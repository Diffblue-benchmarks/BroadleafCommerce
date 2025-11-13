package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PromotableOrderItemImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PromotableOrderItemImpl#getExtraDataMap()}
   *   <li>{@link PromotableOrderItemImpl#getOrderItem()}
   *   <li>{@link PromotableOrderItemImpl#getPromotableOrderItemPriceDetails()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map PromotableOrderItemImpl.getExtraDataMap()",
    "OrderItem PromotableOrderItemImpl.getOrderItem()",
    "java.util.List PromotableOrderItemImpl.getPromotableOrderItemPriceDetails()"
  })
  public void testGettersAndSetters() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl promotableOrderItemImpl =
        new PromotableOrderItemImpl(
            orderItem,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()),
            true);

    // Act
    Map<String, Object> actualExtraDataMap = promotableOrderItemImpl.getExtraDataMap();
    OrderItem actualOrderItem = promotableOrderItemImpl.getOrderItem();

    // Assert
    assertTrue(promotableOrderItemImpl.getPromotableOrderItemPriceDetails().isEmpty());
    assertTrue(actualExtraDataMap.isEmpty());
    assertSame(promotableOrderItemImpl.orderItem, actualOrderItem);
  }
}
