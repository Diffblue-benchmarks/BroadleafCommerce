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
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CandidateItemOfferImplDiffblueTest {
  @Autowired
  private CandidateItemOfferImpl candidateItemOfferImpl;

  /**
   * Test {@link CandidateItemOfferImpl#setOffer(Offer)}.
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#setOffer(Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass550 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl candidateItemOfferImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();

    // Act
    candidateItemOfferImpl2.setOffer(new OfferImpl());
  }

  /**
   * Test {@link CandidateItemOfferImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then {@link CandidateItemOfferImpl} (default constructor)
   * {@link CandidateItemOfferImpl#offer} {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenCandidateItemOfferImplOfferOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    candidateItemOfferImpl.setOffer(offer);

    // Assert
    Offer offer2 = candidateItemOfferImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(((OfferImpl) offer2).maxUsesPerOrder);
    assertNull(((OfferImpl) offer2).priority);
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(((OfferImpl) offer2).maxUsesPerCustomer);
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(((OfferImpl) offer2).adjustmentType);
    assertNull(((OfferImpl) offer2).discountType);
    assertNull(((OfferImpl) offer2).marketingMessage);
    assertNull(((OfferImpl) offer2).maxUsesStrategy);
    assertNull(((OfferImpl) offer2).offerItemQualifierRuleType);
    assertNull(((OfferImpl) offer2).offerItemTargetRuleType);
    assertNull(((OfferImpl) offer2).type);
    assertNull(offer2.getValue());
    assertNull(((OfferImpl) offer2).orderMinSubTotal);
    assertNull(((OfferImpl) offer2).qualifyingItemSubTotal);
    assertNull(((OfferImpl) offer2).targetMinSubTotal);
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
    assertNull(((OfferImpl) offer2).startDate);
    assertNull(offer2.getOrderMinSubTotal());
    assertNull(offer2.getQualifyingItemSubTotal());
    assertNull(offer2.getTargetMinSubTotal());
    assertNull(offer2.getMaxUsesStrategyType());
    assertNull(offer2.getDiscountType());
    assertNull(offer2.getType());
    assertEquals(0, offer2.getMaxUsesPerOrder());
    assertEquals(0L, offer2.getMaxUsesPerCustomer().longValue());
    assertEquals(2147483646, candidateItemOfferImpl.getPriority());
    assertEquals(2147483646, offer2.getPriority());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertFalse(((OfferImpl) offer2).applyToChildItems);
    assertFalse(((OfferImpl) offer2).automaticallyAdded);
    assertFalse(((OfferImpl) offer2).requiresRelatedTargetAndQualifiers);
    assertFalse(((OfferImpl) offer2).totalitarianOffer);
    assertFalse(((OfferImpl) offer2).useListForDiscounts);
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertTrue(((OfferImpl) offer2).applyToSalePrice);
    assertTrue(((OfferImpl) offer2).combinableWithOtherOffers);
    assertSame(offer, candidateItemOfferImpl.getOffer());
    assertSame(offer, candidateItemOfferImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
  }

  /**
   * Test {@link CandidateItemOfferImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl}.</li>
   *   <li>Then {@link CandidateItemOfferImpl} (default constructor) Priority is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenCandidateItemOfferImplPriorityIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    OfferImpl offer = mock(OfferImpl.class);

    // Act
    candidateItemOfferImpl.setOffer(offer);

    // Assert
    assertEquals(0, candidateItemOfferImpl.getPriority());
    assertSame(offer, candidateItemOfferImpl.getOffer());
    assertSame(offer, candidateItemOfferImpl.deproxiedOffer);
  }

  /**
   * Test {@link CandidateItemOfferImpl#getPriority()}.
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getPriority()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPriority() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass535 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl candidateItemOfferImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CandidateItemOfferImpl()).getPriority();
  }

  /**
   * Test {@link CandidateItemOfferImpl#getOffer()}.
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getOffer()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass530 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl candidateItemOfferImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CandidateItemOfferImpl()).getOffer();
  }

  /**
   * Test {@link CandidateItemOfferImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link CandidateItemOfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenCandidateItemOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CandidateItemOfferImpl()).getOffer());
  }

  /**
   * Test {@link CandidateItemOfferImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link CandidateItemOfferImpl} (default constructor) OrderItem is
   * {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenCandidateItemOfferImplOrderItemIsBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setOrderItem(mock(BundleOrderItemImpl.class));

    // Act and Assert
    assertNull(candidateItemOfferImpl.getOffer());
  }

  /**
   * Test {@link CandidateItemOfferImpl#getDiscountedPrice()}.
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getDiscountedPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDiscountedPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass525 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl candidateItemOfferImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CandidateItemOfferImpl()).getDiscountedPrice();
  }

  /**
   * Test {@link CandidateItemOfferImpl#getDiscountedPrice()}.
   * <ul>
   *   <li>Given {@link CandidateItemOfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getDiscountedPrice()}
   */
  @Test
  public void testGetDiscountedPrice_givenCandidateItemOfferImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CandidateItemOfferImpl()).getDiscountedPrice());
  }

  /**
   * Test {@link CandidateItemOfferImpl#getDiscountedPrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getDiscountedPrice()}
   */
  @Test
  public void testGetDiscountedPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(CandidateItemOfferImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(CandidateItemOfferImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(CandidateItemOfferImpl.serialVersionUID);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(CandidateItemOfferImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(CandidateItemOfferImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setBaseRetailPrice(new Money());
    orderItem.setBaseSalePrice(new Money());
    orderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setDiscreteOrderItems(new ArrayList<>());
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(CandidateItemOfferImpl.serialVersionUID);
    orderItem.setName("Name");
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    orderItem.setOrder(order);

    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    Money discountedPrice = new Money();
    candidateItemOfferImpl.setDiscountedPrice(discountedPrice);
    candidateItemOfferImpl.setOrderItem(orderItem);

    // Act and Assert
    assertEquals(discountedPrice, candidateItemOfferImpl.getDiscountedPrice());
  }

  /**
   * Test {@link CandidateItemOfferImpl#getDiscountedPrice()}.
   * <ul>
   *   <li>Then return Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 2.30}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#getDiscountedPrice()}
   */
  @Test
  public void testGetDiscountedPrice_thenReturnAmountIsBigDecimalWith230() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setOrderItem(orderItem);
    candidateItemOfferImpl.setDiscountedPrice(discountedPrice);

    // Act
    Money actualDiscountedPrice = candidateItemOfferImpl.getDiscountedPrice();

    // Assert
    verify(discountedPrice).getAmount();
    verify(orderItem).getOrder();
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualDiscountedPrice.getAmount());
    assertEquals(actualDiscountedPrice, actualDiscountedPrice.abs());
    Money expectedZeroResult = actualDiscountedPrice.ZERO;
    assertEquals(expectedZeroResult, actualDiscountedPrice.zero());
  }

  /**
   * Test {@link CandidateItemOfferImpl#setDiscountedPrice(Money)}.
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetDiscountedPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass540 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl candidateItemOfferImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();

    // Act
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
  }

  /**
   * Test {@link CandidateItemOfferImpl#setDiscountedPrice(Money)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then calls {@link Money#getAmount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  public void testSetDiscountedPrice_givenBigDecimalWith23_thenCallsGetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    candidateItemOfferImpl.setDiscountedPrice(discountedPrice);

    // Assert
    verify(discountedPrice).getAmount();
  }

  /**
   * Test {@link CandidateItemOfferImpl#checkCloneable(CandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link CandidateItemOfferImpl#checkCloneable(CandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckCloneable() throws CloneNotSupportedException, NoSuchMethodException, SecurityException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass445 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl candidateItemOfferImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();

    // Act
    candidateItemOfferImpl2.checkCloneable(new CandidateItemOfferImpl());
  }

  /**
   * Test {@link CandidateItemOfferImpl#clone()}.
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#clone()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClone() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass457 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl candidateItemOfferImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CandidateItemOfferImpl()).clone();
  }

  /**
   * Test {@link CandidateItemOfferImpl#clone()}.
   * <ul>
   *   <li>Given {@link CandidateItemOfferImpl} (default constructor).</li>
   *   <li>Then return {@link CandidateItemOfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#clone()}
   */
  @Test
  public void testClone_givenCandidateItemOfferImpl_thenReturnCandidateItemOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();

    // Act
    CandidateItemOffer actualCloneResult = candidateItemOfferImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof CandidateItemOfferImpl);
    assertEquals(candidateItemOfferImpl, actualCloneResult);
  }

  /**
   * Test {@link CandidateItemOfferImpl#clone()}.
   * <ul>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#clone()}
   */
  @Test
  public void testClone_thenReturnIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setOrderItem(mock(BundleOrderItemImpl.class));

    // Act
    CandidateItemOffer actualCloneResult = candidateItemOfferImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof CandidateItemOfferImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getDiscountedPrice());
    assertNull(actualCloneResult.getOffer());
    assertNull(((CandidateItemOfferImpl) actualCloneResult).deproxiedOffer);
    assertNull(((CandidateItemOfferImpl) actualCloneResult).offer);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and
   * {@link CandidateItemOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
    int expectedHashCodeResult = candidateItemOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateItemOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and
   * {@link CandidateItemOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(discountedPrice);
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
    int notExpectedHashCodeResult = candidateItemOfferImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, candidateItemOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}, and
   * {@link CandidateItemOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateItemOfferImpl#equals(Object)}
   *   <li>{@link CandidateItemOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertEquals(candidateItemOfferImpl, candidateItemOfferImpl);
    int expectedHashCodeResult = candidateItemOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateItemOfferImpl.hashCode());
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(discountedPrice);
    candidateItemOfferImpl.setId(2L);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(discountedPrice);
    candidateItemOfferImpl.setId(null);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(discountedPrice);
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    candidateItemOfferImpl2.setDiscountedPrice(new Money());
    candidateItemOfferImpl2.setId(null);
    candidateItemOfferImpl2.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, candidateItemOfferImpl2);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, null);
  }

  /**
   * Test {@link CandidateItemOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateItemOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    candidateItemOfferImpl.setDiscountedPrice(new Money());
    candidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    candidateItemOfferImpl.setOrderItem(new BundleOrderItemImpl());

    // Act and Assert
    assertNotEquals(candidateItemOfferImpl, "Different type to CandidateItemOfferImpl");
  }

  /**
   * Test
   * {@link CandidateItemOfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CandidateItemOfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl = new CandidateItemOfferImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CandidateItemOffer> actualCreateOrRetrieveCopyInstanceResult = candidateItemOfferImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link CandidateItemOfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CandidateItemOfferImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.offer.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass462 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl candidateItemOfferImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CandidateItemOfferImpl candidateItemOfferImpl2 = new CandidateItemOfferImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    candidateItemOfferImpl2.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CandidateItemOfferImpl}
   *   <li>{@link CandidateItemOfferImpl#setId(Long)}
   *   <li>{@link CandidateItemOfferImpl#setOrderItem(OrderItem)}
   *   <li>{@link CandidateItemOfferImpl#getId()}
   *   <li>{@link CandidateItemOfferImpl#getOrderItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CandidateItemOfferImpl actualCandidateItemOfferImpl = new CandidateItemOfferImpl();
    actualCandidateItemOfferImpl.setId(CandidateItemOfferImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualCandidateItemOfferImpl.setOrderItem(orderItem);
    Long actualId = actualCandidateItemOfferImpl.getId();
    OrderItem actualOrderItem = actualCandidateItemOfferImpl.getOrderItem();

    // Assert that nothing has changed
    assertEquals(CandidateItemOfferImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItem, actualOrderItem);
  }
}
