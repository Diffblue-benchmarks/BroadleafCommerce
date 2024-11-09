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
import java.util.HashSet;
import java.util.Set;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Tab.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TabDiffblueTest {
  @Autowired
  private Tab tab;

  /**
   * Test {@link Tab#withTitle(String)}.
   * <p>
   * Method under test: {@link Tab#withTitle(String)}
   */
  @Test
  public void testWithTitle() {
    // Arrange and Act
    Tab actualWithTitleResult = tab.withTitle("Dr");

    // Assert
    assertEquals("Dr", tab.getTitle());
    assertEquals("Dr", tab.title);
    assertSame(tab, actualWithTitleResult);
  }

  /**
   * Test {@link Tab#withKey(String)}.
   * <p>
   * Method under test: {@link Tab#withKey(String)}
   */
  @Test
  public void testWithKey() {
    // Arrange and Act
    Tab actualWithKeyResult = tab.withKey("Key");

    // Assert
    assertEquals("Key", tab.getKey());
    assertSame(tab, actualWithKeyResult);
  }

  /**
   * Test {@link Tab#withOrder(Integer)}.
   * <p>
   * Method under test: {@link Tab#withOrder(Integer)}
   */
  @Test
  public void testWithOrder() {
    // Arrange
    Tab tab = new Tab();

    // Act
    Tab actualWithOrderResult = tab.withOrder(1);

    // Assert
    assertEquals(1, tab.getOrder().intValue());
    assertSame(tab, actualWithOrderResult);
  }

  /**
   * Test {@link Tab#withTabClass(String)}.
   * <p>
   * Method under test: {@link Tab#withTabClass(String)}
   */
  @Test
  public void testWithTabClass() {
    // Arrange and Act
    Tab actualWithTabClassResult = tab.withTabClass("Tab Class");

    // Assert
    assertEquals(" Tab Class", tab.getTabClass());
    assertEquals("Tab Class", tab.tabClass);
    assertSame(tab, actualWithTabClassResult);
  }

  /**
   * Test {@link Tab#withIsMultiColumn(Boolean)}.
   * <p>
   * Method under test: {@link Tab#withIsMultiColumn(Boolean)}
   */
  @Test
  public void testWithIsMultiColumn() {
    // Arrange
    Tab tab = new Tab();

    // Act
    Tab actualWithIsMultiColumnResult = tab.withIsMultiColumn(true);

    // Assert
    assertTrue(tab.getIsMultiColumn());
    assertTrue(tab.isMultiColumn);
    assertSame(tab, actualWithIsMultiColumnResult);
  }

  /**
   * Test {@link Tab#withCustomTemplate(String)}.
   * <p>
   * Method under test: {@link Tab#withCustomTemplate(String)}
   */
  @Test
  public void testWithCustomTemplate() {
    // Arrange and Act
    Tab actualWithCustomTemplateResult = tab.withCustomTemplate("Custom Template");

    // Assert
    assertEquals("Custom Template", tab.getCustomTemplate());
    assertTrue(tab.hasFieldOrListGrid());
    assertSame(tab, actualWithCustomTemplateResult);
  }

  /**
   * Test {@link Tab#getIsVisible()}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ListGrid} (default
   * constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenHashSetAddListGrid_thenReturnTrue() {
    // Arrange
    HashSet<ListGrid> listGrids = new HashSet<>();
    listGrids.add(new ListGrid());

    Tab tab = new Tab();
    tab.setListGrids(listGrids);

    // Act and Assert
    assertTrue(tab.getIsVisible());
  }

  /**
   * Test {@link Tab#getIsVisible()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor) TabsPresent is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenTabTabsPresentIsTrue_thenReturnTrue() {
    // Arrange
    Tab tab = new Tab();
    tab.setTabsPresent(true);

    // Act and Assert
    assertTrue(tab.getIsVisible());
  }

  /**
   * Test {@link Tab#getIsVisible()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#getIsVisible()}
   */
  @Test
  public void testGetIsVisible_givenTab_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Tab()).getIsVisible());
  }

  /**
   * Test {@link Tab#hasFieldOrListGrid()}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ListGrid} (default
   * constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#hasFieldOrListGrid()}
   */
  @Test
  public void testHasFieldOrListGrid_givenHashSetAddListGrid_thenReturnTrue() {
    // Arrange
    HashSet<ListGrid> listGrids = new HashSet<>();
    listGrids.add(new ListGrid());

    Tab tab = new Tab();
    tab.setListGrids(listGrids);

    // Act and Assert
    assertTrue(tab.hasFieldOrListGrid());
  }

  /**
   * Test {@link Tab#hasFieldOrListGrid()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor) CustomTemplate is
   * {@code Custom Template}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#hasFieldOrListGrid()}
   */
  @Test
  public void testHasFieldOrListGrid_givenTabCustomTemplateIsCustomTemplate_thenReturnTrue() {
    // Arrange
    Tab tab = new Tab();
    tab.setCustomTemplate("Custom Template");

    // Act and Assert
    assertTrue(tab.hasFieldOrListGrid());
  }

  /**
   * Test {@link Tab#hasFieldOrListGrid()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#hasFieldOrListGrid()}
   */
  @Test
  public void testHasFieldOrListGrid_givenTab_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Tab()).hasFieldOrListGrid());
  }

  /**
   * Test {@link Tab#findGroupByKey(String)}.
   * <p>
   * Method under test: {@link Tab#findGroupByKey(String)}
   */
  @Test
  public void testFindGroupByKey() {
    // Arrange, Act and Assert
    assertNull(tab.findGroupByKey("Key"));
  }

  /**
   * Test {@link Tab#findGroupByTitle(String)}.
   * <p>
   * Method under test: {@link Tab#findGroupByTitle(String)}
   */
  @Test
  public void testFindGroupByTitle() {
    // Arrange, Act and Assert
    assertNull(tab.findGroupByTitle("Dr"));
  }

  /**
   * Test {@link Tab#getFields()}.
   * <p>
   * Method under test: {@link Tab#getFields()}
   */
  @Test
  public void testGetFields() {
    // Arrange, Act and Assert
    assertTrue((new Tab()).getFields().isEmpty());
  }

  /**
   * Test {@link Tab#getTabClass()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor) TabClass is {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#getTabClass()}
   */
  @Test
  public void testGetTabClass_givenTabTabClassIsFoo_thenReturnFoo() {
    // Arrange
    Tab tab = new Tab();
    tab.setTabClass("foo");

    // Act and Assert
    assertEquals(" foo", tab.getTabClass());
  }

  /**
   * Test {@link Tab#getTabClass()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor) TabClass is space.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#getTabClass()}
   */
  @Test
  public void testGetTabClass_givenTabTabClassIsSpace_thenReturnEmptyString() {
    // Arrange
    Tab tab = new Tab();
    tab.setTabClass(" ");

    // Act and Assert
    assertEquals("", tab.getTabClass());
  }

  /**
   * Test {@link Tab#getTabClass()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#getTabClass()}
   */
  @Test
  public void testGetTabClass_givenTab_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new Tab()).getTabClass());
  }

  /**
   * Test {@link Tab#getTitle()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor) Title is {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#getTitle()}
   */
  @Test
  public void testGetTitle_givenTabTitleIsFoo_thenReturnFoo() {
    // Arrange
    Tab tab = new Tab();
    tab.setTitle("foo");
    tab.setKey(null);

    // Act and Assert
    assertEquals("foo", tab.getTitle());
  }

  /**
   * Test {@link Tab#getTitle()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#getTitle()}
   */
  @Test
  public void testGetTitle_givenTab_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Tab()).getTitle());
  }

  /**
   * Test {@link Tab#setFieldGroups(Set)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then {@link Tab} (default constructor) FieldGroups is
   * {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#setFieldGroups(Set)}
   */
  @Test
  public void testSetFieldGroups_givenFieldGroup_thenTabFieldGroupsIsHashSet() {
    // Arrange
    Tab tab = new Tab();

    HashSet<FieldGroup> fieldGroups = new HashSet<>();
    fieldGroups.add(new FieldGroup());

    // Act
    tab.setFieldGroups(fieldGroups);

    // Assert
    assertEquals(fieldGroups, tab.getFieldGroups());
  }

  /**
   * Test {@link Tab#setFieldGroups(Set)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor).</li>
   *   <li>Then {@link Tab} (default constructor) FieldGroups size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#setFieldGroups(Set)}
   */
  @Test
  public void testSetFieldGroups_givenFieldGroup_thenTabFieldGroupsSizeIsOne() {
    // Arrange
    Tab tab = new Tab();

    HashSet<FieldGroup> fieldGroups = new HashSet<>();
    fieldGroups.add(new FieldGroup());
    fieldGroups.add(new FieldGroup());

    // Act
    tab.setFieldGroups(fieldGroups);

    // Assert
    assertEquals(1, tab.getFieldGroups().size());
  }

  /**
   * Test {@link Tab#setFieldGroups(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then {@link Tab} (default constructor) FieldGroups Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#setFieldGroups(Set)}
   */
  @Test
  public void testSetFieldGroups_whenHashSet_thenTabFieldGroupsEmpty() {
    // Arrange
    Tab tab = new Tab();

    // Act
    tab.setFieldGroups(new HashSet<>());

    // Assert
    assertTrue(tab.getFieldGroups().isEmpty());
  }

  /**
   * Test {@link Tab#getIsMultiColumn()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor) IsMultiColumn is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#getIsMultiColumn()}
   */
  @Test
  public void testGetIsMultiColumn_givenTabIsMultiColumnIsTrue_thenReturnTrue() {
    // Arrange
    Tab tab = new Tab();
    tab.setIsMultiColumn(true);

    // Act and Assert
    assertTrue(tab.getIsMultiColumn());
  }

  /**
   * Test {@link Tab#getIsMultiColumn()}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tab#getIsMultiColumn()}
   */
  @Test
  public void testGetIsMultiColumn_givenTab_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Tab()).getIsMultiColumn());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tab#setCustomTemplate(String)}
   *   <li>{@link Tab#setIsMultiColumn(Boolean)}
   *   <li>{@link Tab#setKey(String)}
   *   <li>{@link Tab#setListGrids(Set)}
   *   <li>{@link Tab#setOrder(Integer)}
   *   <li>{@link Tab#setTabClass(String)}
   *   <li>{@link Tab#setTabsPresent(boolean)}
   *   <li>{@link Tab#setTitle(String)}
   *   <li>{@link Tab#setWantsFullScreen(Boolean)}
   *   <li>{@link Tab#getCustomTemplate()}
   *   <li>{@link Tab#getFieldGroups()}
   *   <li>{@link Tab#getKey()}
   *   <li>{@link Tab#getListGrids()}
   *   <li>{@link Tab#getOrder()}
   *   <li>{@link Tab#getWantsFullScreen()}
   *   <li>{@link Tab#isTabsPresent()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Tab tab = new Tab();

    // Act
    tab.setCustomTemplate("Custom Template");
    tab.setIsMultiColumn(true);
    tab.setKey("Key");
    HashSet<ListGrid> listGrids = new HashSet<>();
    tab.setListGrids(listGrids);
    tab.setOrder(1);
    tab.setTabClass("Tab Class");
    tab.setTabsPresent(true);
    tab.setTitle("Dr");
    tab.setWantsFullScreen(true);
    String actualCustomTemplate = tab.getCustomTemplate();
    Set<FieldGroup> actualFieldGroups = tab.getFieldGroups();
    String actualKey = tab.getKey();
    Set<ListGrid> actualListGrids = tab.getListGrids();
    Integer actualOrder = tab.getOrder();
    Boolean actualWantsFullScreen = tab.getWantsFullScreen();
    boolean actualIsTabsPresentResult = tab.isTabsPresent();

    // Assert that nothing has changed
    assertEquals("Custom Template", actualCustomTemplate);
    assertEquals("Key", actualKey);
    assertEquals(1, actualOrder.intValue());
    assertTrue(actualFieldGroups.isEmpty());
    assertTrue(actualListGrids.isEmpty());
    assertTrue(actualWantsFullScreen);
    assertTrue(actualIsTabsPresentResult);
    assertSame(listGrids, actualListGrids);
  }

  /**
   * Test new {@link Tab} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Tab}
   */
  @Test
  public void testNewTab() {
    // Arrange and Act
    Tab actualTab = new Tab();

    // Assert
    assertEquals("", actualTab.getTabClass());
    assertNull(actualTab.isMultiColumn);
    assertNull(actualTab.getOrder());
    assertNull(actualTab.getCustomTemplate());
    assertNull(actualTab.getKey());
    assertNull(actualTab.getTitle());
    assertNull(actualTab.tabClass);
    assertNull(actualTab.title);
    assertFalse(actualTab.getIsMultiColumn());
    assertFalse(actualTab.getIsVisible());
    assertFalse(actualTab.getWantsFullScreen());
    assertFalse(actualTab.hasFieldOrListGrid());
    assertFalse(actualTab.isTabsPresent());
    assertTrue(actualTab.getFields().isEmpty());
    assertTrue(actualTab.getFieldGroups().isEmpty());
    assertTrue(actualTab.getListGrids().isEmpty());
  }
}
