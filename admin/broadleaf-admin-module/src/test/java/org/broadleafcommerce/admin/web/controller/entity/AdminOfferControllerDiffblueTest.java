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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.admin.web.controller.extension.AdminOfferControllerExtensionHandler;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
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
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
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

@RunWith(MockitoJUnitRunner.class)
public class AdminOfferControllerDiffblueTest {
  @Mock private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Mock private AdminEntityService adminEntityService;

  @Mock private AdminNavigationService adminNavigationService;

  @InjectMocks private AdminOfferController adminOfferController;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock private FormBuilderService formBuilderService;

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
    AdminOfferController adminOfferController = new AdminOfferController();

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
    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();

    // Act and Assert
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
    AdminOfferController adminOfferController = new AdminOfferController();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminOfferController.modifyModelAttributes(model);

    // Assert
    assertEquals(1, model.size());
    assertEquals("offer-form", model.get("additionalControllerClasses"));
  }
}
