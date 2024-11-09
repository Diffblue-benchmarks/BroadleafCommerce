/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.controller.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.mockito.Mockito;

public class AdminProductControllerDiffblueTest {
  /**
   * Test {@link AdminProductController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminProductController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminProductController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminProductController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminProductController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminProductController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();

    // Act and Assert
    assertEquals(AdminProductController.SECTION_KEY, adminProductController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn(null);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    doNothing().when(codeField).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField, atLeast(1)).getValue();
    verify(codeField).setFieldType(eq("hidden"));
    verify(codeField).withAttribute(eq("overriddenUrl"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.getValue()).thenReturn(null);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    doNothing().when(codeField2).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField2);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField2, atLeast(1)).getValue();
    verify(codeField2).setFieldType(eq("hidden"));
    verify(codeField2).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("sourceField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.getValue()).thenReturn(null);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    doNothing().when(codeField3).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField3);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField3, atLeast(1)).getValue();
    verify(codeField3).setFieldType(eq("hidden"));
    verify(codeField3).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.getValue()).thenReturn(null);
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField3);
    doNothing().when(codeField4).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField4);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField4, atLeast(1)).getValue();
    verify(codeField4).setFieldType(eq("hidden"));
    verify(codeField4).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField3).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField2).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField3);
    CodeField codeField5 = mock(CodeField.class);
    when(codeField5.getValue()).thenReturn(null);
    when(codeField5.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField4);
    doNothing().when(codeField5).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField5);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField5, atLeast(1)).getValue();
    verify(codeField5).setFieldType(eq("hidden"));
    verify(codeField5).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("prefix"), isNull());
    verify(codeField2).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField4).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField3).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return
   * {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenField_whenEntityFormFindFieldReturnField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Then calls {@link Field#withFieldType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_thenCallsWithFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withFieldType(Mockito.<String>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField3);
    CodeField codeField5 = mock(CodeField.class);
    when(codeField5.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField4);
    CodeField codeField6 = mock(CodeField.class);
    when(codeField6.getValue()).thenReturn(null);
    when(codeField6.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField5);
    doNothing().when(codeField6).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField6);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField6, atLeast(1)).getValue();
    verify(codeField6).setFieldType(eq("hidden"));
    verify(codeField6).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("prefix"), isNull());
    verify(codeField3).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField5).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField4).withAttribute(eq("toggleField"), isA(Object.class));
    verify(codeField).withFieldType(eq("generated_url"));
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with
   * {@code entityForm}, {@code pathVars}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyEntityFormWithEntityFormPathVars_givenField() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with
   * {@code entityForm}, {@code pathVars}.
   * <ul>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyEntityFormWithEntityFormPathVars_thenCallsGetValue() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");
    doNothing().when(codeField).setReadOnly(Mockito.<Boolean>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField).getValue();
    verify(codeField).setReadOnly(eq(true));
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();

    DynamicResultSet drs = new DynamicResultSet();
    drs.setRecords(new Entity[]{new Entity()});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{new Entity()});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(3, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
    assertEquals("42", getResult2.get(AdminProductController.SELECTIZE_NAME_PROPERTY));
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(3, getResult2.size());
    assertNull(getResult2.get("alternateId"));
    assertNull(getResult2.get("id"));
    assertNull(getResult2.get(AdminProductController.SELECTIZE_NAME_PROPERTY));
  }

  /**
   * Test
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.</li>
   *   <li>Then return {@code options} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  public void testConstructSelectizeOptionMap_whenDynamicResultSet_thenReturnOptionsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminProductController adminProductController = new AdminProductController();
    DynamicResultSet drs = new DynamicResultSet();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }
}
