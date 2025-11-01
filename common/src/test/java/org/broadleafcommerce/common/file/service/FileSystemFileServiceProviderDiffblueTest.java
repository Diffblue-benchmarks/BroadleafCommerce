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
   * Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  public void testGetResource() {
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
   * Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  public void testGetResource2() {
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
   * Method under test:
   * {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)}
   */
  @Test
  public void testGetResource3() {
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
   * Method under test:
   * {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)}
   */
  @Test
  public void testGetResource4() {
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
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResources() {
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
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResources2() {
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
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = new FileWorkArea();

    // Act and Assert
    assertTrue(fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true).isEmpty());
  }

  /**
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);

    // Act and Assert
    assertTrue(fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true).isEmpty());
  }

  /**
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths3() {
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
   * Method under test:
   * {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths4() {
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
   * Method under test:
   * {@link FileSystemFileServiceProvider#removeResource(String)}
   */
  @Test
  public void testRemoveResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();

    // Act and Assert
    assertFalse(fileSystemFileServiceProvider.removeResource("Name"));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Method under test:
   * {@link FileSystemFileServiceProvider#removeResource(String)}
   */
  @Test
  public void testRemoveResource2() {
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
   * Method under test:
   * {@link FileSystemFileServiceProvider#buildResourceName(String)}
   */
  @Test
  public void testBuildResourceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("example", (new FileSystemFileServiceProvider()).buildResourceName("https://example.org/example"));
    assertEquals("", (new FileSystemFileServiceProvider()).buildResourceName("/"));
  }

  /**
   * Method under test:
   * {@link FileSystemFileServiceProvider#buildResourceName(String)}
   */
  @Test
  public void testBuildResourceName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    fileSystemFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    // Act and Assert
    assertEquals("example", fileSystemFileServiceProvider.buildResourceName("https://example.org/example"));
  }

  /**
   * Method under test:
   * {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}
   */
  @Test
  public void testGetBaseDirectory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();

    // Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.getBaseDirectory(true));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Method under test:
   * {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}
   */
  @Test
  public void testGetBaseDirectory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider = new FileSystemFileServiceProvider();
    FileWorkArea workArea = mock(FileWorkArea.class);
    fileSystemFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    // Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.getBaseDirectory(true));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }
}
