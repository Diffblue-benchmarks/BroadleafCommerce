package org.broadleafcommerce.cms.url.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.cms.url.type.URLRedirectType;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml",
    "/applicationContext-servlet-cms-contentClient.xml", "/applicationContext-servlet-cms-contentCreator.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class URLHandlerImplDiffblueTest {
  @Autowired
  private URLHandlerImpl uRLHandlerImpl;

  /**
   * Test {@link URLHandlerImpl#getUrlRedirectType()}.
   * <p>
   * Method under test: {@link URLHandlerImpl#getUrlRedirectType()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetUrlRedirectType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9306 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.domain.URLHandlerImpl uRLHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerImpl()).getUrlRedirectType();
  }

  /**
   * Test {@link URLHandlerImpl#getUrlRedirectType()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getUrlRedirectType()}
   */
  @Test
  public void testGetUrlRedirectType_givenURLHandlerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getUrlRedirectType());
  }

  /**
   * Test {@link URLHandlerImpl#getUrlRedirectType()}.
   * <ul>
   *   <li>Then return FriendlyType is {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getUrlRedirectType()}
   */
  @Test
  public void testGetUrlRedirectType_thenReturnFriendlyTypeIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Act
    URLRedirectType actualUrlRedirectType = urlHandlerImpl.getUrlRedirectType();

    // Assert
    verify(redirectType).getType();
    assertEquals("https://example.org/example", actualUrlRedirectType.getFriendlyType());
    assertEquals("https://example.org/example", actualUrlRedirectType.getType());
  }

  /**
   * Test {@link URLHandlerImpl#setUrlRedirectType(URLRedirectType)}.
   * <p>
   * Method under test: {@link URLHandlerImpl#setUrlRedirectType(URLRedirectType)}
   */
  @Test
  public void testSetUrlRedirectType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    // Act
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Assert
    verify(redirectType).getType();
    URLRedirectType urlRedirectType = urlHandlerImpl.getUrlRedirectType();
    assertEquals("https://example.org/example", urlRedirectType.getFriendlyType());
    assertEquals("https://example.org/example", urlRedirectType.getType());
    assertEquals("https://example.org/example", urlHandlerImpl.urlRedirectType);
  }

  /**
   * Test {@link URLHandlerImpl#setUrlRedirectType(URLRedirectType)}.
   * <p>
   * Method under test: {@link URLHandlerImpl#setUrlRedirectType(URLRedirectType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetUrlRedirectType2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9660 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.domain.URLHandlerImpl uRLHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerImpl()).setUrlRedirectType(URLRedirectType.FORWARD);
  }

  /**
   * Test {@link URLHandlerImpl#setUrlRedirectType(URLRedirectType)}.
   * <ul>
   *   <li>When {@link URLRedirectType#FORWARD}.</li>
   *   <li>Then {@link URLHandlerImpl} (default constructor)
   * {@link URLHandlerImpl#urlRedirectType} is {@code FORWARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setUrlRedirectType(URLRedirectType)}
   */
  @Test
  public void testSetUrlRedirectType_whenForward_thenURLHandlerImplUrlRedirectTypeIsForward() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    URLRedirectType redirectType = URLRedirectType.FORWARD;

    // Act
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Assert
    assertEquals("FORWARD", urlHandlerImpl.urlRedirectType);
    URLRedirectType expectedUrlRedirectType = redirectType.FORWARD;
    assertSame(expectedUrlRedirectType, urlHandlerImpl.getUrlRedirectType());
  }

  /**
   * Test {@link URLHandlerImpl#isRegexHandler()}.
   * <p>
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsRegexHandler() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9638 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.domain.URLHandlerImpl uRLHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerImpl()).isRegexHandler();
  }

  /**
   * Test {@link URLHandlerImpl#isRegexHandler()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  public void testIsRegexHandler_givenURLHandlerImplUrlRedirectTypeIsForward_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setIncomingURL(".");

    // Act and Assert
    assertTrue(urlHandlerImpl.isRegexHandler());
  }

  /**
   * Test {@link URLHandlerImpl#isRegexHandler()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  public void testIsRegexHandler_givenURLHandlerImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new URLHandlerImpl()).isRegexHandler());
  }

  /**
   * Test {@link URLHandlerImpl#isRegexHandler()}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#isRegexHandler()}
   */
  @Test
  public void testIsRegexHandler_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setUrlRedirectType(redirectType);
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setIncomingURL(".");

    // Act
    boolean actualIsRegexHandlerResult = urlHandlerImpl.isRegexHandler();

    // Assert
    verify(redirectType).getType();
    assertTrue(actualIsRegexHandlerResult);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(Boolean)} with {@code Boolean}.
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetRegexHandlerWithBoolean() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9646 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.domain.URLHandlerImpl uRLHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerImpl()).setRegexHandler((Boolean) true);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetRegexHandlerWithBoolean2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9653 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.domain.URLHandlerImpl uRLHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerImpl()).setRegexHandler(true);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean_givenURLHandlerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();

    // Act
    urlHandlerImpl.setRegexHandler(true);

    // Assert
    assertTrue(urlHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(Boolean)} with {@code Boolean}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean_givenURLHandlerImplUrlRedirectTypeIsForward() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act
    urlHandlerImpl.setRegexHandler(null);

    // Assert
    assertFalse(urlHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(Boolean)} with {@code Boolean}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>Then {@link URLHandlerImpl} (default constructor)
   * {@link URLHandlerImpl#isRegex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean_givenURLHandlerImpl_thenURLHandlerImplIsRegex() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();

    // Act
    urlHandlerImpl.setRegexHandler((Boolean) true);

    // Assert
    assertTrue(urlHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(Boolean)} with {@code Boolean}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Act
    urlHandlerImpl.setRegexHandler(null);

    // Assert
    verify(redirectType).getType();
    assertFalse(urlHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#setRegexHandler(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#setRegexHandler(boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean_thenCallsGetType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Act
    urlHandlerImpl.setRegexHandler(true);

    // Assert
    verify(redirectType).getType();
    assertTrue(urlHandlerImpl.isRegex);
  }

  /**
   * Test {@link URLHandlerImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link URLHandlerImpl#getMainEntityName()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMainEntityName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9298 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.domain.URLHandlerImpl uRLHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerImpl()).getMainEntityName();
  }

  /**
   * Test {@link URLHandlerImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenURLHandlerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getMainEntityName());
  }

  /**
   * Test {@link URLHandlerImpl#getMainEntityName()}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Act
    String actualMainEntityName = urlHandlerImpl.getMainEntityName();

    // Assert
    verify(redirectType).getType();
    assertNull(actualMainEntityName);
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocation() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9290 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.domain.URLHandlerImpl uRLHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerImpl()).getLocation();
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) IncomingURL is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenURLHandlerImplIncomingURLIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setIncomingURL("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", urlHandlerImpl.getLocation());
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenURLHandlerImplUrlRedirectTypeIsForward() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);
    urlHandlerImpl.setIncomingURL(".");
    urlHandlerImpl.setRegexHandler(true);

    // Act and Assert
    assertEquals("https://example.org/example", urlHandlerImpl.getLocation());
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation_givenURLHandlerImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new URLHandlerImpl()).getLocation());
  }

  /**
   * Test {@link URLHandlerImpl#getLocation()}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#getLocation()}
   */
  @Test
  public void testGetLocation_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setUrlRedirectType(redirectType);
    urlHandlerImpl.setIncomingURL(".");
    urlHandlerImpl.setRegexHandler(true);

    // Act
    String actualLocation = urlHandlerImpl.getLocation();

    // Assert
    verify(redirectType).getType();
    assertEquals("https://example.org/example", actualLocation);
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHasRegExCharacters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9314 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.domain.URLHandlerImpl uRLHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerImpl()).hasRegExCharacters("https://example.org/example");
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   *   <li>When {@code *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_givenURLHandlerImplUrlRedirectTypeIsForward_whenAsterisk() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("*"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   *   <li>When {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_givenURLHandlerImplUrlRedirectTypeIsForward_whenBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("\\"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) UrlRedirectType is
   * {@link URLRedirectType#FORWARD}.</li>
   *   <li>When {@code +}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_givenURLHandlerImplUrlRedirectTypeIsForward_whenPlusSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("+"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_givenURLHandlerImpl_whenHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new URLHandlerImpl()).hasRegExCharacters("https://example.org/example"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor).</li>
   *   <li>When {@code Location}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_givenURLHandlerImpl_whenLocation_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new URLHandlerImpl()).hasRegExCharacters("Location"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(redirectType);

    // Act
    boolean actualHasRegExCharactersResult = urlHandlerImpl.hasRegExCharacters("(");

    // Assert
    verify(redirectType).getType();
    assertTrue(actualHasRegExCharactersResult);
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code ^}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenCircumflexAccent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("^"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code $}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenDollarSign() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("$"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenLeftCurlyBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("{"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenLeftParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("("));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code [}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenLeftSquareBracket() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("["));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("?"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code )}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenRightParenthesis() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters(")"));
  }

  /**
   * Test {@link URLHandlerImpl#hasRegExCharacters(String)}.
   * <ul>
   *   <li>When {@code |}.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#hasRegExCharacters(String)}
   */
  @Test
  public void testHasRegExCharacters_whenVerticalLine() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertTrue(urlHandlerImpl.hasRegExCharacters("|"));
  }

  /**
   * Test
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<URLHandler> actualCreateOrRetrieveCopyInstanceResult = urlHandlerImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.url.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml","/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9224 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.url.domain.URLHandlerImpl uRLHandlerImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    urlHandlerImpl.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link CreateResponse} {@link CreateResponse#getClone()} return
   * {@link NullURLHandler#NullURLHandler()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenCreateResponseGetCloneReturnNullURLHandler()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new NullURLHandler());
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    urlHandlerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link URLHandlerImpl} (default constructor) Id is one.</li>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenURLHandlerImplIdIsOne_thenCallsGetType()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setUrlRedirectType(redirectType);

    URLHandlerImpl urlHandlerImpl2 = new URLHandlerImpl();
    urlHandlerImpl2.setId(1L);
    urlHandlerImpl2.setIncomingURL("https://example.org/example");
    urlHandlerImpl2.setNewURL("https://example.org/example");
    urlHandlerImpl2.setRegexHandler(true);
    urlHandlerImpl2.setUrlRedirectType(URLRedirectType.FORWARD);
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(urlHandlerImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    urlHandlerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(redirectType).getType();
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link URLRedirectType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetType() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setUrlRedirectType(redirectType);
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new NullURLHandler());
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    urlHandlerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(redirectType).getType();
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}, and
   * {@link URLHandlerImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link URLHandlerImpl#equals(Object)}
   *   <li>{@link URLHandlerImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    URLHandlerImpl urlHandlerImpl2 = new URLHandlerImpl();
    urlHandlerImpl2.setId(1L);
    urlHandlerImpl2.setIncomingURL("https://example.org/example");
    urlHandlerImpl2.setNewURL("https://example.org/example");
    urlHandlerImpl2.setRegexHandler(true);
    urlHandlerImpl2.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertEquals(urlHandlerImpl, urlHandlerImpl2);
    int expectedHashCodeResult = urlHandlerImpl.hashCode();
    assertEquals(expectedHashCodeResult, urlHandlerImpl2.hashCode());
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}, and
   * {@link URLHandlerImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link URLHandlerImpl#equals(Object)}
   *   <li>{@link URLHandlerImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertEquals(urlHandlerImpl, urlHandlerImpl);
    int expectedHashCodeResult = urlHandlerImpl.hashCode();
    assertEquals(expectedHashCodeResult, urlHandlerImpl.hashCode());
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(2L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    URLHandlerImpl urlHandlerImpl2 = new URLHandlerImpl();
    urlHandlerImpl2.setId(1L);
    urlHandlerImpl2.setIncomingURL("https://example.org/example");
    urlHandlerImpl2.setNewURL("https://example.org/example");
    urlHandlerImpl2.setRegexHandler(true);
    urlHandlerImpl2.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertNotEquals(urlHandlerImpl, urlHandlerImpl2);
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(redirectType);

    URLHandlerImpl urlHandlerImpl2 = new URLHandlerImpl();
    urlHandlerImpl2.setId(1L);
    urlHandlerImpl2.setIncomingURL("https://example.org/example");
    urlHandlerImpl2.setNewURL("https://example.org/example");
    urlHandlerImpl2.setRegexHandler(true);
    urlHandlerImpl2.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertNotEquals(urlHandlerImpl, urlHandlerImpl2);
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertNotEquals(urlHandlerImpl, null);
  }

  /**
   * Test {@link URLHandlerImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    URLHandlerImpl urlHandlerImpl = new URLHandlerImpl();
    urlHandlerImpl.setId(1L);
    urlHandlerImpl.setIncomingURL("https://example.org/example");
    urlHandlerImpl.setNewURL("https://example.org/example");
    urlHandlerImpl.setRegexHandler(true);
    urlHandlerImpl.setUrlRedirectType(URLRedirectType.FORWARD);

    // Act and Assert
    assertNotEquals(urlHandlerImpl, "Different type to URLHandlerImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link URLHandlerImpl}
   *   <li>{@link URLHandlerImpl#setId(Long)}
   *   <li>{@link URLHandlerImpl#setIncomingURL(String)}
   *   <li>{@link URLHandlerImpl#setNewURL(String)}
   *   <li>{@link URLHandlerImpl#getId()}
   *   <li>{@link URLHandlerImpl#getIncomingURL()}
   *   <li>{@link URLHandlerImpl#getNewURL()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    URLHandlerImpl actualUrlHandlerImpl = new URLHandlerImpl();
    actualUrlHandlerImpl.setId(1L);
    actualUrlHandlerImpl.setIncomingURL("https://example.org/example");
    actualUrlHandlerImpl.setNewURL("https://example.org/example");
    Long actualId = actualUrlHandlerImpl.getId();
    String actualIncomingURL = actualUrlHandlerImpl.getIncomingURL();

    // Assert that nothing has changed
    assertEquals("https://example.org/example", actualIncomingURL);
    assertEquals("https://example.org/example", actualUrlHandlerImpl.getNewURL());
    assertEquals(1L, actualId.longValue());
  }
}
