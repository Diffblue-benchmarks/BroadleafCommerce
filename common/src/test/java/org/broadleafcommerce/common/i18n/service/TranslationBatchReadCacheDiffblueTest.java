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
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.junit.Ignore;
import org.junit.Test;

public class TranslationBatchReadCacheDiffblueTest {
  /**
   * Test {@link TranslationBatchReadCache#getCache()}.
   * <p>
   * Method under test: {@link TranslationBatchReadCache#getCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getCache(TranslationBatchReadCache.java:51)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    TranslationBatchReadCache.getCache();
  }

  /**
   * Test {@link TranslationBatchReadCache#getThreadlocalCache()}.
   * <p>
   * Method under test: {@link TranslationBatchReadCache#getThreadlocalCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetThreadlocalCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getCache(TranslationBatchReadCache.java:51)
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getThreadlocalCache(TranslationBatchReadCache.java:57)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    TranslationBatchReadCache.getThreadlocalCache();
  }

  /**
   * Test {@link TranslationBatchReadCache#clearCache()}.
   * <p>
   * Method under test: {@link TranslationBatchReadCache#clearCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getCache(TranslationBatchReadCache.java:51)
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.clearCache(TranslationBatchReadCache.java:62)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    TranslationBatchReadCache.clearCache();
  }

  /**
   * Test {@link TranslationBatchReadCache#hasCache()}.
   * <p>
   * Method under test: {@link TranslationBatchReadCache#hasCache()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHasCache() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getCache(TranslationBatchReadCache.java:51)
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getThreadlocalCache(TranslationBatchReadCache.java:57)
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.hasCache(TranslationBatchReadCache.java:66)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    TranslationBatchReadCache.hasCache();
  }

  /**
   * Test {@link TranslationBatchReadCache#addToCache(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationBatchReadCache#addToCache(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddToCache_whenArrayList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getCache(TranslationBatchReadCache.java:51)
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getThreadlocalCache(TranslationBatchReadCache.java:57)
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.addToCache(TranslationBatchReadCache.java:71)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    TranslationBatchReadCache.addToCache(new ArrayList<>());
  }

  /**
   * Test
   * {@link TranslationBatchReadCache#getFromCache(TranslatedEntity, String, String, String)}.
   * <ul>
   *   <li>When {@link TranslatedEntity#CATALOG}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationBatchReadCache#getFromCache(TranslatedEntity, String, String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFromCache_whenCatalog() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getCache(TranslationBatchReadCache.java:51)
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getThreadlocalCache(TranslationBatchReadCache.java:57)
    //       at org.broadleafcommerce.common.i18n.service.TranslationBatchReadCache.getFromCache(TranslationBatchReadCache.java:90)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    TranslationBatchReadCache.getFromCache(TranslatedEntity.CATALOG, "42", "Property Name", "en");
  }

  /**
   * Test
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   * with {@code entityType}, {@code id}, {@code propertyName},
   * {@code localeCode}.
   * <p>
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode() {
    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.common.site.domain.Catalog-42-Property Name-en",
        TranslationBatchReadCache.buildCacheKey(TranslatedEntity.CATALOG, "42", "Property Name", "en"));
    assertEquals("--42-Property Name-en",
        TranslationBatchReadCache.buildCacheKey(new TranslatedEntity("-", "-"), "42", "Property Name", "en"));
  }

  /**
   * Test
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   * with {@code entityType}, {@code id}, {@code propertyName},
   * {@code localeCode}.
   * <p>
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode2() {
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
   * Test
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   * with {@code entityType}, {@code id}, {@code propertyName},
   * {@code localeCode}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode_givenEmptyString() {
    // Arrange
    TranslatedEntity entityType = mock(TranslatedEntity.class);
    when(entityType.getType()).thenReturn("");

    // Act
    String actualBuildCacheKeyResult = TranslationBatchReadCache.buildCacheKey(entityType, "42", "Property Name", "en");

    // Assert
    verify(entityType).getType();
    assertEquals("-42-Property Name-en", actualBuildCacheKeyResult);
  }

  /**
   * Test
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   * with {@code entityType}, {@code id}, {@code propertyName},
   * {@code localeCode}.
   * <ul>
   *   <li>When {@link TranslatedEntity#TranslatedEntity()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   */
  @Test
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode_whenTranslatedEntity() {
    // Arrange, Act and Assert
    assertEquals("-42-Property Name-en",
        TranslationBatchReadCache.buildCacheKey(new TranslatedEntity(), "42", "Property Name", "en"));
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(Translation)} with
   * {@code translation}.
   * <p>
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(Translation)}
   */
  @Test
  public void testBuildCacheKeyWithTranslation() {
    // Arrange
    TranslationImpl translation = new TranslationImpl();
    translation.setEntityType(TranslatedEntity.CATALOG);

    // Act and Assert
    assertEquals("org.broadleafcommerce.common.site.domain.Catalog---",
        TranslationBatchReadCache.buildCacheKey(translation));
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(Translation)} with
   * {@code translation}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationBatchReadCache#buildCacheKey(Translation)}
   */
  @Test
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
