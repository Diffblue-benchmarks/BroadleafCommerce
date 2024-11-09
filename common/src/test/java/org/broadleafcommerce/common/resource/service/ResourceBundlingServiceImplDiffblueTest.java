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
package org.broadleafcommerce.common.resource.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.broadleafcommerce.common.web.resource.BroadleafDefaultResourceResolverChain;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.ResourceResolverChain;

public class ResourceBundlingServiceImplDiffblueTest {
  /**
   * Test {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  public void testRebuildBundledResource_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.rebuildBundledResource("Requested Bundle Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}.
   * <ul>
   *   <li>When {@code .css}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  public void testRebuildBundledResource_whenCss_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).rebuildBundledResource(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}.
   * <ul>
   *   <li>When {@code .js}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  public void testRebuildBundledResource_whenJs_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).rebuildBundledResource(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}.
   * <ul>
   *   <li>When {@code Requested Bundle Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  public void testRebuildBundledResource_whenRequestedBundleName_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).rebuildBundledResource("Requested Bundle Name"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   * with {@code requestedBundleName}, {@code mappingPrefix}, {@code files}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   */
  @Test
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFiles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName("Requested Bundle Name", "Mapping Prefix",
        new ArrayList<>()));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   * with {@code requestedBundleName}, {@code mappingPrefix}, {@code files},
   * {@code bundleAppend}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   */
  @Test
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFilesBundleAppend() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName("Requested Bundle Name", "Mapping Prefix",
        new ArrayList<>(), "Bundle Append"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   * with {@code requestedBundleName}, {@code mappingPrefix}, {@code files},
   * {@code bundleAppend}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   */
  @Test
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFilesBundleAppend2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName(".js", "Mapping Prefix", new ArrayList<>(),
        "Bundle Append"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   * with {@code requestedBundleName}, {@code mappingPrefix}, {@code files},
   * {@code bundleAppend}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   */
  @Test
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFilesBundleAppend3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName(".css", "Mapping Prefix", new ArrayList<>(),
        "Bundle Append"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   * with {@code requestedBundleName}, {@code mappingPrefix}, {@code files},
   * {@code bundleAppend}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   */
  @Test
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFilesBundleAppend4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add(".js");

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName("Requested Bundle Name", "Mapping Prefix", files,
        "Bundle Append"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   * with {@code requestedBundleName}, {@code mappingPrefix}, {@code files},
   * {@code bundleAppend}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   */
  @Test
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFilesBundleAppend5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add(".css");
    files.add(".js");

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName("Requested Bundle Name", "Mapping Prefix", files,
        "Bundle Append"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   * with {@code requestedBundleName}, {@code mappingPrefix}, {@code files}.
   * <ul>
   *   <li>Given {@code .css}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   */
  @Test
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFiles_givenCss() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add(".css");
    files.add(".js");

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName("Requested Bundle Name", "Mapping Prefix", files));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   * with {@code requestedBundleName}, {@code mappingPrefix}, {@code files}.
   * <ul>
   *   <li>Given {@code .js}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   */
  @Test
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFiles_givenJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add(".js");

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName("Requested Bundle Name", "Mapping Prefix", files));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   * with {@code requestedBundleName}, {@code mappingPrefix}, {@code files}.
   * <ul>
   *   <li>When {@code .css}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   */
  @Test
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFiles_whenCss() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName(".css", "Mapping Prefix", new ArrayList<>()));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   * with {@code requestedBundleName}, {@code mappingPrefix}, {@code files}.
   * <ul>
   *   <li>When {@code .js}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   */
  @Test
  public void testResolveBundleResourceNameWithRequestedBundleNameMappingPrefixFiles_whenJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName(".js", "Mapping Prefix", new ArrayList<>()));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   *   <li>When {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  public void testResolveBundleResource_givenHashMapComputeIfPresentFooAndBiFunction_when102() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResource("1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code .js}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  public void testResolveBundleResource_givenResourceBundlingServiceImpl_whenJs_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).resolveBundleResource(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}.
   * <ul>
   *   <li>When {@code 1.0.2}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  public void testResolveBundleResource_when102_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).resolveBundleResource("1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}.
   * <ul>
   *   <li>When {@code .css}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  public void testResolveBundleResource_whenCss_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).resolveBundleResource(".css"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  public void testCheckForRegisteredBundleFile_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertFalse(resourceBundlingServiceImpl.checkForRegisteredBundleFile("1.0.2"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  public void testCheckForRegisteredBundleFile_givenResourceBundlingServiceImpl_when102() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).checkForRegisteredBundleFile("1.0.2"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code .css}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  public void testCheckForRegisteredBundleFile_givenResourceBundlingServiceImpl_whenCss() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).checkForRegisteredBundleFile(".css"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code .js}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  public void testCheckForRegisteredBundleFile_givenResourceBundlingServiceImpl_whenJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).checkForRegisteredBundleFile(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundledResource(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundledResource(String)}
   */
  @Test
  public void testGetBundledResource_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.getBundledResource("1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundledResource(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code 1.0.2}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundledResource(String)}
   */
  @Test
  public void testGetBundledResource_givenResourceBundlingServiceImpl_when102_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).getBundledResource("1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  public void testLookupBundlePath_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertEquals("Request Path", resourceBundlingServiceImpl.lookupBundlePath("Request Path"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code .css}.</li>
   *   <li>Then return {@code /css/.css}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  public void testLookupBundlePath_givenResourceBundlingServiceImpl_whenCss_thenReturnCssCss() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/css/.css", (new ResourceBundlingServiceImpl()).lookupBundlePath(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code /js/.js}.</li>
   *   <li>Then return {@code /js/.js}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  public void testLookupBundlePath_givenResourceBundlingServiceImpl_whenJsJs_thenReturnJsJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/js/.js", (new ResourceBundlingServiceImpl()).lookupBundlePath("/js/.js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code .js}.</li>
   *   <li>Then return {@code /js/.js}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  public void testLookupBundlePath_givenResourceBundlingServiceImpl_whenJs_thenReturnJsJs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/js/.js", (new ResourceBundlingServiceImpl()).lookupBundlePath(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   * <ul>
   *   <li>When {@code /css/.css}.</li>
   *   <li>Then return {@code /css/.css}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  public void testLookupBundlePath_whenCssCss_thenReturnCssCss() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/css/.css", (new ResourceBundlingServiceImpl()).lookupBundlePath("/css/.css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}.
   * <ul>
   *   <li>When {@code Request Path}.</li>
   *   <li>Then return {@code Request Path}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  public void testLookupBundlePath_whenRequestPath_thenReturnRequestPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Request Path", (new ResourceBundlingServiceImpl()).lookupBundlePath("Request Path"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   * with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain},
   * {@code locations}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   */
  @Test
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain = new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    Resource actualCreateBundleResult = resourceBundlingServiceImpl.createBundle("1.0.2", filePaths, resolverChain,
        new ArrayList<>());

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals("1.0.2", actualCreateBundleResult.getDescription());
    assertEquals("1.0.2", actualCreateBundleResult.getFilename());
    assertEquals(-1, actualCreateBundleResult.getInputStream().read(new byte[]{}));
    assertEquals(0, ((GeneratedResource) actualCreateBundleResult).getBytes().length);
    assertFalse(actualCreateBundleResult.isFile());
    assertFalse(actualCreateBundleResult.isOpen());
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   * with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain},
   * {@code locations}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   */
  @Test
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");
    BroadleafDefaultResourceResolverChain resolverChain = new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    Resource actualCreateBundleResult = resourceBundlingServiceImpl.createBundle(".js", filePaths, resolverChain,
        new ArrayList<>());

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(".js", actualCreateBundleResult.getDescription());
    assertEquals(".js", actualCreateBundleResult.getFilename());
    assertEquals(-1, actualCreateBundleResult.getInputStream().read(new byte[]{}));
    assertEquals(0, ((GeneratedResource) actualCreateBundleResult).getBytes().length);
    assertFalse(actualCreateBundleResult.isFile());
    assertFalse(actualCreateBundleResult.isOpen());
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   * with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain},
   * {@code locations}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   */
  @Test
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations3() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    ArrayList<String> filePaths = new ArrayList<>();
    ResourceResolverChain resolverChain = mock(ResourceResolverChain.class);

    // Act
    Resource actualCreateBundleResult = resourceBundlingServiceImpl.createBundle("1.0.2", filePaths, resolverChain,
        new ArrayList<>());

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals("1.0.2", actualCreateBundleResult.getDescription());
    assertEquals("1.0.2", actualCreateBundleResult.getFilename());
    assertEquals(-1, actualCreateBundleResult.getInputStream().read(new byte[]{}));
    assertEquals(0, ((GeneratedResource) actualCreateBundleResult).getBytes().length);
    assertFalse(actualCreateBundleResult.isFile());
    assertFalse(actualCreateBundleResult.isOpen());
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   * with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain},
   * {@code locations}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   */
  @Test
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain = new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    ArrayList<Resource> locations = new ArrayList<>();
    GeneratedResource generatedResource = new GeneratedResource();
    locations.add(generatedResource);

    // Act
    Resource actualCreateBundleResult = resourceBundlingServiceImpl.createBundle("1.0.2", filePaths, resolverChain,
        locations);

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualCreateBundleResult);
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   * with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain},
   * {@code locations}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   */
  @Test
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocations5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    ArrayList<String> filePaths = new ArrayList<>();
    BroadleafDefaultResourceResolverChain resolverChain = new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    ArrayList<Resource> locations = new ArrayList<>();
    GeneratedResource generatedResource = new GeneratedResource();
    locations.add(generatedResource);
    locations.add(new GeneratedResource());

    // Act
    Resource actualCreateBundleResult = resourceBundlingServiceImpl.createBundle("1.0.2", filePaths, resolverChain,
        locations);

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(generatedResource, actualCreateBundleResult);
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List, String)}
   * with {@code versionedBundleName}, {@code filePaths}, {@code resolverChain},
   * {@code locations}, {@code bundleAppend}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List, String)}
   */
  @Test
  public void testCreateBundleWithVersionedBundleNameFilePathsResolverChainLocationsBundleAppend() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> filePaths = new ArrayList<>();
    filePaths.add("/directory/foo.txt");
    BroadleafDefaultResourceResolverChain resolverChain = new BroadleafDefaultResourceResolverChain(new ArrayList<>());

    // Act
    Resource actualCreateBundleResult = resourceBundlingServiceImpl.createBundle(".js", filePaths, resolverChain,
        new ArrayList<>(), null);

    // Assert
    assertTrue(actualCreateBundleResult instanceof GeneratedResource);
    assertEquals(".js", actualCreateBundleResult.getDescription());
    assertEquals(".js", actualCreateBundleResult.getFilename());
    assertEquals(-1, actualCreateBundleResult.getInputStream().read(new byte[]{}));
    assertEquals(0, ((GeneratedResource) actualCreateBundleResult).getBytes().length);
    assertFalse(actualCreateBundleResult.isFile());
    assertFalse(actualCreateBundleResult.isOpen());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}
   */
  @Test
  public void testGetCacheKey_given42_whenArrayListAdd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}
   */
  @Test
  public void testGetCacheKey_givenFoo_whenArrayListAddFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act and Assert
    assertEquals("1.0.2", resourceBundlingServiceImpl.getCacheKey("1.0.2", files));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}
   */
  @Test
  public void testGetCacheKey_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertEquals("1.0.2", resourceBundlingServiceImpl.getCacheKey("1.0.2", new ArrayList<>()));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleName(String, String)}.
   * <ul>
   *   <li>When {@code .css}.</li>
   *   <li>Then return {@code 1.0.2.css}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundleName(String, String)}
   */
  @Test
  public void testGetBundleName_whenCss_thenReturn102Css() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1.0.2.css", (new ResourceBundlingServiceImpl()).getBundleName(".css", "1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}.
   * <ul>
   *   <li>Then return {@code -636681914}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  public void testGetBundleVersion_thenReturn636681914() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    GeneratedResource generatedResource = mock(GeneratedResource.class);
    when(generatedResource.getHashRepresentation()).thenReturn("Hash Representation");
    ByteArrayResource byteArrayResource = mock(ByteArrayResource.class);
    when(byteArrayResource.lastModified()).thenReturn(1L);

    LinkedHashMap<String, Resource> foundResources = new LinkedHashMap<>();
    foundResources.put("42", byteArrayResource);
    foundResources.put("foo", generatedResource);

    // Act
    String actualBundleVersion = resourceBundlingServiceImpl.getBundleVersion(foundResources);

    // Assert
    verify(generatedResource).getHashRepresentation();
    verify(byteArrayResource).lastModified();
    assertEquals("-636681914", actualBundleVersion);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}.
   * <ul>
   *   <li>Then return {@code 848213750}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  public void testGetBundleVersion_thenReturn848213750() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    GeneratedResource generatedResource = mock(GeneratedResource.class);
    when(generatedResource.getHashRepresentation()).thenReturn("Hash Representation");

    LinkedHashMap<String, Resource> foundResources = new LinkedHashMap<>();
    foundResources.put("foo", generatedResource);

    // Act
    String actualBundleVersion = resourceBundlingServiceImpl.getBundleVersion(foundResources);

    // Assert
    verify(generatedResource).getHashRepresentation();
    assertEquals("848213750", actualBundleVersion);
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}.
   * <ul>
   *   <li>Then throw {@link NoSuchBeanDefinitionException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  public void testGetBundleVersion_thenThrowNoSuchBeanDefinitionException() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    GeneratedResource generatedResource = mock(GeneratedResource.class);
    when(generatedResource.getHashRepresentation()).thenThrow(new NoSuchBeanDefinitionException("\r\n"));

    LinkedHashMap<String, Resource> foundResources = new LinkedHashMap<>();
    foundResources.put("foo", generatedResource);

    // Act and Assert
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> resourceBundlingServiceImpl.getBundleVersion(foundResources));
    verify(generatedResource).getHashRepresentation();
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}.
   * <ul>
   *   <li>When {@link LinkedHashMap#LinkedHashMap()}.</li>
   *   <li>Then return {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  public void testGetBundleVersion_whenLinkedHashMap_thenReturn0() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertEquals("0", resourceBundlingServiceImpl.getBundleVersion(new LinkedHashMap<>()));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getAdditionalBundleFiles(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getAdditionalBundleFiles(String)}
   */
  @Test
  public void testGetAdditionalBundleFiles_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.getAdditionalBundleFiles("Bundle Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getAdditionalBundleFiles(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getAdditionalBundleFiles(String)}
   */
  @Test
  public void testGetAdditionalBundleFiles_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(new HashMap<>());

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.getAdditionalBundleFiles("Bundle Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#addVersion(String, String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#addVersion(String, String)}
   */
  @Test
  public void testAddVersion_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertEquals("Request Path1.0.2.null", resourceBundlingServiceImpl.addVersion("Request Path", "1.0.2"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#addVersion(String, String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>Then return {@code Request Path1.0.2.null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#addVersion(String, String)}
   */
  @Test
  public void testAddVersion_givenResourceBundlingServiceImpl_thenReturnRequestPath102Null() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Request Path1.0.2.null", (new ResourceBundlingServiceImpl()).addVersion("Request Path", "1.0.2"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}
   */
  @Test
  public void testFindResourceHttpRequestHandler_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.findResourceHttpRequestHandler("https://example.org/example"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}.
   * <ul>
   *   <li>When {@code .css}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}
   */
  @Test
  public void testFindResourceHttpRequestHandler_whenCss_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).findResourceHttpRequestHandler(".css"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}
   */
  @Test
  public void testFindResourceHttpRequestHandler_whenHttpsExampleOrgExample_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).findResourceHttpRequestHandler("https://example.org/example"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}.
   * <ul>
   *   <li>When {@code .js}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}
   */
  @Test
  public void testFindResourceHttpRequestHandler_whenJs_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).findResourceHttpRequestHandler(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}
   */
  @Test
  public void testIsJavaScriptResource_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertFalse(resourceBundlingServiceImpl.isJavaScriptResource("Resource Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code .js}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}
   */
  @Test
  public void testIsJavaScriptResource_givenResourceBundlingServiceImpl_whenJs_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ResourceBundlingServiceImpl()).isJavaScriptResource(".js"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}
   */
  @Test
  public void testIsJavaScriptResource_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).isJavaScriptResource(null));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}.
   * <ul>
   *   <li>When {@code Resource Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}
   */
  @Test
  public void testIsJavaScriptResource_whenResourceName_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).isJavaScriptResource("Resource Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isCSSResource(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   *   <li>When {@code Resource Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#isCSSResource(String)}
   */
  @Test
  public void testIsCSSResource_givenHashMapComputeIfPresentFooAndBiFunction_whenResourceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertFalse(resourceBundlingServiceImpl.isCSSResource("Resource Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isCSSResource(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code .css}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#isCSSResource(String)}
   */
  @Test
  public void testIsCSSResource_givenResourceBundlingServiceImpl_whenCss_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ResourceBundlingServiceImpl()).isCSSResource(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isCSSResource(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#isCSSResource(String)}
   */
  @Test
  public void testIsCSSResource_givenResourceBundlingServiceImpl_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).isCSSResource(null));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#isCSSResource(String)}.
   * <ul>
   *   <li>When {@code Resource Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#isCSSResource(String)}
   */
  @Test
  public void testIsCSSResource_whenResourceName_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).isCSSResource("Resource Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getResourcePath(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getResourcePath(String)}
   */
  @Test
  public void testGetResourcePath_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertEquals("bundles/Name", resourceBundlingServiceImpl.getResourcePath("Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getResourcePath(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>Then return {@code bundles/Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getResourcePath(String)}
   */
  @Test
  public void testGetResourcePath_givenResourceBundlingServiceImpl_thenReturnBundlesName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("bundles/Name", (new ResourceBundlingServiceImpl()).getResourcePath("Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#getResourcePath(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code bundles/}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getResourcePath(String)}
   */
  @Test
  public void testGetResourcePath_givenResourceBundlingServiceImpl_whenSlash_thenReturnBundles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("bundles/", (new ResourceBundlingServiceImpl()).getResourcePath("/"));
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#findBundlesNameByResourceFileName(String)}.
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#findBundlesNameByResourceFileName(String)}
   */
  @Test
  public void testFindBundlesNameByResourceFileName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertTrue(resourceBundlingServiceImpl.findBundlesNameByResourceFileName("foo.txt").isEmpty());
  }

  /**
   * Test
   * {@link ResourceBundlingServiceImpl#findBundlesNameByResourceFileName(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceBundlingServiceImpl#findBundlesNameByResourceFileName(String)}
   */
  @Test
  public void testFindBundlesNameByResourceFileName_givenResourceBundlingServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ResourceBundlingServiceImpl()).findBundlesNameByResourceFileName("foo.txt").isEmpty());
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#removeBundle(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   *   <li>When {@code Bundle Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  public void testRemoveBundle_givenHashMapComputeIfPresentFooAndBiFunction_whenBundleName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertFalse(resourceBundlingServiceImpl.removeBundle("Bundle Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#removeBundle(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code Bundle Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  public void testRemoveBundle_givenResourceBundlingServiceImpl_whenBundleName_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).removeBundle("Bundle Name"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#removeBundle(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code .css}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  public void testRemoveBundle_givenResourceBundlingServiceImpl_whenCss_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).removeBundle(".css"));
  }

  /**
   * Test {@link ResourceBundlingServiceImpl#removeBundle(String)}.
   * <ul>
   *   <li>Given {@link ResourceBundlingServiceImpl} (default constructor).</li>
   *   <li>When {@code .js}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  public void testRemoveBundle_givenResourceBundlingServiceImpl_whenJs_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).removeBundle(".js"));
  }
}
