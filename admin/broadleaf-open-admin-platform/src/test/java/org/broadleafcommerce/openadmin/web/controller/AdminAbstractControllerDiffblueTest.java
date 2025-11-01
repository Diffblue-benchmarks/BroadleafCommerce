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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields2() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields3() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields4() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields5() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields6() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields7() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields8() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields9() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields10() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields11() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields12() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields13() {
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
   * Method under test:
   * {@link AdminAbstractController#setSpecializedNameForFields(DynamicEntityFormInfo, EntityForm)}
   */
  @Test
  public void testSetSpecializedNameForFields14() {
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
    verify(field2, atLeast(1)).getOrder();
    verify(field, atLeast(1)).getOrder();
    verify(field).setName(eq("null|Name"));
    verify(field2).setName(eq("null|Name"));
    verify(fieldGroup2).getFields();
    verify(tab).getFieldGroups();
  }

  /**
   * Method under test:
   * {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}
   */
  @Test
  public void testExtractDynamicFormFields() {
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
   * Method under test:
   * {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}
   */
  @Test
  public void testExtractDynamicFormFields2() {
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
   * Method under test:
   * {@link AdminAbstractController#extractDynamicFormFields(ClassMetadata, EntityForm)}
   */
  @Test
  public void testExtractDynamicFormFields3() {
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
   * Method under test: {@link AdminAbstractController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSectionKey(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getSectionKey(pathVars));
  }

  /**
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(new HashMap<>()).length);
  }

  /**
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria2() {
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
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria3() {
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
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria4() {
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
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria5() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortProperty", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria6() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("sortDirection", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria7() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria8() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", new ArrayList<>());

    // Act and Assert
    assertEquals(0, adminExportController.getCriteria(requestParams).length);
  }

  /**
   * Method under test: {@link AdminAbstractController#getCriteria(Map)}
   */
  @Test
  public void testGetCriteria9() {
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
   * Method under test: {@link AdminAbstractController#getSortDirections(Map)}
   */
  @Test
  public void testGetSortDirections() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSortDirections(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getSortDirections(Map)}
   */
  @Test
  public void testGetSortDirections2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("sortDirection", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getSortDirections(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getSortPropertyNames(Map)}
   */
  @Test
  public void testGetSortPropertyNames() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getSortPropertyNames(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getSortPropertyNames(Map)}
   */
  @Test
  public void testGetSortPropertyNames2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("sortProperty", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getSortPropertyNames(requestParams));
  }

  /**
   * Method under test:
   * {@link AdminAbstractController#getAddEntityTypes(ClassTree)}
   */
  @Test
  public void testGetAddEntityTypes() {
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
   * Method under test:
   * {@link AdminAbstractController#getAddEntityTypes(ClassTree)}
   */
  @Test
  public void testGetAddEntityTypes2() {
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
   * Method under test: {@link AdminAbstractController#getDefaultEntityType()}
   */
  @Test
  public void testGetDefaultEntityType() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getDefaultEntityType());
  }

  /**
   * Method under test: {@link AdminAbstractController#getDefaultEntityType()}
   */
  @Test
  public void testGetDefaultEntityType2() {
    // Arrange
    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(mock(AdminExporter.class));

    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(exporters);

    // Act and Assert
    assertNull(adminExportController.getDefaultEntityType());
  }

  /**
   * Method under test: {@link AdminAbstractController#getSectionCustomCriteria()}
   */
  @Test
  public void testGetSectionCustomCriteria() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getSectionCustomCriteria());
  }

  /**
   * Method under test: {@link AdminAbstractController#getSectionCustomCriteria()}
   */
  @Test
  public void testGetSectionCustomCriteria2() {
    // Arrange
    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(mock(AdminExporter.class));

    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(exporters);

    // Act and Assert
    assertNull(adminExportController.getSectionCustomCriteria());
  }

  /**
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getStartIndex(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex2() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getStartIndex(null));
  }

  /**
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", null);

    // Act and Assert
    assertNull(adminExportController.getStartIndex(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex4() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("startIndex", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getStartIndex(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex5() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getStartIndex(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getStartIndex(Map)}
   */
  @Test
  public void testGetStartIndex6() {
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
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex2() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getMaxIndex(null));
  }

  /**
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", null);

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex4() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxIndex", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex5() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getMaxIndex(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getMaxIndex(Map)}
   */
  @Test
  public void testGetMaxIndex6() {
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
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getMaxResults(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults2() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getMaxResults(null));
  }

  /**
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxResults", null);

    // Act and Assert
    assertNull(adminExportController.getMaxResults(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults4() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("maxResults", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getMaxResults(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults5() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getMaxResults(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getMaxResults(Map)}
   */
  @Test
  public void testGetMaxResults6() {
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
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getLastId(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId2() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getLastId(null));
  }

  /**
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lastId", null);

    // Act and Assert
    assertNull(adminExportController.getLastId(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId4() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lastId", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getLastId(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId5() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getLastId(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getLastId(Map)}
   */
  @Test
  public void testGetLastId6() {
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
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getFirstId(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId2() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getFirstId(null));
  }

  /**
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("firstId", null);

    // Act and Assert
    assertNull(adminExportController.getFirstId(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId4() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("firstId", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getFirstId(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId5() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getFirstId(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getFirstId(Map)}
   */
  @Test
  public void testGetFirstId6() {
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
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getUpperCount(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount2() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getUpperCount(null));
  }

  /**
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("upperCount", null);

    // Act and Assert
    assertNull(adminExportController.getUpperCount(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount4() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("upperCount", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getUpperCount(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount5() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getUpperCount(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getUpperCount(Map)}
   */
  @Test
  public void testGetUpperCount6() {
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
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getLowerCount(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount2() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getLowerCount(null));
  }

  /**
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lowerCount", null);

    // Act and Assert
    assertNull(adminExportController.getLowerCount(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount4() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("lowerCount", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getLowerCount(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount5() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getLowerCount(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getLowerCount(Map)}
   */
  @Test
  public void testGetLowerCount6() {
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
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.getPageSize(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize2() {
    // Arrange, Act and Assert
    assertNull((new AdminExportController()).getPageSize(null));
  }

  /**
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("pageSize", null);

    // Act and Assert
    assertNull(adminExportController.getPageSize(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize4() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("pageSize", new ArrayList<>());

    // Act and Assert
    assertNull(adminExportController.getPageSize(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize5() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(adminExportController.getPageSize(requestParams));
  }

  /**
   * Method under test: {@link AdminAbstractController#getPageSize(Map)}
   */
  @Test
  public void testGetPageSize6() {
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
   * Method under test:
   * {@link AdminAbstractController#createSectionCrumb(String, String)}
   */
  @Test
  public void testCreateSectionCrumb() {
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
   * Method under test:
   * {@link AdminAbstractController#createSectionCrumb(String, String)}
   */
  @Test
  public void testCreateSectionCrumb2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SectionCrumb actualCreateSectionCrumbResult = (new AdminExportController()).createSectionCrumb("/", "42");

    // Assert
    assertEquals("", actualCreateSectionCrumbResult.getSectionIdentifier());
    assertEquals("42", actualCreateSectionCrumbResult.getSectionId());
    assertNull(actualCreateSectionCrumbResult.getOriginalSectionIdentifier());
  }

  /**
   * Method under test:
   * {@link AdminAbstractController#createSectionCrumb(String, String)}
   */
  @Test
  public void testCreateSectionCrumb3() {
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
   * Method under test:
   * {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}
   */
  @Test
  public void testPopulateJsonValidationErrors() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();
    BindException result = new BindException("Target", "Object Name");

    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act
    JsonResponse actualPopulateJsonValidationErrorsResult = adminExportController.populateJsonValidationErrors(form,
        result, json);

    // Assert
    assertNull(actualPopulateJsonValidationErrorsResult.done());
    assertSame(json, actualPopulateJsonValidationErrorsResult);
  }

  /**
   * Method under test:
   * {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}
   */
  @Test
  public void testPopulateJsonValidationErrors2() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("errors", "errors"));
    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act
    JsonResponse actualPopulateJsonValidationErrorsResult = adminExportController.populateJsonValidationErrors(form,
        result, json);

    // Assert
    assertNull(actualPopulateJsonValidationErrorsResult.done());
    assertSame(json, actualPopulateJsonValidationErrorsResult);
  }

  /**
   * Method under test:
   * {@link AdminAbstractController#populateJsonValidationErrors(EntityForm, BindingResult, JsonResponse)}
   */
  @Test
  public void testPopulateJsonValidationErrors3() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();
    EntityForm form = new EntityForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("errorType", "errorType"));
    result.addError(new ObjectError("errors", "errors"));
    JsonResponse json = new JsonResponse(new MockHttpServletResponse());

    // Act
    JsonResponse actualPopulateJsonValidationErrorsResult = adminExportController.populateJsonValidationErrors(form,
        result, json);

    // Assert
    assertNull(actualPopulateJsonValidationErrorsResult.done());
    assertSame(json, actualPopulateJsonValidationErrorsResult);
  }

  /**
   * Method under test:
   * {@link AdminAbstractController#translateErrorMessage(ObjectError)}
   */
  @Test
  public void testTranslateErrorMessage() {
    // Arrange
    AdminExportController adminExportController = new AdminExportController();

    // Act and Assert
    assertNull(adminExportController.translateErrorMessage(new ObjectError("Object Name", "Default Message")));
  }

  /**
   * Method under test:
   * {@link AdminAbstractController#translateErrorMessage(ObjectError)}
   */
  @Test
  public void testTranslateErrorMessage2() {
    // Arrange
    ArrayList<AdminExporter> exporters = new ArrayList<>();
    exporters.add(mock(AdminExporter.class));

    AdminExportController adminExportController = new AdminExportController();
    adminExportController.setExporters(exporters);

    // Act and Assert
    assertNull(adminExportController.translateErrorMessage(new ObjectError("Object Name", "Default Message")));
  }
}
