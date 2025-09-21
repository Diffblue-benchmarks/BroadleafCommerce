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
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferPriceDataIdentifierType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferPriceDataImplDiffblueTest {
  @Autowired private OfferPriceDataImpl offerPriceDataImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataImpl#setActiveEndDate(Date)}
   *   <li>{@link OfferPriceDataImpl#setActiveStartDate(Date)}
   *   <li>{@link OfferPriceDataImpl#setAmount(BigDecimal)}
   *   <li>{@link OfferPriceDataImpl#setId(Long)}
   *   <li>{@link OfferPriceDataImpl#setIdentifierValue(String)}
   *   <li>{@link OfferPriceDataImpl#setOffer(Offer)}
   *   <li>{@link OfferPriceDataImpl#setQuantity(Integer)}
   *   <li>{@link OfferPriceDataImpl#getActiveEndDate()}
   *   <li>{@link OfferPriceDataImpl#getActiveStartDate()}
   *   <li>{@link OfferPriceDataImpl#getAmount()}
   *   <li>{@link OfferPriceDataImpl#getId()}
   *   <li>{@link OfferPriceDataImpl#getIdentifierValue()}
   *   <li>{@link OfferPriceDataImpl#getOffer()}
   *   <li>{@link OfferPriceDataImpl#getQuantity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Date OfferPriceDataImpl.getActiveEndDate()",
    "Date OfferPriceDataImpl.getActiveStartDate()",
    "BigDecimal OfferPriceDataImpl.getAmount()",
    "Long OfferPriceDataImpl.getId()",
    "String OfferPriceDataImpl.getIdentifierValue()",
    "Offer OfferPriceDataImpl.getOffer()",
    "Integer OfferPriceDataImpl.getQuantity()",
    "void OfferPriceDataImpl.setActiveEndDate(Date)",
    "void OfferPriceDataImpl.setActiveStartDate(Date)",
    "void OfferPriceDataImpl.setAmount(BigDecimal)",
    "void OfferPriceDataImpl.setId(Long)",
    "void OfferPriceDataImpl.setIdentifierValue(String)",
    "void OfferPriceDataImpl.setOffer(Offer)",
    "void OfferPriceDataImpl.setQuantity(Integer)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    Date activeEndDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    offerPriceDataImpl.setActiveEndDate(activeEndDate);
    Date activeStartDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offerPriceDataImpl.setActiveStartDate(activeStartDate);
    BigDecimal amount = new BigDecimal("2.3");
    offerPriceDataImpl.setAmount(amount);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierValue("42");
    OfferImpl offer = new OfferImpl();
    offerPriceDataImpl.setOffer(offer);
    offerPriceDataImpl.setQuantity(1);
    Date actualActiveEndDate = offerPriceDataImpl.getActiveEndDate();
    Date actualActiveStartDate = offerPriceDataImpl.getActiveStartDate();
    BigDecimal actualAmount = offerPriceDataImpl.getAmount();
    Long actualId = offerPriceDataImpl.getId();
    String actualIdentifierValue = offerPriceDataImpl.getIdentifierValue();
    Offer actualOffer = offerPriceDataImpl.getOffer();

    // Assert
    assertEquals("42", actualIdentifierValue);
    assertEquals(1, offerPriceDataImpl.getQuantity().intValue());
    assertEquals(new BigDecimal("2.3"), actualAmount);
    assertEquals(OfferPriceDataImpl.serialVersionUID, actualId.longValue());
    assertSame(amount, actualAmount);
    assertSame(offer, actualOffer);
    assertSame(activeEndDate, actualActiveEndDate);
    assertSame(activeStartDate, actualActiveStartDate);
  }

  /**
   * Test {@link OfferPriceDataImpl#getIdentifierType()}.
   *
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#getIdentifierType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferPriceDataIdentifierType OfferPriceDataImpl.getIdentifierType()"})
  public void testGetIdentifierType_givenOfferPriceDataImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(offerPriceDataImpl.getIdentifierType());
  }

  /**
   * Test {@link OfferPriceDataImpl#getIdentifierType()}.
   *
   * <ul>
   *   <li>Then return {@link OfferPriceDataIdentifierType#PRODUCT_EXTERNAL_ID}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#getIdentifierType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferPriceDataIdentifierType OfferPriceDataImpl.getIdentifierType()"})
  public void testGetIdentifierType_thenReturnProduct_external_id() {
    // Arrange
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);

    // Act and Assert
    assertSame(
        OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID, offerPriceDataImpl.getIdentifierType());
  }

  /**
   * Test {@link OfferPriceDataImpl#setIdentifierType(OfferPriceDataIdentifierType)}.
   *
   * <ul>
   *   <li>Then {@link OfferPriceDataImpl} {@link OfferPriceDataImpl#identifierType} is {@code
   *       PRODUCT_EXTERNAL_ID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OfferPriceDataImpl#setIdentifierType(OfferPriceDataIdentifierType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType)"})
  public void testSetIdentifierType_thenOfferPriceDataImplIdentifierTypeIsProductExternalId() {
    // Arrange and Act
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);

    // Assert
    assertEquals("PRODUCT_EXTERNAL_ID", offerPriceDataImpl.identifierType);
    assertSame(
        OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID, offerPriceDataImpl.getIdentifierType());
  }

  /**
   * Test {@link OfferPriceDataImpl#getDiscountType()}.
   *
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#getDiscountType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferDiscountType OfferPriceDataImpl.getDiscountType()"})
  public void testGetDiscountType_givenOfferPriceDataImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(offerPriceDataImpl.getDiscountType());
  }

  /**
   * Test {@link OfferPriceDataImpl#getDiscountType()}.
   *
   * <ul>
   *   <li>Then return {@link OfferDiscountType#AMOUNT_OFF}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#getDiscountType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferDiscountType OfferPriceDataImpl.getDiscountType()"})
  public void testGetDiscountType_thenReturnAmount_off() {
    // Arrange
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);

    // Act and Assert
    assertSame(OfferDiscountType.AMOUNT_OFF, offerPriceDataImpl.getDiscountType());
  }

  /**
   * Test {@link OfferPriceDataImpl#setDiscountType(OfferDiscountType)}.
   *
   * <ul>
   *   <li>When {@link OfferDiscountType#AMOUNT_OFF}.
   *   <li>Then {@link OfferPriceDataImpl} {@link OfferPriceDataImpl#discountType} is {@code
   *       AMOUNT_OFF}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#setDiscountType(OfferDiscountType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferPriceDataImpl.setDiscountType(OfferDiscountType)"})
  public void testSetDiscountType_whenAmount_off_thenOfferPriceDataImplDiscountTypeIsAmountOff() {
    // Arrange and Act
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);

    // Assert
    assertEquals("AMOUNT_OFF", offerPriceDataImpl.discountType);
    assertSame(OfferDiscountType.AMOUNT_OFF, offerPriceDataImpl.getDiscountType());
  }

  /**
   * Test {@link OfferPriceDataImpl#getArchived()}.
   *
   * <p>Method under test: {@link OfferPriceDataImpl#getArchived()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Character OfferPriceDataImpl.getArchived()"})
  public void testGetArchived() {
    // Arrange, Act and Assert
    assertEquals('N', offerPriceDataImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferPriceDataImpl#setArchived(Character)}.
   *
   * <p>Method under test: {@link OfferPriceDataImpl#setArchived(Character)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferPriceDataImpl.setArchived(Character)"})
  public void testSetArchived() {
    // Arrange and Act
    offerPriceDataImpl.setArchived('A');

    // Assert
    assertEquals('A', offerPriceDataImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', offerPriceDataImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   *
   * <p>Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferPriceDataImpl.isActive()"})
  public void testIsActive() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(null);
    offerPriceDataImpl.setOffer(offer);
    offerPriceDataImpl.setActiveEndDate(null);
    offerPriceDataImpl.setArchived(null);

    // Act and Assert
    assertFalse(offerPriceDataImpl.isActive());
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link Offer} {@link Offer#getEndDate()} return {@code null}.
   *   <li>Then calls {@link Offer#getEndDate()}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferPriceDataImpl.isActive()"})
  public void testIsActive_givenOfferGetEndDateReturnNull_thenCallsGetEndDate() {
    // Arrange
    Offer offer = mock(Offer.class);
    when(offer.getEndDate()).thenReturn(null);
    when(offer.getStartDate()).thenReturn(null);

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setOffer(offer);

    // Act
    boolean actualIsActiveResult = offerPriceDataImpl.isActive();

    // Assert
    verify(offer).getEndDate();
    verify(offer).getStartDate();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) EndDate is {@link Date#Date()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferPriceDataImpl.isActive()"})
  public void testIsActive_givenOfferImplEndDateIsDate_thenReturnFalse() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));
    offer.setEndDate(new Date());
    offerPriceDataImpl.setActiveStartDate(null);
    offerPriceDataImpl.setOffer(offer);
    offerPriceDataImpl.setActiveEndDate(null);
    offerPriceDataImpl.setArchived('Y');

    // Act and Assert
    assertFalse(offerPriceDataImpl.isActive());
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OfferImpl} (default constructor) StartDate is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferPriceDataImpl.isActive()"})
  public void testIsActive_givenOfferImplStartDateIsNull_thenReturnFalse() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(null);
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));
    offer.setEndDate(null);
    offerPriceDataImpl.setActiveStartDate(null);
    offerPriceDataImpl.setOffer(offer);
    offerPriceDataImpl.setActiveEndDate(null);
    offerPriceDataImpl.setArchived(null);

    // Act and Assert
    assertFalse(offerPriceDataImpl.isActive());
  }

  /**
   * Test {@link OfferPriceDataImpl#isActive()}.
   *
   * <ul>
   *   <li>Given {@link OfferPriceDataImpl} Archived is {@code Y}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OfferPriceDataImpl.isActive()"})
  public void testIsActive_givenOfferPriceDataImplArchivedIsY_thenReturnFalse() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));
    offer.setEndDate(null);
    offerPriceDataImpl.setActiveStartDate(null);
    offerPriceDataImpl.setOffer(offer);
    offerPriceDataImpl.setActiveEndDate(null);
    offerPriceDataImpl.setArchived('Y');

    // Act and Assert
    assertFalse(offerPriceDataImpl.isActive());
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}, and {@link OfferPriceDataImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataImpl#equals(Object)}
   *   <li>{@link OfferPriceDataImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(offerPriceDataImpl, offerPriceDataImpl2);
    assertEquals(offerPriceDataImpl.hashCode(), offerPriceDataImpl2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}, and {@link OfferPriceDataImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataImpl#equals(Object)}
   *   <li>{@link OfferPriceDataImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(null);
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(null);
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertEquals(offerPriceDataImpl, offerPriceDataImpl2);
    assertEquals(offerPriceDataImpl.hashCode(), offerPriceDataImpl2.hashCode());
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}, and {@link OfferPriceDataImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OfferPriceDataImpl#equals(Object)}
   *   <li>{@link OfferPriceDataImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    // Act and Assert
    assertEquals(offerPriceDataImpl, offerPriceDataImpl);
    int expectedHashCodeResult = offerPriceDataImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerPriceDataImpl.hashCode());
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(new Date());
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(null);
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(new Date());
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(BigDecimal.valueOf(OfferPriceDataImpl.serialVersionUID));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.FIX_PRICE);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(2L);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("Identifier Value");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setId(OfferImpl.serialVersionUID);

    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(offer);
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(0);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(new OfferDiscountType());
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    OfferPriceDataImpl offerPriceDataImpl2 = new OfferPriceDataImpl();
    offerPriceDataImpl2.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl2.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl2.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl2.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl2.setIdentifierType(new OfferPriceDataIdentifierType());
    offerPriceDataImpl2.setIdentifierValue("42");
    offerPriceDataImpl2.setOffer(new OfferImpl());
    offerPriceDataImpl2.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, offerPriceDataImpl2);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, null);
  }

  /**
   * Test {@link OfferPriceDataImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OfferPriceDataImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OfferPriceDataImpl.equals(Object)",
    "int OfferPriceDataImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferPriceDataImpl offerPriceDataImpl = new OfferPriceDataImpl();
    offerPriceDataImpl.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerPriceDataImpl.setAmount(new BigDecimal("2.3"));
    offerPriceDataImpl.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offerPriceDataImpl.setId(OfferPriceDataImpl.serialVersionUID);
    offerPriceDataImpl.setIdentifierType(OfferPriceDataIdentifierType.PRODUCT_EXTERNAL_ID);
    offerPriceDataImpl.setIdentifierValue("42");
    offerPriceDataImpl.setOffer(new OfferImpl());
    offerPriceDataImpl.setQuantity(1);

    // Act and Assert
    assertNotEquals(offerPriceDataImpl, "Different type to OfferPriceDataImpl");
  }

  /**
   * Test new {@link OfferPriceDataImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OfferPriceDataImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferPriceDataImpl.<init>()"})
  public void testNewOfferPriceDataImpl() {
    // Arrange and Act
    OfferPriceDataImpl actualOfferPriceDataImpl = new OfferPriceDataImpl();

    // Assert
    assertEquals('N', actualOfferPriceDataImpl.getArchived().charValue());
    assertNull(actualOfferPriceDataImpl.getQuantity());
    assertNull(actualOfferPriceDataImpl.getId());
    assertNull(actualOfferPriceDataImpl.getIdentifierValue());
    assertNull(actualOfferPriceDataImpl.discountType);
    assertNull(actualOfferPriceDataImpl.identifierType);
    assertNull(actualOfferPriceDataImpl.getAmount());
    assertNull(actualOfferPriceDataImpl.getActiveEndDate());
    assertNull(actualOfferPriceDataImpl.getActiveStartDate());
    assertNull(actualOfferPriceDataImpl.getOffer());
    assertNull(actualOfferPriceDataImpl.getDiscountType());
    assertNull(actualOfferPriceDataImpl.getIdentifierType());
  }
}
