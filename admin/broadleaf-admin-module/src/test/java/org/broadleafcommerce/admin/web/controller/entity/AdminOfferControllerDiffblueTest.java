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
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
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
import org.broadleafcommerce.openadmin.web.controller.AbstractAdminAbstractControllerExtensionHandler;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;

@RunWith(MockitoJUnitRunner.class)
public class AdminOfferControllerDiffblueTest {
  @Mock private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Mock private AdminEntityService adminEntityService;

  @Mock private AdminNavigationService adminNavigationService;

  @InjectMocks private AdminOfferController adminOfferController;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock private DynamicEntityDao dynamicEntityDao;

  @Mock private EntityDuplicator entityDuplicator;

  @Mock private FormBuilderService formBuilderService;

  @Mock private GenericEntityService genericEntityService;

  @Mock private RowLevelSecurityService rowLevelSecurityService;

  @Mock private SecurityVerifier securityVerifier;

  /**
   * Test {@link AdminOfferController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>Given {@code sectionKey}.
   *   <li>Then return {@code sectionKey}.
   * </ul>
   *
   * <p>Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link AdminOfferController#SECTION_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminOfferController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange, Act and Assert
    assertEquals(
        AdminOfferController.SECTION_KEY, adminOfferController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminOfferController#getSectionCustomCriteria()}.
   *
   * <p>Method under test: {@link AdminOfferController#getSectionCustomCriteria()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AdminOfferController.getSectionCustomCriteria()"})
  public void testGetSectionCustomCriteria() {
    // Arrange and Act
    String[] actualSectionCustomCriteria = new AdminOfferController().getSectionCustomCriteria();

    // Assert
    assertEquals(0, actualSectionCustomCriteria.length);
    assertSame(AdminOfferController.customCriteria, actualSectionCustomCriteria);
  }

  /**
   * Test {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model,
   * Map, MultiValueMap)}.
   *
   * <p>Method under test: {@link AdminOfferController#viewEntityList(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityList() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

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
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(11))
        .andExpect(
            model()
                .attributeExists(
                    "currentAdminSection",
                    "currentUri",
                    "currentUrl",
                    "entityTypes",
                    "isFilter",
                    "listGrid",
                    "mainActions",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/defaultContainer"))
        .andExpect(forwardedUrl("modules/defaultContainer"));
  }

  /**
   * Test {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model,
   * Map, MultiValueMap)}.
   *
   * <p>Method under test: {@link AdminOfferController#viewEntityList(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityList2() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

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
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(11))
        .andExpect(
            model()
                .attributeExists(
                    "currentAdminSection",
                    "currentUri",
                    "currentUrl",
                    "entityTypes",
                    "isFilter",
                    "listGrid",
                    "mainActions",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/defaultContainer"))
        .andExpect(forwardedUrl("modules/defaultContainer"));
  }

  /**
   * Test {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model,
   * Map, MultiValueMap)}.
   *
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) Properties is empty array of {@link
   *       Property}.
   * </ul>
   *
   * <p>Method under test: {@link AdminOfferController#viewEntityList(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityList_givenClassMetadataPropertiesIsEmptyArrayOfProperty()
      throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(11))
        .andExpect(
            model()
                .attributeExists(
                    "currentAdminSection",
                    "currentUri",
                    "currentUrl",
                    "entityTypes",
                    "isFilter",
                    "listGrid",
                    "mainActions",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/defaultContainer"))
        .andExpect(forwardedUrl("modules/defaultContainer"));
  }

  /**
   * Test {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model,
   * Map, MultiValueMap)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Metadata is {@link AdornedTargetCollectionMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminOfferController#viewEntityList(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityList_givenPropertyMetadataIsAdornedTargetCollectionMetadata()
      throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(11))
        .andExpect(
            model()
                .attributeExists(
                    "currentAdminSection",
                    "currentUri",
                    "currentUrl",
                    "entityTypes",
                    "isFilter",
                    "listGrid",
                    "mainActions",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/defaultContainer"))
        .andExpect(forwardedUrl("modules/defaultContainer"));
  }

  /**
   * Test {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model,
   * Map, MultiValueMap)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canAdd(AdminUser,
   *       String, ClassMetadata)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminOfferController#viewEntityList(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityList_givenRowLevelSecurityServiceCanAddReturnFalse() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

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
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(false);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(11))
        .andExpect(
            model()
                .attributeExists(
                    "currentAdminSection",
                    "currentUri",
                    "currentUrl",
                    "entityTypes",
                    "isFilter",
                    "listGrid",
                    "mainActions",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/defaultContainer"))
        .andExpect(forwardedUrl("modules/defaultContainer"));
  }

  /**
   * Test {@link AdminOfferController#viewAddEntityForm(HttpServletRequest, HttpServletResponse,
   * Model, Map, String)}.
   *
   * <p>Method under test: {@link AdminOfferController#viewAddEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewAddEntityForm() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    doNothing()
        .when(formBuilderService)
        .removeNonApplicableFields(
            Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new EntityForm());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/offer/add").param("entityType", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(9))
        .andExpect(
            model()
                .attributeExists(
                    "additionalControllerClasses",
                    "currentAdminSection",
                    "currentUrl",
                    "entityForm",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminOfferController#viewAddEntityForm(HttpServletRequest, HttpServletResponse,
   * Model, Map, String)}.
   *
   * <p>Method under test: {@link AdminOfferController#viewAddEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewAddEntityForm2() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    doNothing()
        .when(formBuilderService)
        .removeNonApplicableFields(
            Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new EntityForm());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/offer/add").param("entityType", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(9))
        .andExpect(
            model()
                .attributeExists(
                    "additionalControllerClasses",
                    "currentAdminSection",
                    "currentUrl",
                    "entityForm",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminOfferController#viewAddEntityForm(HttpServletRequest, HttpServletResponse,
   * Model, Map, String)}.
   *
   * <p>Method under test: {@link AdminOfferController#viewAddEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewAddEntityForm3() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    doNothing()
        .when(formBuilderService)
        .removeNonApplicableFields(
            Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new EntityForm());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/offer/add").param("entityType", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(9))
        .andExpect(
            model()
                .attributeExists(
                    "additionalControllerClasses",
                    "currentAdminSection",
                    "currentUrl",
                    "entityForm",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminOfferController#viewAddEntityForm(HttpServletRequest, HttpServletResponse,
   * Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   *   <li>When {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminOfferController#viewAddEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewAddEntityForm_givenEntityFormAddTabFromTabMetadataTabMetadata_whenFoo()
      throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());
    doNothing()
        .when(formBuilderService)
        .removeNonApplicableFields(
            Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/offer/add").param("entityType", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(9))
        .andExpect(
            model()
                .attributeExists(
                    "additionalControllerClasses",
                    "currentAdminSection",
                    "currentUrl",
                    "entityForm",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminOfferController#viewAddEntityForm(HttpServletRequest, HttpServletResponse,
   * Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) DynamicForm {@code ?} is {@link
   *       EntityForm} (default constructor).
   *   <li>When {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminOfferController#viewAddEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewAddEntityForm_givenEntityFormDynamicFormQuestionMarkIsEntityForm_whenFoo()
      throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());

    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("?", new EntityForm());
    doNothing()
        .when(formBuilderService)
        .removeNonApplicableFields(
            Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/offer/add").param("entityType", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(9))
        .andExpect(
            model()
                .attributeExists(
                    "additionalControllerClasses",
                    "currentAdminSection",
                    "currentUrl",
                    "entityForm",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminOfferController#duplicateEntity(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, EntityForm, BindingResult)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then model size one.
   * </ul>
   *
   * <p>Method under test: {@link AdminOfferController#duplicateEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOfferController.duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)"
  })
  public void testDuplicateEntity_when42_thenModelSizeOne() throws Exception {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(entityDuplicator.copy(Mockito.<Class<Object>>any(), Mockito.<Long>any()))
        .thenReturn("Copy");
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(genericEntityService.getIdentifier(Mockito.<Object>any()))
        .thenReturn(new SimpleDateFormat("yyyy/mm/dd"));

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/offer/{id}/duplicate", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminOfferController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(1))
        .andExpect(model().attributeExists("entityForm"));
  }

  /**
   * Test {@link AdminOfferController#modifyModelAttributes(Model)}.
   *
   * <p>Method under test: {@link AdminOfferController#modifyModelAttributes(Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
