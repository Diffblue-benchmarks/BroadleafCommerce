package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
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
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BundleOrderItemFeePriceImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#setBundleOrderItem(BundleOrderItem)}
   *   <li>{@link BundleOrderItemFeePriceImpl#setId(Long)}
   *   <li>{@link BundleOrderItemFeePriceImpl#setName(String)}
   *   <li>{@link BundleOrderItemFeePriceImpl#setReportingCode(String)}
   *   <li>{@link BundleOrderItemFeePriceImpl#setTaxable(Boolean)}
   *   <li>{@link BundleOrderItemFeePriceImpl#getBundleOrderItem()}
   *   <li>{@link BundleOrderItemFeePriceImpl#getId()}
   *   <li>{@link BundleOrderItemFeePriceImpl#getName()}
   *   <li>{@link BundleOrderItemFeePriceImpl#getReportingCode()}
   *   <li>{@link BundleOrderItemFeePriceImpl#isTaxable()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BundleOrderItem BundleOrderItemFeePriceImpl.getBundleOrderItem()",
    "Long BundleOrderItemFeePriceImpl.getId()",
    "String BundleOrderItemFeePriceImpl.getName()",
    "String BundleOrderItemFeePriceImpl.getReportingCode()",
    "Boolean BundleOrderItemFeePriceImpl.isTaxable()",
    "void BundleOrderItemFeePriceImpl.setBundleOrderItem(BundleOrderItem)",
    "void BundleOrderItemFeePriceImpl.setId(Long)",
    "void BundleOrderItemFeePriceImpl.setName(String)",
    "void BundleOrderItemFeePriceImpl.setReportingCode(String)",
    "void BundleOrderItemFeePriceImpl.setTaxable(Boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();

    // Act
    bundleOrderItemFeePriceImpl.setBundleOrderItem(bundleOrderItem);
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);
    BundleOrderItem actualBundleOrderItem = bundleOrderItemFeePriceImpl.getBundleOrderItem();
    Long actualId = bundleOrderItemFeePriceImpl.getId();
    String actualName = bundleOrderItemFeePriceImpl.getName();
    String actualReportingCode = bundleOrderItemFeePriceImpl.getReportingCode();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Reporting Code", actualReportingCode);
    assertTrue(bundleOrderItemFeePriceImpl.isTaxable());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(bundleOrderItem, actualBundleOrderItem);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemFeePriceImpl.convertToMoney(BigDecimal)"})
  public void testConvertToMoney_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
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

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setCurrency(currency);

    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    bundleOrderItem.setAuditable(auditable);
    bundleOrderItem.setBaseRetailPrice(new Money());
    bundleOrderItem.setBaseSalePrice(new Money());
    bundleOrderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItem.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItem.setCartMessages(new ArrayList<>());
    bundleOrderItem.setChildOrderItems(new ArrayList<>());
    bundleOrderItem.setDiscountingAllowed(true);
    bundleOrderItem.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItem.setHasValidationError(true);
    bundleOrderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItem.setName("Name");
    bundleOrderItem.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setOrderItemAttributes(new HashMap<>());
    bundleOrderItem.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItem.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItem.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItem.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItem.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItem.setPrice(new Money());
    bundleOrderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setQuantity(1);
    bundleOrderItem.setRetailPrice(new Money());
    bundleOrderItem.setRetailPriceOverride(true);
    bundleOrderItem.setSalePrice(new Money());
    bundleOrderItem.setSalePriceOverride(true);
    bundleOrderItem.setTaxable(true);
    bundleOrderItem.updateSaleAndRetailPrices();
    bundleOrderItem.setOrder(order);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);
    bundleOrderItemFeePriceImpl.setBundleOrderItem(bundleOrderItem);

    // Act
    Money actualConvertToMoneyResult =
        bundleOrderItemFeePriceImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualConvertToMoneyResult.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money zeroResult = actualConvertToMoneyResult.zero();
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = actualConvertToMoneyResult.abs().zero();
    assertEquals(zeroResult2, zeroResult3.abs());
    assertEquals(zeroResult2, zeroResult3.zero());
    assertEquals(zeroResult2, zeroResult2);
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code US Dollar}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemFeePriceImpl.convertToMoney(BigDecimal)"})
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

    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    bundleOrderItem.setAuditable(auditable);
    bundleOrderItem.setBaseRetailPrice(new Money());
    bundleOrderItem.setBaseSalePrice(new Money());
    bundleOrderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItem.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItem.setCartMessages(new ArrayList<>());
    bundleOrderItem.setChildOrderItems(new ArrayList<>());
    bundleOrderItem.setDiscountingAllowed(true);
    bundleOrderItem.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItem.setHasValidationError(true);
    bundleOrderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItem.setName("Name");
    bundleOrderItem.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setOrderItemAttributes(new HashMap<>());
    bundleOrderItem.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItem.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItem.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItem.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItem.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItem.setPrice(new Money());
    bundleOrderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setQuantity(1);
    bundleOrderItem.setRetailPrice(new Money());
    bundleOrderItem.setRetailPriceOverride(true);
    bundleOrderItem.setSalePrice(new Money());
    bundleOrderItem.setSalePriceOverride(true);
    bundleOrderItem.setTaxable(true);
    bundleOrderItem.updateSaleAndRetailPrices();
    bundleOrderItem.setOrder(order);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    Money amount = new Money();
    bundleOrderItemFeePriceImpl.setAmount(amount);
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);
    bundleOrderItemFeePriceImpl.setBundleOrderItem(bundleOrderItem);

    // Act
    Money actualConvertToMoneyResult =
        bundleOrderItemFeePriceImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Currency currency = actualConvertToMoneyResult.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertEquals(840, currency.getNumericCode());
    assertEquals(amount, actualConvertToMoneyResult.abs().zero());
    assertEquals(amount, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money BundleOrderItemFeePriceImpl.convertToMoney(BigDecimal)"})
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

    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    bundleOrderItem.setAuditable(auditable);
    bundleOrderItem.setBaseRetailPrice(new Money());
    bundleOrderItem.setBaseSalePrice(new Money());
    bundleOrderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItem.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItem.setCartMessages(new ArrayList<>());
    bundleOrderItem.setChildOrderItems(new ArrayList<>());
    bundleOrderItem.setDiscountingAllowed(true);
    bundleOrderItem.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItem.setHasValidationError(true);
    bundleOrderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItem.setName("Name");
    bundleOrderItem.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setOrderItemAttributes(new HashMap<>());
    bundleOrderItem.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItem.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItem.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItem.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItem.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItem.setPrice(new Money());
    bundleOrderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setQuantity(1);
    bundleOrderItem.setRetailPrice(new Money());
    bundleOrderItem.setRetailPriceOverride(true);
    bundleOrderItem.setSalePrice(new Money());
    bundleOrderItem.setSalePriceOverride(true);
    bundleOrderItem.setTaxable(true);
    bundleOrderItem.updateSaleAndRetailPrices();
    bundleOrderItem.setOrder(order);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);
    bundleOrderItemFeePriceImpl.setBundleOrderItem(bundleOrderItem);

    // Act and Assert
    assertNull(bundleOrderItemFeePriceImpl.convertToMoney(null));
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemFeePriceImpl} (default constructor).
   *   <li>Then return {@link BundleOrderItemFeePriceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BundleOrderItemFeePrice BundleOrderItemFeePriceImpl.clone()"})
  public void testClone_givenBundleOrderItemFeePriceImpl_thenReturnBundleOrderItemFeePriceImpl() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();

    // Act
    BundleOrderItemFeePrice actualCloneResult = bundleOrderItemFeePriceImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof BundleOrderItemFeePriceImpl);
    assertEquals(bundleOrderItemFeePriceImpl, actualCloneResult);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#clone()}.
   *
   * <ul>
   *   <li>Then return BundleOrderItem CurrencyCode is {@code GBP}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BundleOrderItemFeePrice BundleOrderItemFeePriceImpl.clone()"})
  public void testClone_thenReturnBundleOrderItemCurrencyCodeIsGbp() {
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

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setCurrency(currency);

    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    bundleOrderItem.setAuditable(auditable);
    bundleOrderItem.setBaseRetailPrice(new Money());
    bundleOrderItem.setBaseSalePrice(new Money());
    bundleOrderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItem.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItem.setCartMessages(new ArrayList<>());
    bundleOrderItem.setChildOrderItems(new ArrayList<>());
    bundleOrderItem.setDiscountingAllowed(true);
    bundleOrderItem.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItem.setHasValidationError(true);
    bundleOrderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItem.setName("Name");
    bundleOrderItem.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setOrderItemAttributes(new HashMap<>());
    bundleOrderItem.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItem.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItem.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItem.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItem.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItem.setPrice(new Money());
    bundleOrderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setQuantity(1);
    bundleOrderItem.setRetailPrice(new Money());
    bundleOrderItem.setRetailPriceOverride(true);
    bundleOrderItem.setSalePrice(new Money());
    bundleOrderItem.setSalePriceOverride(true);
    bundleOrderItem.setTaxable(true);
    bundleOrderItem.updateSaleAndRetailPrices();
    bundleOrderItem.setOrder(order);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(bundleOrderItem);

    // Act
    BundleOrderItemFeePrice actualCloneResult = bundleOrderItemFeePriceImpl.clone();

    // Assert
    verify(currency).getCurrencyCode();
    assertTrue(actualCloneResult instanceof BundleOrderItemFeePriceImpl);
    BundleOrderItem bundleOrderItem2 = actualCloneResult.getBundleOrderItem();
    assertTrue(bundleOrderItem2 instanceof BundleOrderItemImpl);
    assertEquals("GBP", ((BundleOrderItemImpl) bundleOrderItem2).getCurrencyCode());
    Money amount = actualCloneResult.getAmount();
    Money actualAbsResult = amount.abs();
    assertEquals(amount, actualAbsResult);
    Money actualZeroResult = amount.zero();
    assertEquals(amount, actualZeroResult);
    assertEquals(amount, bundleOrderItem2.getBaseRetailPrice());
    assertEquals(amount, bundleOrderItem2.getBaseSalePrice());
    assertEquals(amount, bundleOrderItem2.getTaxablePrice());
    assertEquals(amount, bundleOrderItem2.getAdjustmentValue());
    assertEquals(amount, bundleOrderItem2.getAverageAdjustmentValue());
    assertEquals(amount, bundleOrderItem2.getAveragePrice());
    assertEquals(amount, bundleOrderItem2.getFutureCreditTotalAdjustmentValue());
    assertEquals(amount, bundleOrderItem2.getPrice());
    assertEquals(amount, bundleOrderItem2.getRetailPrice());
    assertEquals(amount, bundleOrderItem2.getTotalAdjustmentValue());
    assertEquals(amount, bundleOrderItem2.getTotalPrice());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#clone()}.
   *
   * <ul>
   *   <li>Then return BundleOrderItem CurrencyCode is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BundleOrderItemFeePrice BundleOrderItemFeePriceImpl.clone()"})
  public void testClone_thenReturnBundleOrderItemCurrencyCodeIsNull() {
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

    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    bundleOrderItem.setAuditable(auditable);
    bundleOrderItem.setBaseRetailPrice(new Money());
    bundleOrderItem.setBaseSalePrice(new Money());
    bundleOrderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItem.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItem.setCartMessages(new ArrayList<>());
    bundleOrderItem.setChildOrderItems(new ArrayList<>());
    bundleOrderItem.setDiscountingAllowed(true);
    bundleOrderItem.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItem.setHasValidationError(true);
    bundleOrderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItem.setName("Name");
    bundleOrderItem.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setOrderItemAttributes(new HashMap<>());
    bundleOrderItem.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItem.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItem.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItem.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItem.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItem.setPrice(new Money());
    bundleOrderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setQuantity(1);
    bundleOrderItem.setRetailPrice(new Money());
    bundleOrderItem.setRetailPriceOverride(true);
    bundleOrderItem.setSalePrice(new Money());
    bundleOrderItem.setSalePriceOverride(true);
    bundleOrderItem.setTaxable(true);
    bundleOrderItem.updateSaleAndRetailPrices();
    bundleOrderItem.setOrder(order);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);
    Money amount = new Money();
    bundleOrderItemFeePriceImpl.setAmount(amount);
    bundleOrderItemFeePriceImpl.setBundleOrderItem(bundleOrderItem);

    // Act
    BundleOrderItemFeePrice actualCloneResult = bundleOrderItemFeePriceImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof BundleOrderItemFeePriceImpl);
    BundleOrderItem bundleOrderItem2 = actualCloneResult.getBundleOrderItem();
    assertTrue(bundleOrderItem2 instanceof BundleOrderItemImpl);
    assertNull(((BundleOrderItemImpl) bundleOrderItem2).getCurrencyCode());
    assertEquals(amount, bundleOrderItem2.getBaseRetailPrice());
    assertEquals(amount, bundleOrderItem2.getBaseSalePrice());
    assertEquals(amount, bundleOrderItem2.getTaxablePrice());
    assertEquals(amount, actualCloneResult.getAmount());
    assertEquals(amount, bundleOrderItem2.getAdjustmentValue());
    assertEquals(amount, bundleOrderItem2.getAverageAdjustmentValue());
    assertEquals(amount, bundleOrderItem2.getAveragePrice());
    assertEquals(amount, bundleOrderItem2.getFutureCreditTotalAdjustmentValue());
    assertEquals(amount, bundleOrderItem2.getPrice());
    assertEquals(amount, bundleOrderItem2.getRetailPrice());
    assertEquals(amount, bundleOrderItem2.getTotalAdjustmentValue());
    assertEquals(amount, bundleOrderItem2.getTotalPrice());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#clone()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BundleOrderItemFeePrice BundleOrderItemFeePriceImpl.clone()"})
  public void testClone_thenThrowRuntimeException() {
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

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenThrow(new RuntimeException());

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
    order.setCurrency(currency);

    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    bundleOrderItem.setAuditable(auditable);
    bundleOrderItem.setBaseRetailPrice(new Money());
    bundleOrderItem.setBaseSalePrice(new Money());
    bundleOrderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItem.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItem.setCartMessages(new ArrayList<>());
    bundleOrderItem.setChildOrderItems(new ArrayList<>());
    bundleOrderItem.setDiscountingAllowed(true);
    bundleOrderItem.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItem.setHasValidationError(true);
    bundleOrderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItem.setName("Name");
    bundleOrderItem.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setOrderItemAttributes(new HashMap<>());
    bundleOrderItem.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItem.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItem.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItem.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItem.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItem.setPrice(new Money());
    bundleOrderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItem.setQuantity(1);
    bundleOrderItem.setRetailPrice(new Money());
    bundleOrderItem.setRetailPriceOverride(true);
    bundleOrderItem.setSalePrice(new Money());
    bundleOrderItem.setSalePriceOverride(true);
    bundleOrderItem.setTaxable(true);
    bundleOrderItem.updateSaleAndRetailPrices();
    bundleOrderItem.setOrder(order);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(bundleOrderItem);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> bundleOrderItemFeePriceImpl.clone());
    verify(currency).getCurrencyCode();
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and {@link
   * BundleOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
    assertEquals(bundleOrderItemFeePriceImpl.hashCode(), bundleOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and {@link
   * BundleOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(null);
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(null);
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
    assertEquals(bundleOrderItemFeePriceImpl.hashCode(), bundleOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and {@link
   * BundleOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(null);
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(null);
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
    assertEquals(bundleOrderItemFeePriceImpl.hashCode(), bundleOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and {@link
   * BundleOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(null);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(null);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
    assertEquals(bundleOrderItemFeePriceImpl.hashCode(), bundleOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and {@link
   * BundleOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName(null);
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName(null);
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
    assertEquals(bundleOrderItemFeePriceImpl.hashCode(), bundleOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and {@link
   * BundleOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode(null);
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode(null);
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
    assertEquals(bundleOrderItemFeePriceImpl.hashCode(), bundleOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and {@link
   * BundleOrderItemFeePriceImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    // Act and Assert
    assertEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl);
    int expectedHashCodeResult = bundleOrderItemFeePriceImpl.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemFeePriceImpl.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(null);
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money(10.0d));
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(null);
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(mock(BundleOrderItemImpl.class));
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(2L);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(null);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Reporting Code");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName(null);
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Name");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode(null);
    bundleOrderItemFeePriceImpl.setTaxable(true);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(false);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl2 = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl2.setAmount(new Money());
    bundleOrderItemFeePriceImpl2.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl2.setName("Name");
    bundleOrderItemFeePriceImpl2.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl2.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, bundleOrderItemFeePriceImpl2);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, null);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BundleOrderItemFeePriceImpl.equals(Object)",
    "int BundleOrderItemFeePriceImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(new Money());
    bundleOrderItemFeePriceImpl.setBundleOrderItem(new BundleOrderItemImpl());
    bundleOrderItemFeePriceImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    bundleOrderItemFeePriceImpl.setName("Name");
    bundleOrderItemFeePriceImpl.setReportingCode("Reporting Code");
    bundleOrderItemFeePriceImpl.setTaxable(true);

    // Act and Assert
    assertNotEquals(bundleOrderItemFeePriceImpl, "Different type to BundleOrderItemFeePriceImpl");
  }

  /**
   * Test new {@link BundleOrderItemFeePriceImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BundleOrderItemFeePriceImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BundleOrderItemFeePriceImpl.<init>()"})
  public void testNewBundleOrderItemFeePriceImpl() {
    // Arrange and Act
    BundleOrderItemFeePriceImpl actualBundleOrderItemFeePriceImpl =
        new BundleOrderItemFeePriceImpl();

    // Assert
    assertNull(actualBundleOrderItemFeePriceImpl.getId());
    assertNull(actualBundleOrderItemFeePriceImpl.getName());
    assertNull(actualBundleOrderItemFeePriceImpl.getReportingCode());
    assertNull(actualBundleOrderItemFeePriceImpl.amount);
    assertNull(actualBundleOrderItemFeePriceImpl.getAmount());
    assertNull(actualBundleOrderItemFeePriceImpl.getBundleOrderItem());
    assertFalse(actualBundleOrderItemFeePriceImpl.isTaxable());
  }
}
