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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;

public class FulfillmentGroupAdjustmentImplDiffblueTest {
  /**
   * Method under test:
   * {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    fulfillmentGroupAdjustmentImpl.init(fulfillmentGroup, offer, "Just cause");

    // Assert
    Offer offer2 = fulfillmentGroupAdjustmentImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals("Just cause", fulfillmentGroupAdjustmentImpl.getReason());
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(((OfferImpl) offer2).maxUsesPerOrder);
    assertNull(((OfferImpl) offer2).priority);
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(((OfferImpl) offer2).maxUsesPerCustomer);
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(((OfferImpl) offer2).adjustmentType);
    assertNull(((OfferImpl) offer2).discountType);
    assertNull(((OfferImpl) offer2).marketingMessage);
    assertNull(((OfferImpl) offer2).maxUsesStrategy);
    assertNull(((OfferImpl) offer2).offerItemQualifierRuleType);
    assertNull(((OfferImpl) offer2).offerItemTargetRuleType);
    assertNull(((OfferImpl) offer2).type);
    assertNull(offer2.getValue());
    assertNull(((OfferImpl) offer2).orderMinSubTotal);
    assertNull(((OfferImpl) offer2).qualifyingItemSubTotal);
    assertNull(((OfferImpl) offer2).targetMinSubTotal);
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
    assertNull(((OfferImpl) offer2).startDate);
    assertNull(offer2.getOrderMinSubTotal());
    assertNull(offer2.getQualifyingItemSubTotal());
    assertNull(offer2.getTargetMinSubTotal());
    assertNull(offer2.getMaxUsesStrategyType());
    assertNull(offer2.getDiscountType());
    assertNull(offer2.getType());
    assertEquals(0, offer2.getMaxUsesPerOrder());
    assertEquals(0L, offer2.getMaxUsesPerCustomer().longValue());
    assertEquals(2147483646, offer2.getPriority());
    assertFalse(fulfillmentGroupAdjustmentImpl.isFutureCredit());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertFalse(((OfferImpl) offer2).applyToChildItems);
    assertFalse(((OfferImpl) offer2).automaticallyAdded);
    assertFalse(((OfferImpl) offer2).requiresRelatedTargetAndQualifiers);
    assertFalse(((OfferImpl) offer2).totalitarianOffer);
    assertFalse(((OfferImpl) offer2).useListForDiscounts);
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertTrue(((OfferImpl) offer2).applyToSalePrice);
    assertTrue(((OfferImpl) offer2).combinableWithOtherOffers);
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
    assertSame(fulfillmentGroup, fulfillmentGroupAdjustmentImpl.getFulfillmentGroup());
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}
   */
  @Test
  public void testInit2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    OfferImpl offer = new OfferImpl();

    // Act
    fulfillmentGroupAdjustmentImpl.init(fulfillmentGroup, offer, "Just cause");

