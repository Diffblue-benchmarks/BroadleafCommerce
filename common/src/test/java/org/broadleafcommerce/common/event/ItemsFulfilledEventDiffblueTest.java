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

public class ItemsFulfilledEventDiffblueTest {
  /**
   * Test {@link ItemsFulfilledEvent#ItemsFulfilledEvent(Long, Map)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CatalogId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ItemsFulfilledEvent#ItemsFulfilledEvent(Long, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ItemsFulfilledEvent.<init>(Long, Map)"})
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
    assertEquals(1L, actualItemsFulfilledEvent.getFulfillmentGroupId().longValue());
    assertEquals(1L, ((Long) actualItemsFulfilledEvent.getSource()).longValue());
    assertTrue(actualItemsFulfilledEvent.getContext().isEmpty());
    assertEquals(fulfilled, actualItemsFulfilledEvent.getItemsAndQuantitiesFulfilled());
  }

  /**
   * Test {@link ItemsFulfilledEvent#getFulfillmentGroupId()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ItemsFulfilledEvent#getFulfillmentGroupId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ItemsFulfilledEvent.getFulfillmentGroupId()"})
  public void testGetFulfillmentGroupId_givenHashMapOneIsOne_thenReturnLongValueIsOne() {
    // Arrange
    HashMap<Long, Integer> fulfilled = new HashMap<>();
    fulfilled.put(1L, 1);
    ItemsFulfilledEvent itemsFulfilledEvent = new ItemsFulfilledEvent(1L, fulfilled);

    // Act and Assert
    assertEquals(1L, itemsFulfilledEvent.getFulfillmentGroupId().longValue());
  }
}
