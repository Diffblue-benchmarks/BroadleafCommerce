package org.broadleafcommerce.common.file.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class BroadleafFileServiceImplDiffblueTest {
  @Mock private BroadleafFileServiceExtensionManager broadleafFileServiceExtensionManager;

  @InjectMocks private BroadleafFileServiceImpl broadleafFileServiceImpl;

  @Mock private FileServiceProvider fileServiceProvider;

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String)} with {@code name}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String)"})
  public void testGetResourceWithName() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(new FileSystemFileServiceProvider());

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name");

    // Assert
    FileServiceProvider defaultFileServiceProvider =
        broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider instanceof FileSystemFileServiceProvider);
    assertEquals("Name", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(
        System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider).baseDirectory);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String)} with {@code name}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String)"})
  public void testGetResourceWithName2() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider = new FileSystemFileServiceProvider();
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name");

    // Assert
    FileServiceProvider defaultFileServiceProvider2 =
        broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider2 instanceof FileSystemFileServiceProvider);
    assertEquals("Name", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(
        System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider2).baseDirectory);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(new FileSystemFileServiceProvider());

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name", 1L);

    // Assert
    FileServiceProvider defaultFileServiceProvider =
        broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider instanceof FileSystemFileServiceProvider);
    assertEquals("Name", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(
        System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider).baseDirectory);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout2() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider = new FileSystemFileServiceProvider();
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name", 1L);

    // Assert
    FileServiceProvider defaultFileServiceProvider2 =
        broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider2 instanceof FileSystemFileServiceProvider);
    assertEquals("Name", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
    assertEquals(
        System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider2).baseDirectory);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout3() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("/directory");
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name", 1L);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).getResource("Name");
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout4() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(".");
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name", 1L);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).getResource("Name");
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout5() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(".");
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("", 1L);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).getResource("");
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout6() {
    // Arrange
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenThrow(new FileServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        FileServiceException.class, () -> broadleafFileServiceImpl.getResource("Name", 1L));
    verify(broadleafFileServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout7() {
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
        FileServiceException.class, () -> broadleafFileServiceImpl.getResource("Name", 1L));
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("Name"), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout8() {
    // Arrange
    when(fileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

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
    File actualResource = broadleafFileServiceImpl.getResource("Name", 1L);

    // Assert
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("Name"), isA(ExtensionResultHolder.class));
    verify(fileServiceProvider).getResource("Name");
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout9() {
    // Arrange
    when(fileServiceProvider.getResource(Mockito.<String>any()))
        .thenThrow(new FileServiceException("An error occurred"));

    BroadleafFileServiceExtensionHandler broadleafFileServiceExtensionHandler =
        mock(BroadleafFileServiceExtensionHandler.class);
    when(broadleafFileServiceExtensionHandler.processPathForSite(
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenReturn(broadleafFileServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        FileServiceException.class, () -> broadleafFileServiceImpl.getResource("Name", 1L));
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("Name"), isA(ExtensionResultHolder.class));
    verify(fileServiceProvider).getResource("Name");
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <ul>
   *   <li>Then calls {@link FileSystemFileServiceProvider#getResource(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_thenCallsGetResource() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name", 1L);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).getResource("Name");
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <ul>
   *   <li>Then return Name is {@code tmp}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_thenReturnNameIsTmp() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("", null);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    assertEquals("tmp", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <ul>
   *   <li>When {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_whenDot() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource(".", 1L);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_whenEmptyString() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("", 1L);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return Name is {@code tmp}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_whenMax_value_thenReturnNameIsTmp() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("", Long.MAX_VALUE);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    assertEquals("tmp", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String, Long)} with {@code name}, {@code
   * localTimeout}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link FileSystemFileServiceProvider#getResource(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String, Long)"})
  public void testGetResourceWithNameLocalTimeout_whenNull_thenCallsGetResource() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource(null, 1L);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).getResource(null);
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return Name is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String)"})
  public void testGetResourceWithName_thenReturnNameIsTestTxt() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    File actualResource = broadleafFileServiceImpl.getResource("Name");

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).getResource("Name");
    assertEquals("test.txt", actualResource.getName());
    assertTrue(actualResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getResource(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getResource(String)"})
  public void testGetResourceWithName_thenThrowFileServiceException() {
    // Arrange
    when(fileServiceProvider.getResource(Mockito.<String>any()))
        .thenThrow(new FileServiceException("An error occurred"));

    // Act and Assert
    assertThrows(FileServiceException.class, () -> broadleafFileServiceImpl.getResource("Name"));
    verify(fileServiceProvider).getResource("Name");
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName() {
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
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName2() {
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
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName3() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName4() {
    // Arrange
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenThrow(new FileServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.getLocalResource("Resource Name"));
    verify(broadleafFileServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName5() {
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
        () -> broadleafFileServiceImpl.getLocalResource("Resource Name"));
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("Resource Name"), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName6() {
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
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("Resource Name");

    // Assert
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("Resource Name"), isA(ExtensionResultHolder.class));
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite2() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite3() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite4() {
    // Arrange
    when(broadleafFileServiceExtensionManager.getProxy())
        .thenThrow(new FileServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.getLocalResource("Resource Name", false));
    verify(broadleafFileServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite5() {
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
        () -> broadleafFileServiceImpl.getLocalResource("Resource Name", false));
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("Resource Name"), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite6() {
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
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("Resource Name", false);

    // Assert
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("Resource Name"), isA(ExtensionResultHolder.class));
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <ul>
   *   <li>Given {@link BroadleafFileServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_givenBroadleafFileServiceImpl() {
    // Arrange and Act
    File actualLocalResource =
        new BroadleafFileServiceImpl().getLocalResource("Resource Name", true);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <ul>
   *   <li>Given {@link BroadleafFileServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_givenBroadleafFileServiceImpl2() {
    // Arrange and Act
    File actualLocalResource =
        new BroadleafFileServiceImpl().getLocalResource("Resource Name", false);

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <ul>
   *   <li>Then return Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_thenReturnNameIsEmptyString() {
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
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return Name is {@code tmp}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_whenDot_thenReturnNameIsTmp() {
    // Arrange and Act
    File actualLocalResource = new BroadleafFileServiceImpl().getLocalResource(".", true);

    // Assert
    assertEquals("tmp", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Name is {@code tmp}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_whenEmptyString_thenReturnNameIsTmp() {
    // Arrange and Act
    File actualLocalResource = new BroadleafFileServiceImpl().getLocalResource("", true);

    // Assert
    assertEquals("tmp", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)} with {@code
   * resourceName}, {@code skipSite}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String, boolean)"})
  public void testGetLocalResourceWithResourceNameSkipSite_whenNull_thenReturnNameIsNull() {
    // Arrange and Act
    File actualLocalResource = new BroadleafFileServiceImpl().getLocalResource(null, false);

    // Assert
    assertEquals("null", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   *
   * <ul>
   *   <li>Given {@link BroadleafFileServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_givenBroadleafFileServiceImpl() {
    // Arrange and Act
    File actualLocalResource = new BroadleafFileServiceImpl().getLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   *
   * <ul>
   *   <li>Then return Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_thenReturnNameIsEmptyString() {
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
   *
   * <ul>
   *   <li>Then return Name is {@code Resource Name.}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_thenReturnNameIsResourceName() {
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
    File actualLocalResource = broadleafFileServiceImpl.getLocalResource("Resource Name.");

    // Assert
    verify(broadleafFileServiceExtensionManager).getProxy();
    verify(broadleafFileServiceExtensionHandler)
        .processPathForSite(eq("/tmp"), eq("Resource Name."), isA(ExtensionResultHolder.class));
    assertEquals("Resource Name.", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return Name is {@code tmp}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_whenDot_thenReturnNameIsTmp() {
    // Arrange and Act
    File actualLocalResource = new BroadleafFileServiceImpl().getLocalResource(".");

    // Assert
    assertEquals("tmp", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Name is {@code tmp}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_whenEmptyString_thenReturnNameIsTmp() {
    // Arrange and Act
    File actualLocalResource = new BroadleafFileServiceImpl().getLocalResource("");

    // Assert
    assertEquals("tmp", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getLocalResource(String)} with {@code resourceName}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getLocalResource(String)"})
  public void testGetLocalResourceWithResourceName_whenNull_thenReturnNameIsNull() {
    // Arrange and Act
    File actualLocalResource = new BroadleafFileServiceImpl().getLocalResource(null);

    // Assert
    assertEquals("null", actualLocalResource.getName());
    assertTrue(actualLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getSharedLocalResource(String)"})
  public void testGetSharedLocalResource() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("/directory");

    // Act
    File actualSharedLocalResource =
        broadleafFileServiceImpl.getSharedLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getSharedLocalResource(String)"})
  public void testGetSharedLocalResource2() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("Temp File System Base Directory");

    // Act
    File actualSharedLocalResource =
        broadleafFileServiceImpl.getSharedLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualSharedLocalResource.getName());
    assertFalse(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getSharedLocalResource(String)"})
  public void testGetSharedLocalResource3() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(".");

    // Act
    File actualSharedLocalResource =
        broadleafFileServiceImpl.getSharedLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualSharedLocalResource.getName());
    assertFalse(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafFileServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getSharedLocalResource(String)"})
  public void testGetSharedLocalResource_givenBroadleafFileServiceImpl() {
    // Arrange and Act
    File actualSharedLocalResource =
        new BroadleafFileServiceImpl().getSharedLocalResource("Resource Name");

    // Assert
    assertEquals("Resource Name", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   *
   * <ul>
   *   <li>Then return Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getSharedLocalResource(String)"})
  public void testGetSharedLocalResource_thenReturnNameIsEmptyString() {
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
   *
   * <ul>
   *   <li>When {@code ..}.
   *   <li>Then return Name is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getSharedLocalResource(String)"})
  public void testGetSharedLocalResource_whenDotDot_thenReturnNameIsEmptyString() {
    // Arrange and Act
    File actualSharedLocalResource = broadleafFileServiceImpl.getSharedLocalResource("..");

    // Assert
    assertEquals("", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return Name is {@code tmp}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getSharedLocalResource(String)"})
  public void testGetSharedLocalResource_whenDot_thenReturnNameIsTmp() {
    // Arrange and Act
    File actualSharedLocalResource = new BroadleafFileServiceImpl().getSharedLocalResource(".");

    // Assert
    assertEquals("tmp", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Name is {@code tmp}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getSharedLocalResource(String)"})
  public void testGetSharedLocalResource_whenEmptyString_thenReturnNameIsTmp() {
    // Arrange and Act
    File actualSharedLocalResource = new BroadleafFileServiceImpl().getSharedLocalResource("");

    // Assert
    assertEquals("tmp", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   *
   * <ul>
   *   <li>When {@code Resource Name.}.
   *   <li>Then return Name is {@code Resource Name.}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getSharedLocalResource(String)"})
  public void testGetSharedLocalResource_whenResourceName_thenReturnNameIsResourceName() {
    // Arrange and Act
    File actualSharedLocalResource =
        broadleafFileServiceImpl.getSharedLocalResource("Resource Name.");

    // Assert
    assertEquals("Resource Name.", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}.
   *
   * <ul>
   *   <li>When {@code Resource Name..}.
   *   <li>Then return Name is {@code Resource Name..}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getSharedLocalResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File BroadleafFileServiceImpl.getSharedLocalResource(String)"})
  public void testGetSharedLocalResource_whenResourceName_thenReturnNameIsResourceName2() {
    // Arrange and Act
    File actualSharedLocalResource =
        broadleafFileServiceImpl.getSharedLocalResource("Resource Name..");

    // Assert
    assertEquals("Resource Name..", actualSharedLocalResource.getName());
    assertTrue(actualSharedLocalResource.isAbsolute());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkForResourceOnClassPath(String)}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#checkForResourceOnClassPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.checkForResourceOnClassPath(String)"})
  public void testCheckForResourceOnClassPath() {
    // Arrange, Act and Assert
    assertFalse(new BroadleafFileServiceImpl().checkForResourceOnClassPath("Name"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#lookupResourceOnClassPath(String)}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#lookupResourceOnClassPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.core.io.ClassPathResource BroadleafFileServiceImpl.lookupResourceOnClassPath(String)"
  })
  public void testLookupResourceOnClassPath() {
    // Arrange, Act and Assert
    assertNull(new BroadleafFileServiceImpl().lookupResourceOnClassPath("Name"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getClasspathResource(String)}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getClasspathResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream BroadleafFileServiceImpl.getClasspathResource(String)"})
  public void testGetClasspathResource() {
    // Arrange, Act and Assert
    assertNull(new BroadleafFileServiceImpl().getClasspathResource("Name"));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(new FileSystemFileServiceProvider());

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("Resource Name");

    // Assert
    FileServiceProvider defaultFileServiceProvider =
        broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider instanceof FileSystemFileServiceProvider);
    assertFalse(actualRemoveResourceResult);
    assertEquals(
        System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider).baseDirectory);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource2() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider = new FileSystemFileServiceProvider();
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("Resource Name");

    // Assert
    FileServiceProvider defaultFileServiceProvider2 =
        broadleafFileServiceImpl.getDefaultFileServiceProvider();
    assertTrue(defaultFileServiceProvider2 instanceof FileSystemFileServiceProvider);
    assertFalse(actualRemoveResourceResult);
    assertEquals(
        System.getProperty("java.io.tmpdir"),
        ((FileSystemFileServiceProvider) defaultFileServiceProvider2).baseDirectory);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafFileServiceImpl} (default constructor) TempFileSystemBaseDirectory
   *       is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource_givenBroadleafFileServiceImplTempFileSystemBaseDirectoryIsDot() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);
    doNothing()
        .when(defaultFileServiceProvider)
        .addOrUpdateResources(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean());
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory(".");
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("Resource Name");

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResources(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).removeResource("Resource Name");
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <ul>
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource_thenThrowFileServiceException() {
    // Arrange
    when(fileServiceProvider.removeResource(Mockito.<String>any()))
        .thenThrow(new FileServiceException("An error occurred"));

    // Act and Assert
    assertThrows(
        FileServiceException.class, () -> broadleafFileServiceImpl.removeResource("Resource Name"));
    verify(fileServiceProvider).removeResource("Resource Name");
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <ul>
   *   <li>When {@code ---.}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource_whenDashDashDashDot_thenReturnTrue() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);
    doNothing()
        .when(defaultFileServiceProvider)
        .addOrUpdateResources(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean());
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("---.");

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResources(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).removeResource("---.");
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <ul>
   *   <li>When {@code ..}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource_whenDotDot_thenReturnTrue() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);
    doNothing()
        .when(defaultFileServiceProvider)
        .addOrUpdateResources(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean());
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("..");

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResources(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).removeResource("..");
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource_whenDot_thenReturnTrue() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);
    doNothing()
        .when(defaultFileServiceProvider)
        .addOrUpdateResources(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean());
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource(".");

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResources(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).removeResource(".");
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource_whenEmptyString_thenReturnTrue() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);
    doNothing()
        .when(defaultFileServiceProvider)
        .addOrUpdateResources(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean());
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("");

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResources(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).removeResource("");
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <ul>
   *   <li>When {@code java.io.tmpdir}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource_whenJavaIoTmpdir_thenReturnTrue() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);
    doNothing()
        .when(defaultFileServiceProvider)
        .addOrUpdateResources(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean());
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("java.io.tmpdir");

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResources(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).removeResource("java.io.tmpdir");
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource_whenNull_thenReturnTrue() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);
    doNothing()
        .when(defaultFileServiceProvider)
        .addOrUpdateResources(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean());
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource(null);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResources(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).removeResource(null);
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#removeResource(String)}.
   *
   * <ul>
   *   <li>When {@code Resource Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#removeResource(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafFileServiceImpl.removeResource(String)"})
  public void testRemoveResource_whenResourceName_thenReturnTrue() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.removeResource(Mockito.<String>any())).thenReturn(true);
    doNothing()
        .when(defaultFileServiceProvider)
        .addOrUpdateResources(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean());
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    // Act
    boolean actualRemoveResourceResult = broadleafFileServiceImpl.removeResource("Resource Name");

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResources(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider).removeResource("Resource Name");
    assertTrue(actualRemoveResourceResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link FileServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResource(FileWorkArea, File,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafFileServiceImpl.addOrUpdateResource(FileWorkArea, File, boolean)"
  })
  public void testAddOrUpdateResource_thenThrowFileServiceException() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () ->
            broadleafFileServiceImpl.addOrUpdateResource(
                workArea,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
                true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafFileServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea,
   * File, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafFileServiceImpl.addOrUpdateResourceForPath(FileWorkArea, File, boolean)"
  })
  public void testAddOrUpdateResourceForPath_givenBroadleafFileServiceImpl() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () ->
            broadleafFileServiceImpl.addOrUpdateResourceForPath(
                workArea,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
                true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}.
   *
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea,
   * File, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafFileServiceImpl.addOrUpdateResourceForPath(FileWorkArea, File, boolean)"
  })
  public void testAddOrUpdateResourceForPath_givenDirectoryFooTxt() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () ->
            broadleafFileServiceImpl.addOrUpdateResourceForPath(
                workArea,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(),
                true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link FileServiceProvider#addOrUpdateResourcesForPaths(FileWorkArea, List,
   *       boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea,
   * File, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafFileServiceImpl.addOrUpdateResourceForPath(FileWorkArea, File, boolean)"
  })
  public void testAddOrUpdateResourceForPath_thenCallsAddOrUpdateResourcesForPaths() {
    // Arrange
    when(fileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenThrow(new FileServiceException("An error occurred"));

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () ->
            broadleafFileServiceImpl.addOrUpdateResourceForPath(
                workArea, Paths.get(System.getProperty("java.io.tmpdir"), "").toFile(), true));
    verify(fileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea, File, boolean)}.
   *
   * <ul>
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResourceForPath(FileWorkArea,
   * File, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafFileServiceImpl.addOrUpdateResourceForPath(FileWorkArea, File, boolean)"
  })
  public void testAddOrUpdateResourceForPath_thenReturnFoo() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(stringList);
    doNothing()
        .when(defaultFileServiceProvider)
        .addOrUpdateResources(Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean());
    defaultFileServiceProvider.addOrUpdateResources(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    FileWorkArea workArea2 = new FileWorkArea();
    workArea2.setFilePathLocation("");

    // Act
    String actualAddOrUpdateResourceForPathResult =
        broadleafFileServiceImpl.addOrUpdateResourceForPath(
            workArea2, Paths.get(System.getProperty("java.io.tmpdir"), "").toFile(), true);

    // Assert
    verify(defaultFileServiceProvider)
        .addOrUpdateResources(isA(FileWorkArea.class), isA(List.class), eq(true));
    verify(defaultFileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
    assertEquals("foo", actualAddOrUpdateResourceForPathResult);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with
   * {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(new FileSystemFileServiceProvider());

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    broadleafFileServiceImpl.addOrUpdateResources(workArea, new ArrayList<>(), true);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with
   * {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea2() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with
   * {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea3() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    FileWorkArea workArea2 = new FileWorkArea();
    workArea2.setFilePathLocation("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());

    // Act
    broadleafFileServiceImpl.addOrUpdateResources(workArea2, files, true);

    // Assert
    verify(defaultFileServiceProvider, atLeast(1))
        .addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), eq(true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with
   * {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea4() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with
   * {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea5() {
    // Arrange
    when(fileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenThrow(new FileServiceException("An error occurred"));

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, new ArrayList<>(), true));
    verify(fileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List, boolean)} with
   * {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <ul>
   *   <li>Given {@code Work Area}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesWithWorkAreaFilesRemoveFilesFromWorkArea_givenWorkArea() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, files, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea, boolean)} with {@code
   * workArea}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#addOrUpdateResources(FileWorkArea,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafFileServiceImpl.addOrUpdateResources(FileWorkArea, boolean)"})
  public void testAddOrUpdateResourcesWithWorkAreaRemoveFilesFromWorkArea() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResources(workArea, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link
   * BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link
   * BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea2() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(new FileSystemFileServiceProvider());

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertTrue(
        broadleafFileServiceImpl
            .addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true)
            .isEmpty());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link
   * BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea3() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link
   * BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea4() {
    // Arrange
    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    FileSystemFileServiceProvider defaultFileServiceProvider =
        mock(FileSystemFileServiceProvider.class);
    when(defaultFileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    defaultFileServiceProvider.addOrUpdateResourcesForPaths(workArea, new ArrayList<>(), true);

    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setDefaultFileServiceProvider(defaultFileServiceProvider);

    FileWorkArea workArea2 = new FileWorkArea();
    workArea2.setFilePathLocation("");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());

    // Act
    List<String> actualAddOrUpdateResourcesForPathsResult =
        broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea2, files, true);

    // Assert
    verify(defaultFileServiceProvider, atLeast(1))
        .addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), eq(true));
    assertTrue(actualAddOrUpdateResourcesForPathsResult.isEmpty());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link
   * BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea5() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> files = new ArrayList<>();
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    files.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, files, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   * with {@code workArea}, {@code files}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link
   * BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, List, boolean)"
  })
  public void testAddOrUpdateResourcesForPathsWithWorkAreaFilesRemoveFilesFromWorkArea6() {
    // Arrange
    when(fileServiceProvider.addOrUpdateResourcesForPaths(
            Mockito.<FileWorkArea>any(), Mockito.<List<File>>any(), anyBoolean()))
        .thenThrow(new FileServiceException("An error occurred"));

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () ->
            broadleafFileServiceImpl.addOrUpdateResourcesForPaths(
                workArea, new ArrayList<>(), true));
    verify(fileServiceProvider)
        .addOrUpdateResourcesForPaths(isA(FileWorkArea.class), isA(List.class), eq(true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)} with
   * {@code workArea}, {@code removeFilesFromWorkArea}.
   *
   * <p>Method under test: {@link
   * BroadleafFileServiceImpl#addOrUpdateResourcesForPaths(FileWorkArea, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BroadleafFileServiceImpl.addOrUpdateResourcesForPaths(FileWorkArea, boolean)"
  })
  public void testAddOrUpdateResourcesForPathsWithWorkAreaRemoveFilesFromWorkArea() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    assertThrows(
        FileServiceException.class,
        () -> broadleafFileServiceImpl.addOrUpdateResourcesForPaths(workArea, true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#selectFileServiceProvider()}.
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#selectFileServiceProvider()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FileServiceProvider BroadleafFileServiceImpl.selectFileServiceProvider()"})
  public void testSelectFileServiceProvider() {
    // Arrange, Act and Assert
    assertNull(new BroadleafFileServiceImpl().selectFileServiceProvider());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}.
   *
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafFileServiceImpl.checkFiles(FileWorkArea, List)"})
  public void testCheckFiles_givenDirectoryFooTxt() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    ArrayList<File> fileList = new ArrayList<>();
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class, () -> broadleafFileServiceImpl.checkFiles(workArea, fileList));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}.
   *
   * <ul>
   *   <li>Given {@code /directory/foo.txt}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafFileServiceImpl.checkFiles(FileWorkArea, List)"})
  public void testCheckFiles_givenDirectoryFooTxt_whenArrayList_thenDoesNotThrow() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("/directory/foo.txt");

    // Act and Assert
    broadleafFileServiceImpl.checkFiles(workArea, new ArrayList<>());
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link FileWorkArea} (default constructor) FilePathLocation is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafFileServiceImpl.checkFiles(FileWorkArea, List)"})
  public void testCheckFiles_givenEmptyString_whenFileWorkAreaFilePathLocationIsEmptyString() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    ArrayList<File> fileList = new ArrayList<>();
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class, () -> broadleafFileServiceImpl.checkFiles(workArea, fileList));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with empty string
   *       toFile.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafFileServiceImpl.checkFiles(FileWorkArea, List)"})
  public void testCheckFiles_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithEmptyStringToFile() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("");

    ArrayList<File> fileList = new ArrayList<>();
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "").toFile());

    // Act and Assert
    broadleafFileServiceImpl.checkFiles(workArea, fileList);
  }

  /**
   * Test {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}.
   *
   * <ul>
   *   <li>Given {@code Work Area}.
   *   <li>When {@link FileWorkArea} (default constructor) FilePathLocation is {@code Work Area}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#checkFiles(FileWorkArea, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafFileServiceImpl.checkFiles(FileWorkArea, List)"})
  public void testCheckFiles_givenWorkArea_whenFileWorkAreaFilePathLocationIsWorkArea() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();

    FileWorkArea workArea = new FileWorkArea();
    workArea.setFilePathLocation("Work Area");

    ArrayList<File> fileList = new ArrayList<>();
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(
        FileServiceException.class, () -> broadleafFileServiceImpl.checkFiles(workArea, fileList));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code /directory}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafFileServiceImpl.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory_thenReturnDirectory() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("/directory");

    // Act and Assert
    assertEquals("/directory", broadleafFileServiceImpl.getBaseDirectory(true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code /directory}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafFileServiceImpl.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory_thenReturnDirectory2() {
    // Arrange
    BroadleafFileServiceImpl broadleafFileServiceImpl = new BroadleafFileServiceImpl();
    broadleafFileServiceImpl.setTempFileSystemBaseDirectory("/directory");

    // Act and Assert
    assertEquals("/directory", broadleafFileServiceImpl.getBaseDirectory(false));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}.
   *
   * <ul>
   *   <li>Then return Property is {@code java.io.tmpdir}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafFileServiceImpl.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory_thenReturnPropertyIsJavaIoTmpdir() {
    // Arrange, Act and Assert
    assertEquals(
        System.getProperty("java.io.tmpdir"),
        new BroadleafFileServiceImpl().getBaseDirectory(true));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}.
   *
   * <ul>
   *   <li>Then return Property is {@code java.io.tmpdir}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getBaseDirectory(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafFileServiceImpl.getBaseDirectory(boolean)"})
  public void testGetBaseDirectory_thenReturnPropertyIsJavaIoTmpdir2() {
    // Arrange, Act and Assert
    assertEquals(
        System.getProperty("java.io.tmpdir"),
        new BroadleafFileServiceImpl().getBaseDirectory(false));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#getTempDirectory(String)}.
   *
   * <ul>
   *   <li>When {@code ..}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#getTempDirectory(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafFileServiceImpl.getTempDirectory(String)"})
  public void testGetTempDirectory_whenDotDot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(broadleafFileServiceImpl.getTempDirectory(".."));
  }

  /**
   * Test {@link BroadleafFileServiceImpl#buildFileList(File, Collection)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFileServiceImpl#buildFileList(File, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafFileServiceImpl.buildFileList(File, Collection)"})
  public void testBuildFileList_thenArrayListSizeIsOne() {
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FileServiceProvider BroadleafFileServiceImpl.getDefaultFileServiceProvider()",
    "List BroadleafFileServiceImpl.getFileServiceProviders()",
    "int BroadleafFileServiceImpl.getMaxGeneratedDirectoryDepth()",
    "String BroadleafFileServiceImpl.getTempFileSystemBaseDirectory()",
    "void BroadleafFileServiceImpl.setDefaultFileServiceProvider(FileServiceProvider)",
    "void BroadleafFileServiceImpl.setFileServiceProviders(List)",
    "void BroadleafFileServiceImpl.setMaxGeneratedDirectoryDepth(int)",
    "void BroadleafFileServiceImpl.setTempFileSystemBaseDirectory(String)"
  })
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
    FileServiceProvider actualDefaultFileServiceProvider =
        broadleafFileServiceImpl.getDefaultFileServiceProvider();
    List<FileServiceProvider> actualFileServiceProviders =
        broadleafFileServiceImpl.getFileServiceProviders();
    int actualMaxGeneratedDirectoryDepth = broadleafFileServiceImpl.getMaxGeneratedDirectoryDepth();

    // Assert
    assertEquals("/directory", broadleafFileServiceImpl.getTempFileSystemBaseDirectory());
    assertEquals(2, actualMaxGeneratedDirectoryDepth);
    assertTrue(actualFileServiceProviders.isEmpty());
    assertSame(fileServiceProviders, actualFileServiceProviders);
    assertSame(defaultFileServiceProvider, actualDefaultFileServiceProvider);
  }
}
