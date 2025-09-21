/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.file.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.cms.field.type.StorageType;
import org.broadleafcommerce.cms.file.dao.StaticAssetStorageDao;
import org.broadleafcommerce.cms.file.domain.ImageStaticAssetImpl;
import org.broadleafcommerce.cms.file.domain.StaticAsset;
import org.broadleafcommerce.cms.file.domain.StaticAssetImpl;
import org.broadleafcommerce.cms.file.domain.StaticAssetStorage;
import org.broadleafcommerce.cms.file.domain.StaticAssetStorageImpl;
import org.broadleafcommerce.cms.file.service.operation.NamedOperationManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.file.service.BroadleafFileService;
import org.broadleafcommerce.common.io.ConcurrentFileOutputStream;
import org.broadleafcommerce.common.util.StreamCapableTransactionalOperation;
import org.broadleafcommerce.common.util.StreamingTransactionCapableUtil;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

@RunWith(MockitoJUnitRunner.class)
public class StaticAssetStorageServiceImplDiffblueTest {
  @Mock private BroadleafFileService broadleafFileService;

  @Mock private ConcurrentFileOutputStream concurrentFileOutputStream;

  @Mock private Environment environment;

  @Mock private NamedOperationManager namedOperationManager;

  @Mock private StaticAssetService staticAssetService;

  @Mock private StaticAssetServiceExtensionManager staticAssetServiceExtensionManager;

  @Mock private StaticAssetStorageDao staticAssetStorageDao;

  @InjectMocks private StaticAssetStorageServiceImpl staticAssetStorageServiceImpl;

  @Mock private StreamingTransactionCapableUtil streamingTransactionCapableUtil;

