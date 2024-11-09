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
package org.broadleafcommerce.core.payment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class OrderPaymentImplDiffblueTest {
  /**
   * Test {@link OrderPaymentImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  public void testGetAmount_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    Money amount = new Money();
    orderPaymentImpl.setAmount(amount);
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertEquals(amount, orderPaymentImpl.getAmount());
  }

  /**
   * Test {@link OrderPaymentImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) Amount is
   * {@link Money}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  public void testGetAmount_givenOrderPaymentImplAmountIsMoney_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(mock(Money.class));

    // Act and Assert
    assertNull(orderPaymentImpl.getAmount());
  }

  /**
   * Test {@link OrderPaymentImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  public void testGetAmount_givenOrderPaymentImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getAmount());
  }

  /**
   * Test {@link OrderPaymentImpl#getAmount()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAmount()}
   */
  @Test
  public void testGetAmount_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BroadleafCurrencyImpl currency = mock(BroadleafCurrencyImpl.class);
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    Money amount = new Money();
    orderPaymentImpl.setAmount(amount);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualAmount = orderPaymentImpl.getAmount();

    // Assert
    verify(currency).getCurrencyCode();
    assertEquals(amount, actualAmount);
  }

  /**
   * Test {@link OrderPaymentImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link OrderPaymentImpl} (default constructor)
   * {@link OrderPaymentImpl#amount} is {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount_whenMoney_thenOrderPaymentImplAmountIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    Money amount = new Money();

    // Act
    orderPaymentImpl.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), orderPaymentImpl.amount);
    BigDecimal bigDecimal = orderPaymentImpl.amount;
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
   * Test {@link OrderPaymentImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   *   <li>Then {@link OrderPaymentImpl} (default constructor)
   * {@link OrderPaymentImpl#amount} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount_whenMoney_thenOrderPaymentImplAmountIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();

    // Act
    orderPaymentImpl.setAmount(mock(Money.class));

    // Assert
    assertNull(orderPaymentImpl.amount);
  }

  /**
   * Test {@link OrderPaymentImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link OrderPaymentImpl} (default constructor)
   * {@link OrderPaymentImpl#amount} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount_whenNull_thenOrderPaymentImplAmountIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();

    // Act
    orderPaymentImpl.setAmount(null);

    // Assert
    assertNull(orderPaymentImpl.amount);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentImpl#setBillingAddress(Address)}
   *   <li>{@link OrderPaymentImpl#setId(Long)}
   *   <li>{@link OrderPaymentImpl#setOrder(Order)}
   *   <li>{@link OrderPaymentImpl#setReferenceNumber(String)}
   *   <li>{@link OrderPaymentImpl#setTransactions(List)}
   *   <li>{@link OrderPaymentImpl#getBillingAddress()}
   *   <li>{@link OrderPaymentImpl#getId()}
   *   <li>{@link OrderPaymentImpl#getOrder()}
   *   <li>{@link OrderPaymentImpl#getReferenceNumber()}
   *   <li>{@link OrderPaymentImpl#getTransactions()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    AddressImpl billingAddress = new AddressImpl();

    // Act
    orderPaymentImpl.setBillingAddress(billingAddress);
    orderPaymentImpl.setId(1L);
    NullOrderImpl order = new NullOrderImpl();
    orderPaymentImpl.setOrder(order);
    orderPaymentImpl.setReferenceNumber("42");
    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    orderPaymentImpl.setTransactions(transactions);
    Address actualBillingAddress = orderPaymentImpl.getBillingAddress();
    Long actualId = orderPaymentImpl.getId();
    Order actualOrder = orderPaymentImpl.getOrder();
    String actualReferenceNumber = orderPaymentImpl.getReferenceNumber();
    List<PaymentTransaction> actualTransactions = orderPaymentImpl.getTransactions();

    // Assert that nothing has changed
    assertEquals("42", actualReferenceNumber);
    assertEquals(1L, actualId.longValue());
    assertSame(transactions, actualTransactions);
    assertSame(order, actualOrder);
    assertSame(billingAddress, actualBillingAddress);
  }

  /**
   * Test {@link OrderPaymentImpl#setType(PaymentType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) Type Type is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setType(PaymentType)}
   */
  @Test
  public void testSetType_givenType_thenOrderPaymentImplTypeTypeIsType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    PaymentType type = mock(PaymentType.class);
    when(type.getType()).thenReturn("Type");

    // Act
    orderPaymentImpl.setType(type);

    // Assert
    verify(type).getType();
    assertEquals("Type", orderPaymentImpl.getType().getType());
    assertEquals("Type", orderPaymentImpl.type);
  }

  /**
   * Test {@link OrderPaymentImpl#setType(PaymentType)}.
   * <ul>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) Type is
   * {@link PaymentType#PaymentType(String, String)} with {@code Type} and
   * {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setType(PaymentType)}
   */
  @Test
  public void testSetType_thenOrderPaymentImplTypeIsPaymentTypeWithTypeAndFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    PaymentType type = new PaymentType("Type", "Friendly Type");

    // Act
    orderPaymentImpl.setType(type);

    // Assert
    assertEquals("Type", orderPaymentImpl.type);
    assertEquals(type, orderPaymentImpl.getType());
  }

  /**
   * Test {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  public void testSetPaymentGatewayType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    PaymentGatewayType gatewayType = new PaymentGatewayType("Type", "Friendly Type");

    // Act
    orderPaymentImpl.setPaymentGatewayType(gatewayType);

    // Assert
    assertEquals("Type", orderPaymentImpl.gatewayType);
    assertEquals(gatewayType, orderPaymentImpl.getGatewayType());
  }

  /**
   * Test {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) GatewayType Type is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  public void testSetPaymentGatewayType_givenType_thenOrderPaymentImplGatewayTypeTypeIsType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    PaymentGatewayType gatewayType = mock(PaymentGatewayType.class);
    when(gatewayType.getType()).thenReturn("Type");

    // Act
    orderPaymentImpl.setPaymentGatewayType(gatewayType);

    // Assert
    verify(gatewayType).getType();
    assertEquals("Type", orderPaymentImpl.getGatewayType().getType());
    assertEquals("Type", orderPaymentImpl.gatewayType);
  }

  /**
   * Test {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}.
   * <ul>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) Transactions first is
   * {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}
   */
  @Test
  public void testAddTransaction_thenOrderPaymentImplTransactionsFirstIsPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    PaymentTransactionImpl transaction = new PaymentTransactionImpl();

    // Act
    orderPaymentImpl.addTransaction(transaction);

    // Assert
    List<PaymentTransaction> transactions = orderPaymentImpl.getTransactions();
    assertEquals(1, transactions.size());
    assertSame(transaction, transactions.get(0));
    assertSame(transaction, orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}.
   * <ul>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) Transactions first is
   * {@link PaymentTransactionImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}
   */
  @Test
  public void testAddTransaction_thenOrderPaymentImplTransactionsFirstIsPaymentTransactionImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);

    // Act
    orderPaymentImpl.addTransaction(transaction);

    // Assert
    List<PaymentTransaction> transactions = orderPaymentImpl.getTransactions();
    assertEquals(1, transactions.size());
    assertSame(transaction, transactions.get(0));
    assertSame(transaction, orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("42", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl
        .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(mock(PaymentTransactionType.class));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl
        .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType_givenOrderPaymentImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();

    // Act and Assert
    assertTrue(orderPaymentImpl.getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type")).isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>When {@link PaymentTransactionType}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType_givenOrderPaymentImpl_whenPaymentTransactionType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderPaymentImpl()).getTransactionsForType(mock(PaymentTransactionType.class)).isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl
        .getTransactionsForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertEquals(1, actualTransactionsForType.size());
  }

  /**
   * Test {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionsForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionsForType_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    List<PaymentTransaction> actualTransactionsForType = orderPaymentImpl.getTransactionsForType(null);

    // Assert
    verify(transaction).getType();
    assertTrue(actualTransactionsForType.isEmpty());
  }

  /**
   * Test {@link OrderPaymentImpl#getInitialTransaction()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  public void testGetInitialTransaction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setParentTransaction(new PaymentTransactionImpl());

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setTransactions(transactions);

    // Act and Assert
    assertNull(orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getInitialTransaction()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  public void testGetInitialTransaction_givenOrderPaymentImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getInitialTransaction()}.
   * <ul>
   *   <li>Then return {@link PaymentTransactionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  public void testGetInitialTransaction_thenReturnPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setParentTransaction(null);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setTransactions(transactions);

    // Act
    PaymentTransaction actualInitialTransaction = orderPaymentImpl.getInitialTransaction();

    // Assert
    assertTrue(actualInitialTransaction instanceof PaymentTransactionImpl);
    BigDecimal bigDecimal = orderPaymentImpl.amount;
    Money amount = actualInitialTransaction.getAmount();
    Money absResult = amount.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = amount.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult6.getAmount());
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
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult5.getAmount());
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
    assertSame(bigDecimal, absResult15.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(bigDecimal, absResult28.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult7 = absResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    assertSame(bigDecimal, absResult30.abs().getAmount());
    Money zeroResult8 = absResult8.zero();
    Money absResult31 = zeroResult8.abs();
    Money absResult32 = absResult31.abs();
    assertSame(bigDecimal, absResult32.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult9 = absResult12.zero();
    Money absResult33 = zeroResult9.abs();
    Money absResult34 = absResult33.abs();
    assertSame(bigDecimal, absResult34.abs().getAmount());
    Money zeroResult10 = absResult16.zero();
    Money absResult35 = zeroResult10.abs();
    Money absResult36 = absResult35.abs();
    assertSame(bigDecimal, absResult36.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult11 = zeroResult4.zero();
    Money absResult37 = zeroResult11.abs();
    Money absResult38 = absResult37.abs();
    assertSame(bigDecimal, absResult38.abs().getAmount());
    Money zeroResult12 = zeroResult5.zero();
    Money absResult39 = zeroResult12.abs();
    Money absResult40 = absResult39.abs();
    assertSame(bigDecimal, absResult40.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult13 = zeroResult6.zero();
    Money absResult41 = zeroResult13.abs();
    Money absResult42 = absResult41.abs();
    assertSame(bigDecimal, absResult42.abs().getAmount());
    Money zeroResult14 = zeroResult3.zero();
    Money absResult43 = zeroResult14.abs();
    Money absResult44 = absResult43.abs();
    assertSame(bigDecimal, absResult44.abs().getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult15 = absResult4.zero();
    Money absResult45 = zeroResult15.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult16 = absResult9.zero();
    Money absResult46 = zeroResult16.abs();
    assertSame(bigDecimal, absResult46.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    Money zeroResult17 = absResult13.zero();
    Money absResult47 = zeroResult17.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    Money zeroResult18 = absResult17.zero();
    Money absResult48 = zeroResult18.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult19 = absResult20.zero();
    Money absResult49 = zeroResult19.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    Money zeroResult20 = absResult23.zero();
    Money absResult50 = zeroResult20.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    Money zeroResult21 = absResult26.zero();
    Money absResult51 = zeroResult21.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult22 = zeroResult7.zero();
    Money absResult52 = zeroResult22.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult23 = zeroResult8.zero();
    Money absResult53 = zeroResult23.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    Money zeroResult24 = zeroResult9.zero();
    Money absResult54 = zeroResult24.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult25 = zeroResult10.zero();
    Money absResult55 = zeroResult25.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult26 = zeroResult11.zero();
    Money absResult56 = zeroResult26.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult27 = zeroResult12.zero();
    Money absResult57 = zeroResult27.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    Money zeroResult28 = zeroResult13.zero();
    Money absResult58 = zeroResult28.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult29 = zeroResult14.zero();
    Money absResult59 = zeroResult29.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult30 = absResult5.zero();
    assertSame(bigDecimal, zeroResult30.abs().getAmount());
    Money zeroResult31 = absResult10.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult32 = absResult14.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    Money zeroResult33 = absResult18.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    Money zeroResult34 = absResult21.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    Money zeroResult35 = absResult24.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    Money zeroResult36 = absResult27.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult37 = absResult29.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult31.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    Money zeroResult39 = absResult33.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult35.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult41 = absResult37.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult39.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    Money zeroResult43 = absResult41.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult43.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult45 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult55 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    Money zeroResult56 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult57 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    Money zeroResult58 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, absResult30.zero().getAmount());
    assertSame(bigDecimal, absResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, absResult34.zero().getAmount());
    assertSame(bigDecimal, absResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, absResult38.zero().getAmount());
    assertSame(bigDecimal, absResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, absResult42.zero().getAmount());
    assertSame(bigDecimal, absResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult30.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, amount.getAmount());
  }

  /**
   * Test {@link OrderPaymentImpl#getInitialTransaction()}.
   * <ul>
   *   <li>Then return {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getInitialTransaction()}
   */
  @Test
  public void testGetInitialTransaction_thenReturnPaymentTransactionImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl
        .setDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    paymentTransactionImpl.setParentTransaction(null);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(mock(Money.class));
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setTransactions(transactions);

    // Act and Assert
    assertSame(paymentTransactionImpl, orderPaymentImpl.getInitialTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  public void testGetAuthorizeTransaction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());

    // Act and Assert
    assertNull(orderPaymentImpl.getAuthorizeTransaction());
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  public void testGetAuthorizeTransaction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    PaymentTransaction actualAuthorizeTransaction = orderPaymentImpl.getAuthorizeTransaction();

    // Assert
    verify(transaction, atLeast(1)).getType();
    assertNull(actualAuthorizeTransaction);
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  public void testGetAuthorizeTransaction3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    orderPaymentImpl.getAuthorizeTransaction();

    // Assert
    verify(transaction).getType();
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  public void testGetAuthorizeTransaction4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    orderPaymentImpl.getAuthorizeTransaction();

    // Assert
    verify(transaction, atLeast(1)).getType();
  }

  /**
   * Test {@link OrderPaymentImpl#getAuthorizeTransaction()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getAuthorizeTransaction()}
   */
  @Test
  public void testGetAuthorizeTransaction_givenOrderPaymentImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getAuthorizeTransaction());
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    PaymentTransactionImpl transaction2 = new PaymentTransactionImpl();
    transaction2.setOrderPayment(new OrderPaymentImpl());

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction2);
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl.getTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType_givenOrderPaymentImplOrderIsNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl}
   * {@link PaymentTransactionImpl#getType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType_givenPaymentTransactionImplGetTypeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    Money money = new Money();
    when(transaction.getAmount()).thenReturn(money);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getAmount();
    verify(transaction).getType();
    assertEquals(money, actualTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link PaymentTransactionType#PaymentTransactionType()}.</li>
   *   <li>Then calls {@link PaymentTransactionImpl#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType_whenPaymentTransactionType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl.getTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link PaymentTransactionType}.</li>
   *   <li>Then calls {@link PaymentTransactionImpl#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetTransactionAmountForType_whenPaymentTransactionType_thenCallsGetType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualTransactionAmountForType = orderPaymentImpl
        .getTransactionAmountForType(mock(PaymentTransactionType.class));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualTransactionAmountForType.ZERO, actualTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    PaymentTransactionImpl transaction2 = new PaymentTransactionImpl();
    transaction2.setOrderPayment(new OrderPaymentImpl());

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction2);
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    Money money = new Money();
    when(transaction.getAmount()).thenReturn(money);
    when(transaction.getSuccess()).thenReturn(true);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getAmount();
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertEquals(money, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link PaymentTransactionType#PaymentTransactionType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType_whenPaymentTransactionType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(new PaymentTransactionType());

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link PaymentTransactionType}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#getSuccessfulTransactionAmountForType(PaymentTransactionType)}
   */
  @Test
  public void testGetSuccessfulTransactionAmountForType_whenPaymentTransactionType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);
    orderPaymentImpl.setOrder(order);

    // Act
    Money actualSuccessfulTransactionAmountForType = orderPaymentImpl
        .getSuccessfulTransactionAmountForType(mock(PaymentTransactionType.class));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(transaction).getType();
    assertEquals(actualSuccessfulTransactionAmountForType.ZERO, actualSuccessfulTransactionAmountForType);
  }

  /**
   * Test {@link OrderPaymentImpl#getStatus()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getStatus()}
   */
  @Test
  public void testGetStatus_givenOrderPaymentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getStatus());
  }

  /**
   * Test {@link OrderPaymentImpl#getStatus()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) addTransaction
   * {@link PaymentTransactionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getStatus()}
   */
  @Test
  public void testGetStatus_givenOrderPaymentImplAddTransactionPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(mock(PaymentTransactionImpl.class));

    // Act and Assert
    assertNull(orderPaymentImpl.getStatus());
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(transaction, atLeast(1)).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(true);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(transaction).getSuccess();
    verify(transaction, atLeast(1)).getType();
    assertTrue(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) addTransaction
   * {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed_givenOrderPaymentImplAddTransactionPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(new PaymentTransactionImpl());

    // Act and Assert
    assertFalse(orderPaymentImpl.isConfirmed());
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed_givenOrderPaymentImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderPaymentImpl()).isConfirmed());
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl}
   * {@link PaymentTransactionImpl#getSuccess()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed_givenPaymentTransactionImplGetSuccessReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(false);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl}
   * {@link PaymentTransactionImpl#getSuccess()} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed_givenPaymentTransactionImplGetSuccessReturnTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(true);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("AUTHORIZE_AND_CAPTURE", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertTrue(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#isConfirmed()}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl}
   * {@link PaymentTransactionImpl#getType()} return {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isConfirmed()}
   */
  @Test
  public void testIsConfirmed_givenPaymentTransactionImplGetTypeReturnNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(transaction);

    // Act
    boolean actualIsConfirmedResult = orderPaymentImpl.isConfirmed();

    // Assert
    verify(transaction, atLeast(1)).getType();
    assertFalse(actualIsConfirmedResult);
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_givenOrderPaymentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getCurrency());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) Amount is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_givenOrderPaymentImplAmountIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrency());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) Amount is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_givenOrderPaymentImplAmountIsMoney2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(mock(Money.class));
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setOrder(new NullOrderImpl());

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrency());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@link BroadleafCurrencyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(new BroadleafCurrencyImpl());

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenOrderPaymentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderPaymentImpl()).getCurrencyCode());
  }

  /**
   * Test {@link OrderPaymentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) Amount is
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenOrderPaymentImplAmountIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(mock(Money.class));
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));
    orderPaymentImpl.setOrder(order);

    // Act and Assert
    assertNull(orderPaymentImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderPaymentImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenOrderPaymentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new OrderPaymentImpl()).getArchived().charValue());
  }

  /**
   * Test {@link OrderPaymentImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) addTransaction
   * {@link PaymentTransactionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenOrderPaymentImplAddTransactionPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(mock(PaymentTransactionImpl.class));

    // Act and Assert
    assertEquals('N', orderPaymentImpl.getArchived().charValue());
  }

  /**
   * Test {@link OrderPaymentImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenOrderPaymentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();

    // Act
    orderPaymentImpl.setArchived('A');

    // Assert
    assertEquals('A', orderPaymentImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', orderPaymentImpl.getArchived().charValue());
  }

  /**
   * Test {@link OrderPaymentImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) addTransaction
   * {@link PaymentTransactionImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenOrderPaymentImplAddTransactionPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.addTransaction(mock(PaymentTransactionImpl.class));

    // Act
    orderPaymentImpl.setArchived('A');

    // Assert
    assertEquals('A', orderPaymentImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', orderPaymentImpl.getArchived().charValue());
  }

  /**
   * Test {@link OrderPaymentImpl#isActive()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor) Archived is
   * {@code Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isActive()}
   */
  @Test
  public void testIsActive_givenOrderPaymentImplArchivedIsY_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setArchived('Y');

    // Act and Assert
    assertFalse(orderPaymentImpl.isActive());
  }

  /**
   * Test {@link OrderPaymentImpl#isActive()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#isActive()}
   */
  @Test
  public void testIsActive_givenOrderPaymentImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderPaymentImpl()).isActive());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}, and
   * {@link OrderPaymentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setOrder(new NullOrderImpl());
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertEquals(orderPaymentImpl, orderPaymentImpl2);
    int expectedHashCodeResult = orderPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentImpl2.hashCode());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}, and
   * {@link OrderPaymentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(mock(Money.class));
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setOrder(new NullOrderImpl());
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertEquals(orderPaymentImpl, orderPaymentImpl2);
    int expectedHashCodeResult = orderPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentImpl2.hashCode());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}, and
   * {@link OrderPaymentImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderPaymentImpl#equals(Object)}
   *   <li>{@link OrderPaymentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertEquals(orderPaymentImpl, orderPaymentImpl);
    int expectedHashCodeResult = orderPaymentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentImpl.hashCode());
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(2L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setAmount(new Money());
    orderPaymentImpl2.setBillingAddress(new AddressImpl());
    orderPaymentImpl2.setId(1L);
    orderPaymentImpl2.setOrder(new NullOrderImpl());
    orderPaymentImpl2.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl2.setReferenceNumber("42");
    orderPaymentImpl2.setTransactions(new ArrayList<>());
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(orderPaymentImpl, orderPaymentImpl2);
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(orderPaymentImpl, null);
  }

  /**
   * Test {@link OrderPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    orderPaymentImpl.setAmount(new Money());
    orderPaymentImpl.setBillingAddress(new AddressImpl());
    orderPaymentImpl.setId(1L);
    orderPaymentImpl.setOrder(new NullOrderImpl());
    orderPaymentImpl.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    orderPaymentImpl.setReferenceNumber("42");
    orderPaymentImpl.setTransactions(new ArrayList<>());
    orderPaymentImpl.setType(new PaymentType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(orderPaymentImpl, "Different type to OrderPaymentImpl");
  }

  /**
   * Test
   * {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderPayment> actualCreateOrRetrieveCopyInstanceResult = orderPaymentImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link OrderPaymentImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnOrderPaymentImpl() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentImpl orderPaymentImpl = new OrderPaymentImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<OrderPayment> actualCreateOrRetrieveCopyInstanceResult = orderPaymentImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService).getCeilingImplClass(eq("org.broadleafcommerce.core.payment.domain.OrderPaymentImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    OrderPayment clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof OrderPaymentImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(orderPaymentImpl, clone);
  }
}
