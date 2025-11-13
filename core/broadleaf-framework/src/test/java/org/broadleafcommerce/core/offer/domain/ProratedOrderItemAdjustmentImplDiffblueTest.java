package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
public class ProratedOrderItemAdjustmentImplDiffblueTest {
  @Autowired private ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl;

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#init(OrderItem, Offer, String)}.
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#init(OrderItem, Offer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProratedOrderItemAdjustmentImpl.init(OrderItem, Offer, String)"})
  public void testInit() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    proratedOrderItemAdjustmentImpl.init(orderItem, offer, "Just cause");

    // Assert
    assertEquals("Just cause", proratedOrderItemAdjustmentImpl.getReason());
    assertSame(offer, proratedOrderItemAdjustmentImpl.getOffer());
    assertSame(orderItem, proratedOrderItemAdjustmentImpl.getOrderItem());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#setId(Long)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#setOffer(Offer)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#setOrderItem(OrderItem)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#setQuantity(int)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#setReason(String)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#getId()}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#getOffer()}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#getOrderItem()}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#getQuantity()}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#getReason()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ProratedOrderItemAdjustmentImpl.getId()",
    "Offer ProratedOrderItemAdjustmentImpl.getOffer()",
    "OrderItem ProratedOrderItemAdjustmentImpl.getOrderItem()",
    "int ProratedOrderItemAdjustmentImpl.getQuantity()",
    "String ProratedOrderItemAdjustmentImpl.getReason()",
    "void ProratedOrderItemAdjustmentImpl.setId(Long)",
    "void ProratedOrderItemAdjustmentImpl.setOffer(Offer)",
    "void ProratedOrderItemAdjustmentImpl.setOrderItem(OrderItem)",
    "void ProratedOrderItemAdjustmentImpl.setQuantity(int)",
    "void ProratedOrderItemAdjustmentImpl.setReason(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();

    // Act
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    OfferImpl offer = new OfferImpl();
    proratedOrderItemAdjustmentImpl.setOffer(offer);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    Long actualId = proratedOrderItemAdjustmentImpl.getId();
    Offer actualOffer = proratedOrderItemAdjustmentImpl.getOffer();
    OrderItem actualOrderItem = proratedOrderItemAdjustmentImpl.getOrderItem();
    int actualQuantity = proratedOrderItemAdjustmentImpl.getQuantity();

