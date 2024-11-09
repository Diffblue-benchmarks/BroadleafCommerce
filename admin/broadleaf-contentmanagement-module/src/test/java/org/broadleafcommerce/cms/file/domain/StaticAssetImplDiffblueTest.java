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
import org.mockito.Mockito;

public class StaticAssetImplDiffblueTest {
  /**
   * Test {@link StaticAssetImpl#getTitle()}.
   * <ul>
   *   <li>Given {@link StaticAssetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getTitle()}
   */
  @Test
  public void testGetTitle_givenStaticAssetImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetImpl()).getTitle());
  }

  /**
   * Test {@link StaticAssetImpl#getTitle()}.
   * <ul>
   *   <li>Given {@link StorageType} {@link StorageType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link StorageType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getTitle()}
   */
  @Test
  public void testGetTitle_givenStorageTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StorageType storageType = mock(StorageType.class);
    when(storageType.getType()).thenReturn("Type");

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setStorageType(storageType);

    // Act
    String actualTitle = staticAssetImpl.getTitle();

    // Assert
    verify(storageType).getType();
    assertNull(actualTitle);
  }

  /**
   * Test {@link StaticAssetImpl#getAltText()}.
   * <ul>
   *   <li>Given {@link StaticAssetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getAltText()}
   */
  @Test
  public void testGetAltText_givenStaticAssetImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetImpl()).getAltText());
  }

  /**
   * Test {@link StaticAssetImpl#getAltText()}.
   * <ul>
   *   <li>Given {@link StorageType} {@link StorageType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link StorageType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getAltText()}
   */
  @Test
  public void testGetAltText_givenStorageTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StorageType storageType = mock(StorageType.class);
    when(storageType.getType()).thenReturn("Type");

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setStorageType(storageType);

    // Act
    String actualAltText = staticAssetImpl.getAltText();

    // Assert
    verify(storageType).getType();
    assertNull(actualAltText);
  }

  /**
   * Test {@link StaticAssetImpl#getStorageType()}.
   * <ul>
   *   <li>Given {@link StaticAssetImpl} (default constructor) StorageType is
   * {@link StorageType#DATABASE}.</li>
   *   <li>Then return {@link StorageType#DATABASE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getStorageType()}
   */
  @Test
  public void testGetStorageType_givenStaticAssetImplStorageTypeIsDatabase_thenReturnDatabase() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setAltText("Alt Text");
    staticAssetImpl.setContentMessageValues(new HashMap<>());
    staticAssetImpl.setFileExtension("File Extension");
    staticAssetImpl.setFileSize(3L);
    staticAssetImpl.setFullUrl("https://example.org/example");
    staticAssetImpl.setId(1L);
    staticAssetImpl.setMimeType("Mime Type");
    staticAssetImpl.setName("Name");
    staticAssetImpl.setStorageType(StorageType.DATABASE);
    staticAssetImpl.setTitle("Dr");

    // Act
    StorageType actualStorageType = staticAssetImpl.getStorageType();

    // Assert
    assertSame(actualStorageType.DATABASE, actualStorageType);
  }

  /**
   * Test {@link StaticAssetImpl#getStorageType()}.
   * <ul>
   *   <li>Given {@link StaticAssetImpl} (default constructor).</li>
   *   <li>Then return {@link StorageType#DATABASE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getStorageType()}
   */
  @Test
  public void testGetStorageType_givenStaticAssetImpl_thenReturnDatabase() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    StorageType actualStorageType = (new StaticAssetImpl()).getStorageType();

    // Assert
    assertSame(actualStorageType.DATABASE, actualStorageType);
  }

  /**
   * Test {@link StaticAssetImpl#getStorageType()}.
   * <ul>
   *   <li>Given {@link StorageType} {@link StorageType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getStorageType()}
   */
  @Test
  public void testGetStorageType_givenStorageTypeGetTypeReturnType_thenReturnFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StorageType storageType = mock(StorageType.class);
    when(storageType.getType()).thenReturn("Type");

    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    staticAssetImpl.setAltText("Alt Text");
    staticAssetImpl.setContentMessageValues(new HashMap<>());
    staticAssetImpl.setFileExtension("File Extension");
    staticAssetImpl.setFileSize(3L);
    staticAssetImpl.setFullUrl("https://example.org/example");
    staticAssetImpl.setId(1L);
    staticAssetImpl.setMimeType("Mime Type");
    staticAssetImpl.setName("Name");
    staticAssetImpl.setStorageType(storageType);
    staticAssetImpl.setTitle("Dr");

    // Act
    StorageType actualStorageType = staticAssetImpl.getStorageType();

    // Assert
    verify(storageType).getType();
    assertEquals("Friendly Type", actualStorageType.getFriendlyType());
    assertEquals("Type", actualStorageType.getType());
  }

  /**
   * Test {@link StaticAssetImpl#setStorageType(StorageType)}.
   * <ul>
   *   <li>Then {@link StaticAssetImpl} (default constructor) StorageType
   * FriendlyType is {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#setStorageType(StorageType)}
   */
  @Test
  public void testSetStorageType_thenStaticAssetImplStorageTypeFriendlyTypeIsFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    StorageType storageType = mock(StorageType.class);
    when(storageType.getType()).thenReturn("Type");

    // Act
    staticAssetImpl.setStorageType(storageType);

    // Assert
    verify(storageType).getType();
    StorageType storageType2 = staticAssetImpl.getStorageType();
    assertEquals("Friendly Type", storageType2.getFriendlyType());
    assertEquals("Type", storageType2.getType());
    assertEquals("Type", staticAssetImpl.storageType);
  }

  /**
   * Test {@link StaticAssetImpl#setStorageType(StorageType)}.
   * <ul>
   *   <li>When {@link StorageType#DATABASE}.</li>
   *   <li>Then {@link StaticAssetImpl} (default constructor)
   * {@link StaticAssetImpl#storageType} is {@code DATABASE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#setStorageType(StorageType)}
   */
  @Test
  public void testSetStorageType_whenDatabase_thenStaticAssetImplStorageTypeIsDatabase() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();

    // Act
    staticAssetImpl.setStorageType(StorageType.DATABASE);

    // Assert
    assertEquals("DATABASE", staticAssetImpl.storageType);
  }

  /**
   * Test
   * {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StaticAsset> actualCreateOrRetrieveCopyInstanceResult = staticAssetImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link ImageStaticAssetImpl} (default constructor) AltText is
   * {@code Alt Text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenImageStaticAssetImplAltTextIsAltText()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link StaticAssetImpl#setAltText(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsSetAltText() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
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
    staticAssetImpl.createOrRetrieveCopyInstance(context);

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
   * Test
   * {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link StaticAssetImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnStaticAssetImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StaticAssetImpl staticAssetImpl = new StaticAssetImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<StaticAsset> actualCreateOrRetrieveCopyInstanceResult = staticAssetImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.cms.file.domain.StaticAssetImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    StaticAsset clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof StaticAssetImpl);
    StorageType storageType = clone.getStorageType();
    assertEquals("DATABASE", storageType.getType());
    assertEquals("DATABASE", ((StaticAssetImpl) clone).storageType);
    assertEquals("Database", storageType.getFriendlyType());
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
   * <ul>
   *   <li>Given {@link StaticAssetImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenStaticAssetImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StaticAssetImpl()).getMainEntityName());
  }

  /**
   * Test {@link StaticAssetImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link StorageType} {@link StorageType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StaticAssetImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenStorageTypeGetTypeReturnType_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StorageType storageType = mock(StorageType.class);
    when(storageType.getType()).thenReturn("Type");

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
    imageStaticAssetImpl.setStorageType(storageType);
    imageStaticAssetImpl.setTitle("Dr");
    imageStaticAssetImpl.setWidth(1);

    // Act
    String actualMainEntityName = imageStaticAssetImpl.getMainEntityName();

    // Assert
    verify(storageType).getType();
    assertEquals("Name", actualMainEntityName);
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

    // Assert that nothing has changed
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
