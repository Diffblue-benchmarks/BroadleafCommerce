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
import org.springframework.boot.test.mock.mockito.MockBean;

public class ResourcesRequestBundleDiffblueTest {
  @MockBean
  private ResourcesRequestBundle resourcesRequestBundle;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourcesRequestBundle#getBundleFilePaths()}
   *   <li>{@link ResourcesRequestBundle#getBundleName()}
   *   <li>{@link ResourcesRequestBundle#getBundlePath()}
   *   <li>{@link ResourcesRequestBundle#getFiles()}
   *   <li>{@link ResourcesRequestBundle#getMappingPrefix()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ResourcesRequestBundle resourcesRequestBundle = new ResourcesRequestBundle("Bundle Name", "Mapping Prefix",
        new ArrayList<>(), "Bundle Path");

    // Act
    List<String> actualBundleFilePaths = resourcesRequestBundle.getBundleFilePaths();
    String actualBundleName = resourcesRequestBundle.getBundleName();
    String actualBundlePath = resourcesRequestBundle.getBundlePath();
    List<String> actualFiles = resourcesRequestBundle.getFiles();

    // Assert
    assertEquals("Bundle Name", actualBundleName);
    assertEquals("Bundle Path", actualBundlePath);
    assertEquals("Mapping Prefix", resourcesRequestBundle.getMappingPrefix());
    assertNull(actualBundleFilePaths);
    assertTrue(actualFiles.isEmpty());
  }

  /**
   * Method under test:
   * {@link ResourcesRequestBundle#ResourcesRequestBundle(String, String, List, String)}
   */
  @Test
  public void testNewResourcesRequestBundle() {
    // Arrange and Act
    ResourcesRequestBundle actualResourcesRequestBundle = new ResourcesRequestBundle("Bundle Name", "Mapping Prefix",
        new ArrayList<>(), "Bundle Path");

    // Assert
    assertEquals("Bundle Name", actualResourcesRequestBundle.getBundleName());
    assertEquals("Bundle Path", actualResourcesRequestBundle.getBundlePath());
    assertEquals("Mapping Prefix", actualResourcesRequestBundle.getMappingPrefix());
    assertNull(actualResourcesRequestBundle.getBundleFilePaths());
    assertTrue(actualResourcesRequestBundle.getFiles().isEmpty());
  }

  /**
   * Method under test:
   * {@link ResourcesRequestBundle#ResourcesRequestBundle(String, String, List, String)}
   */
  @Test
  public void testNewResourcesRequestBundle2() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act
    ResourcesRequestBundle actualResourcesRequestBundle = new ResourcesRequestBundle("Bundle Name", "Mapping Prefix",
        files, "Bundle Path");

    // Assert
    assertEquals("Bundle Name", actualResourcesRequestBundle.getBundleName());
    assertEquals("Bundle Path", actualResourcesRequestBundle.getBundlePath());
    assertEquals("Mapping Prefix", actualResourcesRequestBundle.getMappingPrefix());
    List<String> files2 = actualResourcesRequestBundle.getFiles();
    assertEquals(1, files2.size());
    assertEquals("foo", files2.get(0));
    assertNull(actualResourcesRequestBundle.getBundleFilePaths());
  }

  /**
   * Method under test:
   * {@link ResourcesRequestBundle#ResourcesRequestBundle(String, String, List, String)}
   */
  @Test
  public void testNewResourcesRequestBundle3() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    files.add("42");
    files.add("foo");

    // Act
    ResourcesRequestBundle actualResourcesRequestBundle = new ResourcesRequestBundle("Bundle Name", "Mapping Prefix",
        files, "Bundle Path");

    // Assert
    assertEquals("Bundle Name", actualResourcesRequestBundle.getBundleName());
    assertEquals("Bundle Path", actualResourcesRequestBundle.getBundlePath());
    assertEquals("Mapping Prefix", actualResourcesRequestBundle.getMappingPrefix());
    assertNull(actualResourcesRequestBundle.getBundleFilePaths());
    assertEquals(files, actualResourcesRequestBundle.getFiles());
  }

  /**
   * Method under test:
   * {@link ResourcesRequestBundle#ResourcesRequestBundle(String, String, List, List)}
   */
  @Test
  public void testNewResourcesRequestBundle4() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();

    // Act
    ResourcesRequestBundle actualResourcesRequestBundle = new ResourcesRequestBundle("Bundle Name", "Mapping Prefix",
        files, new ArrayList<>());

