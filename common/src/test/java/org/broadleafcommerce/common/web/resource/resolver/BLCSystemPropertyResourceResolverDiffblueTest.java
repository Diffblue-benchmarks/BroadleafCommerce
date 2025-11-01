/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolverChain;

public class BLCSystemPropertyResourceResolverDiffblueTest {
  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcSystemPropertyResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcSystemPropertyResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcSystemPropertyResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveUrlPath(Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn("https://example.org/example");

    // Act
    String actualResolveUrlPathInternalResult = blcSystemPropertyResourceResolver
        .resolveUrlPathInternal("https://example.org/example", locations, chain);

    // Assert
    verify(chain).resolveUrlPath(eq("https://example.org/example"), isA(List.class));
    assertEquals("https://example.org/example", actualResolveUrlPathInternalResult);
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcSystemPropertyResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcSystemPropertyResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcSystemPropertyResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(blcSystemPropertyResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    GeneratedResource generatedResource = new GeneratedResource();
    when(chain.resolveResource(Mockito.<HttpServletRequest>any(), Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn(generatedResource);

    // Act
    Resource actualResolveResourceInternalResult = blcSystemPropertyResourceResolver.resolveResourceInternal(request,
        "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain).resolveResource(isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertTrue(actualResolveResourceInternalResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualResolveResourceInternalResult);
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal6() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveResource(Mockito.<HttpServletRequest>any(), Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn(new ByteArrayResource(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}));

    // Act
    Resource actualResolveResourceInternalResult = blcSystemPropertyResourceResolver.resolveResourceInternal(request,
        "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain).resolveResource(isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertTrue(actualResolveResourceInternalResult instanceof GeneratedResource);
    assertEquals("BLC-system-property.js", actualResolveResourceInternalResult.getDescription());
    assertEquals("BLC-system-property.js", actualResolveResourceInternalResult.getFilename());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualResolveResourceInternalResult.getInputStream().read(byteArray));
    assertFalse(actualResolveResourceInternalResult.isFile());
    assertFalse(actualResolveResourceInternalResult.isOpen());
    assertArrayEquals(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        ((GeneratedResource) actualResolveResourceInternalResult).getBytes());
    assertArrayEquals(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, byteArray);
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    ClassPathResource classPathResource = new ClassPathResource("BLC-system-property.js");
    when(chain.resolveResource(Mockito.<HttpServletRequest>any(), Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn(classPathResource);

    // Act
    Resource actualResolveResourceInternalResult = blcSystemPropertyResourceResolver.resolveResourceInternal(request,
        "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain).resolveResource(isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertSame(classPathResource, actualResolveResourceInternalResult);
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}
   */
  @Test
  public void testConvertResource() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    GeneratedResource origResource = new GeneratedResource();

    // Act
    Resource actualConvertResourceResult = blcSystemPropertyResourceResolver.convertResource(origResource, "foo.txt");

    // Assert
    assertTrue(actualConvertResourceResult instanceof GeneratedResource);
    assertEquals(origResource, actualConvertResourceResult);
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}
   */
  @Test
  public void testConvertResource2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();

    // Act
    Resource actualConvertResourceResult = blcSystemPropertyResourceResolver
        .convertResource(new ByteArrayResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "foo.txt");

    // Assert
    assertTrue(actualConvertResourceResult instanceof GeneratedResource);
    assertEquals("foo.txt", actualConvertResourceResult.getDescription());
    assertEquals("foo.txt", actualConvertResourceResult.getFilename());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualConvertResourceResult.getInputStream().read(byteArray));
    assertFalse(actualConvertResourceResult.isFile());
    assertFalse(actualConvertResourceResult.isOpen());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        ((GeneratedResource) actualConvertResourceResult).getBytes());
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, byteArray);
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}
   */
  @Test
  public void testConvertResource3() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    ByteArrayResource origResource = mock(ByteArrayResource.class);
    when(origResource.getInputStream()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    Resource actualConvertResourceResult = blcSystemPropertyResourceResolver.convertResource(origResource, "foo.txt");

    // Assert
    verify(origResource).getInputStream();
    assertTrue(actualConvertResourceResult instanceof GeneratedResource);
    assertEquals("foo.txt", actualConvertResourceResult.getDescription());
    assertEquals("foo.txt", actualConvertResourceResult.getFilename());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualConvertResourceResult.getInputStream().read(byteArray));
    assertFalse(actualConvertResourceResult.isFile());
    assertFalse(actualConvertResourceResult.isOpen());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((GeneratedResource) actualConvertResourceResult).getBytes());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#addVersion(String, String)}
   */
  @Test
  public void testAddVersion() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Request Path1.0.2.null",
        (new BLCSystemPropertyResourceResolver()).addVersion("Request Path", "1.0.2"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BLCSystemPropertyResourceResolver#setOrder(int)}
   *   <li>{@link BLCSystemPropertyResourceResolver#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();

    // Act
    blcSystemPropertyResourceResolver.setOrder(1);

    // Assert that nothing has changed
    assertEquals(1, blcSystemPropertyResourceResolver.getOrder());
  }
}
