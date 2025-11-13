package org.broadleafcommerce.openadmin.web.form.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldGroup.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldGroupDiffblueTest {
  @Autowired private FieldGroup fieldGroup;

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
  public void testGetIsVisible_givenFieldGroupAddFieldField_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
  public void testGetIsVisible_givenFieldGroupAddListGridListGrid_thenReturnTrue2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
  public void testGetIsVisible_givenFieldGroupAddListGridNull_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(null);

    // Act and Assert
    assertFalse(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) IsVisible is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
  public void testGetIsVisible_givenFieldGroupIsVisibleIsTrue_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setIsVisible(true);

    // Act and Assert
    assertTrue(fieldGroup.getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
  public void testGetIsVisible_givenFieldGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FieldGroup().getIsVisible());
  }

  /**
   * Test {@link FieldGroup#getIsVisible()}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsVisible()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsVisible()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) IsUntitled is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsUntitled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsUntitled()"})
  public void testGetIsUntitled_givenFieldGroupIsUntitledIsTrue_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setIsUntitled(true);

    // Act and Assert
    assertTrue(fieldGroup.getIsUntitled());
  }

  /**
   * Test {@link FieldGroup#getIsUntitled()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getIsUntitled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getIsUntitled()"})
  public void testGetIsUntitled_givenFieldGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FieldGroup().getIsUntitled());
  }

  /**
   * Test {@link FieldGroup#getCollapsed()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) Collapsed is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getCollapsed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getCollapsed()"})
  public void testGetCollapsed_givenFieldGroupCollapsedIsTrue_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setCollapsed(true);

    // Act and Assert
    assertTrue(fieldGroup.getCollapsed());
  }

  /**
   * Test {@link FieldGroup#getCollapsed()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getCollapsed()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldGroup.getCollapsed()"})
  public void testGetCollapsed_givenFieldGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FieldGroup().getCollapsed());
  }

  /**
   * Test {@link FieldGroup#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) Title is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getTitle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FieldGroup.getTitle()"})
  public void testGetTitle_givenFieldGroupTitleIsFoo_thenReturnFoo() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.setTitle("foo");
    fieldGroup.setKey("foo");

    // Act and Assert
    assertEquals("foo", fieldGroup.getTitle());
  }

  /**
   * Test {@link FieldGroup#getTitle()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getTitle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FieldGroup.getTitle()"})
  public void testGetTitle_givenFieldGroup_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FieldGroup().getTitle());
  }

  /**
   * Test {@link FieldGroup#withKey(String)}.
   *
   * <p>Method under test: {@link FieldGroup#withKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroup FieldGroup.withKey(String)"})
  public void testWithKey() {
    // Arrange and Act
    FieldGroup actualWithKeyResult = fieldGroup.withKey("Key");

    // Assert
    assertEquals("Key", fieldGroup.getKey());
    assertSame(fieldGroup, actualWithKeyResult);
  }

  /**
   * Test {@link FieldGroup#withTitle(String)}.
   *
   * <p>Method under test: {@link FieldGroup#withTitle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroup FieldGroup.withTitle(String)"})
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
   *
   * <p>Method under test: {@link FieldGroup#withOrder(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroup FieldGroup.withOrder(Integer)"})
  public void testWithOrder() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act
    FieldGroup actualWithOrderResult = fieldGroup.withOrder(1);

    // Assert
    assertEquals(1, fieldGroup.getOrder().intValue());
    assertSame(fieldGroup, actualWithOrderResult);
  }

  /**
   * Test {@link FieldGroup#withCustomTemplate(String)}.
   *
   * <p>Method under test: {@link FieldGroup#withCustomTemplate(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroup FieldGroup.withCustomTemplate(String)"})
  public void testWithCustomTemplate() {
    // Arrange and Act
    FieldGroup actualWithCustomTemplateResult = fieldGroup.withCustomTemplate("Custom Template");

    // Assert
    assertEquals("Custom Template", fieldGroup.getCustomTemplate());
    assertSame(fieldGroup, actualWithCustomTemplateResult);
  }

  /**
   * Test {@link FieldGroup#addField(Field)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then {@link FieldGroup} (default constructor) {@link
   *       FieldGroup#alternateOrderedGroupItems} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#addField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.addField(Field)"})
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
   *
   * <ul>
   *   <li>When {@link Field} (default constructor).
   *   <li>Then {@link FieldGroup} (default constructor) Fields size is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#addField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.addField(Field)"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor).
   *   <li>When {@link HashSet#HashSet()} add {@link Field} (default constructor).
   *   <li>Then {@link FieldGroup} (default constructor) {@link FieldGroup#groupItems} size is two.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldGroup.addFields(Set)"})
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
   *
   * <ul>
   *   <li>Then {@link FieldGroup} (default constructor) {@link
   *       FieldGroup#alternateOrderedGroupItems} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldGroup.addFields(Set)"})
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
   *
   * <ul>
   *   <li>Then {@link FieldGroup} (default constructor) GroupItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldGroup.addFields(Set)"})
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
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then not {@link FieldGroup} (default constructor) IsVisible.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#addFields(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldGroup.addFields(Set)"})
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
   *
   * <p>Method under test: {@link FieldGroup#addListGrid(ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldGroup.addListGrid(ListGrid)"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) AlternateOrdering is {@code true}.
   *   <li>When {@link Field} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.removeField(Field)"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>When {@link Field} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.removeField(Field)"})
  public void testRemoveField_givenFieldGroupAddFieldField_whenField_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.removeField(new Field()));
  }

  /**
   * Test {@link FieldGroup#removeField(Field)}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   *   <li>When {@link Field} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.removeField(Field)"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>When {@link Field} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.removeField(Field)"})
  public void testRemoveField_givenFieldGroup_whenField_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act and Assert
    assertFalse(fieldGroup.removeField(new Field()));
  }

  /**
   * Test {@link FieldGroup#removeField(Field)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Field} (default constructor) AlternateOrdering is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#removeField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.removeField(Field)"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return {@link FieldGroup} (default constructor) {@link FieldGroup#groupItems}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getGroupItems()"})
  public void testGetGroupItems_givenFieldGroupAddFieldField_thenReturnFieldGroupGroupItems() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act
    Set<FieldGroupItem> actualGroupItems = fieldGroup.getGroupItems();

    // Assert
    assertEquals(fieldGroup.groupItems, actualGroupItems);
  }

  /**
   * Test {@link FieldGroup#getGroupItems()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return {@link FieldGroup} (default constructor) {@link FieldGroup#groupItems}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getGroupItems()"})
  public void testGetGroupItems_givenFieldGroupAddFieldField_thenReturnFieldGroupGroupItems2() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act
    Set<FieldGroupItem> actualGroupItems = fieldGroup.getGroupItems();

    // Assert
    assertEquals(fieldGroup.groupItems, actualGroupItems);
  }

  /**
   * Test {@link FieldGroup#getGroupItems()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getGroupItems()"})
  public void testGetGroupItems_givenFieldGroupAddListGridListGrid() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addListGrid(new ListGrid());
    fieldGroup.addField(new Field());
    fieldGroup.addField(new Field());

    // Act
    Set<FieldGroupItem> actualGroupItems = fieldGroup.getGroupItems();

    // Assert
    assertEquals(fieldGroup.groupItems, actualGroupItems);
  }

  /**
   * Test {@link FieldGroup#getGroupItems()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getGroupItems()"})
  public void testGetGroupItems_givenFieldGroup_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new FieldGroup().getGroupItems().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getGroupItems()}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getGroupItems()"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is six.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getGroupItems()"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is zero.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getGroupItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getGroupItems()"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) AlternateOrdering is {@code true}.
   *   <li>When {@link Field} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByField(Field)"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) AlternateOrdering is {@code true}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByField(Field)"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>When {@link Field} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByField(Field)"})
  public void testFindFieldGroupItemByField_givenFieldGroupAddFieldField_whenField() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(new Field()));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByField(Field)}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByField(Field)"})
  public void testFindFieldGroupItemByField_givenFieldGroupAddFieldField_whenNull() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(null));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByField(Field)}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   *   <li>When {@link Field} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByField(Field)"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>When {@link Field} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByField(Field)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByField(Field)"})
  public void testFindFieldGroupItemByField_givenFieldGroup_whenField() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByField(new Field()));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) AlternateOrdering is {@code true}.
   *   <li>When {@link ListGrid} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByListGrid(ListGrid)"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>When {@link ListGrid} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByListGrid(ListGrid)"})
  public void testFindFieldGroupItemByListGrid_givenFieldGroupAddFieldField_whenListGrid() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(new ListGrid()));
  }

  /**
   * Test {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   *   <li>When {@link ListGrid} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByListGrid(ListGrid)"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByListGrid(ListGrid)"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>When {@link ListGrid} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#findFieldGroupItemByListGrid(ListGrid)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldGroupItem FieldGroup.findFieldGroupItemByListGrid(ListGrid)"})
  public void testFindFieldGroupItemByListGrid_givenFieldGroup_whenListGrid() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();

    // Act and Assert
    assertNull(fieldGroup.findFieldGroupItemByListGrid(new ListGrid()));
  }

  /**
   * Test {@link FieldGroup#containsFieldData()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.containsFieldData()"})
  public void testContainsFieldData_givenFieldGroupAddFieldField_thenReturnFalse() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertFalse(fieldGroup.containsFieldData());
  }

  /**
   * Test {@link FieldGroup#containsFieldData()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.containsFieldData()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.containsFieldData()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.containsFieldData()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.containsFieldData()"})
  public void testContainsFieldData_givenFieldGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FieldGroup().containsFieldData());
  }

  /**
   * Test {@link FieldGroup#containsFieldData()}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.containsFieldData()"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.containsFieldData()"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.containsFieldData()"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#containsFieldData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.containsFieldData()"})
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
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) AlternateOrdering is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#hasFieldOrListGrid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.hasFieldOrListGrid()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#hasFieldOrListGrid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.hasFieldOrListGrid()"})
  public void testHasFieldOrListGrid_givenFieldGroupAddFieldField_thenReturnTrue() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.hasFieldOrListGrid());
  }

  /**
   * Test {@link FieldGroup#hasFieldOrListGrid()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#hasFieldOrListGrid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FieldGroup.hasFieldOrListGrid()"})
  public void testHasFieldOrListGrid_givenFieldGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FieldGroup().hasFieldOrListGrid());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getFields()"})
  public void testGetFields_givenFieldGroupAddFieldField_thenReturnSizeIsOne() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(1, fieldGroup.getFields().size());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getFields()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getFields()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getFields()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getFields()"})
  public void testGetFields_givenFieldGroup_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new FieldGroup().getFields().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getFields()"})
  public void testGetFields_givenFieldOrderIsOne_thenReturnSizeIsTwo() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(2, fieldGroup.getFields().size());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is six.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getFields()"})
  public void testGetFields_givenFieldOrderIsSix_thenReturnSizeIsTwo() {
    // Arrange
    Field field = new Field();
    field.setOrder(6);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(2, fieldGroup.getFields().size());
  }

  /**
   * Test {@link FieldGroup#getFields()}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is zero.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getFields()"})
  public void testGetFields_givenFieldOrderIsZero_thenReturnSizeIsTwo() {
    // Arrange
    Field field = new Field();
    field.setOrder(0);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertEquals(2, fieldGroup.getFields().size());
  }

  /**
   * Test {@link FieldGroup#getListGrids()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getListGrids()"})
  public void testGetListGrids_givenFieldGroupAddFieldField_thenReturnEmpty() {
    // Arrange
    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getListGrids()}.
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getListGrids()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getListGrids()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid {@link ListGrid} (default
   *       constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getListGrids()"})
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
   *
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getListGrids()"})
  public void testGetListGrids_givenFieldGroup_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new FieldGroup().getListGrids().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getListGrids()}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getListGrids()"})
  public void testGetListGrids_givenFieldOrderIsOne_thenReturnEmpty() {
    // Arrange
    Field field = new Field();
    field.setOrder(1);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getListGrids()}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is six.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getListGrids()"})
  public void testGetListGrids_givenFieldOrderIsSix_thenReturnEmpty() {
    // Arrange
    Field field = new Field();
    field.setOrder(6);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Test {@link FieldGroup#getListGrids()}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Order is zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldGroup#getListGrids()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FieldGroup.getListGrids()"})
  public void testGetListGrids_givenFieldOrderIsZero_thenReturnEmpty() {
    // Arrange
    Field field = new Field();
    field.setOrder(0);
    field.setAlternateOrdering(true);

    FieldGroup fieldGroup = new FieldGroup();
    fieldGroup.addField(field);
    fieldGroup.addField(new Field());

    // Act and Assert
    assertTrue(fieldGroup.getListGrids().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldGroup.<init>()",
    "Integer FieldGroup.getColumn()",
    "String FieldGroup.getCustomTemplate()",
    "Map FieldGroup.getGroupAttributes()",
    "String FieldGroup.getKey()",
    "Integer FieldGroup.getOrder()",
    "String FieldGroup.getToolTip()",
    "void FieldGroup.setCollapsed(Boolean)",
    "void FieldGroup.setColumn(Integer)",
    "void FieldGroup.setCustomTemplate(String)",
    "void FieldGroup.setGroupAttributes(Map)",
    "void FieldGroup.setGroupItems(Set)",
    "void FieldGroup.setIsUntitled(Boolean)",
    "void FieldGroup.setIsVisible(Boolean)",
    "void FieldGroup.setKey(String)",
    "void FieldGroup.setOrder(Integer)",
    "void FieldGroup.setTitle(String)",
    "void FieldGroup.setToolTip(String)"
  })
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

    // Assert
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
