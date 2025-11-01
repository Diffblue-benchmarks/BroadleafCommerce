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

public class ItemsReturnedEventDiffblueTest {
  /**
   * Method under test: {@link ItemsReturnedEvent#getOrderId()}
   */
  @Test
  public void testGetOrderId() {
    // Arrange
    HashMap<Long, Integer> returnedItems = new HashMap<>();
    returnedItems.put(1L, 1);

    // Act and Assert
    assertEquals(1L, (new ItemsReturnedEvent(1L, returnedItems)).getOrderId().longValue());
  }

  /**
   * Method under test: {@link ItemsReturnedEvent#getOrderId()}
   */
  @Test
  public void testGetOrderId2() {
    // Arrange
    HashMap<Long, Integer> returnedItems = new HashMap<>();
    returnedItems.computeIfPresent(1L, mock(BiFunction.class));
    returnedItems.put(1L, 1);

    // Act and Assert
    assertEquals(1L, (new ItemsReturnedEvent(1L, returnedItems)).getOrderId().longValue());
  }

  /**
   * Method under test: {@link ItemsReturnedEvent#ItemsReturnedEvent(Long, Map)}
   */
  @Test
  public void testNewItemsReturnedEvent() {
    // Arrange
    HashMap<Long, Integer> returnedItems = new HashMap<>();
    returnedItems.put(1L, 1);

    // Act
    ItemsReturnedEvent actualItemsReturnedEvent = new ItemsReturnedEvent(1L, returnedItems);

    // Assert
    assertNull(actualItemsReturnedEvent.getCatalogId());
    assertNull(actualItemsReturnedEvent.getProfileId());
    assertNull(actualItemsReturnedEvent.getSiteId());
    assertNull(actualItemsReturnedEvent.getCurrencyCode());
    assertNull(actualItemsReturnedEvent.getLocaleCode());
    assertNull(actualItemsReturnedEvent.getTimeZoneId());
    Map<Long, Integer> itemsAndQuantitiesReturned = actualItemsReturnedEvent.getItemsAndQuantitiesReturned();
    assertEquals(1, itemsAndQuantitiesReturned.size());
    assertEquals(1, itemsAndQuantitiesReturned.get(1L).intValue());
    assertEquals(1L, actualItemsReturnedEvent.getOrderId().longValue());
    assertTrue(actualItemsReturnedEvent.getContext().isEmpty());
  }

  /**
   * Method under test: {@link ItemsReturnedEvent#ItemsReturnedEvent(Long, Map)}
   */
  @Test
  public void testNewItemsReturnedEvent2() {
    // Arrange
    HashMap<Long, Integer> returnedItems = new HashMap<>();
    returnedItems.computeIfPresent(1L, mock(BiFunction.class));
    returnedItems.put(1L, 1);

    // Act
    ItemsReturnedEvent actualItemsReturnedEvent = new ItemsReturnedEvent(1L, returnedItems);

    // Assert
    assertNull(actualItemsReturnedEvent.getCatalogId());
    assertNull(actualItemsReturnedEvent.getProfileId());
    assertNull(actualItemsReturnedEvent.getSiteId());
    assertNull(actualItemsReturnedEvent.getCurrencyCode());
    assertNull(actualItemsReturnedEvent.getLocaleCode());
    assertNull(actualItemsReturnedEvent.getTimeZoneId());
    Map<Long, Integer> itemsAndQuantitiesReturned = actualItemsReturnedEvent.getItemsAndQuantitiesReturned();
    assertEquals(1, itemsAndQuantitiesReturned.size());
    assertEquals(1, itemsAndQuantitiesReturned.get(1L).intValue());
    assertEquals(1L, actualItemsReturnedEvent.getOrderId().longValue());
    assertTrue(actualItemsReturnedEvent.getContext().isEmpty());
  }
}
