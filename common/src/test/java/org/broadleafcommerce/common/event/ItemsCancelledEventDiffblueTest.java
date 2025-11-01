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

public class ItemsCancelledEventDiffblueTest {
  /**
   * Method under test: {@link ItemsCancelledEvent#getFulfillmentGroupId()}
   */
  @Test
  public void testGetFulfillmentGroupId() {
    // Arrange
    HashMap<Long, Integer> cancelledItems = new HashMap<>();
    cancelledItems.put(1L, 1);

    // Act and Assert
    assertEquals(1L, (new ItemsCancelledEvent(1L, cancelledItems)).getFulfillmentGroupId().longValue());
  }

  /**
   * Method under test: {@link ItemsCancelledEvent#getFulfillmentGroupId()}
   */
  @Test
  public void testGetFulfillmentGroupId2() {
    // Arrange
    HashMap<Long, Integer> cancelledItems = new HashMap<>();
    cancelledItems.computeIfPresent(1L, mock(BiFunction.class));
    cancelledItems.put(1L, 1);

    // Act and Assert
    assertEquals(1L, (new ItemsCancelledEvent(1L, cancelledItems)).getFulfillmentGroupId().longValue());
  }

  /**
   * Method under test: {@link ItemsCancelledEvent#ItemsCancelledEvent(Long, Map)}
   */
  @Test
  public void testNewItemsCancelledEvent() {
    // Arrange
    HashMap<Long, Integer> cancelledItems = new HashMap<>();
    cancelledItems.put(1L, 1);

    // Act
    ItemsCancelledEvent actualItemsCancelledEvent = new ItemsCancelledEvent(1L, cancelledItems);

    // Assert
    assertNull(actualItemsCancelledEvent.getCatalogId());
    assertNull(actualItemsCancelledEvent.getProfileId());
    assertNull(actualItemsCancelledEvent.getSiteId());
    assertNull(actualItemsCancelledEvent.getCurrencyCode());
    assertNull(actualItemsCancelledEvent.getLocaleCode());
    assertNull(actualItemsCancelledEvent.getTimeZoneId());
    Map<Long, Integer> itemsAndQuantitiesCancelled = actualItemsCancelledEvent.getItemsAndQuantitiesCancelled();
    assertEquals(1, itemsAndQuantitiesCancelled.size());
    assertEquals(1, itemsAndQuantitiesCancelled.get(1L).intValue());
    assertEquals(1L, actualItemsCancelledEvent.getFulfillmentGroupId().longValue());
    assertTrue(actualItemsCancelledEvent.getContext().isEmpty());
  }

  /**
   * Method under test: {@link ItemsCancelledEvent#ItemsCancelledEvent(Long, Map)}
   */
  @Test
  public void testNewItemsCancelledEvent2() {
    // Arrange
    HashMap<Long, Integer> cancelledItems = new HashMap<>();
    cancelledItems.computeIfPresent(1L, mock(BiFunction.class));
    cancelledItems.put(1L, 1);

    // Act
    ItemsCancelledEvent actualItemsCancelledEvent = new ItemsCancelledEvent(1L, cancelledItems);

    // Assert
    assertNull(actualItemsCancelledEvent.getCatalogId());
    assertNull(actualItemsCancelledEvent.getProfileId());
    assertNull(actualItemsCancelledEvent.getSiteId());
    assertNull(actualItemsCancelledEvent.getCurrencyCode());
    assertNull(actualItemsCancelledEvent.getLocaleCode());
    assertNull(actualItemsCancelledEvent.getTimeZoneId());
    Map<Long, Integer> itemsAndQuantitiesCancelled = actualItemsCancelledEvent.getItemsAndQuantitiesCancelled();
    assertEquals(1, itemsAndQuantitiesCancelled.size());
    assertEquals(1, itemsAndQuantitiesCancelled.get(1L).intValue());
    assertEquals(1L, actualItemsCancelledEvent.getFulfillmentGroupId().longValue());
    assertTrue(actualItemsCancelledEvent.getContext().isEmpty());
  }
}
