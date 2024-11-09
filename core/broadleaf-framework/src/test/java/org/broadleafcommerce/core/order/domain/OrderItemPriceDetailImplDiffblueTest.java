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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class OrderItemPriceDetailImplDiffblueTest {
  /**
   * Test
   * {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}
   */
  @Test
  public void testGetFutureCreditOrderItemPriceDetailAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act and Assert
    assertTrue(orderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}
   */
  @Test
  public void testGetFutureCreditOrderItemPriceDetailAdjustments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(new OrderItemPriceDetailAdjustmentImpl());

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl.setOrderItem(mock(OrderItem.class));
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act and Assert
    assertTrue(orderItemPriceDetailImpl.getFutureCreditOrderItemPriceDetailAdjustments().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}
   */
  @Test
  public void testGetFutureCreditOrderItemPriceDetailAdjustments_givenOrderItemPriceDetailImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderItemPriceDetailImpl()).getFutureCreditOrderItemPriceDetailAdjustments().isEmpty());
  }

  /**
   * Test
   * {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#getFutureCreditOrderItemPriceDetailAdjustments()}
   */
  @Test
  public void testGetFutureCreditOrderItemPriceDetailAdjustments_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = mock(
        OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.isFutureCredit()).thenReturn(true);

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act
    List<OrderItemPriceDetailAdjustment> actualFutureCreditOrderItemPriceDetailAdjustments = orderItemPriceDetailImpl
        .getFutureCreditOrderItemPriceDetailAdjustments();

    // Assert
    verify(orderItemPriceDetailAdjustmentImpl).isFutureCredit();
    assertEquals(1, actualFutureCreditOrderItemPriceDetailAdjustments.size());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is
   * {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_givenAuditableCreatedByIsSerialVersionUID_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl.setOrderItem(orderItem);
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);

    // Act and Assert
    assertNull(orderItemPriceDetailImpl.getCurrency());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrency()}.
   * <ul>
   *   <li>Then calls {@link OrderItemImpl#getOrder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getCurrency()}
   */
  @Test
  public void testGetCurrency_thenCallsGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl.setOrderItem(orderItem);
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);

    // Act
    BroadleafCurrency actualCurrency = orderItemPriceDetailImpl.getCurrency();

    // Assert
    verify(orderItem).getOrder();
    assertNull(actualCurrency);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getAdjustmentValue()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getAdjustmentValue()}
   */
  @Test
  public void testGetAdjustmentValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualAdjustmentValue = orderItemPriceDetailImpl.getAdjustmentValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualAdjustmentValue.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getAdjustmentValue()}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs Amount is {@link OrderImpl}
   * (default constructor) {@link OrderImpl#totalTax}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getAdjustmentValue()}
   */
  @Test
  public void testGetAdjustmentValue_thenReturnAbsAbsAbsAbsAbsAbsAbsAmountIsOrderImplTotalTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(currency);
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualAdjustmentValue = orderItemPriceDetailImpl.getAdjustmentValue();

    // Assert
    verify(currency).getCurrencyCode();
    verify(orderItem).getOrder();
    BigDecimal bigDecimal = orderImpl.totalTax;
    Money absResult = actualAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualAdjustmentValue.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getAdjustmentValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getAdjustmentValue()}
   */
  @Test
  public void testGetAdjustmentValue_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualAdjustmentValue = orderItemPriceDetailImpl.getAdjustmentValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualAdjustmentValue.ZERO, actualAdjustmentValue);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}
   */
  @Test
  public void testGetFutureCreditAdjustmentValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditAdjustmentValue = orderItemPriceDetailImpl.getFutureCreditAdjustmentValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualFutureCreditAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualFutureCreditAdjustmentValue.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}
   */
  @Test
  public void testGetFutureCreditAdjustmentValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(currency);
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditAdjustmentValue = orderItemPriceDetailImpl.getFutureCreditAdjustmentValue();

    // Assert
    verify(currency).getCurrencyCode();
    verify(orderItem).getOrder();
    BigDecimal bigDecimal = orderImpl.totalTax;
    Money absResult = actualFutureCreditAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualFutureCreditAdjustmentValue.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#getFutureCreditAdjustmentValue()}
   */
  @Test
  public void testGetFutureCreditAdjustmentValue_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditAdjustmentValue = orderItemPriceDetailImpl.getFutureCreditAdjustmentValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualFutureCreditAdjustmentValue.ZERO, actualFutureCreditAdjustmentValue);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getRoundingModeForAdj()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getRoundingModeForAdj()}
   */
  @Test
  public void testGetRoundingModeForAdj() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(mock(BundleOrderItemImpl.class));

    // Act and Assert
    assertEquals(RoundingMode.HALF_EVEN, orderItemPriceDetailImpl.getRoundingModeForAdj());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getRoundingModeForAdj()}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getRoundingModeForAdj()}
   */
  @Test
  public void testGetRoundingModeForAdj_givenOrderItemPriceDetailImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(RoundingMode.HALF_EVEN, (new OrderItemPriceDetailImpl()).getRoundingModeForAdj());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}
   */
  @Test
  public void testGetTotalAdjustmentValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentValue = orderItemPriceDetailImpl.getTotalAdjustmentValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualTotalAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualTotalAdjustmentValue.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}.
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}
   */
  @Test
  public void testGetTotalAdjustmentValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(currency);
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentValue = orderItemPriceDetailImpl.getTotalAdjustmentValue();

    // Assert
    verify(currency).getCurrencyCode();
    verify(orderItem).getOrder();
    BigDecimal bigDecimal = orderImpl.totalTax;
    Money absResult = actualTotalAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualTotalAdjustmentValue.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustmentValue()}
   */
  @Test
  public void testGetTotalAdjustmentValue_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustmentValue = orderItemPriceDetailImpl.getTotalAdjustmentValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualTotalAdjustmentValue.ZERO, actualTotalAdjustmentValue);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  public void testGetFutureCreditTotalAdjustmentValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditTotalAdjustmentValue = orderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualFutureCreditTotalAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualFutureCreditTotalAdjustmentValue.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  public void testGetFutureCreditTotalAdjustmentValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(currency);
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAdjustments(new ArrayList<>());
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditTotalAdjustmentValue = orderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue();

    // Assert
    verify(currency).getCurrencyCode();
    verify(orderItem).getOrder();
    BigDecimal bigDecimal = orderImpl.totalTax;
    Money absResult = actualFutureCreditTotalAdjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualFutureCreditTotalAdjustmentValue.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#getFutureCreditTotalAdjustmentValue()}
   */
  @Test
  public void testGetFutureCreditTotalAdjustmentValue_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualFutureCreditTotalAdjustmentValue = orderItemPriceDetailImpl.getFutureCreditTotalAdjustmentValue();

    // Assert
    verify(orderItem).getOrder();
    assertEquals(actualFutureCreditTotalAdjustmentValue.ZERO, actualFutureCreditTotalAdjustmentValue);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderItemPriceDetailImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  public void testGetTotalAdjustedPrice_givenArrayListAddOrderItemPriceDetailImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(new OrderItemPriceDetailImpl());

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(order);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(orderItemPriceDetails);
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl.getTotalAdjustedPrice();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualTotalAdjustedPrice.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualTotalAdjustedPrice.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderItemPriceDetailImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  public void testGetTotalAdjustedPrice_givenArrayListAddOrderItemPriceDetailImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    ArrayList<OrderItemPriceDetail> orderItemPriceDetails = new ArrayList<>();
    orderItemPriceDetails.add(new OrderItemPriceDetailImpl());
    orderItemPriceDetails.add(new OrderItemPriceDetailImpl());

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(order);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(orderItemPriceDetails);
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl.getTotalAdjustedPrice();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualTotalAdjustedPrice.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualTotalAdjustedPrice.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is
   * {@link OrderItemQualifierImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  public void testGetTotalAdjustedPrice_givenAuditableCreatedByIsSerialVersionUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl.getTotalAdjustedPrice();

    // Assert
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualTotalAdjustedPrice.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualTotalAdjustedPrice.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Order is
   * {@link NullOrderFactoryImpl#NULL_ORDER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  public void testGetTotalAdjustedPrice_givenOrderItemImplOrderIsNull_order() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItem.setName("Name");
    orderItem.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl.getTotalAdjustedPrice();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualTotalAdjustedPrice.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualTotalAdjustedPrice.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  public void testGetTotalAdjustedPrice_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(order);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl.getTotalAdjustedPrice();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    BigDecimal bigDecimal = orderItem.salePrice;
    Money absResult = actualTotalAdjustedPrice.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = actualTotalAdjustedPrice.zero();
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
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult4.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult2.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult60 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getTotalAdjustedPrice()}
   */
  @Test
  public void testGetTotalAdjustedPrice_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = mock(Auditable.class);
    doNothing().when(auditable).setCreatedBy(Mockito.<Long>any());
    doNothing().when(auditable).setDateCreated(Mockito.<Date>any());
    doNothing().when(auditable).setDateUpdated(Mockito.<Date>any());
    doNothing().when(auditable).setUpdatedBy(Mockito.<Long>any());
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrder(order);
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    Money retailPrice = new Money();
    orderItem.setRetailPrice(retailPrice);
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money(10.0d));
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    Money actualTotalAdjustedPrice = orderItemPriceDetailImpl.getTotalAdjustedPrice();

    // Assert
    verify(auditable).setCreatedBy(eq(1L));
    verify(auditable).setDateCreated(isA(Date.class));
    verify(auditable).setDateUpdated(isA(Date.class));
    verify(auditable).setUpdatedBy(eq(1L));
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(retailPrice, actualTotalAdjustedPrice);
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getUseSalePrice()}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl} (default constructor) OrderItem is
   * {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getUseSalePrice()}
   */
  @Test
  public void testGetUseSalePrice_givenOrderItemPriceDetailImplOrderItemIsBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(mock(BundleOrderItemImpl.class));

    // Act and Assert
    assertTrue(orderItemPriceDetailImpl.getUseSalePrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getUseSalePrice()}.
   * <ul>
   *   <li>Given {@link OrderItemPriceDetailImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getUseSalePrice()}
   */
  @Test
  public void testGetUseSalePrice_givenOrderItemPriceDetailImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderItemPriceDetailImpl()).getUseSalePrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getUseSalePrice()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getUseSalePrice()}
   */
  @Test
  public void testGetUseSalePrice_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setUseSalePrice(false);

    // Act and Assert
    assertFalse(orderItemPriceDetailImpl.getUseSalePrice());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertNull(orderItemPriceDetailImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemPriceDetailImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemPriceDetailImpl.setQuantity(1);
    orderItemPriceDetailImpl.setUseSalePrice(true);
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act and Assert
    assertNull(orderItemPriceDetailImpl.getCurrencyCode());
  }

  /**
   * Test {@link OrderItemPriceDetailImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Then calls {@link OrderItemImpl#getOrder()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemPriceDetailImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_thenCallsGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    orderItemPriceDetailImpl.setOrderItem(orderItem);

    // Act
    String actualCurrencyCode = orderItemPriceDetailImpl.getCurrencyCode();

    // Assert
    verify(orderItem).getOrder();
    assertNull(actualCurrencyCode);
  }

  /**
   * Test
   * {@link OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OrderItemPriceDetail> actualCreateOrRetrieveCopyInstanceResult = orderItemPriceDetailImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link OrderItemPriceDetailImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemPriceDetailImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnOrderItemPriceDetailImpl()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemPriceDetailImpl orderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<OrderItemPriceDetail> actualCreateOrRetrieveCopyInstanceResult = orderItemPriceDetailImpl
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    OrderItemPriceDetail clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof OrderItemPriceDetailImpl);
    assertNull(clone.getId());
    assertNull(clone.getOrderItem());
    assertEquals(0, clone.getQuantity());
    assertEquals(RoundingMode.HALF_EVEN, ((OrderItemPriceDetailImpl) clone).getRoundingModeForAdj());
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertTrue(clone.getFutureCreditOrderItemPriceDetailAdjustments().isEmpty());
    assertTrue(clone.getOrderItemPriceDetailAdjustments().isEmpty());
    assertTrue(clone.getUseSalePrice());
    assertTrue(((OrderItemPriceDetailImpl) clone).useSalePrice);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderItemPriceDetailImpl}
   *   <li>{@link OrderItemPriceDetailImpl#setId(Long)}
   *   <li>{@link OrderItemPriceDetailImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemPriceDetailImpl#setOrderItemAdjustments(List)}
   *   <li>{@link OrderItemPriceDetailImpl#setQuantity(int)}
   *   <li>{@link OrderItemPriceDetailImpl#getId()}
   *   <li>{@link OrderItemPriceDetailImpl#getOrderItem()}
   *   <li>{@link OrderItemPriceDetailImpl#getOrderItemPriceDetailAdjustments()}
   *   <li>{@link OrderItemPriceDetailImpl#getQuantity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemPriceDetailImpl actualOrderItemPriceDetailImpl = new OrderItemPriceDetailImpl();
    actualOrderItemPriceDetailImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderItemPriceDetailImpl.setOrderItem(orderItem);
    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    actualOrderItemPriceDetailImpl.setOrderItemAdjustments(orderItemPriceDetailAdjustments);
    actualOrderItemPriceDetailImpl.setQuantity(1);
    Long actualId = actualOrderItemPriceDetailImpl.getId();
    OrderItem actualOrderItem = actualOrderItemPriceDetailImpl.getOrderItem();
    List<OrderItemPriceDetailAdjustment> actualOrderItemPriceDetailAdjustments = actualOrderItemPriceDetailImpl
        .getOrderItemPriceDetailAdjustments();

    // Assert that nothing has changed
    assertEquals(1, actualOrderItemPriceDetailImpl.getQuantity());
    assertTrue(actualOrderItemPriceDetailAdjustments.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItemPriceDetailAdjustments, actualOrderItemPriceDetailAdjustments);
    assertSame(orderItem, actualOrderItem);
  }
}
