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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
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
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

@RunWith(MockitoJUnitRunner.class)
public class BLCJSResourceResolverDiffblueTest {
  @InjectMocks private BLCJSResourceResolver bLCJSResourceResolver;

  /**
   * Test {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link BLCJSResourceResolver} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCJSResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenBLCJSResourceResolver() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BLCJSResourceResolver());

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCJSResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenGeneratedResource() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCJSResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenGeneratedResource2() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link PathResourceResolver} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCJSResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenPathResourceResolver() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new PathResourceResolver());

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link PathResourceResolver} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCJSResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenPathResourceResolver2() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new PathResourceResolver());

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then calls {@link Resource#createRelative(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCJSResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_thenCallsCreateRelative() throws IOException {
    // Arrange
    Resource resource = mock(Resource.class);
    when(resource.createRelative(Mockito.<String>any())).thenReturn(new GeneratedResource());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(resource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new PathResourceResolver());

    // Act
    String actualResolveUrlPathInternalResult =
        bLCJSResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(resolvers));

    // Assert
    verify(resource).createRelative("https://example.org/example");
    assertNull(actualResolveUrlPathInternalResult);
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then calls {@link Resource#createRelative(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCJSResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_thenCallsCreateRelative2() throws IOException {
    // Arrange
    Resource resource = mock(Resource.class);
    when(resource.createRelative(Mockito.<String>any())).thenReturn(new GeneratedResource());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(resource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new PathResourceResolver());

    // Act
    String actualResolveUrlPathInternalResult =
        bLCJSResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(resolvers));

    // Assert
    verify(resource).createRelative("https://example.org/example");
    assertNull(actualResolveUrlPathInternalResult);
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List, ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BLCJSResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link BLCJSResourceResolver} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCJSResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_givenBLCJSResourceResolver() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BLCJSResourceResolver());

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCJSResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_givenGeneratedResource() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCJSResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_givenGeneratedResource2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@code BLC}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCJSResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_whenBlc_thenReturnNull() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveResourceInternal(
            request,
            "BLC",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCJSResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_whenNull_thenReturnNull() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveResourceInternal(
            request,
            null,
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@code Request Path}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BLCJSResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_whenRequestPath_thenReturnNull() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        bLCJSResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BLCJSResourceResolver#convertResource(Resource, String)}.
   *
   * <ul>
   *   <li>Then return Description is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#convertResource(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource BLCJSResourceResolver.convertResource(Resource, String)"})
  public void testConvertResource_thenReturnDescriptionIsFooTxt() throws IOException {
    // Arrange
    ByteArrayResource origResource = new ByteArrayResource(new byte[] {});

    // Act
    Resource actualConvertResourceResult =
        bLCJSResourceResolver.convertResource(origResource, "foo.txt");

    // Assert
    assertTrue(actualConvertResourceResult instanceof GeneratedResource);
    assertEquals("foo.txt", actualConvertResourceResult.getDescription());
    assertEquals("foo.txt", actualConvertResourceResult.getFilename());
    int actualReadResult = actualConvertResourceResult.getInputStream().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertFalse(actualConvertResourceResult.isFile());
    assertFalse(actualConvertResourceResult.isOpen());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualConvertResourceResult).getBytes());
  }

  /**
   * Test {@link BLCJSResourceResolver#convertResource(Resource, String)}.
   *
   * <ul>
   *   <li>When {@link GeneratedResource#GeneratedResource()}.
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#convertResource(Resource, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource BLCJSResourceResolver.convertResource(Resource, String)"})
  public void testConvertResource_whenGeneratedResource_thenReturnGeneratedResource()
      throws IOException {
    // Arrange
    GeneratedResource origResource = new GeneratedResource();

    // Act
    Resource actualConvertResourceResult =
        bLCJSResourceResolver.convertResource(origResource, "foo.txt");

    // Assert
    assertTrue(actualConvertResourceResult instanceof GeneratedResource);
    assertEquals(origResource, actualConvertResourceResult);
  }

  /**
   * Test {@link BLCJSResourceResolver#addVersion(String, String)}.
   *
   * <ul>
   *   <li>When {@code Request Path}.
   *   <li>Then return {@code Request Path1.0.2.null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#addVersion(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCJSResourceResolver.addVersion(String, String)"})
  public void testAddVersion_whenRequestPath_thenReturnRequestPath102Null() {
    // Arrange, Act and Assert
    assertEquals(
        "Request Path1.0.2.null", bLCJSResourceResolver.addVersion("Request Path", "1.0.2"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BLCJSResourceResolver#setOrder(int)}
   *   <li>{@link BLCJSResourceResolver#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int BLCJSResourceResolver.getOrder()",
    "void BLCJSResourceResolver.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();

    // Act
    blcjsResourceResolver.setOrder(1);

    // Assert
    assertEquals(1, blcjsResourceResolver.getOrder());
  }
}
