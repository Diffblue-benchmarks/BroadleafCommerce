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

@ContextConfiguration(classes = {EntityForm.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EntityFormDiffblueTest {
  @Autowired
  private EntityForm entityForm;

  /**
   * Test {@link EntityForm#getFields()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata
   * {@link TabMetadata} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getFields()}
   */
  @Test
  public void testGetFields_givenEntityFormAddTabFromTabMetadataTabMetadata_thenReturnEmpty() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act and Assert
    assertTrue(entityForm.getFields().isEmpty());
  }

  /**
   * Test {@link EntityForm#getFields()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) DynamicForm {@code Name}
   * is {@link EntityForm} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getFields()}
   */
  @Test
  public void testGetFields_givenEntityFormDynamicFormNameIsEntityForm_thenReturnEmpty() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("Name", new EntityForm());

    // Act and Assert
    assertTrue(entityForm.getFields().isEmpty());
  }

  /**
   * Test {@link EntityForm#getFields()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) ReadOnly is
   * {@code true}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getFields()}
   */
  @Test
  public void testGetFields_givenEntityFormReadOnlyIsTrue_thenReturnEmpty() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setReadOnly(true);
    entityForm.putDynamicForm("Name", new EntityForm());

    // Act and Assert
    assertTrue(entityForm.getFields().isEmpty());
  }

  /**
   * Test {@link EntityForm#getFields()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getFields()}
   */
  @Test
  public void testGetFields_givenEntityForm_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new EntityForm()).getFields().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
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
   * Test {@link EntityForm#getAllListGrids()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getAllListGrids()}
   */
  @Test
  public void testGetAllListGrids_givenEntityForm() {
    // Arrange, Act and Assert
    assertTrue((new EntityForm()).getAllListGrids().isEmpty());
  }

  /**
   * Test {@link EntityForm#getAllListGrids()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata
   * {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getAllListGrids()}
   */
  @Test
  public void testGetAllListGrids_givenEntityFormAddTabFromTabMetadataTabMetadata() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act and Assert
    assertTrue(entityForm.getAllListGrids().isEmpty());
  }

  /**
   * Test {@link EntityForm#findField(String)}.
   * <ul>
   *   <li>When {@code Field Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#findField(String)}
   */
  @Test
  public void testFindField_whenFieldName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(entityForm.findField("Field Name"));
    assertTrue(entityForm.fields.isEmpty());
  }

  /**
   * Test {@link EntityForm#removeTab(Tab)} with {@code tab}.
   * <ul>
   *   <li>Given {@code Dr}.</li>
   *   <li>When {@link Tab} (default constructor) Title is {@code Dr}.</li>
   *   <li>Then {@link EntityForm} (default constructor) Tabs size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#removeTab(Tab)}
   */
  @Test
  public void testRemoveTabWithTab_givenDr_whenTabTitleIsDr_thenEntityFormTabsSizeIsOne() {
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
   * Test {@link EntityForm#removeTab(Tab)} with {@code tab}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   *   <li>When {@link Tab} (default constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) Tabs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#removeTab(Tab)}
   */
  @Test
  public void testRemoveTabWithTab_givenEntityForm_whenTab_thenEntityFormTabsEmpty() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    entityForm.removeTab(new Tab());

    // Assert
    assertTrue(entityForm.getTabs().isEmpty());
  }

  /**
   * Test {@link EntityForm#removeTab(Tab)} with {@code tab}.
   * <ul>
   *   <li>When {@link Tab} (default constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) Tabs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#removeTab(Tab)}
   */
  @Test
  public void testRemoveTabWithTab_whenTab_thenEntityFormTabsEmpty() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    entityForm.removeTab(new Tab());

    // Assert
    assertTrue(entityForm.getTabs().isEmpty());
  }

  /**
   * Test {@link EntityForm#addAction(EntityFormAction)} with {@code action}.
   * <p>
   * Method under test: {@link EntityForm#addAction(EntityFormAction)}
   */
  @Test
  public void testAddActionWithAction() {
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
    assertSame(action, actions.get(0));
    assertSame(action, entityFormActionList.get(0));
  }

  /**
   * Test {@link EntityForm#addAction(int, EntityFormAction)} with
   * {@code position}, {@code action}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) Actions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#addAction(int, EntityFormAction)}
   */
  @Test
  public void testAddActionWithPositionAction_givenEntityForm_thenEntityFormActionsSizeIsOne() {
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
    assertSame(action, actions.get(0));
    assertSame(action, entityFormActionList.get(0));
  }

  /**
   * Test {@link EntityForm#addAction(int, EntityFormAction)} with
   * {@code position}, {@code action}.
   * <ul>
   *   <li>Then {@link EntityForm} (default constructor) Actions size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#addAction(int, EntityFormAction)}
   */
  @Test
  public void testAddActionWithPositionAction_thenEntityFormActionsSizeIsThree() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addAction(2, DefaultAdornedEntityFormActions.Add);
    entityForm.addAction(1, DefaultAdornedEntityFormActions.Add);
    EntityFormAction action = DefaultAdornedEntityFormActions.Add;

    // Act
    entityForm.addAction(1, action);

    // Assert
    List<EntityFormAction> actions = entityForm.getActions();
    assertEquals(3, actions.size());
    List<EntityFormAction> entityFormActionList = entityForm.actions;
    assertEquals(3, entityFormActionList.size());
    assertSame(action, actions.get(0));
    assertSame(action, actions.get(2));
    assertSame(action, entityFormActionList.get(0));
    assertSame(action, entityFormActionList.get(2));
  }

  /**
   * Test {@link EntityForm#putDynamicForm(String, EntityForm)}.
   * <p>
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
   * Test {@link EntityForm#putDynamicFormInfo(String, DynamicEntityFormInfo)}.
   * <ul>
   *   <li>Then {@link EntityForm} DynamicFormInfos {@code Name} is
   * {@link DynamicEntityFormInfo} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityForm#putDynamicFormInfo(String, DynamicEntityFormInfo)}
   */
  @Test
  public void testPutDynamicFormInfo_thenEntityFormDynamicFormInfosNameIsDynamicEntityFormInfo() {
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
   * Test {@link EntityForm#putDynamicFormInfo(String, DynamicEntityFormInfo)}.
   * <ul>
   *   <li>Then {@link EntityForm} DynamicFormInfos {@code Name} is
   * {@link DynamicEntityFormInfo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityForm#putDynamicFormInfo(String, DynamicEntityFormInfo)}
   */
  @Test
  public void testPutDynamicFormInfo_thenEntityFormDynamicFormInfosNameIsDynamicEntityFormInfo2() {
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
   * Test {@link EntityForm#setPreventSubmit()}.
   * <p>
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
   * Test {@link EntityForm#setReadOnly(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setReadOnly(boolean)}
   */
  @Test
  public void testSetReadOnlyWithBoolean_givenEntityForm() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    entityForm.setReadOnly(true);

    // Assert
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Test {@link EntityForm#setReadOnly(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata
   * {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setReadOnly(boolean)}
   */
  @Test
  public void testSetReadOnlyWithBoolean_givenEntityFormAddTabFromTabMetadataTabMetadata() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    entityForm.setReadOnly(true);

    // Assert
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Test {@link EntityForm#setReadOnly(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Then {@link EntityForm} (default constructor) DynamicForms size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setReadOnly(boolean)}
   */
  @Test
  public void testSetReadOnlyWithBoolean_thenEntityFormDynamicFormsSizeIsOne() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("Name", new EntityForm());

    // Act
    entityForm.setReadOnly(true);

    // Assert
    Map<String, EntityForm> dynamicForms = entityForm.getDynamicForms();
    assertEquals(1, dynamicForms.size());
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
    assertTrue(dynamicForms.get("Name").getReadOnly());
  }

  /**
   * Test {@link EntityForm#setReadOnly()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setReadOnly()}
   */
  @Test
  public void testSetReadOnly_givenEntityForm() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    entityForm.setReadOnly();

    // Assert
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Test {@link EntityForm#setReadOnly()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata
   * {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setReadOnly()}
   */
  @Test
  public void testSetReadOnly_givenEntityFormAddTabFromTabMetadataTabMetadata() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    entityForm.setReadOnly();

    // Assert
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Test {@link EntityForm#setReadOnly()}.
   * <ul>
   *   <li>Then {@link EntityForm} (default constructor) DynamicForms size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setReadOnly()}
   */
  @Test
  public void testSetReadOnly_thenEntityFormDynamicFormsSizeIsOne() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("Name", new EntityForm());

    // Act
    entityForm.setReadOnly();

    // Assert
    Map<String, EntityForm> dynamicForms = entityForm.getDynamicForms();
    assertEquals(1, dynamicForms.size());
    assertTrue(entityForm.fields.isEmpty());
    assertTrue(entityForm.getReadOnly());
    assertTrue(dynamicForms.get("Name").getReadOnly());
  }

  /**
   * Test {@link EntityForm#getActions()}.
   * <p>
   * Method under test: {@link EntityForm#getActions()}
   */
  @Test
  public void testGetActions() {
    // Arrange, Act and Assert
    assertTrue((new EntityForm()).getActions().isEmpty());
  }

  /**
   * Test {@link EntityForm#collapseToOneFieldGroup()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#collapseToOneFieldGroup()}
   */
  @Test
  public void testCollapseToOneFieldGroup_givenEntityForm() {
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
   * Test {@link EntityForm#collapseToOneFieldGroup()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata
   * {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#collapseToOneFieldGroup()}
   */
  @Test
  public void testCollapseToOneFieldGroup_givenEntityFormAddTabFromTabMetadataTabMetadata() {
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
   * Test {@link EntityForm#getTranslationCeilingEntity()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getTranslationCeilingEntity()}
   */
  @Test
  public void testGetTranslationCeilingEntity_givenEntityForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EntityForm()).getTranslationCeilingEntity());
  }

  /**
   * Test {@link EntityForm#getTranslationCeilingEntity()}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getTranslationCeilingEntity()}
   */
  @Test
  public void testGetTranslationCeilingEntity_thenReturnFoo() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setTranslationCeilingEntity("foo");

    // Act and Assert
    assertEquals("foo", entityForm.getTranslationCeilingEntity());
  }

  /**
   * Test {@link EntityForm#getTranslationId()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) TranslationId is
   * {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getTranslationId()}
   */
  @Test
  public void testGetTranslationId_givenEntityFormTranslationIdIsFoo_thenReturnFoo() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setTranslationId("foo");

    // Act and Assert
    assertEquals("foo", entityForm.getTranslationId());
  }

  /**
   * Test {@link EntityForm#getTranslationId()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getTranslationId()}
   */
  @Test
  public void testGetTranslationId_givenEntityForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EntityForm()).getTranslationId());
  }

  /**
   * Test {@link EntityForm#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) MainEntityName is
   * {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenEntityFormMainEntityNameIsFoo_thenReturnFoo() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setMainEntityName("foo");

    // Act and Assert
    assertEquals("foo", entityForm.getMainEntityName());
  }

  /**
   * Test {@link EntityForm#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenEntityForm_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new EntityForm()).getMainEntityName());
  }

  /**
   * Test {@link EntityForm#getSectionKey()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) SectionKey is
   * {@code foo}.</li>
   *   <li>Then return {@code /foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getSectionKey()}
   */
  @Test
  public void testGetSectionKey_givenEntityFormSectionKeyIsFoo_thenReturnFoo() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setSectionKey("foo");

    // Act and Assert
    assertEquals("/foo", entityForm.getSectionKey());
  }

  /**
   * Test {@link EntityForm#getSectionKey()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getSectionKey()}
   */
  @Test
  public void testGetSectionKey_givenEntityForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EntityForm()).getSectionKey());
  }

  /**
   * Test {@link EntityForm#setTabs(Set)}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor) Title is {@code Dr}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@link Tab} (default
   * constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) Tabs is
   * {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setTabs(Set)}
   */
  @Test
  public void testSetTabs_givenTabTitleIsDr_whenHashSetAddTab_thenEntityFormTabsIsHashSet() {
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
    assertEquals(tabs, entityForm.getTabs());
  }

  /**
   * Test {@link EntityForm#setTabs(Set)}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()} add {@link Tab} (default
   * constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) Tabs is
   * {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setTabs(Set)}
   */
  @Test
  public void testSetTabs_givenTab_whenHashSetAddTab_thenEntityFormTabsIsHashSet() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    HashSet<Tab> tabs = new HashSet<>();
    tabs.add(new Tab());

    // Act
    entityForm.setTabs(tabs);

    // Assert
    assertEquals(tabs, entityForm.getTabs());
  }

  /**
   * Test {@link EntityForm#setTabs(Set)}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()} add {@link Tab} (default
   * constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) Tabs size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setTabs(Set)}
   */
  @Test
  public void testSetTabs_givenTab_whenHashSetAddTab_thenEntityFormTabsSizeIsOne() {
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
   * Test {@link EntityForm#setTabs(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then {@link EntityForm} (default constructor) Tabs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setTabs(Set)}
   */
  @Test
  public void testSetTabs_whenHashSet_thenEntityFormTabsEmpty() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act
    entityForm.setTabs(new HashSet<>());

    // Assert
    assertTrue(entityForm.getTabs().isEmpty());
  }

  /**
   * Test {@link EntityForm#setSectionCrumbsImpl(List)}.
   * <p>
   * Method under test: {@link EntityForm#setSectionCrumbsImpl(List)}
   */
  @Test
  public void testSetSectionCrumbsImpl() {
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
   * Test {@link EntityForm#setSectionCrumbsImpl(List)}.
   * <ul>
   *   <li>Then {@link EntityForm} SectionCrumbs is {@code 42--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setSectionCrumbsImpl(List)}
   */
  @Test
  public void testSetSectionCrumbsImpl_thenEntityFormSectionCrumbsIs4242() {
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
   * Test {@link EntityForm#setSectionCrumbsImpl(List)}.
   * <ul>
   *   <li>Then {@link EntityForm} SectionCrumbs is {@code null--null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setSectionCrumbsImpl(List)}
   */
  @Test
  public void testSetSectionCrumbsImpl_thenEntityFormSectionCrumbsIsNullNull() {
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
   * Test {@link EntityForm#setSectionCrumbsImpl(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link EntityForm} SectionCrumbs is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#setSectionCrumbsImpl(List)}
   */
  @Test
  public void testSetSectionCrumbsImpl_whenArrayList_thenEntityFormSectionCrumbsIsEmptyString() {
    // Arrange
    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();

    // Act
    entityForm.setSectionCrumbsImpl(sectionCrumbs);

    // Assert
    assertEquals("", entityForm.getSectionCrumbs());
    assertSame(sectionCrumbs, entityForm.getSectionCrumbsImpl());
  }

  /**
   * Test {@link EntityForm#getSectionCrumbs()}.
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getSectionCrumbs()}
   */
  @Test
  public void testGetSectionCrumbs_givenEntityForm_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new EntityForm()).getSectionCrumbs());
  }

  /**
   * Test {@link EntityForm#getSectionCrumbs()}.
   * <ul>
   *   <li>Then return {@code 42--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getSectionCrumbs()}
   */
  @Test
  public void testGetSectionCrumbs_thenReturn4242() {
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
   * Test {@link EntityForm#getSectionCrumbs()}.
   * <ul>
   *   <li>Then return {@code 42--42,42--42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#getSectionCrumbs()}
   */
  @Test
  public void testGetSectionCrumbs_thenReturn42424242() {
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
   * Test {@link EntityForm#addTabFromTabMetadata(TabMetadata)}.
   * <ul>
   *   <li>When {@link TabMetadata} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityForm#addTabFromTabMetadata(TabMetadata)}
   */
  @Test
  public void testAddTabFromTabMetadata_whenTabMetadata_thenReturnNull() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertNull(entityForm.addTabFromTabMetadata(new TabMetadata()));
    assertEquals(1, entityForm.getTabs().size());
  }

  /**
   * Test new {@link EntityForm} (default constructor).
   * <p>
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
