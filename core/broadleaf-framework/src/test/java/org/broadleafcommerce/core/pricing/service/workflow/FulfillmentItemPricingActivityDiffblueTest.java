package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FulfillmentItemPricingActivity.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentItemPricingActivityDiffblueTest {
  @Autowired private FulfillmentItemPricingActivity fulfillmentItemPricingActivity;

  /**
   * Test {@link FulfillmentItemPricingActivity#getCurrency(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#getCurrency(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafCurrency FulfillmentItemPricingActivity.getCurrency(FulfillmentGroup)"
  })
  public void testGetCurrency_givenNullOrderImpl_thenReturnNull() {
    // Arrange
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    BroadleafCurrency actualCurrency = fulfillmentItemPricingActivity.getCurrency(fg);

    // Assert
    verify(fg).getOrder();
    assertNull(actualCurrency);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);

    // Act
    Money actualOrderSavingsToDistribute =
        fulfillmentItemPricingActivity.getOrderSavingsToDistribute(order);

    // Assert
    verify(currency, atLeast(1)).getCurrencyCode();
    Currency currency2 = actualOrderSavingsToDistribute.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualOrderSavingsToDistribute.abs();
    assertEquals(actualOrderSavingsToDistribute, actualAbsResult);
    Money actualZeroResult = actualOrderSavingsToDistribute.zero();
    assertEquals(actualOrderSavingsToDistribute, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(null);
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);

    // Act
    Money actualOrderSavingsToDistribute =
        fulfillmentItemPricingActivity.getOrderSavingsToDistribute(order);

    // Assert
    verify(currency, atLeast(1)).getCurrencyCode();
    Currency currency2 = actualOrderSavingsToDistribute.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualOrderSavingsToDistribute.abs();
    assertEquals(actualOrderSavingsToDistribute, actualAbsResult);
    Money actualZeroResult = actualOrderSavingsToDistribute.zero();
    assertEquals(actualOrderSavingsToDistribute, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#lessThan(Money)} return {@code false}.
   *   <li>Then calls {@link Money#lessThan(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute_givenMoneyLessThanReturnFalse_thenCallsLessThan() {
    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity =
        new FulfillmentItemPricingActivity();

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(false);

    Order order = mock(Order.class);
    when(order.getSubTotal()).thenReturn(money);
    Money money2 = new Money();
    when(order.getOrderAdjustmentsValue()).thenReturn(money2);

    // Act
    Money actualOrderSavingsToDistribute =
        fulfillmentItemPricingActivity.getOrderSavingsToDistribute(order);

    // Assert
    verify(money).lessThan(isA(Money.class));
    verify(order, atLeast(1)).getOrderAdjustmentsValue();
    verify(order).getSubTotal();
    assertSame(money2, actualOrderSavingsToDistribute);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   *
   * <ul>
   *   <li>Then calls {@link Order#getCurrency()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute_thenCallsGetCurrency() {
    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity =
        new FulfillmentItemPricingActivity();

    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);

    Order order = mock(Order.class);
    when(order.getSubTotal()).thenReturn(money);
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustmentsValue()).thenReturn(new Money());

    // Act
    fulfillmentItemPricingActivity.getOrderSavingsToDistribute(order);

    // Assert
    verify(money).lessThan(isA(Money.class));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustmentsValue();
    verify(order).getSubTotal();
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute_whenNullOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertSame(
        Money.ZERO,
        fulfillmentItemPricingActivity.getOrderSavingsToDistribute(new NullOrderImpl()));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute_whenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    Money subTotal = new Money();
    order.setSubTotal(subTotal);
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    // Act and Assert
    assertEquals(subTotal, fulfillmentItemPricingActivity.getOrderSavingsToDistribute(order));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor) SubTotal is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#getOrderSavingsToDistribute(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getOrderSavingsToDistribute(Order)"})
  public void testGetOrderSavingsToDistribute_whenOrderImplSubTotalIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(null);
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    Money orderTotal = new Money();
    order.setTotal(orderTotal);
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    // Act and Assert
    assertEquals(orderTotal, fulfillmentItemPricingActivity.getOrderSavingsToDistribute(order));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.
   *   <li>Then calls {@link Money#getAmount()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentItemPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenMoneySubtractReturnMoney_thenCallsGetAmount() throws Exception {
    // Arrange
    Money money = mock(Money.class);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(money);

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
    verify(money).getAmount();
    verify(money).subtract(isA(Money.class));
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getHasOrderAdjustments();
    verify(nullOrderImpl, atLeast(1)).getOrderAdjustmentsValue();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getOrderAdjustmentsValue()} return
   *       {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentItemPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenNullOrderImplGetOrderAdjustmentsValueReturnMoney() throws Exception {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(new Money());

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getHasOrderAdjustments();
    verify(nullOrderImpl, atLeast(1)).getOrderAdjustmentsValue();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getOrderAdjustmentsValue()} return
   *       {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentItemPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenNullOrderImplGetOrderAdjustmentsValueReturnMoney2()
      throws Exception {
    // Arrange
    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(new Money());

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getHasOrderAdjustments();
    verify(nullOrderImpl, atLeast(1)).getOrderAdjustmentsValue();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} {@link NullOrderImpl#getOrderAdjustmentsValue()} return
   *       {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentItemPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenNullOrderImplGetOrderAdjustmentsValueReturnMoneyWithAmountIsTen()
      throws Exception {
    // Arrange
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    when(nullOrderImpl.getHasOrderAdjustments()).thenReturn(true);
    when(nullOrderImpl.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(nullOrderImpl.getCurrency()).thenReturn(null);
    when(nullOrderImpl.getOrderAdjustmentsValue()).thenReturn(new Money(10.0d));

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(nullOrderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
    verify(nullOrderImpl, atLeast(1)).getCurrency();
    verify(nullOrderImpl, atLeast(1)).getFulfillmentGroups();
    verify(nullOrderImpl).getHasOrderAdjustments();
    verify(nullOrderImpl, atLeast(1)).getOrderAdjustmentsValue();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).
   *   <li>Then SeedData return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext FulfillmentItemPricingActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderImpl_thenSeedDataReturnOrderImpl() throws Exception {
    // Arrange
    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    OrderImpl orderImpl = new OrderImpl();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = fulfillmentItemPricingActivity.execute(context);

    // Assert
    Order seedData = actualExecuteResult.getSeedData();
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(orderImpl, seedData);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link NullOrderImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.populateItemTotalAmount(Order, Map)"})
  public void testPopulateItemTotalAmount_givenOrderItemImplOrderIsNullOrderImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    doNothing().when(fulfillmentGroupItemImpl).setTotalItemAmount(Mockito.<Money>any());
    when(fulfillmentGroupItemImpl.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(orderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    fulfillmentItemPricingActivity.populateItemTotalAmount(order, new HashMap<>());

    // Assert
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getQuantity();
    verify(fulfillmentGroupItemImpl).setTotalItemAmount(isA(Money.class));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Price is {@code null}.
   *   <li>Then calls {@link FulfillmentGroupItemImpl#getOrderItem()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.populateItemTotalAmount(Order, Map)"})
  public void testPopulateItemTotalAmount_givenOrderItemImplPriceIsNull_thenCallsGetOrderItem() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(null);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    doNothing().when(fulfillmentGroupItemImpl).setTotalItemAmount(Mockito.<Money>any());
    when(fulfillmentGroupItemImpl.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(orderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    fulfillmentItemPricingActivity.populateItemTotalAmount(order, new HashMap<>());

    // Assert
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getQuantity();
    verify(fulfillmentGroupItemImpl).setTotalItemAmount(isA(Money.class));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Quantity is two.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.populateItemTotalAmount(Order, Map)"})
  public void testPopulateItemTotalAmount_givenOrderItemImplQuantityIsTwo() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(2);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    doNothing().when(fulfillmentGroupItemImpl).setTotalItemAmount(Mockito.<Money>any());
    when(fulfillmentGroupItemImpl.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(orderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    fulfillmentItemPricingActivity.populateItemTotalAmount(order, new HashMap<>());

    // Assert
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getQuantity();
    verify(fulfillmentGroupItemImpl).setTotalItemAmount(isA(Money.class));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#populateItemTotalAmount(Order,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.populateItemTotalAmount(Order, Map)"})
  public void testPopulateItemTotalAmount_thenCallsGetCurrencyCode() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(order);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    doNothing().when(fulfillmentGroupItemImpl).setTotalItemAmount(Mockito.<Money>any());
    when(fulfillmentGroupItemImpl.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(orderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order2 = new OrderImpl();
    order2.setAdditionalOfferInformation(new HashMap<>());
    order2.setAuditable(auditable);
    order2.setCandidateOrderOffers(new ArrayList<>());
    order2.setCurrency(new BroadleafCurrencyImpl());
    order2.setCustomer(new CustomerImpl());
    order2.setEmailAddress("42 Main St");
    order2.setId(1L);
    order2.setLocale(new LocaleImpl());
    order2.setName("Name");
    order2.setOrderAttributes(new HashMap<>());
    order2.setOrderItems(new ArrayList<>());
    order2.setOrderMessages(new ArrayList<>());
    order2.setOrderNumber("42");
    order2.setPayments(new ArrayList<>());
    order2.setStatus(OrderStatus.ARCHIVED);
    order2.setSubTotal(new Money());
    order2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order2.setTaxOverride(true);
    order2.setTotal(new Money());
    order2.setTotalFulfillmentCharges(new Money());
    order2.setTotalTax(new Money());
    order2.setFulfillmentGroups(fulfillmentGroups);

    // Act
    fulfillmentItemPricingActivity.populateItemTotalAmount(order2, new HashMap<>());

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getQuantity();
    verify(fulfillmentGroupItemImpl).setTotalItemAmount(isA(Money.class));
    verify(order, atLeast(1)).getCurrency();
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}.
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixItemTotalRoundingIssues(Order, Map)"})
  public void testFixItemTotalRoundingIssues() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getTotalPrice()).thenReturn(new Money(10.0d));

    HashMap<OrderItem, List<FulfillmentGroupItem>> partialOrderItemMap = new HashMap<>();
    partialOrderItemMap.put(bundleOrderItemImpl, new ArrayList<>());

    // Act
    fulfillmentItemPricingActivity.fixItemTotalRoundingIssues(order, partialOrderItemMap);

    // Assert
    verify(bundleOrderItemImpl).getTotalPrice();
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getTotalPrice()} return
   *       {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixItemTotalRoundingIssues(Order, Map)"})
  public void testFixItemTotalRoundingIssues_givenBundleOrderItemImplGetTotalPriceReturnMoney() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getTotalPrice()).thenReturn(new Money());

    HashMap<OrderItem, List<FulfillmentGroupItem>> partialOrderItemMap = new HashMap<>();
    partialOrderItemMap.put(bundleOrderItemImpl, new ArrayList<>());

    // Act
    fulfillmentItemPricingActivity.fixItemTotalRoundingIssues(order, partialOrderItemMap);

    // Assert
    verify(bundleOrderItemImpl).getTotalPrice();
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.
   *   <li>Then calls {@link Money#subtract(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#fixItemTotalRoundingIssues(Order,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.fixItemTotalRoundingIssues(Order, Map)"})
  public void testFixItemTotalRoundingIssues_givenMoneySubtractReturnMoney_thenCallsSubtract() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getTotalPrice()).thenReturn(money);

    HashMap<OrderItem, List<FulfillmentGroupItem>> partialOrderItemMap = new HashMap<>();
    partialOrderItemMap.put(bundleOrderItemImpl, new ArrayList<>());

    // Act
    fulfillmentItemPricingActivity.fixItemTotalRoundingIssues(order, partialOrderItemMap);

    // Assert
    verify(money).subtract(isA(Money.class));
    verify(bundleOrderItemImpl).getTotalPrice();
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money FulfillmentItemPricingActivity.calculateTotalPriceForAllFulfillmentItems(Order)"
  })
  public void testCalculateTotalPriceForAllFulfillmentItems() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setCurrency(currency);

    // Act
    Money actualCalculateTotalPriceForAllFulfillmentItemsResult =
        fulfillmentItemPricingActivity.calculateTotalPriceForAllFulfillmentItems(order);

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualCalculateTotalPriceForAllFulfillmentItemsResult.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualCalculateTotalPriceForAllFulfillmentItemsResult.abs();
    assertEquals(actualCalculateTotalPriceForAllFulfillmentItemsResult, actualAbsResult);
    Money actualZeroResult = actualCalculateTotalPriceForAllFulfillmentItemsResult.zero();
    assertEquals(actualCalculateTotalPriceForAllFulfillmentItemsResult, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}.
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money FulfillmentItemPricingActivity.calculateTotalPriceForAllFulfillmentItems(Order)"
  })
  public void testCalculateTotalPriceForAllFulfillmentItems2() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setCurrency(currency);

    // Act
    Money actualCalculateTotalPriceForAllFulfillmentItemsResult =
        fulfillmentItemPricingActivity.calculateTotalPriceForAllFulfillmentItems(order);

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualCalculateTotalPriceForAllFulfillmentItemsResult.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualCalculateTotalPriceForAllFulfillmentItemsResult.abs();
    assertEquals(actualCalculateTotalPriceForAllFulfillmentItemsResult, actualAbsResult);
    Money actualZeroResult = actualCalculateTotalPriceForAllFulfillmentItemsResult.zero();
    assertEquals(actualCalculateTotalPriceForAllFulfillmentItemsResult, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#calculateTotalPriceForAllFulfillmentItems(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money FulfillmentItemPricingActivity.calculateTotalPriceForAllFulfillmentItems(Order)"
  })
  public void testCalculateTotalPriceForAllFulfillmentItems_whenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        Money.ZERO,
        fulfillmentItemPricingActivity.calculateTotalPriceForAllFulfillmentItems(new OrderImpl()));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}.
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money FulfillmentItemPricingActivity.distributeOrderSavingsToItems(Order, BigDecimal)"
  })
  public void testDistributeOrderSavingsToItems() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setCurrency(currency);

    // Act
    Money actualDistributeOrderSavingsToItemsResult =
        fulfillmentItemPricingActivity.distributeOrderSavingsToItems(order, new BigDecimal("2.3"));

    // Assert
    verify(currency, atLeast(1)).getCurrencyCode();
    Currency currency2 = actualDistributeOrderSavingsToItemsResult.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualDistributeOrderSavingsToItemsResult.abs();
    assertEquals(actualDistributeOrderSavingsToItemsResult, actualAbsResult);
    Money actualZeroResult = actualDistributeOrderSavingsToItemsResult.zero();
    assertEquals(actualDistributeOrderSavingsToItemsResult, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#distributeOrderSavingsToItems(Order, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money FulfillmentItemPricingActivity.distributeOrderSavingsToItems(Order, BigDecimal)"
  })
  public void testDistributeOrderSavingsToItems_whenOrderImpl_thenReturnZero() {
    // Arrange
    OrderImpl order = new OrderImpl();

    // Act
    Money actualDistributeOrderSavingsToItemsResult =
        fulfillmentItemPricingActivity.distributeOrderSavingsToItems(order, new BigDecimal("2.3"));

    // Assert
    assertEquals(Money.ZERO, actualDistributeOrderSavingsToItemsResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(Order, Money)"
  })
  public void testFixOrderSavingsRoundingIssues() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustmentsValue()).thenReturn(new Money());
    when(order.getHasOrderAdjustments()).thenReturn(true);

    // Act
    fulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(order, new Money());

    // Assert
    verify(order).getHasOrderAdjustments();
    verify(order).getOrderAdjustmentsValue();
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(Order, Money)"
  })
  public void testFixOrderSavingsRoundingIssues_givenArrayListAddFulfillmentGroupImpl() {
    // Arrange
    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getOrderAdjustmentsValue()).thenReturn(new Money(10.0d));
    when(order.getHasOrderAdjustments()).thenReturn(true);

    // Act
    fulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(order, new Money());

    // Assert
    verify(order).getFulfillmentGroups();
    verify(order).getHasOrderAdjustments();
    verify(order).getOrderAdjustmentsValue();
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   *
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(Order, Money)"
  })
  public void testFixOrderSavingsRoundingIssues_thenCallsGetFulfillmentGroups() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustmentsValue()).thenReturn(new Money(10.0d));
    when(order.getHasOrderAdjustments()).thenReturn(true);

    // Act
    fulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(order, new Money());

    // Assert
    verify(order).getFulfillmentGroups();
    verify(order).getHasOrderAdjustments();
    verify(order).getOrderAdjustmentsValue();
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}.
   *
   * <ul>
   *   <li>Then calls {@link Money#subtract(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#fixOrderSavingsRoundingIssues(Order, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(Order, Money)"
  })
  public void testFixOrderSavingsRoundingIssues_thenCallsSubtract() {
    // Arrange
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustmentsValue()).thenReturn(money);
    when(order.getHasOrderAdjustments()).thenReturn(true);

    // Act
    fulfillmentItemPricingActivity.fixOrderSavingsRoundingIssues(order, new Money());

    // Assert
    verify(money).subtract(isA(Money.class));
    verify(order).getHasOrderAdjustments();
    verify(order).getOrderAdjustmentsValue();
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.updateTaxableAmountsOnItems(Order)"})
  public void testUpdateTaxableAmountsOnItems() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount()).thenReturn(new Money());
    when(fulfillmentGroupItemImpl.getTotalItemAmount()).thenReturn(new Money());
    doNothing().when(fulfillmentGroupItemImpl).setTotalItemTaxableAmount(Mockito.<Money>any());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setCurrency(null);

    // Act
    fulfillmentItemPricingActivity.updateTaxableAmountsOnItems(order);

    // Assert
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getProratedOrderAdjustmentAmount();
    verify(fulfillmentGroupItemImpl).getTotalItemAmount();
    verify(fulfillmentGroupItemImpl).setTotalItemTaxableAmount(isA(Money.class));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.updateTaxableAmountsOnItems(Order)"})
  public void testUpdateTaxableAmountsOnItems2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount()).thenReturn(null);
    when(fulfillmentGroupItemImpl.getTotalItemAmount()).thenReturn(new Money());
    doNothing().when(fulfillmentGroupItemImpl).setTotalItemTaxableAmount(Mockito.<Money>any());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setCurrency(null);

    // Act
    fulfillmentItemPricingActivity.updateTaxableAmountsOnItems(order);

    // Assert
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getProratedOrderAdjustmentAmount();
    verify(fulfillmentGroupItemImpl).getTotalItemAmount();
    verify(fulfillmentGroupItemImpl).setTotalItemTaxableAmount(isA(Money.class));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.
   *   <li>Then calls {@link Money#subtract(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.updateTaxableAmountsOnItems(Order)"})
  public void testUpdateTaxableAmountsOnItems_givenMoneySubtractReturnMoney_thenCallsSubtract() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getProratedOrderAdjustmentAmount()).thenReturn(mock(Money.class));
    when(fulfillmentGroupItemImpl.getTotalItemAmount()).thenReturn(money);
    doNothing().when(fulfillmentGroupItemImpl).setTotalItemTaxableAmount(Mockito.<Money>any());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setCurrency(null);

    // Act
    fulfillmentItemPricingActivity.updateTaxableAmountsOnItems(order);

    // Assert
    verify(money).subtract(isA(Money.class));
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getProratedOrderAdjustmentAmount();
    verify(fulfillmentGroupItemImpl).getTotalItemAmount();
    verify(fulfillmentGroupItemImpl).setTotalItemTaxableAmount(isA(Money.class));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#isTaxable()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#updateTaxableAmountsOnItems(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentItemPricingActivity.updateTaxableAmountsOnItems(Order)"})
  public void testUpdateTaxableAmountsOnItems_thenCallsIsTaxable() {
    // Arrange
    FulfillmentItemPricingActivity fulfillmentItemPricingActivity =
        new FulfillmentItemPricingActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isTaxable()).thenReturn(false);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    doNothing().when(fulfillmentGroupItemImpl).setTotalItemTaxableAmount(Mockito.<Money>any());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setCurrency(null);

    // Act
    fulfillmentItemPricingActivity.updateTaxableAmountsOnItems(order);

    // Assert
    verify(bundleOrderItemImpl).isTaxable();
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).setTotalItemTaxableAmount(isA(Money.class));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#sumItemAmount(List, Order)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#sumItemAmount(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.sumItemAmount(List, Order)"})
  public void testSumItemAmount_whenArrayList_thenReturnZero() {
    // Arrange
    ArrayList<FulfillmentGroupItem> items = new ArrayList<>();

    // Act and Assert
    assertEquals(
        Money.ZERO, fulfillmentItemPricingActivity.sumItemAmount(items, new NullOrderImpl()));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#sumTaxAmount(List, Order)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#sumTaxAmount(List, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.sumTaxAmount(List, Order)"})
  public void testSumTaxAmount_whenArrayList_thenReturnZero() {
    // Arrange
    ArrayList<FulfillmentGroupItem> items = new ArrayList<>();

    // Act and Assert
    assertEquals(
        Money.ZERO, fulfillmentItemPricingActivity.sumTaxAmount(items, new NullOrderImpl()));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#countNumberOfUnits(Money)}.
   *
   * <ul>
   *   <li>Then return one thousand.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#countNumberOfUnits(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long FulfillmentItemPricingActivity.countNumberOfUnits(Money)"})
  public void testCountNumberOfUnits_thenReturnOneThousand()
      throws IOException, ClassNotFoundException {
    // Arrange
    ObjectInputStream in = mock(ObjectInputStream.class);
    when(in.readFloat()).thenReturn(10.0f);

    Money difference = new Money();
    difference.readExternal(in);

    // Act
    long actualCountNumberOfUnitsResult =
        fulfillmentItemPricingActivity.countNumberOfUnits(difference);

    // Assert
    verify(in).readFloat();
    assertEquals(1000L, actualCountNumberOfUnitsResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#countNumberOfUnits(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#countNumberOfUnits(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long FulfillmentItemPricingActivity.countNumberOfUnits(Money)"})
  public void testCountNumberOfUnits_whenMoney_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, fulfillmentItemPricingActivity.countNumberOfUnits(new Money()));
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is {@code -0.5}.
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code -0.01}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getUnitAmount(Money)"})
  public void testGetUnitAmount_whenMoneyWithAmountIs05_thenReturnAmountIsBigDecimalWith001() {
    // Arrange and Act
    Money actualUnitAmount = fulfillmentItemPricingActivity.getUnitAmount(new Money(-0.5d));

    // Assert
    assertEquals(new BigDecimal("-0.01"), actualUnitAmount.getAmount());
    BigDecimal expectedAmount = new BigDecimal("0.01");
    Money absResult = actualUnitAmount.abs();
    assertEquals(expectedAmount, absResult.getAmount());
    assertEquals(absResult.abs(), absResult.abs());
    Money money = Money.ZERO;
    assertEquals(money, absResult.zero());
    assertEquals(money, actualUnitAmount.zero());
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with {@code 0.01}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentItemPricingActivity#getUnitAmount(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentItemPricingActivity.getUnitAmount(Money)"})
  public void testGetUnitAmount_whenMoney_thenReturnAmountIsBigDecimalWith001() {
    // Arrange
    Money difference = new Money();

    // Act
    Money actualUnitAmount = fulfillmentItemPricingActivity.getUnitAmount(difference);

    // Assert
    assertEquals(new BigDecimal("0.01"), actualUnitAmount.getAmount());
    assertEquals(difference, actualUnitAmount.zero());
    Money actualAbsResult = actualUnitAmount.abs();
    assertEquals(actualUnitAmount, actualAbsResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long,
   * Money)}.
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FulfillmentItemPricingActivity.applyDifferenceToAmount(FulfillmentGroupItem, long, Money)"
  })
  public void testApplyDifferenceToAmount() {
    // Arrange
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getTotalItemAmount()).thenReturn(new Money());
    doNothing().when(fgItem).setTotalItemAmount(Mockito.<Money>any());
    fgItem.setTotalItemAmount(null);

    Money unitAmount = mock(Money.class);
    when(unitAmount.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());

    // Act
    long actualApplyDifferenceToAmountResult =
        fulfillmentItemPricingActivity.applyDifferenceToAmount(fgItem, 1L, unitAmount);

    // Assert
    verify(unitAmount).multiply(isA(BigDecimal.class));
    verify(fgItem).getQuantity();
    verify(fgItem).getTotalItemAmount();
    verify(fgItem, atLeast(1)).setTotalItemAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyDifferenceToAmountResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long,
   * Money)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money#Money()}.
   *   <li>Then calls {@link Money#add(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#applyDifferenceToAmount(FulfillmentGroupItem, long, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FulfillmentItemPricingActivity.applyDifferenceToAmount(FulfillmentGroupItem, long, Money)"
  })
  public void testApplyDifferenceToAmount_givenMoneyAddReturnMoney_thenCallsAdd() {
    // Arrange
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());

    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getTotalItemAmount()).thenReturn(money);
    doNothing().when(fgItem).setTotalItemAmount(Mockito.<Money>any());
    fgItem.setTotalItemAmount(null);

    Money unitAmount = mock(Money.class);
    when(unitAmount.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());

    // Act
    long actualApplyDifferenceToAmountResult =
        fulfillmentItemPricingActivity.applyDifferenceToAmount(fgItem, 1L, unitAmount);

    // Assert
    verify(money).add(isA(Money.class));
    verify(unitAmount).multiply(isA(BigDecimal.class));
    verify(fgItem).getQuantity();
    verify(fgItem).getTotalItemAmount();
    verify(fgItem, atLeast(1)).setTotalItemAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyDifferenceToAmountResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem,
   * long, Money)}.
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FulfillmentItemPricingActivity.applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)"
  })
  public void testApplyDifferenceToProratedAdj() {
    // Arrange
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getProratedOrderAdjustmentAmount()).thenReturn(new Money());
    doNothing().when(fgItem).setProratedOrderAdjustmentAmount(Mockito.<Money>any());
    fgItem.setProratedOrderAdjustmentAmount(null);

    Money unitAmount = mock(Money.class);
    when(unitAmount.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());

    // Act
    long actualApplyDifferenceToProratedAdjResult =
        fulfillmentItemPricingActivity.applyDifferenceToProratedAdj(fgItem, 1L, unitAmount);

    // Assert
    verify(unitAmount).multiply(isA(BigDecimal.class));
    verify(fgItem).getProratedOrderAdjustmentAmount();
    verify(fgItem).getQuantity();
    verify(fgItem, atLeast(1)).setProratedOrderAdjustmentAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyDifferenceToProratedAdjResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem,
   * long, Money)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money#Money()}.
   *   <li>Then calls {@link Money#add(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FulfillmentItemPricingActivity.applyDifferenceToProratedAdj(FulfillmentGroupItem, long, Money)"
  })
  public void testApplyDifferenceToProratedAdj_givenMoneyAddReturnMoney_thenCallsAdd() {
    // Arrange
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());

    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getProratedOrderAdjustmentAmount()).thenReturn(money);
    doNothing().when(fgItem).setProratedOrderAdjustmentAmount(Mockito.<Money>any());
    fgItem.setProratedOrderAdjustmentAmount(null);

    Money unitAmount = mock(Money.class);
    when(unitAmount.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());

    // Act
    long actualApplyDifferenceToProratedAdjResult =
        fulfillmentItemPricingActivity.applyDifferenceToProratedAdj(fgItem, 1L, unitAmount);

    // Assert
    verify(money).add(isA(Money.class));
    verify(unitAmount).multiply(isA(BigDecimal.class));
    verify(fgItem).getProratedOrderAdjustmentAmount();
    verify(fgItem).getQuantity();
    verify(fgItem, atLeast(1)).setProratedOrderAdjustmentAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyDifferenceToProratedAdjResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long,
   * Money)}.
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FulfillmentItemPricingActivity.applyTaxDifference(FulfillmentGroupItem, long, Money)"
  })
  public void testApplyTaxDifference() {
    // Arrange
    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getTotalItemTaxableAmount()).thenReturn(new Money());
    doNothing().when(fgItem).setTotalItemTaxableAmount(Mockito.<Money>any());
    fgItem.setTotalItemTaxableAmount(null);

    Money unitAmount = mock(Money.class);
    when(unitAmount.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());

    // Act
    long actualApplyTaxDifferenceResult =
        fulfillmentItemPricingActivity.applyTaxDifference(fgItem, 1L, unitAmount);

    // Assert
    verify(unitAmount).multiply(isA(BigDecimal.class));
    verify(fgItem).getQuantity();
    verify(fgItem).getTotalItemTaxableAmount();
    verify(fgItem, atLeast(1)).setTotalItemTaxableAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyTaxDifferenceResult);
  }

  /**
   * Test {@link FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long,
   * Money)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money#Money()}.
   *   <li>Then calls {@link Money#add(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentItemPricingActivity#applyTaxDifference(FulfillmentGroupItem, long, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long FulfillmentItemPricingActivity.applyTaxDifference(FulfillmentGroupItem, long, Money)"
  })
  public void testApplyTaxDifference_givenMoneyAddReturnMoney_thenCallsAdd() {
    // Arrange
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());

    FulfillmentGroupItemImpl fgItem = mock(FulfillmentGroupItemImpl.class);
    when(fgItem.getQuantity()).thenReturn(1);
    when(fgItem.getTotalItemTaxableAmount()).thenReturn(money);
    doNothing().when(fgItem).setTotalItemTaxableAmount(Mockito.<Money>any());
    fgItem.setTotalItemTaxableAmount(null);

    Money unitAmount = mock(Money.class);
    when(unitAmount.multiply(Mockito.<BigDecimal>any())).thenReturn(new Money());

    // Act
    long actualApplyTaxDifferenceResult =
        fulfillmentItemPricingActivity.applyTaxDifference(fgItem, 1L, unitAmount);

    // Assert
    verify(money).add(isA(Money.class));
    verify(unitAmount).multiply(isA(BigDecimal.class));
    verify(fgItem).getQuantity();
    verify(fgItem).getTotalItemTaxableAmount();
    verify(fgItem, atLeast(1)).setTotalItemTaxableAmount(Mockito.<Money>any());
    assertEquals(1L, actualApplyTaxDifferenceResult);
  }
}
