package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.controller.AbstractAdminAbstractControllerExtensionHandler;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.form.entity.FieldGroup;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.broadleafcommerce.openadmin.web.handler.MultipleCatalogExtensionHandler;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
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
  @Mock private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Mock private AdminEntityService adminEntityService;

  @Mock private AdminNavigationService adminNavigationService;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @InjectMocks private AdminStructuredContentController adminStructuredContentController;

  @Mock private AdminUserDao adminUserDao;

  @Mock private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock private EntityFormValidator entityFormValidator;

  @Mock private FormBuilderService formBuilderService;

  @Mock private MultipleCatalogExtensionManager multipleCatalogExtensionManager;

  /**
   * Test {@link AdminStructuredContentController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>Given {@code sectionKey}.
   *   <li>Then return {@code sectionKey}.
   * </ul>
   *
   * <p>Method under test: {@link AdminStructuredContentController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminStructuredContentController.getSectionKey(Map)"})
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    // Arrange
    AdminStructuredContentController adminStructuredContentController =
        new AdminStructuredContentController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminStructuredContentController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminStructuredContentController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code structured-content}.
   * </ul>
   *
   * <p>Method under test: {@link AdminStructuredContentController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminStructuredContentController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnStructuredContent() {
    // Arrange
    AdminStructuredContentController adminStructuredContentController =
        new AdminStructuredContentController();

    // Act and Assert
    assertEquals(
        "structured-content", adminStructuredContentController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <p>Method under test: {@link
   * AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm() throws Exception {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    doNothing()
        .when(entityForm)
        .putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(entityForm).setSectionKey(Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

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

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity entity = new Entity();
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
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

    MultipleCatalogExtensionHandler multipleCatalogExtensionHandler =
        mock(MultipleCatalogExtensionHandler.class);
    doNothing()
        .when(multipleCatalogExtensionHandler)
        .setCurrentCatalog(Mockito.<Entity>any(), Mockito.<Model>any());
    when(multipleCatalogExtensionManager.getProxy()).thenReturn(multipleCatalogExtensionHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewEntityFormResult =
        adminStructuredContentController.viewEntityForm(
            request, response, model, new HashMap<>(), "42");

    // Assert
    verify(multipleCatalogExtensionManager).getProxy();
    verify(adminAbstractControllerExtensionManager, atLeast(1)).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminNavigationService).findAdminSectionByURI("/structured-content");
    verify(adminEntityService, atLeast(1))
        .getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService, atLeast(1))
        .getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            isA(ClassMetadata.class),
            anyBoolean());
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).clearFieldsMap();
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm).getTabs();
    verify(entityForm).putDynamicForm(eq("structuredContentType"), isA(EntityForm.class));
    verify(entityForm)
        .putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityForm).setSectionKey("structured-content");
    verify(multipleCatalogExtensionHandler).setCurrentCatalog(isA(Entity.class), isA(Model.class));
    verify(formBuilderService, atLeast(1))
        .createEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any());
    assertEquals(8, model.size());
    Object getResult = model.get("entity");
    assertTrue(getResult instanceof Entity);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("", model.get("currentUrl"));
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualViewEntityFormResult);
    assertEquals("structured-content", model.get("sectionKey"));
    assertEquals("unassigned", model.get("currentFolderId"));
    assertTrue(model.containsKey("entityForm"));
    assertTrue((Boolean) model.get("useAjaxUpdate"));
    assertSame(entity, getResult);
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link AdminUserDao} {@link AdminUserDao#readAdminUserById(Long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm_givenAdminUserDaoReadAdminUserByIdReturnNull() throws Exception {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    CodeField codeField = mock(CodeField.class);
    when(codeField.getOrder()).thenReturn(1);
    when(codeField.getFriendlyName()).thenReturn("Friendly Name");
    when(codeField.getName()).thenReturn("Name");
    when(codeField.getOwningEntityClass()).thenReturn("Owning Entity Class");
    doNothing().when(codeField).setIsVisible(Mockito.<Boolean>any());
    when(codeField.getValue()).thenReturn("42");
    doNothing().when(codeField).setReadOnly(Mockito.<Boolean>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue("42");

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.addField(Mockito.<Field>any())).thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findGroup(Mockito.<String>any())).thenReturn(fieldGroup);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    doNothing()
        .when(entityForm)
        .putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).setSectionKey(Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

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

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity entity = new Entity();
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
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
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(null);

    MultipleCatalogExtensionHandler multipleCatalogExtensionHandler =
        mock(MultipleCatalogExtensionHandler.class);
    doNothing()
        .when(multipleCatalogExtensionHandler)
        .setCurrentCatalog(Mockito.<Entity>any(), Mockito.<Model>any());
    when(multipleCatalogExtensionManager.getProxy()).thenReturn(multipleCatalogExtensionHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewEntityFormResult =
        adminStructuredContentController.viewEntityForm(
            request, response, model, new HashMap<>(), "42");

    // Assert
    verify(multipleCatalogExtensionManager).getProxy();
    verify(adminAbstractControllerExtensionManager, atLeast(1)).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminUserDao, atLeast(1)).readAdminUserById(42L);
    verify(adminNavigationService).findAdminSectionByURI("/structured-content");
    verify(adminEntityService, atLeast(1))
        .getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService, atLeast(1))
        .getRecord(
            Mockito.<PersistencePackageRequest>any(),
            eq("42"),
            isA(ClassMetadata.class),
            anyBoolean());
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).clearFieldsMap();
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).findGroup("AdminAuditable_Audit");
    verify(entityForm).getTabs();
    verify(entityForm).putDynamicForm(eq("structuredContentType"), isA(EntityForm.class));
    verify(entityForm)
        .putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityForm).setSectionKey("structured-content");
    verify(codeField, atLeast(1)).getFriendlyName();
    verify(codeField, atLeast(1)).getName();
    verify(codeField, atLeast(1)).getOrder();
    verify(codeField, atLeast(1)).getOwningEntityClass();
    verify(codeField, atLeast(1)).getValue();
    verify(codeField, atLeast(1)).setIsVisible(false);
    verify(codeField).setReadOnly(true);
    verify(codeField).setValue("42");
    verify(fieldGroup, atLeast(1)).addField(Mockito.<Field>any());
    verify(multipleCatalogExtensionHandler).setCurrentCatalog(isA(Entity.class), isA(Model.class));
    verify(formBuilderService, atLeast(1))
        .createEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any());
    assertEquals(8, model.size());
    Object getResult = model.get("entity");
    assertTrue(getResult instanceof Entity);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("", model.get("currentUrl"));
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualViewEntityFormResult);
    assertEquals("structured-content", model.get("sectionKey"));
    assertEquals("unassigned", model.get("currentFolderId"));
    assertTrue(model.containsKey("entityForm"));
    assertTrue((Boolean) model.get("useAjaxUpdate"));
    assertSame(entity, getResult);
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#getOrder()} return one.
   *   <li>Then calls {@link CodeField#getFriendlyName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm_givenCodeFieldGetOrderReturnOne_thenCallsGetFriendlyName()
      throws Exception {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    CodeField codeField = mock(CodeField.class);
    when(codeField.getOrder()).thenReturn(1);
    when(codeField.getFriendlyName()).thenReturn("Friendly Name");
    when(codeField.getName()).thenReturn("Name");
    when(codeField.getOwningEntityClass()).thenReturn("Owning Entity Class");
    doNothing().when(codeField).setIsVisible(Mockito.<Boolean>any());
    when(codeField.getValue()).thenReturn("42");
    doNothing().when(codeField).setReadOnly(Mockito.<Boolean>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue("42");

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.addField(Mockito.<Field>any())).thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findGroup(Mockito.<String>any())).thenReturn(fieldGroup);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    doNothing()
        .when(entityForm)
        .putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).setSectionKey(Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

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

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity entity = new Entity();
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
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
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());

    MultipleCatalogExtensionHandler multipleCatalogExtensionHandler =
        mock(MultipleCatalogExtensionHandler.class);
    doNothing()
        .when(multipleCatalogExtensionHandler)
        .setCurrentCatalog(Mockito.<Entity>any(), Mockito.<Model>any());
    when(multipleCatalogExtensionManager.getProxy()).thenReturn(multipleCatalogExtensionHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewEntityFormResult =
        adminStructuredContentController.viewEntityForm(
            request, response, model, new HashMap<>(), "42");

    // Assert
    verify(multipleCatalogExtensionManager).getProxy();
    verify(adminAbstractControllerExtensionManager, atLeast(1)).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminUserDao, atLeast(1)).readAdminUserById(42L);
    verify(adminNavigationService).findAdminSectionByURI("/structured-content");
    verify(adminEntityService, atLeast(1))
        .getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService, atLeast(1))
        .getRecord(
            Mockito.<PersistencePackageRequest>any(),
            eq("42"),
            isA(ClassMetadata.class),
            anyBoolean());
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).clearFieldsMap();
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).findGroup("AdminAuditable_Audit");
    verify(entityForm).getTabs();
    verify(entityForm).putDynamicForm(eq("structuredContentType"), isA(EntityForm.class));
    verify(entityForm)
        .putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityForm).setSectionKey("structured-content");
    verify(codeField, atLeast(1)).getFriendlyName();
    verify(codeField, atLeast(1)).getName();
    verify(codeField, atLeast(1)).getOrder();
    verify(codeField, atLeast(1)).getOwningEntityClass();
    verify(codeField, atLeast(1)).getValue();
    verify(codeField, atLeast(1)).setIsVisible(false);
    verify(codeField).setReadOnly(true);
    verify(codeField).setValue("42");
    verify(fieldGroup, atLeast(1)).addField(Mockito.<Field>any());
    verify(multipleCatalogExtensionHandler).setCurrentCatalog(isA(Entity.class), isA(Model.class));
    verify(formBuilderService, atLeast(1))
        .createEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any());
    assertEquals(8, model.size());
    Object getResult = model.get("entity");
    assertTrue(getResult instanceof Entity);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("", model.get("currentUrl"));
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualViewEntityFormResult);
    assertEquals("structured-content", model.get("sectionKey"));
    assertEquals("unassigned", model.get("currentFolderId"));
    assertTrue(model.containsKey("entityForm"));
    assertTrue((Boolean) model.get("useAjaxUpdate"));
    assertSame(entity, getResult);
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} {@link EntityForm#findField(String)} return {@link Field}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm_givenEntityFormFindFieldReturnField() throws Exception {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    doNothing()
        .when(entityForm)
        .putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(entityForm).setSectionKey(Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

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

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity entity = new Entity();
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
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

    MultipleCatalogExtensionHandler multipleCatalogExtensionHandler =
        mock(MultipleCatalogExtensionHandler.class);
    doNothing()
        .when(multipleCatalogExtensionHandler)
        .setCurrentCatalog(Mockito.<Entity>any(), Mockito.<Model>any());
    when(multipleCatalogExtensionManager.getProxy()).thenReturn(multipleCatalogExtensionHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewEntityFormResult =
        adminStructuredContentController.viewEntityForm(
            request, response, model, new HashMap<>(), "42");

    // Assert
    verify(multipleCatalogExtensionManager).getProxy();
    verify(adminAbstractControllerExtensionManager, atLeast(1)).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminNavigationService).findAdminSectionByURI("/structured-content");
    verify(adminEntityService, atLeast(1))
        .getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService, atLeast(1))
        .getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            isA(ClassMetadata.class),
            anyBoolean());
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).clearFieldsMap();
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm).getTabs();
    verify(entityForm).putDynamicForm(eq("structuredContentType"), isA(EntityForm.class));
    verify(entityForm)
        .putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityForm).setSectionKey("structured-content");
    verify(multipleCatalogExtensionHandler).setCurrentCatalog(isA(Entity.class), isA(Model.class));
    verify(formBuilderService, atLeast(1))
        .createEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any());
    assertEquals(8, model.size());
    Object getResult = model.get("entity");
    assertTrue(getResult instanceof Entity);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("", model.get("currentUrl"));
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualViewEntityFormResult);
    assertEquals("structured-content", model.get("sectionKey"));
    assertEquals("unassigned", model.get("currentFolderId"));
    assertTrue(model.containsKey("entityForm"));
    assertTrue((Boolean) model.get("useAjaxUpdate"));
    assertSame(entity, getResult);
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} {@link EntityForm#findGroup(String)} return {@link FieldGroup}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm_givenEntityFormFindGroupReturnFieldGroup() throws Exception {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    Field field = new Field();
    field.setValue("42");

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findGroup(Mockito.<String>any())).thenReturn(new FieldGroup());
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    doNothing()
        .when(entityForm)
        .putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(entityForm).setSectionKey(Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

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

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity entity = new Entity();
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
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
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());

    MultipleCatalogExtensionHandler multipleCatalogExtensionHandler =
        mock(MultipleCatalogExtensionHandler.class);
    doNothing()
        .when(multipleCatalogExtensionHandler)
        .setCurrentCatalog(Mockito.<Entity>any(), Mockito.<Model>any());
    when(multipleCatalogExtensionManager.getProxy()).thenReturn(multipleCatalogExtensionHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewEntityFormResult =
        adminStructuredContentController.viewEntityForm(
            request, response, model, new HashMap<>(), "42");

    // Assert
    verify(multipleCatalogExtensionManager).getProxy();
    verify(adminAbstractControllerExtensionManager, atLeast(1)).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminUserDao, atLeast(1)).readAdminUserById(42L);
    verify(adminNavigationService).findAdminSectionByURI("/structured-content");
    verify(adminEntityService, atLeast(1))
        .getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService, atLeast(1))
        .getRecord(
            Mockito.<PersistencePackageRequest>any(),
            eq("42"),
            isA(ClassMetadata.class),
            anyBoolean());
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).clearFieldsMap();
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).findGroup("AdminAuditable_Audit");
    verify(entityForm).getTabs();
    verify(entityForm).putDynamicForm(eq("structuredContentType"), isA(EntityForm.class));
    verify(entityForm)
        .putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityForm).setSectionKey("structured-content");
    verify(multipleCatalogExtensionHandler).setCurrentCatalog(isA(Entity.class), isA(Model.class));
    verify(formBuilderService, atLeast(1))
        .createEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any());
    assertEquals(8, model.size());
    Object getResult = model.get("entity");
    assertTrue(getResult instanceof Entity);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("", model.get("currentUrl"));
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualViewEntityFormResult);
    assertEquals("structured-content", model.get("sectionKey"));
    assertEquals("unassigned", model.get("currentFolderId"));
    assertTrue(model.containsKey("entityForm"));
    assertTrue((Boolean) model.get("useAjaxUpdate"));
    assertSame(entity, getResult);
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityForm} {@link EntityForm#findGroup(String)} return {@code null}.
   *   <li>Then calls {@link AdminUserDao#readAdminUserById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm_givenEntityFormFindGroupReturnNull_thenCallsReadAdminUserById()
      throws Exception {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    Field field = new Field();
    field.setValue("42");

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findGroup(Mockito.<String>any())).thenReturn(null);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    doNothing()
        .when(entityForm)
        .putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(entityForm).setSectionKey(Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

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

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity entity = new Entity();
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
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
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());

    MultipleCatalogExtensionHandler multipleCatalogExtensionHandler =
        mock(MultipleCatalogExtensionHandler.class);
    doNothing()
        .when(multipleCatalogExtensionHandler)
        .setCurrentCatalog(Mockito.<Entity>any(), Mockito.<Model>any());
    when(multipleCatalogExtensionManager.getProxy()).thenReturn(multipleCatalogExtensionHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewEntityFormResult =
        adminStructuredContentController.viewEntityForm(
            request, response, model, new HashMap<>(), "42");

    // Assert
    verify(multipleCatalogExtensionManager).getProxy();
    verify(adminAbstractControllerExtensionManager, atLeast(1)).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminUserDao, atLeast(1)).readAdminUserById(42L);
    verify(adminNavigationService).findAdminSectionByURI("/structured-content");
    verify(adminEntityService, atLeast(1))
        .getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService, atLeast(1))
        .getRecord(
            Mockito.<PersistencePackageRequest>any(),
            eq("42"),
            isA(ClassMetadata.class),
            anyBoolean());
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).clearFieldsMap();
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).findGroup("AdminAuditable_Audit");
    verify(entityForm).getTabs();
    verify(entityForm).putDynamicForm(eq("structuredContentType"), isA(EntityForm.class));
    verify(entityForm)
        .putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityForm).setSectionKey("structured-content");
    verify(multipleCatalogExtensionHandler).setCurrentCatalog(isA(Entity.class), isA(Model.class));
    verify(formBuilderService, atLeast(1))
        .createEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any());
    assertEquals(8, model.size());
    Object getResult = model.get("entity");
    assertTrue(getResult instanceof Entity);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("", model.get("currentUrl"));
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualViewEntityFormResult);
    assertEquals("structured-content", model.get("sectionKey"));
    assertEquals("unassigned", model.get("currentFolderId"));
    assertTrue(model.containsKey("entityForm"));
    assertTrue((Boolean) model.get("useAjaxUpdate"));
    assertSame(entity, getResult);
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is {@code 42}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link FieldGroup#addField(Field)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm_givenFieldValueIs42_whenHashMap_thenCallsAddField()
      throws Exception {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    Field field = new Field();
    field.setValue("42");

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.addField(Mockito.<Field>any())).thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findGroup(Mockito.<String>any())).thenReturn(fieldGroup);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    doNothing()
        .when(entityForm)
        .putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(entityForm).setSectionKey(Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

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

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity entity = new Entity();
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
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
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());

    MultipleCatalogExtensionHandler multipleCatalogExtensionHandler =
        mock(MultipleCatalogExtensionHandler.class);
    doNothing()
        .when(multipleCatalogExtensionHandler)
        .setCurrentCatalog(Mockito.<Entity>any(), Mockito.<Model>any());
    when(multipleCatalogExtensionManager.getProxy()).thenReturn(multipleCatalogExtensionHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewEntityFormResult =
        adminStructuredContentController.viewEntityForm(
            request, response, model, new HashMap<>(), "42");

    // Assert
    verify(multipleCatalogExtensionManager).getProxy();
    verify(adminAbstractControllerExtensionManager, atLeast(1)).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminUserDao, atLeast(1)).readAdminUserById(42L);
    verify(adminNavigationService).findAdminSectionByURI("/structured-content");
    verify(adminEntityService, atLeast(1))
        .getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService, atLeast(1))
        .getRecord(
            Mockito.<PersistencePackageRequest>any(),
            eq("42"),
            isA(ClassMetadata.class),
            anyBoolean());
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).clearFieldsMap();
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).findGroup("AdminAuditable_Audit");
    verify(entityForm).getTabs();
    verify(entityForm).putDynamicForm(eq("structuredContentType"), isA(EntityForm.class));
    verify(entityForm)
        .putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityForm).setSectionKey("structured-content");
    verify(fieldGroup, atLeast(1)).addField(Mockito.<Field>any());
    verify(multipleCatalogExtensionHandler).setCurrentCatalog(isA(Entity.class), isA(Model.class));
    verify(formBuilderService, atLeast(1))
        .createEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any());
    assertEquals(8, model.size());
    Object getResult = model.get("entity");
    assertTrue(getResult instanceof Entity);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("", model.get("currentUrl"));
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualViewEntityFormResult);
    assertEquals("structured-content", model.get("sectionKey"));
    assertEquals("unassigned", model.get("currentFolderId"));
    assertTrue(model.containsKey("entityForm"));
    assertTrue((Boolean) model.get("useAjaxUpdate"));
    assertSame(entity, getResult);
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code structured-content} is {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm_givenHashMapStructuredContentIsTabMetadata() throws Exception {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    CodeField codeField = mock(CodeField.class);
    when(codeField.getOrder()).thenReturn(1);
    when(codeField.getFriendlyName()).thenReturn("Friendly Name");
    when(codeField.getName()).thenReturn("Name");
    when(codeField.getOwningEntityClass()).thenReturn("Owning Entity Class");
    doNothing().when(codeField).setIsVisible(Mockito.<Boolean>any());
    when(codeField.getValue()).thenReturn("42");
    doNothing().when(codeField).setReadOnly(Mockito.<Boolean>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue("42");

    FieldGroup fieldGroup = mock(FieldGroup.class);
    when(fieldGroup.addField(Mockito.<Field>any())).thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findGroup(Mockito.<String>any())).thenReturn(fieldGroup);
    when(entityForm.getTabs()).thenReturn(new HashSet<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    doNothing()
        .when(entityForm)
        .putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).setSectionKey(Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.put("structured-content", new TabMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("sectionKey");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("sectionKey");
    classMetaData.setTabAndGroupMetadata(tabAndGroupMetadata);
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity entity = new Entity();
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
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
    when(adminUserDao.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());

    MultipleCatalogExtensionHandler multipleCatalogExtensionHandler =
        mock(MultipleCatalogExtensionHandler.class);
    doNothing()
        .when(multipleCatalogExtensionHandler)
        .setCurrentCatalog(Mockito.<Entity>any(), Mockito.<Model>any());
    when(multipleCatalogExtensionManager.getProxy()).thenReturn(multipleCatalogExtensionHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewEntityFormResult =
        adminStructuredContentController.viewEntityForm(
            request, response, model, new HashMap<>(), "42");

    // Assert
    verify(multipleCatalogExtensionManager).getProxy();
    verify(adminAbstractControllerExtensionManager, atLeast(1)).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminUserDao, atLeast(1)).readAdminUserById(42L);
    verify(adminNavigationService).findAdminSectionByURI("/structured-content");
    verify(adminEntityService, atLeast(1))
        .getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService, atLeast(1))
        .getRecord(
            Mockito.<PersistencePackageRequest>any(),
            eq("42"),
            isA(ClassMetadata.class),
            anyBoolean());
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), isNull());
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).clearFieldsMap();
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).findGroup("AdminAuditable_Audit");
    verify(entityForm).getTabs();
    verify(entityForm).putDynamicForm(eq("structuredContentType"), isA(EntityForm.class));
    verify(entityForm)
        .putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityForm).setSectionKey("structured-content");
    verify(codeField, atLeast(1)).getFriendlyName();
    verify(codeField, atLeast(1)).getName();
    verify(codeField, atLeast(1)).getOrder();
    verify(codeField, atLeast(1)).getOwningEntityClass();
    verify(codeField, atLeast(1)).getValue();
    verify(codeField, atLeast(1)).setIsVisible(false);
    verify(codeField).setReadOnly(true);
    verify(codeField).setValue("42");
    verify(fieldGroup, atLeast(1)).addField(Mockito.<Field>any());
    verify(multipleCatalogExtensionHandler).setCurrentCatalog(isA(Entity.class), isA(Model.class));
    verify(formBuilderService, atLeast(1))
        .createEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any());
    assertEquals(8, model.size());
    Object getResult = model.get("entity");
    assertTrue(getResult instanceof Entity);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("", model.get("currentUrl"));
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualViewEntityFormResult);
    assertEquals("structured-content", model.get("sectionKey"));
    assertEquals("unassigned", model.get("currentFolderId"));
    assertTrue(model.containsKey("entityForm"));
    assertTrue((Boolean) model.get("useAjaxUpdate"));
    assertSame(entity, getResult);
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest,
   * HttpServletResponse, Model, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Tab} (default constructor).
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is eight.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)"
  })
  public void testViewEntityForm_givenHashSetAddTab_whenHashMap_thenConcurrentModelSizeIsEight()
      throws Exception {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AbstractAdminAbstractControllerExtensionHandler());

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(new Tab());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getTabs()).thenReturn(tabSet);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    doNothing()
        .when(entityForm)
        .putDynamicFormInfo(Mockito.<String>any(), Mockito.<DynamicEntityFormInfo>any());
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(entityForm).setSectionKey(Mockito.<String>any());
    when(formBuilderService.createEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(entityForm);

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

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    Entity entity = new Entity();
    Entity[] records = new Entity[] {entity};
    DynamicResultSet dynamicResultSet2 = new DynamicResultSet(records, 1);
    persistenceResponse2.setDynamicResultSet(dynamicResultSet2);
    when(adminEntityService.getRecordsForSelectedTab(
            Mockito.<ClassMetadata>any(),
            Mockito.<Entity>any(),
            Mockito.<List<SectionCrumb>>any(),
            Mockito.<String>any()))
        .thenReturn(new HashMap<>());
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

    MultipleCatalogExtensionHandler multipleCatalogExtensionHandler =
        mock(MultipleCatalogExtensionHandler.class);
    doNothing()
        .when(multipleCatalogExtensionHandler)
        .setCurrentCatalog(Mockito.<Entity>any(), Mockito.<Model>any());
    when(multipleCatalogExtensionManager.getProxy()).thenReturn(multipleCatalogExtensionHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewEntityFormResult =
        adminStructuredContentController.viewEntityForm(
            request, response, model, new HashMap<>(), "42");

    // Assert
    verify(multipleCatalogExtensionManager).getProxy();
    verify(adminAbstractControllerExtensionManager, atLeast(1)).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminNavigationService).findAdminSectionByURI("/structured-content");
    verify(adminEntityService, atLeast(1))
        .getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService, atLeast(1))
        .getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            isA(ClassMetadata.class),
            anyBoolean());
    verify(adminEntityService)
        .getRecordsForSelectedTab(
            isA(ClassMetadata.class), isA(Entity.class), isA(List.class), eq("General"));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).clearFieldsMap();
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm).getTabs();
    verify(entityForm).putDynamicForm(eq("structuredContentType"), isA(EntityForm.class));
    verify(entityForm)
        .putDynamicFormInfo(eq("structuredContentType"), isA(DynamicEntityFormInfo.class));
    verify(entityForm).setSectionKey("structured-content");
    verify(multipleCatalogExtensionHandler).setCurrentCatalog(isA(Entity.class), isA(Model.class));
    verify(formBuilderService, atLeast(1))
        .createEntityForm(
            isA(ClassMetadata.class),
            isA(Entity.class),
            Mockito.<Map<String, DynamicResultSet>>any(),
            Mockito.<List<SectionCrumb>>any());
    assertEquals(8, model.size());
    Object getResult = model.get("entity");
    assertTrue(getResult instanceof Entity);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("", model.get("currentUrl"));
    assertEquals("entityEdit", model.get("viewType"));
    assertEquals("modules/defaultContainer", actualViewEntityFormResult);
    assertEquals("structured-content", model.get("sectionKey"));
    assertEquals("unassigned", model.get("currentFolderId"));
    assertTrue(model.containsKey("entityForm"));
    assertTrue((Boolean) model.get("useAjaxUpdate"));
    assertSame(entity, getResult);
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminStructuredContentController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   *
   * <p>Method under test: {@link AdminStructuredContentController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"
  })
  public void testSaveEntity() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(null);
    when(entityFormValidator.validate(
            Mockito.<EntityForm>any(), Mockito.<Entity>any(), Mockito.<Errors>any()))
        .thenReturn(true);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("constructForm");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("constructForm");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = new EntityForm();
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualSaveEntityResult =
        adminStructuredContentController.saveEntity(
            request,
            response,
            model,
            pathVars,
            "42",
            entityForm,
            result,
            new RedirectAttributesModelMap());

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).updateEntity(isA(EntityForm.class), isNull(), isA(List.class));
    verify(adminSectionCustomCriteriaService, atLeast(1))
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityFormValidator)
        .validate(isA(EntityForm.class), (Entity) isNull(), isA(Errors.class));
    Map<String, DynamicEntityFormInfo> dynamicFormInfos = entityForm.getDynamicFormInfos();
    assertEquals(1, dynamicFormInfos.size());
    DynamicEntityFormInfo getResult = dynamicFormInfos.get("structuredContentType");
    assertEquals("constructForm", getResult.getCriteriaName());
    assertEquals(
        "org.broadleafcommerce.cms.structure.domain.StructuredContent",
        getResult.getSecurityCeilingClassName());
    assertEquals(
        "org.broadleafcommerce.cms.structure.domain.StructuredContentType",
        getResult.getCeilingClassName());
    assertEquals("redirect:/structured-content/42", actualSaveEntityResult);
    assertEquals("structuredContentType", getResult.getPropertyName());
    assertNull(getResult.getPropertyValue());
    assertNull(getResult.getCustomCriteriaOverride());
  }

  /**
   * Test {@link AdminStructuredContentController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@code constructForm}.
   * </ul>
   *
   * <p>Method under test: {@link AdminStructuredContentController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"
  })
  public void testSaveEntity_givenConstructForm() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(entityFormValidator.validate(
            Mockito.<EntityForm>any(), Mockito.<Entity>any(), Mockito.<Errors>any()))
        .thenReturn(true);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("constructForm");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("constructForm");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    EntityForm entityForm = new EntityForm();
    entityForm.putDynamicForm("constructForm", new EntityForm());
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualSaveEntityResult =
        adminStructuredContentController.saveEntity(
            request,
            response,
            model,
            pathVars,
            "42",
            entityForm,
            result,
            new RedirectAttributesModelMap());

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .updateEntity(isA(EntityForm.class), isA(String[].class), isA(List.class));
    verify(adminSectionCustomCriteriaService, atLeast(1))
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityFormValidator)
        .validate(isA(EntityForm.class), (Entity) isNull(), isA(Errors.class));
    Map<String, DynamicEntityFormInfo> dynamicFormInfos = entityForm.getDynamicFormInfos();
    assertEquals(1, dynamicFormInfos.size());
    DynamicEntityFormInfo getResult = dynamicFormInfos.get("structuredContentType");
    assertEquals("constructForm", getResult.getCriteriaName());
    assertEquals(
        "org.broadleafcommerce.cms.structure.domain.StructuredContent",
        getResult.getSecurityCeilingClassName());
    assertEquals(
        "org.broadleafcommerce.cms.structure.domain.StructuredContentType",
        getResult.getCeilingClassName());
    assertEquals("redirect:/structured-content/42", actualSaveEntityResult);
    assertEquals("structuredContentType", getResult.getPropertyName());
    assertNull(getResult.getPropertyValue());
    assertNull(getResult.getCustomCriteriaOverride());
  }

  /**
   * Test {@link AdminStructuredContentController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminStructuredContentController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"
  })
  public void testSaveEntity_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata()
      throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(entityFormValidator.validate(
            Mockito.<EntityForm>any(), Mockito.<Entity>any(), Mockito.<Errors>any()))
        .thenReturn(true);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("constructForm");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("constructForm");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualSaveEntityResult =
        adminStructuredContentController.saveEntity(
            request,
            response,
            model,
            pathVars,
            "42",
            entityForm,
            result,
            new RedirectAttributesModelMap());

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .updateEntity(isA(EntityForm.class), isA(String[].class), isA(List.class));
    verify(adminSectionCustomCriteriaService, atLeast(1))
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityFormValidator)
        .validate(isA(EntityForm.class), (Entity) isNull(), isA(Errors.class));
    Map<String, DynamicEntityFormInfo> dynamicFormInfos = entityForm.getDynamicFormInfos();
    assertEquals(1, dynamicFormInfos.size());
    DynamicEntityFormInfo getResult = dynamicFormInfos.get("structuredContentType");
    assertEquals("constructForm", getResult.getCriteriaName());
    assertEquals(
        "org.broadleafcommerce.cms.structure.domain.StructuredContent",
        getResult.getSecurityCeilingClassName());
    assertEquals(
        "org.broadleafcommerce.cms.structure.domain.StructuredContentType",
        getResult.getCeilingClassName());
    assertEquals("redirect:/structured-content/42", actualSaveEntityResult);
    assertEquals("structuredContentType", getResult.getPropertyName());
    assertNull(getResult.getPropertyValue());
    assertNull(getResult.getCustomCriteriaOverride());
  }

  /**
   * Test {@link AdminStructuredContentController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then {@link EntityForm} (default constructor) DynamicFormInfos size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminStructuredContentController#saveEntity(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminStructuredContentController.saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)"
  })
  public void testSaveEntity_whenEntityForm_thenEntityFormDynamicFormInfosSizeIsOne()
      throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(entityFormValidator.validate(
            Mockito.<EntityForm>any(), Mockito.<Entity>any(), Mockito.<Errors>any()))
        .thenReturn(true);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("constructForm");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("constructForm");
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = new EntityForm();
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualSaveEntityResult =
        adminStructuredContentController.saveEntity(
            request,
            response,
            model,
            pathVars,
            "42",
            entityForm,
            result,
            new RedirectAttributesModelMap());

    // Assert
    verify(classNameRequestParamValidationService).getClassNameForSection("structured-content");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .updateEntity(isA(EntityForm.class), isA(String[].class), isA(List.class));
    verify(adminSectionCustomCriteriaService, atLeast(1))
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityFormValidator)
        .validate(isA(EntityForm.class), (Entity) isNull(), isA(Errors.class));
    Map<String, DynamicEntityFormInfo> dynamicFormInfos = entityForm.getDynamicFormInfos();
    assertEquals(1, dynamicFormInfos.size());
    DynamicEntityFormInfo getResult = dynamicFormInfos.get("structuredContentType");
    assertEquals("constructForm", getResult.getCriteriaName());
    assertEquals(
        "org.broadleafcommerce.cms.structure.domain.StructuredContent",
        getResult.getSecurityCeilingClassName());
    assertEquals(
        "org.broadleafcommerce.cms.structure.domain.StructuredContentType",
        getResult.getCeilingClassName());
    assertEquals("redirect:/structured-content/42", actualSaveEntityResult);
    assertEquals("structuredContentType", getResult.getPropertyName());
    assertNull(getResult.getPropertyValue());
    assertNull(getResult.getCustomCriteriaOverride());
  }
}
