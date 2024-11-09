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
   * Test {@link FieldGroupItem#FieldGroupItem(ListGrid)}.
   * <p>
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
   * Test {@link FieldGroupItem#FieldGroupItem(Field)}.
   * <p>
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

  /**
   * Test getters and setters.
   * <p>
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
   * Test {@link FieldGroupItem#setField(Field)}.
   * <p>
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
   * Test {@link FieldGroupItem#setCustomField(Field)}.
   * <p>
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
   * Test {@link FieldGroupItem#setListGrid(ListGrid)}.
   * <ul>
   *   <li>Then {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor) ListGrid is {@link ListGrid} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#setListGrid(ListGrid)}
   */
  @Test
  public void testSetListGrid_thenFieldGroupItemWithListGridIsListGridListGridIsListGrid() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    ListGrid listGrid = new ListGrid();

    // Act
    fieldGroupItem.setListGrid(listGrid);

    // Assert
    assertSame(listGrid, fieldGroupItem.getListGrid());
  }

  /**
   * Test {@link FieldGroupItem#setListGrid(ListGrid)}.
   * <ul>
   *   <li>Then {@link FieldGroupItem#FieldGroupItem(ListGrid)} with
   * {@link ListGrid} ListGrid is {@link ListGrid} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#setListGrid(ListGrid)}
   */
  @Test
  public void testSetListGrid_thenFieldGroupItemWithListGridListGridIsListGrid() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(mock(ListGrid.class));
    ListGrid listGrid = new ListGrid();

    // Act
    fieldGroupItem.setListGrid(listGrid);

    // Assert
    assertSame(listGrid, fieldGroupItem.getListGrid());
  }

  /**
   * Test {@link FieldGroupItem#isField()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(Field)} with field is
   * {@link Field} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#isField()}
   */
  @Test
  public void testIsField_givenFieldGroupItemWithFieldIsField_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroupItem(new Field())).isField());
  }

  /**
   * Test {@link FieldGroupItem#isField()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#isField()}
   */
  @Test
  public void testIsField_givenFieldGroupItemWithListGridIsListGrid_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroupItem(new ListGrid())).isField());
  }

  /**
   * Test {@link FieldGroupItem#isListGrid()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(Field)} with field is
   * {@link Field} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#isListGrid()}
   */
  @Test
  public void testIsListGrid_givenFieldGroupItemWithFieldIsField_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroupItem(new Field())).isListGrid());
  }

  /**
   * Test {@link FieldGroupItem#isListGrid()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#isListGrid()}
   */
  @Test
  public void testIsListGrid_givenFieldGroupItemWithListGridIsListGrid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroupItem(new ListGrid())).isListGrid());
  }

  /**
   * Test {@link FieldGroupItem#isCustomField()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#isCustomField()}
   */
  @Test
  public void testIsCustomField_givenFieldGroupItemWithListGridIsListGrid_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroupItem(new ListGrid())).isCustomField());
  }

  /**
   * Test {@link FieldGroupItem#isCustomField()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#isCustomField()}
   */
  @Test
  public void testIsCustomField_thenReturnTrue() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    fieldGroupItem.setType("CUSTOM_FIELD");

    // Act and Assert
    assertTrue(fieldGroupItem.isCustomField());
  }

  /**
   * Test {@link FieldGroupItem#getOrder()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(Field)} with field is
   * {@link Field} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#getOrder()}
   */
  @Test
  public void testGetOrder_givenFieldGroupItemWithFieldIsField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FieldGroupItem(new Field())).getOrder());
  }

  /**
   * Test {@link FieldGroupItem#getOrder()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor) CustomField is {@link Field} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#getOrder()}
   */
  @Test
  public void testGetOrder_givenFieldGroupItemWithListGridIsListGridCustomFieldIsField() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    fieldGroupItem.setCustomField(new Field());

    // Act and Assert
    assertNull(fieldGroupItem.getOrder());
  }

  /**
   * Test {@link FieldGroupItem#getOrder()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#getOrder()}
   */
  @Test
  public void testGetOrder_givenFieldGroupItemWithListGridIsListGrid_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new FieldGroupItem(new ListGrid())).getOrder().intValue());
  }

  /**
   * Test {@link FieldGroupItem#getFriendlyName()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(Field)} with field is
   * {@link Field} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName_givenFieldGroupItemWithFieldIsField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FieldGroupItem(new Field())).getFriendlyName());
  }

  /**
   * Test {@link FieldGroupItem#getFriendlyName()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor) CustomField is {@link Field} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName_givenFieldGroupItemWithListGridIsListGridCustomFieldIsField() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    fieldGroupItem.setCustomField(new Field());

    // Act and Assert
    assertNull(fieldGroupItem.getFriendlyName());
  }

  /**
   * Test {@link FieldGroupItem#getFriendlyName()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName_givenFieldGroupItemWithListGridIsListGrid_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FieldGroupItem(new ListGrid())).getFriendlyName());
  }

  /**
   * Test {@link FieldGroupItem#getName()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(Field)} with field is
   * {@link Field} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#getName()}
   */
  @Test
  public void testGetName_givenFieldGroupItemWithFieldIsField_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FieldGroupItem(new Field())).getName());
  }

  /**
   * Test {@link FieldGroupItem#getName()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor) CustomField is {@link Field} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#getName()}
   */
  @Test
  public void testGetName_givenFieldGroupItemWithListGridIsListGridCustomFieldIsField() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    fieldGroupItem.setCustomField(new Field());

    // Act and Assert
    assertNull(fieldGroupItem.getName());
  }

  /**
   * Test {@link FieldGroupItem#getName()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#getName()}
   */
  @Test
  public void testGetName_givenFieldGroupItemWithListGridIsListGrid_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FieldGroupItem(new ListGrid())).getName());
  }

  /**
   * Test {@link FieldGroupItem#isVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(Field)} with field is
   * {@link Field} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#isVisible()}
   */
  @Test
  public void testIsVisible_givenFieldGroupItemWithFieldIsField_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroupItem(new Field())).isVisible());
  }

  /**
   * Test {@link FieldGroupItem#isVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor) CustomField is {@link Field} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#isVisible()}
   */
  @Test
  public void testIsVisible_givenFieldGroupItemWithListGridIsListGridCustomFieldIsField() {
    // Arrange
    FieldGroupItem fieldGroupItem = new FieldGroupItem(new ListGrid());
    fieldGroupItem.setCustomField(new Field());

    // Act and Assert
    assertTrue(fieldGroupItem.isVisible());
  }

  /**
   * Test {@link FieldGroupItem#isVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#isVisible()}
   */
  @Test
  public void testIsVisible_givenFieldGroupItemWithListGridIsListGrid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroupItem(new ListGrid())).isVisible());
  }

  /**
   * Test {@link FieldGroupItem#isVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroupItem#FieldGroupItem(ListGrid)} with listGrid is
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroupItem#isVisible()}
   */
  @Test
  public void testIsVisible_givenFieldGroupItemWithListGridIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroupItem((ListGrid) null)).isVisible());
  }
}
