package org.broadleafcommerce.openadmin.web.controller.entity;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
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

@RunWith(MockitoJUnitRunner.class)
public class AdminBasicOperationsControllerDiffblueTest {
  @Mock private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @InjectMocks private AdminBasicOperationsController adminBasicOperationsController;

  @Mock
  private AdminBasicOperationsControllerExtensionManager
      adminBasicOperationsControllerExtensionManager;

  @Mock private AdminEntityService adminEntityService;

  @Mock private AdminNavigationService adminNavigationService;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock private FormBuilderService formBuilderService;

  /**
   * Test {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}.
   *
   * <p>Method under test: {@link
   * AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicOperationsController.showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)"
  })
  public void testShowSelectCollectionItem() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
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
    when(adminBasicOperationsControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminBasicOperationsControllerExtensionHandler());

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/{owningClass:.*}/{collectionField:.*}/select", "xx", "xx");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("dynamicField", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(9))
        .andExpect(
            model()
                .attributeExists(
                    "collectionProperty",
                    "currentAdminSection",
                    "currentUrl",
                    "listGrid",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}.
   *
   * <p>Method under test: {@link
   * AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicOperationsController.showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)"
  })
  public void testShowSelectCollectionItem2() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
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
    when(adminBasicOperationsControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminBasicOperationsControllerExtensionHandler());

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/{owningClass:.*}/{collectionField:.*}/select", "xx", "xx");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("dynamicField", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(9))
        .andExpect(
            model()
                .attributeExists(
                    "collectionProperty",
                    "currentAdminSection",
                    "currentUrl",
                    "listGrid",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}.
   *
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor) FriendlyName is {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicOperationsController.showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)"
  })
  public void testShowSelectCollectionItem_givenListGridFriendlyNameIsQuestionMark()
      throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    ListGrid listGrid = new ListGrid();
    listGrid.setFriendlyName("?");
    when(formBuilderService.buildMainListGrid(
            Mockito.<DynamicResultSet>any(),
            Mockito.<ClassMetadata>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);

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
    when(adminBasicOperationsControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminBasicOperationsControllerExtensionHandler());

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/{owningClass:.*}/{collectionField:.*}/select", "xx", "xx");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("dynamicField", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(9))
        .andExpect(
            model()
                .attributeExists(
                    "collectionProperty",
                    "currentAdminSection",
                    "currentUrl",
                    "listGrid",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}.
   *
   * <ul>
   *   <li>Given {@code xx}.
   *   <li>When array of {@link Object} with {@code xx} and {@code xx}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicOperationsController.showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)"
  })
  public void testShowSelectCollectionItem_givenXx_whenArrayOfObjectWithXxAndXx() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
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
    when(adminBasicOperationsControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminBasicOperationsControllerExtensionHandler());

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/{owningClass:.*}/{collectionField:.*}/select", "xx", "|");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("dynamicField", String.valueOf(true));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(9))
        .andExpect(
            model()
                .attributeExists(
                    "collectionProperty",
                    "currentAdminSection",
                    "currentUrl",
                    "listGrid",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicOperationsController.showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)"
  })
  public void testShowSelectCollectionItem_whenFoo() throws Exception {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
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
    when(adminBasicOperationsControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminBasicOperationsControllerExtensionHandler());

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/{owningClass:.*}/{collectionField:.*}/select", "xx", "xx");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("dynamicField", String.valueOf(true)).param("requestingEntityId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(9))
        .andExpect(
            model()
                .attributeExists(
                    "collectionProperty",
                    "currentAdminSection",
                    "currentUrl",
                    "listGrid",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link
   * AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicOperationsController.sessionTimerReset(HttpServletRequest, HttpServletResponse)"
  })
  public void testSessionTimerReset() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/sessionTimerReset");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"serverSessionTimeoutInterval\":0}"));
  }

  /**
   * Test {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest,
   * HttpServletResponse, MultiValueMap)}.
   *
   * <p>Method under test: {@link
   * AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse,
   * MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicOperationsController.logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)"
  })
  public void testLogJavaScriptError() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/logJavaScriptError");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"errorLogged\":true}"));
  }

  /**
   * Test {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest,
   * HttpServletResponse, Model, Map)}.
   *
   * <p>Method under test: {@link
   * AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse,
   * Model, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicOperationsController.updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)"
  })
  public void testUpdateAdminNavigation() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/update-navigation");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(0))
        .andExpect(view().name("layout/partials/secondLeftNav"))
        .andExpect(forwardedUrl("layout/partials/secondLeftNav"));
  }
}
