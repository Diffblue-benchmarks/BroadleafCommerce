/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolverChain;

public class RuleBuilderOptionsResourceResolverDiffblueTest {
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
