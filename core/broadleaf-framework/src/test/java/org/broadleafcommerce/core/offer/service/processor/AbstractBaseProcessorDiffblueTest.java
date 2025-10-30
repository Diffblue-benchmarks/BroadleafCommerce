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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import java.util.TimeZone;
import org.broadleafcommerce.common.RequestDTO;
import org.broadleafcommerce.common.RequestDTOImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferQualifyingCriteriaXref;
import org.broadleafcommerce.core.offer.domain.OfferQualifyingCriteriaXrefImpl;
import org.broadleafcommerce.core.offer.service.discount.CandidatePromotionItems;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtility;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AbstractBaseProcessorDiffblueTest {
  @Mock
  private PromotableOfferUtility promotableOfferUtility;

  /**
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   * <p>
   * Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"})
  public void testMeetsItemQualifierSubtotal() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
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
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"})
  public void testMeetsItemQualifierSubtotal_givenHashSetAddOfferQualifyingCriteriaXrefImpl() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

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
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"})
  public void testMeetsItemQualifierSubtotal_givenMoney() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
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
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then calls {@link OfferImpl#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"})
  public void testMeetsItemQualifierSubtotal_givenMoneyWithAmountIsTen_thenCallsGetType() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
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
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link OfferImpl} {@link OfferImpl#getType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"})
  public void testMeetsItemQualifierSubtotal_givenNull_whenOfferImplGetTypeReturnNull() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
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
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   * <ul>
   *   <li>Given {@link OfferType#ORDER_ITEM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"})
  public void testMeetsItemQualifierSubtotal_givenOrder_item() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
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
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   * <ul>
   *   <li>Then calls {@link Money#greaterThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"})
  public void testMeetsItemQualifierSubtotal_thenCallsGreaterThan() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
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
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"})
  public void testMeetsItemQualifierSubtotal_whenOfferImpl_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(offer, new CandidatePromotionItems()));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   * <ul>
   *   <li>Given {@code Expression}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code Expression} is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_givenExpression_whenHashMapExpressionIs42_thenReturnFalse() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("Expression", "42");

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_givenFoo_whenHashMapFooIs42_thenReturnFalse() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("foo", "42");

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_givenGetProductAttributesUu() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("getProductAttributes()[UU]", "42");

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_whenEmptyString_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.executeExpression("", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   * <ul>
   *   <li>When {@code Expression}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_whenExpression_thenReturnFalse() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   * <ul>
   *   <li>When {@code getProductAttributes()[UU]}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_whenGetProductAttributesUu_thenReturnFalse() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("getProductAttributes()[UU]", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility)).executeExpression("Expression", null));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   * <ul>
   *   <li>When {@code Offer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_whenOrgBroadleafcommerceCoreOfferDomainOffer() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("org.broadleafcommerce.core.offer.domain.Offer",
        new HashMap<>()));
  }

  /**
   * Test {@link AbstractBaseProcessor#usePriceBeforeAdjustments(String)}.
   * <p>
   * Method under test: {@link AbstractBaseProcessor#usePriceBeforeAdjustments(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractBaseProcessor.usePriceBeforeAdjustments(String)"})
  public void testUsePriceBeforeAdjustments() {
    // Arrange, Act and Assert
    assertEquals("Expression",
        (new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility)).usePriceBeforeAdjustments("Expression"));
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   * <ul>
   *   <li>Given {@link OfferTimeZoneProcessor} {@link OfferTimeZoneProcessor#getTimeZone(Offer)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers_givenOfferTimeZoneProcessorGetTimeZoneReturnNull() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, new CustomerImpl());

    // Assert
    verify(offerTimeZoneProcessor, atLeast(1)).getTimeZone(isA(Offer.class));
    assertTrue(offers.isEmpty());
    assertTrue(actualFilterOffersResult.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   * <ul>
   *   <li>Then calls {@link OfferImpl#getEndDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers_thenCallsGetEndDate() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(offerImpl.getStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, new CustomerImpl());

    // Assert
    verify(offerImpl, atLeast(1)).getEndDate();
    verify(offerImpl, atLeast(1)).getStartDate();
    verify(offerTimeZoneProcessor, atLeast(1)).getTimeZone(Mockito.<Offer>any());
    assertTrue(offers.isEmpty());
    assertTrue(actualFilterOffersResult.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   * <ul>
   *   <li>Then calls {@link OfferTimeZoneProcessor#getTimeZone(Offer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers_thenCallsGetTimeZone() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, new CustomerImpl());

    // Assert
    verify(offerTimeZoneProcessor, atLeast(1)).getTimeZone(isA(Offer.class));
    assertTrue(offers.isEmpty());
    assertTrue(actualFilterOffersResult.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers_whenArrayList_thenArrayListEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, new CustomerImpl());

    // Assert
    assertTrue(offers.isEmpty());
    assertTrue(actualFilterOffersResult.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers_whenNull_thenNull() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    // Act and Assert
    assertNull(null);
    assertTrue(fulfillmentGroupOfferProcessorImpl.filterOffers(null, new CustomerImpl()).isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidRequestOffers(List)"})
  public void testRemoveInvalidRequestOffers_givenOfferImpl_thenReturnArrayList() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertSame(offers, fulfillmentGroupOfferProcessorImpl.removeInvalidRequestOffers(offers));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidRequestOffers(List)"})
  public void testRemoveInvalidRequestOffers_givenOfferImpl_thenReturnSizeIsTwo() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    OfferImpl offerImpl = new OfferImpl();
    offers.add(offerImpl);

    // Act
    List<Offer> actualRemoveInvalidRequestOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeInvalidRequestOffers(offers);

    // Assert
    assertEquals(2, actualRemoveInvalidRequestOffersResult.size());
    assertSame(offerImpl, actualRemoveInvalidRequestOffersResult.get(1));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidRequestOffers(List)"})
  public void testRemoveInvalidRequestOffers_whenArrayList_thenReturnEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.removeInvalidRequestOffers(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#couldOfferApplyToRequestDTO(Offer, RequestDTO)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#couldOfferApplyToRequestDTO(Offer, RequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.couldOfferApplyToRequestDTO(Offer, RequestDTO)"})
  public void testCouldOfferApplyToRequestDTO_whenOfferImpl_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.couldOfferApplyToRequestDTO(offer, new RequestDTOImpl()));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeTimePeriodOffers(List)"})
  public void testRemoveTimePeriodOffers_givenOfferImpl_thenReturnArrayList() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertSame(offers, fulfillmentGroupOfferProcessorImpl.removeTimePeriodOffers(offers));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeTimePeriodOffers(List)"})
  public void testRemoveTimePeriodOffers_givenOfferImpl_thenReturnSizeIsTwo() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    OfferImpl offerImpl = new OfferImpl();
    offers.add(offerImpl);

    // Act
    List<Offer> actualRemoveTimePeriodOffersResult = fulfillmentGroupOfferProcessorImpl.removeTimePeriodOffers(offers);

    // Assert
    assertEquals(2, actualRemoveTimePeriodOffersResult.size());
    assertSame(offerImpl, actualRemoveTimePeriodOffersResult.get(1));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeTimePeriodOffers(List)"})
  public void testRemoveTimePeriodOffers_whenArrayList_thenReturnEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.removeTimePeriodOffers(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#couldOfferApplyToTimePeriod(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#couldOfferApplyToTimePeriod(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.couldOfferApplyToTimePeriod(Offer)"})
  public void testCouldOfferApplyToTimePeriod_whenOfferImpl_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.couldOfferApplyToTimePeriod(new OfferImpl()));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   * <ul>
   *   <li>Given {@link OfferTimeZoneProcessor} {@link OfferTimeZoneProcessor#getTimeZone(Offer)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers_givenOfferTimeZoneProcessorGetTimeZoneReturnNull() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualRemoveOutOfDateOffersResult = fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerTimeZoneProcessor, atLeast(1)).getTimeZone(isA(Offer.class));
    assertTrue(offers.isEmpty());
    assertTrue(actualRemoveOutOfDateOffersResult.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   * <ul>
   *   <li>Then calls {@link OfferImpl#getEndDate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers_thenCallsGetEndDate() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(offerImpl.getStartDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualRemoveOutOfDateOffersResult = fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerImpl, atLeast(1)).getEndDate();
    verify(offerImpl, atLeast(1)).getStartDate();
    verify(offerTimeZoneProcessor, atLeast(1)).getTimeZone(Mockito.<Offer>any());
    assertTrue(offers.isEmpty());
    assertTrue(actualRemoveOutOfDateOffersResult.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   * <ul>
   *   <li>Then calls {@link OfferTimeZoneProcessor#getTimeZone(Offer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers_thenCallsGetTimeZone() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualRemoveOutOfDateOffersResult = fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerTimeZoneProcessor, atLeast(1)).getTimeZone(isA(Offer.class));
    assertTrue(offers.isEmpty());
    assertTrue(actualRemoveOutOfDateOffersResult.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers_whenArrayList() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    List<Offer> actualRemoveOutOfDateOffersResult = fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    assertTrue(offers.isEmpty());
    assertTrue(actualRemoveOutOfDateOffersResult.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#dateToCalendar(Date, TimeZone)}.
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#dateToCalendar(Date, TimeZone)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Calendar AbstractBaseProcessor.dateToCalendar(Date, TimeZone)"})
  public void testDateToCalendar_thenReturnGregorianCalendar() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
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
   * Test {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidCustomerOffers(List, Customer)"})
  public void testRemoveInvalidCustomerOffers_givenOfferImpl_thenReturnArrayList() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertSame(offers, fulfillmentGroupOfferProcessorImpl.removeInvalidCustomerOffers(offers, new CustomerImpl()));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidCustomerOffers(List, Customer)"})
  public void testRemoveInvalidCustomerOffers_givenOfferImpl_thenReturnSizeIsTwo() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    OfferImpl offerImpl = new OfferImpl();
    offers.add(offerImpl);

    // Act
    List<Offer> actualRemoveInvalidCustomerOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeInvalidCustomerOffers(offers, new CustomerImpl());

    // Assert
    assertEquals(2, actualRemoveInvalidCustomerOffersResult.size());
    assertSame(offerImpl, actualRemoveInvalidCustomerOffersResult.get(1));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidCustomerOffers(List, Customer)"})
  public void testRemoveInvalidCustomerOffers_whenArrayList_thenReturnEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.removeInvalidCustomerOffers(offers, new CustomerImpl()).isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#couldOfferApplyToCustomer(Offer, Customer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#couldOfferApplyToCustomer(Offer, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractBaseProcessor.couldOfferApplyToCustomer(Offer, Customer)"})
  public void testCouldOfferApplyToCustomer_whenOfferImpl_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.couldOfferApplyToCustomer(offer, new CustomerImpl()));
  }

  /**
   * Test {@link AbstractBaseProcessor#getOfferTimeZoneProcessor()}.
   * <p>
   * Method under test: {@link AbstractBaseProcessor#getOfferTimeZoneProcessor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferTimeZoneProcessor AbstractBaseProcessor.getOfferTimeZoneProcessor()"})
  public void testGetOfferTimeZoneProcessor() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility)).getOfferTimeZoneProcessor());
  }

  /**
   * Test {@link AbstractBaseProcessor#setOfferTimeZoneProcessor(OfferTimeZoneProcessor)}.
   * <p>
   * Method under test: {@link AbstractBaseProcessor#setOfferTimeZoneProcessor(OfferTimeZoneProcessor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractBaseProcessor.setOfferTimeZoneProcessor(OfferTimeZoneProcessor)"})
  public void testSetOfferTimeZoneProcessor() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);

    // Act
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    // Assert
    assertSame(offerTimeZoneProcessor, fulfillmentGroupOfferProcessorImpl.getOfferTimeZoneProcessor());
  }
}
