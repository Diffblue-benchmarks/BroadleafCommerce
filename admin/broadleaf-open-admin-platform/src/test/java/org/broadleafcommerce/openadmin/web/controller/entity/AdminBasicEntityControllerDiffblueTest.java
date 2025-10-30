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
package org.broadleafcommerce.openadmin.web.controller.entity;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.remote.EntityOperationType;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityProvider;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.broadleafcommerce.openadmin.web.controller.AbstractAdminAbstractControllerExtensionHandler;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid.Type;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormAction;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.form.entity.FieldGroup;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RunWith(MockitoJUnitRunner.class)
public class AdminBasicEntityControllerDiffblueTest {
  @InjectMocks
  private AdminBasicEntityController adminBasicEntityController;

  @Mock
  private AdminEntityService adminEntityService;

  @Mock
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock
  private EntityFormValidator entityFormValidator;

  @Mock
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Mock
  private AdminNavigationService adminNavigationService;

  @Mock
  private FormBuilderService formBuilderService;

  @Mock
  private RowLevelSecurityService rowLevelSecurityService;

  @Mock
  private SecurityVerifier securityVerifier;

  @Mock
  private AdminUserDao adminUserDao;

  /**
   * Test {@link AdminBasicEntityController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"})
  public void testViewEntityList_thenStatusIsOk() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(Mockito.<DynamicResultSet>any(), Mockito.<ClassMetadata>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{sectionKey:.+}", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(11))
        .andExpect(MockMvcResultMatchers.model()
            .attributeExists("currentAdminSection", "currentUri", "currentUrl", "entityTypes", "isFilter", "listGrid",
                "mainActions", "sectionKey", "viewType"))
        .andExpect(MockMvcResultMatchers.view().name("modules/defaultContainer"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("modules/defaultContainer"));
  }

  /**
   * Test {@link AdminBasicEntityController#setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata, String, String, Model, MultiValueMap)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata, String, String, Model, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminBasicEntityController.setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata, String, String, Model, MultiValueMap)"})
  public void testSetupViewEntityListBasicModel_thenConcurrentModelSizeIsSeven() throws ServiceException {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSectionImpl);
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        new MockHttpServletRequest("https://example.org/example", "https://example.org/example"));

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminBasicEntityController.setupViewEntityListBasicModel(request, cmd, "Section Key", "Section Class Name", model,
        new HttpHeaders());

    // Assert
    verify(adminAbstractControllerExtensionManager, atLeast(1)).getProxy();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
    assertEquals(7, model.size());
    Object getResult = model.get("entityTypes");
    assertTrue(getResult instanceof List);
    Object getResult2 = model.get("mainActions");
    assertTrue(getResult2 instanceof List);
    Object getResult3 = model.get("currentAdminSection");
    assertTrue(getResult3 instanceof AdminSectionImpl);
    assertEquals("Section Key", model.get("sectionKey"));
    assertEquals("http://localhosthttps://example.org/example", model.get("currentUrl"));
    assertEquals("ttps://example.org/example", model.get("currentUri"));
    assertEquals(1, ((List<ClassTree>) getResult).size());
    assertEquals(1, ((List<EntityFormAction>) getResult2).size());
    assertFalse((Boolean) model.get("isFilter"));
    assertSame(adminSectionImpl, getResult3);
  }

  /**
   * Test {@link AdminBasicEntityController#setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata, String, String, Model, MultiValueMap)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata, String, String, Model, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminBasicEntityController.setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata, String, String, Model, MultiValueMap)"})
  public void testSetupViewEntityListBasicModel_thenThrowUnsupportedOperationException() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> adminBasicEntityController
        .setupViewEntityListBasicModel(request, cmd, "Section Key", "Section Class Name", model, new HttpHeaders()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <ul>
   *   <li>Then content string {@code <Map><?>42</?></Map>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminBasicEntityController.viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"})
  public void testViewEntityListSelectize_thenContentStringMap42Map() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("?", "42");
    when(formBuilderService.constructSelectizeOptionMap(Mockito.<DynamicResultSet>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(stringObjectMap);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{sectionKey:.+}/selectize",
        "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Map><?>42</?></Map>"));
  }

  /**
   * Test {@link AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <ul>
   *   <li>When BroadleafRequestContext is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminBasicEntityController.viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"})
  public void testViewEntityListSelectize_whenBroadleafRequestContextIsTrue() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(formBuilderService.constructSelectizeOptionMap(Mockito.<DynamicResultSet>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(new HashMap<>());

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{sectionKey:.+}/selectize",
        BroadleafRequestContext.getBroadleafRequestContext(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Map/>"));
  }

  /**
   * Test {@link AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <ul>
   *   <li>When {@code Uri Variables}.</li>
   *   <li>Then content string {@code <Map/>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminBasicEntityController.viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"})
  public void testViewEntityListSelectize_whenUriVariables_thenContentStringMap() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(formBuilderService.constructSelectizeOptionMap(Mockito.<DynamicResultSet>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(new HashMap<>());

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{sectionKey:.+}/selectize",
        "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Map/>"));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return array of {@link String} with {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminBasicEntityController.getCustomCriteria(Map)"})
  public void testGetCustomCriteria_givenArrayList_thenReturnArrayOfStringWithNull() {
    // Arrange
    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put(AdminBasicEntityController.CUSTOM_CRITERIA, new ArrayList<>());

    // Act and Assert
    assertArrayEquals(new String[]{null}, adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@link AdminBasicEntityController#CUSTOM_CRITERIA} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminBasicEntityController.getCustomCriteria(Map)"})
  public void testGetCustomCriteria_givenNull_whenHashMapCustom_criteriaIsNull() {
    // Arrange
    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put(AdminBasicEntityController.CUSTOM_CRITERIA, null);

    // Act and Assert
    assertArrayEquals(new String[]{null}, adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code Request Params}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminBasicEntityController.getCustomCriteria(Map)"})
  public void testGetCustomCriteria_thenReturnArrayOfStringWithRequestParams() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put(AdminBasicEntityController.CUSTOM_CRITERIA, stringList);

    // Act and Assert
    assertArrayEquals(new String[]{"Request Params"}, adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminBasicEntityController.getCustomCriteria(Map)"})
  public void testGetCustomCriteria_whenHashMap_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminBasicEntityController.getCustomCriteria(new HashMap<>()));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminBasicEntityController.getCustomCriteria(Map)"})
  public void testGetCustomCriteria_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(adminBasicEntityController.getCustomCriteria(null));
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"})
  public void testAddAddActionIfAllowed() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, new ArrayList<>()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"})
  public void testAddAddActionIfAllowed2() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    ArrayList<EntityFormAction> mainActions = new ArrayList<>();

    // Act
    adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, mainActions);

    // Assert that nothing has changed
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(mainActions.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"})
  public void testAddAddActionIfAllowed3() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenThrow(new UnsupportedOperationException("foo"));
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, new ArrayList<>()));
    verify(basicFieldMetadata).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getReadOnly()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"})
  public void testAddAddActionIfAllowed_givenBasicFieldMetadataGetReadOnlyReturnFalse() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(false);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    ArrayList<EntityFormAction> mainActions = new ArrayList<>();

    // Act
    adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, mainActions);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertEquals(1, mainActions.size());
    EntityFormAction getResult = mainActions.get(0);
    assertEquals("", getResult.getConfirmEnabledText());
    assertEquals("/add", getResult.getUrlPostfix());
    assertEquals("ADD", getResult.getId());
    assertEquals("Add", getResult.getDisplayText());
    assertEquals("add-main-entity", getResult.getButtonClass());
    assertEquals("button", getResult.getButtonType());
    assertEquals("fa fa-plus-square-o fa-lg", getResult.getIconClass());
    assertNull(getResult.getUrlOverride());
    assertFalse(getResult.getIsConfirmEnabled());
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getReadOnly()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"})
  public void testAddAddActionIfAllowed_givenBasicFieldMetadataGetReadOnlyReturnTrue() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    ArrayList<EntityFormAction> mainActions = new ArrayList<>();

    // Act
    adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, mainActions);

    // Assert that nothing has changed
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(mainActions.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"})
  public void testAddAddActionIfAllowed_givenPropertyGetMetadataReturnBasicFieldMetadata() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    ArrayList<EntityFormAction> mainActions = new ArrayList<>();

    // Act
    adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, mainActions);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertEquals(1, mainActions.size());
    EntityFormAction getResult = mainActions.get(0);
    assertEquals("", getResult.getConfirmEnabledText());
    assertEquals("/add", getResult.getUrlPostfix());
    assertEquals("ADD", getResult.getId());
    assertEquals("Add", getResult.getDisplayText());
    assertEquals("add-main-entity", getResult.getButtonClass());
    assertEquals("button", getResult.getButtonType());
    assertEquals("fa fa-plus-square-o fa-lg", getResult.getIconClass());
    assertNull(getResult.getUrlOverride());
    assertFalse(getResult.getIsConfirmEnabled());
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityProvider#canAdd(AdminUser, String, ClassMetadata)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"})
  public void testAddAddActionIfAllowed_givenRowLevelSecurityServiceCanAddReturnFalse() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(false);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ArrayList<EntityFormAction> mainActions = new ArrayList<>();

    // Act
    adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, mainActions);

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(mainActions.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"})
  public void testAddAddActionIfAllowed_thenArrayListSizeIsOne() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ArrayList<EntityFormAction> mainActions = new ArrayList<>();

    // Act
    adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, mainActions);

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertEquals(1, mainActions.size());
    EntityFormAction getResult = mainActions.get(0);
    assertEquals("", getResult.getConfirmEnabledText());
    assertEquals("/add", getResult.getUrlPostfix());
    assertEquals("ADD", getResult.getId());
    assertEquals("Add", getResult.getDisplayText());
    assertEquals("add-main-entity", getResult.getButtonClass());
    assertEquals("button", getResult.getButtonType());
    assertEquals("fa fa-plus-square-o fa-lg", getResult.getIconClass());
    assertNull(getResult.getUrlOverride());
    assertFalse(getResult.getIsConfirmEnabled());
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"})
  public void testIsAddActionAllowed() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"})
  public void testIsAddActionAllowed2() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    boolean actualIsAddActionAllowedResult = adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertFalse(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"})
  public void testIsAddActionAllowed3() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenThrow(new UnsupportedOperationException("foo"));
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd));
    verify(basicFieldMetadata).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getReadOnly()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"})
  public void testIsAddActionAllowed_givenBasicFieldMetadataGetReadOnlyReturnFalse() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(false);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    boolean actualIsAddActionAllowedResult = adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getReadOnly()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"})
  public void testIsAddActionAllowed_givenBasicFieldMetadataGetReadOnlyReturnTrue() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    boolean actualIsAddActionAllowedResult = adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertFalse(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"})
  public void testIsAddActionAllowed_givenPropertyGetMetadataReturnBasicFieldMetadata() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    boolean actualIsAddActionAllowedResult = adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityProvider#canAdd(AdminUser, String, ClassMetadata)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"})
  public void testIsAddActionAllowed_givenRowLevelSecurityServiceCanAddReturnFalse() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(false);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsAddActionAllowedResult = adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertFalse(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"})
  public void testIsAddActionAllowed_whenClassMetadataCeilingTypeIsType_thenReturnTrue() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsAddActionAllowedResult = adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Section Class Name"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getReadOnly()} return {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_givenBasicFieldMetadataGetReadOnlyReturnFalse_thenReturnTrue() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(false);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    assertTrue(actualIsNotReadOnlyResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getReadOnly()} return {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_givenBasicFieldMetadataGetReadOnlyReturnTrue_thenReturnFalse() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    assertFalse(actualIsNotReadOnlyResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_givenPropertyGetMetadataReturnAdornedTargetCollectionMetadata() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    assertFalse(actualIsNotReadOnlyResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_givenPropertyGetMetadataReturnBasicFieldMetadata() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    assertTrue(actualIsNotReadOnlyResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_thenThrowUnsupportedOperationException() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenThrow(new UnsupportedOperationException("foo"));
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
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

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> adminBasicEntityController.isNotReadOnly(cmd));
    verify(basicFieldMetadata).getReadOnly();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_whenClassMetadataCeilingTypeIsType_thenReturnTrue() {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertTrue(adminBasicEntityController.isNotReadOnly(cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"})
  public void testViewAddEntityForm_thenStatusIsOk() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    doNothing().when(formBuilderService)
        .removeNonApplicableFields(Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    when(formBuilderService.createEntityForm(Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new EntityForm());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree("Dr Jane Doe"));
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{sectionKey:.+}/add", "Uri Variables")
        .param("entityType", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(8))
        .andExpect(MockMvcResultMatchers.model()
            .attributeExists("currentAdminSection", "currentUrl", "entityForm", "entityFriendlyName", "modalHeaderType",
                "sectionKey", "viewType"))
        .andExpect(MockMvcResultMatchers.view().name("modules/modalContainer"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.determineEntityType(String, ClassMetadata)"})
  public void testDetermineEntityType() throws UnsupportedEncodingException {
    // Arrange
    ClassTree polymorphicEntities = mock(ClassTree.class);
    when(polymorphicEntities.getChildren()).thenReturn(new ClassTree[]{new ClassTree()});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(polymorphicEntities);
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    String actualDetermineEntityTypeResult = adminBasicEntityController.determineEntityType(null, cmd);

    // Assert
    verify(polymorphicEntities).getChildren();
    assertNull(actualDetermineEntityTypeResult);
  }

  /**
   * Test {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link ClassTree#ClassTree()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.determineEntityType(String, ClassMetadata)"})
  public void testDetermineEntityType_givenClassTree_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertNull(adminBasicEntityController.determineEntityType(null, cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link ClassTree#ClassTree()}.</li>
   *   <li>When {@code Entity Type}.</li>
   *   <li>Then return {@code Entity Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.determineEntityType(String, ClassMetadata)"})
  public void testDetermineEntityType_givenClassTree_whenEntityType_thenReturnEntityType()
      throws UnsupportedEncodingException {
    // Arrange
    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("Entity Type", adminBasicEntityController.determineEntityType("Entity Type", cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.determineEntityType(String, ClassMetadata)"})
  public void testDetermineEntityType_thenThrowUnsupportedOperationException() throws UnsupportedEncodingException {
    // Arrange
    ClassTree polymorphicEntities = mock(ClassTree.class);
    when(polymorphicEntities.getFullyQualifiedClassname()).thenThrow(new UnsupportedOperationException("foo"));
    when(polymorphicEntities.getChildren()).thenReturn(new ClassTree[]{});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(polymorphicEntities);
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> adminBasicEntityController.determineEntityType(null, cmd));
    verify(polymorphicEntities).getChildren();
    verify(polymorphicEntities).getFullyQualifiedClassname();
  }

  /**
   * Test {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.getErrorDuplicatingResponse(HttpServletResponse, String)"})
  public void testGetErrorDuplicatingResponse_thenMockHttpServletResponseHeaderNamesSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualErrorDuplicatingResponse = adminBasicEntityController.getErrorDuplicatingResponse(response, "Code");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"errors\":[{\"code\":\"Code\",\"errorType\":\"global\",\"message\":\"Duplication_Failure\"}]}",
        response.getContentAsString());
    assertNull(actualErrorDuplicatingResponse);
    assertEquals(81, response.getContentAsByteArray().length);
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"})
  public void testGetViewSubRecords_givenSectionCrumbOriginalSectionIdentifierIs42() throws Exception {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    HashMap<String, String> pathVars = new HashMap<>();
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabName()).thenThrow(new UnsupportedOperationException("foo"));
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(tabMetadata);
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
    Entity entity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> crumbs = new ArrayList<>();
    crumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.getViewSubRecords(request, pathVars, cmd, entity, crumbs));
    verify(cmd, atLeast(1)).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(tabMetadata).getTabName();
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code tabName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"})
  public void testGetViewSubRecords_givenSectionCrumbOriginalSectionIdentifierIsTabName() throws Exception {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    HashMap<String, String> pathVars = new HashMap<>();
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabName()).thenThrow(new UnsupportedOperationException("foo"));
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(tabMetadata);
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
    Entity entity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("tabName");
    sectionCrumb2.setSectionId("tabName");
    sectionCrumb2.setSectionIdentifier("tabName");

    ArrayList<SectionCrumb> crumbs = new ArrayList<>();
    crumbs.add(sectionCrumb2);
    crumbs.add(sectionCrumb);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.getViewSubRecords(request, pathVars, cmd, entity, crumbs));
    verify(cmd, atLeast(1)).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(tabMetadata).getTabName();
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"})
  public void testGetViewSubRecords_givenTabMetadata() throws Exception {
    // Arrange
    when(adminEntityService.getRecordsForSelectedTab(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<List<SectionCrumb>>any(), Mockito.<String>any())).thenReturn(new HashMap<>());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    HashMap<String, String> pathVars = new HashMap<>();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(new TabMetadata());
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
    Entity entity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualViewSubRecords = adminBasicEntityController.getViewSubRecords(request, pathVars,
        cmd, entity, new ArrayList<>());

    // Assert
    verify(cmd, atLeast(1)).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adminEntityService).getRecordsForSelectedTab(isA(ClassMetadata.class), isA(Entity.class), isA(List.class),
        isNull());
    assertTrue(actualViewSubRecords.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Given {@code tabName}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code tabName} is {@code tabName}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"})
  public void testGetViewSubRecords_givenTabName_whenHashMapTabNameIsTabName_thenReturnEmpty() throws Exception {
    // Arrange
    when(adminEntityService.getRecordsForSelectedTab(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<List<SectionCrumb>>any(), Mockito.<String>any())).thenReturn(new HashMap<>());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("tabName", "tabName");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualViewSubRecords = adminBasicEntityController.getViewSubRecords(request, pathVars,
        cmd, entity, new ArrayList<>());

    // Assert
    verify(adminEntityService).getRecordsForSelectedTab(isA(ClassMetadata.class), isA(Entity.class), isA(List.class),
        eq("tabName"));
    assertTrue(actualViewSubRecords.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"})
  public void testGetViewSubRecords_thenThrowUnsupportedOperationException() throws Exception {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    HashMap<String, String> pathVars = new HashMap<>();
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabName()).thenThrow(new UnsupportedOperationException("foo"));
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(tabMetadata);
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
    Entity entity = new Entity();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.getViewSubRecords(request, pathVars, cmd, entity, new ArrayList<>()));
    verify(cmd, atLeast(1)).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(tabMetadata).getTabName();
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"})
  public void testGetViewSubRecords_whenClassMetadataCeilingTypeIsType_thenReturnEmpty() throws Exception {
    // Arrange
    when(adminEntityService.getRecordsForSelectedTab(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<List<SectionCrumb>>any(), Mockito.<String>any())).thenReturn(new HashMap<>());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    HashMap<String, String> pathVars = new HashMap<>();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualViewSubRecords = adminBasicEntityController.getViewSubRecords(request, pathVars,
        cmd, entity, new ArrayList<>());

    // Assert
    verify(adminEntityService).getRecordsForSelectedTab(isA(ClassMetadata.class), isA(Entity.class), isA(List.class),
        eq("General"));
    assertTrue(actualViewSubRecords.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#saveEntityJson(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#saveEntityJson(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.saveEntityJson(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntityJson() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{});
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/{sectionKey:.+}/{id}", "Uri Variables",
        "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/Uri Variables/Uri Variables"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/Uri Variables/Uri Variables"));
  }

  /**
   * Test {@link AdminBasicEntityController#saveEntityJson(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#saveEntityJson(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.saveEntityJson(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntityJson2() throws Exception {
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/{sectionKey:.+}/{id}",
        BroadleafRequestContext.getBroadleafRequestContext(true), "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0));
  }

  /**
   * Test {@link AdminBasicEntityController#saveEntityJson(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Then view name {@code redirect:/Uri Variables/Uri Variables}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#saveEntityJson(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.saveEntityJson(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntityJson_thenViewNameRedirectUriVariablesUriVariables() throws Exception {
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/{sectionKey:.+}/{id}", "Uri Variables",
        "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/Uri Variables/Uri Variables"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/Uri Variables/Uri Variables"));
  }

  /**
   * Test {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest, String)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AdminBasicEntityController.buildDirtyList(Map, HttpServletRequest, String)"})
  public void testBuildDirtyList_thenThrowServiceException() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecord(Mockito.<PersistencePackageRequest>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any(), anyBoolean())).thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    HashMap<String, String> pathVars = new HashMap<>();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminBasicEntityController.buildDirtyList(pathVars,
        new JSCompatibilityRequestWrapper(new MockHttpServletRequest()), "42"));
    verify(classNameRequestParamValidationService).getClassNameForSection(isNull());
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecord(isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class),
        eq(false));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
  }

  /**
   * Test {@link AdminBasicEntityController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntity() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{});
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/{sectionKey:.+}/{id}", "Uri Variables",
        "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/Uri Variables/Uri Variables"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/Uri Variables/Uri Variables"));
  }

  /**
   * Test {@link AdminBasicEntityController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Then view name {@code redirect:/Uri Variables/Uri Variables}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntity_thenViewNameRedirectUriVariablesUriVariables() throws Exception {
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/{sectionKey:.+}/{id}", "Uri Variables",
        "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/Uri Variables/Uri Variables"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/Uri Variables/Uri Variables"));
  }

  /**
   * Test {@link AdminBasicEntityController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#post(String, Object[])} {@code /{sectionKey:.+}/{id}} BroadleafRequestContext is {@code true} and {@code Uri Variables}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testSaveEntity_whenPostSectionKeyIdBroadleafRequestContextIsTrueAndUriVariables() throws Exception {
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/{sectionKey:.+}/{id}",
        BroadleafRequestContext.getBroadleafRequestContext(true), "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0));
  }

  /**
   * Test {@link AdminBasicEntityController#modifyEntityForm(Entity, EntityForm, Map)} with {@code entity}, {@code entityForm}, {@code pathVars}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#modifyEntityForm(Entity, EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.modifyEntityForm(Entity, EntityForm, Map)"})
  public void testModifyEntityFormWithEntityEntityFormPathVars_thenCallsGetProxy() throws Exception {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    Entity entity = new Entity();
    EntityForm entityForm = new EntityForm();

    // Act
    adminBasicEntityController.modifyEntityForm(entity, entityForm, new HashMap<>());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
  }

  /**
   * Test {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)"})
  public void testResolveAppropriateEntityView() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request,
        model, new EntityForm());

    // Assert
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertTrue((Boolean) model.get("useAjaxUpdate"));
  }

  /**
   * Test {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)"})
  public void testResolveAppropriateEntityView2() {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request,
        model, new EntityForm());

    // Assert
    ServletRequest request2 = request.getRequest();
    assertTrue(request2 instanceof HttpServletRequestWrapper);
    assertTrue(((HttpServletRequestWrapper) request2).getRequest() instanceof JSCompatibilityRequestWrapper);
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertTrue((Boolean) model.get("useAjaxUpdate"));
  }

  /**
   * Test {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)"})
  public void testResolveAppropriateEntityView3() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request2,
        model, new EntityForm());

    // Assert
    verify(request).getHeader(eq("X-Requested-With"));
    verify(request).getParameter(eq("blcAjax"));
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertTrue((Boolean) model.get("useAjaxUpdate"));
  }

  /**
   * Test {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)"})
  public void testResolveAppropriateEntityView_givenEmptyString() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(request.getParameter(Mockito.<String>any())).thenReturn("");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request2,
        model, new EntityForm());

    // Assert
    verify(request).getHeader(eq("X-Requested-With"));
    verify(request).getParameter(eq("blcAjax"));
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertTrue((Boolean) model.get("useAjaxUpdate"));
  }

  /**
   * Test {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <ul>
   *   <li>Given {@code XMLHttpRequest}.</li>
   *   <li>Then {@link EntityForm} (default constructor) ReadOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)"})
  public void testResolveAppropriateEntityView_givenXMLHttpRequest_thenEntityFormReadOnly() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("XMLHttpRequest");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    ConcurrentModel model = new ConcurrentModel();
    EntityForm entityForm = new EntityForm();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request2,
        model, entityForm);

    // Assert
    verify(request).getHeader(eq("X-Requested-With"));
    verify(request).getParameter(eq("blcAjax"));
    assertEquals(2, model.size());
    assertEquals("modal/entityView", model.get("viewType"));
    assertEquals("modules/modalContainer", actualResolveAppropriateEntityViewResult);
    assertEquals("viewEntity", model.get("modalHeaderType"));
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Test {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link EntityForm#setReadOnly()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)"})
  public void testResolveAppropriateEntityView_thenCallsSetReadOnly() {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getHeader(Mockito.<String>any())).thenReturn("XMLHttpRequest");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    ConcurrentModel model = new ConcurrentModel();
    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).setReadOnly();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request2,
        model, entityForm);

    // Assert
    verify(request).getHeader(eq("X-Requested-With"));
    verify(entityForm).setReadOnly();
    verify(request).getParameter(eq("blcAjax"));
    assertEquals(2, model.size());
    assertEquals("modal/entityView", model.get("viewType"));
    assertEquals("modules/modalContainer", actualResolveAppropriateEntityViewResult);
    assertEquals("viewEntity", model.get("modalHeaderType"));
  }

  /**
   * Test {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)"})
  public void testResolveAppropriateEntityView_whenMockHttpServletRequest() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualResolveAppropriateEntityViewResult = adminBasicEntityController.resolveAppropriateEntityView(request,
        model, new EntityForm());

    // Assert
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertTrue((Boolean) model.get("useAjaxUpdate"));
  }

  /**
   * Test {@link AdminBasicEntityController#removeEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#removeEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.removeEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"})
  public void testRemoveEntity_thenStatusIsFound() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(adminEntityService.removeEntity(Mockito.<EntityForm>any(), Mockito.<String[]>any(),
        Mockito.<List<SectionCrumb>>any())).thenReturn(new PersistenceResponse());
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/{sectionKey:.+}/{id}/delete",
        "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isFound())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("redirect:/Uri Variables"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/Uri Variables"));
  }

  /**
   * Test {@link AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)"})
  public void testGetModalForBlankEntityType_givenHttpsExampleOrgExample() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath("https://example.org/example");
    request.setRequestURI("Request");
    ConcurrentModel model = new ConcurrentModel();

    ClassTree polymorphicEntities = new ClassTree();
    polymorphicEntities.setFriendlyName(null);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setPolymorphicEntities(polymorphicEntities);

    // Act
    String actualModalForBlankEntityType = adminBasicEntityController.getModalForBlankEntityType(request, model,
        "Section Key", cmd);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
    assertEquals(6, model.size());
    Object getResult = model.get("entityTypes");
    assertTrue(getResult instanceof List);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("Request", model.get("currentUri"));
    assertEquals("Section Key", model.get("sectionKey"));
    assertEquals("addEntity", model.get("modalHeaderType"));
    assertEquals("modal/entityTypeSelection", model.get("viewType"));
    assertEquals("modules/modalContainer", actualModalForBlankEntityType);
    assertEquals(1, ((List<ClassTree>) getResult).size());
    assertSame(polymorphicEntities, cmd.getPolymorphicEntities());
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code currentUri} is {@code Request}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)"})
  public void testGetModalForBlankEntityType_givenSlash_thenConcurrentModelCurrentUriIsRequest() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath("/");
    request.setRequestURI("Request");
    ConcurrentModel model = new ConcurrentModel();

    ClassTree polymorphicEntities = new ClassTree();
    polymorphicEntities.setFriendlyName(null);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setPolymorphicEntities(polymorphicEntities);

    // Act
    String actualModalForBlankEntityType = adminBasicEntityController.getModalForBlankEntityType(request, model,
        "Section Key", cmd);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
    assertEquals(6, model.size());
    Object getResult = model.get("entityTypes");
    assertTrue(getResult instanceof List);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("Request", model.get("currentUri"));
    assertEquals("Section Key", model.get("sectionKey"));
    assertEquals("addEntity", model.get("modalHeaderType"));
    assertEquals("modal/entityTypeSelection", model.get("viewType"));
    assertEquals("modules/modalContainer", actualModalForBlankEntityType);
    assertEquals(1, ((List<ClassTree>) getResult).size());
    assertSame(polymorphicEntities, cmd.getPolymorphicEntities());
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code currentUri} is {@code equest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)"})
  public void testGetModalForBlankEntityType_thenConcurrentModelCurrentUriIsEquest() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath("");
    request.setRequestURI("Request");
    ConcurrentModel model = new ConcurrentModel();

    ClassTree polymorphicEntities = new ClassTree();
    polymorphicEntities.setFriendlyName(null);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setPolymorphicEntities(polymorphicEntities);

    // Act
    String actualModalForBlankEntityType = adminBasicEntityController.getModalForBlankEntityType(request, model,
        "Section Key", cmd);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
    assertEquals(6, model.size());
    Object getResult = model.get("entityTypes");
    assertTrue(getResult instanceof List);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("Section Key", model.get("sectionKey"));
    assertEquals("addEntity", model.get("modalHeaderType"));
    assertEquals("equest", model.get("currentUri"));
    assertEquals("modal/entityTypeSelection", model.get("viewType"));
    assertEquals("modules/modalContainer", actualModalForBlankEntityType);
    assertEquals(1, ((List<ClassTree>) getResult).size());
    assertSame(polymorphicEntities, cmd.getPolymorphicEntities());
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminBasicEntityController#buildSelectizeCustomCriteria()}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#buildSelectizeCustomCriteria()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminBasicEntityController.buildSelectizeCustomCriteria()"})
  public void testBuildSelectizeCustomCriteria() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{AdminBasicEntityController.IS_SELECTIZE_REQUEST},
        adminBasicEntityController.buildSelectizeCustomCriteria());
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"})
  public void testBuildAddCollectionItemModel_thenConcurrentModelSizeIsEight() throws ServiceException {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    ListGrid listGrid = mock(ListGrid.class);
    doNothing().when(listGrid).removeAllRowActions();
    doNothing().when(listGrid).setCanFilterAndSort(Mockito.<Boolean>any());
    doNothing().when(listGrid).setFriendlyName(Mockito.<String>any());
    doNothing().when(listGrid).setIsSortable(anyBoolean());
    doNothing().when(listGrid).setListGridType(Mockito.<Type>any());
    doNothing().when(listGrid).setPathOverride(Mockito.<String>any());
    doNothing().when(listGrid).setSubCollectionFieldName(Mockito.<String>any());
    when(formBuilderService.buildAdornedListForm(Mockito.<AdornedTargetCollectionMetadata>any(),
        Mockito.<AdornedTargetList>any(), Mockito.<String>any(), anyBoolean(), Mockito.<EntityForm>any(),
        Mockito.<List<SectionCrumb>>any(), anyBoolean())).thenReturn(new EntityForm());
    doNothing().when(formBuilderService)
        .populateEntityFormFieldValues(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getPolymorphicEntities()).thenReturn(new ClassTree());
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    Property property = new Property();
    classMetaData.setProperties(new Property[]{property});
    classMetaData.setSecurityCeilingType("owningClass=");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act
    String actualBuildAddCollectionItemModelResult = adminBasicEntityController.buildAddCollectionItemModel(request,
        response, model, "42", "Collection Field", "Section Key", collectionProperty, md, ppr, entityForm,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classMetaData).getPolymorphicEntities();
    verify(classMetaData).setCeilingType(eq("owningClass="));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("owningClass="));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("Section Key"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(persistenceResponse).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    verify(listGrid).removeAllRowActions();
    verify(listGrid).setCanFilterAndSort(eq(true));
    verify(listGrid).setFriendlyName(isNull());
    verify(listGrid).setIsSortable(eq(false));
    verify(listGrid).setListGridType(eq(Type.ADORNED));
    verify(listGrid).setPathOverride(eq("http://localhost"));
    verify(listGrid).setSubCollectionFieldName(eq("Collection Field"));
    verify(formBuilderService).buildAdornedListForm(isA(AdornedTargetCollectionMetadata.class), isNull(), eq("42"),
        eq(false), isA(EntityForm.class), isA(List.class), eq(true));
    verify(formBuilderService).buildCollectionListGrid(eq("42"), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
    verify(formBuilderService).populateEntityFormFieldValues(isA(ClassMetadata.class), isA(Entity.class),
        isA(EntityForm.class));
    assertEquals(8, model.size());
    Object getResult = model.get("collectionProperty");
    assertTrue(getResult instanceof Property);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    Object getResult3 = model.get("entityForm");
    assertTrue(getResult3 instanceof EntityForm);
    assertEquals("42", entityForm.getParentId());
    assertEquals("Collection Field", ppr.getSectionEntityField());
    assertEquals("Section Key", model.get("sectionKey"));
    assertEquals("addCollectionItem", model.get("modalHeaderType"));
    assertEquals("http://localhost", model.get("currentUrl"));
    assertEquals("modal/adornedSelectEntity", model.get("viewType"));
    assertEquals("modules/modalContainer", actualBuildAddCollectionItemModelResult);
    assertEquals(1, ppr.getCustomCriteria().length);
    assertEquals(PersistencePackageRequest.Type.STANDARD, ppr.getType());
    assertTrue(model.containsKey("listGrid"));
    assertTrue(ppr.isAddOperationInspect());
    assertEquals(property, getResult);
    assertSame(collectionProperty, getResult);
    assertSame(adminSectionImpl, getResult2);
    assertSame(entityForm, getResult3);
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"})
  public void testBuildAddCollectionItemModel_thenThrowServiceException() throws ServiceException {
    // Arrange
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminBasicEntityController.buildAddCollectionItemModel(request, response,
        model, "42", "Collection Field", "Section Key", collectionProperty, md, ppr, entityForm, new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("Section Key"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService).buildCollectionListGrid(eq("42"), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"})
  public void testBuildAddCollectionItemModel_thenThrowUnsupportedOperationException() throws ServiceException {
    // Arrange
    ListGrid listGrid = mock(ListGrid.class);
    doThrow(new UnsupportedOperationException("owningClass=")).when(listGrid).setFriendlyName(Mockito.<String>any());
    doNothing().when(listGrid).setPathOverride(Mockito.<String>any());
    doNothing().when(listGrid).setSubCollectionFieldName(Mockito.<String>any());
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getPolymorphicEntities()).thenReturn(new ClassTree());
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.buildAddCollectionItemModel(request, response, model, "42", "Collection Field",
            "Section Key", collectionProperty, md, ppr, entityForm, new Entity()));
    verify(classMetaData).getPolymorphicEntities();
    verify(classMetaData).setCeilingType(eq("owningClass="));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("owningClass="));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("Section Key"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(persistenceResponse).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    verify(listGrid).setFriendlyName(isNull());
    verify(listGrid).setPathOverride(eq("http://localhost"));
    verify(listGrid).setSubCollectionFieldName(eq("Collection Field"));
    verify(formBuilderService).buildCollectionListGrid(eq("42"), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"})
  public void testReinitializeEntityForm() throws ServiceException {
    // Arrange
    doNothing().when(formBuilderService)
        .populateEntityForm(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(), Mockito.<EntityForm>any(), Mockito.<List<SectionCrumb>>any());
    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).removeAllActions();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[]{new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

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
    EntityForm actualReinitializeEntityFormResult = adminBasicEntityController.reinitializeEntityForm(entityForm,
        collectionMetadata, entity, subRecordsMap, sectionCrumbs);

    // Assert
    verify(entityForm).clearFieldsMap();
    verify(entityForm).removeAllActions();
    verify(formBuilderService).populateEntityForm(isA(ClassMetadata.class), isA(Entity.class), isA(Map.class),
        isA(EntityForm.class), isA(List.class));
    assertSame(entityForm, actualReinitializeEntityFormResult);
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}.
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"})
  public void testReinitializeEntityForm_givenSectionCrumbOriginalSectionIdentifierIs42() throws ServiceException {
    // Arrange
    doNothing().when(formBuilderService)
        .populateEntityForm(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(), Mockito.<EntityForm>any(), Mockito.<List<SectionCrumb>>any());
    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).removeAllActions();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[]{new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    EntityForm actualReinitializeEntityFormResult = adminBasicEntityController.reinitializeEntityForm(entityForm,
        collectionMetadata, entity, subRecordsMap, sectionCrumbs);

    // Assert
    verify(entityForm).clearFieldsMap();
    verify(entityForm).removeAllActions();
    verify(formBuilderService).populateEntityForm(isA(ClassMetadata.class), isA(Entity.class), isA(Map.class),
        isA(EntityForm.class), isA(List.class));
    assertSame(entityForm, actualReinitializeEntityFormResult);
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}.
   * <ul>
   *   <li>Then calls {@link FormBuilderService#createEntityForm(ClassMetadata, Entity, Map, List)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"})
  public void testReinitializeEntityForm_thenCallsCreateEntityForm() throws ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.createEntityForm(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
        Mockito.<Map<String, DynamicResultSet>>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(entityForm);

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[]{new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act
    EntityForm actualReinitializeEntityFormResult = adminBasicEntityController.reinitializeEntityForm(null,
        collectionMetadata, entity, subRecordsMap, new ArrayList<>());

    // Assert
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(Entity.class), isA(Map.class),
        isA(List.class));
    assertSame(entityForm, actualReinitializeEntityFormResult);
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}.
   * <ul>
   *   <li>Then return {@link EntityForm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"})
  public void testReinitializeEntityForm_thenReturnEntityForm() throws ServiceException {
    // Arrange
    doNothing().when(formBuilderService)
        .populateEntityForm(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(), Mockito.<EntityForm>any(), Mockito.<List<SectionCrumb>>any());
    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).removeAllActions();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[]{new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act
    EntityForm actualReinitializeEntityFormResult = adminBasicEntityController.reinitializeEntityForm(entityForm,
        collectionMetadata, entity, subRecordsMap, new ArrayList<>());

    // Assert
    verify(entityForm).clearFieldsMap();
    verify(entityForm).removeAllActions();
    verify(formBuilderService).populateEntityForm(isA(ClassMetadata.class), isA(Entity.class), isA(Map.class),
        isA(EntityForm.class), isA(List.class));
    assertSame(entityForm, actualReinitializeEntityFormResult);
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"})
  public void testReinitializeEntityForm_thenThrowUnsupportedOperationException() throws ServiceException {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    doThrow(new UnsupportedOperationException("foo")).when(entityForm).clearFieldsMap();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[]{new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> adminBasicEntityController
        .reinitializeEntityForm(entityForm, collectionMetadata, entity, subRecordsMap, new ArrayList<>()));
    verify(entityForm).clearFieldsMap();
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@link EntityForm} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"})
  public void testReinitializeEntityForm_whenEntityForm_thenReturnEntityForm() throws ServiceException {
    // Arrange
    doNothing().when(formBuilderService)
        .populateEntityForm(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(), Mockito.<EntityForm>any(), Mockito.<List<SectionCrumb>>any());
    EntityForm entityForm = new EntityForm();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[]{new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act
    EntityForm actualReinitializeEntityFormResult = adminBasicEntityController.reinitializeEntityForm(entityForm,
        collectionMetadata, entity, subRecordsMap, new ArrayList<>());

    // Assert
    verify(formBuilderService).populateEntityForm(isA(ClassMetadata.class), isA(Entity.class), isA(Map.class),
        isA(EntityForm.class), isA(List.class));
    assertSame(entityForm, actualReinitializeEntityFormResult);
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAuditableDisplayFields(EntityForm)"})
  public void testAddAuditableDisplayFields() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getName()).thenThrow(new UnsupportedOperationException("auditable.createdBy"));
    when(codeField.getValue()).thenReturn("42");
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.addAuditableDisplayFields(entityForm));
    verify(entityForm).findField(eq("auditable.createdBy"));
    verify(codeField).getName();
    verify(codeField).getValue();
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAuditableDisplayFields(EntityForm)"})
  public void testAddAuditableDisplayFields_givenField_whenEntityFormFindFieldReturnField() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminBasicEntityController.addAuditableDisplayFields(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   * <ul>
   *   <li>Then calls {@link EntityForm#findGroup(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAuditableDisplayFields(EntityForm)"})
  public void testAddAuditableDisplayFields_thenCallsFindGroup() {
    // Arrange
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());
    CodeField codeField = mock(CodeField.class);
    when(codeField.getOrder()).thenReturn(1);
    when(codeField.getFriendlyName()).thenReturn("Friendly Name");
    when(codeField.getName()).thenReturn("Name");
    when(codeField.getOwningEntityClass()).thenReturn("Owning Entity Class");
    doNothing().when(codeField).setIsVisible(Mockito.<Boolean>any());
    when(codeField.getValue()).thenReturn("42");
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findGroup(Mockito.<String>any())).thenReturn(new FieldGroup());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminBasicEntityController.addAuditableDisplayFields(entityForm);

    // Assert
    verify(adminUserDao, atLeast(1)).readAdminUserById(eq(42L));
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).findGroup(eq("AdminAuditable_Audit"));
    verify(codeField, atLeast(1)).getFriendlyName();
    verify(codeField, atLeast(1)).getName();
    verify(codeField, atLeast(1)).getOrder();
    verify(codeField, atLeast(1)).getOwningEntityClass();
    verify(codeField, atLeast(1)).getValue();
    verify(codeField, atLeast(1)).setIsVisible(eq(false));
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   * <ul>
   *   <li>Then calls {@link AdminUser#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminBasicEntityController.addAuditableDisplayFields(EntityForm)"})
  public void testAddAuditableDisplayFields_thenCallsGetName() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getName()).thenThrow(new UnsupportedOperationException("foo"));
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(adminUser);
    CodeField codeField = mock(CodeField.class);
    when(codeField.getOrder()).thenReturn(1);
    when(codeField.getFriendlyName()).thenReturn("Friendly Name");
    when(codeField.getName()).thenReturn("Name");
    when(codeField.getOwningEntityClass()).thenReturn("Owning Entity Class");
    when(codeField.getValue()).thenReturn("42");
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.addAuditableDisplayFields(entityForm));
    verify(adminUserDao).readAdminUserById(eq(42L));
    verify(adminUser).getName();
    verify(entityForm).findField(eq("auditable.createdBy"));
    verify(codeField).getFriendlyName();
    verify(codeField).getName();
    verify(codeField).getOrder();
    verify(codeField).getOwningEntityClass();
    verify(codeField, atLeast(1)).getValue();
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentTabName(Map, ClassMetadata)"})
  public void testGetCurrentTabName_givenTabMetadata_thenReturnNull() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(new TabMetadata());
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
    String actualCurrentTabName = adminBasicEntityController.getCurrentTabName(pathVars, cmd);

    // Assert
    verify(cmd).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    assertNull(actualCurrentTabName);
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   * <ul>
   *   <li>Given {@code tabName}.</li>
   *   <li>Then return {@code Path Vars}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentTabName(Map, ClassMetadata)"})
  public void testGetCurrentTabName_givenTabName_thenReturnPathVars() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("tabName", "Path Vars");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("Path Vars", adminBasicEntityController.getCurrentTabName(pathVars, cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentTabName(Map, ClassMetadata)"})
  public void testGetCurrentTabName_thenThrowUnsupportedOperationException() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();
    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabName()).thenThrow(new UnsupportedOperationException("foo"));
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getFirstTab()).thenReturn(tabMetadata);
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

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> adminBasicEntityController.getCurrentTabName(pathVars, cmd));
    verify(cmd).getFirstTab();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(tabMetadata).getTabName();
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   * <ul>
   *   <li>When {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.</li>
   *   <li>Then return {@code General}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentTabName(Map, ClassMetadata)"})
  public void testGetCurrentTabName_whenClassMetadataCeilingTypeIsType_thenReturnGeneral() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("General", adminBasicEntityController.getCurrentTabName(pathVars, cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}.
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentFolderId(HttpServletRequest)"})
  public void testGetCurrentFolderId() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertEquals("unassigned",
        adminBasicEntityController.getCurrentFolderId(new JSCompatibilityRequestWrapper(request)));
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code currentFolderId}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentFolderId(HttpServletRequest)"})
  public void testGetCurrentFolderId_givenCurrentFolderId_thenReturnHttpsExampleOrgExample() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("currentFolderId", "https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example",
        adminBasicEntityController.getCurrentFolderId(new JSCompatibilityRequestWrapper(request)));
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentFolderId(HttpServletRequest)"})
  public void testGetCurrentFolderId_givenEmptyString() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("", "https://example.org/example");

    // Act and Assert
    assertEquals("unassigned",
        adminBasicEntityController.getCurrentFolderId(new JSCompatibilityRequestWrapper(request)));
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code unassigned}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentFolderId(HttpServletRequest)"})
  public void testGetCurrentFolderId_thenReturnUnassigned() {
    // Arrange, Act and Assert
    assertEquals("unassigned",
        adminBasicEntityController.getCurrentFolderId(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));
  }
}
