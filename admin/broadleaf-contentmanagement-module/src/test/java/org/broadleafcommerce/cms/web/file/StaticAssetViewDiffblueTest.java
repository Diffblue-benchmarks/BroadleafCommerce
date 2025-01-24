package org.broadleafcommerce.cms.web.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StaticAssetViewDiffblueTest {
  @Autowired
  private StaticAssetView staticAssetView;

  /**
   * Test
   * {@link StaticAssetView#render(Map, HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link StaticAssetView#render(Map, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRender() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.file;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2208 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.file.StaticAssetView staticAssetView;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    HashMap<String, Object> model = new HashMap<>();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    staticAssetView.render(model, request, new MockHttpServletResponse());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticAssetView}
   *   <li>{@link StaticAssetView#setBrowserAssetCachingEnabled(boolean)}
   *   <li>{@link StaticAssetView#setCacheSeconds(long)}
   *   <li>{@link StaticAssetView#getCacheSeconds()}
   *   <li>{@link StaticAssetView#getContentType()}
   *   <li>{@link StaticAssetView#isBrowserAssetCachingEnabled()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetView actualStaticAssetView = new StaticAssetView();
    actualStaticAssetView.setBrowserAssetCachingEnabled(true);
    actualStaticAssetView.setCacheSeconds(1L);
    long actualCacheSeconds = actualStaticAssetView.getCacheSeconds();
    actualStaticAssetView.getContentType();

    // Assert that nothing has changed
    assertEquals(1L, actualCacheSeconds);
    assertTrue(actualStaticAssetView.isBrowserAssetCachingEnabled());
  }
}
