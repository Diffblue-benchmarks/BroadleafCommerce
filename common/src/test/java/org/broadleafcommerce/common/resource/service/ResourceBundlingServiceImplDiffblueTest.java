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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  public void testRebuildBundledResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).rebuildBundledResource("Requested Bundle Name"));
    assertNull((new ResourceBundlingServiceImpl()).rebuildBundledResource(".css"));
    assertNull((new ResourceBundlingServiceImpl()).rebuildBundledResource(".js"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#rebuildBundledResource(String)}
   */
  @Test
  public void testRebuildBundledResource2() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   */
  @Test
  public void testResolveBundleResourceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName("Requested Bundle Name", "Mapping Prefix",
        new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   */
  @Test
  public void testResolveBundleResourceName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName(".js", "Mapping Prefix", new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   */
  @Test
  public void testResolveBundleResourceName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName(".css", "Mapping Prefix", new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   */
  @Test
  public void testResolveBundleResourceName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add(".js");

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName("Requested Bundle Name", "Mapping Prefix", files));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List)}
   */
  @Test
  public void testResolveBundleResourceName5() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   */
  @Test
  public void testResolveBundleResourceName6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName("Requested Bundle Name", "Mapping Prefix",
        new ArrayList<>(), "Bundle Append"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   */
  @Test
  public void testResolveBundleResourceName7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName(".js", "Mapping Prefix", new ArrayList<>(),
        "Bundle Append"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   */
  @Test
  public void testResolveBundleResourceName8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.resolveBundleResourceName(".css", "Mapping Prefix", new ArrayList<>(),
        "Bundle Append"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   */
  @Test
  public void testResolveBundleResourceName9() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResourceName(String, String, List, String)}
   */
  @Test
  public void testResolveBundleResourceName10() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  public void testResolveBundleResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).resolveBundleResource("1.0.2"));
    assertNull((new ResourceBundlingServiceImpl()).resolveBundleResource(".css"));
    assertNull((new ResourceBundlingServiceImpl()).resolveBundleResource(".js"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#resolveBundleResource(String)}
   */
  @Test
  public void testResolveBundleResource2() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  public void testCheckForRegisteredBundleFile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).checkForRegisteredBundleFile("1.0.2"));
    assertFalse((new ResourceBundlingServiceImpl()).checkForRegisteredBundleFile(".css"));
    assertFalse((new ResourceBundlingServiceImpl()).checkForRegisteredBundleFile(".js"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#checkForRegisteredBundleFile(String)}
   */
  @Test
  public void testCheckForRegisteredBundleFile2() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundledResource(String)}
   */
  @Test
  public void testGetBundledResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).getBundledResource("1.0.2"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundledResource(String)}
   */
  @Test
  public void testGetBundledResource2() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  public void testLookupBundlePath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Request Path", (new ResourceBundlingServiceImpl()).lookupBundlePath("Request Path"));
    assertEquals("/css/.css", (new ResourceBundlingServiceImpl()).lookupBundlePath(".css"));
    assertEquals("/js/.js", (new ResourceBundlingServiceImpl()).lookupBundlePath(".js"));
    assertEquals("/css/.css", (new ResourceBundlingServiceImpl()).lookupBundlePath("/css/.css"));
    assertEquals("/js/.js", (new ResourceBundlingServiceImpl()).lookupBundlePath("/js/.js"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#lookupBundlePath(String)}
   */
  @Test
  public void testLookupBundlePath2() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   */
  @Test
  public void testCreateBundle() throws IOException {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   */
  @Test
  public void testCreateBundle2() throws IOException {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   */
  @Test
  public void testCreateBundle3() throws IOException {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   */
  @Test
  public void testCreateBundle4() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List)}
   */
  @Test
  public void testCreateBundle5() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#createBundle(String, List, ResourceResolverChain, List, String)}
   */
  @Test
  public void testCreateBundle6() throws IOException {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}
   */
  @Test
  public void testGetCacheKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertEquals("1.0.2", resourceBundlingServiceImpl.getCacheKey("1.0.2", new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}
   */
  @Test
  public void testGetCacheKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act and Assert
    assertEquals("1.0.2", resourceBundlingServiceImpl.getCacheKey("1.0.2", files));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getCacheKey(String, List)}
   */
  @Test
  public void testGetCacheKey3() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundleName(String, String)}
   */
  @Test
  public void testGetBundleName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1.0.2.css", (new ResourceBundlingServiceImpl()).getBundleName(".css", "1.0.2"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  public void testGetBundleVersion() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();

    // Act and Assert
    assertEquals("0", resourceBundlingServiceImpl.getBundleVersion(new LinkedHashMap<>()));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  public void testGetBundleVersion2() throws IOException {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  public void testGetBundleVersion3() throws IOException {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getBundleVersion(LinkedHashMap)}
   */
  @Test
  public void testGetBundleVersion4() throws IOException {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getAdditionalBundleFiles(String)}
   */
  @Test
  public void testGetAdditionalBundleFiles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(new HashMap<>());

    // Act and Assert
    assertNull(resourceBundlingServiceImpl.getAdditionalBundleFiles("Bundle Name"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getAdditionalBundleFiles(String)}
   */
  @Test
  public void testGetAdditionalBundleFiles2() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#addVersion(String, String)}
   */
  @Test
  public void testAddVersion() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Request Path1.0.2.null", (new ResourceBundlingServiceImpl()).addVersion("Request Path", "1.0.2"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#addVersion(String, String)}
   */
  @Test
  public void testAddVersion2() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}
   */
  @Test
  public void testFindResourceHttpRequestHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ResourceBundlingServiceImpl()).findResourceHttpRequestHandler("https://example.org/example"));
    assertNull((new ResourceBundlingServiceImpl()).findResourceHttpRequestHandler(".js"));
    assertNull((new ResourceBundlingServiceImpl()).findResourceHttpRequestHandler(".css"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#findResourceHttpRequestHandler(String)}
   */
  @Test
  public void testFindResourceHttpRequestHandler2() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}
   */
  @Test
  public void testIsJavaScriptResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).isJavaScriptResource("Resource Name"));
    assertFalse((new ResourceBundlingServiceImpl()).isJavaScriptResource(null));
    assertTrue((new ResourceBundlingServiceImpl()).isJavaScriptResource(".js"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#isJavaScriptResource(String)}
   */
  @Test
  public void testIsJavaScriptResource2() {
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
   * Method under test: {@link ResourceBundlingServiceImpl#isCSSResource(String)}
   */
  @Test
  public void testIsCSSResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).isCSSResource("Resource Name"));
    assertFalse((new ResourceBundlingServiceImpl()).isCSSResource(null));
    assertTrue((new ResourceBundlingServiceImpl()).isCSSResource(".css"));
  }

  /**
   * Method under test: {@link ResourceBundlingServiceImpl#isCSSResource(String)}
   */
  @Test
  public void testIsCSSResource2() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getResourcePath(String)}
   */
  @Test
  public void testGetResourcePath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("bundles/Name", (new ResourceBundlingServiceImpl()).getResourcePath("Name"));
    assertEquals("bundles/", (new ResourceBundlingServiceImpl()).getResourcePath("/"));
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#getResourcePath(String)}
   */
  @Test
  public void testGetResourcePath2() {
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
   * Method under test:
   * {@link ResourceBundlingServiceImpl#findBundlesNameByResourceFileName(String)}
   */
  @Test
  public void testFindBundlesNameByResourceFileName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ResourceBundlingServiceImpl()).findBundlesNameByResourceFileName("foo.txt").isEmpty());
  }

  /**
   * Method under test:
   * {@link ResourceBundlingServiceImpl#findBundlesNameByResourceFileName(String)}
   */
  @Test
  public void testFindBundlesNameByResourceFileName2() {
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
   * Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  public void testRemoveBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ResourceBundlingServiceImpl()).removeBundle("Bundle Name"));
    assertFalse((new ResourceBundlingServiceImpl()).removeBundle(".css"));
    assertFalse((new ResourceBundlingServiceImpl()).removeBundle(".js"));
  }

  /**
   * Method under test: {@link ResourceBundlingServiceImpl#removeBundle(String)}
   */
  @Test
  public void testRemoveBundle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, List<String>> additionalBundleFiles = new HashMap<>();
    additionalBundleFiles.computeIfPresent("foo", mock(BiFunction.class));

    ResourceBundlingServiceImpl resourceBundlingServiceImpl = new ResourceBundlingServiceImpl();
    resourceBundlingServiceImpl.setAdditionalBundleFiles(additionalBundleFiles);

    // Act and Assert
    assertFalse(resourceBundlingServiceImpl.removeBundle("Bundle Name"));
  }
}
