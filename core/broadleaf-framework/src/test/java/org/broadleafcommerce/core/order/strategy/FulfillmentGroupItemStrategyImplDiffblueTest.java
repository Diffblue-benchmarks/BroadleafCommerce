/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.core.order.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.call.FulfillmentGroupItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class FulfillmentGroupItemStrategyImplDiffblueTest {
  @InjectMocks private FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded() throws PricingException {
    // Arrange
    when(fulfillmentGroupService.createEmptyFulfillmentGroup())
        .thenThrow(new IllegalStateException());
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemAdded(request));
    verify(fulfillmentGroupService).createEmptyFulfillmentGroup();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded2() throws PricingException {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    request.setOrderItem(new BundleOrderItemImpl());

    // Act
    CartOperationRequest actualOnItemAddedResult =
        fulfillmentGroupItemStrategyImpl.onItemAdded(request);

    // Assert
    assertSame(request, actualOnItemAddedResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded3() throws PricingException {
    // Arrange
    when(fulfillmentGroupService.addItemToFulfillmentGroup(
            Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(), anyBoolean()))
        .thenThrow(new IllegalStateException());
    when(fulfillmentGroupService.createEmptyFulfillmentGroup())
        .thenReturn(new FulfillmentGroupImpl());

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

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);
    when(request.getOrderItem()).thenReturn(orderItemImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemAdded(request));
    verify(fulfillmentGroupService)
        .addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false), eq(false));
    verify(fulfillmentGroupService).createEmptyFulfillmentGroup();
    verify(request).getOrder();
    verify(request).getOrderItem();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded_givenArrayListAddFulfillmentGroupImpl() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    // Act
    CartOperationRequest actualOnItemAddedResult =
        fulfillmentGroupItemStrategyImpl.onItemAdded(request);

    // Assert
    verify(request).getOrder();
    verify(request).getOrderItem();
    assertSame(request, actualOnItemAddedResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded_givenArrayListAddFulfillmentGroupImpl2() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    // Act
    CartOperationRequest actualOnItemAddedResult =
        fulfillmentGroupItemStrategyImpl.onItemAdded(request);

    // Assert
    verify(request).getOrder();
    verify(request).getOrderItem();
    assertSame(request, actualOnItemAddedResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#getType()} return {@link
   *       FulfillmentType#DIGITAL}.
   *   <li>Then calls {@link FulfillmentGroupImpl#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded_givenFulfillmentGroupImplGetTypeReturnDigital_thenCallsGetType()
      throws PricingException {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(FulfillmentType.DIGITAL);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new IllegalStateException());

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);
    when(request.getOrderItem()).thenReturn(bundleOrderItemImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemAdded(request));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getType();
    verify(request).getOrder();
    verify(request).getOrderItem();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#getType()} return {@link
   *       FulfillmentType#FulfillmentType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded_givenFulfillmentGroupImplGetTypeReturnFulfillmentType()
      throws PricingException {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(new FulfillmentType());

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new IllegalStateException());

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);
    when(request.getOrderItem()).thenReturn(bundleOrderItemImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemAdded(request));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getType();
    verify(request).getOrder();
    verify(request).getOrderItem();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#getType()} return {@link
   *       FulfillmentType}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded_givenFulfillmentGroupImplGetTypeReturnFulfillmentType2()
      throws PricingException {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getType()).thenReturn(mock(FulfillmentType.class));

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new IllegalStateException());

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);
    when(request.getOrderItem()).thenReturn(bundleOrderItemImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemAdded(request));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(fulfillmentGroupImpl, atLeast(1)).getType();
    verify(request).getOrder();
    verify(request).getOrderItem();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       FulfillmentGroupService#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   *       boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded_thenCallsAddItemToFulfillmentGroup() throws PricingException {
    // Arrange
    when(fulfillmentGroupService.addItemToFulfillmentGroup(
            Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(), anyBoolean()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.createEmptyFulfillmentGroup())
        .thenReturn(new FulfillmentGroupImpl());

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

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);
    when(request.getOrderItem()).thenReturn(orderItemImpl);

    // Act
    CartOperationRequest actualOnItemAddedResult =
        fulfillmentGroupItemStrategyImpl.onItemAdded(request);

    // Assert
    verify(fulfillmentGroupService)
        .addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false), eq(false));
    verify(fulfillmentGroupService).createEmptyFulfillmentGroup();
    verify(request).getOrder();
    verify(request).getOrderItem();
    assertSame(request, actualOnItemAddedResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       FulfillmentGroupService#addItemToFulfillmentGroup(FulfillmentGroupItemRequest, boolean,
   *       boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded_thenCallsAddItemToFulfillmentGroup2() throws PricingException {
    // Arrange
    when(fulfillmentGroupService.addItemToFulfillmentGroup(
            Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(), anyBoolean()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
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

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);
    when(request.getOrderItem()).thenReturn(orderItemImpl);

    // Act
    CartOperationRequest actualOnItemAddedResult =
        fulfillmentGroupItemStrategyImpl.onItemAdded(request);

    // Assert
    verify(fulfillmentGroupService)
        .addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false), eq(false));
    verify(request).getOrder();
    verify(request).getOrderItem();
    assertSame(request, actualOnItemAddedResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded_thenCallsGetDiscreteOrderItems() throws PricingException {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

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

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new IllegalStateException());

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);
    when(request.getOrderItem()).thenReturn(bundleOrderItemImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemAdded(request));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(request).getOrder();
    verify(request).getOrderItem();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <ul>
   *   <li>When {@link CartOperationRequest} {@link CartOperationRequest#getOrderItem()} return
   *       {@link BundleOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded_whenCartOperationRequestGetOrderItemReturnBundleOrderItemImpl()
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

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    // Act
    CartOperationRequest actualOnItemAddedResult =
        fulfillmentGroupItemStrategyImpl.onItemAdded(request);

    // Assert
    verify(request).getOrder();
    verify(request).getOrderItem();
    assertSame(request, actualOnItemAddedResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"
  })
  public void testResolveFulfillmentTypeWithDiscreteOrderItem() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getFulfillmentType()).thenReturn(FulfillmentType.DIGITAL);

    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult =
        fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(discreteOrderItem);

    // Assert
    verify(skuImpl, atLeast(1)).getFulfillmentType();
    verify(discreteOrderItem).getSku();
    assertSame(FulfillmentType.DIGITAL, actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"
  })
  public void testResolveFulfillmentTypeWithDiscreteOrderItem2() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getDefaultProduct()).thenReturn(new ProductBundleImpl());
    when(skuImpl.getFulfillmentType()).thenReturn(null);

    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult =
        fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(discreteOrderItem);

    // Assert
    verify(skuImpl, atLeast(1)).getDefaultProduct();
    verify(skuImpl).getFulfillmentType();
    verify(discreteOrderItem).getSku();
    assertNull(actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"
  })
  public void testResolveFulfillmentTypeWithDiscreteOrderItem3() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getDefaultProduct()).thenReturn(productBundleImpl);
    when(skuImpl.getFulfillmentType()).thenReturn(null);

    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult =
        fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(discreteOrderItem);

    // Assert
    verify(productBundleImpl, atLeast(1)).getDefaultCategory();
    verify(skuImpl, atLeast(1)).getDefaultProduct();
    verify(skuImpl).getFulfillmentType();
    verify(discreteOrderItem).getSku();
    assertNull(actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"
  })
  public void testResolveFulfillmentTypeWithDiscreteOrderItem4() {
    // Arrange
    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalStateException());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getDefaultProduct()).thenReturn(productBundleImpl);
    when(skuImpl.getFulfillmentType()).thenReturn(null);

    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(discreteOrderItem));
    verify(productBundleImpl).getDefaultCategory();
    verify(skuImpl, atLeast(1)).getDefaultProduct();
    verify(skuImpl).getFulfillmentType();
    verify(discreteOrderItem).getSku();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"
  })
  public void testResolveFulfillmentTypeWithDiscreteOrderItem5() {
    // Arrange
    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getDefaultProduct()).thenReturn(productBundleImpl);
    when(skuImpl.getFulfillmentType()).thenReturn(null);

    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult =
        fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(discreteOrderItem);

    // Assert
    verify(productBundleImpl, atLeast(1)).getDefaultCategory();
    verify(skuImpl, atLeast(1)).getDefaultProduct();
    verify(skuImpl).getFulfillmentType();
    verify(discreteOrderItem).getSku();
    assertSame(FulfillmentType.DIGITAL, actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"
  })
  public void testResolveFulfillmentTypeWithDiscreteOrderItem_givenSkuImpl() {
    // Arrange
    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(new SkuImpl());

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult =
        fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(discreteOrderItem);

    // Assert
    verify(discreteOrderItem).getSku();
    assertNull(actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)} with
   * {@code discreteOrderItem}.
   *
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getFulfillmentType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(DiscreteOrderItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(DiscreteOrderItem)"
  })
  public void testResolveFulfillmentTypeWithDiscreteOrderItem_thenCallsGetFulfillmentType() {
    // Arrange
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFulfillmentType()).thenThrow(new IllegalStateException());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getDefaultProduct()).thenReturn(productBundleImpl);
    when(skuImpl.getFulfillmentType()).thenReturn(null);

    DiscreteOrderItem discreteOrderItem = mock(DiscreteOrderItem.class);
    when(discreteOrderItem.getSku()).thenReturn(skuImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(discreteOrderItem));
    verify(categoryImpl).getFulfillmentType();
    verify(productBundleImpl, atLeast(1)).getDefaultCategory();
    verify(skuImpl, atLeast(1)).getDefaultProduct();
    verify(skuImpl).getFulfillmentType();
    verify(discreteOrderItem).getSku();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"
  })
  public void testResolveFulfillmentTypeWithSku() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(new CategoryImpl());

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getDefaultProduct()).thenReturn(productBundleImpl);
    when(sku.getFulfillmentType()).thenReturn(null);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult =
        fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(sku);

    // Assert
    verify(productBundleImpl, atLeast(1)).getDefaultCategory();
    verify(sku, atLeast(1)).getDefaultProduct();
    verify(sku).getFulfillmentType();
    assertNull(actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"
  })
  public void testResolveFulfillmentTypeWithSku2() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenThrow(new IllegalStateException());

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getDefaultProduct()).thenReturn(productBundleImpl);
    when(sku.getFulfillmentType()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(sku));
    verify(productBundleImpl).getDefaultCategory();
    verify(sku, atLeast(1)).getDefaultProduct();
    verify(sku).getFulfillmentType();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl} (default constructor) FulfillmentType is {@link
   *       FulfillmentType#DIGITAL}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"
  })
  public void testResolveFulfillmentTypeWithSku_givenCategoryImplFulfillmentTypeIsDigital() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setFulfillmentType(FulfillmentType.DIGITAL);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getDefaultProduct()).thenReturn(productBundleImpl);
    when(sku.getFulfillmentType()).thenReturn(null);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult =
        fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(sku);

    // Assert
    verify(productBundleImpl, atLeast(1)).getDefaultCategory();
    verify(sku, atLeast(1)).getDefaultProduct();
    verify(sku).getFulfillmentType();
    assertSame(FulfillmentType.DIGITAL, actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentType#DIGITAL}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"
  })
  public void testResolveFulfillmentTypeWithSku_givenDigital() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getFulfillmentType()).thenReturn(FulfillmentType.DIGITAL);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult =
        fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(sku);

    // Assert
    verify(sku, atLeast(1)).getFulfillmentType();
    assertSame(FulfillmentType.DIGITAL, actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"
  })
  public void testResolveFulfillmentTypeWithSku_givenProductBundleImpl() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getDefaultProduct()).thenReturn(new ProductBundleImpl());
    when(sku.getFulfillmentType()).thenReturn(null);

    // Act
    FulfillmentType actualResolveFulfillmentTypeResult =
        fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(sku);

    // Assert
    verify(sku, atLeast(1)).getDefaultProduct();
    verify(sku).getFulfillmentType();
    assertNull(actualResolveFulfillmentTypeResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>Then calls {@link CategoryImpl#getFulfillmentType()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"
  })
  public void testResolveFulfillmentTypeWithSku_thenCallsGetFulfillmentType() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.getFulfillmentType()).thenThrow(new IllegalStateException());

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getDefaultCategory()).thenReturn(categoryImpl);

    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getDefaultProduct()).thenReturn(productBundleImpl);
    when(sku.getFulfillmentType()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(sku));
    verify(categoryImpl).getFulfillmentType();
    verify(productBundleImpl, atLeast(1)).getDefaultCategory();
    verify(sku, atLeast(1)).getDefaultProduct();
    verify(sku).getFulfillmentType();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)} with {@code sku}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#resolveFulfillmentType(Sku)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentType FulfillmentGroupItemStrategyImpl.resolveFulfillmentType(Sku)"
  })
  public void testResolveFulfillmentTypeWithSku_whenSkuImpl_thenReturnNull() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    // Act and Assert
    assertNull(fulfillmentGroupItemStrategyImpl.resolveFulfillmentType(new SkuImpl()));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup)} with {@code order}, {@code orderItem}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order,
   * OrderItem, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithOrderOrderItemFulfillmentGroup()
      throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupService.addItemToFulfillmentGroup(
            Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(), anyBoolean()))
        .thenReturn(fulfillmentGroupImpl);
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        fulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(
            order, orderItem, new FulfillmentGroupImpl());

    // Assert
    verify(fulfillmentGroupService)
        .addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false), eq(false));
    assertSame(fulfillmentGroupImpl, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem,
   * FulfillmentGroup)} with {@code order}, {@code orderItem}, {@code fulfillmentGroup}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order,
   * OrderItem, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(Order, OrderItem, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithOrderOrderItemFulfillmentGroup2()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupService.addItemToFulfillmentGroup(
            Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(), anyBoolean()))
        .thenThrow(new IllegalStateException());
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            fulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(
                order, orderItem, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupService)
        .addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false), eq(false));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem, int,
   * FulfillmentGroup)} with {@code order}, {@code orderItem}, {@code quantity}, {@code
   * fulfillmentGroup}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order,
   * OrderItem, int, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(Order, OrderItem, int, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithOrderOrderItemQuantityFulfillmentGroup()
      throws PricingException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    when(fulfillmentGroupService.addItemToFulfillmentGroup(
            Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(), anyBoolean()))
        .thenReturn(fulfillmentGroupImpl);
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    FulfillmentGroup actualAddItemToFulfillmentGroupResult =
        fulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(
            order, orderItem, 2, new FulfillmentGroupImpl());

    // Assert
    verify(fulfillmentGroupService)
        .addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false), eq(false));
    assertSame(fulfillmentGroupImpl, actualAddItemToFulfillmentGroupResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order, OrderItem, int,
   * FulfillmentGroup)} with {@code order}, {@code orderItem}, {@code quantity}, {@code
   * fulfillmentGroup}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#addItemToFulfillmentGroup(Order,
   * OrderItem, int, FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(Order, OrderItem, int, FulfillmentGroup)"
  })
  public void testAddItemToFulfillmentGroupWithOrderOrderItemQuantityFulfillmentGroup2()
      throws PricingException {
    // Arrange
    when(fulfillmentGroupService.addItemToFulfillmentGroup(
            Mockito.<FulfillmentGroupItemRequest>any(), anyBoolean(), anyBoolean()))
        .thenThrow(new IllegalStateException());
    NullOrderImpl order = new NullOrderImpl();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            fulfillmentGroupItemStrategyImpl.addItemToFulfillmentGroup(
                order, orderItem, 2, new FulfillmentGroupImpl()));
    verify(fulfillmentGroupService)
        .addItemToFulfillmentGroup(isA(FulfillmentGroupItemRequest.class), eq(false), eq(false));
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemUpdated(CartOperationRequest)"
  })
  public void testOnItemUpdated() throws PricingException {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    request.setOrderItemQuantityDelta(0);

    // Act
    CartOperationRequest actualOnItemUpdatedResult =
        fulfillmentGroupItemStrategyImpl.onItemUpdated(request);

    // Assert
    assertSame(request, actualOnItemUpdatedResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemUpdated(CartOperationRequest)"
  })
  public void testOnItemUpdated_givenIllegalStateException() throws PricingException {
    // Arrange
    CartOperationRequest request = mock(CartOperationRequest.class);
    doThrow(new IllegalStateException())
        .when(request)
        .setFgisToDelete(Mockito.<List<FulfillmentGroupItem>>any());
    when(request.getOrderItemQuantityDelta()).thenReturn(2);
    when(request.getOrder()).thenReturn(new NullOrderImpl());
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(request).setOrderItemQuantityDelta(Mockito.<Integer>any());
    request.setOrderItemQuantityDelta(0);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemUpdated(request));
    verify(request).getOrder();
    verify(request).getOrderItem();
    verify(request).getOrderItemQuantityDelta();
    verify(request).setFgisToDelete(isA(List.class));
    verify(request).setOrderItemQuantityDelta(0);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemUpdated(CartOperationRequest)"
  })
  public void testOnItemUpdated_thenCallsGetDiscreteOrderItems() throws PricingException {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenThrow(new IllegalStateException());

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrderItemQuantityDelta()).thenReturn(2);
    when(request.getOrder()).thenReturn(new NullOrderImpl());
    when(request.getOrderItem()).thenReturn(bundleOrderItemImpl);
    doNothing().when(request).setOrderItemQuantityDelta(Mockito.<Integer>any());
    request.setOrderItemQuantityDelta(0);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemUpdated(request));
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(request).getOrder();
    verify(request).getOrderItem();
    verify(request).getOrderItemQuantityDelta();
    verify(request).setOrderItemQuantityDelta(0);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then return {@link CartOperationRequest}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemUpdated(CartOperationRequest)"
  })
  public void testOnItemUpdated_thenReturnCartOperationRequest() throws PricingException {
    // Arrange
    CartOperationRequest request = mock(CartOperationRequest.class);
    doNothing().when(request).setFgisToDelete(Mockito.<List<FulfillmentGroupItem>>any());
    when(request.getOrderItemQuantityDelta()).thenReturn(2);
    when(request.getOrder()).thenReturn(new NullOrderImpl());
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    doNothing().when(request).setOrderItemQuantityDelta(Mockito.<Integer>any());
    request.setOrderItemQuantityDelta(0);

    // Act
    CartOperationRequest actualOnItemUpdatedResult =
        fulfillmentGroupItemStrategyImpl.onItemUpdated(request);

    // Assert
    verify(request).getOrder();
    verify(request).getOrderItem();
    verify(request).getOrderItemQuantityDelta();
    verify(request).setFgisToDelete(isA(List.class));
    verify(request).setOrderItemQuantityDelta(0);
    assertSame(request, actualOnItemUpdatedResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order,
   * OrderItem, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupItemStrategyImpl.updateItemQuantity(Order, OrderItem, Integer)"
  })
  public void testUpdateItemQuantity() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getQuantity()).thenThrow(new IllegalStateException());
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            fulfillmentGroupItemStrategyImpl.updateItemQuantity(
                order, new BundleOrderItemImpl(), 0));
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getQuantity();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order,
   * OrderItem, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupItemStrategyImpl.updateItemQuantity(Order, OrderItem, Integer)"
  })
  public void testUpdateItemQuantity2() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    doThrow(new IllegalStateException()).when(fulfillmentGroupItemImpl).setQuantity(anyInt());
    when(fulfillmentGroupItemImpl.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            fulfillmentGroupItemStrategyImpl.updateItemQuantity(
                order, new BundleOrderItemImpl(), 0));
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl, atLeast(1)).getQuantity();
    verify(fulfillmentGroupItemImpl).setQuantity(1);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order,
   * OrderItem, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupItemStrategyImpl.updateItemQuantity(Order, OrderItem, Integer)"
  })
  public void testUpdateItemQuantity3() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new DiscreteOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            fulfillmentGroupItemStrategyImpl.updateItemQuantity(
                order, new BundleOrderItemImpl(), 0));
    verify(fulfillmentGroupItemImpl).getOrderItem();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} {@link FulfillmentGroupItemImpl#getQuantity()}
   *       return minus one.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order,
   * OrderItem, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupItemStrategyImpl.updateItemQuantity(Order, OrderItem, Integer)"
  })
  public void testUpdateItemQuantity_givenFulfillmentGroupItemImplGetQuantityReturnMinusOne()
      throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getQuantity()).thenReturn(-1);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            fulfillmentGroupItemStrategyImpl.updateItemQuantity(
                order, new BundleOrderItemImpl(), 0));
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl, atLeast(1)).getQuantity();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order,
   * OrderItem, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupItemStrategyImpl.updateItemQuantity(Order, OrderItem, Integer)"
  })
  public void testUpdateItemQuantity_thenReturnEmpty() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    doNothing().when(fulfillmentGroupItemImpl).setQuantity(anyInt());
    when(fulfillmentGroupItemImpl.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    List<FulfillmentGroupItem> actualUpdateItemQuantityResult =
        fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 0);

    // Assert
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl, atLeast(1)).getQuantity();
    verify(fulfillmentGroupItemImpl).setQuantity(1);
    assertTrue(actualUpdateItemQuantityResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order,
   * OrderItem, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupItemStrategyImpl.updateItemQuantity(Order, OrderItem, Integer)"
  })
  public void testUpdateItemQuantity_thenReturnEmpty2() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    doNothing().when(fulfillmentGroupItemImpl).setQuantity(anyInt());
    when(fulfillmentGroupItemImpl.getQuantity()).thenReturn(1);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    List<FulfillmentGroupItem> actualUpdateItemQuantityResult =
        fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 2);

    // Assert
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getQuantity();
    verify(fulfillmentGroupItemImpl).setQuantity(3);
    assertTrue(actualUpdateItemQuantityResult.isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order, OrderItem, Integer)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#updateItemQuantity(Order,
   * OrderItem, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupItemStrategyImpl.updateItemQuantity(Order, OrderItem, Integer)"
  })
  public void testUpdateItemQuantity_thenReturnSizeIsOne() throws PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = mock(FulfillmentGroupItemImpl.class);
    when(fulfillmentGroupItemImpl.getQuantity()).thenReturn(0);
    when(fulfillmentGroupItemImpl.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setFulfillmentGroups(fulfillmentGroups);

    // Act
    List<FulfillmentGroupItem> actualUpdateItemQuantityResult =
        fulfillmentGroupItemStrategyImpl.updateItemQuantity(order, new BundleOrderItemImpl(), 0);

    // Assert
    verify(fulfillmentGroupItemImpl).getOrderItem();
    verify(fulfillmentGroupItemImpl).getQuantity();
    assertEquals(1, actualUpdateItemQuantityResult.size());
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"
  })
  public void testOnItemRemoved() {
    // Arrange
    when(fulfillmentGroupService.getFulfillmentGroupItemsForOrderItem(
            Mockito.<Order>any(), Mockito.<OrderItem>any()))
        .thenThrow(new IllegalStateException());
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemRemoved(request));
    verify(fulfillmentGroupService)
        .getFulfillmentGroupItemsForOrderItem(isA(Order.class), isNull());
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then AddedOrderItem return {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"
  })
  public void testOnItemRemoved_thenAddedOrderItemReturnBundleOrderItemImpl() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    request.setOrderItem(orderItem);

    // Act
    CartOperationRequest actualOnItemRemovedResult =
        fulfillmentGroupItemStrategyImpl.onItemRemoved(request);

    // Assert
    OrderItem addedOrderItem = actualOnItemRemovedResult.getAddedOrderItem();
    assertTrue(addedOrderItem instanceof BundleOrderItemImpl);
    assertSame(orderItem, addedOrderItem);
    assertSame(orderItem, actualOnItemRemovedResult.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"
  })
  public void testOnItemRemoved_thenCallsGetDiscreteOrderItems() {
    // Arrange
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getDiscreteOrderItems()).thenThrow(new IllegalStateException());
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    request.setOrderItem(orderItem);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.onItemRemoved(request));
    verify(orderItem).getDiscreteOrderItems();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"
  })
  public void testOnItemRemoved_thenOrderReturnNullOrderImpl() {
    // Arrange
    when(fulfillmentGroupService.getFulfillmentGroupItemsForOrderItem(
            Mockito.<Order>any(), Mockito.<OrderItem>any()))
        .thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    CartOperationRequest actualOnItemRemovedResult =
        fulfillmentGroupItemStrategyImpl.onItemRemoved(request);

    // Assert
    verify(fulfillmentGroupService)
        .getFulfillmentGroupItemsForOrderItem(isA(Order.class), isNull());
    assertTrue(actualOnItemRemovedResult.getOrder() instanceof NullOrderImpl);
    assertNull(actualOnItemRemovedResult.getAddedOrderItem());
    assertNull(actualOnItemRemovedResult.getOrderItem());
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@link CartOperationRequest}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"
  })
  public void testVerify_givenArrayListAddDiscreteOrderItemImpl_thenReturnCartOperationRequest()
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

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);

    // Act
    CartOperationRequest actualVerifyResult = fulfillmentGroupItemStrategyImpl.verify(request);

    // Assert
    verify(request).getOrder();
    assertSame(request, actualVerifyResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getBundleOrderItem()}
   *       return {@link BundleOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"
  })
  public void testVerify_givenDiscreteOrderItemImplGetBundleOrderItemReturnBundleOrderItemImpl()
      throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupService).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getId()).thenReturn(1L);
    when(discreteOrderItemImpl.getBundleOrderItem()).thenReturn(new BundleOrderItemImpl());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);

    // Act
    CartOperationRequest actualVerifyResult = fulfillmentGroupItemStrategyImpl.verify(request);

    // Assert
    verify(discreteOrderItemImpl, atLeast(1)).getBundleOrderItem();
    verify(discreteOrderItemImpl, atLeast(1)).getId();
    verify(discreteOrderItemImpl).getQuantity();
    verify(fulfillmentGroupService).delete(isA(FulfillmentGroup.class));
    verify(request).getOrder();
    assertSame(request, actualVerifyResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getBundleOrderItem()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"
  })
  public void testVerify_givenDiscreteOrderItemImplGetBundleOrderItemReturnNull()
      throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupService).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getId()).thenReturn(1L);
    when(discreteOrderItemImpl.getBundleOrderItem()).thenReturn(null);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.verify(request));
    verify(discreteOrderItemImpl).getBundleOrderItem();
    verify(discreteOrderItemImpl, atLeast(1)).getId();
    verify(discreteOrderItemImpl).getQuantity();
    verify(fulfillmentGroupService).delete(isA(FulfillmentGroup.class));
    verify(request).getOrder();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupService} {@link
   *       FulfillmentGroupService#delete(FulfillmentGroup)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"
  })
  public void testVerify_givenFulfillmentGroupServiceDeleteThrowIllegalStateException()
      throws PricingException {
    // Arrange
    doThrow(new IllegalStateException())
        .when(fulfillmentGroupService)
        .delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.verify(request));
    verify(fulfillmentGroupService).delete(isA(FulfillmentGroup.class));
    verify(request).getOrder();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getQuantity()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"
  })
  public void testVerify_thenCallsGetQuantity() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupService).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenThrow(new IllegalStateException());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getId()).thenReturn(1L);
    when(discreteOrderItemImpl.getBundleOrderItem()).thenReturn(bundleOrderItemImpl);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(discreteOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable2);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(1L);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(new NullOrderImpl());
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setPrice(new Money());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setDiscreteOrderItems(discreteOrderItems);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl2);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> fulfillmentGroupItemStrategyImpl.verify(request));
    verify(discreteOrderItemImpl, atLeast(1)).getBundleOrderItem();
    verify(discreteOrderItemImpl).getId();
    verify(bundleOrderItemImpl).getQuantity();
    verify(fulfillmentGroupService).delete(isA(FulfillmentGroup.class));
    verify(request).getOrder();
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then return {@link CartOperationRequest}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"
  })
  public void testVerify_thenReturnCartOperationRequest() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupService).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);

    // Act
    CartOperationRequest actualVerifyResult = fulfillmentGroupItemStrategyImpl.verify(request);

    // Assert
    verify(fulfillmentGroupService).delete(isA(FulfillmentGroup.class));
    verify(request).getOrder();
    assertSame(request, actualVerifyResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then return {@link CartOperationRequest}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"
  })
  public void testVerify_thenReturnCartOperationRequest2() throws PricingException {
    // Arrange
    doNothing().when(fulfillmentGroupService).delete(Mockito.<FulfillmentGroup>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrder()).thenReturn(orderImpl);

    // Act
    CartOperationRequest actualVerifyResult = fulfillmentGroupItemStrategyImpl.verify(request);

    // Assert
    verify(fulfillmentGroupService).delete(isA(FulfillmentGroup.class));
    verify(request).getOrder();
    assertSame(request, actualVerifyResult);
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then return Order FulfillmentGroups is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"
  })
  public void testVerify_thenReturnOrderFulfillmentGroupsIsArrayList() throws PricingException {
    // Arrange
    fulfillmentGroupItemStrategyImpl.setRemoveEmptyFulfillmentGroups(false);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setFulfillmentGroups(fulfillmentGroups);
    order.setOrderItems(orderItems);
    NullOrderImpl order2 = new NullOrderImpl();

    CartOperationRequest request =
        new CartOperationRequest(order2, new OrderItemRequestDTO(), true);
    request.setOrder(order);

    // Act and Assert
    Order order3 = fulfillmentGroupItemStrategyImpl.verify(request).getOrder();
    assertTrue(order3 instanceof OrderImpl);
    assertSame(fulfillmentGroups, order3.getFulfillmentGroups());
  }

  /**
   * Test {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then return Order OrderItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest FulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"
  })
  public void testVerify_thenReturnOrderOrderItemsSizeIsOne() throws PricingException {
    // Arrange
    fulfillmentGroupItemStrategyImpl.setRemoveEmptyFulfillmentGroups(false);

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

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
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

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
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
    order.setFulfillmentGroups(new ArrayList<>());
    order.setOrderItems(orderItems);
    NullOrderImpl order2 = new NullOrderImpl();

    CartOperationRequest request =
        new CartOperationRequest(order2, new OrderItemRequestDTO(), true);
    request.setOrder(order);

    // Act and Assert
    Order order3 = fulfillmentGroupItemStrategyImpl.verify(request).getOrder();
    List<OrderItem> orderItems2 = order3.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertTrue(orderItems2.get(0) instanceof BundleOrderItemImpl);
    assertTrue(order3 instanceof OrderImpl);
    assertTrue(order3.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemStrategyImpl#setRemoveEmptyFulfillmentGroups(boolean)}
   *   <li>{@link FulfillmentGroupItemStrategyImpl#isRemoveEmptyFulfillmentGroups()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemStrategyImpl.isRemoveEmptyFulfillmentGroups()",
    "void FulfillmentGroupItemStrategyImpl.setRemoveEmptyFulfillmentGroups(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupItemStrategyImpl fulfillmentGroupItemStrategyImpl =
        new FulfillmentGroupItemStrategyImpl();

    // Act
    fulfillmentGroupItemStrategyImpl.setRemoveEmptyFulfillmentGroups(true);

    // Assert
    assertTrue(fulfillmentGroupItemStrategyImpl.isRemoveEmptyFulfillmentGroups());
  }
}
