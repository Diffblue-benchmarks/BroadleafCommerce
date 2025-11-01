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
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ResourcesRequestDiffblueTest {
  /**
   * Method under test: {@link ResourcesRequest#getBundle(String, String, List)}
   */
  @Test
  public void testGetBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();

    // Act and Assert
    assertNull(resourcesRequest.getBundle("Name", "Mapping Prefix", new ArrayList<>()));
  }

  /**
   * Method under test: {@link ResourcesRequest#getBundle(String, String, List)}
   */
  @Test
  public void testGetBundle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();

    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act and Assert
    assertNull(resourcesRequest.getBundle("Name", "Mapping Prefix", files));
  }

  /**
   * Method under test: {@link ResourcesRequest#getBundle(String, String, List)}
   */
  @Test
  public void testGetBundle3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();

    ArrayList<String> files = new ArrayList<>();
    files.add("42");
    files.add("foo");

    // Act and Assert
    assertNull(resourcesRequest.getBundle("Name", "Mapping Prefix", files));
  }

  /**
   * Method under test:
   * {@link ResourcesRequest#saveBundle(String, String, List, String)}
   */
  @Test
  public void testSaveBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();

    // Act
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
   * Method under test:
   * {@link ResourcesRequest#saveBundle(String, String, List, String)}
   */
  @Test
  public void testSaveBundle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();

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
    List<String> files2 = getResult.getFiles();
    assertEquals(1, files2.size());
    assertEquals("foo", files2.get(0));
    assertNull(getResult.getBundleFilePaths());
  }

  /**
   * Method under test:
   * {@link ResourcesRequest#saveBundle(String, String, List, String)}
   */
  @Test
  public void testSaveBundle3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();

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
   * Method under test:
   * {@link ResourcesRequest#saveBundle(String, String, List, List)}
   */
  @Test
  public void testSaveBundle4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();
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
   * Method under test:
   * {@link ResourcesRequest#saveBundle(String, String, List, List)}
   */
  @Test
  public void testSaveBundle5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();

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
    List<String> files2 = getResult.getFiles();
    assertEquals(1, files2.size());
    assertEquals("foo", files2.get(0));
    assertNull(getResult.getBundlePath());
    assertTrue(getResult.getBundleFilePaths().isEmpty());
  }

  /**
   * Method under test:
   * {@link ResourcesRequest#saveBundle(String, String, List, List)}
   */
  @Test
  public void testSaveBundle6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();

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
   * Method under test:
   * {@link ResourcesRequest#saveBundle(String, String, List, List)}
   */
  @Test
  public void testSaveBundle7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();
    ArrayList<String> files = new ArrayList<>();

    ArrayList<String> bundledFilePaths = new ArrayList<>();
    bundledFilePaths.add("foo");

    // Act
    resourcesRequest.saveBundle("Name", "Mapping Prefix", files, bundledFilePaths);

    // Assert
    List<ResourcesRequestBundle> resourcesRequestBundleList = resourcesRequest.bundlesRequested;
    assertEquals(1, resourcesRequestBundleList.size());
    ResourcesRequestBundle getResult = resourcesRequestBundleList.get(0);
    assertEquals("Mapping Prefix", getResult.getMappingPrefix());
    assertEquals("Name", getResult.getBundleName());
    List<String> bundleFilePaths = getResult.getBundleFilePaths();
    assertEquals(1, bundleFilePaths.size());
    assertEquals("foo", bundleFilePaths.get(0));
    assertNull(getResult.getBundlePath());
    assertTrue(getResult.getFiles().isEmpty());
  }

  /**
   * Method under test:
   * {@link ResourcesRequest#saveBundle(String, String, List, List)}
   */
  @Test
  public void testSaveBundle8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcesRequest resourcesRequest = new ResourcesRequest();
    ArrayList<String> files = new ArrayList<>();

    ArrayList<String> bundledFilePaths = new ArrayList<>();
    bundledFilePaths.add("42");
    bundledFilePaths.add("foo");

    // Act
    resourcesRequest.saveBundle("Name", "Mapping Prefix", files, bundledFilePaths);

    // Assert
    List<ResourcesRequestBundle> resourcesRequestBundleList = resourcesRequest.bundlesRequested;
    assertEquals(1, resourcesRequestBundleList.size());
    ResourcesRequestBundle getResult = resourcesRequestBundleList.get(0);
    assertEquals("Mapping Prefix", getResult.getMappingPrefix());
    assertEquals("Name", getResult.getBundleName());
    assertNull(getResult.getBundlePath());
    assertTrue(getResult.getFiles().isEmpty());
    assertEquals(bundledFilePaths, getResult.getBundleFilePaths());
  }
}
