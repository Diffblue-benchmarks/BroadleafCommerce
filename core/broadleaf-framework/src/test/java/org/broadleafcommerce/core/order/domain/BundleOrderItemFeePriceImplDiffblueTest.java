package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class BundleOrderItemFeePriceImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Reporting Code", actualReportingCode);
    assertTrue(bundleOrderItemFeePriceImpl.isTaxable());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(bundleOrderItem, actualBundleOrderItem);
  }

  /**
   * Test
   * {@link BundleOrderItemFeePriceImpl#checkCloneable(BundleOrderItemFeePrice)}.
   * <ul>
   *   <li>When {@link BundleOrderItemFeePriceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BundleOrderItemFeePriceImpl#checkCloneable(BundleOrderItemFeePrice)}
   */
  @Test
  public void testCheckCloneable_whenBundleOrderItemFeePriceImpl()
      throws CloneNotSupportedException, NoSuchMethodException, SecurityException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();

    // Act
    bundleOrderItemFeePriceImpl.checkCloneable(new BundleOrderItemFeePriceImpl());
  }

  /**
   * Test
   * {@link BundleOrderItemFeePriceImpl#checkCloneable(BundleOrderItemFeePrice)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BundleOrderItemFeePriceImpl#checkCloneable(BundleOrderItemFeePrice)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckCloneable_whenNull()
      throws CloneNotSupportedException, NoSuchMethodException, SecurityException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemFeePriceImpl.checkCloneable(BundleOrderItemFeePriceImpl.java:159)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new BundleOrderItemFeePriceImpl()).checkCloneable(null);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_givenAuditableDateCreatedIsDate_whenNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
   * Test {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_givenOrderImplCurrencyIsNull_whenNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
   * Test {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs zero is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_thenReturnAbsAbsAbsAbsAbsAbsAbsZeroIsMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    Money actualConvertToMoneyResult = bundleOrderItemFeePriceImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Money absResult = actualConvertToMoneyResult.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(amount, absResult6.abs().zero());
    assertEquals(amount, absResult6.zero());
    assertEquals(amount, absResult5.zero());
    assertEquals(amount, absResult4.zero());
    assertEquals(amount, absResult3.zero());
    assertEquals(amount, absResult2.zero());
    assertEquals(amount, absResult.zero());
    assertEquals(amount, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs zero is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BundleOrderItemFeePriceImpl#convertToMoney(BigDecimal)}
   */
  @Test
  public void testConvertToMoney_thenReturnAbsAbsAbsAbsAbsAbsAbsZeroIsZero() {
    // Arrange
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    bundleOrderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setBundleOrderItem(bundleOrderItem);

    // Act
    Money actualConvertToMoneyResult = bundleOrderItemFeePriceImpl.convertToMoney(new BigDecimal("2.3"));

    // Assert
    Money money = actualConvertToMoneyResult.ZERO;
    Money absResult = actualConvertToMoneyResult.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(money, absResult6.abs().zero());
    assertEquals(money, absResult6.zero());
    assertEquals(money, absResult5.zero());
    assertEquals(money, absResult4.zero());
    assertEquals(money, absResult3.zero());
    assertEquals(money, absResult2.zero());
    assertEquals(money, absResult.zero());
    assertEquals(money, actualConvertToMoneyResult.zero());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#clone()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemFeePriceImpl} (default constructor).</li>
   *   <li>Then return {@link BundleOrderItemFeePriceImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#clone()}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#clone()}
   */
  @Test
  public void testClone_givenOrderImplCurrencyIsNull_thenReturnName() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
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
    assertEquals("Name", actualCloneResult.getName());
    assertEquals("Reporting Code", actualCloneResult.getReportingCode());
    assertNull(actualCloneResult.getId());
    assertFalse(actualCloneResult.isTaxable());
    assertEquals(new BigDecimal("0.00"), ((BundleOrderItemFeePriceImpl) actualCloneResult).amount);
    assertEquals(amount, actualCloneResult.getAmount());
    assertSame(bundleOrderItem, actualCloneResult.getBundleOrderItem());
  }

  /**
   * Test
   * {@link BundleOrderItemFeePriceImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link BundleOrderItemFeePriceImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<BundleOrderItemFeePrice> actualCreateOrRetrieveCopyInstanceResult = bundleOrderItemFeePriceImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and
   * {@link BundleOrderItemFeePriceImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = bundleOrderItemFeePriceImpl.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and
   * {@link BundleOrderItemFeePriceImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = bundleOrderItemFeePriceImpl.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and
   * {@link BundleOrderItemFeePriceImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = bundleOrderItemFeePriceImpl.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and
   * {@link BundleOrderItemFeePriceImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = bundleOrderItemFeePriceImpl.hashCode();
    assertEquals(expectedHashCodeResult, bundleOrderItemFeePriceImpl2.hashCode());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#equals(Object)}, and
   * {@link BundleOrderItemFeePriceImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BundleOrderItemFeePriceImpl#equals(Object)}
   *   <li>{@link BundleOrderItemFeePriceImpl#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    bundleOrderItemFeePriceImpl.setAmount(mock(Money.class));
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#equals(Object)}
   */
  @Test
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
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BundleOrderItemFeePriceImpl}
   */
  @Test
  public void testNewBundleOrderItemFeePriceImpl() {
    // Arrange and Act
    BundleOrderItemFeePriceImpl actualBundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();

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
