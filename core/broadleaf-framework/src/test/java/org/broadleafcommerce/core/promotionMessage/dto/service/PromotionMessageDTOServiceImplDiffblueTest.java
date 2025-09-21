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
package org.broadleafcommerce.core.promotionMessage.dto.service;

import static org.junit.Assert.assertEquals;
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryMediaXrefImpl;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferOfferRuleXref;
import org.broadleafcommerce.core.offer.domain.OfferOfferRuleXrefImpl;
import org.broadleafcommerce.core.offer.domain.OfferRuleImpl;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.promotionMessage.domain.PromotionMessage;
import org.broadleafcommerce.core.promotionMessage.domain.PromotionMessageImpl;
import org.broadleafcommerce.core.promotionMessage.dto.PromotionMessageDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PromotionMessageDTOServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PromotionMessageDTOServiceImplDiffblueTest {
  @Autowired private PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl;

  /**
   * Test {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)} with {@code
   * promotionMessages}.
   *
   * <p>Method under test: {@link
   * PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PromotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(Set)"})
  public void testConvertPromotionMessagesToDTOsWithPromotionMessages() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(null);

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult =
        promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(promotionMessages);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult =
        actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    Media media2 = getResult2.getMedia();
    assertTrue(media2 instanceof CategoryMediaXrefImpl);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, media2);
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)} with {@code
   * promotionMessages}.
   *
   * <p>Method under test: {@link
   * PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PromotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(Set)"})
  public void testConvertPromotionMessagesToDTOsWithPromotionMessages2() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(new LocaleImpl());

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult =
        promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(promotionMessages);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult =
        actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    Media media2 = getResult2.getMedia();
    assertTrue(media2 instanceof CategoryMediaXrefImpl);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, media2);
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)} with
   * {@code promotionMessages}, {@code offer}.
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map PromotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(Set, Offer)"
  })
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(null);

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    HashMap<String, OfferOfferRuleXref> offerMatchRulesXref = new HashMap<>();
    offerMatchRulesXref.put("CUSTOMER", new OfferOfferRuleXrefImpl());

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setOfferMatchRulesXref(offerMatchRulesXref);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult =
        promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(promotionMessages, offer);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult =
        actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    Media media2 = getResult2.getMedia();
    assertTrue(media2 instanceof CategoryMediaXrefImpl);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, media2);
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)} with
   * {@code promotionMessages}, {@code offer}.
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map PromotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(Set, Offer)"
  })
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer2() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(null);

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl.setId(1L);
    offerOfferRuleXrefImpl.setKey("Key");
    offerOfferRuleXrefImpl.setOffer(new OfferImpl());
    offerOfferRuleXrefImpl.setOfferRule(new OfferRuleImpl());

    HashMap<String, OfferOfferRuleXref> offerMatchRulesXref = new HashMap<>();
    offerMatchRulesXref.put("CUSTOMER", offerOfferRuleXrefImpl);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setOfferMatchRulesXref(offerMatchRulesXref);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult =
        promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(promotionMessages, offer);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult =
        actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    Media media2 = getResult2.getMedia();
    assertTrue(media2 instanceof CategoryMediaXrefImpl);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, media2);
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)} with
   * {@code promotionMessages}, {@code offer}.
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map PromotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(Set, Offer)"
  })
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer3() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(new LocaleImpl());

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult =
        promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(promotionMessages, null);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult =
        actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    Media media2 = getResult2.getMedia();
    assertTrue(media2 instanceof CategoryMediaXrefImpl);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, media2);
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)} with
   * {@code promotionMessages}, {@code offer}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map PromotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(Set, Offer)"
  })
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer_thenReturnEmpty() {
    // Arrange
    HashSet<PromotionMessage> promotionMessages = new HashSet<>();

    // Act and Assert
    assertTrue(
        promotionMessageDTOServiceImpl
            .convertPromotionMessagesToDTOs(promotionMessages, new OfferImpl())
            .isEmpty());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)} with
   * {@code promotionMessages}, {@code offer}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map PromotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(Set, Offer)"
  })
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer_whenNull() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(null);

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult =
        promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(promotionMessages, null);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult =
        actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    Media media2 = getResult2.getMedia();
    assertTrue(media2 instanceof CategoryMediaXrefImpl);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, media2);
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)} with
   * {@code promotionMessages}, {@code offer}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map PromotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(Set, Offer)"
  })
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer_whenOfferImpl() {
    // Arrange
    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(null);

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult =
        promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(
            promotionMessages, new OfferImpl());

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult =
        actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    Media media2 = getResult2.getMedia();
    assertTrue(media2 instanceof CategoryMediaXrefImpl);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, media2);
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)} with {@code
   * promotionMessages}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PromotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(Set)"})
  public void testConvertPromotionMessagesToDTOsWithPromotionMessages_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code CUSTOMER} is {@link
   *       OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.profile.core.dto.CustomerRuleHolder PromotionMessageDTOServiceImpl.buildCustomerRuleHolder(Offer)"
  })
  public void testBuildCustomerRuleHolder_givenHashMapCustomerIsOfferOfferRuleXrefImpl() {
    // Arrange
    HashMap<String, OfferOfferRuleXref> offerMatchRulesXref = new HashMap<>();
    offerMatchRulesXref.put("CUSTOMER", new OfferOfferRuleXrefImpl());

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setOfferMatchRulesXref(offerMatchRulesXref);

    // Act and Assert
    assertNull(promotionMessageDTOServiceImpl.buildCustomerRuleHolder(offer).getCustomerRule());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}.
   *
   * <ul>
   *   <li>Given {@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()} Id is one.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.profile.core.dto.CustomerRuleHolder PromotionMessageDTOServiceImpl.buildCustomerRuleHolder(Offer)"
  })
  public void testBuildCustomerRuleHolder_givenOfferOfferRuleXrefImplIdIsOne() {
    // Arrange
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl.setId(1L);
    offerOfferRuleXrefImpl.setKey("Key");
    offerOfferRuleXrefImpl.setOffer(new OfferImpl());
    offerOfferRuleXrefImpl.setOfferRule(new OfferRuleImpl());

    HashMap<String, OfferOfferRuleXref> offerMatchRulesXref = new HashMap<>();
    offerMatchRulesXref.put("CUSTOMER", offerOfferRuleXrefImpl);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setOfferMatchRulesXref(offerMatchRulesXref);

    // Act and Assert
    assertNull(promotionMessageDTOServiceImpl.buildCustomerRuleHolder(offer).getCustomerRule());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.profile.core.dto.CustomerRuleHolder PromotionMessageDTOServiceImpl.buildCustomerRuleHolder(Offer)"
  })
  public void testBuildCustomerRuleHolder_whenNull() {
    // Arrange, Act and Assert
    assertNull(promotionMessageDTOServiceImpl.buildCustomerRuleHolder(null).getCustomerRule());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.profile.core.dto.CustomerRuleHolder PromotionMessageDTOServiceImpl.buildCustomerRuleHolder(Offer)"
  })
  public void testBuildCustomerRuleHolder_whenOfferImpl() {
    // Arrange, Act and Assert
    assertNull(
        promotionMessageDTOServiceImpl.buildCustomerRuleHolder(new OfferImpl()).getCustomerRule());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code CUSTOMER} is {@link
   *       OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PromotionMessageDTOServiceImpl.getCustomerRule(Offer)"})
  public void testGetCustomerRule_givenHashMapCustomerIsOfferOfferRuleXrefImpl() {
    // Arrange
    HashMap<String, OfferOfferRuleXref> offerMatchRulesXref = new HashMap<>();
    offerMatchRulesXref.put("CUSTOMER", new OfferOfferRuleXrefImpl());

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setOfferMatchRulesXref(offerMatchRulesXref);

    // Act and Assert
    assertNull(promotionMessageDTOServiceImpl.getCustomerRule(offer));
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}.
   *
   * <ul>
   *   <li>Given {@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()} Id is one.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PromotionMessageDTOServiceImpl.getCustomerRule(Offer)"})
  public void testGetCustomerRule_givenOfferOfferRuleXrefImplIdIsOne() {
    // Arrange
    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl.setId(1L);
    offerOfferRuleXrefImpl.setKey("Key");
    offerOfferRuleXrefImpl.setOffer(new OfferImpl());
    offerOfferRuleXrefImpl.setOfferRule(new OfferRuleImpl());

    HashMap<String, OfferOfferRuleXref> offerMatchRulesXref = new HashMap<>();
    offerMatchRulesXref.put("CUSTOMER", offerOfferRuleXrefImpl);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setOfferMatchRulesXref(offerMatchRulesXref);

    // Act and Assert
    assertNull(promotionMessageDTOServiceImpl.getCustomerRule(offer));
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PromotionMessageDTOServiceImpl.getCustomerRule(Offer)"})
  public void testGetCustomerRule_whenNull() {
    // Arrange, Act and Assert
    assertNull(promotionMessageDTOServiceImpl.getCustomerRule(null));
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PromotionMessageDTOServiceImpl.getCustomerRule(Offer)"})
  public void testGetCustomerRule_whenOfferImpl() {
    // Arrange, Act and Assert
    assertNull(promotionMessageDTOServiceImpl.getCustomerRule(new OfferImpl()));
  }
}
