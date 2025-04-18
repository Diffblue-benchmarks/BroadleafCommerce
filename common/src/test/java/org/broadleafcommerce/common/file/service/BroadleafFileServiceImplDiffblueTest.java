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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.broadleafcommerce.common.file.FileServiceException;
import org.broadleafcommerce.common.file.domain.FileWorkArea;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BroadleafFileServiceImplDiffblueTest {
  @InjectMocks
  private BroadleafFileServiceImpl broadleafFileServiceImpl;

  @Mock
  private FileServiceProvider fileServiceProvider;

  @Mock
  private List<FileServiceProvider> list;

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String)} with {@code name}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String)"})
  public void testGetResourceWithName() {
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
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code localTimeout}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code localTimeout}.
   * <ul>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(mock(FileServiceProvider.class));
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("", null);

    // Assert
    assertEquals("T", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code localTimeout}.
   * <ul>
   *   <li>Then return Name is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_thenReturnNameIsTestTxt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code localTimeout}.
   * <ul>
   *   <li>When {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_whenDot() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act and Assert
    assertTrue(broadleafFileServiceImpl.getResource(".", 1L).isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code localTimeout}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_whenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    FileServiceProvider defaultFileServiceProvider = mock(FileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act and Assert
    assertTrue(broadleafFileServiceImpl.getResource("", 1L).isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code localTimeout}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_whenMax_value_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(mock(FileServiceProvider.class));
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("", Long.MAX_VALUE);

    // Assert
    assertEquals("T", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code localTimeout}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_whenNull_thenReturnNameIsTestTxt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getResource(String)} with {@code name}.
   * <ul>
   *   <li>Then return Name is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String)"})
  public void testGetResourceWithName_thenReturnNameIsTestTxt() {
    // Arrange
    when(fileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name");

    // Assert
    verify(fileServiceProvider).getResource(eq("Name"));
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String)} with {@code name}.
   * <ul>
   *   <li>Then throw {@link FileServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String)"})
  public void testGetResourceWithName_thenThrowFileServiceException() {
    // Arrange
    when(fileServiceProvider.getResource(Mockito.<String>any()))
        .thenThrow(new FileServiceException("An error occurred"));

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.getResource("Name"));
    verify(fileServiceProvider).getResource(eq("Name"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code resourceName}, {@code skipSite}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code resourceName}, {@code skipSite}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code resourceName}, {@code skipSite}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_thenReturnNameIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>Then return Name is {@code Resource Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_thenReturnNameIsResourceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("Resource Name", true);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_whenDot_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(".", true);

    // Assert
    assertEquals("T", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_whenEmptyString_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("", true);

    // Assert
    assertEquals("T", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("Resource Name", false);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code resourceName}, {@code skipSite}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_whenNull_thenReturnNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(null, false);

    // Assert
    assertEquals("null", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   * <ul>
   *   <li>Then return Name is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_thenReturnNameIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   * <ul>
   *   <li>Then return Name is {@code Resource Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_thenReturnNameIsResourceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_whenDot_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(".");

    // Assert
    assertEquals("T", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Name is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_whenEmptyString_thenReturnNameIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource("");

    // Assert
    assertEquals("T", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_whenNull_thenReturnNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    File actualLocalResource = (new BroadleafFileServiceImpl()).getLocalResource(null);

    // Assert
    assertEquals("null", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkForResourceOnClassPath(String)}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#checkForResourceOnClassPath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.checkForResourceOnClassPath(String)"})
  public void testCheckForResourceOnClassPath() {
    // Arrange, Act and Assert
    assertFalse(broadleafFileServiceImpl.checkForResourceOnClassPath("Name"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getClasspathResource(String)}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getClasspathResource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.InputStream BroadleafFileServiceImpl.getClasspathResource(String)"})
  public void testGetClasspathResource() {
    // Arrange, Act and Assert
    assertNull(broadleafFileServiceImpl.getClasspathResource("Name"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}.
   * <ul>
   *   <li>Then calls {@link FileWorkArea#getFilePathLocation()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.addOrUpdateResource(FileWorkArea, File, boolean)"})
  public void testAddOrUpdateResource_thenCallsGetFilePathLocation() {
    // Arrange
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("/directory/foo.txt");
    doNothing().when(workArea).setFilePathLocation(Mockito.<String>any());
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResource(workArea,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    verify(workArea, atLeast(1)).getFilePathLocation();
    verify(workArea).setFilePathLocation(eq("/directory/foo.txt"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}.
   * <ul>
   *   <li>When {@link FileWorkArea} (default constructor) FilePathLocation is {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.addOrUpdateResource(FileWorkArea, File, boolean)"})
  public void testAddOrUpdateResource_whenFileWorkAreaFilePathLocationIsDirectoryFooTxt() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResource(workArea,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link FileWorkArea#getFilePathLocation()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafFileServiceImpl.addOrUpdateResourceForPath(FileWorkArea, File, boolean)"})
  public void testAddOrUpdateResourceForPath_givenEmptyString_thenCallsGetFilePathLocation() {
    // Arrange
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");
    doNothing().when(workArea).setFilePathLocation(Mockito.<String>any());
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResourceForPath(workArea,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
    verify(workArea).getFilePathLocation();
    verify(workArea).setFilePathLocation(eq("/directory/foo.txt"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}.
   * <ul>
   *   <li>When {@link FileWorkArea} (default constructor) FilePathLocation is {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafFileServiceImpl.addOrUpdateResourceForPath(FileWorkArea, File, boolean)"})
  public void testAddOrUpdateResourceForPath_whenFileWorkAreaFilePathLocationIsDirectoryFooTxt() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResourceForPath(workArea,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea() {
    // Arrange
    when(fileServiceProvider.addOrUpdateResourcesForPaths(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(),
        anyBoolean())).thenReturn(new ArrayList<>());

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act
    broadleafFileServiceImpl.addOrUpdateResources(workArea, new ArrayList<>(), true);

    // Assert
    verify(fileServiceProvider).addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea2() {
    // Arrange
    when(fileServiceProvider.addOrUpdateResourcesForPaths(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(),
        anyBoolean())).thenThrow(new FileServiceException("An error occurred"));

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, new ArrayList<>(), true));
    verify(fileServiceProvider).addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea3() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea4() {
    // Arrange
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");
    doNothing().when(workArea).setFilePathLocation(Mockito.<String>any());
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, files, true));
    verify(workArea).getFilePathLocation();
    verify(workArea).setFilePathLocation(eq("/directory/foo.txt"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <ul>
   *   <li>Given {@code Work Area}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea_givenWorkArea() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)} with {@code workArea}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, boolean)"})
  public void testAddOrUpdateResourcesWithWorkAreaRemoveFilesFromWorkArea() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)} with {@code workArea}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, boolean)"})
  public void testAddOrUpdateResourcesWithWorkAreaRemoveFilesFromWorkArea2() {
    // Arrange
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("/directory/foo.txt");
    doNothing().when(workArea).setFilePathLocation(Mockito.<String>any());
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
    verify(workArea).setFilePathLocation(eq("/directory/foo.txt"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)} with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)} with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea2() {
    // Arrange
    when(fileServiceProvider.addOrUpdateResourcesForPaths(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(),
        anyBoolean())).thenReturn(new ArrayList<>());

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act
    List<String> actualAddOrUpdateResourcesForPathsResult = broadleafFileServiceImpl
        .addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    // Assert
    verify(fileServiceProvider).addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    assertTrue(actualAddOrUpdateResourcesForPathsResult.isEmpty());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)} with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea3() {
    // Arrange
    when(fileServiceProvider.addOrUpdateResourcesForPaths(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(),
        anyBoolean())).thenThrow(new FileServiceException("An error occurred"));

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true));
    verify(fileServiceProvider).addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)} with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea4() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)} with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"})
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea5() {
    // Arrange
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("");
    doNothing().when(workArea).setFilePathLocation(Mockito.<String>any());
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, files, true));
    verify(workArea).getFilePathLocation();
    verify(workArea).setFilePathLocation(eq("/directory/foo.txt"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)} with {@code workArea}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, boolean)"})
  public void testAddOrUpdateResourcesForPathsWithWorkAreaRemoveFilesFromWorkArea() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)} with {@code workArea}, {@code removeFilesFromWorkArea}.
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, boolean)"})
  public void testAddOrUpdateResourcesForPathsWithWorkAreaRemoveFilesFromWorkArea2() {
    // Arrange
    FileWorkArea workArea = mock(FileWorkArea.class);
    when(workArea.getFilePathLocation()).thenReturn("/directory/foo.txt");
    doNothing().when(workArea).setFilePathLocation(Mockito.<String>any());
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, true));
    verify(workArea, atLeast(1)).getFilePathLocation();
    verify(workArea).setFilePathLocation(eq("/directory/foo.txt"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}.
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.checkFiles(FileWorkArea, List)"})
  public void testCheckFiles_givenDirectoryFooTxt() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> fileList = new ArrayList<>();
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.checkFiles(workArea, fileList));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link FileWorkArea} (default constructor) FilePathLocation is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.checkFiles(FileWorkArea, List)"})
  public void testCheckFiles_givenEmptyString_whenFileWorkAreaFilePathLocationIsEmptyString() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    ArrayList<File> fileList = new ArrayList<>();
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.checkFiles(workArea, fileList));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}.
   * <ul>
   *   <li>Given {@code Work Area}.</li>
   *   <li>When {@link FileWorkArea} (default constructor) FilePathLocation is {@code Work Area}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.checkFiles(FileWorkArea, List)"})
  public void testCheckFiles_givenWorkArea_whenFileWorkAreaFilePathLocationIsWorkArea() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafFileServiceImpl.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory() {
    // Arrange
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(" ");

    // Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), broadleafFileServiceImpl.getBaseDirectory(false));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}.
   * <ul>
   *   <li>Given {@link BroadleafFileServiceImpl}.</li>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafFileServiceImpl.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory_givenBroadleafFileServiceImpl_whenTrue() {
    // Arrange, Act and Assert
    assertEquals(System.getProperty("java.io.tmpdir"), broadleafFileServiceImpl.getBaseDirectory(true));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BroadleafFileServiceImpl.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory_thenReturnFoo() {
    // Arrange
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("foo");

    // Act and Assert
    assertEquals("foo", broadleafFileServiceImpl.getBaseDirectory(false));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#buildFileList(File, Collection)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafFileServiceImpl#buildFileList(File, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafFileServiceImpl.buildFileList(File, Collection)"})
  public void testBuildFileList_thenArrayListSizeIsOne() {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ArrayList<File> fileList = new ArrayList<>();

    // Act
    broadleafFileServiceImpl.buildFileList(file, fileList);

    // Assert
    assertEquals(1, fileList.size());
    assertSame(file, fileList.get(0));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafFileServiceImpl#setDefaultFileServiceProvider(FileServiceProvider)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FileServiceProvider BroadleafFileServiceImpl.getDefaultFileServiceProvider()",
      "List BroadleafFileServiceImpl.getFileServiceProviders()",
      "int BroadleafFileServiceImpl.getMaxGeneratedDirectoryDepth()",
      "String BroadleafFileServiceImpl.getTempFileSystemBaseDirectory()",
      "void BroadleafFileServiceImpl.setDefaultFileServiceProvider(FileServiceProvider)",
      "void BroadleafFileServiceImpl.setFileServiceProviders(List)",
      "void BroadleafFileServiceImpl.setMaxGeneratedDirectoryDepth(int)",
      "void BroadleafFileServiceImpl.setTempFileSystemBaseDirectory(String)"})
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

    // Assert
    assertEquals("/directory", broadleafFileServiceImpl.getTempFileSystemBaseDirectory());
    assertEquals(2, actualMaxGeneratedDirectoryDepth);
    assertTrue(actualFileServiceProviders.isEmpty());
    assertSame(fileServiceProviders, actualFileServiceProviders);
    assertSame(defaultFileServiceProvider, actualDefaultFileServiceProvider);
  }
}
