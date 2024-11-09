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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.junit.Test;

public class PersistencePerspectiveDiffblueTest {
  /**
   * Test {@link PersistencePerspective#PersistencePerspective()}.
   * <p>
   * Method under test: {@link PersistencePerspective#PersistencePerspective()}
   */
  @Test
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
   * Test
   * {@link PersistencePerspective#PersistencePerspective(OperationTypes, String[], ForeignKey[])}.
   * <p>
   * Method under test:
   * {@link PersistencePerspective#PersistencePerspective(OperationTypes, String[], ForeignKey[])}
   */
  @Test
  public void testNewPersistencePerspective2() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties = new String[]{"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[]{new ForeignKey()};

    // Act
    PersistencePerspective actualPersistencePerspective = new PersistencePerspective(operationTypes,
        additionalNonPersistentProperties, additionalForeignKeys);

    // Assert
    assertSame(additionalNonPersistentProperties, actualPersistencePerspective.getAdditionalNonPersistentProperties());
    assertSame(additionalForeignKeys, actualPersistencePerspective.getAdditionalForeignKeys());
  }

  /**
   * Test
   * {@link PersistencePerspective#PersistencePerspective(OperationTypes, String[], ForeignKey[])}.
   * <ul>
   *   <li>Then return ConfigurationKey is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePerspective#PersistencePerspective(OperationTypes, String[], ForeignKey[])}
   */
  @Test
  public void testNewPersistencePerspective_thenReturnConfigurationKeyIsNull() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties = new String[]{"Additional Non Persistent Properties"};

    // Act
    PersistencePerspective actualPersistencePerspective = new PersistencePerspective(operationTypes,
        additionalNonPersistentProperties, new ForeignKey[]{});

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
    assertSame(additionalNonPersistentProperties, actualPersistencePerspective.getAdditionalNonPersistentProperties());
  }

  /**
   * Test
   * {@link PersistencePerspective#PersistencePerspective(OperationTypes, String[], ForeignKey[])}.
   * <ul>
   *   <li>When empty array of {@link String}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePerspective#PersistencePerspective(OperationTypes, String[], ForeignKey[])}
   */
  @Test
  public void testNewPersistencePerspective_whenEmptyArrayOfString_thenReturnArrayLengthIsZero() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    ForeignKey[] additionalForeignKeys = new ForeignKey[]{new ForeignKey()};

    // Act
    PersistencePerspective actualPersistencePerspective = new PersistencePerspective(operationTypes, new String[]{},
        additionalForeignKeys);

    // Assert
    assertEquals(0, actualPersistencePerspective.getAdditionalNonPersistentProperties().length);
    assertSame(additionalForeignKeys, actualPersistencePerspective.getAdditionalForeignKeys());
  }