    // Assert
    Offer offer2 = fulfillmentGroupAdjustmentImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals("Just cause", fulfillmentGroupAdjustmentImpl.getReason());
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(((OfferImpl) offer2).maxUsesPerOrder);
    assertNull(((OfferImpl) offer2).priority);
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(((OfferImpl) offer2).maxUsesPerCustomer);
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(((OfferImpl) offer2).adjustmentType);
    assertNull(((OfferImpl) offer2).discountType);
    assertNull(((OfferImpl) offer2).marketingMessage);
    assertNull(((OfferImpl) offer2).maxUsesStrategy);
    assertNull(((OfferImpl) offer2).offerItemQualifierRuleType);
    assertNull(((OfferImpl) offer2).offerItemTargetRuleType);
    assertNull(((OfferImpl) offer2).type);
    assertNull(offer2.getValue());
    assertNull(((OfferImpl) offer2).orderMinSubTotal);
    assertNull(((OfferImpl) offer2).qualifyingItemSubTotal);
    assertNull(((OfferImpl) offer2).targetMinSubTotal);
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
    assertNull(((OfferImpl) offer2).startDate);
    assertNull(offer2.getOrderMinSubTotal());
    assertNull(offer2.getQualifyingItemSubTotal());
    assertNull(offer2.getTargetMinSubTotal());
    assertNull(offer2.getMaxUsesStrategyType());
    assertNull(offer2.getDiscountType());
    assertNull(offer2.getType());
    assertEquals(0, offer2.getMaxUsesPerOrder());
    assertEquals(0L, offer2.getMaxUsesPerCustomer().longValue());
    assertEquals(2147483646, offer2.getPriority());
    assertFalse(fulfillmentGroupAdjustmentImpl.isFutureCredit());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertFalse(((OfferImpl) offer2).applyToChildItems);
    assertFalse(((OfferImpl) offer2).automaticallyAdded);
    assertFalse(((OfferImpl) offer2).requiresRelatedTargetAndQualifiers);
    assertFalse(((OfferImpl) offer2).totalitarianOffer);
    assertFalse(((OfferImpl) offer2).useListForDiscounts);
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertTrue(((OfferImpl) offer2).applyToSalePrice);
    assertTrue(((OfferImpl) offer2).combinableWithOtherOffers);
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
    assertSame(fulfillmentGroup, fulfillmentGroupAdjustmentImpl.getFulfillmentGroup());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}
   */
  @Test
  public void testInit3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupAdjustmentImpl.init(fulfillmentGroup, null, "Just cause");

    // Assert
    assertEquals("Just cause", fulfillmentGroupAdjustmentImpl.getReason());
    assertNull(fulfillmentGroupAdjustmentImpl.getOffer());
    assertNull(fulfillmentGroupAdjustmentImpl.deproxiedOffer);
    assertNull(fulfillmentGroupAdjustmentImpl.offer);
    assertFalse(fulfillmentGroupAdjustmentImpl.isFutureCredit());
    assertSame(fulfillmentGroup, fulfillmentGroupAdjustmentImpl.getFulfillmentGroup());
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}
   */
  @Test
  public void testInit4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    Offer offer = mock(Offer.class);
    when(offer.getAdjustmentType()).thenReturn(OfferAdjustmentType.FUTURE_CREDIT);

    // Act
    fulfillmentGroupAdjustmentImpl.init(fulfillmentGroup, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    assertEquals("Just cause", fulfillmentGroupAdjustmentImpl.getReason());
    assertTrue(fulfillmentGroupAdjustmentImpl.isFutureCredit());
    assertSame(fulfillmentGroup, fulfillmentGroupAdjustmentImpl.getFulfillmentGroup());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}
   */
  @Test
  public void testInit5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    Offer offer = mock(Offer.class);
    when(offer.getAdjustmentType()).thenReturn(null);

    // Act
    fulfillmentGroupAdjustmentImpl.init(fulfillmentGroup, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    assertEquals("Just cause", fulfillmentGroupAdjustmentImpl.getReason());
    assertFalse(fulfillmentGroupAdjustmentImpl.isFutureCredit());
    assertSame(fulfillmentGroup, fulfillmentGroupAdjustmentImpl.getFulfillmentGroup());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}
   */
  @Test
  public void testInit6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    Offer offer = mock(Offer.class);
    when(offer.getName()).thenReturn("Name");
    when(offer.getAdjustmentType()).thenReturn(OfferAdjustmentType.FUTURE_CREDIT);

    // Act
    fulfillmentGroupAdjustmentImpl.init(fulfillmentGroup, offer, null);

    // Assert
    verify(offer).getAdjustmentType();
    verify(offer).getName();
    assertEquals("Name", fulfillmentGroupAdjustmentImpl.getReason());
    assertTrue(fulfillmentGroupAdjustmentImpl.isFutureCredit());
    assertSame(fulfillmentGroup, fulfillmentGroupAdjustmentImpl.getFulfillmentGroup());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#getOffer()}
   */
  @Test
  public void testGetOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupAdjustmentImpl()).getOffer());
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#getOffer()}
   */
  @Test
  public void testGetOffer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(mock(FulfillmentGroupImpl.class));

    // Act and Assert
    assertNull(fulfillmentGroupAdjustmentImpl.getOffer());
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    fulfillmentGroupAdjustmentImpl.setOffer(offer);

    // Assert
    Offer offer2 = fulfillmentGroupAdjustmentImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(((OfferImpl) offer2).maxUsesPerOrder);
    assertNull(((OfferImpl) offer2).priority);
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(((OfferImpl) offer2).maxUsesPerCustomer);
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(((OfferImpl) offer2).adjustmentType);
    assertNull(((OfferImpl) offer2).discountType);
    assertNull(((OfferImpl) offer2).marketingMessage);
    assertNull(((OfferImpl) offer2).maxUsesStrategy);
    assertNull(((OfferImpl) offer2).offerItemQualifierRuleType);
    assertNull(((OfferImpl) offer2).offerItemTargetRuleType);
    assertNull(((OfferImpl) offer2).type);
    assertNull(offer2.getValue());
    assertNull(((OfferImpl) offer2).orderMinSubTotal);
    assertNull(((OfferImpl) offer2).qualifyingItemSubTotal);
    assertNull(((OfferImpl) offer2).targetMinSubTotal);
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
    assertNull(((OfferImpl) offer2).startDate);
    assertNull(offer2.getOrderMinSubTotal());
    assertNull(offer2.getQualifyingItemSubTotal());
    assertNull(offer2.getTargetMinSubTotal());
    assertNull(offer2.getMaxUsesStrategyType());
    assertNull(offer2.getDiscountType());
    assertNull(offer2.getType());
    assertEquals(0, offer2.getMaxUsesPerOrder());
    assertEquals(0L, offer2.getMaxUsesPerCustomer().longValue());
    assertEquals(2147483646, offer2.getPriority());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertFalse(((OfferImpl) offer2).applyToChildItems);
    assertFalse(((OfferImpl) offer2).automaticallyAdded);
    assertFalse(((OfferImpl) offer2).requiresRelatedTargetAndQualifiers);
    assertFalse(((OfferImpl) offer2).totalitarianOffer);
    assertFalse(((OfferImpl) offer2).useListForDiscounts);
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertTrue(((OfferImpl) offer2).applyToSalePrice);
    assertTrue(((OfferImpl) offer2).combinableWithOtherOffers);
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    OfferImpl offer = mock(OfferImpl.class);

    // Act
    fulfillmentGroupAdjustmentImpl.setOffer(offer);

    // Assert
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(FulfillmentGroupAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setOrder(order);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    Money value = new Money();
    fulfillmentGroupAdjustmentImpl.setValue(value);
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act and Assert
    assertEquals(value, fulfillmentGroupAdjustmentImpl.getValue());
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getOrder()).thenReturn(new NullOrderImpl());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    Money actualValue = fulfillmentGroupAdjustmentImpl.getValue();

    // Assert
    verify(fulfillmentGroup).getOrder();
    assertEquals(actualValue.ZERO, actualValue);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(FulfillmentGroupAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setOrder(order);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(value);
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    Money actualValue = fulfillmentGroupAdjustmentImpl.getValue();

    // Assert
    verify(value).getAmount();
    assertNull(actualValue);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();

    // Act
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupAdjustmentImpl.value);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    fulfillmentGroupAdjustmentImpl.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), fulfillmentGroupAdjustmentImpl.value);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getCurrencyCode()).thenReturn("GBP");

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    String actualCurrencyCode = fulfillmentGroupAdjustmentImpl.getCurrencyCode();

    // Assert
    verify(fulfillmentGroup).getCurrencyCode();
    assertEquals("GBP", actualCurrencyCode);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    int expectedHashCodeResult = fulfillmentGroupAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(mock(FulfillmentGroup.class));
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    int notExpectedHashCodeResult = fulfillmentGroupAdjustmentImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    int expectedHashCodeResult = fulfillmentGroupAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(null);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    int expectedHashCodeResult = fulfillmentGroupAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(value);
    Money value2 = mock(Money.class);
    when(value2.getAmount()).thenReturn(null);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(value2);

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    int expectedHashCodeResult = fulfillmentGroupAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl);
    int expectedHashCodeResult = fulfillmentGroupAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupAdjustmentImpl.hashCode());
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(2L);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(mock(FulfillmentGroup.class));
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(null);
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(false);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Reason");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason(null);
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money(10.0d));

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(value);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, null);
  }

  /**
   * Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, "Different type to FulfillmentGroupAdjustmentImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link FulfillmentGroupAdjustmentImpl#setFulfillmentGroup(FulfillmentGroup)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#setFutureCredit(Boolean)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#setId(Long)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#setReason(String)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#getFulfillmentGroup()}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#getId()}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#getReason()}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#isFutureCredit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(fulfillmentGroup);
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    FulfillmentGroup actualFulfillmentGroup = fulfillmentGroupAdjustmentImpl.getFulfillmentGroup();
    Long actualId = fulfillmentGroupAdjustmentImpl.getId();
    String actualReason = fulfillmentGroupAdjustmentImpl.getReason();

    // Assert that nothing has changed
    assertEquals("Just cause", actualReason);
    assertTrue(fulfillmentGroupAdjustmentImpl.isFutureCredit());
    assertEquals(FulfillmentGroupAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(fulfillmentGroup, actualFulfillmentGroup);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link FulfillmentGroupAdjustmentImpl}
   */
  @Test
  public void testNewFulfillmentGroupAdjustmentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    FulfillmentGroupAdjustmentImpl actualFulfillmentGroupAdjustmentImpl = new FulfillmentGroupAdjustmentImpl();

    // Assert
    assertNull(actualFulfillmentGroupAdjustmentImpl.getId());
    assertNull(actualFulfillmentGroupAdjustmentImpl.getReason());
    assertNull(actualFulfillmentGroupAdjustmentImpl.getOffer());
    assertNull(actualFulfillmentGroupAdjustmentImpl.deproxiedOffer);
    assertNull(actualFulfillmentGroupAdjustmentImpl.offer);
    assertNull(actualFulfillmentGroupAdjustmentImpl.getFulfillmentGroup());
    assertFalse(actualFulfillmentGroupAdjustmentImpl.isFutureCredit());
    assertEquals(new BigDecimal("0.00"), actualFulfillmentGroupAdjustmentImpl.value);
  }
}
