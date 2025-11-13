package org.broadleafcommerce.core.order.service.legacy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.MergeCartResponse;
import org.broadleafcommerce.core.order.service.call.ReconstructCartResponse;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LegacyMergeCartServiceImplDiffblueTest {
  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @InjectMocks private LegacyMergeCartServiceImpl legacyMergeCartServiceImpl;

  @Mock private OrderItemService orderItemService;

  @Mock private OrderService orderService;

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code
   * customer}, {@code anonymousCart}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order, boolean)"
  })
  public void testMergeCartWithCustomerAnonymousCartPriceOrder() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(orderItems);
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);
    CustomerImpl customer = new CustomerImpl();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable2);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart, true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualMergeCartResult.getOrder();
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    OrderItem getResult = orderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertTrue(order instanceof OrderImpl);
    assertSame(bundleOrderItemImpl, getResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code
   * customer}, {@code anonymousCart}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order, boolean)"
  })
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_givenEmptyString()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    CustomerImpl customer = new CustomerImpl();
    customer.setEmailAddress("");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable2);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart, true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    assertEquals(0, order.getItemCount());
    assertEquals(1L, order.getId().longValue());
    assertTrue(order.getNonDiscreteOrderItems().isEmpty());
    assertTrue(order.getOrderItems().isEmpty());
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code
   * customer}, {@code anonymousCart}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order, boolean)"
  })
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_thenOrderReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    CustomerImpl customer = new CustomerImpl();
    customer.setEmailAddress("42 Main St");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable2);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart, true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(true));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code
   * customer}, {@code anonymousCart}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return Order Id longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order, boolean)"
  })
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_thenReturnOrderIdLongValueIsOne()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);
    CustomerImpl customer = new CustomerImpl();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable2);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart, true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    assertEquals(0, order.getItemCount());
    assertEquals(1L, order.getId().longValue());
    assertTrue(order.getNonDiscreteOrderItems().isEmpty());
    assertTrue(order.getOrderItems().isEmpty());
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code
   * customer}, {@code anonymousCart}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return Order Id longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order, boolean)"
  })
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_thenReturnOrderIdLongValueIsOne2()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(new CustomerImpl(), null, true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    assertEquals(0, order.getItemCount());
    assertEquals(1L, order.getId().longValue());
    assertTrue(order.getNonDiscreteOrderItems().isEmpty());
    assertTrue(order.getOrderItems().isEmpty());
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code
   * customer}, {@code anonymousCart}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return Order Id longValue is two.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order, boolean)"
  })
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_thenReturnOrderIdLongValueIsTwo()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(2L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);
    CustomerImpl customer = new CustomerImpl();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable2);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart, true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    assertEquals(0, order.getItemCount());
    assertEquals(2L, order.getId().longValue());
    assertTrue(order.getNonDiscreteOrderItems().isEmpty());
    assertTrue(order.getOrderItems().isEmpty());
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code
   * customer}, {@code anonymousCart}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return Order is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order, boolean)"
  })
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_thenReturnOrderIsNull()
      throws PricingException {
    // Arrange
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(null);
    CustomerImpl customer = new CustomerImpl();

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, new NullOrderImpl(), true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    assertNull(actualMergeCartResult.getOrder());
    assertFalse(actualMergeCartResult.isMerged());
    assertTrue(actualMergeCartResult.getAddedItems().isEmpty());
    assertTrue(actualMergeCartResult.getRemovedItems().isEmpty());
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code
   * customer}, {@code anonymousCart}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return Order ItemCount is one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order, boolean)"
  })
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_thenReturnOrderItemCountIsOne()
      throws PricingException {
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(orderItems);
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);
    CustomerImpl customer = new CustomerImpl();

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable3);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart, true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertEquals(1, order.getItemCount());
    assertEquals(orderItems, order.getNonDiscreteOrderItems());
    assertSame(orderItemImpl, orderItems2.get(0));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code
   * customer}, {@code anonymousCart}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then throw {@link PricingException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order, boolean)"
  })
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_thenThrowPricingException()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new PricingException("An error occurred"));
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    CustomerImpl customer = new CustomerImpl();
    customer.setEmailAddress("42 Main St");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable2);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    // Act and Assert
    assertThrows(
        PricingException.class,
        () -> legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart, true));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code
   * customer}, {@code anonymousCart}, {@code priceOrder}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Merged.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order, boolean)"
  })
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_whenNull_thenReturnMerged()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(orderItems);
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(new CustomerImpl(), null, true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualMergeCartResult.getOrder();
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    OrderItem getResult = orderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertTrue(order instanceof OrderImpl);
    assertTrue(actualMergeCartResult.isMerged());
    assertSame(bundleOrderItemImpl, getResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)} with {@code customer},
   * {@code anonymousCart}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart_givenEmptyString() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("");

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable4);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable3);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());
    anonymousCart.setOrderItems(orderItems);

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    assertSame(orderImpl, order);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)} with {@code customer},
   * {@code anonymousCart}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart_givenNull() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress(null);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable4);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable3);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());
    anonymousCart.setOrderItems(orderItems);

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    assertSame(orderImpl, order);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)} with {@code customer},
   * {@code anonymousCart}.
   *
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart_thenOrderReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("not blank");

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable4);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable3);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());
    anonymousCart.setOrderItems(orderItems);

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(true));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)} with {@code customer},
   * {@code anonymousCart}.
   *
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart_thenOrderReturnNullOrderImpl2()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(orderItems);
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("not blank");

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable4);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    ArrayList<OrderItem> orderItems2 = new ArrayList<>();
    orderItems2.add(bundleOrderItemImpl);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable3);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());
    anonymousCart.setOrderItems(orderItems2);

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(true));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)} with {@code customer},
   * {@code anonymousCart}.
   *
   * <ul>
   *   <li>Then return Order is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart_thenReturnOrderIsNull()
      throws PricingException {
    // Arrange
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(null);
    CustomerImpl customer = new CustomerImpl();

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, new NullOrderImpl());

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    assertNull(actualMergeCartResult.getOrder());
    assertFalse(actualMergeCartResult.isMerged());
    assertTrue(actualMergeCartResult.getAddedItems().isEmpty());
    assertTrue(actualMergeCartResult.getRemovedItems().isEmpty());
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)} with {@code customer},
   * {@code anonymousCart}.
   *
   * <ul>
   *   <li>Then return Order is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart_thenReturnOrderIsNull2()
      throws PricingException {
    // Arrange
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("not blank");

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable2);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());
    anonymousCart.setOrderItems(new ArrayList<>());

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    assertNull(actualMergeCartResult.getOrder());
    assertFalse(actualMergeCartResult.isMerged());
    assertTrue(actualMergeCartResult.getAddedItems().isEmpty());
    assertTrue(actualMergeCartResult.getRemovedItems().isEmpty());
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)} with {@code customer},
   * {@code anonymousCart}.
   *
   * <ul>
   *   <li>Then throw {@link PricingException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyMergeCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart_thenThrowPricingException()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new PricingException("An error occurred"));
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable2);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPayments(new ArrayList<>());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setEmailAddress("not blank");

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable4);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl.setHasValidationError(true);
    bundleOrderItemImpl.setId(1L);
    bundleOrderItemImpl.setName("Name");
    bundleOrderItemImpl.setOrder(new NullOrderImpl());
    bundleOrderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl.setPrice(new Money());
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setDiscreteOrderItems(discreteOrderItems);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable3);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());
    anonymousCart.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        PricingException.class,
        () -> legacyMergeCartServiceImpl.mergeCart(customer, anonymousCart));
    verify(orderService).findCartForCustomer(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#reconstructCart(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#reconstructCart(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyMergeCartServiceImpl.reconstructCart(Customer)"
  })
  public void testReconstructCartWithCustomer() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setOrderItems(orderItems);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    ReconstructCartResponse actualReconstructCartResult =
        legacyMergeCartServiceImpl.reconstructCart(new CustomerImpl());

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualReconstructCartResult.getOrder();
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    OrderItem getResult = orderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertTrue(order instanceof OrderImpl);
    assertSame(bundleOrderItemImpl, getResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#reconstructCart(Customer, boolean)} with {@code
   * customer}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#reconstructCart(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyMergeCartServiceImpl.reconstructCart(Customer, boolean)"
  })
  public void testReconstructCartWithCustomerPriceOrder() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setOrderItems(orderItems);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    ReconstructCartResponse actualReconstructCartResult =
        legacyMergeCartServiceImpl.reconstructCart(new CustomerImpl(), true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualReconstructCartResult.getOrder();
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    OrderItem getResult = orderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertTrue(order instanceof OrderImpl);
    assertSame(bundleOrderItemImpl, getResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#reconstructCart(Customer, boolean)} with {@code
   * customer}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return Order is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#reconstructCart(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyMergeCartServiceImpl.reconstructCart(Customer, boolean)"
  })
  public void testReconstructCartWithCustomerPriceOrder_thenReturnOrderIsNull()
      throws PricingException {
    // Arrange
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(null);

    // Act
    ReconstructCartResponse actualReconstructCartResult =
        legacyMergeCartServiceImpl.reconstructCart(new CustomerImpl(), true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    assertNull(actualReconstructCartResult.getOrder());
    assertTrue(actualReconstructCartResult.getRemovedItems().isEmpty());
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#reconstructCart(Customer, boolean)} with {@code
   * customer}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return Order is {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#reconstructCart(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyMergeCartServiceImpl.reconstructCart(Customer, boolean)"
  })
  public void testReconstructCartWithCustomerPriceOrder_thenReturnOrderIsOrderImpl()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    ReconstructCartResponse actualReconstructCartResult =
        legacyMergeCartServiceImpl.reconstructCart(new CustomerImpl(), true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualReconstructCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    assertSame(orderImpl, order);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#reconstructCart(Customer, boolean)} with {@code
   * customer}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return Order ItemCount is one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#reconstructCart(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyMergeCartServiceImpl.reconstructCart(Customer, boolean)"
  })
  public void testReconstructCartWithCustomerPriceOrder_thenReturnOrderItemCountIsOne()
      throws PricingException {
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setOrderItems(orderItems);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    ReconstructCartResponse actualReconstructCartResult =
        legacyMergeCartServiceImpl.reconstructCart(new CustomerImpl(), true);

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualReconstructCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertEquals(1, order.getItemCount());
    assertEquals(orderItems, order.getNonDiscreteOrderItems());
    assertSame(orderItemImpl, orderItems2.get(0));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#reconstructCart(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then return Order is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#reconstructCart(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyMergeCartServiceImpl.reconstructCart(Customer)"
  })
  public void testReconstructCartWithCustomer_thenReturnOrderIsNull() throws PricingException {
    // Arrange
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(null);

    // Act
    ReconstructCartResponse actualReconstructCartResult =
        legacyMergeCartServiceImpl.reconstructCart(new CustomerImpl());

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    assertNull(actualReconstructCartResult.getOrder());
    assertTrue(actualReconstructCartResult.getRemovedItems().isEmpty());
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#reconstructCart(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then return Order is {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#reconstructCart(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyMergeCartServiceImpl.reconstructCart(Customer)"
  })
  public void testReconstructCartWithCustomer_thenReturnOrderIsOrderImpl() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    ReconstructCartResponse actualReconstructCartResult =
        legacyMergeCartServiceImpl.reconstructCart(new CustomerImpl());

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualReconstructCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    assertSame(orderImpl, order);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#reconstructCart(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then return Order ItemCount is one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#reconstructCart(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyMergeCartServiceImpl.reconstructCart(Customer)"
  })
  public void testReconstructCartWithCustomer_thenReturnOrderItemCountIsOne()
      throws PricingException {
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    orderImpl.setOrderItems(orderItems);
    when(orderService.findCartForCustomer(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    ReconstructCartResponse actualReconstructCartResult =
        legacyMergeCartServiceImpl.reconstructCart(new CustomerImpl());

    // Assert
    verify(orderService).findCartForCustomer(isA(Customer.class));
    Order order = actualReconstructCartResult.getOrder();
    assertTrue(order instanceof OrderImpl);
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertEquals(1, order.getItemCount());
    assertEquals(orderItems, order.getNonDiscreteOrderItems());
    assertSame(orderItemImpl, orderItems2.get(0));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testMergeGiftWrapOrderItems() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualMergeGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testMergeGiftWrapOrderItems_givenArrayListAddBundleOrderItemImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(new BundleOrderItemImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualMergeGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testMergeGiftWrapOrderItems_givenArrayListAddDiscreteOrderItemImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(new DiscreteOrderItemImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualMergeGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link GiftWrapOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testMergeGiftWrapOrderItems_givenArrayListAddGiftWrapOrderItemImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(new GiftWrapOrderItemImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualMergeGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse,
   * Order, Map)}.
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testRemoveExpiredGiftWrapOrderItems() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualRemoveExpiredGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualRemoveExpiredGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse,
   * Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testRemoveExpiredGiftWrapOrderItems_givenArrayListAddBundleOrderItemImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(new BundleOrderItemImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualRemoveExpiredGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualRemoveExpiredGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse,
   * Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link GiftWrapOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testRemoveExpiredGiftWrapOrderItems_givenArrayListAddGiftWrapOrderItemImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(new GiftWrapOrderItemImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualRemoveExpiredGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualRemoveExpiredGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}.
   *
   * <ul>
   *   <li>Given {@link LegacyMergeCartServiceImpl} (default constructor).
   *   <li>Then return {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyMergeCartServiceImpl.mergeOfferCodes(Order, Order)"})
  public void testMergeOfferCodes_givenLegacyMergeCartServiceImpl_thenReturnOrderImpl() {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl customerCart = new OrderImpl();
    customerCart.setAdditionalOfferInformation(new HashMap<>());
    customerCart.setAuditable(auditable2);
    customerCart.setCandidateOrderOffers(new ArrayList<>());
    customerCart.setCurrency(new BroadleafCurrencyImpl());
    customerCart.setCustomer(new CustomerImpl());
    customerCart.setEmailAddress("42 Main St");
    customerCart.setFulfillmentGroups(new ArrayList<>());
    customerCart.setId(1L);
    customerCart.setLocale(new LocaleImpl());
    customerCart.setName("Name");
    customerCart.setOrderAttributes(new HashMap<>());
    customerCart.setOrderItems(new ArrayList<>());
    customerCart.setOrderMessages(new ArrayList<>());
    customerCart.setOrderNumber("42");
    customerCart.setPayments(new ArrayList<>());
    customerCart.setStatus(OrderStatus.ARCHIVED);
    customerCart.setSubTotal(new Money());
    customerCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerCart.setTaxOverride(true);
    customerCart.setTotal(new Money());
    customerCart.setTotalFulfillmentCharges(new Money());
    customerCart.setTotalTax(new Money());

    // Act
    Order actualMergeOfferCodesResult =
        legacyMergeCartServiceImpl.mergeOfferCodes(anonymousCart, customerCart);

    // Assert
    assertSame(customerCart, actualMergeOfferCodesResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}.
   *
   * <ul>
   *   <li>Given {@link LegacyMergeCartServiceImpl} (default constructor).
   *   <li>Then return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyMergeCartServiceImpl.mergeOfferCodes(Order, Order)"})
  public void testMergeOfferCodes_givenLegacyMergeCartServiceImpl_thenReturnOrderImpl2() {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl customerCart = new OrderImpl();
    OfferCodeImpl offerCode = new OfferCodeImpl();
    customerCart.addAddedOfferCode(offerCode);
    customerCart.setAdditionalOfferInformation(new HashMap<>());
    customerCart.setAuditable(auditable2);
    customerCart.setCandidateOrderOffers(new ArrayList<>());
    customerCart.setCurrency(new BroadleafCurrencyImpl());
    customerCart.setCustomer(new CustomerImpl());
    customerCart.setEmailAddress("42 Main St");
    customerCart.setFulfillmentGroups(new ArrayList<>());
    customerCart.setId(1L);
    customerCart.setLocale(new LocaleImpl());
    customerCart.setName("Name");
    customerCart.setOrderAttributes(new HashMap<>());
    customerCart.setOrderItems(new ArrayList<>());
    customerCart.setOrderMessages(new ArrayList<>());
    customerCart.setOrderNumber("42");
    customerCart.setPayments(new ArrayList<>());
    customerCart.setStatus(OrderStatus.ARCHIVED);
    customerCart.setSubTotal(new Money());
    customerCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerCart.setTaxOverride(true);
    customerCart.setTotal(new Money());
    customerCart.setTotalFulfillmentCharges(new Money());
    customerCart.setTotalTax(new Money());

    // Act
    Order actualMergeOfferCodesResult =
        legacyMergeCartServiceImpl.mergeOfferCodes(anonymousCart, customerCart);

    // Assert
    assertTrue(actualMergeOfferCodesResult instanceof OrderImpl);
    List<OfferCode> addedOfferCodes = actualMergeOfferCodesResult.getAddedOfferCodes();
    assertEquals(1, addedOfferCodes.size());
    assertSame(offerCode, addedOfferCodes.get(0));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}.
   *
   * <ul>
   *   <li>Given {@link LegacyMergeCartServiceImpl} (default constructor).
   *   <li>Then return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyMergeCartServiceImpl.mergeOfferCodes(Order, Order)"})
  public void testMergeOfferCodes_givenLegacyMergeCartServiceImpl_thenReturnOrderImpl3() {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.addAddedOfferCode(new OfferCodeImpl());
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl customerCart = new OrderImpl();
    OfferCodeImpl offerCode = new OfferCodeImpl();
    customerCart.addAddedOfferCode(offerCode);
    customerCart.setAdditionalOfferInformation(new HashMap<>());
    customerCart.setAuditable(auditable2);
    customerCart.setCandidateOrderOffers(new ArrayList<>());
    customerCart.setCurrency(new BroadleafCurrencyImpl());
    customerCart.setCustomer(new CustomerImpl());
    customerCart.setEmailAddress("42 Main St");
    customerCart.setFulfillmentGroups(new ArrayList<>());
    customerCart.setId(1L);
    customerCart.setLocale(new LocaleImpl());
    customerCart.setName("Name");
    customerCart.setOrderAttributes(new HashMap<>());
    customerCart.setOrderItems(new ArrayList<>());
    customerCart.setOrderMessages(new ArrayList<>());
    customerCart.setOrderNumber("42");
    customerCart.setPayments(new ArrayList<>());
    customerCart.setStatus(OrderStatus.ARCHIVED);
    customerCart.setSubTotal(new Money());
    customerCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerCart.setTaxOverride(true);
    customerCart.setTotal(new Money());
    customerCart.setTotalFulfillmentCharges(new Money());
    customerCart.setTotalTax(new Money());

    // Act
    Order actualMergeOfferCodesResult =
        legacyMergeCartServiceImpl.mergeOfferCodes(anonymousCart, customerCart);

    // Assert
    assertTrue(actualMergeOfferCodesResult instanceof OrderImpl);
    List<OfferCode> addedOfferCodes = actualMergeOfferCodesResult.getAddedOfferCodes();
    assertEquals(1, addedOfferCodes.size());
    assertSame(offerCode, addedOfferCodes.get(0));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeRegularOrderItems(Order, MergeCartResponse, Order,
   * Map)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeRegularOrderItems(Order,
   * MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.mergeRegularOrderItems(Order, MergeCartResponse, Order, Map)"
  })
  public void testMergeRegularOrderItems_thenReturnNullOrderImpl() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeRegularOrderItemsResult =
        legacyMergeCartServiceImpl.mergeRegularOrderItems(
            anonymousCart, mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualMergeRegularOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#addOrderItemToOrder(Order, OrderItem, Boolean)}.
   *
   * <ul>
   *   <li>Then {@link BundleOrderItemImpl} (default constructor) CurrencyCode is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#addOrderItemToOrder(Order, OrderItem,
   * Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyMergeCartServiceImpl.addOrderItemToOrder(Order, OrderItem, Boolean)"
  })
  public void testAddOrderItemToOrder_thenBundleOrderItemImplCurrencyCodeIsNull()
      throws PricingException {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

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
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    order.setOrderItems(orderItems);
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
    BundleOrderItemImpl newOrderItem = new BundleOrderItemImpl();

    // Act
    OrderItem actualAddOrderItemToOrderResult =
        legacyMergeCartServiceImpl.addOrderItemToOrder(order, newOrderItem, true);

    // Assert
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    assertNull(newOrderItem.getCurrencyCode());
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertSame(orderItems, orderItems2);
    assertSame(bundleOrderItemImpl, actualAddOrderItemToOrderResult);
    assertSame(order, newOrderItem.getOrder());
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#addOrderItemToOrder(Order, OrderItem, Boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link PricingException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#addOrderItemToOrder(Order, OrderItem,
   * Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItem LegacyMergeCartServiceImpl.addOrderItemToOrder(Order, OrderItem, Boolean)"
  })
  public void testAddOrderItemToOrder_thenThrowPricingException() throws PricingException {
    // Arrange
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new PricingException("An error occurred"));

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
    order.setCurrency(new BroadleafCurrencyImpl());
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

    // Act and Assert
    assertThrows(
        PricingException.class,
        () ->
            legacyMergeCartServiceImpl.addOrderItemToOrder(order, new BundleOrderItemImpl(), true));
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#removeItemFromOrder(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.removeItemFromOrder(Order, OrderItem, boolean)"
  })
  public void testRemoveItemFromOrder_thenReturnNullOrderImpl() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
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
    order.setOrderItems(orderItems);

    // Act
    Order actualRemoveItemFromOrderResult =
        legacyMergeCartServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(), true);

    // Assert
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    assertSame(nullOrderImpl, actualRemoveItemFromOrderResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#removeItemFromOrder(Order, OrderItem, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link PricingException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#removeItemFromOrder(Order, OrderItem,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.removeItemFromOrder(Order, OrderItem, boolean)"
  })
  public void testRemoveItemFromOrder_thenThrowPricingException() throws PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenThrow(new PricingException("An error occurred"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertThrows(
        PricingException.class,
        () ->
            legacyMergeCartServiceImpl.removeItemFromOrder(order, new BundleOrderItemImpl(), true));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
  }

  /**
   * Test new {@link LegacyMergeCartServiceImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * LegacyMergeCartServiceImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyMergeCartServiceImpl.<init>()"})
  public void testNewLegacyMergeCartServiceImpl() {
    // Arrange, Act and Assert
    assertNull(new LegacyMergeCartServiceImpl().fulfillmentGroupService);
  }
}
