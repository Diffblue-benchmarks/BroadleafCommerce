package org.broadleafcommerce.cms.url.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.cms.url.domain.URLHandler;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class URLHandlerServiceImplDiffblueTest {
  @Autowired
  private URLHandlerServiceImpl uRLHandlerServiceImpl;

  /**
   * Test {@link URLHandlerServiceImpl#findURLHandlerByURI(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findURLHandlerByURI(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindURLHandlerByURI() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10021 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).findURLHandlerByURI("https://example.org/example");
  }

  /**
   * Test {@link URLHandlerServiceImpl#findURLHandlerById(Long)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findURLHandlerById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindURLHandlerById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10006 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).findURLHandlerById(1L);
  }

  /**
   * Test {@link URLHandlerServiceImpl#findAllURLHandlers()}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findAllURLHandlers()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAllURLHandlers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10005 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).findAllURLHandlers();
  }

  /**
   * Test {@link URLHandlerServiceImpl#findAllRegexURLHandlers()}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#findAllRegexURLHandlers()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAllRegexURLHandlers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10004 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).findAllRegexURLHandlers();
  }

  /**
   * Test {@link URLHandlerServiceImpl#saveURLHandler(URLHandler)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#saveURLHandler(URLHandler)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveURLHandler() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11258 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).saveURLHandler(URLHandlerServiceImpl.NULL_URL_HANDLER);
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  public void testCheckForMatches() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerServiceImpl()).checkForMatches("https://example.org/example"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#checkForMatches(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#checkForMatches(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckForMatches2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9695 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).checkForMatches("https://example.org/example");
  }

  /**
   * Test {@link URLHandlerServiceImpl#removeURLHandlerFromCache(String)}.
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#removeURLHandlerFromCache(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveURLHandlerFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10949 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).removeURLHandlerFromCache("https://example.org/example");
  }

  /**
   * Test {@link URLHandlerServiceImpl#removeURLHandlerFromCache(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#removeURLHandlerFromCache(String)}
   */
  @Test
  public void testRemoveURLHandlerFromCache_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new URLHandlerServiceImpl()).removeURLHandlerFromCache(null));
  }

  /**
   * Test {@link URLHandlerServiceImpl#manipulateUri(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#manipulateUri(String)}
   */
  @Test
  public void testManipulateUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        (new URLHandlerServiceImpl()).manipulateUri("https://example.org/example"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#manipulateUri(String)}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#manipulateUri(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testManipulateUri2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10640 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).manipulateUri("https://example.org/example");
  }

  /**
   * Test {@link URLHandlerServiceImpl#getUrlHandlerFromCache(String)}.
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#getUrlHandlerFromCache(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetUrlHandlerFromCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10331 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).getUrlHandlerFromCache("https://example.org/example");
  }

  /**
   * Test {@link URLHandlerServiceImpl#getUrlHandlerCache()}.
   * <p>
   * Method under test: {@link URLHandlerServiceImpl#getUrlHandlerCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetUrlHandlerCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10330 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).getUrlHandlerCache();
  }

  /**
   * Test {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}.
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildURLHandlerCacheKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9673 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    URLHandlerServiceImpl urlHandlerServiceImpl = new URLHandlerServiceImpl();

    // Act
    urlHandlerServiceImpl.buildURLHandlerCacheKey(new SiteImpl(), "https://example.org/example");
  }

  /**
   * Test {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@code site:1_https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}
   */
  @Test
  public void testBuildURLHandlerCacheKey_givenOne_thenReturnSite1HttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerServiceImpl urlHandlerServiceImpl = new URLHandlerServiceImpl();
    SiteImpl site = mock(SiteImpl.class);
    when(site.getId()).thenReturn(1L);

    // Act
    String actualBuildURLHandlerCacheKeyResult = urlHandlerServiceImpl.buildURLHandlerCacheKey(site,
        "https://example.org/example");

    // Assert
    verify(site).getId();
    assertEquals("site:1_https://example.org/example", actualBuildURLHandlerCacheKeyResult);
  }

  /**
   * Test {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code site:}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}
   */
  @Test
  public void testBuildURLHandlerCacheKey_givenRuntimeExceptionWithSite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerServiceImpl urlHandlerServiceImpl = new URLHandlerServiceImpl();
    SiteImpl site = mock(SiteImpl.class);
    when(site.getId()).thenThrow(new RuntimeException("site:"));

    // Act
    urlHandlerServiceImpl.buildURLHandlerCacheKey(site, "https://example.org/example");

    // Assert
    verify(site).getId();
  }

  /**
   * Test {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}.
   * <ul>
   *   <li>Then return {@code site:null_https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}
   */
  @Test
  public void testBuildURLHandlerCacheKey_thenReturnSiteNullHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerServiceImpl urlHandlerServiceImpl = new URLHandlerServiceImpl();

    // Act and Assert
    assertEquals("site:null_https://example.org/example",
        urlHandlerServiceImpl.buildURLHandlerCacheKey(new SiteImpl(), "https://example.org/example"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#buildURLHandlerCacheKey(Site, String)}
   */
  @Test
  public void testBuildURLHandlerCacheKey_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("null", (new URLHandlerServiceImpl()).buildURLHandlerCacheKey(null, null));
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  public void testWrapStringsWithAnchors() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("^([\\[\\]\\.\\|\\?\\*\\+\\(\\)\\\\~`\\!@#%&\\-_+={}'\"\"<>:;, \\/])$", (new URLHandlerServiceImpl())
        .wrapStringsWithAnchors("([\\[\\]\\.\\|\\?\\*\\+\\(\\)\\\\~`\\!@#%&\\-_+={}'\"\"<>:;, \\/])"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testWrapStringsWithAnchors2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11273 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.service.URLHandlerServiceImpl uRLHandlerServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerServiceImpl()).wrapStringsWithAnchors("https://example.org/example");
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <ul>
   *   <li>Then return {@code ^$}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  public void testWrapStringsWithAnchors_thenReturnCircumflexAccentDollarSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("^$", (new URLHandlerServiceImpl()).wrapStringsWithAnchors("^"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <ul>
   *   <li>Then return {@code ^/$}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  public void testWrapStringsWithAnchors_thenReturnCircumflexAccentSlashDollarSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("^/$", (new URLHandlerServiceImpl()).wrapStringsWithAnchors("$"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <ul>
   *   <li>Then return {@code ^/https://example.org/example$}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  public void testWrapStringsWithAnchors_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("^/https://example.org/example$",
        (new URLHandlerServiceImpl()).wrapStringsWithAnchors("https://example.org/example"));
  }

  /**
   * Test {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then return {@code ^ $}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerServiceImpl#wrapStringsWithAnchors(String)}
   */
  @Test
  public void testWrapStringsWithAnchors_whenSpace_thenReturnCircumflexAccentSpaceDollarSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("^ $", (new URLHandlerServiceImpl()).wrapStringsWithAnchors(" "));
  }
}
