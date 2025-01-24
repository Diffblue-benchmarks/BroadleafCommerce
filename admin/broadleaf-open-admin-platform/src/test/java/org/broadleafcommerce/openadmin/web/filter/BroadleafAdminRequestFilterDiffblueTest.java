package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAdminRequestFilterDiffblueTest {
  @Autowired
  private BroadleafAdminRequestFilter broadleafAdminRequestFilter;

  /**
   * Test
   * {@link BroadleafAdminRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1992 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.BroadleafAdminRequestFilter broadleafAdminRequestFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafAdminRequestFilter broadleafAdminRequestFilter2 = new BroadleafAdminRequestFilter();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    // Act
    broadleafAdminRequestFilter2.doFilterInternalUnlessIgnored(request, new MockHttpServletResponse(),
        mock(FilterChain.class));
  }

  /**
   * Test
   * {@link BroadleafAdminRequestFilter#validateClassNameParams(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminRequestFilter#validateClassNameParams(HttpServletRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateClassNameParams() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2298 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.BroadleafAdminRequestFilter broadleafAdminRequestFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafAdminRequestFilter broadleafAdminRequestFilter2 = new BroadleafAdminRequestFilter();

    // Act
    broadleafAdminRequestFilter2
        .validateClassNameParams(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
  }

  /**
   * Test
   * {@link BroadleafAdminRequestFilter#forwardToConflictDestination(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminRequestFilter#forwardToConflictDestination(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testForwardToConflictDestination() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2147 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.BroadleafAdminRequestFilter broadleafAdminRequestFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafAdminRequestFilter broadleafAdminRequestFilter2 = new BroadleafAdminRequestFilter();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    // Act
    broadleafAdminRequestFilter2.forwardToConflictDestination(request, new MockHttpServletResponse());
  }

  /**
   * Test {@link BroadleafAdminRequestFilter#getOrder()}.
   * <p>
   * Method under test: {@link BroadleafAdminRequestFilter#getOrder()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2293 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.BroadleafAdminRequestFilter broadleafAdminRequestFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BroadleafAdminRequestFilter()).getOrder();
  }

  /**
   * Test {@link BroadleafAdminRequestFilter#getOrder()}.
   * <ul>
   *   <li>Given {@link BroadleafAdminRequestFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestFilter#getOrder()}
   */
  @Test
  public void testGetOrder_givenBroadleafAdminRequestFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new BroadleafAdminRequestFilter()).getOrder());
  }

  /**
   * Test {@link BroadleafAdminRequestFilter#getOrder()}.
   * <ul>
   *   <li>Given {@link BroadleafAdminRequestFilter} (default constructor)
   * Environment is {@link StandardEnvironment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestFilter#getOrder()}
   */
  @Test
  public void testGetOrder_givenBroadleafAdminRequestFilterEnvironmentIsStandardEnvironment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminRequestFilter broadleafAdminRequestFilter = new BroadleafAdminRequestFilter();
    broadleafAdminRequestFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(10000, broadleafAdminRequestFilter.getOrder());
  }
}
