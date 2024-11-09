/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web.resource.resolver;

import static org.junit.Assert.assertEquals;
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
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

public class BLCJSResourceResolverDiffblueTest {
  /**
   * Test
   * {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_givenGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_givenGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveUrlPath(Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualResolveUrlPathInternalResult = blcjsResourceResolver
        .resolveUrlPathInternal("https://example.org/example", locations, chain);

    // Assert
    verify(chain).resolveUrlPath(eq("https://example.org/example"), isA(List.class));
    assertEquals("https://example.org/example", actualResolveUrlPathInternalResult);
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCJSResourceResolver}
   * (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_whenArrayListAddBLCJSResourceResolver_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BLCJSResourceResolver());

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_givenGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_givenGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCJSResourceResolver}
   * (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_whenArrayListAddBLCJSResourceResolver_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BLCJSResourceResolver());

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code BLC}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_whenBlc_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveResourceInternal(request, "BLC", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveResourceInternal(request, null, locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code Request Path}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_whenRequestPath_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcjsResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSResourceResolver#convertResource(Resource, String)}.
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>Then return {@link GeneratedResource}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSResourceResolver#convertResource(Resource, String)}
   */
  @Test
  public void testConvertResource_whenGeneratedResource_thenReturnGeneratedResource() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    GeneratedResource origResource = new GeneratedResource();

    // Act
    Resource actualConvertResourceResult = blcjsResourceResolver.convertResource(origResource, "foo.txt");

    // Assert
    assertTrue(actualConvertResourceResult instanceof GeneratedResource);
    assertEquals(origResource, actualConvertResourceResult);
  }

  /**
   * Test {@link BLCJSResourceResolver#addVersion(String, String)}.
   * <ul>
   *   <li>When {@code Request Path}.</li>
   *   <li>Then return {@code Request Path1.0.2.null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCJSResourceResolver#addVersion(String, String)}
   */
  @Test
  public void testAddVersion_whenRequestPath_thenReturnRequestPath102Null() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Request Path1.0.2.null", (new BLCJSResourceResolver()).addVersion("Request Path", "1.0.2"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BLCJSResourceResolver#setOrder(int)}
   *   <li>{@link BLCJSResourceResolver#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();

    // Act
    blcjsResourceResolver.setOrder(1);

    // Assert that nothing has changed
    assertEquals(1, blcjsResourceResolver.getOrder());
  }
}
