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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.junit.Test;

public class TranslationBatchReadCacheDiffblueTest {
  /**
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(Translation)}
   */
  @Test
  public void testBuildCacheKey() {
    // Arrange
    TranslationImpl translation = new TranslationImpl();
    translation.setEntityType(TranslatedEntity.CATALOG);

    // Act and Assert
    assertEquals("org.broadleafcommerce.common.site.domain.Catalog---",
        TranslationBatchReadCache.buildCacheKey(translation));
  }

  /**
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(Translation)}
   */
  @Test
  public void testBuildCacheKey2() {
    // Arrange
    TranslationImpl translation = new TranslationImpl();
    translation.setEntityId("");
    translation.setEntityType(TranslatedEntity.CATALOG);

    // Act and Assert
    assertEquals("org.broadleafcommerce.common.site.domain.Catalog---",
        TranslationBatchReadCache.buildCacheKey(translation));
  }

  /**
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testBuildCacheKey3() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.common.site.domain.Catalog-42-Property Name-en",
        TranslationBatchReadCache.buildCacheKey(TranslatedEntity.CATALOG, "42", "Property Name", "en"));
  }

  /**
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testBuildCacheKey4() {
    // Arrange, Act and Assert
    assertEquals("--42-Property Name-en",
        TranslationBatchReadCache.buildCacheKey(new TranslatedEntity("-", "-"), "42", "Property Name", "en"));
  }

  /**
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testBuildCacheKey5() {
    // Arrange, Act and Assert
    assertEquals("-42-Property Name-en",
        TranslationBatchReadCache.buildCacheKey(new TranslatedEntity(), "42", "Property Name", "en"));
  }

  /**
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testBuildCacheKey6() {
    // Arrange
    TranslatedEntity entityType = mock(TranslatedEntity.class);
    when(entityType.getType()).thenReturn("Type");

    // Act
    String actualBuildCacheKeyResult = TranslationBatchReadCache.buildCacheKey(entityType, "42", "Property Name", "en");

    // Assert
    verify(entityType).getType();
    assertEquals("Type-42-Property Name-en", actualBuildCacheKeyResult);
  }

  /**
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testBuildCacheKey7() {
    // Arrange
    TranslatedEntity entityType = mock(TranslatedEntity.class);
    when(entityType.getType()).thenReturn("");

    // Act
    String actualBuildCacheKeyResult = TranslationBatchReadCache.buildCacheKey(entityType, "42", "Property Name", "en");

    // Assert
    verify(entityType).getType();
    assertEquals("-42-Property Name-en", actualBuildCacheKeyResult);
  }
}
