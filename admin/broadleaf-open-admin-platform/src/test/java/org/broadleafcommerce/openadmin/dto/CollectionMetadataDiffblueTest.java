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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdornedTargetCollectionMetadata.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CollectionMetadataDiffblueTest {
  @Autowired
  private CollectionMetadata collectionMetadata;

  /**
   * Test {@link CollectionMetadata#getPersistencePerspective()}.
   * <p>
   * Method under test: {@link CollectionMetadata#getPersistencePerspective()}
   */
  @Test
  public void testGetPersistencePerspective() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getPersistencePerspective());
  }

  /**
   * Test
   * {@link CollectionMetadata#setPersistencePerspective(PersistencePerspective)}.
   * <p>
   * Method under test:
   * {@link CollectionMetadata#setPersistencePerspective(PersistencePerspective)}
   */
  @Test
  public void testSetPersistencePerspective() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Assert
    assertSame(persistencePerspective, adornedTargetCollectionMetadata.getPersistencePerspective());
  }

  /**
   * Test {@link CollectionMetadata#getCollectionCeilingEntity()}.
   * <p>
   * Method under test: {@link CollectionMetadata#getCollectionCeilingEntity()}
   */
  @Test
  public void testGetCollectionCeilingEntity() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getCollectionCeilingEntity());
  }

  /**
   * Test {@link CollectionMetadata#setCollectionCeilingEntity(String)}.
   * <p>
   * Method under test:
   * {@link CollectionMetadata#setCollectionCeilingEntity(String)}
   */
  @Test
  public void testSetCollectionCeilingEntity() {
    // Arrange and Act
    collectionMetadata.setCollectionCeilingEntity("Collection Ceiling Entity");

    // Assert
    assertTrue(collectionMetadata instanceof AdornedTargetCollectionMetadata);
    assertEquals("Collection Ceiling Entity", collectionMetadata.getCollectionCeilingEntity());
  }

  /**
   * Test {@link CollectionMetadata#isMutable()}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor)
   * Mutable is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#isMutable()}
   */
  @Test
  public void testIsMutable_givenAdornedTargetCollectionMetadataMutableIsFalse_thenReturnFalse() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setMutable(false);

    // Act and Assert
    assertFalse(adornedTargetCollectionMetadata.isMutable());
  }

  /**
   * Test {@link CollectionMetadata#isMutable()}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#isMutable()}
   */
  @Test
  public void testIsMutable_givenAdornedTargetCollectionMetadata_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new AdornedTargetCollectionMetadata()).isMutable());
  }

  /**
   * Test {@link CollectionMetadata#getCustomCriteria()}.
   * <p>
   * Method under test: {@link CollectionMetadata#getCustomCriteria()}
   */
  @Test
  public void testGetCustomCriteria() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getCustomCriteria());
  }

  /**
   * Test {@link CollectionMetadata#setCustomCriteria(String[])}.
   * <p>
   * Method under test: {@link CollectionMetadata#setCustomCriteria(String[])}
   */
  @Test
  public void testSetCustomCriteria() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    String[] customCriteria = new String[]{"Custom Criteria"};

    // Act
    adornedTargetCollectionMetadata.setCustomCriteria(customCriteria);

    // Assert
    assertSame(customCriteria, adornedTargetCollectionMetadata.getCustomCriteria());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   * <p>
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata
        .populate(new AdornedTargetCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   * <p>
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate2() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, adornedTargetList);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata
        .populate(new AdornedTargetCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems2 = ((AdornedTargetCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems2.size());
    PersistencePerspectiveItem getResult = persistencePerspectiveItems2.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult instanceof AdornedTargetList);
    assertEquals(adornedTargetList, getResult);
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   * <p>
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate3() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    ForeignKey foreignKey = new ForeignKey();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, foreignKey);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata
        .populate(new AdornedTargetCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems2 = ((AdornedTargetCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems2.size());
    PersistencePerspectiveItem getResult = persistencePerspectiveItems2.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult instanceof ForeignKey);
    assertEquals(foreignKey, getResult);
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code FOREIGNKEY} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate_givenHashMapComputeIfPresentForeignkeyAndBiFunction() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.computeIfPresent(PersistencePerspectiveItemType.FOREIGNKEY, mock(BiFunction.class));
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, adornedTargetList);

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata
        .populate(new AdornedTargetCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    Map<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems2 = ((AdornedTargetCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective()
        .getPersistencePerspectiveItems();
    assertEquals(1, persistencePerspectiveItems2.size());
    PersistencePerspectiveItem getResult = persistencePerspectiveItems2.get(PersistencePerspectiveItemType.FOREIGNKEY);
    assertTrue(getResult instanceof AdornedTargetList);
    assertEquals(adornedTargetList, getResult);
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata
        .populate(new AdornedTargetCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    ForeignKey[] additionalForeignKeys = ((AdornedTargetCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective()
        .getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertEquals(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata
        .populate(new AdornedTargetCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate_thenReturnArrayLengthIsZero2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata
        .populate(new AdornedTargetCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return PersistencePerspective ExcludeFields is array of
   * {@link String} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata
        .populate(new AdornedTargetCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getExcludeFields());
  }

  /**
   * Test {@link CollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return PersistencePerspective IncludeFields is array of
   * {@link String} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = adornedTargetCollectionMetadata
        .populate(new AdornedTargetCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof AdornedTargetCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((AdornedTargetCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}, and
   * {@link CollectionMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
    int expectedHashCodeResult = adornedTargetCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetCollectionMetadata2.hashCode());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}, and
   * {@link CollectionMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
    int expectedHashCodeResult = adornedTargetCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetCollectionMetadata2.hashCode());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}, and
   * {@link CollectionMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCollectionCeilingEntity("Collection Ceiling Entity");

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setCollectionCeilingEntity("Collection Ceiling Entity");

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
    int expectedHashCodeResult = adornedTargetCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetCollectionMetadata2.hashCode());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}, and
   * {@link CollectionMetadata#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata);
    int expectedHashCodeResult = adornedTargetCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetCollectionMetadata.hashCode());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), 1);
    assertNotEquals(new AdornedTargetCollectionMetadata(), mock(AdornedTargetCollectionMetadata.class));
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCollectionCeilingEntity("Collection Ceiling Entity");

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setCustomCriteria(new String[]{"Custom Criteria"});

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, new AdornedTargetCollectionMetadata());
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata2.setCollectionCeilingEntity("Collection Ceiling Entity");

    // Act and Assert
    assertNotEquals(adornedTargetCollectionMetadata, adornedTargetCollectionMetadata2);
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), null);
  }

  /**
   * Test {@link CollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), "Different type to CollectionMetadata");
  }
}
