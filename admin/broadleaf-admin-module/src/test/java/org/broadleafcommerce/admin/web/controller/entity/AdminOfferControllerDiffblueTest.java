package org.broadleafcommerce.admin.web.controller.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.persistence.EntityDuplicator;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.core.offer.service.OfferService;
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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;

@ContextConfiguration(classes = {AdminOfferController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminOfferControllerDiffblueTest {
  @MockBean(name = "blAdminAbstractControllerExtensionManager")
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @MockBean
  private AdminEntityService adminEntityService;

  @MockBean
  private AdminNavigationService adminNavigationService;

  @Autowired
  private AdminOfferController adminOfferController;

  @MockBean
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @MockBean
  private AdminUserDao adminUserDao;

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
  private OfferService offerService;

  @MockBean
  private RowLevelSecurityService rowLevelSecurityService;

  @MockBean
  private SandBoxHelper sandBoxHelper;

  @MockBean
  private SecurityVerifier securityVerifier;

  /**
   * Test {@link AdminOfferController#getSectionKey(Map)}.
   * <p>
   * Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSectionKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminOfferController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass358 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminOfferController adminOfferController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminOfferController.getSectionKey(new HashMap<>());
  }

  /**
   * Test {@link AdminOfferController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminOfferController.getSectionKey(pathVars));
  }

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
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();

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
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();

    // Act and Assert
    assertEquals(AdminOfferController.SECTION_KEY, adminOfferController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminOfferController#getSectionCustomCriteria()}.
   * <p>
   * Method under test: {@link AdminOfferController#getSectionCustomCriteria()}
   */
  @Test
  public void testGetSectionCustomCriteria() {
    // Arrange, Act and Assert
    assertEquals(0, (new AdminOfferController()).getSectionCustomCriteria().length);
  }

  /**
   * Test
   * {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <p>
   * Method under test:
   * {@link AdminOfferController#viewEntityList(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testViewEntityList() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminOfferController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass357 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminOfferController adminOfferController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer");

    // Act
    MockMvcBuilders.standaloneSetup(adminOfferController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminOfferController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}.
   * <p>
   * Method under test:
   * {@link AdminOfferController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testViewEntityForm() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminOfferController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass356 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminOfferController adminOfferController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer/{id}", "42");

    // Act
    MockMvcBuilders.standaloneSetup(adminOfferController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminOfferController#viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}.
   * <p>
   * Method under test:
   * {@link AdminOfferController#viewAddEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testViewAddEntityForm() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminOfferController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass355 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminOfferController adminOfferController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/offer/add").param("entityType", "foo");

    // Act
    MockMvcBuilders.standaloneSetup(adminOfferController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminOfferController#addEntity(HttpServletRequest, HttpServletResponse, Model, Map, EntityForm, BindingResult)}.
   * <p>
   * Method under test:
   * {@link AdminOfferController#addEntity(HttpServletRequest, HttpServletResponse, Model, Map, EntityForm, BindingResult)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddEntity() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminOfferController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass353 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminOfferController adminOfferController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/offer/add");

    // Act
    MockMvcBuilders.standaloneSetup(adminOfferController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminOfferController#duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)}.
   * <p>
   * Method under test:
   * {@link AdminOfferController#duplicateEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDuplicateEntity() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminOfferController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass354 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminOfferController adminOfferController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/offer/{id}/duplicate", "42");

    // Act
    MockMvcBuilders.standaloneSetup(adminOfferController).build().perform(requestBuilder);
  }

  /**
   * Test {@link AdminOfferController#modifyModelAttributes(Model)}.
   * <p>
   * Method under test: {@link AdminOfferController#modifyModelAttributes(Model)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyModelAttributes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.admin.web.controller.entity.AdminOfferController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass359 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.entity.AdminOfferController adminOfferController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.dao.AdminUserDao adminUserDao;
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
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService rowLevelSecurityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.sandbox.SandBoxHelper sandBoxHelper;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminOfferController.modifyModelAttributes(new ConcurrentModel());
  }

  /**
   * Test {@link AdminOfferController#modifyModelAttributes(Model)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return
   * {@code Apply}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#modifyModelAttributes(Model)}
   */
  @Test
  public void testModifyModelAttributes_givenFunctionApplyReturnApply_thenCallsApply() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("additionalControllerClasses", function);

    // Act
    adminOfferController.modifyModelAttributes(model);

    // Assert that nothing has changed
    verify(function).apply(eq("additionalControllerClasses"));
    assertEquals(1, model.size());
    assertEquals("offer-form", model.get("additionalControllerClasses"));
  }

  /**
   * Test {@link AdminOfferController#modifyModelAttributes(Model)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminOfferController#modifyModelAttributes(Model)}
   */
  @Test
  public void testModifyModelAttributes_whenConcurrentModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferController adminOfferController = new AdminOfferController();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminOfferController.modifyModelAttributes(model);

    // Assert that nothing has changed
    assertEquals(1, model.size());
    assertEquals("offer-form", model.get("additionalControllerClasses"));
  }
}
