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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.openadmin.dto.visitor.PersistencePerspectiveItemVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.PersistencePerspectiveItemVisitorAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdornedTargetList.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdornedTargetListDiffblueTest {
  @Autowired
  private AdornedTargetList adornedTargetList;

  /**
   * Test {@link AdornedTargetList#AdornedTargetList()}.
   * <p>
   * Method under test: {@link AdornedTargetList#AdornedTargetList()}
   */
  @Test
  public void testNewAdornedTargetList() {
    // Arrange and Act
    AdornedTargetList actualAdornedTargetList = new AdornedTargetList();

    // Assert
    assertNull(actualAdornedTargetList.getSortAscending());
    assertNull(actualAdornedTargetList.getAdornedTargetEntityClassname());
    assertNull(actualAdornedTargetList.getAdornedTargetEntityPolymorphicType());
    assertNull(actualAdornedTargetList.getCollectionFieldName());
    assertNull(actualAdornedTargetList.getIdProperty());
    assertNull(actualAdornedTargetList.getJoinEntityClass());
    assertNull(actualAdornedTargetList.getLinkedIdProperty());
    assertNull(actualAdornedTargetList.getLinkedObjectPath());
    assertNull(actualAdornedTargetList.getSortField());
    assertNull(actualAdornedTargetList.getTargetIdProperty());
    assertNull(actualAdornedTargetList.getTargetObjectPath());
    assertFalse(actualAdornedTargetList.getInverse());
    assertTrue(actualAdornedTargetList.getMutable());
  }

  /**
   * Test
   * {@link AdornedTargetList#AdornedTargetList(String, String, String, String, String, String)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetList#AdornedTargetList(String, String, String, String, String, String)}
   */
  @Test
  public void testNewAdornedTargetList2() {
    // Arrange and Act
    AdornedTargetList actualAdornedTargetList = new AdornedTargetList("Collection Field Name", "Linked Object Path",
        "Linked Id Property", "Target Object Path", "Target Id Property", "Adorned Target Entity Classname");

    // Assert
    assertEquals("Adorned Target Entity Classname", actualAdornedTargetList.getAdornedTargetEntityClassname());
    assertEquals("Collection Field Name", actualAdornedTargetList.getCollectionFieldName());
    assertEquals("Linked Id Property", actualAdornedTargetList.getLinkedIdProperty());
    assertEquals("Linked Object Path", actualAdornedTargetList.getLinkedObjectPath());
    assertEquals("Target Id Property", actualAdornedTargetList.getTargetIdProperty());
    assertEquals("Target Object Path", actualAdornedTargetList.getTargetObjectPath());
    assertNull(actualAdornedTargetList.getSortAscending());
    assertNull(actualAdornedTargetList.getAdornedTargetEntityPolymorphicType());
    assertNull(actualAdornedTargetList.getIdProperty());
    assertNull(actualAdornedTargetList.getJoinEntityClass());
    assertNull(actualAdornedTargetList.getSortField());
    assertFalse(actualAdornedTargetList.getInverse());
    assertTrue(actualAdornedTargetList.getMutable());
  }

  /**
   * Test
   * {@link AdornedTargetList#AdornedTargetList(String, String, String, String, String, String, String)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetList#AdornedTargetList(String, String, String, String, String, String, String)}
   */
  @Test
  public void testNewAdornedTargetList3() {
    // Arrange and Act
    AdornedTargetList actualAdornedTargetList = new AdornedTargetList("Collection Field Name", "Linked Object Path",
        "Linked Id Property", "Target Object Path", "Target Id Property", "Adorned Target Entity Classname",
        "Adorned Target Entity Polymorphic Type");

    // Assert
    assertEquals("Adorned Target Entity Classname", actualAdornedTargetList.getAdornedTargetEntityClassname());
    assertEquals("Adorned Target Entity Polymorphic Type",
        actualAdornedTargetList.getAdornedTargetEntityPolymorphicType());
    assertEquals("Collection Field Name", actualAdornedTargetList.getCollectionFieldName());
    assertEquals("Linked Id Property", actualAdornedTargetList.getLinkedIdProperty());
    assertEquals("Linked Object Path", actualAdornedTargetList.getLinkedObjectPath());
    assertEquals("Target Id Property", actualAdornedTargetList.getTargetIdProperty());
    assertEquals("Target Object Path", actualAdornedTargetList.getTargetObjectPath());
    assertNull(actualAdornedTargetList.getSortAscending());
    assertNull(actualAdornedTargetList.getIdProperty());
    assertNull(actualAdornedTargetList.getJoinEntityClass());
    assertNull(actualAdornedTargetList.getSortField());
    assertFalse(actualAdornedTargetList.getInverse());
    assertTrue(actualAdornedTargetList.getMutable());
  }

  /**
   * Test
   * {@link AdornedTargetList#AdornedTargetList(String, String, String, String, String, String, String, Boolean)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetList#AdornedTargetList(String, String, String, String, String, String, String, Boolean)}
   */
  @Test
  public void testNewAdornedTargetList4() {
    // Arrange and Act
    AdornedTargetList actualAdornedTargetList = new AdornedTargetList("Collection Field Name", "Linked Object Path",
        "Linked Id Property", "Target Object Path", "Target Id Property", "Adorned Target Entity Classname",
        "Sort Field", true);

    // Assert
    assertEquals("Adorned Target Entity Classname", actualAdornedTargetList.getAdornedTargetEntityClassname());
    assertEquals("Collection Field Name", actualAdornedTargetList.getCollectionFieldName());
    assertEquals("Linked Id Property", actualAdornedTargetList.getLinkedIdProperty());
    assertEquals("Linked Object Path", actualAdornedTargetList.getLinkedObjectPath());
    assertEquals("Sort Field", actualAdornedTargetList.getSortField());
    assertEquals("Target Id Property", actualAdornedTargetList.getTargetIdProperty());
    assertEquals("Target Object Path", actualAdornedTargetList.getTargetObjectPath());
    assertNull(actualAdornedTargetList.getAdornedTargetEntityPolymorphicType());
    assertNull(actualAdornedTargetList.getIdProperty());
    assertNull(actualAdornedTargetList.getJoinEntityClass());
    assertFalse(actualAdornedTargetList.getInverse());
    assertTrue(actualAdornedTargetList.getMutable());
    assertTrue(actualAdornedTargetList.getSortAscending());
  }

  /**
   * Test
   * {@link AdornedTargetList#AdornedTargetList(String, String, String, String, String, String, String, String, Boolean)}.
   * <p>
   * Method under test:
   * {@link AdornedTargetList#AdornedTargetList(String, String, String, String, String, String, String, String, Boolean)}
   */
  @Test
  public void testNewAdornedTargetList5() {
    // Arrange and Act
    AdornedTargetList actualAdornedTargetList = new AdornedTargetList("Collection Field Name", "Linked Object Path",
        "Linked Id Property", "Target Object Path", "Target Id Property", "Adorned Target Entity Classname",
        "Adorned Target Entity Polymorphic Type", "Sort Field", true);

    // Assert
    assertEquals("Adorned Target Entity Classname", actualAdornedTargetList.getAdornedTargetEntityClassname());
    assertEquals("Adorned Target Entity Polymorphic Type",
        actualAdornedTargetList.getAdornedTargetEntityPolymorphicType());
    assertEquals("Collection Field Name", actualAdornedTargetList.getCollectionFieldName());
    assertEquals("Linked Id Property", actualAdornedTargetList.getLinkedIdProperty());
    assertEquals("Linked Object Path", actualAdornedTargetList.getLinkedObjectPath());
    assertEquals("Sort Field", actualAdornedTargetList.getSortField());
    assertEquals("Target Id Property", actualAdornedTargetList.getTargetIdProperty());
    assertEquals("Target Object Path", actualAdornedTargetList.getTargetObjectPath());
    assertNull(actualAdornedTargetList.getIdProperty());
    assertNull(actualAdornedTargetList.getJoinEntityClass());
    assertFalse(actualAdornedTargetList.getInverse());
    assertTrue(actualAdornedTargetList.getMutable());
    assertTrue(actualAdornedTargetList.getSortAscending());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetList#setAdornedTargetEntityClassname(String)}
   *   <li>{@link AdornedTargetList#setAdornedTargetEntityPolymorphicType(String)}
   *   <li>{@link AdornedTargetList#setCollectionFieldName(String)}
   *   <li>{@link AdornedTargetList#setIdProperty(String)}
   *   <li>{@link AdornedTargetList#setInverse(Boolean)}
   *   <li>{@link AdornedTargetList#setJoinEntityClass(String)}
   *   <li>{@link AdornedTargetList#setLinkedIdProperty(String)}
   *   <li>{@link AdornedTargetList#setLinkedObjectPath(String)}
   *   <li>{@link AdornedTargetList#setMutable(Boolean)}
   *   <li>{@link AdornedTargetList#setSortAscending(Boolean)}
   *   <li>{@link AdornedTargetList#setSortField(String)}
   *   <li>{@link AdornedTargetList#setTargetIdProperty(String)}
   *   <li>{@link AdornedTargetList#setTargetObjectPath(String)}
   *   <li>{@link AdornedTargetList#toString()}
   *   <li>{@link AdornedTargetList#getAdornedTargetEntityClassname()}
   *   <li>{@link AdornedTargetList#getAdornedTargetEntityPolymorphicType()}
   *   <li>{@link AdornedTargetList#getCollectionFieldName()}
   *   <li>{@link AdornedTargetList#getIdProperty()}
   *   <li>{@link AdornedTargetList#getInverse()}
   *   <li>{@link AdornedTargetList#getJoinEntityClass()}
   *   <li>{@link AdornedTargetList#getLinkedIdProperty()}
   *   <li>{@link AdornedTargetList#getLinkedObjectPath()}
   *   <li>{@link AdornedTargetList#getMutable()}
   *   <li>{@link AdornedTargetList#getSortAscending()}
   *   <li>{@link AdornedTargetList#getSortField()}
   *   <li>{@link AdornedTargetList#getTargetIdProperty()}
   *   <li>{@link AdornedTargetList#getTargetObjectPath()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    // Act
    adornedTargetList.setAdornedTargetEntityClassname("Adorned Target Entity Classname");
    adornedTargetList.setAdornedTargetEntityPolymorphicType("Adorned Target Entity Polymorphic Type");
    adornedTargetList.setCollectionFieldName("Many To Field");
    adornedTargetList.setIdProperty("Id Property");
    adornedTargetList.setInverse(true);
    adornedTargetList.setJoinEntityClass("Join Entity Class");
    adornedTargetList.setLinkedIdProperty("Linked Id Property");
    adornedTargetList.setLinkedObjectPath("Linked Property Path");
    adornedTargetList.setMutable(true);
    adornedTargetList.setSortAscending(true);
    adornedTargetList.setSortField("Sort Field");
    adornedTargetList.setTargetIdProperty("Target Id Property");
    adornedTargetList.setTargetObjectPath("Target Object Path");
    String actualToStringResult = adornedTargetList.toString();
    String actualAdornedTargetEntityClassname = adornedTargetList.getAdornedTargetEntityClassname();
    String actualAdornedTargetEntityPolymorphicType = adornedTargetList.getAdornedTargetEntityPolymorphicType();
    String actualCollectionFieldName = adornedTargetList.getCollectionFieldName();
    String actualIdProperty = adornedTargetList.getIdProperty();
    Boolean actualInverse = adornedTargetList.getInverse();
    String actualJoinEntityClass = adornedTargetList.getJoinEntityClass();
    String actualLinkedIdProperty = adornedTargetList.getLinkedIdProperty();
    String actualLinkedObjectPath = adornedTargetList.getLinkedObjectPath();
    Boolean actualMutable = adornedTargetList.getMutable();
    Boolean actualSortAscending = adornedTargetList.getSortAscending();
    String actualSortField = adornedTargetList.getSortField();
    String actualTargetIdProperty = adornedTargetList.getTargetIdProperty();

    // Assert that nothing has changed
    assertEquals("Adorned Target Entity Classname", actualAdornedTargetEntityClassname);
    assertEquals("Adorned Target Entity Polymorphic Type", actualAdornedTargetEntityPolymorphicType);
    assertEquals(
        "AdornedTargetList{collectionFieldName='Many To Field', linkedObjectPath='Linked Property Path',"
            + " targetObjectPath='Target Object Path', adornedTargetEntityClassname='Adorned Target Entity Classname',"
            + " adornedTargetEntityPolymorphicType='Adorned Target Entity Polymorphic Type', sortField='Sort Field',"
            + " sortAscending=true, linkedIdProperty='Linked Id Property', targetIdProperty='Target Id Property',"
            + " inverse=true, joinEntityClass='Join Entity Class', idProperty='Id Property', mutable=true}",
        actualToStringResult);
    assertEquals("Id Property", actualIdProperty);
    assertEquals("Join Entity Class", actualJoinEntityClass);
    assertEquals("Linked Id Property", actualLinkedIdProperty);
    assertEquals("Linked Property Path", actualLinkedObjectPath);
    assertEquals("Many To Field", actualCollectionFieldName);
    assertEquals("Sort Field", actualSortField);
    assertEquals("Target Id Property", actualTargetIdProperty);
    assertEquals("Target Object Path", adornedTargetList.getTargetObjectPath());
    assertTrue(actualInverse);
    assertTrue(actualMutable);
    assertTrue(actualSortAscending);
  }

  /**
   * Test {@link AdornedTargetList#accept(PersistencePerspectiveItemVisitor)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePerspectiveItemVisitorAdapter#visit(AdornedTargetList)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdornedTargetList#accept(PersistencePerspectiveItemVisitor)}
   */
  @Test
  public void testAccept_thenCallsVisit() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    PersistencePerspectiveItemVisitorAdapter visitor = mock(PersistencePerspectiveItemVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<AdornedTargetList>any());

    // Act
    adornedTargetList.accept(visitor);

    // Assert
    verify(visitor).visit(isA(AdornedTargetList.class));
  }

  /**
   * Test {@link AdornedTargetList#clonePersistencePerspectiveItem()}.
   * <p>
   * Method under test:
   * {@link AdornedTargetList#clonePersistencePerspectiveItem()}
   */
  @Test
  public void testClonePersistencePerspectiveItem() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    // Act
    PersistencePerspectiveItem actualClonePersistencePerspectiveItemResult = adornedTargetList
        .clonePersistencePerspectiveItem();

    // Assert
    assertTrue(actualClonePersistencePerspectiveItemResult instanceof AdornedTargetList);
    assertEquals(adornedTargetList, actualClonePersistencePerspectiveItemResult);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}, and
   * {@link AdornedTargetList#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetList#equals(Object)}
   *   <li>{@link AdornedTargetList#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    AdornedTargetList adornedTargetList2 = new AdornedTargetList();

    // Act and Assert
    assertEquals(adornedTargetList, adornedTargetList2);
    int expectedHashCodeResult = adornedTargetList.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetList2.hashCode());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}, and
   * {@link AdornedTargetList#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetList#equals(Object)}
   *   <li>{@link AdornedTargetList#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList("Collection Field Name", "Linked Object Path",
        "Linked Id Property", "Target Object Path", "Target Id Property", "Adorned Target Entity Classname");
    AdornedTargetList adornedTargetList2 = new AdornedTargetList("Collection Field Name", "Linked Object Path",
        "Linked Id Property", "Target Object Path", "Target Id Property", "Adorned Target Entity Classname");

    // Act and Assert
    assertEquals(adornedTargetList, adornedTargetList2);
    int expectedHashCodeResult = adornedTargetList.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetList2.hashCode());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}, and
   * {@link AdornedTargetList#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetList#equals(Object)}
   *   <li>{@link AdornedTargetList#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setSortField("Sort Field");

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setSortField("Sort Field");

    // Act and Assert
    assertEquals(adornedTargetList, adornedTargetList2);
    int expectedHashCodeResult = adornedTargetList.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetList2.hashCode());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}, and
   * {@link AdornedTargetList#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetList#equals(Object)}
   *   <li>{@link AdornedTargetList#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setSortAscending(true);

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setSortAscending(true);

    // Act and Assert
    assertEquals(adornedTargetList, adornedTargetList2);
    int expectedHashCodeResult = adornedTargetList.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetList2.hashCode());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}, and
   * {@link AdornedTargetList#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetList#equals(Object)}
   *   <li>{@link AdornedTargetList#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setAdornedTargetEntityPolymorphicType("Adorned Target Entity Polymorphic Type");

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setAdornedTargetEntityPolymorphicType("Adorned Target Entity Polymorphic Type");

    // Act and Assert
    assertEquals(adornedTargetList, adornedTargetList2);
    int expectedHashCodeResult = adornedTargetList.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetList2.hashCode());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}, and
   * {@link AdornedTargetList#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetList#equals(Object)}
   *   <li>{@link AdornedTargetList#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setJoinEntityClass("Join Entity Class");

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setJoinEntityClass("Join Entity Class");

    // Act and Assert
    assertEquals(adornedTargetList, adornedTargetList2);
    int expectedHashCodeResult = adornedTargetList.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetList2.hashCode());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}, and
   * {@link AdornedTargetList#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetList#equals(Object)}
   *   <li>{@link AdornedTargetList#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setIdProperty("Id Property");

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setIdProperty("Id Property");

    // Act and Assert
    assertEquals(adornedTargetList, adornedTargetList2);
    int expectedHashCodeResult = adornedTargetList.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetList2.hashCode());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}, and
   * {@link AdornedTargetList#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdornedTargetList#equals(Object)}
   *   <li>{@link AdornedTargetList#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    // Act and Assert
    assertEquals(adornedTargetList, adornedTargetList);
    int expectedHashCodeResult = adornedTargetList.hashCode();
    assertEquals(expectedHashCodeResult, adornedTargetList.hashCode());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList("Collection Field Name", "Linked Object Path",
        "Linked Id Property", "Target Object Path", "Target Id Property", "Adorned Target Entity Classname");

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList("Collection Field Name", "Linked Object Path",
        "Linked Id Property", "Target Object Path", "Target Id Property", "Adorned Target Entity Classname"));
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setCollectionFieldName("Many To Field");

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setLinkedObjectPath("Linked Property Path");

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setTargetObjectPath("Target Object Path");

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setSortField("Sort Field");

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setSortAscending(true);

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setLinkedIdProperty("Linked Id Property");

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setTargetIdProperty("Target Id Property");

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setInverse(true);

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setAdornedTargetEntityPolymorphicType("Adorned Target Entity Polymorphic Type");

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setJoinEntityClass("Join Entity Class");

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setIdProperty("Id Property");

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList("Collection Field Name", "Linked Object Path",
        "Linked Id Property", "Target Object Path", "Target Id Property", "Adorned Target Entity Classname");

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setAdornedTargetEntityClassname("Adorned Target Entity Classname");

    // Act and Assert
    assertNotEquals(adornedTargetList, adornedTargetList2);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList("Collection Field Name", "Linked Object Path",
        "Linked Id Property", "Target Object Path", "Target Id Property", "Adorned Target Entity Classname");

    // Act and Assert
    assertNotEquals(adornedTargetList,
        new AdornedTargetList("Collection Field Name", "Linked Object Path", "Linked Id Property", "Target Object Path",
            "Target Id Property", "Adorned Target Entity Classname", "Adorned Target Entity Polymorphic Type"));
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setCollectionFieldName("Many To Field");

    // Act and Assert
    assertNotEquals(adornedTargetList, adornedTargetList2);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setLinkedObjectPath("Linked Property Path");

    // Act and Assert
    assertNotEquals(adornedTargetList, adornedTargetList2);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setTargetObjectPath("Target Object Path");

    // Act and Assert
    assertNotEquals(adornedTargetList, adornedTargetList2);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setSortField("Sort Field");

    // Act and Assert
    assertNotEquals(adornedTargetList, adornedTargetList2);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setSortAscending(true);

    // Act and Assert
    assertNotEquals(adornedTargetList, adornedTargetList2);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setLinkedIdProperty("Linked Id Property");

    // Act and Assert
    assertNotEquals(adornedTargetList, adornedTargetList2);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setTargetIdProperty("Target Id Property");

    // Act and Assert
    assertNotEquals(adornedTargetList, adornedTargetList2);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setJoinEntityClass("Join Entity Class");

    // Act and Assert
    assertNotEquals(adornedTargetList, adornedTargetList2);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();

    AdornedTargetList adornedTargetList2 = new AdornedTargetList();
    adornedTargetList2.setIdProperty("Id Property");

    // Act and Assert
    assertNotEquals(adornedTargetList, adornedTargetList2);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    AdornedTargetList adornedTargetList = new AdornedTargetList();
    adornedTargetList.setInverse(null);

    // Act and Assert
    assertNotEquals(adornedTargetList, new AdornedTargetList());
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetList(), null);
  }

  /**
   * Test {@link AdornedTargetList#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdornedTargetList#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AdornedTargetList(), "Different type to AdornedTargetList");
  }
}
