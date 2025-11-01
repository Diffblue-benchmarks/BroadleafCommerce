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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldGroup.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class FieldGroupDiffblueTest {
  @Autowired
  private FieldGroup fieldGroup;

  /**
   * Method under test: {@link FieldGroup#removeListGrid(ListGrid)}
   */
  @Test
  public void testRemoveListGrid() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getAlternateOrdering()).thenReturn(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act
    fieldGroup.removeListGrid(new ListGrid());

    // Assert
    verify(field).getAlternateOrdering();
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroup()).getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible4() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible5() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setIsVisible(true);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible6() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible7() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible8() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(null);

    // Act and Assert
    assertFalse(fieldGroup.getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible9() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible10() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(field);

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible11() {
    // Arrange
    Field field = new Field();
    field.setOrder(0);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Method under test: {@link FieldGroup#getIsUntitled()}
   */
  @Test
  public void testGetIsUntitled() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroup()).getIsUntitled());
  }

  /**
   * Method under test: {@link FieldGroup#getIsUntitled()}
   */
  @Test
  public void testGetIsUntitled2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setIsUntitled(true);

    // Act and Assert
    assertTrue(fieldGroup.getIsUntitled());
  }

  /**
   * Method under test: {@link FieldGroup#getIsUntitled()}
   */
  @Test
  public void testGetIsUntitled3() {
    // Arrange
    HashMap<String, Object> groupAttributes = new HashMap<>();
    groupAttributes.computeIfPresent("foo", mock(BiFunction.class));

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setGroupAttributes(groupAttributes);

    // Act and Assert
    assertFalse(fieldGroup.getIsUntitled());
  }

  /**
   * Method under test: {@link FieldGroup#getCollapsed()}
   */
  @Test
  public void testGetCollapsed() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroup()).getCollapsed());
  }

  /**
   * Method under test: {@link FieldGroup#getCollapsed()}
   */
  @Test
  public void testGetCollapsed2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setCollapsed(true);

    // Act and Assert
    assertTrue(fieldGroup.getCollapsed());
  }

  /**
   * Method under test: {@link FieldGroup#getCollapsed()}
   */
  @Test
  public void testGetCollapsed3() {
    // Arrange
    HashMap<String, Object> groupAttributes = new HashMap<>();
    groupAttributes.computeIfPresent("foo", mock(BiFunction.class));

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setGroupAttributes(groupAttributes);

    // Act and Assert
    assertFalse(fieldGroup.getCollapsed());
  }

  /**
   * Method under test: {@link FieldGroup#getTitle()}
   */
  @Test
  public void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new FieldGroup()).getTitle());
  }

  /**
   * Method under test: {@link FieldGroup#getTitle()}
   */
  @Test
  public void testGetTitle2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setTitle("foo");
    fieldGroup.setKey(null);

    // Act and Assert
    assertEquals("foo", fieldGroup.getTitle());
  }

  /**
   * Method under test: {@link FieldGroup#withKey(String)}
   */
  @Test
  public void testWithKey() {
    // Arrange and Act
    FieldGroup actualWithKeyResult = fieldGroup.withKey("Key");

    // Assert
    assertEquals("Key", fieldGroup.getKey());
    assertTrue(fieldGroup.getFields().isEmpty());
    assertTrue(fieldGroup.getGroupItems().isEmpty());
    assertTrue(fieldGroup.getListGrids().isEmpty());
    assertTrue(fieldGroup.groupItems.isEmpty());
    assertSame(fieldGroup, actualWithKeyResult);
  }

  /**
   * Method under test: {@link FieldGroup#withTitle(String)}
   */
  @Test
  public void testWithTitle() {
    // Arrange and Act
    FieldGroup actualWithTitleResult = fieldGroup.withTitle("Dr");

    // Assert
    assertEquals("Dr", fieldGroup.getTitle());
    assertEquals("Dr", fieldGroup.title);
    assertTrue(fieldGroup.getFields().isEmpty());
    assertTrue(fieldGroup.getGroupItems().isEmpty());
    assertTrue(fieldGroup.getListGrids().isEmpty());
    assertTrue(fieldGroup.groupItems.isEmpty());
    assertSame(fieldGroup, actualWithTitleResult);
  }

  /**
   * Method under test: {@link FieldGroup#withOrder(Integer)}
   */
  @Test
  public void testWithOrder() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act
    FieldGroup actualWithOrderResult = fieldGroup.withOrder(1);

    // Assert
    assertEquals(1, fieldGroup.getOrder().intValue());
    assertTrue(fieldGroup.getFields().isEmpty());
    assertTrue(fieldGroup.getGroupItems().isEmpty());
    assertTrue(fieldGroup.getListGrids().isEmpty());
    assertTrue(fieldGroup.groupItems.isEmpty());
    assertSame(fieldGroup, actualWithOrderResult);
  }

  /**
   * Method under test: {@link FieldGroup#withOrder(Integer)}
   */
  @Test
  public void testWithOrder2() {
    // Arrange
    HashMap<String, Object> groupAttributes = new HashMap<>();
    groupAttributes.computeIfPresent("foo", mock(BiFunction.class));

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setGroupAttributes(groupAttributes);

    // Act
    FieldGroup actualWithOrderResult = fieldGroup.withOrder(1);

    // Assert
    assertEquals(1, fieldGroup.getOrder().intValue());
    assertTrue(fieldGroup.getFields().isEmpty());
    assertTrue(fieldGroup.getGroupItems().isEmpty());
    assertTrue(fieldGroup.getListGrids().isEmpty());
    assertTrue(fieldGroup.groupItems.isEmpty());
    assertSame(fieldGroup, actualWithOrderResult);
  }

  /**
   * Method under test: {@link FieldGroup#withCustomTemplate(String)}
   */
  @Test
  public void testWithCustomTemplate() {
    // Arrange and Act
    FieldGroup actualWithCustomTemplateResult = fieldGroup.withCustomTemplate("Custom Template");

    // Assert
    assertEquals("Custom Template", fieldGroup.getCustomTemplate());
    assertTrue(fieldGroup.getFields().isEmpty());
    assertTrue(fieldGroup.getGroupItems().isEmpty());
    assertTrue(fieldGroup.getListGrids().isEmpty());
    assertTrue(fieldGroup.groupItems.isEmpty());
    assertSame(fieldGroup, actualWithCustomTemplateResult);
  }

  /**
   * Method under test: {@link FieldGroup#addField(Field)}
   */
  @Test
  public void testAddField() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act
    boolean actualAddFieldResult = fieldGroup.addField(new Field());

    // Assert
    assertEquals(1, fieldGroup.getFields().size());
    assertEquals(1, fieldGroup.getGroupItems().size());
    assertEquals(1, fieldGroup.groupItems.size());
    assertTrue(fieldGroup.alternateOrderedGroupItems.isEmpty());
    assertTrue(actualAddFieldResult);
    assertTrue(fieldGroup.getIsVisible());
    assertTrue(fieldGroup.hasFieldOrListGrid());
  }

  /**
   * Method under test: {@link FieldGroup#addField(Field)}
   */
  @Test
  public void testAddField2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    Field field = new Field();
    field.setAlternateOrdering(true);

    // Act
    boolean actualAddFieldResult = fieldGroup.addField(field);

    // Assert
    assertEquals(1, fieldGroup.alternateOrderedGroupItems.size());
    assertTrue(fieldGroup.groupItems.isEmpty());
    assertTrue(actualAddFieldResult);
    assertTrue(fieldGroup.hasFieldOrListGrid());
  }

  /**
   * Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  public void testAddFields() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act
    fieldGroup.addFields(new HashSet<>());

    // Assert that nothing has changed
    assertFalse(fieldGroup.getIsVisible());
    assertFalse(fieldGroup.hasFieldOrListGrid());
    assertTrue(fieldGroup.getFields().isEmpty());
    assertTrue(fieldGroup.getGroupItems().isEmpty());
    assertTrue(fieldGroup.alternateOrderedGroupItems.isEmpty());
    assertTrue(fieldGroup.groupItems.isEmpty());
  }

  /**
   * Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  public void testAddFields2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    Field field = new Field();
    field.setAlternateOrdering(null);

    LinkedHashSet<Field> fields = new LinkedHashSet<>();
    fields.add(field);

    // Act
    fieldGroup.addFields(fields);

    // Assert
    assertEquals(1, fieldGroup.getFields().size());
    assertEquals(1, fieldGroup.getGroupItems().size());
    assertEquals(1, fieldGroup.groupItems.size());
    assertTrue(fieldGroup.alternateOrderedGroupItems.isEmpty());
    assertTrue(fieldGroup.getIsVisible());
    assertTrue(fieldGroup.hasFieldOrListGrid());
  }

  /**
   * Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  public void testAddFields3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    Field field = new Field();
    field.setAlternateOrdering(true);

    LinkedHashSet<Field> fields = new LinkedHashSet<>();
    fields.add(field);

    // Act
    fieldGroup.addFields(fields);

    // Assert
    assertEquals(1, fieldGroup.alternateOrderedGroupItems.size());
    assertTrue(fieldGroup.groupItems.isEmpty());
    assertTrue(fieldGroup.hasFieldOrListGrid());
  }

  /**
   * Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  public void testAddFields4() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    HashSet<Field> fields = new HashSet<>();
    fields.add(new Field());
    fields.add(new Field());

    // Act
    fieldGroup.addFields(fields);

    // Assert
    assertEquals(2, fieldGroup.groupItems.size());
    assertTrue(fieldGroup.alternateOrderedGroupItems.isEmpty());
    assertTrue(fieldGroup.getIsVisible());
    assertTrue(fieldGroup.hasFieldOrListGrid());
    assertEquals(fields, fieldGroup.getFields());
    Set<FieldGroupItem> expectedGroupItems = fieldGroup.groupItems;
    assertEquals(expectedGroupItems, fieldGroup.getGroupItems());
  }

  /**
   * Method under test: {@link FieldGroup#addListGrid(ListGrid)}
   */
  @Test
  public void testAddListGrid() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act
    fieldGroup.addListGrid(new ListGrid());

    // Assert
    assertEquals(1, fieldGroup.getGroupItems().size());
    assertEquals(1, fieldGroup.getListGrids().size());
    assertEquals(1, fieldGroup.groupItems.size());
    assertTrue(fieldGroup.getIsVisible());
    assertTrue(fieldGroup.hasFieldOrListGrid());
  }

  /**
   * Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  public void testRemoveField() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act and Assert
    assertFalse(fieldGroup.removeField(new Field()));
  }

  /**
   * Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  public void testRemoveField2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.removeField(new Field()));
  }

  /**
   * Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  public void testRemoveField3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.removeField(new Field()));
  }

  /**
   * Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  public void testRemoveField4() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    Field field = new Field();
    field.setAlternateOrdering(true);

    // Act and Assert
    assertFalse(fieldGroup.removeField(field));
  }

  /**
   * Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  public void testRemoveField5() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertFalse(fieldGroup.removeField(new Field()));
  }

  /**
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroup()).getGroupItems().isEmpty());
  }

  /**
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(fieldGroup.groupItems, fieldGroup.getGroupItems());
  }

  /**
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(fieldGroup.groupItems, fieldGroup.getGroupItems());
  }

  /**
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems4() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(fieldGroup.groupItems, fieldGroup.getGroupItems());
  }

  /**
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems5() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(2, fieldGroup.getGroupItems().size());
  }

  /**
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems6() {
    // Arrange
    Field field = new Field();
    field.setOrder(6);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(2, fieldGroup.getGroupItems().size());
  }

  /**
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems7() {
    // Arrange
    Field field = new Field();
    field.setOrder(0);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(2, fieldGroup.getGroupItems().size());
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(new Field()));
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(new Field()));
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(new Field()));
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField4() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(null));
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField5() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(new Field()));
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField6() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(null));
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  public void testFindFieldGroupItemByListGrid() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(new ListGrid()));
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  public void testFindFieldGroupItemByListGrid2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(new ListGrid()));
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  public void testFindFieldGroupItemByListGrid3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(new ListGrid()));
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  public void testFindFieldGroupItemByListGrid4() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(null));
  }

  /**
   * Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  public void testFindFieldGroupItemByListGrid5() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(new ListGrid()));
  }

  /**
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroup()).containsFieldData());
  }

  /**
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData4() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData5() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData6() {
    // Arrange
    Field field = new Field();
    field.setValue("42");

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertTrue(fieldGroup.containsFieldData());
  }

  /**
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData7() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData8() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(field);

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData9() {
    // Arrange
    Field field = new Field();
    field.setOrder(0);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Method under test: {@link FieldGroup#hasFieldOrListGrid()}
   */
  @Test
  public void testHasFieldOrListGrid() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroup()).hasFieldOrListGrid());
  }

  /**
   * Method under test: {@link FieldGroup#hasFieldOrListGrid()}
   */
  @Test
  public void testHasFieldOrListGrid2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.hasFieldOrListGrid());
  }

  /**
   * Method under test: {@link FieldGroup#hasFieldOrListGrid()}
   */
  @Test
  public void testHasFieldOrListGrid3() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertTrue(fieldGroup.hasFieldOrListGrid());
  }

  /**
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroup()).getFields().isEmpty());
  }

  /**
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(1, fieldGroup.getFields().size());
  }

  /**
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(2, fieldGroup.getFields().size());
  }

  /**
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields4() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(1, fieldGroup.getFields().size());
  }

  /**
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields5() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(3, fieldGroup.getFields().size());
  }

  /**
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields6() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertEquals(1, fieldGroup.getFields().size());
  }

  /**
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields7() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(field);

    // Act and Assert
    assertEquals(2, fieldGroup.getFields().size());
  }

  /**
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields8() {
    // Arrange
    Field field = new Field();
    field.setOrder(0);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertEquals(1, fieldGroup.getFields().size());
  }

  /**
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroup()).getListGrids().isEmpty());
  }

  /**
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids4() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(1, fieldGroup.getListGrids().size());
  }

  /**
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids5() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids6() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids7() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(field);

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids8() {
    // Arrange
    Field field = new Field();
    field.setOrder(0);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldGroup}
   *   <li>{@link FieldGroup#setCollapsed(Boolean)}
   *   <li>{@link FieldGroup#setColumn(Integer)}
   *   <li>{@link FieldGroup#setCustomTemplate(String)}
   *   <li>{@link FieldGroup#setGroupAttributes(Map)}
   *   <li>{@link FieldGroup#setGroupItems(Set)}
   *   <li>{@link FieldGroup#setIsUntitled(Boolean)}
   *   <li>{@link FieldGroup#setIsVisible(Boolean)}
   *   <li>{@link FieldGroup#setKey(String)}
   *   <li>{@link FieldGroup#setOrder(Integer)}
   *   <li>{@link FieldGroup#setTitle(String)}
   *   <li>{@link FieldGroup#setToolTip(String)}
   *   <li>{@link FieldGroup#getColumn()}
   *   <li>{@link FieldGroup#getCustomTemplate()}
   *   <li>{@link FieldGroup#getGroupAttributes()}
   *   <li>{@link FieldGroup#getKey()}
   *   <li>{@link FieldGroup#getOrder()}
   *   <li>{@link FieldGroup#getToolTip()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldGroup actualFieldGroup = new FieldGroup();
    actualFieldGroup.setCollapsed(true);
    actualFieldGroup.setColumn(1);
    actualFieldGroup.setCustomTemplate("Custom Template");
    HashMap<String, Object> groupAttributes = new HashMap<>();
    actualFieldGroup.setGroupAttributes(groupAttributes);
    actualFieldGroup.setGroupItems(new HashSet<>());
    actualFieldGroup.setIsUntitled(true);
    actualFieldGroup.setIsVisible(true);
    actualFieldGroup.setKey("Key");
    actualFieldGroup.setOrder(1);
    actualFieldGroup.setTitle("Dr");
    actualFieldGroup.setToolTip("127.0.0.1");
    Integer actualColumn = actualFieldGroup.getColumn();
    String actualCustomTemplate = actualFieldGroup.getCustomTemplate();
    Map<String, Object> actualGroupAttributes = actualFieldGroup.getGroupAttributes();
    String actualKey = actualFieldGroup.getKey();
    Integer actualOrder = actualFieldGroup.getOrder();
    actualFieldGroup.getToolTip();

    // Assert that nothing has changed
    assertEquals("Custom Template", actualCustomTemplate);
    assertEquals("Key", actualKey);
    assertEquals(1, actualColumn.intValue());
    assertEquals(1, actualOrder.intValue());
    assertTrue(actualGroupAttributes.isEmpty());
    assertTrue(actualFieldGroup.alternateOrderedGroupItems.isEmpty());
    assertTrue(actualFieldGroup.groupItems.isEmpty());
    assertSame(groupAttributes, actualGroupAttributes);
  }
}
