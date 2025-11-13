package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
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
import org.broadleafcommerce.cms.admin.web.service.AssetFormBuilderService;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
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
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
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
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RunWith(MockitoJUnitRunner.class)
public class AdminAssetControllerDiffblueTest {
  @Mock private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @InjectMocks private AdminAssetController adminAssetController;

  @Mock private AdminEntityService adminEntityService;

  @Mock private AdminNavigationService adminNavigationService;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock private AssetFormBuilderService assetFormBuilderService;

  @Mock private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock private EntityFormValidator entityFormValidator;

  @Mock private FormBuilderService formBuilderService;

  @Mock private RowLevelSecurityService rowLevelSecurityService;

  @Mock private SecurityVerifier securityVerifier;

  /**
   * Test {@link AdminAssetController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>Given {@code sectionKey}.
   *   <li>Then return {@code sectionKey}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAssetController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminAssetController.getSectionKey(Map)"})
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    // Arrange
    AdminAssetController adminAssetController = new AdminAssetController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminAssetController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminAssetController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link AdminAssetController#SECTION_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAssetController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminAssetController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange
    AdminAssetController adminAssetController = new AdminAssetController();

    // Act and Assert
    assertEquals(
        AdminAssetController.SECTION_KEY, adminAssetController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminAssetController#viewEntityList(HttpServletRequest, HttpServletResponse, Model,
   * Map, MultiValueMap)}.
   *
   * <p>Method under test: {@link AdminAssetController#viewEntityList(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminAssetController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityList() throws Exception {
    // Arrange
    doNothing()
        .when(assetFormBuilderService)
        .addImageThumbnailField(Mockito.<ListGrid>any(), Mockito.<String>any());
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
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("sectionKey");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("sectionKey");
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

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/assets");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminAssetController)
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
   * Test {@link AdminAssetController#viewEntityList(HttpServletRequest, HttpServletResponse, Model,
   * Map, MultiValueMap)}.
   *
   * <p>Method under test: {@link AdminAssetController#viewEntityList(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminAssetController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityList2() throws Exception {
    // Arrange
    doNothing()
        .when(assetFormBuilderService)
        .addImageThumbnailField(Mockito.<ListGrid>any(), Mockito.<String>any());
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
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("sectionKey");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("sectionKey");
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

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/assets");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminAssetController)
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
   * Test {@link AdminAssetController#viewEntityList(HttpServletRequest, HttpServletResponse, Model,
   * Map, MultiValueMap)}.
   *
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) Properties is empty array of {@link
   *       Property}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAssetController#viewEntityList(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminAssetController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityList_givenClassMetadataPropertiesIsEmptyArrayOfProperty()
      throws Exception {
    // Arrange
    doNothing()
        .when(assetFormBuilderService)
        .addImageThumbnailField(Mockito.<ListGrid>any(), Mockito.<String>any());
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
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("sectionKey");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("sectionKey");
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

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/assets");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminAssetController)
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
   * Test {@link AdminAssetController#viewEntityList(HttpServletRequest, HttpServletResponse, Model,
   * Map, MultiValueMap)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Metadata is {@link AdornedTargetCollectionMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminAssetController#viewEntityList(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminAssetController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityList_givenPropertyMetadataIsAdornedTargetCollectionMetadata()
      throws Exception {
    // Arrange
    doNothing()
        .when(assetFormBuilderService)
        .addImageThumbnailField(Mockito.<ListGrid>any(), Mockito.<String>any());
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
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("sectionKey");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("sectionKey");
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

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/assets");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminAssetController)
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
   * Test {@link AdminAssetController#viewEntityList(HttpServletRequest, HttpServletResponse, Model,
   * Map, MultiValueMap)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canAdd(AdminUser,
   *       String, ClassMetadata)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminAssetController#viewEntityList(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminAssetController.viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityList_givenRowLevelSecurityServiceCanAddReturnFalse() throws Exception {
    // Arrange
    doNothing()
        .when(assetFormBuilderService)
        .addImageThumbnailField(Mockito.<ListGrid>any(), Mockito.<String>any());
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
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("sectionKey");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("sectionKey");
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

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/assets");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminAssetController)
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
   * Test {@link AdminAssetController#saveEntity(HttpServletRequest, HttpServletResponse, Model,
   * Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link AdminAssetController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminAssetController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"
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
        MockMvcRequestBuilders.post("/assets/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminAssetController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/assets/42"))
        .andExpect(redirectedUrl("/assets/42"));
  }

  /**
   * Test {@link AdminAssetController#saveEntity(HttpServletRequest, HttpServletResponse, Model,
   * Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link AdminAssetController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminAssetController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"
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
        MockMvcRequestBuilders.post("/assets/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminAssetController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/assets/42"))
        .andExpect(redirectedUrl("/assets/42"));
  }

  /**
   * Test {@link AdminAssetController#getDefaultEntityType()}.
   *
   * <p>Method under test: {@link AdminAssetController#getDefaultEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminAssetController.getDefaultEntityType()"})
  public void testGetDefaultEntityType() {
    // Arrange, Act and Assert
    assertEquals(
        "org.broadleafcommerce.cms.file.domain.StaticAssetImpl",
        new AdminAssetController().getDefaultEntityType());
  }
}
