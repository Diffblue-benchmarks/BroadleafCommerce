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
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferImplDiffblueTest {
  @Autowired private OfferImpl offerImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferImpl#setDescription(String)}
   *   <li>{@link OfferImpl#setEndDate(Date)}
   *   <li>{@link OfferImpl#setId(Long)}
   *   <li>{@link OfferImpl#setMarketingMessage(String)}
   *   <li>{@link OfferImpl#setMaxUsesPerCustomer(Long)}
   *   <li>{@link OfferImpl#setMinimumDaysPerUsage(Long)}
   *   <li>{@link OfferImpl#setName(String)}
   *   <li>{@link OfferImpl#setOfferCodes(List)}
   *   <li>{@link OfferImpl#setOfferMatchRulesXref(Map)}
   *   <li>{@link OfferImpl#setOfferPriceData(List)}
   *   <li>{@link OfferImpl#setPriority(Integer)}
   *   <li>{@link OfferImpl#setQualifyingItemCriteriaXref(Set)}
   *   <li>{@link OfferImpl#setRequiresRelatedTargetAndQualifiers(Boolean)}
   *   <li>{@link OfferImpl#setStartDate(Date)}
   *   <li>{@link OfferImpl#setTargetItemCriteriaXref(Set)}
   *   <li>{@link OfferImpl#setTargetSystem(String)}
   *   <li>{@link OfferImpl#setUseListForDiscounts(Boolean)}
   *   <li>{@link OfferImpl#setValue(BigDecimal)}
   *   <li>{@link OfferImpl#getDescription()}
   *   <li>{@link OfferImpl#getEndDate()}
   *   <li>{@link OfferImpl#getId()}
   *   <li>{@link OfferImpl#getMinimumDaysPerUsage()}
   *   <li>{@link OfferImpl#getName()}
   *   <li>{@link OfferImpl#getOfferCodes()}
   *   <li>{@link OfferImpl#getOfferMatchRulesXref()}
   *   <li>{@link OfferImpl#getOfferPriceData()}
   *   <li>{@link OfferImpl#getQualifyingItemCriteriaXref()}
   *   <li>{@link OfferImpl#getTargetSystem()}
   *   <li>{@link OfferImpl#getValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String OfferImpl.getDescription()",
    "Date OfferImpl.getEndDate()",
    "Long OfferImpl.getId()",
    "Long OfferImpl.getMinimumDaysPerUsage()",
    "String OfferImpl.getName()",
    "List OfferImpl.getOfferCodes()",
    "Map OfferImpl.getOfferMatchRulesXref()",
    "List OfferImpl.getOfferPriceData()",
    "Set OfferImpl.getQualifyingItemCriteriaXref()",
    "String OfferImpl.getTargetSystem()",
    "BigDecimal OfferImpl.getValue()",
    "void OfferImpl.setDescription(String)",
    "void OfferImpl.setEndDate(Date)",
    "void OfferImpl.setId(Long)",
    "void OfferImpl.setMarketingMessage(String)",
    "void OfferImpl.setMaxUsesPerCustomer(Long)",
    "void OfferImpl.setMinimumDaysPerUsage(Long)",
    "void OfferImpl.setName(String)",
    "void OfferImpl.setOfferCodes(List)",
    "void OfferImpl.setOfferMatchRulesXref(Map)",
    "void OfferImpl.setOfferPriceData(List)",
    "void OfferImpl.setPriority(Integer)",
    "void OfferImpl.setQualifyingItemCriteriaXref(Set)",
    "void OfferImpl.setRequiresRelatedTargetAndQualifiers(Boolean)",
    "void OfferImpl.setStartDate(Date)",
    "void OfferImpl.setTargetItemCriteriaXref(Set)",
    "void OfferImpl.setTargetSystem(String)",
    "void OfferImpl.setUseListForDiscounts(Boolean)",
    "void OfferImpl.setValue(BigDecimal)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    offerImpl.setDescription("The characteristics of someone or something");
    Date endDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offerImpl.setEndDate(endDate);
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offerImpl.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offerImpl.setName("Name");
    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerImpl.setOfferCodes(offerCodes);
    HashMap<String, OfferOfferRuleXref> offerMatchRulesXref = new HashMap<>();
    offerImpl.setOfferMatchRulesXref(offerMatchRulesXref);
    ArrayList<OfferPriceData> offerPriceData = new ArrayList<>();
    offerImpl.setOfferPriceData(offerPriceData);
    offerImpl.setPriority(1);
    HashSet<OfferQualifyingCriteriaXref> qualifyingItemCriteriaXref = new HashSet<>();
    offerImpl.setQualifyingItemCriteriaXref(qualifyingItemCriteriaXref);
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setUseListForDiscounts(true);
    BigDecimal value = new BigDecimal("2.3");
    offerImpl.setValue(value);
    String actualDescription = offerImpl.getDescription();
    Date actualEndDate = offerImpl.getEndDate();
    Long actualId = offerImpl.getId();
    Long actualMinimumDaysPerUsage = offerImpl.getMinimumDaysPerUsage();
    String actualName = offerImpl.getName();
    List<OfferCode> actualOfferCodes = offerImpl.getOfferCodes();
    Map<String, OfferOfferRuleXref> actualOfferMatchRulesXref = offerImpl.getOfferMatchRulesXref();
    List<OfferPriceData> actualOfferPriceData = offerImpl.getOfferPriceData();
    Set<OfferQualifyingCriteriaXref> actualQualifyingItemCriteriaXref =
        offerImpl.getQualifyingItemCriteriaXref();
    String actualTargetSystem = offerImpl.getTargetSystem();
    BigDecimal actualValue = offerImpl.getValue();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Target System", actualTargetSystem);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualOfferCodes.isEmpty());
    assertTrue(actualOfferPriceData.isEmpty());
    assertTrue(actualOfferMatchRulesXref.isEmpty());
    assertTrue(actualQualifyingItemCriteriaXref.isEmpty());
    assertEquals(new BigDecimal("2.3"), actualValue);
    assertEquals(OfferImpl.serialVersionUID, actualId.longValue());
    assertEquals(OfferImpl.serialVersionUID, actualMinimumDaysPerUsage.longValue());
    assertSame(value, actualValue);
    assertSame(offerCodes, actualOfferCodes);
    assertSame(offerPriceData, actualOfferPriceData);
    assertSame(offerMatchRulesXref, actualOfferMatchRulesXref);
    assertSame(qualifyingItemCriteriaXref, actualQualifyingItemCriteriaXref);
    assertSame(endDate, actualEndDate);
  }

  /**
   * Test {@link OfferImpl#getType()}.
   *
   * <p>Method under test: {@link OfferImpl#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferType OfferImpl.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull(offerImpl.getType());
  }

  /**
   * Test {@link OfferImpl#setType(OfferType)}.
   *
   * <ul>
   *   <li>When {@link OfferType#FULFILLMENT_GROUP}.
   *   <li>Then {@link OfferImpl} {@link OfferImpl#type} is {@code FULFILLMENT_GROUP}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#setType(OfferType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setType(OfferType)"})
  public void testSetType_whenFulfillment_group_thenOfferImplTypeIsFulfillmentGroup() {
    // Arrange and Act
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);

    // Assert
    assertEquals("FULFILLMENT_GROUP", offerImpl.type);
    assertSame(OfferType.FULFILLMENT_GROUP, offerImpl.getType());
  }

  /**
   * Test {@link OfferImpl#getDiscountType()}.
   *
   * <p>Method under test: {@link OfferImpl#getDiscountType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferDiscountType OfferImpl.getDiscountType()"})
  public void testGetDiscountType() {
    // Arrange, Act and Assert
    assertNull(offerImpl.getDiscountType());
  }

  /**
   * Test {@link OfferImpl#setDiscountType(OfferDiscountType)}.
   *
   * <ul>
   *   <li>When {@link OfferDiscountType#AMOUNT_OFF}.
   *   <li>Then {@link OfferImpl} {@link OfferImpl#discountType} is {@code AMOUNT_OFF}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#setDiscountType(OfferDiscountType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setDiscountType(OfferDiscountType)"})
  public void testSetDiscountType_whenAmount_off_thenOfferImplDiscountTypeIsAmountOff() {
    // Arrange and Act
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);

    // Assert
    assertEquals("AMOUNT_OFF", offerImpl.discountType);
    assertSame(OfferDiscountType.AMOUNT_OFF, offerImpl.getDiscountType());
  }

  /**
   * Test {@link OfferImpl#getOfferItemQualifierRuleType()}.
   *
   * <ul>
   *   <li>Then {@link OfferImpl} OfferItemTargetRuleType is {@link
   *       OfferItemRestrictionRuleType#NONE}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getOfferItemQualifierRuleType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferItemRestrictionRuleType OfferImpl.getOfferItemQualifierRuleType()"})
  public void testGetOfferItemQualifierRuleType_thenOfferImplOfferItemTargetRuleTypeIsNone() {
    // Arrange, Act and Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = OfferItemRestrictionRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemQualifierRuleType());
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemTargetRuleType());
  }

  /**
   * Test {@link OfferImpl#getOfferItemQualifierRuleType()}.
   *
   * <ul>
   *   <li>Then {@link OfferImpl} (default constructor) OfferItemTargetRuleType is {@link
   *       OfferItemRestrictionRuleType#NONE}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getOfferItemQualifierRuleType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferItemRestrictionRuleType OfferImpl.getOfferItemQualifierRuleType()"})
  public void testGetOfferItemQualifierRuleType_thenOfferImplOfferItemTargetRuleTypeIsNone2() {
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

    // Act and Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = OfferItemRestrictionRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemQualifierRuleType());
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemTargetRuleType());
  }

  /**
   * Test {@link OfferImpl#setOfferItemQualifierRuleType(OfferItemRestrictionRuleType)}.
   *
   * <ul>
   *   <li>Then {@link OfferImpl} {@link OfferImpl#offerItemQualifierRuleType} is {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferImpl#setOfferItemQualifierRuleType(OfferItemRestrictionRuleType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType)"})
  public void testSetOfferItemQualifierRuleType_thenOfferImplOfferItemQualifierRuleTypeIsNone() {
    // Arrange and Act
    offerImpl.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);

    // Assert
    assertEquals("NONE", offerImpl.offerItemQualifierRuleType);
  }

  /**
   * Test {@link OfferImpl#getOfferItemTargetRuleType()}.
   *
   * <ul>
   *   <li>Then {@link OfferImpl} OfferItemQualifierRuleType is {@link
   *       OfferItemRestrictionRuleType#NONE}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getOfferItemTargetRuleType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferItemRestrictionRuleType OfferImpl.getOfferItemTargetRuleType()"})
  public void testGetOfferItemTargetRuleType_thenOfferImplOfferItemQualifierRuleTypeIsNone() {
    // Arrange and Act
    OfferItemRestrictionRuleType actualOfferItemTargetRuleType =
        offerImpl.getOfferItemTargetRuleType();

    // Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = OfferItemRestrictionRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemQualifierRuleType());
    assertSame(offerItemRestrictionRuleType, actualOfferItemTargetRuleType);
  }

  /**
   * Test {@link OfferImpl#getOfferItemTargetRuleType()}.
   *
   * <ul>
   *   <li>Then {@link OfferImpl} (default constructor) OfferItemQualifierRuleType is {@link
   *       OfferItemRestrictionRuleType#NONE}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getOfferItemTargetRuleType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferItemRestrictionRuleType OfferImpl.getOfferItemTargetRuleType()"})
  public void testGetOfferItemTargetRuleType_thenOfferImplOfferItemQualifierRuleTypeIsNone2() {
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

    // Act
    OfferItemRestrictionRuleType actualOfferItemTargetRuleType =
        offerImpl.getOfferItemTargetRuleType();

    // Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = OfferItemRestrictionRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemQualifierRuleType());
    assertSame(offerItemRestrictionRuleType, actualOfferItemTargetRuleType);
  }

  /**
   * Test {@link OfferImpl#setOfferItemTargetRuleType(OfferItemRestrictionRuleType)}.
   *
   * <ul>
   *   <li>Then {@link OfferImpl} {@link OfferImpl#offerItemTargetRuleType} is {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferImpl#setOfferItemTargetRuleType(OfferItemRestrictionRuleType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setOfferItemTargetRuleType(OfferItemRestrictionRuleType)"})
  public void testSetOfferItemTargetRuleType_thenOfferImplOfferItemTargetRuleTypeIsNone() {
    // Arrange and Act
    offerImpl.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);

    // Assert
    assertEquals("NONE", offerImpl.offerItemTargetRuleType);
  }

  /**
   * Test {@link OfferImpl#getPriority()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} Priority is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OfferImpl.getPriority()"})
  public void testGetPriority_givenOfferImplPriorityIsOne_thenReturnOne() {
    // Arrange
    offerImpl.setPriority(1);

    // Act and Assert
    assertEquals(1, offerImpl.getPriority());
  }

  /**
   * Test {@link OfferImpl#getPriority()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@link Integer#MAX_VALUE} less one.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OfferImpl.getPriority()"})
  public void testGetPriority_givenOfferImpl_thenReturnMax_valueLessOne() {
    // Arrange, Act and Assert
    assertEquals(2147483646, offerImpl.getPriority());
  }

  /**
   * Test {@link OfferImpl#getStartDate()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} Archived is {@code Y}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getStartDate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date OfferImpl.getStartDate()"})
  public void testGetStartDate_givenOfferImplArchivedIsY_thenReturnNull() {
    // Arrange
    offerImpl.setArchived('Y');

    // Act and Assert
    assertNull(offerImpl.getStartDate());
  }

  /**
   * Test {@link OfferImpl#getStartDate()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getStartDate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date OfferImpl.getStartDate()"})
  public void testGetStartDate_givenOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(offerImpl.getStartDate());
  }

  /**
   * Test {@link OfferImpl#getApplyDiscountToSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getApplyDiscountToSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.getApplyDiscountToSalePrice()"})
  public void testGetApplyDiscountToSalePrice_givenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(offerImpl.getApplyDiscountToSalePrice());
  }

  /**
   * Test {@link OfferImpl#getApplyDiscountToSalePrice()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getApplyDiscountToSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.getApplyDiscountToSalePrice()"})
  public void testGetApplyDiscountToSalePrice_thenReturnFalse() {
    // Arrange
    offerImpl.setApplyDiscountToSalePrice(false);

    // Act and Assert
    assertFalse(offerImpl.getApplyDiscountToSalePrice());
  }

  /**
   * Test {@link OfferImpl#getApplyToChildItems()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} ApplyToChildItems is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getApplyToChildItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferImpl.getApplyToChildItems()"})
  public void testGetApplyToChildItems_givenOfferImplApplyToChildItemsIsTrue_thenReturnTrue() {
    // Arrange
    offerImpl.setApplyToChildItems(true);

    // Act and Assert
    assertTrue(offerImpl.getApplyToChildItems());
  }

  /**
   * Test {@link OfferImpl#getApplyToChildItems()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getApplyToChildItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferImpl.getApplyToChildItems()"})
  public void testGetApplyToChildItems_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerImpl.getApplyToChildItems());
  }

  /**
   * Test {@link OfferImpl#setApplyToChildItems(boolean)}.
   *
   * <p>Method under test: {@link OfferImpl#setApplyToChildItems(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setApplyToChildItems(boolean)"})
  public void testSetApplyToChildItems() {
    // Arrange and Act
    offerImpl.setApplyToChildItems(true);

    // Assert
    assertTrue(offerImpl.getApplyToChildItems());
    assertTrue(offerImpl.applyToChildItems);
  }

  /**
   * Test {@link OfferImpl#isCombinableWithOtherOffers()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isCombinableWithOtherOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isCombinableWithOtherOffers()"})
  public void testIsCombinableWithOtherOffers_givenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(offerImpl.isCombinableWithOtherOffers());
  }

  /**
   * Test {@link OfferImpl#isCombinableWithOtherOffers()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isCombinableWithOtherOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isCombinableWithOtherOffers()"})
  public void testIsCombinableWithOtherOffers_thenReturnFalse() {
    // Arrange
    offerImpl.setCombinableWithOtherOffers(false);

    // Act and Assert
    assertFalse(offerImpl.isCombinableWithOtherOffers());
  }

  /**
   * Test {@link OfferImpl#getCombinableWithOtherOffers()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getCombinableWithOtherOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.getCombinableWithOtherOffers()"})
  public void testGetCombinableWithOtherOffers_givenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(offerImpl.getCombinableWithOtherOffers());
  }

  /**
   * Test {@link OfferImpl#getCombinableWithOtherOffers()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getCombinableWithOtherOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.getCombinableWithOtherOffers()"})
  public void testGetCombinableWithOtherOffers_thenReturnFalse() {
    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setCombinableWithOtherOffers(false);

    // Act and Assert
    assertFalse(offerImpl.getCombinableWithOtherOffers());
  }

  /**
   * Test {@link OfferImpl#isAutomaticallyAdded()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} AutomaticallyAdded is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isAutomaticallyAdded()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isAutomaticallyAdded()"})
  public void testIsAutomaticallyAdded_givenOfferImplAutomaticallyAddedIsTrue_thenReturnTrue() {
    // Arrange
    offerImpl.setAutomaticallyAdded(true);

    // Act and Assert
    assertTrue(offerImpl.isAutomaticallyAdded());
  }

  /**
   * Test {@link OfferImpl#isAutomaticallyAdded()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isAutomaticallyAdded()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isAutomaticallyAdded()"})
  public void testIsAutomaticallyAdded_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerImpl.isAutomaticallyAdded());
  }

  /**
   * Test {@link OfferImpl#setAutomaticallyAdded(boolean)}.
   *
   * <p>Method under test: {@link OfferImpl#setAutomaticallyAdded(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setAutomaticallyAdded(boolean)"})
  public void testSetAutomaticallyAdded() {
    // Arrange and Act
    offerImpl.setAutomaticallyAdded(true);

    // Assert
    assertTrue(offerImpl.automaticallyAdded);
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerCustomer()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getMaxUsesPerCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferImpl.getMaxUsesPerCustomer()"})
  public void testGetMaxUsesPerCustomer_givenOfferImpl_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, offerImpl.getMaxUsesPerCustomer().longValue());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerCustomer()}.
   *
   * <ul>
   *   <li>Then return longValue is {@link OfferImpl#serialVersionUID}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getMaxUsesPerCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OfferImpl.getMaxUsesPerCustomer()"})
  public void testGetMaxUsesPerCustomer_thenReturnLongValueIsSerialVersionUID() {
    // Arrange
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(OfferImpl.serialVersionUID, offerImpl.getMaxUsesPerCustomer().longValue());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesStrategyType()}.
   *
   * <p>Method under test: {@link OfferImpl#getMaxUsesStrategyType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerMaxUsesStrategyType OfferImpl.getMaxUsesStrategyType()"})
  public void testGetMaxUsesStrategyType() {
    // Arrange, Act and Assert
    assertNull(offerImpl.getMaxUsesStrategyType());
  }

  /**
   * Test {@link OfferImpl#setMaxUsesStrategyType(CustomerMaxUsesStrategyType)}.
   *
   * <ul>
   *   <li>When {@link CustomerMaxUsesStrategyType#ACCOUNT}.
   *   <li>Then {@link OfferImpl} {@link OfferImpl#maxUsesStrategy} is {@code ACCOUNT}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#setMaxUsesStrategyType(CustomerMaxUsesStrategyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setMaxUsesStrategyType(CustomerMaxUsesStrategyType)"})
  public void testSetMaxUsesStrategyType_whenAccount_thenOfferImplMaxUsesStrategyIsAccount() {
    // Arrange and Act
    offerImpl.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);

    // Assert
    assertEquals("ACCOUNT", offerImpl.maxUsesStrategy);
    assertSame(CustomerMaxUsesStrategyType.ACCOUNT, offerImpl.getMaxUsesStrategyType());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerCustomer()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isUnlimitedUsePerCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isUnlimitedUsePerCustomer()"})
  public void testIsUnlimitedUsePerCustomer_givenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(offerImpl.isUnlimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerCustomer()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isUnlimitedUsePerCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isUnlimitedUsePerCustomer()"})
  public void testIsUnlimitedUsePerCustomer_thenReturnFalse() {
    // Arrange
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act and Assert
    assertFalse(offerImpl.isUnlimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerCustomer()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isLimitedUsePerCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isLimitedUsePerCustomer()"})
  public void testIsLimitedUsePerCustomer_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerImpl.isLimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerCustomer()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isLimitedUsePerCustomer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isLimitedUsePerCustomer()"})
  public void testIsLimitedUsePerCustomer_thenReturnTrue() {
    // Arrange
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act and Assert
    assertTrue(offerImpl.isLimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerOrder()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} MaxUsesPerOrder is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getMaxUsesPerOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OfferImpl.getMaxUsesPerOrder()"})
  public void testGetMaxUsesPerOrder_givenOfferImplMaxUsesPerOrderIsOne_thenReturnOne() {
    // Arrange
    offerImpl.setMaxUsesPerOrder(1);

    // Act and Assert
    assertEquals(1, offerImpl.getMaxUsesPerOrder());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerOrder()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getMaxUsesPerOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int OfferImpl.getMaxUsesPerOrder()"})
  public void testGetMaxUsesPerOrder_givenOfferImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, offerImpl.getMaxUsesPerOrder());
  }

  /**
   * Test {@link OfferImpl#setMaxUsesPerOrder(int)}.
   *
   * <p>Method under test: {@link OfferImpl#setMaxUsesPerOrder(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setMaxUsesPerOrder(int)"})
  public void testSetMaxUsesPerOrder() {
    // Arrange and Act
    offerImpl.setMaxUsesPerOrder(3);

    // Assert
    assertEquals(3, offerImpl.maxUsesPerOrder.intValue());
    assertEquals(3, offerImpl.getMaxUsesPerOrder());
    assertFalse(offerImpl.isUnlimitedUsePerOrder());
    assertTrue(offerImpl.isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerOrder()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} MaxUsesPerOrder is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isUnlimitedUsePerOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isUnlimitedUsePerOrder()"})
  public void testIsUnlimitedUsePerOrder_givenOfferImplMaxUsesPerOrderIsOne_thenReturnFalse() {
    // Arrange
    offerImpl.setMaxUsesPerOrder(1);

    // Act and Assert
    assertFalse(offerImpl.isUnlimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerOrder()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} MaxUsesPerOrder is zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isUnlimitedUsePerOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isUnlimitedUsePerOrder()"})
  public void testIsUnlimitedUsePerOrder_givenOfferImplMaxUsesPerOrderIsZero_thenReturnTrue() {
    // Arrange
    offerImpl.setMaxUsesPerOrder(0);

    // Act and Assert
    assertTrue(offerImpl.isUnlimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerOrder()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isUnlimitedUsePerOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isUnlimitedUsePerOrder()"})
  public void testIsUnlimitedUsePerOrder_givenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(offerImpl.isUnlimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerOrder()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} MaxUsesPerOrder is one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isLimitedUsePerOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isLimitedUsePerOrder()"})
  public void testIsLimitedUsePerOrder_givenOfferImplMaxUsesPerOrderIsOne_thenReturnTrue() {
    // Arrange
    offerImpl.setMaxUsesPerOrder(1);

    // Act and Assert
    assertTrue(offerImpl.isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerOrder()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} MaxUsesPerOrder is zero.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isLimitedUsePerOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isLimitedUsePerOrder()"})
  public void testIsLimitedUsePerOrder_givenOfferImplMaxUsesPerOrderIsZero_thenReturnFalse() {
    // Arrange
    offerImpl.setMaxUsesPerOrder(0);

    // Act and Assert
    assertFalse(offerImpl.isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerOrder()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isLimitedUsePerOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isLimitedUsePerOrder()"})
  public void testIsLimitedUsePerOrder_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerImpl.isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#getMarketingMessage()}.
   *
   * <p>Method under test: {@link OfferImpl#getMarketingMessage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OfferImpl.getMarketingMessage()"})
  public void testGetMarketingMessage() {
    // Arrange, Act and Assert
    assertNull(offerImpl.getMarketingMessage());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) TargetItemCriteriaXref is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OfferImpl.getTargetItemCriteriaXref()"})
  public void testGetTargetItemCriteriaXref_givenOfferImplTargetItemCriteriaXrefIsHashSet() {
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
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.ORDER_ITEM);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());

    // Act and Assert
    assertEquals(1, offerImpl.getTargetItemCriteriaXref().size());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) TargetItemCriteriaXref is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OfferImpl.getTargetItemCriteriaXref()"})
  public void testGetTargetItemCriteriaXref_givenOfferImplTargetItemCriteriaXrefIsNull() {
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
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.ORDER_ITEM);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setTargetItemCriteriaXref(null);

    // Act and Assert
    assertEquals(1, offerImpl.getTargetItemCriteriaXref().size());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OfferImpl.getTargetItemCriteriaXref()"})
  public void testGetTargetItemCriteriaXref_givenOfferImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(offerImpl.getTargetItemCriteriaXref().isEmpty());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   *
   * <ul>
   *   <li>Then return {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OfferImpl.getTargetItemCriteriaXref()"})
  public void testGetTargetItemCriteriaXref_thenReturnHashSet() {
    // Arrange
    HashSet<OfferTargetCriteriaXref> targetItemCriteriaXref = new HashSet<>();
    targetItemCriteriaXref.add(new OfferTargetCriteriaXrefImpl());

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
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.ORDER_ITEM);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setTargetItemCriteriaXref(targetItemCriteriaXref);

    // Act
    Set<OfferTargetCriteriaXref> actualTargetItemCriteriaXref =
        offerImpl.getTargetItemCriteriaXref();

    // Assert
    assertEquals(1, actualTargetItemCriteriaXref.size());
    assertSame(targetItemCriteriaXref, actualTargetItemCriteriaXref);
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set OfferImpl.getTargetItemCriteriaXref()"})
  public void testGetTargetItemCriteriaXref_thenReturnNull() {
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
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setTargetItemCriteriaXref(null);

    // Act and Assert
    assertNull(offerImpl.getTargetItemCriteriaXref());
  }

  /**
   * Test {@link OfferImpl#isTotalitarianOffer()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} TotalitarianOffer is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isTotalitarianOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferImpl.isTotalitarianOffer()"})
  public void testIsTotalitarianOffer_givenOfferImplTotalitarianOfferIsTrue_thenReturnTrue() {
    // Arrange
    offerImpl.setTotalitarianOffer(true);

    // Act and Assert
    assertTrue(offerImpl.isTotalitarianOffer());
  }

  /**
   * Test {@link OfferImpl#isTotalitarianOffer()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isTotalitarianOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferImpl.isTotalitarianOffer()"})
  public void testIsTotalitarianOffer_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerImpl.isTotalitarianOffer());
  }

  /**
   * Test {@link OfferImpl#setTotalitarianOffer(Boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then not {@link OfferImpl} {@link OfferImpl#totalitarianOffer}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#setTotalitarianOffer(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setTotalitarianOffer(Boolean)"})
  public void testSetTotalitarianOffer_whenNull_thenNotOfferImplTotalitarianOffer() {
    // Arrange and Act
    offerImpl.setTotalitarianOffer(null);

    // Assert that nothing has changed
    assertFalse(offerImpl.totalitarianOffer);
  }

  /**
   * Test {@link OfferImpl#setTotalitarianOffer(Boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link OfferImpl} {@link OfferImpl#totalitarianOffer}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#setTotalitarianOffer(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setTotalitarianOffer(Boolean)"})
  public void testSetTotalitarianOffer_whenTrue_thenOfferImplTotalitarianOffer() {
    // Arrange and Act
    offerImpl.setTotalitarianOffer(true);

    // Assert
    assertTrue(offerImpl.totalitarianOffer);
  }

  /**
   * Test {@link OfferImpl#getUseListForDiscounts()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} UseListForDiscounts is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getUseListForDiscounts()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferImpl.getUseListForDiscounts()"})
  public void testGetUseListForDiscounts_givenOfferImplUseListForDiscountsIsNull() {
    // Arrange
    offerImpl.setUseListForDiscounts(null);

    // Act and Assert
    assertFalse(offerImpl.getUseListForDiscounts());
  }

  /**
   * Test {@link OfferImpl#getUseListForDiscounts()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getUseListForDiscounts()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferImpl.getUseListForDiscounts()"})
  public void testGetUseListForDiscounts_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerImpl.getUseListForDiscounts());
  }

  /**
   * Test {@link OfferImpl#getUseListForDiscounts()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getUseListForDiscounts()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferImpl.getUseListForDiscounts()"})
  public void testGetUseListForDiscounts_thenReturnTrue() {
    // Arrange
    offerImpl.setUseListForDiscounts(true);

    // Act and Assert
    assertTrue(offerImpl.getUseListForDiscounts());
  }

  /**
   * Test {@link OfferImpl#getArchived()}.
   *
   * <p>Method under test: {@link OfferImpl#getArchived()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character OfferImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', offerImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferImpl#setArchived(Character)}.
   *
   * <p>Method under test: {@link OfferImpl#setArchived(Character)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange and Act
    offerImpl.setArchived('A');

    // Assert
    assertEquals('A', offerImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', offerImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferImpl#isActive()}.
   *
   * <p>Method under test: {@link OfferImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isActive()"})
  public void testIsActive() {
    // Arrange
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setArchived(null);

    // Act and Assert
    assertFalse(offerImpl.isActive());
  }

  /**
   * Test {@link OfferImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isActive()"})
  public void testIsActive_givenOfferImplArchivedIsY_thenReturnFalse() {
    // Arrange
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setEndDate(null);
    offerImpl.setArchived('Y');

    // Act and Assert
    assertFalse(offerImpl.isActive());
  }

  /**
   * Test {@link OfferImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} EndDate is {@link Date#Date()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isActive()"})
  public void testIsActive_givenOfferImplEndDateIsDate_thenReturnFalse() {
    // Arrange
    offerImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setEndDate(new Date());
    offerImpl.setArchived('Y');

    // Act and Assert
    assertFalse(offerImpl.isActive());
  }

  /**
   * Test {@link OfferImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isActive()"})
  public void testIsActive_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerImpl.isActive());
  }

  /**
   * Test {@link OfferImpl#getQualifyingItemSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getQualifyingItemSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OfferImpl.getQualifyingItemSubTotal()"})
  public void testGetQualifyingItemSubTotal_givenOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(offerImpl.getQualifyingItemSubTotal());
  }

  /**
   * Test {@link OfferImpl#getQualifyingItemSubTotal()}.
   *
   * <ul>
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getQualifyingItemSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OfferImpl.getQualifyingItemSubTotal()"})
  public void testGetQualifyingItemSubTotal_thenReturnMoney() {
    // Arrange
    Money qualifyingItemSubTotal = new Money();
    offerImpl.setQualifyingItemSubTotal(qualifyingItemSubTotal);

    // Act and Assert
    assertEquals(qualifyingItemSubTotal, offerImpl.getQualifyingItemSubTotal());
  }

  /**
   * Test {@link OfferImpl#setQualifyingItemSubTotal(Money)}.
   *
   * <p>Method under test: {@link OfferImpl#setQualifyingItemSubTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setQualifyingItemSubTotal(Money)"})
  public void testSetQualifyingItemSubTotal() {
    // Arrange
    Money qualifyingItemSubTotal = new Money();

    // Act
    offerImpl.setQualifyingItemSubTotal(qualifyingItemSubTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), offerImpl.qualifyingItemSubTotal);
    BigDecimal bigDecimal = offerImpl.qualifyingItemSubTotal;
    Money absResult = qualifyingItemSubTotal.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = qualifyingItemSubTotal.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link OfferImpl#setQualifyingItemSubTotal(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OfferImpl} {@link OfferImpl#qualifyingItemSubTotal} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#setQualifyingItemSubTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setQualifyingItemSubTotal(Money)"})
  public void testSetQualifyingItemSubTotal_whenNull_thenOfferImplQualifyingItemSubTotalIsNull() {
    // Arrange and Act
    offerImpl.setQualifyingItemSubTotal(null);

    // Assert that nothing has changed
    assertNull(offerImpl.qualifyingItemSubTotal);
  }

  /**
   * Test {@link OfferImpl#getOrderMinSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} OrderMinSubTotal is {@link Money#Money()}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getOrderMinSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OfferImpl.getOrderMinSubTotal()"})
  public void testGetOrderMinSubTotal_givenOfferImplOrderMinSubTotalIsMoney_thenReturnMoney() {
    // Arrange
    Money orderMinSubTotal = new Money();
    offerImpl.setOrderMinSubTotal(orderMinSubTotal);

    // Act and Assert
    assertEquals(orderMinSubTotal, offerImpl.getOrderMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getOrderMinSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getOrderMinSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OfferImpl.getOrderMinSubTotal()"})
  public void testGetOrderMinSubTotal_givenOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(offerImpl.getOrderMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#setOrderMinSubTotal(Money)}.
   *
   * <ul>
   *   <li>Then {@link OfferImpl} {@link OfferImpl#orderMinSubTotal} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#setOrderMinSubTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setOrderMinSubTotal(Money)"})
  public void testSetOrderMinSubTotal_thenOfferImplOrderMinSubTotalIsBigDecimalWith000() {
    // Arrange
    Money orderMinSubTotal = new Money();

    // Act
    offerImpl.setOrderMinSubTotal(orderMinSubTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), offerImpl.orderMinSubTotal);
    BigDecimal bigDecimal = offerImpl.orderMinSubTotal;
    Money absResult = orderMinSubTotal.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = orderMinSubTotal.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link OfferImpl#setOrderMinSubTotal(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OfferImpl} {@link OfferImpl#orderMinSubTotal} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#setOrderMinSubTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setOrderMinSubTotal(Money)"})
  public void testSetOrderMinSubTotal_whenNull_thenOfferImplOrderMinSubTotalIsNull() {
    // Arrange and Act
    offerImpl.setOrderMinSubTotal(null);

    // Assert that nothing has changed
    assertNull(offerImpl.orderMinSubTotal);
  }

  /**
   * Test {@link OfferImpl#getTargetMinSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} TargetMinSubTotal is {@link Money#Money()}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getTargetMinSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OfferImpl.getTargetMinSubTotal()"})
  public void testGetTargetMinSubTotal_givenOfferImplTargetMinSubTotalIsMoney_thenReturnMoney() {
    // Arrange
    Money targetMinSubTotal = new Money();
    offerImpl.setTargetMinSubTotal(targetMinSubTotal);

    // Act and Assert
    assertEquals(targetMinSubTotal, offerImpl.getTargetMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getTargetMinSubTotal()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getTargetMinSubTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money OfferImpl.getTargetMinSubTotal()"})
  public void testGetTargetMinSubTotal_givenOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(offerImpl.getTargetMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#setTargetMinSubTotal(Money)}.
   *
   * <ul>
   *   <li>Then {@link OfferImpl} {@link OfferImpl#targetMinSubTotal} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#setTargetMinSubTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setTargetMinSubTotal(Money)"})
  public void testSetTargetMinSubTotal_thenOfferImplTargetMinSubTotalIsBigDecimalWith000() {
    // Arrange
    Money targetMinSubTotal = new Money();

    // Act
    offerImpl.setTargetMinSubTotal(targetMinSubTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), offerImpl.targetMinSubTotal);
    BigDecimal bigDecimal = offerImpl.targetMinSubTotal;
    Money absResult = targetMinSubTotal.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = targetMinSubTotal.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link OfferImpl#setTargetMinSubTotal(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OfferImpl} {@link OfferImpl#targetMinSubTotal} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#setTargetMinSubTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.setTargetMinSubTotal(Money)"})
  public void testSetTargetMinSubTotal_whenNull_thenOfferImplTargetMinSubTotalIsNull() {
    // Arrange and Act
    offerImpl.setTargetMinSubTotal(null);

    // Assert that nothing has changed
    assertNull(offerImpl.targetMinSubTotal);
  }

  /**
   * Test {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}.
   *
   * <p>Method under test: {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferImpl.getRequiresRelatedTargetAndQualifiers()"})
  public void testGetRequiresRelatedTargetAndQualifiers() {
    // Arrange
    offerImpl.setRequiresRelatedTargetAndQualifiers(null);

    // Act and Assert
    assertFalse(offerImpl.getRequiresRelatedTargetAndQualifiers());
  }

  /**
   * Test {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferImpl.getRequiresRelatedTargetAndQualifiers()"})
  public void testGetRequiresRelatedTargetAndQualifiers_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerImpl.getRequiresRelatedTargetAndQualifiers());
  }

  /**
   * Test {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OfferImpl.getRequiresRelatedTargetAndQualifiers()"})
  public void testGetRequiresRelatedTargetAndQualifiers_thenReturnTrue() {
    // Arrange
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);

    // Act and Assert
    assertTrue(offerImpl.getRequiresRelatedTargetAndQualifiers());
  }

  /**
   * Test {@link OfferImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link OfferImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OfferImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(offerImpl.getMainEntityName());
  }

  /**
   * Test {@link OfferImpl#getAdjustmentType()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@link OfferAdjustmentType#ORDER_DISCOUNT}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getAdjustmentType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferAdjustmentType OfferImpl.getAdjustmentType()"})
  public void testGetAdjustmentType_givenOfferImpl_thenReturnOrder_discount() {
    // Arrange, Act and Assert
    assertSame(OfferAdjustmentType.ORDER_DISCOUNT, offerImpl.getAdjustmentType());
  }

  /**
   * Test {@link OfferImpl#getAdjustmentType()}.
   *
   * <ul>
   *   <li>Then return {@link OfferAdjustmentType#FUTURE_CREDIT}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#getAdjustmentType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferAdjustmentType OfferImpl.getAdjustmentType()"})
  public void testGetAdjustmentType_thenReturnFuture_credit() {
    // Arrange
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);

    // Act and Assert
    assertSame(OfferAdjustmentType.FUTURE_CREDIT, offerImpl.getAdjustmentType());
  }

  /**
   * Test {@link OfferImpl#isFutureCredit()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} AdjustmentType is {@link OfferAdjustmentType#FUTURE_CREDIT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isFutureCredit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isFutureCredit()"})
  public void testIsFutureCredit_givenOfferImplAdjustmentTypeIsFuture_credit_thenReturnTrue() {
    // Arrange
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);

    // Act and Assert
    assertTrue(offerImpl.isFutureCredit());
  }

  /**
   * Test {@link OfferImpl#isFutureCredit()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#isFutureCredit()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.isFutureCredit()"})
  public void testIsFutureCredit_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(offerImpl.isFutureCredit());
  }

  /**
   * Test {@link OfferImpl#equals(Object)}, and {@link OfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferImpl#equals(Object)}
   *   <li>{@link OfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.equals(Object)", "int OfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl2.setApplyDiscountToSalePrice(true);
    offerImpl2.setApplyToChildItems(true);
    offerImpl2.setAutomaticallyAdded(true);
    offerImpl2.setCombinableWithOtherOffers(true);
    offerImpl2.setDescription("The characteristics of someone or something");
    offerImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl2.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setId(OfferImpl.serialVersionUID);
    offerImpl2.setMarketingMessage("Marketing Message");
    offerImpl2.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offerImpl2.setMaxUsesPerOrder(3);
    offerImpl2.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offerImpl2.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offerImpl2.setName("Name");
    offerImpl2.setOfferCodes(new ArrayList<>());
    offerImpl2.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl2.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl2.setOfferMatchRulesXref(new HashMap<>());
    offerImpl2.setOfferPriceData(new ArrayList<>());
    offerImpl2.setOrderMinSubTotal(new Money());
    offerImpl2.setPriority(1);
    offerImpl2.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl2.setQualifyingItemSubTotal(new Money());
    offerImpl2.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl2.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl2.setTargetMinSubTotal(new Money());
    offerImpl2.setTargetSystem("Target System");
    offerImpl2.setTotalitarianOffer(true);
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(offerImpl, offerImpl2);
    assertEquals(offerImpl.hashCode(), offerImpl2.hashCode());
  }

  /**
   * Test {@link OfferImpl#equals(Object)}, and {@link OfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferImpl#equals(Object)}
   *   <li>{@link OfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.equals(Object)", "int OfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(offerImpl, offerImpl);
    int expectedHashCodeResult = offerImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerImpl.hashCode());
  }

  /**
   * Test {@link OfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.equals(Object)", "int OfferImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    offerImpl.setId(2L);
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

    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl2.setApplyDiscountToSalePrice(true);
    offerImpl2.setApplyToChildItems(true);
    offerImpl2.setAutomaticallyAdded(true);
    offerImpl2.setCombinableWithOtherOffers(true);
    offerImpl2.setDescription("The characteristics of someone or something");
    offerImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl2.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setId(OfferImpl.serialVersionUID);
    offerImpl2.setMarketingMessage("Marketing Message");
    offerImpl2.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offerImpl2.setMaxUsesPerOrder(3);
    offerImpl2.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offerImpl2.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offerImpl2.setName("Name");
    offerImpl2.setOfferCodes(new ArrayList<>());
    offerImpl2.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl2.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offerImpl2.setOfferMatchRulesXref(new HashMap<>());
    offerImpl2.setOfferPriceData(new ArrayList<>());
    offerImpl2.setOrderMinSubTotal(new Money());
    offerImpl2.setPriority(1);
    offerImpl2.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl2.setQualifyingItemSubTotal(new Money());
    offerImpl2.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl2.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl2.setTargetMinSubTotal(new Money());
    offerImpl2.setTargetSystem("Target System");
    offerImpl2.setTotalitarianOffer(true);
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(offerImpl, offerImpl2);
  }

  /**
   * Test {@link OfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.equals(Object)", "int OfferImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(offerImpl, null);
  }

  /**
   * Test {@link OfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferImpl.equals(Object)", "int OfferImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(offerImpl, "Different type to OfferImpl");
  }

  /**
   * Test {@link OfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link OfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse OfferImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new OfferImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Offer> actualCreateOrRetrieveCopyInstanceResult =
        offerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link OfferImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OfferImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferImpl.<init>()"})
  public void testNewOfferImpl() {
    // Arrange and Act
    OfferImpl actualOfferImpl = new OfferImpl();

    // Assert
    assertEquals('N', actualOfferImpl.getArchived().charValue());
    assertNull(actualOfferImpl.maxUsesPerOrder);
    assertNull(actualOfferImpl.priority);
    assertNull(actualOfferImpl.getId());
    assertNull(actualOfferImpl.getMinimumDaysPerUsage());
    assertNull(actualOfferImpl.maxUsesPerCustomer);
    assertNull(actualOfferImpl.getDescription());
    assertNull(actualOfferImpl.getMainEntityName());
    assertNull(actualOfferImpl.getMarketingMessage());
    assertNull(actualOfferImpl.getName());
    assertNull(actualOfferImpl.getTargetSystem());
    assertNull(actualOfferImpl.adjustmentType);
    assertNull(actualOfferImpl.discountType);
    assertNull(actualOfferImpl.marketingMessage);
    assertNull(actualOfferImpl.maxUsesStrategy);
    assertNull(actualOfferImpl.offerItemQualifierRuleType);
    assertNull(actualOfferImpl.offerItemTargetRuleType);
    assertNull(actualOfferImpl.type);
    assertNull(actualOfferImpl.getValue());
    assertNull(actualOfferImpl.orderMinSubTotal);
    assertNull(actualOfferImpl.qualifyingItemSubTotal);
    assertNull(actualOfferImpl.targetMinSubTotal);
    assertNull(actualOfferImpl.getEndDate());
    assertNull(actualOfferImpl.getStartDate());
    assertNull(actualOfferImpl.startDate);
    assertNull(actualOfferImpl.getOrderMinSubTotal());
    assertNull(actualOfferImpl.getQualifyingItemSubTotal());
    assertNull(actualOfferImpl.getTargetMinSubTotal());
    assertNull(actualOfferImpl.getMaxUsesStrategyType());
    assertNull(actualOfferImpl.getDiscountType());
    assertNull(actualOfferImpl.getType());
    assertEquals(0, actualOfferImpl.getMaxUsesPerOrder());
    assertEquals(0L, actualOfferImpl.getMaxUsesPerCustomer().longValue());
    assertEquals(2147483646, actualOfferImpl.getPriority());
    assertFalse(actualOfferImpl.getApplyToChildItems());
    assertFalse(actualOfferImpl.getRequiresRelatedTargetAndQualifiers());
    assertFalse(actualOfferImpl.getUseListForDiscounts());
    assertFalse(actualOfferImpl.isFutureCredit());
    assertFalse(actualOfferImpl.isLimitedUsePerOrder());
    assertFalse(actualOfferImpl.applyToChildItems);
    assertFalse(actualOfferImpl.automaticallyAdded);
    assertFalse(actualOfferImpl.requiresRelatedTargetAndQualifiers);
    assertFalse(actualOfferImpl.totalitarianOffer);
    assertFalse(actualOfferImpl.useListForDiscounts);
    assertTrue(actualOfferImpl.getOfferCodes().isEmpty());
    assertTrue(actualOfferImpl.getOfferPriceData().isEmpty());
    assertTrue(actualOfferImpl.getOfferMatchRulesXref().isEmpty());
    assertTrue(actualOfferImpl.getQualifyingItemCriteriaXref().isEmpty());
    assertTrue(actualOfferImpl.getTargetItemCriteriaXref().isEmpty());
    assertTrue(actualOfferImpl.legacyQualifyingItemCriteria.isEmpty());
    assertTrue(actualOfferImpl.legacyTargetItemCriteria.isEmpty());
    assertTrue(actualOfferImpl.targetItemCriteria.isEmpty());
    assertTrue(actualOfferImpl.getApplyDiscountToSalePrice());
    assertTrue(actualOfferImpl.getCombinableWithOtherOffers());
    assertTrue(actualOfferImpl.isUnlimitedUsePerOrder());
    assertTrue(actualOfferImpl.applyToSalePrice);
    assertTrue(actualOfferImpl.combinableWithOtherOffers);
  }
}
