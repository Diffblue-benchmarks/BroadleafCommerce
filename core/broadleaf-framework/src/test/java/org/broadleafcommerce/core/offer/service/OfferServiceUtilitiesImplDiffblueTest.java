package org.broadleafcommerce.core.offer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.dao.OfferDaoImpl;
import org.broadleafcommerce.core.offer.domain.CandidateItemOffer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.domain.ProratedOrderItemAdjustment;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetail;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper;
import org.broadleafcommerce.core.order.domain.BundleOrderItemFeePrice;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItem;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemAttribute;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.domain.OrderItemQualifier;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
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
public class OfferServiceUtilitiesImplDiffblueTest {
  @Autowired
  private OfferServiceUtilitiesImpl offerServiceUtilitiesImpl;

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#applyAdjustmentsForItemPriceDetails(PromotableCandidateItemOffer, List)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#applyAdjustmentsForItemPriceDetails(PromotableCandidateItemOffer, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyAdjustmentsForItemPriceDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2185 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceUtilitiesImpl offerServiceUtilitiesImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl2 = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    // Act
    offerServiceUtilitiesImpl2.applyAdjustmentsForItemPriceDetails(itemOffer, new ArrayList<>());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#adjustmentIsNotGoodEnoughToBeApplied(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#adjustmentIsNotGoodEnoughToBeApplied(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdjustmentIsNotGoodEnoughToBeApplied() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1996 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceUtilitiesImpl offerServiceUtilitiesImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl2 = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    // Act
    offerServiceUtilitiesImpl2.adjustmentIsNotGoodEnoughToBeApplied(itemOffer,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#applyOrderItemAdjustment(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#applyOrderItemAdjustment(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyOrderItemAdjustment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2282 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceUtilitiesImpl offerServiceUtilitiesImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl2 = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    // Act
    offerServiceUtilitiesImpl2.applyOrderItemAdjustment(itemOffer,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildOrderItemList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2489 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceUtilitiesImpl offerServiceUtilitiesImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl2 = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

    // Act
    offerServiceUtilitiesImpl2.buildOrderItemList(new NullOrderImpl());
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}
   */
  @Test
  public void testBuildOrderItemList_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

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
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(discreteOrderItems, offerServiceUtilitiesImpl.buildOrderItemList(order));
  }

