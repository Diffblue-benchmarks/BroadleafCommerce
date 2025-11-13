package org.broadleafcommerce.core.offer.service.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.discount.FulfillmentGroupOfferPotential;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class FulfillmentGroupOfferProcessorImplDiffblueTest {
  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(PromotableOrder)"
  })
  public void testCalculateFulfillmentGroupTotal() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(order2);

    // Assert
    assertTrue(order2.getOrder() instanceof OrderImpl);
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(PromotableOrder)"
  })
  public void testCalculateFulfillmentGroupTotal_thenCallsGetCurrencyCode() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    doNothing().when(order).setTotalFulfillmentCharges(Mockito.<Money>any());
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(order2);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).setTotalFulfillmentCharges(isA(Money.class));
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   *
   * <ul>
   *   <li>When {@link Order} {@link Order#getCurrency()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(PromotableOrder)"
  })
  public void testCalculateFulfillmentGroupTotal_whenOrderGetCurrencyReturnNull() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setTotalFulfillmentCharges(Mockito.<Money>any());
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(order2);

    // Assert
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).setTotalFulfillmentCharges(isA(Money.class));
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)"
  })
  public void testCompareAndAdjustFulfillmentGroupOffers() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertFalse(
        fulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(order2, true));
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)"
  })
  public void testCompareAndAdjustFulfillmentGroupOffers2() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

    PromotableOrder order = mock(PromotableOrder.class);
    doNothing().when(order).removeAllCandidateFulfillmentOfferAdjustments();
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult =
        fulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(order, true);

    // Assert
    verify(order).calculateSubtotalWithAdjustments();
    verify(order).calculateSubtotalWithoutAdjustments();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).removeAllCandidateFulfillmentOfferAdjustments();
    assertFalse(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)"
  })
  public void testCompareAndAdjustFulfillmentGroupOffers3() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getOrderCurrency()).thenReturn(broadleafCurrency);
    when(order.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            fulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(order, true));
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).calculateSubtotalWithoutAdjustments();
    verify(order).getOrderCurrency();
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link Order#getCurrency()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)"
  })
  public void testCompareAndAdjustFulfillmentGroupOffers_thenCallsGetCurrency() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult =
        fulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(order2, true);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertFalse(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupOfferProcessorImpl.removeTrailingNotCombinableFulfillmentGroupOffers(List)"
  })
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnArrayList() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential>
        actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult =
            fulfillmentGroupOfferProcessorImpl.removeTrailingNotCombinableFulfillmentGroupOffers(
                candidateOffers);

    // Assert
    assertEquals(candidateOffers, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult);
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupOfferProcessorImpl.removeTrailingNotCombinableFulfillmentGroupOffers(List)"
  })
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act and Assert
    assertTrue(
        fulfillmentGroupOfferProcessorImpl
            .removeTrailingNotCombinableFulfillmentGroupOffers(new ArrayList<>())
            .isEmpty());
  }
}
