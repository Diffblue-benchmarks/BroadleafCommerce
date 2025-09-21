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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RunWith(MockitoJUnitRunner.class)
public class AdminUserManagementControllerDiffblueTest {
  @Mock private AdminEntityService adminEntityService;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @InjectMocks private AdminUserManagementController adminUserManagementController;

  @Mock private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock private EntityFormValidator entityFormValidator;

  /**
   * Test {@link AdminUserManagementController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>Given {@code sectionKey}.
   *   <li>Then return {@code sectionKey}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminUserManagementController.getSectionKey(Map)"})
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminUserManagementController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminUserManagementController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link AdminUserManagementController#SECTION_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminUserManagementController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange, Act and Assert
    assertEquals(
        AdminUserManagementController.SECTION_KEY,
        adminUserManagementController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminUserManagementController#saveEntity(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link AdminUserManagementController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminUserManagementController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"
  })
  public void testSaveEntity() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(entityFormValidator.validate(
            Mockito.<EntityForm>any(), Mockito.<Entity>any(), Mockito.<Errors>any()))
        .thenReturn(true);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.updateEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/user-management/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminUserManagementController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/user-management/42"))
        .andExpect(redirectedUrl("/user-management/42"));
  }

  /**
   * Test {@link AdminUserManagementController#saveEntity(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link AdminUserManagementController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminUserManagementController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"
  })
  public void testSaveEntity2() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    when(entityFormValidator.validate(
            Mockito.<EntityForm>any(), Mockito.<Entity>any(), Mockito.<Errors>any()))
        .thenReturn(true);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.updateEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/user-management/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminUserManagementController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/user-management/42"))
        .andExpect(redirectedUrl("/user-management/42"));
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)} with {@code ef},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#getValue()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserManagementController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEfPathVars_givenCodeFieldGetValueReturnEmptyString() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("");
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue(null);

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("password", new EntityForm());

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("password"), isA(EntityForm.class));
    verify(codeField, atLeast(1)).getValue();
    verify(codeField).setValue(null);
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)} with {@code ef},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#getValue()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserManagementController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEfPathVars_givenCodeFieldGetValueReturnNull() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn(null);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue(null);

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("password", new EntityForm());

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("password"), isA(EntityForm.class));
    verify(codeField).getValue();
    verify(codeField).setValue(null);
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)} with {@code ef},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserManagementController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEfPathVars_givenFieldValueIsEmptyString() {
    // Arrange
    Field field = new Field();
    field.setValue("");

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("password", new EntityForm());

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("password"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)} with {@code ef},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is {@code Field}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserManagementController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEfPathVars_givenFieldValueIsField() {
    // Arrange
    Field field = new Field();
    field.setValue("Field");

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("password", new EntityForm());

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("password"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)} with {@code ef},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserManagementController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEfPathVars_givenFieldValueIsNull() {
    // Arrange
    Field field = new Field();
    field.setValue(null);

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("password", new EntityForm());

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("password"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)} with {@code ef},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserManagementController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEfPathVars_givenNull_whenEntityFormFindFieldReturnNull() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(null);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("password", new EntityForm());

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("password"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)} with {@code ef},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#setIsVisible(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminUserManagementController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEfPathVars_thenCallsSetIsVisible() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setIsVisible(Mockito.<Boolean>any());
    when(codeField.getValue()).thenReturn("42");
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue(null);

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("password", new EntityForm());

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("password"), isA(EntityForm.class));
    verify(codeField, atLeast(1)).getValue();
    verify(codeField, atLeast(1)).setIsVisible(false);
    verify(codeField).setValue(null);
  }
}
