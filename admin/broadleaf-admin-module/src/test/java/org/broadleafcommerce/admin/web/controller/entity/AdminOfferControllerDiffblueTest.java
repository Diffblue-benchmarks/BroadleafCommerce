/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.controller.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.admin.web.controller.extension.AdminOfferControllerExtensionHandler;
import org.broadleafcommerce.common.persistence.EntityDuplicator;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.remote.EntityOperationType;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
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
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;

@RunWith(MockitoJUnitRunner.class)
public class AdminOfferControllerDiffblueTest {
  @Mock
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Mock
  private AdminEntityService adminEntityService;

  @Mock
  private AdminNavigationService adminNavigationService;

  @InjectMocks
  private AdminOfferController adminOfferController;

  @Mock
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock
  private AdminUserDao adminUserDao;

  @Mock
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock
  private DynamicEntityDao dynamicEntityDao;

  @Mock
  private EntityDuplicator entityDuplicator;

  @Mock
  private ExploitProtectionService exploitProtectionService;

  @Mock
  private FormBuilderService formBuilderService;

  @Mock
  private GenericEntityService genericEntityService;

  @Mock
  private OfferService offerService;

  @Mock
  private RowLevelSecurityService rowLevelSecurityService;

  @Mock
  private SandBoxHelper sandBoxHelper;

  @Mock
  private SecurityVerifier securityVerifier;

  /**
   * Test {@link AdminOfferController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminOfferController.getSectionKey(Map)"})
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminOfferController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminOfferController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminOfferController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminOfferController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange, Act and Assert
    assertEquals(AdminOfferController.SECTION_KEY, adminOfferController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminOfferController#getSectionCustomCriteria()}.
   * <p>
   * Method under test: {@link AdminOfferController#getSectionCustomCriteria()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] AdminOfferController.getSectionCustomCriteria()"})
  public void testGetSectionCustomCriteria() {
    // Arrange, Act and Assert
    assertEquals(0, (new AdminOfferController()).getSectionCustomCriteria().length);
  }

  /**
   * Test {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <p>
   * Method under test: {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminOfferController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"})
  public void testViewEntityList() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy()).thenReturn(new AdminOfferControllerExtensionHandler());
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
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
   * Test {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <p>
   * Method under test: {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminOfferController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"})
  public void testViewEntityList2() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    when(adminAbstractControllerExtensionManager.getProxy()).thenReturn(new AdminOfferControllerExtensionHandler());
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
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
   * Test {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) Properties is empty array of {@link Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminOfferController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"})
  public void testViewEntityList_givenClassMetadataPropertiesIsEmptyArrayOfProperty() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy()).thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(Mockito.<DynamicResultSet>any(), Mockito.<ClassMetadata>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{});
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
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
   * Test {@link AdminOfferController#duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)}.
   * <ul>
   *   <li>Given {@link AdminSectionCustomCriteriaService}.</li>
   *   <li>Then model size one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminOfferController.duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)"})
  public void testDuplicateEntity_givenAdminSectionCustomCriteriaService_thenModelSizeOne() throws Exception {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(entityDuplicator.copy(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn("Copy");
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/offer/{id}/duplicate", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("entityForm"));
  }

  /**
   * Test {@link AdminOfferController#duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)}.
   * <ul>
   *   <li>Given {@link EntityDuplicator} {@link EntityDuplicator#copy(Class, Long)} return BroadleafRequestContext is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminOfferController.duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)"})
  public void testDuplicateEntity_givenEntityDuplicatorCopyReturnBroadleafRequestContextIsTrue() throws Exception {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(entityDuplicator.copy(Mockito.<Class<Object>>any(), Mockito.<Long>any()))
        .thenReturn(BroadleafRequestContext.getBroadleafRequestContext(true));
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(new SimpleDateFormat("yyyy/mm/dd"));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/offer/{id}/duplicate", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(1))
        .andExpect(MockMvcResultMatchers.model().attributeExists("entityForm"));
  }

  /**
   * Test {@link AdminOfferController#modifyModelAttributes(Model)}.
   * <p>
   * Method under test: {@link AdminOfferController#modifyModelAttributes(Model)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminOfferController.modifyModelAttributes(Model)"})
  public void testModifyModelAttributes() {
    // Arrange
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminOfferController.modifyModelAttributes(model);

    // Assert
    assertEquals(1, model.size());
    assertEquals("offer-form", model.get("additionalControllerClasses"));
  }
}
