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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.web.JsonResponse;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.server.service.export.AdminExporter;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.form.entity.FieldGroup;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class AdminAbstractControllerDiffblueTest {
  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getOrder()} return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenCodeFieldGetOrderReturnOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());
    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(1);
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(field);

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(field).getAlternateOrdering();
    verify(field).getName();
    verify(field, atLeast(1)).getOrder();
    verify(field).setName(eq("null|Name"));
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getOrder()} return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenCodeFieldGetOrderReturnOne2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());
    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(1);
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(field);

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(field).getAlternateOrdering();
    verify(field).getName();
    verify(field, atLeast(1)).getOrder();
    verify(field).setName(eq("null|Name"));
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getOrder()} return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenCodeFieldGetOrderReturnZero() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());
    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(0);
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(field);

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(field).getAlternateOrdering();
    verify(field).getName();
    verify(field, atLeast(1)).getOrder();
    verify(field).setName(eq("null|Name"));
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then calls {@link FieldGroup#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenFieldGroupAddFieldField_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then calls {@link FieldGroup#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenFieldGroupAddFieldField_thenCallsGetFields2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(new Field());

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addField {@link Field}
   * (default constructor).</li>
   *   <li>Then calls {@link FieldGroup#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenFieldGroupAddFieldField_thenCallsGetFields3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(new Field());
    fieldGroup2.addField(new Field());

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link FieldGroup} (default constructor) addListGrid
   * {@link ListGrid} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenFieldGroupAddListGridListGrid() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());

    FieldGroup fieldGroup2 = new FieldGroup();
    fieldGroup2.addListGrid(new ListGrid());
    fieldGroup2.addField(new Field());

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
    fieldGroupSet.add(fieldGroup2);
    fieldGroupSet.add(fieldGroup);
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link FieldGroup} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenHashSetAddFieldGroup() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
    fieldGroupSet.add(new FieldGroup());
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Field} (default
   * constructor).</li>
   *   <li>Then calls {@link FieldGroup#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenHashSetAddField_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    HashSet<Field> fieldSet = new HashSet<>();
    fieldSet.add(new Field());
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(fieldSet);

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
    fieldGroupSet.add(fieldGroup);
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Tab} (default
   * constructor).</li>
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenHashSetAddTab_thenCallsClearFieldsMap() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(new Tab());
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_givenHashSet_thenCallsClearFieldsMap() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link Tab#getFieldGroups()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_thenCallsGetFieldGroups() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(new HashSet<>());

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link FieldGroup#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.getFields()).thenReturn(new HashSet<>());

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();
    fieldGroupSet.add(fieldGroup);
    Tab tab = mock(Tab.class);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);
    EntityForm dynamicForm = mock(EntityForm.class);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(fieldGroup).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link Field#getFriendlyName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields_thenCallsGetFriendlyName() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    DynamicEntityFormInfo info = new DynamicEntityFormInfo();
    EntityForm dynamicForm = mock(EntityForm.class);

    HashSet<Tab> tabSet = new HashSet<>();
    Tab tab = mock(Tab.class);

    HashSet<FieldGroup> fieldGroupSet = new HashSet<>();

    FieldGroup fieldGroup = new FieldGroup();
    CodeField field = mock(CodeField.class);
    when(field.getOrder()).thenReturn(1);
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getAlternateOrdering()).thenReturn(true);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setName(Mockito.<String>any());
    fieldGroup.addField(field);
    CodeField field2 = mock(CodeField.class);
    when(field2.getFriendlyName()).thenReturn("Friendly Name");
    when(field2.getOrder()).thenReturn(1);
    when(field2.getAlternateOrdering()).thenReturn(true);
    when(field2.getName()).thenReturn("Name");
    doNothing().when(field2).setName(Mockito.<String>any());
    fieldGroup.addField(field2);
    fieldGroupSet.add(fieldGroup);
    FieldGroup fieldGroup2 = mock(FieldGroup.class);
    when(fieldGroup2.getFields()).thenReturn(new HashSet<>());
    fieldGroupSet.add(fieldGroup2);
    when(tab.getFieldGroups()).thenReturn(fieldGroupSet);
    tabSet.add(tab);
    when(dynamicForm.getTabs()).thenReturn(tabSet);
    doNothing().when(dynamicForm).clearFieldsMap();

    // Act
    adminExportController.setSpecializedNameForFields(info, dynamicForm);

    // Assert
    verify(dynamicForm).clearFieldsMap();
    verify(dynamicForm).getTabs();
    verify(field).getAlternateOrdering();
    verify(field2).getAlternateOrdering();
    verify(field).getFriendlyName();
    verify(field2).getFriendlyName();
    verify(field, atLeast(1)).getName();
    verify(field2, atLeast(1)).getName();
    verify(field, atLeast(1)).getOrder();
    verify(field2, atLeast(1)).getOrder();
    verify(field).setName(eq("null|Name"));
    verify(field2).setName(eq("null|Name"));
    verify(fieldGroup2).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Test
   * {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link Field} (default
   * constructor).</li>
   *   <li>Then calls {@link EntityForm#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}
   */
  @Test
  public void testExtractDynamicFormFields_givenHashMapFooIsField_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    ClassMetadata cmd = mock(ClassMetadata.class);
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    // Act
    adminExportController.extractDynamicFormFields(cmd, entityForm);

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entityForm).getFields();
  }

  /**
   * Test
   * {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link EntityForm#getFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}
   */
  @Test
  public void testExtractDynamicFormFields_thenCallsGetFields() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    ClassMetadata cmd = mock(ClassMetadata.class);
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());

    // Act
    adminExportController.extractDynamicFormFields(cmd, entityForm);

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entityForm).getFields();
  }

  /**
   * Test
   * {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then calls {@link ClassMetadata#setCeilingType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}
   */
  @Test
  public void testExtractDynamicFormFields_whenEntityForm_thenCallsSetCeilingType() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    ClassMetadata cmd = mock(ClassMetadata.class);
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    adminExportController.extractDynamicFormFields(cmd, new EntityForm());

    // Assert
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link AdminAbstractController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenSectionKey() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminAbstractController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_whenHashMap() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria_givenBiFunction() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("sortProperty", mock(BiFunction.class));
    requestParams.put("foo", new ArrayList<>());

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[0];
    assertEquals("foo", filterAndSortCriteria.getPropertyId());
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertNull(filterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualCriteria.length);
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return first element FilterValues Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria_givenFoo_thenReturnFirstElementFilterValuesEmpty() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("foo", new ArrayList<>());

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[0];
    assertEquals("foo", filterAndSortCriteria.getPropertyId());
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertNull(filterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualCriteria.length);
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return first element FilterValues Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria_givenFoo_thenReturnFirstElementFilterValuesEmpty2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("foo", new ArrayList<>());
    requestParams.put("foo", new ArrayList<>());

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[0];
    assertEquals("foo", filterAndSortCriteria.getPropertyId());
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertNull(filterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualCriteria.length);
    assertTrue(filterAndSortCriteria.getFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code maxIndex}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code maxIndex} is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria_givenMaxIndex_whenHashMapMaxIndexIsArrayList() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code sortDirection}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code sortDirection} is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria_givenSortDirection_whenHashMapSortDirectionIsArrayList() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortDirection", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code sortProperty}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code sortProperty} is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria_givenSortProperty_whenHashMapSortPropertyIsArrayList() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortProperty", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Given {@code startIndex}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code startIndex} is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria_givenStartIndex_whenHashMapStartIndexIsArrayList() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>Then return first element FilterValues size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria_thenReturnFirstElementFilterValuesSizeIsOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("sortProperty");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("foo", stringList);

    // Act
    FilterAndSortCriteria[] actualCriteria = adminExportController.getCriteria(requestParams);

    // Assert
    FilterAndSortCriteria filterAndSortCriteria = actualCriteria[0];
    assertEquals("foo", filterAndSortCriteria.getPropertyId());
    List<String> filterValues = filterAndSortCriteria.getFilterValues();
    assertEquals(1, filterValues.size());
    assertEquals("sortProperty", filterValues.get(0));
    assertNull(filterAndSortCriteria.getSortAscending());
    assertNull(filterAndSortCriteria.getSortDirection());
    assertNull(filterAndSortCriteria.getRestrictionType());
    assertEquals(1, actualCriteria.length);
    assertTrue(filterAndSortCriteria.getSpecialFilterValues().isEmpty());
    assertTrue(filterAndSortCriteria.isNullsLast());
    assertEquals(Integer.MIN_VALUE, filterAndSortCriteria.getOrder().intValue());
  }

  /**
   * Test {@link AdminAbstractController#getCriteria(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria_whenHashMap_thenReturnArrayLengthIsZero() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(new HashMap<>()).length);
  }

  /**
   * Test {@link AdminAbstractController#getSortDirections(Map)}.
   * <ul>
   *   <li>Given {@code sortDirection}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSortDirections(Map)}
   */
  @Test
  public void testGetSortDirections_givenSortDirection() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("sortDirection", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getSortDirections(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getSortDirections(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSortDirections(Map)}
   */
  @Test
  public void testGetSortDirections_whenHashMap() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSortDirections(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getSortPropertyNames(Map)}.
   * <ul>
   *   <li>Given {@code sortProperty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSortPropertyNames(Map)}
   */
  @Test
  public void testGetSortPropertyNames_givenSortProperty() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("sortProperty", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getSortPropertyNames(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getSortPropertyNames(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSortPropertyNames(Map)}
   */
  @Test
  public void testGetSortPropertyNames_whenHashMap() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSortPropertyNames(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getAddEntityTypes(ClassTree)}.
   * <ul>
   *   <li>Given {@link AdminExportController} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#getAddEntityTypes(ClassTree)}
   */
  @Test
  public void testGetAddEntityTypes_givenAdminExportController_thenReturnSizeIsOne() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    ClassTree classTree = new ClassTree();

    // Act
    List<ClassTree> actualAddEntityTypes = adminExportController.getAddEntityTypes(classTree);

    // Assert
    assertEquals(1, actualAddEntityTypes.size());
    assertSame(classTree, actualAddEntityTypes.get(0));
  }

  /**
   * Test {@link AdminAbstractController#getAddEntityTypes(ClassTree)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminExporter}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#getAddEntityTypes(ClassTree)}
   */
  @Test
  public void testGetAddEntityTypes_givenArrayListAddAdminExporter_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(mock(AdminExporter.class));

    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(exporters);
    ClassTree classTree = new ClassTree();

    // Act
    List<ClassTree> actualAddEntityTypes = adminExportController.getAddEntityTypes(classTree);

    // Assert
    assertEquals(1, actualAddEntityTypes.size());
    assertSame(classTree, actualAddEntityTypes.get(0));
  }

  /**
   * Test {@link AdminAbstractController#getDefaultEntityType()}.
   * <ul>
   *   <li>Given {@link AdminExportController} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getDefaultEntityType()}
   */
  @Test
  public void testGetDefaultEntityType_givenAdminExportController() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getDefaultEntityType());
  }

  /**
   * Test {@link AdminAbstractController#getDefaultEntityType()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminExporter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getDefaultEntityType()}
   */
  @Test
  public void testGetDefaultEntityType_givenArrayListAddAdminExporter() {
    // Arrange
    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(mock(AdminExporter.class));

    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(exporters);

    // Act and Assert
    assertNull(adminExportController.getDefaultEntityType());
  }

  /**
   * Test {@link AdminAbstractController#getSectionCustomCriteria()}.
   * <ul>
   *   <li>Given {@link AdminExportController} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCustomCriteria()}
   */
  @Test
  public void testGetSectionCustomCriteria_givenAdminExportController() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getSectionCustomCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getSectionCustomCriteria()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminExporter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getSectionCustomCriteria()}
   */
  @Test
  public void testGetSectionCustomCriteria_givenArrayListAddAdminExporter() {
    // Arrange
    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(mock(AdminExporter.class));

    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(exporters);

    // Act and Assert
    assertNull(adminExportController.getSectionCustomCriteria());
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getStartIndex(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code startIndex} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex_givenArrayList_whenHashMapStartIndexIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getStartIndex(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getStartIndex(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code startIndex} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex_givenNull_whenHashMapStartIndexIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", null);

    // Act and Assert
    assertNull(adminExportController.getStartIndex(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getStartIndex(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getStartIndex(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getStartIndex(null));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getMaxIndex(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code maxIndex} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex_givenArrayList_whenHashMapMaxIndexIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code maxIndex} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex_givenNull_whenHashMapMaxIndexIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", null);

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getMaxIndex(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getMaxIndex(null));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxResults", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getMaxResults(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code maxResults} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults_givenArrayList_whenHashMapMaxResultsIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxResults", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getMaxResults(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getMaxResults(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code maxResults} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults_givenNull_whenHashMapMaxResultsIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxResults", null);

    // Act and Assert
    assertNull(adminExportController.getMaxResults(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getMaxResults(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getMaxResults(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getMaxResults(null));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId_givenArrayListAdd42_thenReturnLongValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lastId", stringList);

    // Act and Assert
    assertEquals(42L, adminExportController.getLastId(requestParams).longValue());
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code lastId} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId_givenArrayList_whenHashMapLastIdIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lastId", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getLastId(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getLastId(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code lastId} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId_givenNull_whenHashMapLastIdIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lastId", null);

    // Act and Assert
    assertNull(adminExportController.getLastId(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getLastId(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getLastId(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getLastId(null));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId_givenArrayListAdd42_thenReturnLongValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("firstId", stringList);

    // Act and Assert
    assertEquals(42L, adminExportController.getFirstId(requestParams).longValue());
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code firstId} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId_givenArrayList_whenHashMapFirstIdIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("firstId", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getFirstId(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getFirstId(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code firstId} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId_givenNull_whenHashMapFirstIdIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("firstId", null);

    // Act and Assert
    assertNull(adminExportController.getFirstId(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getFirstId(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getFirstId(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getFirstId(null));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("upperCount", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getUpperCount(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code upperCount} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount_givenArrayList_whenHashMapUpperCountIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("upperCount", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getUpperCount(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getUpperCount(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code upperCount} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount_givenNull_whenHashMapUpperCountIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("upperCount", null);

    // Act and Assert
    assertNull(adminExportController.getUpperCount(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getUpperCount(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getUpperCount(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getUpperCount(null));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lowerCount", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getLowerCount(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code lowerCount} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount_givenArrayList_whenHashMapLowerCountIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lowerCount", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getLowerCount(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getLowerCount(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code lowerCount} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount_givenNull_whenHashMapLowerCountIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lowerCount", null);

    // Act and Assert
    assertNull(adminExportController.getLowerCount(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getLowerCount(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getLowerCount(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getLowerCount(null));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize_givenArrayListAdd42_thenReturnIntValueIsFortyTwo() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("pageSize", stringList);

    // Act and Assert
    assertEquals(42, adminExportController.getPageSize(requestParams).intValue());
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code pageSize} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize_givenArrayList_whenHashMapPageSizeIsArrayList_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("pageSize", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getPageSize(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getPageSize(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code pageSize} is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize_givenNull_whenHashMapPageSizeIsNull_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("pageSize", null);

    // Act and Assert
    assertNull(adminExportController.getPageSize(requestParams));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize_whenHashMap_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getPageSize(new HashMap<>()));
  }

  /**
   * Test {@link AdminAbstractController#getPageSize(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getPageSize(null));
  }

  /**
   * Test {@link AdminAbstractController#createSectionCrumb(String, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminExporter}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#createSectionCrumb(String, String)}
   */
  @Test
  public void testCreateSectionCrumb_givenArrayListAddAdminExporter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(mock(AdminExporter.class));

    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(exporters);

    // Act
    SectionCrumb actualCreateSectionCrumbResult = adminExportController.createSectionCrumb("Current Section", "42");

    // Assert
    assertEquals("42", actualCreateSectionCrumbResult.getSectionId());
    assertEquals("Current Section", actualCreateSectionCrumbResult.getSectionIdentifier());
    assertNull(actualCreateSectionCrumbResult.getOriginalSectionIdentifier());
  }

  /**
   * Test {@link AdminAbstractController#createSectionCrumb(String, String)}.
   * <ul>
   *   <li>Then return SectionIdentifier is {@code Current Section}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#createSectionCrumb(String, String)}
   */
  @Test
  public void testCreateSectionCrumb_thenReturnSectionIdentifierIsCurrentSection() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SectionCrumb actualCreateSectionCrumbResult = (new AdminExportController()).createSectionCrumb("Current Section",
        "42");

    // Assert
    assertEquals("42", actualCreateSectionCrumbResult.getSectionId());
    assertEquals("Current Section", actualCreateSectionCrumbResult.getSectionIdentifier());
    assertNull(actualCreateSectionCrumbResult.getOriginalSectionIdentifier());
  }

  /**
   * Test {@link AdminAbstractController#createSectionCrumb(String, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return SectionIdentifier is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#createSectionCrumb(String, String)}
   */
  @Test
  public void testCreateSectionCrumb_whenSlash_thenReturnSectionIdentifierIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SectionCrumb actualCreateSectionCrumbResult = (new AdminExportController()).createSectionCrumb("/", "42");

    // Assert
    assertEquals("", actualCreateSectionCrumbResult.getSectionIdentifier());
    assertEquals("42", actualCreateSectionCrumbResult.getSectionId());
    assertNull(actualCreateSectionCrumbResult.getOriginalSectionIdentifier());
  }

  /**
   * Test
   * {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}.
   * <p>
   * Method under test:
   * {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}
   */
  @Test
  public void testPopulateJsonValidationErrors() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("errors", "errors"));
    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act and Assert
    assertSame(json, adminExportController.populateJsonValidationErrors(form, result, json));
  }

  /**
   * Test
   * {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}.
   * <p>
   * Method under test:
   * {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}
   */
  @Test
  public void testPopulateJsonValidationErrors2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("errorType", "errorType"));
    result.addError(new ObjectError("errors", "errors"));
    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act and Assert
    assertSame(json, adminExportController.populateJsonValidationErrors(form, result, json));
  }

  /**
   * Test
   * {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}.
   * <ul>
   *   <li>When {@link BindException#BindException(Object, String)} with
   * {@code Target} and {@code Object Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}
   */
  @Test
  public void testPopulateJsonValidationErrors_whenBindExceptionWithTargetAndObjectName() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();
    BindException result = new BindException("Target", "Object Name");

    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act and Assert
    assertSame(json, adminExportController.populateJsonValidationErrors(form, result, json));
  }

  /**
   * Test {@link AdminAbstractController#translateErrorMessage(ObjectError)}.
   * <ul>
   *   <li>Given {@link AdminExportController} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#translateErrorMessage(ObjectError)}
   */
  @Test
  public void testTranslateErrorMessage_givenAdminExportController_thenReturnNull() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.translateErrorMessage(new ObjectError("Object Name", "Default Message")));
  }

  /**
   * Test {@link AdminAbstractController#translateErrorMessage(ObjectError)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminExporter}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAbstractController#translateErrorMessage(ObjectError)}
   */
  @Test
  public void testTranslateErrorMessage_givenArrayListAddAdminExporter_thenReturnNull() {
    // Arrange
    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(mock(AdminExporter.class));

    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(exporters);

    // Act and Assert
    assertNull(adminExportController.translateErrorMessage(new ObjectError("Object Name", "Default Message")));
  }
}
