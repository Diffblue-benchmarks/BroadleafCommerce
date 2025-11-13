package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.core.offer.domain.CandidateItemOffer;
import org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemAdjustment;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderItemImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemImpl#setAuditable(Auditable)}
   *   <li>{@link OrderItemImpl#setCandidateItemOffers(List)}
   *   <li>{@link OrderItemImpl#setCartMessages(List)}
   *   <li>{@link OrderItemImpl#setChildOrderItems(List)}
   *   <li>{@link OrderItemImpl#setGiftWrapOrderItem(GiftWrapOrderItem)}
   *   <li>{@link OrderItemImpl#setHasValidationError(Boolean)}
   *   <li>{@link OrderItemImpl#setId(Long)}
   *   <li>{@link OrderItemImpl#setName(String)}
   *   <li>{@link OrderItemImpl#setOrder(Order)}
   *   <li>{@link OrderItemImpl#setOrderItemAdjustments(List)}
   *   <li>{@link OrderItemImpl#setOrderItemAttributes(Map)}
   *   <li>{@link OrderItemImpl#setOrderItemPriceDetails(List)}
   *   <li>{@link OrderItemImpl#setOrderItemQualifiers(List)}
   *   <li>{@link OrderItemImpl#setParentOrderItem(OrderItem)}
   *   <li>{@link OrderItemImpl#setPersonalMessage(PersonalMessage)}
   *   <li>{@link OrderItemImpl#setProratedOrderItemAdjustments(List)}
   *   <li>{@link OrderItemImpl#setQuantity(int)}
   *   <li>{@link OrderItemImpl#setTaxable(Boolean)}
   *   <li>{@link OrderItemImpl#getAuditable()}
   *   <li>{@link OrderItemImpl#getCandidateItemOffers()}
   *   <li>{@link OrderItemImpl#getCartMessages()}
   *   <li>{@link OrderItemImpl#getChildOrderItems()}
   *   <li>{@link OrderItemImpl#getId()}
   *   <li>{@link OrderItemImpl#getName()}
   *   <li>{@link OrderItemImpl#getOrder()}
   *   <li>{@link OrderItemImpl#getOrderItemAdjustments()}
   *   <li>{@link OrderItemImpl#getOrderItemAttributes()}
   *   <li>{@link OrderItemImpl#getOrderItemPriceDetails()}
   *   <li>{@link OrderItemImpl#getOrderItemQualifiers()}
   *   <li>{@link OrderItemImpl#getParentOrderItem()}
   *   <li>{@link OrderItemImpl#getPersonalMessage()}
   *   <li>{@link OrderItemImpl#getQuantity()}
   *   <li>{@link OrderItemImpl#isSkuActive()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Auditable OrderItemImpl.getAuditable()",
    "List OrderItemImpl.getCandidateItemOffers()",
    "List OrderItemImpl.getCartMessages()",
    "List OrderItemImpl.getChildOrderItems()",
    "Long OrderItemImpl.getId()",
    "String OrderItemImpl.getName()",
    "Order OrderItemImpl.getOrder()",
    "List OrderItemImpl.getOrderItemAdjustments()",
    "Map OrderItemImpl.getOrderItemAttributes()",
    "List OrderItemImpl.getOrderItemPriceDetails()",
    "List OrderItemImpl.getOrderItemQualifiers()",
    "OrderItem OrderItemImpl.getParentOrderItem()",
    "PersonalMessage OrderItemImpl.getPersonalMessage()",
    "int OrderItemImpl.getQuantity()",
    "boolean OrderItemImpl.isSkuActive()",
    "void OrderItemImpl.setAuditable(Auditable)",
    "void OrderItemImpl.setCandidateItemOffers(List)",
    "void OrderItemImpl.setCartMessages(List)",
    "void OrderItemImpl.setChildOrderItems(List)",
    "void OrderItemImpl.setGiftWrapOrderItem(GiftWrapOrderItem)",
    "void OrderItemImpl.setHasValidationError(Boolean)",
    "void OrderItemImpl.setId(Long)",
    "void OrderItemImpl.setName(String)",
    "void OrderItemImpl.setOrder(Order)",
    "void OrderItemImpl.setOrderItemAdjustments(List)",
    "void OrderItemImpl.setOrderItemAttributes(Map)",
    "void OrderItemImpl.setOrderItemPriceDetails(List)",
    "void OrderItemImpl.setOrderItemQualifiers(List)",
    "void OrderItemImpl.setParentOrderItem(OrderItem)",
    "void OrderItemImpl.setPersonalMessage(PersonalMessage)",
    "void OrderItemImpl.setProratedOrderItemAdjustments(List)",
    "void OrderItemImpl.setQuantity(int)",
    "void OrderItemImpl.setTaxable(Boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderItemImpl orderItemImpl = new OrderItemImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    // Act
    orderItemImpl.setAuditable(auditable);
    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    orderItemImpl.setCandidateItemOffers(candidateItemOffers);
    ArrayList<String> cartMessage = new ArrayList<>();
    orderItemImpl.setCartMessages(cartMessage);
    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    orderItemImpl.setChildOrderItems(childOrderItems);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    Order order = NullOrderFactoryImpl.NULL_ORDER;
    orderItemImpl.setOrder(order);
    ArrayList<OrderItemAdjustment> orderItemAdjustments = new ArrayList<>();
    orderItemImpl.setOrderItemAdjustments(orderItemAdjustments);
    HashMap<String, OrderItemAttribute> orderItemAttributes = new HashMap<>();
    orderItemImpl.setOrderItemAttributes(orderItemAttributes);
    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemImpl.setOrderItemPriceDetails(orderItemPriceDetails);
    ArrayList<OrderItemQualifier> orderItemQualifiers = new ArrayList<>();
    orderItemImpl.setOrderItemQualifiers(orderItemQualifiers);
    BundleOrderItemImpl parentOrderItem = new BundleOrderItemImpl();
    orderItemImpl.setParentOrderItem(parentOrderItem);
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();
    orderItemImpl.setPersonalMessage(personalMessage);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setTaxable(true);
    Auditable actualAuditable = orderItemImpl.getAuditable();
    List<CandidateItemOffer> actualCandidateItemOffers = orderItemImpl.getCandidateItemOffers();
    List<String> actualCartMessages = orderItemImpl.getCartMessages();
    List<OrderItem> actualChildOrderItems = orderItemImpl.getChildOrderItems();
    Long actualId = orderItemImpl.getId();
    String actualName = orderItemImpl.getName();
    Order actualOrder = orderItemImpl.getOrder();
    List<OrderItemAdjustment> actualOrderItemAdjustments = orderItemImpl.getOrderItemAdjustments();
    Map<String, OrderItemAttribute> actualOrderItemAttributes =
        orderItemImpl.getOrderItemAttributes();
    List<OrderItemPriceDetail> actualOrderItemPriceDetails =
        orderItemImpl.getOrderItemPriceDetails();
    List<OrderItemQualifier> actualOrderItemQualifiers = orderItemImpl.getOrderItemQualifiers();
    OrderItem actualParentOrderItem = orderItemImpl.getParentOrderItem();
    PersonalMessage actualPersonalMessage = orderItemImpl.getPersonalMessage();
    int actualQuantity = orderItemImpl.getQuantity();
    boolean actualIsSkuActiveResult = orderItemImpl.isSkuActive();

    // Assert
    assertTrue(actualPersonalMessage instanceof PersonalMessageImpl);
    assertEquals("Name", actualName);
    assertEquals(1, actualQuantity);
    assertTrue(actualCandidateItemOffers.isEmpty());
    assertTrue(actualCartMessages.isEmpty());
    assertTrue(actualChildOrderItems.isEmpty());
    assertTrue(actualIsSkuActiveResult);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(candidateItemOffers, actualCandidateItemOffers);
    assertSame(cartMessage, actualCartMessages);
    assertSame(childOrderItems, actualChildOrderItems);
    assertSame(orderItemAdjustments, actualOrderItemAdjustments);
    assertSame(orderItemPriceDetails, actualOrderItemPriceDetails);
    assertSame(orderItemQualifiers, actualOrderItemQualifiers);
    assertSame(orderItemAttributes, actualOrderItemAttributes);
    assertSame(auditable, actualAuditable);
    assertSame(parentOrderItem, actualParentOrderItem);
    assertSame(personalMessage, actualPersonalMessage);
    assertSame(order, actualOrder);
  }

  /**
   * Test {@link OrderItemImpl#assignFinalPrice()}.
   *
   * <p>Method under test: {@link OrderItemImpl#assignFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.assignFinalPrice()"})
  public void testAssignFinalPrice() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.assignFinalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.price);
    BigDecimal bigDecimal = orderItemImpl.retailPrice;
    assertSame(bigDecimal, orderItemImpl.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAveragePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getRetailPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getSalePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTaxablePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalPrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#assignFinalPrice()}.
   *
   * <p>Method under test: {@link OrderItemImpl#assignFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.assignFinalPrice()"})
  public void testAssignFinalPrice2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.assignFinalPrice();

    // Assert that nothing has changed
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderItemImpl.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAveragePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getRetailPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getSalePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTaxablePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalPrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#assignFinalPrice()}.
   *
   * <p>Method under test: {@link OrderItemImpl#assignFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.assignFinalPrice()"})
  public void testAssignFinalPrice3() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.assignFinalPrice();

    // Assert that nothing has changed
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.price);
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#assignFinalPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) SalePrice is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#assignFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.assignFinalPrice()"})
  public void testAssignFinalPrice_givenOrderItemImplSalePriceIsNull() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(null);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.assignFinalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.price);
    BigDecimal bigDecimal = orderItemImpl.retailPrice;
    assertSame(bigDecimal, orderItemImpl.getAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAverageAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getAveragePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getFutureCreditTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getRetailPrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getSalePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTaxablePrice().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalAdjustmentValue().getAmount());
    assertSame(bigDecimal, orderItemImpl.getTotalPrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#assignFinalPrice()}.
   *
   * <ul>
   *   <li>Then {@link OrderItemImpl} (default constructor) AdjustmentValue Amount is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#assignFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemImpl.assignFinalPrice()"})
  public void testAssignFinalPrice_thenOrderItemImplAdjustmentValueAmountIsBigDecimalWith000() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setQuantity(6);
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setRetailPrice(null);
    orderItemImpl.setOrder(order);

    // Act
    orderItemImpl.assignFinalPrice();

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(new BigDecimal("0.00"), orderItemImpl.getAdjustmentValue().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.getAveragePrice().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.getPrice().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.getTaxablePrice().getAmount());
    assertEquals(new BigDecimal("10.00"), orderItemImpl.price);
    assertEquals(new BigDecimal("60.00"), orderItemImpl.getTotalPrice().getAmount());
    BigDecimal expectedAmount = orderItemImpl.salePrice;
    assertSame(expectedAmount, orderItemImpl.getSalePrice().getAmount());
  }

  /**
   * Test {@link OrderItemImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnCurrencyDisplayNameIsUsDollar() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(null);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setOrder(order);

    // Act
    Money actualConvertToMoneyResult = orderItemImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(840, currency.getNumericCode());
    assertEquals(finalPrice, actualConvertToMoneyResult.abs().zero());
    assertEquals(finalPrice, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link OrderItemImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_whenNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemQualifierImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAdjustments(new ArrayList<>());
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
    order.setCurrency(new BroadleafCurrencyImpl());

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
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
    orderItemImpl.setOrder(order);

    // Act and Assert
    assertNull(orderItemImpl.convertToMoney(null));
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CandidateItemOfferImpl} (default
   *       constructor).
   *   <li>Then return ChildOrderItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_givenArrayListAddCandidateItemOfferImpl_thenReturnChildOrderItemsEmpty() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    candidateItemOffers.add(new CandidateItemOfferImpl());

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
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
    orderItemImpl.setCandidateItemOffers(candidateItemOffers);
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    assertTrue(actualCloneResult.getChildOrderItems().isEmpty());
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) ChildOrderItems is {@code null}.
   *   <li>Then return ChildOrderItems Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_givenOrderItemImplChildOrderItemsIsNull_thenReturnChildOrderItemsEmpty() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    candidateItemOffers.add(new CandidateItemOfferImpl());

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
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
    orderItemImpl.setCandidateItemOffers(candidateItemOffers);
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setChildOrderItems(null);

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    assertTrue(actualCloneResult.getChildOrderItems().isEmpty());
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) OrderItemAttributes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_givenOrderItemImplOrderItemAttributesIsNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    candidateItemOffers.add(new CandidateItemOfferImpl());

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
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
    orderItemImpl.setCandidateItemOffers(candidateItemOffers);
    orderItemImpl.setOrderItemAttributes(null);
    orderItemImpl.setChildOrderItems(new ArrayList<>());

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    assertTrue(actualCloneResult.getChildOrderItems().isEmpty());
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then ChildOrderItems first return {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenChildOrderItemsFirstReturnBundleOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    CandidateItemOfferImpl candidateItemOfferImpl = mock(CandidateItemOfferImpl.class);
    when(candidateItemOfferImpl.clone()).thenReturn(new CandidateItemOfferImpl());

    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    candidateItemOffers.add(candidateItemOfferImpl);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    when(bundleOrderItemImpl.clone()).thenReturn(bundleOrderItemImpl2);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
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
    orderItemImpl.setCandidateItemOffers(candidateItemOffers);
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    verify(candidateItemOfferImpl).clone();
    verify(bundleOrderItemImpl).clone();
    List<OrderItem> childOrderItems2 = actualCloneResult.getChildOrderItems();
    assertEquals(1, childOrderItems2.size());
    OrderItem getResult = childOrderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    assertSame(bundleOrderItemImpl2, getResult);
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then ChildOrderItems first return {@link OrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenChildOrderItemsFirstReturnOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    CandidateItemOfferImpl candidateItemOfferImpl = mock(CandidateItemOfferImpl.class);
    when(candidateItemOfferImpl.clone()).thenReturn(new CandidateItemOfferImpl());

    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    candidateItemOffers.add(candidateItemOfferImpl);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(orderItemImpl);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable);
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();
    orderItemImpl2.setCandidateItemOffers(candidateItemOffers);
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = orderItemImpl2.clone();

    // Assert
    verify(candidateItemOfferImpl).clone();
    List<OrderItem> childOrderItems2 = actualCloneResult.getChildOrderItems();
    assertEquals(1, childOrderItems2.size());
    assertTrue(childOrderItems2.get(0) instanceof OrderItemImpl);
    assertTrue(actualCloneResult instanceof OrderItemImpl);
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return CandidateItemOffers Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenReturnCandidateItemOffersEmpty() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    orderItemImpl.setCandidateItemOffers(null);
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    assertTrue(actualCloneResult.getCandidateItemOffers().isEmpty());
    Money zeroResult = actualCloneResult.getAverageAdjustmentValue().zero();
    assertEquals(finalPrice, zeroResult.zero().abs().abs().abs());
    Money zeroResult2 = zeroResult.abs().zero().zero();
    assertEquals(finalPrice, zeroResult2.abs());
    assertEquals(finalPrice, zeroResult2.zero());
    assertSame(((OrderItemImpl) actualCloneResult).salePrice, zeroResult2.getAmount());
  }

  /**
   * Test {@link OrderItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return OrderItemAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItem OrderItemImpl.clone()"})
  public void testClone_thenReturnOrderItemAttributesSizeIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    CandidateItemOfferImpl candidateItemOfferImpl = mock(CandidateItemOfferImpl.class);
    when(candidateItemOfferImpl.clone()).thenReturn(new CandidateItemOfferImpl());

    ArrayList<CandidateItemOffer> candidateItemOffers = new ArrayList<>();
    candidateItemOffers.add(candidateItemOfferImpl);

    HashMap<String, OrderItemAttribute> orderItemAttributes = new HashMap<>();
    orderItemAttributes.put("foo", new OrderItemAttributeImpl());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.clone()).thenReturn(new BundleOrderItemImpl());

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
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
    orderItemImpl.setCandidateItemOffers(candidateItemOffers);
    orderItemImpl.setOrderItemAttributes(orderItemAttributes);
    orderItemImpl.setChildOrderItems(childOrderItems);

    // Act
    OrderItem actualCloneResult = orderItemImpl.clone();

    // Assert
    verify(candidateItemOfferImpl).clone();
    verify(bundleOrderItemImpl).clone();
    Map<String, OrderItemAttribute> orderItemAttributes2 =
        actualCloneResult.getOrderItemAttributes();
    assertEquals(1, orderItemAttributes2.size());
    OrderItemAttribute getResult = orderItemAttributes2.get(null);
    assertTrue(getResult instanceof OrderItemAttributeImpl);
    assertTrue(actualCloneResult instanceof OrderItemImpl);
    assertNull(getResult.getId());
    assertNull(getResult.toString());
    assertNull(getResult.getName());
    assertNull(getResult.getValue());
    assertSame(actualCloneResult, getResult.getOrderItem());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl2);
    assertEquals(orderItemImpl.hashCode(), orderItemImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl2);
    assertEquals(orderItemImpl.hashCode(), orderItemImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(null);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl2);
    assertEquals(orderItemImpl.hashCode(), orderItemImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}, and {@link OrderItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemImpl#equals(Object)}
   *   <li>{@link OrderItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    // Act and Assert
    assertEquals(orderItemImpl, orderItemImpl);
    int expectedHashCodeResult = orderItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemImpl.hashCode());
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(2L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(null);
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(mock(GiftWrapOrderItemImpl.class));
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(null);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BUNDLE);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(new OrderItemType());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new DiscreteOrderItemImpl());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(null);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(null);
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(mock(PersonalMessageImpl.class));
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money(10.0d));
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(0);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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
    orderItemImpl.setRetailPrice(null);
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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
    orderItemImpl.setRetailPrice(new Money(10.0d));
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(null);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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
    orderItemImpl.setSalePrice(new Money(10.0d));
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl2 = new OrderItemImpl();
    orderItemImpl2.setAuditable(auditable2);
    orderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl2.setCartMessages(new ArrayList<>());
    orderItemImpl2.setChildOrderItems(new ArrayList<>());
    orderItemImpl2.setDiscountingAllowed(true);
    orderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl2.setHasValidationError(true);
    orderItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl2.setName("Name");
    orderItemImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setOrderItemAttributes(new HashMap<>());
    orderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl2.setPrice(new Money());
    orderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl2.setQuantity(1);
    orderItemImpl2.setRetailPrice(new Money());
    orderItemImpl2.setRetailPriceOverride(true);
    orderItemImpl2.setSalePrice(new Money());
    orderItemImpl2.setSalePriceOverride(true);
    orderItemImpl2.setTaxable(true);
    orderItemImpl2.updateSaleAndRetailPrices();

    // Act and Assert
    assertNotEquals(orderItemImpl, orderItemImpl2);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    // Act and Assert
    assertNotEquals(orderItemImpl, null);
  }

  /**
   * Test {@link OrderItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemImpl.equals(Object)", "int OrderItemImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
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

    // Act and Assert
    assertNotEquals(orderItemImpl, "Different type to OrderItemImpl");
  }
}
