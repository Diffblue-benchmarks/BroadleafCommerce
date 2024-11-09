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
package org.broadleafcommerce.common.file.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.file.FileServiceException;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.file.service.type.FileApplicationType;
import org.junit.Test;

public class FileSystemFileServiceProviderDiffblueTest {
  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with
   * {@code url}.
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  public void testGetResourceWithUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    fileSystemFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    // Act
    File actualResource = fileSystemFileServiceProvider.getResource("https://example.org/example");

    // Assert
    assertEquals("example", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test
   * {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)}
   * with {@code url}, {@code applicationType}.
   * <ul>
   *   <li>Then return Name is {@code example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)}
   */
  @Test
  public void testGetResourceWithUrlApplicationType_thenReturnNameIsExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();

    // Act
    File actualResource = fileSystemFileServiceProvider.getResource("https://example.org/example",
        FileApplicationType.ALL);

    // Assert
    assertEquals("example", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test
   * {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)}
   * with {@code url}, {@code applicationType}.
   * <ul>
   *   <li>When {@link FileApplicationType}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)}
   */
  @Test
  public void testGetResourceWithUrlApplicationType_whenFileApplicationType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();

    // Act
    File actualResource = fileSystemFileServiceProvider.getResource("https://example.org/example",
        mock(FileApplicationType.class));

    // Assert
    assertEquals("example", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test
   * {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)}
   * with {@code url}, {@code applicationType}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)}
   */
  @Test
  public void testGetResourceWithUrlApplicationType_whenSlash_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();

    // Act
    File actualResource = fileSystemFileServiceProvider.getResource("/", FileApplicationType.ALL);

    // Assert
    assertEquals("T", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with
   * {@code url}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return Name is {@code example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  public void testGetResourceWithUrl_whenHttpsExampleOrgExample_thenReturnNameIsExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();

    // Act
    File actualResource = fileSystemFileServiceProvider.getResource("https://example.org/example");

    // Assert
    assertEquals("example", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with
   * {@code url}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  public void testGetResourceWithUrl_whenSlash_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();

    // Act
    File actualResource = fileSystemFileServiceProvider.getResource("/");

    // Assert
    assertEquals("T", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test
   * {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResources_givenDirectoryFooTxt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
  }

  /**
   * Test
   * {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResources_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
  }

  /**
   * Test
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths_givenDirectoryFooTxt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, files, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
  }

  /**
   * Test
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, files, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
  }

  /**
   * Test
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = new FileWorkArea();

    // Act and Assert
    assertTrue(fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>When {@link FileWorkArea}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths_whenFileWorkArea_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);

    // Act and Assert
    assertTrue(fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test {@link FileSystemFileServiceProvider#removeResource(String)}.
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#removeResource(String)}
   */
  @Test
  public void testRemoveResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    fileSystemFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    // Act and Assert
    assertFalse(fileSystemFileServiceProvider.removeResource("Name"));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#removeResource(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#removeResource(String)}
   */
  @Test
  public void testRemoveResource_whenName_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();

    // Act and Assert
    assertFalse(fileSystemFileServiceProvider.removeResource("Name"));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#buildResourceName(String)}.
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#buildResourceName(String)}
   */
  @Test
  public void testBuildResourceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    fileSystemFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    // Act and Assert
    assertEquals("example", fileSystemFileServiceProvider.buildResourceName("https://example.org/example"));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#buildResourceName(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#buildResourceName(String)}
   */
  @Test
  public void testBuildResourceName_whenHttpsExampleOrgExample_thenReturnExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("example", (new FileSystemFileServiceProvider()).buildResourceName("https://example.org/example"));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#buildResourceName(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#buildResourceName(String)}
   */
  @Test
  public void testBuildResourceName_whenSlash_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new FileSystemFileServiceProvider()).buildResourceName("/"));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}.
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}
   */
  @Test
  public void testGetBaseDirectory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    fileSystemFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    // Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.getBaseDirectory(true));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}
   */
  @Test
  public void testGetBaseDirectory_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();

    // Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.getBaseDirectory(false));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}
   */
  @Test
  public void testGetBaseDirectory_whenTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();

    // Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.getBaseDirectory(true));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getSiteDirectory(String)}.
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#getSiteDirectory(String)}
   */
  @Test
  public void testGetSiteDirectory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("/directory", (new FileSystemFileServiceProvider()).getSiteDirectory("/directory"));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getSiteDirectory(String)}.
   * <p>
   * Method under test:
   * {@link FileSystemFileServiceProvider#getSiteDirectory(String)}
   */
  @Test
  public void testGetSiteDirectory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    fileSystemFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    // Act and Assert
    assertEquals("/directory", fileSystemFileServiceProvider.getSiteDirectory("/directory"));
  }
}