    // Assert
    assertEquals("Just cause", proratedOrderItemAdjustmentImpl.getReason());
    assertEquals(1, actualQuantity);
    assertEquals(ProratedOrderItemAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(offer, actualOffer);
    assertSame(orderItem, actualOrderItem);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProratedOrderItemAdjustmentImpl.getValue()"})
  public void testGetValue_givenMoneyGetAmountReturnNull_thenReturnNull() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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
    proratedOrderItemAdjustmentImpl.setValue(value);
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualValue = proratedOrderItemAdjustmentImpl.getValue();

    // Assert
    verify(value).getAmount();
    assertNull(actualValue);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProratedOrderItemAdjustmentImpl.getValue()"})
  public void testGetValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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
    proratedOrderItemAdjustmentImpl.setValue(value);
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(value, proratedOrderItemAdjustmentImpl.getValue());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProratedOrderItemAdjustmentImpl.getValue()"})
  public void testGetValue_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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
    orderItem.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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
    proratedOrderItemAdjustmentImpl.setValue(new Money());
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act
    Money actualValue = proratedOrderItemAdjustmentImpl.getValue();

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
   * Test {@link ProratedOrderItemAdjustmentImpl#setValue(Money)}.
   *
   * <ul>
   *   <li>Then {@link ProratedOrderItemAdjustmentImpl} {@link
   *       ProratedOrderItemAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)} with
   *       {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProratedOrderItemAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenProratedOrderItemAdjustmentImplValueIsBigDecimalWith000() {
    // Arrange and Act
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    // Assert that nothing has changed
    assertEquals(new BigDecimal("0.00"), proratedOrderItemAdjustmentImpl.value);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#setValue(Money)}.
   *
   * <ul>
   *   <li>Then {@link ProratedOrderItemAdjustmentImpl} {@link
   *       ProratedOrderItemAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)} with
   *       {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProratedOrderItemAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenProratedOrderItemAdjustmentImplValueIsBigDecimalWith23() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    proratedOrderItemAdjustmentImpl.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), proratedOrderItemAdjustmentImpl.value);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is {@link
   *       ProratedOrderItemAdjustmentImpl#serialVersionUID}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProratedOrderItemAdjustmentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(ProratedOrderItemAdjustmentImpl.serialVersionUID);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
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

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setOrderItem(orderItem);

    // Act and Assert
    assertNull(proratedOrderItemAdjustmentImpl.getCurrencyCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and {@link
   * ProratedOrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
    assertEquals(
        proratedOrderItemAdjustmentImpl.hashCode(), proratedOrderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and {@link
   * ProratedOrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
    assertEquals(
        proratedOrderItemAdjustmentImpl.hashCode(), proratedOrderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and {@link
   * ProratedOrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(null);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
    assertEquals(
        proratedOrderItemAdjustmentImpl.hashCode(), proratedOrderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and {@link
   * ProratedOrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(null);
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(null);
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
    assertEquals(
        proratedOrderItemAdjustmentImpl.hashCode(), proratedOrderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and {@link
   * ProratedOrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(null);
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(null);
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
    assertEquals(
        proratedOrderItemAdjustmentImpl.hashCode(), proratedOrderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and {@link
   * ProratedOrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason(null);
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason(null);
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
    assertEquals(
        proratedOrderItemAdjustmentImpl.hashCode(), proratedOrderItemAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}, and {@link
   * ProratedOrderItemAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   *   <li>{@link ProratedOrderItemAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl);
    int expectedHashCodeResult = proratedOrderItemAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, proratedOrderItemAdjustmentImpl.hashCode());
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(2L);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setId(OfferImpl.serialVersionUID);

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(offer);
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(null);
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new DiscreteOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(null);
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Reason");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason(null);
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money(10.0d));

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(null);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(value);

    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl2 =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl2.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl2.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl2.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl2.setQuantity(1);
    proratedOrderItemAdjustmentImpl2.setReason("Just cause");
    proratedOrderItemAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, proratedOrderItemAdjustmentImpl2);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(proratedOrderItemAdjustmentImpl, null);
  }

  /**
   * Test {@link ProratedOrderItemAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProratedOrderItemAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProratedOrderItemAdjustmentImpl.equals(Object)",
    "int ProratedOrderItemAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProratedOrderItemAdjustmentImpl proratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();
    proratedOrderItemAdjustmentImpl.setId(ProratedOrderItemAdjustmentImpl.serialVersionUID);
    proratedOrderItemAdjustmentImpl.setOffer(new OfferImpl());
    proratedOrderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    proratedOrderItemAdjustmentImpl.setQuantity(1);
    proratedOrderItemAdjustmentImpl.setReason("Just cause");
    proratedOrderItemAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(
        proratedOrderItemAdjustmentImpl, "Different type to ProratedOrderItemAdjustmentImpl");
  }

  /**
   * Test new {@link ProratedOrderItemAdjustmentImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ProratedOrderItemAdjustmentImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProratedOrderItemAdjustmentImpl.<init>()"})
  public void testNewProratedOrderItemAdjustmentImpl() {
    // Arrange and Act
    ProratedOrderItemAdjustmentImpl actualProratedOrderItemAdjustmentImpl =
        new ProratedOrderItemAdjustmentImpl();

    // Assert
    assertNull(actualProratedOrderItemAdjustmentImpl.getId());
    assertNull(actualProratedOrderItemAdjustmentImpl.getReason());
    assertNull(actualProratedOrderItemAdjustmentImpl.getOffer());
    assertNull(actualProratedOrderItemAdjustmentImpl.getOrderItem());
    assertEquals(0, actualProratedOrderItemAdjustmentImpl.getQuantity());
    assertEquals(new BigDecimal("0.00"), actualProratedOrderItemAdjustmentImpl.value);
  }
}
