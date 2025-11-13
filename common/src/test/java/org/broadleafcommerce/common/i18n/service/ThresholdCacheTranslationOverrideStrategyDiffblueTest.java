package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ItemStatus;
import org.broadleafcommerce.common.extension.StandardCacheItem;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ThresholdCacheTranslationOverrideStrategyDiffblueTest {
  /**
   * Test {@link ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Standard Cache Key}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ThresholdCacheTranslationOverrideStrategy.validateTemplateProcessing(String, String)"
  })
  public void testValidateTemplateProcessing_whenStandardCacheKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new ThresholdCacheTranslationOverrideStrategy()
            .validateTemplateProcessing("Standard Cache Key", "Template Cache Key"));
  }

  /**
   * Test {@link ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Template Cache Key}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ThresholdCacheTranslationOverrideStrategy.validateTemplateProcessing(String, String)"
  })
  public void testValidateTemplateProcessing_whenTemplateCacheKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ThresholdCacheTranslationOverrideStrategy()
            .validateTemplateProcessing("Template Cache Key", "Template Cache Key"));
  }

  /**
   * Test {@link ThresholdCacheTranslationOverrideStrategy#getOrder()}.
   *
   * <p>Method under test: {@link ThresholdCacheTranslationOverrideStrategy#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ThresholdCacheTranslationOverrideStrategy.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(0, new ThresholdCacheTranslationOverrideStrategy().getOrder());
  }

  /**
   * Test {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair,
   * Translation)}.
   *
   * <ul>
   *   <li>Then {@link LocalePair} (default constructor) SpecificItem CacheItem is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThresholdCacheTranslationOverrideStrategy.buildSingleItemResponse(LocalePair, Translation)"
  })
  public void testBuildSingleItemResponse_thenLocalePairSpecificItemCacheItemIsEmptyString() {
    // Arrange
    ThresholdCacheTranslationOverrideStrategy thresholdCacheTranslationOverrideStrategy =
        new ThresholdCacheTranslationOverrideStrategy();

    StandardCacheItem generalItem = new StandardCacheItem();
    generalItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    generalItem.setItemStatus(ItemStatus.DELETED);
    generalItem.setKey("Key");

    StandardCacheItem specificItem = new StandardCacheItem();
    specificItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    specificItem.setItemStatus(ItemStatus.DELETED);
    specificItem.setKey("Key");

    LocalePair response = new LocalePair();
    response.setGeneralItem(generalItem);
    response.setSpecificItem(specificItem);

    // Act
    thresholdCacheTranslationOverrideStrategy.buildSingleItemResponse(response, null);

    // Assert
    StandardCacheItem specificItem2 = response.getSpecificItem();
    assertEquals("", specificItem2.getCacheItem());
    assertNull(specificItem2.getKey());
    assertEquals(ItemStatus.NORMAL, specificItem2.getItemStatus());
  }

  /**
   * Test {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair,
   * Translation)}.
   *
   * <ul>
   *   <li>Then {@link LocalePair} (default constructor) SpecificItem CacheItem is {@link
   *       TranslationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThresholdCacheTranslationOverrideStrategy.buildSingleItemResponse(LocalePair, Translation)"
  })
  public void testBuildSingleItemResponse_thenLocalePairSpecificItemCacheItemIsTranslationImpl() {
    // Arrange
    ThresholdCacheTranslationOverrideStrategy thresholdCacheTranslationOverrideStrategy =
        new ThresholdCacheTranslationOverrideStrategy();

    StandardCacheItem generalItem = new StandardCacheItem();
    generalItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    generalItem.setItemStatus(ItemStatus.DELETED);
    generalItem.setKey("Key");

    StandardCacheItem specificItem = new StandardCacheItem();
    specificItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    specificItem.setItemStatus(ItemStatus.DELETED);
    specificItem.setKey("Key");

    LocalePair response = new LocalePair();
    response.setGeneralItem(generalItem);
    response.setSpecificItem(specificItem);
    TranslationImpl translation = new TranslationImpl();

    // Act
    thresholdCacheTranslationOverrideStrategy.buildSingleItemResponse(response, translation);

    // Assert
    assertSame(translation, response.getSpecificItem().getCacheItem());
  }
}
