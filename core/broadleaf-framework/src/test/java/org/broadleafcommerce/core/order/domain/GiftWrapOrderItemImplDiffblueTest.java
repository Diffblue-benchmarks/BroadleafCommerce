package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GiftWrapOrderItemImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GiftWrapOrderItemImpl#setWrappedItems(List)}
   *   <li>{@link GiftWrapOrderItemImpl#getWrappedItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List GiftWrapOrderItemImpl.getWrappedItems()",
    "void GiftWrapOrderItemImpl.setWrappedItems(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    GiftWrapOrderItemImpl giftWrapOrderItemImpl = new GiftWrapOrderItemImpl();
    ArrayList<OrderItem> wrappedItems = new ArrayList<>();

    // Act
    giftWrapOrderItemImpl.setWrappedItems(wrappedItems);
    List<OrderItem> actualWrappedItems = giftWrapOrderItemImpl.getWrappedItems();

    // Assert
    assertTrue(actualWrappedItems.isEmpty());
    assertSame(wrappedItems, actualWrappedItems);
  }
}
