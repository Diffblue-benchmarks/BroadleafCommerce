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
package org.broadleafcommerce.core.offer.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.offer.domain.CandidateFulfillmentGroupOffer;
import org.broadleafcommerce.core.offer.domain.CandidateFulfillmentGroupOfferImpl;
import org.broadleafcommerce.core.offer.domain.CandidateItemOffer;
import org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl;
import org.broadleafcommerce.core.offer.domain.CandidateOrderOffer;
import org.broadleafcommerce.core.offer.domain.CandidateOrderOfferImpl;
import org.broadleafcommerce.core.offer.domain.FulfillmentGroupAdjustment;
import org.broadleafcommerce.core.offer.domain.FulfillmentGroupAdjustmentImpl;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferInfo;
import org.broadleafcommerce.core.offer.domain.OfferInfoImpl;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderAdjustmentImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemAdjustmentImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OfferDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private OfferDaoImpl offerDaoImpl;

  /**
   * Test {@link OfferDaoImpl#create()}.
   *
   * <p>Method under test: {@link OfferDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer OfferDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offerImpl.setMaxUsesPerOrder(3);
    offerImpl.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offerImpl.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offerImpl.setName("Name");
    offerImpl.setOfferCodes(new ArrayList<>());
    offerImpl.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl.setOfferMatchRulesXref(new HashMap<>());
    offerImpl.setOfferPriceData(new ArrayList<>());
    offerImpl.setOrderMinSubTotal(new Money());
    offerImpl.setPriority(1);
    offerImpl.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl.setQualifyingItemSubTotal(new Money());
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(offerImpl);

    // Act
    Offer actualCreateResult = offerDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.offer.domain.Offer");
    assertSame(offerImpl, actualCreateResult);
  }

  /**
   * Test {@link OfferDaoImpl#createOfferInfo()}.
   *
   * <p>Method under test: {@link OfferDaoImpl#createOfferInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferInfo OfferDaoImpl.createOfferInfo()"})
  public void testCreateOfferInfo() {
    // Arrange
    OfferInfoImpl offerInfoImpl = new OfferInfoImpl();
    offerInfoImpl.setFieldValues(new HashMap<>());
    offerInfoImpl.setId(1L);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(offerInfoImpl);

    // Act
    OfferInfo actualCreateOfferInfoResult = offerDaoImpl.createOfferInfo();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.offer.domain.OfferInfo");
    assertSame(offerInfoImpl, actualCreateOfferInfoResult);
  }

  /**
   * Test {@link OfferDaoImpl#createCandidateOrderOffer()}.
   *
   * <p>Method under test: {@link OfferDaoImpl#createCandidateOrderOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CandidateOrderOffer OfferDaoImpl.createCandidateOrderOffer()"})
  public void testCreateCandidateOrderOffer() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(new Money());
    candidateOrderOfferImpl.setId(CandidateOrderOfferImpl.serialVersionUID);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(candidateOrderOfferImpl);

    // Act
    CandidateOrderOffer actualCreateCandidateOrderOfferResult =
        offerDaoImpl.createCandidateOrderOffer();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.offer.domain.CandidateOrderOffer");
    assertSame(candidateOrderOfferImpl, actualCreateCandidateOrderOfferResult);
  }

  /**
   * Test {@link OfferDaoImpl#createCandidateItemOffer()}.
   *
   * <p>Method under test: {@link OfferDaoImpl#createCandidateItemOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CandidateItemOffer OfferDaoImpl.createCandidateItemOffer()"})
  public void testCreateCandidateItemOffer() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(candidateItemOfferImpl);

    // Act
    CandidateItemOffer actualCreateCandidateItemOfferResult =
        offerDaoImpl.createCandidateItemOffer();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.offer.domain.CandidateItemOffer");
    assertSame(candidateItemOfferImpl, actualCreateCandidateItemOfferResult);
  }

  /**
   * Test {@link OfferDaoImpl#createCandidateFulfillmentGroupOffer()}.
   *
   * <p>Method under test: {@link OfferDaoImpl#createCandidateFulfillmentGroupOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CandidateFulfillmentGroupOffer OfferDaoImpl.createCandidateFulfillmentGroupOffer()"
  })
  public void testCreateCandidateFulfillmentGroupOffer() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(candidateFulfillmentGroupOfferImpl);

    // Act
    CandidateFulfillmentGroupOffer actualCreateCandidateFulfillmentGroupOfferResult =
        offerDaoImpl.createCandidateFulfillmentGroupOffer();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            "org.broadleafcommerce.core.offer.domain.CandidateFulfillmentGroupOffer");
    assertSame(
        candidateFulfillmentGroupOfferImpl, actualCreateCandidateFulfillmentGroupOfferResult);
  }

  /**
   * Test {@link OfferDaoImpl#createOrderItemAdjustment()}.
   *
   * <p>Method under test: {@link OfferDaoImpl#createOrderItemAdjustment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItemAdjustment OfferDaoImpl.createOrderItemAdjustment()"})
  public void testCreateOrderItemAdjustment() {
    // Arrange
    OrderItemAdjustmentImpl orderItemAdjustmentImpl = new OrderItemAdjustmentImpl();
    orderItemAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemAdjustmentImpl.setId(OrderItemAdjustmentImpl.serialVersionUID);
    orderItemAdjustmentImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAdjustmentImpl.setReason("Just cause");
    orderItemAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemAdjustmentImpl.setValue(new Money());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(orderItemAdjustmentImpl);

    // Act
    OrderItemAdjustment actualCreateOrderItemAdjustmentResult =
        offerDaoImpl.createOrderItemAdjustment();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.offer.domain.OrderItemAdjustment");
    assertSame(orderItemAdjustmentImpl, actualCreateOrderItemAdjustmentResult);
  }

  /**
   * Test {@link OfferDaoImpl#createOrderItemPriceDetailAdjustment()}.
   *
   * <p>Method under test: {@link OfferDaoImpl#createOrderItemPriceDetailAdjustment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderItemPriceDetailAdjustment OfferDaoImpl.createOrderItemPriceDetailAdjustment()"
  })
  public void testCreateOrderItemPriceDetailAdjustment() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        new OrderItemPriceDetailAdjustmentImpl();
    orderItemPriceDetailAdjustmentImpl.setAppliedToSalePrice(true);
    orderItemPriceDetailAdjustmentImpl.setFutureCredit(true);
    orderItemPriceDetailAdjustmentImpl.setId(OrderItemPriceDetailAdjustmentImpl.serialVersionUID);
    orderItemPriceDetailAdjustmentImpl.setOfferName("Offer Name");
    orderItemPriceDetailAdjustmentImpl.setOrderItemPriceDetail(new OrderItemPriceDetailImpl());
    orderItemPriceDetailAdjustmentImpl.setReason("Just cause");
    orderItemPriceDetailAdjustmentImpl.setRetailPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setSalesPriceValue(new Money());
    orderItemPriceDetailAdjustmentImpl.setValue(new Money());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(orderItemPriceDetailAdjustmentImpl);

    // Act
    OrderItemPriceDetailAdjustment actualCreateOrderItemPriceDetailAdjustmentResult =
        offerDaoImpl.createOrderItemPriceDetailAdjustment();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance(
            "org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment");
    assertSame(
        orderItemPriceDetailAdjustmentImpl, actualCreateOrderItemPriceDetailAdjustmentResult);
  }

  /**
   * Test {@link OfferDaoImpl#createOrderAdjustment()}.
   *
   * <p>Method under test: {@link OfferDaoImpl#createOrderAdjustment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderAdjustment OfferDaoImpl.createOrderAdjustment()"})
  public void testCreateOrderAdjustment() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(orderAdjustmentImpl);

    // Act
    OrderAdjustment actualCreateOrderAdjustmentResult = offerDaoImpl.createOrderAdjustment();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.offer.domain.OrderAdjustment");
    assertSame(orderAdjustmentImpl, actualCreateOrderAdjustmentResult);
  }

  /**
   * Test {@link OfferDaoImpl#createFulfillmentGroupAdjustment()}.
   *
   * <p>Method under test: {@link OfferDaoImpl#createFulfillmentGroupAdjustment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupAdjustment OfferDaoImpl.createFulfillmentGroupAdjustment()"})
  public void testCreateFulfillmentGroupAdjustment() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(fulfillmentGroupAdjustmentImpl);

    // Act
    FulfillmentGroupAdjustment actualCreateFulfillmentGroupAdjustmentResult =
        offerDaoImpl.createFulfillmentGroupAdjustment();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.offer.domain.FulfillmentGroupAdjustment");
    assertSame(fulfillmentGroupAdjustmentImpl, actualCreateFulfillmentGroupAdjustmentResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link OfferDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long OfferDaoImpl.getCurrentDateResolution()",
    "void OfferDaoImpl.setCurrentDateResolution(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OfferDaoImpl offerDaoImpl = new OfferDaoImpl();

    // Act
    offerDaoImpl.setCurrentDateResolution(1L);

    // Assert
    assertEquals(1L, offerDaoImpl.getCurrentDateResolution().longValue());
  }
}
