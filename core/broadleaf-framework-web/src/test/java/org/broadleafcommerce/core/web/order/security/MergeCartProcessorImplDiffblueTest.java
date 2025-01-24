package org.broadleafcommerce.core.web.order.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class MergeCartProcessorImplDiffblueTest {
  @Autowired
  private MergeCartProcessorImpl mergeCartProcessorImpl;

  /**
   * Test {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)} with
   * {@code request}, {@code authResult}.
   * <p>
   * Method under test:
   * {@link MergeCartProcessorImpl#execute(WebRequest, Authentication)}
   */
  @Test
  @DisplayName("Test execute(WebRequest, Authentication) with 'request', 'authResult'")
  @Disabled("TODO: Complete this test")
  void testExecuteWithRequestAuthResult() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9090 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.MergeCartProcessorImpl mergeCartProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MergeCartProcessorImpl mergeCartProcessorImpl2 = new MergeCartProcessorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act
    mergeCartProcessorImpl2.execute(request, new TestingAuthenticationToken("Principal", "Credentials"));
  }

  /**
   * Test
   * {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse, Authentication)}
   * with {@code request}, {@code response}, {@code authResult}.
   * <p>
   * Method under test:
   * {@link MergeCartProcessorImpl#execute(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName("Test execute(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authResult'")
  @Disabled("TODO: Complete this test")
  void testExecuteWithRequestResponseAuthResult() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.order.security;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8859 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.MergeCartProcessorImpl mergeCartProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MergeCartProcessorImpl mergeCartProcessorImpl2 = new MergeCartProcessorImpl();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    mergeCartProcessorImpl2.execute(request, response, new TestingAuthenticationToken("Principal", "Credentials"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MergeCartProcessorImpl#setMergeCartResponseKey(String)}
   *   <li>{@link MergeCartProcessorImpl#getMergeCartResponseKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    MergeCartProcessorImpl mergeCartProcessorImpl = new MergeCartProcessorImpl();

    // Act
    mergeCartProcessorImpl.setMergeCartResponseKey("Merge Cart Response Key");

    // Assert that nothing has changed
    assertEquals("Merge Cart Response Key", mergeCartProcessorImpl.getMergeCartResponseKey());
  }
}
