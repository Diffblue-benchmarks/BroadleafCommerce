package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
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
public class AbstractBroadleafAdminRequestFilterDiffblueTest {
  @Autowired
  private AbstractBroadleafAdminRequestFilter abstractBroadleafAdminRequestFilter;

  /**
   * Test
   * {@link AbstractBroadleafAdminRequestFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <p>
   * Method under test:
   * {@link AbstractBroadleafAdminRequestFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShouldProcessURL() {
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
    //   public class DiffblueFakeClass620 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.AbstractBroadleafAdminRequestFilter abstractBroadleafAdminRequestFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BroadleafAdminRequestFilter broadleafAdminRequestFilter = new BroadleafAdminRequestFilter();

    // Act
    broadleafAdminRequestFilter.shouldProcessURL(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()),
        "https://example.org/example");
  }

  /**
   * Test {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}.
   * <p>
   * Method under test:
   * {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafAdminRequestFilter broadleafAdminRequestFilter = new BroadleafAdminRequestFilter();
    broadleafAdminRequestFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(44, broadleafAdminRequestFilter.getIgnoreSuffixes().size());
  }

  /**
   * Test {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}.
   * <p>
   * Method under test:
   * {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIgnoreSuffixes2() {
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
    //   public class DiffblueFakeClass615 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.AbstractBroadleafAdminRequestFilter abstractBroadleafAdminRequestFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BroadleafAdminRequestFilter()).getIgnoreSuffixes();
  }

  /**
   * Test {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}.
   * <ul>
   *   <li>Given {@link BroadleafAdminRequestFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBroadleafAdminRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes_givenBroadleafAdminRequestFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(44, (new BroadleafAdminRequestFilter()).getIgnoreSuffixes().size());
  }
}
