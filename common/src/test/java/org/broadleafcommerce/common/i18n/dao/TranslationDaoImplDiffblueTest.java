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
package org.broadleafcommerce.common.i18n.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelper;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TranslationDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @Mock private SandBoxHelper sandBoxHelper;

  @InjectMocks private TranslationDaoImpl translationDaoImpl;

  /**
   * Test {@link TranslationDaoImpl#create()}.
   *
   * <ul>
   *   <li>Given {@link TranslationImpl} (default constructor) EntityId is {@code 42}.
   *   <li>Then return {@link TranslationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationDaoImpl.create()"})
  public void testCreate_givenTranslationImplEntityIdIs42_thenReturnTranslationImpl() {
    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityId("42");
    translationImpl.setEntityType(TranslatedEntity.CATALOG);
    translationImpl.setFieldName("Field Name");
    translationImpl.setId(1L);
    translationImpl.setLocaleCode("en");
    translationImpl.setTranslatedValue("42");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(translationImpl);

    // Act
    Translation actualCreateResult = translationDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.common.i18n.domain.Translation");
    assertSame(translationImpl, actualCreateResult);
  }

  /**
   * Test {@link TranslationDaoImpl#create()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationDaoImpl.create()"})
  public void testCreate_thenThrowIllegalStateException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationDaoImpl.create());
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.common.i18n.domain.Translation");
  }

  /**
   * Test {@link TranslationDaoImpl#getIdPropertyMetadata(TranslatedEntity)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getIdPropertyMetadata(TranslatedEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map TranslationDaoImpl.getIdPropertyMetadata(TranslatedEntity)"})
  public void testGetIdPropertyMetadata_thenThrowIllegalStateException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.getIdPropertyMetadata(TranslatedEntity.CATALOG));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
  }

  /**
   * Test {@link TranslationDaoImpl#getEntityImpl(TranslatedEntity)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link TranslatedEntity#CATALOG}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getEntityImpl(TranslatedEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class TranslationDaoImpl.getEntityImpl(TranslatedEntity)"})
  public void testGetEntityImpl_givenJavaLangObject_whenCatalog_thenReturnObject() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    // Act
    Class<?> actualEntityImpl = translationDaoImpl.getEntityImpl(TranslatedEntity.CATALOG);

    // Assert
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    Class<Object> expectedEntityImpl = Object.class;
    assertEquals(expectedEntityImpl, actualEntityImpl);
  }

  /**
   * Test {@link TranslationDaoImpl#getEntityImpl(TranslatedEntity)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getEntityImpl(TranslatedEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class TranslationDaoImpl.getEntityImpl(TranslatedEntity)"})
  public void testGetEntityImpl_thenThrowIllegalStateException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.getEntityImpl(TranslatedEntity.CATALOG));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
  }

  /**
   * Test {@link TranslationDaoImpl#readTranslations(TranslatedEntity, String, String)}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#readTranslations(TranslatedEntity, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TranslationDaoImpl.readTranslations(TranslatedEntity, String, String)"})
  public void testReadTranslations() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.readTranslations(TranslatedEntity.CATALOG, "42", "Field Name"));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
  }

  /**
   * Test {@link TranslationDaoImpl#readTranslations(TranslatedEntity, String, String)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#getOriginalId(Class, Long)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#readTranslations(TranslatedEntity, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TranslationDaoImpl.readTranslations(TranslatedEntity, String, String)"})
  public void testReadTranslations_givenSandBoxHelperGetOriginalIdThrowIllegalStateException() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.readTranslations(TranslatedEntity.CATALOG, "42", "Field Name"));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
  }

  /**
   * Test {@link TranslationDaoImpl#readTranslations(TranslatedEntity, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SandBoxHelper#getProductionOriginalId(Class, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#readTranslations(TranslatedEntity, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TranslationDaoImpl.readTranslations(TranslatedEntity, String, String)"})
  public void testReadTranslations_thenCallsGetProductionOriginalId() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.readTranslations(TranslatedEntity.CATALOG, "42", "Field Name"));
    verify(entityConfiguration, atLeast(1))
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), eq(1L));
  }

  /**
   * Test {@link TranslationDaoImpl#readTranslation(TranslatedEntity, String, String, String)} with
   * {@code entity}, {@code entityId}, {@code fieldName}, {@code localeCode}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#readTranslation(TranslatedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationDaoImpl.readTranslation(TranslatedEntity, String, String, String)"
  })
  public void testReadTranslationWithEntityEntityIdFieldNameLocaleCode() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationDaoImpl.readTranslation(TranslatedEntity.CATALOG, "42", "Field Name", "en"));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
  }

  /**
   * Test {@link TranslationDaoImpl#readTranslation(TranslatedEntity, String, String, String)} with
   * {@code entity}, {@code entityId}, {@code fieldName}, {@code localeCode}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#readTranslation(TranslatedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationDaoImpl.readTranslation(TranslatedEntity, String, String, String)"
  })
  public void testReadTranslationWithEntityEntityIdFieldNameLocaleCode2() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationDaoImpl.readTranslation(TranslatedEntity.CATALOG, "42", "Field Name", "en"));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
  }

  /**
   * Test {@link TranslationDaoImpl#readTranslation(TranslatedEntity, String, String, String)} with
   * {@code entity}, {@code entityId}, {@code fieldName}, {@code localeCode}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#readTranslation(TranslatedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationDaoImpl.readTranslation(TranslatedEntity, String, String, String)"
  })
  public void testReadTranslationWithEntityEntityIdFieldNameLocaleCode3() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationDaoImpl.readTranslation(TranslatedEntity.CATALOG, "42", "Field Name", "en"));
    verify(entityConfiguration, atLeast(1))
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), eq(1L));
  }

  /**
   * Test {@link TranslationDaoImpl#getEntityId(TranslatedEntity, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getEntityId(TranslatedEntity, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getEntityId(TranslatedEntity, Object)"})
  public void testGetEntityId_thenThrowIllegalStateException() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.getEntityId(TranslatedEntity.CATALOG, BLCFieldUtils.NULL_FIELD));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)} with {@code
   * entityType}, {@code entityId}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, String)"})
  public void testGetUpdatedEntityIdWithEntityTypeEntityId() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, "42"));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)} with {@code
   * entityType}, {@code entityId}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, String)"})
  public void testGetUpdatedEntityIdWithEntityTypeEntityId2() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, "42"));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)} with {@code
   * entityType}, {@code entityId}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, String)"})
  public void testGetUpdatedEntityIdWithEntityTypeEntityId3() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, "42"));
    verify(entityConfiguration, atLeast(1))
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), eq(1L));
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)} with {@code
   * entityType}, {@code entityId}.
   *
   * <ul>
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, String)"})
  public void testGetUpdatedEntityIdWithEntityTypeEntityId_thenReturn1() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);

    OriginalIdResponse originalIdResponse2 = new OriginalIdResponse();
    originalIdResponse2.setOriginalId(1L);
    originalIdResponse2.setRecordFound(true);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse2);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    String actualUpdatedEntityId =
        translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, "42");

    // Assert
    verify(entityConfiguration, atLeast(1))
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), eq(1L));
    assertEquals("1", actualUpdatedEntityId);
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)} with {@code
   * entityType}, {@code entityId}.
   *
   * <ul>
   *   <li>Then return {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, String)"})
  public void testGetUpdatedEntityIdWithEntityTypeEntityId_thenReturn2() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);

    OriginalIdResponse originalIdResponse2 = new OriginalIdResponse();
    originalIdResponse2.setOriginalId(2L);
    originalIdResponse2.setRecordFound(true);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse2);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    String actualUpdatedEntityId =
        translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, "42");

    // Assert
    verify(entityConfiguration, atLeast(1))
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), eq(1L));
    assertEquals("2", actualUpdatedEntityId);
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)} with {@code
   * entityType}, {@code entityId}.
   *
   * <ul>
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, String)"})
  public void testGetUpdatedEntityIdWithEntityTypeEntityId_thenReturn12() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);

    OriginalIdResponse originalIdResponse2 = new OriginalIdResponse();
    originalIdResponse2.setOriginalId(1L);
    originalIdResponse2.setRecordFound(false);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse2);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    String actualUpdatedEntityId =
        translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, "42");

    // Assert
    verify(entityConfiguration, atLeast(1))
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), eq(1L));
    assertEquals("1", actualUpdatedEntityId);
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)} with {@code
   * entityType}, {@code entityId}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, String)"})
  public void testGetUpdatedEntityIdWithEntityTypeEntityId_thenReturn42() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(null);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    String actualUpdatedEntityId =
        translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, "42");

    // Assert
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
    assertEquals("42", actualUpdatedEntityId);
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)} with {@code
   * entityType}, {@code entityId}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, String)"})
  public void testGetUpdatedEntityIdWithEntityTypeEntityId_thenReturn422() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(false);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    String actualUpdatedEntityId =
        translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, "42");

    // Assert
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(42L));
    assertEquals("42", actualUpdatedEntityId);
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)} with {@code
   * entityType}, {@code idValue}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, Long)"})
  public void testGetUpdatedEntityIdWithEntityTypeIdValue() {
    // Arrange
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, 1L));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)} with {@code
   * entityType}, {@code idValue}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, Long)"})
  public void testGetUpdatedEntityIdWithEntityTypeIdValue2() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, 1L));
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(1L));
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)} with {@code
   * entityType}, {@code idValue}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, Long)"})
  public void testGetUpdatedEntityIdWithEntityTypeIdValue3() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, 1L));
    verify(entityConfiguration, atLeast(1))
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(1L));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), eq(1L));
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)} with {@code
   * entityType}, {@code idValue}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, Long)"})
  public void testGetUpdatedEntityIdWithEntityTypeIdValue4() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);

    OriginalIdResponse originalIdResponse2 = new OriginalIdResponse();
    originalIdResponse2.setOriginalId(1L);
    originalIdResponse2.setRecordFound(false);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse2);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    String actualUpdatedEntityId =
        translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, 1L);

    // Assert
    verify(entityConfiguration, atLeast(1))
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(1L));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), eq(1L));
    assertEquals("1", actualUpdatedEntityId);
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)} with {@code
   * entityType}, {@code idValue}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, Long)"})
  public void testGetUpdatedEntityIdWithEntityTypeIdValue5() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(null);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    String actualUpdatedEntityId =
        translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, 1L);

    // Assert
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(1L));
    assertEquals("1", actualUpdatedEntityId);
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)} with {@code
   * entityType}, {@code idValue}.
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, Long)"})
  public void testGetUpdatedEntityIdWithEntityTypeIdValue6() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(false);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    String actualUpdatedEntityId =
        translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, 1L);

    // Assert
    verify(entityConfiguration)
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(1L));
    assertEquals("1", actualUpdatedEntityId);
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)} with {@code
   * entityType}, {@code idValue}.
   *
   * <ul>
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, Long)"})
  public void testGetUpdatedEntityIdWithEntityTypeIdValue_thenReturn1() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);

    OriginalIdResponse originalIdResponse2 = new OriginalIdResponse();
    originalIdResponse2.setOriginalId(1L);
    originalIdResponse2.setRecordFound(true);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse2);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    String actualUpdatedEntityId =
        translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, 1L);

    // Assert
    verify(entityConfiguration, atLeast(1))
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(1L));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), eq(1L));
    assertEquals("1", actualUpdatedEntityId);
  }

  /**
   * Test {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)} with {@code
   * entityType}, {@code idValue}.
   *
   * <ul>
   *   <li>Then return {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#getUpdatedEntityId(TranslatedEntity, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationDaoImpl.getUpdatedEntityId(TranslatedEntity, Long)"})
  public void testGetUpdatedEntityIdWithEntityTypeIdValue_thenReturn2() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(entityConfiguration.lookupEntityClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);

    OriginalIdResponse originalIdResponse2 = new OriginalIdResponse();
    originalIdResponse2.setOriginalId(2L);
    originalIdResponse2.setRecordFound(true);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse2);
    when(sandBoxHelper.getOriginalId(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    String actualUpdatedEntityId =
        translationDaoImpl.getUpdatedEntityId(TranslatedEntity.CATALOG, 1L);

    // Assert
    verify(entityConfiguration, atLeast(1))
        .lookupEntityClass("org.broadleafcommerce.common.site.domain.Catalog");
    verify(sandBoxHelper).getOriginalId(isA(Class.class), eq(1L));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), eq(1L));
    assertEquals("2", actualUpdatedEntityId);
  }

  /**
   * Test {@link TranslationDaoImpl#findBestTranslation(String, List)}.
   *
   * <ul>
   *   <li>Then calls {@link TranslationImpl#getLocaleCode()}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#findBestTranslation(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationDaoImpl.findBestTranslation(String, List)"})
  public void testFindBestTranslation_thenCallsGetLocaleCode() {
    // Arrange
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    when(translationImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(translationImpl);

    // Act
    translationDaoImpl.findBestTranslation("en", translations);

    // Assert
    verify(translationImpl).getLocaleCode();
  }

  /**
   * Test {@link TranslationDaoImpl#findBestTranslation(String, List)}.
   *
   * <ul>
   *   <li>When {@code Specific Locale}.
   *   <li>Then calls {@link TranslationImpl#getLocaleCode()}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#findBestTranslation(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationDaoImpl.findBestTranslation(String, List)"})
  public void testFindBestTranslation_whenSpecificLocale_thenCallsGetLocaleCode() {
    // Arrange
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    when(translationImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(translationImpl);

    // Act
    translationDaoImpl.findBestTranslation("Specific Locale", translations);

    // Assert
    verify(translationImpl).getLocaleCode();
  }

  /**
   * Test {@link TranslationDaoImpl#findSpecificTranslation(String, List)}.
   *
   * <ul>
   *   <li>Then calls {@link TranslationImpl#getLocaleCode()}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#findSpecificTranslation(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationDaoImpl.findSpecificTranslation(String, List)"})
  public void testFindSpecificTranslation_thenCallsGetLocaleCode() {
    // Arrange
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    when(translationImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(translationImpl);

    // Act
    translationDaoImpl.findSpecificTranslation("en", translations);

    // Assert
    verify(translationImpl).getLocaleCode();
  }

  /**
   * Test {@link TranslationDaoImpl#findSpecificTranslation(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#findSpecificTranslation(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationDaoImpl.findSpecificTranslation(String, List)"})
  public void testFindSpecificTranslation_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(translationDaoImpl.findSpecificTranslation("en", new ArrayList<>()));
  }

  /**
   * Test {@link TranslationDaoImpl#findSpecificTranslation(String, List)}.
   *
   * <ul>
   *   <li>When {@code GB}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationDaoImpl#findSpecificTranslation(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationDaoImpl.findSpecificTranslation(String, List)"})
  public void testFindSpecificTranslation_whenGb_thenReturnNull() {
    // Arrange
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    when(translationImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(translationImpl);

    // Act
    Translation actualFindSpecificTranslationResult =
        translationDaoImpl.findSpecificTranslation("GB", translations);

    // Assert
    verify(translationImpl).getLocaleCode();
    assertNull(actualFindSpecificTranslationResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TranslationDaoImpl#setDynamicDaoHelper(DynamicDaoHelper)}
   *   <li>{@link TranslationDaoImpl#getDynamicDaoHelper()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicDaoHelper TranslationDaoImpl.getDynamicDaoHelper()",
    "void TranslationDaoImpl.setDynamicDaoHelper(DynamicDaoHelper)"
  })
  public void testGettersAndSetters() {
    // Arrange
    TranslationDaoImpl translationDaoImpl = new TranslationDaoImpl();
    DynamicDaoHelperImpl dynamicDaoHelper = new DynamicDaoHelperImpl();

    // Act
    translationDaoImpl.setDynamicDaoHelper(dynamicDaoHelper);
    DynamicDaoHelper actualDynamicDaoHelper = translationDaoImpl.getDynamicDaoHelper();

    // Assert
    assertTrue(actualDynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertSame(dynamicDaoHelper, actualDynamicDaoHelper);
  }
}
