package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PersistencePerspectiveDiffblueTest {
  /**
   * Test {@link PersistencePerspective#PersistencePerspective()}.
   *
   * <p>Method under test: {@link PersistencePerspective#PersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.<init>()"})
  public void testNewPersistencePerspective() {
    // Arrange and Act
    PersistencePerspective actualPersistencePerspective = new PersistencePerspective();

    // Assert
    assertNull(actualPersistencePerspective.getConfigurationKey());
    assertEquals(0, actualPersistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, actualPersistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(0, actualPersistencePerspective.getExcludeFields().length);
    assertEquals(0, actualPersistencePerspective.getIncludeFields().length);
    OperationTypes operationTypes = actualPersistencePerspective.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(actualPersistencePerspective.getPopulateToOneFields());
    assertFalse(actualPersistencePerspective.getShowArchivedFields());
    assertTrue(actualPersistencePerspective.getPersistencePerspectiveItems().isEmpty());
    assertTrue(actualPersistencePerspective.getUseServerSideInspectionCache());
  }

  /**
   * Test {@link PersistencePerspective#PersistencePerspective(OperationTypes, String[],
   * ForeignKey[])}.
   *
   * <p>Method under test: {@link PersistencePerspective#PersistencePerspective(OperationTypes,
   * String[], ForeignKey[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.<init>(OperationTypes, String[], ForeignKey[])"})
  public void testNewPersistencePerspective2() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};

    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setManyToField("Many To Field");
    ForeignKey[] additionalForeignKeys =
        new ForeignKey[] {foreignKey, new ForeignKey("Many To Field", "Foreign Key Class")};

    // Act
    PersistencePerspective actualPersistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);

    // Assert
    assertSame(additionalForeignKeys, actualPersistencePerspective.getAdditionalForeignKeys());
  }

  /**
   * Test {@link PersistencePerspective#PersistencePerspective(OperationTypes, String[],
   * ForeignKey[])}.
   *
   * <ul>
   *   <li>Then return ConfigurationKey is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#PersistencePerspective(OperationTypes,
   * String[], ForeignKey[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.<init>(OperationTypes, String[], ForeignKey[])"})
  public void testNewPersistencePerspective_thenReturnConfigurationKeyIsNull() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};

    // Act
    PersistencePerspective actualPersistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, new ForeignKey[] {});

    // Assert
    assertNull(actualPersistencePerspective.getConfigurationKey());
    assertEquals(0, actualPersistencePerspective.getAdditionalForeignKeys().length);
    assertEquals(0, actualPersistencePerspective.getExcludeFields().length);
    assertEquals(0, actualPersistencePerspective.getIncludeFields().length);
    assertFalse(actualPersistencePerspective.getPopulateToOneFields());
    assertFalse(actualPersistencePerspective.getShowArchivedFields());
    assertTrue(actualPersistencePerspective.getPersistencePerspectiveItems().isEmpty());
    assertTrue(actualPersistencePerspective.getUseServerSideInspectionCache());
    assertSame(operationTypes, actualPersistencePerspective.getOperationTypes());
  }

  /**
   * Test {@link PersistencePerspective#PersistencePerspective(OperationTypes, String[],
   * ForeignKey[])}.
   *
   * <ul>
   *   <li>Then return first element is {@link ForeignKey#ForeignKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#PersistencePerspective(OperationTypes,
   * String[], ForeignKey[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.<init>(OperationTypes, String[], ForeignKey[])"})
  public void testNewPersistencePerspective_thenReturnFirstElementIsForeignKey() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey foreignKey = new ForeignKey();
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {foreignKey};

    // Act
    PersistencePerspective actualPersistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);

    // Assert
    ForeignKey[] additionalForeignKeys2 = actualPersistencePerspective.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertSame(foreignKey, additionalForeignKeys2[0]);
  }

  /**
   * Test {@link PersistencePerspective#PersistencePerspective(OperationTypes, String[],
   * ForeignKey[])}.
   *
   * <ul>
   *   <li>Then return first element ManyToField is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#PersistencePerspective(OperationTypes,
   * String[], ForeignKey[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.<init>(OperationTypes, String[], ForeignKey[])"})
  public void testNewPersistencePerspective_thenReturnFirstElementManyToFieldIsNull() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    // Act
    PersistencePerspective actualPersistencePerspective =
        new PersistencePerspective(operationTypes, new String[] {}, additionalForeignKeys);

    // Assert
    ForeignKey[] additionalForeignKeys2 = actualPersistencePerspective.getAdditionalForeignKeys();
    assertNull(additionalForeignKeys2[0].getManyToField());
    assertEquals(0, actualPersistencePerspective.getAdditionalNonPersistentProperties().length);
    assertEquals(1, additionalForeignKeys2.length);
    assertSame(additionalForeignKeys, additionalForeignKeys2);
  }

  /**
   * Test {@link PersistencePerspective#setAdditionalNonPersistentProperties(String[])}.
   *
   * <p>Method under test: {@link
   * PersistencePerspective#setAdditionalNonPersistentProperties(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.setAdditionalNonPersistentProperties(String[])"})
  public void testSetAdditionalNonPersistentProperties() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};

    // Act
    persistencePerspective.setAdditionalNonPersistentProperties(additionalNonPersistentProperties);

    // Assert
    assertSame(
        additionalNonPersistentProperties,
        persistencePerspective.getAdditionalNonPersistentProperties());
  }

  /**
   * Test {@link PersistencePerspective#setAdditionalNonPersistentProperties(String[])}.
   *
   * <p>Method under test: {@link
   * PersistencePerspective#setAdditionalNonPersistentProperties(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.setAdditionalNonPersistentProperties(String[])"})
  public void testSetAdditionalNonPersistentProperties2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] additionalNonPersistentProperties = new String[] {};

    // Act
    persistencePerspective.setAdditionalNonPersistentProperties(additionalNonPersistentProperties);

    // Assert
    assertSame(
        additionalNonPersistentProperties,
        persistencePerspective.getAdditionalNonPersistentProperties());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistencePerspective#setConfigurationKey(String)}
   *   <li>{@link PersistencePerspective#setOperationTypes(OperationTypes)}
   *   <li>{@link PersistencePerspective#setPersistencePerspectiveItems(Map)}
   *   <li>{@link PersistencePerspective#setPopulateToOneFields(Boolean)}
   *   <li>{@link PersistencePerspective#setShowArchivedFields(Boolean)}
   *   <li>{@link PersistencePerspective#setUseServerSideInspectionCache(Boolean)}
   *   <li>{@link PersistencePerspective#toString()}
   *   <li>{@link PersistencePerspective#getAdditionalForeignKeys()}
   *   <li>{@link PersistencePerspective#getAdditionalNonPersistentProperties()}
   *   <li>{@link PersistencePerspective#getConfigurationKey()}
   *   <li>{@link PersistencePerspective#getExcludeFields()}
   *   <li>{@link PersistencePerspective#getIncludeFields()}
   *   <li>{@link PersistencePerspective#getOperationTypes()}
   *   <li>{@link PersistencePerspective#getPersistencePerspectiveItems()}
   *   <li>{@link PersistencePerspective#getPopulateToOneFields()}
   *   <li>{@link PersistencePerspective#getShowArchivedFields()}
   *   <li>{@link PersistencePerspective#getUseServerSideInspectionCache()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ForeignKey[] PersistencePerspective.getAdditionalForeignKeys()",
    "String[] PersistencePerspective.getAdditionalNonPersistentProperties()",
    "String PersistencePerspective.getConfigurationKey()",
    "String[] PersistencePerspective.getExcludeFields()",
    "String[] PersistencePerspective.getIncludeFields()",
    "OperationTypes PersistencePerspective.getOperationTypes()",
    "Map PersistencePerspective.getPersistencePerspectiveItems()",
    "Boolean PersistencePerspective.getPopulateToOneFields()",
    "Boolean PersistencePerspective.getShowArchivedFields()",
    "Boolean PersistencePerspective.getUseServerSideInspectionCache()",
    "void PersistencePerspective.setConfigurationKey(String)",
    "void PersistencePerspective.setOperationTypes(OperationTypes)",
    "void PersistencePerspective.setPersistencePerspectiveItems(Map)",
    "void PersistencePerspective.setPopulateToOneFields(Boolean)",
    "void PersistencePerspective.setShowArchivedFields(Boolean)",
    "void PersistencePerspective.setUseServerSideInspectionCache(Boolean)",
    "String PersistencePerspective.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    persistencePerspective.setConfigurationKey("Configuration Key");
    OperationTypes operationTypes = new OperationTypes();
    persistencePerspective.setOperationTypes(operationTypes);
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setPopulateToOneFields(true);
    persistencePerspective.setShowArchivedFields(true);
    persistencePerspective.setUseServerSideInspectionCache(true);
    String actualToStringResult = persistencePerspective.toString();
    ForeignKey[] actualAdditionalForeignKeys = persistencePerspective.getAdditionalForeignKeys();
    String[] actualAdditionalNonPersistentProperties =
        persistencePerspective.getAdditionalNonPersistentProperties();
    String actualConfigurationKey = persistencePerspective.getConfigurationKey();
    String[] actualExcludeFields = persistencePerspective.getExcludeFields();
    String[] actualIncludeFields = persistencePerspective.getIncludeFields();
    OperationTypes actualOperationTypes = persistencePerspective.getOperationTypes();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        actualPersistencePerspectiveItems = persistencePerspective.getPersistencePerspectiveItems();
    Boolean actualPopulateToOneFields = persistencePerspective.getPopulateToOneFields();
    Boolean actualShowArchivedFields = persistencePerspective.getShowArchivedFields();
    Boolean actualUseServerSideInspectionCache =
        persistencePerspective.getUseServerSideInspectionCache();

    // Assert
    assertEquals("Configuration Key", actualConfigurationKey);
    assertEquals(
        "PersistencePerspective{persistencePerspectiveItems={}, configurationKey='Configuration Key'}",
        actualToStringResult);
    assertEquals(0, actualAdditionalForeignKeys.length);
    assertEquals(0, actualAdditionalNonPersistentProperties.length);
    assertEquals(0, actualExcludeFields.length);
    assertEquals(0, actualIncludeFields.length);
    assertTrue(actualPersistencePerspectiveItems.isEmpty());
    assertTrue(actualPopulateToOneFields);
    assertTrue(actualShowArchivedFields);
    assertTrue(actualUseServerSideInspectionCache);
    assertSame(persistencePerspectiveItems, actualPersistencePerspectiveItems);
    assertSame(operationTypes, actualOperationTypes);
  }

  /**
   * Test {@link PersistencePerspective#setAdditionalForeignKeys(ForeignKey[])}.
   *
   * <p>Method under test: {@link PersistencePerspective#setAdditionalForeignKeys(ForeignKey[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.setAdditionalForeignKeys(ForeignKey[])"})
  public void testSetAdditionalForeignKeys() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    // Act
    persistencePerspective.setAdditionalForeignKeys(additionalForeignKeys);

    // Assert
    assertSame(additionalForeignKeys, persistencePerspective.getAdditionalForeignKeys());
  }

  /**
   * Test {@link PersistencePerspective#setAdditionalForeignKeys(ForeignKey[])}.
   *
   * <p>Method under test: {@link PersistencePerspective#setAdditionalForeignKeys(ForeignKey[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.setAdditionalForeignKeys(ForeignKey[])"})
  public void testSetAdditionalForeignKeys2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {};

    // Act
    persistencePerspective.setAdditionalForeignKeys(additionalForeignKeys);

    // Assert
    assertSame(additionalForeignKeys, persistencePerspective.getAdditionalForeignKeys());
  }

  /**
   * Test {@link PersistencePerspective#setAdditionalForeignKeys(ForeignKey[])}.
   *
   * <p>Method under test: {@link PersistencePerspective#setAdditionalForeignKeys(ForeignKey[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.setAdditionalForeignKeys(ForeignKey[])"})
  public void testSetAdditionalForeignKeys3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setManyToField("Many To Field");
    ForeignKey[] additionalForeignKeys =
        new ForeignKey[] {foreignKey, new ForeignKey("Many To Field", "Foreign Key Class")};

    // Act
    persistencePerspective.setAdditionalForeignKeys(additionalForeignKeys);

    // Assert
    assertSame(additionalForeignKeys, persistencePerspective.getAdditionalForeignKeys());
  }

  /**
   * Test {@link
   * PersistencePerspective#addPersistencePerspectiveItem(PersistencePerspectiveItemType,
   * PersistencePerspectiveItem)}.
   *
   * <p>Method under test: {@link
   * PersistencePerspective#addPersistencePerspectiveItem(PersistencePerspectiveItemType,
   * PersistencePerspectiveItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PersistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType, PersistencePerspectiveItem)"
  })
  public void testAddPersistencePerspectiveItem() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    AdornedTargetList item = new AdornedTargetList();

    // Act
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, item);

    // Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems =
        persistencePerspective.getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    assertSame(item, persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY));
  }

  /**
   * Test {@link PersistencePerspective#setExcludeFields(String[])}.
   *
   * <p>Method under test: {@link PersistencePerspective#setExcludeFields(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.setExcludeFields(String[])"})
  public void testSetExcludeFields() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] excludeManyToOneFields = new String[] {"Exclude Many To One Fields"};

    // Act
    persistencePerspective.setExcludeFields(excludeManyToOneFields);

    // Assert
    assertSame(excludeManyToOneFields, persistencePerspective.getExcludeFields());
  }

  /**
   * Test {@link PersistencePerspective#setExcludeFields(String[])}.
   *
   * <ul>
   *   <li>Then {@link PersistencePerspective#PersistencePerspective()} ExcludeFields is empty array
   *       of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#setExcludeFields(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.setExcludeFields(String[])"})
  public void testSetExcludeFields_thenPersistencePerspectiveExcludeFieldsIsEmptyArrayOfString() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] excludeManyToOneFields = new String[] {};

    // Act
    persistencePerspective.setExcludeFields(excludeManyToOneFields);

    // Assert
    assertSame(excludeManyToOneFields, persistencePerspective.getExcludeFields());
  }

  /**
   * Test {@link PersistencePerspective#setIncludeFields(String[])}.
   *
   * <p>Method under test: {@link PersistencePerspective#setIncludeFields(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.setIncludeFields(String[])"})
  public void testSetIncludeFields() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] includeManyToOneFields = new String[] {"Include Many To One Fields"};

    // Act
    persistencePerspective.setIncludeFields(includeManyToOneFields);

    // Assert
    assertSame(includeManyToOneFields, persistencePerspective.getIncludeFields());
  }

  /**
   * Test {@link PersistencePerspective#setIncludeFields(String[])}.
   *
   * <ul>
   *   <li>Then {@link PersistencePerspective#PersistencePerspective()} IncludeFields is empty array
   *       of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#setIncludeFields(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistencePerspective.setIncludeFields(String[])"})
  public void testSetIncludeFields_thenPersistencePerspectiveIncludeFieldsIsEmptyArrayOfString() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] includeManyToOneFields = new String[] {};

    // Act
    persistencePerspective.setIncludeFields(includeManyToOneFields);

    // Assert
    assertSame(includeManyToOneFields, persistencePerspective.getIncludeFields());
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   *
   * <p>Method under test: {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistencePerspective PersistencePerspective.clonePersistencePerspective()"})
  public void testClonePersistencePerspective() {
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

    // Act
    PersistencePerspective actualClonePersistencePerspectiveResult =
        persistencePerspective.clonePersistencePerspective();

    // Assert
    assertEquals(persistencePerspective, actualClonePersistencePerspectiveResult);
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   *
   * <p>Method under test: {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistencePerspective PersistencePerspective.clonePersistencePerspective()"})
  public void testClonePersistencePerspective2() {
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

    // Act
    PersistencePerspective actualClonePersistencePerspectiveResult =
        persistencePerspective.clonePersistencePerspective();

    // Assert
    assertEquals(0, actualClonePersistencePerspectiveResult.getIncludeFields().length);
    ForeignKey[] additionalForeignKeys2 =
        actualClonePersistencePerspectiveResult.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(
        new String[] {"foo"},
        actualClonePersistencePerspectiveResult.getAdditionalNonPersistentProperties());
    assertArrayEquals(
        new String[] {"foo"}, actualClonePersistencePerspectiveResult.getExcludeFields());
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   *
   * <p>Method under test: {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistencePerspective PersistencePerspective.clonePersistencePerspective()"})
  public void testClonePersistencePerspective3() {
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

    // Act
    PersistencePerspective actualClonePersistencePerspectiveResult =
        persistencePerspective.clonePersistencePerspective();

    // Assert
    assertEquals(0, actualClonePersistencePerspectiveResult.getExcludeFields().length);
    ForeignKey[] additionalForeignKeys2 =
        actualClonePersistencePerspectiveResult.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(
        new String[] {"foo"},
        actualClonePersistencePerspectiveResult.getAdditionalNonPersistentProperties());
    assertArrayEquals(
        new String[] {"foo"}, actualClonePersistencePerspectiveResult.getIncludeFields());
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   *
   * <p>Method under test: {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistencePerspective PersistencePerspective.clonePersistencePerspective()"})
  public void testClonePersistencePerspective4() {
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

    // Act
    PersistencePerspective actualClonePersistencePerspectiveResult =
        persistencePerspective.clonePersistencePerspective();

    // Assert
    ForeignKey[] additionalForeignKeys2 =
        actualClonePersistencePerspectiveResult.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(
        new String[] {"foo"},
        actualClonePersistencePerspectiveResult.getAdditionalNonPersistentProperties());
    assertArrayEquals(
        new String[] {"foo"}, actualClonePersistencePerspectiveResult.getExcludeFields());
    assertArrayEquals(
        new String[] {"foo"}, actualClonePersistencePerspectiveResult.getIncludeFields());
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   *
   * <p>Method under test: {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistencePerspective PersistencePerspective.clonePersistencePerspective()"})
  public void testClonePersistencePerspective5() {
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

    // Act
    PersistencePerspective actualClonePersistencePerspectiveResult =
        persistencePerspective.clonePersistencePerspective();

    // Assert
    assertEquals(0, actualClonePersistencePerspectiveResult.getAdditionalForeignKeys().length);
    assertArrayEquals(
        new String[] {"foo"},
        actualClonePersistencePerspectiveResult.getAdditionalNonPersistentProperties());
    assertArrayEquals(
        new String[] {"foo"}, actualClonePersistencePerspectiveResult.getExcludeFields());
    assertArrayEquals(
        new String[] {"foo"}, actualClonePersistencePerspectiveResult.getIncludeFields());
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   *
   * <p>Method under test: {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistencePerspective PersistencePerspective.clonePersistencePerspective()"})
  public void testClonePersistencePerspective6() {
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

    // Act
    PersistencePerspective actualClonePersistencePerspectiveResult =
        persistencePerspective.clonePersistencePerspective();

    // Assert
    assertEquals(
        0, actualClonePersistencePerspectiveResult.getAdditionalNonPersistentProperties().length);
    ForeignKey[] additionalForeignKeys2 =
        actualClonePersistencePerspectiveResult.getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
    assertArrayEquals(
        new String[] {"foo"}, actualClonePersistencePerspectiveResult.getExcludeFields());
    assertArrayEquals(
        new String[] {"foo"}, actualClonePersistencePerspectiveResult.getIncludeFields());
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   *
   * <p>Method under test: {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistencePerspective PersistencePerspective.clonePersistencePerspective()"})
  public void testClonePersistencePerspective7() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    AdornedTargetList item = new AdornedTargetList();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, item);

    // Act and Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems =
        persistencePerspective.clonePersistencePerspective().getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult =
        persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult instanceof AdornedTargetList);
    assertEquals(item, getResult);
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   *
   * <p>Method under test: {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistencePerspective PersistencePerspective.clonePersistencePerspective()"})
  public void testClonePersistencePerspective8() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    ForeignKey item = new ForeignKey();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, item);

    // Act and Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems =
        persistencePerspective.clonePersistencePerspective().getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    PersistencePerspectiveItem getResult =
        persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult instanceof ForeignKey);
    assertEquals(item, getResult);
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   *
   * <ul>
   *   <li>Then return {@link PersistencePerspective#PersistencePerspective()}.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistencePerspective PersistencePerspective.clonePersistencePerspective()"})
  public void testClonePersistencePerspective_thenReturnPersistencePerspective() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    PersistencePerspective actualClonePersistencePerspectiveResult =
        persistencePerspective.clonePersistencePerspective();

    // Assert
    assertEquals(persistencePerspective, actualClonePersistencePerspectiveResult);
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}, and {@link
   * PersistencePerspective#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistencePerspective#equals(Object)}
   *   <li>{@link PersistencePerspective#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    PersistencePerspective persistencePerspective2 = new PersistencePerspective();

    // Act and Assert
    assertEquals(persistencePerspective, persistencePerspective2);
    assertEquals(persistencePerspective.hashCode(), persistencePerspective2.hashCode());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}, and {@link
   * PersistencePerspective#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistencePerspective#equals(Object)}
   *   <li>{@link PersistencePerspective#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act and Assert
    assertEquals(persistencePerspective, persistencePerspective);
    int expectedHashCodeResult = persistencePerspective.hashCode();
    assertEquals(expectedHashCodeResult, persistencePerspective.hashCode());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(
        new String[] {"Additional Non Persistent Properties"});
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setExcludeFields(new String[] {"Exclude Many To One Fields"});
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setIncludeFields(new String[] {"Include Many To One Fields"});
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setConfigurationKey("Configuration Key");
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setPopulateToOneFields(true);

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setShowArchivedFields(true);

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setConfigurationKey("Configuration Key");
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective2 = new PersistencePerspective();
    persistencePerspective2.setConfigurationKey("Configuration Key");

    // Act and Assert
    assertNotEquals(persistencePerspective, persistencePerspective2);
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    PersistencePerspective persistencePerspective2 = new PersistencePerspective();
    persistencePerspective2.setConfigurationKey("Configuration Key");

    // Act and Assert
    assertNotEquals(persistencePerspective, persistencePerspective2);
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setPopulateToOneFields(null);

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setShowArchivedFields(null);

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PersistencePerspective(), null);
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistencePerspective.equals(Object)",
    "int PersistencePerspective.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PersistencePerspective(), "Different type to PersistencePerspective");
  }
}
