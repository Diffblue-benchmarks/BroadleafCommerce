/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.file.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.cms.field.type.StorageType;
import org.broadleafcommerce.cms.file.domain.ImageStaticAssetImpl;
import org.broadleafcommerce.cms.file.domain.StaticAsset;
import org.broadleafcommerce.cms.file.domain.StaticAssetImpl;
import org.junit.Test;

public class StaticAssetServiceImplDiffblueTest {
  /**
   * Test {@link StaticAssetServiceImpl#getFileExtension(String)} with
   * {@code fileName}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getFileExtension(String)}
   */
  @Test
  public void testGetFileExtensionWithFileName_whenDot_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetServiceImpl()).getFileExtension("."));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getFileExtension(String)} with
   * {@code fileName}.
   * <ul>
   *   <li>When {@code File Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getFileExtension(String)}
   */
  @Test
  public void testGetFileExtensionWithFileName_whenFileName_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetServiceImpl()).getFileExtension("File Name"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getFileExtension(String)} with
   * {@code fileName}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getFileExtension(String)}
   */
  @Test
  public void testGetFileExtensionWithFileName_whenFooTxt_thenReturnTxt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("txt", (new StaticAssetServiceImpl()).getFileExtension("foo.txt"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#validateFileName(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#validateFileName(String)}
   */
  @Test
  public void testValidateFileName_whenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StaticAssetServiceImpl()).validateFileName(""));
  }

  /**
   * Test {@link StaticAssetServiceImpl#validateFileName(String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#validateFileName(String)}
   */
  @Test
  public void testValidateFileName_whenFooTxt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StaticAssetServiceImpl()).validateFileName("foo.txt"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code /} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_givenBiFunction_whenHashMapComputeIfPresentSlashAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.computeIfPresent("/", mock(BiFunction.class));

    // Act and Assert
    assertEquals("/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code fileName} is {@code /}.</li>
   *   <li>Then return {@code //}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_givenSlash_whenHashMapFileNameIsSlash_thenReturnSlashSlash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", null);
    assetProperties.put("entityId", null);
    assetProperties.put("fileName", "/");

    // Act and Assert
    assertEquals("//", staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>Then return {@code ///example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_thenReturnExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", null);
    assetProperties.put("entityId", null);
    assetProperties.put("fileName", "https://example.org/example");

    // Act and Assert
    assertEquals("///example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code entityId} is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_whenHashMapEntityIdIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", null);
    assetProperties.put("entityId", "https://example.org/example");
    assetProperties.put("fileName", null);

    // Act and Assert
    assertEquals("/https://example.org/example/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code entityType} is
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_whenHashMapEntityTypeIsHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", "https://example.org/example");
    assetProperties.put("entityId", null);
    assetProperties.put("fileName", null);

    // Act and Assert
    assertEquals("/https://example.org/example/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code fileName} is {@code null}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_whenHashMapFileNameIsNull_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", null);
    assetProperties.put("entityId", "null");
    assetProperties.put("fileName", null);

    // Act and Assert
    assertEquals("/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code fileName} is {@code null}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_whenHashMapFileNameIsNull_thenReturnHttpsExampleOrgExample2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    HashMap<String, String> assetProperties = new HashMap<>();
    assetProperties.put("entityType", "null");
    assetProperties.put("entityId", null);
    assetProperties.put("fileName", null);

    // Act and Assert
    assertEquals("/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(assetProperties, "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  public void testBuildAssetURL_whenHashMap_thenReturnHttpsExampleOrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    // Act and Assert
    assertEquals("/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(new HashMap<>(), "https://example.org/example"));
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}
   */
  @Test
  public void testCreateNonImageAsset_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    StaticAsset actualCreateNonImageAssetResult = staticAssetServiceImpl.createNonImageAsset(inputStream, "foo.txt",
        new HashMap<>());

    // Assert
    assertTrue(actualCreateNonImageAssetResult instanceof StaticAssetImpl);
    StorageType storageType = actualCreateNonImageAssetResult.getStorageType();
    assertEquals("DATABASE", storageType.getType());
    assertEquals("Database", storageType.getFriendlyType());
    assertNull(actualCreateNonImageAssetResult.getFileSize());
    assertNull(actualCreateNonImageAssetResult.getId());
    assertNull(actualCreateNonImageAssetResult.getAltText());
    assertNull(actualCreateNonImageAssetResult.getFileExtension());
    assertNull(actualCreateNonImageAssetResult.getFullUrl());
    assertNull(actualCreateNonImageAssetResult.getMimeType());
    assertNull(actualCreateNonImageAssetResult.getName());
    assertNull(actualCreateNonImageAssetResult.getTitle());
    assertNull(((StaticAssetImpl) actualCreateNonImageAssetResult).getMainEntityName());
    assertTrue(actualCreateNonImageAssetResult.getContentMessageValues().isEmpty());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}.
   * <ul>
   *   <li>When {@link DataInputStream}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}
   */
  @Test
  public void testCreateNonImageAsset_whenDataInputStream() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    DataInputStream inputStream = mock(DataInputStream.class);

    // Act
    StaticAsset actualCreateNonImageAssetResult = staticAssetServiceImpl.createNonImageAsset(inputStream, "foo.txt",
        new HashMap<>());

    // Assert
    assertTrue(actualCreateNonImageAssetResult instanceof StaticAssetImpl);
    StorageType storageType = actualCreateNonImageAssetResult.getStorageType();
    assertEquals("DATABASE", storageType.getType());
    assertEquals("Database", storageType.getFriendlyType());
    assertNull(actualCreateNonImageAssetResult.getFileSize());
    assertNull(actualCreateNonImageAssetResult.getId());
    assertNull(actualCreateNonImageAssetResult.getAltText());
    assertNull(actualCreateNonImageAssetResult.getFileExtension());
    assertNull(actualCreateNonImageAssetResult.getFullUrl());
    assertNull(actualCreateNonImageAssetResult.getMimeType());
    assertNull(actualCreateNonImageAssetResult.getName());
    assertNull(actualCreateNonImageAssetResult.getTitle());
    assertNull(((StaticAssetImpl) actualCreateNonImageAssetResult).getMainEntityName());
    assertTrue(actualCreateNonImageAssetResult.getContentMessageValues().isEmpty());
  }

  /**
   * Test {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code https://example-3.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}
   */
  @Test
  public void testGetCountUrl_whenFalse_thenReturnHttpsExample3OrgExample() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example-3.org/example",
        (new StaticAssetServiceImpl()).getCountUrl("https://example.org/example", 3, false));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}.
   * <ul>
   *   <li>When {@code Full Url}.</li>
   *   <li>Then return {@code Full Url-3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}
   */
  @Test
  public void testGetCountUrl_whenFullUrl_thenReturnFullUrl3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Full Url-3", (new StaticAssetServiceImpl()).getCountUrl("Full Url", 3, true));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example-3}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}
   */
  @Test
  public void testGetCountUrl_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("https://example.org/example-3",
        (new StaticAssetServiceImpl()).getCountUrl("https://example.org/example", 3, true));
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@link DataInputStream}.</li>
   *   <li>Then {@link ImageStaticAssetImpl} (default constructor) MimeType is
   * {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  public void testGetMimeType_whenDataInputStream_thenImageStaticAssetImplMimeTypeIsTextPlain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    DataInputStream inputStream = mock(DataInputStream.class);
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "foo.txt", newAsset);

    // Assert
    assertEquals("text/plain", newAsset.getMimeType());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code File Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  public void testGetMimeType_whenFileName() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "File Name", newAsset);

    // Assert
    assertEquals("application/octet-stream", newAsset.getMimeType());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then {@link ImageStaticAssetImpl} (default constructor) MimeType is
   * {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  public void testGetMimeType_whenFooTxt_thenImageStaticAssetImplMimeTypeIsTextPlain()
      throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "foo.txt", newAsset);

    // Assert
    assertEquals("text/plain", newAsset.getMimeType());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  public void testGetMimeType_whenNull() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, null, newAsset);

    // Assert
    assertEquals("application/octet-stream", newAsset.getMimeType());
  }

  /**
   * Test
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  public void testGetMimeType_whenSlash() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "/", newAsset);

    // Assert
    assertEquals("application/octet-stream", newAsset.getMimeType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StaticAssetServiceImpl#setAllowedFileExtensions(String)}
   *   <li>{@link StaticAssetServiceImpl#setDisabledFileExtensions(String)}
   *   <li>{@link StaticAssetServiceImpl#setShouldAcceptNonImageAsset(boolean)}
   *   <li>{@link StaticAssetServiceImpl#getAllowedFileExtensions()}
   *   <li>{@link StaticAssetServiceImpl#getDisabledFileExtensions()}
   *   <li>{@link StaticAssetServiceImpl#getShouldAcceptNonImageAsset()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    // Act
    staticAssetServiceImpl.setAllowedFileExtensions("Allowed File Extensions");
    staticAssetServiceImpl.setDisabledFileExtensions("Disabled File Extensions");
    staticAssetServiceImpl.setShouldAcceptNonImageAsset(true);
    String actualAllowedFileExtensions = staticAssetServiceImpl.getAllowedFileExtensions();
    String actualDisabledFileExtensions = staticAssetServiceImpl.getDisabledFileExtensions();

    // Assert that nothing has changed
    assertEquals("Allowed File Extensions", actualAllowedFileExtensions);
    assertEquals("Disabled File Extensions", actualDisabledFileExtensions);
    assertTrue(staticAssetServiceImpl.getShouldAcceptNonImageAsset());
  }
}
