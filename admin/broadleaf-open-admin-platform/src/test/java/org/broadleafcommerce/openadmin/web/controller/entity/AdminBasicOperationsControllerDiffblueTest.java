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

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.controller.AbstractAdminAbstractControllerExtensionHandler;
import org.broadleafcommerce.openadmin.web.controller.AbstractAdminBasicOperationsControllerExtensionHandler;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.controller.AdminBasicOperationsControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
import org.broadleafcommerce.openadmin.web.service.SearchFieldResolver;
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
import org.springframework.util.MultiValueMap;

@RunWith(MockitoJUnitRunner.class)
public class AdminBasicOperationsControllerDiffblueTest {
  @Mock
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @InjectMocks
  private AdminBasicOperationsController adminBasicOperationsController;

  @Mock
  private AdminBasicOperationsControllerExtensionManager adminBasicOperationsControllerExtensionManager;

  @Mock
  private AdminEntityService adminEntityService;

  @Mock
  private AdminNavigationService adminNavigationService;

  @Mock
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock
  private ExploitProtectionService exploitProtectionService;

  @Mock
  private FormBuilderService formBuilderService;

  @Mock
  private SearchFieldResolver searchFieldResolver;

  @Mock
  private SecurityVerifier securityVerifier;

  /**
   * Test {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}.
   * <p>
   * Method under test: {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicOperationsController.showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)"})
  public void testShowSelectCollectionItem() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(Mockito.<DynamicResultSet>any(), Mockito.<ClassMetadata>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(adminBasicOperationsControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminBasicOperationsControllerExtensionHandler());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
        .get("/{owningClass:.*}/{collectionField:.*}/select", "U", "U");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("dynamicField", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(9))
        .andExpect(MockMvcResultMatchers.model()
            .attributeExists("collectionProperty", "currentAdminSection", "currentUrl", "listGrid", "modalHeaderType",
                "sectionKey", "viewType"))
        .andExpect(MockMvcResultMatchers.view().name("modules/modalContainer"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}.
   * <p>
   * Method under test: {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicOperationsController.showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)"})
  public void testShowSelectCollectionItem2() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(Mockito.<DynamicResultSet>any(), Mockito.<ClassMetadata>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(adminBasicOperationsControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminBasicOperationsControllerExtensionHandler());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
        .get("/{owningClass:.*}/{collectionField:.*}/select", "U", "U");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("dynamicField", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(9))
        .andExpect(MockMvcResultMatchers.model()
            .attributeExists("collectionProperty", "currentAdminSection", "currentUrl", "listGrid", "modalHeaderType",
                "sectionKey", "viewType"))
        .andExpect(MockMvcResultMatchers.view().name("modules/modalContainer"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) FriendlyName is {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicOperationsController.showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)"})
  public void testShowSelectCollectionItem_givenListGridFriendlyNameIsQuestionMark() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});
    when(exploitProtectionService.cleanString(Mockito.<String>any())).thenReturn("Clean String");
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    ListGrid listGrid = new ListGrid();
    listGrid.setFriendlyName("?");
    when(formBuilderService.buildMainListGrid(Mockito.<DynamicResultSet>any(), Mockito.<ClassMetadata>any(),
        Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(adminBasicOperationsControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminBasicOperationsControllerExtensionHandler());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
        .get("/{owningClass:.*}/{collectionField:.*}/select", "U", "U");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("dynamicField", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(9))
        .andExpect(MockMvcResultMatchers.model()
            .attributeExists("collectionProperty", "currentAdminSection", "currentUrl", "listGrid", "modalHeaderType",
                "sectionKey", "viewType"))
        .andExpect(MockMvcResultMatchers.view().name("modules/modalContainer"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicOperationsController.sessionTimerReset(HttpServletRequest, HttpServletResponse)"})
  public void testSessionTimerReset() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/sessionTimerReset");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("{\"serverSessionTimeoutInterval\":0}"));
  }

  /**
   * Test {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}.
   * <p>
   * Method under test: {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicOperationsController.logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)"})
  public void testLogJavaScriptError() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/logJavaScriptError");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("{\"errorLogged\":true}"));
  }

  /**
   * Test {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}.
   * <p>
   * Method under test: {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminBasicOperationsController.updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)"})
  public void testUpdateAdminNavigation() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/update-navigation");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.model().size(0))
        .andExpect(MockMvcResultMatchers.view().name("layout/partials/secondLeftNav"))
        .andExpect(MockMvcResultMatchers.forwardedUrl("layout/partials/secondLeftNav"));
  }
}
