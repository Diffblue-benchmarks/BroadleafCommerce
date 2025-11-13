package org.broadleafcommerce.common.web.resource.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.resource.service.ResourceBundlingService;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

@RunWith(MockitoJUnitRunner.class)
public class BundleResourceResolverDiffblueTest {
  @InjectMocks private BundleResourceResolver bundleResourceResolver;

  @Mock private ResourceBundlingService resourceBundlingService;

  /**
   * Test {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BundleResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    when(resourceBundlingService.resolveBundleResource(Mockito.<String>any()))
        .thenReturn(generatedResource);
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    Resource actualResolveResourceInternalResult =
        bundleResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("Request Path");
    verify(resourceBundlingService).resolveBundleResource("Request Path");
    assertSame(generatedResource, actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BundleResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal2() {
    // Arrange
    when(resourceBundlingService.resolveBundleResource(Mockito.<String>any())).thenReturn(null);
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    Resource actualResolveResourceInternalResult =
        bundleResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("Request Path");
    verify(resourceBundlingService).resolveBundleResource("Request Path");
    assertNull(actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BundleResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal3() {
    // Arrange
    when(resourceBundlingService.rebuildBundledResource(Mockito.<String>any())).thenReturn(null);
    when(resourceBundlingService.resolveBundleResource(Mockito.<String>any()))
        .thenReturn(new ClassPathResource("Path"));
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    Resource actualResolveResourceInternalResult =
        bundleResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("Request Path");
    verify(resourceBundlingService).rebuildBundledResource("Request Path");
    verify(resourceBundlingService).resolveBundleResource("Request Path");
    assertNull(actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BundleResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal4() {
    // Arrange
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(false);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    Resource actualResolveResourceInternalResult =
        bundleResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("Request Path");
    assertNull(actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link BundleResourceResolver} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BundleResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_givenBundleResourceResolver_whenNull_thenReturnNull() {
    // Arrange
    BundleResourceResolver bundleResourceResolver = new BundleResourceResolver();
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        bundleResourceResolver.resolveResourceInternal(
            request,
            null,
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BundleResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_givenGeneratedResource() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    when(resourceBundlingService.rebuildBundledResource(Mockito.<String>any()))
        .thenReturn(generatedResource);
    when(resourceBundlingService.resolveBundleResource(Mockito.<String>any()))
        .thenReturn(new ClassPathResource("Path"));
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act
    Resource actualResolveResourceInternalResult =
        bundleResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("Request Path");
    verify(resourceBundlingService).rebuildBundledResource("Request Path");
    verify(resourceBundlingService).resolveBundleResource("Request Path");
    assertSame(generatedResource, actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BundleResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_givenGeneratedResource2() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    when(resourceBundlingService.rebuildBundledResource(Mockito.<String>any()))
        .thenReturn(generatedResource);
    when(resourceBundlingService.resolveBundleResource(Mockito.<String>any()))
        .thenReturn(new ClassPathResource("Path"));
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act
    Resource actualResolveResourceInternalResult =
        bundleResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("Request Path");
    verify(resourceBundlingService).rebuildBundledResource("Request Path");
    verify(resourceBundlingService).resolveBundleResource("Request Path");
    assertSame(generatedResource, actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest, String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then return {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveResourceInternal(HttpServletRequest,
   * String, List, ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource BundleResourceResolver.resolveResourceInternal(HttpServletRequest, String, List, ResourceResolverChain)"
  })
  public void testResolveResourceInternal_thenReturnGeneratedResource() {
    // Arrange
    GeneratedResource generatedResource = new GeneratedResource();
    when(resourceBundlingService.rebuildBundledResource(Mockito.<String>any()))
        .thenReturn(generatedResource);
    when(resourceBundlingService.resolveBundleResource(Mockito.<String>any()))
        .thenReturn(new ClassPathResource("Path"));
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    Resource actualResolveResourceInternalResult =
        bundleResourceResolver.resolveResourceInternal(
            request,
            "Request Path",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("Request Path");
    verify(resourceBundlingService).rebuildBundledResource("Request Path");
    verify(resourceBundlingService).resolveBundleResource("Request Path");
    assertSame(generatedResource, actualResolveResourceInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link BundleResourceResolver} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BundleResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenBundleResourceResolver_whenNull_thenReturnNull() {
    // Arrange
    BundleResourceResolver bundleResourceResolver = new BundleResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    // Act and Assert
    assertNull(
        bundleResourceResolver.resolveUrlPathInternal(
            null, locations, new BroadleafDefaultResourceResolverChain(new ArrayList<>())));
  }

  /**
   * Test {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BundleResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenGeneratedResource() {
    // Arrange
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(true);

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act
    String actualResolveUrlPathInternalResult =
        bundleResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("https://example.org/example");
    assertEquals("https://example.org/example", actualResolveUrlPathInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Given {@link GeneratedResource#GeneratedResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BundleResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_givenGeneratedResource2() {
    // Arrange
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(true);

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act
    String actualResolveUrlPathInternalResult =
        bundleResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("https://example.org/example");
    assertEquals("https://example.org/example", actualResolveUrlPathInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BundleResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(true);
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    String actualResolveUrlPathInternalResult =
        bundleResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("https://example.org/example");
    assertEquals("https://example.org/example", actualResolveUrlPathInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BundleResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_thenReturnNull() {
    // Arrange
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(false);
    ArrayList<Resource> locations = new ArrayList<>();

    // Act
    String actualResolveUrlPathInternalResult =
        bundleResourceResolver.resolveUrlPathInternal(
            "https://example.org/example",
            locations,
            new BroadleafDefaultResourceResolverChain(new ArrayList<>()));

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("https://example.org/example");
    assertNull(actualResolveUrlPathInternalResult);
  }

  /**
   * Test {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link BundleResourceResolver} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#resolveUrlPathInternal(String, List,
   * ResourceResolverChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BundleResourceResolver.resolveUrlPathInternal(String, List, ResourceResolverChain)"
  })
  public void testResolveUrlPathInternal_whenArrayListAddBundleResourceResolver_thenReturnNull() {
    // Arrange
    BundleResourceResolver bundleResourceResolver = new BundleResourceResolver();
    ArrayList<Resource> locations = new ArrayList<>();

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BundleResourceResolver());

    // Act and Assert
    assertNull(
        bundleResourceResolver.resolveUrlPathInternal(
            null, locations, new BroadleafDefaultResourceResolverChain(resolvers)));
  }

  /**
   * Test {@link BundleResourceResolver#isBundleFile(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#isBundleFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleResourceResolver.isBundleFile(String)"})
  public void testIsBundleFile_thenReturnFalse() {
    // Arrange
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(false);

    // Act
    boolean actualIsBundleFileResult = bundleResourceResolver.isBundleFile("Request Path");

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("Request Path");
    assertFalse(actualIsBundleFileResult);
  }

  /**
   * Test {@link BundleResourceResolver#isBundleFile(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BundleResourceResolver#isBundleFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BundleResourceResolver.isBundleFile(String)"})
  public void testIsBundleFile_thenReturnTrue() {
    // Arrange
    when(resourceBundlingService.checkForRegisteredBundleFile(Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualIsBundleFileResult = bundleResourceResolver.isBundleFile("Request Path");

    // Assert
    verify(resourceBundlingService).checkForRegisteredBundleFile("Request Path");
    assertTrue(actualIsBundleFileResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleResourceResolver#setOrder(int)}
   *   <li>{@link BundleResourceResolver#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int BundleResourceResolver.getOrder()",
    "void BundleResourceResolver.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BundleResourceResolver bundleResourceResolver = new BundleResourceResolver();

    // Act
    bundleResourceResolver.setOrder(1);

    // Assert
    assertEquals(1, bundleResourceResolver.getOrder());
  }
}
