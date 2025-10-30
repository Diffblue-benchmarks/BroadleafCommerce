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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@RunWith(MockitoJUnitRunner.class)
public class AdminStructuredContentControllerDiffblueTest {
  @InjectMocks
  private AdminStructuredContentController adminStructuredContentController;

  @Mock
  private AdminEntityService adminEntityService;

  @Mock
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock
  private EntityFormValidator entityFormValidator;

  /**
   * Test {@link AdminStructuredContentController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminStructuredContentController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminStructuredContentController.getSectionKey(Map)"})
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminStructuredContentController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminStructuredContentController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code structured-content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminStructuredContentController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminStructuredContentController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnStructuredContent() {
    // Arrange, Act and Assert
    assertEquals("structured-content", adminStructuredContentController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminStructuredContentController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    BindException result = new BindException(BroadleafRequestContext.getBroadleafRequestContext(true), "Object Name");

    // Act
    String actualSaveEntityResult = adminStructuredContentController.saveEntity(request, response, model, pathVars,
        "42", entityForm, result, new RedirectAttributesModelMap());

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("structured-content"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).updateEntity(isA(EntityForm.class), isA(String[].class), isA(List.class));
    verify(adminSectionCustomCriteriaService, atLeast(1)).mergeSectionCustomCriteria(eq("Class Name For Section"),
        isNull());
    verify(entityForm).getFields();
    verify(entityForm).putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityFormValidator).validate(isA(EntityForm.class), (Entity) isNull(), isA(Errors.class));
    assertEquals("redirect:/structured-content/42", actualSaveEntityResult);
  }

  /**
   * Test {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Given {@code constructForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminStructuredContentController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntity_givenConstructForm() throws Exception {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("constructForm", new EntityForm());
    BindException result = new BindException("Target", "Object Name");

    // Act
    adminStructuredContentController.saveEntity(request, response, model, pathVars, "42", entityForm, result,
        new RedirectAttributesModelMap());

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("structured-content"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).updateEntity(isA(EntityForm.class), isA(String[].class), isA(List.class));
    verify(adminSectionCustomCriteriaService, atLeast(1)).mergeSectionCustomCriteria(eq("Class Name For Section"),
        isNull());
    verify(entityFormValidator).validate(isA(EntityForm.class), (Entity) isNull(), isA(Errors.class));
    Map<String, DynamicEntityFormInfo> dynamicFormInfos = entityForm.getDynamicFormInfos();
    assertEquals(1, dynamicFormInfos.size());
    DynamicEntityFormInfo getResult = dynamicFormInfos.get("structuredContentType");
    assertEquals("constructForm", getResult.getCriteriaName());
    assertEquals("org.broadleafcommerce.cms.structure.domain.StructuredContent",
        getResult.getSecurityCeilingClassName());
    assertEquals("org.broadleafcommerce.cms.structure.domain.StructuredContentType", getResult.getCeilingClassName());
    assertEquals("structuredContentType", getResult.getPropertyName());
    assertNull(getResult.getCustomCriteriaOverride());
    assertNull(getResult.getPropertyValue());
  }

  /**
   * Test {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code redirect:/structured-content/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminStructuredContentController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntity_givenHashMap_thenReturnRedirectStructuredContent42() throws Exception {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualSaveEntityResult = adminStructuredContentController.saveEntity(request, response, model, pathVars,
        "42", entityForm, result, new RedirectAttributesModelMap());

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("structured-content"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).updateEntity(isA(EntityForm.class), isA(String[].class), isA(List.class));
    verify(adminSectionCustomCriteriaService, atLeast(1)).mergeSectionCustomCriteria(eq("Class Name For Section"),
        isNull());
    verify(entityForm).getFields();
    verify(entityForm).putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityFormValidator).validate(isA(EntityForm.class), (Entity) isNull(), isA(Errors.class));
    assertEquals("redirect:/structured-content/42", actualSaveEntityResult);
  }

  /**
   * Test {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminStructuredContentController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntity_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata() throws Exception {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());
    BindException result = new BindException("Target", "Object Name");

    // Act
    adminStructuredContentController.saveEntity(request, response, model, pathVars, "42", entityForm, result,
        new RedirectAttributesModelMap());

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("structured-content"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).updateEntity(isA(EntityForm.class), isA(String[].class), isA(List.class));
    verify(adminSectionCustomCriteriaService, atLeast(1)).mergeSectionCustomCriteria(eq("Class Name For Section"),
        isNull());
    verify(entityFormValidator).validate(isA(EntityForm.class), (Entity) isNull(), isA(Errors.class));
    Map<String, DynamicEntityFormInfo> dynamicFormInfos = entityForm.getDynamicFormInfos();
    assertEquals(1, dynamicFormInfos.size());
    DynamicEntityFormInfo getResult = dynamicFormInfos.get("structuredContentType");
    assertEquals("constructForm", getResult.getCriteriaName());
    assertEquals("org.broadleafcommerce.cms.structure.domain.StructuredContent",
        getResult.getSecurityCeilingClassName());
    assertEquals("org.broadleafcommerce.cms.structure.domain.StructuredContentType", getResult.getCeilingClassName());
    assertEquals("structuredContentType", getResult.getPropertyName());
    assertNull(getResult.getCustomCriteriaOverride());
    assertNull(getResult.getPropertyValue());
  }

  /**
   * Test {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) DynamicFormInfos size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminStructuredContentController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntity_whenEntityForm_thenEntityFormDynamicFormInfosSizeIsOne() throws Exception {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = new EntityForm();
    BindException result = new BindException("Target", "Object Name");

    // Act
    adminStructuredContentController.saveEntity(request, response, model, pathVars, "42", entityForm, result,
        new RedirectAttributesModelMap());

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("structured-content"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).updateEntity(isA(EntityForm.class), isA(String[].class), isA(List.class));
    verify(adminSectionCustomCriteriaService, atLeast(1)).mergeSectionCustomCriteria(eq("Class Name For Section"),
        isNull());
    verify(entityFormValidator).validate(isA(EntityForm.class), (Entity) isNull(), isA(Errors.class));
    Map<String, DynamicEntityFormInfo> dynamicFormInfos = entityForm.getDynamicFormInfos();
    assertEquals(1, dynamicFormInfos.size());
    DynamicEntityFormInfo getResult = dynamicFormInfos.get("structuredContentType");
    assertEquals("constructForm", getResult.getCriteriaName());
    assertEquals("org.broadleafcommerce.cms.structure.domain.StructuredContent",
        getResult.getSecurityCeilingClassName());
    assertEquals("org.broadleafcommerce.cms.structure.domain.StructuredContentType", getResult.getCeilingClassName());
    assertEquals("structuredContentType", getResult.getPropertyName());
    assertNull(getResult.getCustomCriteriaOverride());
    assertNull(getResult.getPropertyValue());
  }
}
