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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.common.presentation.client.ForeignKeyRestrictionType;
import org.broadleafcommerce.openadmin.dto.visitor.PersistencePerspectiveItemVisitor;
import org.broadleafcommerce.openadmin.dto.visitor.PersistencePerspectiveItemVisitorAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {ForeignKey.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ForeignKeyDiffblueTest {
  @Autowired
  private ForeignKey foreignKey;

  /**
   * Test {@link ForeignKey#ForeignKey()}.
   * <p>
   * Method under test: {@link ForeignKey#ForeignKey()}
   */
  @Test
  public void testNewForeignKey() {
    // Arrange and Act
    ForeignKey actualForeignKey = new ForeignKey();

    // Assert
    assertEquals("name", actualForeignKey.getDisplayValueProperty());
    assertNull(actualForeignKey.getSortAscending());
    assertNull(actualForeignKey.getCurrentValue());
    assertNull(actualForeignKey.getDataSourceName());
    assertNull(actualForeignKey.getForeignKeyClass());
    assertNull(actualForeignKey.getManyToField());
    assertNull(actualForeignKey.getOriginatingField());
    assertNull(actualForeignKey.getSortField());
    assertEquals(ForeignKeyRestrictionType.ID_EQ, actualForeignKey.getRestrictionType());
    assertTrue(actualForeignKey.getMutable());
  }

  /**
   * Test {@link ForeignKey#ForeignKey(String, String)}.
   * <p>
   * Method under test: {@link ForeignKey#ForeignKey(String, String)}
   */
  @Test
  public void testNewForeignKey2() {
    // Arrange and Act
    ForeignKey actualForeignKey = new ForeignKey("Many To Field", "Foreign Key Class");

    // Assert
    assertEquals("Foreign Key Class", actualForeignKey.getForeignKeyClass());
    assertEquals("Many To Field", actualForeignKey.getManyToField());
    assertEquals("name", actualForeignKey.getDisplayValueProperty());
    assertNull(actualForeignKey.getSortAscending());
    assertNull(actualForeignKey.getCurrentValue());
    assertNull(actualForeignKey.getDataSourceName());
    assertNull(actualForeignKey.getOriginatingField());
    assertNull(actualForeignKey.getSortField());
    assertEquals(ForeignKeyRestrictionType.ID_EQ, actualForeignKey.getRestrictionType());
    assertTrue(actualForeignKey.getMutable());
  }

  /**
   * Test {@link ForeignKey#ForeignKey(String, String, String)}.
   * <p>
   * Method under test: {@link ForeignKey#ForeignKey(String, String, String)}
   */
  @Test
  public void testNewForeignKey3() {
    // Arrange and Act
    ForeignKey actualForeignKey = new ForeignKey("Many To Field", "Foreign Key Class", "Data Source Name");

    // Assert
    assertEquals("Data Source Name", actualForeignKey.getDataSourceName());
    assertEquals("Foreign Key Class", actualForeignKey.getForeignKeyClass());
    assertEquals("Many To Field", actualForeignKey.getManyToField());
    assertEquals("name", actualForeignKey.getDisplayValueProperty());
    assertNull(actualForeignKey.getSortAscending());
    assertNull(actualForeignKey.getCurrentValue());
    assertNull(actualForeignKey.getOriginatingField());
    assertNull(actualForeignKey.getSortField());
    assertEquals(ForeignKeyRestrictionType.ID_EQ, actualForeignKey.getRestrictionType());
    assertTrue(actualForeignKey.getMutable());
  }

  /**
   * Test
   * {@link ForeignKey#ForeignKey(String, String, String, ForeignKeyRestrictionType)}.
   * <p>
   * Method under test:
   * {@link ForeignKey#ForeignKey(String, String, String, ForeignKeyRestrictionType)}
   */
  @Test
  public void testNewForeignKey4() {
    // Arrange and Act
    ForeignKey actualForeignKey = new ForeignKey("Many To Field", "Foreign Key Class", "Data Source Name",
        ForeignKeyRestrictionType.ID_EQ);

    // Assert
    assertEquals("Data Source Name", actualForeignKey.getDataSourceName());
    assertEquals("Foreign Key Class", actualForeignKey.getForeignKeyClass());
    assertEquals("Many To Field", actualForeignKey.getManyToField());
    assertEquals("name", actualForeignKey.getDisplayValueProperty());
    assertNull(actualForeignKey.getSortAscending());
    assertNull(actualForeignKey.getCurrentValue());
    assertNull(actualForeignKey.getOriginatingField());
    assertNull(actualForeignKey.getSortField());
    assertEquals(ForeignKeyRestrictionType.ID_EQ, actualForeignKey.getRestrictionType());
    assertTrue(actualForeignKey.getMutable());
  }

  /**
   * Test
   * {@link ForeignKey#ForeignKey(String, String, String, ForeignKeyRestrictionType, String)}.
   * <p>
   * Method under test:
   * {@link ForeignKey#ForeignKey(String, String, String, ForeignKeyRestrictionType, String)}
   */
  @Test
  public void testNewForeignKey5() {
    // Arrange and Act
    ForeignKey actualForeignKey = new ForeignKey("Many To Field", "Foreign Key Class", "Data Source Name",
        ForeignKeyRestrictionType.ID_EQ, "42");

    // Assert
    assertEquals("42", actualForeignKey.getDisplayValueProperty());
    assertEquals("Data Source Name", actualForeignKey.getDataSourceName());
    assertEquals("Foreign Key Class", actualForeignKey.getForeignKeyClass());
    assertEquals("Many To Field", actualForeignKey.getManyToField());
    assertNull(actualForeignKey.getSortAscending());
    assertNull(actualForeignKey.getCurrentValue());
    assertNull(actualForeignKey.getOriginatingField());
    assertNull(actualForeignKey.getSortField());
    assertEquals(ForeignKeyRestrictionType.ID_EQ, actualForeignKey.getRestrictionType());
    assertTrue(actualForeignKey.getMutable());
  }

  /**
   * Test {@link ForeignKey#withManyToField(String)}.
   * <p>
   * Method under test: {@link ForeignKey#withManyToField(String)}
   */
  @Test
  public void testWithManyToField() {
    // Arrange and Act
    ForeignKey actualWithManyToFieldResult = foreignKey.withManyToField("Many To Field");

    // Assert
    assertEquals("Many To Field", foreignKey.getManyToField());
    assertSame(foreignKey, actualWithManyToFieldResult);
  }

  /**
   * Test {@link ForeignKey#withOriginatingField(String)}.
   * <p>
   * Method under test: {@link ForeignKey#withOriginatingField(String)}
   */
  @Test
  public void testWithOriginatingField() {
    // Arrange and Act
    ForeignKey actualWithOriginatingFieldResult = foreignKey.withOriginatingField("Originating Field");

    // Assert
    assertEquals("Originating Field", foreignKey.getOriginatingField());
    assertSame(foreignKey, actualWithOriginatingFieldResult);
  }

  /**
   * Test {@link ForeignKey#withForeignKeyClass(String)}.
   * <p>
   * Method under test: {@link ForeignKey#withForeignKeyClass(String)}
   */
  @Test
  public void testWithForeignKeyClass() {
    // Arrange and Act
    ForeignKey actualWithForeignKeyClassResult = foreignKey.withForeignKeyClass("Foreign Key Class");

    // Assert
    assertEquals("Foreign Key Class", foreignKey.getForeignKeyClass());
    assertSame(foreignKey, actualWithForeignKeyClassResult);
  }

  /**
   * Test {@link ForeignKey#withSortField(String)}.
   * <p>
   * Method under test: {@link ForeignKey#withSortField(String)}
   */
  @Test
  public void testWithSortField() {
    // Arrange and Act
    ForeignKey actualWithSortFieldResult = foreignKey.withSortField("Sort Field");

    // Assert
    assertEquals("Sort Field", foreignKey.getSortField());
    assertSame(foreignKey, actualWithSortFieldResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForeignKey#setCurrentValue(String)}
   *   <li>{@link ForeignKey#setDataSourceName(String)}
   *   <li>{@link ForeignKey#setDisplayValueProperty(String)}
   *   <li>{@link ForeignKey#setForeignKeyClass(String)}
   *   <li>{@link ForeignKey#setManyToField(String)}
   *   <li>{@link ForeignKey#setMutable(Boolean)}
   *   <li>{@link ForeignKey#setOriginatingField(String)}
   *   <li>{@link ForeignKey#setRestrictionType(ForeignKeyRestrictionType)}
   *   <li>{@link ForeignKey#setSortAscending(Boolean)}
   *   <li>{@link ForeignKey#setSortField(String)}
   *   <li>{@link ForeignKey#toString()}
   *   <li>{@link ForeignKey#getCurrentValue()}
   *   <li>{@link ForeignKey#getDataSourceName()}
   *   <li>{@link ForeignKey#getDisplayValueProperty()}
   *   <li>{@link ForeignKey#getForeignKeyClass()}
   *   <li>{@link ForeignKey#getManyToField()}
   *   <li>{@link ForeignKey#getMutable()}
   *   <li>{@link ForeignKey#getOriginatingField()}
   *   <li>{@link ForeignKey#getRestrictionType()}
   *   <li>{@link ForeignKey#getSortAscending()}
   *   <li>{@link ForeignKey#getSortField()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    // Act
    foreignKey.setCurrentValue("42");
    foreignKey.setDataSourceName("Data Source Name");
    foreignKey.setDisplayValueProperty("42");
    foreignKey.setForeignKeyClass("Foreign Key Class");
    foreignKey.setManyToField("Many To Field");
    foreignKey.setMutable(true);
    foreignKey.setOriginatingField("Originating Field");
    foreignKey.setRestrictionType(ForeignKeyRestrictionType.ID_EQ);
    foreignKey.setSortAscending(true);
    foreignKey.setSortField("Sort Field");
    String actualToStringResult = foreignKey.toString();
    String actualCurrentValue = foreignKey.getCurrentValue();
    String actualDataSourceName = foreignKey.getDataSourceName();
    String actualDisplayValueProperty = foreignKey.getDisplayValueProperty();
    String actualForeignKeyClass = foreignKey.getForeignKeyClass();
    String actualManyToField = foreignKey.getManyToField();
    Boolean actualMutable = foreignKey.getMutable();
    String actualOriginatingField = foreignKey.getOriginatingField();
    ForeignKeyRestrictionType actualRestrictionType = foreignKey.getRestrictionType();
    Boolean actualSortAscending = foreignKey.getSortAscending();

    // Assert that nothing has changed
    assertEquals("42", actualCurrentValue);
    assertEquals("42", actualDisplayValueProperty);
    assertEquals("Data Source Name", actualDataSourceName);
    assertEquals("Foreign Key Class", actualForeignKeyClass);
    assertEquals(
        "ForeignKey{manyToField='Many To Field', originatingField='Originating Field', foreignKeyClass='Foreign"
            + " Key Class', currentValue='42', dataSourceName='Data Source Name', restrictionType=ID_EQ, displayVal"
            + "ueProperty='42', sortField='Sort Field', sortAscending=true', mutable=true}",
        actualToStringResult);
    assertEquals("Many To Field", actualManyToField);
    assertEquals("Originating Field", actualOriginatingField);
    assertEquals("Sort Field", foreignKey.getSortField());
    assertEquals(ForeignKeyRestrictionType.ID_EQ, actualRestrictionType);
    assertTrue(actualMutable);
    assertTrue(actualSortAscending);
  }

  /**
   * Test {@link ForeignKey#accept(PersistencePerspectiveItemVisitor)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePerspectiveItemVisitorAdapter#visit(ForeignKey)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ForeignKey#accept(PersistencePerspectiveItemVisitor)}
   */
  @Test
  public void testAccept_thenCallsVisit() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    PersistencePerspectiveItemVisitorAdapter visitor = mock(PersistencePerspectiveItemVisitorAdapter.class);
    doNothing().when(visitor).visit(Mockito.<ForeignKey>any());

    // Act
    foreignKey.accept(visitor);

    // Assert
    verify(visitor).visit(isA(ForeignKey.class));
  }

  /**
   * Test {@link ForeignKey#cloneForeignKey()}.
   * <p>
   * Method under test: {@link ForeignKey#cloneForeignKey()}
   */
  @Test
  public void testCloneForeignKey() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    // Act and Assert
    assertEquals(foreignKey, foreignKey.cloneForeignKey());
  }

  /**
   * Test {@link ForeignKey#clonePersistencePerspectiveItem()}.
   * <p>
   * Method under test: {@link ForeignKey#clonePersistencePerspectiveItem()}
   */
  @Test
  public void testClonePersistencePerspectiveItem() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    // Act
    PersistencePerspectiveItem actualClonePersistencePerspectiveItemResult = foreignKey
        .clonePersistencePerspectiveItem();

    // Assert
    assertTrue(actualClonePersistencePerspectiveItemResult instanceof ForeignKey);
    assertEquals(foreignKey, actualClonePersistencePerspectiveItemResult);
  }

  /**
   * Test {@link ForeignKey#equals(Object)}, and {@link ForeignKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForeignKey#equals(Object)}
   *   <li>{@link ForeignKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    ForeignKey foreignKey2 = new ForeignKey();

    // Act and Assert
    assertEquals(foreignKey, foreignKey2);
    int expectedHashCodeResult = foreignKey.hashCode();
    assertEquals(expectedHashCodeResult, foreignKey2.hashCode());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}, and {@link ForeignKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForeignKey#equals(Object)}
   *   <li>{@link ForeignKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey("name", "name");
    ForeignKey foreignKey2 = new ForeignKey("name", "name");

    // Act and Assert
    assertEquals(foreignKey, foreignKey2);
    int expectedHashCodeResult = foreignKey.hashCode();
    assertEquals(expectedHashCodeResult, foreignKey2.hashCode());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}, and {@link ForeignKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForeignKey#equals(Object)}
   *   <li>{@link ForeignKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey("name", "name", "name");
    ForeignKey foreignKey2 = new ForeignKey("name", "name", "name");

    // Act and Assert
    assertEquals(foreignKey, foreignKey2);
    int expectedHashCodeResult = foreignKey.hashCode();
    assertEquals(expectedHashCodeResult, foreignKey2.hashCode());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}, and {@link ForeignKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForeignKey#equals(Object)}
   *   <li>{@link ForeignKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setCurrentValue("42");

    ForeignKey foreignKey2 = new ForeignKey();
    foreignKey2.setCurrentValue("42");

    // Act and Assert
    assertEquals(foreignKey, foreignKey2);
    int expectedHashCodeResult = foreignKey.hashCode();
    assertEquals(expectedHashCodeResult, foreignKey2.hashCode());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}, and {@link ForeignKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForeignKey#equals(Object)}
   *   <li>{@link ForeignKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setSortField("name");

    ForeignKey foreignKey2 = new ForeignKey();
    foreignKey2.setSortField("name");

    // Act and Assert
    assertEquals(foreignKey, foreignKey2);
    int expectedHashCodeResult = foreignKey.hashCode();
    assertEquals(expectedHashCodeResult, foreignKey2.hashCode());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}, and {@link ForeignKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForeignKey#equals(Object)}
   *   <li>{@link ForeignKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setSortAscending(true);

    ForeignKey foreignKey2 = new ForeignKey();
    foreignKey2.setSortAscending(true);

    // Act and Assert
    assertEquals(foreignKey, foreignKey2);
    int expectedHashCodeResult = foreignKey.hashCode();
    assertEquals(expectedHashCodeResult, foreignKey2.hashCode());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}, and {@link ForeignKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForeignKey#equals(Object)}
   *   <li>{@link ForeignKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setOriginatingField("name");

    ForeignKey foreignKey2 = new ForeignKey();
    foreignKey2.setOriginatingField("name");

    // Act and Assert
    assertEquals(foreignKey, foreignKey2);
    int expectedHashCodeResult = foreignKey.hashCode();
    assertEquals(expectedHashCodeResult, foreignKey2.hashCode());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}, and {@link ForeignKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForeignKey#equals(Object)}
   *   <li>{@link ForeignKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    // Act and Assert
    assertEquals(foreignKey, foreignKey);
    int expectedHashCodeResult = foreignKey.hashCode();
    assertEquals(expectedHashCodeResult, foreignKey.hashCode());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey("name", "name");

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey("name", "name", "name");

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey("name", "name"));
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey("name", "name", "name"));
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setManyToField("name");

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setCurrentValue("42");

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setDisplayValueProperty("42");

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setSortField("name");

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setSortAscending(true);

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setOriginatingField("name");

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey("name", "name");

    ForeignKey foreignKey2 = new ForeignKey();
    foreignKey2.setForeignKeyClass("name");

    // Act and Assert
    assertNotEquals(foreignKey, foreignKey2);
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    ForeignKey foreignKey2 = new ForeignKey();
    foreignKey2.setManyToField("name");

    // Act and Assert
    assertNotEquals(foreignKey, foreignKey2);
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    ForeignKey foreignKey2 = new ForeignKey();
    foreignKey2.setCurrentValue("42");

    // Act and Assert
    assertNotEquals(foreignKey, foreignKey2);
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    ForeignKey foreignKey2 = new ForeignKey();
    foreignKey2.setSortField("name");

    // Act and Assert
    assertNotEquals(foreignKey, foreignKey2);
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    ForeignKey foreignKey2 = new ForeignKey();
    foreignKey2.setSortAscending(true);

    // Act and Assert
    assertNotEquals(foreignKey, foreignKey2);
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();

    ForeignKey foreignKey2 = new ForeignKey();
    foreignKey2.setOriginatingField("name");

    // Act and Assert
    assertNotEquals(foreignKey, foreignKey2);
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    ForeignKey foreignKey = new ForeignKey();
    foreignKey.setDisplayValueProperty(null);

    // Act and Assert
    assertNotEquals(foreignKey, new ForeignKey());
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ForeignKey(), null);
  }

  /**
   * Test {@link ForeignKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ForeignKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ForeignKey(), "Different type to ForeignKey");
  }
}
