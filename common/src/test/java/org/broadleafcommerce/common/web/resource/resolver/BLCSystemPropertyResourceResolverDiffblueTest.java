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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
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
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_givenGeneratedResource() {
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
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_givenGeneratedResource2() {
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
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_thenReturnHttpsExampleOrgExample() {
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
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveUrlPathInternal_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(blcSystemPropertyResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal() {
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
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal2() {
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
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return InputStream read is eight.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_givenA_thenReturnInputStreamReadIsEight() throws IOException {
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
    byte[] byteArray = new byte[8];
    assertEquals(8, actualResolveResourceInternalResult.getInputStream().read(byteArray));
    assertArrayEquals(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        ((GeneratedResource) actualResolveResourceInternalResult).getBytes());
    assertArrayEquals(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, byteArray);
  }

  /**
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_thenReturnGeneratedResource() {
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
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_whenArrayListAddGeneratedResource() {
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
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_whenArrayListAddGeneratedResource2() {
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
   * Test
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code Request Path}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  public void testResolveResourceInternal_whenRequestPath_thenReturnNull() {
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
   * Test
   * {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}.
   * <ul>
   *   <li>Then return second element is {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}
   */
  @Test
  public void testConvertResource_thenReturnSecondElementIsX() throws IOException {
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
    byte[] byteArray = new byte[8];
    assertEquals(8, actualConvertResourceResult.getInputStream().read(byteArray));
    byte[] bytes = ((GeneratedResource) actualConvertResourceResult).getBytes();
    assertEquals(8, bytes.length);
    assertEquals('X', bytes[1]);
    assertEquals('X', bytes[3]);
    assertEquals('X', bytes[5]);
    assertEquals('X', bytes[7]);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return second element is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}
   */
  @Test
  public void testConvertResource_whenA_thenReturnSecondElementIsOne() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();

    // Act
    Resource actualConvertResourceResult = blcSystemPropertyResourceResolver
        .convertResource(new ByteArrayResource(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "foo.txt");

    // Assert
    assertTrue(actualConvertResourceResult instanceof GeneratedResource);
    byte[] bytes = ((GeneratedResource) actualConvertResourceResult).getBytes();
    assertEquals((byte) 1, bytes[1]);
    assertEquals((byte) 1, bytes[3]);
    assertEquals((byte) 1, bytes[5]);
    assertEquals((byte) 1, bytes[7]);
    byte[] byteArray = new byte[8];
    assertEquals(8, actualConvertResourceResult.getInputStream().read(byteArray));
    assertEquals(8, bytes.length);
    assertArrayEquals(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, byteArray);
  }

  /**
   * Test
   * {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}.
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}
   */
  @Test
  public void testConvertResource_whenGeneratedResource_thenReturnGeneratedResource() throws IOException {
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
   * Test {@link BLCSystemPropertyResourceResolver#addVersion(String, String)}.
   * <ul>
   *   <li>When {@code Request Path}.</li>
   *   <li>Then return {@code Request Path1.0.2.null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCSystemPropertyResourceResolver#addVersion(String, String)}
   */
  @Test
  public void testAddVersion_whenRequestPath_thenReturnRequestPath102Null() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Request Path1.0.2.null",
        (new BLCSystemPropertyResourceResolver()).addVersion("Request Path", "1.0.2"));
  }

  /**
   * Test getters and setters.
   * <p>
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
