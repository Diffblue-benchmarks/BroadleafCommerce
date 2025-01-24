package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentCreator.xml",
    "/applicationContext-servlet-cms-contentClient.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminStructuredContentControllerDiffblueTest {
  @Autowired
  private AdminStructuredContentController adminStructuredContentController;

  /**
   * Test {@link AdminStructuredContentController#getSectionKey(Map)}.
   * <p>
   * Method under test:
   * {@link AdminStructuredContentController#getSectionKey(Map)}
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
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentCreator.xml","/applicationContext-servlet-cms-contentClient.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3442 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminStructuredContentController adminStructuredContentController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    adminStructuredContentController.getSectionKey(new HashMap<>());
  }

  /**
   * Test {@link AdminStructuredContentController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminStructuredContentController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminStructuredContentController adminStructuredContentController = new AdminStructuredContentController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminStructuredContentController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminStructuredContentController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminStructuredContentController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminStructuredContentController adminStructuredContentController = new AdminStructuredContentController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminStructuredContentController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminStructuredContentController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code structured-content}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminStructuredContentController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_whenHashMap_thenReturnStructuredContent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminStructuredContentController adminStructuredContentController = new AdminStructuredContentController();

    // Act and Assert
    assertEquals("structured-content", adminStructuredContentController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test
   * {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}.
   * <p>
   * Method under test:
   * {@link AdminStructuredContentController#viewEntityForm(HttpServletRequest, HttpServletResponse, Model, Map, String)}
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
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentCreator.xml","/applicationContext-servlet-cms-contentClient.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3658 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminStructuredContentController adminStructuredContentController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminStructuredContentController.viewEntityForm(request, response, model, new HashMap<>(), "42");
  }

  /**
   * Test
   * {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test:
   * {@link AdminStructuredContentController#saveEntity(HttpServletRequest, HttpServletResponse, Model, Map, String, EntityForm, BindingResult, RedirectAttributes)}
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
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentCreator.xml","/applicationContext-servlet-cms-contentClient.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3450 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminStructuredContentController adminStructuredContentController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = new EntityForm();
    BindException result = new BindException("Target", "Object Name");

    // Act
    adminStructuredContentController.saveEntity(request, response, model, pathVars, "42", entityForm, result,
        new RedirectAttributesModelMap());
  }

  /**
   * Test
   * {@link AdminStructuredContentController#getDynamicForm(HttpServletRequest, HttpServletResponse, Model, Map, String, String)}
   * with {@code request}, {@code response}, {@code model}, {@code pathVars},
   * {@code propertyName}, {@code propertyTypeId}.
   * <p>
   * Method under test:
   * {@link AdminStructuredContentController#getDynamicForm(HttpServletRequest, HttpServletResponse, Model, Map, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDynamicFormWithRequestResponseModelPathVarsPropertyNamePropertyTypeId() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.admin.web.controller;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentCreator.xml","/applicationContext-servlet-cms-contentClient.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3310 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.admin.web.controller.AdminStructuredContentController adminStructuredContentController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    adminStructuredContentController.getDynamicForm(request, response, model, new HashMap<>(), "Property Name", "42");
  }

  /**
   * Test new {@link AdminStructuredContentController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminStructuredContentController}
   */
  @Test
  public void testNewAdminStructuredContentController() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     AdminBasicEntityController.adminUserDao
    //     AdminBasicEntityController.adornedTargetAutoPopulateExtensionManager
    //     AdminBasicEntityController.duplicator
    //     AdminBasicEntityController.dynamicEntityDao
    //     AdminBasicEntityController.genericEntityService
    //     AdminBasicEntityController.multipleCatalogExtensionManager
    //     AdminBasicEntityController.rowLevelSecurityService
    //     AdminBasicEntityController.sandBoxHelper
    //     AdminAbstractController.adminNavigationService
    //     AdminAbstractController.adminRemoteSecurityService
    //     AdminAbstractController.customCriteriaService
    //     AdminAbstractController.entityConfiguration
    //     AdminAbstractController.entityFormValidator
    //     AdminAbstractController.eps
    //     AdminAbstractController.extensionManager
    //     AdminAbstractController.filterProductTypeExtensionManager
    //     AdminAbstractController.formService
    //     AdminAbstractController.service
    //     AdminAbstractController.validationService

    // Arrange and Act
    new AdminStructuredContentController();
  }
}
