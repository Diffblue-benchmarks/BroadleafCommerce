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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.cms.file.dao.StaticAssetDao;
import org.broadleafcommerce.cms.file.domain.ImageStaticAssetImpl;
import org.broadleafcommerce.cms.file.domain.StaticAsset;
import org.broadleafcommerce.cms.file.domain.StaticAssetImpl;
import org.broadleafcommerce.common.file.service.StaticAssetPathService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StaticAssetServiceImplDiffblueTest {
  @Mock
  private StaticAssetDao staticAssetDao;

  @Mock
  private StaticAssetPathService staticAssetPathService;

  @InjectMocks
  private StaticAssetServiceImpl staticAssetServiceImpl;

  @Mock
  private StaticAssetStorageService staticAssetStorageService;

  /**
   * Test {@link StaticAssetServiceImpl#findStaticAssetById(Long)}.
   * <ul>
   *   <li>Then return {@link ImageStaticAssetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findStaticAssetById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.findStaticAssetById(Long)"})
  public void testFindStaticAssetById_thenReturnImageStaticAssetImpl() {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = new ImageStaticAssetImpl();
    when(staticAssetDao.readStaticAssetById(Mockito.<Long>any())).thenReturn(imageStaticAssetImpl);

    // Act
    StaticAsset actualFindStaticAssetByIdResult = staticAssetServiceImpl.findStaticAssetById(1L);

    // Assert
    verify(staticAssetDao).readStaticAssetById(eq(1L));
    assertSame(imageStaticAssetImpl, actualFindStaticAssetByIdResult);
  }

  /**
   * Test {@link StaticAssetServiceImpl#findStaticAssetById(Long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findStaticAssetById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.findStaticAssetById(Long)"})
  public void testFindStaticAssetById_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetDao.readStaticAssetById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetServiceImpl.findStaticAssetById(1L));
    verify(staticAssetDao).readStaticAssetById(eq(1L));
  }

  /**
   * Test {@link StaticAssetServiceImpl#readAllStaticAssets()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#readAllStaticAssets()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StaticAssetServiceImpl.readAllStaticAssets()"})
  public void testReadAllStaticAssets_thenReturnEmpty() {
    // Arrange
    when(staticAssetDao.readAllStaticAssets()).thenReturn(new ArrayList<>());

    // Act
    List<StaticAsset> actualReadAllStaticAssetsResult = staticAssetServiceImpl.readAllStaticAssets();

    // Assert
    verify(staticAssetDao).readAllStaticAssets();
    assertTrue(actualReadAllStaticAssetsResult.isEmpty());
  }

  /**
   * Test {@link StaticAssetServiceImpl#readAllStaticAssets()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#readAllStaticAssets()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List StaticAssetServiceImpl.readAllStaticAssets()"})
  public void testReadAllStaticAssets_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetDao.readAllStaticAssets()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetServiceImpl.readAllStaticAssets());
    verify(staticAssetDao).readAllStaticAssets();
  }

  /**
   * Test {@link StaticAssetServiceImpl#findTotalStaticAssetCount()}.
   * <ul>
   *   <li>Then return longValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findTotalStaticAssetCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long StaticAssetServiceImpl.findTotalStaticAssetCount()"})
  public void testFindTotalStaticAssetCount_thenReturnLongValueIsThree() {
    // Arrange
    when(staticAssetDao.readTotalStaticAssetCount()).thenReturn(3L);

    // Act
    Long actualFindTotalStaticAssetCountResult = staticAssetServiceImpl.findTotalStaticAssetCount();

    // Assert
    verify(staticAssetDao).readTotalStaticAssetCount();
    assertEquals(3L, actualFindTotalStaticAssetCountResult.longValue());
  }

  /**
   * Test {@link StaticAssetServiceImpl#findTotalStaticAssetCount()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findTotalStaticAssetCount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long StaticAssetServiceImpl.findTotalStaticAssetCount()"})
  public void testFindTotalStaticAssetCount_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetDao.readTotalStaticAssetCount()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetServiceImpl.findTotalStaticAssetCount());
    verify(staticAssetDao).readTotalStaticAssetCount();
  }

  /**
   * Test {@link StaticAssetServiceImpl#getFileExtension(String)} with {@code fileName}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getFileExtension(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getFileExtension(String)"})
  public void testGetFileExtensionWithFileName_whenDot_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(staticAssetServiceImpl.getFileExtension("."));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getFileExtension(String)} with {@code fileName}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getFileExtension(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getFileExtension(String)"})
  public void testGetFileExtensionWithFileName_whenFooTxt_thenReturnTxt() {
    // Arrange, Act and Assert
    assertEquals("txt", staticAssetServiceImpl.getFileExtension("foo.txt"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.buildAssetURL(Map, String)"})
  public void testBuildAssetURL_givenSlash_whenHashMapFileNameIsSlash_thenReturnSlashSlash() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.buildAssetURL(Map, String)"})
  public void testBuildAssetURL_thenReturnExampleOrgExample() {
    // Arrange
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
   *   <li>When {@link HashMap#HashMap()} {@code entityId} is {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.buildAssetURL(Map, String)"})
  public void testBuildAssetURL_whenHashMapEntityIdIsHttpsExampleOrgExample() {
    // Arrange
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
   *   <li>When {@link HashMap#HashMap()} {@code entityType} is {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#buildAssetURL(Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.buildAssetURL(Map, String)"})
  public void testBuildAssetURL_whenHashMapEntityTypeIsHttpsExampleOrgExample() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.buildAssetURL(Map, String)"})
  public void testBuildAssetURL_whenHashMapFileNameIsNull_thenReturnHttpsExampleOrgExample() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.buildAssetURL(Map, String)"})
  public void testBuildAssetURL_whenHashMapFileNameIsNull_thenReturnHttpsExampleOrgExample2() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.buildAssetURL(Map, String)"})
  public void testBuildAssetURL_whenHashMap_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("/https://example.org/example",
        staticAssetServiceImpl.buildAssetURL(new HashMap<>(), "https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#createNonImageAsset(InputStream, String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.createNonImageAsset(InputStream, String, Map)"})
  public void testCreateNonImageAsset() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    StaticAsset actualCreateNonImageAssetResult = staticAssetServiceImpl.createNonImageAsset(inputStream, "foo.txt",
        new HashMap<>());

    // Assert
    assertTrue(actualCreateNonImageAssetResult instanceof StaticAssetImpl);
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
   * Method under test: {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getCountUrl(String, int, boolean)"})
  public void testGetCountUrl_whenFalse_thenReturnHttpsExample3OrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example-3.org/example",
        staticAssetServiceImpl.getCountUrl("https://example.org/example", 3, false));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}.
   * <ul>
   *   <li>When {@code Full Url}.</li>
   *   <li>Then return {@code Full Url-3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getCountUrl(String, int, boolean)"})
  public void testGetCountUrl_whenFullUrl_thenReturnFullUrl3() {
    // Arrange, Act and Assert
    assertEquals("Full Url-3", staticAssetServiceImpl.getCountUrl("Full Url", 3, true));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example-3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getCountUrl(String, int, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getCountUrl(String, int, boolean)"})
  public void testGetCountUrl_whenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample3() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example-3",
        staticAssetServiceImpl.getCountUrl("https://example.org/example", 3, true));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code File Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetServiceImpl.getMimeType(InputStream, String, StaticAsset)"})
  public void testGetMimeType_whenFileName() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "File Name", newAsset);

    // Assert
    assertEquals("application/octet-stream", newAsset.getMimeType());
  }

  /**
   * Test {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then {@link ImageStaticAssetImpl} (default constructor) MimeType is {@code text/plain}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetServiceImpl.getMimeType(InputStream, String, StaticAsset)"})
  public void testGetMimeType_whenFooTxt_thenImageStaticAssetImplMimeTypeIsTextPlain()
      throws UnsupportedEncodingException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "foo.txt", newAsset);

    // Assert
    assertEquals("text/plain", newAsset.getMimeType());
  }

  /**
   * Test {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetServiceImpl.getMimeType(InputStream, String, StaticAsset)"})
  public void testGetMimeType_whenNull() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, null, newAsset);

    // Assert
    assertEquals("application/octet-stream", newAsset.getMimeType());
  }

  /**
   * Test {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getMimeType(InputStream, String, StaticAsset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetServiceImpl.getMimeType(InputStream, String, StaticAsset)"})
  public void testGetMimeType_whenSlash() throws UnsupportedEncodingException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ImageStaticAssetImpl newAsset = new ImageStaticAssetImpl();

    // Act
    staticAssetServiceImpl.getMimeType(inputStream, "/", newAsset);

    // Assert
    assertEquals("application/octet-stream", newAsset.getMimeType());
  }

  /**
   * Test {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.findStaticAssetByFullUrl(String)"})
  public void testFindStaticAssetByFullUrl_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetDao.readStaticAssetByFullUrl(Mockito.<String>any()))
        .thenThrow(new RuntimeException(";jsessionidUU=UU"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> staticAssetServiceImpl.findStaticAssetByFullUrl("https://example.org/example"));
    verify(staticAssetDao).readStaticAssetByFullUrl(eq("https://example.org/example"));
  }

  /**
   * Test {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.findStaticAssetByFullUrl(String)"})
  public void testFindStaticAssetByFullUrl_whenHttpsExampleOrgExample() {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = new ImageStaticAssetImpl();
    when(staticAssetDao.readStaticAssetByFullUrl(Mockito.<String>any())).thenReturn(imageStaticAssetImpl);

    // Act
    StaticAsset actualFindStaticAssetByFullUrlResult = staticAssetServiceImpl
        .findStaticAssetByFullUrl("https://example.org/example");

    // Assert
    verify(staticAssetDao).readStaticAssetByFullUrl(eq("https://example.org/example"));
    assertSame(imageStaticAssetImpl, actualFindStaticAssetByFullUrlResult);
  }

  /**
   * Test {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example(?i);jsessionid.*?=.*?(?=\?|$)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.findStaticAssetByFullUrl(String)"})
  public void testFindStaticAssetByFullUrl_whenHttpsExampleOrgExampleIJsessionid() {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = new ImageStaticAssetImpl();
    when(staticAssetDao.readStaticAssetByFullUrl(Mockito.<String>any())).thenReturn(imageStaticAssetImpl);

    // Act
    StaticAsset actualFindStaticAssetByFullUrlResult = staticAssetServiceImpl
        .findStaticAssetByFullUrl("https://example.org/example(?i);jsessionid.*?=.*?(?=\\?|$)");

    // Assert
    verify(staticAssetDao).readStaticAssetByFullUrl(eq("https://example.org/example(?i)?(?=\\?|$)"));
    assertSame(imageStaticAssetImpl, actualFindStaticAssetByFullUrlResult);
  }

  /**
   * Test {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example;jsessionidUU=UU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.findStaticAssetByFullUrl(String)"})
  public void testFindStaticAssetByFullUrl_whenHttpsExampleOrgExampleJsessionidUUUu() {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = new ImageStaticAssetImpl();
    when(staticAssetDao.readStaticAssetByFullUrl(Mockito.<String>any())).thenReturn(imageStaticAssetImpl);

    // Act
    StaticAsset actualFindStaticAssetByFullUrlResult = staticAssetServiceImpl
        .findStaticAssetByFullUrl("https://example.org/example;jsessionidUU=UU");

    // Assert
    verify(staticAssetDao).readStaticAssetByFullUrl(eq("https://example.org/example"));
    assertSame(imageStaticAssetImpl, actualFindStaticAssetByFullUrlResult);
  }

  /**
   * Test {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}.
   * <ul>
   *   <li>When {@code (?i);jsessionid.*?=.*?(?=\?|$)}.</li>
   *   <li>Then return {@link ImageStaticAssetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.findStaticAssetByFullUrl(String)"})
  public void testFindStaticAssetByFullUrl_whenIJsessionid_thenReturnImageStaticAssetImpl() {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = new ImageStaticAssetImpl();
    when(staticAssetDao.readStaticAssetByFullUrl(Mockito.<String>any())).thenReturn(imageStaticAssetImpl);

    // Act
    StaticAsset actualFindStaticAssetByFullUrlResult = staticAssetServiceImpl
        .findStaticAssetByFullUrl("(?i);jsessionid.*?=.*?(?=\\?|$)");

    // Assert
    verify(staticAssetDao).readStaticAssetByFullUrl(eq("(?i)?(?=\\?|$)"));
    assertSame(imageStaticAssetImpl, actualFindStaticAssetByFullUrlResult);
  }

  /**
   * Test {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}.
   * <ul>
   *   <li>When {@code ;jsessionidUU=UU}.</li>
   *   <li>Then return {@link ImageStaticAssetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#findStaticAssetByFullUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.findStaticAssetByFullUrl(String)"})
  public void testFindStaticAssetByFullUrl_whenJsessionidUUUu_thenReturnImageStaticAssetImpl() {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = new ImageStaticAssetImpl();
    when(staticAssetDao.readStaticAssetByFullUrl(Mockito.<String>any())).thenReturn(imageStaticAssetImpl);

    // Act
    StaticAsset actualFindStaticAssetByFullUrlResult = staticAssetServiceImpl
        .findStaticAssetByFullUrl(";jsessionidUU=UU");

    // Assert
    verify(staticAssetDao).readStaticAssetByFullUrl(eq(""));
    assertSame(imageStaticAssetImpl, actualFindStaticAssetByFullUrlResult);
  }

  /**
   * Test {@link StaticAssetServiceImpl#addStaticAsset(StaticAsset)}.
   * <ul>
   *   <li>Then return {@link ImageStaticAssetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#addStaticAsset(StaticAsset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.addStaticAsset(StaticAsset)"})
  public void testAddStaticAsset_thenReturnImageStaticAssetImpl() {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = new ImageStaticAssetImpl();
    when(staticAssetDao.addOrUpdateStaticAsset(Mockito.<StaticAsset>any(), anyBoolean()))
        .thenReturn(imageStaticAssetImpl);

    // Act
    StaticAsset actualAddStaticAssetResult = staticAssetServiceImpl.addStaticAsset(new ImageStaticAssetImpl());

    // Assert
    verify(staticAssetDao).addOrUpdateStaticAsset(isA(StaticAsset.class), eq(true));
    assertSame(imageStaticAssetImpl, actualAddStaticAssetResult);
  }

  /**
   * Test {@link StaticAssetServiceImpl#addStaticAsset(StaticAsset)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#addStaticAsset(StaticAsset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.addStaticAsset(StaticAsset)"})
  public void testAddStaticAsset_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetDao.addOrUpdateStaticAsset(Mockito.<StaticAsset>any(), anyBoolean()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetServiceImpl.addStaticAsset(new ImageStaticAssetImpl()));
    verify(staticAssetDao).addOrUpdateStaticAsset(isA(StaticAsset.class), eq(true));
  }

  /**
   * Test {@link StaticAssetServiceImpl#updateStaticAsset(StaticAsset)}.
   * <ul>
   *   <li>Then return {@link ImageStaticAssetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#updateStaticAsset(StaticAsset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.updateStaticAsset(StaticAsset)"})
  public void testUpdateStaticAsset_thenReturnImageStaticAssetImpl() {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = new ImageStaticAssetImpl();
    when(staticAssetDao.addOrUpdateStaticAsset(Mockito.<StaticAsset>any(), anyBoolean()))
        .thenReturn(imageStaticAssetImpl);

    // Act
    StaticAsset actualUpdateStaticAssetResult = staticAssetServiceImpl.updateStaticAsset(new ImageStaticAssetImpl());

    // Assert
    verify(staticAssetDao).addOrUpdateStaticAsset(isA(StaticAsset.class), eq(true));
    assertSame(imageStaticAssetImpl, actualUpdateStaticAssetResult);
  }

  /**
   * Test {@link StaticAssetServiceImpl#updateStaticAsset(StaticAsset)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#updateStaticAsset(StaticAsset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StaticAsset StaticAssetServiceImpl.updateStaticAsset(StaticAsset)"})
  public void testUpdateStaticAsset_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetDao.addOrUpdateStaticAsset(Mockito.<StaticAsset>any(), anyBoolean()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetServiceImpl.updateStaticAsset(new ImageStaticAssetImpl()));
    verify(staticAssetDao).addOrUpdateStaticAsset(isA(StaticAsset.class), eq(true));
  }

  /**
   * Test {@link StaticAssetServiceImpl#deleteStaticAsset(StaticAsset)}.
   * <ul>
   *   <li>Given {@link StaticAssetDao} {@link StaticAssetDao#delete(StaticAsset)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#deleteStaticAsset(StaticAsset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetServiceImpl.deleteStaticAsset(StaticAsset)"})
  public void testDeleteStaticAsset_givenStaticAssetDaoDeleteDoesNothing() {
    // Arrange
    doNothing().when(staticAssetDao).delete(Mockito.<StaticAsset>any());

    // Act
    staticAssetServiceImpl.deleteStaticAsset(new ImageStaticAssetImpl());

    // Assert
    verify(staticAssetDao).delete(isA(StaticAsset.class));
  }

  /**
   * Test {@link StaticAssetServiceImpl#deleteStaticAsset(StaticAsset)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#deleteStaticAsset(StaticAsset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetServiceImpl.deleteStaticAsset(StaticAsset)"})
  public void testDeleteStaticAsset_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException("foo")).when(staticAssetDao).delete(Mockito.<StaticAsset>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetServiceImpl.deleteStaticAsset(new ImageStaticAssetImpl()));
    verify(staticAssetDao).delete(isA(StaticAsset.class));
  }

  /**
   * Test {@link StaticAssetServiceImpl#getStaticAssetUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getStaticAssetUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getStaticAssetUrlPrefix()"})
  public void testGetStaticAssetUrlPrefix_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");

    // Act
    String actualStaticAssetUrlPrefix = staticAssetServiceImpl.getStaticAssetUrlPrefix();

    // Assert
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    assertEquals("https://example.org/example", actualStaticAssetUrlPrefix);
  }

  /**
   * Test {@link StaticAssetServiceImpl#getStaticAssetUrlPrefix()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getStaticAssetUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getStaticAssetUrlPrefix()"})
  public void testGetStaticAssetUrlPrefix_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetServiceImpl.getStaticAssetUrlPrefix());
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
  }

  /**
   * Test {@link StaticAssetServiceImpl#getPrefixedStaticAssetUrl(String)}.
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getPrefixedStaticAssetUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getPrefixedStaticAssetUrl(String)"})
  public void testGetPrefixedStaticAssetUrl() {
    // Arrange
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("https://example.org/example");

    // Act
    String actualPrefixedStaticAssetUrl = staticAssetServiceImpl
        .getPrefixedStaticAssetUrl("https://example.org/example");

    // Assert
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    assertEquals("/https://example.org/examplehttps://example.org/example", actualPrefixedStaticAssetUrl);
  }

  /**
   * Test {@link StaticAssetServiceImpl#getPrefixedStaticAssetUrl(String)}.
   * <ul>
   *   <li>Then return {@code /https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getPrefixedStaticAssetUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getPrefixedStaticAssetUrl(String)"})
  public void testGetPrefixedStaticAssetUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn("/");

    // Act
    String actualPrefixedStaticAssetUrl = staticAssetServiceImpl
        .getPrefixedStaticAssetUrl("https://example.org/example");

    // Assert
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    assertEquals("/https://example.org/example", actualPrefixedStaticAssetUrl);
  }

  /**
   * Test {@link StaticAssetServiceImpl#getPrefixedStaticAssetUrl(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getPrefixedStaticAssetUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getPrefixedStaticAssetUrl(String)"})
  public void testGetPrefixedStaticAssetUrl_thenReturnHttpsExampleOrgExample2() {
    // Arrange
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenReturn(null);

    // Act
    String actualPrefixedStaticAssetUrl = staticAssetServiceImpl
        .getPrefixedStaticAssetUrl("https://example.org/example");

    // Assert
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
    assertEquals("https://example.org/example", actualPrefixedStaticAssetUrl);
  }

  /**
   * Test {@link StaticAssetServiceImpl#getPrefixedStaticAssetUrl(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getPrefixedStaticAssetUrl(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getPrefixedStaticAssetUrl(String)"})
  public void testGetPrefixedStaticAssetUrl_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetPathService.getStaticAssetUrlPrefix()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> staticAssetServiceImpl.getPrefixedStaticAssetUrl("https://example.org/example"));
    verify(staticAssetPathService).getStaticAssetUrlPrefix();
  }

  /**
   * Test {@link StaticAssetServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(staticAssetPathService.getStaticAssetEnvironmentUrlPrefix()).thenReturn("https://example.org/example");

    // Act
    String actualStaticAssetEnvironmentUrlPrefix = staticAssetServiceImpl.getStaticAssetEnvironmentUrlPrefix();

    // Assert
    verify(staticAssetPathService).getStaticAssetEnvironmentUrlPrefix();
    assertEquals("https://example.org/example", actualStaticAssetEnvironmentUrlPrefix);
  }

  /**
   * Test {@link StaticAssetServiceImpl#getStaticAssetEnvironmentUrlPrefix()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getStaticAssetEnvironmentUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getStaticAssetEnvironmentUrlPrefix()"})
  public void testGetStaticAssetEnvironmentUrlPrefix_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetPathService.getStaticAssetEnvironmentUrlPrefix()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetServiceImpl.getStaticAssetEnvironmentUrlPrefix());
    verify(staticAssetPathService).getStaticAssetEnvironmentUrlPrefix();
  }

  /**
   * Test {@link StaticAssetServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"})
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_thenReturnHttpsExampleOrgExample() {
    // Arrange
    when(staticAssetPathService.getStaticAssetEnvironmentSecureUrlPrefix()).thenReturn("https://example.org/example");

    // Act
    String actualStaticAssetEnvironmentSecureUrlPrefix = staticAssetServiceImpl
        .getStaticAssetEnvironmentSecureUrlPrefix();

    // Assert
    verify(staticAssetPathService).getStaticAssetEnvironmentSecureUrlPrefix();
    assertEquals("https://example.org/example", actualStaticAssetEnvironmentSecureUrlPrefix);
  }

  /**
   * Test {@link StaticAssetServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#getStaticAssetEnvironmentSecureUrlPrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix()"})
  public void testGetStaticAssetEnvironmentSecureUrlPrefix_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetPathService.getStaticAssetEnvironmentSecureUrlPrefix()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> staticAssetServiceImpl.getStaticAssetEnvironmentSecureUrlPrefix());
    verify(staticAssetPathService).getStaticAssetEnvironmentSecureUrlPrefix();
  }

  /**
   * Test {@link StaticAssetServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then return {@code Convert Asset Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenReturnConvertAssetPath() {
    // Arrange
    when(staticAssetPathService.convertAssetPath(Mockito.<String>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn("Convert Asset Path");

    // Act
    String actualConvertAssetPathResult = staticAssetServiceImpl.convertAssetPath("Asset Path", "Context Path", true);

    // Assert
    verify(staticAssetPathService).convertAssetPath(eq("Asset Path"), eq("Context Path"), eq(true));
    assertEquals("Convert Asset Path", actualConvertAssetPathResult);
  }

  /**
   * Test {@link StaticAssetServiceImpl#convertAssetPath(String, String, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetServiceImpl#convertAssetPath(String, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.convertAssetPath(String, String, boolean)"})
  public void testConvertAssetPath_thenThrowRuntimeException() {
    // Arrange
    when(staticAssetPathService.convertAssetPath(Mockito.<String>any(), Mockito.<String>any(), anyBoolean()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> staticAssetServiceImpl.convertAssetPath("Asset Path", "Context Path", true));
    verify(staticAssetPathService).convertAssetPath(eq("Asset Path"), eq("Context Path"), eq(true));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetServiceImpl.getAllowedFileExtensions()",
      "String StaticAssetServiceImpl.getDisabledFileExtensions()",
      "boolean StaticAssetServiceImpl.getShouldAcceptNonImageAsset()",
      "void StaticAssetServiceImpl.setAllowedFileExtensions(String)",
      "void StaticAssetServiceImpl.setDisabledFileExtensions(String)",
      "void StaticAssetServiceImpl.setShouldAcceptNonImageAsset(boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    StaticAssetServiceImpl staticAssetServiceImpl = new StaticAssetServiceImpl();

    // Act
    staticAssetServiceImpl.setAllowedFileExtensions("Allowed File Extensions");
    staticAssetServiceImpl.setDisabledFileExtensions("Disabled File Extensions");
    staticAssetServiceImpl.setShouldAcceptNonImageAsset(true);
    String actualAllowedFileExtensions = staticAssetServiceImpl.getAllowedFileExtensions();
    String actualDisabledFileExtensions = staticAssetServiceImpl.getDisabledFileExtensions();

    // Assert
    assertEquals("Allowed File Extensions", actualAllowedFileExtensions);
    assertEquals("Disabled File Extensions", actualDisabledFileExtensions);
    assertTrue(staticAssetServiceImpl.getShouldAcceptNonImageAsset());
  }
}
