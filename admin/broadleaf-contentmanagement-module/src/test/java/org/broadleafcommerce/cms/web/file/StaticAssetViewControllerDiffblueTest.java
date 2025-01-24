package org.broadleafcommerce.cms.web.file;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class StaticAssetViewControllerDiffblueTest {
  @Autowired
  private StaticAssetViewController staticAssetViewController;

  /**
   * Test {@link StaticAssetViewController#init()}.
   * <p>
   * Method under test: {@link StaticAssetViewController#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.file;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2443 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.file.StaticAssetViewController staticAssetViewController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    staticAssetViewController.init();
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   * <p>
   * Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertParameterMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.file;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2325 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.file.StaticAssetViewController staticAssetViewController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    staticAssetViewController.convertParameterMap(new HashMap<>());
  }

  /**
   * Test {@link StaticAssetViewController#convertParameterMap(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetViewController#convertParameterMap(Map)}
   */
  @Test
  public void testConvertParameterMap_whenHashMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();

    // Act and Assert
    assertTrue(staticAssetViewController.convertParameterMap(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link StaticAssetViewController#isAllowedUrlParameter(String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#isAllowedUrlParameter(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsAllowedUrlParameter() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.file;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2444 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.file.StaticAssetViewController staticAssetViewController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    staticAssetViewController.isAllowedUrlParameter("https://example.org/example");
  }

  /**
   * Test
   * {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#handleRequestInternal(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleRequestInternal() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.file;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2334 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.file.StaticAssetViewController staticAssetViewController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    staticAssetViewController.handleRequestInternal(request, new MockHttpServletResponse());
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveAssetPrefix() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.file;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2757 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.file.StaticAssetViewController staticAssetViewController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    staticAssetViewController.removeAssetPrefix("Request URI");
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <ul>
   *   <li>Given {@link StaticAssetViewController} (default constructor)
   * CacheControl is {@link CacheControl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  public void testRemoveAssetPrefix_givenStaticAssetViewControllerCacheControlIsCacheControl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();
    staticAssetViewController.setCacheControl(mock(CacheControl.class));

    // Act and Assert
    assertEquals("Request URI", staticAssetViewController.removeAssetPrefix("Request URI"));
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <ul>
   *   <li>Given {@link StaticAssetViewController} (default constructor).</li>
   *   <li>Then return {@code Request URI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  public void testRemoveAssetPrefix_givenStaticAssetViewController_thenReturnRequestUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Request URI", (new StaticAssetViewController()).removeAssetPrefix("Request URI"));
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <ul>
   *   <li>Then return {@code /quest URI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  public void testRemoveAssetPrefix_thenReturnQuestUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();
    staticAssetViewController.setAssetServerUrlPrefix("foo");

    // Act and Assert
    assertEquals("/quest URI", staticAssetViewController.removeAssetPrefix("Request URI"));
  }

  /**
   * Test {@link StaticAssetViewController#removeAssetPrefix(String)}.
   * <ul>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#removeAssetPrefix(String)}
   */
  @Test
  public void testRemoveAssetPrefix_thenReturnSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();
    staticAssetViewController.setAssetServerUrlPrefix("");

    // Act and Assert
    assertEquals("/", staticAssetViewController.removeAssetPrefix("/"));
  }

  /**
   * Test {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}.
   * <p>
   * Method under test:
   * {@link StaticAssetViewController#getAllowUnnamedImageManipulation()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllowUnnamedImageManipulation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.file;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2333 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.file.StaticAssetViewController staticAssetViewController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    staticAssetViewController.getAllowUnnamedImageManipulation();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StaticAssetViewController#setAssetServerUrlPrefix(String)}
   *   <li>{@link StaticAssetViewController#setViewResolverName(String)}
   *   <li>{@link StaticAssetViewController#getAssetServerUrlPrefix()}
   *   <li>{@link StaticAssetViewController#getViewResolverName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    StaticAssetViewController staticAssetViewController = new StaticAssetViewController();

    // Act
    staticAssetViewController.setAssetServerUrlPrefix("https://example.org/example");
    staticAssetViewController.setViewResolverName("View Resolver Name");
    String actualAssetServerUrlPrefix = staticAssetViewController.getAssetServerUrlPrefix();

    // Assert that nothing has changed
    assertEquals("View Resolver Name", staticAssetViewController.getViewResolverName());
    assertEquals("https://example.org/example", actualAssetServerUrlPrefix);
  }

  /**
   * Test new {@link StaticAssetViewController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link StaticAssetViewController}
   */
  @Test
  public void testNewStaticAssetViewController() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    StaticAssetViewController actualStaticAssetViewController = new StaticAssetViewController();

    // Assert
    assertNull(actualStaticAssetViewController.getVaryByRequestHeaders());
    assertNull(actualStaticAssetViewController.getAssetServerUrlPrefix());
    assertNull(actualStaticAssetViewController.getViewResolverName());
    assertNull(actualStaticAssetViewController.staticAssetStorageService);
    assertNull(actualStaticAssetViewController.namedOperationManager);
    assertNull(actualStaticAssetViewController.siteResolver);
    assertNull(actualStaticAssetViewController.appCtx);
    assertNull(actualStaticAssetViewController.env);
    assertNull(actualStaticAssetViewController.getCacheControl());
    assertEquals(-1, actualStaticAssetViewController.getCacheSeconds());
    assertFalse(actualStaticAssetViewController.isSynchronizeOnSession());
    assertFalse(actualStaticAssetViewController.isAlwaysMustRevalidate());
    assertFalse(actualStaticAssetViewController.isRequireSession());
    assertFalse(actualStaticAssetViewController.isUseExpiresHeader());
    assertTrue(actualStaticAssetViewController.isUseCacheControlHeader());
    assertTrue(actualStaticAssetViewController.isUseCacheControlNoStore());
    assertArrayEquals(new String[]{"GET", "HEAD", "POST"}, actualStaticAssetViewController.getSupportedMethods());
  }

  /**
   * Test new {@link StaticAssetViewController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link StaticAssetViewController}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewStaticAssetViewController2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.file;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2324 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.file.StaticAssetViewController staticAssetViewController;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new StaticAssetViewController();
  }
}
