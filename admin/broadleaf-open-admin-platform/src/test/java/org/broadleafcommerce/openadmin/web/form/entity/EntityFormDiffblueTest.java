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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {EntityForm.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityFormDiffblueTest {
  @Autowired
  private EntityForm entityForm;

  /**
   * Method under test: {@link EntityForm#getFields()}
   */
  @Test
  public void testGetFields() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    Map<String, Field> actualFields = entityForm.getFields();

    // Assert
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    assertTrue(actualFields.isEmpty());
    assertSame(entityForm.fields, actualFields);
  }

  /**
   * Method under test: {@link EntityForm#getFields()}
   */
  @Test
  public void testGetFields2() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    EntityForm ef = new EntityForm();
    entityForm.putDynamicForm("Name", ef);

    // Act
    Map<String, Field> actualFields = entityForm.getFields();

    // Assert
    Map<String, EntityForm> dynamicForms = entityForm.getDynamicForms();
    assertEquals(1, dynamicForms.size());
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(actualFields.isEmpty());
    assertSame(ef, dynamicForms.get("Name"));
    assertSame(entityForm.fields, actualFields);
  }

  /**
   * Method under test: {@link EntityForm#getFields()}
   */
  @Test
  public void testGetFields3() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    Map<String, Field> actualFields = entityForm.getFields();

    // Assert
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    assertTrue(actualFields.isEmpty());
    assertSame(entityForm.fields, actualFields);
  }

  /**
   * Method under test: {@link EntityForm#getFields()}
   */
  @Test
  public void testGetFields4() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setReadOnly(true);
    EntityForm ef = new EntityForm();
    entityForm.putDynamicForm("Name", ef);

    // Act
    Map<String, Field> actualFields = entityForm.getFields();

    // Assert
    Map<String, EntityForm> dynamicForms = entityForm.getDynamicForms();
    assertEquals(1, dynamicForms.size());
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(actualFields.isEmpty());
    assertSame(ef, dynamicForms.get("Name"));
    assertSame(entityForm.fields, actualFields);
  }

  /**
   * Method under test: {@link EntityForm#getAllListGrids()}
   */
  @Test
  public void testGetAllListGrids() {
    // Arrange, Act and Assert
    assertTrue((new EntityForm()).getAllListGrids().isEmpty());
  }

  /**
   * Method under test: {@link EntityForm#getAllListGrids()}
   */
  @Test
  public void testGetAllListGrids2() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act and Assert
    assertTrue(entityForm.getAllListGrids().isEmpty());
  }

  /**
   * Method under test: {@link EntityForm#findListGrid(String)}
   */
  @Test
  public void testFindListGrid() {
    // Arrange, Act and Assert
    assertNull(entityForm.findListGrid("Collection Field Name"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#findGroup(String)}
   */
  @Test
  public void testFindGroup() {
    // Arrange, Act and Assert
    assertNull(entityForm.findGroup("Group Name"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#findTab(String)}
   */
  @Test
  public void testFindTab() {
    // Arrange, Act and Assert
    assertNull(entityForm.findTab("Tab Key"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#findTabForField(String)}
   */
  @Test
  public void testFindTabForField() {
    // Arrange, Act and Assert
    assertNull(entityForm.findTabForField("Field Name"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#findField(String)}
   */
  @Test
  public void testFindField() {
    // Arrange, Act and Assert
    assertNull(entityForm.findField("Field Name"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#sanitizeFieldName(String)}
   */
  @Test
  public void testSanitizeFieldName() {
    // Arrange, Act and Assert
    assertEquals("Field Name", entityForm.sanitizeFieldName("Field Name"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#removeField(String)}
   */
  @Test
  public void testRemoveField() {
    // Arrange, Act and Assert
    assertNull(entityForm.removeField("Field Name"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#removeTab(Tab)}
   */
  @Test
  public void testRemoveTab() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    entityForm.removeTab(new Tab());

    // Assert
    assertTrue(entityForm.getTabs().isEmpty());
  }

  /**
   * Method under test: {@link EntityForm#removeTab(Tab)}
   */
  @Test
  public void testRemoveTab2() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    entityForm.removeTab(new Tab());

    // Assert
    assertTrue(entityForm.getTabs().isEmpty());
  }

  /**
   * Method under test: {@link EntityForm#removeTab(Tab)}
   */
  @Test
  public void testRemoveTab3() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    Tab tab = new Tab();
    tab.setTitle("Dr");
    tab.setKey("ThreadLocalManager.notify.orphans");

    // Act
    entityForm.removeTab(tab);

    // Assert
    assertEquals(1, entityForm.getTabs().size());
  }

  /**
   * Method under test: {@link EntityForm#removeTab(String)}
   */
  @Test
  public void testRemoveTab4() {
    // Arrange and Act
    entityForm.removeTab("Tab Name");

    // Assert that nothing has changed
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#removeListGrid(String)}
   */
  @Test
  public void testRemoveListGrid() {
    // Arrange, Act and Assert
    assertNull(entityForm.removeListGrid("Sub Collection Field Name"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#addAction(int, EntityFormAction)}
   */
  @Test
  public void testAddAction() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    EntityFormAction action = DefaultAdornedEntityFormActions.Add;

    // Act
    entityForm.addAction(1, action);

    // Assert
    List<EntityFormAction> actions = entityForm.getActions();
    assertEquals(1, actions.size());
    List<EntityFormAction> entityFormActionList = entityForm.actions;
    assertEquals(1, entityFormActionList.size());
    assertTrue(entityForm.getSectionCrumbsImpl().isEmpty());
    assertSame(action, actions.get(0));
    assertSame(action, entityFormActionList.get(0));
  }

  /**
   * Method under test: {@link EntityForm#addAction(int, EntityFormAction)}
   */
  @Test
  public void testAddAction2() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addAction(2, DefaultAdornedEntityFormActions.Add);
    entityForm.addAction(1, DefaultAdornedEntityFormActions.Add);
    EntityFormAction action = DefaultAdornedEntityFormActions.Add;

    // Act
    entityForm.addAction(1, action);

    // Assert
    List<EntityFormAction> entityFormActionList = entityForm.actions;
    assertEquals(3, entityFormActionList.size());
    assertTrue(entityForm.getSectionCrumbsImpl().isEmpty());
    List<EntityFormAction> expectedActions = entityForm.actions;
    assertEquals(expectedActions, entityForm.getActions());
    assertSame(action, entityFormActionList.get(0));
    assertSame(action, entityFormActionList.get(2));
  }

  /**
   * Method under test: {@link EntityForm#addAction(EntityFormAction)}
   */
  @Test
  public void testAddAction3() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    EntityFormAction action = DefaultAdornedEntityFormActions.Add;

    // Act
    entityForm.addAction(action);

    // Assert
    List<EntityFormAction> actions = entityForm.getActions();
    assertEquals(1, actions.size());
    List<EntityFormAction> entityFormActionList = entityForm.actions;
    assertEquals(1, entityFormActionList.size());
    assertTrue(entityForm.getSectionCrumbsImpl().isEmpty());
    assertSame(action, actions.get(0));
    assertSame(action, entityFormActionList.get(0));
  }

  /**
   * Method under test: {@link EntityForm#getDynamicForm(String)}
   */
  @Test
  public void testGetDynamicForm() {
    // Arrange, Act and Assert
    assertNull(entityForm.getDynamicForm("Name"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#putDynamicForm(String, EntityForm)}
   */
  @Test
  public void testPutDynamicForm() {
    // Arrange and Act
    entityForm.putDynamicForm("Name", entityForm);

    // Assert
    Map<String, EntityForm> dynamicForms = entityForm.getDynamicForms();
    assertEquals(1, dynamicForms.size());
    assertSame(entityForm, dynamicForms.get("Name"));
  }

  /**
   * Method under test: {@link EntityForm#getDynamicFormInfo(String)}
   */
  @Test
  public void testGetDynamicFormInfo() {
    // Arrange, Act and Assert
    assertNull(entityForm.getDynamicFormInfo("Name"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test:
   * {@link EntityForm#putDynamicFormInfo(String, DynamicEntityFormInfo)}
   */
  @Test
  public void testPutDynamicFormInfo() {
    // Arrange
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    // Act
    entityForm.putDynamicFormInfo("Name", info);

    // Assert
    Map<String, DynamicEntityFormInfo> dynamicFormInfos = entityForm.getDynamicFormInfos();
    assertEquals(1, dynamicFormInfos.size());
    assertSame(info, dynamicFormInfos.get("Name"));
  }

  /**
   * Method under test:
   * {@link EntityForm#putDynamicFormInfo(String, DynamicEntityFormInfo)}
   */
  @Test
  public void testPutDynamicFormInfo2() {
    // Arrange
    DynamicEntityFormInfo info = mock(DynamicEntityFormInfo.class);

    // Act
    entityForm.putDynamicFormInfo("Name", info);

    // Assert
    Map<String, DynamicEntityFormInfo> dynamicFormInfos = entityForm.getDynamicFormInfos();
    assertEquals(1, dynamicFormInfos.size());
    assertSame(info, dynamicFormInfos.get("Name"));
  }

  /**
   * Method under test: {@link EntityForm#setPreventSubmit()}
   */
  @Test
  public void testSetPreventSubmit() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    entityForm.setPreventSubmit();

    // Assert
    assertTrue(entityForm.getPreventSubmit());
  }

  /**
   * Method under test: {@link EntityForm#setReadOnly()}
   */
  @Test
  public void testSetReadOnly() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    entityForm.setReadOnly();

    // Assert
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#setReadOnly()}
   */
  @Test
  public void testSetReadOnly2() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    EntityForm ef = new EntityForm();
    entityForm.putDynamicForm("Name", ef);

    // Act
    entityForm.setReadOnly();

    // Assert
    Map<String, EntityForm> dynamicForms = entityForm.getDynamicForms();
    assertEquals(1, dynamicForms.size());
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
    assertSame(ef, dynamicForms.get("Name"));
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#setReadOnly()}
   */
  @Test
  public void testSetReadOnly3() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    entityForm.setReadOnly();

    // Assert
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#setReadOnly(boolean)}
   */
  @Test
  public void testSetReadOnly4() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    entityForm.setReadOnly(true);

    // Assert
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#setReadOnly(boolean)}
   */
  @Test
  public void testSetReadOnly5() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    EntityForm ef = new EntityForm();
    entityForm.putDynamicForm("Name", ef);

    // Act
    entityForm.setReadOnly(true);

    // Assert
    Map<String, EntityForm> dynamicForms = entityForm.getDynamicForms();
    assertEquals(1, dynamicForms.size());
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
    assertSame(ef, dynamicForms.get("Name"));
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#setReadOnly(boolean)}
   */
  @Test
  public void testSetReadOnly6() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    entityForm.setReadOnly(true);

    // Assert
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#getActions()}
   */
  @Test
  public void testGetActions() {
    // Arrange, Act and Assert
    assertTrue((new EntityForm()).getActions().isEmpty());
  }

  /**
   * Method under test: {@link EntityForm#findActionById(String)}
   */
  @Test
  public void testFindActionById() {
    // Arrange, Act and Assert
    assertNull(entityForm.findActionById("42"));
    assertTrue(entityForm.getAttributes().isEmpty());
    assertTrue(entityForm.getDynamicFormInfos().isEmpty());
    assertTrue(entityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = entityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(entityForm.fields.isEmpty());
    assertSame(entityForm.fields, fields);
  }

  /**
   * Method under test: {@link EntityForm#collapseToOneFieldGroup()}
   */
  @Test
  public void testCollapseToOneFieldGroup() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    FieldGroup actualCollapseToOneFieldGroupResult = entityForm.collapseToOneFieldGroup();

    // Assert
    assertNull(actualCollapseToOneFieldGroupResult.collapsed);
    assertNull(actualCollapseToOneFieldGroupResult.isUntitled);
    assertNull(actualCollapseToOneFieldGroupResult.isVisible);
    assertNull(actualCollapseToOneFieldGroupResult.getColumn());
    assertNull(actualCollapseToOneFieldGroupResult.getOrder());
    assertNull(actualCollapseToOneFieldGroupResult.getCustomTemplate());
    assertNull(actualCollapseToOneFieldGroupResult.getKey());
    assertNull(actualCollapseToOneFieldGroupResult.getTitle());
    assertNull(actualCollapseToOneFieldGroupResult.getToolTip());
    assertNull(actualCollapseToOneFieldGroupResult.title);
    assertEquals(1, entityForm.getTabs().size());
    assertFalse(actualCollapseToOneFieldGroupResult.getCollapsed());
    assertFalse(actualCollapseToOneFieldGroupResult.getIsUntitled());
    assertFalse(actualCollapseToOneFieldGroupResult.getIsVisible());
    assertFalse(actualCollapseToOneFieldGroupResult.hasFieldOrListGrid());
    assertTrue(actualCollapseToOneFieldGroupResult.getGroupAttributes().isEmpty());
    assertTrue(actualCollapseToOneFieldGroupResult.getFields().isEmpty());
    assertTrue(actualCollapseToOneFieldGroupResult.getGroupItems().isEmpty());
    assertTrue(actualCollapseToOneFieldGroupResult.getListGrids().isEmpty());
    assertTrue(actualCollapseToOneFieldGroupResult.alternateOrderedGroupItems.isEmpty());
    assertTrue(actualCollapseToOneFieldGroupResult.groupItems.isEmpty());
  }

  /**
   * Method under test: {@link EntityForm#collapseToOneFieldGroup()}
   */
  @Test
  public void testCollapseToOneFieldGroup2() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    FieldGroup actualCollapseToOneFieldGroupResult = entityForm.collapseToOneFieldGroup();

    // Assert
    assertNull(actualCollapseToOneFieldGroupResult.collapsed);
    assertNull(actualCollapseToOneFieldGroupResult.isUntitled);
    assertNull(actualCollapseToOneFieldGroupResult.isVisible);
    assertNull(actualCollapseToOneFieldGroupResult.getColumn());
    assertNull(actualCollapseToOneFieldGroupResult.getOrder());
    assertNull(actualCollapseToOneFieldGroupResult.getCustomTemplate());
    assertNull(actualCollapseToOneFieldGroupResult.getKey());
    assertNull(actualCollapseToOneFieldGroupResult.getTitle());
    assertNull(actualCollapseToOneFieldGroupResult.getToolTip());
    assertNull(actualCollapseToOneFieldGroupResult.title);
    assertEquals(1, entityForm.getTabs().size());
    assertFalse(actualCollapseToOneFieldGroupResult.getCollapsed());
    assertFalse(actualCollapseToOneFieldGroupResult.getIsUntitled());
    assertFalse(actualCollapseToOneFieldGroupResult.getIsVisible());
    assertFalse(actualCollapseToOneFieldGroupResult.hasFieldOrListGrid());
    assertTrue(actualCollapseToOneFieldGroupResult.getGroupAttributes().isEmpty());
    assertTrue(actualCollapseToOneFieldGroupResult.getFields().isEmpty());
    assertTrue(actualCollapseToOneFieldGroupResult.getGroupItems().isEmpty());
    assertTrue(actualCollapseToOneFieldGroupResult.getListGrids().isEmpty());
    assertTrue(actualCollapseToOneFieldGroupResult.alternateOrderedGroupItems.isEmpty());
    assertTrue(actualCollapseToOneFieldGroupResult.groupItems.isEmpty());
  }

  /**
   * Method under test: {@link EntityForm#getTranslationCeilingEntity()}
   */
  @Test
  public void testGetTranslationCeilingEntity() {
    // Arrange, Act and Assert
    assertNull((new EntityForm()).getTranslationCeilingEntity());
  }

  /**
   * Method under test: {@link EntityForm#getTranslationCeilingEntity()}
   */
  @Test
  public void testGetTranslationCeilingEntity2() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setTranslationCeilingEntity("foo");

    // Act and Assert
    assertEquals("foo", entityForm.getTranslationCeilingEntity());
  }

  /**
   * Method under test: {@link EntityForm#getTranslationId()}
   */
  @Test
  public void testGetTranslationId() {
    // Arrange, Act and Assert
    assertNull((new EntityForm()).getTranslationId());
  }

  /**
   * Method under test: {@link EntityForm#getTranslationId()}
   */
  @Test
  public void testGetTranslationId2() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setTranslationId("foo");

    // Act and Assert
    assertEquals("foo", entityForm.getTranslationId());
  }

  /**
   * Method under test: {@link EntityForm#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertEquals("", (new EntityForm()).getMainEntityName());
  }

  /**
   * Method under test: {@link EntityForm#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName2() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setMainEntityName("foo");

    // Act and Assert
    assertEquals("foo", entityForm.getMainEntityName());
  }

  /**
   * Method under test: {@link EntityForm#getSectionKey()}
   */
  @Test
  public void testGetSectionKey() {
    // Arrange, Act and Assert
    assertNull((new EntityForm()).getSectionKey());
  }

  /**
   * Method under test: {@link EntityForm#getSectionKey()}
   */
  @Test
  public void testGetSectionKey2() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setSectionKey("foo");

    // Act and Assert
    assertEquals("/foo", entityForm.getSectionKey());
  }

  /**
   * Method under test: {@link EntityForm#setTabs(Set)}
   */
  @Test
  public void testSetTabs() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    entityForm.setTabs(new HashSet<>());

    // Assert
    assertTrue(entityForm.getTabs().isEmpty());
  }

  /**
   * Method under test: {@link EntityForm#setTabs(Set)}
   */
  @Test
  public void testSetTabs2() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    HashSet<Tab> tabs = new HashSet<>();
    tabs.add(new Tab());

    // Act
    entityForm.setTabs(tabs);

    // Assert
    assertEquals(1, entityForm.getTabs().size());
  }

  /**
   * Method under test: {@link EntityForm#setTabs(Set)}
   */
  @Test
  public void testSetTabs3() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    HashSet<Tab> tabs = new HashSet<>();
    tabs.add(new Tab());
    tabs.add(new Tab());

    // Act
    entityForm.setTabs(tabs);

    // Assert
    assertEquals(1, entityForm.getTabs().size());
  }

  /**
   * Method under test: {@link EntityForm#setTabs(Set)}
   */
  @Test
  public void testSetTabs4() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    Tab tab = new Tab();
    tab.setTitle("Dr");
    tab.setKey("ThreadLocalManager.notify.orphans");

    HashSet<Tab> tabs = new HashSet<>();
    tabs.add(tab);

    // Act
    entityForm.setTabs(tabs);

    // Assert
    assertEquals(1, entityForm.getTabs().size());
  }

  /**
   * Method under test: {@link EntityForm#setSectionCrumbsImpl(List)}
   */
  @Test
  public void testSetSectionCrumbsImpl() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    entityForm.setSectionCrumbsImpl(sectionCrumbs);

    // Assert
    assertEquals("", entityForm.getSectionCrumbs());
    assertSame(sectionCrumbs, entityForm.getSectionCrumbsImpl());
  }

  /**
   * Method under test: {@link EntityForm#setSectionCrumbsImpl(List)}
   */
  @Test
  public void testSetSectionCrumbsImpl2() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    entityForm.setSectionCrumbsImpl(sectionCrumbs);

    // Assert
    assertEquals("42--42", entityForm.getSectionCrumbs());
    assertSame(sectionCrumbs, entityForm.getSectionCrumbsImpl());
  }

  /**
   * Method under test: {@link EntityForm#setSectionCrumbsImpl(List)}
   */
  @Test
  public void testSetSectionCrumbsImpl3() {
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
    entityForm.setSectionCrumbsImpl(sectionCrumbs);

    // Assert
    assertEquals("Section Identifier--Section Id,42--42", entityForm.getSectionCrumbs());
    assertSame(sectionCrumbs, entityForm.getSectionCrumbsImpl());
  }

  /**
   * Method under test: {@link EntityForm#setSectionCrumbsImpl(List)}
   */
  @Test
  public void testSetSectionCrumbsImpl4() {
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
    entityForm.setSectionCrumbsImpl(sectionCrumbs);

    // Assert
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    assertEquals("null--null", entityForm.getSectionCrumbs());
    assertSame(sectionCrumbs, entityForm.getSectionCrumbsImpl());
  }

  /**
   * Method under test: {@link EntityForm#getSectionCrumbs()}
   */
  @Test
  public void testGetSectionCrumbs() {
    // Arrange, Act and Assert
    assertEquals("", (new EntityForm()).getSectionCrumbs());
  }

  /**
   * Method under test: {@link EntityForm#getSectionCrumbs()}
   */
  @Test
  public void testGetSectionCrumbs2() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    EntityForm entityForm = new EntityForm();
    entityForm.setSectionCrumbsImpl(sectionCrumbs);

    // Act and Assert
    assertEquals("42--42", entityForm.getSectionCrumbs());
  }

  /**
   * Method under test: {@link EntityForm#getSectionCrumbs()}
   */
  @Test
  public void testGetSectionCrumbs3() {
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

    EntityForm entityForm = new EntityForm();
    entityForm.setSectionCrumbsImpl(sectionCrumbs);

    // Act and Assert
    assertEquals("42--42,42--42", entityForm.getSectionCrumbs());
  }

  /**
   * Method under test: {@link EntityForm#addTabFromTabMetadata(TabMetadata)}
   */
  @Test
  public void testAddTabFromTabMetadata() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertNull(entityForm.addTabFromTabMetadata(new TabMetadata()));
    assertEquals(1, entityForm.getTabs().size());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityForm#setActions(List)}
   *   <li>{@link EntityForm#setAttributes(Map)}
   *   <li>{@link EntityForm#setCeilingEntityClassname(String)}
   *   <li>{@link EntityForm#setDynamicFormInfos(Map)}
   *   <li>{@link EntityForm#setDynamicForms(Map)}
   *   <li>{@link EntityForm#setEncType(String)}
   *   <li>{@link EntityForm#setEntityType(String)}
   *   <li>{@link EntityForm#setId(String)}
   *   <li>{@link EntityForm#setIdProperty(String)}
   *   <li>{@link EntityForm#setJsErrorMap(String)}
   *   <li>{@link EntityForm#setMainEntityName(String)}
   *   <li>{@link EntityForm#setParentId(String)}
   *   <li>{@link EntityForm#setSectionKey(String)}
   *   <li>{@link EntityForm#setTranslationCeilingEntity(String)}
   *   <li>{@link EntityForm#setTranslationId(String)}
   *   <li>{@link EntityForm#clearFieldsMap()}
   *   <li>{@link EntityForm#getAttributes()}
   *   <li>{@link EntityForm#getCeilingEntityClassname()}
   *   <li>{@link EntityForm#getDynamicFormInfos()}
   *   <li>{@link EntityForm#getDynamicForms()}
   *   <li>{@link EntityForm#getEncType()}
   *   <li>{@link EntityForm#getEntityType()}
   *   <li>{@link EntityForm#getId()}
   *   <li>{@link EntityForm#getIdProperty()}
   *   <li>{@link EntityForm#getJsErrorMap()}
   *   <li>{@link EntityForm#getParentId()}
   *   <li>{@link EntityForm#getPreventSubmit()}
   *   <li>{@link EntityForm#getReadOnly()}
   *   <li>{@link EntityForm#getSectionCrumbsImpl()}
   *   <li>{@link EntityForm#getTabs()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    entityForm.setActions(new ArrayList<>());
    HashMap<String, Object> attributes = new HashMap<>();
    entityForm.setAttributes(attributes);
    entityForm.setCeilingEntityClassname("Ceiling Entity Classname");
    HashMap<String, DynamicEntityFormInfo> dynamicFormInfos = new HashMap<>();
    entityForm.setDynamicFormInfos(dynamicFormInfos);
    HashMap<String, EntityForm> dynamicForms = new HashMap<>();
    entityForm.setDynamicForms(dynamicForms);
    entityForm.setEncType("Enc Type");
    entityForm.setEntityType("Entity Type");
    entityForm.setId("42");
    entityForm.setIdProperty("Id Property");
    entityForm.setJsErrorMap("An error occurred");
    entityForm.setMainEntityName("Main Entity Name");
    entityForm.setParentId("42");
    entityForm.setSectionKey("Section Key");
    entityForm.setTranslationCeilingEntity("Translation Ceiling Entity");
    entityForm.setTranslationId("42");
    entityForm.clearFieldsMap();
    Map<String, Object> actualAttributes = entityForm.getAttributes();
    String actualCeilingEntityClassname = entityForm.getCeilingEntityClassname();
    Map<String, DynamicEntityFormInfo> actualDynamicFormInfos = entityForm.getDynamicFormInfos();
    Map<String, EntityForm> actualDynamicForms = entityForm.getDynamicForms();
    String actualEncType = entityForm.getEncType();
    String actualEntityType = entityForm.getEntityType();
    String actualId = entityForm.getId();
    String actualIdProperty = entityForm.getIdProperty();
    String actualJsErrorMap = entityForm.getJsErrorMap();
    String actualParentId = entityForm.getParentId();
    Boolean actualPreventSubmit = entityForm.getPreventSubmit();
    Boolean actualReadOnly = entityForm.getReadOnly();
    List<SectionCrumb> actualSectionCrumbsImpl = entityForm.getSectionCrumbsImpl();
    Set<Tab> actualTabs = entityForm.getTabs();

    // Assert that nothing has changed
    assertEquals("42", actualId);
    assertEquals("42", actualParentId);
    assertEquals("An error occurred", actualJsErrorMap);
    assertEquals("Ceiling Entity Classname", actualCeilingEntityClassname);
    assertEquals("Enc Type", actualEncType);
    assertEquals("Entity Type", actualEntityType);
    assertEquals("Id Property", actualIdProperty);
    assertFalse(actualPreventSubmit);
    assertFalse(actualReadOnly);
    assertTrue(actualSectionCrumbsImpl.isEmpty());
    assertTrue(actualAttributes.isEmpty());
    assertTrue(actualDynamicFormInfos.isEmpty());
    assertTrue(actualDynamicForms.isEmpty());
    assertTrue(actualTabs.isEmpty());
    assertSame(attributes, actualAttributes);
    assertSame(dynamicFormInfos, actualDynamicFormInfos);
    assertSame(dynamicForms, actualDynamicForms);
  }

  /**
   * Method under test: default or parameterless constructor of {@link EntityForm}
   */
  @Test
  public void testNewEntityForm() {
    // Arrange and Act
    EntityForm actualEntityForm = new EntityForm();

    // Assert
    assertEquals("", actualEntityForm.getMainEntityName());
    assertEquals("", actualEntityForm.getSectionCrumbs());
    assertEquals("id", actualEntityForm.getIdProperty());
    assertNull(actualEntityForm.getCeilingEntityClassname());
    assertNull(actualEntityForm.getEncType());
    assertNull(actualEntityForm.getEntityType());
    assertNull(actualEntityForm.getId());
    assertNull(actualEntityForm.getJsErrorMap());
    assertNull(actualEntityForm.getParentId());
    assertNull(actualEntityForm.getSectionKey());
    assertNull(actualEntityForm.getTranslationCeilingEntity());
    assertNull(actualEntityForm.getTranslationId());
    assertNull(actualEntityForm.mainEntityName);
    assertNull(actualEntityForm.sectionKey);
    assertNull(actualEntityForm.translationCeilingEntity);
    assertNull(actualEntityForm.translationId);
    assertFalse(actualEntityForm.getPreventSubmit());
    assertFalse(actualEntityForm.getReadOnly());
    assertTrue(actualEntityForm.getActions().isEmpty());
    assertTrue(actualEntityForm.getAllListGrids().isEmpty());
    assertTrue(actualEntityForm.getSectionCrumbsImpl().isEmpty());
    assertTrue(actualEntityForm.actions.isEmpty());
    assertTrue(actualEntityForm.getAttributes().isEmpty());
    assertTrue(actualEntityForm.getDynamicFormInfos().isEmpty());
    assertTrue(actualEntityForm.getDynamicForms().isEmpty());
    Map<String, Field> fields = actualEntityForm.getFields();
    assertTrue(fields.isEmpty());
    assertTrue(actualEntityForm.getTabs().isEmpty());
    assertSame(fields, actualEntityForm.fields);
  }
}