  /**
   * Test {@link StaticAssetStorageServiceImpl#findStaticAsset(String)}.
   *
   * <ul>
   *   <li>Then return {@link ImageStaticAssetImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#findStaticAsset(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StaticAsset StaticAssetStorageServiceImpl.findStaticAsset(String)"})
  public void testFindStaticAsset_thenReturnImageStaticAssetImpl() {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = new ImageStaticAssetImpl();
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenReturn(imageStaticAssetImpl);

    // Act
    StaticAsset actualFindStaticAssetResult =
        staticAssetStorageServiceImpl.findStaticAsset("https://example.org/example");

    // Assert
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
    assertSame(imageStaticAssetImpl, actualFindStaticAssetResult);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#findStaticAsset(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#findStaticAsset(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StaticAsset StaticAssetStorageServiceImpl.findStaticAsset(String)"})
  public void testFindStaticAsset_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.findStaticAsset("https://example.org/example"));
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#shouldUseSharedFile(InputStream)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#shouldUseSharedFile(InputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetStorageServiceImpl.shouldUseSharedFile(InputStream)"})
  public void testShouldUseSharedFile_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(
        staticAssetStorageServiceImpl.shouldUseSharedFile(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#shouldUseSharedFile(InputStream)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#shouldUseSharedFile(InputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetStorageServiceImpl.shouldUseSharedFile(InputStream)"})
  public void testShouldUseSharedFile_whenNull() {
    // Arrange, Act and Assert
    assertFalse(staticAssetStorageServiceImpl.shouldUseSharedFile(null));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File StaticAssetStorageServiceImpl.getFileFromLocalRepository(String)"})
  public void testGetFileFromLocalRepository() {
    // Arrange
    when(staticAssetServiceExtensionManager.getProxy()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.getFileFromLocalRepository("foo.txt"));
    verify(staticAssetServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File StaticAssetStorageServiceImpl.getFileFromLocalRepository(String)"})
  public void testGetFileFromLocalRepository2() {
    // Arrange
    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenThrow(new RuntimeException());
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.getFileFromLocalRepository("foo.txt"));
    verify(staticAssetServiceExtensionHandler)
        .fileExists(eq("foo.txt"), isA(ExtensionResultHolder.class));
    verify(staticAssetServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File StaticAssetStorageServiceImpl.getFileFromLocalRepository(String)"})
  public void testGetFileFromLocalRepository3() {
    // Arrange
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);

    // Act
    File actualFileFromLocalRepository =
        staticAssetStorageServiceImpl.getFileFromLocalRepository("foo.txt");

    // Assert
    verify(staticAssetServiceExtensionHandler)
        .fileExists(eq("foo.txt"), isA(ExtensionResultHolder.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService).getSharedLocalResource("foo.txt");
    assertEquals("test.txt", actualFileFromLocalRepository.getName());
    assertTrue(actualFileFromLocalRepository.isAbsolute());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File StaticAssetStorageServiceImpl.getFileFromLocalRepository(String)"})
  public void testGetFileFromLocalRepository4() {
    // Arrange
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.getFileFromLocalRepository("foo.txt"));
    verify(staticAssetServiceExtensionHandler)
        .fileExists(eq("foo.txt"), isA(ExtensionResultHolder.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService).getSharedLocalResource("foo.txt");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File StaticAssetStorageServiceImpl.getFileFromLocalRepository(String)"})
  public void testGetFileFromLocalRepository5() {
    // Arrange
    when(broadleafFileService.getLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "42").toFile());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);

    // Act
    File actualFileFromLocalRepository =
        staticAssetStorageServiceImpl.getFileFromLocalRepository("foo.txt");

    // Assert
    verify(staticAssetServiceExtensionHandler)
        .fileExists(eq("foo.txt"), isA(ExtensionResultHolder.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService).getLocalResource("foo.txt");
    verify(broadleafFileService).getSharedLocalResource("foo.txt");
    assertEquals("test.txt", actualFileFromLocalRepository.getName());
    assertTrue(actualFileFromLocalRepository.isAbsolute());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File StaticAssetStorageServiceImpl.getFileFromLocalRepository(String)"})
  public void testGetFileFromLocalRepository6() {
    // Arrange
    when(broadleafFileService.getLocalResource(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "42").toFile());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.getFileFromLocalRepository("foo.txt"));
    verify(staticAssetServiceExtensionHandler)
        .fileExists(eq("foo.txt"), isA(ExtensionResultHolder.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService).getLocalResource("foo.txt");
    verify(broadleafFileService).getSharedLocalResource("foo.txt");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getFileFromLocalRepository(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"File StaticAssetStorageServiceImpl.getFileFromLocalRepository(String)"})
  public void testGetFileFromLocalRepository7() {
    // Arrange
    when(broadleafFileService.getLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "42").toFile());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(null);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);

    // Act
    File actualFileFromLocalRepository =
        staticAssetStorageServiceImpl.getFileFromLocalRepository("foo.txt");

    // Assert
    verify(staticAssetServiceExtensionHandler)
        .fileExists(eq("foo.txt"), isA(ExtensionResultHolder.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService).getLocalResource("foo.txt");
    verify(broadleafFileService).getSharedLocalResource("foo.txt");
    assertEquals("test.txt", actualFileFromLocalRepository.getName());
    assertTrue(actualFileFromLocalRepository.isAbsolute());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "File StaticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(StaticAsset, File)"
  })
  public void testLookupAssetAndCreateLocalFile() throws Throwable {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(
                new ImageStaticAssetImpl(),
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "File StaticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(StaticAsset, File)"
  })
  public void testLookupAssetAndCreateLocalFile2() throws IOException, SQLException {
    // Arrange
    when(broadleafFileService.getResource(Mockito.<String>any())).thenThrow(new RuntimeException());

    ImageStaticAssetImpl staticAsset = mock(ImageStaticAssetImpl.class);
    when(staticAsset.getFullUrl()).thenReturn("https://example.org/example");
    when(staticAsset.getStorageType()).thenReturn(StorageType.FILESYSTEM);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(
                staticAsset, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    verify(staticAsset).getFullUrl();
    verify(staticAsset).getStorageType();
    verify(broadleafFileService).getResource("https://example.org/example");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "File StaticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(StaticAsset, File)"
  })
  public void testLookupAssetAndCreateLocalFile3() throws IOException, SQLException {
    // Arrange
    when(broadleafFileService.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    ImageStaticAssetImpl staticAsset = mock(ImageStaticAssetImpl.class);
    when(staticAsset.getFullUrl()).thenReturn("https://example.org/example");
    when(staticAsset.getStorageType()).thenReturn(new StorageType("FILESYSTEM", "FILESYSTEM"));

    // Act
    File actualLookupAssetAndCreateLocalFileResult =
        staticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(
            staticAsset, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    verify(staticAsset, atLeast(1)).getFullUrl();
    verify(staticAsset).getStorageType();
    verify(broadleafFileService, atLeast(1)).getResource("https://example.org/example");
    assertEquals("test.txt", actualLookupAssetAndCreateLocalFileResult.getName());
    assertTrue(actualLookupAssetAndCreateLocalFileResult.isAbsolute());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}.
   *
   * <ul>
   *   <li>Then return Name is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "File StaticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(StaticAsset, File)"
  })
  public void testLookupAssetAndCreateLocalFile_thenReturnNameIsTestTxt()
      throws IOException, SQLException {
    // Arrange
    when(broadleafFileService.getResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    ImageStaticAssetImpl staticAsset = mock(ImageStaticAssetImpl.class);
    when(staticAsset.getFullUrl()).thenReturn("https://example.org/example");
    when(staticAsset.getStorageType()).thenReturn(StorageType.FILESYSTEM);

    // Act
    File actualLookupAssetAndCreateLocalFileResult =
        staticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(
            staticAsset, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    verify(staticAsset, atLeast(1)).getFullUrl();
    verify(staticAsset).getStorageType();
    verify(broadleafFileService, atLeast(1)).getResource("https://example.org/example");
    assertEquals("test.txt", actualLookupAssetAndCreateLocalFileResult.getName());
    assertTrue(actualLookupAssetAndCreateLocalFileResult.isAbsolute());
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}.
   *
   * <ul>
   *   <li>When {@link ImageStaticAssetImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "File StaticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(StaticAsset, File)"
  })
  public void testLookupAssetAndCreateLocalFile_whenImageStaticAssetImpl() throws Throwable {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());
    File baseLocalFile = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    File actualLookupAssetAndCreateLocalFileResult =
        staticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(
            new ImageStaticAssetImpl(), baseLocalFile);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    assertSame(baseLocalFile, actualLookupAssetAndCreateLocalFileResult);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset,
   * File)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createLocalFileFromClassPathResource(StaticAsset, File)"
  })
  public void testCreateLocalFileFromClassPathResource() throws IOException {
    // Arrange
    when(broadleafFileService.getClasspathResource(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.createLocalFileFromClassPathResource(
                new ImageStaticAssetImpl(),
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    verify(broadleafFileService).getClasspathResource(null);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset,
   * File)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createLocalFileFromClassPathResource(StaticAsset, File)"
  })
  public void testCreateLocalFileFromClassPathResource2() throws IOException {
    // Arrange
    when(broadleafFileService.getClasspathResource(Mockito.<String>any()))
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(concurrentFileOutputStream.write(Mockito.<InputStream>any(), Mockito.<File>any()))
        .thenReturn(19088743);

    // Act
    staticAssetStorageServiceImpl.createLocalFileFromClassPathResource(
        new ImageStaticAssetImpl(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    verify(broadleafFileService).getClasspathResource(null);
    verify(concurrentFileOutputStream).write(isA(InputStream.class), isA(File.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset,
   * File)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createLocalFileFromClassPathResource(StaticAsset, File)"
  })
  public void testCreateLocalFileFromClassPathResource3() throws IOException {
    // Arrange
    when(broadleafFileService.getClasspathResource(Mockito.<String>any()))
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(concurrentFileOutputStream.write(Mockito.<InputStream>any(), Mockito.<File>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.createLocalFileFromClassPathResource(
                new ImageStaticAssetImpl(),
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    verify(broadleafFileService).getClasspathResource(null);
    verify(concurrentFileOutputStream).write(isA(InputStream.class), isA(File.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset,
   * File)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createLocalFileFromClassPathResource(StaticAsset, File)"
  })
  public void testCreateLocalFileFromClassPathResource4() throws IOException {
    // Arrange
    when(broadleafFileService.getClasspathResource(Mockito.<String>any())).thenReturn(null);
    when(concurrentFileOutputStream.write(Mockito.<InputStream>any(), Mockito.<File>any()))
        .thenReturn(19088743);

    // Act
    staticAssetStorageServiceImpl.createLocalFileFromClassPathResource(
        new ImageStaticAssetImpl(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    verify(broadleafFileService).getClasspathResource(null);
    verify(concurrentFileOutputStream).write(isNull(), isA(File.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset,
   * File)}.
   *
   * <ul>
   *   <li>Then calls {@link DataInputStream#close()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createLocalFileFromClassPathResource(StaticAsset, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createLocalFileFromClassPathResource(StaticAsset, File)"
  })
  public void testCreateLocalFileFromClassPathResource_thenCallsClose() throws IOException {
    // Arrange
    DataInputStream dataInputStream = mock(DataInputStream.class);
    doThrow(new IOException()).when(dataInputStream).close();
    when(broadleafFileService.getClasspathResource(Mockito.<String>any()))
        .thenReturn(dataInputStream);
    when(concurrentFileOutputStream.write(Mockito.<InputStream>any(), Mockito.<File>any()))
        .thenReturn(19088743);

    // Act
    staticAssetStorageServiceImpl.createLocalFileFromClassPathResource(
        new ImageStaticAssetImpl(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    verify(dataInputStream).close();
    verify(broadleafFileService).getClasspathResource(null);
    verify(concurrentFileOutputStream).write(isA(InputStream.class), isA(File.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createLocalFileFromInputStream(InputStream, File)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createLocalFileFromInputStream(InputStream, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createLocalFileFromInputStream(InputStream, File)"
  })
  public void testCreateLocalFileFromInputStream() throws IOException {
    // Arrange
    when(concurrentFileOutputStream.write(Mockito.<InputStream>any(), Mockito.<File>any()))
        .thenReturn(19088743);

    // Act
    staticAssetStorageServiceImpl.createLocalFileFromInputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    verify(concurrentFileOutputStream).write(isA(InputStream.class), isA(File.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createLocalFileFromInputStream(InputStream, File)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#close()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createLocalFileFromInputStream(InputStream, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createLocalFileFromInputStream(InputStream, File)"
  })
  public void testCreateLocalFileFromInputStream_givenIOException_thenCallsClose()
      throws IOException {
    // Arrange
    when(concurrentFileOutputStream.write(Mockito.<InputStream>any(), Mockito.<File>any()))
        .thenReturn(19088743);

    DataInputStream is = mock(DataInputStream.class);
    doThrow(new IOException()).when(is).close();

    // Act
    staticAssetStorageServiceImpl.createLocalFileFromInputStream(
        is, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    verify(is).close();
    verify(concurrentFileOutputStream).write(isA(InputStream.class), isA(File.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createLocalFileFromInputStream(InputStream, File)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createLocalFileFromInputStream(InputStream, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createLocalFileFromInputStream(InputStream, File)"
  })
  public void testCreateLocalFileFromInputStream_thenThrowRuntimeException() throws IOException {
    // Arrange
    when(concurrentFileOutputStream.write(Mockito.<InputStream>any(), Mockito.<File>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.createLocalFileFromInputStream(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    verify(concurrentFileOutputStream).write(isA(InputStream.class), isA(File.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createLocalFileFromInputStream(InputStream, File)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link ConcurrentFileOutputStream#write(InputStream, File)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createLocalFileFromInputStream(InputStream, File)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createLocalFileFromInputStream(InputStream, File)"
  })
  public void testCreateLocalFileFromInputStream_whenNull_thenCallsWrite() throws IOException {
    // Arrange
    when(concurrentFileOutputStream.write(Mockito.<InputStream>any(), Mockito.<File>any()))
        .thenReturn(19088743);

    // Act
    staticAssetStorageServiceImpl.createLocalFileFromInputStream(
        null, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Assert
    verify(concurrentFileOutputStream).write(isNull(), isA(File.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetStorageServiceImpl.getCacheFileModel(String, Map)"})
  public void testGetCacheFileModel() throws Exception {
    // Arrange
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.getCacheFileModel(
                "https://example.org/example", new HashMap<>()));
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetStorageServiceImpl.getCacheFileModel(String, Map)"})
  public void testGetCacheFileModel2() throws Exception {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    when(namedOperationManager.manageNamedParameters(Mockito.<Map<String, String>>any()))
        .thenThrow(new RuntimeException());

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setAltText(",");
    staticAssetImpl.setContentMessageValues(new HashMap<>());
    staticAssetImpl.setFileExtension(",");
    staticAssetImpl.setFileSize(3L);
    staticAssetImpl.setFullUrl("https://example.org/example");
    staticAssetImpl.setId(1L);
    staticAssetImpl.setMimeType("text/plain");
    staticAssetImpl.setName(",");
    staticAssetImpl.setStorageType(StorageType.DATABASE);
    staticAssetImpl.setTitle("Dr");
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenReturn(staticAssetImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.getCacheFileModel(
                "https://example.org/example", new HashMap<>()));
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
    verify(namedOperationManager).manageNamedParameters(isA(Map.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetStorageServiceImpl.getCacheFileModel(String, Map)"})
  public void testGetCacheFileModel3() throws Exception {
    // Arrange
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);
    when(namedOperationManager.manageNamedParameters(Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setAltText(",");
    staticAssetImpl.setContentMessageValues(new HashMap<>());
    staticAssetImpl.setFileExtension(",");
    staticAssetImpl.setFileSize(3L);
    staticAssetImpl.setFullUrl("https://example.org/example");
    staticAssetImpl.setId(1L);
    staticAssetImpl.setMimeType("text/plain");
    staticAssetImpl.setName(",");
    staticAssetImpl.setStorageType(StorageType.DATABASE);
    staticAssetImpl.setTitle("Dr");
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenReturn(staticAssetImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.getCacheFileModel(
                "https://example.org/example", new HashMap<>()));
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
    verify(staticAssetServiceExtensionHandler)
        .fileExists(
            eq("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example"),
            isA(ExtensionResultHolder.class));
    verify(namedOperationManager).manageNamedParameters(isA(Map.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService)
        .getSharedLocalResource("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetStorageServiceImpl.getCacheFileModel(String, Map)"})
  public void testGetCacheFileModel4() throws Exception {
    // Arrange
    when(broadleafFileService.getLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), ",").toFile());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);
    when(namedOperationManager.manageNamedParameters(Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setAltText(",");
    staticAssetImpl.setContentMessageValues(new HashMap<>());
    staticAssetImpl.setFileExtension(",");
    staticAssetImpl.setFileSize(3L);
    staticAssetImpl.setFullUrl("https://example.org/example");
    staticAssetImpl.setId(1L);
    staticAssetImpl.setMimeType("text/plain");
    staticAssetImpl.setName(",");
    staticAssetImpl.setStorageType(StorageType.DATABASE);
    staticAssetImpl.setTitle("Dr");
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenReturn(staticAssetImpl);

    // Act
    Map<String, String> actualCacheFileModel =
        staticAssetStorageServiceImpl.getCacheFileModel(
            "https://example.org/example", new HashMap<>());

    // Assert
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
    verify(staticAssetServiceExtensionHandler)
        .fileExists(
            eq("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example"),
            isA(ExtensionResultHolder.class));
    verify(namedOperationManager).manageNamedParameters(isA(Map.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService)
        .getLocalResource("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example");
    verify(broadleafFileService)
        .getSharedLocalResource("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example");
    assertEquals(2, actualCacheFileModel.size());
    assertEquals("text/plain", actualCacheFileModel.get("mimeType"));
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
        actualCacheFileModel.get("cacheFilePath"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetStorageServiceImpl.getCacheFileModel(String, Map)"})
  public void testGetCacheFileModel5() throws Exception {
    // Arrange
    when(broadleafFileService.getLocalResource(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), ",").toFile());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);
    when(namedOperationManager.manageNamedParameters(Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setAltText(",");
    staticAssetImpl.setContentMessageValues(new HashMap<>());
    staticAssetImpl.setFileExtension(",");
    staticAssetImpl.setFileSize(3L);
    staticAssetImpl.setFullUrl("https://example.org/example");
    staticAssetImpl.setId(1L);
    staticAssetImpl.setMimeType("text/plain");
    staticAssetImpl.setName(",");
    staticAssetImpl.setStorageType(StorageType.DATABASE);
    staticAssetImpl.setTitle("Dr");
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenReturn(staticAssetImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.getCacheFileModel(
                "https://example.org/example", new HashMap<>()));
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
    verify(staticAssetServiceExtensionHandler)
        .fileExists(
            eq("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example"),
            isA(ExtensionResultHolder.class));
    verify(namedOperationManager).manageNamedParameters(isA(Map.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService)
        .getLocalResource("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example");
    verify(broadleafFileService)
        .getSharedLocalResource("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example");
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentFileOutputStream} {@link
   *       ConcurrentFileOutputStream#write(InputStream, File)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetStorageServiceImpl.getCacheFileModel(String, Map)"})
  public void testGetCacheFileModel_givenConcurrentFileOutputStreamWriteThrowRuntimeException()
      throws Exception {
    // Arrange
    when(broadleafFileService.getClasspathResource(Mockito.<String>any()))
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(broadleafFileService.checkForResourceOnClassPath(Mockito.<String>any())).thenReturn(true);
    when(broadleafFileService.getLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), ",").toFile());
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), ",").toFile());
    when(concurrentFileOutputStream.write(Mockito.<InputStream>any(), Mockito.<File>any()))
        .thenThrow(new RuntimeException());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);
    when(namedOperationManager.manageNamedParameters(Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setAltText(",");
    staticAssetImpl.setContentMessageValues(new HashMap<>());
    staticAssetImpl.setFileExtension(",");
    staticAssetImpl.setFileSize(3L);
    staticAssetImpl.setFullUrl("https://example.org/example");
    staticAssetImpl.setId(1L);
    staticAssetImpl.setMimeType("text/plain");
    staticAssetImpl.setName(",");
    staticAssetImpl.setStorageType(StorageType.DATABASE);
    staticAssetImpl.setTitle("Dr");
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenReturn(staticAssetImpl);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.getCacheFileModel(
                "https://example.org/example", new HashMap<>()));
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
    verify(staticAssetServiceExtensionHandler, atLeast(1))
        .fileExists(
            eq("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example"),
            Mockito.<ExtensionResultHolder<Object>>any());
    verify(namedOperationManager).manageNamedParameters(isA(Map.class));
    verify(staticAssetServiceExtensionManager, atLeast(1)).getProxy();
    verify(broadleafFileService).checkForResourceOnClassPath("https://example.org/example");
    verify(broadleafFileService).getClasspathResource("https://example.org/example");
    verify(broadleafFileService, atLeast(1))
        .getLocalResource("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example");
    verify(broadleafFileService, atLeast(1))
        .getSharedLocalResource("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example");
    verify(concurrentFileOutputStream).write(isA(InputStream.class), isA(File.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code ,} is {@code ,}.
   *   <li>Then return {@code mimeType} is {@code text/plain}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetStorageServiceImpl.getCacheFileModel(String, Map)"})
  public void testGetCacheFileModel_givenHashMapCommaIsComma_thenReturnMimeTypeIsTextPlain()
      throws Exception {
    // Arrange
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put(",", ",");
    when(namedOperationManager.manageNamedParameters(Mockito.<Map<String, String>>any()))
        .thenReturn(stringStringMap);

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setAltText(",");
    staticAssetImpl.setContentMessageValues(new HashMap<>());
    staticAssetImpl.setFileExtension(",");
    staticAssetImpl.setFileSize(3L);
    staticAssetImpl.setFullUrl("https://example.org/example");
    staticAssetImpl.setId(1L);
    staticAssetImpl.setMimeType("text/plain");
    staticAssetImpl.setName(",");
    staticAssetImpl.setStorageType(StorageType.DATABASE);
    staticAssetImpl.setTitle("Dr");
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenReturn(staticAssetImpl);

    // Act
    Map<String, String> actualCacheFileModel =
        staticAssetStorageServiceImpl.getCacheFileModel(
            "https://example.org/example", new HashMap<>());

    // Assert
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
    verify(staticAssetServiceExtensionHandler)
        .fileExists(
            eq("https://example---ec4c0a214e3a9e5dc5c02968e891dbfb.org/example"),
            isA(ExtensionResultHolder.class));
    verify(namedOperationManager).manageNamedParameters(isA(Map.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService)
        .getSharedLocalResource("https://example---ec4c0a214e3a9e5dc5c02968e891dbfb.org/example");
    assertEquals(2, actualCacheFileModel.size());
    assertEquals("text/plain", actualCacheFileModel.get("mimeType"));
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
        actualCacheFileModel.get("cacheFilePath"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}.
   *
   * <ul>
   *   <li>Then return {@code mimeType} is {@code image/png}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetStorageServiceImpl.getCacheFileModel(String, Map)"})
  public void testGetCacheFileModel_thenReturnMimeTypeIsImagePng() throws Exception {
    // Arrange
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);
    when(namedOperationManager.manageNamedParameters(Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setAltText(",");
    staticAssetImpl.setContentMessageValues(new HashMap<>());
    staticAssetImpl.setFileExtension(",");
    staticAssetImpl.setFileSize(3L);
    staticAssetImpl.setFullUrl("https://example.org/example");
    staticAssetImpl.setId(1L);
    staticAssetImpl.setMimeType("image/png");
    staticAssetImpl.setName(",");
    staticAssetImpl.setStorageType(StorageType.DATABASE);
    staticAssetImpl.setTitle("Dr");
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenReturn(staticAssetImpl);

    // Act
    Map<String, String> actualCacheFileModel =
        staticAssetStorageServiceImpl.getCacheFileModel(
            "https://example.org/example", new HashMap<>());

    // Assert
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
    verify(staticAssetServiceExtensionHandler)
        .fileExists(
            eq("https://example---085eede51150f1845dff2fcf12c551bd.org/example"),
            isA(ExtensionResultHolder.class));
    verify(namedOperationManager).manageNamedParameters(isA(Map.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService)
        .getSharedLocalResource("https://example---085eede51150f1845dff2fcf12c551bd.org/example");
    assertEquals(2, actualCacheFileModel.size());
    assertEquals("image/png", actualCacheFileModel.get("mimeType"));
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
        actualCacheFileModel.get("cacheFilePath"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}.
   *
   * <ul>
   *   <li>Then return {@code mimeType} is {@code text/plain}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getCacheFileModel(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetStorageServiceImpl.getCacheFileModel(String, Map)"})
  public void testGetCacheFileModel_thenReturnMimeTypeIsTextPlain() throws Exception {
    // Arrange
    when(broadleafFileService.getSharedLocalResource(Mockito.<String>any()))
        .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    StaticAssetServiceExtensionHandler staticAssetServiceExtensionHandler =
        mock(StaticAssetServiceExtensionHandler.class);
    when(staticAssetServiceExtensionHandler.fileExists(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(staticAssetServiceExtensionManager.getProxy())
        .thenReturn(staticAssetServiceExtensionHandler);
    when(namedOperationManager.manageNamedParameters(Mockito.<Map<String, String>>any()))
        .thenReturn(new HashMap<>());

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setAltText(",");
    staticAssetImpl.setContentMessageValues(new HashMap<>());
    staticAssetImpl.setFileExtension(",");
    staticAssetImpl.setFileSize(3L);
    staticAssetImpl.setFullUrl("https://example.org/example");
    staticAssetImpl.setId(1L);
    staticAssetImpl.setMimeType("text/plain");
    staticAssetImpl.setName(",");
    staticAssetImpl.setStorageType(StorageType.DATABASE);
    staticAssetImpl.setTitle("Dr");
    when(staticAssetService.findStaticAssetByFullUrl(Mockito.<String>any()))
        .thenReturn(staticAssetImpl);

    // Act
    Map<String, String> actualCacheFileModel =
        staticAssetStorageServiceImpl.getCacheFileModel(
            "https://example.org/example", new HashMap<>());

    // Assert
    verify(staticAssetService).findStaticAssetByFullUrl("https://example.org/example");
    verify(staticAssetServiceExtensionHandler)
        .fileExists(
            eq("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example"),
            isA(ExtensionResultHolder.class));
    verify(namedOperationManager).manageNamedParameters(isA(Map.class));
    verify(staticAssetServiceExtensionManager).getProxy();
    verify(broadleafFileService)
        .getSharedLocalResource("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example");
    assertEquals(2, actualCacheFileModel.size());
    assertEquals("text/plain", actualCacheFileModel.get("mimeType"));
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toString(),
        actualCacheFileModel.get("cacheFilePath"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#shouldRecompress(String)}.
   *
   * <ul>
   *   <li>When {@code image/png}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#shouldRecompress(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetStorageServiceImpl.shouldRecompress(String)"})
  public void testShouldRecompress_whenImagePng_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(staticAssetStorageServiceImpl.shouldRecompress("image/png"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#shouldRecompress(String)}.
   *
   * <ul>
   *   <li>When {@code text/plain}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#shouldRecompress(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetStorageServiceImpl.shouldRecompress(String)"})
  public void testShouldRecompress_whenTextPlain_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(staticAssetStorageServiceImpl.shouldRecompress("text/plain"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#buildModel(String, String)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#buildModel(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map StaticAssetStorageServiceImpl.buildModel(String, String)"})
  public void testBuildModel() {
    // Arrange and Act
    Map<String, String> actualBuildModelResult =
        staticAssetStorageServiceImpl.buildModel("/directory/foo.txt", "text/plain");

    // Assert
    assertEquals(2, actualBuildModelResult.size());
    assertEquals("/directory/foo.txt", actualBuildModelResult.get("cacheFilePath"));
    assertEquals("text/plain", actualBuildModelResult.get("mimeType"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#findStaticAssetStorageById(Long)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#findStaticAssetStorageById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StaticAssetStorage StaticAssetStorageServiceImpl.findStaticAssetStorageById(Long)"
  })
  public void testFindStaticAssetStorageById_thenReturnNull() throws Throwable {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act
    StaticAssetStorage actualFindStaticAssetStorageByIdResult =
        staticAssetStorageServiceImpl.findStaticAssetStorageById(1L);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    assertNull(actualFindStaticAssetStorageByIdResult);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#findStaticAssetStorageById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#findStaticAssetStorageById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StaticAssetStorage StaticAssetStorageServiceImpl.findStaticAssetStorageById(Long)"
  })
  public void testFindStaticAssetStorageById_thenThrowRuntimeException() throws Throwable {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> staticAssetStorageServiceImpl.findStaticAssetStorageById(1L));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#create()}.
   *
   * <ul>
   *   <li>Then return {@link StaticAssetStorageImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StaticAssetStorage StaticAssetStorageServiceImpl.create()"})
  public void testCreate_thenReturnStaticAssetStorageImpl() {
    // Arrange
    StaticAssetStorageImpl staticAssetStorageImpl = new StaticAssetStorageImpl();
    when(staticAssetStorageDao.create()).thenReturn(staticAssetStorageImpl);

    // Act
    StaticAssetStorage actualCreateResult = staticAssetStorageServiceImpl.create();

    // Assert
    verify(staticAssetStorageDao).create();
    assertSame(staticAssetStorageImpl, actualCreateResult);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#create()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StaticAssetStorage StaticAssetStorageServiceImpl.create()"})
  public void testCreate_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetStorageDao.create()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetStorageServiceImpl.create());
    verify(staticAssetStorageDao).create();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#readStaticAssetStorageByStaticAssetId(Long)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#readStaticAssetStorageByStaticAssetId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StaticAssetStorage StaticAssetStorageServiceImpl.readStaticAssetStorageByStaticAssetId(Long)"
  })
  public void testReadStaticAssetStorageByStaticAssetId_thenReturnNull() throws Throwable {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act
    StaticAssetStorage actualReadStaticAssetStorageByStaticAssetIdResult =
        staticAssetStorageServiceImpl.readStaticAssetStorageByStaticAssetId(1L);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    assertNull(actualReadStaticAssetStorageByStaticAssetIdResult);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#readStaticAssetStorageByStaticAssetId(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#readStaticAssetStorageByStaticAssetId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StaticAssetStorage StaticAssetStorageServiceImpl.readStaticAssetStorageByStaticAssetId(Long)"
  })
  public void testReadStaticAssetStorageByStaticAssetId_thenThrowRuntimeException()
      throws Throwable {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.readStaticAssetStorageByStaticAssetId(1L));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#save(StaticAssetStorage)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#save(StaticAssetStorage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StaticAssetStorage StaticAssetStorageServiceImpl.save(StaticAssetStorage)"})
  public void testSave_thenReturnNull() throws Throwable {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act
    StaticAssetStorage actualSaveResult =
        staticAssetStorageServiceImpl.save(new StaticAssetStorageImpl());

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    assertNull(actualSaveResult);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#save(StaticAssetStorage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#save(StaticAssetStorage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StaticAssetStorage StaticAssetStorageServiceImpl.save(StaticAssetStorage)"})
  public void testSave_thenThrowRuntimeException() throws Throwable {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.save(new StaticAssetStorageImpl()));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#delete(StaticAssetStorage)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#delete(StaticAssetStorage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticAssetStorageServiceImpl.delete(StaticAssetStorage)"})
  public void testDelete() throws Throwable {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act
    staticAssetStorageServiceImpl.delete(new StaticAssetStorageImpl());

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#delete(StaticAssetStorage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#delete(StaticAssetStorage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticAssetStorageServiceImpl.delete(StaticAssetStorage)"})
  public void testDelete_thenThrowRuntimeException() throws Throwable {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.delete(new StaticAssetStorageImpl()));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createBlob(InputStream, long)} with {@code
   * uploadedFileInputStream}, {@code fileSize}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#createBlob(InputStream, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Blob StaticAssetStorageServiceImpl.createBlob(InputStream, long)"})
  public void testCreateBlobWithUploadedFileInputStreamFileSize_thenReturnNull() throws Throwable {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act
    Blob actualCreateBlobResult =
        staticAssetStorageServiceImpl.createBlob(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 3L);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    assertNull(actualCreateBlobResult);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createBlob(InputStream, long)} with {@code
   * uploadedFileInputStream}, {@code fileSize}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#createBlob(InputStream, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Blob StaticAssetStorageServiceImpl.createBlob(InputStream, long)"})
  public void testCreateBlobWithUploadedFileInputStreamFileSize_thenThrowRuntimeException()
      throws Throwable {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            staticAssetStorageServiceImpl.createBlob(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 3L));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createBlob(MultipartFile)} with {@code uploadedFile}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#createBlob(MultipartFile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Blob StaticAssetStorageServiceImpl.createBlob(MultipartFile)"})
  public void testCreateBlobWithUploadedFile_thenReturnNull() throws Throwable {
    // Arrange
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());
    MockMultipartFile uploadedFile =
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    Blob actualCreateBlobResult = staticAssetStorageServiceImpl.createBlob(uploadedFile);

    // Assert
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
    assertNull(actualCreateBlobResult);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createBlob(MultipartFile)} with {@code uploadedFile}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#createBlob(MultipartFile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Blob StaticAssetStorageServiceImpl.createBlob(MultipartFile)"})
  public void testCreateBlobWithUploadedFile_thenThrowRuntimeException() throws Throwable {
    // Arrange
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());
    MockMultipartFile uploadedFile =
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> staticAssetStorageServiceImpl.createBlob(uploadedFile));
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset, Map)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetStorageServiceImpl.constructCacheFileName(StaticAsset, Map)"
  })
  public void testConstructCacheFileName() {
    // Arrange
    StaticAssetImpl staticAsset = new StaticAssetImpl();
    staticAsset.setAltText("Alt Text");
    staticAsset.setContentMessageValues(new HashMap<>());
    staticAsset.setFileExtension("File Extension");
    staticAsset.setFileSize(3L);
    staticAsset.setFullUrl("https://example.org/example");
    staticAsset.setId(1L);
    staticAsset.setMimeType("text/plain");
    staticAsset.setName("Name");
    staticAsset.setStorageType(StorageType.DATABASE);
    staticAsset.setTitle("Dr");

    // Act and Assert
    assertEquals(
        "https://example---d41d8cd98f00b204e9800998ecf8427e.org/example",
        staticAssetStorageServiceImpl.constructCacheFileName(staticAsset, new HashMap<>()));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset, Map)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetStorageServiceImpl.constructCacheFileName(StaticAsset, Map)"
  })
  public void testConstructCacheFileName2() {
    // Arrange
    StaticAssetImpl staticAsset = new StaticAssetImpl();
    staticAsset.setAltText("Alt Text");
    staticAsset.setContentMessageValues(new HashMap<>());
    staticAsset.setFileExtension("File Extension");
    staticAsset.setFileSize(3L);
    staticAsset.setFullUrl("https://example.org/example");
    staticAsset.setId(1L);
    staticAsset.setMimeType("text/plain");
    staticAsset.setName("Name");
    staticAsset.setStorageType(StorageType.DATABASE);
    staticAsset.setTitle("Dr");

    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("---", "---");

    // Act and Assert
    assertEquals(
        "https://example---9dc5f758e8e773980f07a95bfc8642f1.org/example",
        staticAssetStorageServiceImpl.constructCacheFileName(staticAsset, parameterMap));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset, Map)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String StaticAssetStorageServiceImpl.constructCacheFileName(StaticAsset, Map)"
  })
  public void testConstructCacheFileName3() {
    // Arrange
    StaticAssetImpl staticAsset = new StaticAssetImpl();
    staticAsset.setAltText("Alt Text");
    staticAsset.setContentMessageValues(new HashMap<>());
    staticAsset.setFileExtension("File Extension");
    staticAsset.setFileSize(3L);
    staticAsset.setFullUrl("https://example.org/example");
    staticAsset.setId(1L);
    staticAsset.setMimeType("text/plain");
    staticAsset.setName("Name");
    staticAsset.setStorageType(StorageType.DATABASE);
    staticAsset.setTitle("Dr");

    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("42", "---");

    // Act and Assert
    assertEquals(
        "https://example---0c37ed02b7bae1079ca1789c9920b799.org/example",
        staticAssetStorageServiceImpl.constructCacheFileName(staticAsset, parameterMap));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#pad(String, int, char)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#pad(String, int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetStorageServiceImpl.pad(String, int, char)"})
  public void testPad_whenFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", staticAssetStorageServiceImpl.pad("foo", 3, 'A'));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#pad(String, int, char)}.
   *
   * <ul>
   *   <li>When {@code )}.
   *   <li>Then return {@code AA)}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#pad(String, int, char)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetStorageServiceImpl.pad(String, int, char)"})
  public void testPad_whenRightParenthesis_thenReturnAa() {
    // Arrange, Act and Assert
    assertEquals("AA)", staticAssetStorageServiceImpl.pad(")", 3, 'A'));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile,
   * StaticAsset)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile, StaticAsset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createStaticAssetStorageFromFile(MultipartFile, StaticAsset)"
  })
  public void testCreateStaticAssetStorageFromFile() throws IOException {
    // Arrange
    when(staticAssetStorageDao.create()).thenThrow(new RuntimeException());
    MockMultipartFile file =
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    ImageStaticAssetImpl staticAsset = new ImageStaticAssetImpl();
    staticAsset.setStorageType(StorageType.DATABASE);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.createStaticAssetStorageFromFile(file, staticAsset));
    verify(staticAssetStorageDao).create();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile,
   * StaticAsset)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile, StaticAsset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createStaticAssetStorageFromFile(MultipartFile, StaticAsset)"
  })
  public void testCreateStaticAssetStorageFromFile2() throws Throwable {
    // Arrange
    when(staticAssetStorageDao.create()).thenReturn(new StaticAssetStorageImpl());
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());
    MockMultipartFile file =
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    StaticAssetImpl staticAsset = new StaticAssetImpl();
    staticAsset.setAltText("Alt Text");
    staticAsset.setContentMessageValues(new HashMap<>());
    staticAsset.setFileExtension("File Extension");
    staticAsset.setFileSize(3L);
    staticAsset.setFullUrl("https://example.org/example");
    staticAsset.setId(1L);
    staticAsset.setMimeType("text/plain");
    staticAsset.setName("Name");
    staticAsset.setStorageType(StorageType.DATABASE);
    staticAsset.setTitle("Dr");
    staticAsset.setStorageType(StorageType.DATABASE);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.createStaticAssetStorageFromFile(file, staticAsset));
    verify(staticAssetStorageDao).create();
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile,
   * StaticAsset)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile, StaticAsset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createStaticAssetStorageFromFile(MultipartFile, StaticAsset)"
  })
  public void testCreateStaticAssetStorageFromFile_givenNull() throws IOException {
    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl =
        new StaticAssetStorageServiceImpl();
    MockMultipartFile file =
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    StaticAsset staticAsset = mock(StaticAsset.class);
    when(staticAsset.getStorageType()).thenReturn(null);

    // Act
    staticAssetStorageServiceImpl.createStaticAssetStorageFromFile(file, staticAsset);

    // Assert
    verify(staticAsset, atLeast(1)).getStorageType();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile,
   * StaticAsset)}.
   *
   * <ul>
   *   <li>Given {@link StorageType#StorageType(String, String)} with {@code Type} and {@code
   *       Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile, StaticAsset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createStaticAssetStorageFromFile(MultipartFile, StaticAsset)"
  })
  public void testCreateStaticAssetStorageFromFile_givenStorageTypeWithTypeAndFriendlyType()
      throws IOException {
    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl =
        new StaticAssetStorageServiceImpl();
    MockMultipartFile file =
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    StaticAsset staticAsset = mock(StaticAsset.class);
    when(staticAsset.getStorageType()).thenReturn(new StorageType("Type", "Friendly Type"));

    // Act
    staticAssetStorageServiceImpl.createStaticAssetStorageFromFile(file, staticAsset);

    // Assert
    verify(staticAsset, atLeast(1)).getStorageType();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile,
   * StaticAsset)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation,
   *       Class)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile, StaticAsset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createStaticAssetStorageFromFile(MultipartFile, StaticAsset)"
  })
  public void testCreateStaticAssetStorageFromFile_thenCallsRunTransactionalOperation()
      throws Throwable {
    // Arrange
    when(staticAssetStorageDao.create()).thenReturn(new StaticAssetStorageImpl());
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());
    MockMultipartFile file =
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    StaticAssetImpl staticAsset = new StaticAssetImpl();
    staticAsset.setAltText("Alt Text");
    staticAsset.setContentMessageValues(new HashMap<>());
    staticAsset.setFileExtension("File Extension");
    staticAsset.setFileSize(3L);
    staticAsset.setFullUrl("https://example.org/example");
    staticAsset.setId(1L);
    staticAsset.setMimeType("text/plain");
    staticAsset.setName("Name");
    staticAsset.setStorageType(StorageType.DATABASE);
    staticAsset.setTitle("Dr");
    staticAsset.setStorageType(StorageType.DATABASE);

    // Act
    staticAssetStorageServiceImpl.createStaticAssetStorageFromFile(file, staticAsset);

    // Assert
    verify(staticAssetStorageDao).create();
    verify(streamingTransactionCapableUtil, atLeast(1))
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createStaticAssetStorage(InputStream, StaticAsset)"
  })
  public void testCreateStaticAssetStorage() throws IOException {
    // Arrange
    when(staticAssetStorageDao.create()).thenThrow(new RuntimeException());
    ByteArrayInputStream fileInputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ImageStaticAssetImpl staticAsset = new ImageStaticAssetImpl();
    staticAsset.setStorageType(StorageType.DATABASE);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.createStaticAssetStorage(fileInputStream, staticAsset));
    verify(staticAssetStorageDao).create();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}.
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createStaticAssetStorage(InputStream, StaticAsset)"
  })
  public void testCreateStaticAssetStorage2() throws Throwable {
    // Arrange
    when(staticAssetStorageDao.create()).thenReturn(new StaticAssetStorageImpl());
    doThrow(new RuntimeException())
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());
    ByteArrayInputStream fileInputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    StaticAssetImpl staticAsset = new StaticAssetImpl();
    staticAsset.setAltText("Alt Text");
    staticAsset.setContentMessageValues(new HashMap<>());
    staticAsset.setFileExtension("File Extension");
    staticAsset.setFileSize(3L);
    staticAsset.setFullUrl("https://example.org/example");
    staticAsset.setId(1L);
    staticAsset.setMimeType("text/plain");
    staticAsset.setName("Name");
    staticAsset.setStorageType(StorageType.DATABASE);
    staticAsset.setTitle("Dr");
    staticAsset.setStorageType(StorageType.DATABASE);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.createStaticAssetStorage(fileInputStream, staticAsset));
    verify(staticAssetStorageDao).create();
    verify(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            isA(StreamCapableTransactionalOperation.class), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link StaticAsset} {@link StaticAsset#getStorageType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createStaticAssetStorage(InputStream, StaticAsset)"
  })
  public void testCreateStaticAssetStorage_givenNull_whenStaticAssetGetStorageTypeReturnNull()
      throws IOException {
    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl =
        new StaticAssetStorageServiceImpl();
    ByteArrayInputStream fileInputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    StaticAsset staticAsset = mock(StaticAsset.class);
    when(staticAsset.getStorageType()).thenReturn(null);

    // Act
    staticAssetStorageServiceImpl.createStaticAssetStorage(fileInputStream, staticAsset);

    // Assert
    verify(staticAsset, atLeast(1)).getStorageType();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}.
   *
   * <ul>
   *   <li>Given {@link StorageType#StorageType(String, String)} with {@code Type} and {@code
   *       Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createStaticAssetStorage(InputStream, StaticAsset)"
  })
  public void testCreateStaticAssetStorage_givenStorageTypeWithTypeAndFriendlyType()
      throws IOException {
    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl =
        new StaticAssetStorageServiceImpl();
    ByteArrayInputStream fileInputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    StaticAsset staticAsset = mock(StaticAsset.class);
    when(staticAsset.getStorageType()).thenReturn(new StorageType("Type", "Friendly Type"));

    // Act
    staticAssetStorageServiceImpl.createStaticAssetStorage(fileInputStream, staticAsset);

    // Assert
    verify(staticAsset, atLeast(1)).getStorageType();
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       StreamingTransactionCapableUtil#runTransactionalOperation(StreamCapableTransactionalOperation,
   *       Class)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetStorageServiceImpl.createStaticAssetStorage(InputStream, StaticAsset)"
  })
  public void testCreateStaticAssetStorage_thenCallsRunTransactionalOperation() throws Throwable {
    // Arrange
    when(staticAssetStorageDao.create()).thenReturn(new StaticAssetStorageImpl());
    doNothing()
        .when(streamingTransactionCapableUtil)
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(),
            Mockito.<Class<RuntimeException>>any());
    ByteArrayInputStream fileInputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    StaticAssetImpl staticAsset = new StaticAssetImpl();
    staticAsset.setAltText("Alt Text");
    staticAsset.setContentMessageValues(new HashMap<>());
    staticAsset.setFileExtension("File Extension");
    staticAsset.setFileSize(3L);
    staticAsset.setFullUrl("https://example.org/example");
    staticAsset.setId(1L);
    staticAsset.setMimeType("text/plain");
    staticAsset.setName("Name");
    staticAsset.setStorageType(StorageType.DATABASE);
    staticAsset.setTitle("Dr");
    staticAsset.setStorageType(StorageType.DATABASE);

    // Act
    staticAssetStorageServiceImpl.createStaticAssetStorage(fileInputStream, staticAsset);

    // Assert
    verify(staticAssetStorageDao).create();
    verify(streamingTransactionCapableUtil, atLeast(1))
        .runTransactionalOperation(
            Mockito.<StreamCapableTransactionalOperation>any(), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadSizeForFile(String)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getMaxUploadSizeForFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long StaticAssetStorageServiceImpl.getMaxUploadSizeForFile(String)"})
  public void testGetMaxUploadSizeForFile_givenEnvironmentGetPropertyReturnOne_thenReturnOne() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(1L);
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenReturn("Property");

    // Act
    long actualMaxUploadSizeForFile =
        staticAssetStorageServiceImpl.getMaxUploadSizeForFile("foo.txt");

    // Assert
    verify(environment).getProperty(eq("asset.server.max.uploadable.file.size"), isA(Class.class));
    verify(environment)
        .getProperty(
            eq("admin.image.file.extensions"),
            isA(Class.class),
            eq("bmp,jpg,jpeg,png,img,tiff,gif"));
    assertEquals(1L, actualMaxUploadSizeForFile);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadSizeForFile(String)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getMaxUploadSizeForFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long StaticAssetStorageServiceImpl.getMaxUploadSizeForFile(String)"})
  public void testGetMaxUploadSizeForFile_givenEnvironmentGetPropertyThrowRuntimeException() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.getMaxUploadSizeForFile("foo.txt"));
    verify(environment)
        .getProperty(
            eq("admin.image.file.extensions"),
            isA(Class.class),
            eq("bmp,jpg,jpeg,png,img,tiff,gif"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadSizeForFile(String)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getMaxUploadSizeForFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long StaticAssetStorageServiceImpl.getMaxUploadSizeForFile(String)"})
  public void testGetMaxUploadSizeForFile_givenEnvironmentGetPropertyThrowRuntimeException2() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenThrow(new RuntimeException());
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenReturn("Property");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> staticAssetStorageServiceImpl.getMaxUploadSizeForFile("foo.txt"));
    verify(environment).getProperty(eq("asset.server.max.uploadable.file.size"), isA(Class.class));
    verify(environment)
        .getProperty(
            eq("admin.image.file.extensions"),
            isA(Class.class),
            eq("bmp,jpg,jpeg,png,img,tiff,gif"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadSizeForFile(String)}.
   *
   * <ul>
   *   <li>Then return {@link StaticAssetStorageServiceImpl#DEFAULT_ASSET_UPLOAD_SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getMaxUploadSizeForFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long StaticAssetStorageServiceImpl.getMaxUploadSizeForFile(String)"})
  public void testGetMaxUploadSizeForFile_thenReturnDefault_asset_upload_size() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenReturn(null);
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenReturn("Property");

    // Act
    long actualMaxUploadSizeForFile =
        staticAssetStorageServiceImpl.getMaxUploadSizeForFile("foo.txt");

    // Assert
    verify(environment).getProperty(eq("asset.server.max.uploadable.file.size"), isA(Class.class));
    verify(environment)
        .getProperty(
            eq("admin.image.file.extensions"),
            isA(Class.class),
            eq("bmp,jpg,jpeg,png,img,tiff,gif"));
    assertEquals(
        StaticAssetStorageServiceImpl.DEFAULT_ASSET_UPLOAD_SIZE, actualMaxUploadSizeForFile);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#isImageFile(String)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#isImageFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetStorageServiceImpl.isImageFile(String)"})
  public void testIsImageFile_givenEnvironmentGetPropertyReturn42_when42_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenReturn("42");

    // Act
    boolean actualIsImageFileResult = staticAssetStorageServiceImpl.isImageFile("42");

    // Assert
    verify(environment)
        .getProperty(
            eq("admin.image.file.extensions"),
            isA(Class.class),
            eq("bmp,jpg,jpeg,png,img,tiff,gif"));
    assertTrue(actualIsImageFileResult);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#isImageFile(String)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code Property}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#isImageFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetStorageServiceImpl.isImageFile(String)"})
  public void testIsImageFile_givenEnvironmentGetPropertyReturnProperty_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenReturn("Property");

    // Act
    boolean actualIsImageFileResult = staticAssetStorageServiceImpl.isImageFile("foo.txt");

    // Assert
    verify(environment)
        .getProperty(
            eq("admin.image.file.extensions"),
            isA(Class.class),
            eq("bmp,jpg,jpeg,png,img,tiff,gif"));
    assertFalse(actualIsImageFileResult);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#isImageFile(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#isImageFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StaticAssetStorageServiceImpl.isImageFile(String)"})
  public void testIsImageFile_thenThrowRuntimeException() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> staticAssetStorageServiceImpl.isImageFile("foo.txt"));
    verify(environment)
        .getProperty(
            eq("admin.image.file.extensions"),
            isA(Class.class),
            eq("bmp,jpg,jpeg,png,img,tiff,gif"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileExtension(String)}.
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getFileExtension(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetStorageServiceImpl.getFileExtension(String)"})
  public void testGetFileExtension() {
    // Arrange, Act and Assert
    assertEquals("Asset Path", staticAssetStorageServiceImpl.getFileExtension("Asset Path"));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadableFileSize()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getMaxUploadableFileSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long StaticAssetStorageServiceImpl.getMaxUploadableFileSize()"})
  public void testGetMaxUploadableFileSize_givenEnvironmentGetPropertyReturnOne_thenReturnOne() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(1L);

    // Act
    long actualMaxUploadableFileSize = staticAssetStorageServiceImpl.getMaxUploadableFileSize();

    // Assert
    verify(environment).getProperty(eq("asset.server.max.uploadable.file.size"), isA(Class.class));
    assertEquals(1L, actualMaxUploadableFileSize);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadableFileSize()}.
   *
   * <ul>
   *   <li>Then return {@link StaticAssetStorageServiceImpl#DEFAULT_ASSET_UPLOAD_SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getMaxUploadableFileSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long StaticAssetStorageServiceImpl.getMaxUploadableFileSize()"})
  public void testGetMaxUploadableFileSize_thenReturnDefault_asset_upload_size() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenReturn(null);

    // Act
    long actualMaxUploadableFileSize = staticAssetStorageServiceImpl.getMaxUploadableFileSize();

    // Assert
    verify(environment).getProperty(eq("asset.server.max.uploadable.file.size"), isA(Class.class));
    assertEquals(
        StaticAssetStorageServiceImpl.DEFAULT_ASSET_UPLOAD_SIZE, actualMaxUploadableFileSize);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadableFileSize()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getMaxUploadableFileSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long StaticAssetStorageServiceImpl.getMaxUploadableFileSize()"})
  public void testGetMaxUploadableFileSize_thenThrowRuntimeException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> staticAssetStorageServiceImpl.getMaxUploadableFileSize());
    verify(environment).getProperty(eq("asset.server.max.uploadable.file.size"), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadableImageSize()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getMaxUploadableImageSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long StaticAssetStorageServiceImpl.getMaxUploadableImageSize()"})
  public void testGetMaxUploadableImageSize_givenEnvironmentGetPropertyReturnOne_thenReturnOne() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(1L);

    // Act
    long actualMaxUploadableImageSize = staticAssetStorageServiceImpl.getMaxUploadableImageSize();

    // Assert
    verify(environment).getProperty(eq("asset.server.max.uploadable.image.size"), isA(Class.class));
    assertEquals(1L, actualMaxUploadableImageSize);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadableImageSize()}.
   *
   * <ul>
   *   <li>Then return {@link StaticAssetStorageServiceImpl#DEFAULT_ASSET_UPLOAD_SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getMaxUploadableImageSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long StaticAssetStorageServiceImpl.getMaxUploadableImageSize()"})
  public void testGetMaxUploadableImageSize_thenReturnDefault_asset_upload_size() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenReturn(null);

    // Act
    long actualMaxUploadableImageSize = staticAssetStorageServiceImpl.getMaxUploadableImageSize();

    // Assert
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any(), isA(Class.class));
    assertEquals(
        StaticAssetStorageServiceImpl.DEFAULT_ASSET_UPLOAD_SIZE, actualMaxUploadableImageSize);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getMaxUploadableImageSize()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getMaxUploadableImageSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long StaticAssetStorageServiceImpl.getMaxUploadableImageSize()"})
  public void testGetMaxUploadableImageSize_thenThrowRuntimeException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Long>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> staticAssetStorageServiceImpl.getMaxUploadableImageSize());
    verify(environment).getProperty(eq("asset.server.max.uploadable.image.size"), isA(Class.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileBufferSize()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code 8096}.
   *   <li>Then return {@code 8096}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getFileBufferSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int StaticAssetStorageServiceImpl.getFileBufferSize()"})
  public void testGetFileBufferSize_givenEnvironmentGetPropertyReturn8096_thenReturn8096() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(8096);

    // Act
    int actualFileBufferSize = staticAssetStorageServiceImpl.getFileBufferSize();

    // Assert
    verify(environment)
        .getProperty(eq("asset.server.file.buffer.size"), isA(Class.class), isA(Object.class));
    assertEquals(8096, actualFileBufferSize);
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getFileBufferSize()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getFileBufferSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int StaticAssetStorageServiceImpl.getFileBufferSize()"})
  public void testGetFileBufferSize_thenThrowRuntimeException() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetStorageServiceImpl.getFileBufferSize());
    verify(environment)
        .getProperty(eq("asset.server.file.buffer.size"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getAdminImageFileExtensions()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getAdminImageFileExtensions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticAssetStorageServiceImpl.getAdminImageFileExtensions()"})
  public void testGetAdminImageFileExtensions_thenReturnSizeIsOne() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenReturn("Property");

    // Act
    List<String> actualAdminImageFileExtensions =
        staticAssetStorageServiceImpl.getAdminImageFileExtensions();

    // Assert
    verify(environment)
        .getProperty(
            eq("admin.image.file.extensions"),
            isA(Class.class),
            eq("bmp,jpg,jpeg,png,img,tiff,gif"));
    assertEquals(1, actualAdminImageFileExtensions.size());
    assertEquals("Property", actualAdminImageFileExtensions.get(0));
  }

  /**
   * Test {@link StaticAssetStorageServiceImpl#getAdminImageFileExtensions()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetStorageServiceImpl#getAdminImageFileExtensions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticAssetStorageServiceImpl.getAdminImageFileExtensions()"})
  public void testGetAdminImageFileExtensions_thenThrowRuntimeException() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<String>>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> staticAssetStorageServiceImpl.getAdminImageFileExtensions());
    verify(environment)
        .getProperty(
            eq("admin.image.file.extensions"),
            isA(Class.class),
            eq("bmp,jpg,jpeg,png,img,tiff,gif"));
  }
}
