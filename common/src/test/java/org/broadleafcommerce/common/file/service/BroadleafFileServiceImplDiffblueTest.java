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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.broadleafcommerce.common.file.FileServiceException;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.codehaus.groovy.runtime.WritablePath;
import org.junit.Test;
import org.mockito.Mockito;

public class BroadleafFileServiceImplDiffblueTest {
  /**
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  public void testGetResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    FileSystemFileServiceProvider defaultFileServiceProvider = new FileSystemFileServiceProvider();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name");

    // Assert
    FileServiceProvider defaultFileServiceProvider2 = broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider2 instanceof FileSystemFileServiceProvider);
    assertEquals("Name", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider2).baseDirectory);
    assertSame(defaultFileServiceProvider, defaultFileServiceProvider2);
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  public void testGetResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name");

    // Assert
    verify(defaultFileServiceProvider).getResource(eq("Name"));
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  public void testGetResource3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    FileSystemFileServiceProvider defaultFileServiceProvider = new FileSystemFileServiceProvider();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name", 1L);

    // Assert
    FileServiceProvider defaultFileServiceProvider2 = broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider2 instanceof FileSystemFileServiceProvider);
    assertEquals("Name", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider2).baseDirectory);
    assertSame(defaultFileServiceProvider, defaultFileServiceProvider2);
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  public void testGetResource4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name", 1L);

    // Assert
    verify(defaultFileServiceProvider).getResource(eq("Name"));
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  public void testGetResource5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource(null, 1L);

    // Assert
    verify(defaultFileServiceProvider).getResource(isNull());
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  public void testGetResource6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(mock(FileServiceProvider.class));

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("", null);

    // Assert
    assertEquals("tmp", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  public void testGetResource7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(mock(FileServiceProvider.class));

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("", Long.MAX_VALUE);

    // Assert
    assertEquals("tmp", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("");

    // Assert
    assertEquals("tmp", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResource3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(null);

    // Assert
    assertEquals("null", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResource4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(".");

    // Assert
    assertEquals("tmp", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResource5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("/directory");

    // Act
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResource6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("Temp File System Base Directory");

    // Act
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertFalse(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResource7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(".");

    // Act
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertFalse(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResource8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(".");

    // Act
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("");

    // Assert
    assertEquals("", actualLocalResource.getName());
    assertFalse(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResource9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("Resource Name", true);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResource10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("", true);

    // Assert
    assertEquals("tmp", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResource11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(".", true);

    // Assert
    assertEquals("tmp", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResource12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("Resource Name", false);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResource13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("/directory");

    // Act
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("Resource Name", true);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResource14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(null, false);

    // Assert
    assertEquals("null", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResource15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("Temp File System Base Directory");

    // Act
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("Resource Name", true);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertFalse(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResource16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(".");

    // Act
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("Resource Name", true);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertFalse(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResource17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(".");

    // Act
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("", true);

    // Assert
    assertEquals("", actualLocalResource.getName());
    assertFalse(actualLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualSharedLocalResource = (new BroadleafFileServiceImpl()).getSharedLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualSharedLocalResource = (new BroadleafFileServiceImpl()).getSharedLocalResource("");

    // Assert
    assertEquals("tmp", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualSharedLocalResource = (new BroadleafFileServiceImpl()).getSharedLocalResource(".");

    // Assert
    assertEquals("tmp", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("/directory");

    // Act
    File actualSharedLocalResource = broadleafFileServiceImpl.getSharedLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("Temp File System Base Directory");

    // Act
    File actualSharedLocalResource = broadleafFileServiceImpl.getSharedLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualSharedLocalResource.getName());
    assertFalse(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(".");

    // Act
    File actualSharedLocalResource = broadleafFileServiceImpl.getSharedLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualSharedLocalResource.getName());
    assertFalse(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(".");

    // Act
    File actualSharedLocalResource = broadleafFileServiceImpl.getSharedLocalResource("");

    // Assert
    assertEquals("", actualSharedLocalResource.getName());
    assertFalse(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#checkForResourceOnClassPath(String)}
   */
  @Test
  public void testCheckForResourceOnClassPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BroadleafFileServiceImpl()).checkForResourceOnClassPath("Name"));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#lookupResourceOnClassPath(String)}
   */
  @Test
  public void testLookupResourceOnClassPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BroadleafFileServiceImpl()).lookupResourceOnClassPath("Name"));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#getClasspathResource(String)}
   */
  @Test
  public void testGetClasspathResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BroadleafFileServiceImpl()).getClasspathResource("Name"));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}
   */
  @Test
  public void testAddOrUpdateResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResource(workArea,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}
   */
  @Test
  public void testAddOrUpdateResource2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResource(workArea,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    verify(workArea, atLeast(1)).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}
   */
  @Test
  public void testAddOrUpdateResourceForPath() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResourceForPath(workArea,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}
   */
  @Test
  public void testAddOrUpdateResourceForPath2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResourceForPath(workArea,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    verify(workArea).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResources() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResources2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, files, true));
    verify(workArea).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)}
   */
  @Test
  public void testAddOrUpdateResources3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, true));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)}
   */
  @Test
  public void testAddOrUpdateResources4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(new FileSystemFileServiceProvider());
    FileWorkArea workArea = new FileWorkArea();

    // Act and Assert
    assertTrue(broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true).isEmpty());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, files, true));
    verify(workArea).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, true));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPaths5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#selectFileServiceProvider()}
   */
  @Test
  public void testSelectFileServiceProvider() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new BroadleafFileServiceImpl()).selectFileServiceProvider());
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  public void testCheckFiles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    ArrayList<File> fileList = new ArrayList<>();
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.checkFiles(workArea, fileList));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  public void testCheckFiles2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");

    ArrayList<File> fileList = new ArrayList<>();
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.checkFiles(workArea, fileList));
    verify(workArea).getFilePathLocation();
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}
   */
  @Test
  public void testGetBaseDirectory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), (new BroadleafFileServiceImpl()).getBaseDirectory(true));
  }

  /**
   * Method under test: {@link BroadleafFileServiceImpl#getTempDirectory(String)}
   */
  @Test
  public void testGetTempDirectory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileSystemFileServiceProvider defaultFileServiceProvider = mock(FileSystemFileServiceProvider.class);
    doNothing().when(defaultFileServiceProvider)
        .addOrUpdateResources(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean());
    FileWorkArea workArea = new FileWorkArea();
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    broadleafFileServiceImpl.getTempDirectory("/directory");

    // Assert
    verify(defaultFileServiceProvider).addOrUpdateResources(isA(FileWorkArea.class), isA(List.class), eq(true));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#buildFileList(File, Collection)}
   */
  @Test
  public void testBuildFileList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ArrayList<File> fileList = new ArrayList<>();

    // Act
    broadleafFileServiceImpl.buildFileList(file, fileList);

    // Assert
    assertEquals(1, fileList.size());
    assertSame(file, fileList.get(0));
  }

  /**
   * Method under test:
   * {@link BroadleafFileServiceImpl#buildFileList(File, Collection)}
   */
  @Test
  public void testBuildFileList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    System.getProperty("java.io.tmpdir");
    WritablePath writablePath = mock(WritablePath.class);
    when(writablePath.toFile()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    File file = writablePath.toFile();
    ArrayList<File> fileList = new ArrayList<>();

    // Act
    broadleafFileServiceImpl.buildFileList(file, fileList);

    // Assert
    verify(writablePath).toFile();
    assertEquals(1, fileList.size());
    assertSame(file, fileList.get(0));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafFileServiceImpl#setDefaultFileServiceProvider(FileServiceProvider)}
   *   <li>{@link BroadleafFileServiceImpl#setFileServiceProviders(List)}
   *   <li>{@link BroadleafFileServiceImpl#setMaxGeneratedDirectoryDepth(int)}
   *   <li>{@link BroadleafFileServiceImpl#setTempFileSystemBaseDirectory(String)}
   *   <li>{@link BroadleafFileServiceImpl#getDefaultFileServiceProvider()}
   *   <li>{@link BroadleafFileServiceImpl#getFileServiceProviders()}
   *   <li>{@link BroadleafFileServiceImpl#getMaxGeneratedDirectoryDepth()}
   *   <li>{@link BroadleafFileServiceImpl#getTempFileSystemBaseDirectory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    FileSystemFileServiceProvider defaultFileServiceProvider = new FileSystemFileServiceProvider();

    // Act
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);
    ArrayList<FileServiceProvider> fileServiceProviders = new ArrayList<>();
    broadleafFileServiceImpl.setFileServiceProviders(fileServiceProviders);
    broadleafFileServiceImpl.setMaxGeneratedDirectoryDepth(2);
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("/directory");
    FileServiceProvider actualDefaultFileServiceProvider = broadleafFileServiceImpl.getDefaultFileServiceProvider();
    List<FileServiceProvider> actualFileServiceProviders = broadleafFileServiceImpl.getFileServiceProviders();
    int actualMaxGeneratedDirectoryDepth = broadleafFileServiceImpl.getMaxGeneratedDirectoryDepth();

    // Assert that nothing has changed
    assertEquals("/directory", broadleafFileServiceImpl.getTempFileSystemBaseDirectory());
    assertEquals(2, actualMaxGeneratedDirectoryDepth);
    assertTrue(actualFileServiceProviders.isEmpty());
    assertSame(fileServiceProviders, actualFileServiceProviders);
    assertSame(defaultFileServiceProvider, actualDefaultFileServiceProvider);
  }
}
