package org.broadleafcommerce.core.promotionMessage.dto.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.broadleafcommerce.common.locale.domain.Locale;
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
import org.broadleafcommerce.profile.core.dto.CustomerRuleHolder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PromotionMessageDTOServiceImplDiffblueTest {
  @Autowired
  private PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl;

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   * with {@code promotionMessages}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessages() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(null);

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult = promotionMessageDTOServiceImpl
        .convertPromotionMessagesToDTOs(promotionMessages);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult = actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertNull(getResult2.getCustomerRuleHolder().getCustomerRule());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, getResult2.getMedia());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   * with {@code promotionMessages}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessages2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(new LocaleImpl());

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult = promotionMessageDTOServiceImpl
        .convertPromotionMessagesToDTOs(promotionMessages);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult = actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertNull(getResult2.getCustomerRuleHolder().getCustomerRule());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, getResult2.getMedia());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   * with {@code promotionMessages}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessages3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();
    PromotionMessageImpl promotionMessageImpl = mock(PromotionMessageImpl.class);
    when(promotionMessageImpl.getPriority()).thenReturn(1);
    when(promotionMessageImpl.getMessage()).thenReturn("Not all who wander are lost");
    when(promotionMessageImpl.getMessagePlacement()).thenReturn("Message Placement");
    when(promotionMessageImpl.getEndDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(promotionMessageImpl.getLocale()).thenReturn(new LocaleImpl());
    CategoryMediaXrefImpl categoryMediaXrefImpl = new CategoryMediaXrefImpl();
    when(promotionMessageImpl.getMedia()).thenReturn(categoryMediaXrefImpl);
    doNothing().when(promotionMessageImpl).setEndDate(Mockito.<Date>any());
    doNothing().when(promotionMessageImpl).setId(Mockito.<Long>any());
    doNothing().when(promotionMessageImpl).setLocale(Mockito.<Locale>any());
    doNothing().when(promotionMessageImpl).setMedia(Mockito.<Media>any());
    doNothing().when(promotionMessageImpl).setMessage(Mockito.<String>any());
    doNothing().when(promotionMessageImpl).setMessagePlacement(Mockito.<String>any());
    doNothing().when(promotionMessageImpl).setName(Mockito.<String>any());
    doNothing().when(promotionMessageImpl).setPriority(Mockito.<Integer>any());
    doNothing().when(promotionMessageImpl).setStartDate(Mockito.<Date>any());
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    promotionMessageImpl.setMedia(new CategoryMediaXrefImpl());
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(null);

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult = promotionMessageDTOServiceImpl
        .convertPromotionMessagesToDTOs(promotionMessages);

    // Assert
    verify(promotionMessageImpl).getEndDate();
    verify(promotionMessageImpl, atLeast(1)).getLocale();
    verify(promotionMessageImpl).getMedia();
    verify(promotionMessageImpl).getMessage();
    verify(promotionMessageImpl).getMessagePlacement();
    verify(promotionMessageImpl).getPriority();
    verify(promotionMessageImpl).setEndDate(isA(Date.class));
    verify(promotionMessageImpl).setId(eq(1L));
    verify(promotionMessageImpl).setLocale(isNull());
    verify(promotionMessageImpl).setMedia(isA(Media.class));
    verify(promotionMessageImpl).setMessage(eq("Promotion Message"));
    verify(promotionMessageImpl).setMessagePlacement(eq("Message Location"));
    verify(promotionMessageImpl).setName(eq("Name"));
    verify(promotionMessageImpl).setPriority(eq(1));
    verify(promotionMessageImpl).setStartDate(isA(Date.class));
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult = actualConvertPromotionMessagesToDTOsResult.get("Message Placement");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    assertEquals("Message Placement", getResult2.getMessagePlacement());
    assertEquals("Not all who wander are lost", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertNull(getResult2.getCustomerRuleHolder().getCustomerRule());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(categoryMediaXrefImpl, getResult2.getMedia());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   * with {@code promotionMessages}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertPromotionMessagesToDTOsWithPromotionMessages4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.promotionMessage.dto.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2577 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.promotionMessage.dto.service.PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl2 = new PromotionMessageDTOServiceImpl();

    // Act
    promotionMessageDTOServiceImpl2.convertPromotionMessagesToDTOs(new HashSet<>());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   * with {@code promotionMessages}, {@code offer}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));
    offer.setOfferMatchRulesXref(offerMatchRulesXref);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult = promotionMessageDTOServiceImpl
        .convertPromotionMessagesToDTOs(promotionMessages, offer);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult = actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertNull(getResult2.getCustomerRuleHolder().getCustomerRule());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, getResult2.getMedia());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   * with {@code promotionMessages}, {@code offer}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));
    offer.setOfferMatchRulesXref(offerMatchRulesXref);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult = promotionMessageDTOServiceImpl
        .convertPromotionMessagesToDTOs(promotionMessages, offer);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult = actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertNull(getResult2.getCustomerRuleHolder().getCustomerRule());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, getResult2.getMedia());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   * with {@code promotionMessages}, {@code offer}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(new LocaleImpl());

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult = promotionMessageDTOServiceImpl
        .convertPromotionMessagesToDTOs(promotionMessages, null);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult = actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertNull(getResult2.getCustomerRuleHolder().getCustomerRule());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, getResult2.getMedia());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   * with {@code promotionMessages}, {@code offer}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.promotionMessage.dto.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2580 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.promotionMessage.dto.service.PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl2 = new PromotionMessageDTOServiceImpl();
    HashSet<PromotionMessage> promotionMessages = new HashSet<>();

    // Act
    promotionMessageDTOServiceImpl2.convertPromotionMessagesToDTOs(promotionMessages, new OfferImpl());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   * with {@code promotionMessages}, {@code offer}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();
    HashSet<PromotionMessage> promotionMessages = new HashSet<>();

    // Act and Assert
    assertTrue(
        promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(promotionMessages, new OfferImpl()).isEmpty());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   * with {@code promotionMessages}, {@code offer}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(null);

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult = promotionMessageDTOServiceImpl
        .convertPromotionMessagesToDTOs(promotionMessages, null);

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult = actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertNull(getResult2.getCustomerRuleHolder().getCustomerRule());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, getResult2.getMedia());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   * with {@code promotionMessages}, {@code offer}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer_whenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    PromotionMessageImpl promotionMessageImpl = new PromotionMessageImpl();
    promotionMessageImpl
        .setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setId(PromotionMessageImpl.serialVersionUID);
    CategoryMediaXrefImpl media = new CategoryMediaXrefImpl();
    promotionMessageImpl.setMedia(media);
    promotionMessageImpl.setMessage("Promotion Message");
    promotionMessageImpl.setMessagePlacement("Message Location");
    promotionMessageImpl.setName("Name");
    promotionMessageImpl.setPriority(1);
    promotionMessageImpl
        .setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    promotionMessageImpl.setLocale(null);

    LinkedHashSet<PromotionMessage> promotionMessages = new LinkedHashSet<>();
    promotionMessages.add(promotionMessageImpl);

    // Act
    Map<String, List<PromotionMessageDTO>> actualConvertPromotionMessagesToDTOsResult = promotionMessageDTOServiceImpl
        .convertPromotionMessagesToDTOs(promotionMessages, new OfferImpl());

    // Assert
    assertEquals(1, actualConvertPromotionMessagesToDTOsResult.size());
    List<PromotionMessageDTO> getResult = actualConvertPromotionMessagesToDTOsResult.get("Message Location");
    assertEquals(1, getResult.size());
    PromotionMessageDTO getResult2 = getResult.get(0);
    assertEquals("Message Location", getResult2.getMessagePlacement());
    assertEquals("Promotion Message", getResult2.getMessage());
    assertNull(getResult2.getLocaleCode());
    assertNull(getResult2.getCustomerRuleHolder().getCustomerRule());
    assertEquals(1, getResult2.getPriority().intValue());
    assertSame(media, getResult2.getMedia());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   * with {@code promotionMessages}, {@code offer}.
   * <ul>
   *   <li>When {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set, Offer)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessagesOffer_whenOfferImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    // Act and Assert
    assertTrue(promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(new HashSet<>(), mock(OfferImpl.class))
        .isEmpty());
  }

  /**
   * Test
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   * with {@code promotionMessages}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#convertPromotionMessagesToDTOs(Set)}
   */
  @Test
  public void testConvertPromotionMessagesToDTOsWithPromotionMessages_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    // Act and Assert
    assertTrue(promotionMessageDTOServiceImpl.convertPromotionMessagesToDTOs(new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildCustomerRuleHolder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.promotionMessage.dto.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2547 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.promotionMessage.dto.service.PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl2 = new PromotionMessageDTOServiceImpl();

    // Act
    promotionMessageDTOServiceImpl2.buildCustomerRuleHolder(new OfferImpl());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code CUSTOMER} is
   * {@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}
   */
  @Test
  public void testBuildCustomerRuleHolder_givenHashMapCustomerIsOfferOfferRuleXrefImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

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
    offer.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link Offer#getOfferMatchRulesXref()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}
   */
  @Test
  public void testBuildCustomerRuleHolder_givenHashMap_thenCallsGetOfferMatchRulesXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();
    Offer offer = mock(Offer.class);
    when(offer.getOfferMatchRulesXref()).thenReturn(new HashMap<>());

    // Act
    CustomerRuleHolder actualBuildCustomerRuleHolderResult = promotionMessageDTOServiceImpl
        .buildCustomerRuleHolder(offer);

    // Assert
    verify(offer).getOfferMatchRulesXref();
    assertNull(actualBuildCustomerRuleHolderResult.getCustomerRule());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}.
   * <ul>
   *   <li>Given {@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()} Id is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}
   */
  @Test
  public void testBuildCustomerRuleHolder_givenOfferOfferRuleXrefImplIdIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

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
    offer.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}
   */
  @Test
  public void testBuildCustomerRuleHolder_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PromotionMessageDTOServiceImpl()).buildCustomerRuleHolder(null).getCustomerRule());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#buildCustomerRuleHolder(Offer)}
   */
  @Test
  public void testBuildCustomerRuleHolder_whenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    // Act and Assert
    assertNull(promotionMessageDTOServiceImpl.buildCustomerRuleHolder(new OfferImpl()).getCustomerRule());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}.
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCustomerRule() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.promotionMessage.dto.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2610 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.promotionMessage.dto.service.PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl2 = new PromotionMessageDTOServiceImpl();

    // Act
    promotionMessageDTOServiceImpl2.getCustomerRule(new OfferImpl());
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code CUSTOMER} is
   * {@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}
   */
  @Test
  public void testGetCustomerRule_givenHashMapCustomerIsOfferOfferRuleXrefImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

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
    offer.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link Offer#getOfferMatchRulesXref()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}
   */
  @Test
  public void testGetCustomerRule_givenHashMap_thenCallsGetOfferMatchRulesXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();
    Offer offer = mock(Offer.class);
    when(offer.getOfferMatchRulesXref()).thenReturn(new HashMap<>());

    // Act
    String actualCustomerRule = promotionMessageDTOServiceImpl.getCustomerRule(offer);

    // Assert
    verify(offer).getOfferMatchRulesXref();
    assertNull(actualCustomerRule);
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}.
   * <ul>
   *   <li>Given {@link OfferOfferRuleXrefImpl#OfferOfferRuleXrefImpl()} Id is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}
   */
  @Test
  public void testGetCustomerRule_givenOfferOfferRuleXrefImplIdIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

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
    offer.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    offer.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}
   */
  @Test
  public void testGetCustomerRule_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PromotionMessageDTOServiceImpl()).getCustomerRule(null));
  }

  /**
   * Test {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotionMessageDTOServiceImpl#getCustomerRule(Offer)}
   */
  @Test
  public void testGetCustomerRule_whenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotionMessageDTOServiceImpl promotionMessageDTOServiceImpl = new PromotionMessageDTOServiceImpl();

    // Act and Assert
    assertNull(promotionMessageDTOServiceImpl.getCustomerRule(new OfferImpl()));
  }
}
