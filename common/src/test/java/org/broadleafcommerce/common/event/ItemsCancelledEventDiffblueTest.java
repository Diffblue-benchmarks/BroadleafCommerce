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
