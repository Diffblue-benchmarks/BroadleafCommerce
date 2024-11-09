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
package org.broadleafcommerce.core.order.service.workflow.update;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.ItemNotFoundException;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;

public class UpdateOrderItemActivityDiffblueTest {
  /**
   * Test {@link UpdateOrderItemActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateOrderItemActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenAuditableCreatedByIsOne_thenThrowItemNotFoundException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateOrderItemActivity updateOrderItemActivity = new UpdateOrderItemActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
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
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> updateOrderItemActivity.execute(context));
    verify(context).getSeedData();
  }

  /**
   * Test {@link UpdateOrderItemActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link ItemNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateOrderItemActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenThrowItemNotFoundException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateOrderItemActivity updateOrderItemActivity = new UpdateOrderItemActivity();
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    OrderImpl order = new OrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act and Assert
    assertThrows(ItemNotFoundException.class, () -> updateOrderItemActivity.execute(context));
    verify(context).getSeedData();
  }
}