  /**
   * Test {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildOrderItemList(Order)}
   */
  @Test
  public void testBuildOrderItemList_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

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

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.isPricingAtContainerLevel()).thenReturn(true);
    when(bundleOrderItemImpl.updateSaleAndRetailPrices()).thenReturn(true);
    doNothing().when(bundleOrderItemImpl).setBaseRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBaseSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setBundleOrderItemFeePrices(Mockito.<List<BundleOrderItemFeePrice>>any());
    doNothing().when(bundleOrderItemImpl).setDiscreteOrderItems(Mockito.<List<DiscreteOrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setAuditable(Mockito.<Auditable>any());
    doNothing().when(bundleOrderItemImpl).setCandidateItemOffers(Mockito.<List<CandidateItemOffer>>any());
    doNothing().when(bundleOrderItemImpl).setCartMessages(Mockito.<List<String>>any());
    doNothing().when(bundleOrderItemImpl).setChildOrderItems(Mockito.<List<OrderItem>>any());
    doNothing().when(bundleOrderItemImpl).setDiscountingAllowed(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setGiftWrapOrderItem(Mockito.<GiftWrapOrderItem>any());
    doNothing().when(bundleOrderItemImpl).setHasValidationError(Mockito.<Boolean>any());
    doNothing().when(bundleOrderItemImpl).setId(Mockito.<Long>any());
    doNothing().when(bundleOrderItemImpl).setName(Mockito.<String>any());
    doNothing().when(bundleOrderItemImpl).setOrder(Mockito.<Order>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAdjustments(Mockito.<List<OrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemAttributes(Mockito.<Map<String, OrderItemAttribute>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemPriceDetails(Mockito.<List<OrderItemPriceDetail>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemQualifiers(Mockito.<List<OrderItemQualifier>>any());
    doNothing().when(bundleOrderItemImpl).setOrderItemType(Mockito.<OrderItemType>any());
    doNothing().when(bundleOrderItemImpl).setParentOrderItem(Mockito.<OrderItem>any());
    doNothing().when(bundleOrderItemImpl).setPersonalMessage(Mockito.<PersonalMessage>any());
    doNothing().when(bundleOrderItemImpl)
        .setProratedOrderItemAdjustments(Mockito.<List<ProratedOrderItemAdjustment>>any());
    doNothing().when(bundleOrderItemImpl).setQuantity(anyInt());
    doNothing().when(bundleOrderItemImpl).setRetailPrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setRetailPriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setSalePrice(Mockito.<Money>any());
    doNothing().when(bundleOrderItemImpl).setSalePriceOverride(anyBoolean());
    doNothing().when(bundleOrderItemImpl).setTaxable(Mockito.<Boolean>any());
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
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
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
    order.setOrderItems(orderItems);

    // Act
    List<OrderItem> actualBuildOrderItemListResult = offerServiceUtilitiesImpl.buildOrderItemList(order);

    // Assert
    verify(bundleOrderItemImpl).isPricingAtContainerLevel();
    verify(bundleOrderItemImpl).setBaseRetailPrice(isA(Money.class));
    verify(bundleOrderItemImpl).setBaseSalePrice(isA(Money.class));
    verify(bundleOrderItemImpl).setBundleOrderItemFeePrices(isA(List.class));
    verify(bundleOrderItemImpl).setDiscreteOrderItems(isA(List.class));
    verify(bundleOrderItemImpl).updateSaleAndRetailPrices();
    verify(bundleOrderItemImpl).setAuditable(isA(Auditable.class));
    verify(bundleOrderItemImpl).setCandidateItemOffers(isA(List.class));
    verify(bundleOrderItemImpl).setCartMessages(isA(List.class));
    verify(bundleOrderItemImpl).setChildOrderItems(isA(List.class));
    verify(bundleOrderItemImpl).setDiscountingAllowed(eq(true));
    verify(bundleOrderItemImpl).setGiftWrapOrderItem(isA(GiftWrapOrderItem.class));
    verify(bundleOrderItemImpl).setHasValidationError(eq(true));
    verify(bundleOrderItemImpl).setId(eq(1L));
    verify(bundleOrderItemImpl).setName(eq("Name"));
    verify(bundleOrderItemImpl).setOrder(isA(Order.class));
    verify(bundleOrderItemImpl).setOrderItemAdjustments(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemAttributes(isA(Map.class));
    verify(bundleOrderItemImpl).setOrderItemPriceDetails(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemQualifiers(isA(List.class));
    verify(bundleOrderItemImpl).setOrderItemType(isA(OrderItemType.class));
    verify(bundleOrderItemImpl).setParentOrderItem(isA(OrderItem.class));
    verify(bundleOrderItemImpl).setPersonalMessage(isA(PersonalMessage.class));
    verify(bundleOrderItemImpl).setProratedOrderItemAdjustments(isA(List.class));
    verify(bundleOrderItemImpl).setQuantity(eq(1));
    verify(bundleOrderItemImpl).setRetailPrice(isA(Money.class));
    verify(bundleOrderItemImpl).setRetailPriceOverride(eq(true));
    verify(bundleOrderItemImpl).setSalePrice(isA(Money.class));
    verify(bundleOrderItemImpl).setSalePriceOverride(eq(true));
    verify(bundleOrderItemImpl).setTaxable(eq(true));
    assertEquals(1, actualBuildOrderItemListResult.size());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPromotableItemMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2509 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceUtilitiesImpl offerServiceUtilitiesImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl2 = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    offerServiceUtilitiesImpl2.buildPromotableItemMap(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}
   */
  @Test
  public void testBuildPromotableItemMap_givenAuditableCreatedByIsOne_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

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
    assertTrue(offerServiceUtilitiesImpl
        .buildPromotableItemMap(
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
        .isEmpty());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildPromotableItemMap(PromotableOrder)}
   */
  @Test
  public void testBuildPromotableItemMap_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);
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
    assertEquals(1,
        offerServiceUtilitiesImpl
            .buildPromotableItemMap(
                new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
            .size());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  public void testBuildItemDetailAdjustmentMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        mock(PromotableOfferUtilityImpl.class));

    // Act and Assert
    assertTrue(offerServiceUtilitiesImpl.buildItemDetailAdjustmentMap(new OrderItemPriceDetailImpl()).isEmpty());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildItemDetailAdjustmentMap2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2471 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.service.OfferServiceUtilitiesImpl offerServiceUtilitiesImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl2 = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

    // Act
    offerServiceUtilitiesImpl2.buildItemDetailAdjustmentMap(new OrderItemPriceDetailImpl());
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  public void testBuildItemDetailAdjustmentMap_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
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
    Map<Long, OrderItemPriceDetailAdjustment> actualBuildItemDetailAdjustmentMapResult = offerServiceUtilitiesImpl
        .buildItemDetailAdjustmentMap(itemDetail);

    // Assert
    verify(orderItemPriceDetailAdjustmentImpl, atLeast(1)).getOffer();
    assertEquals(1, actualBuildItemDetailAdjustmentMapResult.size());
    assertTrue(actualBuildItemDetailAdjustmentMapResult.containsKey(null));
  }

  /**
   * Test
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}.
   * <ul>
   *   <li>When {@link OrderItemPriceDetailImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferServiceUtilitiesImpl#buildItemDetailAdjustmentMap(OrderItemPriceDetail)}
   */
  @Test
  public void testBuildItemDetailAdjustmentMap_whenOrderItemPriceDetailImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());

    // Act and Assert
    assertTrue(offerServiceUtilitiesImpl.buildItemDetailAdjustmentMap(new OrderItemPriceDetailImpl()).isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OfferServiceUtilitiesImpl#setGenericEntityService(GenericEntityService)}
   *   <li>{@link OfferServiceUtilitiesImpl#setOfferDao(OfferDao)}
   *   <li>
   * {@link OfferServiceUtilitiesImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OfferServiceUtilitiesImpl#getGenericEntityService()}
   *   <li>{@link OfferServiceUtilitiesImpl#getOfferDao()}
   *   <li>{@link OfferServiceUtilitiesImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OfferServiceUtilitiesImpl offerServiceUtilitiesImpl = new OfferServiceUtilitiesImpl(
        new PromotableOfferUtilityImpl());
    GenericEntityServiceImpl entityService = new GenericEntityServiceImpl();

    // Act
    offerServiceUtilitiesImpl.setGenericEntityService(entityService);
    OfferDaoImpl offerDao = new OfferDaoImpl();
    offerServiceUtilitiesImpl.setOfferDao(offerDao);
    PromotableItemFactoryImpl promotableItemFactory = new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    offerServiceUtilitiesImpl.setPromotableItemFactory(promotableItemFactory);
    GenericEntityService actualGenericEntityService = offerServiceUtilitiesImpl.getGenericEntityService();
    OfferDao actualOfferDao = offerServiceUtilitiesImpl.getOfferDao();
    PromotableItemFactory actualPromotableItemFactory = offerServiceUtilitiesImpl.getPromotableItemFactory();

    // Assert that nothing has changed
    assertTrue(actualGenericEntityService instanceof GenericEntityServiceImpl);
    assertTrue(actualOfferDao instanceof OfferDaoImpl);
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(entityService, actualGenericEntityService);
    assertSame(offerDao, actualOfferDao);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
  }
}
