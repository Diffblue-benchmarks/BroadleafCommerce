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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class ItemsFulfilledEventDiffblueTest {
  /**
   * Test {@link ItemsFulfilledEvent#ItemsFulfilledEvent(Long, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemsFulfilledEvent#ItemsFulfilledEvent(Long, Map)}
   */
  @Test
  public void testNewItemsFulfilledEvent_givenBiFunction() {
    // Arrange
    HashMap<Long, Integer> fulfilled = new HashMap<>();
    fulfilled.computeIfPresent(1L, mock(BiFunction.class));
    fulfilled.put(1L, 1);

    // Act
    ItemsFulfilledEvent actualItemsFulfilledEvent = new ItemsFulfilledEvent(1L, fulfilled);

    // Assert
    assertNull(actualItemsFulfilledEvent.getCatalogId());
    assertNull(actualItemsFulfilledEvent.getProfileId());
    assertNull(actualItemsFulfilledEvent.getSiteId());
    assertNull(actualItemsFulfilledEvent.getCurrencyCode());
    assertNull(actualItemsFulfilledEvent.getLocaleCode());
    assertNull(actualItemsFulfilledEvent.getTimeZoneId());
    Map<Long, Integer> itemsAndQuantitiesFulfilled = actualItemsFulfilledEvent.getItemsAndQuantitiesFulfilled();
    assertEquals(1, itemsAndQuantitiesFulfilled.size());
    assertEquals(1, itemsAndQuantitiesFulfilled.get(1L).intValue());
    assertEquals(1L, actualItemsFulfilledEvent.getFulfillmentGroupId().longValue());
    assertTrue(actualItemsFulfilledEvent.getContext().isEmpty());
  }

  /**
   * Test {@link ItemsFulfilledEvent#ItemsFulfilledEvent(Long, Map)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return CatalogId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemsFulfilledEvent#ItemsFulfilledEvent(Long, Map)}
   */
  @Test
  public void testNewItemsFulfilledEvent_givenOne_thenReturnCatalogIdIsNull() {
    // Arrange
    HashMap<Long, Integer> fulfilled = new HashMap<>();
    fulfilled.put(1L, 1);

    // Act
    ItemsFulfilledEvent actualItemsFulfilledEvent = new ItemsFulfilledEvent(1L, fulfilled);

    // Assert
    assertNull(actualItemsFulfilledEvent.getCatalogId());
    assertNull(actualItemsFulfilledEvent.getProfileId());
    assertNull(actualItemsFulfilledEvent.getSiteId());
    assertNull(actualItemsFulfilledEvent.getCurrencyCode());
    assertNull(actualItemsFulfilledEvent.getLocaleCode());
    assertNull(actualItemsFulfilledEvent.getTimeZoneId());
    Map<Long, Integer> itemsAndQuantitiesFulfilled = actualItemsFulfilledEvent.getItemsAndQuantitiesFulfilled();
    assertEquals(1, itemsAndQuantitiesFulfilled.size());
    assertEquals(1, itemsAndQuantitiesFulfilled.get(1L).intValue());
    assertEquals(1L, actualItemsFulfilledEvent.getFulfillmentGroupId().longValue());
    assertTrue(actualItemsFulfilledEvent.getContext().isEmpty());
  }

  /**
   * Test {@link ItemsFulfilledEvent#getFulfillmentGroupId()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent one and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemsFulfilledEvent#getFulfillmentGroupId()}
   */
  @Test
  public void testGetFulfillmentGroupId_givenHashMapComputeIfPresentOneAndBiFunction() {
    // Arrange
    HashMap<Long, Integer> fulfilled = new HashMap<>();
    fulfilled.computeIfPresent(1L, mock(BiFunction.class));
    fulfilled.put(1L, 1);

    // Act and Assert
    assertEquals(1L, (new ItemsFulfilledEvent(1L, fulfilled)).getFulfillmentGroupId().longValue());
  }

  /**
   * Test {@link ItemsFulfilledEvent#getFulfillmentGroupId()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemsFulfilledEvent#getFulfillmentGroupId()}
   */
  @Test
  public void testGetFulfillmentGroupId_givenHashMapOneIsOne_thenReturnLongValueIsOne() {
    // Arrange
    HashMap<Long, Integer> fulfilled = new HashMap<>();
    fulfilled.put(1L, 1);

    // Act and Assert
    assertEquals(1L, (new ItemsFulfilledEvent(1L, fulfilled)).getFulfillmentGroupId().longValue());
  }
}
