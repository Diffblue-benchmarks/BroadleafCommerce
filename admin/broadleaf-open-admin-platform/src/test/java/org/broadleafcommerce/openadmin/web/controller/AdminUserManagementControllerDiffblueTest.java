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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RunWith(MockitoJUnitRunner.class)
public class AdminUserManagementControllerDiffblueTest {
  @Mock
  private AdminEntityService adminEntityService;

  @Mock
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @InjectMocks
  private AdminUserManagementController adminUserManagementController;

  @Mock
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock
  private EntityFormValidator entityFormValidator;

  /**
   * Test {@link AdminUserManagementController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminUserManagementController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminUserManagementController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange, Act and Assert
    assertEquals(AdminUserManagementController.SECTION_KEY,
        adminUserManagementController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminUserManagementController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link AdminUserManagementController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminUserManagementController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntity() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(entityFormValidator.validate(Mockito.<EntityForm>any(), Mockito.<Entity>any(), Mockito.<Errors>any()))
        .thenReturn(true);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.updateEntity(Mockito.<EntityForm>any(), Mockito.<String[]>any(),
        Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user-management/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminUserManagementController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/user-management/42"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/user-management/42"));
  }

  /**
   * Test {@link AdminUserManagementController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link AdminUserManagementController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminUserManagementController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntity2() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    when(entityFormValidator.validate(Mockito.<EntityForm>any(), Mockito.<Entity>any(), Mockito.<Errors>any()))
        .thenReturn(true);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.updateEntity(Mockito.<EntityForm>any(), Mockito.<String[]>any(),
        Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user-management/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminUserManagementController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/user-management/42"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/user-management/42"));
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)} with {@code ef}, {@code pathVars}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getValue()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserManagementController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEfPathVars_givenCodeFieldGetValueReturnEmptyString() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("");
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField, atLeast(1)).getValue();
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)} with {@code ef}, {@code pathVars}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserManagementController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEfPathVars_givenField_whenEntityFormFindFieldReturnField() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)} with {@code ef}, {@code pathVars}.
   * <ul>
   *   <li>Then calls {@link Field#setIsVisible(Boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminUserManagementController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEfPathVars_thenCallsSetIsVisible() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setIsVisible(Mockito.<Boolean>any());
    when(codeField.getValue()).thenReturn("42");
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField, atLeast(1)).getValue();
    verify(codeField, atLeast(1)).setIsVisible(eq(false));
  }
}