    // Assert
    assertEquals("Bundle Name", actualResourcesRequestBundle.getBundleName());
    assertEquals("Mapping Prefix", actualResourcesRequestBundle.getMappingPrefix());
    assertNull(actualResourcesRequestBundle.getBundlePath());
    assertTrue(actualResourcesRequestBundle.getBundleFilePaths().isEmpty());
    assertTrue(actualResourcesRequestBundle.getFiles().isEmpty());
  }

  /**
   * Method under test:
   * {@link ResourcesRequestBundle#ResourcesRequestBundle(String, String, List, List)}
   */
  @Test
  public void testNewResourcesRequestBundle5() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    files.add("foo");

    // Act
    ResourcesRequestBundle actualResourcesRequestBundle = new ResourcesRequestBundle("Bundle Name", "Mapping Prefix",
        files, new ArrayList<>());

    // Assert
    assertEquals("Bundle Name", actualResourcesRequestBundle.getBundleName());
    assertEquals("Mapping Prefix", actualResourcesRequestBundle.getMappingPrefix());
    List<String> files2 = actualResourcesRequestBundle.getFiles();
    assertEquals(1, files2.size());
    assertEquals("foo", files2.get(0));
    assertNull(actualResourcesRequestBundle.getBundlePath());
    assertTrue(actualResourcesRequestBundle.getBundleFilePaths().isEmpty());
  }

  /**
   * Method under test:
   * {@link ResourcesRequestBundle#ResourcesRequestBundle(String, String, List, List)}
   */
  @Test
  public void testNewResourcesRequestBundle6() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();
    files.add("42");
    files.add("foo");

    // Act
    ResourcesRequestBundle actualResourcesRequestBundle = new ResourcesRequestBundle("Bundle Name", "Mapping Prefix",
        files, new ArrayList<>());

    // Assert
    assertEquals("Bundle Name", actualResourcesRequestBundle.getBundleName());
    assertEquals("Mapping Prefix", actualResourcesRequestBundle.getMappingPrefix());
    assertNull(actualResourcesRequestBundle.getBundlePath());
    assertTrue(actualResourcesRequestBundle.getBundleFilePaths().isEmpty());
    assertEquals(files, actualResourcesRequestBundle.getFiles());
  }

  /**
   * Method under test:
   * {@link ResourcesRequestBundle#ResourcesRequestBundle(String, String, List, List)}
   */
  @Test
  public void testNewResourcesRequestBundle7() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();

    ArrayList<String> bundleFilePaths = new ArrayList<>();
    bundleFilePaths.add("foo");

    // Act
    ResourcesRequestBundle actualResourcesRequestBundle = new ResourcesRequestBundle("Bundle Name", "Mapping Prefix",
        files, bundleFilePaths);

    // Assert
    assertEquals("Bundle Name", actualResourcesRequestBundle.getBundleName());
    assertEquals("Mapping Prefix", actualResourcesRequestBundle.getMappingPrefix());
    List<String> bundleFilePaths2 = actualResourcesRequestBundle.getBundleFilePaths();
    assertEquals(1, bundleFilePaths2.size());
    assertEquals("foo", bundleFilePaths2.get(0));
    assertNull(actualResourcesRequestBundle.getBundlePath());
    assertTrue(actualResourcesRequestBundle.getFiles().isEmpty());
  }

  /**
   * Method under test:
   * {@link ResourcesRequestBundle#ResourcesRequestBundle(String, String, List, List)}
   */
  @Test
  public void testNewResourcesRequestBundle8() {
    // Arrange
    ArrayList<String> files = new ArrayList<>();

    ArrayList<String> bundleFilePaths = new ArrayList<>();
    bundleFilePaths.add("42");
    bundleFilePaths.add("foo");

    // Act
    ResourcesRequestBundle actualResourcesRequestBundle = new ResourcesRequestBundle("Bundle Name", "Mapping Prefix",
        files, bundleFilePaths);

    // Assert
    assertEquals("Bundle Name", actualResourcesRequestBundle.getBundleName());
    assertEquals("Mapping Prefix", actualResourcesRequestBundle.getMappingPrefix());
    assertNull(actualResourcesRequestBundle.getBundlePath());
    assertTrue(actualResourcesRequestBundle.getFiles().isEmpty());
    assertEquals(bundleFilePaths, actualResourcesRequestBundle.getBundleFilePaths());
  }
}
