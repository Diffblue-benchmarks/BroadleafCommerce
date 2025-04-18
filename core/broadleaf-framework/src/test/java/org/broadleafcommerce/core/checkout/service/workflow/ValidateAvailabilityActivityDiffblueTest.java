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
package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.inventory.service.ContextualInventoryService;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidateAvailabilityActivityDiffblueTest {
  @Mock
  private ContextualInventoryService contextualInventoryService;

  @InjectMocks
  private ValidateAvailabilityActivity validateAvailabilityActivity;

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenReturn(true);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenThrow(new IllegalArgumentException("foo"));
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setOrderItems(orderItems);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(skuImpl).isActive();
    verify(bundleOrderItemImpl).getSku();
    verify(bundleOrderItemImpl).getQuantity();
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_givenBundleOrderItemImplGetSkuReturnSkuImpl() throws Exception {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setOrderItems(orderItems);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(bundleOrderItemImpl).getSku();
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link ContextualInventoryService#checkSkuAvailability(Order, Sku, Integer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsCheckSkuAvailability() throws Exception {
    // Arrange
    doNothing().when(contextualInventoryService)
        .checkSkuAvailability(Mockito.<Order>any(), Mockito.<Sku>any(), Mockito.<Integer>any());
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenReturn(true);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenReturn(1);
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setOrderItems(orderItems);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = validateAvailabilityActivity.execute(context);

    // Assert
    verify(skuImpl).isActive();
    verify(contextualInventoryService).checkSkuAvailability(isA(Order.class), isA(Sku.class), eq(1));
    verify(bundleOrderItemImpl).getSku();
    verify(bundleOrderItemImpl).getQuantity();
    assertTrue(actualExecuteResult.getSeedData().getOrder() instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link Order#getOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetOrderItems() throws Exception {
    // Arrange
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(order).getOrderItems();
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(new CheckoutSeed(null, new HashMap<>()));

    // Act and Assert
    assertSame(context, validateAvailabilityActivity.execute(context));
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return SeedData Order NonDiscreteOrderItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnSeedDataOrderNonDiscreteOrderItemsSizeIsOne() throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
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
    Money finalPrice = new Money();
    orderItemImpl.setPrice(finalPrice);
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setOrderItems(orderItems);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = validateAvailabilityActivity.execute(context);

    // Assert
    Order order2 = actualExecuteResult.getSeedData().getOrder();
    assertTrue(order2 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertEquals(1, order2.getNonDiscreteOrderItems().size());
    assertEquals(1, order2.getOrderItems().size());
    assertEquals(1, order2.getItemCount());
    assertEquals(finalPrice, order2.getFulfillmentGroupAdjustmentsValue());
    assertEquals(finalPrice, order2.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertEquals(finalPrice, order2.getFutureCreditItemAdjustmentsValue());
    assertEquals(finalPrice, order2.getFutureCreditOrderAdjustmentsValue());
    assertEquals(finalPrice, order2.getItemAdjustmentsValue());
    assertEquals(finalPrice, order2.getOrderAdjustmentsValue());
    assertEquals(finalPrice, order2.getTotalAdjustmentsValue());
    assertEquals(finalPrice, order2.getTotalFutureCreditAdjustmentsValue());
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return SeedData Order OrderItems Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnSeedDataOrderOrderItemsEmpty() throws Exception {
    // Arrange
    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    OrderImpl order = new OrderImpl();
    context.setSeedData(new CheckoutSeed(order, new HashMap<>()));

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = validateAvailabilityActivity.execute(context);

    // Assert
    Order order2 = actualExecuteResult.getSeedData().getOrder();
    assertTrue(order2 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertTrue(order2.getOrderItems().isEmpty());
  }
}
