package org.broadleafcommerce.openadmin.web.controller.entity;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.controller.AdminBasicOperationsControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
import org.broadleafcommerce.openadmin.web.service.SearchFieldResolver;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {AdminBasicOperationsController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminBasicOperationsControllerDiffblueTest {
  @MockBean(name = "blAdminAbstractControllerExtensionManager")
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Autowired
  private AdminBasicOperationsController adminBasicOperationsController;

  @MockBean(name = "blAdminBasicOperationsControllerExtensionManager")
  private AdminBasicOperationsControllerExtensionManager adminBasicOperationsControllerExtensionManager;

  @MockBean
  private AdminEntityService adminEntityService;

  @MockBean
  private AdminNavigationService adminNavigationService;

  @MockBean
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @MockBean
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @MockBean(name = "blEntityConfiguration")
  private EntityConfiguration entityConfiguration;

  @MockBean(name = "blEntityFormValidator")
  private EntityFormValidator entityFormValidator;

  @MockBean
  private ExploitProtectionService exploitProtectionService;

  @MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager")
  private FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;

  @MockBean
  private FormBuilderService formBuilderService;

  @MockBean
  private SearchFieldResolver searchFieldResolver;

  @MockBean
  private SecurityVerifier securityVerifier;

  /**
   * Test
   * {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#showSelectCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, boolean, MultiValueMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShowSelectCollectionItem() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicOperationsController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass70 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicOperationsController adminBasicOperationsController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminBasicOperationsControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminBasicOperationsControllerExtensionManager adminBasicOperationsControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.SearchFieldResolver searchFieldResolver;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
        .get("/{owningClass:.*}/{collectionField:.*}/select", "U", "U");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("dynamicField", String.valueOf(true));

    // Act
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#getTypeaheadResults(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, String, MultiValueMap)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#getTypeaheadResults(HttpServletRequest, HttpServletResponse, Model, Map, String, String, String, String, MultiValueMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetTypeaheadResults() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicOperationsController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass67 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicOperationsController adminBasicOperationsController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminBasicOperationsControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminBasicOperationsControllerExtensionManager adminBasicOperationsControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.SearchFieldResolver searchFieldResolver;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/{owningClass:.*}/{collectionField:.*}/typeahead", "U", "U");

    // Act
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testSessionTimerReset() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    SecurityWrapperRequest request = new SecurityWrapperRequest(
        new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualSessionTimerResetResult = adminBasicOperationsController.sessionTimerReset(request, response);

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"serverSessionTimeoutInterval\":0}", response.getContentAsString());
    assertNull(actualSessionTimerResetResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    byte[] expectedContentAsByteArray = "{\"serverSessionTimeoutInterval\":0}".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, response.getContentAsByteArray());
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSessionTimerReset2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicOperationsController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass69 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicOperationsController adminBasicOperationsController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminBasicOperationsControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminBasicOperationsControllerExtensionManager adminBasicOperationsControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.SearchFieldResolver searchFieldResolver;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/sessionTimerReset");

    // Act
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link MockHttpSession#MockHttpSession()}.</li>
   *   <li>Then calls {@link HttpServletRequestWrapper#getSession()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testSessionTimerReset_givenMockHttpSession_thenCallsGetSession() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getSession()).thenReturn(new MockHttpSession());
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualSessionTimerResetResult = adminBasicOperationsController.sessionTimerReset(request2, response);

    // Assert
    verify(request).getSession();
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"serverSessionTimeoutInterval\":0}", response.getContentAsString());
    assertNull(actualSessionTimerResetResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    byte[] expectedContentAsByteArray = "{\"serverSessionTimeoutInterval\":0}".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, response.getContentAsByteArray());
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#sessionTimerReset(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testSessionTimerReset_thenMockHttpServletResponseHeaderNamesSizeIsOne() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualSessionTimerResetResult = adminBasicOperationsController.sessionTimerReset(request, response);

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"serverSessionTimeoutInterval\":0}", response.getContentAsString());
    assertNull(actualSessionTimerResetResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    byte[] expectedContentAsByteArray = "{\"serverSessionTimeoutInterval\":0}".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, response.getContentAsByteArray());
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLogJavaScriptError() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicOperationsController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass68 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicOperationsController adminBasicOperationsController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminBasicOperationsControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminBasicOperationsControllerExtensionManager adminBasicOperationsControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.SearchFieldResolver searchFieldResolver;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/logJavaScriptError");

    // Act
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}
   */
  @Test
  public void testLogJavaScriptError_thenMockHttpServletResponseHeaderNamesSizeIsOne() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualLogJavaScriptErrorResult = adminBasicOperationsController.logJavaScriptError(request, response,
        new HttpHeaders());

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"errorLogged\":true}", response.getContentAsString());
    assertNull(actualLogJavaScriptErrorResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    byte[] expectedContentAsByteArray = "{\"errorLogged\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, response.getContentAsByteArray());
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}.
   * <ul>
   *   <li>When {@link DefaultMultipartHttpServletRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#logJavaScriptError(HttpServletRequest, HttpServletResponse, MultiValueMap)}
   */
  @Test
  public void testLogJavaScriptError_whenDefaultMultipartHttpServletRequest() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualLogJavaScriptErrorResult = adminBasicOperationsController.logJavaScriptError(request, response,
        new HttpHeaders());

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals("{\"errorLogged\":true}", response.getContentAsString());
    assertNull(actualLogJavaScriptErrorResult);
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
    byte[] expectedContentAsByteArray = "{\"errorLogged\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, response.getContentAsByteArray());
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}
   */
  @Test
  public void testUpdateAdminNavigation() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals("layout/partials/secondLeftNav",
        adminBasicOperationsController.updateAdminNavigation(request, response, model, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}
   */
  @Test
  public void testUpdateAdminNavigation2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals("layout/partials/secondLeftNav",
        adminBasicOperationsController.updateAdminNavigation(request, response, model, new HashMap<>()));
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#updateAdminNavigation(HttpServletRequest, HttpServletResponse, Model, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateAdminNavigation3() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller.entity;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicOperationsController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass71 {
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminAbstractControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicOperationsController adminBasicOperationsController;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blAdminBasicOperationsControllerExtensionManager") org.broadleafcommerce.openadmin.web.controller.AdminBasicOperationsControllerExtensionManager adminBasicOperationsControllerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminEntityService adminEntityService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService adminNavigationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService classNameRequestParamValidationService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityConfiguration") org.broadleafcommerce.common.persistence.EntityConfiguration entityConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blEntityFormValidator") org.broadleafcommerce.openadmin.web.form.entity.EntityFormValidator entityFormValidator;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.security.service.ExploitProtectionService exploitProtectionService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blFilterProductTypePersistenceHandlerExtensionManager") org.broadleafcommerce.openadmin.server.service.extension.FilterProductTypePersistenceHandlerExtensionManager filterProductTypePersistenceHandlerExtensionManager;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.FormBuilderService formBuilderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.web.service.SearchFieldResolver searchFieldResolver;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier securityVerifier;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/update-navigation");

    // Act
    MockMvcBuilders.standaloneSetup(adminBasicOperationsController).build().perform(requestBuilder);
  }

  /**
   * Test
   * {@link AdminBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdminBasicOperationsController#modifyFetchPersistencePackageRequest(PersistencePackageRequest, Map)}
   */
  @Test
  public void testModifyFetchPersistencePackageRequest() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     AdminBasicOperationsController.extensionManager
    //     AdminBasicOperationsController.searchFieldResolver
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

    // Arrange
    AdminBasicOperationsController adminBasicOperationsController = new AdminBasicOperationsController();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();

    // Act
    adminBasicOperationsController.modifyFetchPersistencePackageRequest(ppr, new HashMap<>());
  }
}
