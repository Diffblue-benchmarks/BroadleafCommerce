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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.cms.field.type.StorageType;
import org.broadleafcommerce.cms.file.domain.ImageStaticAssetImpl;
import org.broadleafcommerce.cms.file.domain.StaticAsset;
import org.broadleafcommerce.cms.file.domain.StaticAssetImpl;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

public class StaticAssetStorageServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#shouldUseSharedFile(InputStream)}
   */
  @Test
  public void testShouldUseSharedFile() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl = new StaticAssetStorageServiceImpl();

    // Act and Assert
    assertFalse(
        staticAssetStorageServiceImpl.shouldUseSharedFile(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#shouldUseSharedFile(InputStream)}
   */
  @Test
  public void testShouldUseSharedFile2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StaticAssetStorageServiceImpl()).shouldUseSharedFile(null));
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#shouldUseSharedFile(InputStream)}
   */
  @Test
  public void testShouldUseSharedFile3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StaticAssetStorageServiceImpl()).shouldUseSharedFile(mock(DataInputStream.class)));
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#lookupAssetAndCreateLocalFile(StaticAsset, File)}
   */
  @Test
  public void testLookupAssetAndCreateLocalFile() throws IOException, SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl = new StaticAssetStorageServiceImpl();
    StaticAsset staticAsset = mock(StaticAsset.class);
    when(staticAsset.getFullUrl()).thenThrow(new RuntimeException("foo"));
    when(staticAsset.getStorageType()).thenReturn(StorageType.FILESYSTEM);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetStorageServiceImpl.lookupAssetAndCreateLocalFile(staticAsset,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    verify(staticAsset).getFullUrl();
    verify(staticAsset).getStorageType();
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#shouldRecompress(String)}
   */
  @Test
  public void testShouldRecompress() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StaticAssetStorageServiceImpl()).shouldRecompress("Mime Type"));
    assertTrue((new StaticAssetStorageServiceImpl()).shouldRecompress("png"));
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#buildModel(String, String)}
   */
  @Test
  public void testBuildModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, String> actualBuildModelResult = (new StaticAssetStorageServiceImpl()).buildModel("/directory/foo.txt",
        "Mime Type");

    // Assert
    assertEquals(2, actualBuildModelResult.size());
    assertEquals("/directory/foo.txt", actualBuildModelResult.get("cacheFilePath"));
    assertEquals("Mime Type", actualBuildModelResult.get("mimeType"));
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset, Map)}
   */
  @Test
  public void testConstructCacheFileName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl = new StaticAssetStorageServiceImpl();

    StaticAssetImpl staticAsset = new StaticAssetImpl();
    staticAsset.setAltText("Alt Text");
    staticAsset.setContentMessageValues(new HashMap<>());
    staticAsset.setFileExtension("File Extension");
    staticAsset.setFileSize(3L);
    staticAsset.setFullUrl("https://example.org/example");
    staticAsset.setId(1L);
    staticAsset.setMimeType("Mime Type");
    staticAsset.setName("Name");
    staticAsset.setStorageType(StorageType.DATABASE);
    staticAsset.setTitle("Dr");

    // Act and Assert
    assertEquals("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example",
        staticAssetStorageServiceImpl.constructCacheFileName(staticAsset, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset, Map)}
   */
  @Test
  public void testConstructCacheFileName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl = new StaticAssetStorageServiceImpl();
    ImageStaticAssetImpl staticAsset = mock(ImageStaticAssetImpl.class);
    when(staticAsset.getFullUrl()).thenReturn("https://example.org/example");

    // Act
    String actualConstructCacheFileNameResult = staticAssetStorageServiceImpl.constructCacheFileName(staticAsset,
        new HashMap<>());

    // Assert
    verify(staticAsset).getFullUrl();
    assertEquals("https://example---d41d8cd98f00b204e9800998ecf8427e.org/example", actualConstructCacheFileNameResult);
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset, Map)}
   */
  @Test
  public void testConstructCacheFileName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl = new StaticAssetStorageServiceImpl();
    ImageStaticAssetImpl staticAsset = mock(ImageStaticAssetImpl.class);
    when(staticAsset.getFullUrl()).thenReturn("https://example.org/example");

    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("---", "---");

    // Act
    String actualConstructCacheFileNameResult = staticAssetStorageServiceImpl.constructCacheFileName(staticAsset,
        parameterMap);

    // Assert
    verify(staticAsset).getFullUrl();
    assertEquals("https://example---9dc5f758e8e773980f07a95bfc8642f1.org/example", actualConstructCacheFileNameResult);
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#constructCacheFileName(StaticAsset, Map)}
   */
  @Test
  public void testConstructCacheFileName4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl = new StaticAssetStorageServiceImpl();
    ImageStaticAssetImpl staticAsset = mock(ImageStaticAssetImpl.class);
    when(staticAsset.getFullUrl()).thenReturn("https://example.org/example");

    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("", "");
    parameterMap.putAll(new HashMap<>());
    parameterMap.put("---", "---");

    // Act
    String actualConstructCacheFileNameResult = staticAssetStorageServiceImpl.constructCacheFileName(staticAsset,
        parameterMap);

    // Assert
    verify(staticAsset).getFullUrl();
    assertEquals("https://example---01a6651a94ab602dbfc47587d234b52c.org/example", actualConstructCacheFileNameResult);
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#pad(String, int, char)}
   */
  @Test
  public void testPad() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("foo", (new StaticAssetStorageServiceImpl()).pad("foo", 3, 'A'));
    assertEquals("AA)", (new StaticAssetStorageServiceImpl()).pad(")", 3, 'A'));
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile, StaticAsset)}
   */
  @Test
  public void testCreateStaticAssetStorageFromFile() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl = new StaticAssetStorageServiceImpl();
    MultipartFile file = mock(MultipartFile.class);
    when(file.getInputStream()).thenReturn(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    StaticAsset staticAsset = mock(StaticAsset.class);
    when(staticAsset.getStorageType()).thenReturn(new StorageType("Type", "Friendly Type"));

    // Act
    staticAssetStorageServiceImpl.createStaticAssetStorageFromFile(file, staticAsset);

    // Assert that nothing has changed
    verify(staticAsset, atLeast(1)).getStorageType();
    verify(file).getInputStream();
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#createStaticAssetStorageFromFile(MultipartFile, StaticAsset)}
   */
  @Test
  public void testCreateStaticAssetStorageFromFile2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl = new StaticAssetStorageServiceImpl();
    MultipartFile file = mock(MultipartFile.class);
    when(file.getInputStream()).thenReturn(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    StaticAsset staticAsset = mock(StaticAsset.class);
    when(staticAsset.getStorageType()).thenReturn(null);

    // Act
    staticAssetStorageServiceImpl.createStaticAssetStorageFromFile(file, staticAsset);

    // Assert that nothing has changed
    verify(staticAsset, atLeast(1)).getStorageType();
    verify(file).getInputStream();
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}
   */
  @Test
  public void testCreateStaticAssetStorage() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl = new StaticAssetStorageServiceImpl();
    ByteArrayInputStream fileInputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    StaticAsset staticAsset = mock(StaticAsset.class);
    when(staticAsset.getStorageType()).thenReturn(new StorageType("Type", "Friendly Type"));

    // Act
    staticAssetStorageServiceImpl.createStaticAssetStorage(fileInputStream, staticAsset);

    // Assert that nothing has changed
    verify(staticAsset, atLeast(1)).getStorageType();
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#createStaticAssetStorage(InputStream, StaticAsset)}
   */
  @Test
  public void testCreateStaticAssetStorage2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetStorageServiceImpl staticAssetStorageServiceImpl = new StaticAssetStorageServiceImpl();
    ByteArrayInputStream fileInputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    StaticAsset staticAsset = mock(StaticAsset.class);
    when(staticAsset.getStorageType()).thenReturn(null);

    // Act
    staticAssetStorageServiceImpl.createStaticAssetStorage(fileInputStream, staticAsset);

    // Assert that nothing has changed
    verify(staticAsset, atLeast(1)).getStorageType();
  }

  /**
   * Method under test:
   * {@link StaticAssetStorageServiceImpl#getFileExtension(String)}
   */
  @Test
  public void testGetFileExtension() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Asset Path", (new StaticAssetStorageServiceImpl()).getFileExtension("Asset Path"));
  }
}
