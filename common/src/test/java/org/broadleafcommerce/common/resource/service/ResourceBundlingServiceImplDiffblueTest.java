package org.broadleafcommerce.common.resource.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import de.jkeylockmanager.manager.KeyLockManager;
import de.jkeylockmanager.manager.LockCallback;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.file.service.BroadleafFileService;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.broadleafcommerce.common.web.resource.resolver.BLCJSResourceResolver;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.servlet.resource.CachingResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;
import org.springframework.web.servlet.resource.ResourceTransformer;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class ResourceBundlingServiceImplDiffblueTest {
  @Mock private ApplicationContext applicationContext;

  @Mock private BroadleafFileService broadleafFileService;

  @Mock private Environment environment;

  @Mock private KeyLockManager keyLockManager;

  @InjectMocks private ResourceBundlingServiceImpl resourceBundlingServiceImpl;

  /**
   * Test {@link ResourceBundlingServiceImpl#initializeResources(ContextRefreshedEvent)}.
   *
   * <p>Method under test: {@link
   * ResourceBundlingServiceImpl#initializeResources(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundlingServiceImpl.initializeResources(ContextRefreshedEvent)"})
  public void testInitializeResources() throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(ResourceHttpRequestHandler.class)))
        .thenReturn(new ResourceHttpRequestHandler());

    // Act
    resourceBundlingServiceImpl.initializeResources(
        new ContextRefreshedEvent(mock(ApplicationContext.class)));

    // Assert
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any(), isA(Class.class));
    ResourceHttpRequestHandler resourceHttpRequestHandler =
        resourceBundlingServiceImpl.cssResourceHandler;
    assertNull(resourceHttpRequestHandler.getVaryByRequestHeaders());
    ResourceHttpRequestHandler resourceHttpRequestHandler2 =
        resourceBundlingServiceImpl.jsResourceHandler;
    assertNull(resourceHttpRequestHandler2.getVaryByRequestHeaders());
    assertNull(resourceHttpRequestHandler.getCacheControl());
    assertNull(resourceHttpRequestHandler2.getCacheControl());
    assertNull(resourceHttpRequestHandler.getResourceHttpMessageConverter());
    assertNull(resourceHttpRequestHandler2.getResourceHttpMessageConverter());
    assertNull(resourceHttpRequestHandler.getResourceRegionHttpMessageConverter());
    assertNull(resourceHttpRequestHandler2.getResourceRegionHttpMessageConverter());
    assertNull(resourceHttpRequestHandler.getContentNegotiationManager());
    assertNull(resourceHttpRequestHandler2.getContentNegotiationManager());
    assertNull(resourceHttpRequestHandler.getUrlPathHelper());
    assertNull(resourceHttpRequestHandler2.getUrlPathHelper());
    assertEquals(-1, resourceHttpRequestHandler.getCacheSeconds());
    assertEquals(-1, resourceHttpRequestHandler2.getCacheSeconds());
    assertEquals(2, resourceHttpRequestHandler.getSupportedMethods().length);
    assertEquals(2, resourceHttpRequestHandler2.getSupportedMethods().length);
    assertFalse(resourceHttpRequestHandler.isOptimizeLocations());
    assertFalse(resourceHttpRequestHandler2.isOptimizeLocations());
    assertFalse(resourceHttpRequestHandler.isAlwaysMustRevalidate());
    assertFalse(resourceHttpRequestHandler2.isAlwaysMustRevalidate());
    assertFalse(resourceHttpRequestHandler.isRequireSession());
    assertFalse(resourceHttpRequestHandler2.isRequireSession());
    assertFalse(resourceHttpRequestHandler.isUseExpiresHeader());
    assertFalse(resourceHttpRequestHandler2.isUseExpiresHeader());
    List<Resource> locations = resourceHttpRequestHandler.getLocations();
    assertTrue(locations.isEmpty());
    List<ResourceResolver> resourceResolvers = resourceHttpRequestHandler.getResourceResolvers();
    assertTrue(resourceResolvers.isEmpty());
    List<ResourceTransformer> resourceTransformers =
        resourceHttpRequestHandler.getResourceTransformers();
    assertTrue(resourceTransformers.isEmpty());
    Map<String, MediaType> mediaTypes = resourceHttpRequestHandler.getMediaTypes();
    assertTrue(mediaTypes.isEmpty());
    assertTrue(resourceHttpRequestHandler.isUseLastModified());
    assertTrue(resourceHttpRequestHandler2.isUseLastModified());
    assertTrue(resourceHttpRequestHandler.isUseCacheControlHeader());
    assertTrue(resourceHttpRequestHandler2.isUseCacheControlHeader());
    assertTrue(resourceHttpRequestHandler.isUseCacheControlNoStore());
    assertTrue(resourceHttpRequestHandler2.isUseCacheControlNoStore());
    assertSame(locations, resourceHttpRequestHandler2.getLocations());
    assertSame(mediaTypes, resourceHttpRequestHandler2.getMediaTypes());
    assertSame(resourceResolvers, resourceHttpRequestHandler2.getResourceResolvers());
    assertSame(resourceTransformers, resourceHttpRequestHandler2.getResourceTransformers());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#initializeResources(ContextRefreshedEvent)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundlingServiceImpl#initializeResources(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundlingServiceImpl.initializeResources(ContextRefreshedEvent)"})
  public void testInitializeResources_givenJavaLangObject() throws BeansException {
    // Arrange
    Class<Object> type = Object.class;
    when(applicationContext.getBean(Mockito.<String>any(), eq(ResourceHttpRequestHandler.class)))
        .thenThrow(new NoSuchBeanDefinitionException(type));

    // Act
    resourceBundlingServiceImpl.initializeResources(
        new ContextRefreshedEvent(mock(ApplicationContext.class)));

    // Assert
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any(), isA(Class.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#initializeResources(ContextRefreshedEvent)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundlingServiceImpl#initializeResources(ContextRefreshedEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceBundlingServiceImpl.initializeResources(ContextRefreshedEvent)"})
  public void testInitializeResources_thenThrowRuntimeException() throws BeansException {
    // Arrange
    when(applicationContext.getBean(Mockito.<String>any(), eq(ResourceHttpRequestHandler.class)))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            resourceBundlingServiceImpl.initializeResources(
                new ContextRefreshedEvent(mock(ApplicationContext.class))));
    verify(applicationContext).getBean(eq("blJsResources"), isA(Class.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}.
   *
   * <ul>
   *   <li>When {@code /css/.css}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.rebuildBundledResource(String)"})
  public void testRebuildBundledResource_whenCssCss_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().rebuildBundledResource("/css/.css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}.
   *
   * <ul>
   *   <li>When {@code .css}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.rebuildBundledResource(String)"})
  public void testRebuildBundledResource_whenCss_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().rebuildBundledResource(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}.
   *
   * <ul>
   *   <li>When {@code /js/.js}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.rebuildBundledResource(String)"})
  public void testRebuildBundledResource_whenJsJs_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().rebuildBundledResource("/js/.js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}.
   *
   * <ul>
   *   <li>When {@code .js}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.rebuildBundledResource(String)"})
  public void testRebuildBundledResource_whenJs_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().rebuildBundledResource(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}.
   *
   * <ul>
   *   <li>When {@code Requested Bundle Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.rebuildBundledResource(String)"})
  public void testRebuildBundledResource_whenRequestedBundleName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().rebuildBundledResource("Requested Bundle Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)} with
   * {@code requestedBundleName}, {@code mappingPrefix}, {@code files}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String,
   * String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceBundlingServiceImpl.resolveBundleResourceName(String, String, List)"
  })
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFiles() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(
        resourceBundlingServiceImpl.resolveBundleResourceName(
            "Requested Bundle Name", "Mapping Prefix", new ArrayList<>()));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)} with
   * {@code requestedBundleName}, {@code mappingPrefix}, {@code files}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String,
   * String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceBundlingServiceImpl.resolveBundleResourceName(String, String, List)"
  })
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFiles2() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    // Act and Assert
    assertNull(
        resourceBundlingServiceImpl.resolveBundleResourceName(
            "Requested Bundle Name", "Mapping Prefix", files));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List,
   * String)} with {@code requestedBundleName}, {@code mappingPrefix}, {@code files}, {@code
   * bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String,
   * String, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceBundlingServiceImpl.resolveBundleResourceName(String, String, List, String)"
  })
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFilesBundleAppend() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(
        resourceBundlingServiceImpl.resolveBundleResourceName(
            "Requested Bundle Name", "Mapping Prefix", new ArrayList<>(), "Bundle Append"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List,
   * String)} with {@code requestedBundleName}, {@code mappingPrefix}, {@code files}, {@code
   * bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String,
   * String, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceBundlingServiceImpl.resolveBundleResourceName(String, String, List, String)"
  })
  public void
      testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFilesBundleAppend2() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add("Files");

    // Act and Assert
    assertNull(
        resourceBundlingServiceImpl.resolveBundleResourceName(
            "Requested Bundle Name", "Mapping Prefix", files, "Bundle Append"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List,
   * String)} with {@code requestedBundleName}, {@code mappingPrefix}, {@code files}, {@code
   * bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String,
   * String, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceBundlingServiceImpl.resolveBundleResourceName(String, String, List, String)"
  })
  public void
      testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFilesBundleAppend3() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(
        resourceBundlingServiceImpl.resolveBundleResourceName(
            ".js", "Mapping Prefix", new ArrayList<>(), "Bundle Append"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List,
   * String)} with {@code requestedBundleName}, {@code mappingPrefix}, {@code files}, {@code
   * bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String,
   * String, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceBundlingServiceImpl.resolveBundleResourceName(String, String, List, String)"
  })
  public void
      testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFilesBundleAppend4() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(
        resourceBundlingServiceImpl.resolveBundleResourceName(
            ".css", "Mapping Prefix", new ArrayList<>(), "Bundle Append"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List,
   * String)} with {@code requestedBundleName}, {@code mappingPrefix}, {@code files}, {@code
   * bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String,
   * String, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceBundlingServiceImpl.resolveBundleResourceName(String, String, List, String)"
  })
  public void
      testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFilesBundleAppend5() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add("foo");
    files.add(".js");

    // Act and Assert
    assertNull(
        resourceBundlingServiceImpl.resolveBundleResourceName(
            "Requested Bundle Name", "Mapping Prefix", files, "Bundle Append"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)} with
   * {@code requestedBundleName}, {@code mappingPrefix}, {@code files}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String,
   * String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceBundlingServiceImpl.resolveBundleResourceName(String, String, List)"
  })
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFiles_givenFoo() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add("foo");
    files.add(".js");

    // Act and Assert
    assertNull(
        resourceBundlingServiceImpl.resolveBundleResourceName(
            "Requested Bundle Name", "Mapping Prefix", files));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)} with
   * {@code requestedBundleName}, {@code mappingPrefix}, {@code files}.
   *
   * <ul>
   *   <li>When {@code .css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String,
   * String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceBundlingServiceImpl.resolveBundleResourceName(String, String, List)"
  })
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFiles_whenCss() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(
        resourceBundlingServiceImpl.resolveBundleResourceName(
            ".css", "Mapping Prefix", new ArrayList<>()));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)} with
   * {@code requestedBundleName}, {@code mappingPrefix}, {@code files}.
   *
   * <ul>
   *   <li>When {@code .js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String,
   * String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceBundlingServiceImpl.resolveBundleResourceName(String, String, List)"
  })
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFiles_whenJs() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(
        resourceBundlingServiceImpl.resolveBundleResourceName(
            ".js", "Mapping Prefix", new ArrayList<>()));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).
   *   <li>When {@code .js}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.resolveBundleResource(String)"})
  public void testResolveBundleResource_givenResourceBundlingServiceImpl_whenJs_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().resolveBundleResource(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.resolveBundleResource(String)"})
  public void testResolveBundleResource_when102_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().resolveBundleResource("1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}.
   *
   * <ul>
   *   <li>When {@code /css/.css}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.resolveBundleResource(String)"})
  public void testResolveBundleResource_whenCssCss_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().resolveBundleResource("/css/.css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}.
   *
   * <ul>
   *   <li>When {@code .css}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.resolveBundleResource(String)"})
  public void testResolveBundleResource_whenCss_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().resolveBundleResource(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}.
   *
   * <ul>
   *   <li>When {@code /js/.js}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.resolveBundleResource(String)"})
  public void testResolveBundleResource_whenJsJs_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().resolveBundleResource("/js/.js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.checkForRegisteredBundleFile(String)"})
  public void testCheckForRegisteredBundleFile_when102() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().checkForRegisteredBundleFile("1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   *
   * <ul>
   *   <li>When {@code .css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.checkForRegisteredBundleFile(String)"})
  public void testCheckForRegisteredBundleFile_whenCss() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().checkForRegisteredBundleFile(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   *
   * <ul>
   *   <li>When {@code /css/.css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.checkForRegisteredBundleFile(String)"})
  public void testCheckForRegisteredBundleFile_whenCssCss() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().checkForRegisteredBundleFile("/css/.css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   *
   * <ul>
   *   <li>When {@code .js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.checkForRegisteredBundleFile(String)"})
  public void testCheckForRegisteredBundleFile_whenJs() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().checkForRegisteredBundleFile(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   *
   * <ul>
   *   <li>When {@code /js/.js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.checkForRegisteredBundleFile(String)"})
  public void testCheckForRegisteredBundleFile_whenJsJs() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().checkForRegisteredBundleFile("/js/.js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundledResource(String)}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).
   *   <li>When {@code 1.0.2}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getBundledResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.getBundledResource(String)"})
  public void testGetBundledResource_givenResourceBundlingServiceImpl_when102_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().getBundledResource("1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   *
   * <ul>
   *   <li>When {@code /css/.css}.
   *   <li>Then return {@code /css/.css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.lookupBundlePath(String)"})
  public void testLookupBundlePath_whenCssCss_thenReturnCssCss() {
    // Arrange, Act and Assert
    assertEquals("/css/.css", new ResourceBundlingServiceImpl().lookupBundlePath("/css/.css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   *
   * <ul>
   *   <li>When {@code .css}.
   *   <li>Then return {@code /css/.css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.lookupBundlePath(String)"})
  public void testLookupBundlePath_whenCss_thenReturnCssCss() {
    // Arrange, Act and Assert
    assertEquals("/css/.css", new ResourceBundlingServiceImpl().lookupBundlePath(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   *
   * <ul>
   *   <li>When {@code /js/.js}.
   *   <li>Then return {@code /js/.js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.lookupBundlePath(String)"})
  public void testLookupBundlePath_whenJsJs_thenReturnJsJs() {
    // Arrange, Act and Assert
    assertEquals("/js/.js", new ResourceBundlingServiceImpl().lookupBundlePath("/js/.js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   *
   * <ul>
   *   <li>When {@code .js}.
   *   <li>Then return {@code /js/.js}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.lookupBundlePath(String)"})
  public void testLookupBundlePath_whenJs_thenReturnJsJs() {
    // Arrange, Act and Assert
    assertEquals("/js/.js", new ResourceBundlingServiceImpl().lookupBundlePath(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   *
   * <ul>
   *   <li>When {@code Request Path}.
   *   <li>Then return {@code Request Path}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.lookupBundlePath(String)"})
  public void testLookupBundlePath_whenRequestPath_thenReturnRequestPath() {
    // Arrange, Act and Assert
    assertEquals(
        "Request Path", new ResourceBundlingServiceImpl().lookupBundlePath("Request Path"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)} with {@code versionedBundleName}, {@code filePaths}, {@code
   * resolverChain}, {@code locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocations()
      throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("ThreadLocalManager.notify.orphans");

    Resource resource = mock(Resource.class);
    Class<Object> type = Object.class;
    when(resource.getInputStream()).thenThrow(new NoSuchBeanDefinitionException(type));

    ResourceResolverChain resolverChain = mock(ResourceResolverChain.class);
    when(resolverChain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(resource);

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            resourceBundlingServiceImpl.createBundleIfNeeded(
                "1.0.2", filePaths, resolverChain, new ArrayList<>()));
    verify(resource).getInputStream();
    verify(resolverChain)
        .resolveResource(isNull(), eq("ThreadLocalManager.notify.orphans"), isA(List.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)} with {@code versionedBundleName}, {@code filePaths}, {@code
   * resolverChain}, {@code locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocations2()
      throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("ThreadLocalManager.notify.orphans");

    Resource resource = mock(Resource.class);
    when(resource.getInputStream()).thenThrow(new IOException());

    ResourceResolverChain resolverChain = mock(ResourceResolverChain.class);
    when(resolverChain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(resource);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            resourceBundlingServiceImpl.createBundleIfNeeded(
                "1.0.2", filePaths, resolverChain, new ArrayList<>()));
    verify(resource).getInputStream();
    verify(resolverChain)
        .resolveResource(isNull(), eq("ThreadLocalManager.notify.orphans"), isA(List.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)} with {@code versionedBundleName}, {@code filePaths}, {@code
   * resolverChain}, {@code locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocations3() {
    // Arrange
    doNothing()
        .when(keyLockManager)
        .executeLocked(Mockito.<Object>any(), Mockito.<LockCallback>any());
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    resourceBundlingServiceImpl.createBundleIfNeeded(
        "1.0.2", filePaths, resolverChain, new ArrayList<>());

    // Assert
    verify(keyLockManager).executeLocked(isA(Object.class), isA(LockCallback.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)} with {@code versionedBundleName}, {@code filePaths}, {@code
   * resolverChain}, {@code locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocations4() {
    // Arrange
    doNothing()
        .when(keyLockManager)
        .executeLocked(Mockito.<Object>any(), Mockito.<LockCallback>any());

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("42");
    filePaths.add("foo");
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    resourceBundlingServiceImpl.createBundleIfNeeded(
        "1.0.2", filePaths, resolverChain, new ArrayList<>());

    // Assert
    verify(keyLockManager).executeLocked(isA(Object.class), isA(LockCallback.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)} with {@code versionedBundleName}, {@code filePaths}, {@code
   * resolverChain}, {@code locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocations5() {
    // Arrange
    doNothing()
        .when(keyLockManager)
        .executeLocked(Mockito.<Object>any(), Mockito.<LockCallback>any());
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act
    resourceBundlingServiceImpl.createBundleIfNeeded("1.0.2", filePaths, resolverChain, locations);

    // Assert
    verify(keyLockManager).executeLocked(isA(Object.class), isA(LockCallback.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)} with {@code versionedBundleName}, {@code filePaths}, {@code
   * resolverChain}, {@code locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocations6() {
    // Arrange
    doNothing()
        .when(keyLockManager)
        .executeLocked(Mockito.<Object>any(), Mockito.<LockCallback>any());
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act
    resourceBundlingServiceImpl.createBundleIfNeeded("1.0.2", filePaths, resolverChain, locations);

    // Assert
    verify(keyLockManager).executeLocked(isA(Object.class), isA(LockCallback.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)} with {@code versionedBundleName}, {@code filePaths},
   * {@code resolverChain}, {@code locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List, String)"
  })
  public void
      testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend()
          throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("ThreadLocalManager.notify.orphans");

    Resource resource = mock(Resource.class);
    Class<Object> type = Object.class;
    when(resource.getInputStream()).thenThrow(new NoSuchBeanDefinitionException(type));

    ResourceResolverChain resolverChain = mock(ResourceResolverChain.class);
    when(resolverChain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(resource);

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            resourceBundlingServiceImpl.createBundleIfNeeded(
                "1.0.2", filePaths, resolverChain, new ArrayList<>(), "Bundle Append"));
    verify(resource).getInputStream();
    verify(resolverChain)
        .resolveResource(isNull(), eq("ThreadLocalManager.notify.orphans"), isA(List.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)} with {@code versionedBundleName}, {@code filePaths},
   * {@code resolverChain}, {@code locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List, String)"
  })
  public void
      testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend2()
          throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("ThreadLocalManager.notify.orphans");

    Resource resource = mock(Resource.class);
    when(resource.getInputStream()).thenThrow(new IOException());

    ResourceResolverChain resolverChain = mock(ResourceResolverChain.class);
    when(resolverChain.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any()))
        .thenReturn(resource);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            resourceBundlingServiceImpl.createBundleIfNeeded(
                "1.0.2", filePaths, resolverChain, new ArrayList<>(), "Bundle Append"));
    verify(resource).getInputStream();
    verify(resolverChain)
        .resolveResource(isNull(), eq("ThreadLocalManager.notify.orphans"), isA(List.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)} with {@code versionedBundleName}, {@code filePaths},
   * {@code resolverChain}, {@code locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List, String)"
  })
  public void
      testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend3() {
    // Arrange
    doNothing()
        .when(keyLockManager)
        .executeLocked(Mockito.<Object>any(), Mockito.<LockCallback>any());
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    resourceBundlingServiceImpl.createBundleIfNeeded(
        "1.0.2", filePaths, resolverChain, new ArrayList<>(), "Bundle Append");

    // Assert
    verify(keyLockManager).executeLocked(isA(Object.class), isA(LockCallback.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)} with {@code versionedBundleName}, {@code filePaths},
   * {@code resolverChain}, {@code locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List, String)"
  })
  public void
      testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend4() {
    // Arrange
    doNothing()
        .when(keyLockManager)
        .executeLocked(Mockito.<Object>any(), Mockito.<LockCallback>any());

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("42");
    filePaths.add("foo");
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    resourceBundlingServiceImpl.createBundleIfNeeded(
        "1.0.2", filePaths, resolverChain, new ArrayList<>(), "Bundle Append");

    // Assert
    verify(keyLockManager).executeLocked(isA(Object.class), isA(LockCallback.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)} with {@code versionedBundleName}, {@code filePaths},
   * {@code resolverChain}, {@code locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List, String)"
  })
  public void
      testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend5() {
    // Arrange
    doNothing()
        .when(keyLockManager)
        .executeLocked(Mockito.<Object>any(), Mockito.<LockCallback>any());
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());

    // Act
    resourceBundlingServiceImpl.createBundleIfNeeded(
        "1.0.2", filePaths, resolverChain, locations, "Bundle Append");

    // Assert
    verify(keyLockManager).executeLocked(isA(Object.class), isA(LockCallback.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)} with {@code versionedBundleName}, {@code filePaths},
   * {@code resolverChain}, {@code locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundleIfNeeded(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceBundlingServiceImpl.createBundleIfNeeded(String, List, ResourceResolverChain, List, String)"
  })
  public void
      testCreateBundleIfNeededWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend6() {
    // Arrange
    doNothing()
        .when(keyLockManager)
        .executeLocked(Mockito.<Object>any(), Mockito.<LockCallback>any());
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    ArrayList<Resource> locations = new ArrayList<>();
    locations.add(new GeneratedResource());
    locations.add(new GeneratedResource());

    // Act
    resourceBundlingServiceImpl.createBundleIfNeeded(
        "1.0.2", filePaths, resolverChain, locations, "Bundle Append");

    // Assert
    verify(keyLockManager).executeLocked(isA(Object.class), isA(LockCallback.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain,
   * List)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle(
            "1.0.2", filePaths, resolverChain, new ArrayList<>());

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals("1.0.2", actualCreateBundleResult.getDescription());
    assertEquals("1.0.2", actualCreateBundleResult.getFilename());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualCreateBundleResult).getBytes());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain,
   * List)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations2() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle(
            ".js", filePaths, resolverChain, new ArrayList<>());

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(".js", actualCreateBundleResult.getDescription());
    assertEquals(".js", actualCreateBundleResult.getFilename());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualCreateBundleResult).getBytes());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain,
   * List)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations3() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    ArrayList<Resource> locations = new ArrayList<>();
    GeneratedResource generatedResource = new GeneratedResource();
    locations.add(generatedResource);

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle("1.0.2", filePaths, resolverChain, locations);

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualCreateBundleResult);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain,
   * List)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations4() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    ArrayList<Resource> locations = new ArrayList<>();
    GeneratedResource generatedResource = new GeneratedResource();
    locations.add(generatedResource);
    locations.add(new GeneratedResource());

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle("1.0.2", filePaths, resolverChain, locations);

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualCreateBundleResult);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain,
   * List)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations5() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BLCJSResourceResolver());
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(resolvers);

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle(
            ".js", filePaths, resolverChain, new ArrayList<>());

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(".js", actualCreateBundleResult.getDescription());
    assertEquals(".js", actualCreateBundleResult.getFilename());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualCreateBundleResult).getBytes());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain,
   * List)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations6() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new PathResourceResolver());
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(resolvers);

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle(
            ".js", filePaths, resolverChain, new ArrayList<>());

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(".js", actualCreateBundleResult.getDescription());
    assertEquals(".js", actualCreateBundleResult.getFilename());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualCreateBundleResult).getBytes());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain,
   * List)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations7()
      throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");

    Resource resource = mock(Resource.class);
    Class<Object> type = Object.class;
    when(resource.getInputStream()).thenThrow(new NoSuchBeanDefinitionException(type));

    CachingResourceResolver cachingResourceResolver = mock(CachingResourceResolver.class);
    when(cachingResourceResolver.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any(),
            Mockito.<ResourceResolverChain>any()))
        .thenReturn(resource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(cachingResourceResolver);
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(resolvers);

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            resourceBundlingServiceImpl.createBundle(
                ".js", filePaths, resolverChain, new ArrayList<>()));
    verify(resource).getInputStream();
    verify(cachingResourceResolver)
        .resolveResource(
            isNull(), eq("/directory/foo.txt"), isA(List.class), isA(ResourceResolverChain.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain,
   * List)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations8()
      throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");

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
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(resolvers);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            resourceBundlingServiceImpl.createBundle(
                ".js", filePaths, resolverChain, new ArrayList<>()));
    verify(resource).getInputStream();
    verify(cachingResourceResolver)
        .resolveResource(
            isNull(), eq("/directory/foo.txt"), isA(List.class), isA(ResourceResolverChain.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain,
   * List)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations9() {
    // Arrange
    Class<Object> type = Object.class;
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");

    CachingResourceResolver cachingResourceResolver = mock(CachingResourceResolver.class);
    when(cachingResourceResolver.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any(),
            Mockito.<ResourceResolverChain>any()))
        .thenReturn(new GeneratedResource());

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(cachingResourceResolver);
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(resolvers);

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            resourceBundlingServiceImpl.createBundle(
                ".js", filePaths, resolverChain, new ArrayList<>()));
    verify(environment).getProperty("bundle.charset");
    verify(cachingResourceResolver)
        .resolveResource(
            isNull(), eq("/directory/foo.txt"), isA(List.class), isA(ResourceResolverChain.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain,
   * List)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations10()
      throws IOException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenThrow(new RuntimeException());

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");

    ByteArrayResource byteArrayResource = mock(ByteArrayResource.class);
    when(byteArrayResource.getInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    CachingResourceResolver cachingResourceResolver = mock(CachingResourceResolver.class);
    when(cachingResourceResolver.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any(),
            Mockito.<ResourceResolverChain>any()))
        .thenReturn(byteArrayResource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(cachingResourceResolver);
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(resolvers);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            resourceBundlingServiceImpl.createBundle(
                "1.0.2", filePaths, resolverChain, new ArrayList<>()));
    verify(environment).getProperty("bundle.charset");
    verify(byteArrayResource).getInputStream();
    verify(cachingResourceResolver)
        .resolveResource(
            isNull(), eq("/directory/foo.txt"), isA(List.class), isA(ResourceResolverChain.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List,
   * String)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List, String)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend()
      throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle(
            ".js", filePaths, resolverChain, new ArrayList<>(), null);

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(".js", actualCreateBundleResult.getDescription());
    assertEquals(".js", actualCreateBundleResult.getFilename());
    int actualReadResult = actualCreateBundleResult.getInputStream().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertFalse(actualCreateBundleResult.isFile());
    assertFalse(actualCreateBundleResult.isOpen());
    assertArrayEquals(new byte[] {}, ((GeneratedResource) actualCreateBundleResult).getBytes());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List,
   * String)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List, String)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend2()
      throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");

    Resource resource = mock(Resource.class);
    Class<Object> type = Object.class;
    when(resource.getInputStream()).thenThrow(new NoSuchBeanDefinitionException(type));

    CachingResourceResolver cachingResourceResolver = mock(CachingResourceResolver.class);
    when(cachingResourceResolver.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any(),
            Mockito.<ResourceResolverChain>any()))
        .thenReturn(resource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(cachingResourceResolver);
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(resolvers);

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            resourceBundlingServiceImpl.createBundle(
                ".js", filePaths, resolverChain, new ArrayList<>(), "Bundle Append"));
    verify(resource).getInputStream();
    verify(cachingResourceResolver)
        .resolveResource(
            isNull(), eq("/directory/foo.txt"), isA(List.class), isA(ResourceResolverChain.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List,
   * String)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List, String)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend3()
      throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");

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
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(resolvers);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            resourceBundlingServiceImpl.createBundle(
                ".js", filePaths, resolverChain, new ArrayList<>(), "Bundle Append"));
    verify(resource).getInputStream();
    verify(cachingResourceResolver)
        .resolveResource(
            isNull(), eq("/directory/foo.txt"), isA(List.class), isA(ResourceResolverChain.class));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List,
   * String)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List, String)"
  })
  public void
      testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend4() {
    // Arrange
    Class<Object> type = Object.class;
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class,
        () ->
            resourceBundlingServiceImpl.createBundle(
                "1.0.2", filePaths, resolverChain, new ArrayList<>(), "Bundle Append"));
    verify(environment).getProperty("bundle.charset");
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List,
   * String)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List, String)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend5()
      throws IOException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn(null);
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle(
            "1.0.2", filePaths, resolverChain, new ArrayList<>(), "Bundle Append");

    // Assert
    verify(environment).getProperty("bundle.charset");
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals("1.0.2", actualCreateBundleResult.getDescription());
    assertEquals("1.0.2", actualCreateBundleResult.getFilename());
    byte[] byteArray = new byte[13];
    assertEquals(13, actualCreateBundleResult.getInputStream().read(byteArray));
    assertArrayEquals(
        "Bundle Append".getBytes("UTF-8"),
        ((GeneratedResource) actualCreateBundleResult).getBytes());
    assertArrayEquals("Bundle Append".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List,
   * String)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List, String)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend6()
      throws IOException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle(
            ".js", filePaths, resolverChain, new ArrayList<>(), "Bundle Append");

    // Assert
    verify(environment, atLeast(1)).getProperty("bundle.charset");
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(".js", actualCreateBundleResult.getDescription());
    assertEquals(".js", actualCreateBundleResult.getFilename());
    byte[] byteArray = new byte[14];
    assertEquals(14, actualCreateBundleResult.getInputStream().read(byteArray));
    assertArrayEquals(
        ";Bundle Append".getBytes("UTF-8"),
        ((GeneratedResource) actualCreateBundleResult).getBytes());
    assertArrayEquals(";Bundle Append".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List,
   * String)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List, String)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend7()
      throws IOException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(new BLCJSResourceResolver());
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(resolvers);

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle(
            ".js", filePaths, resolverChain, new ArrayList<>(), "Bundle Append");

    // Assert
    verify(environment, atLeast(1)).getProperty("bundle.charset");
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(".js", actualCreateBundleResult.getDescription());
    assertEquals(".js", actualCreateBundleResult.getFilename());
    byte[] byteArray = new byte[14];
    assertEquals(14, actualCreateBundleResult.getInputStream().read(byteArray));
    assertArrayEquals(
        ";Bundle Append".getBytes("UTF-8"),
        ((GeneratedResource) actualCreateBundleResult).getBytes());
    assertArrayEquals(";Bundle Append".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List,
   * String)} with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain}, {@code
   * locations}, {@code bundleAppend}.
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#createBundle(String, List,
   * ResourceResolverChain, List, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Resource ResourceBundlingServiceImpl.createBundle(String, List, ResourceResolverChain, List, String)"
  })
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend8()
      throws IOException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");

    Resource resource = mock(Resource.class);
    when(resource.getInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    CachingResourceResolver cachingResourceResolver = mock(CachingResourceResolver.class);
    when(cachingResourceResolver.resolveResource(
            Mockito.<HttpServletRequest>any(),
            Mockito.<String>any(),
            Mockito.<List<Resource>>any(),
            Mockito.<ResourceResolverChain>any()))
        .thenReturn(resource);

    ArrayList<ResourceResolver> resolvers = new ArrayList<>();
    resolvers.add(cachingResourceResolver);
    BroadleafDefaultResourceResolverChain resolverChain =
        new BroadleafDefaultResourceResolverChain(resolvers);

    // Act
    Resource actualCreateBundleResult =
        resourceBundlingServiceImpl.createBundle(
            ".js", filePaths, resolverChain, new ArrayList<>(), "Bundle Append");

    // Assert
    verify(environment, atLeast(1)).getProperty("bundle.charset");
    verify(resource).getInputStream();
    verify(cachingResourceResolver)
        .resolveResource(
            isNull(), eq("/directory/foo.txt"), isA(List.class), isA(ResourceResolverChain.class));
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(".js", actualCreateBundleResult.getDescription());
    assertEquals(".js", actualCreateBundleResult.getFilename());
    byte[] byteArray = new byte[24];
    assertEquals(24, actualCreateBundleResult.getInputStream().read(byteArray));
    assertArrayEquals(
        "AXAXAXAX;\n;Bundle Append".getBytes("UTF-8"),
        ((GeneratedResource) actualCreateBundleResult).getBytes());
    assertArrayEquals("AXAXAXAX;\n;Bundle Append".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.getCacheKey(String, List)"})
  public void testGetCacheKey_given42_whenArrayListAdd42() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add("42");
    files.add("foo");

    // Act and Assert
    assertEquals("1.0.2", resourceBundlingServiceImpl.getCacheKey("1.0.2", files));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.getCacheKey(String, List)"})
  public void testGetCacheKey_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act and Assert
    assertEquals("1.0.2", resourceBundlingServiceImpl.getCacheKey("1.0.2", files));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.getCacheKey(String, List)"})
  public void testGetCacheKey_whenArrayList() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertEquals("1.0.2", resourceBundlingServiceImpl.getCacheKey("1.0.2", new ArrayList<>()));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleName(String, String)}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).
   *   <li>When {@code .css}.
   *   <li>Then return {@code 1.0.2.css}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getBundleName(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.getBundleName(String, String)"})
  public void testGetBundleName_givenResourceBundlingServiceImpl_whenCss_thenReturn102Css() {
    // Arrange, Act and Assert
    assertEquals("1.0.2.css", new ResourceBundlingServiceImpl().getBundleName(".css", "1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}.
   *
   * <ul>
   *   <li>Given {@link Resource} {@link Resource#lastModified()} return one.
   *   <li>Then return {@code -1268928760}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.getBundleVersion(LinkedHashMap)"})
  public void testGetBundleVersion_givenResourceLastModifiedReturnOne_thenReturn1268928760()
      throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    Resource resource = mock(Resource.class);
    when(resource.lastModified()).thenReturn(1L);

    LinkedHashMap<String, Resource> foundResources = new LinkedHashMap<>();
    foundResources.put("foo", resource);

    // Act
    String actualBundleVersion = resourceBundlingServiceImpl.getBundleVersion(foundResources);

    // Assert
    verify(resource).lastModified();
    assertEquals("-1268928760", actualBundleVersion);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}.
   *
   * <ul>
   *   <li>Then return {@code 1180559414}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.getBundleVersion(LinkedHashMap)"})
  public void testGetBundleVersion_thenReturn1180559414() throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    Resource resource = mock(Resource.class);
    when(resource.lastModified()).thenReturn(1L);

    GeneratedResource generatedResource = mock(GeneratedResource.class);
    when(generatedResource.getHashRepresentation()).thenReturn("Hash Representation");
    doNothing().when(generatedResource).setHashRepresentation(Mockito.<String>any());
    generatedResource.setHashRepresentation("Hash Representation");

    LinkedHashMap<String, Resource> foundResources = new LinkedHashMap<>();
    foundResources.put("foo", new GeneratedResource());
    foundResources.put("42", generatedResource);
    foundResources.put("foo", resource);

    // Act
    String actualBundleVersion = resourceBundlingServiceImpl.getBundleVersion(foundResources);

    // Assert
    verify(generatedResource).getHashRepresentation();
    verify(generatedResource).setHashRepresentation("Hash Representation");
    verify(resource).lastModified();
    assertEquals("1180559414", actualBundleVersion);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}.
   *
   * <ul>
   *   <li>Then return {@code -1681651514}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.getBundleVersion(LinkedHashMap)"})
  public void testGetBundleVersion_thenReturn1681651514() throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    Resource resource = mock(Resource.class);
    when(resource.lastModified()).thenReturn(1L);

    GeneratedResource generatedResource = new GeneratedResource();
    generatedResource.setHashRepresentation("Hash Representation");

    LinkedHashMap<String, Resource> foundResources = new LinkedHashMap<>();
    foundResources.put("42", generatedResource);
    foundResources.put("foo", resource);

    // Act
    String actualBundleVersion = resourceBundlingServiceImpl.getBundleVersion(foundResources);

    // Assert
    verify(resource).lastModified();
    assertEquals("-1681651514", actualBundleVersion);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}.
   *
   * <ul>
   *   <li>When {@link LinkedHashMap#LinkedHashMap()}.
   *   <li>Then return {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.getBundleVersion(LinkedHashMap)"})
  public void testGetBundleVersion_whenLinkedHashMap_thenReturn0() throws IOException {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertEquals("0", resourceBundlingServiceImpl.getBundleVersion(new LinkedHashMap<>()));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getAdditionalBundleFiles(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getAdditionalBundleFiles(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ResourceBundlingServiceImpl.getAdditionalBundleFiles(String)"})
  public void testGetAdditionalBundleFiles_thenReturnNull() {
    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(new HashMap<>());

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.getAdditionalBundleFiles("Bundle Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#addVersion(String, String)}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).
   *   <li>Then return {@code Request Path1.0.2.null}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#addVersion(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.addVersion(String, String)"})
  public void testAddVersion_givenResourceBundlingServiceImpl_thenReturnRequestPath102Null() {
    // Arrange, Act and Assert
    assertEquals(
        "Request Path1.0.2.null",
        new ResourceBundlingServiceImpl().addVersion("Request Path", "1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#readBundle(String)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#readBundle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.readBundle(String)"})
  public void testReadBundle_givenJavaLangObject_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    Class<Object> type = Object.class;
    when(broadleafFileService.getResource(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class, () -> resourceBundlingServiceImpl.readBundle("1.0.2"));
    verify(broadleafFileService).getResource("/bundles/1.0.2");
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#readBundle(String)}.
   *
   * <ul>
   *   <li>Then return {@link FileSystemResource}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#readBundle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource ResourceBundlingServiceImpl.readBundle(String)"})
  public void testReadBundle_thenReturnFileSystemResource() throws IOException {
    // Arrange
    when(broadleafFileService.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    Resource actualReadBundleResult = resourceBundlingServiceImpl.readBundle("1.0.2");

    // Assert
    verify(broadleafFileService).getResource("/bundles/1.0.2");
    assertTrue(actualReadBundleResult instanceof FileSystemResource);
    File file = actualReadBundleResult.getFile();
    assertEquals("test.txt", file.getName());
    assertEquals("test.txt", actualReadBundleResult.getFilename());
    assertFalse(actualReadBundleResult.isOpen());
    assertTrue(file.isAbsolute());
    assertTrue(actualReadBundleResult.isFile());
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
        ((FileSystemResource) actualReadBundleResult).getPath());
    String expectedToStringResult =
        String.join(
            "", "file:", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString());
    assertEquals(expectedToStringResult, actualReadBundleResult.getURI().toString());
    String expectedToStringResult2 =
        String.join(
            "", "file:", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString());
    assertEquals(expectedToStringResult2, actualReadBundleResult.getURL().toString());
    String expectedDescription =
        String.join(
            "",
            "file [",
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
            "]");
    assertEquals(expectedDescription, actualReadBundleResult.getDescription());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}.
   *
   * <ul>
   *   <li>When {@code .css}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceHttpRequestHandler ResourceBundlingServiceImpl.findResourceHttpRequestHandler(String)"
  })
  public void testFindResourceHttpRequestHandler_whenCss_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().findResourceHttpRequestHandler(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceHttpRequestHandler ResourceBundlingServiceImpl.findResourceHttpRequestHandler(String)"
  })
  public void testFindResourceHttpRequestHandler_whenHttpsExampleOrgExample_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new ResourceBundlingServiceImpl()
            .findResourceHttpRequestHandler("https://example.org/example"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}.
   *
   * <ul>
   *   <li>When {@code .js}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceHttpRequestHandler ResourceBundlingServiceImpl.findResourceHttpRequestHandler(String)"
  })
  public void testFindResourceHttpRequestHandler_whenJs_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new ResourceBundlingServiceImpl().findResourceHttpRequestHandler(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}.
   *
   * <ul>
   *   <li>When {@code .js}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.isJavaScriptResource(String)"})
  public void testIsJavaScriptResource_whenJs_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ResourceBundlingServiceImpl().isJavaScriptResource(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.isJavaScriptResource(String)"})
  public void testIsJavaScriptResource_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().isJavaScriptResource(null));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}.
   *
   * <ul>
   *   <li>When {@code Resource Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.isJavaScriptResource(String)"})
  public void testIsJavaScriptResource_whenResourceName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().isJavaScriptResource("Resource Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isCSSResource(String)}.
   *
   * <ul>
   *   <li>When {@code .css}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#isCSSResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.isCSSResource(String)"})
  public void testIsCSSResource_whenCss_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new ResourceBundlingServiceImpl().isCSSResource(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isCSSResource(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#isCSSResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.isCSSResource(String)"})
  public void testIsCSSResource_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().isCSSResource(null));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isCSSResource(String)}.
   *
   * <ul>
   *   <li>When {@code Resource Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#isCSSResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.isCSSResource(String)"})
  public void testIsCSSResource_whenResourceName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().isCSSResource("Resource Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getResourcePath(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code bundles/Name}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getResourcePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.getResourcePath(String)"})
  public void testGetResourcePath_whenName_thenReturnBundlesName() {
    // Arrange, Act and Assert
    assertEquals("bundles/Name", new ResourceBundlingServiceImpl().getResourcePath("Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getResourcePath(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@code bundles/}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getResourcePath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ResourceBundlingServiceImpl.getResourcePath(String)"})
  public void testGetResourcePath_whenSlash_thenReturnBundles() {
    // Arrange, Act and Assert
    assertEquals("bundles/", new ResourceBundlingServiceImpl().getResourcePath("/"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleCharSet()}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getBundleCharSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Charset ResourceBundlingServiceImpl.getBundleCharSet()"})
  public void testGetBundleCharSet_givenJavaLangObject_thenThrowNoSuchBeanDefinitionException() {
    // Arrange
    Class<Object> type = Object.class;
    when(environment.getProperty(Mockito.<String>any()))
        .thenThrow(new NoSuchBeanDefinitionException(type));

    // Act and Assert
    assertThrows(
        NoSuchBeanDefinitionException.class, () -> resourceBundlingServiceImpl.getBundleCharSet());
    verify(environment).getProperty("bundle.charset");
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleCharSet()}.
   *
   * <ul>
   *   <li>Then return name is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#getBundleCharSet()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Charset ResourceBundlingServiceImpl.getBundleCharSet()"})
  public void testGetBundleCharSet_thenReturnNameIsUtf8() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("");

    // Act
    Charset actualBundleCharSet = resourceBundlingServiceImpl.getBundleCharSet();

    // Assert
    verify(environment).getProperty("bundle.charset");
    assertEquals("UTF-8", actualBundleCharSet.name());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#findBundlesNameByResourceFileName(String)}.
   *
   * <p>Method under test: {@link
   * ResourceBundlingServiceImpl#findBundlesNameByResourceFileName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ResourceBundlingServiceImpl.findBundlesNameByResourceFileName(String)"})
  public void testFindBundlesNameByResourceFileName() {
    // Arrange, Act and Assert
    assertTrue(
        new ResourceBundlingServiceImpl().findBundlesNameByResourceFileName("foo.txt").isEmpty());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#removeBundle(String)}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).
   *   <li>When {@code Bundle Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.removeBundle(String)"})
  public void testRemoveBundle_givenResourceBundlingServiceImpl_whenBundleName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().removeBundle("Bundle Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#removeBundle(String)}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).
   *   <li>When {@code /css/.css}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.removeBundle(String)"})
  public void testRemoveBundle_givenResourceBundlingServiceImpl_whenCssCss_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().removeBundle("/css/.css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#removeBundle(String)}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).
   *   <li>When {@code .css}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.removeBundle(String)"})
  public void testRemoveBundle_givenResourceBundlingServiceImpl_whenCss_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().removeBundle(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#removeBundle(String)}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).
   *   <li>When {@code /js/.js}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.removeBundle(String)"})
  public void testRemoveBundle_givenResourceBundlingServiceImpl_whenJsJs_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().removeBundle("/js/.js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#removeBundle(String)}.
   *
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).
   *   <li>When {@code .js}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ResourceBundlingServiceImpl.removeBundle(String)"})
  public void testRemoveBundle_givenResourceBundlingServiceImpl_whenJs_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ResourceBundlingServiceImpl().removeBundle(".js"));
  }
}
