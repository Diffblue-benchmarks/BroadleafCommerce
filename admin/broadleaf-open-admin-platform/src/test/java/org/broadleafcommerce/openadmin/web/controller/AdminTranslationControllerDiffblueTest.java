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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.service.TranslationService;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.remote.EntityOperationType;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.form.TranslationForm;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.DefaultAdornedEntityFormActions;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormAction;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.service.TranslationFormAction;
import org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderService;
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

@RunWith(MockitoJUnitRunner.class)
public class AdminTranslationControllerDiffblueTest {
  @Mock private AdminEntityService adminEntityService;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @InjectMocks private AdminTranslationController adminTranslationController;

  @Mock
  private AdminTranslationControllerExtensionManager adminTranslationControllerExtensionManager;

  @Mock private SecurityVerifier securityVerifier;

  @Mock private TranslationFormBuilderService translationFormBuilderService;

  @Mock private TranslationService translationService;

  /**
   * Test {@link AdminTranslationController#viewTranslation(HttpServletRequest, HttpServletResponse,
   * Model, TranslationForm, BindingResult)}.
   *
   * <p>Method under test: {@link AdminTranslationController#viewTranslation(HttpServletRequest,
   * HttpServletResponse, Model, TranslationForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminTranslationController.viewTranslation(HttpServletRequest, HttpServletResponse, Model, TranslationForm, BindingResult)"
  })
  public void testViewTranslation() throws Exception {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());

    AdminTranslationControllerExtensionHandler adminTranslationControllerExtensionHandler =
        mock(AdminTranslationControllerExtensionHandler.class);
    when(adminTranslationControllerExtensionHandler.applyTransformation(
            Mockito.<TranslationForm>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminTranslationControllerExtensionManager.getProxy())
        .thenReturn(adminTranslationControllerExtensionHandler);
    when(translationFormBuilderService.buildListGrid(
            Mockito.<List<Translation>>any(), anyBoolean()))
        .thenReturn(new ListGrid());
    when(translationService.getTranslations(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/translation");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminTranslationController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(5))
        .andExpect(
            model()
                .attributeExists("currentUrl", "form", "listGrid", "modalHeaderType", "viewType"))
        .andExpect(view().name(AdminAbstractController.MODAL_CONTAINER_VIEW))
        .andExpect(forwardedUrl(AdminAbstractController.MODAL_CONTAINER_VIEW));
  }

  /**
   * Test {@link AdminTranslationController#showAddTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}.
   *
   * <p>Method under test: {@link AdminTranslationController#showAddTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminTranslationController.showAddTranslation(HttpServletRequest, HttpServletResponse, Model, Map, TranslationForm, BindingResult)"
  })
  public void testShowAddTranslation() throws Exception {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(translationFormBuilderService.buildTranslationForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<TranslationForm>any(),
            Mockito.<TranslationFormAction>any()))
        .thenReturn(new EntityForm());

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/translation/add");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminTranslationController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(5))
        .andExpect(
            model()
                .attributeExists("currentUrl", "entityForm", "form", "modalHeaderType", "viewType"))
        .andExpect(view().name(AdminAbstractController.MODAL_CONTAINER_VIEW))
        .andExpect(forwardedUrl(AdminAbstractController.MODAL_CONTAINER_VIEW));
  }

  /**
   * Test {@link AdminTranslationController#showAddTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}.
   *
   * <p>Method under test: {@link AdminTranslationController#showAddTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminTranslationController.showAddTranslation(HttpServletRequest, HttpServletResponse, Model, Map, TranslationForm, BindingResult)"
  })
  public void testShowAddTranslation2() throws Exception {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {});

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(translationFormBuilderService.buildTranslationForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<TranslationForm>any(),
            Mockito.<TranslationFormAction>any()))
        .thenReturn(new EntityForm());

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/translation/add");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminTranslationController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(5))
        .andExpect(
            model()
                .attributeExists("currentUrl", "entityForm", "form", "modalHeaderType", "viewType"))
        .andExpect(view().name(AdminAbstractController.MODAL_CONTAINER_VIEW))
        .andExpect(forwardedUrl(AdminAbstractController.MODAL_CONTAINER_VIEW));
  }

  /**
   * Test {@link AdminTranslationController#deleteTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}.
   *
   * <p>Method under test: {@link AdminTranslationController#deleteTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminTranslationController.deleteTranslation(HttpServletRequest, HttpServletResponse, Model, Map, TranslationForm, BindingResult)"
  })
  public void testDeleteTranslation() throws Exception {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

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
    when(adminEntityService.removeEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    AdminTranslationControllerExtensionHandler adminTranslationControllerExtensionHandler =
        mock(AdminTranslationControllerExtensionHandler.class);
    when(adminTranslationControllerExtensionHandler.applyTransformation(
            Mockito.<TranslationForm>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminTranslationControllerExtensionManager.getProxy())
        .thenReturn(adminTranslationControllerExtensionHandler);
    when(translationFormBuilderService.buildListGrid(
            Mockito.<List<Translation>>any(), anyBoolean()))
        .thenReturn(new ListGrid());
    when(translationFormBuilderService.buildTranslationForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<TranslationForm>any(),
            Mockito.<TranslationFormAction>any()))
        .thenReturn(new EntityForm());
    when(translationService.getTranslations(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/translation/delete");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminTranslationController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(5))
        .andExpect(
            model()
                .attributeExists("currentUrl", "form", "listGrid", "modalHeaderType", "viewType"))
        .andExpect(view().name(AdminAbstractController.MODAL_CONTAINER_VIEW))
        .andExpect(forwardedUrl(AdminAbstractController.MODAL_CONTAINER_VIEW));
  }

  /**
   * Test {@link AdminTranslationController#deleteTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}.
   *
   * <p>Method under test: {@link AdminTranslationController#deleteTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminTranslationController.deleteTranslation(HttpServletRequest, HttpServletResponse, Model, Map, TranslationForm, BindingResult)"
  })
  public void testDeleteTranslation2() throws Exception {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);

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
    when(adminEntityService.removeEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    AdminTranslationControllerExtensionHandler adminTranslationControllerExtensionHandler =
        mock(AdminTranslationControllerExtensionHandler.class);
    when(adminTranslationControllerExtensionHandler.applyTransformation(
            Mockito.<TranslationForm>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminTranslationControllerExtensionManager.getProxy())
        .thenReturn(adminTranslationControllerExtensionHandler);
    when(translationFormBuilderService.buildListGrid(
            Mockito.<List<Translation>>any(), anyBoolean()))
        .thenReturn(new ListGrid());
    when(translationFormBuilderService.buildTranslationForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<TranslationForm>any(),
            Mockito.<TranslationFormAction>any()))
        .thenReturn(new EntityForm());
    when(translationService.getTranslations(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/translation/delete");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminTranslationController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(5))
        .andExpect(
            model()
                .attributeExists("currentUrl", "form", "listGrid", "modalHeaderType", "viewType"))
        .andExpect(view().name(AdminAbstractController.MODAL_CONTAINER_VIEW))
        .andExpect(forwardedUrl(AdminAbstractController.MODAL_CONTAINER_VIEW));
  }

  /**
   * Test {@link AdminTranslationController#deleteTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#deleteTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminTranslationController.deleteTranslation(HttpServletRequest, HttpServletResponse, Model, Map, TranslationForm, BindingResult)"
  })
  public void testDeleteTranslation_givenEntityFormAddTabFromTabMetadataTabMetadata()
      throws Exception {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

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
    when(adminEntityService.removeEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    AdminTranslationControllerExtensionHandler adminTranslationControllerExtensionHandler =
        mock(AdminTranslationControllerExtensionHandler.class);
    when(adminTranslationControllerExtensionHandler.applyTransformation(
            Mockito.<TranslationForm>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminTranslationControllerExtensionManager.getProxy())
        .thenReturn(adminTranslationControllerExtensionHandler);

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());
    when(translationFormBuilderService.buildListGrid(
            Mockito.<List<Translation>>any(), anyBoolean()))
        .thenReturn(new ListGrid());
    when(translationFormBuilderService.buildTranslationForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<TranslationForm>any(),
            Mockito.<TranslationFormAction>any()))
        .thenReturn(entityForm);
    when(translationService.getTranslations(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/translation/delete");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminTranslationController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(5))
        .andExpect(
            model()
                .attributeExists("currentUrl", "form", "listGrid", "modalHeaderType", "viewType"))
        .andExpect(view().name(AdminAbstractController.MODAL_CONTAINER_VIEW))
        .andExpect(forwardedUrl(AdminAbstractController.MODAL_CONTAINER_VIEW));
  }

  /**
   * Test {@link AdminTranslationController#deleteTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) DynamicForm {@code ?} is {@link
   *       EntityForm} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#deleteTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminTranslationController.deleteTranslation(HttpServletRequest, HttpServletResponse, Model, Map, TranslationForm, BindingResult)"
  })
  public void testDeleteTranslation_givenEntityFormDynamicFormQuestionMarkIsEntityForm()
      throws Exception {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

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
    when(adminEntityService.removeEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    AdminTranslationControllerExtensionHandler adminTranslationControllerExtensionHandler =
        mock(AdminTranslationControllerExtensionHandler.class);
    when(adminTranslationControllerExtensionHandler.applyTransformation(
            Mockito.<TranslationForm>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminTranslationControllerExtensionManager.getProxy())
        .thenReturn(adminTranslationControllerExtensionHandler);

    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("?", new EntityForm());
    when(translationFormBuilderService.buildListGrid(
            Mockito.<List<Translation>>any(), anyBoolean()))
        .thenReturn(new ListGrid());
    when(translationFormBuilderService.buildTranslationForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<TranslationForm>any(),
            Mockito.<TranslationFormAction>any()))
        .thenReturn(entityForm);
    when(translationService.getTranslations(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/translation/delete");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminTranslationController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(5))
        .andExpect(
            model()
                .attributeExists("currentUrl", "form", "listGrid", "modalHeaderType", "viewType"))
        .andExpect(view().name(AdminAbstractController.MODAL_CONTAINER_VIEW))
        .andExpect(forwardedUrl(AdminAbstractController.MODAL_CONTAINER_VIEW));
  }

  /**
   * Test {@link AdminTranslationController#deleteTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#deleteTranslation(HttpServletRequest,
   * HttpServletResponse, Model, Map, TranslationForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminTranslationController.deleteTranslation(HttpServletRequest, HttpServletResponse, Model, Map, TranslationForm, BindingResult)"
  })
  public void testDeleteTranslation_givenEntityFormReadOnlyIsTrue() throws Exception {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

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
    when(adminEntityService.removeEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    AdminTranslationControllerExtensionHandler adminTranslationControllerExtensionHandler =
        mock(AdminTranslationControllerExtensionHandler.class);
    when(adminTranslationControllerExtensionHandler.applyTransformation(
            Mockito.<TranslationForm>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminTranslationControllerExtensionManager.getProxy())
        .thenReturn(adminTranslationControllerExtensionHandler);

    EntityForm entityForm = new EntityForm();
    entityForm.setReadOnly(true);
    when(translationFormBuilderService.buildListGrid(
            Mockito.<List<Translation>>any(), anyBoolean()))
        .thenReturn(new ListGrid());
    when(translationFormBuilderService.buildTranslationForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<TranslationForm>any(),
            Mockito.<TranslationFormAction>any()))
        .thenReturn(entityForm);
    when(translationService.getTranslations(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/translation/delete");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminTranslationController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(5))
        .andExpect(
            model()
                .attributeExists("currentUrl", "form", "listGrid", "modalHeaderType", "viewType"))
        .andExpect(view().name(AdminAbstractController.MODAL_CONTAINER_VIEW))
        .andExpect(forwardedUrl(AdminAbstractController.MODAL_CONTAINER_VIEW));
  }

  /**
   * Test {@link AdminTranslationController#getTranslationForm(EntityForm)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return TranslationId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#getTranslationForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TranslationForm AdminTranslationController.getTranslationForm(EntityForm)"})
  public void testGetTranslationForm_given42_thenReturnTranslationIdLongValueIsFortyTwo() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("ceilingEntity", new EntityForm());

    // Act
    TranslationForm actualTranslationForm =
        adminTranslationController.getTranslationForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).getId();
    verify(entityForm).putDynamicForm(eq("ceilingEntity"), isA(EntityForm.class));
    assertNull(actualTranslationForm.getCeilingEntity());
    assertNull(actualTranslationForm.getEntityId());
    assertNull(actualTranslationForm.getFieldType());
    assertNull(actualTranslationForm.getLocaleCode());
    assertNull(actualTranslationForm.getPropertyName());
    assertNull(actualTranslationForm.getTranslatedValue());
    assertEquals(42L, actualTranslationForm.getTranslationId().longValue());
    assertFalse(actualTranslationForm.getIsRte());
  }

  /**
   * Test {@link AdminTranslationController#getTranslationForm(EntityForm)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link EntityForm} {@link EntityForm#getId()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#getTranslationForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TranslationForm AdminTranslationController.getTranslationForm(EntityForm)"})
  public void testGetTranslationForm_givenEmptyString_whenEntityFormGetIdReturnEmptyString() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("ceilingEntity", new EntityForm());

    // Act
    TranslationForm actualTranslationForm =
        adminTranslationController.getTranslationForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm).getId();
    verify(entityForm).putDynamicForm(eq("ceilingEntity"), isA(EntityForm.class));
    assertNull(actualTranslationForm.getTranslationId());
    assertNull(actualTranslationForm.getCeilingEntity());
    assertNull(actualTranslationForm.getEntityId());
    assertNull(actualTranslationForm.getFieldType());
    assertNull(actualTranslationForm.getLocaleCode());
    assertNull(actualTranslationForm.getPropertyName());
    assertNull(actualTranslationForm.getTranslatedValue());
    assertFalse(actualTranslationForm.getIsRte());
  }

  /**
   * Test {@link AdminTranslationController#getTranslationForm(EntityForm)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>When {@link EntityForm} {@link EntityForm#getId()} return space.
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#getTranslationForm(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TranslationForm AdminTranslationController.getTranslationForm(EntityForm)"})
  public void testGetTranslationForm_givenSpace_whenEntityFormGetIdReturnSpace() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn(" ");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("ceilingEntity", new EntityForm());

    // Act
    TranslationForm actualTranslationForm =
        adminTranslationController.getTranslationForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm).getId();
    verify(entityForm).putDynamicForm(eq("ceilingEntity"), isA(EntityForm.class));
    assertNull(actualTranslationForm.getTranslationId());
    assertNull(actualTranslationForm.getCeilingEntity());
    assertNull(actualTranslationForm.getEntityId());
    assertNull(actualTranslationForm.getFieldType());
    assertNull(actualTranslationForm.getLocaleCode());
    assertNull(actualTranslationForm.getPropertyName());
    assertNull(actualTranslationForm.getTranslatedValue());
    assertFalse(actualTranslationForm.getIsRte());
  }

  /**
   * Test {@link AdminTranslationController#getClassNameForSection(String)}.
   *
   * <p>Method under test: {@link AdminTranslationController#getClassNameForSection(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminTranslationController.getClassNameForSection(String)"})
  public void testGetClassNameForSection() {
    // Arrange, Act and Assert
    assertEquals(
        "org.broadleafcommerce.common.i18n.domain.Translation",
        adminTranslationController.getClassNameForSection("Section Key"));
  }

  /**
   * Test {@link AdminTranslationController#modifyRevertButton(EntityForm)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityFormAction#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#modifyRevertButton(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminTranslationController.modifyRevertButton(EntityForm)"})
  public void testModifyRevertButton_thenCallsGetId() {
    // Arrange
    EntityFormAction action = mock(EntityFormAction.class);
    doNothing().when(action).setButtonClass(Mockito.<String>any());
    when(action.getId()).thenReturn("REVERT");

    EntityForm entityForm = new EntityForm();
    entityForm.addAction(1, action);

    // Act
    adminTranslationController.modifyRevertButton(entityForm);

    // Assert
    verify(action).getId();
    verify(action).setButtonClass("translation-revert-button");
  }

  /**
   * Test {@link AdminTranslationController#modifyRevertButton(EntityForm)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} {@link EntityForm#findActionById(String)} return {@link
   *       DefaultAdornedEntityFormActions#Add}.
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#modifyRevertButton(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminTranslationController.modifyRevertButton(EntityForm)"})
  public void testModifyRevertButton_whenEntityFormFindActionByIdReturnAdd() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findActionById(Mockito.<String>any()))
        .thenReturn(DefaultAdornedEntityFormActions.Add);

    // Act
    adminTranslationController.modifyRevertButton(entityForm);

    // Assert
    verify(entityForm).findActionById("REVERT");
  }

  /**
   * Test {@link AdminTranslationController#modifyRevertButton(EntityForm)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} {@link EntityForm#findActionById(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#modifyRevertButton(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminTranslationController.modifyRevertButton(EntityForm)"})
  public void testModifyRevertButton_whenEntityFormFindActionByIdReturnNull() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findActionById(Mockito.<String>any())).thenReturn(null);

    // Act
    adminTranslationController.modifyRevertButton(entityForm);

    // Assert
    verify(entityForm).findActionById("REVERT");
  }

  /**
   * Test {@link AdminTranslationController#populateTranslationFields(EntityForm, TranslationForm)}.
   *
   * <p>Method under test: {@link AdminTranslationController#populateTranslationFields(EntityForm,
   * TranslationForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminTranslationController.populateTranslationFields(EntityForm, TranslationForm)"
  })
  public void testPopulateTranslationFields() {
    // Arrange
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity("Type", "Friendly Type"));
    EntityForm entityForm = new EntityForm();

    TranslationForm translationForm = new TranslationForm();
    translationForm.setCeilingEntity("Ceiling Entity");
    translationForm.setEntityId("42");
    translationForm.setFieldType("Field Type");
    translationForm.setIsRte(true);
    translationForm.setLocaleCode("en");
    translationForm.setPropertyName("Property Name");
    translationForm.setTranslatedValue("42");
    translationForm.setTranslationId(1L);

    // Act
    adminTranslationController.populateTranslationFields(entityForm, translationForm);

    // Assert
    verify(translationService).getAssignableEntityType("Ceiling Entity");
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(2, fields.size());
    assertTrue(fields.containsKey("entityType"));
    assertTrue(fields.containsKey("fieldName"));
  }

  /**
   * Test {@link AdminTranslationController#populateTranslationFields(EntityForm, TranslationForm)}.
   *
   * <ul>
   *   <li>Given {@code entityType}.
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#populateTranslationFields(EntityForm,
   * TranslationForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminTranslationController.populateTranslationFields(EntityForm, TranslationForm)"
  })
  public void testPopulateTranslationFields_givenEntityType() {
    // Arrange
    TranslatedEntity translatedEntity = mock(TranslatedEntity.class);
    when(translatedEntity.getFriendlyType()).thenReturn("Friendly Type");
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(translatedEntity);

    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("entityType", new EntityForm());

    TranslationForm translationForm = new TranslationForm();
    translationForm.setCeilingEntity("Ceiling Entity");
    translationForm.setEntityId("42");
    translationForm.setFieldType("Field Type");
    translationForm.setIsRte(true);
    translationForm.setLocaleCode("en");
    translationForm.setPropertyName("Property Name");
    translationForm.setTranslatedValue("42");
    translationForm.setTranslationId(1L);

    // Act
    adminTranslationController.populateTranslationFields(entityForm, translationForm);

    // Assert
    verify(translatedEntity).getFriendlyType();
    verify(translationService).getAssignableEntityType("Ceiling Entity");
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(2, fields.size());
    assertTrue(fields.containsKey("entityType"));
    assertTrue(fields.containsKey("fieldName"));
  }

  /**
   * Test {@link AdminTranslationController#populateTranslationFields(EntityForm, TranslationForm)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code entityType} is {@link Field} (default
   *       constructor).
   *   <li>Then calls {@link EntityForm#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#populateTranslationFields(EntityForm,
   * TranslationForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminTranslationController.populateTranslationFields(EntityForm, TranslationForm)"
  })
  public void testPopulateTranslationFields_givenHashMapEntityTypeIsField_thenCallsGetFields() {
    // Arrange
    TranslatedEntity translatedEntity = mock(TranslatedEntity.class);
    when(translatedEntity.getFriendlyType()).thenReturn("Friendly Type");
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(translatedEntity);

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("entityType", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);

    TranslationForm translationForm = new TranslationForm();
    translationForm.setCeilingEntity("Ceiling Entity");
    translationForm.setEntityId("42");
    translationForm.setFieldType("Field Type");
    translationForm.setIsRte(true);
    translationForm.setLocaleCode("en");
    translationForm.setPropertyName("Property Name");
    translationForm.setTranslatedValue("42");
    translationForm.setTranslationId(1L);

    // Act
    adminTranslationController.populateTranslationFields(entityForm, translationForm);

    // Assert
    verify(translatedEntity).getFriendlyType();
    verify(translationService).getAssignableEntityType("Ceiling Entity");
    verify(entityForm, atLeast(1)).getFields();
  }

  /**
   * Test {@link AdminTranslationController#populateTranslationFields(EntityForm, TranslationForm)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#populateTranslationFields(EntityForm,
   * TranslationForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminTranslationController.populateTranslationFields(EntityForm, TranslationForm)"
  })
  public void testPopulateTranslationFields_givenTabMetadata() {
    // Arrange
    TranslatedEntity translatedEntity = mock(TranslatedEntity.class);
    when(translatedEntity.getFriendlyType()).thenReturn("Friendly Type");
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(translatedEntity);

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    TranslationForm translationForm = new TranslationForm();
    translationForm.setCeilingEntity("Ceiling Entity");
    translationForm.setEntityId("42");
    translationForm.setFieldType("Field Type");
    translationForm.setIsRte(true);
    translationForm.setLocaleCode("en");
    translationForm.setPropertyName("Property Name");
    translationForm.setTranslatedValue("42");
    translationForm.setTranslationId(1L);

    // Act
    adminTranslationController.populateTranslationFields(entityForm, translationForm);

    // Assert
    verify(translatedEntity).getFriendlyType();
    verify(translationService).getAssignableEntityType("Ceiling Entity");
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(2, fields.size());
    assertTrue(fields.containsKey("entityType"));
    assertTrue(fields.containsKey("fieldName"));
  }

  /**
   * Test {@link AdminTranslationController#populateTranslationFields(EntityForm, TranslationForm)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then {@link EntityForm} (default constructor) Fields size is two.
   * </ul>
   *
   * <p>Method under test: {@link AdminTranslationController#populateTranslationFields(EntityForm,
   * TranslationForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminTranslationController.populateTranslationFields(EntityForm, TranslationForm)"
  })
  public void testPopulateTranslationFields_whenEntityForm_thenEntityFormFieldsSizeIsTwo() {
    // Arrange
    TranslatedEntity translatedEntity = mock(TranslatedEntity.class);
    when(translatedEntity.getFriendlyType()).thenReturn("Friendly Type");
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(translatedEntity);
    EntityForm entityForm = new EntityForm();

    TranslationForm translationForm = new TranslationForm();
    translationForm.setCeilingEntity("Ceiling Entity");
    translationForm.setEntityId("42");
    translationForm.setFieldType("Field Type");
    translationForm.setIsRte(true);
    translationForm.setLocaleCode("en");
    translationForm.setPropertyName("Property Name");
    translationForm.setTranslatedValue("42");
    translationForm.setTranslationId(1L);

    // Act
    adminTranslationController.populateTranslationFields(entityForm, translationForm);

    // Assert
    verify(translatedEntity).getFriendlyType();
    verify(translationService).getAssignableEntityType("Ceiling Entity");
    Map<String, Field> fields = entityForm.getFields();
    assertEquals(2, fields.size());
    assertTrue(fields.containsKey("entityType"));
    assertTrue(fields.containsKey("fieldName"));
  }
}
