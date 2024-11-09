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
   * Test {@link BroadleafFileServiceImpl#getResource(String)} with {@code name}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  public void testGetResourceWithName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(new FileSystemFileServiceProvider());

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name");

    // Assert
    FileServiceProvider defaultFileServiceProvider = broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider instanceof FileSystemFileServiceProvider);
    assertEquals("Name", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider).baseDirectory);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with
   * {@code name}, {@code localTimeout}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  public void testGetResourceWithNameLocalTimeout() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(new FileSystemFileServiceProvider());

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name", 1L);

    // Assert
    FileServiceProvider defaultFileServiceProvider = broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider instanceof FileSystemFileServiceProvider);
    assertEquals("Name", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider).baseDirectory);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with
   * {@code name}, {@code localTimeout}.
   * <ul>
   *   <li>Then return Name is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  public void testGetResourceWithNameLocalTimeout_thenReturnNameIsTestTxt() {
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
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with
   * {@code name}, {@code localTimeout}.
   * <ul>
   *   <li>Then return Name is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  public void testGetResourceWithNameLocalTimeout_thenReturnNameIsTestTxt2() {
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
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with
   * {@code name}, {@code localTimeout}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  public void testGetResourceWithNameLocalTimeout_whenMax_value_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(mock(FileServiceProvider.class));

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("", Long.MAX_VALUE);

    // Assert
    assertEquals("T", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with
   * {@code name}, {@code localTimeout}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  public void testGetResourceWithNameLocalTimeout_whenNull_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(mock(FileServiceProvider.class));

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("", null);

    // Assert
    assertEquals("T", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String)} with {@code name}.
   * <ul>
   *   <li>Then return Name is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  public void testGetResourceWithName_thenReturnNameIsTestTxt() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with
   * {@code resourceName}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResourceWithResourceName() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with
   * {@code resourceName}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResourceWithResourceName2() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with
   * {@code resourceName}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResourceWithResourceName3() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with
   * {@code resourceName}, {@code skipSite}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResourceWithResourceNameSkipSite() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with
   * {@code resourceName}, {@code skipSite}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResourceWithResourceNameSkipSite2() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with
   * {@code resourceName}, {@code skipSite}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResourceWithResourceNameSkipSite3() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with
   * {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResourceWithResourceNameSkipSite_thenReturnNameIsEmptyString() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with
   * {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>Then return Name is {@code Resource Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResourceWithResourceNameSkipSite_thenReturnNameIsResourceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("Resource Name", true);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with
   * {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResourceWithResourceNameSkipSite_whenDot_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(".", true);

    // Assert
    assertEquals("T", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with
   * {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResourceWithResourceNameSkipSite_whenEmptyString_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("", true);

    // Assert
    assertEquals("T", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with
   * {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResourceWithResourceNameSkipSite_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("Resource Name", false);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with
   * {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  public void testGetLocalResourceWithResourceNameSkipSite_whenNull_thenReturnNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(null, false);

    // Assert
    assertEquals("null", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with
   * {@code resourceName}.
   * <ul>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResourceWithResourceName_thenReturnNameIsEmptyString() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with
   * {@code resourceName}.
   * <ul>
   *   <li>Then return Name is {@code Resource Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResourceWithResourceName_thenReturnNameIsResourceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with
   * {@code resourceName}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResourceWithResourceName_whenDot_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(".");

    // Assert
    assertEquals("T", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with
   * {@code resourceName}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResourceWithResourceName_whenEmptyString_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("");

    // Assert
    assertEquals("T", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with
   * {@code resourceName}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  public void testGetLocalResourceWithResourceName_whenNull_thenReturnNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(null);

    // Assert
    assertEquals("null", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource() {
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
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource2() {
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
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource3() {
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
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   * <ul>
   *   <li>Given {@link BroadleafFileServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource_givenBroadleafFileServiceImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualSharedLocalResource = (new BroadleafFileServiceImpl()).getSharedLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   * <ul>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource_thenReturnNameIsEmptyString() {
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
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource_whenDot_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualSharedLocalResource = (new BroadleafFileServiceImpl()).getSharedLocalResource(".");

    // Assert
    assertEquals("T", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  public void testGetSharedLocalResource_whenEmptyString_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    File actualSharedLocalResource = (new BroadleafFileServiceImpl()).getSharedLocalResource("");

    // Assert
    assertEquals("T", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkForResourceOnClassPath(String)}.
   * <p>
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
   * Test {@link BroadleafFileServiceImpl#lookupResourceOnClassPath(String)}.
   * <p>
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
   * Test {@link BroadleafFileServiceImpl#getClasspathResource(String)}.
   * <p>
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
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  public void testRemoveResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(new FileSystemFileServiceProvider());

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("Resource Name");

    // Assert
    FileServiceProvider defaultFileServiceProvider = broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider instanceof FileSystemFileServiceProvider);
    assertFalse(actualRemoveResourceResult);
    assertEquals(System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider).baseDirectory);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   * <ul>
   *   <li>When {@code ..}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  public void testRemoveResource_whenDotDot_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("..");

    // Assert
    verify(defaultFileServiceProvider).removeResource(eq(".."));
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  public void testRemoveResource_whenDot_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource(".");

    // Assert
    verify(defaultFileServiceProvider).removeResource(eq("."));
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  public void testRemoveResource_whenEmptyString_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("");

    // Assert
    verify(defaultFileServiceProvider).removeResource(eq(""));
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  public void testRemoveResource_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource(null);

    // Assert
    verify(defaultFileServiceProvider).removeResource(isNull());
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   * <ul>
   *   <li>When {@code Resource Name}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  public void testRemoveResource_whenResourceName_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("Resource Name");

    // Assert
    verify(defaultFileServiceProvider).removeResource(eq("Resource Name"));
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   * <ul>
   *   <li>When {@code ThreadLocalManager.notify.orphans}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  public void testRemoveResource_whenThreadLocalManagerNotifyOrphans_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("ThreadLocalManager.notify.orphans");

    // Assert
    verify(defaultFileServiceProvider).removeResource(eq("ThreadLocalManager.notify.orphans"));
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}.
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.</li>
   *   <li>Then calls {@link FileWorkArea#getFilePathLocation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}
   */
  @Test
  public void testAddOrUpdateResource_givenDirectoryFooTxt_thenCallsGetFilePathLocation() {
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
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}.
   * <ul>
   *   <li>Given {@code Work Area}.</li>
   *   <li>When {@link FileWorkArea} (default constructor) FilePathLocation is
   * {@code Work Area}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}
   */
  @Test
  public void testAddOrUpdateResource_givenWorkArea_whenFileWorkAreaFilePathLocationIsWorkArea() {
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
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link FileWorkArea#getFilePathLocation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}
   */
  @Test
  public void testAddOrUpdateResourceForPath_givenEmptyString_thenCallsGetFilePathLocation() {
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
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}.
   * <ul>
   *   <li>Given {@code Work Area}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}
   */
  @Test
  public void testAddOrUpdateResourceForPath_givenWorkArea() {
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
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea() {
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
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <ul>
   *   <li>Given {@code Work Area}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea_givenWorkArea() {
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
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)}
   * with {@code workArea}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesWithWorkAreaRemoveFilesFromWorkArea() {
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
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)}
   * with {@code workArea}, {@code removeFilesFromWorkArea}.
   * <ul>
   *   <li>Given {@code Work Area}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesWithWorkAreaRemoveFilesFromWorkArea_givenWorkArea() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, true));
  }

  /**
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea() {
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
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(new FileSystemFileServiceProvider());
    FileWorkArea workArea = new FileWorkArea();

    // Act and Assert
    assertTrue(broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true).isEmpty());
  }

  /**
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea3() {
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
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)}
   * with {@code workArea}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPathsWithWorkAreaRemoveFilesFromWorkArea() {
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
   * Test
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)}
   * with {@code workArea}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)}
   */
  @Test
  public void testAddOrUpdateResourcesForPathsWithWorkAreaRemoveFilesFromWorkArea2() {
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
   * Test {@link BroadleafFileServiceImpl#selectFileServiceProvider()}.
   * <p>
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
   * Test {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link FileWorkArea#getFilePathLocation()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  public void testCheckFiles_givenEmptyString_thenCallsGetFilePathLocation() {
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
   * Test {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}.
   * <ul>
   *   <li>Given {@code Work Area}.</li>
   *   <li>When {@link FileWorkArea} (default constructor) FilePathLocation is
   * {@code Work Area}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  public void testCheckFiles_givenWorkArea_whenFileWorkAreaFilePathLocationIsWorkArea() {
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
   * Test {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}
   */
  @Test
  public void testGetBaseDirectory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(null);

    // Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), broadleafFileServiceImpl.getBaseDirectory(false));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}.
   * <ul>
   *   <li>Given {@link BroadleafFileServiceImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}
   */
  @Test
  public void testGetBaseDirectory_givenBroadleafFileServiceImpl_whenTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), (new BroadleafFileServiceImpl()).getBaseDirectory(true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}.
   * <ul>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}
   */
  @Test
  public void testGetBaseDirectory_thenReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("foo");

    // Act and Assert
    assertEquals("foo", broadleafFileServiceImpl.getBaseDirectory(false));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getTempDirectory(String)}.
   * <ul>
   *   <li>Then calls
   * {@link FileSystemFileServiceProvider#addOrUpdateResources(FileWorkArea, List, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getTempDirectory(String)}
   */
  @Test
  public void testGetTempDirectory_thenCallsAddOrUpdateResources() {
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
   * Test {@link BroadleafFileServiceImpl#buildFileList(File, Collection)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first is Property is
   * {@code java.io.tmpdir} is {@code test.txt} toFile.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#buildFileList(File, Collection)}
   */
  @Test
  public void testBuildFileList_thenArrayListFirstIsPropertyIsJavaIoTmpdirIsTestTxtToFile() {
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
   * Test {@link BroadleafFileServiceImpl#buildFileList(File, Collection)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first is {@link WritablePath}
   * toFile.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafFileServiceImpl#buildFileList(File, Collection)}
   */
  @Test
  public void testBuildFileList_thenArrayListFirstIsWritablePathToFile() {
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
   * Test getters and setters.
   * <p>
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
