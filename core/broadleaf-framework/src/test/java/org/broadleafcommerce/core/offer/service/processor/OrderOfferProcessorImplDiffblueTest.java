package org.broadleafcommerce.core.offer.service.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.dao.OfferDaoImpl;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderAdjustmentImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.service.OfferServiceUtilities;
import org.broadleafcommerce.core.offer.service.OfferServiceUtilitiesImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateOrderOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateOrderOfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroup;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderAdjustment;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderAdjustmentImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItem;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetail;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.order.dao.OrderItemDao;
import org.broadleafcommerce.core.order.dao.OrderItemDaoImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderOfferProcessorImplDiffblueTest {
  @Autowired
  private OrderOfferProcessorImpl orderOfferProcessorImpl;

  /**
   * Test
   * {@link OrderOfferProcessorImpl#filterOrderLevelOffer(PromotableOrder, List, Offer)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#filterOrderLevelOffer(PromotableOrder, List, Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterOrderLevelOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3807 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    ArrayList<PromotableCandidateOrderOffer> qualifiedOrderOffers = new ArrayList<>();

    // Act
    orderOfferProcessorImpl2.filterOrderLevelOffer(promotableOrder, qualifiedOrderOffers, new OfferImpl());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#filterOrderLevelOffer(PromotableOrder, List, Offer)}.
   * <ul>
   *   <li>Given {@link OfferDiscountType#FIX_PRICE}.</li>
   *   <li>Then calls {@link Offer#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#filterOrderLevelOffer(PromotableOrder, List, Offer)}
   */
  @Test
  public void testFilterOrderLevelOffer_givenFix_price_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    ArrayList<PromotableCandidateOrderOffer> qualifiedOrderOffers = new ArrayList<>();
    Offer offer = mock(Offer.class);
    when(offer.getName()).thenReturn("Name");
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);

    // Act
    orderOfferProcessorImpl.filterOrderLevelOffer(promotableOrder, qualifiedOrderOffers, offer);

    // Assert
    verify(offer).getDiscountType();
    verify(offer).getName();
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#filterOrderLevelOffer(PromotableOrder, List, Offer)}.
   * <ul>
   *   <li>Then calls {@link Offer#getApplyDiscountToSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#filterOrderLevelOffer(PromotableOrder, List, Offer)}
   */
  @Test
  public void testFilterOrderLevelOffer_thenCallsGetApplyDiscountToSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    ArrayList<PromotableCandidateOrderOffer> qualifiedOrderOffers = new ArrayList<>();
    Offer offer = mock(Offer.class);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(OfferType.FULFILLMENT_GROUP);
    when(offer.getApplyDiscountToSalePrice()).thenReturn(true);
    when(offer.getOfferMatchRulesXref()).thenReturn(new HashMap<>());
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    orderOfferProcessorImpl.filterOrderLevelOffer(promotableOrder, qualifiedOrderOffers, offer);

    // Assert
    verify(offer).getApplyDiscountToSalePrice();
    verify(offer).getDiscountType();
    verify(offer).getOfferMatchRulesXref();
    verify(offer, atLeast(1)).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer, atLeast(1)).getType();
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#couldOfferApplyToOrder(Offer, PromotableOrder)}
   * with {@code offer}, {@code promotableOrder}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#couldOfferApplyToOrder(Offer, PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCouldOfferApplyToOrderWithOfferPromotableOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3627 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OfferImpl offer = new OfferImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderOfferProcessorImpl2.couldOfferApplyToOrder(offer,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#couldOfferApplyToOrder(Offer, PromotableOrder, PromotableFulfillmentGroup)}
   * with {@code offer}, {@code promotableOrder}, {@code fulfillmentGroup}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#couldOfferApplyToOrder(Offer, PromotableOrder, PromotableFulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCouldOfferApplyToOrderWithOfferPromotableOrderFulfillmentGroup() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3657 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OfferImpl offer = new OfferImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.couldOfferApplyToOrder(offer, promotableOrder, new PromotableFulfillmentGroupImpl(
        fulfillmentGroup, promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl())));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#couldOfferApplyToOrder(Offer, PromotableOrder, PromotableOrderItem)}
   * with {@code offer}, {@code promotableOrder}, {@code orderItem}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#couldOfferApplyToOrder(Offer, PromotableOrder, PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCouldOfferApplyToOrderWithOfferPromotableOrderOrderItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3687 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OfferImpl offer = new OfferImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.couldOfferApplyToOrder(offer, promotableOrder, new PromotableOrderItemImpl(orderItem,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#couldOfferApplyToOrder(Offer, PromotableOrder, PromotableOrderItem, PromotableFulfillmentGroup)}
   * with {@code offer}, {@code promotableOrder}, {@code promotableOrderItem},
   * {@code promotableFulfillmentGroup}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#couldOfferApplyToOrder(Offer, PromotableOrder, PromotableOrderItem, PromotableFulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCouldOfferApplyToOrderWithOfferPromotableOrderPromotableOrderItemPromotableFulfillmentGroup() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3717 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OfferImpl offer = new OfferImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl promotableOrderItem = new PromotableOrderItemImpl(orderItem, promotableOrder2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder3 = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.couldOfferApplyToOrder(offer, promotableOrder, promotableOrderItem,
        new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder3,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl())));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#createCandidateOrderOffer(PromotableOrder, List, Offer)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#createCandidateOrderOffer(PromotableOrder, List, Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateCandidateOrderOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3747 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    ArrayList<PromotableCandidateOrderOffer> qualifiedOrderOffers = new ArrayList<>();

    // Act
    orderOfferProcessorImpl2.createCandidateOrderOffer(promotableOrder, qualifiedOrderOffers, new OfferImpl());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableOrderOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act and Assert
    assertTrue(orderOfferProcessorImpl.removeTrailingNotCombinableOrderOffers(new ArrayList<>()).isEmpty());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveTrailingNotCombinableOrderOffers2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3927 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    orderOfferProcessorImpl2.removeTrailingNotCombinableOrderOffers(new ArrayList<>());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableOrderOffers_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOfferImpl = new PromotableCandidateOrderOfferImpl(
        promotableOrder, new OfferImpl());

    ArrayList<PromotableCandidateOrderOffer> candidateOffers = new ArrayList<>();
    candidateOffers.add(promotableCandidateOrderOfferImpl);

    // Act
    List<PromotableCandidateOrderOffer> actualRemoveTrailingNotCombinableOrderOffersResult = orderOfferProcessorImpl
        .removeTrailingNotCombinableOrderOffers(candidateOffers);

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertEquals(candidateOffers, actualRemoveTrailingNotCombinableOrderOffersResult);
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableOrderOffers_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));

    // Act and Assert
    assertTrue(orderOfferProcessorImpl.removeTrailingNotCombinableOrderOffers(new ArrayList<>()).isEmpty());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}
   */
  @Test
  public void testApplyAllOrderOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl.applyAllOrderOffers(orderOffers, promotableOrder);

    // Assert
    assertTrue(promotableOrder.getOrder() instanceof OrderImpl);
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyAllOrderOffers2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3363 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderOfferProcessorImpl2.applyAllOrderOffers(orderOffers,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}
   */
  @Test
  public void testApplyAllOrderOffers_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    orderOfferProcessorImpl.applyAllOrderOffers(orderOffers,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   * <ul>
   *   <li>When {@link Order} {@link Order#getCurrency()} return {@code null}.</li>
   *   <li>Then calls {@link Order#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}
   */
  @Test
  public void testApplyAllOrderOffers_whenOrderGetCurrencyReturnNull_thenCallsGetCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();
    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    orderOfferProcessorImpl.applyAllOrderOffers(orderOffers,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#orderMeetsQualifyingSubtotalRequirements(PromotableOrder, PromotableCandidateOrderOffer)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#orderMeetsQualifyingSubtotalRequirements(PromotableOrder, PromotableCandidateOrderOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOrderMeetsQualifyingSubtotalRequirements() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3837 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.orderMeetsQualifyingSubtotalRequirements(order2,
        new PromotableCandidateOrderOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#orderMeetsSubtotalRequirements(PromotableOrder, PromotableCandidateOrderOffer)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#orderMeetsSubtotalRequirements(PromotableOrder, PromotableCandidateOrderOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOrderMeetsSubtotalRequirements() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3867 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.orderMeetsSubtotalRequirements(order2,
        new PromotableCandidateOrderOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  public void testCompareAndAdjustOrderAndItemOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    PromotableOrder promotableOrder = mock(PromotableOrder.class);
    doNothing().when(promotableOrder).removeAllCandidateItemOfferAdjustments();
    when(promotableOrder.calculateItemAdjustmentTotal()).thenReturn(new Money());
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());

    // Act
    orderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(promotableOrder);

    // Assert that nothing has changed
    verify(promotableOrder).calculateItemAdjustmentTotal();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).removeAllCandidateItemOfferAdjustments();
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  public void testCompareAndAdjustOrderAndItemOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    PromotableOrder promotableOrder = mock(PromotableOrder.class);
    doNothing().when(promotableOrder).removeAllCandidateOrderOfferAdjustments();
    when(promotableOrder.calculateItemAdjustmentTotal()).thenReturn(new Money(10.0d));
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());

    // Act
    orderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(promotableOrder);

    // Assert that nothing has changed
    verify(promotableOrder).calculateItemAdjustmentTotal();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).removeAllCandidateOrderOfferAdjustments();
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCompareAndAdjustOrderAndItemOffers3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3597 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderOfferProcessorImpl2.compareAndAdjustOrderAndItemOffers(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  public void testCompareAndAdjustOrderAndItemOffers_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    orderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link Money#greaterThanOrEqual(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  public void testCompareAndAdjustOrderAndItemOffers_thenCallsGreaterThanOrEqual() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money money = mock(Money.class);
    when(money.greaterThanOrEqual(Mockito.<Money>any())).thenReturn(true);
    PromotableOrder promotableOrder = mock(PromotableOrder.class);
    doNothing().when(promotableOrder).removeAllCandidateItemOfferAdjustments();
    when(promotableOrder.calculateItemAdjustmentTotal()).thenReturn(new Money(10.0d));
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);

    // Act
    orderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(promotableOrder);

    // Assert
    verify(money).greaterThanOrEqual(isA(Money.class));
    verify(promotableOrder).calculateItemAdjustmentTotal();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).removeAllCandidateItemOfferAdjustments();
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#applyOrderOffer(PromotableOrder, PromotableCandidateOrderOffer)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#applyOrderOffer(PromotableOrder, PromotableCandidateOrderOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyOrderOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3393 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.applyOrderOffer(promotableOrder,
        new PromotableCandidateOrderOfferImpl(promotableOrder2, new OfferImpl()));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#buildPromotableOrderAdjustmentsMap(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#buildPromotableOrderAdjustmentsMap(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPromotableOrderAdjustmentsMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3537 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderOfferProcessorImpl2.buildPromotableOrderAdjustmentsMap(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#synchronizeOrderAdjustments(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#synchronizeOrderAdjustments(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSynchronizeOrderAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4125 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderOfferProcessorImpl2.synchronizeOrderAdjustments(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateAdjustmentIfChangesDetected() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4185 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OrderAdjustmentImpl adjustment = new OrderAdjustmentImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = new PromotableCandidateOrderOfferImpl(
        promotableOrder, new OfferImpl());

    NullOrderImpl order2 = new NullOrderImpl();

    // Act
    orderOfferProcessorImpl2.updateAdjustmentIfChangesDetected(adjustment,
        new PromotableOrderAdjustmentImpl(promotableCandidateOrderOffer,
            new PromotableOrderImpl(order2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#synchronizeOrderItems(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#synchronizeOrderItems(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSynchronizeOrderItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4155 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderOfferProcessorImpl2.synchronizeOrderItems(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#synchronizeItemPriceDetails(OrderItem, PromotableOrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#synchronizeItemPriceDetails(OrderItem, PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSynchronizeItemPriceDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4065 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    BundleOrderItemImpl orderItem2 = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.synchronizeItemPriceDetails(orderItem, new PromotableOrderItemImpl(orderItem2,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#synchronizeItemQualifiers(OrderItem, PromotableOrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#synchronizeItemQualifiers(OrderItem, PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSynchronizeItemQualifiers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4095 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    BundleOrderItemImpl orderItem2 = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.synchronizeItemQualifiers(orderItem, new PromotableOrderItemImpl(orderItem2,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testProcessMatchingDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3897 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();

    // Act
    orderOfferProcessorImpl2.processMatchingDetails(itemDetail,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls
   * {@link OrderItemPriceDetailImpl#getOrderItemPriceDetailAdjustments()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testProcessMatchingDetails_givenOne_thenCallsGetOrderItemPriceDetailAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setOfferServiceUtilities(new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl()));
    OrderItemPriceDetailImpl itemDetail = mock(OrderItemPriceDetailImpl.class);
    when(itemDetail.getQuantity()).thenReturn(1);
    when(itemDetail.getOrderItemPriceDetailAdjustments()).thenReturn(new ArrayList<>());

    // Act
    orderOfferProcessorImpl.processMatchingDetails(itemDetail,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));

    // Assert
    verify(itemDetail).getOrderItemPriceDetailAdjustments();
    verify(itemDetail).getQuantity();
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailImpl} (default constructor) Quantity is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testProcessMatchingDetails_thenOrderItemPriceDetailImplQuantityIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setOfferServiceUtilities(new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl()));
    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();

    // Act
    orderOfferProcessorImpl.processMatchingDetails(itemDetail,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));

    // Assert
    assertEquals(1, itemDetail.getQuantity());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildItemPriceDetailKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3423 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    orderOfferProcessorImpl2.buildItemPriceDetailKey(new OrderItemPriceDetailImpl());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link OrderItemPriceDetailImpl#getOrderItem()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}
   */
  @Test
  public void testBuildItemPriceDetailKey_givenArrayList_thenCallsGetOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OrderItemPriceDetailImpl itemDetail = mock(OrderItemPriceDetailImpl.class);
    when(itemDetail.getUseSalePrice()).thenReturn(true);
    when(itemDetail.getOrderItemPriceDetailAdjustments()).thenReturn(new ArrayList<>());
    when(itemDetail.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    // Act
    orderOfferProcessorImpl.buildItemPriceDetailKey(itemDetail);

    // Assert
    verify(itemDetail).getOrderItem();
    verify(itemDetail).getOrderItemPriceDetailAdjustments();
    verify(itemDetail).getUseSalePrice();
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}.
   * <ul>
   *   <li>Then calls {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}
   */
  @Test
  public void testBuildItemPriceDetailKey_thenCallsGetOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl = mock(
        OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.getOffer()).thenReturn(new OfferImpl());

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);

    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();
    itemDetail.setId(1L);
    itemDetail.setOrderItem(new BundleOrderItemImpl());
    itemDetail.setQuantity(1);
    itemDetail.setUseSalePrice(true);
    itemDetail.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act
    orderOfferProcessorImpl.buildItemPriceDetailKey(itemDetail);

    // Assert
    verify(orderItemPriceDetailAdjustmentImpl).getOffer();
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#buildPromotableDetailsMap(PromotableOrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#buildPromotableDetailsMap(PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPromotableDetailsMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3477 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.buildPromotableDetailsMap(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#buildPromotableQualifiersMap(PromotableOrderItem)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#buildPromotableQualifiersMap(PromotableOrderItem)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPromotableQualifiersMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3567 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.buildPromotableQualifiersMap(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#synchronizeFulfillmentGroups(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#synchronizeFulfillmentGroups(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSynchronizeFulfillmentGroups() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4035 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderOfferProcessorImpl2.synchronizeFulfillmentGroups(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFgContainsFutureCreditAdjustment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3777 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    orderOfferProcessorImpl2.fgContainsFutureCreditAdjustment(new FulfillmentGroupImpl());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  public void testFgContainsFutureCreditAdjustment_givenMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getFutureCreditFulfillmentGroupAdjustmentsValue()).thenReturn(new Money());

    // Act
    boolean actualFgContainsFutureCreditAdjustmentResult = orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg);

    // Assert
    verify(fg).getFutureCreditFulfillmentGroupAdjustmentsValue();
    assertFalse(actualFgContainsFutureCreditAdjustmentResult);
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  public void testFgContainsFutureCreditAdjustment_givenMoneyWithAmountIsTen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getFutureCreditFulfillmentGroupAdjustmentsValue()).thenReturn(new Money(10.0d));

    // Act
    boolean actualFgContainsFutureCreditAdjustmentResult = orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg);

    // Assert
    verify(fg).getFutureCreditFulfillmentGroupAdjustmentsValue();
    assertTrue(actualFgContainsFutureCreditAdjustmentResult);
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  public void testFgContainsFutureCreditAdjustment_givenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    FulfillmentGroupImpl fg = new FulfillmentGroupImpl();
    fg.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link Money#compareTo(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  public void testFgContainsFutureCreditAdjustment_thenCallsCompareTo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money money = mock(Money.class);
    when(money.compareTo(Mockito.<Money>any())).thenReturn(1);
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getFutureCreditFulfillmentGroupAdjustmentsValue()).thenReturn(money);

    // Act
    boolean actualFgContainsFutureCreditAdjustmentResult = orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg);

    // Assert
    verify(money).compareTo(isA(Money.class));
    verify(fg).getFutureCreditFulfillmentGroupAdjustmentsValue();
    assertTrue(actualFgContainsFutureCreditAdjustmentResult);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}
   */
  @Test
  public void testSyncFulfillmentPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    doNothing().when(fg).setFulfillmentPrice(Mockito.<Money>any());
    when(fg.getFulfillmentGroupAdjustmentsValue()).thenReturn(new Money());
    when(fg.getRetailFulfillmentPrice()).thenReturn(new Money());
    doNothing().when(fg).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    doNothing().when(fg).setOrder(Mockito.<Order>any());
    fg.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());
    fg.setOrder(mock(Order.class));

    // Act
    orderOfferProcessorImpl.syncFulfillmentPrice(fg);

    // Assert
    verify(fg).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fg).getFulfillmentGroupAdjustmentsValue();
    verify(fg).getRetailFulfillmentPrice();
    verify(fg).setFulfillmentPrice(isA(Money.class));
    verify(fg).setOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSyncFulfillmentPrice2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3945 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    orderOfferProcessorImpl2.syncFulfillmentPrice(new FulfillmentGroupImpl());
  }

  /**
   * Test {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#subtract(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}
   */
  @Test
  public void testSyncFulfillmentPrice_givenMoneySubtractReturnMoney_thenCallsSubtract() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    doNothing().when(fg).setFulfillmentPrice(Mockito.<Money>any());
    when(fg.getFulfillmentGroupAdjustmentsValue()).thenReturn(mock(Money.class));
    when(fg.getRetailFulfillmentPrice()).thenReturn(money);
    doNothing().when(fg).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    doNothing().when(fg).setOrder(Mockito.<Order>any());
    fg.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());
    fg.setOrder(mock(Order.class));

    // Act
    orderOfferProcessorImpl.syncFulfillmentPrice(fg);

    // Assert
    verify(money).subtract(isA(Money.class));
    verify(fg).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fg).getFulfillmentGroupAdjustmentsValue();
    verify(fg).getRetailFulfillmentPrice();
    verify(fg).setFulfillmentPrice(isA(Money.class));
    verify(fg).setOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) FulfillmentPrice
   * is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}
   */
  @Test
  public void testSyncFulfillmentPrice_thenFulfillmentGroupImplFulfillmentPriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    FulfillmentGroupImpl fg = new FulfillmentGroupImpl();
    Money retailFulfillmentPrice = new Money();
    fg.setRetailFulfillmentPrice(retailFulfillmentPrice);
    fg.setOrder(order);

    // Act
    orderOfferProcessorImpl.syncFulfillmentPrice(fg);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    assertEquals(retailFulfillmentPrice, fg.getFulfillmentPrice());
    assertEquals(retailFulfillmentPrice, fg.getShippingPrice());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPromotableFulfillmentGroupMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3507 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderOfferProcessorImpl2.buildPromotableFulfillmentGroupMap(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}
   */
  @Test
  public void testBuildPromotableFulfillmentGroupMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue(orderOfferProcessorImpl
        .buildPromotableFulfillmentGroupMap(
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
        .isEmpty());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}
   */
  @Test
  public void testBuildPromotableFulfillmentGroupMap_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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

    // Act
    Map<Long, PromotableFulfillmentGroup> actualBuildPromotableFulfillmentGroupMapResult = orderOfferProcessorImpl
        .buildPromotableFulfillmentGroupMap(
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    assertEquals(1, actualBuildPromotableFulfillmentGroupMapResult.size());
    PromotableFulfillmentGroup getResult = actualBuildPromotableFulfillmentGroupMapResult.get(null);
    assertTrue(getResult instanceof PromotableFulfillmentGroupImpl);
    assertTrue(getResult.getCandidateFulfillmentGroupAdjustments().isEmpty());
    assertTrue(getResult.getDiscountableOrderItems().isEmpty());
    assertTrue(((PromotableFulfillmentGroupImpl) getResult).candidateFulfillmentGroupAdjustments.isEmpty());
    assertSame(fulfillmentGroupImpl, getResult.getFulfillmentGroup());
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#buildPromFulfillmentAdjMap(PromotableFulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#buildPromFulfillmentAdjMap(PromotableFulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPromFulfillmentAdjMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3447 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.buildPromFulfillmentAdjMap(new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl())));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#synchronizeFulfillmentGroupAdjustments(FulfillmentGroup, PromotableFulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#synchronizeFulfillmentGroupAdjustments(FulfillmentGroup, PromotableFulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSynchronizeFulfillmentGroupAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4005 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    FulfillmentGroupImpl fg = new FulfillmentGroupImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    orderOfferProcessorImpl2.synchronizeFulfillmentGroupAdjustments(fg, new PromotableFulfillmentGroupImpl(
        fulfillmentGroup, promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl())));
  }

  /**
   * Test
   * {@link OrderOfferProcessorImpl#synchronizeAdjustmentsAndPrices(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OrderOfferProcessorImpl#synchronizeAdjustmentsAndPrices(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSynchronizeAdjustmentsAndPrices() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3975 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.OrderOfferProcessorImpl orderOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl2 = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderOfferProcessorImpl2.synchronizeAdjustmentsAndPrices(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderOfferProcessorImpl#setOfferDao(OfferDao)}
   *   <li>
   * {@link OrderOfferProcessorImpl#setOfferServiceUtilities(OfferServiceUtilities)}
   *   <li>{@link OrderOfferProcessorImpl#setOrderItemDao(OrderItemDao)}
   *   <li>
   * {@link OrderOfferProcessorImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OrderOfferProcessorImpl#getOfferServiceUtilities()}
   *   <li>{@link OrderOfferProcessorImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    orderOfferProcessorImpl.setOfferDao(new OfferDaoImpl());
    OfferServiceUtilitiesImpl offerServiceUtilities = new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setOfferServiceUtilities(offerServiceUtilities);
    orderOfferProcessorImpl.setOrderItemDao(new OrderItemDaoImpl());
    PromotableItemFactoryImpl promotableItemFactory = new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setPromotableItemFactory(promotableItemFactory);
    OfferServiceUtilities actualOfferServiceUtilities = orderOfferProcessorImpl.getOfferServiceUtilities();
    PromotableItemFactory actualPromotableItemFactory = orderOfferProcessorImpl.getPromotableItemFactory();

    // Assert that nothing has changed
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(offerServiceUtilities, actualOfferServiceUtilities);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
  }
}
