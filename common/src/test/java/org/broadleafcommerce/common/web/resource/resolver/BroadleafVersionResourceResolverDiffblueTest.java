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

public class BroadleafVersionResourceResolverDiffblueTest {
  /**
   * Test
   * {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <p>
   * Method under test:
   * {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafVersionResourceResolver broadleafVersionResourceResolver = new BroadleafVersionResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_givenGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafVersionResourceResolver broadleafVersionResourceResolver = new BroadleafVersionResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_givenGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafVersionResourceResolver broadleafVersionResourceResolver = new BroadleafVersionResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafVersionResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafVersionResourceResolver broadleafVersionResourceResolver = new BroadleafVersionResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_givenGeneratedResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafVersionResourceResolver broadleafVersionResourceResolver = new BroadleafVersionResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_givenGeneratedResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafVersionResourceResolver broadleafVersionResourceResolver = new BroadleafVersionResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafVersionResourceResolver broadleafVersionResourceResolver = new BroadleafVersionResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveUrlPath(Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualResolveUrlPathInternalResult = broadleafVersionResourceResolver
        .resolveUrlPathInternal("https://example.org/example", locations, chain);

    // Assert
    verify(chain).resolveUrlPath(eq("https://example.org/example"), isA(List.class));
    assertEquals("https://example.org/example", actualResolveUrlPathInternalResult);
  }

  /**
   * Test
   * {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafVersionResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafVersionResourceResolver broadleafVersionResourceResolver = new BroadleafVersionResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(broadleafVersionResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafVersionResourceResolver#setOrder(int)}
   *   <li>{@link BroadleafVersionResourceResolver#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafVersionResourceResolver broadleafVersionResourceResolver = new BroadleafVersionResourceResolver();

    // Act
    broadleafVersionResourceResolver.setOrder(1);

    // Assert that nothing has changed
    assertEquals(1, broadleafVersionResourceResolver.getOrder());
  }
}
