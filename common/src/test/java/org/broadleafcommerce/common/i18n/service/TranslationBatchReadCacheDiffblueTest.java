package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TranslationBatchReadCacheDiffblueTest {
  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   * with {@code entityType}, {@code id}, {@code propertyName}, {@code localeCode}.
   *
   * <p>Method under test: {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TranslationBatchReadCache.buildCacheKey(TranslatedEntity, String, String, String)"
  })
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode() {
    // Arrange and Act
    String actualBuildCacheKeyResult =
        TranslationBatchReadCache.buildCacheKey(
            TranslatedEntity.CATALOG, "42", "Property Name", "en");

    // Assert
    assertEquals(
        "org.broadleafcommerce.common.site.domain.Catalog-42-Property Name-en",
        actualBuildCacheKeyResult);
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   * with {@code entityType}, {@code id}, {@code propertyName}, {@code localeCode}.
   *
   * <p>Method under test: {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TranslationBatchReadCache.buildCacheKey(TranslatedEntity, String, String, String)"
  })
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode2() {
    // Arrange and Act
    String actualBuildCacheKeyResult =
        TranslationBatchReadCache.buildCacheKey(
            new TranslatedEntity("-", "-"), "42", "Property Name", "en");

    // Assert
    assertEquals("--42-Property Name-en", actualBuildCacheKeyResult);
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   * with {@code entityType}, {@code id}, {@code propertyName}, {@code localeCode}.
   *
   * <p>Method under test: {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TranslationBatchReadCache.buildCacheKey(TranslatedEntity, String, String, String)"
  })
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode3() {
    // Arrange and Act
    String actualBuildCacheKeyResult =
        TranslationBatchReadCache.buildCacheKey(
            new TranslatedEntity(), "42", "Property Name", "en");

    // Assert
    assertEquals("-42-Property Name-en", actualBuildCacheKeyResult);
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String, String, String)}
   * with {@code entityType}, {@code id}, {@code propertyName}, {@code localeCode}.
   *
   * <p>Method under test: {@link TranslationBatchReadCache#buildCacheKey(TranslatedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TranslationBatchReadCache.buildCacheKey(TranslatedEntity, String, String, String)"
  })
  public void testBuildCacheKeyWithEntityTypeIdPropertyNameLocaleCode4() {
    // Arrange and Act
    String actualBuildCacheKeyResult =
        TranslationBatchReadCache.buildCacheKey(
            TranslatedEntity.CATALOG, "", "Property Name", "en");

    // Assert
    assertEquals(
        "org.broadleafcommerce.common.site.domain.Catalog--Property Name-en",
        actualBuildCacheKeyResult);
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(Translation)} with {@code translation}.
   *
   * <p>Method under test: {@link TranslationBatchReadCache#buildCacheKey(Translation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationBatchReadCache.buildCacheKey(Translation)"})
  public void testBuildCacheKeyWithTranslation() {
    // Arrange
    TranslationImpl translation = new TranslationImpl();
    translation.setEntityType(TranslatedEntity.CATALOG);

    // Act and Assert
    assertEquals(
        "org.broadleafcommerce.common.site.domain.Catalog---",
        TranslationBatchReadCache.buildCacheKey(translation));
  }

  /**
   * Test {@link TranslationBatchReadCache#buildCacheKey(Translation)} with {@code translation}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link TranslationBatchReadCache#buildCacheKey(Translation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationBatchReadCache.buildCacheKey(Translation)"})
  public void testBuildCacheKeyWithTranslation_givenEmptyString() {
    // Arrange
    TranslationImpl translation = new TranslationImpl();
    translation.setEntityId("");
    translation.setEntityType(TranslatedEntity.CATALOG);

    // Act and Assert
    assertEquals(
        "org.broadleafcommerce.common.site.domain.Catalog---",
        TranslationBatchReadCache.buildCacheKey(translation));
  }
}
