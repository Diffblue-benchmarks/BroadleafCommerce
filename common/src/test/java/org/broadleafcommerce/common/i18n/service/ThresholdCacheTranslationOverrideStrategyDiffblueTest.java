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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.common.extension.ItemStatus;
import org.broadleafcommerce.common.extension.StandardCacheItem;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mockito.Mockito;

public class ThresholdCacheTranslationOverrideStrategyDiffblueTest {
  /**
   * Test
   * {@link ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String, String)}.
   * <ul>
   *   <li>When {@code Standard Cache Key}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String, String)}
   */
  @Test
  public void testValidateTemplateProcessing_whenStandardCacheKey_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ThresholdCacheTranslationOverrideStrategy()).validateTemplateProcessing("Standard Cache Key",
        "Template Cache Key"));
  }

  /**
   * Test
   * {@link ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String, String)}.
   * <ul>
   *   <li>When {@code Template Cache Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThresholdCacheTranslationOverrideStrategy#validateTemplateProcessing(String, String)}
   */
  @Test
  public void testValidateTemplateProcessing_whenTemplateCacheKey_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ThresholdCacheTranslationOverrideStrategy()).validateTemplateProcessing("Template Cache Key",
        "Template Cache Key"));
  }

  /**
   * Test {@link ThresholdCacheTranslationOverrideStrategy#getOrder()}.
   * <p>
   * Method under test:
   * {@link ThresholdCacheTranslationOverrideStrategy#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(0, (new ThresholdCacheTranslationOverrideStrategy()).getOrder());
  }

  /**
   * Test
   * {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}.
   * <ul>
   *   <li>Then calls {@link LocalePair#setGeneralItem(StandardCacheItem)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}
   */
  @Test
  public void testBuildSingleItemResponse_thenCallsSetGeneralItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ThresholdCacheTranslationOverrideStrategy thresholdCacheTranslationOverrideStrategy = new ThresholdCacheTranslationOverrideStrategy();

    StandardCacheItem generalItem = new StandardCacheItem();
    generalItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    generalItem.setItemStatus(ItemStatus.DELETED);
    generalItem.setKey("Key");

    StandardCacheItem specificItem = new StandardCacheItem();
    specificItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    specificItem.setItemStatus(ItemStatus.DELETED);
    specificItem.setKey("Key");
    LocalePair response = mock(LocalePair.class);
    doNothing().when(response).setGeneralItem(Mockito.<StandardCacheItem>any());
    doNothing().when(response).setSpecificItem(Mockito.<StandardCacheItem>any());
    response.setGeneralItem(generalItem);
    response.setSpecificItem(specificItem);

    // Act
    thresholdCacheTranslationOverrideStrategy.buildSingleItemResponse(response, new TranslationImpl());

    // Assert
    verify(response).setGeneralItem(isA(StandardCacheItem.class));
    verify(response, atLeast(1)).setSpecificItem(Mockito.<StandardCacheItem>any());
  }

  /**
   * Test
   * {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}.
   * <ul>
   *   <li>Then {@link LocalePair} (default constructor) SpecificItem CacheItem is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}
   */
  @Test
  public void testBuildSingleItemResponse_thenLocalePairSpecificItemCacheItemIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ThresholdCacheTranslationOverrideStrategy thresholdCacheTranslationOverrideStrategy = new ThresholdCacheTranslationOverrideStrategy();

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
   * Test
   * {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}.
   * <ul>
   *   <li>Then {@link LocalePair} (default constructor) SpecificItem CacheItem is
   * {@link TranslationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThresholdCacheTranslationOverrideStrategy#buildSingleItemResponse(LocalePair, Translation)}
   */
  @Test
  public void testBuildSingleItemResponse_thenLocalePairSpecificItemCacheItemIsTranslationImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ThresholdCacheTranslationOverrideStrategy thresholdCacheTranslationOverrideStrategy = new ThresholdCacheTranslationOverrideStrategy();

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
