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
package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ListGrid.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ListGridDiffblueTest {
  @Autowired
  private ListGrid listGrid;

  /**
   * Test {@link ListGrid#getPath()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) ContainingEntityId is
   * {@code 42}.</li>
   *   <li>Then return {@code /Section Key/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getPath()}
   */
  @Test
  public void testGetPath_givenListGridContainingEntityIdIs42_thenReturnSectionKey42() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setContainingEntityId("42");
    listGrid.setSectionKey("Section Key");

    // Act and Assert
    assertEquals("/Section Key/42", listGrid.getPath());
  }

  /**
   * Test {@link ListGrid#getPath()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) PathOverride is
   * {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getPath()}
   */
  @Test
  public void testGetPath_givenListGridPathOverrideIsSlash_thenReturnSlash() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setPathOverride("/");

    // Act and Assert
    assertEquals("/", listGrid.getPath());
  }

  /**
   * Test {@link ListGrid#getPath()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) SectionKey is
   * {@code Section Key}.</li>
   *   <li>Then return {@code /Section Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getPath()}
   */
  @Test
  public void testGetPath_givenListGridSectionKeyIsSectionKey_thenReturnSectionKey() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setSectionKey("Section Key");

    // Act and Assert
    assertEquals("/Section Key", listGrid.getPath());
  }

  /**
   * Test {@link ListGrid#getPath()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) SectionKey is
   * {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getPath()}
   */
  @Test
  public void testGetPath_givenListGridSectionKeyIsSlash_thenReturnSlash() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setSectionKey("/");

    // Act and Assert
    assertEquals("/", listGrid.getPath());
  }

  /**
   * Test {@link ListGrid#getPath()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) SubCollectionFieldName is
   * {@code /}.</li>
   *   <li>Then return {@code /Section Key//}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getPath()}
   */
  @Test
  public void testGetPath_givenListGridSubCollectionFieldNameIsSlash_thenReturnSectionKey() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setSubCollectionFieldName("/");
    listGrid.setSectionKey("Section Key");

    // Act and Assert
    assertEquals("/Section Key//", listGrid.getPath());
  }

  /**
   * Test {@link ListGrid#getSectionCrumbRepresentation()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getSectionCrumbRepresentation()}
   */
  @Test
  public void testGetSectionCrumbRepresentation_givenListGrid_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new ListGrid()).getSectionCrumbRepresentation());
  }

  /**
   * Test {@link ListGrid#getSectionCrumbRepresentation()}.
   * <ul>
   *   <li>Then return {@code ?sectionCrumbs=42--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getSectionCrumbRepresentation()}
   */
  @Test
  public void testGetSectionCrumbRepresentation_thenReturnSectionCrumbs4242() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    ListGrid listGrid = new ListGrid();
    listGrid.setSectionCrumbs(sectionCrumbs);

    // Act and Assert
    assertEquals("?sectionCrumbs=42--42", listGrid.getSectionCrumbRepresentation());
  }

  /**
   * Test {@link ListGrid#getSectionCrumbRepresentation()}.
   * <ul>
   *   <li>Then return {@code ?sectionCrumbs=42--42,42--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getSectionCrumbRepresentation()}
   */
  @Test
  public void testGetSectionCrumbRepresentation_thenReturnSectionCrumbs42424242() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("42");
    sectionCrumb2.setSectionId("42");
    sectionCrumb2.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    ListGrid listGrid = new ListGrid();
    listGrid.setSectionCrumbs(sectionCrumbs);

    // Act and Assert
    assertEquals("?sectionCrumbs=42--42,42--42", listGrid.getSectionCrumbRepresentation());
  }

  /**
   * Test {@link ListGrid#getActiveToolbarActions()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getActiveToolbarActions()}
   */
  @Test
  public void testGetActiveToolbarActions_givenListGrid_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ListGrid()).getActiveToolbarActions().isEmpty());
  }

  /**
   * Test {@link ListGrid#getActiveRowActions()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getActiveRowActions()}
   */
  @Test
  public void testGetActiveRowActions_givenListGrid_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ListGrid()).getActiveRowActions().isEmpty());
  }

  /**
   * Test {@link ListGrid#getActiveToolbarActionGroups()}.
   * <ul>
   *   <li>Given {@link ListGridActionGroup} (default constructor) addAction
   * {@link DefaultListGridActions#MANUAL_FETCH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getActiveToolbarActionGroups()}
   */
  @Test
  public void testGetActiveToolbarActionGroups_givenListGridActionGroupAddActionManual_fetch() {
    // Arrange
    ListGridActionGroup actionGroup = new ListGridActionGroup();
    actionGroup.addAction(DefaultListGridActions.MANUAL_FETCH);

    ListGrid listGrid = new ListGrid();
    listGrid.addToolbarActionGroup(actionGroup);

    // Act and Assert
    assertTrue(listGrid.getActiveToolbarActionGroups().isEmpty());
  }

  /**
   * Test {@link ListGrid#getActiveToolbarActionGroups()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getActiveToolbarActionGroups()}
   */
  @Test
  public void testGetActiveToolbarActionGroups_givenListGrid_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ListGrid()).getActiveToolbarActionGroups().isEmpty());
  }

  /**
   * Test {@link ListGrid#getActiveToolbarActionGroups()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getActiveToolbarActionGroups()}
   */
  @Test
  public void testGetActiveToolbarActionGroups_thenReturnEmpty() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.addToolbarActionGroup(new ListGridActionGroup());

    // Act and Assert
    assertTrue(listGrid.getActiveToolbarActionGroups().isEmpty());
  }

  /**
   * Test {@link ListGrid#getActiveRowActionGroups()}.
   * <ul>
   *   <li>Given {@link ListGridActionGroup} (default constructor) addAction
   * {@link DefaultListGridActions#MANUAL_FETCH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getActiveRowActionGroups()}
   */
  @Test
  public void testGetActiveRowActionGroups_givenListGridActionGroupAddActionManual_fetch() {
    // Arrange
    ListGridActionGroup actionGroup = new ListGridActionGroup();
    actionGroup.addAction(DefaultListGridActions.MANUAL_FETCH);

    ListGrid listGrid = new ListGrid();
    listGrid.addRowActionGroup(actionGroup);

    // Act and Assert
    assertTrue(listGrid.getActiveRowActionGroups().isEmpty());
  }

  /**
   * Test {@link ListGrid#getActiveRowActionGroups()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getActiveRowActionGroups()}
   */
  @Test
  public void testGetActiveRowActionGroups_givenListGrid_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ListGrid()).getActiveRowActionGroups().isEmpty());
  }

  /**
   * Test {@link ListGrid#getActiveRowActionGroups()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getActiveRowActionGroups()}
   */
  @Test
  public void testGetActiveRowActionGroups_thenReturnEmpty() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.addRowActionGroup(new ListGridActionGroup());

    // Act and Assert
    assertTrue(listGrid.getActiveRowActionGroups().isEmpty());
  }

  /**
   * Test {@link ListGrid#getActiveModalRowActions()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getActiveModalRowActions()}
   */
  @Test
  public void testGetActiveModalRowActions_givenListGrid_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ListGrid()).getActiveModalRowActions().isEmpty());
  }

  /**
   * Test {@link ListGrid#removeAllRowActions()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#removeAllRowActions()}
   */
  @Test
  public void testRemoveAllRowActions_givenListGrid() {
    // Arrange
    ListGrid listGrid = new ListGrid();

    // Act
    listGrid.removeAllRowActions();

    // Assert
    assertTrue(listGrid.getActiveRowActions().isEmpty());
    assertTrue(listGrid.getRowActions().isEmpty());
  }

  /**
   * Test {@link ListGrid#removeAllRowActions()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) addRowAction
   * {@link ListGridAction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#removeAllRowActions()}
   */
  @Test
  public void testRemoveAllRowActions_givenListGridAddRowActionListGridAction() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.addRowAction(mock(ListGridAction.class));

    // Act
    listGrid.removeAllRowActions();

    // Assert
    assertTrue(listGrid.getActiveRowActions().isEmpty());
    assertTrue(listGrid.getRowActions().isEmpty());
  }

  /**
   * Test {@link ListGrid#addToolbarActionGroup(ListGridActionGroup)}.
   * <p>
   * Method under test:
   * {@link ListGrid#addToolbarActionGroup(ListGridActionGroup)}
   */
  @Test
  public void testAddToolbarActionGroup() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    ListGridActionGroup actionGroup = new ListGridActionGroup();

    // Act
    listGrid.addToolbarActionGroup(actionGroup);

    // Assert
    List<ListGridActionGroup> toolbarActionGroups = listGrid.getToolbarActionGroups();
    assertEquals(1, toolbarActionGroups.size());
    assertSame(actionGroup, toolbarActionGroups.get(0));
  }

  /**
   * Test {@link ListGrid#addRowActionGroup(ListGridActionGroup)}.
   * <p>
   * Method under test: {@link ListGrid#addRowActionGroup(ListGridActionGroup)}
   */
  @Test
  public void testAddRowActionGroup() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    ListGridActionGroup actionGroup = new ListGridActionGroup();

    // Act
    listGrid.addRowActionGroup(actionGroup);

    // Assert
    List<ListGridActionGroup> rowActionGroups = listGrid.getRowActionGroups();
    assertEquals(1, rowActionGroups.size());
    assertSame(actionGroup, rowActionGroups.get(0));
  }

  /**
   * Test {@link ListGrid#findToolbarAction(String)}.
   * <p>
   * Method under test: {@link ListGrid#findToolbarAction(String)}
   */
  @Test
  public void testFindToolbarAction() {
    // Arrange, Act and Assert
    assertNull(listGrid.findToolbarAction("42"));
  }

  /**
   * Test {@link ListGrid#findRowAction(String)}.
   * <p>
   * Method under test: {@link ListGrid#findRowAction(String)}
   */
  @Test
  public void testFindRowAction() {
    // Arrange, Act and Assert
    assertNull(listGrid.findRowAction("42"));
  }

  /**
   * Test {@link ListGrid#findModalRowAction(String)}.
   * <p>
   * Method under test: {@link ListGrid#findModalRowAction(String)}
   */
  @Test
  public void testFindModalRowAction() {
    // Arrange, Act and Assert
    assertNull(listGrid.findModalRowAction("42"));
  }

  /**
   * Test {@link ListGrid#isSortable()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) IsSortable is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#isSortable()}
   */
  @Test
  public void testIsSortable_givenListGridIsSortableIsTrue_thenReturnTrue() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setIsSortable(true);

    // Act and Assert
    assertTrue(listGrid.isSortable());
  }

  /**
   * Test {@link ListGrid#isSortable()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#isSortable()}
   */
  @Test
  public void testIsSortable_givenListGrid_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ListGrid()).isSortable());
  }

  /**
   * Test {@link ListGrid#setListGridType(Type)}.
   * <p>
   * Method under test: {@link ListGrid#setListGridType(ListGrid.Type)}
   */
  @Test
  public void testSetListGridType() {
    // Arrange
    ListGrid listGrid = new ListGrid();

    // Act
    listGrid.setListGridType(ListGrid.Type.MAIN);

    // Assert
    assertEquals("main", listGrid.getListGridType());
  }

  /**
   * Test {@link ListGrid#setSelectType(SelectType)}.
   * <p>
   * Method under test: {@link ListGrid#setSelectType(ListGrid.SelectType)}
   */
  @Test
  public void testSetSelectType() {
    // Arrange
    ListGrid listGrid = new ListGrid();

    // Act
    listGrid.setSelectType(ListGrid.SelectType.SINGLE_SELECT);

    // Assert
    assertEquals("single_select", listGrid.getSelectType());
  }

  /**
   * Test {@link ListGrid#getCanFilterAndSort()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) CanFilterAndSort is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getCanFilterAndSort()}
   */
  @Test
  public void testGetCanFilterAndSort_givenListGridCanFilterAndSortIsFalse_thenReturnFalse() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setCanFilterAndSort(false);

    // Act and Assert
    assertFalse(listGrid.getCanFilterAndSort());
  }

  /**
   * Test {@link ListGrid#getCanFilterAndSort()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) CanFilterAndSort is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getCanFilterAndSort()}
   */
  @Test
  public void testGetCanFilterAndSort_givenListGridCanFilterAndSortIsTrue_thenReturnTrue() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setCanFilterAndSort(true);

    // Act and Assert
    assertTrue(listGrid.getCanFilterAndSort());
  }

  /**
   * Test {@link ListGrid#getCanFilterAndSort()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getCanFilterAndSort()}
   */
  @Test
  public void testGetCanFilterAndSort_givenListGrid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ListGrid()).getCanFilterAndSort());
  }

  /**
   * Test {@link ListGrid#getIsReadOnly()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) IsReadOnly is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getIsReadOnly()}
   */
  @Test
  public void testGetIsReadOnly_givenListGridIsReadOnlyIsTrue_thenReturnTrue() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setIsReadOnly(true);

    // Act and Assert
    assertTrue(listGrid.getIsReadOnly());
  }

  /**
   * Test {@link ListGrid#getIsReadOnly()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getIsReadOnly()}
   */
  @Test
  public void testGetIsReadOnly_givenListGrid_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ListGrid()).getIsReadOnly());
  }

  /**
   * Test {@link ListGrid#getClickable()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) SelectTypeString is
   * {@code none}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getClickable()}
   */
  @Test
  public void testGetClickable_givenListGridSelectTypeStringIsNone_thenReturnFalse() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setSelectTypeString("none");

    // Act and Assert
    assertFalse(listGrid.getClickable());
  }

  /**
   * Test {@link ListGrid#getClickable()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getClickable()}
   */
  @Test
  public void testGetClickable_givenListGrid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ListGrid()).getClickable());
  }

  /**
   * Test {@link ListGrid#getHideIdColumn()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) HideIdColumn is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getHideIdColumn()}
   */
  @Test
  public void testGetHideIdColumn_givenListGridHideIdColumnIsFalse_thenReturnFalse() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setHideIdColumn(false);

    // Act and Assert
    assertFalse(listGrid.getHideIdColumn());
  }

  /**
   * Test {@link ListGrid#getHideIdColumn()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) HideIdColumn is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getHideIdColumn()}
   */
  @Test
  public void testGetHideIdColumn_givenListGridHideIdColumnIsTrue_thenReturnTrue() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setHideIdColumn(true);

    // Act and Assert
    assertTrue(listGrid.getHideIdColumn());
  }

  /**
   * Test {@link ListGrid#getHideIdColumn()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getHideIdColumn()}
   */
  @Test
  public void testGetHideIdColumn_givenListGrid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ListGrid()).getHideIdColumn());
  }

  /**
   * Test {@link ListGrid#findHeaderField(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#findHeaderField(String)}
   */
  @Test
  public void testFindHeaderField_whenName() {
    // Arrange, Act and Assert
    assertNull(listGrid.findHeaderField("Name"));
  }

  /**
   * Test {@link ListGrid#findHeaderField(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#findHeaderField(String)}
   */
  @Test
  public void testFindHeaderField_whenNull() {
    // Arrange, Act and Assert
    assertNull(listGrid.findHeaderField(null));
  }

  /**
   * Test {@link ListGrid#isEmpty()}.
   * <p>
   * Method under test: {@link ListGrid#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new ListGrid()).isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ListGrid#setAddMethodType(AddMethodType)}
   *   <li>{@link ListGrid#setCanFilterAndSort(Boolean)}
   *   <li>{@link ListGrid#setClassName(String)}
   *   <li>{@link ListGrid#setContainingEntityId(String)}
   *   <li>{@link ListGrid#setDataWrapper(DataWrapper)}
   *   <li>{@link ListGrid#setExternalEntitySectionKey(String)}
   *   <li>{@link ListGrid#setFetchType(String)}
   *   <li>{@link ListGrid#setFieldBuilder(String)}
   *   <li>{@link ListGrid#setFieldWrapper(FieldWrapper)}
   *   <li>{@link ListGrid#setFirstId(long)}
   *   <li>{@link ListGrid#setFriendlyName(String)}
   *   <li>{@link ListGrid#setHeaderFields(Set)}
   *   <li>{@link ListGrid#setHelpText(String)}
   *   <li>{@link ListGrid#setHideFriendlyName(boolean)}
   *   <li>{@link ListGrid#setHideIdColumn(Boolean)}
   *   <li>{@link ListGrid#setHtmlEscapeMainEntityLink(boolean)}
   *   <li>{@link ListGrid#setIdProperty(String)}
   *   <li>{@link ListGrid#setIsReadOnly(Boolean)}
   *   <li>{@link ListGrid#setIsSortable(boolean)}
   *   <li>{@link ListGrid#setJson(String)}
   *   <li>{@link ListGrid#setJsonFieldName(String)}
   *   <li>{@link ListGrid#setLastId(long)}
   *   <li>{@link ListGrid#setListGridTypeString(String)}
   *   <li>{@link ListGrid#setLowerCount(int)}
   *   <li>{@link ListGrid#setManualFetch(Boolean)}
   *   <li>{@link ListGrid#setModalRowActions(List)}
   *   <li>{@link ListGrid#setMultiSelectCheckBoxOnly(boolean)}
   *   <li>{@link ListGrid#setOrder(int)}
   *   <li>{@link ListGrid#setPageSize(int)}
   *   <li>{@link ListGrid#setPathOverride(String)}
   *   <li>{@link ListGrid#setPromptSearch(boolean)}
   *   <li>{@link ListGrid#setRecords(List)}
   *   <li>{@link ListGrid#setRowActionGroups(List)}
   *   <li>{@link ListGrid#setRowActions(List)}
   *   <li>{@link ListGrid#setSearchFieldsTemplateOverride(String)}
   *   <li>{@link ListGrid#setSectionKey(String)}
   *   <li>{@link ListGrid#setSelectTypeString(String)}
   *   <li>{@link ListGrid#setSelectizeUrl(String)}
   *   <li>{@link ListGrid#setStartIndex(int)}
   *   <li>{@link ListGrid#setSubCollectionFieldName(String)}
   *   <li>{@link ListGrid#setTemplateOverride(String)}
   *   <li>{@link ListGrid#setToolbarActionGroups(List)}
   *   <li>{@link ListGrid#setToolbarActions(List)}
   *   <li>{@link ListGrid#setTotalCountLessThanPageSize(boolean)}
   *   <li>{@link ListGrid#setTotalRecords(int)}
   *   <li>{@link ListGrid#setUpperCount(int)}
   *   <li>{@link ListGrid#getAddMethodType()}
   *   <li>{@link ListGrid#getClassName()}
   *   <li>{@link ListGrid#getContainingEntityId()}
   *   <li>{@link ListGrid#getDataWrapper()}
   *   <li>{@link ListGrid#getExternalEntitySectionKey()}
   *   <li>{@link ListGrid#getFetchType()}
   *   <li>{@link ListGrid#getFieldBuilder()}
   *   <li>{@link ListGrid#getFieldWrapper()}
   *   <li>{@link ListGrid#getFirstId()}
   *   <li>{@link ListGrid#getFriendlyName()}
   *   <li>{@link ListGrid#getHeaderFields()}
   *   <li>{@link ListGrid#getHelpText()}
   *   <li>{@link ListGrid#getHideFriendlyName()}
   *   <li>{@link ListGrid#getIdProperty()}
   *   <li>{@link ListGrid#getIsSortable()}
   *   <li>{@link ListGrid#getJson()}
   *   <li>{@link ListGrid#getJsonFieldName()}
   *   <li>{@link ListGrid#getLastId()}
   *   <li>{@link ListGrid#getListGridType()}
   *   <li>{@link ListGrid#getLowerCount()}
   *   <li>{@link ListGrid#getModalRowActions()}
   *   <li>{@link ListGrid#getOrder()}
   *   <li>{@link ListGrid#getPageSize()}
   *   <li>{@link ListGrid#getPathOverride()}
   *   <li>{@link ListGrid#getRecords()}
   *   <li>{@link ListGrid#getRowActionGroups()}
   *   <li>{@link ListGrid#getRowActions()}
   *   <li>{@link ListGrid#getSearchFieldsTemplateOverride()}
   *   <li>{@link ListGrid#getSectionCrumbs()}
   *   <li>{@link ListGrid#getSectionKey()}
   *   <li>{@link ListGrid#getSelectType()}
   *   <li>{@link ListGrid#getSelectizeUrl()}
   *   <li>{@link ListGrid#getStartIndex()}
   *   <li>{@link ListGrid#getSubCollectionFieldName()}
   *   <li>{@link ListGrid#getTemplateOverride()}
   *   <li>{@link ListGrid#getToolbarActionGroups()}
   *   <li>{@link ListGrid#getToolbarActions()}
   *   <li>{@link ListGrid#getTotalRecords()}
   *   <li>{@link ListGrid#getUpperCount()}
   *   <li>{@link ListGrid#isHtmlEscapeMainEntityLink()}
   *   <li>{@link ListGrid#isMultiSelectCheckBoxOnly()}
   *   <li>{@link ListGrid#isPromptSearch()}
   *   <li>{@link ListGrid#isTotalCountLessThanPageSize()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ListGrid listGrid = new ListGrid();

    // Act
    listGrid.setAddMethodType(AddMethodType.PERSIST);
    listGrid.setCanFilterAndSort(true);
    listGrid.setClassName("Class Name");
    listGrid.setContainingEntityId("42");
    DataWrapper dataWrapper = new DataWrapper();
    listGrid.setDataWrapper(dataWrapper);
    listGrid.setExternalEntitySectionKey("External Entity Section Key");
    listGrid.setFetchType("Fetch Type");
    listGrid.setFieldBuilder("Field Builder");
    FieldWrapper fieldWrapper = new FieldWrapper();
    listGrid.setFieldWrapper(fieldWrapper);
    listGrid.setFirstId(1L);
    listGrid.setFriendlyName("Friendly Name");
    HashSet<Field> headerFields = new HashSet<>();
    listGrid.setHeaderFields(headerFields);
    listGrid.setHelpText("Help Text");
    listGrid.setHideFriendlyName(true);
    listGrid.setHideIdColumn(true);
    listGrid.setHtmlEscapeMainEntityLink(true);
    listGrid.setIdProperty("Id Property");
    listGrid.setIsReadOnly(true);
    listGrid.setIsSortable(true);
    listGrid.setJson("Json");
    listGrid.setJsonFieldName("Json Field Name");
    listGrid.setLastId(1L);
    listGrid.setListGridTypeString("List Grid Type");
    listGrid.setLowerCount(3);
    listGrid.setManualFetch(true);
    ArrayList<ListGridAction> modalRowActions = new ArrayList<>();
    listGrid.setModalRowActions(modalRowActions);
    listGrid.setMultiSelectCheckBoxOnly(true);
    listGrid.setOrder(1);
    listGrid.setPageSize(3);
    listGrid.setPathOverride("Path Override");
    listGrid.setPromptSearch(true);
    ArrayList<ListGridRecord> records = new ArrayList<>();
    listGrid.setRecords(records);
    ArrayList<ListGridActionGroup> rowActionGroups = new ArrayList<>();
    listGrid.setRowActionGroups(rowActionGroups);
    ArrayList<ListGridAction> rowActions = new ArrayList<>();
    listGrid.setRowActions(rowActions);
    listGrid.setSearchFieldsTemplateOverride("Search Fields Template Override");
    listGrid.setSectionKey("Section Key");
    listGrid.setSelectTypeString("Select Type");
    listGrid.setSelectizeUrl("https://example.org/example");
    listGrid.setStartIndex(1);
    listGrid.setSubCollectionFieldName("Sub Collection Field Name");
    listGrid.setTemplateOverride("Template Override");
    ArrayList<ListGridActionGroup> toolbarActionGroups = new ArrayList<>();
    listGrid.setToolbarActionGroups(toolbarActionGroups);
    ArrayList<ListGridAction> toolbarActions = new ArrayList<>();
    listGrid.setToolbarActions(toolbarActions);
    listGrid.setTotalCountLessThanPageSize(true);
    listGrid.setTotalRecords(1);
    listGrid.setUpperCount(3);
    AddMethodType actualAddMethodType = listGrid.getAddMethodType();
    String actualClassName = listGrid.getClassName();
    String actualContainingEntityId = listGrid.getContainingEntityId();
    DataWrapper actualDataWrapper = listGrid.getDataWrapper();
    String actualExternalEntitySectionKey = listGrid.getExternalEntitySectionKey();
    String actualFetchType = listGrid.getFetchType();
    String actualFieldBuilder = listGrid.getFieldBuilder();
    FieldWrapper actualFieldWrapper = listGrid.getFieldWrapper();
    long actualFirstId = listGrid.getFirstId();
    String actualFriendlyName = listGrid.getFriendlyName();
    Set<Field> actualHeaderFields = listGrid.getHeaderFields();
    String actualHelpText = listGrid.getHelpText();
    boolean actualHideFriendlyName = listGrid.getHideFriendlyName();
    String actualIdProperty = listGrid.getIdProperty();
    boolean actualIsSortable = listGrid.getIsSortable();
    String actualJson = listGrid.getJson();
    String actualJsonFieldName = listGrid.getJsonFieldName();
    long actualLastId = listGrid.getLastId();
    String actualListGridType = listGrid.getListGridType();
    int actualLowerCount = listGrid.getLowerCount();
    List<ListGridAction> actualModalRowActions = listGrid.getModalRowActions();
    int actualOrder = listGrid.getOrder();
    int actualPageSize = listGrid.getPageSize();
    String actualPathOverride = listGrid.getPathOverride();
    List<ListGridRecord> actualRecords = listGrid.getRecords();
    List<ListGridActionGroup> actualRowActionGroups = listGrid.getRowActionGroups();
    List<ListGridAction> actualRowActions = listGrid.getRowActions();
    String actualSearchFieldsTemplateOverride = listGrid.getSearchFieldsTemplateOverride();
    List<SectionCrumb> actualSectionCrumbs = listGrid.getSectionCrumbs();
    String actualSectionKey = listGrid.getSectionKey();
    String actualSelectType = listGrid.getSelectType();
    String actualSelectizeUrl = listGrid.getSelectizeUrl();
    int actualStartIndex = listGrid.getStartIndex();
    String actualSubCollectionFieldName = listGrid.getSubCollectionFieldName();
    String actualTemplateOverride = listGrid.getTemplateOverride();
    List<ListGridActionGroup> actualToolbarActionGroups = listGrid.getToolbarActionGroups();
    List<ListGridAction> actualToolbarActions = listGrid.getToolbarActions();
    int actualTotalRecords = listGrid.getTotalRecords();
    int actualUpperCount = listGrid.getUpperCount();
    boolean actualIsHtmlEscapeMainEntityLinkResult = listGrid.isHtmlEscapeMainEntityLink();
    boolean actualIsMultiSelectCheckBoxOnlyResult = listGrid.isMultiSelectCheckBoxOnly();
    boolean actualIsPromptSearchResult = listGrid.isPromptSearch();
    boolean actualIsTotalCountLessThanPageSizeResult = listGrid.isTotalCountLessThanPageSize();

    // Assert that nothing has changed
    assertEquals("42", actualContainingEntityId);
    assertEquals("Class Name", actualClassName);
    assertEquals("External Entity Section Key", actualExternalEntitySectionKey);
    assertEquals("Fetch Type", actualFetchType);
    assertEquals("Field Builder", actualFieldBuilder);
    assertEquals("Friendly Name", actualFriendlyName);
    assertEquals("Help Text", actualHelpText);
    assertEquals("Id Property", actualIdProperty);
    assertEquals("Json Field Name", actualJsonFieldName);
    assertEquals("Json", actualJson);
    assertEquals("List Grid Type", actualListGridType);
    assertEquals("Path Override", actualPathOverride);
    assertEquals("Search Fields Template Override", actualSearchFieldsTemplateOverride);
    assertEquals("Section Key", actualSectionKey);
    assertEquals("Select Type", actualSelectType);
    assertEquals("Sub Collection Field Name", actualSubCollectionFieldName);
    assertEquals("Template Override", actualTemplateOverride);
    assertEquals("https://example.org/example", actualSelectizeUrl);
    assertEquals(1, actualOrder);
    assertEquals(1, actualStartIndex);
    assertEquals(1, actualTotalRecords);
    assertEquals(1L, actualFirstId);
    assertEquals(1L, actualLastId);
    assertEquals(3, actualLowerCount);
    assertEquals(3, actualPageSize);
    assertEquals(3, actualUpperCount);
    assertEquals(AddMethodType.PERSIST, actualAddMethodType);
    assertTrue(actualModalRowActions.isEmpty());
    assertTrue(actualRecords.isEmpty());
    assertTrue(actualRowActionGroups.isEmpty());
    assertTrue(actualRowActions.isEmpty());
    assertTrue(actualSectionCrumbs.isEmpty());
    assertTrue(actualToolbarActionGroups.isEmpty());
    assertTrue(actualToolbarActions.isEmpty());
    assertTrue(actualHeaderFields.isEmpty());
    assertTrue(actualHideFriendlyName);
    assertTrue(actualIsSortable);
    assertTrue(actualIsHtmlEscapeMainEntityLinkResult);
    assertTrue(actualIsMultiSelectCheckBoxOnlyResult);
    assertTrue(actualIsPromptSearchResult);
    assertTrue(actualIsTotalCountLessThanPageSizeResult);
    assertSame(modalRowActions, actualModalRowActions);
    assertSame(records, actualRecords);
    assertSame(rowActionGroups, actualRowActionGroups);
    assertSame(rowActions, actualRowActions);
    assertSame(toolbarActionGroups, actualToolbarActionGroups);
    assertSame(toolbarActions, actualToolbarActions);
    assertSame(headerFields, actualHeaderFields);
    assertSame(dataWrapper, actualDataWrapper);
    assertSame(fieldWrapper, actualFieldWrapper);
  }

  /**
   * Test {@link ListGrid#getManualFetch()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) ManualFetch is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getManualFetch()}
   */
  @Test
  public void testGetManualFetch_givenListGridManualFetchIsTrue_thenReturnTrue() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.setManualFetch(true);

    // Act and Assert
    assertTrue(listGrid.getManualFetch());
  }

  /**
   * Test {@link ListGrid#getManualFetch()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getManualFetch()}
   */
  @Test
  public void testGetManualFetch_givenListGrid_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ListGrid()).getManualFetch());
  }

  /**
   * Test {@link ListGrid#setSectionCrumbs(List)}.
   * <p>
   * Method under test: {@link ListGrid#setSectionCrumbs(List)}
   */
  @Test
  public void testSetSectionCrumbs() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act
    listGrid.setSectionCrumbs(sectionCrumbs);

    // Assert
    assertEquals("?sectionCrumbs=Section Identifier--Section Id,42--42", listGrid.getSectionCrumbRepresentation());
    assertSame(sectionCrumbs, listGrid.getSectionCrumbs());
  }

  /**
   * Test {@link ListGrid#setSectionCrumbs(List)}.
   * <p>
   * Method under test: {@link ListGrid#setSectionCrumbs(List)}
   */
  @Test
  public void testSetSectionCrumbs2() {
    // Arrange
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    listGrid.setSectionCrumbs(sectionCrumbs);

    // Assert
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    assertEquals("?sectionCrumbs=null--null", listGrid.getSectionCrumbRepresentation());
    assertSame(sectionCrumbs, listGrid.getSectionCrumbs());
  }

  /**
   * Test {@link ListGrid#setSectionCrumbs(List)}.
   * <ul>
   *   <li>Then {@link ListGrid} SectionCrumbRepresentation is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#setSectionCrumbs(List)}
   */
  @Test
  public void testSetSectionCrumbs_thenListGridSectionCrumbRepresentationIsEmptyString() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    listGrid.setSectionCrumbs(sectionCrumbs);

    // Assert
    assertEquals("", listGrid.getSectionCrumbRepresentation());
    assertSame(sectionCrumbs, listGrid.getSectionCrumbs());
  }

  /**
   * Test {@link ListGrid#setSectionCrumbs(List)}.
   * <ul>
   *   <li>Then {@link ListGrid} SectionCrumbRepresentation is
   * {@code ?sectionCrumbs=42--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#setSectionCrumbs(List)}
   */
  @Test
  public void testSetSectionCrumbs_thenListGridSectionCrumbRepresentationIsSectionCrumbs4242() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    listGrid.setSectionCrumbs(sectionCrumbs);

    // Assert
    assertEquals("?sectionCrumbs=42--42", listGrid.getSectionCrumbRepresentation());
    assertSame(sectionCrumbs, listGrid.getSectionCrumbs());
  }

  /**
   * Test {@link ListGrid#addCssClass(String)}.
   * <p>
   * Method under test: {@link ListGrid#addCssClass(String)}
   */
  @Test
  public void testAddCssClass() {
    // Arrange and Act
    listGrid.addCssClass("Class Name");

    // Assert
    assertEquals("Class Name", listGrid.getCssClassNames());
  }

  /**
   * Test {@link ListGrid#getCssClassNames()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) addCssClass space.</li>
   *   <li>Then return space.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getCssClassNames()}
   */
  @Test
  public void testGetCssClassNames_givenListGridAddCssClassSpace_thenReturnSpace() {
    // Arrange
    ListGrid listGrid = new ListGrid();
    listGrid.addCssClass(" ");

    // Act and Assert
    assertEquals(" ", listGrid.getCssClassNames());
  }

  /**
   * Test {@link ListGrid#getCssClassNames()}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getCssClassNames()}
   */
  @Test
  public void testGetCssClassNames_givenListGrid_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new ListGrid()).getCssClassNames());
  }

  /**
   * Test {@link ListGrid#getFirstSearchableFieldFriendlyName()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) FilterSortDisabled is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getFirstSearchableFieldFriendlyName()}
   */
  @Test
  public void testGetFirstSearchableFieldFriendlyName_givenFieldFilterSortDisabledIsNull() {
    // Arrange
    Field field = new Field();
    field.setFilterSortDisabled(null);

    LinkedHashSet<Field> headerFields = new LinkedHashSet<>();
    headerFields.add(field);

    ListGrid listGrid = new ListGrid();
    listGrid.setHeaderFields(headerFields);

    // Act and Assert
    assertNull(listGrid.getFirstSearchableFieldFriendlyName());
  }

  /**
   * Test {@link ListGrid#getFirstSearchableFieldFriendlyName()}.
   * <ul>
   *   <li>Given {@link Field} (default constructor) FilterSortDisabled is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ListGrid#getFirstSearchableFieldFriendlyName()}
   */
  @Test
  public void testGetFirstSearchableFieldFriendlyName_givenFieldFilterSortDisabledIsTrue() {
    // Arrange
    Field field = new Field();
    field.setFilterSortDisabled(true);

    LinkedHashSet<Field> headerFields = new LinkedHashSet<>();
    headerFields.add(field);

    ListGrid listGrid = new ListGrid();
    listGrid.setHeaderFields(headerFields);

    // Act and Assert
    assertNull(listGrid.getFirstSearchableFieldFriendlyName());
  }

  /**
   * Test new {@link ListGrid} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ListGrid}
   */
  @Test
  public void testNewListGrid() {
    // Arrange and Act
    ListGrid actualListGrid = new ListGrid();

    // Assert
    assertEquals("", actualListGrid.getClassName());
    assertEquals("", actualListGrid.getCssClassNames());
    assertEquals("", actualListGrid.getSectionCrumbRepresentation());
    assertEquals("DEFAULT", actualListGrid.getFetchType());
    assertNull(actualListGrid.canFilterAndSort);
    assertNull(actualListGrid.hideIdColumn);
    assertNull(actualListGrid.isReadOnly);
    assertNull(actualListGrid.manualFetch);
    assertNull(actualListGrid.getContainingEntityId());
    assertNull(actualListGrid.getExternalEntitySectionKey());
    assertNull(actualListGrid.getFieldBuilder());
    assertNull(actualListGrid.getFriendlyName());
    assertNull(actualListGrid.getHelpText());
    assertNull(actualListGrid.getIdProperty());
    assertNull(actualListGrid.getJson());
    assertNull(actualListGrid.getJsonFieldName());
    assertNull(actualListGrid.getListGridType());
    assertNull(actualListGrid.getPathOverride());
    assertNull(actualListGrid.getSearchFieldsTemplateOverride());
    assertNull(actualListGrid.getSectionKey());
    assertNull(actualListGrid.getSelectType());
    assertNull(actualListGrid.getSelectizeUrl());
    assertNull(actualListGrid.getSubCollectionFieldName());
    assertNull(actualListGrid.getTemplateOverride());
    assertNull(actualListGrid.getAddMethodType());
    assertNull(actualListGrid.getDataWrapper());
    assertNull(actualListGrid.getFieldWrapper());
    assertEquals(0, actualListGrid.getLowerCount());
    assertEquals(0, actualListGrid.getOrder());
    assertEquals(0, actualListGrid.getPageSize());
    assertEquals(0, actualListGrid.getStartIndex());
    assertEquals(0, actualListGrid.getTotalRecords());
    assertEquals(0, actualListGrid.getUpperCount());
    assertEquals(0L, actualListGrid.getFirstId());
    assertEquals(0L, actualListGrid.getLastId());
    assertFalse(actualListGrid.getHideFriendlyName());
    assertFalse(actualListGrid.getIsReadOnly());
    assertFalse(actualListGrid.getIsSortable());
    assertFalse(actualListGrid.getManualFetch());
    assertFalse(actualListGrid.isHtmlEscapeMainEntityLink());
    assertFalse(actualListGrid.isMultiSelectCheckBoxOnly());
    assertFalse(actualListGrid.isPromptSearch());
    assertFalse(actualListGrid.isSortable());
    assertFalse(actualListGrid.isTotalCountLessThanPageSize());
    assertTrue(actualListGrid.getActiveModalRowActions().isEmpty());
    assertTrue(actualListGrid.getActiveRowActionGroups().isEmpty());
    assertTrue(actualListGrid.getActiveRowActions().isEmpty());
    assertTrue(actualListGrid.getActiveToolbarActionGroups().isEmpty());
    assertTrue(actualListGrid.getActiveToolbarActions().isEmpty());
    assertTrue(actualListGrid.getModalRowActions().isEmpty());
    assertTrue(actualListGrid.getRecords().isEmpty());
    assertTrue(actualListGrid.getRowActionGroups().isEmpty());
    assertTrue(actualListGrid.getRowActions().isEmpty());
    assertTrue(actualListGrid.getSectionCrumbs().isEmpty());
    assertTrue(actualListGrid.getToolbarActionGroups().isEmpty());
    assertTrue(actualListGrid.getToolbarActions().isEmpty());
    assertTrue(actualListGrid.getHeaderFields().isEmpty());
    assertTrue(actualListGrid.getCanFilterAndSort());
    assertTrue(actualListGrid.getClickable());
    assertTrue(actualListGrid.getHideIdColumn());
    assertTrue(actualListGrid.isEmpty());
  }
}
