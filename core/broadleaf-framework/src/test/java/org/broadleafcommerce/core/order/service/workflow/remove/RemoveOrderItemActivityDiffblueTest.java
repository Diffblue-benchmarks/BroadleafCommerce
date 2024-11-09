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
package org.broadleafcommerce.core.order.service.workflow.remove;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItem;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;

public class RemoveOrderItemActivityDiffblueTest {
  /**
   * Test {@link RemoveOrderItemActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveOrderItemActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenAuditableCreatedByIsOne_thenReturnDefaultProcessContextImpl() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RemoveOrderItemActivity removeOrderItemActivity = new RemoveOrderItemActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    Auditable auditable5 = new Auditable();
    auditable5.setCreatedBy(1L);
    auditable5.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setUpdatedBy(1L);

    Auditable auditable6 = new Auditable();
    auditable6.setCreatedBy(1L);
    auditable6.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable6.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable6.setUpdatedBy(1L);

    Auditable auditable7 = new Auditable();
    auditable7.setCreatedBy(1L);
    auditable7.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable7.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable7.setUpdatedBy(1L);

    Auditable auditable8 = new Auditable();
    auditable8.setCreatedBy(1L);
    auditable8.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable8.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable8.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable8);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
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
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setChildOrderItems(new ArrayList<>());

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable7);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
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
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl2);

    BundleOrderItemImpl bundleOrderItemImpl3 = new BundleOrderItemImpl();
    bundleOrderItemImpl3.setAuditable(auditable6);
    bundleOrderItemImpl3.setBaseRetailPrice(new Money());
    bundleOrderItemImpl3.setBaseSalePrice(new Money());
    bundleOrderItemImpl3.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl3.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl3.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl3.setDiscountingAllowed(true);
    bundleOrderItemImpl3.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl3.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl3.setHasValidationError(true);
    bundleOrderItemImpl3.setId(1L);
    bundleOrderItemImpl3.setName("Name");
    bundleOrderItemImpl3.setOrder(new NullOrderImpl());
    bundleOrderItemImpl3.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl3.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl3.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl3.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl3.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setQuantity(1);
    bundleOrderItemImpl3.setRetailPrice(new Money());
    bundleOrderItemImpl3.setRetailPriceOverride(true);
    bundleOrderItemImpl3.setSalePrice(new Money());
    bundleOrderItemImpl3.setSalePriceOverride(true);
    bundleOrderItemImpl3.setTaxable(true);
    bundleOrderItemImpl3.updateSaleAndRetailPrices();
    bundleOrderItemImpl3.setChildOrderItems(childOrderItems2);

    ArrayList<OrderItem> childOrderItems3 = new ArrayList<>();
    childOrderItems3.add(bundleOrderItemImpl3);

    BundleOrderItemImpl bundleOrderItemImpl4 = new BundleOrderItemImpl();
    bundleOrderItemImpl4.setAuditable(auditable5);
    bundleOrderItemImpl4.setBaseRetailPrice(new Money());
    bundleOrderItemImpl4.setBaseSalePrice(new Money());
    bundleOrderItemImpl4.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl4.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl4.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl4.setDiscountingAllowed(true);
    bundleOrderItemImpl4.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl4.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl4.setHasValidationError(true);
    bundleOrderItemImpl4.setId(1L);
    bundleOrderItemImpl4.setName("Name");
    bundleOrderItemImpl4.setOrder(new NullOrderImpl());
    bundleOrderItemImpl4.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl4.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl4.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl4.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl4.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setQuantity(1);
    bundleOrderItemImpl4.setRetailPrice(new Money());
    bundleOrderItemImpl4.setRetailPriceOverride(true);
    bundleOrderItemImpl4.setSalePrice(new Money());
    bundleOrderItemImpl4.setSalePriceOverride(true);
    bundleOrderItemImpl4.setTaxable(true);
    bundleOrderItemImpl4.updateSaleAndRetailPrices();
    bundleOrderItemImpl4.setChildOrderItems(childOrderItems3);

    ArrayList<OrderItem> childOrderItems4 = new ArrayList<>();
    childOrderItems4.add(bundleOrderItemImpl4);

    BundleOrderItemImpl bundleOrderItemImpl5 = new BundleOrderItemImpl();
    bundleOrderItemImpl5.setAuditable(auditable4);
    bundleOrderItemImpl5.setBaseRetailPrice(new Money());
    bundleOrderItemImpl5.setBaseSalePrice(new Money());
    bundleOrderItemImpl5.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl5.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl5.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl5.setDiscountingAllowed(true);
    bundleOrderItemImpl5.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl5.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl5.setHasValidationError(true);
    bundleOrderItemImpl5.setId(1L);
    bundleOrderItemImpl5.setName("Name");
    bundleOrderItemImpl5.setOrder(new NullOrderImpl());
    bundleOrderItemImpl5.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl5.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl5.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl5.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl5.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl5.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl5.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl5.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl5.setQuantity(1);
    bundleOrderItemImpl5.setRetailPrice(new Money());
    bundleOrderItemImpl5.setRetailPriceOverride(true);
    bundleOrderItemImpl5.setSalePrice(new Money());
    bundleOrderItemImpl5.setSalePriceOverride(true);
    bundleOrderItemImpl5.setTaxable(true);
    bundleOrderItemImpl5.updateSaleAndRetailPrices();
    bundleOrderItemImpl5.setChildOrderItems(childOrderItems4);

    ArrayList<OrderItem> childOrderItems5 = new ArrayList<>();
    childOrderItems5.add(bundleOrderItemImpl5);

    BundleOrderItemImpl bundleOrderItemImpl6 = new BundleOrderItemImpl();
    bundleOrderItemImpl6.setAuditable(auditable3);
    bundleOrderItemImpl6.setBaseRetailPrice(new Money());
    bundleOrderItemImpl6.setBaseSalePrice(new Money());
    bundleOrderItemImpl6.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl6.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl6.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl6.setDiscountingAllowed(true);
    bundleOrderItemImpl6.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl6.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl6.setHasValidationError(true);
    bundleOrderItemImpl6.setId(1L);
    bundleOrderItemImpl6.setName("Name");
    bundleOrderItemImpl6.setOrder(new NullOrderImpl());
    bundleOrderItemImpl6.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl6.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl6.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl6.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl6.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl6.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl6.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl6.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl6.setQuantity(1);
    bundleOrderItemImpl6.setRetailPrice(new Money());
    bundleOrderItemImpl6.setRetailPriceOverride(true);
    bundleOrderItemImpl6.setSalePrice(new Money());
    bundleOrderItemImpl6.setSalePriceOverride(true);
    bundleOrderItemImpl6.setTaxable(true);
    bundleOrderItemImpl6.updateSaleAndRetailPrices();
    bundleOrderItemImpl6.setChildOrderItems(childOrderItems5);

    ArrayList<OrderItem> childOrderItems6 = new ArrayList<>();
    childOrderItems6.add(bundleOrderItemImpl6);

    BundleOrderItemImpl bundleOrderItemImpl7 = new BundleOrderItemImpl();
    bundleOrderItemImpl7.setAuditable(auditable2);
    bundleOrderItemImpl7.setBaseRetailPrice(new Money());
    bundleOrderItemImpl7.setBaseSalePrice(new Money());
    bundleOrderItemImpl7.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl7.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl7.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl7.setDiscountingAllowed(true);
    bundleOrderItemImpl7.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl7.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl7.setHasValidationError(true);
    bundleOrderItemImpl7.setId(1L);
    bundleOrderItemImpl7.setName("Name");
    bundleOrderItemImpl7.setOrder(new NullOrderImpl());
    bundleOrderItemImpl7.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl7.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl7.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl7.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl7.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl7.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl7.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl7.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl7.setQuantity(1);
    bundleOrderItemImpl7.setRetailPrice(new Money());
    bundleOrderItemImpl7.setRetailPriceOverride(true);
    bundleOrderItemImpl7.setSalePrice(new Money());
    bundleOrderItemImpl7.setSalePriceOverride(true);
    bundleOrderItemImpl7.setTaxable(true);
    bundleOrderItemImpl7.updateSaleAndRetailPrices();
    bundleOrderItemImpl7.setChildOrderItems(childOrderItems6);

    ArrayList<OrderItem> childOrderItems7 = new ArrayList<>();
    childOrderItems7.add(bundleOrderItemImpl7);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
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
    orderItem.setChildOrderItems(childOrderItems7);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrderItem(orderItem);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertSame(context, removeOrderItemActivity.execute((ProcessContext<CartOperationRequest>) context));
  }

  /**
   * Test {@link RemoveOrderItemActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) ChildOrderItems
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveOrderItemActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenBundleOrderItemImplChildOrderItemsIsNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RemoveOrderItemActivity removeOrderItemActivity = new RemoveOrderItemActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    Auditable auditable5 = new Auditable();
    auditable5.setCreatedBy(1L);
    auditable5.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setUpdatedBy(1L);

    Auditable auditable6 = new Auditable();
    auditable6.setCreatedBy(1L);
    auditable6.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable6.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable6.setUpdatedBy(1L);

    Auditable auditable7 = new Auditable();
    auditable7.setCreatedBy(1L);
    auditable7.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable7.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable7.setUpdatedBy(1L);

    Auditable auditable8 = new Auditable();
    auditable8.setCreatedBy(1L);
    auditable8.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable8.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable8.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable8);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
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
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable7);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
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
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl2);

    BundleOrderItemImpl bundleOrderItemImpl3 = new BundleOrderItemImpl();
    bundleOrderItemImpl3.setAuditable(auditable6);
    bundleOrderItemImpl3.setBaseRetailPrice(new Money());
    bundleOrderItemImpl3.setBaseSalePrice(new Money());
    bundleOrderItemImpl3.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl3.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl3.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl3.setDiscountingAllowed(true);
    bundleOrderItemImpl3.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl3.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl3.setHasValidationError(true);
    bundleOrderItemImpl3.setId(1L);
    bundleOrderItemImpl3.setName("Name");
    bundleOrderItemImpl3.setOrder(new NullOrderImpl());
    bundleOrderItemImpl3.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl3.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl3.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl3.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl3.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setQuantity(1);
    bundleOrderItemImpl3.setRetailPrice(new Money());
    bundleOrderItemImpl3.setRetailPriceOverride(true);
    bundleOrderItemImpl3.setSalePrice(new Money());
    bundleOrderItemImpl3.setSalePriceOverride(true);
    bundleOrderItemImpl3.setTaxable(true);
    bundleOrderItemImpl3.updateSaleAndRetailPrices();
    bundleOrderItemImpl3.setChildOrderItems(childOrderItems2);

    ArrayList<OrderItem> childOrderItems3 = new ArrayList<>();
    childOrderItems3.add(bundleOrderItemImpl3);

    BundleOrderItemImpl bundleOrderItemImpl4 = new BundleOrderItemImpl();
    bundleOrderItemImpl4.setAuditable(auditable5);
    bundleOrderItemImpl4.setBaseRetailPrice(new Money());
    bundleOrderItemImpl4.setBaseSalePrice(new Money());
    bundleOrderItemImpl4.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl4.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl4.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl4.setDiscountingAllowed(true);
    bundleOrderItemImpl4.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl4.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl4.setHasValidationError(true);
    bundleOrderItemImpl4.setId(1L);
    bundleOrderItemImpl4.setName("Name");
    bundleOrderItemImpl4.setOrder(new NullOrderImpl());
    bundleOrderItemImpl4.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl4.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl4.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl4.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl4.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setQuantity(1);
    bundleOrderItemImpl4.setRetailPrice(new Money());
    bundleOrderItemImpl4.setRetailPriceOverride(true);
    bundleOrderItemImpl4.setSalePrice(new Money());
    bundleOrderItemImpl4.setSalePriceOverride(true);
    bundleOrderItemImpl4.setTaxable(true);
    bundleOrderItemImpl4.updateSaleAndRetailPrices();
    bundleOrderItemImpl4.setChildOrderItems(childOrderItems3);

    ArrayList<OrderItem> childOrderItems4 = new ArrayList<>();
    childOrderItems4.add(bundleOrderItemImpl4);

    BundleOrderItemImpl bundleOrderItemImpl5 = new BundleOrderItemImpl();
    bundleOrderItemImpl5.setAuditable(auditable4);
    bundleOrderItemImpl5.setBaseRetailPrice(new Money());
    bundleOrderItemImpl5.setBaseSalePrice(new Money());
    bundleOrderItemImpl5.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl5.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl5.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl5.setDiscountingAllowed(true);
    bundleOrderItemImpl5.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl5.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl5.setHasValidationError(true);
    bundleOrderItemImpl5.setId(1L);
    bundleOrderItemImpl5.setName("Name");
    bundleOrderItemImpl5.setOrder(new NullOrderImpl());
    bundleOrderItemImpl5.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl5.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl5.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl5.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl5.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl5.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl5.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl5.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl5.setQuantity(1);
    bundleOrderItemImpl5.setRetailPrice(new Money());
    bundleOrderItemImpl5.setRetailPriceOverride(true);
    bundleOrderItemImpl5.setSalePrice(new Money());
    bundleOrderItemImpl5.setSalePriceOverride(true);
    bundleOrderItemImpl5.setTaxable(true);
    bundleOrderItemImpl5.updateSaleAndRetailPrices();
    bundleOrderItemImpl5.setChildOrderItems(childOrderItems4);

    ArrayList<OrderItem> childOrderItems5 = new ArrayList<>();
    childOrderItems5.add(bundleOrderItemImpl5);

    BundleOrderItemImpl bundleOrderItemImpl6 = new BundleOrderItemImpl();
    bundleOrderItemImpl6.setAuditable(auditable3);
    bundleOrderItemImpl6.setBaseRetailPrice(new Money());
    bundleOrderItemImpl6.setBaseSalePrice(new Money());
    bundleOrderItemImpl6.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl6.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl6.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl6.setDiscountingAllowed(true);
    bundleOrderItemImpl6.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl6.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl6.setHasValidationError(true);
    bundleOrderItemImpl6.setId(1L);
    bundleOrderItemImpl6.setName("Name");
    bundleOrderItemImpl6.setOrder(new NullOrderImpl());
    bundleOrderItemImpl6.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl6.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl6.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl6.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl6.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl6.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl6.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl6.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl6.setQuantity(1);
    bundleOrderItemImpl6.setRetailPrice(new Money());
    bundleOrderItemImpl6.setRetailPriceOverride(true);
    bundleOrderItemImpl6.setSalePrice(new Money());
    bundleOrderItemImpl6.setSalePriceOverride(true);
    bundleOrderItemImpl6.setTaxable(true);
    bundleOrderItemImpl6.updateSaleAndRetailPrices();
    bundleOrderItemImpl6.setChildOrderItems(childOrderItems5);

    ArrayList<OrderItem> childOrderItems6 = new ArrayList<>();
    childOrderItems6.add(bundleOrderItemImpl6);

    BundleOrderItemImpl bundleOrderItemImpl7 = new BundleOrderItemImpl();
    bundleOrderItemImpl7.setAuditable(auditable2);
    bundleOrderItemImpl7.setBaseRetailPrice(new Money());
    bundleOrderItemImpl7.setBaseSalePrice(new Money());
    bundleOrderItemImpl7.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl7.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl7.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl7.setDiscountingAllowed(true);
    bundleOrderItemImpl7.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl7.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl7.setHasValidationError(true);
    bundleOrderItemImpl7.setId(1L);
    bundleOrderItemImpl7.setName("Name");
    bundleOrderItemImpl7.setOrder(new NullOrderImpl());
    bundleOrderItemImpl7.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl7.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl7.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl7.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl7.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl7.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl7.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl7.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl7.setQuantity(1);
    bundleOrderItemImpl7.setRetailPrice(new Money());
    bundleOrderItemImpl7.setRetailPriceOverride(true);
    bundleOrderItemImpl7.setSalePrice(new Money());
    bundleOrderItemImpl7.setSalePriceOverride(true);
    bundleOrderItemImpl7.setTaxable(true);
    bundleOrderItemImpl7.updateSaleAndRetailPrices();
    bundleOrderItemImpl7.setChildOrderItems(childOrderItems6);

    ArrayList<OrderItem> childOrderItems7 = new ArrayList<>();
    childOrderItems7.add(bundleOrderItemImpl7);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
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
    orderItem.setChildOrderItems(childOrderItems7);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrderItem(orderItem);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertSame(context, removeOrderItemActivity.execute((ProcessContext<CartOperationRequest>) context));
  }

  /**
   * Test {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}
   */
  @Test
  public void testRemoveItemAndChildren_givenAuditableCreatedByIsOne_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RemoveOrderItemActivity removeOrderItemActivity = new RemoveOrderItemActivity();
    ArrayList<OrderItem> oisToDelete = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable2);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
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
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    Money salePrice = new Money();
    bundleOrderItemImpl.setSalePrice(salePrice);
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    Money baseRetailPrice = new Money();
    orderItem.setBaseRetailPrice(baseRetailPrice);
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
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
    orderItem.setChildOrderItems(childOrderItems);

    // Act
    removeOrderItemActivity.removeItemAndChildren(oisToDelete, orderItem);

    // Assert
    assertEquals(2, oisToDelete.size());
    OrderItem getResult = oisToDelete.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    OrderItem getResult2 = oisToDelete.get(1);
    assertTrue(getResult2 instanceof BundleOrderItemImpl);
    assertTrue(getResult.getParentOrderItem() instanceof BundleOrderItemImpl);
    OrderItem parentOrderItem = getResult2.getParentOrderItem();
    assertTrue(parentOrderItem instanceof BundleOrderItemImpl);
    assertTrue(getResult.getGiftWrapOrderItem() instanceof GiftWrapOrderItemImpl);
    GiftWrapOrderItem giftWrapOrderItem = getResult2.getGiftWrapOrderItem();
    assertTrue(giftWrapOrderItem instanceof GiftWrapOrderItemImpl);
    Order order = getResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    Order order2 = getResult2.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    PersonalMessage personalMessage = getResult.getPersonalMessage();
    assertTrue(personalMessage instanceof PersonalMessageImpl);
    PersonalMessage personalMessage2 = getResult2.getPersonalMessage();
    assertTrue(personalMessage2 instanceof PersonalMessageImpl);
    Money adjustmentValue = getResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(order.getBroadleafAccountId());
    assertNull(order2.getBroadleafAccountId());
    assertNull(order.getId());
    assertNull(order2.getId());
    assertNull(giftWrapOrderItem.getId());
    assertNull(parentOrderItem.getId());
    assertNull(personalMessage2.getId());
    assertNull(order.getEmailAddress());
    assertNull(order2.getEmailAddress());
    assertNull(order.getFulfillmentStatus());
    assertNull(order2.getFulfillmentStatus());
    assertNull(order.getName());
    assertNull(order2.getName());
    assertNull(order.getOrderNumber());
    assertNull(order2.getOrderNumber());
    assertNull(parentOrderItem.getName());
    assertNull(((BundleOrderItemImpl) parentOrderItem).getMainEntityName());
    assertNull(personalMessage2.getMessage());
    assertNull(personalMessage2.getMessageFrom());
    assertNull(personalMessage2.getMessageTo());
    assertNull(personalMessage2.getOccasion());
    assertNull(order.getSubmitDate());
    assertNull(order2.getSubmitDate());
    assertNull(giftWrapOrderItem.getCartMessages());
    assertNull(parentOrderItem.getCartMessages());
    assertNull(order.getAllFutureCreditAdjustments());
    assertNull(order2.getAllFutureCreditAdjustments());
    assertNull(order.getCandidateOrderOffers());
    assertNull(order2.getCandidateOrderOffers());
    assertNull(order.getAddedOfferCodes());
    assertNull(order2.getAddedOfferCodes());
    assertNull(order.getFutureCreditOrderAdjustments());
    assertNull(order2.getFutureCreditOrderAdjustments());
    assertNull(order.getOrderAdjustments());
    assertNull(order2.getOrderAdjustments());
    assertNull(order.getDiscreteOrderItems());
    assertNull(order2.getDiscreteOrderItems());
    assertNull(order.getFulfillmentGroups());
    assertNull(order2.getFulfillmentGroups());
    assertNull(order.getNonDiscreteOrderItems());
    assertNull(order2.getNonDiscreteOrderItems());
    assertNull(order.getOrderItems());
    assertNull(order2.getOrderItems());
    assertNull(order.getOrderMessages());
    assertNull(order2.getOrderMessages());
    assertNull(order.getPayments());
    assertNull(order2.getPayments());
    assertNull(order.getOrderAttributes());
    assertNull(order2.getOrderAttributes());
    assertNull(order.getAdditionalOfferInformation());
    assertNull(order2.getAdditionalOfferInformation());
    assertNull(order.getAuditable());
    assertNull(order2.getAuditable());
    assertNull(order.getCurrency());
    assertNull(order2.getCurrency());
    assertNull(order.getLocale());
    assertNull(order2.getLocale());
    assertNull(((BundleOrderItemImpl) parentOrderItem).getBaseRetailPrice());
    assertNull(((BundleOrderItemImpl) parentOrderItem).getBaseSalePrice());
    assertNull(giftWrapOrderItem.getBaseRetailPrice());
    assertNull(giftWrapOrderItem.getBaseSalePrice());
    assertNull(order.getFulfillmentGroupAdjustmentsValue());
    assertNull(order2.getFulfillmentGroupAdjustmentsValue());
    assertNull(order.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertNull(order2.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertNull(order.getFutureCreditItemAdjustmentsValue());
    assertNull(order2.getFutureCreditItemAdjustmentsValue());
    assertNull(order.getFutureCreditOrderAdjustmentsValue());
    assertNull(order2.getFutureCreditOrderAdjustmentsValue());
    assertNull(order.getItemAdjustmentsValue());
    assertNull(order2.getItemAdjustmentsValue());
    assertNull(order.getTotal());
    assertNull(order2.getTotal());
    assertNull(order.getTotalAdjustmentsValue());
    assertNull(order2.getTotalAdjustmentsValue());
    assertNull(order.getTotalAfterAppliedPayments());
    assertNull(order2.getTotalAfterAppliedPayments());
    assertNull(order.getTotalFulfillmentCharges());
    assertNull(order2.getTotalFulfillmentCharges());
    assertNull(order.getTotalFutureCreditAdjustmentsValue());
    assertNull(order2.getTotalFutureCreditAdjustmentsValue());
    assertNull(order.getTotalShipping());
    assertNull(order2.getTotalShipping());
    assertNull(order.getTotalTax());
    assertNull(order2.getTotalTax());
    assertNull(giftWrapOrderItem.getAdjustmentValue());
    assertNull(parentOrderItem.getAdjustmentValue());
    assertNull(giftWrapOrderItem.getAverageAdjustmentValue());
    assertNull(parentOrderItem.getAverageAdjustmentValue());
    assertNull(giftWrapOrderItem.getAveragePrice());
    assertNull(parentOrderItem.getAveragePrice());
    assertNull(giftWrapOrderItem.getPrice());
    assertNull(parentOrderItem.getPrice());
    assertNull(parentOrderItem.getSalePrice());
    assertNull(giftWrapOrderItem.getCategory());
    assertNull(parentOrderItem.getCategory());
    assertNull(((BundleOrderItemImpl) parentOrderItem).getProduct());
    assertNull(giftWrapOrderItem.getProduct());
    assertNull(((BundleOrderItemImpl) parentOrderItem).getProductBundle());
    assertNull(((BundleOrderItemImpl) parentOrderItem).getSku());
    assertNull(giftWrapOrderItem.getSku());
    assertNull(giftWrapOrderItem.getSkuBundleItem());
    assertNull(giftWrapOrderItem.getBundleOrderItem());
    assertNull(giftWrapOrderItem.getGiftWrapOrderItem());
    assertNull(parentOrderItem.getGiftWrapOrderItem());
    assertNull(giftWrapOrderItem.getOrder());
    assertNull(parentOrderItem.getOrder());
    assertNull(giftWrapOrderItem.getParentOrderItem());
    assertNull(parentOrderItem.getParentOrderItem());
    assertNull(giftWrapOrderItem.getPersonalMessage());
    assertNull(parentOrderItem.getPersonalMessage());
    assertNull(giftWrapOrderItem.getOrderItemType());
    assertNull(parentOrderItem.getOrderItemType());
    assertNull(order.getStatus());
    assertNull(order2.getStatus());
    assertNull(order.getCustomer());
    assertNull(order2.getCustomer());
    assertEquals(0, order.getItemCount());
    assertEquals(0, order2.getItemCount());
    assertEquals(0, giftWrapOrderItem.getQuantity());
    assertEquals(0, parentOrderItem.getQuantity());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertFalse(((BundleOrderItemImpl) parentOrderItem).hasAdjustedItems());
    assertFalse(order.getHasOrderAdjustments());
    assertFalse(order2.getHasOrderAdjustments());
    assertFalse(order.getTaxOverride());
    assertFalse(order2.getTaxOverride());
    assertFalse(giftWrapOrderItem.getHasValidationError());
    assertFalse(parentOrderItem.getHasValidationError());
    assertFalse(giftWrapOrderItem.getIsDiscounted());
    assertFalse(parentOrderItem.getIsDiscounted());
    assertFalse(parentOrderItem.getIsOnSale());
    assertFalse(giftWrapOrderItem.isChildOrderItem());
    assertFalse(parentOrderItem.isChildOrderItem());
    assertTrue(((BundleOrderItemImpl) parentOrderItem).getBundleOrderItemFeePrices().isEmpty());
    List<DiscreteOrderItem> discreteOrderItems = ((BundleOrderItemImpl) parentOrderItem).getDiscreteOrderItems();
    assertTrue(discreteOrderItems.isEmpty());
    assertTrue(giftWrapOrderItem.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(giftWrapOrderItem.getWrappedItems().isEmpty());
    assertTrue(giftWrapOrderItem.getCandidateItemOffers().isEmpty());
    assertTrue(parentOrderItem.getCandidateItemOffers().isEmpty());
    assertTrue(giftWrapOrderItem.getChildOrderItems().isEmpty());
    assertTrue(parentOrderItem.getChildOrderItems().isEmpty());
    assertTrue(giftWrapOrderItem.getOrderItemAdjustments().isEmpty());
    assertTrue(parentOrderItem.getOrderItemAdjustments().isEmpty());
    assertTrue(giftWrapOrderItem.getOrderItemPriceDetails().isEmpty());
    assertTrue(parentOrderItem.getOrderItemPriceDetails().isEmpty());
    assertTrue(giftWrapOrderItem.getOrderItemQualifiers().isEmpty());
    assertTrue(giftWrapOrderItem.getProratedOrderItemAdjustments().isEmpty());
    assertTrue(giftWrapOrderItem.getAdditionalAttributes().isEmpty());
    assertTrue(giftWrapOrderItem.getOrderItemAttributes().isEmpty());
    assertTrue(parentOrderItem.getOrderItemAttributes().isEmpty());
    assertTrue(((BundleOrderItemImpl) parentOrderItem).getAllowDiscountsOnChildItems());
    assertTrue(parentOrderItem.isSkuActive());
    Money baseRetailPrice2 = ((BundleOrderItemImpl) getResult).getBaseRetailPrice();
    Money absResult = baseRetailPrice2.abs();
    assertEquals(baseRetailPrice, absResult.abs());
    Money baseRetailPrice3 = ((BundleOrderItemImpl) getResult2).getBaseRetailPrice();
    Money absResult2 = baseRetailPrice3.abs();
    assertEquals(baseRetailPrice, absResult2.abs());
    Money baseSalePrice = ((BundleOrderItemImpl) getResult).getBaseSalePrice();
    Money absResult3 = baseSalePrice.abs();
    assertEquals(baseRetailPrice, absResult3.abs());
    Money baseSalePrice2 = ((BundleOrderItemImpl) getResult2).getBaseSalePrice();
    Money absResult4 = baseSalePrice2.abs();
    assertEquals(baseRetailPrice, absResult4.abs());
    Money absResult5 = adjustmentValue.abs();
    assertEquals(baseRetailPrice, absResult5.abs());
    Money adjustmentValue2 = getResult2.getAdjustmentValue();
    Money absResult6 = adjustmentValue2.abs();
    assertEquals(baseRetailPrice, absResult6.abs());
    Money averageAdjustmentValue = getResult.getAverageAdjustmentValue();
    Money absResult7 = averageAdjustmentValue.abs();
    assertEquals(baseRetailPrice, absResult7.abs());
    Money averageAdjustmentValue2 = getResult2.getAverageAdjustmentValue();
    Money absResult8 = averageAdjustmentValue2.abs();
    assertEquals(baseRetailPrice, absResult8.abs());
    Money averagePrice = getResult.getAveragePrice();
    Money absResult9 = averagePrice.abs();
    assertEquals(baseRetailPrice, absResult9.abs());
    Money averagePrice2 = getResult2.getAveragePrice();
    Money absResult10 = averagePrice2.abs();
    assertEquals(baseRetailPrice, absResult10.abs());
    Money futureCreditTotalAdjustmentValue = getResult.getFutureCreditTotalAdjustmentValue();
    Money absResult11 = futureCreditTotalAdjustmentValue.abs();
    assertEquals(baseRetailPrice, absResult11.abs());
    Money futureCreditTotalAdjustmentValue2 = getResult2.getFutureCreditTotalAdjustmentValue();
    Money absResult12 = futureCreditTotalAdjustmentValue2.abs();
    assertEquals(baseRetailPrice, absResult12.abs());
    Money price = getResult.getPrice();
    Money absResult13 = price.abs();
    assertEquals(baseRetailPrice, absResult13.abs());
    Money price2 = getResult2.getPrice();
    Money absResult14 = price2.abs();
    assertEquals(baseRetailPrice, absResult14.abs());
    Money retailPrice = getResult.getRetailPrice();
    Money absResult15 = retailPrice.abs();
    assertEquals(baseRetailPrice, absResult15.abs());
    Money retailPrice2 = getResult2.getRetailPrice();
    Money absResult16 = retailPrice2.abs();
    assertEquals(baseRetailPrice, absResult16.abs());
    Money taxablePrice = getResult.getTaxablePrice();
    Money absResult17 = taxablePrice.abs();
    assertEquals(baseRetailPrice, absResult17.abs());
    Money taxablePrice2 = getResult2.getTaxablePrice();
    Money absResult18 = taxablePrice2.abs();
    assertEquals(baseRetailPrice, absResult18.abs());
    Money totalAdjustmentValue = getResult.getTotalAdjustmentValue();
    Money absResult19 = totalAdjustmentValue.abs();
    assertEquals(baseRetailPrice, absResult19.abs());
    Money totalAdjustmentValue2 = getResult2.getTotalAdjustmentValue();
    Money absResult20 = totalAdjustmentValue2.abs();
    assertEquals(baseRetailPrice, absResult20.abs());
    Money totalPrice = getResult.getTotalPrice();
    Money absResult21 = totalPrice.abs();
    assertEquals(baseRetailPrice, absResult21.abs());
    Money totalPrice2 = getResult2.getTotalPrice();
    Money absResult22 = totalPrice2.abs();
    assertEquals(baseRetailPrice, absResult22.abs());
    Money zeroResult = baseRetailPrice2.zero();
    assertEquals(baseRetailPrice, zeroResult.abs());
    Money zeroResult2 = baseRetailPrice3.zero();
    assertEquals(baseRetailPrice, zeroResult2.abs());
    Money zeroResult3 = baseSalePrice.zero();
    assertEquals(baseRetailPrice, zeroResult3.abs());
    Money zeroResult4 = baseSalePrice2.zero();
    assertEquals(baseRetailPrice, zeroResult4.abs());
    Money zeroResult5 = adjustmentValue.zero();
    assertEquals(baseRetailPrice, zeroResult5.abs());
    Money zeroResult6 = adjustmentValue2.zero();
    assertEquals(baseRetailPrice, zeroResult6.abs());
    Money zeroResult7 = averageAdjustmentValue.zero();
    assertEquals(baseRetailPrice, zeroResult7.abs());
    Money zeroResult8 = averageAdjustmentValue2.zero();
    assertEquals(baseRetailPrice, zeroResult8.abs());
    Money zeroResult9 = averagePrice.zero();
    assertEquals(baseRetailPrice, zeroResult9.abs());
    Money zeroResult10 = averagePrice2.zero();
    assertEquals(baseRetailPrice, zeroResult10.abs());
    Money zeroResult11 = futureCreditTotalAdjustmentValue.zero();
    assertEquals(baseRetailPrice, zeroResult11.abs());
    Money zeroResult12 = futureCreditTotalAdjustmentValue2.zero();
    assertEquals(baseRetailPrice, zeroResult12.abs());
    Money zeroResult13 = price.zero();
    assertEquals(baseRetailPrice, zeroResult13.abs());
    Money zeroResult14 = price2.zero();
    assertEquals(baseRetailPrice, zeroResult14.abs());
    Money zeroResult15 = retailPrice.zero();
    assertEquals(baseRetailPrice, zeroResult15.abs());
    Money zeroResult16 = retailPrice2.zero();
    assertEquals(baseRetailPrice, zeroResult16.abs());
    Money zeroResult17 = taxablePrice.zero();
    assertEquals(baseRetailPrice, zeroResult17.abs());
    Money zeroResult18 = taxablePrice2.zero();
    assertEquals(baseRetailPrice, zeroResult18.abs());
    Money zeroResult19 = totalAdjustmentValue.zero();
    assertEquals(baseRetailPrice, zeroResult19.abs());
    Money zeroResult20 = totalAdjustmentValue2.zero();
    assertEquals(baseRetailPrice, zeroResult20.abs());
    Money zeroResult21 = totalPrice.zero();
    assertEquals(baseRetailPrice, zeroResult21.abs());
    Money zeroResult22 = totalPrice2.zero();
    assertEquals(baseRetailPrice, zeroResult22.abs());
    assertEquals(baseRetailPrice, absResult.zero());
    assertEquals(baseRetailPrice, absResult2.zero());
    assertEquals(baseRetailPrice, absResult3.zero());
    assertEquals(baseRetailPrice, absResult4.zero());
    assertEquals(baseRetailPrice, absResult5.zero());
    assertEquals(baseRetailPrice, absResult6.zero());
    assertEquals(baseRetailPrice, absResult7.zero());
    assertEquals(baseRetailPrice, absResult8.zero());
    assertEquals(baseRetailPrice, absResult9.zero());
    assertEquals(baseRetailPrice, absResult10.zero());
    assertEquals(baseRetailPrice, absResult11.zero());
    assertEquals(baseRetailPrice, absResult12.zero());
    assertEquals(baseRetailPrice, absResult13.zero());
    assertEquals(baseRetailPrice, absResult14.zero());
    assertEquals(baseRetailPrice, absResult15.zero());
    assertEquals(baseRetailPrice, absResult16.zero());
    assertEquals(baseRetailPrice, absResult17.zero());
    assertEquals(baseRetailPrice, absResult18.zero());
    assertEquals(baseRetailPrice, absResult19.zero());
    assertEquals(baseRetailPrice, absResult20.zero());
    assertEquals(baseRetailPrice, absResult21.zero());
    assertEquals(baseRetailPrice, absResult22.zero());
    assertEquals(baseRetailPrice, zeroResult.zero());
    assertEquals(baseRetailPrice, zeroResult2.zero());
    assertEquals(baseRetailPrice, zeroResult3.zero());
    assertEquals(baseRetailPrice, zeroResult4.zero());
    assertEquals(baseRetailPrice, zeroResult5.zero());
    assertEquals(baseRetailPrice, zeroResult6.zero());
    assertEquals(baseRetailPrice, zeroResult7.zero());
    assertEquals(baseRetailPrice, zeroResult8.zero());
    assertEquals(baseRetailPrice, zeroResult9.zero());
    assertEquals(baseRetailPrice, zeroResult10.zero());
    assertEquals(baseRetailPrice, zeroResult11.zero());
    assertEquals(baseRetailPrice, zeroResult12.zero());
    assertEquals(baseRetailPrice, zeroResult13.zero());
    assertEquals(baseRetailPrice, zeroResult14.zero());
    assertEquals(baseRetailPrice, zeroResult15.zero());
    assertEquals(baseRetailPrice, zeroResult16.zero());
    assertEquals(baseRetailPrice, zeroResult17.zero());
    assertEquals(baseRetailPrice, zeroResult18.zero());
    assertEquals(baseRetailPrice, zeroResult19.zero());
    assertEquals(baseRetailPrice, zeroResult20.zero());
    assertEquals(baseRetailPrice, zeroResult21.zero());
    assertEquals(baseRetailPrice, zeroResult22.zero());
    assertEquals(baseRetailPrice, order.getSubTotal());
    assertEquals(baseRetailPrice, order2.getSubTotal());
    assertEquals(personalMessage2, personalMessage);
    assertSame(currency, absResult.getCurrency());
    assertSame(currency, absResult2.getCurrency());
    assertSame(currency, absResult3.getCurrency());
    assertSame(currency, absResult4.getCurrency());
    assertSame(currency, absResult5.getCurrency());
    assertSame(currency, absResult6.getCurrency());
    assertSame(currency, absResult7.getCurrency());
    assertSame(currency, absResult8.getCurrency());
    assertSame(currency, absResult9.getCurrency());
    assertSame(currency, absResult10.getCurrency());
    assertSame(currency, absResult11.getCurrency());
    assertSame(currency, absResult12.getCurrency());
    assertSame(currency, absResult13.getCurrency());
    assertSame(currency, absResult14.getCurrency());
    assertSame(currency, absResult15.getCurrency());
    assertSame(currency, absResult16.getCurrency());
    assertSame(currency, absResult17.getCurrency());
    assertSame(currency, absResult18.getCurrency());
    assertSame(currency, absResult19.getCurrency());
    assertSame(currency, absResult20.getCurrency());
    assertSame(currency, absResult21.getCurrency());
    assertSame(currency, absResult22.getCurrency());
    assertSame(currency, zeroResult.getCurrency());
    assertSame(currency, zeroResult2.getCurrency());
    assertSame(currency, zeroResult3.getCurrency());
    assertSame(currency, zeroResult4.getCurrency());
    assertSame(currency, zeroResult5.getCurrency());
    assertSame(currency, zeroResult6.getCurrency());
    assertSame(currency, zeroResult7.getCurrency());
    assertSame(currency, zeroResult8.getCurrency());
    assertSame(currency, zeroResult9.getCurrency());
    assertSame(currency, zeroResult10.getCurrency());
    assertSame(currency, zeroResult11.getCurrency());
    assertSame(currency, zeroResult12.getCurrency());
    assertSame(currency, zeroResult13.getCurrency());
    assertSame(currency, zeroResult14.getCurrency());
    assertSame(currency, zeroResult15.getCurrency());
    assertSame(currency, zeroResult16.getCurrency());
    assertSame(currency, zeroResult17.getCurrency());
    assertSame(currency, zeroResult18.getCurrency());
    assertSame(currency, zeroResult19.getCurrency());
    assertSame(currency, zeroResult20.getCurrency());
    assertSame(currency, zeroResult21.getCurrency());
    assertSame(currency, zeroResult22.getCurrency());
    assertSame(discreteOrderItems, ((BundleOrderItemImpl) parentOrderItem).getOrderItems());
    Money money = salePrice.ZERO;
    assertSame(money, order.getOrderAdjustmentsValue());
    assertSame(money, order2.getOrderAdjustmentsValue());
  }

  /**
   * Test {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Auditable CreatedBy is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}
   */
  @Test
  public void testRemoveItemAndChildren_thenArrayListFirstAuditableCreatedByIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RemoveOrderItemActivity removeOrderItemActivity = new RemoveOrderItemActivity();
    ArrayList<OrderItem> oisToDelete = new ArrayList<>();
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();

    // Act
    removeOrderItemActivity.removeItemAndChildren(oisToDelete, orderItem);

    // Assert
    assertEquals(1, oisToDelete.size());
    OrderItem getResult = oisToDelete.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    Auditable auditable = getResult.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(getResult.getId());
    assertNull(getResult.getName());
    assertNull(((BundleOrderItemImpl) getResult).getMainEntityName());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(getResult.getCartMessages());
    assertNull(((BundleOrderItemImpl) getResult).getBaseRetailPrice());
    assertNull(((BundleOrderItemImpl) getResult).getBaseSalePrice());
    assertNull(getResult.getAdjustmentValue());
    assertNull(getResult.getAverageAdjustmentValue());
    assertNull(getResult.getAveragePrice());
    assertNull(getResult.getPrice());
    assertNull(getResult.getGiftWrapOrderItem());
    assertNull(getResult.getOrder());
    assertNull(getResult.getParentOrderItem());
    assertNull(getResult.getPersonalMessage());
    assertNull(getResult.getOrderItemType());
    assertEquals(0, getResult.getQuantity());
    assertFalse(getResult.getHasValidationError());
    assertFalse(getResult.isChildOrderItem());
    List<OrderItem> childOrderItems = getResult.getChildOrderItems();
    assertTrue(childOrderItems.isEmpty());
    assertSame(auditable, orderItem.getAuditable());
    assertSame(childOrderItems, orderItem.getChildOrderItems());
  }

  /**
   * Test {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first is
   * {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}
   */
  @Test
  public void testRemoveItemAndChildren_thenArrayListFirstIsBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RemoveOrderItemActivity removeOrderItemActivity = new RemoveOrderItemActivity();
    ArrayList<OrderItem> oisToDelete = new ArrayList<>();
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getChildOrderItems()).thenReturn(new ArrayList<>());

    // Act
    removeOrderItemActivity.removeItemAndChildren(oisToDelete, orderItem);

    // Assert
    verify(orderItem).getChildOrderItems();
    assertEquals(1, oisToDelete.size());
    assertSame(orderItem, oisToDelete.get(0));
  }

  /**
   * Test {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}
   */
  @Test
  public void testRemoveItemAndChildren_thenArrayListSizeIsTen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RemoveOrderItemActivity removeOrderItemActivity = new RemoveOrderItemActivity();
    ArrayList<OrderItem> oisToDelete = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    Auditable auditable4 = new Auditable();
    auditable4.setCreatedBy(1L);
    auditable4.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable4.setUpdatedBy(1L);

    Auditable auditable5 = new Auditable();
    auditable5.setCreatedBy(1L);
    auditable5.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable5.setUpdatedBy(1L);

    Auditable auditable6 = new Auditable();
    auditable6.setCreatedBy(1L);
    auditable6.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable6.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable6.setUpdatedBy(1L);

    Auditable auditable7 = new Auditable();
    auditable7.setCreatedBy(1L);
    auditable7.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable7.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable7.setUpdatedBy(1L);

    Auditable auditable8 = new Auditable();
    auditable8.setCreatedBy(1L);
    auditable8.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable8.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable8.setUpdatedBy(1L);

    Auditable auditable9 = new Auditable();
    auditable9.setCreatedBy(1L);
    auditable9.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable9.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable9.setUpdatedBy(1L);

    Auditable auditable10 = new Auditable();
    auditable10.setCreatedBy(1L);
    auditable10.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable10.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable10.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
    bundleOrderItemImpl.setAuditable(auditable10);
    bundleOrderItemImpl.setBaseRetailPrice(new Money());
    bundleOrderItemImpl.setBaseSalePrice(new Money());
    bundleOrderItemImpl.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl.setDiscountingAllowed(true);
    bundleOrderItemImpl.setDiscreteOrderItems(new ArrayList<>());
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
    bundleOrderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl.setQuantity(1);
    bundleOrderItemImpl.setRetailPrice(new Money());
    bundleOrderItemImpl.setRetailPriceOverride(true);
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable9);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
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
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setChildOrderItems(childOrderItems);

    ArrayList<OrderItem> childOrderItems2 = new ArrayList<>();
    childOrderItems2.add(bundleOrderItemImpl2);

    BundleOrderItemImpl bundleOrderItemImpl3 = new BundleOrderItemImpl();
    bundleOrderItemImpl3.setAuditable(auditable8);
    bundleOrderItemImpl3.setBaseRetailPrice(new Money());
    bundleOrderItemImpl3.setBaseSalePrice(new Money());
    bundleOrderItemImpl3.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl3.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl3.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl3.setDiscountingAllowed(true);
    bundleOrderItemImpl3.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl3.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl3.setHasValidationError(true);
    bundleOrderItemImpl3.setId(1L);
    bundleOrderItemImpl3.setName("Name");
    bundleOrderItemImpl3.setOrder(new NullOrderImpl());
    bundleOrderItemImpl3.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl3.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl3.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl3.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl3.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl3.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl3.setQuantity(1);
    bundleOrderItemImpl3.setRetailPrice(new Money());
    bundleOrderItemImpl3.setRetailPriceOverride(true);
    bundleOrderItemImpl3.setSalePrice(new Money());
    bundleOrderItemImpl3.setSalePriceOverride(true);
    bundleOrderItemImpl3.setTaxable(true);
    bundleOrderItemImpl3.updateSaleAndRetailPrices();
    bundleOrderItemImpl3.setChildOrderItems(childOrderItems2);

    ArrayList<OrderItem> childOrderItems3 = new ArrayList<>();
    childOrderItems3.add(bundleOrderItemImpl3);

    BundleOrderItemImpl bundleOrderItemImpl4 = new BundleOrderItemImpl();
    bundleOrderItemImpl4.setAuditable(auditable7);
    bundleOrderItemImpl4.setBaseRetailPrice(new Money());
    bundleOrderItemImpl4.setBaseSalePrice(new Money());
    bundleOrderItemImpl4.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl4.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl4.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl4.setDiscountingAllowed(true);
    bundleOrderItemImpl4.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl4.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl4.setHasValidationError(true);
    bundleOrderItemImpl4.setId(1L);
    bundleOrderItemImpl4.setName("Name");
    bundleOrderItemImpl4.setOrder(new NullOrderImpl());
    bundleOrderItemImpl4.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl4.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl4.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl4.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl4.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl4.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl4.setQuantity(1);
    bundleOrderItemImpl4.setRetailPrice(new Money());
    bundleOrderItemImpl4.setRetailPriceOverride(true);
    bundleOrderItemImpl4.setSalePrice(new Money());
    bundleOrderItemImpl4.setSalePriceOverride(true);
    bundleOrderItemImpl4.setTaxable(true);
    bundleOrderItemImpl4.updateSaleAndRetailPrices();
    bundleOrderItemImpl4.setChildOrderItems(childOrderItems3);

    ArrayList<OrderItem> childOrderItems4 = new ArrayList<>();
    childOrderItems4.add(bundleOrderItemImpl4);

    BundleOrderItemImpl bundleOrderItemImpl5 = new BundleOrderItemImpl();
    bundleOrderItemImpl5.setAuditable(auditable6);
    bundleOrderItemImpl5.setBaseRetailPrice(new Money());
    bundleOrderItemImpl5.setBaseSalePrice(new Money());
    bundleOrderItemImpl5.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl5.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl5.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl5.setDiscountingAllowed(true);
    bundleOrderItemImpl5.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl5.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl5.setHasValidationError(true);
    bundleOrderItemImpl5.setId(1L);
    bundleOrderItemImpl5.setName("Name");
    bundleOrderItemImpl5.setOrder(new NullOrderImpl());
    bundleOrderItemImpl5.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl5.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl5.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl5.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl5.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl5.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl5.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl5.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl5.setQuantity(1);
    bundleOrderItemImpl5.setRetailPrice(new Money());
    bundleOrderItemImpl5.setRetailPriceOverride(true);
    bundleOrderItemImpl5.setSalePrice(new Money());
    bundleOrderItemImpl5.setSalePriceOverride(true);
    bundleOrderItemImpl5.setTaxable(true);
    bundleOrderItemImpl5.updateSaleAndRetailPrices();
    bundleOrderItemImpl5.setChildOrderItems(childOrderItems4);

    ArrayList<OrderItem> childOrderItems5 = new ArrayList<>();
    childOrderItems5.add(bundleOrderItemImpl5);

    BundleOrderItemImpl bundleOrderItemImpl6 = new BundleOrderItemImpl();
    bundleOrderItemImpl6.setAuditable(auditable5);
    bundleOrderItemImpl6.setBaseRetailPrice(new Money());
    bundleOrderItemImpl6.setBaseSalePrice(new Money());
    bundleOrderItemImpl6.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl6.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl6.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl6.setDiscountingAllowed(true);
    bundleOrderItemImpl6.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl6.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl6.setHasValidationError(true);
    bundleOrderItemImpl6.setId(1L);
    bundleOrderItemImpl6.setName("Name");
    bundleOrderItemImpl6.setOrder(new NullOrderImpl());
    bundleOrderItemImpl6.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl6.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl6.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl6.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl6.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl6.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl6.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl6.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl6.setQuantity(1);
    bundleOrderItemImpl6.setRetailPrice(new Money());
    bundleOrderItemImpl6.setRetailPriceOverride(true);
    bundleOrderItemImpl6.setSalePrice(new Money());
    bundleOrderItemImpl6.setSalePriceOverride(true);
    bundleOrderItemImpl6.setTaxable(true);
    bundleOrderItemImpl6.updateSaleAndRetailPrices();
    bundleOrderItemImpl6.setChildOrderItems(childOrderItems5);

    ArrayList<OrderItem> childOrderItems6 = new ArrayList<>();
    childOrderItems6.add(bundleOrderItemImpl6);

    BundleOrderItemImpl bundleOrderItemImpl7 = new BundleOrderItemImpl();
    bundleOrderItemImpl7.setAuditable(auditable4);
    bundleOrderItemImpl7.setBaseRetailPrice(new Money());
    bundleOrderItemImpl7.setBaseSalePrice(new Money());
    bundleOrderItemImpl7.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl7.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl7.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl7.setDiscountingAllowed(true);
    bundleOrderItemImpl7.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl7.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl7.setHasValidationError(true);
    bundleOrderItemImpl7.setId(1L);
    bundleOrderItemImpl7.setName("Name");
    bundleOrderItemImpl7.setOrder(new NullOrderImpl());
    bundleOrderItemImpl7.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl7.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl7.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl7.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl7.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl7.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl7.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl7.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl7.setQuantity(1);
    bundleOrderItemImpl7.setRetailPrice(new Money());
    bundleOrderItemImpl7.setRetailPriceOverride(true);
    bundleOrderItemImpl7.setSalePrice(new Money());
    bundleOrderItemImpl7.setSalePriceOverride(true);
    bundleOrderItemImpl7.setTaxable(true);
    bundleOrderItemImpl7.updateSaleAndRetailPrices();
    bundleOrderItemImpl7.setChildOrderItems(childOrderItems6);

    ArrayList<OrderItem> childOrderItems7 = new ArrayList<>();
    childOrderItems7.add(bundleOrderItemImpl7);

    BundleOrderItemImpl bundleOrderItemImpl8 = new BundleOrderItemImpl();
    bundleOrderItemImpl8.setAuditable(auditable3);
    bundleOrderItemImpl8.setBaseRetailPrice(new Money());
    bundleOrderItemImpl8.setBaseSalePrice(new Money());
    bundleOrderItemImpl8.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl8.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl8.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl8.setDiscountingAllowed(true);
    bundleOrderItemImpl8.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl8.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl8.setHasValidationError(true);
    bundleOrderItemImpl8.setId(1L);
    bundleOrderItemImpl8.setName("Name");
    bundleOrderItemImpl8.setOrder(new NullOrderImpl());
    bundleOrderItemImpl8.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl8.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl8.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl8.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl8.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl8.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl8.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl8.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl8.setQuantity(1);
    bundleOrderItemImpl8.setRetailPrice(new Money());
    bundleOrderItemImpl8.setRetailPriceOverride(true);
    bundleOrderItemImpl8.setSalePrice(new Money());
    bundleOrderItemImpl8.setSalePriceOverride(true);
    bundleOrderItemImpl8.setTaxable(true);
    bundleOrderItemImpl8.updateSaleAndRetailPrices();
    bundleOrderItemImpl8.setChildOrderItems(childOrderItems7);

    ArrayList<OrderItem> childOrderItems8 = new ArrayList<>();
    childOrderItems8.add(bundleOrderItemImpl8);

    BundleOrderItemImpl bundleOrderItemImpl9 = new BundleOrderItemImpl();
    bundleOrderItemImpl9.setAuditable(auditable2);
    bundleOrderItemImpl9.setBaseRetailPrice(new Money());
    bundleOrderItemImpl9.setBaseSalePrice(new Money());
    bundleOrderItemImpl9.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl9.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl9.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl9.setDiscountingAllowed(true);
    bundleOrderItemImpl9.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl9.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl9.setHasValidationError(true);
    bundleOrderItemImpl9.setId(1L);
    bundleOrderItemImpl9.setName("Name");
    bundleOrderItemImpl9.setOrder(new NullOrderImpl());
    bundleOrderItemImpl9.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl9.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl9.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl9.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl9.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl9.setParentOrderItem(new BundleOrderItemImpl());
    bundleOrderItemImpl9.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl9.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl9.setQuantity(1);
    bundleOrderItemImpl9.setRetailPrice(new Money());
    bundleOrderItemImpl9.setRetailPriceOverride(true);
    bundleOrderItemImpl9.setSalePrice(new Money());
    bundleOrderItemImpl9.setSalePriceOverride(true);
    bundleOrderItemImpl9.setTaxable(true);
    bundleOrderItemImpl9.updateSaleAndRetailPrices();
    bundleOrderItemImpl9.setChildOrderItems(childOrderItems8);

    ArrayList<OrderItem> childOrderItems9 = new ArrayList<>();
    childOrderItems9.add(bundleOrderItemImpl9);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
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
    orderItem.setChildOrderItems(childOrderItems9);

    // Act
    removeOrderItemActivity.removeItemAndChildren(oisToDelete, orderItem);

    // Assert
    assertEquals(10, oisToDelete.size());
    OrderItem getResult = oisToDelete.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    OrderItem getResult2 = oisToDelete.get(1);
    assertTrue(getResult2 instanceof BundleOrderItemImpl);
    assertTrue(getResult.getParentOrderItem() instanceof BundleOrderItemImpl);
    assertTrue(getResult2.getParentOrderItem() instanceof BundleOrderItemImpl);
    assertTrue(getResult.getGiftWrapOrderItem() instanceof GiftWrapOrderItemImpl);
    assertTrue(getResult2.getGiftWrapOrderItem() instanceof GiftWrapOrderItemImpl);
    assertTrue(getResult.getPersonalMessage() instanceof PersonalMessageImpl);
    assertTrue(getResult2.getPersonalMessage() instanceof PersonalMessageImpl);
    assertEquals(auditable, getResult2.getAuditable());
    assertSame(bundleOrderItemImpl3, oisToDelete.get(2));
    assertSame(bundleOrderItemImpl4, oisToDelete.get(3));
    assertSame(bundleOrderItemImpl5, oisToDelete.get(4));
    assertSame(bundleOrderItemImpl6, oisToDelete.get(5));
    assertSame(bundleOrderItemImpl7, oisToDelete.get(6));
    assertSame(bundleOrderItemImpl8, oisToDelete.get(7));
    assertSame(bundleOrderItemImpl9, oisToDelete.get(8));
    assertSame(orderItem, oisToDelete.get(9));
  }
}
