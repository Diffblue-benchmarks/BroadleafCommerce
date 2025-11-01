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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.visitor.PersistencePerspectiveItemVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.PersistencePerspectiveItemVisitorAdapter;
import org.junit.Test;
import org.mockito.Mockito;

public class ParentRecordStructureDiffblueTest {
  /**
   * Method under test:
   * {@link ParentRecordStructure#accept(PersistencePerspectiveItemVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    PersistencePerspectiveItemVisitorAdapter visitor = mock(PersistencePerspectiveItemVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<ParentRecordStructure>any());

    // Act
    parentRecordStructure.accept(visitor);

    // Assert
    verify(visitor).visit(isA(ParentRecordStructure.class));
  }

  /**
   * Method under test:
   * {@link ParentRecordStructure#clonePersistencePerspectiveItem()}
   */
  @Test
  public void testClonePersistencePerspectiveItem() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();

    // Act
    PersistencePerspectiveItem actualClonePersistencePerspectiveItemResult = parentRecordStructure
        .clonePersistencePerspectiveItem();

    // Assert
    assertTrue(actualClonePersistencePerspectiveItemResult instanceof ParentRecordStructure);
    assertEquals(parentRecordStructure, actualClonePersistencePerspectiveItemResult);
  }

  /**
   * Method under test:
   * {@link ParentRecordStructure#clonePersistencePerspectiveItem()}
   */
  @Test
  public void testClonePersistencePerspectiveItem2() {
    // Arrange
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.computeIfPresent("foo", mock(BiFunction.class));

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);

    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    parentRecordStructure.setParentMetadata(parentMetadata);

    // Act
    PersistencePerspectiveItem actualClonePersistencePerspectiveItemResult = parentRecordStructure
        .clonePersistencePerspectiveItem();

    // Assert
    assertTrue(actualClonePersistencePerspectiveItemResult instanceof ParentRecordStructure);
    assertEquals(parentRecordStructure, actualClonePersistencePerspectiveItemResult);
  }

  /**
   * Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("ParentRecordStructure{}", (new ParentRecordStructure()).toString());
  }

  /**
   * Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    parentRecordStructure.setParentRecord(null);
    parentRecordStructure.setParentMetadata(parentMetadata);

    // Act and Assert
    assertEquals("ParentRecordStructure{, parentMetadata=[Property{name='null', value='null', isDirty=false,"
        + " enabled=true}]}", parentRecordStructure.toString());
  }

  /**
   * Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  public void testToString3() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    parentMetadata.setProperties(null);

    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    parentRecordStructure.setParentRecord(null);
    parentRecordStructure.setParentMetadata(parentMetadata);

    // Act and Assert
    assertEquals("ParentRecordStructure{}", parentRecordStructure.toString());
  }

  /**
   * Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  public void testToString4() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    parentRecordStructure.setParentRecord(new Entity());
    parentRecordStructure.setParentMetadata(null);

    // Act and Assert
    assertEquals("ParentRecordStructure{Entity{isValidationFailure=false, isDirty=false, properties=null, type=null}'}",
        parentRecordStructure.toString());
  }

  /**
   * Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  public void testToString5() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[]{null});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    parentRecordStructure.setParentRecord(null);
    parentRecordStructure.setParentMetadata(parentMetadata);

    // Act and Assert
    assertEquals("ParentRecordStructure{, parentMetadata=[null]}", parentRecordStructure.toString());
  }

  /**
   * Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  public void testToString6() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[]{new Property("ParentRecordStructure{", "42")});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    parentRecordStructure.setParentRecord(null);
    parentRecordStructure.setParentMetadata(parentMetadata);

    // Act and Assert
    assertEquals(
        "ParentRecordStructure{, parentMetadata=[Property{name='ParentRecordStructure{', value='42', isDirty=false,"
            + " enabled=true}]}",
        parentRecordStructure.toString());
  }

  /**
   * Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  public void testToString7() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    Property property = new Property();
    parentMetadata.setProperties(new Property[]{property, new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    parentRecordStructure.setParentRecord(null);
    parentRecordStructure.setParentMetadata(parentMetadata);

    // Act and Assert
    assertEquals(
        "ParentRecordStructure{, parentMetadata=[Property{name='null', value='null', isDirty=false, enabled=true},"
            + " Property{name='null', value='null', isDirty=false, enabled=true}]}",
        parentRecordStructure.toString());
  }

  /**
   * Method under test: {@link ParentRecordStructure#toString()}
   */
  @Test
  public void testToString8() {
    // Arrange
    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.computeIfPresent("ParentRecordStructure{", mock(BiFunction.class));

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(tabAndGroupMetadata);
    parentMetadata.setProperties(null);

    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    parentRecordStructure.setParentRecord(null);
    parentRecordStructure.setParentMetadata(parentMetadata);

    // Act and Assert
    assertEquals("ParentRecordStructure{}", parentRecordStructure.toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParentRecordStructure#equals(Object)}
   *   <li>{@link ParentRecordStructure#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    ParentRecordStructure parentRecordStructure2 = new ParentRecordStructure();

    // Act and Assert
    assertEquals(parentRecordStructure, parentRecordStructure2);
    int expectedHashCodeResult = parentRecordStructure.hashCode();
    assertEquals(expectedHashCodeResult, parentRecordStructure2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParentRecordStructure#equals(Object)}
   *   <li>{@link ParentRecordStructure#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();

    // Act and Assert
    assertEquals(parentRecordStructure, parentRecordStructure);
    int expectedHashCodeResult = parentRecordStructure.hashCode();
    assertEquals(expectedHashCodeResult, parentRecordStructure.hashCode());
  }

  /**
   * Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Entity parentRecord = new Entity();
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure(parentRecord, new ClassMetadata());

    // Act and Assert
    assertNotEquals(parentRecordStructure, new ParentRecordStructure());
  }

  /**
   * Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    Entity parentRecord = new Entity();

    // Act and Assert
    assertNotEquals(parentRecordStructure, new ParentRecordStructure(parentRecord, new ClassMetadata()));
  }

  /**
   * Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();
    parentRecordStructure.setParentMetadata(parentMetadata);

    // Act and Assert
    assertNotEquals(parentRecordStructure, new ParentRecordStructure());
  }

  /**
   * Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Entity parentRecord = mock(Entity.class);
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure(parentRecord, new ClassMetadata());

    // Act and Assert
    assertNotEquals(parentRecordStructure, new ParentRecordStructure());
  }

  /**
   * Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Entity parentRecord = new Entity();
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure(parentRecord, new ClassMetadata());

    ParentRecordStructure parentRecordStructure2 = new ParentRecordStructure();
    parentRecordStructure2.setParentRecord(new Entity());

    // Act and Assert
    assertNotEquals(parentRecordStructure, parentRecordStructure2);
  }

  /**
   * Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ParentRecordStructure parentRecordStructure = new ParentRecordStructure();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    ParentRecordStructure parentRecordStructure2 = new ParentRecordStructure();
    parentRecordStructure2.setParentMetadata(parentMetadata);

    // Act and Assert
    assertNotEquals(parentRecordStructure, parentRecordStructure2);
  }

  /**
   * Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParentRecordStructure(), null);
  }

  /**
   * Method under test: {@link ParentRecordStructure#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParentRecordStructure(), "Different type to ParentRecordStructure");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ParentRecordStructure#ParentRecordStructure()}
   *   <li>{@link ParentRecordStructure#setParentMetadata(ClassMetadata)}
   *   <li>{@link ParentRecordStructure#setParentRecord(Entity)}
   *   <li>{@link ParentRecordStructure#getParentMetadata()}
   *   <li>{@link ParentRecordStructure#getParentRecord()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ParentRecordStructure actualParentRecordStructure = new ParentRecordStructure();
    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());
    actualParentRecordStructure.setParentMetadata(parentMetadata);
    Entity parentRecord = new Entity();
    actualParentRecordStructure.setParentRecord(parentRecord);
    ClassMetadata actualParentMetadata = actualParentRecordStructure.getParentMetadata();

    // Assert that nothing has changed
    assertSame(parentMetadata, actualParentMetadata);
    assertSame(parentRecord, actualParentRecordStructure.getParentRecord());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ParentRecordStructure#ParentRecordStructure(Entity, ClassMetadata)}
   *   <li>{@link ParentRecordStructure#setParentMetadata(ClassMetadata)}
   *   <li>{@link ParentRecordStructure#setParentRecord(Entity)}
   *   <li>{@link ParentRecordStructure#getParentMetadata()}
   *   <li>{@link ParentRecordStructure#getParentRecord()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    Entity parentRecord = new Entity();

    ClassMetadata parentMetadata = new ClassMetadata();
    parentMetadata.setCeilingType("Type");
    parentMetadata.setCurrencyCode("GBP");
    parentMetadata.setPolymorphicEntities(new ClassTree());
    parentMetadata.setProperties(new Property[]{new Property()});
    parentMetadata.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata.setTabAndGroupMetadata(new HashMap<>());

    // Act
    ParentRecordStructure actualParentRecordStructure = new ParentRecordStructure(parentRecord, parentMetadata);
    ClassMetadata parentMetadata2 = new ClassMetadata();
    parentMetadata2.setCeilingType("Type");
    parentMetadata2.setCurrencyCode("GBP");
    parentMetadata2.setPolymorphicEntities(new ClassTree());
    parentMetadata2.setProperties(new Property[]{new Property()});
    parentMetadata2.setSecurityCeilingType("Security Ceiling Type");
    parentMetadata2.setTabAndGroupMetadata(new HashMap<>());
    actualParentRecordStructure.setParentMetadata(parentMetadata2);
    Entity parentRecord2 = new Entity();
    actualParentRecordStructure.setParentRecord(parentRecord2);
    ClassMetadata actualParentMetadata = actualParentRecordStructure.getParentMetadata();

    // Assert that nothing has changed
    assertSame(parentMetadata2, actualParentMetadata);
    assertSame(parentRecord2, actualParentRecordStructure.getParentRecord());
  }
}
