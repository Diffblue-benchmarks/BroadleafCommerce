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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TranslationBatchReadCacheDiffblueTest {
  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)} with {@code entityType}, {@code id}, {@code propertyName}, {@code localeCode}.
   * <p>
   * Method under test: {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationBatchReadCache.buildCacheKey(TranslatedEntity, String, String, String)"})
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.common.site.domain.Catalog-42-Property Name-en",
        TranslationBatchReadCache.buildCacheKey(TranslatedEntity.CATALOG, "42", "Property Name", "en"));
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)} with {@code entityType}, {@code id}, {@code propertyName}, {@code localeCode}.
   * <p>
   * Method under test: {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationBatchReadCache.buildCacheKey(TranslatedEntity, String, String, String)"})
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode2() {
    // Arrange, Act and Assert
    assertEquals("--42-Property Name-en",
        TranslationBatchReadCache.buildCacheKey(new TranslatedEntity("-", "-"), "42", "Property Name", "en"));
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)} with {@code entityType}, {@code id}, {@code propertyName}, {@code localeCode}.
   * <p>
   * Method under test: {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationBatchReadCache.buildCacheKey(TranslatedEntity, String, String, String)"})
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode3() {
    // Arrange, Act and Assert
    assertEquals("-42-Property Name-en",
        TranslationBatchReadCache.buildCacheKey(new TranslatedEntity(), "42", "Property Name", "en"));
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)} with {@code entityType}, {@code id}, {@code propertyName}, {@code localeCode}.
   * <p>
   * Method under test: {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationBatchReadCache.buildCacheKey(TranslatedEntity, String, String, String)"})
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode4() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.common.site.domain.Catalog--Property Name-en",
        TranslationBatchReadCache.buildCacheKey(TranslatedEntity.CATALOG, "", "Property Name", "en"));
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(Translation)} with {@code translation}.
   * <p>
   * Method under test: {@link TranslationBatchReadCache#buildCacheKey(Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationBatchReadCache.buildCacheKey(Translation)"})
  public void testBuildCacheKeyWithTranslation() {
    // Arrange
    TranslationImpl translation = new TranslationImpl();
    translation.setEntityType(TranslatedEntity.CATALOG);

    // Act and Assert
    assertEquals("org.broadleafcommerce.common.site.domain.Catalog---",
        TranslationBatchReadCache.buildCacheKey(translation));
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(Translation)} with {@code translation}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationBatchReadCache#buildCacheKey(Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationBatchReadCache.buildCacheKey(Translation)"})
  public void testBuildCacheKeyWithTranslation_givenEmptyString() {
    // Arrange
    TranslationImpl translation = new TranslationImpl();
    translation.setEntityId("");
    translation.setEntityType(TranslatedEntity.CATALOG);

    // Act and Assert
    assertEquals("org.broadleafcommerce.common.site.domain.Catalog---",
        TranslationBatchReadCache.buildCacheKey(translation));
  }
}
