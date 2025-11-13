package org.broadleafcommerce.common.web.resource.resolver;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.broadleafcommerce.common.resource.GeneratedResource;
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
import org.springframework.web.servlet.resource.CachingResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

@RunWith(MockitoJUnitRunner.class)
public class BLCJSResourceResolverDiffblueTest {
  @InjectMocks private BLCJSResourceResolver bLCJSResourceResolver;

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
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        blcjsResourceResolver.resolveUrlPathInternal(
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
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        blcjsResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
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
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        blcjsResourceResolver.resolveUrlPathInternal(
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
  public void testResolveResourceInternal_givenBLCJSResourceResolver_whenBlc_thenReturnNull() {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        blcjsResourceResolver.resolveResourceInternal(
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
   *   <li>Given {@link BLCJSResourceResolver} (default constructor).
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
  public void testResolveResourceInternal_givenBLCJSResourceResolver_whenBlc_thenReturnNull2() {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BLCJSResourceResolver());

    // Act and Assert
    assertNull(
        blcjsResourceResolver.resolveResourceInternal(
            request, "BLC", locations, new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link BLCJSResourceResolver} (default constructor).
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
  public void testResolveResourceInternal_givenBLCJSResourceResolver_whenNull_thenReturnNull() {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        blcjsResourceResolver.resolveResourceInternal(
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
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        blcjsResourceResolver.resolveResourceInternal(
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
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act and Assert
    assertNull(
        blcjsResourceResolver.resolveResourceInternal(
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
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
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
  public void testResolveResourceInternal_givenNull_whenArrayListAddNull() throws IOException {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    Resource resource = mock(Resource.class);
    when(resource.getInputStream()).thenThrow(new IOException());

    CachingResourceResolver cachingResourceResolver = mock(CachingResourceResolver.class);
    when(cachingResourceResolver.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any(),
            Mockito.<ResourceResolverChain>any()))
        .thenReturn(resource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(null);
    resolvers.add(cachingResourceResolver);

    // Act
    blcjsResourceResolver.resolveResourceInternal(
        request, "UUBLCxjs", locations, new BroadleafDefaultResourceResolverChain(resolvers));

    // Assert
    verify(resource).getInputStream();
    verify(cachingResourceResolver)
        .resolveResource(
            isA(HttpServletRequest.class),
            eq("UUBLC.js"),
            isA(List.class),
            isA(ResourceResolverChain.class));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
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
  public void testResolveResourceInternal_givenNull_whenArrayListAddNull2() throws IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    Resource resource = mock(Resource.class);
    when(resource.getInputStream()).thenThrow(new IOException());

    CachingResourceResolver cachingResourceResolver = mock(CachingResourceResolver.class);
    when(cachingResourceResolver.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any(),
            Mockito.<ResourceResolverChain>any()))
        .thenReturn(resource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(null);
    resolvers.add(new BLCJSResourceResolver());
    resolvers.add(cachingResourceResolver);

    // Act
    bLCJSResourceResolver.resolveResourceInternal(
        request, "UUBLCxjs", locations, new BroadleafDefaultResourceResolverChain(resolvers));

    // Assert
    verify(resource, atLeast(1)).getInputStream();
    verify(cachingResourceResolver)
        .resolveResource(
            isA(HttpServletRequest.class),
            eq("BLC.js"),
            isA(List.class),
            isA(ResourceResolverChain.class));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then calls {@link Resource#getInputStream()}.
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
  public void testResolveResourceInternal_thenCallsGetInputStream() throws IOException {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    Resource resource = mock(Resource.class);
    when(resource.getInputStream()).thenThrow(new IOException());

    CachingResourceResolver cachingResourceResolver = mock(CachingResourceResolver.class);
    when(cachingResourceResolver.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any(),
            Mockito.<ResourceResolverChain>any()))
        .thenReturn(resource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(cachingResourceResolver);

    // Act
    blcjsResourceResolver.resolveResourceInternal(
        request, "UUBLCxjs", locations, new BroadleafDefaultResourceResolverChain(resolvers));

    // Assert
    verify(resource).getInputStream();
    verify(cachingResourceResolver)
        .resolveResource(
            isA(HttpServletRequest.class),
            eq("BLC.js"),
            isA(List.class),
            isA(ResourceResolverChain.class));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then calls {@link Resource#getInputStream()}.
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
  public void testResolveResourceInternal_thenCallsGetInputStream2() throws IOException {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    Resource resource = mock(Resource.class);
    when(resource.getInputStream()).thenThrow(new IOException());

    CachingResourceResolver cachingResourceResolver = mock(CachingResourceResolver.class);
    when(cachingResourceResolver.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any(),
            Mockito.<ResourceResolverChain>any()))
        .thenReturn(resource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BLCJSResourceResolver());
    resolvers.add(cachingResourceResolver);

    // Act
    blcjsResourceResolver.resolveResourceInternal(
        request, "UUBLCxjs", locations, new BroadleafDefaultResourceResolverChain(resolvers));

    // Assert
    verify(resource, atLeast(1)).getInputStream();
    verify(cachingResourceResolver)
        .resolveResource(
            isA(HttpServletRequest.class),
            eq("BLC.js"),
            isA(List.class),
            isA(ResourceResolverChain.class));
  }

  /**
   * Test {@link BLCJSResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then return {@link GeneratedResource}.
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
  public void testResolveResourceInternal_thenReturnGeneratedResource() {
    // Arrange
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    CachingResourceResolver cachingResourceResolver = mock(CachingResourceResolver.class);
    GeneratedResource generatedResource = new GeneratedResource();
    when(cachingResourceResolver.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any(),
            Mockito.<ResourceResolverChain>any()))
        .thenReturn(generatedResource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(cachingResourceResolver);

    // Act
    Resource actualResolveResourceInternalResult =
        blcjsResourceResolver.resolveResourceInternal(
            request, "UUBLCxjs", locations, new BroadleafDefaultResourceResolverChain(resolvers));

    // Assert
    verify(cachingResourceResolver)
        .resolveResource(
            isA(HttpServletRequest.class),
            eq("BLC.js"),
            isA(List.class),
            isA(ResourceResolverChain.class));
    assertTrue(actualResolveResourceInternalResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualResolveResourceInternalResult);
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
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        blcjsResourceResolver.resolveResourceInternal(
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
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    ByteArrayResource origResource = new ByteArrayResource(new byte[] {});

    // Act
    Resource actualConvertResourceResult =
        blcjsResourceResolver.convertResource(origResource, "foo.txt");

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
    BLCJSResourceResolver blcjsResourceResolver = new BLCJSResourceResolver();
    GeneratedResource origResource = new GeneratedResource();

    // Act
    Resource actualConvertResourceResult =
        blcjsResourceResolver.convertResource(origResource, "foo.txt");

    // Assert
    assertTrue(actualConvertResourceResult instanceof GeneratedResource);
    assertEquals(origResource, actualConvertResourceResult);
  }

  /**
   * Test {@link BLCJSResourceResolver#addVersion(String, String)}.
   *
   * <ul>
   *   <li>Given {@link BLCJSResourceResolver} (default constructor).
   *   <li>Then return {@code Request Path1.0.2.null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCJSResourceResolver#addVersion(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCJSResourceResolver.addVersion(String, String)"})
  public void testAddVersion_givenBLCJSResourceResolver_thenReturnRequestPath102Null() {
    // Arrange, Act and Assert
    assertEquals(
        "Request Path1.0.2.null", new BLCJSResourceResolver().addVersion("Request Path", "1.0.2"));
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
