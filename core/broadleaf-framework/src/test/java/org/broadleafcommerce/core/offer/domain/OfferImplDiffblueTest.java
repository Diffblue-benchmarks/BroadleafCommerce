/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
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
import org.mockito.Mockito;

public class OfferImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    offerImpl.setDescription("The characteristics of someone or something");
    Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Set<OfferQualifyingCriteriaXref> actualQualifyingItemCriteriaXref = offerImpl.getQualifyingItemCriteriaXref();
    String actualTargetSystem = offerImpl.getTargetSystem();
    BigDecimal actualValue = offerImpl.getValue();

    // Assert that nothing has changed
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
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getType()}
   */
  @Test
  public void testGetType_givenOfferImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getType());
  }

  /**
   * Test {@link OfferImpl#getDiscountType()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getDiscountType()}
   */
  @Test
  public void testGetDiscountType_givenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getDiscountType());
  }

  /**
   * Test {@link OfferImpl#getDiscountType()}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getDiscountType()}
   */
  @Test
  public void testGetDiscountType_givenOfferTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    OfferDiscountType actualDiscountType = offerImpl.getDiscountType();

    // Assert
    verify(type).getType();
    assertNull(actualDiscountType);
  }

  /**
   * Test {@link OfferImpl#getOfferItemQualifierRuleType()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOfferItemQualifierRuleType()}
   */
  @Test
  public void testGetOfferItemQualifierRuleType_givenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    OfferItemRestrictionRuleType actualOfferItemQualifierRuleType = offerImpl.getOfferItemQualifierRuleType();

    // Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = actualOfferItemQualifierRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, actualOfferItemQualifierRuleType);
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemTargetRuleType());
  }

  /**
   * Test {@link OfferImpl#getOfferItemQualifierRuleType()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOfferItemQualifierRuleType()}
   */
  @Test
  public void testGetOfferItemQualifierRuleType_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    OfferItemRestrictionRuleType actualOfferItemQualifierRuleType = offerImpl.getOfferItemQualifierRuleType();

    // Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = actualOfferItemQualifierRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, actualOfferItemQualifierRuleType);
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemTargetRuleType());
  }

  /**
   * Test {@link OfferImpl#getOfferItemQualifierRuleType()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOfferItemQualifierRuleType()}
   */
  @Test
  public void testGetOfferItemQualifierRuleType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    OfferItemRestrictionRuleType actualOfferItemQualifierRuleType = offerImpl.getOfferItemQualifierRuleType();

    // Assert
    verify(adjustmentType).getType();
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = actualOfferItemQualifierRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, actualOfferItemQualifierRuleType);
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemTargetRuleType());
  }

  /**
   * Test {@link OfferImpl#getOfferItemTargetRuleType()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOfferItemTargetRuleType()}
   */
  @Test
  public void testGetOfferItemTargetRuleType_givenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    OfferItemRestrictionRuleType actualOfferItemTargetRuleType = offerImpl.getOfferItemTargetRuleType();

    // Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = actualOfferItemTargetRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemQualifierRuleType());
    assertSame(offerItemRestrictionRuleType, actualOfferItemTargetRuleType);
  }

  /**
   * Test {@link OfferImpl#getOfferItemTargetRuleType()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOfferItemTargetRuleType()}
   */
  @Test
  public void testGetOfferItemTargetRuleType_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    OfferItemRestrictionRuleType actualOfferItemTargetRuleType = offerImpl.getOfferItemTargetRuleType();

    // Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = actualOfferItemTargetRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemQualifierRuleType());
    assertSame(offerItemRestrictionRuleType, actualOfferItemTargetRuleType);
  }

  /**
   * Test {@link OfferImpl#getOfferItemTargetRuleType()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOfferItemTargetRuleType()}
   */
  @Test
  public void testGetOfferItemTargetRuleType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    OfferItemRestrictionRuleType actualOfferItemTargetRuleType = offerImpl.getOfferItemTargetRuleType();

    // Assert
    verify(adjustmentType).getType();
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = actualOfferItemTargetRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, offerImpl.getOfferItemQualifierRuleType());
    assertSame(offerItemRestrictionRuleType, actualOfferItemTargetRuleType);
  }

  /**
   * Test {@link OfferImpl#getPriority()}.
   * <ul>
   *   <li>Given {@link OfferAdjustmentType} {@link OfferAdjustmentType#getType()}
   * return {@code Type}.</li>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getPriority()}
   */
  @Test
  public void testGetPriority_givenOfferAdjustmentTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setPriority(1);

    // Act
    int actualPriority = offerImpl.getPriority();

    // Assert
    verify(adjustmentType).getType();
    assertEquals(1, actualPriority);
  }

  /**
   * Test {@link OfferImpl#getPriority()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getPriority()}
   */
  @Test
  public void testGetPriority_givenOfferImplAdjustmentTypeIsFuture_credit_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setPriority(1);

    // Act and Assert
    assertEquals(1, offerImpl.getPriority());
  }

  /**
   * Test {@link OfferImpl#getPriority()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@link Integer#MAX_VALUE} less one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getPriority()}
   */
  @Test
  public void testGetPriority_givenOfferImpl_thenReturnMax_valueLessOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(2147483646, (new OfferImpl()).getPriority());
  }

  /**
   * Test {@link OfferImpl#getStartDate()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) Archived is {@code Y}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getStartDate()}
   */
  @Test
  public void testGetStartDate_givenOfferImplArchivedIsY_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setArchived('Y');

    // Act and Assert
    assertNull(offerImpl.getStartDate());
  }

  /**
   * Test {@link OfferImpl#getStartDate()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getStartDate()}
   */
  @Test
  public void testGetStartDate_givenOfferImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getStartDate());
  }

  /**
   * Test {@link OfferImpl#getApplyDiscountToSalePrice()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getApplyDiscountToSalePrice()}
   */
  @Test
  public void testGetApplyDiscountToSalePrice_givenOfferImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).getApplyDiscountToSalePrice());
  }

  /**
   * Test {@link OfferImpl#getApplyDiscountToSalePrice()}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getApplyDiscountToSalePrice()}
   */
  @Test
  public void testGetApplyDiscountToSalePrice_givenOfferTypeGetTypeReturnType_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    boolean actualApplyDiscountToSalePrice = offerImpl.getApplyDiscountToSalePrice();

    // Assert
    verify(type).getType();
    assertTrue(actualApplyDiscountToSalePrice);
  }

  /**
   * Test {@link OfferImpl#getApplyDiscountToSalePrice()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getApplyDiscountToSalePrice()}
   */
  @Test
  public void testGetApplyDiscountToSalePrice_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setApplyDiscountToSalePrice(false);
    offerImpl.setType(type);

    // Act
    boolean actualApplyDiscountToSalePrice = offerImpl.getApplyDiscountToSalePrice();

    // Assert
    verify(type).getType();
    assertFalse(actualApplyDiscountToSalePrice);
  }

  /**
   * Test {@link OfferImpl#setApplyDiscountToSalePrice(boolean)}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setApplyDiscountToSalePrice(boolean)}
   */
  @Test
  public void testSetApplyDiscountToSalePrice_givenOfferTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    offerImpl.setApplyDiscountToSalePrice(true);

    // Assert
    verify(type).getType();
  }

  /**
   * Test {@link OfferImpl#getApplyToChildItems()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getApplyToChildItems()}
   */
  @Test
  public void testGetApplyToChildItems_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setApplyToChildItems(true);

    // Act and Assert
    assertTrue(offerImpl.getApplyToChildItems());
  }

  /**
   * Test {@link OfferImpl#getApplyToChildItems()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getApplyToChildItems()}
   */
  @Test
  public void testGetApplyToChildItems_givenOfferImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).getApplyToChildItems());
  }

  /**
   * Test {@link OfferImpl#getApplyToChildItems()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getApplyToChildItems()}
   */
  @Test
  public void testGetApplyToChildItems_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setApplyToChildItems(true);

    // Act
    Boolean actualApplyToChildItems = offerImpl.getApplyToChildItems();

    // Assert
    verify(adjustmentType).getType();
    assertTrue(actualApplyToChildItems);
  }

  /**
   * Test {@link OfferImpl#setApplyToChildItems(boolean)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setApplyToChildItems(boolean)}
   */
  @Test
  public void testSetApplyToChildItems_givenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    offerImpl.setApplyToChildItems(true);

    // Assert
    assertTrue(offerImpl.getApplyToChildItems());
    assertTrue(offerImpl.applyToChildItems);
  }

  /**
   * Test {@link OfferImpl#setApplyToChildItems(boolean)}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setApplyToChildItems(boolean)}
   */
  @Test
  public void testSetApplyToChildItems_givenOfferTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    offerImpl.setApplyToChildItems(true);

    // Assert
    verify(type).getType();
    assertTrue(offerImpl.getApplyToChildItems());
    assertTrue(offerImpl.applyToChildItems);
  }

  /**
   * Test {@link OfferImpl#isCombinableWithOtherOffers()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isCombinableWithOtherOffers()}
   */
  @Test
  public void testIsCombinableWithOtherOffers_givenOfferImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).isCombinableWithOtherOffers());
  }

  /**
   * Test {@link OfferImpl#isCombinableWithOtherOffers()}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isCombinableWithOtherOffers()}
   */
  @Test
  public void testIsCombinableWithOtherOffers_givenOfferTypeGetTypeReturnType_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    boolean actualIsCombinableWithOtherOffersResult = offerImpl.isCombinableWithOtherOffers();

    // Assert
    verify(type).getType();
    assertTrue(actualIsCombinableWithOtherOffersResult);
  }

  /**
   * Test {@link OfferImpl#isCombinableWithOtherOffers()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isCombinableWithOtherOffers()}
   */
  @Test
  public void testIsCombinableWithOtherOffers_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setCombinableWithOtherOffers(false);
    offerImpl.setType(type);

    // Act
    boolean actualIsCombinableWithOtherOffersResult = offerImpl.isCombinableWithOtherOffers();

    // Assert
    verify(type).getType();
    assertFalse(actualIsCombinableWithOtherOffersResult);
  }

  /**
   * Test {@link OfferImpl#setCombinableWithOtherOffers(boolean)}.
   * <ul>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setCombinableWithOtherOffers(boolean)}
   */
  @Test
  public void testSetCombinableWithOtherOffers_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    offerImpl.setCombinableWithOtherOffers(true);

    // Assert
    verify(type).getType();
  }

  /**
   * Test {@link OfferImpl#getCombinableWithOtherOffers()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getCombinableWithOtherOffers()}
   */
  @Test
  public void testGetCombinableWithOtherOffers_givenOfferImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).getCombinableWithOtherOffers());
  }

  /**
   * Test {@link OfferImpl#getCombinableWithOtherOffers()}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getCombinableWithOtherOffers()}
   */
  @Test
  public void testGetCombinableWithOtherOffers_givenOfferTypeGetTypeReturnType_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    boolean actualCombinableWithOtherOffers = offerImpl.getCombinableWithOtherOffers();

    // Assert
    verify(type).getType();
    assertTrue(actualCombinableWithOtherOffers);
  }

  /**
   * Test {@link OfferImpl#getCombinableWithOtherOffers()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getCombinableWithOtherOffers()}
   */
  @Test
  public void testGetCombinableWithOtherOffers_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setCombinableWithOtherOffers(false);
    offerImpl.setType(type);

    // Act
    boolean actualCombinableWithOtherOffers = offerImpl.getCombinableWithOtherOffers();

    // Assert
    verify(type).getType();
    assertFalse(actualCombinableWithOtherOffers);
  }

  /**
   * Test {@link OfferImpl#isAutomaticallyAdded()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isAutomaticallyAdded()}
   */
  @Test
  public void testIsAutomaticallyAdded_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setAutomaticallyAdded(true);

    // Act and Assert
    assertTrue(offerImpl.isAutomaticallyAdded());
  }

  /**
   * Test {@link OfferImpl#isAutomaticallyAdded()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isAutomaticallyAdded()}
   */
  @Test
  public void testIsAutomaticallyAdded_givenOfferImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isAutomaticallyAdded());
  }

  /**
   * Test {@link OfferImpl#isAutomaticallyAdded()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isAutomaticallyAdded()}
   */
  @Test
  public void testIsAutomaticallyAdded_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setAutomaticallyAdded(true);

    // Act
    boolean actualIsAutomaticallyAddedResult = offerImpl.isAutomaticallyAdded();

    // Assert
    verify(adjustmentType).getType();
    assertTrue(actualIsAutomaticallyAddedResult);
  }

  /**
   * Test {@link OfferImpl#setAutomaticallyAdded(boolean)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setAutomaticallyAdded(boolean)}
   */
  @Test
  public void testSetAutomaticallyAdded_givenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    offerImpl.setAutomaticallyAdded(true);

    // Assert
    assertTrue(offerImpl.automaticallyAdded);
  }

  /**
   * Test {@link OfferImpl#setAutomaticallyAdded(boolean)}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setAutomaticallyAdded(boolean)}
   */
  @Test
  public void testSetAutomaticallyAdded_givenOfferTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    offerImpl.setAutomaticallyAdded(true);

    // Assert
    verify(type).getType();
    assertTrue(offerImpl.automaticallyAdded);
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerCustomer()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesPerCustomer()}
   */
  @Test
  public void testGetMaxUsesPerCustomer_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
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
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(OfferImpl.serialVersionUID, offerImpl.getMaxUsesPerCustomer().longValue());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerCustomer()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesPerCustomer()}
   */
  @Test
  public void testGetMaxUsesPerCustomer_givenOfferImpl_thenReturnLongValueIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0L, (new OfferImpl()).getMaxUsesPerCustomer().longValue());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerCustomer()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesPerCustomer()}
   */
  @Test
  public void testGetMaxUsesPerCustomer_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
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
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act
    Long actualMaxUsesPerCustomer = offerImpl.getMaxUsesPerCustomer();

    // Assert
    verify(adjustmentType).getType();
    assertEquals(OfferImpl.serialVersionUID, actualMaxUsesPerCustomer.longValue());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesStrategyType()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesStrategyType()}
   */
  @Test
  public void testGetMaxUsesStrategyType_givenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getMaxUsesStrategyType());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesStrategyType()}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesStrategyType()}
   */
  @Test
  public void testGetMaxUsesStrategyType_givenOfferTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    CustomerMaxUsesStrategyType actualMaxUsesStrategyType = offerImpl.getMaxUsesStrategyType();

    // Assert
    verify(type).getType();
    assertNull(actualMaxUsesStrategyType);
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerCustomer()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isUnlimitedUsePerCustomer()}
   */
  @Test
  public void testIsUnlimitedUsePerCustomer_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
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
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act and Assert
    assertFalse(offerImpl.isUnlimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerCustomer()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isUnlimitedUsePerCustomer()}
   */
  @Test
  public void testIsUnlimitedUsePerCustomer_givenOfferImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).isUnlimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerCustomer()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isUnlimitedUsePerCustomer()}
   */
  @Test
  public void testIsUnlimitedUsePerCustomer_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
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
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act
    boolean actualIsUnlimitedUsePerCustomerResult = offerImpl.isUnlimitedUsePerCustomer();

    // Assert
    verify(adjustmentType).getType();
    assertFalse(actualIsUnlimitedUsePerCustomerResult);
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerCustomer()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isLimitedUsePerCustomer()}
   */
  @Test
  public void testIsLimitedUsePerCustomer_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
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
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act and Assert
    assertTrue(offerImpl.isLimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerCustomer()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isLimitedUsePerCustomer()}
   */
  @Test
  public void testIsLimitedUsePerCustomer_givenOfferImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isLimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerCustomer()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isLimitedUsePerCustomer()}
   */
  @Test
  public void testIsLimitedUsePerCustomer_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
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
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act
    boolean actualIsLimitedUsePerCustomerResult = offerImpl.isLimitedUsePerCustomer();

    // Assert
    verify(adjustmentType).getType();
    assertTrue(actualIsLimitedUsePerCustomerResult);
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesPerOrder()}
   */
  @Test
  public void testGetMaxUsesPerOrder_givenOfferImplAdjustmentTypeIsFuture_credit_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
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
    offerImpl.setMaxUsesPerOrder(1);

    // Act and Assert
    assertEquals(1, offerImpl.getMaxUsesPerOrder());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesPerOrder()}
   */
  @Test
  public void testGetMaxUsesPerOrder_givenOfferImpl_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new OfferImpl()).getMaxUsesPerOrder());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerOrder()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesPerOrder()}
   */
  @Test
  public void testGetMaxUsesPerOrder_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
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
    offerImpl.setMaxUsesPerOrder(1);

    // Act
    int actualMaxUsesPerOrder = offerImpl.getMaxUsesPerOrder();

    // Assert
    verify(adjustmentType).getType();
    assertEquals(1, actualMaxUsesPerOrder);
  }

  /**
   * Test {@link OfferImpl#setMaxUsesPerOrder(int)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setMaxUsesPerOrder(int)}
   */
  @Test
  public void testSetMaxUsesPerOrder_givenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    offerImpl.setMaxUsesPerOrder(3);

    // Assert
    assertEquals(3, offerImpl.maxUsesPerOrder.intValue());
    assertEquals(3, offerImpl.getMaxUsesPerOrder());
    assertFalse(offerImpl.isUnlimitedUsePerOrder());
    assertTrue(offerImpl.isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#setMaxUsesPerOrder(int)}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setMaxUsesPerOrder(int)}
   */
  @Test
  public void testSetMaxUsesPerOrder_givenOfferTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    offerImpl.setMaxUsesPerOrder(3);

    // Assert
    verify(type).getType();
    assertEquals(3, offerImpl.maxUsesPerOrder.intValue());
    assertEquals(3, offerImpl.getMaxUsesPerOrder());
    assertFalse(offerImpl.isUnlimitedUsePerOrder());
    assertTrue(offerImpl.isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isUnlimitedUsePerOrder()}
   */
  @Test
  public void testIsUnlimitedUsePerOrder_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
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
    offerImpl.setMaxUsesPerOrder(0);

    // Act and Assert
    assertTrue(offerImpl.isUnlimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) MaxUsesPerOrder is
   * one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isUnlimitedUsePerOrder()}
   */
  @Test
  public void testIsUnlimitedUsePerOrder_givenOfferImplMaxUsesPerOrderIsOne_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
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
    offerImpl.setMaxUsesPerOrder(1);

    // Act and Assert
    assertFalse(offerImpl.isUnlimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isUnlimitedUsePerOrder()}
   */
  @Test
  public void testIsUnlimitedUsePerOrder_givenOfferImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).isUnlimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerOrder()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isUnlimitedUsePerOrder()}
   */
  @Test
  public void testIsUnlimitedUsePerOrder_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
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
    offerImpl.setMaxUsesPerOrder(0);

    // Act
    boolean actualIsUnlimitedUsePerOrderResult = offerImpl.isUnlimitedUsePerOrder();

    // Assert
    verify(adjustmentType).getType();
    assertTrue(actualIsUnlimitedUsePerOrderResult);
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isLimitedUsePerOrder()}
   */
  @Test
  public void testIsLimitedUsePerOrder_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
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
    offerImpl.setMaxUsesPerOrder(0);

    // Act and Assert
    assertFalse(offerImpl.isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) MaxUsesPerOrder is
   * one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isLimitedUsePerOrder()}
   */
  @Test
  public void testIsLimitedUsePerOrder_givenOfferImplMaxUsesPerOrderIsOne_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
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
    offerImpl.setMaxUsesPerOrder(1);

    // Act and Assert
    assertTrue(offerImpl.isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isLimitedUsePerOrder()}
   */
  @Test
  public void testIsLimitedUsePerOrder_givenOfferImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerOrder()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isLimitedUsePerOrder()}
   */
  @Test
  public void testIsLimitedUsePerOrder_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setId(OfferImpl.serialVersionUID);
    offerImpl.setMarketingMessage("Marketing Message");
    offerImpl.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
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
    offerImpl.setMaxUsesPerOrder(0);

    // Act
    boolean actualIsLimitedUsePerOrderResult = offerImpl.isLimitedUsePerOrder();

    // Assert
    verify(adjustmentType).getType();
    assertFalse(actualIsLimitedUsePerOrderResult);
  }

  /**
   * Test {@link OfferImpl#getMarketingMessage()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMarketingMessage()}
   */
  @Test
  public void testGetMarketingMessage_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act and Assert
    assertEquals("Marketing Message", offerImpl.getMarketingMessage());
  }

  /**
   * Test {@link OfferImpl#getMarketingMessage()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMarketingMessage()}
   */
  @Test
  public void testGetMarketingMessage_givenOfferImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getMarketingMessage());
  }

  /**
   * Test {@link OfferImpl#getMarketingMessage()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMarketingMessage()}
   */
  @Test
  public void testGetMarketingMessage_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    String actualMarketingMessage = offerImpl.getMarketingMessage();

    // Assert
    verify(adjustmentType).getType();
    assertEquals("Marketing Message", actualMarketingMessage);
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   * <p>
   * Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  public void testGetTargetItemCriteriaXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(new OfferType("ORDER_ITEM", "ORDER_ITEM", 1));

    // Act and Assert
    assertEquals(1, offerImpl.getTargetItemCriteriaXref().size());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) Type is
   * {@link OfferType#FULFILLMENT_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  public void testGetTargetItemCriteriaXref_givenOfferImplTypeIsFulfillment_group() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);

    // Act and Assert
    assertTrue(offerImpl.getTargetItemCriteriaXref().isEmpty());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) Type is
   * {@link OfferType#ORDER_ITEM}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  public void testGetTargetItemCriteriaXref_givenOfferImplTypeIsOrder_item_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(OfferType.ORDER_ITEM);

    // Act and Assert
    assertEquals(1, offerImpl.getTargetItemCriteriaXref().size());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  public void testGetTargetItemCriteriaXref_givenOfferImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).getTargetItemCriteriaXref().isEmpty());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  public void testGetTargetItemCriteriaXref_givenOfferTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    Set<OfferTargetCriteriaXref> actualTargetItemCriteriaXref = offerImpl.getTargetItemCriteriaXref();

    // Assert
    verify(type).getType();
    assertTrue(actualTargetItemCriteriaXref.isEmpty());
  }

  /**
   * Test {@link OfferImpl#isTotalitarianOffer()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isTotalitarianOffer()}
   */
  @Test
  public void testIsTotalitarianOffer_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setTotalitarianOffer(true);

    // Act and Assert
    assertTrue(offerImpl.isTotalitarianOffer());
  }

  /**
   * Test {@link OfferImpl#isTotalitarianOffer()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isTotalitarianOffer()}
   */
  @Test
  public void testIsTotalitarianOffer_givenOfferImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isTotalitarianOffer());
  }

  /**
   * Test {@link OfferImpl#isTotalitarianOffer()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isTotalitarianOffer()}
   */
  @Test
  public void testIsTotalitarianOffer_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setTotalitarianOffer(true);

    // Act
    Boolean actualIsTotalitarianOfferResult = offerImpl.isTotalitarianOffer();

    // Assert
    verify(adjustmentType).getType();
    assertTrue(actualIsTotalitarianOfferResult);
  }

  /**
   * Test {@link OfferImpl#setTotalitarianOffer(Boolean)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setTotalitarianOffer(Boolean)}
   */
  @Test
  public void testSetTotalitarianOffer_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    offerImpl.setTotalitarianOffer(null);

    // Assert
    assertFalse(offerImpl.totalitarianOffer);
  }

  /**
   * Test {@link OfferImpl#setTotalitarianOffer(Boolean)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link OfferImpl} (default constructor)
   * {@link OfferImpl#totalitarianOffer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setTotalitarianOffer(Boolean)}
   */
  @Test
  public void testSetTotalitarianOffer_givenOfferImpl_whenTrue_thenOfferImplTotalitarianOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    offerImpl.setTotalitarianOffer(true);

    // Assert
    assertTrue(offerImpl.totalitarianOffer);
  }

  /**
   * Test {@link OfferImpl#setTotalitarianOffer(Boolean)}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setTotalitarianOffer(Boolean)}
   */
  @Test
  public void testSetTotalitarianOffer_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act
    offerImpl.setTotalitarianOffer(null);

    // Assert
    verify(adjustmentType).getType();
    assertFalse(offerImpl.totalitarianOffer);
  }

  /**
   * Test {@link OfferImpl#getUseListForDiscounts()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getUseListForDiscounts()}
   */
  @Test
  public void testGetUseListForDiscounts_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setUseListForDiscounts(null);

    // Act and Assert
    assertFalse(offerImpl.getUseListForDiscounts());
  }

  /**
   * Test {@link OfferImpl#getUseListForDiscounts()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getUseListForDiscounts()}
   */
  @Test
  public void testGetUseListForDiscounts_givenOfferImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).getUseListForDiscounts());
  }

  /**
   * Test {@link OfferImpl#getUseListForDiscounts()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getUseListForDiscounts()}
   */
  @Test
  public void testGetUseListForDiscounts_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setUseListForDiscounts(null);

    // Act
    Boolean actualUseListForDiscounts = offerImpl.getUseListForDiscounts();

    // Assert
    verify(adjustmentType).getType();
    assertFalse(actualUseListForDiscounts);
  }

  /**
   * Test {@link OfferImpl#getUseListForDiscounts()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getUseListForDiscounts()}
   */
  @Test
  public void testGetUseListForDiscounts_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setUseListForDiscounts(true);

    // Act and Assert
    assertTrue(offerImpl.getUseListForDiscounts());
  }

  /**
   * Test {@link OfferImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new OfferImpl()).getArchived().charValue());
  }

  /**
   * Test {@link OfferImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenOfferTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    Character actualArchived = offerImpl.getArchived();

    // Assert
    verify(type).getType();
    assertEquals('N', actualArchived.charValue());
  }

  /**
   * Test {@link OfferImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    offerImpl.setArchived('A');

    // Assert
    assertEquals('A', offerImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', offerImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenOfferTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    offerImpl.setArchived('A');

    // Assert
    verify(type).getType();
    assertEquals('A', offerImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', offerImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferImpl#isActive()}.
   * <p>
   * Method under test: {@link OfferImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
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
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setArchived(null);

    // Act and Assert
    assertFalse(offerImpl.isActive());
  }

  /**
   * Test {@link OfferImpl#isActive()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isActive()}
   */
  @Test
  public void testIsActive_givenOfferImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isActive());
  }

  /**
   * Test {@link OfferImpl#getQualifyingItemSubTotal()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getQualifyingItemSubTotal()}
   */
  @Test
  public void testGetQualifyingItemSubTotal_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Money orderMinSubTotal = new Money();
    offerImpl.setOrderMinSubTotal(orderMinSubTotal);
    offerImpl.setPriority(1);
    offerImpl.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setQualifyingItemSubTotal(new Money());

    // Act and Assert
    assertEquals(orderMinSubTotal, offerImpl.getQualifyingItemSubTotal());
  }

  /**
   * Test {@link OfferImpl#getQualifyingItemSubTotal()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getQualifyingItemSubTotal()}
   */
  @Test
  public void testGetQualifyingItemSubTotal_givenOfferImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getQualifyingItemSubTotal());
  }

  /**
   * Test {@link OfferImpl#getQualifyingItemSubTotal()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getQualifyingItemSubTotal()}
   */
  @Test
  public void testGetQualifyingItemSubTotal_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Money orderMinSubTotal = new Money();
    offerImpl.setOrderMinSubTotal(orderMinSubTotal);
    offerImpl.setPriority(1);
    offerImpl.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setQualifyingItemSubTotal(new Money());

    // Act
    Money actualQualifyingItemSubTotal = offerImpl.getQualifyingItemSubTotal();

    // Assert
    verify(adjustmentType).getType();
    assertEquals(orderMinSubTotal, actualQualifyingItemSubTotal);
  }

  /**
   * Test {@link OfferImpl#setQualifyingItemSubTotal(Money)}.
   * <p>
   * Method under test: {@link OfferImpl#setQualifyingItemSubTotal(Money)}
   */
  @Test
  public void testSetQualifyingItemSubTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
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
    Money absResult3 = absResult2.abs();
    assertSame(bigDecimal, absResult3.getAmount());
    Money absResult4 = absResult3.abs();
    assertSame(bigDecimal, absResult4.getAmount());
    Money absResult5 = absResult4.abs();
    assertSame(bigDecimal, absResult5.getAmount());
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = qualifyingItemSubTotal.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult12 = zeroResult2.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(bigDecimal, absResult15.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(bigDecimal, absResult19.abs().getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(bigDecimal, absResult22.abs().getAmount());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertSame(bigDecimal, absResult25.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(bigDecimal, absResult28.abs().getAmount());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    Money zeroResult60 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
  }

  /**
   * Test {@link OfferImpl#setQualifyingItemSubTotal(Money)}.
   * <p>
   * Method under test: {@link OfferImpl#setQualifyingItemSubTotal(Money)}
   */
  @Test
  public void testSetQualifyingItemSubTotal2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Money orderMinSubTotal = new Money();
    offerImpl.setOrderMinSubTotal(orderMinSubTotal);
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

    // Act
    offerImpl.setQualifyingItemSubTotal(null);

    // Assert
    assertNull(offerImpl.qualifyingItemSubTotal);
    assertNull(offerImpl.getQualifyingItemSubTotal());
    Money targetMinSubTotal = offerImpl.getTargetMinSubTotal();
    Money absResult = targetMinSubTotal.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(orderMinSubTotal, absResult6.abs());
    Money absResult7 = targetMinSubTotal.zero().abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertEquals(orderMinSubTotal, absResult11.abs());
    Money zeroResult = absResult.zero();
    Money absResult12 = zeroResult.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertEquals(orderMinSubTotal, absResult15.abs());
    Money zeroResult2 = offerImpl.getOrderMinSubTotal().zero();
    Money zeroResult3 = zeroResult2.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertEquals(orderMinSubTotal, absResult19.abs());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertEquals(orderMinSubTotal, absResult22.abs());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertEquals(orderMinSubTotal, absResult25.abs());
    Money zeroResult6 = zeroResult.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertEquals(orderMinSubTotal, absResult28.abs());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertEquals(orderMinSubTotal, absResult31.abs());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertEquals(orderMinSubTotal, absResult33.abs());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertEquals(orderMinSubTotal, absResult35.abs());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertEquals(orderMinSubTotal, absResult37.abs());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertEquals(orderMinSubTotal, absResult39.abs());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertEquals(orderMinSubTotal, absResult41.abs());
    Money absResult42 = zeroResult5.zero().abs().abs();
    assertEquals(orderMinSubTotal, absResult42.abs());
    Money zeroResult13 = zeroResult6.zero();
    Money absResult43 = zeroResult13.abs();
    Money absResult44 = absResult43.abs();
    assertEquals(orderMinSubTotal, absResult44.abs());
    Money zeroResult14 = zeroResult7.zero();
    Money absResult45 = zeroResult14.abs();
    Money absResult46 = absResult45.abs();
    assertEquals(orderMinSubTotal, absResult46.abs());
    Money zeroResult15 = absResult4.zero();
    Money absResult47 = zeroResult15.abs();
    assertEquals(orderMinSubTotal, absResult47.abs());
    Money zeroResult16 = absResult9.zero();
    Money absResult48 = zeroResult16.abs();
    assertEquals(orderMinSubTotal, absResult48.abs());
    Money zeroResult17 = absResult13.zero();
    Money absResult49 = zeroResult17.abs();
    assertEquals(orderMinSubTotal, absResult49.abs());
    Money zeroResult18 = absResult17.zero();
    Money absResult50 = zeroResult18.abs();
    assertEquals(orderMinSubTotal, absResult50.abs());
    Money zeroResult19 = absResult20.zero();
    Money absResult51 = zeroResult19.abs();
    assertEquals(orderMinSubTotal, absResult51.abs());
    Money zeroResult20 = absResult23.zero();
    Money absResult52 = zeroResult20.abs();
    assertEquals(orderMinSubTotal, absResult52.abs());
    Money zeroResult21 = absResult26.zero();
    Money absResult53 = zeroResult21.abs();
    assertEquals(orderMinSubTotal, absResult53.abs());
    Money zeroResult22 = absResult29.zero();
    Money absResult54 = zeroResult22.abs();
    assertEquals(orderMinSubTotal, absResult54.abs());
    Money zeroResult23 = zeroResult8.zero();
    Money absResult55 = zeroResult23.abs();
    assertEquals(orderMinSubTotal, absResult55.abs());
    Money zeroResult24 = zeroResult9.zero();
    Money absResult56 = zeroResult24.abs();
    assertEquals(orderMinSubTotal, absResult56.abs());
    Money zeroResult25 = zeroResult10.zero();
    Money absResult57 = zeroResult25.abs();
    assertEquals(orderMinSubTotal, absResult57.abs());
    Money zeroResult26 = zeroResult11.zero();
    Money absResult58 = zeroResult26.abs();
    assertEquals(orderMinSubTotal, absResult58.abs());
    Money zeroResult27 = zeroResult12.zero();
    Money absResult59 = zeroResult27.abs();
    assertEquals(orderMinSubTotal, absResult59.abs());
    Money zeroResult28 = zeroResult2.abs().zero().zero();
    Money zeroResult29 = zeroResult28.zero();
    Money absResult60 = zeroResult29.abs();
    assertEquals(orderMinSubTotal, absResult60.abs());
    Money zeroResult30 = zeroResult13.zero();
    Money absResult61 = zeroResult30.abs();
    assertEquals(orderMinSubTotal, absResult61.abs());
    Money zeroResult31 = zeroResult14.zero();
    Money absResult62 = zeroResult31.abs();
    assertEquals(orderMinSubTotal, absResult62.abs());
    Money zeroResult32 = absResult5.zero();
    assertEquals(orderMinSubTotal, zeroResult32.abs());
    Money zeroResult33 = absResult10.zero();
    assertEquals(orderMinSubTotal, zeroResult33.abs());
    Money zeroResult34 = absResult14.zero();
    assertEquals(orderMinSubTotal, zeroResult34.abs());
    Money zeroResult35 = absResult18.zero();
    assertEquals(orderMinSubTotal, zeroResult35.abs());
    Money zeroResult36 = absResult21.zero();
    assertEquals(orderMinSubTotal, zeroResult36.abs());
    Money zeroResult37 = absResult24.zero();
    assertEquals(orderMinSubTotal, zeroResult37.abs());
    Money zeroResult38 = absResult27.zero();
    assertEquals(orderMinSubTotal, zeroResult38.abs());
    Money zeroResult39 = absResult30.zero();
    assertEquals(orderMinSubTotal, zeroResult39.abs());
    Money zeroResult40 = absResult32.zero();
    assertEquals(orderMinSubTotal, zeroResult40.abs());
    Money zeroResult41 = absResult34.zero();
    assertEquals(orderMinSubTotal, zeroResult41.abs());
    Money zeroResult42 = absResult36.zero();
    assertEquals(orderMinSubTotal, zeroResult42.abs());
    Money zeroResult43 = absResult38.zero();
    assertEquals(orderMinSubTotal, zeroResult43.abs());
    Money zeroResult44 = absResult40.zero();
    assertEquals(orderMinSubTotal, zeroResult44.abs());
    Money zeroResult45 = absResult43.zero();
    assertEquals(orderMinSubTotal, zeroResult45.abs());
    Money zeroResult46 = absResult45.zero();
    assertEquals(orderMinSubTotal, zeroResult46.abs());
    Money zeroResult47 = zeroResult15.zero();
    assertEquals(orderMinSubTotal, zeroResult47.abs());
    Money zeroResult48 = zeroResult16.zero();
    assertEquals(orderMinSubTotal, zeroResult48.abs());
    Money zeroResult49 = zeroResult17.zero();
    assertEquals(orderMinSubTotal, zeroResult49.abs());
    Money zeroResult50 = zeroResult18.zero();
    assertEquals(orderMinSubTotal, zeroResult50.abs());
    Money zeroResult51 = zeroResult19.zero();
    assertEquals(orderMinSubTotal, zeroResult51.abs());
    Money zeroResult52 = zeroResult20.zero();
    assertEquals(orderMinSubTotal, zeroResult52.abs());
    Money zeroResult53 = zeroResult21.zero();
    assertEquals(orderMinSubTotal, zeroResult53.abs());
    Money zeroResult54 = zeroResult22.zero();
    assertEquals(orderMinSubTotal, zeroResult54.abs());
    Money zeroResult55 = zeroResult23.zero();
    assertEquals(orderMinSubTotal, zeroResult55.abs());
    Money zeroResult56 = zeroResult24.zero();
    assertEquals(orderMinSubTotal, zeroResult56.abs());
    Money zeroResult57 = zeroResult25.zero();
    assertEquals(orderMinSubTotal, zeroResult57.abs());
    Money zeroResult58 = zeroResult26.zero();
    assertEquals(orderMinSubTotal, zeroResult58.abs());
    Money zeroResult59 = zeroResult27.zero();
    assertEquals(orderMinSubTotal, zeroResult59.abs());
    Money zeroResult60 = zeroResult29.zero();
    assertEquals(orderMinSubTotal, zeroResult60.abs());
    Money zeroResult61 = zeroResult30.zero();
    assertEquals(orderMinSubTotal, zeroResult61.abs());
    Money zeroResult62 = zeroResult31.zero();
    assertEquals(orderMinSubTotal, zeroResult62.abs());
    assertEquals(orderMinSubTotal, absResult6.zero());
    assertEquals(orderMinSubTotal, absResult11.zero());
    assertEquals(orderMinSubTotal, absResult15.zero());
    assertEquals(orderMinSubTotal, absResult19.zero());
    assertEquals(orderMinSubTotal, absResult22.zero());
    assertEquals(orderMinSubTotal, absResult25.zero());
    assertEquals(orderMinSubTotal, absResult28.zero());
    assertEquals(orderMinSubTotal, absResult31.zero());
    assertEquals(orderMinSubTotal, absResult33.zero());
    assertEquals(orderMinSubTotal, absResult35.zero());
    assertEquals(orderMinSubTotal, absResult37.zero());
    assertEquals(orderMinSubTotal, absResult39.zero());
    assertEquals(orderMinSubTotal, absResult41.zero());
    assertEquals(orderMinSubTotal, absResult44.zero());
    assertEquals(orderMinSubTotal, absResult46.zero());
    assertEquals(orderMinSubTotal, absResult47.zero());
    assertEquals(orderMinSubTotal, absResult48.zero());
    assertEquals(orderMinSubTotal, absResult49.zero());
    assertEquals(orderMinSubTotal, absResult50.zero());
    assertEquals(orderMinSubTotal, absResult51.zero());
    assertEquals(orderMinSubTotal, absResult52.zero());
    assertEquals(orderMinSubTotal, absResult53.zero());
    assertEquals(orderMinSubTotal, absResult54.zero());
    assertEquals(orderMinSubTotal, absResult55.zero());
    assertEquals(orderMinSubTotal, absResult56.zero());
    assertEquals(orderMinSubTotal, absResult57.zero());
    assertEquals(orderMinSubTotal, absResult58.zero());
    assertEquals(orderMinSubTotal, absResult59.zero());
    assertEquals(orderMinSubTotal, absResult60.zero());
    assertEquals(orderMinSubTotal, absResult61.zero());
    assertEquals(orderMinSubTotal, absResult62.zero());
    assertEquals(orderMinSubTotal, zeroResult32.zero());
    assertEquals(orderMinSubTotal, zeroResult33.zero());
    assertEquals(orderMinSubTotal, zeroResult34.zero());
    assertEquals(orderMinSubTotal, zeroResult35.zero());
    assertEquals(orderMinSubTotal, zeroResult36.zero());
    assertEquals(orderMinSubTotal, zeroResult37.zero());
    assertEquals(orderMinSubTotal, zeroResult38.zero());
    assertEquals(orderMinSubTotal, zeroResult39.zero());
    assertEquals(orderMinSubTotal, zeroResult40.zero());
    assertEquals(orderMinSubTotal, zeroResult41.zero());
    assertEquals(orderMinSubTotal, zeroResult42.zero());
    assertEquals(orderMinSubTotal, zeroResult43.zero());
    assertEquals(orderMinSubTotal, zeroResult44.zero());
    assertEquals(orderMinSubTotal, zeroResult28.abs().zero().zero());
    assertEquals(orderMinSubTotal, zeroResult45.zero());
    assertEquals(orderMinSubTotal, zeroResult46.zero());
    assertEquals(orderMinSubTotal, zeroResult47.zero());
    assertEquals(orderMinSubTotal, zeroResult48.zero());
    assertEquals(orderMinSubTotal, zeroResult49.zero());
    assertEquals(orderMinSubTotal, zeroResult50.zero());
    assertEquals(orderMinSubTotal, zeroResult51.zero());
    assertEquals(orderMinSubTotal, zeroResult52.zero());
    assertEquals(orderMinSubTotal, zeroResult53.zero());
    assertEquals(orderMinSubTotal, zeroResult54.zero());
    assertEquals(orderMinSubTotal, zeroResult55.zero());
    assertEquals(orderMinSubTotal, zeroResult56.zero());
    assertEquals(orderMinSubTotal, zeroResult57.zero());
    assertEquals(orderMinSubTotal, zeroResult58.zero());
    assertEquals(orderMinSubTotal, zeroResult59.zero());
    assertEquals(orderMinSubTotal, zeroResult60.zero());
    assertEquals(orderMinSubTotal, zeroResult61.zero());
    assertEquals(orderMinSubTotal, zeroResult62.zero());
    BigDecimal bigDecimal = offerImpl.targetMinSubTotal;
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult62.getAmount());
  }

  /**
   * Test {@link OfferImpl#setQualifyingItemSubTotal(Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setQualifyingItemSubTotal(Money)}
   */
  @Test
  public void testSetQualifyingItemSubTotal_whenMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    offerImpl.setQualifyingItemSubTotal(mock(Money.class));

    // Assert
    assertNull(offerImpl.qualifyingItemSubTotal);
    assertNull(offerImpl.getQualifyingItemSubTotal());
  }

  /**
   * Test {@link OfferImpl#getOrderMinSubTotal()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOrderMinSubTotal()}
   */
  @Test
  public void testGetOrderMinSubTotal_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setPriority(1);
    offerImpl.setQualifyingItemCriteriaXref(new HashSet<>());
    Money qualifyingItemSubTotal = new Money();
    offerImpl.setQualifyingItemSubTotal(qualifyingItemSubTotal);
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setOrderMinSubTotal(new Money());

    // Act and Assert
    assertEquals(qualifyingItemSubTotal, offerImpl.getOrderMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getOrderMinSubTotal()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOrderMinSubTotal()}
   */
  @Test
  public void testGetOrderMinSubTotal_givenOfferImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getOrderMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getOrderMinSubTotal()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOrderMinSubTotal()}
   */
  @Test
  public void testGetOrderMinSubTotal_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setPriority(1);
    offerImpl.setQualifyingItemCriteriaXref(new HashSet<>());
    Money qualifyingItemSubTotal = new Money();
    offerImpl.setQualifyingItemSubTotal(qualifyingItemSubTotal);
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setOrderMinSubTotal(new Money());

    // Act
    Money actualOrderMinSubTotal = offerImpl.getOrderMinSubTotal();

    // Assert
    verify(adjustmentType).getType();
    assertEquals(qualifyingItemSubTotal, actualOrderMinSubTotal);
  }

  /**
   * Test {@link OfferImpl#setOrderMinSubTotal(Money)}.
   * <p>
   * Method under test: {@link OfferImpl#setOrderMinSubTotal(Money)}
   */
  @Test
  public void testSetOrderMinSubTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Money orderMinSubTotal = new Money();
    offerImpl.setOrderMinSubTotal(orderMinSubTotal);
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

    // Act
    offerImpl.setOrderMinSubTotal(null);

    // Assert
    Money qualifyingItemSubTotal = offerImpl.getQualifyingItemSubTotal();
    Currency currency = qualifyingItemSubTotal.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(offerImpl.orderMinSubTotal);
    assertNull(offerImpl.getOrderMinSubTotal());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    Money absResult = qualifyingItemSubTotal.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(orderMinSubTotal, absResult6.abs());
    Money targetMinSubTotal = offerImpl.getTargetMinSubTotal();
    Money absResult7 = targetMinSubTotal.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    Money absResult12 = absResult11.abs();
    assertEquals(orderMinSubTotal, absResult12.abs());
    Money zeroResult = qualifyingItemSubTotal.zero();
    Money absResult13 = zeroResult.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    Money absResult16 = absResult15.abs();
    Money absResult17 = absResult16.abs();
    assertEquals(orderMinSubTotal, absResult17.abs());
    Money zeroResult2 = targetMinSubTotal.zero();
    Money absResult18 = zeroResult2.abs();
    Money absResult19 = absResult18.abs();
    Money absResult20 = absResult19.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertEquals(orderMinSubTotal, absResult22.abs());
    Money zeroResult3 = absResult.zero();
    Money absResult23 = zeroResult3.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertEquals(orderMinSubTotal, absResult26.abs());
    Money zeroResult4 = absResult7.zero();
    Money absResult27 = zeroResult4.abs();
    Money absResult28 = absResult27.abs();
    Money absResult29 = absResult28.abs();
    Money absResult30 = absResult29.abs();
    assertEquals(orderMinSubTotal, absResult30.abs());
    Money zeroResult5 = zeroResult.zero();
    Money absResult31 = zeroResult5.abs();
    Money absResult32 = absResult31.abs();
    Money absResult33 = absResult32.abs();
    Money absResult34 = absResult33.abs();
    assertEquals(orderMinSubTotal, absResult34.abs());
    Money zeroResult6 = absResult2.zero();
    Money absResult35 = zeroResult6.abs();
    Money absResult36 = absResult35.abs();
    Money absResult37 = absResult36.abs();
    assertEquals(orderMinSubTotal, absResult37.abs());
    Money zeroResult7 = absResult8.zero();
    Money absResult38 = zeroResult7.abs();
    Money absResult39 = absResult38.abs();
    Money absResult40 = absResult39.abs();
    assertEquals(orderMinSubTotal, absResult40.abs());
    Money zeroResult8 = absResult13.zero();
    Money absResult41 = zeroResult8.abs();
    Money absResult42 = absResult41.abs();
    Money absResult43 = absResult42.abs();
    assertEquals(orderMinSubTotal, absResult43.abs());
    Money zeroResult9 = absResult18.zero();
    Money absResult44 = zeroResult9.abs();
    Money absResult45 = absResult44.abs();
    Money absResult46 = absResult45.abs();
    assertEquals(orderMinSubTotal, absResult46.abs());
    Money zeroResult10 = zeroResult3.zero();
    Money absResult47 = zeroResult10.abs();
    Money absResult48 = absResult47.abs();
    Money absResult49 = absResult48.abs();
    assertEquals(orderMinSubTotal, absResult49.abs());
    Money zeroResult11 = zeroResult4.zero();
    Money absResult50 = zeroResult11.abs();
    Money absResult51 = absResult50.abs();
    Money absResult52 = absResult51.abs();
    assertEquals(orderMinSubTotal, absResult52.abs());
    Money zeroResult12 = zeroResult5.zero();
    Money absResult53 = zeroResult12.abs();
    Money absResult54 = absResult53.abs();
    Money absResult55 = absResult54.abs();
    assertEquals(orderMinSubTotal, absResult55.abs());
    Money zeroResult13 = absResult3.zero();
    Money absResult56 = zeroResult13.abs();
    Money absResult57 = absResult56.abs();
    assertEquals(orderMinSubTotal, absResult57.abs());
    Money zeroResult14 = absResult9.zero();
    Money absResult58 = zeroResult14.abs();
    Money absResult59 = absResult58.abs();
    assertEquals(orderMinSubTotal, absResult59.abs());
    Money zeroResult15 = absResult14.zero();
    Money absResult60 = zeroResult15.abs();
    Money absResult61 = absResult60.abs();
    assertEquals(orderMinSubTotal, absResult61.abs());
    Money zeroResult16 = absResult19.zero();
    Money absResult62 = zeroResult16.abs();
    Money absResult63 = absResult62.abs();
    assertEquals(orderMinSubTotal, absResult63.abs());
    Money zeroResult17 = absResult23.zero();
    Money absResult64 = zeroResult17.abs();
    Money absResult65 = absResult64.abs();
    assertEquals(orderMinSubTotal, absResult65.abs());
    Money zeroResult18 = absResult27.zero();
    Money absResult66 = zeroResult18.abs();
    Money absResult67 = absResult66.abs();
    assertEquals(orderMinSubTotal, absResult67.abs());
    Money zeroResult19 = absResult31.zero();
    Money absResult68 = zeroResult19.abs();
    Money absResult69 = absResult68.abs();
    assertEquals(orderMinSubTotal, absResult69.abs());
    Money zeroResult20 = zeroResult6.zero();
    Money absResult70 = zeroResult20.abs();
    Money absResult71 = absResult70.abs();
    assertEquals(orderMinSubTotal, absResult71.abs());
    Money zeroResult21 = zeroResult7.zero();
    Money absResult72 = zeroResult21.abs();
    Money absResult73 = absResult72.abs();
    assertEquals(orderMinSubTotal, absResult73.abs());
    Money zeroResult22 = zeroResult8.zero();
    Money absResult74 = zeroResult22.abs();
    Money absResult75 = absResult74.abs();
    assertEquals(orderMinSubTotal, absResult75.abs());
    Money zeroResult23 = zeroResult9.zero();
    Money absResult76 = zeroResult23.abs();
    Money absResult77 = absResult76.abs();
    assertEquals(orderMinSubTotal, absResult77.abs());
    Money zeroResult24 = zeroResult10.zero();
    Money absResult78 = zeroResult24.abs();
    Money absResult79 = absResult78.abs();
    assertEquals(orderMinSubTotal, absResult79.abs());
    Money zeroResult25 = zeroResult11.zero();
    Money absResult80 = zeroResult25.abs();
    Money absResult81 = absResult80.abs();
    assertEquals(orderMinSubTotal, absResult81.abs());
    Money zeroResult26 = zeroResult12.zero();
    Money absResult82 = zeroResult26.abs();
    Money absResult83 = absResult82.abs();
    assertEquals(orderMinSubTotal, absResult83.abs());
    Money zeroResult27 = absResult4.zero();
    Money absResult84 = zeroResult27.abs();
    assertEquals(orderMinSubTotal, absResult84.abs());
    Money zeroResult28 = absResult10.zero();
    Money absResult85 = zeroResult28.abs();
    assertEquals(orderMinSubTotal, absResult85.abs());
    Money zeroResult29 = absResult15.zero();
    Money absResult86 = zeroResult29.abs();
    assertEquals(orderMinSubTotal, absResult86.abs());
    Money zeroResult30 = absResult20.zero();
    Money absResult87 = zeroResult30.abs();
    assertEquals(orderMinSubTotal, absResult87.abs());
    Money zeroResult31 = absResult24.zero();
    Money absResult88 = zeroResult31.abs();
    assertEquals(orderMinSubTotal, absResult88.abs());
    Money zeroResult32 = absResult28.zero();
    Money absResult89 = zeroResult32.abs();
    assertEquals(orderMinSubTotal, absResult89.abs());
    Money zeroResult33 = absResult32.zero();
    Money absResult90 = zeroResult33.abs();
    assertEquals(orderMinSubTotal, absResult90.abs());
    Money zeroResult34 = absResult35.zero();
    Money absResult91 = zeroResult34.abs();
    assertEquals(orderMinSubTotal, absResult91.abs());
    Money zeroResult35 = absResult38.zero();
    Money absResult92 = zeroResult35.abs();
    assertEquals(orderMinSubTotal, absResult92.abs());
    Money zeroResult36 = absResult41.zero();
    Money absResult93 = zeroResult36.abs();
    assertEquals(orderMinSubTotal, absResult93.abs());
    Money zeroResult37 = absResult44.zero();
    Money absResult94 = zeroResult37.abs();
    assertEquals(orderMinSubTotal, absResult94.abs());
    Money zeroResult38 = absResult47.zero();
    Money absResult95 = zeroResult38.abs();
    assertEquals(orderMinSubTotal, absResult95.abs());
    Money zeroResult39 = absResult50.zero();
    Money absResult96 = zeroResult39.abs();
    assertEquals(orderMinSubTotal, absResult96.abs());
    Money zeroResult40 = absResult53.zero();
    Money absResult97 = zeroResult40.abs();
    assertEquals(orderMinSubTotal, absResult97.abs());
    Money zeroResult41 = zeroResult13.zero();
    Money absResult98 = zeroResult41.abs();
    assertEquals(orderMinSubTotal, absResult98.abs());
    Money zeroResult42 = zeroResult14.zero();
    Money absResult99 = zeroResult42.abs();
    assertEquals(orderMinSubTotal, absResult99.abs());
    Money zeroResult43 = zeroResult15.zero();
    Money absResult100 = zeroResult43.abs();
    assertEquals(orderMinSubTotal, absResult100.abs());
    Money zeroResult44 = zeroResult16.zero();
    Money absResult101 = zeroResult44.abs();
    assertEquals(orderMinSubTotal, absResult101.abs());
    Money zeroResult45 = zeroResult17.zero();
    Money absResult102 = zeroResult45.abs();
    assertEquals(orderMinSubTotal, absResult102.abs());
    Money zeroResult46 = zeroResult18.zero();
    Money absResult103 = zeroResult46.abs();
    assertEquals(orderMinSubTotal, absResult103.abs());
    Money zeroResult47 = zeroResult19.zero();
    Money absResult104 = zeroResult47.abs();
    assertEquals(orderMinSubTotal, absResult104.abs());
    Money zeroResult48 = zeroResult20.zero();
    Money absResult105 = zeroResult48.abs();
    assertEquals(orderMinSubTotal, absResult105.abs());
    Money zeroResult49 = zeroResult21.zero();
    Money absResult106 = zeroResult49.abs();
    assertEquals(orderMinSubTotal, absResult106.abs());
    Money zeroResult50 = zeroResult22.zero();
    Money absResult107 = zeroResult50.abs();
    assertEquals(orderMinSubTotal, absResult107.abs());
    Money zeroResult51 = zeroResult24.zero();
    Money absResult108 = zeroResult51.abs();
    assertEquals(orderMinSubTotal, absResult108.abs());
    Money zeroResult52 = zeroResult25.zero();
    Money absResult109 = zeroResult52.abs();
    assertEquals(orderMinSubTotal, absResult109.abs());
    Money zeroResult53 = zeroResult26.zero();
    Money absResult110 = zeroResult53.abs();
    assertEquals(orderMinSubTotal, absResult110.abs());
    Money zeroResult54 = absResult5.zero();
    assertEquals(orderMinSubTotal, zeroResult54.abs());
    Money zeroResult55 = absResult11.zero();
    assertEquals(orderMinSubTotal, zeroResult55.abs());
    Money zeroResult56 = absResult16.zero();
    assertEquals(orderMinSubTotal, zeroResult56.abs());
    Money zeroResult57 = absResult21.zero();
    assertEquals(orderMinSubTotal, zeroResult57.abs());
    Money zeroResult58 = absResult25.zero();
    assertEquals(orderMinSubTotal, zeroResult58.abs());
    Money zeroResult59 = absResult29.zero();
    assertEquals(orderMinSubTotal, zeroResult59.abs());
    Money zeroResult60 = absResult33.zero();
    assertEquals(orderMinSubTotal, zeroResult60.abs());
    Money zeroResult61 = absResult36.zero();
    assertEquals(orderMinSubTotal, zeroResult61.abs());
    Money zeroResult62 = absResult39.zero();
    assertEquals(orderMinSubTotal, zeroResult62.abs());
    Money zeroResult63 = absResult42.zero();
    assertEquals(orderMinSubTotal, zeroResult63.abs());
    Money zeroResult64 = absResult45.zero();
    assertEquals(orderMinSubTotal, zeroResult64.abs());
    Money zeroResult65 = absResult48.zero();
    assertEquals(orderMinSubTotal, zeroResult65.abs());
    Money zeroResult66 = absResult51.zero();
    assertEquals(orderMinSubTotal, zeroResult66.abs());
    Money zeroResult67 = absResult54.zero();
    assertEquals(orderMinSubTotal, zeroResult67.abs());
    Money zeroResult68 = absResult56.zero();
    assertEquals(orderMinSubTotal, zeroResult68.abs());
    Money zeroResult69 = absResult58.zero();
    assertEquals(orderMinSubTotal, zeroResult69.abs());
    Money zeroResult70 = absResult60.zero();
    assertEquals(orderMinSubTotal, zeroResult70.abs());
    Money zeroResult71 = absResult62.zero();
    assertEquals(orderMinSubTotal, zeroResult71.abs());
    Money zeroResult72 = absResult64.zero();
    assertEquals(orderMinSubTotal, zeroResult72.abs());
    Money zeroResult73 = absResult66.zero();
    assertEquals(orderMinSubTotal, zeroResult73.abs());
    Money zeroResult74 = absResult68.zero();
    assertEquals(orderMinSubTotal, zeroResult74.abs());
    Money zeroResult75 = absResult70.zero();
    assertEquals(orderMinSubTotal, zeroResult75.abs());
    Money zeroResult76 = absResult72.zero();
    assertEquals(orderMinSubTotal, zeroResult76.abs());
    Money zeroResult77 = absResult74.zero();
    assertEquals(orderMinSubTotal, zeroResult77.abs());
    Money zeroResult78 = absResult78.zero();
    assertEquals(orderMinSubTotal, zeroResult78.abs());
    Money zeroResult79 = absResult80.zero();
    assertEquals(orderMinSubTotal, zeroResult79.abs());
    Money zeroResult80 = absResult82.zero();
    assertEquals(orderMinSubTotal, zeroResult80.abs());
    Money zeroResult81 = zeroResult27.zero();
    assertEquals(orderMinSubTotal, zeroResult81.abs());
    Money zeroResult82 = zeroResult28.zero();
    assertEquals(orderMinSubTotal, zeroResult82.abs());
    Money zeroResult83 = zeroResult29.zero();
    assertEquals(orderMinSubTotal, zeroResult83.abs());
    Money zeroResult84 = zeroResult30.zero();
    assertEquals(orderMinSubTotal, zeroResult84.abs());
    Money zeroResult85 = zeroResult31.zero();
    assertEquals(orderMinSubTotal, zeroResult85.abs());
    Money zeroResult86 = zeroResult32.zero();
    assertEquals(orderMinSubTotal, zeroResult86.abs());
    Money zeroResult87 = zeroResult33.zero();
    assertEquals(orderMinSubTotal, zeroResult87.abs());
    Money zeroResult88 = zeroResult34.zero();
    assertEquals(orderMinSubTotal, zeroResult88.abs());
    Money zeroResult89 = zeroResult35.zero();
    assertEquals(orderMinSubTotal, zeroResult89.abs());
    Money zeroResult90 = zeroResult36.zero();
    assertEquals(orderMinSubTotal, zeroResult90.abs());
    Money zeroResult91 = zeroResult37.zero();
    assertEquals(orderMinSubTotal, zeroResult91.abs());
    Money zeroResult92 = zeroResult38.zero();
    assertEquals(orderMinSubTotal, zeroResult92.abs());
    Money zeroResult93 = zeroResult39.zero();
    assertEquals(orderMinSubTotal, zeroResult93.abs());
    Money zeroResult94 = zeroResult40.zero();
    assertEquals(orderMinSubTotal, zeroResult94.abs());
    Money zeroResult95 = zeroResult41.zero();
    assertEquals(orderMinSubTotal, zeroResult95.abs());
    Money zeroResult96 = zeroResult42.zero();
    assertEquals(orderMinSubTotal, zeroResult96.abs());
    Money zeroResult97 = zeroResult43.zero();
    assertEquals(orderMinSubTotal, zeroResult97.abs());
    Money zeroResult98 = zeroResult44.zero();
    assertEquals(orderMinSubTotal, zeroResult98.abs());
    Money zeroResult99 = zeroResult45.zero();
    assertEquals(orderMinSubTotal, zeroResult99.abs());
    Money zeroResult100 = zeroResult46.zero();
    assertEquals(orderMinSubTotal, zeroResult100.abs());
    Money zeroResult101 = zeroResult47.zero();
    assertEquals(orderMinSubTotal, zeroResult101.abs());
    Money zeroResult102 = zeroResult48.zero();
    assertEquals(orderMinSubTotal, zeroResult102.abs());
    Money zeroResult103 = zeroResult49.zero();
    assertEquals(orderMinSubTotal, zeroResult103.abs());
    Money zeroResult104 = zeroResult50.zero();
    assertEquals(orderMinSubTotal, zeroResult104.abs());
    Money zeroResult105 = zeroResult51.zero();
    assertEquals(orderMinSubTotal, zeroResult105.abs());
    Money zeroResult106 = zeroResult52.zero();
    assertEquals(orderMinSubTotal, zeroResult106.abs());
    Money zeroResult107 = zeroResult53.zero();
    assertEquals(orderMinSubTotal, zeroResult107.abs());
    assertEquals(orderMinSubTotal, absResult6.zero());
    assertEquals(orderMinSubTotal, absResult12.zero());
    assertEquals(orderMinSubTotal, absResult17.zero());
    assertEquals(orderMinSubTotal, absResult22.zero());
    assertEquals(orderMinSubTotal, absResult26.zero());
    assertEquals(orderMinSubTotal, absResult30.zero());
    assertEquals(orderMinSubTotal, absResult34.zero());
    assertEquals(orderMinSubTotal, absResult37.zero());
    assertEquals(orderMinSubTotal, absResult40.zero());
    assertEquals(orderMinSubTotal, absResult43.zero());
    assertEquals(orderMinSubTotal, absResult46.zero());
    assertEquals(orderMinSubTotal, absResult49.zero());
    assertEquals(orderMinSubTotal, absResult52.zero());
    assertEquals(orderMinSubTotal, absResult55.zero());
    assertEquals(orderMinSubTotal, absResult57.zero());
    assertEquals(orderMinSubTotal, absResult59.zero());
    assertEquals(orderMinSubTotal, absResult61.zero());
    assertEquals(orderMinSubTotal, absResult63.zero());
    assertEquals(orderMinSubTotal, absResult65.zero());
    assertEquals(orderMinSubTotal, absResult67.zero());
    assertEquals(orderMinSubTotal, absResult69.zero());
    assertEquals(orderMinSubTotal, absResult71.zero());
    assertEquals(orderMinSubTotal, absResult73.zero());
    assertEquals(orderMinSubTotal, absResult75.zero());
    assertEquals(orderMinSubTotal, absResult79.zero());
    assertEquals(orderMinSubTotal, absResult81.zero());
    assertEquals(orderMinSubTotal, absResult83.zero());
    assertEquals(orderMinSubTotal, absResult84.zero());
    assertEquals(orderMinSubTotal, absResult85.zero());
    assertEquals(orderMinSubTotal, absResult86.zero());
    assertEquals(orderMinSubTotal, absResult87.zero());
    assertEquals(orderMinSubTotal, absResult88.zero());
    assertEquals(orderMinSubTotal, absResult89.zero());
    assertEquals(orderMinSubTotal, absResult90.zero());
    assertEquals(orderMinSubTotal, absResult91.zero());
    assertEquals(orderMinSubTotal, absResult92.zero());
    assertEquals(orderMinSubTotal, absResult93.zero());
    assertEquals(orderMinSubTotal, absResult94.zero());
    assertEquals(orderMinSubTotal, absResult95.zero());
    assertEquals(orderMinSubTotal, absResult96.zero());
    assertEquals(orderMinSubTotal, absResult97.zero());
    assertEquals(orderMinSubTotal, absResult98.zero());
    assertEquals(orderMinSubTotal, absResult99.zero());
    assertEquals(orderMinSubTotal, absResult100.zero());
    assertEquals(orderMinSubTotal, absResult101.zero());
    assertEquals(orderMinSubTotal, absResult102.zero());
    assertEquals(orderMinSubTotal, absResult103.zero());
    assertEquals(orderMinSubTotal, absResult104.zero());
    assertEquals(orderMinSubTotal, absResult105.zero());
    assertEquals(orderMinSubTotal, absResult106.zero());
    assertEquals(orderMinSubTotal, absResult107.zero());
    assertEquals(orderMinSubTotal, absResult108.zero());
    assertEquals(orderMinSubTotal, absResult109.zero());
    assertEquals(orderMinSubTotal, absResult110.zero());
    assertEquals(orderMinSubTotal, zeroResult54.zero());
    assertEquals(orderMinSubTotal, zeroResult55.zero());
    assertEquals(orderMinSubTotal, zeroResult56.zero());
    assertEquals(orderMinSubTotal, zeroResult57.zero());
    assertEquals(orderMinSubTotal, zeroResult58.zero());
    assertEquals(orderMinSubTotal, zeroResult59.zero());
    assertEquals(orderMinSubTotal, zeroResult60.zero());
    assertEquals(orderMinSubTotal, zeroResult61.zero());
    assertEquals(orderMinSubTotal, zeroResult62.zero());
    assertEquals(orderMinSubTotal, zeroResult63.zero());
    assertEquals(orderMinSubTotal, zeroResult64.zero());
    assertEquals(orderMinSubTotal, zeroResult65.zero());
    assertEquals(orderMinSubTotal, zeroResult66.zero());
    assertEquals(orderMinSubTotal, zeroResult67.zero());
    assertEquals(orderMinSubTotal, zeroResult68.zero());
    assertEquals(orderMinSubTotal, zeroResult69.zero());
    assertEquals(orderMinSubTotal, zeroResult70.zero());
    assertEquals(orderMinSubTotal, zeroResult71.zero());
    assertEquals(orderMinSubTotal, zeroResult72.zero());
    assertEquals(orderMinSubTotal, zeroResult73.zero());
    assertEquals(orderMinSubTotal, zeroResult74.zero());
    assertEquals(orderMinSubTotal, zeroResult75.zero());
    assertEquals(orderMinSubTotal, zeroResult76.zero());
    assertEquals(orderMinSubTotal, zeroResult77.zero());
    assertEquals(orderMinSubTotal, zeroResult78.zero());
    assertEquals(orderMinSubTotal, zeroResult79.zero());
    assertEquals(orderMinSubTotal, zeroResult80.zero());
    assertEquals(orderMinSubTotal, zeroResult81.zero());
    assertEquals(orderMinSubTotal, zeroResult82.zero());
    assertEquals(orderMinSubTotal, zeroResult83.zero());
    assertEquals(orderMinSubTotal, zeroResult84.zero());
    assertEquals(orderMinSubTotal, zeroResult85.zero());
    assertEquals(orderMinSubTotal, zeroResult86.zero());
    assertEquals(orderMinSubTotal, zeroResult87.zero());
    assertEquals(orderMinSubTotal, zeroResult88.zero());
    assertEquals(orderMinSubTotal, zeroResult89.zero());
    assertEquals(orderMinSubTotal, zeroResult90.zero());
    assertEquals(orderMinSubTotal, zeroResult91.zero());
    assertEquals(orderMinSubTotal, zeroResult92.zero());
    assertEquals(orderMinSubTotal, zeroResult93.zero());
    assertEquals(orderMinSubTotal, zeroResult94.zero());
    assertEquals(orderMinSubTotal, zeroResult95.zero());
    assertEquals(orderMinSubTotal, zeroResult96.zero());
    assertEquals(orderMinSubTotal, zeroResult97.zero());
    assertEquals(orderMinSubTotal, zeroResult98.zero());
    assertEquals(orderMinSubTotal, zeroResult99.zero());
    assertEquals(orderMinSubTotal, zeroResult100.zero());
    assertEquals(orderMinSubTotal, zeroResult101.zero());
    assertEquals(orderMinSubTotal, zeroResult102.zero());
    assertEquals(orderMinSubTotal, zeroResult103.zero());
    assertEquals(orderMinSubTotal, zeroResult104.zero());
    assertEquals(orderMinSubTotal, zeroResult105.zero());
    assertEquals(orderMinSubTotal, zeroResult106.zero());
    assertEquals(orderMinSubTotal, zeroResult107.zero());
    assertSame(currency, absResult6.getCurrency());
    assertSame(currency, absResult12.getCurrency());
    assertSame(currency, absResult17.getCurrency());
    assertSame(currency, absResult22.getCurrency());
    assertSame(currency, absResult5.getCurrency());
    assertSame(currency, absResult11.getCurrency());
    assertSame(currency, absResult26.getCurrency());
    assertSame(currency, absResult30.getCurrency());
    assertSame(currency, absResult34.getCurrency());
    assertSame(currency, absResult16.getCurrency());
    assertSame(currency, absResult21.getCurrency());
    assertSame(currency, absResult4.getCurrency());
    assertSame(currency, absResult10.getCurrency());
    assertSame(currency, absResult37.getCurrency());
    assertSame(currency, absResult40.getCurrency());
    assertSame(currency, absResult43.getCurrency());
    assertSame(currency, absResult46.getCurrency());
    assertSame(currency, absResult25.getCurrency());
    assertSame(currency, absResult29.getCurrency());
    assertSame(currency, absResult49.getCurrency());
    assertSame(currency, absResult52.getCurrency());
    assertSame(currency, absResult55.getCurrency());
    assertSame(currency, absResult33.getCurrency());
    Money zeroResult108 = zeroResult2.zero();
    Money absResult111 = zeroResult108.abs();
    Money absResult112 = absResult111.abs();
    assertSame(currency, absResult112.abs().getCurrency());
    assertSame(currency, absResult15.getCurrency());
    assertSame(currency, absResult20.getCurrency());
    assertSame(currency, absResult3.getCurrency());
    assertSame(currency, absResult9.getCurrency());
    assertSame(currency, absResult57.getCurrency());
    assertSame(currency, absResult59.getCurrency());
    assertSame(currency, absResult61.getCurrency());
    assertSame(currency, absResult63.getCurrency());
    assertSame(currency, absResult36.getCurrency());
    assertSame(currency, absResult39.getCurrency());
    assertSame(currency, absResult65.getCurrency());
    assertSame(currency, absResult67.getCurrency());
    assertSame(currency, absResult69.getCurrency());
    assertSame(currency, absResult42.getCurrency());
    assertSame(currency, absResult45.getCurrency());
    assertSame(currency, absResult24.getCurrency());
    assertSame(currency, absResult28.getCurrency());
    assertSame(currency, absResult71.getCurrency());
    assertSame(currency, absResult73.getCurrency());
    assertSame(currency, absResult75.getCurrency());
    assertSame(currency, absResult48.getCurrency());
    assertSame(currency, absResult51.getCurrency());
    assertSame(currency, absResult79.getCurrency());
    assertSame(currency, absResult81.getCurrency());
    assertSame(currency, absResult83.getCurrency());
    assertSame(currency, absResult54.getCurrency());
    Money zeroResult109 = zeroResult108.zero();
    Money absResult113 = zeroResult109.abs();
    assertSame(currency, absResult113.abs().getCurrency());
    assertSame(currency, absResult32.getCurrency());
    assertSame(currency, absResult112.getCurrency());
    assertSame(currency, absResult14.getCurrency());
    assertSame(currency, absResult19.getCurrency());
    assertSame(currency, absResult2.getCurrency());
    assertSame(currency, absResult8.getCurrency());
    assertSame(currency, absResult84.getCurrency());
    assertSame(currency, absResult85.getCurrency());
    assertSame(currency, absResult86.getCurrency());
    assertSame(currency, absResult87.getCurrency());
    assertSame(currency, absResult56.getCurrency());
    assertSame(currency, absResult58.getCurrency());
    assertSame(currency, absResult88.getCurrency());
    assertSame(currency, absResult89.getCurrency());
    assertSame(currency, absResult90.getCurrency());
    assertSame(currency, absResult60.getCurrency());
    assertSame(currency, absResult62.getCurrency());
    assertSame(currency, absResult35.getCurrency());
    assertSame(currency, absResult38.getCurrency());
    assertSame(currency, absResult91.getCurrency());
    assertSame(currency, absResult92.getCurrency());
    assertSame(currency, absResult93.getCurrency());
    assertSame(currency, absResult94.getCurrency());
    assertSame(currency, absResult64.getCurrency());
    assertSame(currency, absResult66.getCurrency());
    assertSame(currency, absResult95.getCurrency());
    assertSame(currency, absResult96.getCurrency());
    assertSame(currency, absResult97.getCurrency());
    assertSame(currency, absResult68.getCurrency());
    Money zeroResult110 = absResult111.zero();
    assertSame(currency, zeroResult110.abs().getCurrency());
    assertSame(currency, absResult41.getCurrency());
    assertSame(currency, absResult44.getCurrency());
    assertSame(currency, absResult23.getCurrency());
    assertSame(currency, absResult27.getCurrency());
    assertSame(currency, absResult98.getCurrency());
    assertSame(currency, absResult99.getCurrency());
    assertSame(currency, absResult100.getCurrency());
    assertSame(currency, absResult101.getCurrency());
    assertSame(currency, absResult70.getCurrency());
    assertSame(currency, absResult72.getCurrency());
    assertSame(currency, absResult102.getCurrency());
    assertSame(currency, absResult103.getCurrency());
    assertSame(currency, absResult104.getCurrency());
    assertSame(currency, absResult74.getCurrency());
    assertSame(currency, absResult76.getCurrency());
    assertSame(currency, absResult47.getCurrency());
    assertSame(currency, absResult50.getCurrency());
    assertSame(currency, absResult105.getCurrency());
    assertSame(currency, absResult106.getCurrency());
    assertSame(currency, absResult107.getCurrency());
    assertSame(currency, absResult78.getCurrency());
    assertSame(currency, absResult80.getCurrency());
    assertSame(currency, absResult108.getCurrency());
    assertSame(currency, absResult109.getCurrency());
    assertSame(currency, absResult110.getCurrency());
    assertSame(currency, absResult82.getCurrency());
    Money zeroResult111 = zeroResult109.zero();
    assertSame(currency, zeroResult111.abs().getCurrency());
    assertSame(currency, absResult53.getCurrency());
    assertSame(currency, absResult113.getCurrency());
    assertSame(currency, absResult31.getCurrency());
    assertSame(currency, absResult111.getCurrency());
    assertSame(currency, absResult13.getCurrency());
    assertSame(currency, absResult18.getCurrency());
    assertSame(currency, absResult.getCurrency());
    assertSame(currency, absResult7.getCurrency());
    assertSame(currency, zeroResult54.getCurrency());
    assertSame(currency, zeroResult55.getCurrency());
    assertSame(currency, zeroResult56.getCurrency());
    assertSame(currency, zeroResult57.getCurrency());
    assertSame(currency, zeroResult27.getCurrency());
    assertSame(currency, zeroResult28.getCurrency());
    assertSame(currency, zeroResult58.getCurrency());
    assertSame(currency, zeroResult59.getCurrency());
    assertSame(currency, zeroResult60.getCurrency());
    assertSame(currency, zeroResult29.getCurrency());
    assertSame(currency, zeroResult30.getCurrency());
    assertSame(currency, zeroResult13.getCurrency());
    assertSame(currency, zeroResult14.getCurrency());
    assertSame(currency, zeroResult61.getCurrency());
    assertSame(currency, zeroResult62.getCurrency());
    assertSame(currency, zeroResult63.getCurrency());
    assertSame(currency, zeroResult64.getCurrency());
    assertSame(currency, zeroResult31.getCurrency());
    assertSame(currency, zeroResult32.getCurrency());
    assertSame(currency, zeroResult65.getCurrency());
    assertSame(currency, zeroResult66.getCurrency());
    assertSame(currency, zeroResult67.getCurrency());
    assertSame(currency, zeroResult33.getCurrency());
    assertSame(currency, absResult112.zero().getCurrency());
    assertSame(currency, zeroResult15.getCurrency());
    assertSame(currency, zeroResult16.getCurrency());
    assertSame(currency, zeroResult6.getCurrency());
    assertSame(currency, zeroResult7.getCurrency());
    assertSame(currency, zeroResult68.getCurrency());
    assertSame(currency, zeroResult69.getCurrency());
    assertSame(currency, zeroResult70.getCurrency());
    assertSame(currency, zeroResult71.getCurrency());
    assertSame(currency, zeroResult34.getCurrency());
    assertSame(currency, zeroResult35.getCurrency());
    assertSame(currency, zeroResult72.getCurrency());
    assertSame(currency, zeroResult73.getCurrency());
    assertSame(currency, zeroResult74.getCurrency());
    assertSame(currency, zeroResult36.getCurrency());
    assertSame(currency, zeroResult37.getCurrency());
    assertSame(currency, zeroResult17.getCurrency());
    assertSame(currency, zeroResult18.getCurrency());
    assertSame(currency, zeroResult75.getCurrency());
    assertSame(currency, zeroResult76.getCurrency());
    assertSame(currency, zeroResult77.getCurrency());
    assertSame(currency, zeroResult38.getCurrency());
    assertSame(currency, zeroResult39.getCurrency());
    assertSame(currency, zeroResult78.getCurrency());
    assertSame(currency, zeroResult79.getCurrency());
    assertSame(currency, zeroResult80.getCurrency());
    assertSame(currency, zeroResult40.getCurrency());
    assertSame(currency, absResult113.zero().getCurrency());
    assertSame(currency, zeroResult19.getCurrency());
    assertSame(currency, zeroResult110.getCurrency());
    assertSame(currency, zeroResult8.getCurrency());
    assertSame(currency, zeroResult9.getCurrency());
    assertSame(currency, zeroResult3.getCurrency());
    assertSame(currency, zeroResult4.getCurrency());
    assertSame(currency, zeroResult81.getCurrency());
    assertSame(currency, zeroResult82.getCurrency());
    assertSame(currency, zeroResult83.getCurrency());
    assertSame(currency, zeroResult84.getCurrency());
    assertSame(currency, zeroResult41.getCurrency());
    assertSame(currency, zeroResult42.getCurrency());
    assertSame(currency, zeroResult85.getCurrency());
    assertSame(currency, zeroResult86.getCurrency());
    assertSame(currency, zeroResult87.getCurrency());
    assertSame(currency, zeroResult43.getCurrency());
    assertSame(currency, zeroResult44.getCurrency());
    assertSame(currency, zeroResult20.getCurrency());
    assertSame(currency, zeroResult21.getCurrency());
    assertSame(currency, zeroResult88.getCurrency());
    assertSame(currency, zeroResult89.getCurrency());
    assertSame(currency, zeroResult90.getCurrency());
    assertSame(currency, zeroResult91.getCurrency());
    assertSame(currency, zeroResult45.getCurrency());
    assertSame(currency, zeroResult46.getCurrency());
    assertSame(currency, zeroResult92.getCurrency());
    assertSame(currency, zeroResult93.getCurrency());
    assertSame(currency, zeroResult94.getCurrency());
    assertSame(currency, zeroResult47.getCurrency());
    assertSame(currency, zeroResult110.zero().getCurrency());
    assertSame(currency, zeroResult22.getCurrency());
    assertSame(currency, zeroResult23.getCurrency());
    assertSame(currency, zeroResult10.getCurrency());
    assertSame(currency, zeroResult11.getCurrency());
    assertSame(currency, zeroResult95.getCurrency());
    assertSame(currency, zeroResult96.getCurrency());
    assertSame(currency, zeroResult97.getCurrency());
    assertSame(currency, zeroResult98.getCurrency());
    assertSame(currency, zeroResult48.getCurrency());
    assertSame(currency, zeroResult49.getCurrency());
    assertSame(currency, zeroResult99.getCurrency());
    assertSame(currency, zeroResult100.getCurrency());
    assertSame(currency, zeroResult101.getCurrency());
    assertSame(currency, zeroResult50.getCurrency());
    assertSame(currency, zeroResult23.zero().getCurrency());
    assertSame(currency, zeroResult24.getCurrency());
    assertSame(currency, zeroResult25.getCurrency());
    assertSame(currency, zeroResult102.getCurrency());
    assertSame(currency, zeroResult103.getCurrency());
    assertSame(currency, zeroResult104.getCurrency());
    assertSame(currency, zeroResult51.getCurrency());
    assertSame(currency, zeroResult52.getCurrency());
    assertSame(currency, zeroResult105.getCurrency());
    assertSame(currency, zeroResult106.getCurrency());
    assertSame(currency, zeroResult107.getCurrency());
    assertSame(currency, zeroResult53.getCurrency());
    assertSame(currency, zeroResult111.zero().getCurrency());
    assertSame(currency, zeroResult26.getCurrency());
    assertSame(currency, zeroResult111.getCurrency());
    assertSame(currency, zeroResult12.getCurrency());
    assertSame(currency, zeroResult109.getCurrency());
    assertSame(currency, zeroResult5.getCurrency());
    assertSame(currency, zeroResult108.getCurrency());
    assertSame(currency, zeroResult.getCurrency());
    assertSame(currency, zeroResult2.getCurrency());
    assertSame(currency, targetMinSubTotal.getCurrency());
    BigDecimal bigDecimal = offerImpl.targetMinSubTotal;
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult63.getAmount());
    assertSame(bigDecimal, absResult65.getAmount());
    assertSame(bigDecimal, absResult67.getAmount());
    assertSame(bigDecimal, absResult69.getAmount());
    assertSame(bigDecimal, absResult71.getAmount());
    assertSame(bigDecimal, absResult73.getAmount());
    assertSame(bigDecimal, absResult75.getAmount());
    assertSame(bigDecimal, absResult77.getAmount());
    assertSame(bigDecimal, absResult79.getAmount());
    assertSame(bigDecimal, absResult81.getAmount());
    assertSame(bigDecimal, absResult83.getAmount());
    assertSame(bigDecimal, absResult84.getAmount());
    assertSame(bigDecimal, absResult85.getAmount());
    assertSame(bigDecimal, absResult86.getAmount());
    assertSame(bigDecimal, absResult87.getAmount());
    assertSame(bigDecimal, absResult88.getAmount());
    assertSame(bigDecimal, absResult89.getAmount());
    assertSame(bigDecimal, absResult90.getAmount());
    assertSame(bigDecimal, absResult91.getAmount());
    assertSame(bigDecimal, absResult92.getAmount());
    assertSame(bigDecimal, absResult93.getAmount());
    assertSame(bigDecimal, absResult94.getAmount());
    assertSame(bigDecimal, absResult95.getAmount());
    assertSame(bigDecimal, absResult96.getAmount());
    assertSame(bigDecimal, absResult97.getAmount());
    assertSame(bigDecimal, absResult98.getAmount());
    assertSame(bigDecimal, absResult99.getAmount());
    assertSame(bigDecimal, absResult100.getAmount());
    assertSame(bigDecimal, absResult101.getAmount());
    assertSame(bigDecimal, absResult102.getAmount());
    assertSame(bigDecimal, absResult103.getAmount());
    assertSame(bigDecimal, absResult104.getAmount());
    assertSame(bigDecimal, absResult105.getAmount());
    assertSame(bigDecimal, absResult106.getAmount());
    assertSame(bigDecimal, absResult107.getAmount());
    assertSame(bigDecimal, absResult108.getAmount());
    assertSame(bigDecimal, absResult109.getAmount());
    assertSame(bigDecimal, absResult110.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult62.getAmount());
    assertSame(bigDecimal, zeroResult63.getAmount());
    assertSame(bigDecimal, zeroResult64.getAmount());
    assertSame(bigDecimal, zeroResult65.getAmount());
    assertSame(bigDecimal, zeroResult66.getAmount());
    assertSame(bigDecimal, zeroResult67.getAmount());
    assertSame(bigDecimal, zeroResult68.getAmount());
    assertSame(bigDecimal, zeroResult69.getAmount());
    assertSame(bigDecimal, zeroResult70.getAmount());
    assertSame(bigDecimal, zeroResult71.getAmount());
    assertSame(bigDecimal, zeroResult72.getAmount());
    assertSame(bigDecimal, zeroResult73.getAmount());
    assertSame(bigDecimal, zeroResult74.getAmount());
    assertSame(bigDecimal, zeroResult75.getAmount());
    assertSame(bigDecimal, zeroResult76.getAmount());
    assertSame(bigDecimal, zeroResult77.getAmount());
    assertSame(bigDecimal, zeroResult78.getAmount());
    assertSame(bigDecimal, zeroResult79.getAmount());
    assertSame(bigDecimal, zeroResult80.getAmount());
    assertSame(bigDecimal, zeroResult81.getAmount());
    assertSame(bigDecimal, zeroResult82.getAmount());
    assertSame(bigDecimal, zeroResult83.getAmount());
    assertSame(bigDecimal, zeroResult84.getAmount());
    assertSame(bigDecimal, zeroResult85.getAmount());
    assertSame(bigDecimal, zeroResult86.getAmount());
    assertSame(bigDecimal, zeroResult87.getAmount());
    assertSame(bigDecimal, zeroResult88.getAmount());
    assertSame(bigDecimal, zeroResult89.getAmount());
    assertSame(bigDecimal, zeroResult90.getAmount());
    assertSame(bigDecimal, zeroResult91.getAmount());
    assertSame(bigDecimal, zeroResult92.getAmount());
    assertSame(bigDecimal, zeroResult93.getAmount());
    assertSame(bigDecimal, zeroResult94.getAmount());
    assertSame(bigDecimal, zeroResult95.getAmount());
    assertSame(bigDecimal, zeroResult96.getAmount());
    assertSame(bigDecimal, zeroResult97.getAmount());
    assertSame(bigDecimal, zeroResult98.getAmount());
    assertSame(bigDecimal, zeroResult99.getAmount());
    assertSame(bigDecimal, zeroResult100.getAmount());
    assertSame(bigDecimal, zeroResult101.getAmount());
    assertSame(bigDecimal, zeroResult102.getAmount());
    assertSame(bigDecimal, zeroResult103.getAmount());
    assertSame(bigDecimal, zeroResult104.getAmount());
    assertSame(bigDecimal, zeroResult105.getAmount());
    assertSame(bigDecimal, zeroResult106.getAmount());
    assertSame(bigDecimal, zeroResult107.getAmount());
  }

  /**
   * Test {@link OfferImpl#setOrderMinSubTotal(Money)}.
   * <ul>
   *   <li>Then {@link OfferImpl} (default constructor)
   * {@link OfferImpl#orderMinSubTotal} is {@link BigDecimal#BigDecimal(String)}
   * with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setOrderMinSubTotal(Money)}
   */
  @Test
  public void testSetOrderMinSubTotal_thenOfferImplOrderMinSubTotalIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
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
    Money absResult3 = absResult2.abs();
    assertSame(bigDecimal, absResult3.getAmount());
    Money absResult4 = absResult3.abs();
    assertSame(bigDecimal, absResult4.getAmount());
    Money absResult5 = absResult4.abs();
    assertSame(bigDecimal, absResult5.getAmount());
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = orderMinSubTotal.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult12 = zeroResult2.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(bigDecimal, absResult15.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(bigDecimal, absResult19.abs().getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(bigDecimal, absResult22.abs().getAmount());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertSame(bigDecimal, absResult25.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(bigDecimal, absResult28.abs().getAmount());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    Money zeroResult60 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
  }

  /**
   * Test {@link OfferImpl#setOrderMinSubTotal(Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   *   <li>Then {@link OfferImpl} (default constructor)
   * {@link OfferImpl#orderMinSubTotal} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setOrderMinSubTotal(Money)}
   */
  @Test
  public void testSetOrderMinSubTotal_whenMoney_thenOfferImplOrderMinSubTotalIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    offerImpl.setOrderMinSubTotal(mock(Money.class));

    // Assert
    assertNull(offerImpl.orderMinSubTotal);
    assertNull(offerImpl.getOrderMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getTargetMinSubTotal()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetMinSubTotal()}
   */
  @Test
  public void testGetTargetMinSubTotal_givenOfferImplAdjustmentTypeIsFuture_credit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Money orderMinSubTotal = new Money();
    offerImpl.setOrderMinSubTotal(orderMinSubTotal);
    offerImpl.setPriority(1);
    offerImpl.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl.setQualifyingItemSubTotal(new Money());
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setTargetMinSubTotal(new Money());

    // Act and Assert
    assertEquals(orderMinSubTotal, offerImpl.getTargetMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getTargetMinSubTotal()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetMinSubTotal()}
   */
  @Test
  public void testGetTargetMinSubTotal_givenOfferImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getTargetMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getTargetMinSubTotal()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetMinSubTotal()}
   */
  @Test
  public void testGetTargetMinSubTotal_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Money orderMinSubTotal = new Money();
    offerImpl.setOrderMinSubTotal(orderMinSubTotal);
    offerImpl.setPriority(1);
    offerImpl.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl.setQualifyingItemSubTotal(new Money());
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setTargetMinSubTotal(new Money());

    // Act
    Money actualTargetMinSubTotal = offerImpl.getTargetMinSubTotal();

    // Assert
    verify(adjustmentType).getType();
    assertEquals(orderMinSubTotal, actualTargetMinSubTotal);
  }

  /**
   * Test {@link OfferImpl#setTargetMinSubTotal(Money)}.
   * <p>
   * Method under test: {@link OfferImpl#setTargetMinSubTotal(Money)}
   */
  @Test
  public void testSetTargetMinSubTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    Money orderMinSubTotal = new Money();
    offerImpl.setOrderMinSubTotal(orderMinSubTotal);
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

    // Act
    offerImpl.setTargetMinSubTotal(null);

    // Assert
    assertNull(offerImpl.targetMinSubTotal);
    assertNull(offerImpl.getTargetMinSubTotal());
    Money qualifyingItemSubTotal = offerImpl.getQualifyingItemSubTotal();
    Money absResult = qualifyingItemSubTotal.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(orderMinSubTotal, absResult6.abs());
    Money absResult7 = qualifyingItemSubTotal.zero().abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertEquals(orderMinSubTotal, absResult11.abs());
    Money zeroResult = absResult.zero();
    Money absResult12 = zeroResult.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertEquals(orderMinSubTotal, absResult15.abs());
    Money zeroResult2 = offerImpl.getOrderMinSubTotal().zero();
    Money zeroResult3 = zeroResult2.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertEquals(orderMinSubTotal, absResult19.abs());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertEquals(orderMinSubTotal, absResult22.abs());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertEquals(orderMinSubTotal, absResult25.abs());
    Money zeroResult6 = zeroResult.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertEquals(orderMinSubTotal, absResult28.abs());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertEquals(orderMinSubTotal, absResult31.abs());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertEquals(orderMinSubTotal, absResult33.abs());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertEquals(orderMinSubTotal, absResult35.abs());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertEquals(orderMinSubTotal, absResult37.abs());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertEquals(orderMinSubTotal, absResult39.abs());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertEquals(orderMinSubTotal, absResult41.abs());
    Money absResult42 = zeroResult5.zero().abs().abs();
    assertEquals(orderMinSubTotal, absResult42.abs());
    Money zeroResult13 = zeroResult6.zero();
    Money absResult43 = zeroResult13.abs();
    Money absResult44 = absResult43.abs();
    assertEquals(orderMinSubTotal, absResult44.abs());
    Money zeroResult14 = zeroResult7.zero();
    Money absResult45 = zeroResult14.abs();
    Money absResult46 = absResult45.abs();
    assertEquals(orderMinSubTotal, absResult46.abs());
    Money zeroResult15 = absResult4.zero();
    Money absResult47 = zeroResult15.abs();
    assertEquals(orderMinSubTotal, absResult47.abs());
    Money zeroResult16 = absResult9.zero();
    Money absResult48 = zeroResult16.abs();
    assertEquals(orderMinSubTotal, absResult48.abs());
    Money zeroResult17 = absResult13.zero();
    Money absResult49 = zeroResult17.abs();
    assertEquals(orderMinSubTotal, absResult49.abs());
    Money zeroResult18 = absResult17.zero();
    Money absResult50 = zeroResult18.abs();
    assertEquals(orderMinSubTotal, absResult50.abs());
    Money zeroResult19 = absResult20.zero();
    Money absResult51 = zeroResult19.abs();
    assertEquals(orderMinSubTotal, absResult51.abs());
    Money zeroResult20 = absResult23.zero();
    Money absResult52 = zeroResult20.abs();
    assertEquals(orderMinSubTotal, absResult52.abs());
    Money zeroResult21 = absResult26.zero();
    Money absResult53 = zeroResult21.abs();
    assertEquals(orderMinSubTotal, absResult53.abs());
    Money zeroResult22 = absResult29.zero();
    Money absResult54 = zeroResult22.abs();
    assertEquals(orderMinSubTotal, absResult54.abs());
    Money zeroResult23 = zeroResult8.zero();
    Money absResult55 = zeroResult23.abs();
    assertEquals(orderMinSubTotal, absResult55.abs());
    Money zeroResult24 = zeroResult9.zero();
    Money absResult56 = zeroResult24.abs();
    assertEquals(orderMinSubTotal, absResult56.abs());
    Money zeroResult25 = zeroResult10.zero();
    Money absResult57 = zeroResult25.abs();
    assertEquals(orderMinSubTotal, absResult57.abs());
    Money zeroResult26 = zeroResult11.zero();
    Money absResult58 = zeroResult26.abs();
    assertEquals(orderMinSubTotal, absResult58.abs());
    Money zeroResult27 = zeroResult12.zero();
    Money absResult59 = zeroResult27.abs();
    assertEquals(orderMinSubTotal, absResult59.abs());
    Money zeroResult28 = zeroResult2.abs().zero().zero();
    Money zeroResult29 = zeroResult28.zero();
    Money absResult60 = zeroResult29.abs();
    assertEquals(orderMinSubTotal, absResult60.abs());
    Money zeroResult30 = zeroResult13.zero();
    Money absResult61 = zeroResult30.abs();
    assertEquals(orderMinSubTotal, absResult61.abs());
    Money zeroResult31 = zeroResult14.zero();
    Money absResult62 = zeroResult31.abs();
    assertEquals(orderMinSubTotal, absResult62.abs());
    Money zeroResult32 = absResult5.zero();
    assertEquals(orderMinSubTotal, zeroResult32.abs());
    Money zeroResult33 = absResult10.zero();
    assertEquals(orderMinSubTotal, zeroResult33.abs());
    Money zeroResult34 = absResult14.zero();
    assertEquals(orderMinSubTotal, zeroResult34.abs());
    Money zeroResult35 = absResult18.zero();
    assertEquals(orderMinSubTotal, zeroResult35.abs());
    Money zeroResult36 = absResult21.zero();
    assertEquals(orderMinSubTotal, zeroResult36.abs());
    Money zeroResult37 = absResult24.zero();
    assertEquals(orderMinSubTotal, zeroResult37.abs());
    Money zeroResult38 = absResult27.zero();
    assertEquals(orderMinSubTotal, zeroResult38.abs());
    Money zeroResult39 = absResult30.zero();
    assertEquals(orderMinSubTotal, zeroResult39.abs());
    Money zeroResult40 = absResult32.zero();
    assertEquals(orderMinSubTotal, zeroResult40.abs());
    Money zeroResult41 = absResult34.zero();
    assertEquals(orderMinSubTotal, zeroResult41.abs());
    Money zeroResult42 = absResult36.zero();
    assertEquals(orderMinSubTotal, zeroResult42.abs());
    Money zeroResult43 = absResult38.zero();
    assertEquals(orderMinSubTotal, zeroResult43.abs());
    Money zeroResult44 = absResult40.zero();
    assertEquals(orderMinSubTotal, zeroResult44.abs());
    Money zeroResult45 = absResult43.zero();
    assertEquals(orderMinSubTotal, zeroResult45.abs());
    Money zeroResult46 = absResult45.zero();
    assertEquals(orderMinSubTotal, zeroResult46.abs());
    Money zeroResult47 = zeroResult15.zero();
    assertEquals(orderMinSubTotal, zeroResult47.abs());
    Money zeroResult48 = zeroResult16.zero();
    assertEquals(orderMinSubTotal, zeroResult48.abs());
    Money zeroResult49 = zeroResult17.zero();
    assertEquals(orderMinSubTotal, zeroResult49.abs());
    Money zeroResult50 = zeroResult18.zero();
    assertEquals(orderMinSubTotal, zeroResult50.abs());
    Money zeroResult51 = zeroResult19.zero();
    assertEquals(orderMinSubTotal, zeroResult51.abs());
    Money zeroResult52 = zeroResult20.zero();
    assertEquals(orderMinSubTotal, zeroResult52.abs());
    Money zeroResult53 = zeroResult21.zero();
    assertEquals(orderMinSubTotal, zeroResult53.abs());
    Money zeroResult54 = zeroResult22.zero();
    assertEquals(orderMinSubTotal, zeroResult54.abs());
    Money zeroResult55 = zeroResult23.zero();
    assertEquals(orderMinSubTotal, zeroResult55.abs());
    Money zeroResult56 = zeroResult24.zero();
    assertEquals(orderMinSubTotal, zeroResult56.abs());
    Money zeroResult57 = zeroResult25.zero();
    assertEquals(orderMinSubTotal, zeroResult57.abs());
    Money zeroResult58 = zeroResult26.zero();
    assertEquals(orderMinSubTotal, zeroResult58.abs());
    Money zeroResult59 = zeroResult27.zero();
    assertEquals(orderMinSubTotal, zeroResult59.abs());
    Money zeroResult60 = zeroResult29.zero();
    assertEquals(orderMinSubTotal, zeroResult60.abs());
    Money zeroResult61 = zeroResult30.zero();
    assertEquals(orderMinSubTotal, zeroResult61.abs());
    Money zeroResult62 = zeroResult31.zero();
    assertEquals(orderMinSubTotal, zeroResult62.abs());
    assertEquals(orderMinSubTotal, absResult6.zero());
    assertEquals(orderMinSubTotal, absResult11.zero());
    assertEquals(orderMinSubTotal, absResult15.zero());
    assertEquals(orderMinSubTotal, absResult19.zero());
    assertEquals(orderMinSubTotal, absResult22.zero());
    assertEquals(orderMinSubTotal, absResult25.zero());
    assertEquals(orderMinSubTotal, absResult28.zero());
    assertEquals(orderMinSubTotal, absResult31.zero());
    assertEquals(orderMinSubTotal, absResult33.zero());
    assertEquals(orderMinSubTotal, absResult35.zero());
    assertEquals(orderMinSubTotal, absResult37.zero());
    assertEquals(orderMinSubTotal, absResult39.zero());
    assertEquals(orderMinSubTotal, absResult41.zero());
    assertEquals(orderMinSubTotal, absResult44.zero());
    assertEquals(orderMinSubTotal, absResult46.zero());
    assertEquals(orderMinSubTotal, absResult47.zero());
    assertEquals(orderMinSubTotal, absResult48.zero());
    assertEquals(orderMinSubTotal, absResult49.zero());
    assertEquals(orderMinSubTotal, absResult50.zero());
    assertEquals(orderMinSubTotal, absResult51.zero());
    assertEquals(orderMinSubTotal, absResult52.zero());
    assertEquals(orderMinSubTotal, absResult53.zero());
    assertEquals(orderMinSubTotal, absResult54.zero());
    assertEquals(orderMinSubTotal, absResult55.zero());
    assertEquals(orderMinSubTotal, absResult56.zero());
    assertEquals(orderMinSubTotal, absResult57.zero());
    assertEquals(orderMinSubTotal, absResult58.zero());
    assertEquals(orderMinSubTotal, absResult59.zero());
    assertEquals(orderMinSubTotal, absResult60.zero());
    assertEquals(orderMinSubTotal, absResult61.zero());
    assertEquals(orderMinSubTotal, absResult62.zero());
    assertEquals(orderMinSubTotal, zeroResult32.zero());
    assertEquals(orderMinSubTotal, zeroResult33.zero());
    assertEquals(orderMinSubTotal, zeroResult34.zero());
    assertEquals(orderMinSubTotal, zeroResult35.zero());
    assertEquals(orderMinSubTotal, zeroResult36.zero());
    assertEquals(orderMinSubTotal, zeroResult37.zero());
    assertEquals(orderMinSubTotal, zeroResult38.zero());
    assertEquals(orderMinSubTotal, zeroResult39.zero());
    assertEquals(orderMinSubTotal, zeroResult40.zero());
    assertEquals(orderMinSubTotal, zeroResult41.zero());
    assertEquals(orderMinSubTotal, zeroResult42.zero());
    assertEquals(orderMinSubTotal, zeroResult43.zero());
    assertEquals(orderMinSubTotal, zeroResult44.zero());
    assertEquals(orderMinSubTotal, zeroResult28.abs().zero().zero());
    assertEquals(orderMinSubTotal, zeroResult45.zero());
    assertEquals(orderMinSubTotal, zeroResult46.zero());
    assertEquals(orderMinSubTotal, zeroResult47.zero());
    assertEquals(orderMinSubTotal, zeroResult48.zero());
    assertEquals(orderMinSubTotal, zeroResult49.zero());
    assertEquals(orderMinSubTotal, zeroResult50.zero());
    assertEquals(orderMinSubTotal, zeroResult51.zero());
    assertEquals(orderMinSubTotal, zeroResult52.zero());
    assertEquals(orderMinSubTotal, zeroResult53.zero());
    assertEquals(orderMinSubTotal, zeroResult54.zero());
    assertEquals(orderMinSubTotal, zeroResult55.zero());
    assertEquals(orderMinSubTotal, zeroResult56.zero());
    assertEquals(orderMinSubTotal, zeroResult57.zero());
    assertEquals(orderMinSubTotal, zeroResult58.zero());
    assertEquals(orderMinSubTotal, zeroResult59.zero());
    assertEquals(orderMinSubTotal, zeroResult60.zero());
    assertEquals(orderMinSubTotal, zeroResult61.zero());
    assertEquals(orderMinSubTotal, zeroResult62.zero());
    BigDecimal bigDecimal = offerImpl.qualifyingItemSubTotal;
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult62.getAmount());
  }

  /**
   * Test {@link OfferImpl#setTargetMinSubTotal(Money)}.
   * <ul>
   *   <li>Then {@link OfferImpl} (default constructor)
   * {@link OfferImpl#targetMinSubTotal} is {@link BigDecimal#BigDecimal(String)}
   * with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setTargetMinSubTotal(Money)}
   */
  @Test
  public void testSetTargetMinSubTotal_thenOfferImplTargetMinSubTotalIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
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
    Money absResult3 = absResult2.abs();
    assertSame(bigDecimal, absResult3.getAmount());
    Money absResult4 = absResult3.abs();
    assertSame(bigDecimal, absResult4.getAmount());
    Money absResult5 = absResult4.abs();
    assertSame(bigDecimal, absResult5.getAmount());
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = targetMinSubTotal.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult12 = zeroResult2.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(bigDecimal, absResult15.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(bigDecimal, absResult19.abs().getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(bigDecimal, absResult22.abs().getAmount());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertSame(bigDecimal, absResult25.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(bigDecimal, absResult28.abs().getAmount());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    Money zeroResult60 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
  }

  /**
   * Test {@link OfferImpl#setTargetMinSubTotal(Money)}.
   * <ul>
   *   <li>When {@link Money}.</li>
   *   <li>Then {@link OfferImpl} (default constructor)
   * {@link OfferImpl#targetMinSubTotal} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setTargetMinSubTotal(Money)}
   */
  @Test
  public void testSetTargetMinSubTotal_whenMoney_thenOfferImplTargetMinSubTotalIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();

    // Act
    offerImpl.setTargetMinSubTotal(mock(Money.class));

    // Assert
    assertNull(offerImpl.targetMinSubTotal);
    assertNull(offerImpl.getTargetMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}.
   * <p>
   * Method under test: {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}
   */
  @Test
  public void testGetRequiresRelatedTargetAndQualifiers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setRequiresRelatedTargetAndQualifiers(null);

    // Act and Assert
    assertFalse(offerImpl.getRequiresRelatedTargetAndQualifiers());
  }

  /**
   * Test {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}
   */
  @Test
  public void testGetRequiresRelatedTargetAndQualifiers_givenOfferImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).getRequiresRelatedTargetAndQualifiers());
  }

  /**
   * Test {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}.
   * <ul>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}
   */
  @Test
  public void testGetRequiresRelatedTargetAndQualifiers_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setRequiresRelatedTargetAndQualifiers(null);

    // Act
    Boolean actualRequiresRelatedTargetAndQualifiers = offerImpl.getRequiresRelatedTargetAndQualifiers();

    // Assert
    verify(adjustmentType).getType();
    assertFalse(actualRequiresRelatedTargetAndQualifiers);
  }

  /**
   * Test {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}
   */
  @Test
  public void testGetRequiresRelatedTargetAndQualifiers_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl.setTargetMinSubTotal(new Money());
    offerImpl.setTargetSystem("Target System");
    offerImpl.setTotalitarianOffer(true);
    offerImpl.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl.setUseListForDiscounts(true);
    offerImpl.setValue(new BigDecimal("2.3"));
    offerImpl.setRequiresRelatedTargetAndQualifiers(true);

    // Act and Assert
    assertTrue(offerImpl.getRequiresRelatedTargetAndQualifiers());
  }

  /**
   * Test {@link OfferImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getMainEntityName());
  }

  /**
   * Test {@link OfferImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link OfferType} {@link OfferType#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link OfferType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenOfferTypeGetTypeReturnType_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferType type = mock(OfferType.class);
    when(type.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setType(type);

    // Act
    String actualMainEntityName = offerImpl.getMainEntityName();

    // Assert
    verify(type).getType();
    assertNull(actualMainEntityName);
  }

  /**
   * Test {@link OfferImpl#getAdjustmentType()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@link OfferAdjustmentType#ORDER_DISCOUNT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getAdjustmentType()}
   */
  @Test
  public void testGetAdjustmentType_givenOfferImpl_thenReturnOrder_discount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OfferAdjustmentType actualAdjustmentType = (new OfferImpl()).getAdjustmentType();

    // Assert
    assertSame(actualAdjustmentType.ORDER_DISCOUNT, actualAdjustmentType);
  }

  /**
   * Test {@link OfferImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OfferAdjustmentType} {@link OfferAdjustmentType#getType()}
   * return {@code foo}.</li>
   *   <li>Then calls {@link OfferAdjustmentType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit_givenOfferAdjustmentTypeGetTypeReturnFoo_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("foo");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);

    // Act
    boolean actualIsFutureCreditResult = offerImpl.isFutureCredit();

    // Assert
    verify(adjustmentType).getType();
    assertFalse(actualIsFutureCreditResult);
  }

  /**
   * Test {@link OfferImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit_givenOfferImplAdjustmentTypeIsFuture_credit_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);

    // Act and Assert
    assertTrue(offerImpl.isFutureCredit());
  }

  /**
   * Test {@link OfferImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is
   * {@link OfferAdjustmentType#ORDER_DISCOUNT}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit_givenOfferImplAdjustmentTypeIsOrder_discount_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(OfferAdjustmentType.ORDER_DISCOUNT);

    // Act and Assert
    assertFalse(offerImpl.isFutureCredit());
  }

  /**
   * Test {@link OfferImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit_givenOfferImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isFutureCredit());
  }

  /**
   * Test {@link OfferImpl#equals(Object)}, and {@link OfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferImpl#equals(Object)}
   *   <li>{@link OfferImpl#hashCode()}
   * </ul>
   */
  @Test
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
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl2.setApplyDiscountToSalePrice(true);
    offerImpl2.setApplyToChildItems(true);
    offerImpl2.setAutomaticallyAdded(true);
    offerImpl2.setCombinableWithOtherOffers(true);
    offerImpl2.setDescription("The characteristics of someone or something");
    offerImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl2.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl2.setTargetMinSubTotal(new Money());
    offerImpl2.setTargetSystem("Target System");
    offerImpl2.setTotalitarianOffer(true);
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(offerImpl, offerImpl2);
    int expectedHashCodeResult = offerImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerImpl2.hashCode());
  }

  /**
   * Test {@link OfferImpl#equals(Object)}, and {@link OfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferImpl#equals(Object)}
   *   <li>{@link OfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl2.setApplyDiscountToSalePrice(true);
    offerImpl2.setApplyToChildItems(true);
    offerImpl2.setAutomaticallyAdded(true);
    offerImpl2.setCombinableWithOtherOffers(true);
    offerImpl2.setDescription("The characteristics of someone or something");
    offerImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl2.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl2.setTargetMinSubTotal(new Money());
    offerImpl2.setTargetSystem("Target System");
    offerImpl2.setTotalitarianOffer(true);
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(offerImpl, offerImpl2);
    int expectedHashCodeResult = offerImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerImpl2.hashCode());
  }

  /**
   * Test {@link OfferImpl#equals(Object)}, and {@link OfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferImpl#equals(Object)}
   *   <li>{@link OfferImpl#hashCode()}
   * </ul>
   */
  @Test
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
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act and Assert
    assertEquals(offerImpl, offerImpl);
    int expectedHashCodeResult = offerImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerImpl.hashCode());
  }

  /**
   * Test {@link OfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferAdjustmentType adjustmentType = mock(OfferAdjustmentType.class);
    when(adjustmentType.getType()).thenReturn("Type");

    OfferImpl offerImpl = new OfferImpl();
    offerImpl.setAdjustmentType(adjustmentType);
    offerImpl.setApplyDiscountToSalePrice(true);
    offerImpl.setApplyToChildItems(true);
    offerImpl.setAutomaticallyAdded(true);
    offerImpl.setCombinableWithOtherOffers(true);
    offerImpl.setDescription("The characteristics of someone or something");
    offerImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl2.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offerImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#equals(Object)}
   */
  @Test
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
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act and Assert
    assertNotEquals(offerImpl, null);
  }

  /**
   * Test {@link OfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#equals(Object)}
   */
  @Test
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
    offerImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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

    // Act and Assert
    assertNotEquals(offerImpl, "Different type to OfferImpl");
  }

  /**
   * Test {@link OfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Offer> actualCreateOrRetrieveCopyInstanceResult = offerImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }
}
