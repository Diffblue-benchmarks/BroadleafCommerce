package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.cms.admin.web.service.AssetFormBuilderService;
import org.broadleafcommerce.cms.file.StaticAssetMultiTenantExtensionManager;
import org.broadleafcommerce.cms.file.service.StaticAssetService;
import org.broadleafcommerce.cms.file.service.StaticAssetStorageService;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.persistence.EntityDuplicator;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager;
import org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ContextConfiguration(classes = {AdminAssetController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminAssetControllerDiffblueTest {
  @MockBean(name = "blAdminAbstractControllerExtensionManager")
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Autowired
  private AdminAssetController adminAssetController;

  @MockBean
  private AdminEntityService adminEntityService;

  @MockBean
  private AdminNavigationService adminNavigationService;

  @MockBean
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @MockBean
  private AdminUserDao adminUserDao;

  @MockBean(name = "blAdornedTargetAutoPopulateExtensionManager")
  private AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;

  @MockBean
  private AssetFormBuilderService assetFormBuilderService;

  @MockBean
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @MockBean
  private DynamicEntityDao dynamicEntityDao;

  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  @MockBean
  private EntityDuplicator entityDuplicator;

  @MockBean(name = "blEntityFormValidator")
  private EntityFormValidator entityFormValidator;

  @MockBean
  private ExploitProtectionService exploitProtectionService;

  @MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager")
  private FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;

  @MockBean
  private FormBuilderService formBuilderService;

  @MockBean
  private GenericEntityService genericEntityService;

  @MockBean(name = "blMultipleCatalogExtensionManager")
  private MultipleCatalogExtensionManager multipleCatalogExtensionManager;

  @MockBean
  private RowLevelSecurityService rowLevelSecurityService;

  @MockBean
  private SandBoxHelper sandBoxHelper;

  @MockBean
  private SecurityVerifier securityVerifier;

  @MockBean(name = "blStaticAssetMultiTenantExtensionManager")
  private StaticAssetMultiTenantExtensionManager staticAssetMultiTenantExtensionManager;

  @MockBean
  private StaticAssetService staticAssetService;

  @MockBean
  private StaticAssetStorageService staticAssetStorageService;

  /**
   * Test {@link AdminAssetController#getSectionKey(Map)}.
   * <p>
   * Method under test: {@link AdminAssetController#getSectionKey(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSectionKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.admin.web.controller.AdminAssetController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3093 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminAssetController adminAssetController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.admin.web.service.AssetFormBuilderService assetFormBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao dynamicEntityDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.persistence.EntityDuplicator entityDuplicator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.service.GenericEntityService genericEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blMultipleCatalogExtensionManager") org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager multipleCatalogExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blStaticAssetMultiTenantExtensionManager") org.broadleafcommerce.cms.file.StaticAssetMultiTenantExtensionManager staticAssetMultiTenantExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetService staticAssetService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetStorageService staticAssetStorageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminAssetController.getSectionKey(new HashMap<>());
  }

  /**
   * Test {@link AdminAssetController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAssetController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminAssetController adminAssetController = new AdminAssetController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminAssetController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminAssetController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAssetController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminAssetController adminAssetController = new AdminAssetController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminAssetController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminAssetController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminAssetController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAssetController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminAssetController adminAssetController = new AdminAssetController();

    // Act and Assert
    assertEquals(AdminAssetController.SECTION_KEY, adminAssetController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test
   * {@link AdminAssetController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <p>
   * Method under test:
   * {@link AdminAssetController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testViewEntityList() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.admin.web.controller.AdminAssetController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3091 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminAssetController adminAssetController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.admin.web.service.AssetFormBuilderService assetFormBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao dynamicEntityDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.persistence.EntityDuplicator entityDuplicator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.service.GenericEntityService genericEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blMultipleCatalogExtensionManager") org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager multipleCatalogExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blStaticAssetMultiTenantExtensionManager") org.broadleafcommerce.cms.file.StaticAssetMultiTenantExtensionManager staticAssetMultiTenantExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetService staticAssetService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetStorageService staticAssetStorageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/assets");

    // Act
    MockMvcBuilders.standaloneSetup(adminAssetController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminAssetController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}.
   * <p>
   * Method under test:
   * {@link AdminAssetController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testViewEntityForm() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.admin.web.controller.AdminAssetController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3090 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminAssetController adminAssetController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.admin.web.service.AssetFormBuilderService assetFormBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao dynamicEntityDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.persistence.EntityDuplicator entityDuplicator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.service.GenericEntityService genericEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blMultipleCatalogExtensionManager") org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager multipleCatalogExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blStaticAssetMultiTenantExtensionManager") org.broadleafcommerce.cms.file.StaticAssetMultiTenantExtensionManager staticAssetMultiTenantExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetService staticAssetService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetStorageService staticAssetStorageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/assets/{id}", "42");

    // Act
    MockMvcBuilders.standaloneSetup(adminAssetController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminAssetController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link AdminAssetController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveEntity() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.admin.web.controller.AdminAssetController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3089 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminAssetController adminAssetController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.admin.web.service.AssetFormBuilderService assetFormBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao dynamicEntityDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.persistence.EntityDuplicator entityDuplicator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.service.GenericEntityService genericEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blMultipleCatalogExtensionManager") org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager multipleCatalogExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blStaticAssetMultiTenantExtensionManager") org.broadleafcommerce.cms.file.StaticAssetMultiTenantExtensionManager staticAssetMultiTenantExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetService staticAssetService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetStorageService staticAssetStorageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/assets/{id}", "42");

    // Act
    MockMvcBuilders.standaloneSetup(adminAssetController).build().perform(requestBuilder);
  }

  /**
   * Test {@link AdminAssetController#getDefaultEntityType()}.
   * <p>
   * Method under test: {@link AdminAssetController#getDefaultEntityType()}
   */
  @Test
  public void testGetDefaultEntityType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.cms.file.domain.StaticAssetImpl",
        (new AdminAssetController()).getDefaultEntityType());
  }

  /**
   * Test {@link AdminAssetController#getDefaultEntityType()}.
   * <p>
   * Method under test: {@link AdminAssetController#getDefaultEntityType()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultEntityType2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.admin.web.controller.AdminAssetController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3092 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminAssetController adminAssetController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.admin.web.service.AssetFormBuilderService assetFormBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao dynamicEntityDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.persistence.EntityDuplicator entityDuplicator;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.service.GenericEntityService genericEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blMultipleCatalogExtensionManager") org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager multipleCatalogExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blStaticAssetMultiTenantExtensionManager") org.broadleafcommerce.cms.file.StaticAssetMultiTenantExtensionManager staticAssetMultiTenantExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetService staticAssetService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.file.service.StaticAssetStorageService staticAssetStorageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminAssetController.getDefaultEntityType();
  }
}
