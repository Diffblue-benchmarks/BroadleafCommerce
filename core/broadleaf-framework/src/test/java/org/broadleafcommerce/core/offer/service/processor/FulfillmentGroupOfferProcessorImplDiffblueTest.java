package org.broadleafcommerce.core.offer.service.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.discount.FulfillmentGroupOfferPotential;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroup;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
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
public class FulfillmentGroupOfferProcessorImplDiffblueTest {
  @Autowired
  private FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List, Offer)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List, Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterFulfillmentGroupLevelOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2180 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    ArrayList<PromotableCandidateFulfillmentGroupOffer> qualifiedFGOffers = new ArrayList<>();

    // Act
    fulfillmentGroupOfferProcessorImpl2.filterFulfillmentGroupLevelOffer(order2, qualifiedFGOffers, new OfferImpl());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#getQualifyGroupAcrossAllOrderItems(PromotableFulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#getQualifyGroupAcrossAllOrderItems(PromotableFulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQualifyGroupAcrossAllOrderItems() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2240 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    fulfillmentGroupOfferProcessorImpl2.getQualifyGroupAcrossAllOrderItems(new PromotableFulfillmentGroupImpl(
        fulfillmentGroup, promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl())));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  public void testCalculateFulfillmentGroupTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(order2);

    // Assert
    assertTrue(order2.getOrder() instanceof OrderImpl);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateFulfillmentGroupTotal2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2060 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    fulfillmentGroupOfferProcessorImpl2.calculateFulfillmentGroupTotal(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Order} {@link Order#getCurrency()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  public void testCalculateFulfillmentGroupTotal_givenNull_whenOrderGetCurrencyReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setTotalFulfillmentCharges(Mockito.<Money>any());

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).setTotalFulfillmentCharges(isA(Money.class));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  public void testCalculateFulfillmentGroupTotal_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalFulfillmentCharges(Mockito.<Money>any());

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).setTotalFulfillmentCharges(isA(Money.class));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupImpl#getFulfillmentPrice()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  public void testCalculateFulfillmentGroupTotal_thenCallsGetFulfillmentPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentPrice()).thenReturn(new Money());
    when(fulfillmentGroupImpl.getShippingOverride()).thenReturn(true);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalFulfillmentCharges(Mockito.<Money>any());

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(fulfillmentGroupImpl).getFulfillmentPrice();
    verify(fulfillmentGroupImpl).getShippingOverride();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).setTotalFulfillmentCharges(isA(Money.class));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#couldOfferApplyToFulfillmentGroup(Offer, PromotableFulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#couldOfferApplyToFulfillmentGroup(Offer, PromotableFulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCouldOfferApplyToFulfillmentGroup() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2120 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offer = new OfferImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    fulfillmentGroupOfferProcessorImpl2.couldOfferApplyToFulfillmentGroup(offer, new PromotableFulfillmentGroupImpl(
        fulfillmentGroup, promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl())));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#createCandidateFulfillmentGroupOffer(Offer, List, PromotableFulfillmentGroup)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#createCandidateFulfillmentGroupOffer(Offer, List, PromotableFulfillmentGroup)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateCandidateFulfillmentGroupOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2150 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offer = new OfferImpl();
    ArrayList<PromotableCandidateFulfillmentGroupOffer> qualifiedFGOffers = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    fulfillmentGroupOfferProcessorImpl2.createCandidateFulfillmentGroupOffer(offer, qualifiedFGOffers,
        new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl())));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#applyAllFulfillmentGroupOffers(List, PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#applyAllFulfillmentGroupOffers(List, PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyAllFulfillmentGroupOffers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2000 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    ArrayList<PromotableCandidateFulfillmentGroupOffer> qualifiedFGOffers = new ArrayList<>();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    fulfillmentGroupOfferProcessorImpl2.applyAllFulfillmentGroupOffers(qualifiedFGOffers,
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#filterOffersByQualifyingAndSubtotalRequirements(PromotableOrder, List)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#filterOffersByQualifyingAndSubtotalRequirements(PromotableOrder, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterOffersByQualifyingAndSubtotalRequirements() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2210 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    fulfillmentGroupOfferProcessorImpl2.filterOffersByQualifyingAndSubtotalRequirements(order2, new ArrayList<>());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#orderMeetsQualifyingSubtotalRequirements(PromotableOrder, PromotableCandidateFulfillmentGroupOffer)}
   * with {@code order}, {@code fgOffer}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#orderMeetsQualifyingSubtotalRequirements(PromotableOrder, PromotableCandidateFulfillmentGroupOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOrderMeetsQualifyingSubtotalRequirementsWithOrderFgOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2270 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    fulfillmentGroupOfferProcessorImpl2.orderMeetsQualifyingSubtotalRequirements(order2,
        new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl()));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#orderMeetsSubtotalRequirements(PromotableOrder, PromotableCandidateFulfillmentGroupOffer)}
   * with {@code order}, {@code fgOffer}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#orderMeetsSubtotalRequirements(PromotableOrder, PromotableCandidateFulfillmentGroupOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOrderMeetsSubtotalRequirementsWithOrderFgOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2300 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order3 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order3,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    fulfillmentGroupOfferProcessorImpl2.orderMeetsSubtotalRequirements(order2,
        new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl()));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  public void testCompareAndAdjustFulfillmentGroupOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), true));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  public void testCompareAndAdjustFulfillmentGroupOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    PromotableOrder order = mock(PromotableOrder.class);
    doNothing().when(order).removeAllCandidateFulfillmentOfferAdjustments();
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .compareAndAdjustFulfillmentGroupOffers(order, true);

    // Assert
    verify(order).calculateSubtotalWithAdjustments();
    verify(order).calculateSubtotalWithoutAdjustments();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).removeAllCandidateFulfillmentOfferAdjustments();
    assertFalse(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCompareAndAdjustFulfillmentGroupOffers3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2090 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    fulfillmentGroupOfferProcessorImpl2.compareAndAdjustFulfillmentGroupOffers(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), true);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  public void testCompareAndAdjustFulfillmentGroupOffers_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setName("currency.default");
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
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getOrder()).thenReturn(orderImpl);
    doNothing().when(order).removeAllCandidateItemOfferAdjustments();
    doNothing().when(order).removeAllCandidateOrderOfferAdjustments();
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money(10.0d));
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .compareAndAdjustFulfillmentGroupOffers(order, true);

    // Assert
    verify(order, atLeast(1)).calculateSubtotalWithAdjustments();
    verify(order).calculateSubtotalWithoutAdjustments();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrder();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).removeAllCandidateItemOfferAdjustments();
    verify(order).removeAllCandidateOrderOfferAdjustments();
    assertTrue(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  public void testCompareAndAdjustFulfillmentGroupOffers_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .compareAndAdjustFulfillmentGroupOffers(
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true),
            true);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertFalse(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#setSubTotal(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  public void testCompareAndAdjustFulfillmentGroupOffers_thenCallsSetSubTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    doNothing().when(nullOrderImpl).setSubTotal(Mockito.<Money>any());
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getOrder()).thenReturn(nullOrderImpl);
    doNothing().when(order).removeAllCandidateItemOfferAdjustments();
    doNothing().when(order).removeAllCandidateOrderOfferAdjustments();
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money(10.0d));
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .compareAndAdjustFulfillmentGroupOffers(order, true);

    // Assert
    verify(order, atLeast(1)).calculateSubtotalWithAdjustments();
    verify(order).calculateSubtotalWithoutAdjustments();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrder();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).removeAllCandidateItemOfferAdjustments();
    verify(order).removeAllCandidateOrderOfferAdjustments();
    verify(nullOrderImpl).setSubTotal(isA(Money.class));
    assertTrue(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#applyFulfillmentGroupOffer(PromotableFulfillmentGroup, PromotableCandidateFulfillmentGroupOffer)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#applyFulfillmentGroupOffer(PromotableFulfillmentGroup, PromotableCandidateFulfillmentGroupOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyFulfillmentGroupOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2030 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup2 = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    fulfillmentGroupOfferProcessorImpl2.applyFulfillmentGroupOffer(promotableFulfillmentGroup,
        new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup2, new OfferImpl()));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential> actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeTrailingNotCombinableFulfillmentGroupOffers(candidateOffers);

    // Assert
    assertEquals(1, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.size());
    FulfillmentGroupOfferPotential getResult = actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.get(0);
    assertTrue(getResult.getOffer() instanceof OfferImpl);
    assertEquals(1, getResult.getPriority());
    Money totalSavings = getResult.getTotalSavings();
    assertEquals(totalSavings, totalSavings.abs());
    assertEquals(totalSavings, totalSavings.zero());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isTotalitarianOffer()).thenReturn(true);
    when(offerImpl.isCombinableWithOtherOffers()).thenReturn(true);
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = mock(FulfillmentGroupOfferPotential.class);
    when(fulfillmentGroupOfferPotential.getOffer()).thenReturn(offerImpl);
    doNothing().when(fulfillmentGroupOfferPotential).setOffer(Mockito.<Offer>any());
    doNothing().when(fulfillmentGroupOfferPotential).setPriority(anyInt());
    doNothing().when(fulfillmentGroupOfferPotential).setTotalSavings(Mockito.<Money>any());
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(0);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(-1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential2);
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential> actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeTrailingNotCombinableFulfillmentGroupOffers(candidateOffers);

    // Assert
    verify(offerImpl).isCombinableWithOtherOffers();
    verify(offerImpl).isTotalitarianOffer();
    verify(fulfillmentGroupOfferPotential, atLeast(1)).getOffer();
    verify(fulfillmentGroupOfferPotential).setOffer(isA(Offer.class));
    verify(fulfillmentGroupOfferPotential).setPriority(eq(0));
    verify(fulfillmentGroupOfferPotential).setTotalSavings(isA(Money.class));
    assertEquals(1, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.size());
    FulfillmentGroupOfferPotential getResult = actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.get(0);
    assertTrue(getResult.getOffer() instanceof OfferImpl);
    assertEquals(-1, getResult.getPriority());
    Money totalSavings = getResult.getTotalSavings();
    assertEquals(totalSavings, totalSavings.abs());
    assertEquals(totalSavings, totalSavings.zero());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isCombinableWithOtherOffers()).thenReturn(false);
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = mock(FulfillmentGroupOfferPotential.class);
    when(fulfillmentGroupOfferPotential.getOffer()).thenReturn(offerImpl);
    doNothing().when(fulfillmentGroupOfferPotential).setOffer(Mockito.<Offer>any());
    doNothing().when(fulfillmentGroupOfferPotential).setPriority(anyInt());
    doNothing().when(fulfillmentGroupOfferPotential).setTotalSavings(Mockito.<Money>any());
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(0);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(-1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential2);
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential> actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeTrailingNotCombinableFulfillmentGroupOffers(candidateOffers);

    // Assert
    verify(offerImpl).isCombinableWithOtherOffers();
    verify(fulfillmentGroupOfferPotential).getOffer();
    verify(fulfillmentGroupOfferPotential).setOffer(isA(Offer.class));
    verify(fulfillmentGroupOfferPotential).setPriority(eq(0));
    verify(fulfillmentGroupOfferPotential).setTotalSavings(isA(Money.class));
    assertEquals(1, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.size());
    FulfillmentGroupOfferPotential getResult = actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.get(0);
    assertTrue(getResult.getOffer() instanceof OfferImpl);
    assertEquals(-1, getResult.getPriority());
    Money totalSavings = getResult.getTotalSavings();
    assertEquals(totalSavings, totalSavings.abs());
    assertEquals(totalSavings, totalSavings.zero());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2330 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.processor.FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl2 = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    // Act
    fulfillmentGroupOfferProcessorImpl2.removeTrailingNotCombinableFulfillmentGroupOffers(new ArrayList<>());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = mock(FulfillmentGroupOfferPotential.class);
    when(fulfillmentGroupOfferPotential.getOffer()).thenReturn(new OfferImpl());
    doNothing().when(fulfillmentGroupOfferPotential).setOffer(Mockito.<Offer>any());
    doNothing().when(fulfillmentGroupOfferPotential).setPriority(anyInt());
    doNothing().when(fulfillmentGroupOfferPotential).setTotalSavings(Mockito.<Money>any());
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(0);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(-1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential2);
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential> actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeTrailingNotCombinableFulfillmentGroupOffers(candidateOffers);

    // Assert
    verify(fulfillmentGroupOfferPotential, atLeast(1)).getOffer();
    verify(fulfillmentGroupOfferPotential).setOffer(isA(Offer.class));
    verify(fulfillmentGroupOfferPotential).setPriority(eq(0));
    verify(fulfillmentGroupOfferPotential).setTotalSavings(isA(Money.class));
    assertEquals(candidateOffers, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.removeTrailingNotCombinableFulfillmentGroupOffers(new ArrayList<>())
        .isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.removeTrailingNotCombinableFulfillmentGroupOffers(new ArrayList<>())
        .isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(0);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(-1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential2);
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential> actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeTrailingNotCombinableFulfillmentGroupOffers(candidateOffers);

    // Assert
    assertEquals(2, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.size());
    assertSame(fulfillmentGroupOfferPotential, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.get(1));
  }
}
