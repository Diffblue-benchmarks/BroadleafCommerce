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
package org.broadleafcommerce.core.order.service.workflow.remove;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItem;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RemoveOrderItemActivityDiffblueTest {
  @InjectMocks
  private RemoveOrderItemActivity removeOrderItemActivity;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext RemoveOrderItemActivity.execute(ProcessContext)"})
  public void testExecute_givenAuditableCreatedByIsOne_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
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
    assertSame(context, removeOrderItemActivity.execute(context));
  }

  /**
   * Test {@link RemoveOrderItemActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) ChildOrderItems is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveOrderItemActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext RemoveOrderItemActivity.execute(ProcessContext)"})
  public void testExecute_givenBundleOrderItemImplChildOrderItemsIsNull() throws Exception {
    // Arrange
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
    assertSame(context, removeOrderItemActivity.execute(context));
  }

  /**
   * Test {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoveOrderItemActivity.removeItemAndChildren(List, OrderItem)"})
  public void testRemoveItemAndChildren_givenAuditableCreatedByIsOne_thenArrayListSizeIsTwo() {
    // Arrange
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
    bundleOrderItemImpl.setSalePrice(new Money());
    bundleOrderItemImpl.setSalePriceOverride(true);
    bundleOrderItemImpl.setTaxable(true);
    bundleOrderItemImpl.updateSaleAndRetailPrices();
    bundleOrderItemImpl.setChildOrderItems(null);

    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    childOrderItems.add(bundleOrderItemImpl);

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
    orderItem.setChildOrderItems(childOrderItems);

    // Act
    removeOrderItemActivity.removeItemAndChildren(oisToDelete, orderItem);

    // Assert
    assertEquals(2, oisToDelete.size());
    OrderItem getResult = oisToDelete.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    OrderItem getResult2 = oisToDelete.get(1);
    assertTrue(getResult2 instanceof BundleOrderItemImpl);
    OrderItem parentOrderItem = getResult.getParentOrderItem();
    assertTrue(parentOrderItem instanceof BundleOrderItemImpl);
    OrderItem parentOrderItem2 = getResult2.getParentOrderItem();
    assertTrue(parentOrderItem2 instanceof BundleOrderItemImpl);
    GiftWrapOrderItem giftWrapOrderItem = getResult.getGiftWrapOrderItem();
    assertTrue(giftWrapOrderItem instanceof GiftWrapOrderItemImpl);
    GiftWrapOrderItem giftWrapOrderItem2 = getResult2.getGiftWrapOrderItem();
    assertTrue(giftWrapOrderItem2 instanceof GiftWrapOrderItemImpl);
    assertTrue(getResult.getOrder() instanceof NullOrderImpl);
    assertTrue(getResult2.getOrder() instanceof NullOrderImpl);
    PersonalMessage personalMessage = getResult.getPersonalMessage();
    assertTrue(personalMessage instanceof PersonalMessageImpl);
    PersonalMessage personalMessage2 = getResult2.getPersonalMessage();
    assertTrue(personalMessage2 instanceof PersonalMessageImpl);
    assertEquals(parentOrderItem2, parentOrderItem);
    assertEquals(giftWrapOrderItem2, giftWrapOrderItem);
    assertEquals(personalMessage2, personalMessage);
  }

  /**
   * Test {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoveOrderItemActivity.removeItemAndChildren(List, OrderItem)"})
  public void testRemoveItemAndChildren_thenArrayListSizeIsTen() {
    // Arrange
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
    OrderItem getResult = oisToDelete.get(2);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    OrderItem getResult2 = oisToDelete.get(3);
    assertTrue(getResult2 instanceof BundleOrderItemImpl);
    OrderItem getResult3 = oisToDelete.get(4);
    assertTrue(getResult3 instanceof BundleOrderItemImpl);
    OrderItem getResult4 = oisToDelete.get(5);
    assertTrue(getResult4 instanceof BundleOrderItemImpl);
    OrderItem getResult5 = oisToDelete.get(6);
    assertTrue(getResult5 instanceof BundleOrderItemImpl);
    OrderItem getResult6 = oisToDelete.get(7);
    assertTrue(getResult6 instanceof BundleOrderItemImpl);
    OrderItem getResult7 = oisToDelete.get(8);
    assertTrue(getResult7 instanceof BundleOrderItemImpl);
    OrderItem getResult8 = oisToDelete.get(9);
    assertTrue(getResult8 instanceof BundleOrderItemImpl);
    assertSame(bundleOrderItemImpl3, getResult);
    assertSame(bundleOrderItemImpl4, getResult2);
    assertSame(bundleOrderItemImpl5, getResult3);
    assertSame(bundleOrderItemImpl6, getResult4);
    assertSame(bundleOrderItemImpl7, getResult5);
    assertSame(bundleOrderItemImpl8, getResult6);
    assertSame(bundleOrderItemImpl9, getResult7);
    assertSame(orderItem, getResult8);
  }

  /**
   * Test {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}.
   * <ul>
   *   <li>When {@link BundleOrderItemImpl} (default constructor).</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveOrderItemActivity#removeItemAndChildren(List, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RemoveOrderItemActivity.removeItemAndChildren(List, OrderItem)"})
  public void testRemoveItemAndChildren_whenBundleOrderItemImpl_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<OrderItem> oisToDelete = new ArrayList<>();

    // Act
    removeOrderItemActivity.removeItemAndChildren(oisToDelete, new BundleOrderItemImpl());

    // Assert
    assertEquals(1, oisToDelete.size());
    OrderItem getResult = oisToDelete.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertNull(getResult.getId());
    assertNull(getResult.getName());
    assertNull(((BundleOrderItemImpl) getResult).getMainEntityName());
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
    assertTrue(getResult.getChildOrderItems().isEmpty());
  }
}
