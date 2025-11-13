package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderSubmittedEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderSubmittedEvent#getOrderId()}
   *   <li>{@link OrderSubmittedEvent#getOrderNumber()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long OrderSubmittedEvent.getOrderId()",
    "java.lang.String OrderSubmittedEvent.getOrderNumber()"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderSubmittedEvent orderSubmittedEvent =
        new OrderSubmittedEvent(BLCFieldUtils.NULL_FIELD, 1L, "42");

    // Act
    Long actualOrderId = orderSubmittedEvent.getOrderId();

    // Assert
    assertEquals("42", orderSubmittedEvent.getOrderNumber());
    assertEquals(1L, actualOrderId.longValue());
  }
}
