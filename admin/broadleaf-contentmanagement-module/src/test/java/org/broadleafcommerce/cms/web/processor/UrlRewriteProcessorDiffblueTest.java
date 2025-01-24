package org.broadleafcommerce.cms.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UrlRewriteProcessorDiffblueTest {
  @Autowired
  private UrlRewriteProcessor urlRewriteProcessor;

  /**
   * Test {@link UrlRewriteProcessor#getName()}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("src", (new UrlRewriteProcessor()).getName());
  }

  /**
   * Test {@link UrlRewriteProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getPrecedence()}
   */
  @Test
  public void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1000, (new UrlRewriteProcessor()).getPrecedence());
  }

  /**
   * Test {@link UrlRewriteProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getPrecedence()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPrecedence2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4157 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UrlRewriteProcessor()).getPrecedence();
  }

  /**
   * Test
   * {@link UrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetModifiedAttributes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4100 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor2 = new UrlRewriteProcessor();

    // Act
    urlRewriteProcessor2.getModifiedAttributes("https://example.org/example", new HashMap<>(),
        "https://example.org/example", "https://example.org/example", mock(BroadleafTemplateContext.class));
  }

  /**
   * Test
   * {@link UrlRewriteProcessor#getFullAssetPath(String, String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getFullAssetPath(String, String, BroadleafTemplateContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFullAssetPath() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4066 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UrlRewriteProcessor()).getFullAssetPath("https://example.org/example", "https://example.org/example",
        mock(BroadleafTemplateContext.class));
  }

  /**
   * Test {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsRequestSecure() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5115 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor2 = new UrlRewriteProcessor();

    // Act
    urlRewriteProcessor2.isRequestSecure(new MockHttpServletRequest());
  }

  /**
   * Test {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code HTTPS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  public void testIsRequestSecure_givenHttps() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getScheme()).thenReturn("HTTPS");

    // Act
    boolean actualIsRequestSecureResult = urlRewriteProcessor.isRequestSecure(request);

    // Assert
    verify(request).getScheme();
    assertTrue(actualIsRequestSecureResult);
  }

  /**
   * Test {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#isSecure()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  public void testIsRequestSecure_givenTrue_thenCallsIsSecure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.isSecure()).thenReturn(true);
    when(request.getScheme()).thenReturn("Scheme");

    // Act
    boolean actualIsRequestSecureResult = urlRewriteProcessor.isRequestSecure(request);

    // Assert
    verify(request).getScheme();
    verify(request).isSecure();
    assertTrue(actualIsRequestSecureResult);
  }

  /**
   * Test {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#isRequestSecure(HttpServletRequest)}
   */
  @Test
  public void testIsRequestSecure_whenMockHttpServletRequest_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();

    // Act and Assert
    assertFalse(urlRewriteProcessor.isRequestSecure(new MockHttpServletRequest()));
  }

  /**
   * Test {@link UrlRewriteProcessor#isImageTag(String)}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isImageTag(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsImageTag() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4797 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UrlRewriteProcessor()).isImageTag("https://example.org/example");
  }

  /**
   * Test {@link UrlRewriteProcessor#isImageTag(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isImageTag(String)}
   */
  @Test
  public void testIsImageTag_whenHttpsExampleOrgExample_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new UrlRewriteProcessor()).isImageTag("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#isImageTag(String)}.
   * <ul>
   *   <li>When {@code img}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isImageTag(String)}
   */
  @Test
  public void testIsImageTag_whenImg_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new UrlRewriteProcessor()).isImageTag("img"));
  }

  /**
   * Test {@link UrlRewriteProcessor#isAdminRequest()}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isAdminRequest()}
   */
  @Test
  public void testIsAdminRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new UrlRewriteProcessor()).isAdminRequest());
  }

  /**
   * Test {@link UrlRewriteProcessor#isAdminRequest()}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isAdminRequest()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsAdminRequest2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4477 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UrlRewriteProcessor()).isAdminRequest();
  }

  /**
   * Test {@link UrlRewriteProcessor#isImageExtension(String)}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#isImageExtension(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsImageExtension() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4479 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UrlRewriteProcessor()).isImageExtension("https://example.org/example");
  }

  /**
   * Test {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}.
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testParsePath() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5185 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UrlRewriteProcessor()).parsePath("https://example.org/example", mock(BroadleafTemplateContext.class));
  }

  /**
   * Test {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  public void testParsePath_whenHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualParsePathResult = urlRewriteProcessor.parsePath("https://example.org/example", context);

    // Assert
    verify(context).parseExpression(eq("https://example.org/example"));
    assertEquals("Parse Expression", actualParsePathResult);
  }

  /**
   * Test {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#parsePath(String, BroadleafTemplateContext)}
   */
  @Test
  public void testParsePath_whenSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UrlRewriteProcessor urlRewriteProcessor = new UrlRewriteProcessor();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    String actualParsePathResult = urlRewriteProcessor.parsePath("/", context);

    // Assert
    verify(context).parseExpression(eq("@{ / }"));
    assertEquals("Parse Expression", actualParsePathResult);
  }

  /**
   * Test {@link UrlRewriteProcessor#getFileExtension(String)}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getFileExtension(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFileExtension() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3748 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UrlRewriteProcessor()).getFileExtension("https://example.org/example");
  }

  /**
   * Test {@link UrlRewriteProcessor#getFileExtension(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getFileExtension(String)}
   */
  @Test
  public void testGetFileExtension_whenHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org/example", (new UrlRewriteProcessor()).getFileExtension("https://example.org/example"));
    assertEquals("org/example", (new UrlRewriteProcessor()).getFileExtension("https://example.org/example?"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultFileTypeImagePath() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3430 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("https://example.org/example");
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>Then return {@code /img/admin/file-unkn.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_thenReturnImgAdminFileUnknPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-unkn.png",
        (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code doc}.</li>
   *   <li>Then return {@code /img/admin/file-doc.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenDoc_thenReturnImgAdminFileDocPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-doc.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("doc"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code docx}.</li>
   *   <li>Then return {@code /img/admin/file-doc.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenDocx_thenReturnImgAdminFileDocPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-doc.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("docx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code pdf}.</li>
   *   <li>Then return {@code /img/admin/file-pdf.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenPdf_thenReturnImgAdminFilePdfPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-pdf.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("pdf"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code ppt}.</li>
   *   <li>Then return {@code /img/admin/file-ppt.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenPpt_thenReturnImgAdminFilePptPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-ppt.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("ppt"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code pptx}.</li>
   *   <li>Then return {@code /img/admin/file-ppt.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenPptx_thenReturnImgAdminFilePptPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-ppt.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("pptx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code txt}.</li>
   *   <li>Then return {@code /img/admin/file-txt.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenTxt_thenReturnImgAdminFileTxtPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-txt.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("txt"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code xls}.</li>
   *   <li>Then return {@code /img/admin/file-xls.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenXls_thenReturnImgAdminFileXlsPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-xls.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("xls"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}.
   * <ul>
   *   <li>When {@code xlsx}.</li>
   *   <li>Then return {@code /img/admin/file-xls.png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UrlRewriteProcessor#getDefaultFileTypeImagePath(String)}
   */
  @Test
  public void testGetDefaultFileTypeImagePath_whenXlsx_thenReturnImgAdminFileXlsPng() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/img/admin/file-xls.png", (new UrlRewriteProcessor()).getDefaultFileTypeImagePath("xlsx"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getQueryString(String)}.
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getQueryString(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQueryString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4159 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.UrlRewriteProcessor urlRewriteProcessor;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new UrlRewriteProcessor()).getQueryString("https://example.org/example");
  }

  /**
   * Test {@link UrlRewriteProcessor#getQueryString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getQueryString(String)}
   */
  @Test
  public void testGetQueryString_whenHttpsExampleOrgExample_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new UrlRewriteProcessor()).getQueryString("https://example.org/example"));
  }

  /**
   * Test {@link UrlRewriteProcessor#getQueryString(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example?}.</li>
   *   <li>Then return {@code ?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlRewriteProcessor#getQueryString(String)}
   */
  @Test
  public void testGetQueryString_whenHttpsExampleOrgExample_thenReturnQuestionMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("?", (new UrlRewriteProcessor()).getQueryString("https://example.org/example?"));
  }
}
