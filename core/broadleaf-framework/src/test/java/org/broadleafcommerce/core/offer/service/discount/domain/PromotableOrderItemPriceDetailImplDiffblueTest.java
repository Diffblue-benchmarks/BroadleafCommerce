package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.core.offer.service.discount.PromotionDiscount;
import org.broadleafcommerce.core.offer.service.discount.PromotionQualifier;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PromotableOrderItemPriceDetailImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       PromotableOrderItemPriceDetailImpl#PromotableOrderItemPriceDetailImpl(PromotableOrderItem,
   *       int)}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#setAdjustmentsFinalized(boolean)}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#setQuantity(int)}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getPromotableOrderItem()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getPromotionDiscounts()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getPromotionQualifiers()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getQuantity()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#isAdjustmentsFinalized()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#useSaleAdjustments()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderItemPriceDetailImpl.<init>(PromotableOrderItem, int)",
    "PromotableOrderItem PromotableOrderItemPriceDetailImpl.getPromotableOrderItem()",
    "List PromotableOrderItemPriceDetailImpl.getPromotionDiscounts()",
    "List PromotableOrderItemPriceDetailImpl.getPromotionQualifiers()",
    "int PromotableOrderItemPriceDetailImpl.getQuantity()",
    "boolean PromotableOrderItemPriceDetailImpl.isAdjustmentsFinalized()",
    "void PromotableOrderItemPriceDetailImpl.setAdjustmentsFinalized(boolean)",
    "void PromotableOrderItemPriceDetailImpl.setQuantity(int)",
    "boolean PromotableOrderItemPriceDetailImpl.useSaleAdjustments()"
  })
  public void testGettersAndSetters() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl promotableOrderItem =
        new PromotableOrderItemImpl(
            orderItem,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()),
            true);

    // Act
    PromotableOrderItemPriceDetailImpl actualPromotableOrderItemPriceDetailImpl =
        new PromotableOrderItemPriceDetailImpl(promotableOrderItem, 1);
    actualPromotableOrderItemPriceDetailImpl.setAdjustmentsFinalized(true);
    actualPromotableOrderItemPriceDetailImpl.setQuantity(1);
    PromotableOrderItem actualPromotableOrderItem =
        actualPromotableOrderItemPriceDetailImpl.getPromotableOrderItem();
    List<PromotionDiscount> actualPromotionDiscounts =
        actualPromotableOrderItemPriceDetailImpl.getPromotionDiscounts();
    List<PromotionQualifier> actualPromotionQualifiers =
        actualPromotableOrderItemPriceDetailImpl.getPromotionQualifiers();
    int actualQuantity = actualPromotableOrderItemPriceDetailImpl.getQuantity();
    boolean actualIsAdjustmentsFinalizedResult =
        actualPromotableOrderItemPriceDetailImpl.isAdjustmentsFinalized();

    // Assert
    assertEquals(1, actualQuantity);
    assertFalse(actualPromotableOrderItemPriceDetailImpl.useSaleAdjustments());
    assertTrue(actualPromotionDiscounts.isEmpty());
    assertTrue(actualPromotionQualifiers.isEmpty());
    assertTrue(
        actualPromotableOrderItemPriceDetailImpl.promotableOrderItemPriceDetailAdjustments
            .isEmpty());
    assertTrue(actualIsAdjustmentsFinalizedResult);
    assertSame(promotableOrderItem, actualPromotableOrderItem);
  }
}
