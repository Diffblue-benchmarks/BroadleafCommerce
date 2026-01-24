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
