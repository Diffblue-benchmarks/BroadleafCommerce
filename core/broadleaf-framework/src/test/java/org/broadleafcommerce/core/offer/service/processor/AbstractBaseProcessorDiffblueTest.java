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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityService;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferOfferRuleXref;
import org.broadleafcommerce.core.offer.domain.OfferPriceData;
import org.broadleafcommerce.core.offer.domain.OfferQualifyingCriteriaXref;
import org.broadleafcommerce.core.offer.domain.OfferTargetCriteriaXref;
import org.broadleafcommerce.core.offer.service.OfferServiceUtilities;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtility;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.order.dao.OrderItemDao;
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
  private GenericEntityService genericEntityService;

  @Mock
  private OfferDao offerDao;

  @Mock
  private OfferServiceUtilities offerServiceUtilities;

  @Mock
  private OfferTimeZoneProcessor offerTimeZoneProcessor;

  @Mock
  private OrderItemDao orderItemDao;

  @Mock
  private PromotableItemFactory promotableItemFactory;

  @Mock
  private PromotableOfferUtility promotableOfferUtility;

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
  @MethodsUnderTest({"Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
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
  @MethodsUnderTest({"Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
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
  @MethodsUnderTest({"Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
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
  @MethodsUnderTest({"Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
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
  @MethodsUnderTest({"Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
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
  @MethodsUnderTest({"Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
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
  @MethodsUnderTest({"Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
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
  @MethodsUnderTest({"Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
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
    OfferTimeZoneProcessor offerTimeZoneProcessor2 = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor2.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor2);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, new CustomerImpl());

    // Assert
    verify(offerTimeZoneProcessor2, atLeast(1)).getTimeZone(isA(Offer.class));
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
    OfferTimeZoneProcessor offerTimeZoneProcessor2 = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor2.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor2);
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
    verify(offerTimeZoneProcessor2, atLeast(1)).getTimeZone(Mockito.<Offer>any());
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
    OfferTimeZoneProcessor offerTimeZoneProcessor2 = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor2.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor2);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualFilterOffersResult = fulfillmentGroupOfferProcessorImpl.filterOffers(offers, new CustomerImpl());

    // Assert
    verify(offerTimeZoneProcessor2, atLeast(1)).getTimeZone(isA(Offer.class));
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
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor2 = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor2.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor2);

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
    fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerTimeZoneProcessor2).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
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
    OfferTimeZoneProcessor offerTimeZoneProcessor2 = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor2.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor2);

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
    fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerTimeZoneProcessor2).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
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
    OfferTimeZoneProcessor offerTimeZoneProcessor2 = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor2.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        promotableOfferUtility);
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor2);
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
    fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

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
    verify(offerTimeZoneProcessor2).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertTrue(offers.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers_thenReturnEmpty() {
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
    fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert that nothing has changed
    assertTrue(offers.isEmpty());
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
    assertEquals(1970, actualDateToCalendarResult.getWeekYear());
    assertEquals(2, actualDateToCalendarResult.getFirstDayOfWeek());
    assertEquals(4, actualDateToCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(53, actualDateToCalendarResult.getWeeksInWeekYear());
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
    OfferTimeZoneProcessor offerTimeZoneProcessor2 = mock(OfferTimeZoneProcessor.class);

    // Act
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor2);

    // Assert
    assertSame(offerTimeZoneProcessor2, fulfillmentGroupOfferProcessorImpl.getOfferTimeZoneProcessor());
  }
}
