package org.broadleafcommerce.profile.web.site.security;

import static org.mockito.Mockito.mock;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-web-applicationContext.xml",
    "/blc-config/site/bl-profile-web-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class SessionFixationProtectionFilterDiffblueTest {
  @Autowired
  private SessionFixationProtectionFilter sessionFixationProtectionFilter;

  /**
   * Test
   * {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilter(ServletRequest, ServletResponse, FilterChain)")
  @Disabled("TODO: Complete this test")
  void testDoFilter() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.site.security;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2734 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.site.security.SessionFixationProtectionFilter sessionFixationProtectionFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SessionFixationProtectionFilter sessionFixationProtectionFilter2 = new SessionFixationProtectionFilter();
    MockHttpServletRequest sRequest = new MockHttpServletRequest();

    // Act
    sessionFixationProtectionFilter2.doFilter(sRequest, new MockHttpServletResponse(), mock(FilterChain.class));
  }

  /**
   * Test
   * {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test abortUser(HttpServletRequest, HttpServletResponse)")
  @Disabled("TODO: Complete this test")
  void testAbortUser() throws IOException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.site.security;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2621 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.site.security.SessionFixationProtectionFilter sessionFixationProtectionFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SessionFixationProtectionFilter sessionFixationProtectionFilter2 = new SessionFixationProtectionFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    sessionFixationProtectionFilter2.abortUser(request, new MockHttpServletResponse());
  }
}