  /**
   * Test
   * {@link PersistencePerspective#setAdditionalNonPersistentProperties(String[])}.
   * <p>
   * Method under test:
   * {@link PersistencePerspective#setAdditionalNonPersistentProperties(String[])}
   */
  @Test
  public void testSetAdditionalNonPersistentProperties() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] additionalNonPersistentProperties = new String[]{"Additional Non Persistent Properties"};

    // Act
    persistencePerspective.setAdditionalNonPersistentProperties(additionalNonPersistentProperties);

    // Assert
    assertSame(additionalNonPersistentProperties, persistencePerspective.getAdditionalNonPersistentProperties());
  }

  /**
   * Test
   * {@link PersistencePerspective#setAdditionalNonPersistentProperties(String[])}.
   * <p>
   * Method under test:
   * {@link PersistencePerspective#setAdditionalNonPersistentProperties(String[])}
   */
  @Test
  public void testSetAdditionalNonPersistentProperties2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] additionalNonPersistentProperties = new String[]{};

    // Act
    persistencePerspective.setAdditionalNonPersistentProperties(additionalNonPersistentProperties);

    // Assert
    assertSame(additionalNonPersistentProperties, persistencePerspective.getAdditionalNonPersistentProperties());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    persistencePerspective.setConfigurationKey("Configuration Key");
    OperationTypes operationTypes = new OperationTypes();
    persistencePerspective.setOperationTypes(operationTypes);
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setPopulateToOneFields(true);
    persistencePerspective.setShowArchivedFields(true);
    persistencePerspective.setUseServerSideInspectionCache(true);
    String actualToStringResult = persistencePerspective.toString();
    ForeignKey[] actualAdditionalForeignKeys = persistencePerspective.getAdditionalForeignKeys();
    String[] actualAdditionalNonPersistentProperties = persistencePerspective.getAdditionalNonPersistentProperties();
    String actualConfigurationKey = persistencePerspective.getConfigurationKey();
    String[] actualExcludeFields = persistencePerspective.getExcludeFields();
    String[] actualIncludeFields = persistencePerspective.getIncludeFields();
    OperationTypes actualOperationTypes = persistencePerspective.getOperationTypes();
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> actualPersistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    Boolean actualPopulateToOneFields = persistencePerspective.getPopulateToOneFields();
    Boolean actualShowArchivedFields = persistencePerspective.getShowArchivedFields();
    Boolean actualUseServerSideInspectionCache = persistencePerspective.getUseServerSideInspectionCache();

    // Assert that nothing has changed
    assertEquals("Configuration Key", actualConfigurationKey);
    assertEquals("PersistencePerspective{persistencePerspectiveItems={}, configurationKey='Configuration Key'}",
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
   * <p>
   * Method under test:
   * {@link PersistencePerspective#setAdditionalForeignKeys(ForeignKey[])}
   */
  @Test
  public void testSetAdditionalForeignKeys() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    ForeignKey[] additionalForeignKeys = new ForeignKey[]{new ForeignKey()};

    // Act
    persistencePerspective.setAdditionalForeignKeys(additionalForeignKeys);

    // Assert
    assertSame(additionalForeignKeys, persistencePerspective.getAdditionalForeignKeys());
  }

  /**
   * Test {@link PersistencePerspective#setAdditionalForeignKeys(ForeignKey[])}.
   * <p>
   * Method under test:
   * {@link PersistencePerspective#setAdditionalForeignKeys(ForeignKey[])}
   */
  @Test
  public void testSetAdditionalForeignKeys2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    ForeignKey[] additionalForeignKeys = new ForeignKey[]{};

    // Act
    persistencePerspective.setAdditionalForeignKeys(additionalForeignKeys);

    // Assert
    assertSame(additionalForeignKeys, persistencePerspective.getAdditionalForeignKeys());
  }

  /**
   * Test
   * {@link PersistencePerspective#addPersistencePerspectiveItem(PersistencePerspectiveItemType, PersistencePerspectiveItem)}.
   * <p>
   * Method under test:
   * {@link PersistencePerspective#addPersistencePerspectiveItem(PersistencePerspectiveItemType, PersistencePerspectiveItem)}
   */
  @Test
  public void testAddPersistencePerspectiveItem() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    AdornedTargetList item = new AdornedTargetList();

    // Act
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY, item);

    // Assert
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = persistencePerspective
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems.size());
    assertSame(item, persistencePerspectiveItems.get(PersistencePerspectiveItemType.FOREIGNKEY));
  }

  /**
   * Test {@link PersistencePerspective#setExcludeFields(String[])}.
   * <p>
   * Method under test: {@link PersistencePerspective#setExcludeFields(String[])}
   */
  @Test
  public void testSetExcludeFields() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] excludeManyToOneFields = new String[]{"Exclude Many To One Fields"};

    // Act
    persistencePerspective.setExcludeFields(excludeManyToOneFields);

    // Assert
    assertSame(excludeManyToOneFields, persistencePerspective.getExcludeFields());
  }

  /**
   * Test {@link PersistencePerspective#setExcludeFields(String[])}.
   * <ul>
   *   <li>Then {@link PersistencePerspective#PersistencePerspective()}
   * ExcludeFields is empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#setExcludeFields(String[])}
   */
  @Test
  public void testSetExcludeFields_thenPersistencePerspectiveExcludeFieldsIsEmptyArrayOfString() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] excludeManyToOneFields = new String[]{};

    // Act
    persistencePerspective.setExcludeFields(excludeManyToOneFields);

    // Assert
    assertSame(excludeManyToOneFields, persistencePerspective.getExcludeFields());
  }

  /**
   * Test {@link PersistencePerspective#setIncludeFields(String[])}.
   * <p>
   * Method under test: {@link PersistencePerspective#setIncludeFields(String[])}
   */
  @Test
  public void testSetIncludeFields() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] includeManyToOneFields = new String[]{"Include Many To One Fields"};

    // Act
    persistencePerspective.setIncludeFields(includeManyToOneFields);

    // Assert
    assertSame(includeManyToOneFields, persistencePerspective.getIncludeFields());
  }

  /**
   * Test {@link PersistencePerspective#setIncludeFields(String[])}.
   * <ul>
   *   <li>Then {@link PersistencePerspective#PersistencePerspective()}
   * IncludeFields is empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#setIncludeFields(String[])}
   */
  @Test
  public void testSetIncludeFields_thenPersistencePerspectiveIncludeFieldsIsEmptyArrayOfString() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    String[] includeManyToOneFields = new String[]{};

    // Act
    persistencePerspective.setIncludeFields(includeManyToOneFields);

    // Assert
    assertSame(includeManyToOneFields, persistencePerspective.getIncludeFields());
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   * <p>
   * Method under test:
   * {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  public void testClonePersistencePerspective() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    // Act and Assert
    assertEquals(persistencePerspective, persistencePerspective.clonePersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   * <p>
   * Method under test:
   * {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  public void testClonePersistencePerspective2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY, new ForeignKey());

    // Act and Assert
    assertEquals(persistencePerspective, persistencePerspective.clonePersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  public void testClonePersistencePerspective_givenPersistencePerspective() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act and Assert
    assertEquals(persistencePerspective, persistencePerspective.clonePersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  public void testClonePersistencePerspective_thenReturnArrayLengthIsOne() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    ForeignKey foreignKey = new ForeignKey();
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[]{foreignKey});
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    // Act and Assert
    ForeignKey[] additionalForeignKeys = persistencePerspective.clonePersistencePerspective()
        .getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertEquals(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link PersistencePerspective#clonePersistencePerspective()}.
   * <ul>
   *   <li>Then return ConfigurationKey is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PersistencePerspective#clonePersistencePerspective()}
   */
  @Test
  public void testClonePersistencePerspective_thenReturnConfigurationKeyIsNull() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    // Act
    PersistencePerspective actualClonePersistencePerspectiveResult = persistencePerspective
        .clonePersistencePerspective();

    // Assert
    assertNull(actualClonePersistencePerspectiveResult.getConfigurationKey());
    assertEquals(0, actualClonePersistencePerspectiveResult.getAdditionalForeignKeys().length);
    assertEquals(0, actualClonePersistencePerspectiveResult.getAdditionalNonPersistentProperties().length);
    assertEquals(0, actualClonePersistencePerspectiveResult.getExcludeFields().length);
    assertEquals(0, actualClonePersistencePerspectiveResult.getIncludeFields().length);
    OperationTypes operationTypes = actualClonePersistencePerspectiveResult.getOperationTypes();
    assertEquals(OperationType.BASIC, operationTypes.getAddType());
    assertEquals(OperationType.BASIC, operationTypes.getFetchType());
    assertEquals(OperationType.BASIC, operationTypes.getInspectType());
    assertEquals(OperationType.BASIC, operationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, operationTypes.getUpdateType());
    assertFalse(actualClonePersistencePerspectiveResult.getPopulateToOneFields());
    assertFalse(actualClonePersistencePerspectiveResult.getShowArchivedFields());
    assertTrue(actualClonePersistencePerspectiveResult.getPersistencePerspectiveItems().isEmpty());
    assertTrue(actualClonePersistencePerspectiveResult.getUseServerSideInspectionCache());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}, and
   * {@link PersistencePerspective#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistencePerspective#equals(Object)}
   *   <li>{@link PersistencePerspective#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    PersistencePerspective persistencePerspective2 = new PersistencePerspective();

    // Act and Assert
    assertEquals(persistencePerspective, persistencePerspective2);
    int expectedHashCodeResult = persistencePerspective.hashCode();
    assertEquals(expectedHashCodeResult, persistencePerspective2.hashCode());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}, and
   * {@link PersistencePerspective#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PersistencePerspective#equals(Object)}
   *   <li>{@link PersistencePerspective#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    PersistencePerspective persistencePerspective = new PersistencePerspective(operationTypes,
        new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()});

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(new String[]{"Additional Non Persistent Properties"});
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setExcludeFields(new String[]{"Exclude Many To One Fields"});
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setIncludeFields(new String[]{"Include Many To One Fields"});
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setConfigurationKey("Configuration Key");
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange, Act and Assert
    assertNotEquals(new PersistencePerspective(), mock(OperationTypes.class));
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setPopulateToOneFields(true);

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setShowArchivedFields(true);

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setConfigurationKey("Configuration Key");
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());

    PersistencePerspective persistencePerspective2 = new PersistencePerspective();
    persistencePerspective2.setConfigurationKey("Configuration Key");

    // Act and Assert
    assertNotEquals(persistencePerspective, persistencePerspective2);
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    PersistencePerspective persistencePerspective2 = new PersistencePerspective();
    persistencePerspective2.setConfigurationKey("Configuration Key");

    // Act and Assert
    assertNotEquals(persistencePerspective, persistencePerspective2);
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setPopulateToOneFields(null);

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setShowArchivedFields(null);

    // Act and Assert
    assertNotEquals(persistencePerspective, new PersistencePerspective());
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PersistencePerspective(), null);
  }

  /**
   * Test {@link PersistencePerspective#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersistencePerspective#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PersistencePerspective(), "Different type to PersistencePerspective");
  }
}
