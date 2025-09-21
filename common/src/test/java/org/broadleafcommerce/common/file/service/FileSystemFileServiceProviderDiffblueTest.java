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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.file.FileServiceException;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.broadleafcommerce.common.file.service.type.FileApplicationType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class FileSystemFileServiceProviderDiffblueTest {
  @Mock private BroadleafFileServiceExtensionManager broadleafFileServiceExtensionManager;

  @InjectMocks private FileSystemFileServiceProvider fileSystemFileServiceProvider;

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with {@code url}.
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String)"})
  public void testGetResourceWithUrl() {
    // Arrange
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenThrow(new FileServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.getResource("https://example.org/example"));
    verify(broadleafFileServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with {@code url}.
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String)"})
  public void testGetResourceWithUrl2() {
    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider =
        new FileSystemFileServiceProvider();

    // Act
    File actualResource = fileSystemFileServiceProvider.getResource("https://example.org/example");

    // Assert
    assertEquals("example", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)} with {@code
   * url}, {@code applicationType}.
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String,
   * FileApplicationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String, FileApplicationType)"})
  public void testGetResourceWithUrlApplicationType() {
    // Arrange
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenThrow(new FileServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () ->
            fileSystemFileServiceProvider.getResource(
                "https://example.org/example", FileApplicationType.ALL));
    verify(broadleafFileServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)} with {@code
   * url}, {@code applicationType}.
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String,
   * FileApplicationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String, FileApplicationType)"})
  public void testGetResourceWithUrlApplicationType2() {
    // Arrange
    FileSystemFileServiceProvider fileSystemFileServiceProvider =
        new FileSystemFileServiceProvider();

    // Act
    File actualResource =
        fileSystemFileServiceProvider.getResource(
            "https://example.org/example", FileApplicationType.ALL);

    // Assert
    assertEquals("example", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)} with {@code
   * url}, {@code applicationType}.
   *
   * <ul>
   *   <li>Then return Name is {@code example}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String,
   * FileApplicationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String, FileApplicationType)"})
  public void testGetResourceWithUrlApplicationType_thenReturnNameIsExample() {
    // Arrange
    BroadleafFileServiceExtensionHandler broadleafFileServiceExtensionHandler =
        mock(BroadleafFileServiceExtensionHandler.class);
    when(broadleafFileServiceExtensionHandler.processPathForSite(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenReturn(broadleafFileServiceExtensionHandler);

    // Act
    File actualResource =
        fileSystemFileServiceProvider.getResource(
            "https://example.org/example", FileApplicationType.ALL);

    // Assert
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("example"), isA(ExtensionResultHolder.class));
    assertEquals("example", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)} with {@code
   * url}, {@code applicationType}.
   *
   * <ul>
   *   <li>Then return Name is {@code tmp}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String,
   * FileApplicationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String, FileApplicationType)"})
  public void testGetResourceWithUrlApplicationType_thenReturnNameIsTmp() {
    // Arrange
    BroadleafFileServiceExtensionHandler broadleafFileServiceExtensionHandler =
        mock(BroadleafFileServiceExtensionHandler.class);
    when(broadleafFileServiceExtensionHandler.processPathForSite(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenReturn(broadleafFileServiceExtensionHandler);

    // Act
    File actualResource = fileSystemFileServiceProvider.getResource("/", FileApplicationType.ALL);

    // Assert
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq(""), isA(ExtensionResultHolder.class));
    assertEquals("tmp", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)} with {@code
   * url}, {@code applicationType}.
   *
   * <ul>
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String,
   * FileApplicationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String, FileApplicationType)"})
  public void testGetResourceWithUrlApplicationType_thenThrowFileServiceException() {
    // Arrange
    BroadleafFileServiceExtensionHandler broadleafFileServiceExtensionHandler =
        mock(BroadleafFileServiceExtensionHandler.class);
    when(broadleafFileServiceExtensionHandler.processPathForSite(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenThrow(new FileServiceException("An error occurred"));
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenReturn(broadleafFileServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () ->
            fileSystemFileServiceProvider.getResource(
                "https://example.org/example", FileApplicationType.ALL));
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("example"), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String, FileApplicationType)} with {@code
   * url}, {@code applicationType}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String,
   * FileApplicationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String, FileApplicationType)"})
  public void testGetResourceWithUrlApplicationType_whenSlash_thenThrowFileServiceException() {
    // Arrange
    BroadleafFileServiceExtensionHandler broadleafFileServiceExtensionHandler =
        mock(BroadleafFileServiceExtensionHandler.class);
    when(broadleafFileServiceExtensionHandler.processPathForSite(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenThrow(new FileServiceException("An error occurred"));
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenReturn(broadleafFileServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.getResource("/", FileApplicationType.ALL));
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq(""), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with {@code url}.
   *
   * <ul>
   *   <li>Then return Name is {@code example}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String)"})
  public void testGetResourceWithUrl_thenReturnNameIsExample() {
    // Arrange
    BroadleafFileServiceExtensionHandler broadleafFileServiceExtensionHandler =
        mock(BroadleafFileServiceExtensionHandler.class);
    when(broadleafFileServiceExtensionHandler.processPathForSite(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenReturn(broadleafFileServiceExtensionHandler);

    // Act
    File actualResource = fileSystemFileServiceProvider.getResource("https://example.org/example");

    // Assert
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("example"), isA(ExtensionResultHolder.class));
    assertEquals("example", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with {@code url}.
   *
   * <ul>
   *   <li>Then return Name is {@code tmp}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String)"})
  public void testGetResourceWithUrl_thenReturnNameIsTmp() {
    // Arrange
    BroadleafFileServiceExtensionHandler broadleafFileServiceExtensionHandler =
        mock(BroadleafFileServiceExtensionHandler.class);
    when(broadleafFileServiceExtensionHandler.processPathForSite(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenReturn(broadleafFileServiceExtensionHandler);

    // Act
    File actualResource = fileSystemFileServiceProvider.getResource("/");

    // Assert
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq(""), isA(ExtensionResultHolder.class));
    assertEquals("tmp", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with {@code url}.
   *
   * <ul>
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String)"})
  public void testGetResourceWithUrl_thenThrowFileServiceException() {
    // Arrange
    BroadleafFileServiceExtensionHandler broadleafFileServiceExtensionHandler =
        mock(BroadleafFileServiceExtensionHandler.class);
    when(broadleafFileServiceExtensionHandler.processPathForSite(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenThrow(new FileServiceException("An error occurred"));
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenReturn(broadleafFileServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.getResource("https://example.org/example"));
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("example"), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getResource(String)} with {@code url}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File FileSystemFileServiceProvider.getResource(String)"})
  public void testGetResourceWithUrl_whenSlash_thenThrowFileServiceException() {
    // Arrange
    BroadleafFileServiceExtensionHandler broadleafFileServiceExtensionHandler =
        mock(BroadleafFileServiceExtensionHandler.class);
    when(broadleafFileServiceExtensionHandler.processPathForSite(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenThrow(new FileServiceException("An error occurred"));
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenReturn(broadleafFileServiceExtensionHandler);

    // Act and Assert
    assertThrows(FileServiceException.class, () -> fileSystemFileServiceProvider.getResource("/"));
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq(""), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   *
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea,
   * List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileSystemFileServiceProvider.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResources_givenDirectoryFooTxt() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   *
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea,
   * List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileSystemFileServiceProvider.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResources_givenDirectoryFooTxt2() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea,
   * List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileSystemFileServiceProvider.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResources_givenEmptyString_thenThrowFileServiceException() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea,
   * List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileSystemFileServiceProvider.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResources_givenEmptyString_thenThrowFileServiceException2() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea,
   * List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileSystemFileServiceProvider.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResources_whenFalse_thenThrowFileServiceException() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResources(workArea, files, false));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FileSystemFileServiceProvider.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPaths_givenDirectoryFooTxt() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FileSystemFileServiceProvider.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPaths_givenDirectoryFooTxt2() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List,
   * boolean)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FileSystemFileServiceProvider.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPaths_givenEmptyString_thenThrowFileServiceException() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FileSystemFileServiceProvider.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPaths_whenArrayList_thenReturnEmpty() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertTrue(
        fileSystemFileServiceProvider
            .addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true)
            .isEmpty());
  }

  /**
   * Test {@link FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FileSystemFileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FileSystemFileServiceProvider.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPaths_whenFalse_thenThrowFileServiceException() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> fileSystemFileServiceProvider.addOrUpdateResourcesForPaths(workArea, files, false));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#removeResource(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileSystemFileServiceProvider.removeResource(String)"})
  public void testRemoveResource_whenName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fileSystemFileServiceProvider.removeResource("Name"));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#removeResource(String)}.
   *
   * <ul>
   *   <li>When {@code /Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FileSystemFileServiceProvider.removeResource(String)"})
  public void testRemoveResource_whenName_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(fileSystemFileServiceProvider.removeResource("/Name"));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#buildResourceName(String)}.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   *   <li>Then return {@code example}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#buildResourceName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileSystemFileServiceProvider.buildResourceName(String)"})
  public void testBuildResourceName_whenHttpsExampleOrgExample_thenReturnExample() {
    // Arrange, Act and Assert
    assertEquals(
        "example", fileSystemFileServiceProvider.buildResourceName("https://example.org/example"));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#buildResourceName(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#buildResourceName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileSystemFileServiceProvider.buildResourceName(String)"})
  public void testBuildResourceName_whenSlash_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", fileSystemFileServiceProvider.buildResourceName("/"));
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileSystemFileServiceProvider.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory_whenFalse() {
    // Arrange, Act and Assert
    assertEquals(
        System.getProperty("java.io.tmpdir"),
        fileSystemFileServiceProvider.getBaseDirectory(false));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getBaseDirectory(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileSystemFileServiceProvider.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory_whenTrue() {
    // Arrange, Act and Assert
    assertEquals(
        System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.getBaseDirectory(true));
    assertEquals(System.getProperty("java.io.tmpdir"), fileSystemFileServiceProvider.baseDirectory);
  }

  /**
   * Test {@link FileSystemFileServiceProvider#getSiteDirectory(String)}.
   *
   * <p>Method under test: {@link FileSystemFileServiceProvider#getSiteDirectory(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FileSystemFileServiceProvider.getSiteDirectory(String)"})
  public void testGetSiteDirectory() {
    // Arrange, Act and Assert
    assertEquals("/directory", fileSystemFileServiceProvider.getSiteDirectory("/directory"));
  }
}
