package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderItemPriceDetailImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderItemPriceDetailImpl}
   *   <li>{@link OrderItemPriceDetailImpl#setId(Long)}
   *   <li>{@link OrderItemPriceDetailImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemPriceDetailImpl#setOrderItemAdjustments(List)}
   *   <li>{@link OrderItemPriceDetailImpl#setQuantity(int)}
   *   <li>{@link OrderItemPriceDetailImpl#getId()}
   *   <li>{@link OrderItemPriceDetailImpl#getOrderItem()}
   *   <li>{@link OrderItemPriceDetailImpl#getOrderItemPriceDetailAdjustments()}
   *   <li>{@link OrderItemPriceDetailImpl#getQuantity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemPriceDetailImpl.<init>()",
    "Long OrderItemPriceDetailImpl.getId()",
    "OrderItem OrderItemPriceDetailImpl.getOrderItem()",
    "List OrderItemPriceDetailImpl.getOrderItemPriceDetailAdjustments()",
    "int OrderItemPriceDetailImpl.getQuantity()",
    "void OrderItemPriceDetailImpl.setId(Long)",
    "void OrderItemPriceDetailImpl.setOrderItem(OrderItem)",
    "void OrderItemPriceDetailImpl.setOrderItemAdjustments(List)",
    "void OrderItemPriceDetailImpl.setQuantity(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemPriceDetailImpl actualOrderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    actualOrderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderItemPriceDetailImpl.setOrderItem(orderItem);
    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    actualOrderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);
    actualOrderItemPriceDetailImpl.setQuantity(1);
    Long actualId = actualOrderItemPriceDetailImpl.getId();
    OrderItem actualOrderItem = actualOrderItemPriceDetailImpl.getOrderItem();
    List<OrderItemPriceDetailAdjustment> actualOrderItemPriceDetailAdjustments =
        actualOrderItemPriceDetailImpl.getOrderItemPriceDetailAdjustments();

    // Assert
    assertEquals(1, actualOrderItemPriceDetailImpl.getQuantity());
    assertTrue(actualOrderItemPriceDetailAdjustments.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItemPriceDetailAdjustments, actualOrderItemPriceDetailAdjustments);
    assertSame(orderItem, actualOrderItem);
  }
}
