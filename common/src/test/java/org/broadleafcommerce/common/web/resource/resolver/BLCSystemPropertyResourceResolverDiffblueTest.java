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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolverChain;

@RunWith(MockitoJUnitRunner.class)
public class BLCSystemPropertyResourceResolverDiffblueTest {
  @InjectMocks
  private BLCSystemPropertyResourceResolver bLCSystemPropertyResourceResolver;

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String BLCSystemPropertyResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"})
  public void testResolveUrlPathInternal_givenGeneratedResource() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(bLCSystemPropertyResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String BLCSystemPropertyResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"})
  public void testResolveUrlPathInternal_givenGeneratedResource2() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(bLCSystemPropertyResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String BLCSystemPropertyResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"})
  public void testResolveUrlPathInternal_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(bLCSystemPropertyResourceResolver.resolveUrlPathInternal("https://example.org/example", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    ClassPathResource classPathResource = new ClassPathResource("BLC-system-property.js");
    when(chain.resolveResource(Mockito.<HttpServletRequest>any(), Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn(classPathResource);

    // Act
    Resource actualResolveResourceInternalResult = bLCSystemPropertyResourceResolver.resolveResourceInternal(request,
        "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain).resolveResource(isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertSame(classPathResource, actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return Description is {@code BLC-system-property.js}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_givenA_thenReturnDescriptionIsBlcSystemPropertyJs() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    when(chain.resolveResource(Mockito.<HttpServletRequest>any(), Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn(new ByteArrayResource(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}));

    // Act
    Resource actualResolveResourceInternalResult = bLCSystemPropertyResourceResolver.resolveResourceInternal(request,
        "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain).resolveResource(isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertTrue(actualResolveResourceInternalResult instanceof GeneratedResource);
    assertEquals("BLC-system-property.js", actualResolveResourceInternalResult.getDescription());
    assertEquals("BLC-system-property.js", actualResolveResourceInternalResult.getFilename());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualResolveResourceInternalResult.getInputStream().read(byteArray));
    assertFalse(actualResolveResourceInternalResult.isFile());
    assertArrayEquals(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3},
        ((GeneratedResource) actualResolveResourceInternalResult).getBytes());
    assertArrayEquals(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3}, byteArray);
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_thenReturnGeneratedResource() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();
    BroadleafDefaultResourceResolverChain chain = mock(BroadleafDefaultResourceResolverChain.class);
    GeneratedResource generatedResource = new GeneratedResource();
    when(chain.resolveResource(Mockito.<HttpServletRequest>any(), Mockito.<String>any(), Mockito.<List<Resource>>any()))
        .thenReturn(generatedResource);

    // Act
    Resource actualResolveResourceInternalResult = bLCSystemPropertyResourceResolver.resolveResourceInternal(request,
        "BLC-system-property.js", locations, chain);

    // Assert
    verify(chain).resolveResource(isA(HttpServletRequest.class), eq("BLC-system-property.js"), isA(List.class));
    assertTrue(actualResolveResourceInternalResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_whenArrayListAddGeneratedResource_thenReturnNull() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(bLCSystemPropertyResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_whenArrayListAddGeneratedResource_thenReturnNull2() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(bLCSystemPropertyResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}.
   * <ul>
   *   <li>When {@code Request Path}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BLCSystemPropertyResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"})
  public void testResolveResourceInternal_whenRequestPath_thenReturnNull() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(bLCSystemPropertyResourceResolver.resolveResourceInternal(request, "Request Path", locations,
        new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Description is {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Resource BLCSystemPropertyResourceResolver.convertResource(Resource, String)"})
  public void testConvertResource_whenA_thenReturnDescriptionIsFooTxt() throws IOException {
    // Arrange and Act
    Resource actualConvertResourceResult = bLCSystemPropertyResourceResolver
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
   * Test {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}.
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCSystemPropertyResourceResolver#convertResource(Resource, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Resource BLCSystemPropertyResourceResolver.convertResource(Resource, String)"})
  public void testConvertResource_whenGeneratedResource_thenReturnGeneratedResource() throws IOException {
    // Arrange
    GeneratedResource origResource = new GeneratedResource();

    // Act
    Resource actualConvertResourceResult = bLCSystemPropertyResourceResolver.convertResource(origResource, "foo.txt");

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
   * Method under test: {@link BLCSystemPropertyResourceResolver#addVersion(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCSystemPropertyResourceResolver.addVersion(String, String)"})
  public void testAddVersion_whenRequestPath_thenReturnRequestPath102Null() {
    // Arrange, Act and Assert
    assertEquals("Request Path1.0.2.null", bLCSystemPropertyResourceResolver.addVersion("Request Path", "1.0.2"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int BLCSystemPropertyResourceResolver.getOrder()",
      "void BLCSystemPropertyResourceResolver.setOrder(int)"})
  public void testGettersAndSetters() {
    // Arrange
    BLCSystemPropertyResourceResolver blcSystemPropertyResourceResolver = new BLCSystemPropertyResourceResolver();

    // Act
    blcSystemPropertyResourceResolver.setOrder(1);

    // Assert
    assertEquals(1, blcSystemPropertyResourceResolver.getOrder());
  }
}
