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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class AbstractBaseProcessorDiffblueTest {
  @Mock private PromotableOfferUtility promotableOfferUtility;

  /**
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   *
   * <p>Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer,
   * CandidatePromotionItems)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"
  })
  public void testMeetsItemQualifierSubtotal() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    OfferType offerType = new OfferType("ORDER_ITEM", "ORDER_ITEM", 1);
    when(offer.getType()).thenReturn(offerType);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));

    // Act
    boolean actualMeetsItemQualifierSubtotalResult =
        fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(
            offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer).getType();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link
   *       OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer,
   * CandidatePromotionItems)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"
  })
  public void testMeetsItemQualifierSubtotal_givenHashSetAddOfferQualifyingCriteriaXrefImpl() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    HashSet<OfferQualifyingCriteriaXref> offerQualifyingCriteriaXrefSet = new HashSet<>();
    offerQualifyingCriteriaXrefSet.add(new OfferQualifyingCriteriaXrefImpl());

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(offerQualifyingCriteriaXrefSet);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));

    // Act
    boolean actualMeetsItemQualifierSubtotalResult =
        fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(
            offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer,
   * CandidatePromotionItems)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"
  })
  public void testMeetsItemQualifierSubtotal_givenMoney() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money());

    // Act
    boolean actualMeetsItemQualifierSubtotalResult =
        fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(
            offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemSubTotal();
    assertTrue(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   *   <li>Then calls {@link OfferImpl#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer,
   * CandidatePromotionItems)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"
  })
  public void testMeetsItemQualifierSubtotal_givenMoneyWithAmountIsTen_thenCallsGetType() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(OfferType.FULFILLMENT_GROUP);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));

    // Act
    boolean actualMeetsItemQualifierSubtotalResult =
        fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(
            offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer).getType();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link OfferImpl} {@link OfferImpl#getType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer,
   * CandidatePromotionItems)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"
  })
  public void testMeetsItemQualifierSubtotal_givenNull_whenOfferImplGetTypeReturnNull() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(null);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));

    // Act
    boolean actualMeetsItemQualifierSubtotalResult =
        fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(
            offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer).getType();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   *
   * <ul>
   *   <li>Given {@link OfferType#ORDER_ITEM}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer,
   * CandidatePromotionItems)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"
  })
  public void testMeetsItemQualifierSubtotal_givenOrder_item() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(OfferType.ORDER_ITEM);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));

    // Act
    boolean actualMeetsItemQualifierSubtotalResult =
        fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(
            offer, new CandidatePromotionItems());

    // Assert
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer).getType();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   *
   * <ul>
   *   <li>When {@link CandidatePromotionItems} (default constructor).
   *   <li>Then calls {@link Money#greaterThan(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer,
   * CandidatePromotionItems)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"
  })
  public void testMeetsItemQualifierSubtotal_whenCandidatePromotionItems_thenCallsGreaterThan() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(OfferType.FULFILLMENT_GROUP);
    when(offer.getQualifyingItemSubTotal()).thenReturn(money);

    // Act
    boolean actualMeetsItemQualifierSubtotalResult =
        fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(
            offer, new CandidatePromotionItems());

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(offer).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer).getType();
    assertFalse(actualMeetsItemQualifierSubtotalResult);
  }

  /**
   * Test {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#meetsItemQualifierSubtotal(Offer,
   * CandidatePromotionItems)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBaseProcessor.meetsItemQualifierSubtotal(Offer, CandidatePromotionItems)"
  })
  public void testMeetsItemQualifierSubtotal_whenOfferImpl_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(
        fulfillmentGroupOfferProcessorImpl.meetsItemQualifierSubtotal(
            offer, new CandidatePromotionItems()));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code Expression}.
   *   <li>When {@link HashMap#HashMap()} {@code Expression} is {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_givenExpression_whenHashMapExpressionIs42_thenReturnFalse() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("Expression", "42");

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_givenFoo_whenHashMapFooIs42_thenReturnFalse() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("foo", "42");

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_givenGetProductAttributesUu() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("getProductAttributes()[UU]", "42");

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code Expression} is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_givenNull_whenHashMapExpressionIsNull_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("Expression", null);

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code OfferType}.
   *   <li>When {@link HashMap#HashMap()} {@code OfferType} is {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_givenOfferType_whenHashMapOfferTypeIs42_thenReturnFalse() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("OfferType", "42");
    vars.put("Expression", "42");

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link HashMap#HashMap()} {@code Expression} is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_givenTrue_whenHashMapExpressionIsTrue_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("Expression", true);

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", vars));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_whenEmptyString_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.executeExpression("", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>When {@code getProductAttributes()[UU]}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_whenGetProductAttributesUu_thenReturnFalse() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    // Act and Assert
    assertFalse(
        fulfillmentGroupOfferProcessorImpl.executeExpression(
            "getProductAttributes()[UU]", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_whenHashMap_thenReturnFalse() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    // Act and Assert
    assertFalse(
        fulfillmentGroupOfferProcessorImpl.executeExpression("Expression", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility)
            .executeExpression("Expression", null));
  }

  /**
   * Test {@link AbstractBaseProcessor#executeExpression(String, Map)}.
   *
   * <ul>
   *   <li>When {@code Offer}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#executeExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AbstractBaseProcessor.executeExpression(String, Map)"})
  public void testExecuteExpression_whenOrgBroadleafcommerceCoreOfferDomainOffer() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    // Act and Assert
    assertFalse(
        fulfillmentGroupOfferProcessorImpl.executeExpression(
            "org.broadleafcommerce.core.offer.domain.Offer", new HashMap<>()));
  }

  /**
   * Test {@link AbstractBaseProcessor#usePriceBeforeAdjustments(String)}.
   *
   * <p>Method under test: {@link AbstractBaseProcessor#usePriceBeforeAdjustments(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractBaseProcessor.usePriceBeforeAdjustments(String)"})
  public void testUsePriceBeforeAdjustments() {
    // Arrange, Act and Assert
    assertEquals(
        "Expression",
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility)
            .usePriceBeforeAdjustments("Expression"));
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   *
   * <p>Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
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
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
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
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   *
   * <p>Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers2() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
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
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);
    CustomerImpl customer = new CustomerImpl();

    // Act
    fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
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
    assertTrue(customer.getCustomerAddresses().isEmpty());
    assertTrue(customer.getCustomerPayments().isEmpty());
    assertTrue(customer.getCustomerPhones().isEmpty());
    assertTrue(customer.getCustomerAttributes().isEmpty());
    assertTrue(customer.getTransientProperties().isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) EndDate is {@link Date#Date()}.
   *   <li>Then {@link CustomerImpl} (default constructor) Preview is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers_givenOfferImplEndDateIsDate_thenCustomerImplPreviewIsNull() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
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
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setEndDate(new Date());

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);
    CustomerImpl customer = new CustomerImpl();

    // Act
    fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
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
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) StartDate is {@code null}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers_givenOfferImplStartDateIsNull_thenArrayListEmpty() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
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
    offerImpl.setStartDate(null);
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
    fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
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
    assertTrue(customer.getCustomerAddresses().isEmpty());
    assertTrue(customer.getCustomerPayments().isEmpty());
    assertTrue(customer.getCustomerPhones().isEmpty());
    assertTrue(customer.getCustomerAttributes().isEmpty());
    assertTrue(customer.getTransientProperties().isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   *
   * <ul>
   *   <li>Then {@link CustomerImpl} (default constructor) Preview is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers_thenCustomerImplPreviewIsNull() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
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
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertEquals("null", customer.getMainEntityName());
    assertNull(customer.getPreview());
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
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers_whenArrayList_thenArrayListEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
    ArrayList<Offer> offers = new ArrayList<>();
    CustomerImpl customer = new CustomerImpl();

    // Act
    fulfillmentGroupOfferProcessorImpl.filterOffers(offers, customer);

    // Assert that nothing has changed
    assertEquals("null", customer.getMainEntityName());
    assertFalse(customer.isAnonymous());
    assertFalse(customer.isCookied());
    assertFalse(customer.isDeactivated());
    assertFalse(customer.isLoggedIn());
    assertFalse(customer.isPasswordChangeRequired());
    assertFalse(customer.isReceiveEmail());
    assertFalse(customer.isRegistered());
    assertTrue(offers.isEmpty());
    assertTrue(customer.getCustomerAddresses().isEmpty());
    assertTrue(customer.getCustomerPayments().isEmpty());
    assertTrue(customer.getCustomerPhones().isEmpty());
    assertTrue(customer.getCustomerAttributes().isEmpty());
    assertTrue(customer.getTransientProperties().isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#filterOffers(List, Customer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#filterOffers(List, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.filterOffers(List, Customer)"})
  public void testFilterOffers_whenNull() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
    CustomerImpl customer = new CustomerImpl();

    // Act
    fulfillmentGroupOfferProcessorImpl.filterOffers(null, customer);

    // Assert that nothing has changed
    assertEquals("null", customer.getMainEntityName());
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
  }

  /**
   * Test {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidRequestOffers(List)"})
  public void testRemoveInvalidRequestOffers_givenOfferImpl_thenReturnArrayList() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualRemoveInvalidRequestOffersResult =
        fulfillmentGroupOfferProcessorImpl.removeInvalidRequestOffers(offers);

    // Assert
    assertSame(offers, actualRemoveInvalidRequestOffersResult);
  }

  /**
   * Test {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidRequestOffers(List)"})
  public void testRemoveInvalidRequestOffers_givenOfferImpl_thenReturnSizeIsTwo() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    OfferImpl offerImpl = new OfferImpl();
    offers.add(offerImpl);

    // Act
    List<Offer> actualRemoveInvalidRequestOffersResult =
        fulfillmentGroupOfferProcessorImpl.removeInvalidRequestOffers(offers);

    // Assert
    assertEquals(2, actualRemoveInvalidRequestOffersResult.size());
    assertSame(offerImpl, actualRemoveInvalidRequestOffersResult.get(1));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeInvalidRequestOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidRequestOffers(List)"})
  public void testRemoveInvalidRequestOffers_whenArrayList_thenReturnEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    // Act and Assert
    assertTrue(
        fulfillmentGroupOfferProcessorImpl.removeInvalidRequestOffers(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#couldOfferApplyToRequestDTO(Offer, RequestDTO)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#couldOfferApplyToRequestDTO(Offer,
   * RequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractBaseProcessor.couldOfferApplyToRequestDTO(Offer, RequestDTO)"
  })
  public void testCouldOfferApplyToRequestDTO_whenOfferImpl_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(
        fulfillmentGroupOfferProcessorImpl.couldOfferApplyToRequestDTO(
            offer, new RequestDTOImpl()));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeTimePeriodOffers(List)"})
  public void testRemoveTimePeriodOffers_givenOfferImpl_thenReturnArrayList() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualRemoveTimePeriodOffersResult =
        fulfillmentGroupOfferProcessorImpl.removeTimePeriodOffers(offers);

    // Assert
    assertSame(offers, actualRemoveTimePeriodOffersResult);
  }

  /**
   * Test {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeTimePeriodOffers(List)"})
  public void testRemoveTimePeriodOffers_givenOfferImpl_thenReturnSizeIsTwo() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    OfferImpl offerImpl = new OfferImpl();
    offers.add(offerImpl);

    // Act
    List<Offer> actualRemoveTimePeriodOffersResult =
        fulfillmentGroupOfferProcessorImpl.removeTimePeriodOffers(offers);

    // Assert
    assertEquals(2, actualRemoveTimePeriodOffersResult.size());
    assertSame(offerImpl, actualRemoveTimePeriodOffersResult.get(1));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeTimePeriodOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeTimePeriodOffers(List)"})
  public void testRemoveTimePeriodOffers_whenArrayList_thenReturnEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    // Act and Assert
    assertTrue(
        fulfillmentGroupOfferProcessorImpl.removeTimePeriodOffers(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#couldOfferApplyToTimePeriod(Offer)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#couldOfferApplyToTimePeriod(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractBaseProcessor.couldOfferApplyToTimePeriod(Offer)"})
  public void testCouldOfferApplyToTimePeriod_whenOfferImpl_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.couldOfferApplyToTimePeriod(new OfferImpl()));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
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
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers2() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
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
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers3() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
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
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertTrue(offers.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) EndDate is {@link Date#Date()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers_givenOfferImplEndDateIsDate() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
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
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setEndDate(new Date());

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(offerImpl);

    // Act
    fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) StartDate is {@code null}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers_givenOfferImplStartDateIsNull_thenArrayListEmpty() {
    // Arrange
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);
    when(offerTimeZoneProcessor.getTimeZone(Mockito.<Offer>any())).thenReturn(null);

    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
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
    offerImpl.setStartDate(null);
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
    verify(offerTimeZoneProcessor).getTimeZone(isA(Offer.class));
    assertNull(fulfillmentGroupOfferProcessorImpl.getOfferServiceUtilities());
    assertNull(fulfillmentGroupOfferProcessorImpl.getPromotableItemFactory());
    assertTrue(offers.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeOutOfDateOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeOutOfDateOffers(List)"})
  public void testRemoveOutOfDateOffers_whenArrayList_thenArrayListEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
    ArrayList<Offer> offers = new ArrayList<>();

    // Act
    fulfillmentGroupOfferProcessorImpl.removeOutOfDateOffers(offers);

    // Assert that nothing has changed
    assertTrue(offers.isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#dateToCalendar(Date, TimeZone)}.
   *
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#dateToCalendar(Date, TimeZone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar AbstractBaseProcessor.dateToCalendar(Date, TimeZone)"})
  public void testDateToCalendar_thenReturnGregorianCalendar() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
    TimeZone offerTimeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualDateToCalendarResult =
        fulfillmentGroupOfferProcessorImpl.dateToCalendar(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            offerTimeZone);

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
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidCustomerOffers(List, Customer)"})
  public void testRemoveInvalidCustomerOffers_givenOfferImpl_thenReturnArrayList() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act
    List<Offer> actualRemoveInvalidCustomerOffersResult =
        fulfillmentGroupOfferProcessorImpl.removeInvalidCustomerOffers(offers, new CustomerImpl());

    // Assert
    assertSame(offers, actualRemoveInvalidCustomerOffersResult);
  }

  /**
   * Test {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidCustomerOffers(List, Customer)"})
  public void testRemoveInvalidCustomerOffers_givenOfferImpl_thenReturnSizeIsTwo() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    OfferImpl offerImpl = new OfferImpl();
    offers.add(offerImpl);

    // Act
    List<Offer> actualRemoveInvalidCustomerOffersResult =
        fulfillmentGroupOfferProcessorImpl.removeInvalidCustomerOffers(offers, new CustomerImpl());

    // Assert
    assertEquals(2, actualRemoveInvalidCustomerOffersResult.size());
    assertSame(offerImpl, actualRemoveInvalidCustomerOffersResult.get(1));
  }

  /**
   * Test {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#removeInvalidCustomerOffers(List, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractBaseProcessor.removeInvalidCustomerOffers(List, Customer)"})
  public void testRemoveInvalidCustomerOffers_whenArrayList_thenReturnEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertTrue(
        fulfillmentGroupOfferProcessorImpl
            .removeInvalidCustomerOffers(offers, new CustomerImpl())
            .isEmpty());
  }

  /**
   * Test {@link AbstractBaseProcessor#couldOfferApplyToCustomer(Offer, Customer)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#couldOfferApplyToCustomer(Offer, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractBaseProcessor.couldOfferApplyToCustomer(Offer, Customer)"})
  public void testCouldOfferApplyToCustomer_whenOfferImpl_thenReturnTrue() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
    OfferImpl offer = new OfferImpl();

    // Act and Assert
    assertTrue(
        fulfillmentGroupOfferProcessorImpl.couldOfferApplyToCustomer(offer, new CustomerImpl()));
  }

  /**
   * Test {@link AbstractBaseProcessor#getOfferTimeZoneProcessor()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBaseProcessor#getOfferTimeZoneProcessor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferTimeZoneProcessor AbstractBaseProcessor.getOfferTimeZoneProcessor()"})
  public void testGetOfferTimeZoneProcessor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility).getOfferTimeZoneProcessor());
  }

  /**
   * Test {@link AbstractBaseProcessor#setOfferTimeZoneProcessor(OfferTimeZoneProcessor)}.
   *
   * <p>Method under test: {@link
   * AbstractBaseProcessor#setOfferTimeZoneProcessor(OfferTimeZoneProcessor)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractBaseProcessor.setOfferTimeZoneProcessor(OfferTimeZoneProcessor)"
  })
  public void testSetOfferTimeZoneProcessor() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(promotableOfferUtility);
    OfferTimeZoneProcessor offerTimeZoneProcessor = mock(OfferTimeZoneProcessor.class);

    // Act
    fulfillmentGroupOfferProcessorImpl.setOfferTimeZoneProcessor(offerTimeZoneProcessor);

    // Assert
    assertSame(
        offerTimeZoneProcessor, fulfillmentGroupOfferProcessorImpl.getOfferTimeZoneProcessor());
  }
}
