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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OfferImplDiffblueTest {
  @Autowired
  private OfferImpl offerImpl;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OfferImpl.getDescription()", "Date OfferImpl.getEndDate()", "Long OfferImpl.getId()",
      "Long OfferImpl.getMinimumDaysPerUsage()", "String OfferImpl.getName()", "List OfferImpl.getOfferCodes()",
      "Map OfferImpl.getOfferMatchRulesXref()", "List OfferImpl.getOfferPriceData()",
      "Set OfferImpl.getQualifyingItemCriteriaXref()", "String OfferImpl.getTargetSystem()",
      "BigDecimal OfferImpl.getValue()", "void OfferImpl.setDescription(String)", "void OfferImpl.setEndDate(Date)",
      "void OfferImpl.setId(Long)", "void OfferImpl.setMarketingMessage(String)",
      "void OfferImpl.setMaxUsesPerCustomer(Long)", "void OfferImpl.setMinimumDaysPerUsage(Long)",
      "void OfferImpl.setName(String)", "void OfferImpl.setOfferCodes(List)",
      "void OfferImpl.setOfferMatchRulesXref(Map)", "void OfferImpl.setOfferPriceData(List)",
      "void OfferImpl.setPriority(Integer)", "void OfferImpl.setQualifyingItemCriteriaXref(Set)",
      "void OfferImpl.setRequiresRelatedTargetAndQualifiers(Boolean)", "void OfferImpl.setStartDate(Date)",
      "void OfferImpl.setTargetItemCriteriaXref(Set)", "void OfferImpl.setTargetSystem(String)",
      "void OfferImpl.setUseListForDiscounts(Boolean)", "void OfferImpl.setValue(BigDecimal)"})
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
   * <p>
   * Method under test: {@link OfferImpl#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferType OfferImpl.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getType());
  }

  /**
   * Test {@link OfferImpl#getDiscountType()}.
   * <p>
   * Method under test: {@link OfferImpl#getDiscountType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferDiscountType OfferImpl.getDiscountType()"})
  public void testGetDiscountType() {
    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getDiscountType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferItemRestrictionRuleType OfferImpl.getOfferItemQualifierRuleType()"})
  public void testGetOfferItemQualifierRuleType_givenOfferImpl() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();

    // Act
    OfferItemRestrictionRuleType actualOfferItemQualifierRuleType = offerImpl2.getOfferItemQualifierRuleType();

    // Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = actualOfferItemQualifierRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, actualOfferItemQualifierRuleType);
    assertSame(offerItemRestrictionRuleType, offerImpl2.getOfferItemTargetRuleType());
  }

  /**
   * Test {@link OfferImpl#getOfferItemQualifierRuleType()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOfferItemQualifierRuleType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferItemRestrictionRuleType OfferImpl.getOfferItemQualifierRuleType()"})
  public void testGetOfferItemQualifierRuleType_givenOfferImplAdjustmentTypeIsFuture_credit() {
    // Arrange
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

    // Act
    OfferItemRestrictionRuleType actualOfferItemQualifierRuleType = offerImpl2.getOfferItemQualifierRuleType();

    // Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = actualOfferItemQualifierRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, actualOfferItemQualifierRuleType);
    assertSame(offerItemRestrictionRuleType, offerImpl2.getOfferItemTargetRuleType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferItemRestrictionRuleType OfferImpl.getOfferItemTargetRuleType()"})
  public void testGetOfferItemTargetRuleType_givenOfferImpl() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();

    // Act
    OfferItemRestrictionRuleType actualOfferItemTargetRuleType = offerImpl2.getOfferItemTargetRuleType();

    // Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = actualOfferItemTargetRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, offerImpl2.getOfferItemQualifierRuleType());
    assertSame(offerItemRestrictionRuleType, actualOfferItemTargetRuleType);
  }

  /**
   * Test {@link OfferImpl#getOfferItemTargetRuleType()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOfferItemTargetRuleType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferItemRestrictionRuleType OfferImpl.getOfferItemTargetRuleType()"})
  public void testGetOfferItemTargetRuleType_givenOfferImplAdjustmentTypeIsFuture_credit() {
    // Arrange
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

    // Act
    OfferItemRestrictionRuleType actualOfferItemTargetRuleType = offerImpl2.getOfferItemTargetRuleType();

    // Assert
    OfferItemRestrictionRuleType offerItemRestrictionRuleType = actualOfferItemTargetRuleType.NONE;
    assertSame(offerItemRestrictionRuleType, offerImpl2.getOfferItemQualifierRuleType());
    assertSame(offerItemRestrictionRuleType, actualOfferItemTargetRuleType);
  }

  /**
   * Test {@link OfferImpl#getPriority()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getPriority()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OfferImpl.getPriority()"})
  public void testGetPriority_givenOfferImplAdjustmentTypeIsFuture_credit_thenReturnOne() {
    // Arrange
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
    offerImpl2.setPriority(1);

    // Act and Assert
    assertEquals(1, offerImpl2.getPriority());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OfferImpl.getPriority()"})
  public void testGetPriority_givenOfferImpl_thenReturnMax_valueLessOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date OfferImpl.getStartDate()"})
  public void testGetStartDate_givenOfferImplArchivedIsY_thenReturnNull() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setArchived('Y');

    // Act and Assert
    assertNull(offerImpl2.getStartDate());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date OfferImpl.getStartDate()"})
  public void testGetStartDate_givenOfferImpl_thenReturnNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.getApplyDiscountToSalePrice()"})
  public void testGetApplyDiscountToSalePrice_givenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).getApplyDiscountToSalePrice());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.getApplyDiscountToSalePrice()"})
  public void testGetApplyDiscountToSalePrice_thenReturnFalse() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setApplyDiscountToSalePrice(false);

    // Act and Assert
    assertFalse(offerImpl2.getApplyDiscountToSalePrice());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferImpl.getApplyToChildItems()"})
  public void testGetApplyToChildItems_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).getApplyToChildItems());
  }

  /**
   * Test {@link OfferImpl#getApplyToChildItems()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getApplyToChildItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferImpl.getApplyToChildItems()"})
  public void testGetApplyToChildItems_thenReturnTrue() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl2.setApplyDiscountToSalePrice(true);
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
    offerImpl2.setApplyToChildItems(true);

    // Act and Assert
    assertTrue(offerImpl2.getApplyToChildItems());
  }

  /**
   * Test {@link OfferImpl#setApplyToChildItems(boolean)}.
   * <p>
   * Method under test: {@link OfferImpl#setApplyToChildItems(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setApplyToChildItems(boolean)"})
  public void testSetApplyToChildItems() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();

    // Act
    offerImpl2.setApplyToChildItems(true);

    // Assert
    assertTrue(offerImpl2.getApplyToChildItems());
    assertTrue(offerImpl2.applyToChildItems);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isCombinableWithOtherOffers()"})
  public void testIsCombinableWithOtherOffers_givenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).isCombinableWithOtherOffers());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isCombinableWithOtherOffers()"})
  public void testIsCombinableWithOtherOffers_thenReturnFalse() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setCombinableWithOtherOffers(false);

    // Act and Assert
    assertFalse(offerImpl2.isCombinableWithOtherOffers());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.getCombinableWithOtherOffers()"})
  public void testGetCombinableWithOtherOffers_givenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).getCombinableWithOtherOffers());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.getCombinableWithOtherOffers()"})
  public void testGetCombinableWithOtherOffers_thenReturnFalse() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setCombinableWithOtherOffers(false);

    // Act and Assert
    assertFalse(offerImpl2.getCombinableWithOtherOffers());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isAutomaticallyAdded()"})
  public void testIsAutomaticallyAdded_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isAutomaticallyAdded());
  }

  /**
   * Test {@link OfferImpl#isAutomaticallyAdded()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isAutomaticallyAdded()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isAutomaticallyAdded()"})
  public void testIsAutomaticallyAdded_thenReturnTrue() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl2.setApplyDiscountToSalePrice(true);
    offerImpl2.setApplyToChildItems(true);
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
    offerImpl2.setAutomaticallyAdded(true);

    // Act and Assert
    assertTrue(offerImpl2.isAutomaticallyAdded());
  }

  /**
   * Test {@link OfferImpl#setAutomaticallyAdded(boolean)}.
   * <p>
   * Method under test: {@link OfferImpl#setAutomaticallyAdded(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setAutomaticallyAdded(boolean)"})
  public void testSetAutomaticallyAdded() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();

    // Act
    offerImpl2.setAutomaticallyAdded(true);

    // Assert
    assertTrue(offerImpl2.automaticallyAdded);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OfferImpl.getMaxUsesPerCustomer()"})
  public void testGetMaxUsesPerCustomer_givenOfferImpl_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new OfferImpl()).getMaxUsesPerCustomer().longValue());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerCustomer()}.
   * <ul>
   *   <li>Then return longValue is {@link OfferImpl#serialVersionUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesPerCustomer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OfferImpl.getMaxUsesPerCustomer()"})
  public void testGetMaxUsesPerCustomer_thenReturnLongValueIsSerialVersionUID() {
    // Arrange
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
    offerImpl2.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(OfferImpl.serialVersionUID, offerImpl2.getMaxUsesPerCustomer().longValue());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesStrategyType()}.
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesStrategyType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CustomerMaxUsesStrategyType OfferImpl.getMaxUsesStrategyType()"})
  public void testGetMaxUsesStrategyType() {
    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getMaxUsesStrategyType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isUnlimitedUsePerCustomer()"})
  public void testIsUnlimitedUsePerCustomer_givenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).isUnlimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerCustomer()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isUnlimitedUsePerCustomer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isUnlimitedUsePerCustomer()"})
  public void testIsUnlimitedUsePerCustomer_thenReturnFalse() {
    // Arrange
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
    offerImpl2.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act and Assert
    assertFalse(offerImpl2.isUnlimitedUsePerCustomer());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isLimitedUsePerCustomer()"})
  public void testIsLimitedUsePerCustomer_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isLimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerCustomer()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isLimitedUsePerCustomer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isLimitedUsePerCustomer()"})
  public void testIsLimitedUsePerCustomer_thenReturnTrue() {
    // Arrange
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
    offerImpl2.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);

    // Act and Assert
    assertTrue(offerImpl2.isLimitedUsePerCustomer());
  }

  /**
   * Test {@link OfferImpl#getMaxUsesPerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMaxUsesPerOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OfferImpl.getMaxUsesPerOrder()"})
  public void testGetMaxUsesPerOrder_givenOfferImplAdjustmentTypeIsFuture_credit_thenReturnOne() {
    // Arrange
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
    offerImpl2.setMaxUsesPerOrder(1);

    // Act and Assert
    assertEquals(1, offerImpl2.getMaxUsesPerOrder());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int OfferImpl.getMaxUsesPerOrder()"})
  public void testGetMaxUsesPerOrder_givenOfferImpl_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new OfferImpl()).getMaxUsesPerOrder());
  }

  /**
   * Test {@link OfferImpl#setMaxUsesPerOrder(int)}.
   * <p>
   * Method under test: {@link OfferImpl#setMaxUsesPerOrder(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setMaxUsesPerOrder(int)"})
  public void testSetMaxUsesPerOrder() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();

    // Act
    offerImpl2.setMaxUsesPerOrder(3);

    // Assert
    assertEquals(3, offerImpl2.maxUsesPerOrder.intValue());
    assertEquals(3, offerImpl2.getMaxUsesPerOrder());
    assertFalse(offerImpl2.isUnlimitedUsePerOrder());
    assertTrue(offerImpl2.isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) MaxUsesPerOrder is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isUnlimitedUsePerOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isUnlimitedUsePerOrder()"})
  public void testIsUnlimitedUsePerOrder_givenOfferImplMaxUsesPerOrderIsOne_thenReturnFalse() {
    // Arrange
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
    offerImpl2.setMaxUsesPerOrder(1);

    // Act and Assert
    assertFalse(offerImpl2.isUnlimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isUnlimitedUsePerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) MaxUsesPerOrder is zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isUnlimitedUsePerOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isUnlimitedUsePerOrder()"})
  public void testIsUnlimitedUsePerOrder_givenOfferImplMaxUsesPerOrderIsZero_thenReturnTrue() {
    // Arrange
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
    offerImpl2.setMaxUsesPerOrder(0);

    // Act and Assert
    assertTrue(offerImpl2.isUnlimitedUsePerOrder());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isUnlimitedUsePerOrder()"})
  public void testIsUnlimitedUsePerOrder_givenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).isUnlimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) MaxUsesPerOrder is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isLimitedUsePerOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isLimitedUsePerOrder()"})
  public void testIsLimitedUsePerOrder_givenOfferImplMaxUsesPerOrderIsOne_thenReturnTrue() {
    // Arrange
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
    offerImpl2.setMaxUsesPerOrder(1);

    // Act and Assert
    assertTrue(offerImpl2.isLimitedUsePerOrder());
  }

  /**
   * Test {@link OfferImpl#isLimitedUsePerOrder()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) MaxUsesPerOrder is zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isLimitedUsePerOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isLimitedUsePerOrder()"})
  public void testIsLimitedUsePerOrder_givenOfferImplMaxUsesPerOrderIsZero_thenReturnFalse() {
    // Arrange
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
    offerImpl2.setMaxUsesPerOrder(0);

    // Act and Assert
    assertFalse(offerImpl2.isLimitedUsePerOrder());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isLimitedUsePerOrder()"})
  public void testIsLimitedUsePerOrder_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isLimitedUsePerOrder());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OfferImpl.getMarketingMessage()"})
  public void testGetMarketingMessage_givenOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getMarketingMessage());
  }

  /**
   * Test {@link OfferImpl#getMarketingMessage()}.
   * <ul>
   *   <li>Then return {@code Marketing Message}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getMarketingMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OfferImpl.getMarketingMessage()"})
  public void testGetMarketingMessage_thenReturnMarketingMessage() {
    // Arrange
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
    assertEquals("Marketing Message", offerImpl2.getMarketingMessage());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   * <p>
   * Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set OfferImpl.getTargetItemCriteriaXref()"})
  public void testGetTargetItemCriteriaXref() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setType(new OfferType("ORDER_ITEM", "ORDER_ITEM", 1));

    // Act and Assert
    assertEquals(1, offerImpl2.getTargetItemCriteriaXref().size());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) Type is {@link OfferType#FULFILLMENT_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set OfferImpl.getTargetItemCriteriaXref()"})
  public void testGetTargetItemCriteriaXref_givenOfferImplTypeIsFulfillment_group() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);

    // Act and Assert
    assertTrue(offerImpl2.getTargetItemCriteriaXref().isEmpty());
  }

  /**
   * Test {@link OfferImpl#getTargetItemCriteriaXref()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) Type is {@link OfferType#ORDER_ITEM}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetItemCriteriaXref()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set OfferImpl.getTargetItemCriteriaXref()"})
  public void testGetTargetItemCriteriaXref_givenOfferImplTypeIsOrder_item_thenReturnSizeIsOne() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setType(OfferType.ORDER_ITEM);

    // Act and Assert
    assertEquals(1, offerImpl2.getTargetItemCriteriaXref().size());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set OfferImpl.getTargetItemCriteriaXref()"})
  public void testGetTargetItemCriteriaXref_givenOfferImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new OfferImpl()).getTargetItemCriteriaXref().isEmpty());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferImpl.isTotalitarianOffer()"})
  public void testIsTotalitarianOffer_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isTotalitarianOffer());
  }

  /**
   * Test {@link OfferImpl#isTotalitarianOffer()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isTotalitarianOffer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferImpl.isTotalitarianOffer()"})
  public void testIsTotalitarianOffer_thenReturnTrue() {
    // Arrange
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
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));
    offerImpl2.setTotalitarianOffer(true);

    // Act and Assert
    assertTrue(offerImpl2.isTotalitarianOffer());
  }

  /**
   * Test {@link OfferImpl#setTotalitarianOffer(Boolean)}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link OfferImpl} (default constructor) {@link OfferImpl#totalitarianOffer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setTotalitarianOffer(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setTotalitarianOffer(Boolean)"})
  public void testSetTotalitarianOffer_givenOfferImpl_whenTrue_thenOfferImplTotalitarianOffer() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();

    // Act
    offerImpl2.setTotalitarianOffer(true);

    // Assert
    assertTrue(offerImpl2.totalitarianOffer);
  }

  /**
   * Test {@link OfferImpl#setTotalitarianOffer(Boolean)}.
   * <ul>
   *   <li>Then not {@link OfferImpl} (default constructor) {@link OfferImpl#totalitarianOffer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setTotalitarianOffer(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setTotalitarianOffer(Boolean)"})
  public void testSetTotalitarianOffer_thenNotOfferImplTotalitarianOffer() {
    // Arrange
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

    // Act
    offerImpl2.setTotalitarianOffer(null);

    // Assert
    assertFalse(offerImpl2.totalitarianOffer);
  }

  /**
   * Test {@link OfferImpl#getUseListForDiscounts()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) UseListForDiscounts is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getUseListForDiscounts()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferImpl.getUseListForDiscounts()"})
  public void testGetUseListForDiscounts_givenOfferImplUseListForDiscountsIsNull() {
    // Arrange
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
    offerImpl2.setValue(new BigDecimal("2.3"));
    offerImpl2.setUseListForDiscounts(null);

    // Act and Assert
    assertFalse(offerImpl2.getUseListForDiscounts());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferImpl.getUseListForDiscounts()"})
  public void testGetUseListForDiscounts_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).getUseListForDiscounts());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferImpl.getUseListForDiscounts()"})
  public void testGetUseListForDiscounts_thenReturnTrue() {
    // Arrange
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
    offerImpl2.setValue(new BigDecimal("2.3"));
    offerImpl2.setUseListForDiscounts(true);

    // Act and Assert
    assertTrue(offerImpl2.getUseListForDiscounts());
  }

  /**
   * Test {@link OfferImpl#getArchived()}.
   * <p>
   * Method under test: {@link OfferImpl#getArchived()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Character OfferImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', (new OfferImpl()).getArchived().charValue());
  }

  /**
   * Test {@link OfferImpl#setArchived(Character)}.
   * <p>
   * Method under test: {@link OfferImpl#setArchived(Character)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();

    // Act
    offerImpl2.setArchived('A');

    // Assert
    assertEquals('A', offerImpl2.archiveStatus.getArchived().charValue());
    assertEquals('A', offerImpl2.getArchived().charValue());
  }

  /**
   * Test {@link OfferImpl#isActive()}.
   * <p>
   * Method under test: {@link OfferImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isActive()"})
  public void testIsActive() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offerImpl2.setApplyDiscountToSalePrice(true);
    offerImpl2.setApplyToChildItems(true);
    offerImpl2.setAutomaticallyAdded(true);
    offerImpl2.setCombinableWithOtherOffers(true);
    offerImpl2.setDescription("The characteristics of someone or something");
    offerImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
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
    offerImpl2.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl2.setTargetMinSubTotal(new Money());
    offerImpl2.setTargetSystem("Target System");
    offerImpl2.setTotalitarianOffer(true);
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));
    offerImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setArchived(null);

    // Act and Assert
    assertFalse(offerImpl2.isActive());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isActive()"})
  public void testIsActive_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).isActive());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OfferImpl.getQualifyingItemSubTotal()"})
  public void testGetQualifyingItemSubTotal_givenOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getQualifyingItemSubTotal());
  }

  /**
   * Test {@link OfferImpl#getQualifyingItemSubTotal()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getQualifyingItemSubTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OfferImpl.getQualifyingItemSubTotal()"})
  public void testGetQualifyingItemSubTotal_thenReturnMoney() {
    // Arrange
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
    Money orderMinSubTotal = new Money();
    offerImpl2.setOrderMinSubTotal(orderMinSubTotal);
    offerImpl2.setPriority(1);
    offerImpl2.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl2.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl2.setTargetMinSubTotal(new Money());
    offerImpl2.setTargetSystem("Target System");
    offerImpl2.setTotalitarianOffer(true);
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));
    offerImpl2.setQualifyingItemSubTotal(new Money());

    // Act and Assert
    assertEquals(orderMinSubTotal, offerImpl2.getQualifyingItemSubTotal());
  }

  /**
   * Test {@link OfferImpl#setQualifyingItemSubTotal(Money)}.
   * <p>
   * Method under test: {@link OfferImpl#setQualifyingItemSubTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setQualifyingItemSubTotal(Money)"})
  public void testSetQualifyingItemSubTotal() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    Money qualifyingItemSubTotal = new Money();

    // Act
    offerImpl2.setQualifyingItemSubTotal(qualifyingItemSubTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), offerImpl2.qualifyingItemSubTotal);
    BigDecimal bigDecimal = offerImpl2.qualifyingItemSubTotal;
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
   * <ul>
   *   <li>Then {@link OfferImpl} (default constructor) {@link OfferImpl#qualifyingItemSubTotal} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setQualifyingItemSubTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setQualifyingItemSubTotal(Money)"})
  public void testSetQualifyingItemSubTotal_thenOfferImplQualifyingItemSubTotalIsNull() {
    // Arrange
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

    // Act
    offerImpl2.setQualifyingItemSubTotal(null);

    // Assert
    assertNull(offerImpl2.qualifyingItemSubTotal);
    assertNull(offerImpl2.getQualifyingItemSubTotal());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OfferImpl.getOrderMinSubTotal()"})
  public void testGetOrderMinSubTotal_givenOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getOrderMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getOrderMinSubTotal()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getOrderMinSubTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OfferImpl.getOrderMinSubTotal()"})
  public void testGetOrderMinSubTotal_thenReturnMoney() {
    // Arrange
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
    offerImpl2.setPriority(1);
    offerImpl2.setQualifyingItemCriteriaXref(new HashSet<>());
    Money qualifyingItemSubTotal = new Money();
    offerImpl2.setQualifyingItemSubTotal(qualifyingItemSubTotal);
    offerImpl2.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl2.setTargetMinSubTotal(new Money());
    offerImpl2.setTargetSystem("Target System");
    offerImpl2.setTotalitarianOffer(true);
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));
    offerImpl2.setOrderMinSubTotal(new Money());

    // Act and Assert
    assertEquals(qualifyingItemSubTotal, offerImpl2.getOrderMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#setOrderMinSubTotal(Money)}.
   * <p>
   * Method under test: {@link OfferImpl#setOrderMinSubTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setOrderMinSubTotal(Money)"})
  public void testSetOrderMinSubTotal() {
    // Arrange
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

    // Act
    offerImpl2.setOrderMinSubTotal(null);

    // Assert
    Money qualifyingItemSubTotal = offerImpl2.getQualifyingItemSubTotal();
    Currency currency = qualifyingItemSubTotal.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(offerImpl2.orderMinSubTotal);
    assertNull(offerImpl2.getOrderMinSubTotal());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertSame(currency, qualifyingItemSubTotal.abs().getCurrency());
    Money targetMinSubTotal = offerImpl2.getTargetMinSubTotal();
    assertSame(currency, targetMinSubTotal.abs().getCurrency());
    assertSame(currency, qualifyingItemSubTotal.zero().getCurrency());
    assertSame(currency, targetMinSubTotal.zero().getCurrency());
    assertSame(currency, targetMinSubTotal.getCurrency());
  }

  /**
   * Test {@link OfferImpl#setOrderMinSubTotal(Money)}.
   * <ul>
   *   <li>Then {@link OfferImpl} (default constructor) {@link OfferImpl#orderMinSubTotal} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setOrderMinSubTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setOrderMinSubTotal(Money)"})
  public void testSetOrderMinSubTotal_thenOfferImplOrderMinSubTotalIsBigDecimalWith000() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    Money orderMinSubTotal = new Money();

    // Act
    offerImpl2.setOrderMinSubTotal(orderMinSubTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), offerImpl2.orderMinSubTotal);
    BigDecimal bigDecimal = offerImpl2.orderMinSubTotal;
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
   * Test {@link OfferImpl#getTargetMinSubTotal()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetMinSubTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OfferImpl.getTargetMinSubTotal()"})
  public void testGetTargetMinSubTotal_givenOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getTargetMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getTargetMinSubTotal()}.
   * <ul>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#getTargetMinSubTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money OfferImpl.getTargetMinSubTotal()"})
  public void testGetTargetMinSubTotal_thenReturnMoney() {
    // Arrange
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
    Money orderMinSubTotal = new Money();
    offerImpl2.setOrderMinSubTotal(orderMinSubTotal);
    offerImpl2.setPriority(1);
    offerImpl2.setQualifyingItemCriteriaXref(new HashSet<>());
    offerImpl2.setQualifyingItemSubTotal(new Money());
    offerImpl2.setRequiresRelatedTargetAndQualifiers(true);
    offerImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl2.setTargetSystem("Target System");
    offerImpl2.setTotalitarianOffer(true);
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));
    offerImpl2.setTargetMinSubTotal(new Money());

    // Act and Assert
    assertEquals(orderMinSubTotal, offerImpl2.getTargetMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#setTargetMinSubTotal(Money)}.
   * <ul>
   *   <li>Then {@link OfferImpl} (default constructor) {@link OfferImpl#targetMinSubTotal} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setTargetMinSubTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setTargetMinSubTotal(Money)"})
  public void testSetTargetMinSubTotal_thenOfferImplTargetMinSubTotalIsBigDecimalWith000() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    Money targetMinSubTotal = new Money();

    // Act
    offerImpl2.setTargetMinSubTotal(targetMinSubTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), offerImpl2.targetMinSubTotal);
    BigDecimal bigDecimal = offerImpl2.targetMinSubTotal;
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
   * <ul>
   *   <li>Then {@link OfferImpl} (default constructor) {@link OfferImpl#targetMinSubTotal} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#setTargetMinSubTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OfferImpl.setTargetMinSubTotal(Money)"})
  public void testSetTargetMinSubTotal_thenOfferImplTargetMinSubTotalIsNull() {
    // Arrange
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

    // Act
    offerImpl2.setTargetMinSubTotal(null);

    // Assert
    assertNull(offerImpl2.targetMinSubTotal);
    assertNull(offerImpl2.getTargetMinSubTotal());
  }

  /**
   * Test {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}.
   * <p>
   * Method under test: {@link OfferImpl#getRequiresRelatedTargetAndQualifiers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferImpl.getRequiresRelatedTargetAndQualifiers()"})
  public void testGetRequiresRelatedTargetAndQualifiers() {
    // Arrange
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
    offerImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl2.setTargetMinSubTotal(new Money());
    offerImpl2.setTargetSystem("Target System");
    offerImpl2.setTotalitarianOffer(true);
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));
    offerImpl2.setRequiresRelatedTargetAndQualifiers(null);

    // Act and Assert
    assertFalse(offerImpl2.getRequiresRelatedTargetAndQualifiers());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferImpl.getRequiresRelatedTargetAndQualifiers()"})
  public void testGetRequiresRelatedTargetAndQualifiers_givenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OfferImpl()).getRequiresRelatedTargetAndQualifiers());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OfferImpl.getRequiresRelatedTargetAndQualifiers()"})
  public void testGetRequiresRelatedTargetAndQualifiers_thenReturnTrue() {
    // Arrange
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
    offerImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerImpl2.setTargetItemCriteriaXref(new HashSet<>());
    offerImpl2.setTargetMinSubTotal(new Money());
    offerImpl2.setTargetSystem("Target System");
    offerImpl2.setTotalitarianOffer(true);
    offerImpl2.setType(OfferType.FULFILLMENT_GROUP);
    offerImpl2.setUseListForDiscounts(true);
    offerImpl2.setValue(new BigDecimal("2.3"));
    offerImpl2.setRequiresRelatedTargetAndQualifiers(true);

    // Act and Assert
    assertTrue(offerImpl2.getRequiresRelatedTargetAndQualifiers());
  }

  /**
   * Test {@link OfferImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link OfferImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OfferImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new OfferImpl()).getMainEntityName());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferAdjustmentType OfferImpl.getAdjustmentType()"})
  public void testGetAdjustmentType_givenOfferImpl_thenReturnOrder_discount() {
    // Arrange and Act
    OfferAdjustmentType actualAdjustmentType = (new OfferImpl()).getAdjustmentType();

    // Assert
    assertSame(actualAdjustmentType.ORDER_DISCOUNT, actualAdjustmentType);
  }

  /**
   * Test {@link OfferImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is {@link OfferAdjustmentType#FUTURE_CREDIT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isFutureCredit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isFutureCredit()"})
  public void testIsFutureCredit_givenOfferImplAdjustmentTypeIsFuture_credit_thenReturnTrue() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);

    // Act and Assert
    assertTrue(offerImpl2.isFutureCredit());
  }

  /**
   * Test {@link OfferImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) AdjustmentType is {@link OfferAdjustmentType#ORDER_DISCOUNT}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferImpl#isFutureCredit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isFutureCredit()"})
  public void testIsFutureCredit_givenOfferImplAdjustmentTypeIsOrder_discount_thenReturnFalse() {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    offerImpl2.setAdjustmentType(OfferAdjustmentType.ORDER_DISCOUNT);

    // Act and Assert
    assertFalse(offerImpl2.isFutureCredit());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OfferImpl.isFutureCredit()"})
  public void testIsFutureCredit_givenOfferImpl_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
   * Method under test: {@link OfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse OfferImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    OfferImpl offerImpl2 = new OfferImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Offer> actualCreateOrRetrieveCopyInstanceResult = offerImpl2.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link OfferImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OfferImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
