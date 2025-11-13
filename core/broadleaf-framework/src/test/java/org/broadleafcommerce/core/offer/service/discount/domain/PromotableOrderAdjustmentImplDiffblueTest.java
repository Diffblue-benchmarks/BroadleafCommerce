package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Currency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class PromotableOrderAdjustmentImplDiffblueTest {
  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder)}.
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"
  })
  public void testNewPromotableOrderAdjustmentImpl() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    assertEquals(new BigDecimal("0.00"), adjustmentValue.getAmount());
    Money actualAbsResult = adjustmentValue.abs();
    assertEquals(adjustmentValue, actualAbsResult);
    Money actualZeroResult = adjustmentValue.zero();
    assertEquals(adjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder)}.
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"
  })
  public void testNewPromotableOrderAdjustmentImpl2() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("-2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    assertEquals(new BigDecimal("-2.30"), adjustmentValue.getAmount());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = adjustmentValue.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    Money absResult = adjustmentValue.abs();
    assertEquals(expectedAmount2, absResult.getAmount());
    Money zeroResult2 = zeroResult.zero();
    assertEquals(zeroResult2, absResult.abs().zero());
    assertEquals(zeroResult2, absResult.zero());
    assertEquals(zeroResult2, zeroResult2);
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
  }

  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder)}.
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"
  })
  public void testNewPromotableOrderAdjustmentImpl3() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    assertEquals(new BigDecimal("0.00"), adjustmentValue.getAmount());
    Money actualAbsResult = adjustmentValue.abs();
    assertEquals(adjustmentValue, actualAbsResult);
    Money actualZeroResult = adjustmentValue.zero();
    assertEquals(adjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder)}.
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"
  })
  public void testNewPromotableOrderAdjustmentImpl4() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    Money absResult = adjustmentValue.abs();
    assertEquals(expectedAmount, absResult.getAmount());
    assertEquals(new BigDecimal("0.00000"), adjustmentValue.getAmount());
    Money absResult2 = absResult.abs();
    Money actualZeroResult = absResult2.zero();
    assertEquals(absResult2, actualZeroResult);
    assertEquals(absResult2, absResult.zero());
    assertEquals(absResult2, adjustmentValue.zero());
  }

  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder)}.
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder)"
  })
  public void testNewPromotableOrderAdjustmentImpl5() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(mock(OfferDiscountType.class));

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer, promotableOrder);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    assertEquals(new BigDecimal("0.00"), adjustmentValue.getAmount());
    Money actualAbsResult = adjustmentValue.abs();
    assertEquals(adjustmentValue, actualAbsResult);
    Money actualZeroResult = adjustmentValue.zero();
    assertEquals(adjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}.
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void testNewPromotableOrderAdjustmentImpl6() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), false);

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(
            promotableCandidateOrderOffer, promotableOrder, new Money());

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order).getOrderItems();
    Money adjustmentValue = actualPromotableOrderAdjustmentImpl.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(826, currency.getNumericCode());
    assertEquals(orderItemList, promotableOrder.allOrderItems);
    Money actualAbsResult = adjustmentValue.abs();
    assertEquals(adjustmentValue, actualAbsResult);
    Money actualZeroResult = adjustmentValue.zero();
    assertEquals(adjustmentValue, actualZeroResult);
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}.
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void testNewPromotableOrderAdjustmentImpl7() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(
            promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertEquals(orderAdjustmentList, promotableOrder.allOrderItems);
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}.
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void testNewPromotableOrderAdjustmentImpl8() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("-2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(
            promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertEquals(orderAdjustmentList, promotableOrder.allOrderItems);
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}.
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void testNewPromotableOrderAdjustmentImpl9() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(
            promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertEquals(orderAdjustmentList, promotableOrder.allOrderItems);
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}.
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void testNewPromotableOrderAdjustmentImpl10() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(mock(OfferDiscountType.class));

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(
            promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertEquals(orderAdjustmentList, promotableOrder.allOrderItems);
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}.
   *
   * <ul>
   *   <li>Then calls {@link InternalNumber#divide(BigDecimal, int, RoundingMode)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotableOrderAdjustmentImpl#PromotableOrderAdjustmentImpl(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableOrderAdjustmentImpl.<init>(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void testNewPromotableOrderAdjustmentImpl_thenCallsDivide() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustmentImpl actualPromotableOrderAdjustmentImpl =
        new PromotableOrderAdjustmentImpl(
            promotableCandidateOrderOffer, promotableOrder, adjustmentValue);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertEquals(orderAdjustmentList, promotableOrder.allOrderItems);
    assertSame(adjustmentValue, actualPromotableOrderAdjustmentImpl.getAdjustmentValue());
    assertSame(promotableOrder, actualPromotableOrderAdjustmentImpl.getPromotableOrder());
  }
}
