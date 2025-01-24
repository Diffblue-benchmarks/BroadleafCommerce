package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.cms.page.service.PageService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.DefaultCorsProcessor;

@ContextConfiguration(classes = {PageHandlerMapping.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PageHandlerMappingDiffblueTest {
  @MockBean
  private Environment environment;

  @Autowired
  private PageHandlerMapping pageHandlerMapping;

  @MockBean
  private PageService pageService;

  /**
   * Test {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  public void testGetHandlerInternal() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageHandlerMapping pageHandlerMapping = new PageHandlerMapping();
    pageHandlerMapping.setCorsConfigurationSource(mock(CorsConfigurationSource.class));

    // Act and Assert
    assertNull(pageHandlerMapping.getHandlerInternal(new MockHttpServletRequest()));
  }

  /**
   * Test {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetHandlerInternal2() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.web.PageHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass372 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.PageHandlerMapping pageHandlerMapping;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.page.service.PageService pageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    pageHandlerMapping.getHandlerInternal(new MockHttpServletRequest());
  }

  /**
   * Test {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link PageHandlerMapping} (default constructor).</li>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  public void testGetHandlerInternal_givenPageHandlerMapping_whenMockHttpServletRequest() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageHandlerMapping pageHandlerMapping = new PageHandlerMapping();

    // Act and Assert
    assertNull(pageHandlerMapping.getHandlerInternal(new MockHttpServletRequest()));
  }

  /**
   * Test {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link PageHandlerMapping} (default constructor).</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  public void testGetHandlerInternal_givenPageHandlerMapping_whenNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PageHandlerMapping()).getHandlerInternal(null));
  }

  /**
   * Test new {@link PageHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PageHandlerMapping}
   */
  @Test
  public void testNewPageHandlerMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    PageHandlerMapping actualPageHandlerMapping = new PageHandlerMapping();

    // Assert
    assertTrue(actualPageHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualPageHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertNull(actualPageHandlerMapping.getDefaultHandler());
    assertNull(actualPageHandlerMapping.getControllerName());
    assertNull(actualPageHandlerMapping.charEncoding);
    assertNull(actualPageHandlerMapping.getCorsConfigurationSource());
    assertNull(actualPageHandlerMapping.getPatternParser());
    assertTrue(actualPageHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualPageHandlerMapping.getOrder());
  }

  /**
   * Test new {@link PageHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PageHandlerMapping}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewPageHandlerMapping2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.cms.web.PageHandlerMapping.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass371 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.springframework.core.env.Environment environment;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.PageHandlerMapping pageHandlerMapping;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.cms.page.service.PageService pageService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new PageHandlerMapping();
  }
}
