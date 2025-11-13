package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
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
public class OrderItemAdjustmentImplDiffblueTest {
  @Autowired private OrderItemAdjustmentImpl orderItemAdjustmentImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#setAppliedToSalePrice(boolean)}
   *   <li>{@link OrderItemAdjustmentImpl#setId(Long)}
   *   <li>{@link OrderItemAdjustmentImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemAdjustmentImpl#setReason(String)}
   *   <li>{@link OrderItemAdjustmentImpl#setRetailPriceValue(Money)}
   *   <li>{@link OrderItemAdjustmentImpl#setSalesPriceValue(Money)}
   *   <li>{@link OrderItemAdjustmentImpl#getId()}
   *   <li>{@link OrderItemAdjustmentImpl#getOrderItem()}
   *   <li>{@link OrderItemAdjustmentImpl#getReason()}
   *   <li>{@link OrderItemAdjustmentImpl#isAppliedToSalePrice()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long OrderItemAdjustmentImpl.getId()",
    "OrderItem OrderItemAdjustmentImpl.getOrderItem()",
    "String OrderItemAdjustmentImpl.getReason()",
    "boolean OrderItemAdjustmentImpl.isAppliedToSalePrice()",
    "void OrderItemAdjustmentImpl.setAppliedToSalePrice(boolean)",
    "void OrderItemAdjustmentImpl.setId(Long)",
    "void OrderItemAdjustmentImpl.setOrderItem(OrderItem)",
    "void OrderItemAdjustmentImpl.setReason(String)",
    "void OrderItemAdjustmentImpl.setRetailPriceValue(Money)",
    "void OrderItemAdjustmentImpl.setSalesPriceValue(Money)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();

    // Act
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItemAdjustmentImpl.setOrderItem(orderItem);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    Long actualId = orderItemAdjustmentImpl.getId();
    OrderItem actualOrderItem = orderItemAdjustmentImpl.getOrderItem();
    String actualReason = orderItemAdjustmentImpl.getReason();

    // Assert
    assertEquals("Just cause", actualReason);
    assertTrue(orderItemAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(OrderItemAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItem, actualOrderItem);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getOffer()}.
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.offer.domain.Offer OrderItemAdjustmentImpl.getOffer()"
  })
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull(orderItemAdjustmentImpl.getOffer());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getValue()"})
  public void testGetValue_givenMoneyGetAmountReturnNull_thenReturnNull() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(new BroadleafCurrencyImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);
    orderItemAdjustmentImpl.setValue(value);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualValue = orderItemAdjustmentImpl.getValue();

    // Assert
    verify(value).getAmount();
    assertNull(actualValue);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getValue()"})
  public void testGetValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);
    Money value = new Money();
    orderItemAdjustmentImpl.setValue(value);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(value, orderItemAdjustmentImpl.getValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getValue()"})
  public void testGetValue_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);
    orderItemAdjustmentImpl.setValue(new Money());
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualValue = orderItemAdjustmentImpl.getValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualValue.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualValue.abs();
    assertEquals(actualValue, actualAbsResult);
    Money actualZeroResult = actualValue.zero();
    assertEquals(actualValue, actualZeroResult);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#setValue(Money)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemAdjustmentImpl} {@link OrderItemAdjustmentImpl#value} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenOrderItemAdjustmentImplValueIsBigDecimalWith23() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    orderItemAdjustmentImpl.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), orderItemAdjustmentImpl.value);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#setValue(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link OrderItemAdjustmentImpl} {@link OrderItemAdjustmentImpl#value} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemAdjustmentImpl.setValue(Money)"})
  public void testSetValue_whenMoney_thenOrderItemAdjustmentImplValueIsBigDecimalWith000() {
    // Arrange and Act
    orderItemAdjustmentImpl.setValue(new Money());

    // Assert that nothing has changed
    assertEquals(new BigDecimal("0.00"), orderItemAdjustmentImpl.value);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getRetailPriceValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    orderItem.setBaseRetailPrice(baseRetailPrice);
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);
    orderItemAdjustmentImpl.setRetailPriceValue(null);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(baseRetailPrice, orderItemAdjustmentImpl.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getRetailPriceValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemAdjustmentImpl} RetailPriceValue is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue_givenOrderItemAdjustmentImplRetailPriceValueIsMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(new BroadleafCurrencyImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);
    Money retailPriceValue = new Money();
    orderItemAdjustmentImpl.setRetailPriceValue(retailPriceValue);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertSame(retailPriceValue, orderItemAdjustmentImpl.getRetailPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getRetailPriceValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getRetailPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getRetailPriceValue()"})
  public void testGetRetailPriceValue_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);
    orderItemAdjustmentImpl.setRetailPriceValue(null);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualRetailPriceValue = orderItemAdjustmentImpl.getRetailPriceValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualRetailPriceValue.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getSalesPriceValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    orderItem.setBaseRetailPrice(baseRetailPrice);
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);
    orderItemAdjustmentImpl.setSalesPriceValue(null);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(baseRetailPrice, orderItemAdjustmentImpl.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getSalesPriceValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemAdjustmentImpl} SalesPriceValue is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue_givenOrderItemAdjustmentImplSalesPriceValueIsMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(new BroadleafCurrencyImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);
    Money salesPriceValue = new Money();
    orderItemAdjustmentImpl.setSalesPriceValue(salesPriceValue);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertSame(salesPriceValue, orderItemAdjustmentImpl.getSalesPriceValue());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getSalesPriceValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getSalesPriceValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OrderItemAdjustmentImpl.getSalesPriceValue()"})
  public void testGetSalesPriceValue_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderItemAdjustmentImpl.serialVersionUID);
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

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
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
    orderItem.setOrder(order);
    orderItemAdjustmentImpl.setSalesPriceValue(null);
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualSalesPriceValue = orderItemAdjustmentImpl.getSalesPriceValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualSalesPriceValue.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link
   *       OrderItemAdjustmentImpl#serialVersionUID}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderItemAdjustmentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
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

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertNull(orderItemAdjustmentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    assertEquals(orderItemAdjustmentImpl.hashCode(), orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    assertEquals(orderItemAdjustmentImpl.hashCode(), orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(null);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    assertEquals(orderItemAdjustmentImpl.hashCode(), orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(null);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(null);
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    assertEquals(orderItemAdjustmentImpl.hashCode(), orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason(null);
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason(null);
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
    assertEquals(orderItemAdjustmentImpl.hashCode(), orderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}, and {@link
   * OrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl);
    int expectedHashCodeResult = orderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAdjustmentImpl.hashCode());
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(2L);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new DiscreteOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(null);
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Reason");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason(null);
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money(10.0d));

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(null);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(value);

    OrderItemAdjustmentImpl orderItemAdjustmentImpl2 = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl2.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl2.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl2.setReason("Just cause");
    orderItemAdjustmentImpl2.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl2.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, orderItemAdjustmentImpl2);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, null);
  }

  /**
   * Test {@link OrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemAdjustmentImpl.equals(Object)",
    "int OrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderItemAdjustmentImpl, "Different type to OrderItemAdjustmentImpl");
  }

  /**
   * Test new {@link OrderItemAdjustmentImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OrderItemAdjustmentImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemAdjustmentImpl.<init>()"})
  public void testNewOrderItemAdjustmentImpl() {
    // Arrange and Act
    OrderItemAdjustmentImpl actualOrderItemAdjustmentImpl = new OrderItemAdjustmentImpl();

    // Assert
    assertNull(actualOrderItemAdjustmentImpl.getId());
    assertNull(actualOrderItemAdjustmentImpl.getReason());
    assertNull(actualOrderItemAdjustmentImpl.retailValue);
    assertNull(actualOrderItemAdjustmentImpl.salesValue);
    assertNull(actualOrderItemAdjustmentImpl.getOffer());
    assertNull(actualOrderItemAdjustmentImpl.deproxiedOffer);
    assertNull(actualOrderItemAdjustmentImpl.offer);
    assertNull(actualOrderItemAdjustmentImpl.getOrderItem());
    assertFalse(actualOrderItemAdjustmentImpl.isAppliedToSalePrice());
    assertEquals(new BigDecimal("0.00"), actualOrderItemAdjustmentImpl.value);
  }
}
