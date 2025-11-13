package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ItemsReturnedEventDiffblueTest {
  /**
   * Test {@link ItemsReturnedEvent#ItemsReturnedEvent(Long, Map)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashMap#HashMap()} one is one.
   *   <li>Then return CatalogId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ItemsReturnedEvent#ItemsReturnedEvent(Long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ItemsReturnedEvent.<init>(Long, Map)"})
  public void testNewItemsReturnedEvent_givenOne_whenHashMapOneIsOne_thenReturnCatalogIdIsNull() {
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
    assertEquals(1L, actualItemsReturnedEvent.getOrderId().longValue());
    assertEquals(1L, ((Long) actualItemsReturnedEvent.getSource()).longValue());
    assertTrue(actualItemsReturnedEvent.getContext().isEmpty());
    assertEquals(returnedItems, actualItemsReturnedEvent.getItemsAndQuantitiesReturned());
  }

  /**
   * Test {@link ItemsReturnedEvent#getOrderId()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ItemsReturnedEvent#getOrderId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ItemsReturnedEvent.getOrderId()"})
  public void testGetOrderId_givenHashMapOneIsOne_thenReturnLongValueIsOne() {
    // Arrange
    HashMap<Long, Integer> returnedItems = new HashMap<>();
    returnedItems.put(1L, 1);
    ItemsReturnedEvent itemsReturnedEvent = new ItemsReturnedEvent(1L, returnedItems);

    // Act and Assert
    assertEquals(1L, itemsReturnedEvent.getOrderId().longValue());
  }
}
