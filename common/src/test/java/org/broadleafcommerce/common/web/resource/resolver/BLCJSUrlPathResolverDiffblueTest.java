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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.springframework.web.servlet.resource.ResourceResolverChain;

public class BLCJSUrlPathResolverDiffblueTest {
  /**
   * Test
   * {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_givenGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcjsUrlPathResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_givenGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcjsUrlPathResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveUrlPath(Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualResolveUrlPathInternalResult = blcjsUrlPathResolver
        .resolveUrlPathInternal("https://example.org/example", locations, chain);

    // Assert
    verify(chain).resolveUrlPath(eq("https://example.org/example"), isA(List.class));
    assertEquals("https://example.org/example", actualResolveUrlPathInternalResult);
  }

  /**
   * Test
   * {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code BLC.js}.</li>
   *   <li>Then return {@code BLC.js}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_whenBlcJs_thenReturnBlcJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertEquals("BLC.js", blcjsUrlPathResolver.resolveUrlPathInternal("BLC.js", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSUrlPathResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_whenHttpsExampleOrgExample_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcjsUrlPathResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <p>
   * Method under test:
   * {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcjsUrlPathResolver.resolveResourceInternal(request, "https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_givenGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcjsUrlPathResolver.resolveResourceInternal(request, "https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_givenGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcjsUrlPathResolver.resolveResourceInternal(request, "https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCJSUrlPathResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcjsUrlPathResolver.resolveResourceInternal(request, "https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSUrlPathResolver#addVersion(String, String)}.
   * <ul>
   *   <li>Then return
   * {@code https://example.org/examplehttps://example.org/example.null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCJSUrlPathResolver#addVersion(String, String)}
   */
  @Test
  public void testAddVersion_thenReturnHttpsExampleOrgExamplehttpsExampleOrgExampleNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/examplehttps://example.org/example.null",
        (new BLCJSUrlPathResolver()).addVersion("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BLCJSUrlPathResolver#setOrder(int)}
   *   <li>{@link BLCJSUrlPathResolver#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BLCJSUrlPathResolver blcjsUrlPathResolver = new BLCJSUrlPathResolver();

    // Act
    blcjsUrlPathResolver.setOrder(1);

    // Assert that nothing has changed
    assertEquals(1, blcjsUrlPathResolver.getOrder());
  }
}
