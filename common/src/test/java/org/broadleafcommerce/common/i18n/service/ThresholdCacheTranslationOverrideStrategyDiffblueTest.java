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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.cache.StatisticsService;
import org.broadleafcommerce.common.extension.ItemStatus;
import org.broadleafcommerce.common.extension.StandardCacheItem;
import org.broadleafcommerce.common.i18n.dao.TranslationDao;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ThresholdCacheTranslationOverrideStrategyDiffblueTest {
  @Mock
  private StatisticsService statisticsService;

  @InjectMocks
  private ThresholdCacheTranslationOverrideStrategy thresholdCacheTranslationOverrideStrategy;

  @Mock
  private TranslationDao translationDao;

  @Mock
  private TranslationSupport translationSupport;

  /**
   * Test {@link ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String, String)}.
   * <ul>
   *   <li>When {@code Standard Cache Key}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ThresholdCacheTranslationOverrideStrategy.validateTemplateProcessing(String, String)"})
  public void testValidateTemplateProcessing_whenStandardCacheKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(thresholdCacheTranslationOverrideStrategy.validateTemplateProcessing("Standard Cache Key",
        "Template Cache Key"));
  }

  /**
   * Test {@link ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String, String)}.
   * <ul>
   *   <li>When {@code Template Cache Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ThresholdCacheTranslationOverrideStrategy.validateTemplateProcessing(String, String)"})
  public void testValidateTemplateProcessing_whenTemplateCacheKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(thresholdCacheTranslationOverrideStrategy.validateTemplateProcessing("Template Cache Key",
        "Template Cache Key"));
  }

  /**
   * Test {@link ThresholdCacheTranslationOverrideStrategy#getOrder()}.
   * <p>
   * Method under test: {@link ThresholdCacheTranslationOverrideStrategy#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ThresholdCacheTranslationOverrideStrategy.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(0, (new ThresholdCacheTranslationOverrideStrategy()).getOrder());
  }

  /**
   * Test {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}.
   * <ul>
   *   <li>Then {@link LocalePair} (default constructor) SpecificItem CacheItem is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ThresholdCacheTranslationOverrideStrategy.buildSingleItemResponse(LocalePair, Translation)"})
  public void testBuildSingleItemResponse_thenLocalePairSpecificItemCacheItemIsEmptyString() {
    // Arrange
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
   * Test {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}.
   * <ul>
   *   <li>Then {@link LocalePair} (default constructor) SpecificItem CacheItem is {@link TranslationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ThresholdCacheTranslationOverrideStrategy.buildSingleItemResponse(LocalePair, Translation)"})
  public void testBuildSingleItemResponse_thenLocalePairSpecificItemCacheItemIsTranslationImpl() {
    // Arrange
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
