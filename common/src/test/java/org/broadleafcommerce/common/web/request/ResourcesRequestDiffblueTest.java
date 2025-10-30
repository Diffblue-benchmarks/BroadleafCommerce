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
package org.broadleafcommerce.common.web.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ResourcesRequestDiffblueTest {
  @InjectMocks
  private ResourcesRequest resourcesRequest;

  /**
   * Test {@link ResourcesRequest#getBundle(String, String, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcesRequest#getBundle(String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourcesRequestBundle ResourcesRequest.getBundle(String, String, List)"})
  public void testGetBundle_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    files.add("42");
    files.add("foo");

    // Act and Assert
    assertNull(resourcesRequest.getBundle("Name", "Mapping Prefix", files));
  }

  /**
   * Test {@link ResourcesRequest#getBundle(String, String, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcesRequest#getBundle(String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourcesRequestBundle ResourcesRequest.getBundle(String, String, List)"})
  public void testGetBundle_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act and Assert
    assertNull(resourcesRequest.getBundle("Name", "Mapping Prefix", files));
  }

  /**
   * Test {@link ResourcesRequest#getBundle(String, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcesRequest#getBundle(String, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourcesRequestBundle ResourcesRequest.getBundle(String, String, List)"})
  public void testGetBundle_whenArrayList() {
    // Arrange, Act and Assert
    assertNull(resourcesRequest.getBundle("Name", "Mapping Prefix", new ArrayList<>()));
  }

  /**
   * Test {@link ResourcesRequest#saveBundle(String, String, List, String)} with {@code name}, {@code mappingPrefix}, {@code files}, {@code bundlePath}.
   * <p>
   * Method under test: {@link ResourcesRequest#saveBundle(String, String, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourcesRequest.saveBundle(String, String, List, String)"})
  public void testSaveBundleWithNameMappingPrefixFilesBundlePath() {
    // Arrange and Act
    resourcesRequest.saveBundle("Name", "Mapping Prefix", new ArrayList<>(), "Bundle Path");

    // Assert
    List<ResourcesRequestBundle> resourcesRequestBundleList = resourcesRequest.bundlesRequested;
    assertEquals(1, resourcesRequestBundleList.size());
    ResourcesRequestBundle getResult = resourcesRequestBundleList.get(0);
    assertEquals("Bundle Path", getResult.getBundlePath());
    assertEquals("Mapping Prefix", getResult.getMappingPrefix());
    assertEquals("Name", getResult.getBundleName());
    assertNull(getResult.getBundleFilePaths());
    assertTrue(getResult.getFiles().isEmpty());
  }

  /**
   * Test {@link ResourcesRequest#saveBundle(String, String, List, String)} with {@code name}, {@code mappingPrefix}, {@code files}, {@code bundlePath}.
   * <p>
   * Method under test: {@link ResourcesRequest#saveBundle(String, String, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourcesRequest.saveBundle(String, String, List, String)"})
  public void testSaveBundleWithNameMappingPrefixFilesBundlePath2() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act
    resourcesRequest.saveBundle("Name", "Mapping Prefix", files, "Bundle Path");

    // Assert
    List<ResourcesRequestBundle> resourcesRequestBundleList = resourcesRequest.bundlesRequested;
    assertEquals(1, resourcesRequestBundleList.size());
    ResourcesRequestBundle getResult = resourcesRequestBundleList.get(0);
    assertEquals("Bundle Path", getResult.getBundlePath());
    assertEquals("Mapping Prefix", getResult.getMappingPrefix());
    assertEquals("Name", getResult.getBundleName());
    assertNull(getResult.getBundleFilePaths());
    assertEquals(files, getResult.getFiles());
  }

  /**
   * Test {@link ResourcesRequest#saveBundle(String, String, List, String)} with {@code name}, {@code mappingPrefix}, {@code files}, {@code bundlePath}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcesRequest#saveBundle(String, String, List, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourcesRequest.saveBundle(String, String, List, String)"})
  public void testSaveBundleWithNameMappingPrefixFilesBundlePath_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    files.add("42");
    files.add("foo");

    // Act
    resourcesRequest.saveBundle("Name", "Mapping Prefix", files, "Bundle Path");

    // Assert
    List<ResourcesRequestBundle> resourcesRequestBundleList = resourcesRequest.bundlesRequested;
    assertEquals(1, resourcesRequestBundleList.size());
    ResourcesRequestBundle getResult = resourcesRequestBundleList.get(0);
    assertEquals("Bundle Path", getResult.getBundlePath());
    assertEquals("Mapping Prefix", getResult.getMappingPrefix());
    assertEquals("Name", getResult.getBundleName());
    assertNull(getResult.getBundleFilePaths());
    assertEquals(files, getResult.getFiles());
  }

  /**
   * Test {@link ResourcesRequest#saveBundle(String, String, List, List)} with {@code name}, {@code mappingPrefix}, {@code files}, {@code bundledFilePaths}.
   * <p>
   * Method under test: {@link ResourcesRequest#saveBundle(String, String, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourcesRequest.saveBundle(String, String, List, List)"})
  public void testSaveBundleWithNameMappingPrefixFilesBundledFilePaths() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();

    // Act
    resourcesRequest.saveBundle("Name", "Mapping Prefix", files, new ArrayList<>());

    // Assert
    List<ResourcesRequestBundle> resourcesRequestBundleList = resourcesRequest.bundlesRequested;
    assertEquals(1, resourcesRequestBundleList.size());
    ResourcesRequestBundle getResult = resourcesRequestBundleList.get(0);
    assertEquals("Mapping Prefix", getResult.getMappingPrefix());
    assertEquals("Name", getResult.getBundleName());
    assertNull(getResult.getBundlePath());
    assertTrue(getResult.getBundleFilePaths().isEmpty());
    assertTrue(getResult.getFiles().isEmpty());
  }

  /**
   * Test {@link ResourcesRequest#saveBundle(String, String, List, List)} with {@code name}, {@code mappingPrefix}, {@code files}, {@code bundledFilePaths}.
   * <p>
   * Method under test: {@link ResourcesRequest#saveBundle(String, String, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourcesRequest.saveBundle(String, String, List, List)"})
  public void testSaveBundleWithNameMappingPrefixFilesBundledFilePaths2() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act
    resourcesRequest.saveBundle("Name", "Mapping Prefix", files, new ArrayList<>());

    // Assert
    List<ResourcesRequestBundle> resourcesRequestBundleList = resourcesRequest.bundlesRequested;
    assertEquals(1, resourcesRequestBundleList.size());
    ResourcesRequestBundle getResult = resourcesRequestBundleList.get(0);
    assertEquals("Mapping Prefix", getResult.getMappingPrefix());
    assertEquals("Name", getResult.getBundleName());
    assertNull(getResult.getBundlePath());
    assertTrue(getResult.getBundleFilePaths().isEmpty());
    assertEquals(files, getResult.getFiles());
  }

  /**
   * Test {@link ResourcesRequest#saveBundle(String, String, List, List)} with {@code name}, {@code mappingPrefix}, {@code files}, {@code bundledFilePaths}.
   * <p>
   * Method under test: {@link ResourcesRequest#saveBundle(String, String, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourcesRequest.saveBundle(String, String, List, List)"})
  public void testSaveBundleWithNameMappingPrefixFilesBundledFilePaths3() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    files.add("42");
    files.add("foo");

    // Act
    resourcesRequest.saveBundle("Name", "Mapping Prefix", files, new ArrayList<>());

    // Assert
    List<ResourcesRequestBundle> resourcesRequestBundleList = resourcesRequest.bundlesRequested;
    assertEquals(1, resourcesRequestBundleList.size());
    ResourcesRequestBundle getResult = resourcesRequestBundleList.get(0);
    assertEquals("Mapping Prefix", getResult.getMappingPrefix());
    assertEquals("Name", getResult.getBundleName());
    assertNull(getResult.getBundlePath());
    assertTrue(getResult.getBundleFilePaths().isEmpty());
    assertEquals(files, getResult.getFiles());
  }

  /**
   * Test {@link ResourcesRequest#saveBundle(String, String, List, List)} with {@code name}, {@code mappingPrefix}, {@code files}, {@code bundledFilePaths}.
   * <p>
   * Method under test: {@link ResourcesRequest#saveBundle(String, String, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourcesRequest.saveBundle(String, String, List, List)"})
  public void testSaveBundleWithNameMappingPrefixFilesBundledFilePaths4() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();

    ArrayList<String> bundledFilePaths = new ArrayList<>();
    bundledFilePaths.add("foo");

    // Act
    resourcesRequest.saveBundle("Name", "Mapping Prefix", files, bundledFilePaths);

    // Assert
    List<ResourcesRequestBundle> resourcesRequestBundleList = resourcesRequest.bundlesRequested;
    assertEquals(1, resourcesRequestBundleList.size());
    ResourcesRequestBundle getResult = resourcesRequestBundleList.get(0);
    List<String> bundleFilePaths = getResult.getBundleFilePaths();
    assertEquals(1, bundleFilePaths.size());
    assertEquals("foo", bundleFilePaths.get(0));
    assertTrue(getResult.getFiles().isEmpty());
  }

  /**
   * Test {@link ResourcesRequest#saveBundle(String, String, List, List)} with {@code name}, {@code mappingPrefix}, {@code files}, {@code bundledFilePaths}.
   * <p>
   * Method under test: {@link ResourcesRequest#saveBundle(String, String, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourcesRequest.saveBundle(String, String, List, List)"})
  public void testSaveBundleWithNameMappingPrefixFilesBundledFilePaths5() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();

    ArrayList<String> bundledFilePaths = new ArrayList<>();
    bundledFilePaths.add("42");
    bundledFilePaths.add("foo");

    // Act
    resourcesRequest.saveBundle("Name", "Mapping Prefix", files, bundledFilePaths);

    // Assert
    List<ResourcesRequestBundle> resourcesRequestBundleList = resourcesRequest.bundlesRequested;
    assertEquals(1, resourcesRequestBundleList.size());
    assertEquals(bundledFilePaths, resourcesRequestBundleList.get(0).getBundleFilePaths());
  }
}
