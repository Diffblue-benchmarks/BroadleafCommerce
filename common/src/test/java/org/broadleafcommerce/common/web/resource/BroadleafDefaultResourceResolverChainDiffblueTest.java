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
package org.broadleafcommerce.common.web.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

@ContextConfiguration(classes = {BroadleafDefaultResourceResolverChain.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BroadleafDefaultResourceResolverChainDiffblueTest {
  @Autowired
  private BroadleafDefaultResourceResolverChain broadleafDefaultResourceResolverChain;

  @Autowired
  private List<ResourceResolver> list;

  @MockBean
  private ResourceResolver resourceResolver;

  /**
   * Test {@link BroadleafDefaultResourceResolverChain#resolveResource(HttpServletRequest, String, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BLCJSResourceResolver} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafDefaultResourceResolverChain#resolveResource(HttpServletRequest, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BroadleafDefaultResourceResolverChain.resolveResource(HttpServletRequest, String, List)"})
  public void testResolveResource_givenArrayListAddBLCJSResourceResolver_thenReturnNull() {
    // Arrange
    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BLCJSResourceResolver());
    BroadleafDefaultResourceResolverChain broadleafDefaultResourceResolverChain = new BroadleafDefaultResourceResolverChain(
        resolvers);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act and Assert
    assertNull(broadleafDefaultResourceResolverChain.resolveResource(request, "Request Path", new ArrayList<>()));
  }

  /**
   * Test {@link BroadleafDefaultResourceResolverChain#resolveResource(HttpServletRequest, String, List)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafDefaultResourceResolverChain#resolveResource(HttpServletRequest, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BroadleafDefaultResourceResolverChain.resolveResource(HttpServletRequest, String, List)"})
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    when(resourceResolver.resolveResource(Mockito.<HttpServletRequest>any(), Mockito.<String>any(),
        Mockito.<List<Resource>>any(), Mockito.<ResourceResolverChain>any())).thenReturn(generatedResource);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act
    Resource actualResolveResourceResult = broadleafDefaultResourceResolverChain.resolveResource(request,
        "Request Path", locations);

    // Assert
    verify(resourceResolver).resolveResource(isA(HttpServletRequest.class), eq("Request Path"), isA(List.class),
        isA(ResourceResolverChain.class));
    assertSame(generatedResource, actualResolveResourceResult);
  }

  /**
   * Test {@link BroadleafDefaultResourceResolverChain#resolveResource(HttpServletRequest, String, List)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafDefaultResourceResolverChain#resolveResource(HttpServletRequest, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BroadleafDefaultResourceResolverChain.resolveResource(HttpServletRequest, String, List)"})
  public void testResolveResource_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    when(resourceResolver.resolveResource(Mockito.<HttpServletRequest>any(), Mockito.<String>any(),
        Mockito.<List<Resource>>any(), Mockito.<ResourceResolverChain>any())).thenReturn(generatedResource);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act
    Resource actualResolveResourceResult = broadleafDefaultResourceResolverChain.resolveResource(request,
        "Request Path", locations);

    // Assert
    verify(resourceResolver).resolveResource(isA(HttpServletRequest.class), eq("Request Path"), isA(List.class),
        isA(ResourceResolverChain.class));
    assertSame(generatedResource, actualResolveResourceResult);
  }

  /**
   * Test {@link BroadleafDefaultResourceResolverChain#resolveResource(HttpServletRequest, String, List)}.
   * <ul>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafDefaultResourceResolverChain#resolveResource(HttpServletRequest, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BroadleafDefaultResourceResolverChain.resolveResource(HttpServletRequest, String, List)"})
  public void testResolveResource_thenReturnGeneratedResource() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    when(resourceResolver.resolveResource(Mockito.<HttpServletRequest>any(), Mockito.<String>any(),
        Mockito.<List<Resource>>any(), Mockito.<ResourceResolverChain>any())).thenReturn(generatedResource);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act
    Resource actualResolveResourceResult = broadleafDefaultResourceResolverChain.resolveResource(request,
        "Request Path", new ArrayList<>());

    // Assert
    verify(resourceResolver).resolveResource(isA(HttpServletRequest.class), eq("Request Path"), isA(List.class),
        isA(ResourceResolverChain.class));
    assertSame(generatedResource, actualResolveResourceResult);
  }

  /**
   * Test {@link BroadleafDefaultResourceResolverChain#resolveResource(HttpServletRequest, String, List)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafDefaultResourceResolverChain#resolveResource(HttpServletRequest, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Resource BroadleafDefaultResourceResolverChain.resolveResource(HttpServletRequest, String, List)"})
  public void testResolveResource_thenReturnNull() {
    // Arrange
    BroadleafDefaultResourceResolverChain broadleafDefaultResourceResolverChain = new BroadleafDefaultResourceResolverChain(
        new ArrayList<>());
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act and Assert
    assertNull(broadleafDefaultResourceResolverChain.resolveResource(request, "Request Path", new ArrayList<>()));
  }

  /**
   * Test {@link BroadleafDefaultResourceResolverChain#resolveUrlPath(String, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BLCJSResourceResolver} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafDefaultResourceResolverChain#resolveUrlPath(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafDefaultResourceResolverChain.resolveUrlPath(String, List)"})
  public void testResolveUrlPath_givenArrayListAddBLCJSResourceResolver_thenReturnNull() {
    // Arrange
    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BLCJSResourceResolver());
    BroadleafDefaultResourceResolverChain broadleafDefaultResourceResolverChain = new BroadleafDefaultResourceResolverChain(
        resolvers);

    // Act and Assert
    assertNull(broadleafDefaultResourceResolverChain.resolveUrlPath("https://example.org/example", new ArrayList<>()));
  }

  /**
   * Test {@link BroadleafDefaultResourceResolverChain#resolveUrlPath(String, List)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafDefaultResourceResolverChain#resolveUrlPath(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafDefaultResourceResolverChain.resolveUrlPath(String, List)"})
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource() {
    // Arrange
    when(resourceResolver.resolveUrlPath(Mockito.<String>any(), Mockito.<List<Resource>>any(),
        Mockito.<ResourceResolverChain>any())).thenReturn("https://example.org/example");

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act
    String actualResolveUrlPathResult = broadleafDefaultResourceResolverChain
        .resolveUrlPath("https://example.org/example", locations);

    // Assert
    verify(resourceResolver).resolveUrlPath(eq("https://example.org/example"), isA(List.class),
        isA(ResourceResolverChain.class));
    assertEquals("https://example.org/example", actualResolveUrlPathResult);
  }

  /**
   * Test {@link BroadleafDefaultResourceResolverChain#resolveUrlPath(String, List)}.
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link GeneratedResource#GeneratedResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafDefaultResourceResolverChain#resolveUrlPath(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafDefaultResourceResolverChain.resolveUrlPath(String, List)"})
  public void testResolveUrlPath_givenGeneratedResource_whenArrayListAddGeneratedResource2() {
    // Arrange
    when(resourceResolver.resolveUrlPath(Mockito.<String>any(), Mockito.<List<Resource>>any(),
        Mockito.<ResourceResolverChain>any())).thenReturn("https://example.org/example");

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act
    String actualResolveUrlPathResult = broadleafDefaultResourceResolverChain
        .resolveUrlPath("https://example.org/example", locations);

    // Assert
    verify(resourceResolver).resolveUrlPath(eq("https://example.org/example"), isA(List.class),
        isA(ResourceResolverChain.class));
    assertEquals("https://example.org/example", actualResolveUrlPathResult);
  }

  /**
   * Test {@link BroadleafDefaultResourceResolverChain#resolveUrlPath(String, List)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafDefaultResourceResolverChain#resolveUrlPath(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafDefaultResourceResolverChain.resolveUrlPath(String, List)"})
  public void testResolveUrlPath_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(resourceResolver.resolveUrlPath(Mockito.<String>any(), Mockito.<List<Resource>>any(),
        Mockito.<ResourceResolverChain>any())).thenReturn("https://example.org/example");

    // Act
    String actualResolveUrlPathResult = broadleafDefaultResourceResolverChain
        .resolveUrlPath("https://example.org/example", new ArrayList<>());

    // Assert
    verify(resourceResolver).resolveUrlPath(eq("https://example.org/example"), isA(List.class),
        isA(ResourceResolverChain.class));
    assertEquals("https://example.org/example", actualResolveUrlPathResult);
  }

  /**
   * Test {@link BroadleafDefaultResourceResolverChain#resolveUrlPath(String, List)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafDefaultResourceResolverChain#resolveUrlPath(String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafDefaultResourceResolverChain.resolveUrlPath(String, List)"})
  public void testResolveUrlPath_thenReturnNull() {
    // Arrange
    BroadleafDefaultResourceResolverChain broadleafDefaultResourceResolverChain = new BroadleafDefaultResourceResolverChain(
        new ArrayList<>());

    // Act and Assert
    assertNull(broadleafDefaultResourceResolverChain.resolveUrlPath("https://example.org/example", new ArrayList<>()));
  }
}
