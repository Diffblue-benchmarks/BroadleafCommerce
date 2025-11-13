package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
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
