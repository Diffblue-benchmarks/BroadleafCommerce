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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitorAdapter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class BasicCollectionMetadataDiffblueTest {
  /**
   * Test {@link BasicCollectionMetadata#accept(MetadataVisitor)}.
   *
   * <ul>
   *   <li>When {@link MetadataVisitorAdapter} {@link
   *       MetadataVisitorAdapter#visit(BasicCollectionMetadata)} does nothing.
   *   <li>Then calls {@link MetadataVisitorAdapter#visit(BasicCollectionMetadata)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicCollectionMetadata#accept(MetadataVisitor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicCollectionMetadata.accept(MetadataVisitor)"})
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
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata BasicCollectionMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(new String[] {"foo"});

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    PersistencePerspective persistencePerspective2 =
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getIncludeFields());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata BasicCollectionMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata2() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(new String[] {"foo"});
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    PersistencePerspective persistencePerspective2 =
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertArrayEquals(new String[] {"foo"}, persistencePerspective2.getExcludeFields());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata BasicCollectionMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata3() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
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
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    PersistencePerspective persistencePerspective2 =
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata BasicCollectionMetadata.cloneFieldMetadata()"})
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
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    PersistencePerspective persistencePerspective2 =
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertArrayEquals(
        new String[] {"foo"}, persistencePerspective2.getAdditionalNonPersistentProperties());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata BasicCollectionMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata5() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setAdditionalNonPersistentProperties(null);
    persistencePerspective.setAdditionalForeignKeys(null);
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setAvailableToTypes(new String[] {"Available To Types"});
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    PersistencePerspective persistencePerspective2 =
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
    assertArrayEquals(
        new String[] {"Available To Types"}, actualCloneFieldMetadataResult.getAvailableToTypes());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   *
   * <p>Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata BasicCollectionMetadata.cloneFieldMetadata()"})
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
    assertEquals(
        persistencePerspectiveItems,
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
            .getPersistencePerspective()
            .getPersistencePerspectiveItems());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   *
   * <ul>
   *   <li>Then return AdditionalMetadata size is one.
   * </ul>
   *
   * <p>Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata BasicCollectionMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata_thenReturnAdditionalMetadataSizeIsOne() {
    // Arrange
    HashMap<String, Object> additionalMetadata = new HashMap<>();
    additionalMetadata.put("foo", "42");

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);
    basicCollectionMetadata.setAdditionalMetadata(additionalMetadata);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    Map<String, Object> additionalMetadata2 =
        actualCloneFieldMetadataResult.getAdditionalMetadata();
    assertEquals(1, additionalMetadata2.size());
    assertEquals("42", additionalMetadata2.get("foo"));
    assertEquals(
        persistencePerspective,
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult).getPersistencePerspective());
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   *
   * <ul>
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata BasicCollectionMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata_thenReturnArrayLengthIsOne() {
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
    persistencePerspective.setPersistencePerspectiveItems(null);
    persistencePerspective.setExcludeFields(null);
    persistencePerspective.setIncludeFields(null);

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(persistencePerspective);

    // Act
    FieldMetadata actualCloneFieldMetadataResult = basicCollectionMetadata.cloneFieldMetadata();

    // Assert
    assertTrue(actualCloneFieldMetadataResult instanceof BasicCollectionMetadata);
    ForeignKey[] additionalForeignKeys2 =
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult)
            .getPersistencePerspective()
            .getAdditionalForeignKeys();
    assertEquals(1, additionalForeignKeys2.length);
    assertEquals(foreignKey, additionalForeignKeys2[0]);
  }

  /**
   * Test {@link BasicCollectionMetadata#cloneFieldMetadata()}.
   *
   * <ul>
   *   <li>Then return AvailableToTypes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicCollectionMetadata#cloneFieldMetadata()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldMetadata BasicCollectionMetadata.cloneFieldMetadata()"})
  public void testCloneFieldMetadata_thenReturnAvailableToTypesIsNull() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
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
    assertNull(actualCloneFieldMetadataResult.getAvailableToTypes());
    PersistencePerspective persistencePerspective2 =
        ((BasicCollectionMetadata) actualCloneFieldMetadataResult).getPersistencePerspective();
    assertEquals(0, persistencePerspective2.getAdditionalNonPersistentProperties().length);
    assertEquals(0, persistencePerspective2.getExcludeFields().length);
    assertEquals(0, persistencePerspective2.getIncludeFields().length);
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}, and {@link
   * BasicCollectionMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicCollectionMetadata#equals(Object)}
   *   <li>{@link BasicCollectionMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicCollectionMetadata.equals(Object)",
    "int BasicCollectionMetadata.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    basicCollectionMetadata.setAddMethodType(AddMethodType.PERSIST);

    BasicCollectionMetadata basicCollectionMetadata2 = new BasicCollectionMetadata();
    basicCollectionMetadata2.setSelectizeVisibleField("Selectize Visible Field");
    basicCollectionMetadata2.setAddMethodType(AddMethodType.PERSIST);

    // Act and Assert
    assertEquals(basicCollectionMetadata, basicCollectionMetadata2);
    assertEquals(basicCollectionMetadata.hashCode(), basicCollectionMetadata2.hashCode());
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}, and {@link
   * BasicCollectionMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicCollectionMetadata#equals(Object)}
   *   <li>{@link BasicCollectionMetadata#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicCollectionMetadata.equals(Object)",
    "int BasicCollectionMetadata.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicCollectionMetadata.equals(Object)",
    "int BasicCollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setAddMethodType(AddMethodType.PERSIST);

    // Act and Assert
    assertNotEquals(basicCollectionMetadata, new BasicCollectionMetadata());
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicCollectionMetadata.equals(Object)",
    "int BasicCollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    // Act and Assert
    assertNotEquals(basicCollectionMetadata, new BasicCollectionMetadata());
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicCollectionMetadata.equals(Object)",
    "int BasicCollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    basicCollectionMetadata.setAddMethodType(AddMethodType.PERSIST);

    BasicCollectionMetadata basicCollectionMetadata2 = new BasicCollectionMetadata();
    basicCollectionMetadata2.setAddMethodType(AddMethodType.PERSIST);

    // Act and Assert
    assertNotEquals(basicCollectionMetadata, basicCollectionMetadata2);
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicCollectionMetadata.equals(Object)",
    "int BasicCollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCollectionMetadata(), null);
  }

  /**
   * Test {@link BasicCollectionMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BasicCollectionMetadata#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicCollectionMetadata.equals(Object)",
    "int BasicCollectionMetadata.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BasicCollectionMetadata(), "Different type to BasicCollectionMetadata");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicCollectionMetadata.<init>()",
    "AddMethodType BasicCollectionMetadata.getAddMethodType()",
    "String BasicCollectionMetadata.getSelectizeVisibleField()",
    "String BasicCollectionMetadata.getSortProperty()",
    "void BasicCollectionMetadata.setAddMethodType(AddMethodType)",
    "void BasicCollectionMetadata.setSelectizeVisibleField(String)",
    "void BasicCollectionMetadata.setSortProperty(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BasicCollectionMetadata actualBasicCollectionMetadata = new BasicCollectionMetadata();
    actualBasicCollectionMetadata.setAddMethodType(AddMethodType.PERSIST);
    actualBasicCollectionMetadata.setSelectizeVisibleField("Selectize Visible Field");
    actualBasicCollectionMetadata.setSortProperty("Sort Property");
    AddMethodType actualAddMethodType = actualBasicCollectionMetadata.getAddMethodType();
    String actualSelectizeVisibleField = actualBasicCollectionMetadata.getSelectizeVisibleField();

    // Assert
    assertEquals("Selectize Visible Field", actualSelectizeVisibleField);
    assertEquals("Sort Property", actualBasicCollectionMetadata.getSortProperty());
    assertNull(actualBasicCollectionMetadata.getChildrenExcluded());
    assertNull(actualBasicCollectionMetadata.getExcluded());
    assertNull(actualBasicCollectionMetadata.getLazyFetch());
    assertNull(actualBasicCollectionMetadata.getGroupOrder());
    assertNull(actualBasicCollectionMetadata.getOrder());
    assertNull(actualBasicCollectionMetadata.getTabOrder());
    assertNull(actualBasicCollectionMetadata.getCollectionCeilingEntity());
    assertNull(actualBasicCollectionMetadata.getAddFriendlyName());
    assertNull(actualBasicCollectionMetadata.getCurrencyCodeField());
    assertNull(actualBasicCollectionMetadata.getFieldName());
    assertNull(actualBasicCollectionMetadata.getFriendlyName());
    assertNull(actualBasicCollectionMetadata.getGroup());
    assertNull(actualBasicCollectionMetadata.getInheritedFromType());
    assertNull(actualBasicCollectionMetadata.getOwningClass());
    assertNull(actualBasicCollectionMetadata.getOwningClassFriendlyName());
    assertNull(actualBasicCollectionMetadata.getPrefix());
    assertNull(actualBasicCollectionMetadata.getSecurityLevel());
    assertNull(actualBasicCollectionMetadata.getShowIfProperty());
    assertNull(actualBasicCollectionMetadata.getTab());
    assertNull(actualBasicCollectionMetadata.getTargetClass());
    assertNull(actualBasicCollectionMetadata.getCustomCriteria());
    assertNull(actualBasicCollectionMetadata.getAvailableToTypes());
    assertNull(actualBasicCollectionMetadata.getShowIfFieldEquals());
    assertNull(actualBasicCollectionMetadata.getPersistencePerspective());
    assertEquals(AddMethodType.PERSIST, actualAddMethodType);
    assertTrue(actualBasicCollectionMetadata.getAdditionalMetadata().isEmpty());
    assertTrue(actualBasicCollectionMetadata.isMutable());
  }
}
