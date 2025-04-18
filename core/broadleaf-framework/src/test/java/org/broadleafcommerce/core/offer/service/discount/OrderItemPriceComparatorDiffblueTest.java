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
package org.broadleafcommerce.core.offer.service.discount;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItem;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.Ignore;
import org.junit.Test;

public class OrderItemPriceComparatorDiffblueTest {
  /**
   * Test {@link OrderItemPriceComparator#OrderItemPriceComparator(boolean)}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceComparator#OrderItemPriceComparator(boolean)}
   */
  @Test
  public void testNewOrderItemPriceComparator() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     OrderItemPriceComparator.applyToSalePrice

    // Arrange and Act
    new OrderItemPriceComparator(true);
  }

  /**
   * Test
   * {@link OrderItemPriceComparator#compare(PromotableOrderItem, PromotableOrderItem)}
   * with {@code PromotableOrderItem}, {@code PromotableOrderItem}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceComparator#compare(PromotableOrderItem, PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCompareWithPromotableOrderItemPromotableOrderItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    OrderItemPriceComparator orderItemPriceComparator = new OrderItemPriceComparator(true);

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
    orderItem.setOrder(new OrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl c1 = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    BundleOrderItemImpl orderItem2 = new BundleOrderItemImpl();
    orderItem2.setOrder(new NullOrderImpl());
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderItemPriceComparator.compare(c1, new PromotableOrderItemImpl(orderItem2, promotableOrder2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderItemPriceComparator#compare(PromotableOrderItem, PromotableOrderItem)}
   * with {@code PromotableOrderItem}, {@code PromotableOrderItem}.
   * <p>
   * Method under test:
   * {@link OrderItemPriceComparator#compare(PromotableOrderItem, PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCompareWithPromotableOrderItemPromotableOrderItem2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getRetailPriceBeforeAdjustments(PromotableOrderItemImpl.java:135)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getPriceBeforeAdjustments(PromotableOrderItemImpl.java:142)
    //       at org.broadleafcommerce.core.offer.service.discount.OrderItemPriceComparator.compare(OrderItemPriceComparator.java:40)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    OrderItemPriceComparator orderItemPriceComparator = new OrderItemPriceComparator(true);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl c1 = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    BundleOrderItemImpl orderItem2 = new BundleOrderItemImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderItemPriceComparator.compare(c1, new PromotableOrderItemImpl(orderItem2, promotableOrder2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }
}
