package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.broadleafcommerce.openadmin.web.dao.MultipleCatalogExtensionManager;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ContextConfiguration(classes = {AdminUserManagementController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminUserManagementControllerDiffblueTest {
  @MockBean(name = "blAdminAbstractControllerExtensionManager")
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @MockBean
  private AdminEntityService adminEntityService;

  @MockBean
  private AdminNavigationService adminNavigationService;

  @MockBean
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @MockBean
  private AdminUserDao adminUserDao;

  @Autowired
  private AdminUserManagementController adminUserManagementController;

  @MockBean(name = "blAdornedTargetAutoPopulateExtensionManager")
  private AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;

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

  /**
   * Test {@link AdminUserManagementController#getSectionKey(Map)}.
   * <p>
   * Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSectionKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminUserManagementController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8155 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminUserManagementController adminUserManagementController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
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
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminUserManagementController.getSectionKey(new HashMap<>());
  }

  /**
   * Test {@link AdminUserManagementController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminUserManagementController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminUserManagementController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminUserManagementController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminUserManagementController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminUserManagementController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();

    // Act and Assert
    assertEquals(AdminUserManagementController.SECTION_KEY,
        adminUserManagementController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test
   * {@link AdminUserManagementController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}.
   * <p>
   * Method under test:
   * {@link AdminUserManagementController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testViewEntityForm() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminUserManagementController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8154 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminUserManagementController adminUserManagementController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
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
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user-management/{id}", "42");

    // Act
    MockMvcBuilders.standaloneSetup(adminUserManagementController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminUserManagementController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link AdminUserManagementController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveEntity() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminUserManagementController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8153 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminUserManagementController adminUserManagementController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
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
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user-management/{id}", "42");

    // Act
    MockMvcBuilders.standaloneSetup(adminUserManagementController).build().perform(requestBuilder);
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   * with {@code ef}, {@code pathVars}.
   * <p>
   * Method under test:
   * {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyEntityFormWithEfPathVars() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.AdminUserManagementController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8156 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminUserManagementController adminUserManagementController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdornedTargetAutoPopulateExtensionManager") org.broadleafcommerce.openadmin.server.service.persistence.extension.AdornedTargetAutoPopulateExtensionManager adornedTargetAutoPopulateExtensionManager;
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
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    EntityForm ef = new EntityForm();

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   * with {@code ef}, {@code pathVars}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getValue()} return empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyEntityFormWithEfPathVars_givenCodeFieldGetValueReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("");
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField, atLeast(1)).getValue();
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   * with {@code ef}, {@code pathVars}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return
   * {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyEntityFormWithEfPathVars_givenField_whenEntityFormFindFieldReturnField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   * with {@code ef}, {@code pathVars}.
   * <ul>
   *   <li>Then calls {@link Field#setIsVisible(Boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyEntityFormWithEfPathVars_thenCallsSetIsVisible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setIsVisible(Mockito.<Boolean>any());
    when(codeField.getValue()).thenReturn("42");
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField, atLeast(1)).getValue();
    verify(codeField, atLeast(1)).setIsVisible(eq(false));
  }
}
