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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
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
public class RemoveOrderMultishipOptionActivityDiffblueTest {
  @InjectMocks private RemoveOrderMultishipOptionActivity removeOrderMultishipOptionActivity;

  /**
   * Test {@link RemoveOrderMultishipOptionActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then SeedData AddedOrderItem return {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveOrderMultishipOptionActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext RemoveOrderMultishipOptionActivity.execute(ProcessContext)"})
  public void testExecute_thenSeedDataAddedOrderItemReturnBundleOrderItemImpl() throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
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
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setDiscreteOrderItems(discreteOrderItems);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrderItem(orderItem);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        removeOrderMultishipOptionActivity.execute(context);

    // Assert
    CartOperationRequest seedData = actualExecuteResult.getSeedData();
    OrderItem addedOrderItem = seedData.getAddedOrderItem();
    assertTrue(addedOrderItem instanceof BundleOrderItemImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(orderItem, addedOrderItem);
    assertSame(orderItem, seedData.getOrderItem());
  }

  /**
   * Test {@link RemoveOrderMultishipOptionActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then SeedData Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveOrderMultishipOptionActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext RemoveOrderMultishipOptionActivity.execute(ProcessContext)"})
  public void testExecute_thenSeedDataOrderReturnNullOrderImpl() throws Exception {
    // Arrange
    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        removeOrderMultishipOptionActivity.execute(context);

    // Assert
    CartOperationRequest seedData = actualExecuteResult.getSeedData();
    Order order2 = seedData.getOrder();
    assertTrue(order2 instanceof NullOrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertNull(seedData.getAddedOrderItem());
    assertNull(seedData.getOrderItem());
    Money orderAdjustmentsValue = order2.getOrderAdjustmentsValue();
    assertEquals(new BigDecimal("0.00"), orderAdjustmentsValue.getAmount());
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, order2.getSubTotal());
  }
}
