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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.file.FileServiceException;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.file.service.type.FileApplicationType;
import org.codehaus.groovy.runtime.WritablePath;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FileSystemFileServiceProviderDiffblueTest {
  @InjectMocks
  private FileSystemFileServiceProvider fileSystemFileServiceProvider;

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)} with {@code url}, {@code applicationType}.
   * <ul>
   *   <li>Then return Name is {@code example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String, FileApplicationType)"})
  public void testGetResourceWithUrlApplicationType_thenReturnNameIsExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)} with {@code url}, {@code applicationType}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String, FileApplicationType)"})
  public void testGetResourceWithUrlApplicationType_whenSlash_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with {@code url}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return Name is {@code example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String)"})
  public void testGetResourceWithUrl_whenHttpsExampleOrgExample_thenReturnNameIsExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with {@code url}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String)"})
  public void testGetResourceWithUrl_whenSlash_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FileSystemFileServiceProvider.addOrUpdateResources(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResources() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FileSystemFileServiceProvider.addOrUpdateResources(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResources2() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link FileWorkArea#getFilePathLocation()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FileSystemFileServiceProvider.addOrUpdateResources(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResources_givenEmptyString_thenCallsGetFilePathLocation() {
    // Arrange
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");
    doNothing().when(workArea).setFilePathLocation(Mockito.<String>any());
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
    verify(workArea).setFilePathLocation(eq("/directory/foo.txt"));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>Then calls {@link WritablePath#toFile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FileSystemFileServiceProvider.addOrUpdateResources(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResources_thenCallsToFile() {
    // Arrange
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");
    doNothing().when(workArea).setFilePathLocation(Mockito.<String>any());
    workArea.setFilePathLocation("/directory/foo.txt");
    WritablePath writablePath = mock(WritablePath.class);
    when(writablePath.toFile()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    File toFileResult = writablePath.toFile();

    ArrayList<File> files = new ArrayList<>();
    files.add(toFileResult);
    System.getProperty("java.io.tmpdir");

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
    verify(workArea).setFilePathLocation(eq("/directory/foo.txt"));
    verify(writablePath).toFile();
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link FileWorkArea#getFilePathLocation()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FileSystemFileServiceProvider.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesForPaths_givenEmptyString_thenCallsGetFilePathLocation() {
    // Arrange
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");
    doNothing().when(workArea).setFilePathLocation(Mockito.<String>any());
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, files, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
    verify(workArea).setFilePathLocation(eq("/directory/foo.txt"));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>Then throw {@link FileServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FileSystemFileServiceProvider.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesForPaths_thenThrowFileServiceException() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>Then throw {@link FileServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FileSystemFileServiceProvider.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesForPaths_thenThrowFileServiceException2() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FileSystemFileServiceProvider.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesForPaths_whenArrayList_thenReturnEmpty() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertTrue(fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test {@link FileSystemFileServiceProvider#removeResource(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#removeResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FileSystemFileServiceProvider.removeResource(String)"})
  public void testRemoveResource_whenName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fileSystemFileServiceProvider.removeResource("Name"));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#buildResourceName(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#buildResourceName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileSystemFileServiceProvider.buildResourceName(String)"})
  public void testBuildResourceName_whenHttpsExampleOrgExample_thenReturnExample() {
    // Arrange, Act and Assert
    assertEquals("example", fileSystemFileServiceProvider.buildResourceName("https://example.org/example"));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#buildResourceName(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#buildResourceName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileSystemFileServiceProvider.buildResourceName(String)"})
  public void testBuildResourceName_whenSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", fileSystemFileServiceProvider.buildResourceName("/"));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileSystemFileServiceProvider.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory_whenFalse() {
    // Arrange, Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.getBaseDirectory(false));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileSystemFileServiceProvider.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory_whenTrue() {
    // Arrange, Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.getBaseDirectory(true));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getSiteDirectory(String)}.
   * <p>
   * Method under test: {@link FileSystemFileServiceProvider#getSiteDirectory(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FileSystemFileServiceProvider.getSiteDirectory(String)"})
  public void testGetSiteDirectory() {
    // Arrange, Act and Assert
    assertEquals("/directory", fileSystemFileServiceProvider.getSiteDirectory("/directory"));
  }
}
