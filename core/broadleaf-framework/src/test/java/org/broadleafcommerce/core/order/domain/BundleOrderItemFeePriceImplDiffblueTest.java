/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
   * Test {@link BundleOrderItemFeePriceImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemFeePriceImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#getAmount()}
   */
  @Test
  public void testGetAmount_givenBundleOrderItemFeePriceImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new BundleOrderItemFeePriceImpl()).getAmount());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#getAmount()}
   */
  @Test
  public void testGetAmount_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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

    // Act and Assert
    assertEquals(amount, bundleOrderItemFeePriceImpl.getAmount());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link BundleOrderItemFeePriceImpl} (default constructor)
   * {@link BundleOrderItemFeePriceImpl#amount} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount_whenMoney_thenBundleOrderItemFeePriceImplAmountIsBigDecimalWith000() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();
    Money amount = new Money();

    // Act
    bundleOrderItemFeePriceImpl.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), bundleOrderItemFeePriceImpl.amount);
    BigDecimal bigDecimal = bundleOrderItemFeePriceImpl.amount;
    Money absResult = amount.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    Money absResult3 = absResult2.abs();
    assertSame(bigDecimal, absResult3.getAmount());
    Money absResult4 = absResult3.abs();
    assertSame(bigDecimal, absResult4.getAmount());
    Money absResult5 = absResult4.abs();
    assertSame(bigDecimal, absResult5.getAmount());
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = amount.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult12 = zeroResult2.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(bigDecimal, absResult15.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(bigDecimal, absResult19.abs().getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(bigDecimal, absResult22.abs().getAmount());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertSame(bigDecimal, absResult25.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(bigDecimal, absResult28.abs().getAmount());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    Money zeroResult60 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
  }

  /**
   * Test {@link BundleOrderItemFeePriceImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link BundleOrderItemFeePriceImpl} (default constructor)
   * {@link BundleOrderItemFeePriceImpl#amount} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BundleOrderItemFeePriceImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount_whenNull_thenBundleOrderItemFeePriceImplAmountIsNull() {
    // Arrange
    BundleOrderItemFeePriceImpl bundleOrderItemFeePriceImpl = new BundleOrderItemFeePriceImpl();

    // Act
    bundleOrderItemFeePriceImpl.setAmount(null);

    // Assert
    assertNull(bundleOrderItemFeePriceImpl.amount);
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
