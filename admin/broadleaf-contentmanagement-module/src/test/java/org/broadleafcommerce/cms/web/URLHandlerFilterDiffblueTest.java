package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
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
public class URLHandlerFilterDiffblueTest {
  @Autowired
  private URLHandlerFilter uRLHandlerFilter;

  /**
   * Test
   * {@link URLHandlerFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link URLHandlerFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass572 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.URLHandlerFilter uRLHandlerFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    URLHandlerFilter urlHandlerFilter = new URLHandlerFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    urlHandlerFilter.doFilterInternalUnlessIgnored(request, new MockHttpServletResponse(), mock(FilterChain.class));
  }

  /**
   * Test {@link URLHandlerFilter#fixQueryString(HttpServletRequest, String)}.
   * <p>
   * Method under test:
   * {@link URLHandlerFilter#fixQueryString(HttpServletRequest, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFixQueryString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass704 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.URLHandlerFilter uRLHandlerFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    URLHandlerFilter urlHandlerFilter = new URLHandlerFilter();

    // Act
    urlHandlerFilter.fixQueryString(new MockHttpServletRequest(), "https://example.org/example");
  }

  /**
   * Test {@link URLHandlerFilter#getExistingQueryParams(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerFilter#getExistingQueryParams(String)}
   */
  @Test
  public void testGetExistingQueryParams_whenHttpsExampleOrgExample_thenReturnEmpty()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Set<String> actualExistingQueryParams = URLHandlerFilter.getExistingQueryParams("https://example.org/example");

    // Assert
    assertTrue(actualExistingQueryParams.isEmpty());
  }

  /**
   * Test {@link URLHandlerFilter#getExistingQueryParams(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example?}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link URLHandlerFilter#getExistingQueryParams(String)}
   */
  @Test
  public void testGetExistingQueryParams_whenHttpsExampleOrgExample_thenReturnSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Set<String> actualExistingQueryParams = URLHandlerFilter.getExistingQueryParams("https://example.org/example?");

    // Assert
    assertEquals(1, actualExistingQueryParams.size());
    assertTrue(actualExistingQueryParams.contains("?"));
  }

  /**
   * Test {@link URLHandlerFilter#getPreserveQueryStringOnRedirect()}.
   * <p>
   * Method under test:
   * {@link URLHandlerFilter#getPreserveQueryStringOnRedirect()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPreserveQueryStringOnRedirect() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1126 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.URLHandlerFilter uRLHandlerFilter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new URLHandlerFilter()).getPreserveQueryStringOnRedirect();
  }

  /**
   * Test {@link URLHandlerFilter#getOrder()}.
   * <p>
   * Method under test: {@link URLHandlerFilter#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1000000, (new URLHandlerFilter()).getOrder());
  }
}
