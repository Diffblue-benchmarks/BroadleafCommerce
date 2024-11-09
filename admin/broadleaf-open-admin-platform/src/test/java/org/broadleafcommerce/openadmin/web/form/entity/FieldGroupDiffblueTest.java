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
   * Test {@link FieldGroup#removeListGrid(ListGrid)}.
   * <ul>
   *   <li>Then calls {@link Field#getAlternateOrdering()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#removeListGrid(ListGrid)}
   */
  @Test
  public void testRemoveListGrid_thenCallsGetAlternateOrdering() {
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
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldGroupAddFieldField_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldGroupAddFieldField_thenReturnTrue2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldGroupAddFieldField_thenReturnTrue3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldGroupAddListGridListGrid_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldGroupAddListGridListGrid_thenReturnTrue2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldGroupAddListGridNull_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(null);

    // Act and Assert
    assertFalse(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) IsVisible is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldGroupIsVisibleIsTrue_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setIsVisible(true);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroup()).getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldOrderIsOne_thenReturnTrue() {
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
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldOrderIsOne_thenReturnTrue2() {
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
   * Test {@link FieldGroup#getIsVisible()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenFieldOrderIsZero_thenReturnTrue() {
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
   * Test {@link FieldGroup#getIsUntitled()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) IsUntitled is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsUntitled()}
   */
  @Test
  public void testGetIsUntitled_givenFieldGroupIsUntitledIsTrue_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setIsUntitled(true);

    // Act and Assert
    assertTrue(fieldGroup.getIsUntitled());
  }

  /**
   * Test {@link FieldGroup#getIsUntitled()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsUntitled()}
   */
  @Test
  public void testGetIsUntitled_givenFieldGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroup()).getIsUntitled());
  }

  /**
   * Test {@link FieldGroup#getIsUntitled()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getIsUntitled()}
   */
  @Test
  public void testGetIsUntitled_givenHashMapComputeIfPresentFooAndBiFunction_thenReturnFalse() {
    // Arrange
    HashMap<String, Object> groupAttributes = new HashMap<>();
    groupAttributes.computeIfPresent("foo", mock(BiFunction.class));

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setGroupAttributes(groupAttributes);

    // Act and Assert
    assertFalse(fieldGroup.getIsUntitled());
  }

  /**
   * Test {@link FieldGroup#getCollapsed()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) Collapsed is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getCollapsed()}
   */
  @Test
  public void testGetCollapsed_givenFieldGroupCollapsedIsTrue_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setCollapsed(true);

    // Act and Assert
    assertTrue(fieldGroup.getCollapsed());
  }

  /**
   * Test {@link FieldGroup#getCollapsed()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getCollapsed()}
   */
  @Test
  public void testGetCollapsed_givenFieldGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroup()).getCollapsed());
  }

  /**
   * Test {@link FieldGroup#getCollapsed()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getCollapsed()}
   */
  @Test
  public void testGetCollapsed_givenHashMapComputeIfPresentFooAndBiFunction_thenReturnFalse() {
    // Arrange
    HashMap<String, Object> groupAttributes = new HashMap<>();
    groupAttributes.computeIfPresent("foo", mock(BiFunction.class));

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setGroupAttributes(groupAttributes);

    // Act and Assert
    assertFalse(fieldGroup.getCollapsed());
  }

  /**
   * Test {@link FieldGroup#getTitle()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) Title is {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getTitle()}
   */
  @Test
  public void testGetTitle_givenFieldGroupTitleIsFoo_thenReturnFoo() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setTitle("foo");
    fieldGroup.setKey(null);

    // Act and Assert
    assertEquals("foo", fieldGroup.getTitle());
  }

  /**
   * Test {@link FieldGroup#getTitle()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getTitle()}
   */
  @Test
  public void testGetTitle_givenFieldGroup_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FieldGroup()).getTitle());
  }

  /**
   * Test {@link FieldGroup#withKey(String)}.
   * <p>
   * Method under test: {@link FieldGroup#withKey(String)}
   */
  @Test
  public void testWithKey() {
    // Arrange and Act
    FieldGroup actualWithKeyResult = fieldGroup.withKey("Key");

    // Assert
    assertEquals("Key", fieldGroup.getKey());
    assertSame(fieldGroup, actualWithKeyResult);
  }

  /**
   * Test {@link FieldGroup#withTitle(String)}.
   * <p>
   * Method under test: {@link FieldGroup#withTitle(String)}
   */
  @Test
  public void testWithTitle() {
    // Arrange and Act
    FieldGroup actualWithTitleResult = fieldGroup.withTitle("Dr");

    // Assert
    assertEquals("Dr", fieldGroup.getTitle());
    assertEquals("Dr", fieldGroup.title);
    assertSame(fieldGroup, actualWithTitleResult);
  }

  /**
   * Test {@link FieldGroup#withOrder(Integer)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#withOrder(Integer)}
   */
  @Test
  public void testWithOrder_givenFieldGroup() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act
    FieldGroup actualWithOrderResult = fieldGroup.withOrder(1);

    // Assert
    assertEquals(1, fieldGroup.getOrder().intValue());
    assertSame(fieldGroup, actualWithOrderResult);
  }

  /**
   * Test {@link FieldGroup#withOrder(Integer)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#withOrder(Integer)}
   */
  @Test
  public void testWithOrder_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, Object> groupAttributes = new HashMap<>();
    groupAttributes.computeIfPresent("foo", mock(BiFunction.class));

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setGroupAttributes(groupAttributes);

    // Act
    FieldGroup actualWithOrderResult = fieldGroup.withOrder(1);

    // Assert
    assertEquals(1, fieldGroup.getOrder().intValue());
    assertSame(fieldGroup, actualWithOrderResult);
  }

  /**
   * Test {@link FieldGroup#withCustomTemplate(String)}.
   * <p>
   * Method under test: {@link FieldGroup#withCustomTemplate(String)}
   */
  @Test
  public void testWithCustomTemplate() {
    // Arrange and Act
    FieldGroup actualWithCustomTemplateResult = fieldGroup.withCustomTemplate("Custom Template");

    // Assert
    assertEquals("Custom Template", fieldGroup.getCustomTemplate());
    assertSame(fieldGroup, actualWithCustomTemplateResult);
  }

  /**
   * Test {@link FieldGroup#addField(Field)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then {@link FieldGroup} (default constructor)
   * {@link FieldGroup#alternateOrderedGroupItems} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#addField(Field)}
   */
  @Test
  public void testAddField_givenTrue_thenFieldGroupAlternateOrderedGroupItemsSizeIsOne() {
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
   * Test {@link FieldGroup#addField(Field)}.
   * <ul>
   *   <li>When {@link Field} (default constructor).</li>
   *   <li>Then {@link FieldGroup} (default constructor) Fields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#addField(Field)}
   */
  @Test
  public void testAddField_whenField_thenFieldGroupFieldsSizeIsOne() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act
    fieldGroup.addField(new Field());

    // Assert
    assertEquals(1, fieldGroup.getFields().size());
    assertEquals(1, fieldGroup.getGroupItems().size());
    assertEquals(1, fieldGroup.groupItems.size());
    assertTrue(fieldGroup.alternateOrderedGroupItems.isEmpty());
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#addFields(Set)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()} add {@link Field} (default
   * constructor).</li>
   *   <li>Then {@link FieldGroup} (default constructor)
   * {@link FieldGroup#groupItems} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  public void testAddFields_givenField_whenHashSetAddField_thenFieldGroupGroupItemsSizeIsTwo() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    HashSet<Field> fields = new HashSet<>();
    fields.add(new Field());
    fields.add(new Field());

    // Act
    fieldGroup.addFields(fields);

    // Assert
    assertEquals(2, fieldGroup.groupItems.size());
    assertTrue(fieldGroup.getIsVisible());
    assertEquals(fields, fieldGroup.getFields());
    Set<FieldGroupItem> expectedGroupItems = fieldGroup.groupItems;
    assertEquals(expectedGroupItems, fieldGroup.getGroupItems());
  }

  /**
   * Test {@link FieldGroup#addFields(Set)}.
   * <ul>
   *   <li>Then {@link FieldGroup} (default constructor)
   * {@link FieldGroup#alternateOrderedGroupItems} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  public void testAddFields_thenFieldGroupAlternateOrderedGroupItemsSizeIsOne() {
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
   * Test {@link FieldGroup#addFields(Set)}.
   * <ul>
   *   <li>Then {@link FieldGroup} (default constructor) GroupItems size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  public void testAddFields_thenFieldGroupGroupItemsSizeIsOne() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    Field field = new Field();
    field.setAlternateOrdering(null);

    LinkedHashSet<Field> fields = new LinkedHashSet<>();
    fields.add(field);

    // Act
    fieldGroup.addFields(fields);

    // Assert
    assertEquals(1, fieldGroup.getGroupItems().size());
    assertEquals(1, fieldGroup.groupItems.size());
    assertTrue(fieldGroup.getIsVisible());
    assertEquals(fields, fieldGroup.getFields());
  }

  /**
   * Test {@link FieldGroup#addFields(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then not {@link FieldGroup} (default constructor) IsVisible.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  public void testAddFields_whenHashSet_thenNotFieldGroupIsVisible() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act
    fieldGroup.addFields(new HashSet<>());

    // Assert that nothing has changed
    assertFalse(fieldGroup.getIsVisible());
    assertFalse(fieldGroup.hasFieldOrListGrid());
    assertTrue(fieldGroup.getFields().isEmpty());
    assertTrue(fieldGroup.getGroupItems().isEmpty());
  }

  /**
   * Test {@link FieldGroup#addListGrid(ListGrid)}.
   * <p>
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
   * Test {@link FieldGroup#removeField(Field)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) AlternateOrdering is
   * {@code true}.</li>
   *   <li>When {@link Field} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  public void testRemoveField_givenFieldAlternateOrderingIsTrue_whenField_thenReturnFalse() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertFalse(fieldGroup.removeField(new Field()));
  }

  /**
   * Test {@link FieldGroup#removeField(Field)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>When {@link Field} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  public void testRemoveField_givenFieldGroupAddFieldField_whenField_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.removeField(new Field()));
  }

  /**
   * Test {@link FieldGroup#removeField(Field)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   *   <li>When {@link Field} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  public void testRemoveField_givenFieldGroupAddListGridListGrid_whenField_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.removeField(new Field()));
  }

  /**
   * Test {@link FieldGroup#removeField(Field)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>When {@link Field} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  public void testRemoveField_givenFieldGroup_whenField_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act and Assert
    assertFalse(fieldGroup.removeField(new Field()));
  }

  /**
   * Test {@link FieldGroup#removeField(Field)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Field} (default constructor) AlternateOrdering is
   * {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  public void testRemoveField_givenTrue_whenFieldAlternateOrderingIsTrue_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    Field field = new Field();
    field.setAlternateOrdering(true);

    // Act and Assert
    assertFalse(fieldGroup.removeField(field));
  }

  /**
   * Test {@link FieldGroup#getGroupItems()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return {@link FieldGroup} (default constructor)
   * {@link FieldGroup#groupItems}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems_givenFieldGroupAddFieldField_thenReturnFieldGroupGroupItems() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(fieldGroup.groupItems, fieldGroup.getGroupItems());
  }

  /**
   * Test {@link FieldGroup#getGroupItems()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return {@link FieldGroup} (default constructor)
   * {@link FieldGroup#groupItems}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems_givenFieldGroupAddFieldField_thenReturnFieldGroupGroupItems2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(fieldGroup.groupItems, fieldGroup.getGroupItems());
  }

  /**
   * Test {@link FieldGroup#getGroupItems()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems_givenFieldGroupAddListGridListGrid() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(fieldGroup.groupItems, fieldGroup.getGroupItems());
  }

  /**
   * Test {@link FieldGroup#getGroupItems()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems_givenFieldGroup_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroup()).getGroupItems().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getGroupItems()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems_givenFieldOrderIsOne_thenReturnSizeIsTwo() {
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
   * Test {@link FieldGroup#getGroupItems()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is six.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems_givenFieldOrderIsSix_thenReturnSizeIsTwo() {
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
   * Test {@link FieldGroup#getGroupItems()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is zero.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  public void testGetGroupItems_givenFieldOrderIsZero_thenReturnSizeIsTwo() {
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
   * Test {@link FieldGroup#findFieldGroupItemByField(Field)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) AlternateOrdering is
   * {@code true}.</li>
   *   <li>When {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField_givenFieldAlternateOrderingIsTrue_whenField() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(new Field()));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByField(Field)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) AlternateOrdering is
   * {@code true}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField_givenFieldAlternateOrderingIsTrue_whenNull() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(null));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByField(Field)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>When {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField_givenFieldGroupAddFieldField_whenField() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(new Field()));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByField(Field)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField_givenFieldGroupAddFieldField_whenNull() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(null));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByField(Field)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   *   <li>When {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField_givenFieldGroupAddListGridListGrid_whenField() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(new Field()));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByField(Field)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>When {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  public void testFindFieldGroupItemByField_givenFieldGroup_whenField() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(new Field()));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) AlternateOrdering is
   * {@code true}.</li>
   *   <li>When {@link ListGrid} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  public void testFindFieldGroupItemByListGrid_givenFieldAlternateOrderingIsTrue_whenListGrid() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(new ListGrid()));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>When {@link ListGrid} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  public void testFindFieldGroupItemByListGrid_givenFieldGroupAddFieldField_whenListGrid() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(new ListGrid()));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   *   <li>When {@link ListGrid} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  public void testFindFieldGroupItemByListGrid_givenFieldGroupAddListGridListGrid_whenListGrid() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(new ListGrid()));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  public void testFindFieldGroupItemByListGrid_givenFieldGroupAddListGridListGrid_whenNull() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(null));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>When {@link ListGrid} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  public void testFindFieldGroupItemByListGrid_givenFieldGroup_whenListGrid() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(new ListGrid()));
  }

  /**
   * Test {@link FieldGroup#containsFieldData()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData_givenFieldGroupAddFieldField_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Test {@link FieldGroup#containsFieldData()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData_givenFieldGroupAddFieldField_thenReturnFalse2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Test {@link FieldGroup#containsFieldData()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData_givenFieldGroupAddFieldField_thenReturnFalse3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Test {@link FieldGroup#containsFieldData()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData_givenFieldGroupAddListGridListGrid_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Test {@link FieldGroup#containsFieldData()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData_givenFieldGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroup()).containsFieldData());
  }

  /**
   * Test {@link FieldGroup#containsFieldData()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData_givenFieldOrderIsOne_thenReturnFalse() {
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
   * Test {@link FieldGroup#containsFieldData()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData_givenFieldOrderIsOne_thenReturnFalse2() {
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
   * Test {@link FieldGroup#containsFieldData()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData_givenFieldOrderIsZero_thenReturnFalse() {
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
   * Test {@link FieldGroup#containsFieldData()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  public void testContainsFieldData_givenFieldValueIs42_thenReturnTrue() {
    // Arrange
    Field field = new Field();
    field.setValue("42");

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertTrue(fieldGroup.containsFieldData());
  }

  /**
   * Test {@link FieldGroup#hasFieldOrListGrid()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) AlternateOrdering is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#hasFieldOrListGrid()}
   */
  @Test
  public void testHasFieldOrListGrid_givenFieldAlternateOrderingIsTrue_thenReturnTrue() {
    // Arrange
    Field field = new Field();
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);

    // Act and Assert
    assertTrue(fieldGroup.hasFieldOrListGrid());
  }

  /**
   * Test {@link FieldGroup#hasFieldOrListGrid()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#hasFieldOrListGrid()}
   */
  @Test
  public void testHasFieldOrListGrid_givenFieldGroupAddFieldField_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.hasFieldOrListGrid());
  }

  /**
   * Test {@link FieldGroup#hasFieldOrListGrid()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#hasFieldOrListGrid()}
   */
  @Test
  public void testHasFieldOrListGrid_givenFieldGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldGroup()).hasFieldOrListGrid());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields_givenFieldGroupAddFieldField_thenReturnSizeIsOne() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(1, fieldGroup.getFields().size());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields_givenFieldGroupAddFieldField_thenReturnSizeIsThree() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(3, fieldGroup.getFields().size());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields_givenFieldGroupAddFieldField_thenReturnSizeIsTwo() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(2, fieldGroup.getFields().size());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields_givenFieldGroupAddListGridListGrid_thenReturnSizeIsOne() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(1, fieldGroup.getFields().size());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields_givenFieldGroup_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroup()).getFields().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields_givenFieldOrderIsOne_thenReturnSizeIsOne() {
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
   * Test {@link FieldGroup#getFields()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields_givenFieldOrderIsOne_thenReturnSizeIsTwo() {
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
   * Test {@link FieldGroup#getFields()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is zero.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  public void testGetFields_givenFieldOrderIsZero_thenReturnSizeIsOne() {
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
   * Test {@link FieldGroup#getListGrids()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids_givenFieldGroupAddFieldField_thenReturnEmpty() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getListGrids()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids_givenFieldGroupAddFieldField_thenReturnEmpty2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getListGrids()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids_givenFieldGroupAddFieldField_thenReturnEmpty3() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getListGrids()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids_givenFieldGroupAddListGridListGrid_thenReturnSizeIsOne() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(1, fieldGroup.getListGrids().size());
  }

  /**
   * Test {@link FieldGroup#getListGrids()}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids_givenFieldGroup_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new FieldGroup()).getListGrids().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getListGrids()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids_givenFieldOrderIsOne_thenReturnEmpty() {
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
   * Test {@link FieldGroup#getListGrids()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids_givenFieldOrderIsOne_thenReturnEmpty2() {
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
   * Test {@link FieldGroup#getListGrids()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is zero.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  public void testGetListGrids_givenFieldOrderIsZero_thenReturnEmpty() {
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
   * Test getters and setters.
   * <p>
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
