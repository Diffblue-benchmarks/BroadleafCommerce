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
package org.broadleafcommerce.cms.file.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.cms.field.type.StorageType;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class StaticAssetImplDiffblueTest {
  @Autowired
  private StaticAssetImpl staticAssetImpl;

  /**
   * Test {@link StaticAssetImpl#getTitle()}.
   * <p>
   * Method under test: {@link StaticAssetImpl#getTitle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetImpl.getTitle()"})
  public void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new StaticAssetImpl()).getTitle());
  }

  /**
   * Test {@link StaticAssetImpl#getAltText()}.
   * <p>
   * Method under test: {@link StaticAssetImpl#getAltText()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetImpl.getAltText()"})
  public void testGetAltText() {
    // Arrange, Act and Assert
    assertNull((new StaticAssetImpl()).getAltText());
  }

  /**
   * Test {@link StaticAssetImpl#getStorageType()}.
   * <ul>
   *   <li>Given {@link StaticAssetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getStorageType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StorageType StaticAssetImpl.getStorageType()"})
  public void testGetStorageType_givenStaticAssetImpl() {
    // Arrange and Act
    StorageType actualStorageType = (new StaticAssetImpl()).getStorageType();

    // Assert
    assertSame(actualStorageType.DATABASE, actualStorageType);
  }

  /**
   * Test {@link StaticAssetImpl#getStorageType()}.
   * <ul>
   *   <li>Given {@link StaticAssetImpl} (default constructor) AltText is {@code Alt Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getStorageType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StorageType StaticAssetImpl.getStorageType()"})
  public void testGetStorageType_givenStaticAssetImplAltTextIsAltText() {
    // Arrange
    StaticAssetImpl staticAssetImpl2 = new StaticAssetImpl();
    staticAssetImpl2.setAltText("Alt Text");
    staticAssetImpl2.setContentMessageValues(new HashMap<>());
    staticAssetImpl2.setFileExtension("File Extension");
    staticAssetImpl2.setFileSize(3L);
    staticAssetImpl2.setFullUrl("https://example.org/example");
    staticAssetImpl2.setId(1L);
    staticAssetImpl2.setMimeType("Mime Type");
    staticAssetImpl2.setName("Name");
    staticAssetImpl2.setStorageType(StorageType.DATABASE);
    staticAssetImpl2.setTitle("Dr");

    // Act
    StorageType actualStorageType = staticAssetImpl2.getStorageType();

    // Assert
    assertSame(actualStorageType.DATABASE, actualStorageType);
  }

  /**
   * Test {@link StaticAssetImpl#setStorageType(StorageType)}.
   * <ul>
   *   <li>When {@link StorageType#DATABASE}.</li>
   *   <li>Then {@link StaticAssetImpl} (default constructor) {@link StaticAssetImpl#storageType} is {@code DATABASE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#setStorageType(StorageType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetImpl.setStorageType(StorageType)"})
  public void testSetStorageType_whenDatabase_thenStaticAssetImplStorageTypeIsDatabase() {
    // Arrange
    StaticAssetImpl staticAssetImpl2 = new StaticAssetImpl();

    // Act
    staticAssetImpl2.setStorageType(StorageType.DATABASE);

    // Assert
    assertEquals("DATABASE", staticAssetImpl2.storageType);
  }

  /**
   * Test {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse StaticAssetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    StaticAssetImpl staticAssetImpl2 = new StaticAssetImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StaticAsset> actualCreateOrRetrieveCopyInstanceResult = staticAssetImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link ImageStaticAssetImpl} (default constructor) AltText is {@code Alt Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse StaticAssetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_givenImageStaticAssetImplAltTextIsAltText()
      throws CloneNotSupportedException {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = new ImageStaticAssetImpl();
    imageStaticAssetImpl.setAltText("Alt Text");
    imageStaticAssetImpl.setContentMessageValues(new HashMap<>());
    imageStaticAssetImpl.setFileExtension("File Extension");
    imageStaticAssetImpl.setFileSize(3L);
    imageStaticAssetImpl.setFullUrl("https://example.org/example");
    imageStaticAssetImpl.setHeight(1);
    imageStaticAssetImpl.setId(1L);
    imageStaticAssetImpl.setMimeType("Mime Type");
    imageStaticAssetImpl.setName("Name");
    imageStaticAssetImpl.setStorageType(StorageType.DATABASE);
    imageStaticAssetImpl.setTitle("Dr");
    imageStaticAssetImpl.setWidth(1);
    ImageStaticAssetImpl imageStaticAssetImpl2 = mock(ImageStaticAssetImpl.class);
    doNothing().when(imageStaticAssetImpl2).setAltText(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl2).setFileExtension(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl2).setFileSize(Mockito.<Long>any());
    doNothing().when(imageStaticAssetImpl2).setFullUrl(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl2).setMimeType(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl2).setName(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl2).setStorageType(Mockito.<StorageType>any());
    doNothing().when(imageStaticAssetImpl2).setTitle(Mockito.<String>any());
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(imageStaticAssetImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    imageStaticAssetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(imageStaticAssetImpl2).setAltText(eq("Alt Text"));
    verify(imageStaticAssetImpl2).setFileExtension(eq("File Extension"));
    verify(imageStaticAssetImpl2).setFileSize(eq(3L));
    verify(imageStaticAssetImpl2).setFullUrl(eq("https://example.org/example"));
    verify(imageStaticAssetImpl2).setMimeType(eq("Mime Type"));
    verify(imageStaticAssetImpl2).setName(eq("Name"));
    verify(imageStaticAssetImpl2).setStorageType(isA(StorageType.class));
    verify(imageStaticAssetImpl2).setTitle(eq("Dr"));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link StaticAssetImpl#setAltText(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse StaticAssetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCallsSetAltText() throws CloneNotSupportedException {
    // Arrange
    StaticAssetImpl staticAssetImpl2 = new StaticAssetImpl();
    ImageStaticAssetImpl imageStaticAssetImpl = mock(ImageStaticAssetImpl.class);
    doNothing().when(imageStaticAssetImpl).setAltText(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl).setFileExtension(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl).setFileSize(Mockito.<Long>any());
    doNothing().when(imageStaticAssetImpl).setFullUrl(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl).setMimeType(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl).setName(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl).setStorageType(Mockito.<StorageType>any());
    doNothing().when(imageStaticAssetImpl).setTitle(Mockito.<String>any());
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(imageStaticAssetImpl);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    staticAssetImpl2.createOrRetrieveCopyInstance(context);

    // Assert
    verify(imageStaticAssetImpl).setAltText(isNull());
    verify(imageStaticAssetImpl).setFileExtension(isNull());
    verify(imageStaticAssetImpl).setFileSize(isNull());
    verify(imageStaticAssetImpl).setFullUrl(isNull());
    verify(imageStaticAssetImpl).setMimeType(isNull());
    verify(imageStaticAssetImpl).setName(isNull());
    verify(imageStaticAssetImpl).setStorageType(isA(StorageType.class));
    verify(imageStaticAssetImpl).setTitle(isNull());
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link StaticAssetImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse StaticAssetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnStaticAssetImpl() throws CloneNotSupportedException {
    // Arrange
    StaticAssetImpl staticAssetImpl2 = new StaticAssetImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StaticAsset> actualCreateOrRetrieveCopyInstanceResult = staticAssetImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.file.domain.StaticAssetImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StaticAsset clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StaticAssetImpl);
    assertEquals("DATABASE", ((StaticAssetImpl) clone).storageType);
    assertNull(clone.getFileSize());
    assertNull(clone.getId());
    assertNull(clone.getAltText());
    assertNull(clone.getFileExtension());
    assertNull(clone.getFullUrl());
    assertNull(clone.getMimeType());
    assertNull(clone.getName());
    assertNull(clone.getTitle());
    assertNull(((StaticAssetImpl) clone).getMainEntityName());
    assertNull(((StaticAssetImpl) clone).altText);
    assertNull(((StaticAssetImpl) clone).title);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertTrue(clone.getContentMessageValues().isEmpty());
  }

  /**
   * Test {@link StaticAssetImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link StaticAssetImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StaticAssetImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new StaticAssetImpl()).getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticAssetImpl}
   *   <li>{@link StaticAssetImpl#setAltText(String)}
   *   <li>{@link StaticAssetImpl#setContentMessageValues(Map)}
   *   <li>{@link StaticAssetImpl#setFileExtension(String)}
   *   <li>{@link StaticAssetImpl#setFileSize(Long)}
   *   <li>{@link StaticAssetImpl#setFullUrl(String)}
   *   <li>{@link StaticAssetImpl#setId(Long)}
   *   <li>{@link StaticAssetImpl#setMimeType(String)}
   *   <li>{@link StaticAssetImpl#setName(String)}
   *   <li>{@link StaticAssetImpl#setTitle(String)}
   *   <li>{@link StaticAssetImpl#getContentMessageValues()}
   *   <li>{@link StaticAssetImpl#getFileExtension()}
   *   <li>{@link StaticAssetImpl#getFileSize()}
   *   <li>{@link StaticAssetImpl#getFullUrl()}
   *   <li>{@link StaticAssetImpl#getId()}
   *   <li>{@link StaticAssetImpl#getMimeType()}
   *   <li>{@link StaticAssetImpl#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StaticAssetImpl.<init>()", "Map StaticAssetImpl.getContentMessageValues()",
      "String StaticAssetImpl.getFileExtension()", "Long StaticAssetImpl.getFileSize()",
      "String StaticAssetImpl.getFullUrl()", "Long StaticAssetImpl.getId()", "String StaticAssetImpl.getMimeType()",
      "String StaticAssetImpl.getName()", "void StaticAssetImpl.setAltText(String)",
      "void StaticAssetImpl.setContentMessageValues(Map)", "void StaticAssetImpl.setFileExtension(String)",
      "void StaticAssetImpl.setFileSize(Long)", "void StaticAssetImpl.setFullUrl(String)",
      "void StaticAssetImpl.setId(Long)", "void StaticAssetImpl.setMimeType(String)",
      "void StaticAssetImpl.setName(String)", "void StaticAssetImpl.setTitle(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticAssetImpl actualStaticAssetImpl = new StaticAssetImpl();
    actualStaticAssetImpl.setAltText("Alt Text");
    HashMap<String, StaticAssetDescription> contentMessageValues = new HashMap<>();
    actualStaticAssetImpl.setContentMessageValues(contentMessageValues);
    actualStaticAssetImpl.setFileExtension("File Extension");
    actualStaticAssetImpl.setFileSize(3L);
    actualStaticAssetImpl.setFullUrl("https://example.org/example");
    actualStaticAssetImpl.setId(1L);
    actualStaticAssetImpl.setMimeType("Mime Type");
    actualStaticAssetImpl.setName("Name");
    actualStaticAssetImpl.setTitle("Dr");
    Map<String, StaticAssetDescription> actualContentMessageValues = actualStaticAssetImpl.getContentMessageValues();
    String actualFileExtension = actualStaticAssetImpl.getFileExtension();
    Long actualFileSize = actualStaticAssetImpl.getFileSize();
    String actualFullUrl = actualStaticAssetImpl.getFullUrl();
    Long actualId = actualStaticAssetImpl.getId();
    String actualMimeType = actualStaticAssetImpl.getMimeType();

    // Assert
    assertEquals("File Extension", actualFileExtension);
    assertEquals("Mime Type", actualMimeType);
    assertEquals("Name", actualStaticAssetImpl.getName());
    assertEquals("https://example.org/example", actualFullUrl);
    assertEquals(1L, actualId.longValue());
    assertEquals(3L, actualFileSize.longValue());
    assertTrue(actualContentMessageValues.isEmpty());
    assertSame(contentMessageValues, actualContentMessageValues);
  }
}
