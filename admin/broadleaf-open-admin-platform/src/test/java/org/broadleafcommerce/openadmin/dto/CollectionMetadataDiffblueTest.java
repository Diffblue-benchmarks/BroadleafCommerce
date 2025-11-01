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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
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
   * Method under test: {@link CollectionMetadata#getPersistencePerspective()}
   */
  @Test
  public void testGetPersistencePerspective() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getPersistencePerspective());
  }

  /**
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
   * Method under test: {@link CollectionMetadata#getCollectionCeilingEntity()}
   */
  @Test
  public void testGetCollectionCeilingEntity() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getCollectionCeilingEntity());
  }

  /**
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
   * Method under test: {@link CollectionMetadata#isMutable()}
   */
  @Test
  public void testIsMutable() {
    // Arrange, Act and Assert
    assertTrue((new AdornedTargetCollectionMetadata()).isMutable());
  }

  /**
   * Method under test: {@link CollectionMetadata#isMutable()}
   */
  @Test
  public void testIsMutable2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setMutable(false);

    // Act and Assert
    assertFalse(adornedTargetCollectionMetadata.isMutable());
  }

  /**
   * Method under test: {@link CollectionMetadata#getCustomCriteria()}
   */
  @Test
  public void testGetCustomCriteria() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionMetadata()).getCustomCriteria());
  }

  /**
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
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(new String[]{"foo"});

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(new String[]{"foo"});
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate4() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(new HashMap<>());
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate5() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(new ForeignKey[]{new ForeignKey()});
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate6() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(new String[]{"foo"});
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate7() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate8() {
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

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
   * Method under test: {@link CollectionMetadata#populate(FieldMetadata)}
   */
  @Test
  public void testPopulate9() {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem> persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(PersistencePerspectiveItemType.FOREIGNKEY, new ForeignKey());

    PersistencePerspective persistencePerspective = new PersistencePerspective();
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(persistencePerspective);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertSame(metadata, adornedTargetCollectionMetadata.populate(metadata));
  }

  /**
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
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), 1);
    assertNotEquals(new AdornedTargetCollectionMetadata(), mock(AdornedTargetCollectionMetadata.class));
  }

  /**
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
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), null);
  }

  /**
   * Method under test: {@link CollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetCollectionMetadata(), "Different type to CollectionMetadata");
  }
}
