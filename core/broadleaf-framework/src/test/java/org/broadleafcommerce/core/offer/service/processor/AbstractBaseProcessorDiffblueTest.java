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
package org.broadleafcommerce.core.offer.service.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.broadleafcommerce.common.RequestDTO;
import org.broadleafcommerce.common.RequestDTOImpl;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferOfferRuleXref;
import org.broadleafcommerce.core.offer.domain.OfferPriceData;
import org.broadleafcommerce.core.offer.domain.OfferQualifyingCriteriaXref;
import org.broadleafcommerce.core.offer.domain.OfferQualifyingCriteriaXrefImpl;
import org.broadleafcommerce.core.offer.domain.OfferTargetCriteriaXref;
import org.broadleafcommerce.core.offer.service.discount.CandidatePromotionItems;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtility;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class AbstractBaseProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  public void testMeetsItemQualifierSubtotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(offer, new CandidatePromotionItems()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  public void testMeetsItemQualifierSubtotal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(offer, new CandidatePromotionItems()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  public void testMeetsItemQualifierSubtotal3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money());

    // Act
    boolean actualMeetsItemQualifierSubtotalResult = fulfillmentGroupOfferProcessorImpl
        .meetsItemQualifierSubtotal(offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemSubTotal();
    assertTrue(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  public void testMeetsItemQualifierSubtotal4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(OfferType.FULFILLMENT_GROUP);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));

    // Act
    boolean actualMeetsItemQualifierSubtotalResult = fulfillmentGroupOfferProcessorImpl
        .meetsItemQualifierSubtotal(offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer).getType();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  public void testMeetsItemQualifierSubtotal5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    HashSet<OfferQualifyingCriteriaXref> offerQualifyingCriteriaXrefSet = new HashSet<>();
    offerQualifyingCriteriaXrefSet.add(new OfferQualifyingCriteriaXrefImpl());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(offerQualifyingCriteriaXrefSet);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));

    // Act
    boolean actualMeetsItemQualifierSubtotalResult = fulfillmentGroupOfferProcessorImpl
        .meetsItemQualifierSubtotal(offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  public void testMeetsItemQualifierSubtotal6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(OfferType.ORDER_ITEM);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));

    // Act
    boolean actualMeetsItemQualifierSubtotalResult = fulfillmentGroupOfferProcessorImpl
        .meetsItemQualifierSubtotal(offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer).getType();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  public void testMeetsItemQualifierSubtotal7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(new OfferType("ORDER_ITEM", "ORDER_ITEM", 1));
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));

    // Act
    boolean actualMeetsItemQualifierSubtotalResult = fulfillmentGroupOfferProcessorImpl
        .meetsItemQualifierSubtotal(offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer).getType();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  public void testMeetsItemQualifierSubtotal8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(null);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));

    // Act
    boolean actualMeetsItemQualifierSubtotalResult = fulfillmentGroupOfferProcessorImpl
        .meetsItemQualifierSubtotal(offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer).getType();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  public void testMeetsItemQualifierSubtotal9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(OfferType.FULFILLMENT_GROUP);
    when(offer.getQualifyingItemSubTotal()).thenReturn(money);

    // Act
    boolean actualMeetsItemQualifierSubtotalResult = fulfillmentGroupOfferProcessorImpl
        .meetsItemQualifierSubtotal(offer, new CandidatePromotionItems());

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer).getType();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl()))
        .executeExpression("Expression", null));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtility.class));

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("getProductAttributes()[UU]", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("org.broadleafcommerce.core.offer.domain.Offer",
        new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.executeExpression("", new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("getProductAttributes()[UU]", "42");

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("Expression", "42");

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("foo", "42");

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("Expression", true);

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  public void testExecuteExpression11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("Expression", null);

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#usePriceBeforeAdjustments(String)}
   */
  @Test
  public void testUsePriceBeforeAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Expression", (new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl()))
        .usePriceBeforeAdjustments("Expression"));
    assertEquals("Expression", (new FulfillmentGroupOfferProcessorImpl(mock(PromotableOfferUtilityImpl.class)))
        .usePriceBeforeAdjustments("Expression"));
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  public void testFilterOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    ArrayList<Offer> offers = new ArrayList<>();
    CustomerImpl customer = new CustomerImpl();

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
    Auditable auditable = customer.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(customer.getId());
    assertNull(customer.getChallengeAnswer());
    assertNull(customer.getEmailAddress());
    assertNull(customer.getExternalId());
    assertNull(customer.getFirstName());
    assertNull(customer.getLastName());
    assertNull(customer.getPassword());
    assertNull(customer.getTaxExemptionCode());
    assertNull(customer.getUnencodedChallengeAnswer());
    assertNull(customer.getUnencodedPassword());
    assertNull(customer.getUsername());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(customer.getCustomerLocale());
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertNull(customer.getChallengeQuestion());
    assertFalse(customer.isAnonymous());
    assertFalse(customer.isCookied());
    assertFalse(customer.isDeactivated());
    assertFalse(customer.isLoggedIn());
    assertFalse(customer.isPasswordChangeRequired());
    assertFalse(customer.isReceiveEmail());
    assertFalse(customer.isRegistered());
    assertTrue(offers.isEmpty());
    assertTrue(actualFilterOffersResult.isEmpty());
    assertTrue(customer.getCustomerAddresses().isEmpty());
    assertTrue(customer.getCustomerPayments().isEmpty());
    assertTrue(customer.getCustomerPhones().isEmpty());
    assertTrue(customer.getCustomerAttributes().isEmpty());
    assertTrue(customer.getTransientProperties().isEmpty());
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  public void testFilterOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(null, customer);

    // Assert
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
    Auditable auditable = customer.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(customer.getId());
    assertNull(customer.getChallengeAnswer());
    assertNull(customer.getEmailAddress());
    assertNull(customer.getExternalId());
    assertNull(customer.getFirstName());
    assertNull(customer.getLastName());
    assertNull(customer.getPassword());
    assertNull(customer.getTaxExemptionCode());
    assertNull(customer.getUnencodedChallengeAnswer());
    assertNull(customer.getUnencodedPassword());
    assertNull(customer.getUsername());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(customer.getCustomerLocale());
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertNull(customer.getChallengeQuestion());
    assertFalse(customer.isAnonymous());
    assertFalse(customer.isCookied());
    assertFalse(customer.isDeactivated());
    assertFalse(customer.isLoggedIn());
    assertFalse(customer.isPasswordChangeRequired());
    assertFalse(customer.isReceiveEmail());
    assertFalse(customer.isRegistered());
    assertTrue(actualFilterOffersResult.isEmpty());
    assertTrue(customer.getCustomerAddresses().isEmpty());
    assertTrue(customer.getCustomerPayments().isEmpty());
    assertTrue(customer.getCustomerPhones().isEmpty());
    assertTrue(customer.getCustomerAttributes().isEmpty());
    assertTrue(customer.getTransientProperties().isEmpty());
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  public void testFilterOffers3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    ArrayList<Offer> offers = new ArrayList<>();
    CustomerImpl customer = new CustomerImpl();

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
    Auditable auditable = customer.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(customer.getId());
    assertNull(customer.getChallengeAnswer());
    assertNull(customer.getEmailAddress());
    assertNull(customer.getExternalId());
    assertNull(customer.getFirstName());
    assertNull(customer.getLastName());
    assertNull(customer.getPassword());
    assertNull(customer.getTaxExemptionCode());
    assertNull(customer.getUnencodedChallengeAnswer());
    assertNull(customer.getUnencodedPassword());
    assertNull(customer.getUsername());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(customer.getCustomerLocale());
    assertNull(customer.getChallengeQuestion());
    assertFalse(customer.isAnonymous());
    assertFalse(customer.isCookied());
    assertFalse(customer.isDeactivated());
    assertFalse(customer.isLoggedIn());
    assertFalse(customer.isPasswordChangeRequired());
    assertFalse(customer.isReceiveEmail());
    assertFalse(customer.isRegistered());
    assertTrue(offers.isEmpty());
    assertTrue(actualFilterOffersResult.isEmpty());
    assertTrue(customer.getCustomerAddresses().isEmpty());
    assertTrue(customer.getCustomerPayments().isEmpty());
    assertTrue(customer.getCustomerPhones().isEmpty());
    assertTrue(customer.getCustomerAttributes().isEmpty());
    assertTrue(customer.getTransientProperties().isEmpty());
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  public void testFilterOffers4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setEndDate(null);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);
    CustomerImpl customer = new CustomerImpl();

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
    Auditable auditable = customer.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(customer.getId());
    assertNull(customer.getChallengeAnswer());
    assertNull(customer.getEmailAddress());
    assertNull(customer.getExternalId());
    assertNull(customer.getFirstName());
    assertNull(customer.getLastName());
    assertNull(customer.getPassword());
    assertNull(customer.getTaxExemptionCode());
    assertNull(customer.getUnencodedChallengeAnswer());
    assertNull(customer.getUnencodedPassword());
    assertNull(customer.getUsername());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(customer.getCustomerLocale());
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertNull(customer.getChallengeQuestion());
    assertFalse(customer.isAnonymous());
    assertFalse(customer.isCookied());
    assertFalse(customer.isDeactivated());
    assertFalse(customer.isLoggedIn());
    assertFalse(customer.isPasswordChangeRequired());
    assertFalse(customer.isReceiveEmail());
    assertFalse(customer.isRegistered());
    assertTrue(customer.getCustomerAddresses().isEmpty());
    assertTrue(customer.getCustomerPayments().isEmpty());
    assertTrue(customer.getCustomerPhones().isEmpty());
    assertTrue(customer.getCustomerAttributes().isEmpty());
    assertTrue(customer.getTransientProperties().isEmpty());
    assertSame(offers, actualFilterOffersResult);
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  public void testFilterOffers5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setEndDate(null);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);
    CustomerImpl customer = new CustomerImpl();

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
    Auditable auditable = customer.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(customer.getId());
    assertNull(customer.getChallengeAnswer());
    assertNull(customer.getEmailAddress());
    assertNull(customer.getExternalId());
    assertNull(customer.getFirstName());
    assertNull(customer.getLastName());
    assertNull(customer.getPassword());
    assertNull(customer.getTaxExemptionCode());
    assertNull(customer.getUnencodedChallengeAnswer());
    assertNull(customer.getUnencodedPassword());
    assertNull(customer.getUsername());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(customer.getCustomerLocale());
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertNull(customer.getChallengeQuestion());
    assertFalse(customer.isAnonymous());
    assertFalse(customer.isCookied());
    assertFalse(customer.isDeactivated());
    assertFalse(customer.isLoggedIn());
    assertFalse(customer.isPasswordChangeRequired());
    assertFalse(customer.isReceiveEmail());
    assertFalse(customer.isRegistered());
    assertTrue(customer.getCustomerAddresses().isEmpty());
    assertTrue(customer.getCustomerPayments().isEmpty());
    assertTrue(customer.getCustomerPhones().isEmpty());
    assertTrue(customer.getCustomerAttributes().isEmpty());
    assertTrue(customer.getTransientProperties().isEmpty());
    assertSame(offers, actualFilterOffersResult);
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  public void testFilterOffers6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(offerImpl.getStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(offerImpl).setAdjustmentType(Mockito.<OfferAdjustmentType>any());
    doNothing().when(offerImpl).setApplyDiscountToSalePrice(anyBoolean());
    doNothing().when(offerImpl).setApplyToChildItems(anyBoolean());
    doNothing().when(offerImpl).setAutomaticallyAdded(anyBoolean());
    doNothing().when(offerImpl).setCombinableWithOtherOffers(anyBoolean());
    doNothing().when(offerImpl).setDescription(Mockito.<String>any());
    doNothing().when(offerImpl).setDiscountType(Mockito.<OfferDiscountType>any());
    doNothing().when(offerImpl).setEndDate(Mockito.<Date>any());
    doNothing().when(offerImpl).setId(Mockito.<Long>any());
    doNothing().when(offerImpl).setMarketingMessage(Mockito.<String>any());
    doNothing().when(offerImpl).setMaxUsesPerCustomer(Mockito.<Long>any());
    doNothing().when(offerImpl).setMaxUsesPerOrder(anyInt());
    doNothing().when(offerImpl).setMaxUsesStrategyType(Mockito.<CustomerMaxUsesStrategyType>any());
    doNothing().when(offerImpl).setMinimumDaysPerUsage(Mockito.<Long>any());
    doNothing().when(offerImpl).setName(Mockito.<String>any());
    doNothing().when(offerImpl).setOfferCodes(Mockito.<List<OfferCode>>any());
    doNothing().when(offerImpl).setOfferItemQualifierRuleType(Mockito.<OfferItemRestrictionRuleType>any());
    doNothing().when(offerImpl).setOfferItemTargetRuleType(Mockito.<OfferItemRestrictionRuleType>any());
    doNothing().when(offerImpl).setOfferMatchRulesXref(Mockito.<Map<String, OfferOfferRuleXref>>any());
    doNothing().when(offerImpl).setOfferPriceData(Mockito.<List<OfferPriceData>>any());
    doNothing().when(offerImpl).setOrderMinSubTotal(Mockito.<Money>any());
    doNothing().when(offerImpl).setPriority(Mockito.<Integer>any());
    doNothing().when(offerImpl).setQualifyingItemCriteriaXref(Mockito.<Set<OfferQualifyingCriteriaXref>>any());
    doNothing().when(offerImpl).setQualifyingItemSubTotal(Mockito.<Money>any());
    doNothing().when(offerImpl).setRequiresRelatedTargetAndQualifiers(Mockito.<Boolean>any());
    doNothing().when(offerImpl).setStartDate(Mockito.<Date>any());
    doNothing().when(offerImpl).setTargetItemCriteriaXref(Mockito.<Set<OfferTargetCriteriaXref>>any());
    doNothing().when(offerImpl).setTargetMinSubTotal(Mockito.<Money>any());
    doNothing().when(offerImpl).setTargetSystem(Mockito.<String>any());
    doNothing().when(offerImpl).setTotalitarianOffer(Mockito.<Boolean>any());
    doNothing().when(offerImpl).setType(Mockito.<OfferType>any());
    doNothing().when(offerImpl).setUseListForDiscounts(Mockito.<Boolean>any());
    doNothing().when(offerImpl).setValue(Mockito.<BigDecimal>any());
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setEndDate(null);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);
    CustomerImpl customer = new CustomerImpl();

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    verify(offerImpl, atLeast(1)).getEndDate();
    verify(offerImpl, atLeast(1)).getStartDate();
    verify(offerImpl).setAdjustmentType(isA(OfferAdjustmentType.class));
    verify(offerImpl).setApplyDiscountToSalePrice(eq(true));
    verify(offerImpl).setApplyToChildItems(eq(true));
    verify(offerImpl).setAutomaticallyAdded(eq(true));
    verify(offerImpl).setCombinableWithOtherOffers(eq(true));
    verify(offerImpl).setDescription(eq("The characteristics of someone or something"));
    verify(offerImpl).setDiscountType(isA(OfferDiscountType.class));
    verify(offerImpl).setEndDate(isNull());
    verify(offerImpl).setId(eq(1L));
    verify(offerImpl).setMarketingMessage(eq("Marketing Message"));
    verify(offerImpl).setMaxUsesPerCustomer(eq(1L));
    verify(offerImpl).setMaxUsesPerOrder(eq(3));
    verify(offerImpl).setMaxUsesStrategyType(isA(CustomerMaxUsesStrategyType.class));
    verify(offerImpl).setMinimumDaysPerUsage(eq(1L));
    verify(offerImpl).setName(eq("Name"));
    verify(offerImpl).setOfferCodes(isA(List.class));
    verify(offerImpl).setOfferItemQualifierRuleType(isA(OfferItemRestrictionRuleType.class));
    verify(offerImpl).setOfferItemTargetRuleType(isA(OfferItemRestrictionRuleType.class));
    verify(offerImpl).setOfferMatchRulesXref(isA(Map.class));
    verify(offerImpl).setOfferPriceData(isA(List.class));
    verify(offerImpl).setOrderMinSubTotal(isA(Money.class));
    verify(offerImpl).setPriority(eq(1));
    verify(offerImpl).setQualifyingItemCriteriaXref(isA(Set.class));
    verify(offerImpl).setQualifyingItemSubTotal(isA(Money.class));
    verify(offerImpl).setRequiresRelatedTargetAndQualifiers(eq(true));
    verify(offerImpl).setStartDate(isA(Date.class));
    verify(offerImpl).setTargetItemCriteriaXref(isA(Set.class));
    verify(offerImpl).setTargetMinSubTotal(isA(Money.class));
    verify(offerImpl).setTargetSystem(eq("Target System"));
    verify(offerImpl).setTotalitarianOffer(eq(true));
    verify(offerImpl).setType(isA(OfferType.class));
    verify(offerImpl).setUseListForDiscounts(eq(true));
    verify(offerImpl).setValue(isA(BigDecimal.class));
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
    Auditable auditable = customer.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(customer.getId());
    assertNull(customer.getChallengeAnswer());
    assertNull(customer.getEmailAddress());
    assertNull(customer.getExternalId());
    assertNull(customer.getFirstName());
    assertNull(customer.getLastName());
    assertNull(customer.getPassword());
    assertNull(customer.getTaxExemptionCode());
    assertNull(customer.getUnencodedChallengeAnswer());
    assertNull(customer.getUnencodedPassword());
    assertNull(customer.getUsername());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(customer.getCustomerLocale());
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertNull(customer.getChallengeQuestion());
    assertFalse(customer.isAnonymous());
    assertFalse(customer.isCookied());
    assertFalse(customer.isDeactivated());
    assertFalse(customer.isLoggedIn());
    assertFalse(customer.isPasswordChangeRequired());
    assertFalse(customer.isReceiveEmail());
    assertFalse(customer.isRegistered());
    assertTrue(offers.isEmpty());
    assertTrue(actualFilterOffersResult.isEmpty());
    assertTrue(customer.getCustomerAddresses().isEmpty());
    assertTrue(customer.getCustomerPayments().isEmpty());
    assertTrue(customer.getCustomerPhones().isEmpty());
    assertTrue(customer.getCustomerAttributes().isEmpty());
    assertTrue(customer.getTransientProperties().isEmpty());
    assertSame(offers, actualFilterOffersResult);
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  public void testFilterOffers7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    verify(offerTimeZoneProcessor, atLeast(1)).getTimeZone(isA(Offer.class));
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
    Auditable auditable = customer.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(customer.getId());
    assertNull(customer.getChallengeAnswer());
    assertNull(customer.getEmailAddress());
    assertNull(customer.getExternalId());
    assertNull(customer.getFirstName());
    assertNull(customer.getLastName());
    assertNull(customer.getPassword());
    assertNull(customer.getTaxExemptionCode());
    assertNull(customer.getUnencodedChallengeAnswer());
    assertNull(customer.getUnencodedPassword());
    assertNull(customer.getUsername());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(customer.getCustomerLocale());
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertNull(customer.getChallengeQuestion());
    assertFalse(customer.isAnonymous());
    assertFalse(customer.isCookied());
    assertFalse(customer.isDeactivated());
    assertFalse(customer.isLoggedIn());
    assertFalse(customer.isPasswordChangeRequired());
    assertFalse(customer.isReceiveEmail());
    assertFalse(customer.isRegistered());
    assertTrue(offers.isEmpty());
    assertTrue(actualFilterOffersResult.isEmpty());
    assertTrue(customer.getCustomerAddresses().isEmpty());
    assertTrue(customer.getCustomerPayments().isEmpty());
    assertTrue(customer.getCustomerPhones().isEmpty());
    assertTrue(customer.getCustomerAttributes().isEmpty());
    assertTrue(customer.getTransientProperties().isEmpty());
    assertSame(offers, actualFilterOffersResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}
   */
  @Test
  public void testRemoveInvalidRequestOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    List<Offer> actualRemoveInvalidRequestOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeInvalidRequestOffers(offers);

    // Assert
    assertTrue(actualRemoveInvalidRequestOffersResult.isEmpty());
    assertSame(offers, actualRemoveInvalidRequestOffersResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}
   */
  @Test
  public void testRemoveInvalidRequestOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtility.class));
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    List<Offer> actualRemoveInvalidRequestOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeInvalidRequestOffers(offers);

    // Assert
    assertTrue(actualRemoveInvalidRequestOffersResult.isEmpty());
    assertSame(offers, actualRemoveInvalidRequestOffersResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}
   */
  @Test
  public void testRemoveInvalidRequestOffers3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertSame(offers, fulfillmentGroupOfferProcessorImpl.removeInvalidRequestOffers(offers));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}
   */
  @Test
  public void testRemoveInvalidRequestOffers4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertSame(offers, fulfillmentGroupOfferProcessorImpl.removeInvalidRequestOffers(offers));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#couldOfferApplyToRequestDTO(Offer, RequestDTO)}
   */
  @Test
  public void testCouldOfferApplyToRequestDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.couldOfferApplyToRequestDTO(offer, new RequestDTOImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#couldOfferApplyToRequestDTO(Offer, RequestDTO)}
   */
  @Test
  public void testCouldOfferApplyToRequestDTO2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtility.class));
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.couldOfferApplyToRequestDTO(offer, new RequestDTOImpl()));
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}
   */
  @Test
  public void testRemoveTimePeriodOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    List<Offer> actualRemoveTimePeriodOffersResult = fulfillmentGroupOfferProcessorImpl.removeTimePeriodOffers(offers);

    // Assert
    assertTrue(actualRemoveTimePeriodOffersResult.isEmpty());
    assertSame(offers, actualRemoveTimePeriodOffersResult);
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}
   */
  @Test
  public void testRemoveTimePeriodOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    List<Offer> actualRemoveTimePeriodOffersResult = fulfillmentGroupOfferProcessorImpl.removeTimePeriodOffers(offers);

    // Assert
    assertTrue(actualRemoveTimePeriodOffersResult.isEmpty());
    assertSame(offers, actualRemoveTimePeriodOffersResult);
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}
   */
  @Test
  public void testRemoveTimePeriodOffers3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertSame(offers, fulfillmentGroupOfferProcessorImpl.removeTimePeriodOffers(offers));
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}
   */
  @Test
  public void testRemoveTimePeriodOffers4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertSame(offers, fulfillmentGroupOfferProcessorImpl.removeTimePeriodOffers(offers));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#couldOfferApplyToTimePeriod(Offer)}
   */
  @Test
  public void testCouldOfferApplyToTimePeriod() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.couldOfferApplyToTimePeriod(new OfferImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#couldOfferApplyToTimePeriod(Offer)}
   */
  @Test
  public void testCouldOfferApplyToTimePeriod2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtility.class));

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.couldOfferApplyToTimePeriod(new OfferImpl()));
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  public void testRemoveOutOfDateOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    List<Offer> actualRemoveOutOfDateOffersResult = fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertTrue(offers.isEmpty());
    assertTrue(actualRemoveOutOfDateOffersResult.isEmpty());
    assertSame(offers, actualRemoveOutOfDateOffersResult);
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  public void testRemoveOutOfDateOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    List<Offer> actualRemoveOutOfDateOffersResult = fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    assertTrue(offers.isEmpty());
    assertTrue(actualRemoveOutOfDateOffersResult.isEmpty());
    assertSame(offers, actualRemoveOutOfDateOffersResult);
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  public void testRemoveOutOfDateOffers3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setEndDate(null);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    List<Offer> actualRemoveOutOfDateOffersResult = fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertSame(offers, actualRemoveOutOfDateOffersResult);
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  public void testRemoveOutOfDateOffers4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setEndDate(null);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    List<Offer> actualRemoveOutOfDateOffersResult = fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertSame(offers, actualRemoveOutOfDateOffersResult);
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  public void testRemoveOutOfDateOffers5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(offerImpl.getStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(offerImpl).setAdjustmentType(Mockito.<OfferAdjustmentType>any());
    doNothing().when(offerImpl).setApplyDiscountToSalePrice(anyBoolean());
    doNothing().when(offerImpl).setApplyToChildItems(anyBoolean());
    doNothing().when(offerImpl).setAutomaticallyAdded(anyBoolean());
    doNothing().when(offerImpl).setCombinableWithOtherOffers(anyBoolean());
    doNothing().when(offerImpl).setDescription(Mockito.<String>any());
    doNothing().when(offerImpl).setDiscountType(Mockito.<OfferDiscountType>any());
    doNothing().when(offerImpl).setEndDate(Mockito.<Date>any());
    doNothing().when(offerImpl).setId(Mockito.<Long>any());
    doNothing().when(offerImpl).setMarketingMessage(Mockito.<String>any());
    doNothing().when(offerImpl).setMaxUsesPerCustomer(Mockito.<Long>any());
    doNothing().when(offerImpl).setMaxUsesPerOrder(anyInt());
    doNothing().when(offerImpl).setMaxUsesStrategyType(Mockito.<CustomerMaxUsesStrategyType>any());
    doNothing().when(offerImpl).setMinimumDaysPerUsage(Mockito.<Long>any());
    doNothing().when(offerImpl).setName(Mockito.<String>any());
    doNothing().when(offerImpl).setOfferCodes(Mockito.<List<OfferCode>>any());
    doNothing().when(offerImpl).setOfferItemQualifierRuleType(Mockito.<OfferItemRestrictionRuleType>any());
    doNothing().when(offerImpl).setOfferItemTargetRuleType(Mockito.<OfferItemRestrictionRuleType>any());
    doNothing().when(offerImpl).setOfferMatchRulesXref(Mockito.<Map<String, OfferOfferRuleXref>>any());
    doNothing().when(offerImpl).setOfferPriceData(Mockito.<List<OfferPriceData>>any());
    doNothing().when(offerImpl).setOrderMinSubTotal(Mockito.<Money>any());
    doNothing().when(offerImpl).setPriority(Mockito.<Integer>any());
    doNothing().when(offerImpl).setQualifyingItemCriteriaXref(Mockito.<Set<OfferQualifyingCriteriaXref>>any());
    doNothing().when(offerImpl).setQualifyingItemSubTotal(Mockito.<Money>any());
    doNothing().when(offerImpl).setRequiresRelatedTargetAndQualifiers(Mockito.<Boolean>any());
    doNothing().when(offerImpl).setStartDate(Mockito.<Date>any());
    doNothing().when(offerImpl).setTargetItemCriteriaXref(Mockito.<Set<OfferTargetCriteriaXref>>any());
    doNothing().when(offerImpl).setTargetMinSubTotal(Mockito.<Money>any());
    doNothing().when(offerImpl).setTargetSystem(Mockito.<String>any());
    doNothing().when(offerImpl).setTotalitarianOffer(Mockito.<Boolean>any());
    doNothing().when(offerImpl).setType(Mockito.<OfferType>any());
    doNothing().when(offerImpl).setUseListForDiscounts(Mockito.<Boolean>any());
    doNothing().when(offerImpl).setValue(Mockito.<BigDecimal>any());
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setEndDate(null);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    List<Offer> actualRemoveOutOfDateOffersResult = fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerImpl, atLeast(1)).getEndDate();
    verify(offerImpl, atLeast(1)).getStartDate();
    verify(offerImpl).setAdjustmentType(isA(OfferAdjustmentType.class));
    verify(offerImpl).setApplyDiscountToSalePrice(eq(true));
    verify(offerImpl).setApplyToChildItems(eq(true));
    verify(offerImpl).setAutomaticallyAdded(eq(true));
    verify(offerImpl).setCombinableWithOtherOffers(eq(true));
    verify(offerImpl).setDescription(eq("The characteristics of someone or something"));
    verify(offerImpl).setDiscountType(isA(OfferDiscountType.class));
    verify(offerImpl).setEndDate(isNull());
    verify(offerImpl).setId(eq(1L));
    verify(offerImpl).setMarketingMessage(eq("Marketing Message"));
    verify(offerImpl).setMaxUsesPerCustomer(eq(1L));
    verify(offerImpl).setMaxUsesPerOrder(eq(3));
    verify(offerImpl).setMaxUsesStrategyType(isA(CustomerMaxUsesStrategyType.class));
    verify(offerImpl).setMinimumDaysPerUsage(eq(1L));
    verify(offerImpl).setName(eq("Name"));
    verify(offerImpl).setOfferCodes(isA(List.class));
    verify(offerImpl).setOfferItemQualifierRuleType(isA(OfferItemRestrictionRuleType.class));
    verify(offerImpl).setOfferItemTargetRuleType(isA(OfferItemRestrictionRuleType.class));
    verify(offerImpl).setOfferMatchRulesXref(isA(Map.class));
    verify(offerImpl).setOfferPriceData(isA(List.class));
    verify(offerImpl).setOrderMinSubTotal(isA(Money.class));
    verify(offerImpl).setPriority(eq(1));
    verify(offerImpl).setQualifyingItemCriteriaXref(isA(Set.class));
    verify(offerImpl).setQualifyingItemSubTotal(isA(Money.class));
    verify(offerImpl).setRequiresRelatedTargetAndQualifiers(eq(true));
    verify(offerImpl).setStartDate(isA(Date.class));
    verify(offerImpl).setTargetItemCriteriaXref(isA(Set.class));
    verify(offerImpl).setTargetMinSubTotal(isA(Money.class));
    verify(offerImpl).setTargetSystem(eq("Target System"));
    verify(offerImpl).setTotalitarianOffer(eq(true));
    verify(offerImpl).setType(isA(OfferType.class));
    verify(offerImpl).setUseListForDiscounts(eq(true));
    verify(offerImpl).setValue(isA(BigDecimal.class));
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertTrue(offers.isEmpty());
    assertTrue(actualRemoveOutOfDateOffersResult.isEmpty());
    assertSame(offers, actualRemoveOutOfDateOffersResult);
  }

  /**
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  public void testRemoveOutOfDateOffers6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualRemoveOutOfDateOffersResult = fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerTimeZoneProcessor, atLeast(1)).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertTrue(offers.isEmpty());
    assertTrue(actualRemoveOutOfDateOffersResult.isEmpty());
    assertSame(offers, actualRemoveOutOfDateOffersResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#dateToCalendar(Date, TimeZone)}
   */
  @Test
  public void testDateToCalendar() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    TimeZone offerTimeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualDateToCalendarResult = fulfillmentGroupOfferProcessorImpl.dateToCalendar(date, offerTimeZone);

    // Assert
    assertTrue(actualDateToCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualDateToCalendarResult.getCalendarType());
    assertEquals(1, actualDateToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualDateToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1970, actualDateToCalendarResult.getWeekYear());
    assertEquals(52, actualDateToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualDateToCalendarResult.isLenient());
    assertTrue(actualDateToCalendarResult.isWeekDateSupported());
    assertSame(offerTimeZone, actualDateToCalendarResult.getTimeZone());
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#dateToCalendar(Date, TimeZone)}
   */
  @Test
  public void testDateToCalendar2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    TimeZone offerTimeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualDateToCalendarResult = fulfillmentGroupOfferProcessorImpl.dateToCalendar(date, offerTimeZone);

    // Assert
    assertTrue(actualDateToCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualDateToCalendarResult.getCalendarType());
    assertEquals(1, actualDateToCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualDateToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(1970, actualDateToCalendarResult.getWeekYear());
    assertEquals(52, actualDateToCalendarResult.getWeeksInWeekYear());
    assertTrue(actualDateToCalendarResult.isLenient());
    assertTrue(actualDateToCalendarResult.isWeekDateSupported());
    assertSame(offerTimeZone, actualDateToCalendarResult.getTimeZone());
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}
   */
  @Test
  public void testRemoveInvalidCustomerOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    List<Offer> actualRemoveInvalidCustomerOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeInvalidCustomerOffers(offers, new CustomerImpl());

    // Assert
    assertTrue(actualRemoveInvalidCustomerOffersResult.isEmpty());
    assertSame(offers, actualRemoveInvalidCustomerOffersResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}
   */
  @Test
  public void testRemoveInvalidCustomerOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    List<Offer> actualRemoveInvalidCustomerOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeInvalidCustomerOffers(offers, new CustomerImpl());

    // Assert
    assertTrue(actualRemoveInvalidCustomerOffersResult.isEmpty());
    assertSame(offers, actualRemoveInvalidCustomerOffersResult);
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}
   */
  @Test
  public void testRemoveInvalidCustomerOffers3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertSame(offers, fulfillmentGroupOfferProcessorImpl.removeInvalidCustomerOffers(offers, new CustomerImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}
   */
  @Test
  public void testRemoveInvalidCustomerOffers4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertSame(offers, fulfillmentGroupOfferProcessorImpl.removeInvalidCustomerOffers(offers, new CustomerImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#couldOfferApplyToCustomer(Offer, Customer)}
   */
  @Test
  public void testCouldOfferApplyToCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.couldOfferApplyToCustomer(offer, new CustomerImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#couldOfferApplyToCustomer(Offer, Customer)}
   */
  @Test
  public void testCouldOfferApplyToCustomer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtility.class));
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.couldOfferApplyToCustomer(offer, new CustomerImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractBaseProcessor#setOfferTimeZoneProcessor(OfferTimeZoneProcessor)}
   */
  @Test
  public void testSetOfferTimeZoneProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);

    // Act
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    // Assert
    assertSame(offerTimeZoneProcessor, fulfillmentGroupOfferProcessorImpl.getOfferTimeZoneProcessor());
  }
}
