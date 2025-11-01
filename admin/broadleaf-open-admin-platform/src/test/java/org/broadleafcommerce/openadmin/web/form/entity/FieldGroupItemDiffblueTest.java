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
package org.broadleafcommerce.openadmin.web.form.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.junit.Test;

public class FieldGroupItemDiffblueTest {
  /**
   * Method under test: {@link FieldGroupItem#setField(Field)}
   */
  @Test
  public void testSetField() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    Field field = new Field();

    // Act
    fieldGroupItem.setField(field);

    // Assert
    assertEquals("FIELD", fieldGroupItem.getType());
    assertNull(fieldGroupItem.getOrder());
    assertFalse(fieldGroupItem.isListGrid());
    assertTrue(fieldGroupItem.isField());
    assertSame(field, fieldGroupItem.getField());
  }

  /**
   * Method under test: {@link FieldGroupItem#setCustomField(Field)}
   */
  @Test
  public void testSetCustomField() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    Field field = new Field();

    // Act
    fieldGroupItem.setCustomField(field);

    // Assert
    assertEquals("CUSTOM_FIELD", fieldGroupItem.getType());
    assertNull(fieldGroupItem.getOrder());
    assertFalse(fieldGroupItem.isListGrid());
    assertTrue(fieldGroupItem.isCustomField());
    assertSame(field, fieldGroupItem.getField());
  }

  /**
   * Method under test: {@link FieldGroupItem#setListGrid(ListGrid)}
   */
  @Test
  public void testSetListGrid() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(mock(ListGrid.class));
    ListGrid listGrid = new ListGrid();

    // Act
    fieldGroupItem.setListGrid(listGrid);

    // Assert
    assertSame(listGrid, fieldGroupItem.getListGrid());
  }

  /**
   * Method under test: {@link FieldGroupItem#isField()}
   */
  @Test
  public void testIsField() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroupItem(new ListGrid())).isField());
    assertTrue((new FieldGroupItem(new Field())).isField());
  }

  /**
   * Method under test: {@link FieldGroupItem#isListGrid()}
   */
  @Test
  public void testIsListGrid() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroupItem(new ListGrid())).isListGrid());
    assertFalse((new FieldGroupItem(new Field())).isListGrid());
  }

  /**
   * Method under test: {@link FieldGroupItem#isCustomField()}
   */
  @Test
  public void testIsCustomField() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroupItem(new ListGrid())).isCustomField());
  }

  /**
   * Method under test: {@link FieldGroupItem#isCustomField()}
   */
  @Test
  public void testIsCustomField2() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    fieldGroupItem.setType("CUSTOM_FIELD");

    // Act and Assert
    assertTrue(fieldGroupItem.isCustomField());
  }

  /**
   * Method under test: {@link FieldGroupItem#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(0, (new FieldGroupItem(new ListGrid())).getOrder().intValue());
    assertNull((new FieldGroupItem(new Field())).getOrder());
  }

  /**
   * Method under test: {@link FieldGroupItem#getOrder()}
   */
  @Test
  public void testGetOrder2() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    fieldGroupItem.setCustomField(new Field());

    // Act and Assert
    assertNull(fieldGroupItem.getOrder());
  }

  /**
   * Method under test: {@link FieldGroupItem#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName() {
    // Arrange, Act and Assert
    assertNull((new FieldGroupItem(new ListGrid())).getFriendlyName());
    assertNull((new FieldGroupItem(new Field())).getFriendlyName());
  }

  /**
   * Method under test: {@link FieldGroupItem#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName2() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    fieldGroupItem.setCustomField(new Field());

    // Act and Assert
    assertNull(fieldGroupItem.getFriendlyName());
  }

  /**
   * Method under test: {@link FieldGroupItem#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull((new FieldGroupItem(new ListGrid())).getName());
    assertNull((new FieldGroupItem(new Field())).getName());
  }

  /**
   * Method under test: {@link FieldGroupItem#getName()}
   */
  @Test
  public void testGetName2() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    fieldGroupItem.setCustomField(new Field());

    // Act and Assert
    assertNull(fieldGroupItem.getName());
  }

  /**
   * Method under test: {@link FieldGroupItem#isVisible()}
   */
  @Test
  public void testIsVisible() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroupItem(new ListGrid())).isVisible());
    assertFalse((new FieldGroupItem((ListGrid) null)).isVisible());
    assertTrue((new FieldGroupItem(new Field())).isVisible());
  }

  /**
   * Method under test: {@link FieldGroupItem#isVisible()}
   */
  @Test
  public void testIsVisible2() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    fieldGroupItem.setCustomField(new Field());

    // Act and Assert
    assertTrue(fieldGroupItem.isVisible());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldGroupItem#setType(String)}
   *   <li>{@link FieldGroupItem#getField()}
   *   <li>{@link FieldGroupItem#getListGrid()}
   *   <li>{@link FieldGroupItem#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    FieldGroupItem fieldGroupItem = new FieldGroupItem(listGrid);

    // Act
    fieldGroupItem.setType("Type");
    fieldGroupItem.getField();
    ListGrid actualListGrid = fieldGroupItem.getListGrid();

    // Assert that nothing has changed
    assertEquals("Type", fieldGroupItem.getType());
    assertSame(listGrid, actualListGrid);
  }

  /**
   * Method under test: {@link FieldGroupItem#FieldGroupItem(ListGrid)}
   */
  @Test
  public void testNewFieldGroupItem() {
    // Arrange
    ListGrid listGrid = new ListGrid();

    // Act
    FieldGroupItem actualFieldGroupItem = new FieldGroupItem(listGrid);

    // Assert
    assertEquals("LISTGRID", actualFieldGroupItem.getType());
    assertNull(actualFieldGroupItem.getFriendlyName());
    assertNull(actualFieldGroupItem.getName());
    assertNull(actualFieldGroupItem.getField());
    assertEquals(0, actualFieldGroupItem.getOrder().intValue());
    assertFalse(actualFieldGroupItem.isCustomField());
    assertFalse(actualFieldGroupItem.isField());
    assertTrue(actualFieldGroupItem.isListGrid());
    assertSame(listGrid, actualFieldGroupItem.getListGrid());
  }

  /**
   * Method under test: {@link FieldGroupItem#FieldGroupItem(Field)}
   */
  @Test
  public void testNewFieldGroupItem2() {
    // Arrange
    Field field = new Field();

    // Act
    FieldGroupItem actualFieldGroupItem = new FieldGroupItem(field);

    // Assert
    assertEquals("FIELD", actualFieldGroupItem.getType());
    assertNull(actualFieldGroupItem.getOrder());
    assertNull(actualFieldGroupItem.getFriendlyName());
    assertNull(actualFieldGroupItem.getName());
    assertNull(actualFieldGroupItem.getListGrid());
    assertFalse(actualFieldGroupItem.isCustomField());
    assertFalse(actualFieldGroupItem.isListGrid());
    assertTrue(actualFieldGroupItem.isField());
    assertSame(field, actualFieldGroupItem.getField());
  }
}
