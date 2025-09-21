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
package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PromotableFulfillmentGroupImplDiffblueTest {
  /**
   * Test {@link PromotableFulfillmentGroupImpl#getDiscountableOrderItems()}.
   *
   * <p>Method under test: {@link PromotableFulfillmentGroupImpl#getDiscountableOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PromotableFulfillmentGroupImpl.getDiscountableOrderItems()"})
  public void testGetDiscountableOrderItems() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();
    fulfillmentGroupItem.setOrderItem(new BundleOrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(fulfillmentGroupItem);
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl =
        new PromotableFulfillmentGroupImpl(
            fulfillmentGroup,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    List<PromotableOrderItem> actualDiscountableOrderItems =
        promotableFulfillmentGroupImpl.getDiscountableOrderItems();

    // Assert
    PromotableOrder promotableOrder2 = promotableFulfillmentGroupImpl.promotableOrder;
    assertTrue(promotableOrder2 instanceof PromotableOrderImpl);
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertSame(
        promotableOrder.allOrderItems, ((PromotableOrderImpl) promotableOrder2).allOrderItems);
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#getDiscountableOrderItems()}.
   *
   * <p>Method under test: {@link PromotableFulfillmentGroupImpl#getDiscountableOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PromotableFulfillmentGroupImpl.getDiscountableOrderItems()"})
  public void testGetDiscountableOrderItems2() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();
    fulfillmentGroupItem.setOrderItem(new OrderItemImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(fulfillmentGroupItem);
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl =
        new PromotableFulfillmentGroupImpl(
            fulfillmentGroup,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    List<PromotableOrderItem> actualDiscountableOrderItems =
        promotableFulfillmentGroupImpl.getDiscountableOrderItems();

    // Assert
    PromotableOrder promotableOrder2 = promotableFulfillmentGroupImpl.promotableOrder;
    assertTrue(promotableOrder2 instanceof PromotableOrderImpl);
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertSame(
        promotableOrder.allOrderItems, ((PromotableOrderImpl) promotableOrder2).allOrderItems);
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#getDiscountableOrderItems()}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   * </ul>
   *
   * <p>Method under test: {@link PromotableFulfillmentGroupImpl#getDiscountableOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PromotableFulfillmentGroupImpl.getDiscountableOrderItems()"})
  public void testGetDiscountableOrderItems_givenAuditableCreatedByIsOne() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl =
        new PromotableFulfillmentGroupImpl(
            fulfillmentGroup,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    List<PromotableOrderItem> actualDiscountableOrderItems =
        promotableFulfillmentGroupImpl.getDiscountableOrderItems();

    // Assert
    PromotableOrder promotableOrder2 = promotableFulfillmentGroupImpl.promotableOrder;
    assertTrue(promotableOrder2 instanceof PromotableOrderImpl);
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertSame(
        promotableOrder.allOrderItems, ((PromotableOrderImpl) promotableOrder2).allOrderItems);
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#getDiscountableOrderItems()}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Price is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link PromotableFulfillmentGroupImpl#getDiscountableOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PromotableFulfillmentGroupImpl.getDiscountableOrderItems()"})
  public void testGetDiscountableOrderItems_givenOrderItemImplPriceIsMoney() {
    // Arrange
    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setPrice(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();
    fulfillmentGroupItem.setOrderItem(orderItem);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.addFulfillmentGroupItem(fulfillmentGroupItem);
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl =
        new PromotableFulfillmentGroupImpl(
            fulfillmentGroup,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    List<PromotableOrderItem> actualDiscountableOrderItems =
        promotableFulfillmentGroupImpl.getDiscountableOrderItems();

    // Assert
    PromotableOrder promotableOrder2 = promotableFulfillmentGroupImpl.promotableOrder;
    assertTrue(promotableOrder2 instanceof PromotableOrderImpl);
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertSame(
        promotableOrder.allOrderItems, ((PromotableOrderImpl) promotableOrder2).allOrderItems);
  }
}
