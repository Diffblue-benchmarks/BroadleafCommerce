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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitorAdapter;
import org.junit.Test;
import org.mockito.Mockito;

public class BasicCollectionMetadataDiffblueTest {
  /**
   * Test {@link BasicCollectionMetadata#accept(MetadataVisitor)}.
   * <ul>
   *   <li>When {@link MetadataVisitorAdapter}
   * {@link MetadataVisitorAdapter#visit(BasicCollectionMetadata)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link MetadataVisitorAdapter#visit(BasicCollectionMetadata)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#accept(MetadataVisitor)}
   */
  @Test
  public void testAccept_whenMetadataVisitorAdapterVisitDoesNothing_thenCallsVisit() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    MetadataVisitorAdapter visitor = mock(MetadataVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<BasicCollectionMetadata>any());

    // Act
    basicCollectionMetadata.accept(visitor);

    // Assert
    verify(visitor).visit(isA(BasicCollectionMetadata.class));
  }

  /**
   * Test {@link BasicCollectionMetadata#populate(FieldMetadata)}.
   * <p>
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = basicCollectionMetadata.populate(new BasicCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
  }

  /**
   * Test {@link BasicCollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}
   * PersistencePerspectiveItems is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = basicCollectionMetadata.populate(new BasicCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
  }

  /**
   * Test {@link BasicCollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = basicCollectionMetadata.populate(new BasicCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof BasicCollectionMetadata);
    ForeignKey[] additionalForeignKeys = ((BasicCollectionMetadata) actualPopulateResult).getPersistencePerspective()
        .getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertEquals(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link BasicCollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = basicCollectionMetadata.populate(new BasicCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
  }

  /**
   * Test {@link BasicCollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return PersistencePerspective ExcludeFields is array of
   * {@link String} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = basicCollectionMetadata.populate(new BasicCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getExcludeFields());
  }

  /**
   * Test {@link BasicCollectionMetadata#populate(FieldMetadata)}.
   * <ul>
   *   <li>Then return PersistencePerspective IncludeFields is array of
   * {@link String} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#populate(FieldMetadata)}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualPopulateResult = basicCollectionMetadata.populate(new BasicCollectionMetadata());

    // Assert
    assertTrue(actualPopulateResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualPopulateResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getExcludeFields());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
    assertArrayEquals(new String[]{"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   * <p>
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertEquals(persistencePerspectiveItems,
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult).getPersistencePerspective()
            .getPersistencePerspectiveItems());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code FOREIGNKEY} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertEquals(persistencePerspectiveItems,
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult).getPersistencePerspective()
            .getPersistencePerspectiveItems());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   * <ul>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    ForeignKey[] additionalForeignKeys = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective()
        .getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys.length);
    assertEquals(foreignKey, additionalForeignKeys[0]);
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
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

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 = ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
        .getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalForeignKeys().length);
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertTrue(persistencePerspective2.getPersistencePerspectiveItems().isEmpty());
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}, and
   * {@link BasicCollectionMetadata#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BasicCollectionMetadata#equals(Object)}
   *   <li>{@link BasicCollectionMetadata#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();

    // Act and Assert
    assertEquals(basicCollectionMetadata, basicCollectionMetadata);
    int expectedHashCodeResult = basicCollectionMetadata.hashCode();
    assertEquals(expectedHashCodeResult, basicCollectionMetadata.hashCode());
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setAddMethodType(AddMethodType.PERSIST);

    // Act and Assert
    assertNotEquals(basicCollectionMetadata, new BasicCollectionMetadata());
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCollectionMetadata(), mock(AdornedTargetCollectionMetadata.class));
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(basicCollectionMetadata, new BasicCollectionMetadata());
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCollectionMetadata(), null);
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCollectionMetadata(), "Different type to BasicCollectionMetadata");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BasicCollectionMetadata}
   *   <li>{@link BasicCollectionMetadata#setAddMethodType(AddMethodType)}
   *   <li>{@link BasicCollectionMetadata#setSelectizeVisibleField(String)}
   *   <li>{@link BasicCollectionMetadata#setSortProperty(String)}
   *   <li>{@link BasicCollectionMetadata#getAddMethodType()}
   *   <li>{@link BasicCollectionMetadata#getSelectizeVisibleField()}
   *   <li>{@link BasicCollectionMetadata#getSortProperty()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BasicCollectionMetadata actualBasicCollectionMetadata = new BasicCollectionMetadata();
    actualBasicCollectionMetadata.setAddMethodType(AddMethodType.PERSIST);
    actualBasicCollectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    actualBasicCollectionMetadata.setSortProperty("Sort Property");
    AddMethodType actualAddMethodType = actualBasicCollectionMetadata.getAddMethodType();
    String actualSelectizeVisibleField = actualBasicCollectionMetadata.getSelectizeVisibleField();

    // Assert that nothing has changed
    assertEquals("Selectize Visible Field", actualSelectizeVisibleField);
    assertEquals("Sort Property", actualBasicCollectionMetadata.getSortProperty());
    assertEquals(AddMethodType.PERSIST, actualAddMethodType);
    assertTrue(actualBasicCollectionMetadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualBasicCollectionMetadata.isMutable());
  }
}
