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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.cms.field.type.StorageType;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class StaticAssetImplDiffblueTest {
  @Autowired private StaticAssetImpl staticAssetImpl;

  /**
   * Test {@link StaticAssetImpl#getTitle()}.
   *
   * <p>Method under test: {@link StaticAssetImpl#getTitle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetImpl.getTitle()"})
  public void testGetTitle() {
    // Arrange, Act and Assert
    assertNull(staticAssetImpl.getTitle());
  }

  /**
   * Test {@link StaticAssetImpl#getAltText()}.
   *
   * <p>Method under test: {@link StaticAssetImpl#getAltText()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetImpl.getAltText()"})
  public void testGetAltText() {
    // Arrange, Act and Assert
    assertNull(staticAssetImpl.getAltText());
  }

  /**
   * Test {@link StaticAssetImpl#setStorageType(StorageType)}.
   *
   * <ul>
   *   <li>Then {@link StaticAssetImpl} StorageType FriendlyType is {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetImpl#setStorageType(StorageType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticAssetImpl.setStorageType(StorageType)"})
  public void testSetStorageType_thenStaticAssetImplStorageTypeFriendlyTypeIsFriendlyType() {
    // Arrange
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
   *
   * <ul>
   *   <li>When {@link StorageType#DATABASE}.
   *   <li>Then {@link StaticAssetImpl} {@link StaticAssetImpl#storageType} is {@code DATABASE}.
   * </ul>
   *
   * <p>Method under test: {@link StaticAssetImpl#setStorageType(StorageType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticAssetImpl.setStorageType(StorageType)"})
  public void testSetStorageType_whenDatabase_thenStaticAssetImplStorageTypeIsDatabase() {
    // Arrange and Act
    staticAssetImpl.setStorageType(StorageType.DATABASE);

    // Assert
    assertEquals("DATABASE", staticAssetImpl.storageType);
    assertSame(StorageType.DATABASE, staticAssetImpl.getStorageType());
  }

  /**
   * Test {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StaticAssetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new ImageStaticAssetImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StaticAsset> actualCreateOrRetrieveCopyInstanceResult =
        staticAssetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StaticAssetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(staticAssetImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StaticAsset> actualCreateOrRetrieveCopyInstanceResult =
        staticAssetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then return not AlreadyPopulated.
   * </ul>
   *
   * <p>Method under test: {@link
   * StaticAssetImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse StaticAssetImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenReturnNotAlreadyPopulated()
      throws CloneNotSupportedException {
    // Arrange
    ImageStaticAssetImpl imageStaticAssetImpl = mock(ImageStaticAssetImpl.class);
    doNothing().when(imageStaticAssetImpl).setAltText(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl).setFileExtension(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl).setFileSize(Mockito.<Long>any());
    doNothing().when(imageStaticAssetImpl).setFullUrl(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl).setMimeType(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl).setName(Mockito.<String>any());
    doNothing().when(imageStaticAssetImpl).setStorageType(Mockito.<StorageType>any());
    doNothing().when(imageStaticAssetImpl).setTitle(Mockito.<String>any());
    CreateResponse<Object> createResponse = new CreateResponse<>(imageStaticAssetImpl, false);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<StaticAsset> actualCreateOrRetrieveCopyInstanceResult =
        staticAssetImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(imageStaticAssetImpl).setAltText(null);
    verify(imageStaticAssetImpl).setFileExtension(null);
    verify(imageStaticAssetImpl).setFileSize(isNull());
    verify(imageStaticAssetImpl).setFullUrl(null);
    verify(imageStaticAssetImpl).setMimeType(null);
    verify(imageStaticAssetImpl).setName(null);
    verify(imageStaticAssetImpl).setStorageType(isA(StorageType.class));
    verify(imageStaticAssetImpl).setTitle(null);
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link StaticAssetImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link StaticAssetImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StaticAssetImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(staticAssetImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticAssetImpl.<init>()",
    "Map StaticAssetImpl.getContentMessageValues()",
    "String StaticAssetImpl.getFileExtension()",
    "Long StaticAssetImpl.getFileSize()",
    "String StaticAssetImpl.getFullUrl()",
    "Long StaticAssetImpl.getId()",
    "String StaticAssetImpl.getMimeType()",
    "String StaticAssetImpl.getName()",
    "void StaticAssetImpl.setAltText(String)",
    "void StaticAssetImpl.setContentMessageValues(Map)",
    "void StaticAssetImpl.setFileExtension(String)",
    "void StaticAssetImpl.setFileSize(Long)",
    "void StaticAssetImpl.setFullUrl(String)",
    "void StaticAssetImpl.setId(Long)",
    "void StaticAssetImpl.setMimeType(String)",
    "void StaticAssetImpl.setName(String)",
    "void StaticAssetImpl.setTitle(String)"
  })
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
    actualStaticAssetImpl.setMimeType("text/plain");
    actualStaticAssetImpl.setName("Name");
    actualStaticAssetImpl.setTitle("Dr");
    Map<String, StaticAssetDescription> actualContentMessageValues =
        actualStaticAssetImpl.getContentMessageValues();
    String actualFileExtension = actualStaticAssetImpl.getFileExtension();
    Long actualFileSize = actualStaticAssetImpl.getFileSize();
    String actualFullUrl = actualStaticAssetImpl.getFullUrl();
    Long actualId = actualStaticAssetImpl.getId();
    String actualMimeType = actualStaticAssetImpl.getMimeType();

    // Assert
    assertEquals("File Extension", actualFileExtension);
    assertEquals("Name", actualStaticAssetImpl.getName());
    assertEquals("https://example.org/example", actualFullUrl);
    assertEquals("text/plain", actualMimeType);
    assertEquals(1L, actualId.longValue());
    assertEquals(3L, actualFileSize.longValue());
    assertTrue(actualContentMessageValues.isEmpty());
    assertSame(contentMessageValues, actualContentMessageValues);
  }
}
