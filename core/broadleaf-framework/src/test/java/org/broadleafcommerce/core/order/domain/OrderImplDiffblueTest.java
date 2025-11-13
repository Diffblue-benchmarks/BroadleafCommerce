package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.offer.domain.CandidateOrderOffer;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferInfo;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderImplDiffblueTest {
  @Autowired private OrderImpl orderImpl;

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_givenBundleOrderItemImplOrderIsNull_order_thenReturnZero() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act and Assert
    assertEquals(Money.ZERO, orderImpl.calculateSubTotal());
  }

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_givenOrderImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(Money.ZERO, orderImpl.calculateSubTotal());
  }

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   *
   * <ul>
   *   <li>Then return abs abs abs Amount is {@link OrderItemImpl} (default constructor) {@link
   *       OrderItemImpl#salePrice}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_thenReturnAbsAbsAbsAmountIsOrderItemImplSalePrice() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("currency.default");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualCalculateSubTotalResult = orderImpl.calculateSubTotal();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualCalculateSubTotalResult.abs();
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = actualCalculateSubTotalResult.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderImpl#calculateSubTotal()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#calculateSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderImpl.calculateSubTotal()"})
  public void testCalculateSubTotal_thenReturnMoney() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    Money money = new Money();
    when(orderItem.getTotalPrice()).thenReturn(money);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.addOrderItem(orderItem);

    // Act
    Money actualCalculateSubTotalResult = orderImpl.calculateSubTotal();

    // Assert
    verify(orderItem).getTotalPrice();
    assertEquals(money, actualCalculateSubTotalResult);
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   *
   * <p>Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice() {
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
    orderItemImpl.setPrice(null);
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
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.assignOrderItemsFinalPrice();

    // Assert
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditItemAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getItemAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getTotalAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getTotalFutureCreditAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link
   *       NullOrderFactoryImpl#NULL_ORDER}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice_givenOrderItemImplOrderIsNull_order() {
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.assignOrderItemsFinalPrice();

    // Assert that nothing has changed
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is {@link OrderImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice_givenOrderItemImplOrderIsOrderImpl() {
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
    orderItemImpl.setOrder(new OrderImpl());
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
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.assignOrderItemsFinalPrice();

    // Assert that nothing has changed
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#assignFinalPrice()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice_thenCallsAssignFinalPrice() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    doNothing().when(bundleOrderItemImpl).assignFinalPrice();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.assignOrderItemsFinalPrice();

    // Assert
    verify(bundleOrderItemImpl).assignFinalPrice();
  }

  /**
   * Test {@link OrderImpl#assignOrderItemsFinalPrice()}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.assignOrderItemsFinalPrice()"})
  public void testAssignOrderItemsFinalPrice_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

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
    orderItemImpl.setOrder(order);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    orderImpl.assignOrderItemsFinalPrice();

    // Assert that nothing has changed
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItemImpl.salePrice;
    assertSame(bigDecimal, orderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getFutureCreditOrderAdjustmentsValue().getAmount());
    assertSame(bigDecimal, orderImpl.getOrderAdjustmentsValue().getAmount());
  }

  /**
   * Test {@link OrderImpl#addOrderItem(OrderItem)}.
   *
   * <p>Method under test: {@link OrderImpl#addOrderItem(OrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.addOrderItem(OrderItem)"})
  public void testAddOrderItem() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    orderImpl.addOrderItem(orderItem);

    // Assert
    List<OrderItem> orderItems = orderImpl.getOrderItems();
    assertEquals(1, orderItems.size());
    assertSame(orderItem, orderItems.get(0));
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenArrayListAddBundleOrderItemImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(orderImpl.containsSku(new SkuImpl()));
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenArrayListAddDiscreteOrderItemImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new DiscreteOrderItemImpl());
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(orderImpl.containsSku(new SkuImpl()));
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link
   *       OrderItemQualifierImpl#serialVersionUID}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenAuditableCreatedByIsSerialVersionUID_thenReturnFalse() {
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

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act and Assert
    assertFalse(orderImpl.containsSku(new SkuImpl()));
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link
   *       SkuImpl}.
   *   <li>Then calls {@link BundleOrderItemImpl#getSku()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenBundleOrderItemImplGetSkuReturnSkuImpl_thenCallsGetSku() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(mock(SkuImpl.class));

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualContainsSkuResult = orderImpl.containsSku(new SkuImpl());

    // Assert
    verify(bundleOrderItemImpl, atLeast(1)).getSku();
    assertFalse(actualContainsSkuResult);
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link
   *       SkuImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenBundleOrderItemImplGetSkuReturnSkuImpl_thenReturnTrue() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualContainsSkuResult = orderImpl.containsSku(new SkuImpl());

    // Assert
    verify(bundleOrderItemImpl, atLeast(1)).getSku();
    assertTrue(actualContainsSkuResult);
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getSku()} return {@link
   *       SkuImpl}.
   *   <li>Then calls {@link DiscreteOrderItemImpl#getSku()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenDiscreteOrderItemImplGetSkuReturnSkuImpl_thenCallsGetSku() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSku()).thenReturn(mock(SkuImpl.class));

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(discreteOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualContainsSkuResult = orderImpl.containsSku(new SkuImpl());

    // Assert
    verify(discreteOrderItemImpl, atLeast(1)).getSku();
    assertFalse(actualContainsSkuResult);
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getSku()} return {@link
   *       SkuImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenDiscreteOrderItemImplGetSkuReturnSkuImpl_thenReturnTrue() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(discreteOrderItemImpl);
    orderImpl.setOrderItems(orderItems);

    // Act
    boolean actualContainsSkuResult = orderImpl.containsSku(new SkuImpl());

    // Assert
    verify(discreteOrderItemImpl, atLeast(1)).getSku();
    assertTrue(actualContainsSkuResult);
  }

  /**
   * Test {@link OrderImpl#containsSku(Sku)}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#containsSku(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.containsSku(Sku)"})
  public void testContainsSku_givenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderImpl.containsSku(new SkuImpl()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#setAdditionalOfferInformation(Map)}
   *   <li>{@link OrderImpl#setAuditable(Auditable)}
   *   <li>{@link OrderImpl#setCandidateOrderOffers(List)}
   *   <li>{@link OrderImpl#setCurrency(BroadleafCurrency)}
   *   <li>{@link OrderImpl#setCustomer(Customer)}
   *   <li>{@link OrderImpl#setEmailAddress(String)}
   *   <li>{@link OrderImpl#setFulfillmentGroups(List)}
   *   <li>{@link OrderImpl#setId(Long)}
   *   <li>{@link OrderImpl#setLocale(Locale)}
   *   <li>{@link OrderImpl#setName(String)}
   *   <li>{@link OrderImpl#setOrderAdjustments(List)}
   *   <li>{@link OrderImpl#setOrderAttributes(Map)}
   *   <li>{@link OrderImpl#setOrderItems(List)}
   *   <li>{@link OrderImpl#setOrderMessages(List)}
   *   <li>{@link OrderImpl#setOrderNumber(String)}
   *   <li>{@link OrderImpl#setPayments(List)}
   *   <li>{@link OrderImpl#setSubmitDate(Date)}
   *   <li>{@link OrderImpl#setTaxOverride(Boolean)}
   *   <li>{@link OrderImpl#getAddedOfferCodes()}
   *   <li>{@link OrderImpl#getAdditionalOfferInformation()}
   *   <li>{@link OrderImpl#getAuditable()}
   *   <li>{@link OrderImpl#getBroadleafAccountId()}
   *   <li>{@link OrderImpl#getCandidateOrderOffers()}
   *   <li>{@link OrderImpl#getCurrency()}
   *   <li>{@link OrderImpl#getCustomer()}
   *   <li>{@link OrderImpl#getEmailAddress()}
   *   <li>{@link OrderImpl#getFulfillmentGroups()}
   *   <li>{@link OrderImpl#getFulfillmentStatus()}
   *   <li>{@link OrderImpl#getId()}
   *   <li>{@link OrderImpl#getLocale()}
   *   <li>{@link OrderImpl#getName()}
   *   <li>{@link OrderImpl#getOrderAdjustments()}
   *   <li>{@link OrderImpl#getOrderAttributes()}
   *   <li>{@link OrderImpl#getOrderItems()}
   *   <li>{@link OrderImpl#getOrderNumber()}
   *   <li>{@link OrderImpl#getPayments()}
   *   <li>{@link OrderImpl#getSubmitDate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List OrderImpl.getAddedOfferCodes()",
    "Map OrderImpl.getAdditionalOfferInformation()",
    "Auditable OrderImpl.getAuditable()",
    "Long OrderImpl.getBroadleafAccountId()",
    "List OrderImpl.getCandidateOrderOffers()",
    "BroadleafCurrency OrderImpl.getCurrency()",
    "Customer OrderImpl.getCustomer()",
    "String OrderImpl.getEmailAddress()",
    "List OrderImpl.getFulfillmentGroups()",
    "String OrderImpl.getFulfillmentStatus()",
    "Long OrderImpl.getId()",
    "Locale OrderImpl.getLocale()",
    "String OrderImpl.getName()",
    "List OrderImpl.getOrderAdjustments()",
    "Map OrderImpl.getOrderAttributes()",
    "List OrderImpl.getOrderItems()",
    "String OrderImpl.getOrderNumber()",
    "List OrderImpl.getPayments()",
    "Date OrderImpl.getSubmitDate()",
    "void OrderImpl.setAdditionalOfferInformation(Map)",
    "void OrderImpl.setAuditable(Auditable)",
    "void OrderImpl.setCandidateOrderOffers(List)",
    "void OrderImpl.setCurrency(BroadleafCurrency)",
    "void OrderImpl.setCustomer(Customer)",
    "void OrderImpl.setEmailAddress(String)",
    "void OrderImpl.setFulfillmentGroups(List)",
    "void OrderImpl.setId(Long)",
    "void OrderImpl.setLocale(Locale)",
    "void OrderImpl.setName(String)",
    "void OrderImpl.setOrderAdjustments(List)",
    "void OrderImpl.setOrderAttributes(Map)",
    "void OrderImpl.setOrderItems(List)",
    "void OrderImpl.setOrderMessages(List)",
    "void OrderImpl.setOrderNumber(String)",
    "void OrderImpl.setPayments(List)",
    "void OrderImpl.setSubmitDate(Date)",
    "void OrderImpl.setTaxOverride(Boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderImpl orderImpl = new OrderImpl();
    HashMap<Offer, OfferInfo> additionalOfferInformation = new HashMap<>();

    // Act
    orderImpl.setAdditionalOfferInformation(additionalOfferInformation);
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setAuditable(auditable);
    ArrayList<CandidateOrderOffer> candidateOrderOffers = new ArrayList<>();
    orderImpl.setCandidateOrderOffers(candidateOrderOffers);
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    orderImpl.setCurrency(currency);
    CustomerImpl customer = new CustomerImpl();
    orderImpl.setCustomer(customer);
    orderImpl.setEmailAddress("42 Main St");
    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    LocaleImpl locale = new LocaleImpl();
    orderImpl.setLocale(locale);
    orderImpl.setName("Name");
    ArrayList<OrderAdjustment> orderAdjustments = new ArrayList<>();
    orderImpl.setOrderAdjustments(orderAdjustments);
    HashMap<String, OrderAttribute> orderAttributes = new HashMap<>();
    orderImpl.setOrderAttributes(orderAttributes);
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderImpl.setOrderItems(orderItems);
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    ArrayList<OrderPayment> payments = new ArrayList<>();
    orderImpl.setPayments(payments);
    Date submitDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    orderImpl.setSubmitDate(submitDate);
    orderImpl.setTaxOverride(true);
    List<OfferCode> actualAddedOfferCodes = orderImpl.getAddedOfferCodes();
    Map<Offer, OfferInfo> actualAdditionalOfferInformation =
        orderImpl.getAdditionalOfferInformation();
    Auditable actualAuditable = orderImpl.getAuditable();
    Long actualBroadleafAccountId = orderImpl.getBroadleafAccountId();
    List<CandidateOrderOffer> actualCandidateOrderOffers = orderImpl.getCandidateOrderOffers();
    BroadleafCurrency actualCurrency = orderImpl.getCurrency();
    Customer actualCustomer = orderImpl.getCustomer();
    String actualEmailAddress = orderImpl.getEmailAddress();
    List<FulfillmentGroup> actualFulfillmentGroups = orderImpl.getFulfillmentGroups();
    String actualFulfillmentStatus = orderImpl.getFulfillmentStatus();
    Long actualId = orderImpl.getId();
    Locale actualLocale = orderImpl.getLocale();
    String actualName = orderImpl.getName();
    List<OrderAdjustment> actualOrderAdjustments = orderImpl.getOrderAdjustments();
    Map<String, OrderAttribute> actualOrderAttributes = orderImpl.getOrderAttributes();
    List<OrderItem> actualOrderItems = orderImpl.getOrderItems();
    String actualOrderNumber = orderImpl.getOrderNumber();
    List<OrderPayment> actualPayments = orderImpl.getPayments();
    Date actualSubmitDate = orderImpl.getSubmitDate();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("42", actualOrderNumber);
    assertEquals("Name", actualName);
    assertNull(actualBroadleafAccountId);
    assertNull(actualFulfillmentStatus);
    assertTrue(actualAddedOfferCodes.isEmpty());
    assertTrue(actualCandidateOrderOffers.isEmpty());
    assertTrue(actualFulfillmentGroups.isEmpty());
    assertTrue(actualOrderAdjustments.isEmpty());
    assertTrue(actualOrderItems.isEmpty());
    assertTrue(actualPayments.isEmpty());
    assertTrue(actualAdditionalOfferInformation.isEmpty());
    assertTrue(actualOrderAttributes.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(candidateOrderOffers, actualCandidateOrderOffers);
    assertSame(fulfillmentGroups, actualFulfillmentGroups);
    assertSame(orderAdjustments, actualOrderAdjustments);
    assertSame(orderItems, actualOrderItems);
    assertSame(payments, actualPayments);
    assertSame(additionalOfferInformation, actualAdditionalOfferInformation);
    assertSame(orderAttributes, actualOrderAttributes);
    assertSame(auditable, actualAuditable);
    assertSame(currency, actualCurrency);
    assertSame(locale, actualLocale);
    assertSame(customer, actualCustomer);
    assertSame(submitDate, actualSubmitDate);
  }

  /**
   * Test {@link OrderImpl#addAddedOfferCode(OfferCode)}.
   *
   * <p>Method under test: {@link OrderImpl#addAddedOfferCode(OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.addAddedOfferCode(OfferCode)"})
  public void testAddAddedOfferCode() {
    // Arrange
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    orderImpl.addAddedOfferCode(offerCode);

    // Assert
    List<OfferCode> addedOfferCodes = orderImpl.getAddedOfferCodes();
    assertEquals(1, addedOfferCodes.size());
    assertSame(offerCode, addedOfferCodes.get(0));
  }

  /**
   * Test {@link OrderImpl#addOfferCode(OfferCode)}.
   *
   * <p>Method under test: {@link OrderImpl#addOfferCode(OfferCode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.addOfferCode(OfferCode)"})
  public void testAddOfferCode() {
    // Arrange
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    orderImpl.addOfferCode(offerCode);

    // Assert
    List<OfferCode> addedOfferCodes = orderImpl.getAddedOfferCodes();
    assertEquals(1, addedOfferCodes.size());
    assertSame(offerCode, addedOfferCodes.get(0));
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    assertNotEquals(orderImpl.hashCode(), orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    assertNotEquals(orderImpl.hashCode(), orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(null);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    assertNotEquals(orderImpl.hashCode(), orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(null);
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(null);
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    assertNotEquals(orderImpl.hashCode(), orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(null);
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(null);
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(orderImpl, orderImpl2);
    assertNotEquals(orderImpl.hashCode(), orderImpl2.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}, and {@link OrderImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderImpl#equals(Object)}
   *   <li>{@link OrderImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    // Act and Assert
    assertEquals(orderImpl, orderImpl);
    int expectedHashCodeResult = orderImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderImpl.hashCode());
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

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
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(new Date());
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(null);
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(null);
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(mock(CustomerImpl.class));
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(null);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAdjustments(new ArrayList<>());
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(orderImpl, orderImpl2);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    // Act and Assert
    assertNotEquals(orderImpl, null);
  }

  /**
   * Test {@link OrderImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderImpl.equals(Object)", "int OrderImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAdjustments(new ArrayList<>());
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

    // Act and Assert
    assertNotEquals(orderImpl, "Different type to OrderImpl");
  }

  /**
   * Test new {@link OrderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OrderImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderImpl.<init>()"})
  public void testNewOrderImpl() {
    // Arrange and Act
    OrderImpl actualOrderImpl = new OrderImpl();

    // Assert
    assertNull(actualOrderImpl.getPreview());
    assertNull(actualOrderImpl.taxOverride);
    assertNull(actualOrderImpl.getBroadleafAccountId());
    assertNull(actualOrderImpl.getId());
    assertNull(actualOrderImpl.getCurrencyCode());
    assertNull(actualOrderImpl.getEmailAddress());
    assertNull(actualOrderImpl.getFulfillmentStatus());
    assertNull(actualOrderImpl.getName());
    assertNull(actualOrderImpl.getOrderNumber());
    assertNull(actualOrderImpl.status);
    assertNull(actualOrderImpl.subTotal);
    assertNull(actualOrderImpl.total);
    assertNull(actualOrderImpl.totalFulfillmentCharges);
    assertNull(actualOrderImpl.totalTax);
    assertNull(actualOrderImpl.getSubmitDate());
    assertNull(actualOrderImpl.getCurrency());
    assertNull(actualOrderImpl.getLocale());
    assertNull(actualOrderImpl.getSubTotal());
    assertNull(actualOrderImpl.getTotal());
    assertNull(actualOrderImpl.getTotalAfterAppliedPayments());
    assertNull(actualOrderImpl.getTotalFulfillmentCharges());
    assertNull(actualOrderImpl.getTotalShipping());
    assertNull(actualOrderImpl.getTotalTax());
    assertNull(actualOrderImpl.getStatus());
    assertNull(actualOrderImpl.getCustomer());
    assertEquals(0, actualOrderImpl.getItemCount());
    assertFalse(actualOrderImpl.getHasOrderAdjustments());
    assertFalse(actualOrderImpl.getTaxOverride());
    assertTrue(actualOrderImpl.getAddedOfferCodes().isEmpty());
    assertTrue(actualOrderImpl.getAllFutureCreditAdjustments().isEmpty());
    assertTrue(actualOrderImpl.getCandidateOrderOffers().isEmpty());
    assertTrue(actualOrderImpl.getDiscreteOrderItems().isEmpty());
    assertTrue(actualOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(actualOrderImpl.getFutureCreditOrderAdjustments().isEmpty());
    assertTrue(actualOrderImpl.getNonDiscreteOrderItems().isEmpty());
    assertTrue(actualOrderImpl.getOrderAdjustments().isEmpty());
    assertTrue(actualOrderImpl.getOrderItems().isEmpty());
    assertTrue(actualOrderImpl.getOrderMessages().isEmpty());
    assertTrue(actualOrderImpl.getPayments().isEmpty());
    assertTrue(actualOrderImpl.getAdditionalOfferInformation().isEmpty());
    assertTrue(actualOrderImpl.getOrderAttributes().isEmpty());
  }
}
