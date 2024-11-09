/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.extension.ItemStatus;
import org.broadleafcommerce.common.extension.StandardCacheItem;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.junit.Test;

public class SparseTranslationOverrideStrategyDiffblueTest {
  /**
   * Test {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}
   */
  @Test
  public void testIsOverrideQualified_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy = new SparseTranslationOverrideStrategy();
    Class<Translation> type = Translation.class;

    // Act and Assert
    assertTrue(sparseTranslationOverrideStrategy.isOverrideQualified(type));
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}
   */
  @Test
  public void testIsOverrideQualified_whenJavaLangObject_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy = new SparseTranslationOverrideStrategy();
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(sparseTranslationOverrideStrategy.isOverrideQualified(type));
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link TranslationImpl} (default constructor) EntityId is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}
   */
  @Test
  public void testInitializeOverride_givenOne_whenTranslationImplEntityIdIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy = new SparseTranslationOverrideStrategy();

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
    assertEquals("42", actualInitializeOverrideResult.getCacheItem());
    assertEquals("translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en",
        actualInitializeOverrideResult.getKey());
    assertEquals(ItemStatus.NORMAL, actualInitializeOverrideResult.getItemStatus());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}.
   * <ul>
   *   <li>Then calls {@link TranslationImpl#getEntityId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}
   */
  @Test
  public void testInitializeOverride_thenCallsGetEntityId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy = new SparseTranslationOverrideStrategy();
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    when(translationImpl.getTranslatedValue()).thenReturn("42");
    when(translationImpl.getEntityId()).thenReturn("42");
    when(translationImpl.getFieldName()).thenReturn("Field Name");
    when(translationImpl.getLocaleCode()).thenReturn("en");
    when(translationImpl.getEntityType()).thenReturn(TranslatedEntity.CATALOG);

    // Act
    StandardCacheItem actualInitializeOverrideResult = sparseTranslationOverrideStrategy
        .initializeOverride(translationImpl);

    // Assert
    verify(translationImpl).getEntityId();
    verify(translationImpl).getEntityType();
    verify(translationImpl).getFieldName();
    verify(translationImpl).getLocaleCode();
    verify(translationImpl).getTranslatedValue();
    assertEquals("42", actualInitializeOverrideResult.getCacheItem());
    assertEquals("translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en",
        actualInitializeOverrideResult.getKey());
    assertEquals(ItemStatus.NORMAL, actualInitializeOverrideResult.getItemStatus());
  }

  /**
   * Test
   * {@link SparseTranslationOverrideStrategy#validateTemplateProcessing(String, String)}.
   * <p>
   * Method under test:
   * {@link SparseTranslationOverrideStrategy#validateTemplateProcessing(String, String)}
   */
  @Test
  public void testValidateTemplateProcessing() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SparseTranslationOverrideStrategy()).validateTemplateProcessing("Standard Cache Key",
        "Template Cache Key"));
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getOrder()}.
   * <p>
   * Method under test: {@link SparseTranslationOverrideStrategy#getOrder()}
   */
  @Test
  public void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(SparseTranslationOverrideStrategy.PRECACHED_SPARSE_OVERRIDE_ORDER,
        (new SparseTranslationOverrideStrategy()).getOrder());
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
  public void testGettersAndSetters() {
    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy = new SparseTranslationOverrideStrategy();

    // Act
    sparseTranslationOverrideStrategy.setRestrictAssociation(true);
    sparseTranslationOverrideStrategy.setTemplateEnabled(true);
    boolean actualIsRestrictAssociationResult = sparseTranslationOverrideStrategy.isRestrictAssociation();

    // Assert that nothing has changed
    assertTrue(actualIsRestrictAssociationResult);
    assertTrue(sparseTranslationOverrideStrategy.isTemplateEnabled());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getCacheKey(Translation)} with
   * {@code translation}.
   * <p>
   * Method under test:
   * {@link SparseTranslationOverrideStrategy#getCacheKey(Translation)}
   */
  @Test
  public void testGetCacheKeyWithTranslation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy = new SparseTranslationOverrideStrategy();
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
   * Test
   * {@link SparseTranslationOverrideStrategy#getCacheKey(TranslatedEntity, String, String, String)}
   * with {@code type}, {@code entityId}, {@code fieldName}, {@code localeCode}.
   * <p>
   * Method under test:
   * {@link SparseTranslationOverrideStrategy#getCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testGetCacheKeyWithTypeEntityIdFieldNameLocaleCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en",
        (new SparseTranslationOverrideStrategy()).getCacheKey(TranslatedEntity.CATALOG, "42", "Field Name", "en"));
  }

  /**
   * Test
   * {@link SparseTranslationOverrideStrategy#getCacheKey(TranslatedEntity, String, String, String)}
   * with {@code type}, {@code entityId}, {@code fieldName}, {@code localeCode}.
   * <p>
   * Method under test:
   * {@link SparseTranslationOverrideStrategy#getCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testGetCacheKeyWithTypeEntityIdFieldNameLocaleCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy = new SparseTranslationOverrideStrategy();
    TranslatedEntity type = mock(TranslatedEntity.class);
    when(type.getType()).thenReturn("Type");

    // Act
    String actualCacheKey = sparseTranslationOverrideStrategy.getCacheKey(type, "42", "Field Name", "en");

    // Assert
    verify(type).getType();
    assertEquals("translation-Type-42-Field Name-en", actualCacheKey);
  }
}
