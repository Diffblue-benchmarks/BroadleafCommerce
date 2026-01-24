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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest.Type;
import org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSection;
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
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormAction;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.form.entity.FieldGroup;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
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
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RunWith(MockitoJUnitRunner.class)
public class AdminBasicEntityControllerDiffblueTest {
  @Mock private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @InjectMocks private AdminBasicEntityController adminBasicEntityController;

  @Mock private AdminEntityService adminEntityService;

  @Mock private AdminNavigationService adminNavigationService;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock private AdminUserDao adminUserDao;

  @Mock private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock private EntityFormValidator entityFormValidator;

  @Mock private FormBuilderService formBuilderService;

  @Mock private RowLevelSecurityService rowLevelSecurityService;

  @Mock private SecurityVerifier securityVerifier;

  /**
   * Test {@link AdminBasicEntityController#setupViewEntityListBasicModel(HttpServletRequest,
   * ClassMetadata, String, String, Model, MultiValueMap)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata,
   * String, String, Model, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminBasicEntityController.setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata, String, String, Model, MultiValueMap)"
  })
  public void testSetupViewEntityListBasicModel() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new UnsupportedOperationException());
    doThrow(new ServiceException("An error occurred"))
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.setupViewEntityListBasicModel(
                request, cmd, "xxx", "Section Class Name", model, new HttpHeaders()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
  }

  /**
   * Test {@link AdminBasicEntityController#setupViewEntityListBasicModel(HttpServletRequest,
   * ClassMetadata, String, String, Model, MultiValueMap)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata,
   * String, String, Model, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminBasicEntityController.setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata, String, String, Model, MultiValueMap)"
  })
  public void testSetupViewEntityListBasicModel2() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenThrow(new UnsupportedOperationException());
    MockHttpServletRequest request = new MockHttpServletRequest();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.setupViewEntityListBasicModel(
                request, cmd, "xxx", "Section Class Name", model, new HttpHeaders()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#setupViewEntityListBasicModel(HttpServletRequest,
   * ClassMetadata, String, String, Model, MultiValueMap)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getReadOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata,
   * String, String, Model, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminBasicEntityController.setupViewEntityListBasicModel(HttpServletRequest, ClassMetadata, String, String, Model, MultiValueMap)"
  })
  public void testSetupViewEntityListBasicModel_thenCallsGetReadOnly() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenThrow(new UnsupportedOperationException());

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.setupViewEntityListBasicModel(
                request, cmd, "xxx", "Section Class Name", model, new HttpHeaders()));
    verify(basicFieldMetadata).getReadOnly();
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse,
   * Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityListSelectize() throws Exception {
    // Arrange
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
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new SecurityServiceException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/{sectionKey:.+}/selectize", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isForbidden());
  }

  /**
   * Test {@link AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}.
   *
   * <ul>
   *   <li>Then content string {@code <Map><?>42</?></Map>}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse,
   * Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityListSelectize_thenContentStringMap42Map() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("?", "42");
    when(formBuilderService.constructSelectizeOptionMap(
            Mockito.<DynamicResultSet>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(stringObjectMap);

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

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/{sectionKey:.+}/selectize", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/xml;charset=UTF-8"))
        .andExpect(content().string("<Map><?>42</?></Map>"));
  }

  /**
   * Test {@link AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}.
   *
   * <ul>
   *   <li>When {@code Uri Variables}.
   *   <li>Then content string {@code <Map/>}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse,
   * Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityListSelectize_whenUriVariables_thenContentStringMap() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(formBuilderService.constructSelectizeOptionMap(
            Mockito.<DynamicResultSet>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(new HashMap<>());

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

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/{sectionKey:.+}/selectize", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/xml;charset=UTF-8"))
        .andExpect(content().string("<Map/>"));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   *
   * <ul>
   *   <li>Given {@link AdminBasicEntityController#CUSTOM_CRITERIA}.
   *   <li>Then return array of {@link String} with {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AdminBasicEntityController.getCustomCriteria(Map)"})
  public void testGetCustomCriteria_givenCustom_criteria_thenReturnArrayOfStringWithNull() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put(AdminBasicEntityController.CUSTOM_CRITERIA, new ArrayList<>());

    // Act and Assert
    assertArrayEquals(
        new String[] {null}, adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AdminBasicEntityController.getCustomCriteria(Map)"})
  public void testGetCustomCriteria_givenFoo_whenHashMapFooIsArrayList() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put("foo", new ArrayList<>());

    // Act and Assert
    assertArrayEquals(
        new String[] {null}, adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code Request Params}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AdminBasicEntityController.getCustomCriteria(Map)"})
  public void testGetCustomCriteria_thenReturnArrayOfStringWithRequestParams() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Request Params");

    HashMap<String, List<String>> requestParams = new HashMap<>();
    requestParams.put(AdminBasicEntityController.CUSTOM_CRITERIA, stringList);

    // Act and Assert
    assertArrayEquals(
        new String[] {"Request Params"},
        adminBasicEntityController.getCustomCriteria(requestParams));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AdminBasicEntityController.getCustomCriteria(Map)"})
  public void testGetCustomCriteria_whenHashMap_thenReturnNull() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    // Act and Assert
    assertNull(adminBasicEntityController.getCustomCriteria(new HashMap<>()));
  }

  /**
   * Test {@link AdminBasicEntityController#getCustomCriteria(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCustomCriteria(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AdminBasicEntityController.getCustomCriteria(Map)"})
  public void testGetCustomCriteria_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AdminBasicEntityController().getCustomCriteria(null));
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String,
   * ClassMetadata, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"
  })
  public void testAddAddActionIfAllowed() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new UnsupportedOperationException());
    doThrow(new ServiceException("An error occurred"))
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.addAddActionIfAllowed(
                "Section Class Name", cmd, new ArrayList<>()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String,
   * ClassMetadata, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"
  })
  public void testAddAddActionIfAllowed2() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenThrow(new UnsupportedOperationException());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.addAddActionIfAllowed(
                "Section Class Name", cmd, new ArrayList<>()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String,
   * ClassMetadata, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"
  })
  public void testAddAddActionIfAllowed3() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenThrow(new UnsupportedOperationException());

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.addAddActionIfAllowed(
                "Section Class Name", cmd, new ArrayList<>()));
    verify(basicFieldMetadata).getReadOnly();
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String,
   * ClassMetadata, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"
  })
  public void testAddAddActionIfAllowed_givenBasicFieldMetadataReadOnlyIsTrue()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setReadOnly(true);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ArrayList<EntityFormAction> mainActions = new ArrayList<>();

    // Act
    adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, mainActions);

    // Assert that nothing has changed
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(mainActions.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   *
   * <ul>
   *   <li>Given empty array of {@link Property}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String,
   * ClassMetadata, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"
  })
  public void testAddAddActionIfAllowed_givenEmptyArrayOfProperty() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ArrayList<EntityFormAction> mainActions = new ArrayList<>();

    // Act
    adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, mainActions);

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(mainActions.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Metadata is {@link AdornedTargetCollectionMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String,
   * ClassMetadata, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"
  })
  public void testAddAddActionIfAllowed_givenPropertyMetadataIsAdornedTargetCollectionMetadata()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ArrayList<EntityFormAction> mainActions = new ArrayList<>();

    // Act
    adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, mainActions);

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(mainActions.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#addAddActionIfAllowed(String, ClassMetadata, List)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canAdd(AdminUser,
   *       String, ClassMetadata)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAddActionIfAllowed(String,
   * ClassMetadata, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminBasicEntityController.addAddActionIfAllowed(String, ClassMetadata, List)"
  })
  public void testAddAddActionIfAllowed_givenRowLevelSecurityServiceCanAddReturnFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(false);

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(false);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    ArrayList<EntityFormAction> mainActions = new ArrayList<>();

    // Act
    adminBasicEntityController.addAddActionIfAllowed("Section Class Name", cmd, mainActions);

    // Assert that nothing has changed
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(mainActions.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"
  })
  public void testIsAddActionAllowed() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new UnsupportedOperationException());
    doThrow(new ServiceException("An error occurred"))
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"
  })
  public void testIsAddActionAllowed2() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenThrow(new UnsupportedOperationException());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"
  })
  public void testIsAddActionAllowed3() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenThrow(new UnsupportedOperationException());

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd));
    verify(basicFieldMetadata).getReadOnly();
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"
  })
  public void testIsAddActionAllowed_givenArrayOfPropertyWithProperty_thenReturnTrue()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsAddActionAllowedResult =
        adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getReadOnly()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"
  })
  public void testIsAddActionAllowed_givenBasicFieldMetadataGetReadOnlyReturnFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(false);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsAddActionAllowedResult =
        adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) ReadOnly is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"
  })
  public void testIsAddActionAllowed_givenBasicFieldMetadataReadOnlyIsTrue_thenReturnFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setReadOnly(true);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsAddActionAllowedResult =
        adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertFalse(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given empty array of {@link Property}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"
  })
  public void testIsAddActionAllowed_givenEmptyArrayOfProperty() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsAddActionAllowedResult =
        adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertFalse(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"
  })
  public void testIsAddActionAllowed_givenPropertyGetMetadataReturnBasicFieldMetadata()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsAddActionAllowedResult =
        adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertTrue(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Metadata is {@link AdornedTargetCollectionMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"
  })
  public void testIsAddActionAllowed_givenPropertyMetadataIsAdornedTargetCollectionMetadata()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsAddActionAllowedResult =
        adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertFalse(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isAddActionAllowed(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canAdd(AdminUser,
   *       String, ClassMetadata)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isAddActionAllowed(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminBasicEntityController.isAddActionAllowed(String, ClassMetadata)"
  })
  public void testIsAddActionAllowed_givenRowLevelSecurityServiceCanAddReturnFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(false);

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(false);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsAddActionAllowedResult =
        adminBasicEntityController.isAddActionAllowed("Section Class Name", cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(property, atLeast(1)).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Section Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Section Class Name"), isA(ClassMetadata.class));
    assertFalse(actualIsAddActionAllowedResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_givenArrayOfPropertyWithProperty() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertTrue(adminBasicEntityController.isNotReadOnly(cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getReadOnly()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_givenBasicFieldMetadataGetReadOnlyReturnFalse() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenReturn(false);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).getReadOnly();
    verify(property, atLeast(1)).getMetadata();
    assertTrue(actualIsNotReadOnlyResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) ReadOnly is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_givenBasicFieldMetadataReadOnlyIsTrue_thenReturnFalse() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setReadOnly(true);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(property, atLeast(1)).getMetadata();
    assertFalse(actualIsNotReadOnlyResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given empty array of {@link Property}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_givenEmptyArrayOfProperty() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertFalse(adminBasicEntityController.isNotReadOnly(cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_givenPropertyGetMetadataReturnBasicFieldMetadata() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsNotReadOnlyResult = adminBasicEntityController.isNotReadOnly(cmd);

    // Assert
    verify(property, atLeast(1)).getMetadata();
    assertTrue(actualIsNotReadOnlyResult);
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Metadata is {@link AdornedTargetCollectionMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_givenPropertyMetadataIsAdornedTargetCollectionMetadata() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertFalse(adminBasicEntityController.isNotReadOnly(cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#isNotReadOnly(ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminBasicEntityController.isNotReadOnly(ClassMetadata)"})
  public void testIsNotReadOnly_thenThrowUnsupportedOperationException() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenThrow(new UnsupportedOperationException());

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> adminBasicEntityController.isNotReadOnly(cmd));
    verify(basicFieldMetadata).getReadOnly();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link AdminBasicEntityController#viewAddEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#viewAddEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewAddEntityForm() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new SecurityServiceException());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree("Dr Jane Doe"));
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
        MockMvcRequestBuilders.get("/{sectionKey:.+}/add", "Uri Variables")
            .param("entityType", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isForbidden());
  }

  /**
   * Test {@link AdminBasicEntityController#viewAddEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#viewAddEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewAddEntityForm_thenStatusIsOk() throws Exception {
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
    classMetaData.setPolymorphicEntities(new ClassTree("Dr Jane Doe"));
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
        MockMvcRequestBuilders.get("/{sectionKey:.+}/add", "Uri Variables")
            .param("entityType", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(model().size(8))
        .andExpect(
            model()
                .attributeExists(
                    "currentAdminSection",
                    "currentUrl",
                    "entityForm",
                    "entityFriendlyName",
                    "modalHeaderType",
                    "sectionKey",
                    "viewType"))
        .andExpect(view().name("modules/modalContainer"))
        .andExpect(forwardedUrl("modules/modalContainer"));
  }

  /**
   * Test {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#determineEntityType(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.determineEntityType(String, ClassMetadata)"
  })
  public void testDetermineEntityType() throws UnsupportedEncodingException {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ClassTree polymorphicEntities = mock(ClassTree.class);
    when(polymorphicEntities.getChildren()).thenReturn(new ClassTree[] {new ClassTree()});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(polymorphicEntities);
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    String actualDetermineEntityTypeResult =
        adminBasicEntityController.determineEntityType(" ", cmd);

    // Assert
    verify(polymorphicEntities).getChildren();
    assertNull(actualDetermineEntityTypeResult);
  }

  /**
   * Test {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link ClassTree#ClassTree()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#determineEntityType(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.determineEntityType(String, ClassMetadata)"
  })
  public void testDetermineEntityType_givenClassTree_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertNull(adminBasicEntityController.determineEntityType(" ", cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link ClassTree#ClassTree()}.
   *   <li>When {@code Entity Type}.
   *   <li>Then return {@code Entity Type}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#determineEntityType(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.determineEntityType(String, ClassMetadata)"
  })
  public void testDetermineEntityType_givenClassTree_whenEntityType_thenReturnEntityType()
      throws UnsupportedEncodingException {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("Entity Type", adminBasicEntityController.determineEntityType("Entity Type", cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link ClassTree#ClassTree()}.
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#determineEntityType(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.determineEntityType(String, ClassMetadata)"
  })
  public void testDetermineEntityType_givenClassTree_whenNull_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertNull(adminBasicEntityController.determineEntityType(null, cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#determineEntityType(String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#determineEntityType(String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.determineEntityType(String, ClassMetadata)"
  })
  public void testDetermineEntityType_thenThrowUnsupportedOperationException()
      throws UnsupportedEncodingException {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    ClassTree polymorphicEntities = mock(ClassTree.class);
    when(polymorphicEntities.getFullyQualifiedClassname())
        .thenThrow(new UnsupportedOperationException());
    when(polymorphicEntities.getChildren()).thenReturn(new ClassTree[] {});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(polymorphicEntities);
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> adminBasicEntityController.determineEntityType(" ", cmd));
    verify(polymorphicEntities).getChildren();
    verify(polymorphicEntities).getFullyQualifiedClassname();
  }

  /**
   * Test {@link AdminBasicEntityController#addEntity(HttpServletRequest, HttpServletResponse,
   * Model, Map, EntityForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isForbidden()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#addEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.addEntity(HttpServletRequest, HttpServletResponse, Model, Map, EntityForm, BindingResult)"
  })
  public void testAddEntity_thenStatusIsForbidden() throws Exception {
    // Arrange
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
    when(adminEntityService.addEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new SecurityServiceException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/{sectionKey:.+}/add", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isForbidden());
  }

  /**
   * Test {@link AdminBasicEntityController#duplicateEntity(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, EntityForm, BindingResult)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#duplicateEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)"
  })
  public void testDuplicateEntity() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {});
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
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/{sectionKey:.+}/{id}/duplicate", "/", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/Uri Variables/duplicate"))
        .andExpect(redirectedUrl("/Uri Variables/duplicate"));
  }

  /**
   * Test {@link AdminBasicEntityController#duplicateEntity(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, EntityForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isForbidden()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#duplicateEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)"
  })
  public void testDuplicateEntity_thenStatusIsForbidden() throws Exception {
    // Arrange
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
    when(adminEntityService.updateEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new SecurityServiceException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/{sectionKey:.+}/{id}/duplicate", "/", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isForbidden());
  }

  /**
   * Test {@link AdminBasicEntityController#duplicateEntity(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, EntityForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#duplicateEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)"
  })
  public void testDuplicateEntity_thenStatusIsFound() throws Exception {
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
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/{sectionKey:.+}/{id}/duplicate", "/", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/Uri Variables/duplicate"))
        .andExpect(redirectedUrl("/Uri Variables/duplicate"));
  }

  /**
   * Test {@link AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse,
   * String)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#getErrorDuplicatingResponse(HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.getErrorDuplicatingResponse(HttpServletResponse, String)"
  })
  public void testGetErrorDuplicatingResponse() throws UnsupportedEncodingException {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualErrorDuplicatingResponse =
        adminBasicEntityController.getErrorDuplicatingResponse(response, "Code");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals(
        "{\"errors\":[{\"code\":\"Code\",\"errorType\":\"global\",\"message\":\"Duplication_Failure\"}]}",
        response.getContentAsString());
    assertNull(actualErrorDuplicatingResponse);
    assertEquals(81, response.getContentAsByteArray().length);
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link AdminBasicEntityController#viewEntityForm(HttpServletRequest, HttpServletResponse,
   * Model, Map, String)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {});

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
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new SecurityServiceException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/{sectionKey:.+}/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isForbidden());
  }

  /**
   * Test {@link AdminBasicEntityController#viewEntityForm(HttpServletRequest, HttpServletResponse,
   * Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link AdminEntityService} {@link
   *       AdminEntityService#getRecord(PersistencePackageRequest, String, ClassMetadata, boolean)}
   *       throw {@link SecurityServiceException#SecurityServiceException()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm_givenAdminEntityServiceGetRecordThrowSecurityServiceException()
      throws Exception {
    // Arrange
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
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new SecurityServiceException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/{sectionKey:.+}/{id}", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isForbidden());
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map,
   * ClassMetadata, Entity, List)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link HashMap#HashMap()} {@code tabName} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest,
   * Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"
  })
  public void testGetViewSubRecords_givenEmptyString_whenHashMapTabNameIsEmptyString()
      throws Exception {
    // Arrange
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("tabName", "");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualViewSubRecords =
        adminBasicEntityController.getViewSubRecords(
            request, pathVars, cmd, entity, new ArrayList<>());

    // Assert
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    assertTrue(actualViewSubRecords.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map,
   * ClassMetadata, Entity, List)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code tabName} is {@link TabMetadata} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest,
   * Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"
  })
  public void testGetViewSubRecords_givenHashMapTabNameIsTabMetadata_thenReturnEmpty()
      throws Exception {
    // Arrange
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, String> pathVars = new HashMap<>();

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("tabName", new TabMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);
    Entity entity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualViewSubRecords =
        adminBasicEntityController.getViewSubRecords(
            request, pathVars, cmd, entity, new ArrayList<>());

    // Assert
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), isNull());
    assertTrue(actualViewSubRecords.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map,
   * ClassMetadata, Entity, List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest,
   * Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"
  })
  public void testGetViewSubRecords_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws Exception {
    // Arrange
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, String> pathVars = new HashMap<>();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> crumbs = new ArrayList<>();
    crumbs.add(sectionCrumb);

    // Act
    Map<String, DynamicResultSet> actualViewSubRecords =
        adminBasicEntityController.getViewSubRecords(request, pathVars, cmd, entity, crumbs);

    // Assert
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    assertTrue(actualViewSubRecords.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map,
   * ClassMetadata, Entity, List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code
   *       tabName}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest,
   * Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"
  })
  public void testGetViewSubRecords_givenSectionCrumbOriginalSectionIdentifierIsTabName()
      throws Exception {
    // Arrange
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, String> pathVars = new HashMap<>();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
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

    // Act
    Map<String, DynamicResultSet> actualViewSubRecords =
        adminBasicEntityController.getViewSubRecords(request, pathVars, cmd, entity, crumbs);

    // Assert
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    assertTrue(actualViewSubRecords.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map,
   * ClassMetadata, Entity, List)}.
   *
   * <ul>
   *   <li>Given {@code tabName}.
   *   <li>When {@link HashMap#HashMap()} {@code tabName} is {@code tabName}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest,
   * Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"
  })
  public void testGetViewSubRecords_givenTabName_whenHashMapTabNameIsTabName_thenReturnEmpty()
      throws Exception {
    // Arrange
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
    MockHttpServletRequest request = new MockHttpServletRequest();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("tabName", "tabName");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualViewSubRecords =
        adminBasicEntityController.getViewSubRecords(
            request, pathVars, cmd, entity, new ArrayList<>());

    // Assert
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("tabName"));
    assertTrue(actualViewSubRecords.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map,
   * ClassMetadata, Entity, List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest,
   * Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"
  })
  public void testGetViewSubRecords_thenReturnEmpty() throws Exception {
    // Arrange
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, String> pathVars = new HashMap<>();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    Map<String, DynamicResultSet> actualViewSubRecords =
        adminBasicEntityController.getViewSubRecords(
            request, pathVars, cmd, entity, new ArrayList<>());

    // Assert
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    assertTrue(actualViewSubRecords.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map,
   * ClassMetadata, Entity, List)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest,
   * Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"
  })
  public void testGetViewSubRecords_thenThrowServiceException() throws Exception {
    // Arrange
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenThrow(new ServiceException("An error occurred"));
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, String> pathVars = new HashMap<>();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminBasicEntityController.getViewSubRecords(
                request, pathVars, cmd, entity, new ArrayList<>()));
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
  }

  /**
   * Test {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest, Map,
   * ClassMetadata, Entity, List)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getViewSubRecords(HttpServletRequest,
   * Map, ClassMetadata, Entity, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminBasicEntityController.getViewSubRecords(HttpServletRequest, Map, ClassMetadata, Entity, List)"
  })
  public void testGetViewSubRecords_thenThrowUnsupportedOperationException() throws Exception {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    HashMap<String, String> pathVars = new HashMap<>();

    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabName()).thenThrow(new UnsupportedOperationException());

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("tabName", tabMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);
    Entity entity = new Entity();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.getViewSubRecords(
                request, pathVars, cmd, entity, new ArrayList<>()));
    verify(tabMetadata).getTabName();
  }

  /**
   * Test {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest, String)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminBasicEntityController.buildDirtyList(Map, HttpServletRequest, String)"
  })
  public void testBuildDirtyList() throws ServiceException {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    HashMap<String, String> pathVars = new HashMap<>();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildDirtyList(
                pathVars, new MockHttpServletRequest(), "42"));
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
  }

  /**
   * Test {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.
   *   <li>Then return first is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminBasicEntityController.buildDirtyList(Map, HttpServletRequest, String)"
  })
  public void testBuildDirtyList_givenPropertyGetNameReturnName_thenReturnFirstIsName()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

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

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getIsDirty()).thenReturn(true);

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property});
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    HashMap<String, String> pathVars = new HashMap<>();

    // Act
    List<String> actualBuildDirtyListResult =
        adminBasicEntityController.buildDirtyList(pathVars, new MockHttpServletRequest(), "42");

    // Assert
    verify(entity).getProperties();
    verify(property).getIsDirty();
    verify(property).getName();
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    assertEquals(1, actualBuildDirtyListResult.size());
    assertEquals("Name", actualBuildDirtyListResult.get(0));
  }

  /**
   * Test {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminBasicEntityController.buildDirtyList(Map, HttpServletRequest, String)"
  })
  public void testBuildDirtyList_givenPropertyGetNameThrowUnsupportedOperationException()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

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

    Property property = mock(Property.class);
    when(property.getName()).thenThrow(new UnsupportedOperationException());
    when(property.getIsDirty()).thenReturn(true);

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property});
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    HashMap<String, String> pathVars = new HashMap<>();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildDirtyList(
                pathVars, new MockHttpServletRequest(), "42"));
    verify(entity).getProperties();
    verify(property).getIsDirty();
    verify(property).getName();
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
  }

  /**
   * Test {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} IsDirty is {@code true}.
   *   <li>Then return first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminBasicEntityController.buildDirtyList(Map, HttpServletRequest, String)"
  })
  public void testBuildDirtyList_givenPropertyIsDirtyIsTrue_thenReturnFirstIsNull()
      throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

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

    Property property = new Property();
    property.setIsDirty(true);

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property});
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    HashMap<String, String> pathVars = new HashMap<>();

    // Act
    List<String> actualBuildDirtyListResult =
        adminBasicEntityController.buildDirtyList(pathVars, new MockHttpServletRequest(), "42");

    // Assert
    verify(entity).getProperties();
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    assertEquals(1, actualBuildDirtyListResult.size());
    assertNull(actualBuildDirtyListResult.get(0));
  }

  /**
   * Test {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminBasicEntityController.buildDirtyList(Map, HttpServletRequest, String)"
  })
  public void testBuildDirtyList_thenReturnEmpty() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

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

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {new Property()});
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    HashMap<String, String> pathVars = new HashMap<>();

    // Act
    List<String> actualBuildDirtyListResult =
        adminBasicEntityController.buildDirtyList(pathVars, new MockHttpServletRequest(), "42");

    // Assert
    verify(entity).getProperties();
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    assertTrue(actualBuildDirtyListResult.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminBasicEntityController.buildDirtyList(Map, HttpServletRequest, String)"
  })
  public void testBuildDirtyList_thenReturnEmpty2() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {});

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

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {new Property()});
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    HashMap<String, String> pathVars = new HashMap<>();

    // Act
    List<String> actualBuildDirtyListResult =
        adminBasicEntityController.buildDirtyList(pathVars, new MockHttpServletRequest(), "42");

    // Assert
    verify(entity).getProperties();
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    assertTrue(actualBuildDirtyListResult.isEmpty());
  }

  /**
   * Test {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#buildDirtyList(Map, HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AdminBasicEntityController.buildDirtyList(Map, HttpServletRequest, String)"
  })
  public void testBuildDirtyList_thenThrowServiceException() throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

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
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    HashMap<String, String> pathVars = new HashMap<>();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminBasicEntityController.buildDirtyList(
                pathVars, new MockHttpServletRequest(), "42"));
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
  }

  /**
   * Test {@link AdminBasicEntityController#modifyEntityForm(Entity, EntityForm, Map)} with {@code
   * entity}, {@code entityForm}, {@code pathVars}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#modifyEntityForm(Entity, EntityForm,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminBasicEntityController.modifyEntityForm(Entity, EntityForm, Map)"})
  public void testModifyEntityFormWithEntityEntityFormPathVars() throws Exception {
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
   * Test {@link AdminBasicEntityController#modifyEntityForm(Entity, EntityForm, Map)} with {@code
   * entity}, {@code entityForm}, {@code pathVars}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#modifyEntityForm(Entity, EntityForm,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminBasicEntityController.modifyEntityForm(Entity, EntityForm, Map)"})
  public void testModifyEntityFormWithEntityEntityFormPathVars2() throws Exception {
    // Arrange
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenThrow(new UnsupportedOperationException());
    Entity entity = new Entity();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> adminBasicEntityController.modifyEntityForm(entity, entityForm, new HashMap<>()));
    verify(adminAbstractControllerExtensionManager).getProxy();
  }

  /**
   * Test {@link AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model,
   * EntityForm)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.resolveAppropriateEntityView(HttpServletRequest, Model, EntityForm)"
  })
  public void testResolveAppropriateEntityView() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualResolveAppropriateEntityViewResult =
        adminBasicEntityController.resolveAppropriateEntityView(request, model, new EntityForm());

    // Assert
    assertEquals(2, model.size());
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualResolveAppropriateEntityViewResult);
    assertTrue((Boolean) model.get("useAjaxUpdate"));
  }

  /**
   * Test {@link AdminBasicEntityController#removeEntity(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then view name {@code redirect:/Uri Variables}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#removeEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.removeEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"
  })
  public void testRemoveEntity_thenViewNameRedirectUriVariables() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminEntityService.removeEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new PersistenceResponse());
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(
            "/{sectionKey:.+}/{id}/delete", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/Uri Variables"))
        .andExpect(redirectedUrl("/Uri Variables"));
  }

  /**
   * Test {@link AdminBasicEntityController#removeEntity(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Then view name {@code redirect:/Uri Variables}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#removeEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.removeEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"
  })
  public void testRemoveEntity_thenViewNameRedirectUriVariables2() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(entityFormValidator.validate(
            Mockito.<EntityForm>any(), Mockito.<Entity>any(), Mockito.<Errors>any()))
        .thenReturn(true);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setEntity(new Entity());
    when(adminEntityService.removeEntity(
            Mockito.<EntityForm>any(), Mockito.<String[]>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(
            "/{sectionKey:.+}/{id}/delete", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isFound())
        .andExpect(model().size(0))
        .andExpect(view().name("redirect:/Uri Variables"))
        .andExpect(redirectedUrl("/Uri Variables"));
  }

  /**
   * Test {@link AdminBasicEntityController#getCollectionFieldRecords(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, MultiValueMap)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#getCollectionFieldRecords(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, String, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.getCollectionFieldRecords(HttpServletRequest, HttpServletResponse, Model, Map, String, String, MultiValueMap)"
  })
  public void testGetCollectionFieldRecords() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property("?", "42")});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new SecurityServiceException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/{sectionKey:.+}/{id}/{collectionField:.*}",
            "Uri Variables",
            "Uri Variables",
            "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isForbidden());
  }

  /**
   * Test {@link AdminBasicEntityController#getCollectionFieldRecords(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, MultiValueMap)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#getCollectionFieldRecords(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, String, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.getCollectionFieldRecords(HttpServletRequest, HttpServletResponse, Model, Map, String, String, MultiValueMap)"
  })
  public void testGetCollectionFieldRecords2() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {});

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property("?", "42")});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new SecurityServiceException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/{sectionKey:.+}/{id}/{collectionField:.*}",
            "Uri Variables",
            "Uri Variables",
            "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminBasicEntityController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isForbidden());
  }

  /**
   * Test {@link AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model,
   * String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@code entityTypes}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model, String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)"
  })
  public void testGetModalForBlankEntityType_givenEntityTypes() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("entityTypes");
    request.setRequestURI("Request");
    ConcurrentModel model = new ConcurrentModel();

    ClassTree polymorphicEntities = new ClassTree("Dr Jane Doe");
    polymorphicEntities.setFriendlyName("Cmd");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setPolymorphicEntities(polymorphicEntities);

    // Act
    String actualModalForBlankEntityType =
        adminBasicEntityController.getModalForBlankEntityType(request, model, "xxx", cmd);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    assertEquals(7, model.size());
    Object getResult = model.get("entityTypes");
    assertTrue(getResult instanceof List);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("Cmd", model.get("entityFriendlyName"));
    assertEquals("Request", model.get("currentUri"));
    assertEquals("addEntity", model.get("modalHeaderType"));
    assertEquals("modal/entityTypeSelection", model.get("viewType"));
    assertEquals("modules/modalContainer", actualModalForBlankEntityType);
    assertEquals("xxx", model.get("sectionKey"));
    assertEquals(1, ((List<ClassTree>) getResult).size());
    assertTrue(request.getMultiFileMap().isEmpty());
    assertSame(polymorphicEntities, cmd.getPolymorphicEntities());
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model,
   * String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code currentUri} is {@code Request}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model, String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)"
  })
  public void testGetModalForBlankEntityType_givenSlash_thenConcurrentModelCurrentUriIsRequest() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("/");
    request.setRequestURI("Request");
    ConcurrentModel model = new ConcurrentModel();

    ClassTree polymorphicEntities = new ClassTree("Dr Jane Doe");
    polymorphicEntities.setFriendlyName("Cmd");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setPolymorphicEntities(polymorphicEntities);

    // Act
    String actualModalForBlankEntityType =
        adminBasicEntityController.getModalForBlankEntityType(request, model, "xxx", cmd);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    assertEquals(7, model.size());
    Object getResult = model.get("entityTypes");
    assertTrue(getResult instanceof List);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("Cmd", model.get("entityFriendlyName"));
    assertEquals("Request", model.get("currentUri"));
    assertEquals("addEntity", model.get("modalHeaderType"));
    assertEquals("modal/entityTypeSelection", model.get("viewType"));
    assertEquals("modules/modalContainer", actualModalForBlankEntityType);
    assertEquals("xxx", model.get("sectionKey"));
    assertEquals(1, ((List<ClassTree>) getResult).size());
    assertTrue(request.getMultiFileMap().isEmpty());
    assertSame(polymorphicEntities, cmd.getPolymorphicEntities());
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model,
   * String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code currentUri} is {@code equest}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model, String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)"
  })
  public void testGetModalForBlankEntityType_thenConcurrentModelCurrentUriIsEquest() {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("");
    request.setRequestURI("Request");
    ConcurrentModel model = new ConcurrentModel();

    ClassTree polymorphicEntities = new ClassTree("Dr Jane Doe");
    polymorphicEntities.setFriendlyName("Cmd");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setPolymorphicEntities(polymorphicEntities);

    // Act
    String actualModalForBlankEntityType =
        adminBasicEntityController.getModalForBlankEntityType(request, model, "xxx", cmd);

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    assertEquals(7, model.size());
    Object getResult = model.get("entityTypes");
    assertTrue(getResult instanceof List);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("Cmd", model.get("entityFriendlyName"));
    assertEquals("addEntity", model.get("modalHeaderType"));
    assertEquals("equest", model.get("currentUri"));
    assertEquals("modal/entityTypeSelection", model.get("viewType"));
    assertEquals("modules/modalContainer", actualModalForBlankEntityType);
    assertEquals("xxx", model.get("sectionKey"));
    assertEquals(1, ((List<ClassTree>) getResult).size());
    assertTrue(request.getMultiFileMap().isEmpty());
    assertSame(polymorphicEntities, cmd.getPolymorphicEntities());
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model,
   * String, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#getModalForBlankEntityType(HttpServletRequest, Model, String,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.getModalForBlankEntityType(HttpServletRequest, Model, String, ClassMetadata)"
  })
  public void testGetModalForBlankEntityType_thenThrowUnsupportedOperationException() {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("/");
    request.setRequestURI("Request");
    ConcurrentModel model = new ConcurrentModel();

    ClassTree polymorphicEntities = new ClassTree("Dr Jane Doe");
    polymorphicEntities.setFriendlyName("Cmd");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setPolymorphicEntities(polymorphicEntities);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> adminBasicEntityController.getModalForBlankEntityType(request, model, "xxx", cmd));
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
  }

  /**
   * Test {@link AdminBasicEntityController#buildSelectizeCustomCriteria()}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#buildSelectizeCustomCriteria()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] AdminBasicEntityController.buildSelectizeCustomCriteria()"})
  public void testBuildSelectizeCustomCriteria() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {AdminBasicEntityController.IS_SELECTIZE_REQUEST},
        new AdminBasicEntityController().buildSelectizeCustomCriteria());
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel() throws ServiceException {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel2() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel3() throws ServiceException {
    // Arrange
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("xxx"), isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel4() throws ServiceException {
    // Arrange
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenThrow(new ServiceException("An error occurred"));
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isNull(),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("xxx"), isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel5() throws ServiceException {
    // Arrange
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenThrow(new ServiceException("An error occurred"));
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isNull(),
            eq("42"),
            eq(false),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("xxx"), isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel6() throws ServiceException {
    // Arrange
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.PERSIST);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(md).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).setAddOperationInspect(true);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel7() throws ServiceException {
    // Arrange
    doThrow(new UnsupportedOperationException())
        .when(formBuilderService)
        .removeNonApplicableFields(
            Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new EntityForm());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.PERSIST);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(md).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr, atLeast(1)).getCeilingEntityClassname();
    verify(ppr).setAddOperationInspect(true);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(List.class));
    verify(formBuilderService)
        .removeNonApplicableFields(
            isA(ClassMetadata.class), isA(EntityForm.class), eq("Ceiling Entity Classname"));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel8() throws ServiceException {
    // Arrange
    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(new Tab());

    EntityForm entityForm = mock(EntityForm.class);
    doThrow(new UnsupportedOperationException())
        .when(entityForm)
        .setParentId(Mockito.<String>any());
    when(entityForm.getTabs()).thenReturn(tabSet);
    doNothing().when(entityForm).setCeilingEntityClassname(Mockito.<String>any());
    doNothing().when(entityForm).setEntityType(Mockito.<String>any());
    doNothing()
        .when(formBuilderService)
        .removeNonApplicableFields(
            Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.PERSIST);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(md).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr, atLeast(1)).getCeilingEntityClassname();
    verify(ppr).setAddOperationInspect(true);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(entityForm).getTabs();
    verify(entityForm).setCeilingEntityClassname("Ceiling Entity Classname");
    verify(entityForm).setEntityType("Ceiling Entity Classname");
    verify(entityForm).setParentId("42");
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(List.class));
    verify(formBuilderService)
        .removeNonApplicableFields(
            isA(ClassMetadata.class), isA(EntityForm.class), eq("Ceiling Entity Classname"));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given adorned.
   *   <li>When {@code null}.
   *   <li>Then calls {@link AdminSection#getModule()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_givenAdorned_whenNull_thenCallsGetModule()
      throws ServiceException {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getModule()).thenThrow(new UnsupportedOperationException());
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                null,
                ppr,
                null,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).setAddOperationInspect(true);
    verify(adminSection).getModule();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_givenEntityFormAddTabFromTabMetadataTabMetadata()
      throws ServiceException {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getModule()).thenThrow(new UnsupportedOperationException());
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);

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
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.PERSIST);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(md).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr, atLeast(1)).getCeilingEntityClassname();
    verify(ppr).setAddOperationInspect(true);
    verify(adminSection).getModule();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(List.class));
    verify(formBuilderService)
        .removeNonApplicableFields(
            isA(ClassMetadata.class), isA(EntityForm.class), eq("Ceiling Entity Classname"));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Tab} (default constructor).
   *   <li>Then calls {@link EntityForm#getTabs()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_givenHashSetAddTab_thenCallsGetTabs()
      throws ServiceException {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getModule()).thenThrow(new UnsupportedOperationException());
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(new Tab());

    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).setParentId(Mockito.<String>any());
    when(entityForm.getTabs()).thenReturn(tabSet);
    doNothing().when(entityForm).setCeilingEntityClassname(Mockito.<String>any());
    doNothing().when(entityForm).setEntityType(Mockito.<String>any());
    doNothing()
        .when(formBuilderService)
        .removeNonApplicableFields(
            Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.PERSIST);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(md).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr, atLeast(1)).getCeilingEntityClassname();
    verify(ppr).setAddOperationInspect(true);
    verify(adminSection).getModule();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(entityForm).getTabs();
    verify(entityForm).setCeilingEntityClassname("Ceiling Entity Classname");
    verify(entityForm).setEntityType("Ceiling Entity Classname");
    verify(entityForm).setParentId("42");
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(List.class));
    verify(formBuilderService)
        .removeNonApplicableFields(
            isA(ClassMetadata.class), isA(EntityForm.class), eq("Ceiling Entity Classname"));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@code LOOKUP}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_givenLookup() throws ServiceException {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getModule()).thenThrow(new UnsupportedOperationException());
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.LOOKUP);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(md, atLeast(1)).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).setAddOperationInspect(true);
    verify(adminSection).getModule();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("xxx"), isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@code PERSIST_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_givenPersistEmpty() throws ServiceException {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getModule()).thenThrow(new UnsupportedOperationException());
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.PERSIST_EMPTY);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(md, atLeast(1)).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).setAddOperationInspect(true);
    verify(adminSection).getModule();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("xxx"), isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityForm#clearFieldsMap()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_thenCallsClearFieldsMap() throws ServiceException {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    EntityForm entityForm = mock(EntityForm.class);
    doThrow(new UnsupportedOperationException()).when(entityForm).clearFieldsMap();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).setAddOperationInspect(true);
    verify(entityForm).clearFieldsMap();
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link Tab#getIsVisible()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_thenCallsGetIsVisible() throws ServiceException {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getModule()).thenThrow(new UnsupportedOperationException());
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);

    Tab tab = mock(Tab.class);
    when(tab.getIsVisible()).thenReturn(true);

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(tab);

    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).setParentId(Mockito.<String>any());
    when(entityForm.getTabs()).thenReturn(tabSet);
    doNothing().when(entityForm).setCeilingEntityClassname(Mockito.<String>any());
    doNothing().when(entityForm).setEntityType(Mockito.<String>any());
    doNothing()
        .when(formBuilderService)
        .removeNonApplicableFields(
            Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(), Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.PERSIST);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(md).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr, atLeast(1)).getCeilingEntityClassname();
    verify(ppr).setAddOperationInspect(true);
    verify(adminSection).getModule();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(entityForm).getTabs();
    verify(entityForm).setCeilingEntityClassname("Ceiling Entity Classname");
    verify(entityForm).setEntityType("Ceiling Entity Classname");
    verify(entityForm).setParentId("42");
    verify(tab).getIsVisible();
    verify(formBuilderService).createEntityForm(isA(ClassMetadata.class), isA(List.class));
    verify(formBuilderService)
        .removeNonApplicableFields(
            isA(ClassMetadata.class), isA(EntityForm.class), eq("Ceiling Entity Classname"));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link FormBuilderService#populateEntityForm(ClassMetadata, EntityForm,
   *       List)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_thenCallsPopulateEntityForm()
      throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(formBuilderService)
        .populateEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.PERSIST);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(md).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).setAddOperationInspect(true);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .populateEntityForm(isA(ClassMetadata.class), isA(EntityForm.class), isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link FormBuilderService#populateEntityFormFieldValues(ClassMetadata, Entity,
   *       EntityForm)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_thenCallsPopulateEntityFormFieldValues()
      throws ServiceException {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getModule()).thenThrow(new UnsupportedOperationException());
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    doNothing()
        .when(formBuilderService)
        .populateEntityFormFieldValues(
            Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminSection).getModule();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isNull(),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("xxx"), isA(List.class));
    verify(formBuilderService)
        .populateEntityFormFieldValues(
            isA(ClassMetadata.class), isA(Entity.class), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is eight.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_thenConcurrentModelSizeIsEight()
      throws ServiceException {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    doNothing()
        .when(formBuilderService)
        .populateEntityFormFieldValues(
            Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    Property property = new Property();
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("owningClass=");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act
    String actualBuildAddCollectionItemModelResult =
        adminBasicEntityController.buildAddCollectionItemModel(
            request,
            response,
            model,
            "42",
            "Collection Field",
            "xxx",
            collectionProperty,
            md,
            ppr,
            entityForm,
            new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isNull(),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("xxx"), isA(List.class));
    verify(formBuilderService)
        .populateEntityFormFieldValues(
            isA(ClassMetadata.class), isA(Entity.class), isA(EntityForm.class));
    assertEquals(8, model.size());
    Object getResult = model.get("collectionProperty");
    assertTrue(getResult instanceof Property);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    Object getResult3 = model.get("listGrid");
    assertTrue(getResult3 instanceof ListGrid);
    Object getResult4 = model.get("entityForm");
    assertTrue(getResult4 instanceof EntityForm);
    assertEquals("42", entityForm.getParentId());
    assertEquals("Collection Field", ppr.getSectionEntityField());
    assertEquals("addCollectionItem", model.get("modalHeaderType"));
    assertEquals("http://localhost", model.get("currentUrl"));
    assertEquals("modal/adornedSelectEntity", model.get("viewType"));
    assertEquals("modules/modalContainer", actualBuildAddCollectionItemModelResult);
    assertEquals("xxx", model.get("sectionKey"));
    assertEquals(1, ppr.getCustomCriteria().length);
    assertEquals(Type.STANDARD, ppr.getType());
    assertTrue(ppr.isAddOperationInspect());
    assertEquals(property, getResult);
    assertSame(collectionProperty, getResult);
    assertSame(adminSectionImpl, getResult2);
    assertSame(listGrid, getResult3);
    assertSame(entityForm, getResult4);
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_thenThrowSecurityServiceException()
      throws ServiceException {
    // Arrange
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenThrow(new SecurityServiceException());
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getAdornedList()).thenReturn(new AdornedTargetList());
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());
    doNothing().when(ppr).setOperationTypesOverride(Mockito.<OperationTypes>any());
    doNothing().when(ppr).setSectionEntityField(Mockito.<String>any());
    doNothing().when(ppr).setType(Mockito.<Type>any());

    // Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).getAdornedList();
    verify(ppr).setAddOperationInspect(true);
    verify(ppr).setOperationTypesOverride(isNull());
    verify(ppr).setSectionEntityField("Collection Field");
    verify(ppr).setType(Type.STANDARD);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isA(AdornedTargetList.class),
            eq("42"),
            eq(false),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("xxx"), isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>When adorned AdornedList is {@link AdornedTargetList#AdornedTargetList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_whenAdornedAdornedListIsAdornedTargetList()
      throws ServiceException {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getModule()).thenThrow(new UnsupportedOperationException());
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSection);
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("owningClass=");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("owningClass=");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    ppr.setAdornedList(new AdornedTargetList());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "xxx",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("xxx");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminSection).getModule();
    verify(adminNavigationService).findAdminSectionByURI("/xxx");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isA(AdornedTargetList.class),
            eq("42"),
            eq(false),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("xxx"), isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#showViewUpdateCollection(HttpServletRequest, Model, Map,
   * String, String, String, String, String)} with {@code request}, {@code model}, {@code pathVars},
   * {@code id}, {@code collectionField}, {@code collectionItemId}, {@code alternateId}, {@code
   * modalHeaderType}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#showViewUpdateCollection(HttpServletRequest, Model, Map, String,
   * String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.showViewUpdateCollection(HttpServletRequest, Model, Map, String, String, String, String, String)"
  })
  public void
      testShowViewUpdateCollectionWithRequestModelPathVarsIdCollectionFieldCollectionItemIdAlternateIdModalHeaderType()
          throws ServiceException {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.showViewUpdateCollection(
                request,
                model,
                new HashMap<>(),
                "42",
                "Collection Field",
                "42",
                "42",
                "Modal Header Type"));
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
  }

  /**
   * Test {@link AdminBasicEntityController#showViewUpdateCollection(HttpServletRequest, Model, Map,
   * String, String, String, String, String, EntityForm, Entity)} with {@code request}, {@code
   * model}, {@code pathVars}, {@code id}, {@code collectionField}, {@code collectionItemId}, {@code
   * alternateId}, {@code modalHeaderType}, {@code entityForm}, {@code entity}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#showViewUpdateCollection(HttpServletRequest, Model, Map, String,
   * String, String, String, String, EntityForm, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.showViewUpdateCollection(HttpServletRequest, Model, Map, String, String, String, String, String, EntityForm, Entity)"
  })
  public void
      testShowViewUpdateCollectionWithRequestModelPathVarsIdCollectionFieldCollectionItemIdAlternateIdModalHeaderTypeEntityFormEntity()
          throws ServiceException {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.showViewUpdateCollection(
                request,
                model,
                pathVars,
                "42",
                "Collection Field",
                "42",
                "42",
                "Modal Header Type",
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
  }

  /**
   * Test {@link AdminBasicEntityController#showViewUpdateCollection(HttpServletRequest, Model, Map,
   * String, String, String, String)} with {@code request}, {@code model}, {@code pathVars}, {@code
   * id}, {@code collectionField}, {@code collectionItemId}, {@code modalHeaderType}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#showViewUpdateCollection(HttpServletRequest, Model, Map, String,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.showViewUpdateCollection(HttpServletRequest, Model, Map, String, String, String, String)"
  })
  public void
      testShowViewUpdateCollectionWithRequestModelPathVarsIdCollectionFieldCollectionItemIdModalHeaderType()
          throws ServiceException {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.showViewUpdateCollection(
                request,
                model,
                new HashMap<>(),
                "42",
                "Collection Field",
                "42",
                "Modal Header Type"));
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
  }

  /**
   * Test {@link AdminBasicEntityController#showViewUpdateCollection(HttpServletRequest, Model, Map,
   * String, String, String, String, EntityForm, Entity)} with {@code request}, {@code model},
   * {@code pathVars}, {@code id}, {@code collectionField}, {@code collectionItemId}, {@code
   * modalHeaderType}, {@code entityForm}, {@code entity}.
   *
   * <p>Method under test: {@link
   * AdminBasicEntityController#showViewUpdateCollection(HttpServletRequest, Model, Map, String,
   * String, String, String, EntityForm, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminBasicEntityController.showViewUpdateCollection(HttpServletRequest, Model, Map, String, String, String, String, EntityForm, Entity)"
  })
  public void
      testShowViewUpdateCollectionWithRequestModelPathVarsIdCollectionFieldCollectionItemIdModalHeaderTypeEntityFormEntity()
          throws ServiceException {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.showViewUpdateCollection(
                request,
                model,
                pathVars,
                "42",
                "Collection Field",
                "42",
                "Modal Header Type",
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection(null);
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata,
   * Entity, Map, List)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm,
   * ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"
  })
  public void testReinitializeEntityForm() throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(formBuilderService)
        .populateEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any());
    EntityForm entityForm = new EntityForm();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[] {new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminBasicEntityController.reinitializeEntityForm(
                entityForm, collectionMetadata, entity, subRecordsMap, new ArrayList<>()));
    verify(formBuilderService)
        .populateEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Map.class),
            isA(EntityForm.class),
            isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata,
   * Entity, Map, List)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm,
   * ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"
  })
  public void testReinitializeEntityForm2() throws ServiceException {
    // Arrange
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[] {new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act
    EntityForm actualReinitializeEntityFormResult =
        adminBasicEntityController.reinitializeEntityForm(
            null, collectionMetadata, entity, subRecordsMap, new ArrayList<>());

    // Assert
    verify(formBuilderService)
        .createEntityForm(
            isA(ClassMetadata.class), isA(Entity.class), isA(Map.class), isA(List.class));
    assertSame(entityForm, actualReinitializeEntityFormResult);
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata,
   * Entity, Map, List)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm,
   * ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"
  })
  public void testReinitializeEntityForm3() throws ServiceException {
    // Arrange
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[] {new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminBasicEntityController.reinitializeEntityForm(
                null, collectionMetadata, entity, subRecordsMap, new ArrayList<>()));
    verify(formBuilderService)
        .createEntityForm(
            isA(ClassMetadata.class), isA(Entity.class), isA(Map.class), isA(List.class));
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata,
   * Entity, Map, List)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm,
   * ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"
  })
  public void testReinitializeEntityForm4() throws ServiceException {
    // Arrange
    doNothing()
        .when(formBuilderService)
        .populateEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any());

    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).removeAllActions();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[] {new Property()});
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
    EntityForm actualReinitializeEntityFormResult =
        adminBasicEntityController.reinitializeEntityForm(
            entityForm, collectionMetadata, entity, subRecordsMap, sectionCrumbs);

    // Assert
    verify(entityForm).clearFieldsMap();
    verify(entityForm).removeAllActions();
    verify(formBuilderService)
        .populateEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Map.class),
            isA(EntityForm.class),
            isA(List.class));
    assertSame(entityForm, actualReinitializeEntityFormResult);
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata,
   * Entity, Map, List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm,
   * ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"
  })
  public void testReinitializeEntityForm_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(formBuilderService)
        .populateEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any());

    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).removeAllActions();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[] {new Property()});
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
    EntityForm actualReinitializeEntityFormResult =
        adminBasicEntityController.reinitializeEntityForm(
            entityForm, collectionMetadata, entity, subRecordsMap, sectionCrumbs);

    // Assert
    verify(entityForm).clearFieldsMap();
    verify(entityForm).removeAllActions();
    verify(formBuilderService)
        .populateEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Map.class),
            isA(EntityForm.class),
            isA(List.class));
    assertSame(entityForm, actualReinitializeEntityFormResult);
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata,
   * Entity, Map, List)}.
   *
   * <ul>
   *   <li>Then return {@link EntityForm}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm,
   * ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"
  })
  public void testReinitializeEntityForm_thenReturnEntityForm() throws ServiceException {
    // Arrange
    doNothing()
        .when(formBuilderService)
        .populateEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any());

    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).removeAllActions();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[] {new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act
    EntityForm actualReinitializeEntityFormResult =
        adminBasicEntityController.reinitializeEntityForm(
            entityForm, collectionMetadata, entity, subRecordsMap, new ArrayList<>());

    // Assert
    verify(entityForm).clearFieldsMap();
    verify(entityForm).removeAllActions();
    verify(formBuilderService)
        .populateEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Map.class),
            isA(EntityForm.class),
            isA(List.class));
    assertSame(entityForm, actualReinitializeEntityFormResult);
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata,
   * Entity, Map, List)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm,
   * ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"
  })
  public void testReinitializeEntityForm_thenThrowUnsupportedOperationException()
      throws ServiceException {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    EntityForm entityForm = mock(EntityForm.class);
    doThrow(new UnsupportedOperationException()).when(entityForm).clearFieldsMap();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[] {new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            adminBasicEntityController.reinitializeEntityForm(
                entityForm, collectionMetadata, entity, subRecordsMap, new ArrayList<>()));
    verify(entityForm).clearFieldsMap();
  }

  /**
   * Test {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm, ClassMetadata,
   * Entity, Map, List)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then return {@link EntityForm} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#reinitializeEntityForm(EntityForm,
   * ClassMetadata, Entity, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm AdminBasicEntityController.reinitializeEntityForm(EntityForm, ClassMetadata, Entity, Map, List)"
  })
  public void testReinitializeEntityForm_whenEntityForm_thenReturnEntityForm()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(formBuilderService)
        .populateEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any());
    EntityForm entityForm = new EntityForm();

    ClassMetadata collectionMetadata = new ClassMetadata();
    collectionMetadata.setCeilingType("Type");
    collectionMetadata.setCurrencyCode("GBP");
    collectionMetadata.setPolymorphicEntities(new ClassTree());
    collectionMetadata.setProperties(new Property[] {new Property()});
    collectionMetadata.setSecurityCeilingType("Security Ceiling Type");
    collectionMetadata.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    HashMap<String, DynamicResultSet> subRecordsMap = new HashMap<>();

    // Act
    EntityForm actualReinitializeEntityFormResult =
        adminBasicEntityController.reinitializeEntityForm(
            entityForm, collectionMetadata, entity, subRecordsMap, new ArrayList<>());

    // Assert
    verify(formBuilderService)
        .populateEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            isA(Map.class),
            isA(EntityForm.class),
            isA(List.class));
    assertSame(entityForm, actualReinitializeEntityFormResult);
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminBasicEntityController.addAuditableDisplayFields(EntityForm)"})
  public void testAddAuditableDisplayFields() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("auditable.createdBy", new EntityForm());

    // Act and Assert
    adminBasicEntityController.addAuditableDisplayFields(entityForm);
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminBasicEntityController.addAuditableDisplayFields(EntityForm)"})
  public void testAddAuditableDisplayFields2() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getName()).thenThrow(new UnsupportedOperationException());
    when(codeField.getValue()).thenReturn("42");
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue("Field");

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("auditable.createdBy", new EntityForm());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> adminBasicEntityController.addAuditableDisplayFields(entityForm));
    verify(entityForm).findField("auditable.createdBy");
    verify(entityForm).putDynamicForm(eq("auditable.createdBy"), isA(EntityForm.class));
    verify(codeField).getName();
    verify(codeField).getValue();
    verify(codeField).setValue("Field");
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link AdminBasicEntityController} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminBasicEntityController.addAuditableDisplayFields(EntityForm)"})
  public void testAddAuditableDisplayFields_givenAdminBasicEntityController() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    Field field = new Field();
    field.setValue(null);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("auditable.createdBy", new EntityForm());

    // Act
    adminBasicEntityController.addAuditableDisplayFields(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm).putDynamicForm(eq("auditable.createdBy"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminBasicEntityController.addAuditableDisplayFields(EntityForm)"})
  public void testAddAuditableDisplayFields_givenTabMetadata() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act and Assert
    adminBasicEntityController.addAuditableDisplayFields(entityForm);
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityForm#findGroup(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue("Field");

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findGroup(Mockito.<String>any())).thenReturn(new FieldGroup());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("auditable.createdBy", new EntityForm());

    // Act
    adminBasicEntityController.addAuditableDisplayFields(entityForm);

    // Assert
    verify(adminUserDao, atLeast(1)).readAdminUserById(42L);
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).findGroup("AdminAuditable_Audit");
    verify(entityForm).putDynamicForm(eq("auditable.createdBy"), isA(EntityForm.class));
    verify(codeField, atLeast(1)).getFriendlyName();
    verify(codeField, atLeast(1)).getName();
    verify(codeField, atLeast(1)).getOrder();
    verify(codeField, atLeast(1)).getOwningEntityClass();
    verify(codeField, atLeast(1)).getValue();
    verify(codeField, atLeast(1)).setIsVisible(false);
    verify(codeField).setValue("Field");
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminUser#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminBasicEntityController.addAuditableDisplayFields(EntityForm)"})
  public void testAddAuditableDisplayFields_thenCallsGetName() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getName()).thenThrow(new UnsupportedOperationException());
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(adminUser);

    CodeField codeField = mock(CodeField.class);
    when(codeField.getOrder()).thenReturn(1);
    when(codeField.getFriendlyName()).thenReturn("Friendly Name");
    when(codeField.getName()).thenReturn("Name");
    when(codeField.getOwningEntityClass()).thenReturn("Owning Entity Class");
    when(codeField.getValue()).thenReturn("42");
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue("Field");

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("auditable.createdBy", new EntityForm());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> adminBasicEntityController.addAuditableDisplayFields(entityForm));
    verify(adminUserDao).readAdminUserById(42L);
    verify(adminUser).getName();
    verify(entityForm).findField("auditable.createdBy");
    verify(entityForm).putDynamicForm(eq("auditable.createdBy"), isA(EntityForm.class));
    verify(codeField).getFriendlyName();
    verify(codeField).getName();
    verify(codeField).getOrder();
    verify(codeField).getOwningEntityClass();
    verify(codeField, atLeast(1)).getValue();
    verify(codeField).setValue("Field");
  }

  /**
   * Test {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#addAuditableDisplayFields(EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminBasicEntityController.addAuditableDisplayFields(EntityForm)"})
  public void testAddAuditableDisplayFields_whenEntityForm_thenDoesNotThrow() {
    // Arrange, Act and Assert
    adminBasicEntityController.addAuditableDisplayFields(new EntityForm());
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code tabName} is {@link TabMetadata} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentTabName(Map, ClassMetadata)"})
  public void testGetCurrentTabName_givenHashMapTabNameIsTabMetadata_thenReturnNull() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    HashMap<String, String> pathVars = new HashMap<>();

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("tabName", new TabMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertNull(adminBasicEntityController.getCurrentTabName(pathVars, cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code General}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentTabName(Map, ClassMetadata)"})
  public void testGetCurrentTabName_givenHashMap_whenHashMap_thenReturnGeneral() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    HashMap<String, String> pathVars = new HashMap<>();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("General", adminBasicEntityController.getCurrentTabName(pathVars, cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@code Path Vars}.
   *   <li>Then return {@code Path Vars}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentTabName(Map, ClassMetadata)"})
  public void testGetCurrentTabName_givenPathVars_thenReturnPathVars() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("tabName", "Path Vars");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("Path Vars", adminBasicEntityController.getCurrentTabName(pathVars, cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>When {@link HashMap#HashMap()} {@code tabName} is space.
   *   <li>Then return {@code General}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentTabName(Map, ClassMetadata)"})
  public void testGetCurrentTabName_givenSpace_whenHashMapTabNameIsSpace_thenReturnGeneral() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("tabName", " ");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("General", adminBasicEntityController.getCurrentTabName(pathVars, cmd));
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCurrentTabName(Map, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentTabName(Map, ClassMetadata)"})
  public void testGetCurrentTabName_thenThrowUnsupportedOperationException() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();
    HashMap<String, String> pathVars = new HashMap<>();

    TabMetadata tabMetadata = mock(TabMetadata.class);
    when(tabMetadata.getTabName()).thenThrow(new UnsupportedOperationException());

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("tabName", tabMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> adminBasicEntityController.getCurrentTabName(pathVars, cmd));
    verify(tabMetadata).getTabName();
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code currentFolderId}.
   *   <li>Then return {@code Request}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentFolderId(HttpServletRequest)"})
  public void testGetCurrentFolderId_givenCurrentFolderId_thenReturnRequest() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("currentFolderId", "Request");

    // Act and Assert
    assertEquals("Request", adminBasicEntityController.getCurrentFolderId(request));
  }

  /**
   * Test {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code unassigned}.
   * </ul>
   *
   * <p>Method under test: {@link AdminBasicEntityController#getCurrentFolderId(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminBasicEntityController.getCurrentFolderId(HttpServletRequest)"})
  public void testGetCurrentFolderId_whenMockHttpServletRequest_thenReturnUnassigned() {
    // Arrange
    AdminBasicEntityController adminBasicEntityController = new AdminBasicEntityController();

    // Act and Assert
    assertEquals(
        "unassigned", adminBasicEntityController.getCurrentFolderId(new MockHttpServletRequest()));
  }
}
