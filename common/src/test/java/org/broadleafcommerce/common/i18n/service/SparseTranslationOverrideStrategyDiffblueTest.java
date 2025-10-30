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
package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.cache.OverridePreCacheService;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.extension.ItemStatus;
import org.broadleafcommerce.common.extension.StandardCacheItem;
import org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SparseTranslationOverrideStrategyDiffblueTest {
  @InjectMocks
  private SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy;

  @Mock
  private OverridePreCacheService overridePreCacheService;

  @Mock
  private TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager;

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)}.
   * <ul>
   *   <li>Then return GeneralItem is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"})
  public void testGetLocaleBasedOverride_thenReturnGeneralItemIsNull() {
    // Arrange
    when(overridePreCacheService.findElements((String[]) Mockito.any())).thenReturn(new ArrayList<>());
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride = sparseTranslationOverrideStrategy.getLocaleBasedOverride("en",
        TranslatedEntity.CATALOG, "en", "en", "en", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService).isActiveForType(eq("org.broadleafcommerce.common.i18n.domain.Translation"));
    assertNull(actualLocaleBasedOverride.getGeneralItem());
    assertNull(actualLocaleBasedOverride.getSpecificItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)}.
   * <ul>
   *   <li>Then return GeneralItem is {@link StandardCacheItem} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"})
  public void testGetLocaleBasedOverride_thenReturnGeneralItemIsStandardCacheItem() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("en");

    ArrayList<StandardCacheItem> standardCacheItemList = new ArrayList<>();
    standardCacheItemList.add(standardCacheItem);
    when(overridePreCacheService.findElements((String[]) Mockito.any())).thenReturn(standardCacheItemList);
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride = sparseTranslationOverrideStrategy.getLocaleBasedOverride("en",
        TranslatedEntity.CATALOG, "en", "en", "en", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService).isActiveForType(eq("org.broadleafcommerce.common.i18n.domain.Translation"));
    assertNull(actualLocaleBasedOverride.getSpecificItem());
    assertSame(standardCacheItem, actualLocaleBasedOverride.getGeneralItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"})
  public void testGetLocaleBasedOverride_thenReturnNull() {
    // Arrange
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(false);

    // Act
    LocalePair actualLocaleBasedOverride = sparseTranslationOverrideStrategy.getLocaleBasedOverride("en",
        TranslatedEntity.CATALOG, "en", "en", "en", "en");

    // Assert
    verify(overridePreCacheService).isActiveForType(eq("org.broadleafcommerce.common.i18n.domain.Translation"));
    assertNull(actualLocaleBasedOverride);
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)}.
   * <ul>
   *   <li>When {@code _}.</li>
   *   <li>Then return GeneralItem is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"})
  public void testGetLocaleBasedOverride_whenUnderscore_thenReturnGeneralItemIsNull() {
    // Arrange
    when(overridePreCacheService.findElements((String[]) Mockito.any())).thenReturn(new ArrayList<>());
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride = sparseTranslationOverrideStrategy.getLocaleBasedOverride("en",
        TranslatedEntity.CATALOG, "en", "_", "en", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService).isActiveForType(eq("org.broadleafcommerce.common.i18n.domain.Translation"));
    assertNull(actualLocaleBasedOverride.getGeneralItem());
    assertNull(actualLocaleBasedOverride.getSpecificItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedTemplateValue(String, String, TranslatedEntity, String, String, String, String, String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedTemplateValue(String, String, TranslatedEntity, String, String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedTemplateValue(String, String, TranslatedEntity, String, String, String, String, String)"})
  public void testGetLocaleBasedTemplateValue_thenReturnNull() {
    // Arrange
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(false);

    // Act
    LocalePair actualLocaleBasedTemplateValue = sparseTranslationOverrideStrategy.getLocaleBasedTemplateValue("en",
        "en", TranslatedEntity.CATALOG, "en", "en", "en", "en", "en");

    // Assert
    verify(overridePreCacheService).isActiveForType(eq("org.broadleafcommerce.common.i18n.domain.Translation"));
    assertNull(actualLocaleBasedTemplateValue);
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SparseTranslationOverrideStrategy.isOverrideQualified(Class)"})
  public void testIsOverrideQualified_thenReturnTrue() {
    // Arrange
    Class<Translation> type = Translation.class;

    // Act and Assert
    assertTrue(sparseTranslationOverrideStrategy.isOverrideQualified(type));
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SparseTranslationOverrideStrategy.isOverrideQualified(Class)"})
  public void testIsOverrideQualified_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(sparseTranslationOverrideStrategy.isOverrideQualified(type));
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}.
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StandardCacheItem SparseTranslationOverrideStrategy.initializeOverride(Object)"})
  public void testInitializeOverride() {
    // Arrange
    when(templateOnlyQueryExtensionManager.buildStatus(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<ItemStatus>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);

    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityId("42");
    translationImpl.setEntityType(TranslatedEntity.CATALOG);
    translationImpl.setFieldName("Field Name");
    translationImpl.setId(1L);
    translationImpl.setLocaleCode("en");
    translationImpl.setTranslatedValue("42");

    // Act
    StandardCacheItem actualInitializeOverrideResult = sparseTranslationOverrideStrategy
        .initializeOverride(translationImpl);

    // Assert
    verify(templateOnlyQueryExtensionManager).buildStatus(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals("42", actualInitializeOverrideResult.getCacheItem());
    assertEquals("translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en",
        actualInitializeOverrideResult.getKey());
    assertEquals(ItemStatus.NORMAL, actualInitializeOverrideResult.getItemStatus());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}.
   * <ul>
   *   <li>Then return CacheItem is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StandardCacheItem SparseTranslationOverrideStrategy.initializeOverride(Object)"})
  public void testInitializeOverride_thenReturnCacheItemIs42() {
    // Arrange
    when(templateOnlyQueryExtensionManager.buildStatus(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<ItemStatus>>any())).thenReturn(ExtensionResultStatusType.HANDLED);

    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityId("42");
    translationImpl.setEntityType(TranslatedEntity.CATALOG);
    translationImpl.setFieldName("Field Name");
    translationImpl.setId(1L);
    translationImpl.setLocaleCode("en");
    translationImpl.setTranslatedValue("42");

    // Act
    StandardCacheItem actualInitializeOverrideResult = sparseTranslationOverrideStrategy
        .initializeOverride(translationImpl);

    // Assert
    verify(templateOnlyQueryExtensionManager).buildStatus(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals("42", actualInitializeOverrideResult.getCacheItem());
    assertEquals("translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en",
        actualInitializeOverrideResult.getKey());
    assertEquals(ItemStatus.NORMAL, actualInitializeOverrideResult.getItemStatus());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#validateTemplateProcessing(String, String)}.
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#validateTemplateProcessing(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SparseTranslationOverrideStrategy.validateTemplateProcessing(String, String)"})
  public void testValidateTemplateProcessing() {
    // Arrange, Act and Assert
    assertTrue(
        sparseTranslationOverrideStrategy.validateTemplateProcessing("Standard Cache Key", "Template Cache Key"));
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getOrder()}.
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int SparseTranslationOverrideStrategy.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(SparseTranslationOverrideStrategy.PRECACHED_SPARSE_OVERRIDE_ORDER,
        sparseTranslationOverrideStrategy.getOrder());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SparseTranslationOverrideStrategy#setRestrictAssociation(boolean)}
   *   <li>{@link SparseTranslationOverrideStrategy#setTemplateEnabled(boolean)}
   *   <li>{@link SparseTranslationOverrideStrategy#isRestrictAssociation()}
   *   <li>{@link SparseTranslationOverrideStrategy#isTemplateEnabled()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SparseTranslationOverrideStrategy.isRestrictAssociation()",
      "boolean SparseTranslationOverrideStrategy.isTemplateEnabled()",
      "void SparseTranslationOverrideStrategy.setRestrictAssociation(boolean)",
      "void SparseTranslationOverrideStrategy.setTemplateEnabled(boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy = new SparseTranslationOverrideStrategy();

    // Act
    sparseTranslationOverrideStrategy.setRestrictAssociation(true);
    sparseTranslationOverrideStrategy.setTemplateEnabled(true);
    boolean actualIsRestrictAssociationResult = sparseTranslationOverrideStrategy.isRestrictAssociation();

    // Assert
    assertTrue(actualIsRestrictAssociationResult);
    assertTrue(sparseTranslationOverrideStrategy.isTemplateEnabled());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getCacheKey(Translation)} with {@code translation}.
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#getCacheKey(Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SparseTranslationOverrideStrategy.getCacheKey(Translation)"})
  public void testGetCacheKeyWithTranslation() {
    // Arrange
    Translation translation = mock(Translation.class);
    when(translation.getEntityId()).thenReturn("42");
    when(translation.getFieldName()).thenReturn("Field Name");
    when(translation.getLocaleCode()).thenReturn("en");
    when(translation.getEntityType()).thenReturn(TranslatedEntity.CATALOG);

    // Act
    String actualCacheKey = sparseTranslationOverrideStrategy.getCacheKey(translation);

    // Assert
    verify(translation).getEntityId();
    verify(translation).getEntityType();
    verify(translation).getFieldName();
    verify(translation).getLocaleCode();
    assertEquals("translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en", actualCacheKey);
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getCacheKey(TranslatedEntity, String, String, String)} with {@code type}, {@code entityId}, {@code fieldName}, {@code localeCode}.
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#getCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SparseTranslationOverrideStrategy.getCacheKey(TranslatedEntity, String, String, String)"})
  public void testGetCacheKeyWithTypeEntityIdFieldNameLocaleCode() {
    // Arrange, Act and Assert
    assertEquals("translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en",
        sparseTranslationOverrideStrategy.getCacheKey(TranslatedEntity.CATALOG, "42", "Field Name", "en"));
  }
}
