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

public class ItemsCancelledEventDiffblueTest {
  /**
   * Test {@link ItemsCancelledEvent#ItemsCancelledEvent(Long, Map)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CatalogId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ItemsCancelledEvent#ItemsCancelledEvent(Long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ItemsCancelledEvent.<init>(Long, Map)"})
  public void testNewItemsCancelledEvent_givenOne_thenReturnCatalogIdIsNull() {
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
    assertEquals(1L, actualItemsCancelledEvent.getFulfillmentGroupId().longValue());
    assertEquals(1L, ((Long) actualItemsCancelledEvent.getSource()).longValue());
    assertTrue(actualItemsCancelledEvent.getContext().isEmpty());
    assertEquals(cancelledItems, actualItemsCancelledEvent.getItemsAndQuantitiesCancelled());
  }

  /**
   * Test {@link ItemsCancelledEvent#getFulfillmentGroupId()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ItemsCancelledEvent#getFulfillmentGroupId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ItemsCancelledEvent.getFulfillmentGroupId()"})
  public void testGetFulfillmentGroupId_givenHashMapOneIsOne_thenReturnLongValueIsOne() {
    // Arrange
    HashMap<Long, Integer> cancelledItems = new HashMap<>();
    cancelledItems.put(1L, 1);
    ItemsCancelledEvent itemsCancelledEvent = new ItemsCancelledEvent(1L, cancelledItems);

    // Act and Assert
    assertEquals(1L, itemsCancelledEvent.getFulfillmentGroupId().longValue());
  }
}
