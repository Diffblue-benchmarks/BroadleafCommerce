/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
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
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.controller.AbstractAdminAbstractControllerExtensionHandler;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
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
public class AdminPageControllerDiffblueTest {
  @Mock
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Mock
  private AdminEntityService adminEntityService;

  @Mock
  private AdminNavigationService adminNavigationService;

  @InjectMocks
  private AdminPageController adminPageController;

  @Mock
  private FormBuilderService formBuilderService;

  @Mock
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock
  private EntityFormValidator entityFormValidator;

  /**
   * Test {@link AdminPageController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPageController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminPageController.getSectionKey(Map)"})
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminPageController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminPageController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminPageController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPageController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminPageController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange, Act and Assert
    assertEquals(AdminPageController.SECTION_KEY, adminPageController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminPageController#getDynamicForm(EntityForm, String)} with {@code ef}, {@code id}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>Then return PropertyValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPageController#getDynamicForm(EntityForm, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DynamicEntityFormInfo AdminPageController.getDynamicForm(EntityForm, String)"})
  public void testGetDynamicFormWithEfId_givenField_thenReturnPropertyValueIsNull() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    DynamicEntityFormInfo actualDynamicForm = adminPageController.getDynamicForm(ef, "42");

    // Assert
    verify(ef).findField(eq("pageTemplate"));
    assertEquals("constructForm", actualDynamicForm.getCriteriaName());
    assertEquals("org.broadleafcommerce.cms.page.domain.Page", actualDynamicForm.getSecurityCeilingClassName());
    assertEquals("org.broadleafcommerce.cms.page.domain.PageTemplate", actualDynamicForm.getCeilingClassName());
    assertEquals("pageTemplate", actualDynamicForm.getPropertyName());
    assertNull(actualDynamicForm.getCustomCriteriaOverride());
    assertNull(actualDynamicForm.getPropertyValue());
  }

  /**
   * Test {@link AdminPageController#getDynamicForm(EntityForm, String)} with {@code ef}, {@code id}.
   * <ul>
   *   <li>Then return PropertyValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPageController#getDynamicForm(EntityForm, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DynamicEntityFormInfo AdminPageController.getDynamicForm(EntityForm, String)"})
  public void testGetDynamicFormWithEfId_thenReturnPropertyValueIs42() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    DynamicEntityFormInfo actualDynamicForm = adminPageController.getDynamicForm(ef, "42");

    // Assert
    verify(ef).findField(eq("pageTemplate"));
    verify(codeField).getValue();
    assertEquals("42", actualDynamicForm.getPropertyValue());
    assertEquals("constructForm", actualDynamicForm.getCriteriaName());
    assertEquals("org.broadleafcommerce.cms.page.domain.Page", actualDynamicForm.getSecurityCeilingClassName());
    assertEquals("org.broadleafcommerce.cms.page.domain.PageTemplate", actualDynamicForm.getCeilingClassName());
    assertEquals("pageTemplate", actualDynamicForm.getPropertyName());
    assertNull(actualDynamicForm.getCustomCriteriaOverride());
  }

  /**
   * Test {@link AdminPageController#getDynamicForm(HttpServletRequest, HttpServletResponse, Model, Map, String, String)} with {@code request}, {@code response}, {@code model}, {@code pathVars}, {@code propertyName}, {@code propertyTypeId}.
   * <p>
   * Method under test: {@link AdminPageController#getDynamicForm(HttpServletRequest, HttpServletResponse, Model, Map, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminPageController.getDynamicForm(HttpServletRequest, HttpServletResponse, Model, Map, String, String)"})
  public void testGetDynamicFormWithRequestResponseModelPathVarsPropertyNamePropertyTypeId() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(formBuilderService.createEntityForm(Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new EntityForm());

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/pages/{propertyName}/dynamicForm", "Property Name")
        .param("propertyTypeId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminPageController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(7))
        .andExpect(MockMvcResultMatchers.model()
            .attributeExists("currentAdminSection", "currentUrl", "dynamicForm", "dynamicPropertyName", "entityForm",
                "sectionKey"))
        .andExpect(MockMvcResultMatchers.view().name("views/dynamicFormPartial"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("views/dynamicFormPartial"));
  }

  /**
   * Test {@link AdminPageController#getDynamicForm(HttpServletRequest, HttpServletResponse, Model, Map, String, String)} with {@code request}, {@code response}, {@code model}, {@code pathVars}, {@code propertyName}, {@code propertyTypeId}.
   * <p>
   * Method under test: {@link AdminPageController#getDynamicForm(HttpServletRequest, HttpServletResponse, Model, Map, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminPageController.getDynamicForm(HttpServletRequest, HttpServletResponse, Model, Map, String, String)"})
  public void testGetDynamicFormWithRequestResponseModelPathVarsPropertyNamePropertyTypeId2() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());
    when(formBuilderService.createEntityForm(Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/pages/{propertyName}/dynamicForm", "Property Name")
        .param("propertyTypeId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminPageController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(7))
        .andExpect(MockMvcResultMatchers.model()
            .attributeExists("currentAdminSection", "currentUrl", "dynamicForm", "dynamicPropertyName", "entityForm",
                "sectionKey"))
        .andExpect(MockMvcResultMatchers.view().name("views/dynamicFormPartial"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("views/dynamicFormPartial"));
  }

  /**
   * Test {@link AdminPageController#attachSectionSpecificInfo(PersistencePackageRequest, Map)} with {@code ppr}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminPageController#attachSectionSpecificInfo(PersistencePackageRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminPageController.attachSectionSpecificInfo(PersistencePackageRequest, Map)"})
  public void testAttachSectionSpecificInfoWithPprPathVars() {
    // Arrange
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();

    // Act
    adminPageController.attachSectionSpecificInfo(ppr, new HashMap<>());

    // Assert
    assertEquals("org.broadleafcommerce.cms.page.domain.Page", ppr.getSecurityCeilingEntityClassname());
  }

  /**
   * Test {@link AdminPageController#attachSectionSpecificInfo(PersistencePackageRequest, Map)} with {@code ppr}, {@code pathVars}.
   * <p>
   * Method under test: {@link AdminPageController#attachSectionSpecificInfo(PersistencePackageRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminPageController.attachSectionSpecificInfo(PersistencePackageRequest, Map)"})
  public void testAttachSectionSpecificInfoWithPprPathVars2() {
    // Arrange
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    doNothing().when(ppr).setSecurityCeilingEntityClassname(Mockito.<String>any());

    // Act
    adminPageController.attachSectionSpecificInfo(ppr, new HashMap<>());

    // Assert
    verify(ppr).setSecurityCeilingEntityClassname(eq("org.broadleafcommerce.cms.page.domain.Page"));
  }

  /**
   * Test {@link AdminPageController#addOnChangeTrigger(EntityForm)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPageController#addOnChangeTrigger(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminPageController.addOnChangeTrigger(EntityForm)"})
  public void testAddOnChangeTrigger_givenField_whenEntityFormFindFieldReturnField() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminPageController.addOnChangeTrigger(ef);

    // Assert
    verify(ef).findField(eq("pageTemplate"));
  }

  /**
   * Test {@link AdminPageController#addOnChangeTrigger(EntityForm)}.
   * <ul>
   *   <li>Then calls {@link Field#setOnChangeTrigger(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminPageController#addOnChangeTrigger(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminPageController.addOnChangeTrigger(EntityForm)"})
  public void testAddOnChangeTrigger_thenCallsSetOnChangeTrigger() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setOnChangeTrigger(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminPageController.addOnChangeTrigger(ef);

    // Assert
    verify(ef).findField(eq("pageTemplate"));
    verify(codeField).setOnChangeTrigger(eq("dynamicForm-pageTemplate"));
  }

  /**
   * Test {@link AdminPageController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link AdminPageController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminPageController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/pages/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminPageController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/pages/42"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/pages/42"));
  }

  /**
   * Test {@link AdminPageController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link AdminPageController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminPageController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/pages/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminPageController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/pages/42"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/pages/42"));
  }
}
