package org.broadleafcommerce.openadmin.web.rulebuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolverChain;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RuleBuilderOptionsResourceResolverDiffblueTest {
  @Autowired
  private RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver;

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver = new RuleBuilderOptionsResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveResource(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveResource2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.rulebuilder;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass22497 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.rulebuilder.RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver2 = new RuleBuilderOptionsResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    ruleBuilderOptionsResourceResolver2.resolveResource(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>()));
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver = new RuleBuilderOptionsResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveResource(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver = new RuleBuilderOptionsResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveResource(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Then return {@link GeneratedResource}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource_thenReturnGeneratedResource() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver = new RuleBuilderOptionsResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    Resource actualResolveResourceResult = ruleBuilderOptionsResourceResolver.resolveResource(request,
        "admin/components/ruleBuilder-options.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    assertTrue(actualResolveResourceResult instanceof GeneratedResource);
    assertEquals("admin/components/ruleBuilder-options.js", actualResolveResourceResult.getDescription());
    assertEquals("admin/components/ruleBuilder-options.js", actualResolveResourceResult.getFilename());
    assertEquals(-1, actualResolveResourceResult.getInputStream().read(new byte[]{}));
    assertEquals(0, ((GeneratedResource) actualResolveResourceResult).getBytes().length);
    assertFalse(actualResolveResourceResult.isFile());
    assertFalse(actualResolveResourceResult.isOpen());
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveResource(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResource_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver = new RuleBuilderOptionsResourceResolver();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveResource(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveUrlPath() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.rulebuilder;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass22616 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.rulebuilder.RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver2 = new RuleBuilderOptionsResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    ruleBuilderOptionsResourceResolver2.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>()));
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver = new RuleBuilderOptionsResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver = new RuleBuilderOptionsResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver = new RuleBuilderOptionsResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveUrlPath(Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualResolveUrlPathResult = ruleBuilderOptionsResourceResolver.resolveUrlPath("https://example.org/example",
        locations, chain);

    // Assert
    verify(chain).resolveUrlPath(eq("https://example.org/example"), isA(List.class));
    assertEquals("https://example.org/example", actualResolveUrlPathResult);
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Then return {@code admin/components/ruleBuilder-options.js}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_thenReturnAdminComponentsRuleBuilderOptionsJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver = new RuleBuilderOptionsResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertEquals("admin/components/ruleBuilder-options.js",
        ruleBuilderOptionsResourceResolver.resolveUrlPath("admin/components/ruleBuilder-options.js", locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleBuilderOptionsResourceResolver#resolveUrlPath(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPath_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleBuilderOptionsResourceResolver ruleBuilderOptionsResourceResolver = new RuleBuilderOptionsResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(ruleBuilderOptionsResourceResolver.resolveUrlPath("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }
}
