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
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;
import org.mockito.Mockito;

public class OfferCodeImplDiffblueTest {
  /**
   * Test {@link OfferCodeImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferCodeImpl()).getOffer());
  }

  /**
   * Test {@link OfferCodeImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) StartDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenOfferCodeImplStartDateIsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setStartDate(mock(java.sql.Date.class));

    // Act and Assert
    assertNull(offerCodeImpl.getOffer());
  }

  /**
   * Test {@link OfferCodeImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl}.</li>
   *   <li>Then {@link OfferCodeImpl} (default constructor) Offer is
   * {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenOfferCodeImplOfferIsOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    OfferImpl offer = mock(OfferImpl.class);

    // Act
    offerCodeImpl.setOffer(offer);

    // Assert
    assertSame(offer, offerCodeImpl.getOffer());
    assertSame(offer, offerCodeImpl.deproxiedOffer);
  }

  /**
   * Test {@link OfferCodeImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then {@link OfferCodeImpl} (default constructor)
   * {@link OfferCodeImpl#offer} {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenOfferCodeImplOfferOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    offerCodeImpl.setOffer(offer);

    // Assert
    Offer offer2 = offerCodeImpl.offer;
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
    assertSame(offer, offerCodeImpl.getOffer());
    assertSame(offer, offerCodeImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
  }

  /**
   * Test {@link OfferCodeImpl#getMaxUses()}.
   * <p>
   * Method under test: {@link OfferCodeImpl#getMaxUses()}
   */
  @Test
  public void testGetMaxUses() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);
    offerCodeImpl.setMaxUses(1);

    // Act and Assert
    assertEquals(1, offerCodeImpl.getMaxUses());
  }

  /**
   * Test {@link OfferCodeImpl#getMaxUses()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) EndDate is
   * {@link java.sql.Date}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#getMaxUses()}
   */
  @Test
  public void testGetMaxUses_givenOfferCodeImplEndDateIsDate_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(mock(java.sql.Date.class));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl
        .setStartDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);
    offerCodeImpl.setMaxUses(1);

    // Act and Assert
    assertEquals(1, offerCodeImpl.getMaxUses());
  }

  /**
   * Test {@link OfferCodeImpl#getMaxUses()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#getMaxUses()}
   */
  @Test
  public void testGetMaxUses_givenOfferCodeImpl_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new OfferCodeImpl()).getMaxUses());
  }

  /**
   * Test {@link OfferCodeImpl#setMaxUses(int)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#setMaxUses(int)}
   */
  @Test
  public void testSetMaxUses_givenOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();

    // Act
    offerCodeImpl.setMaxUses(3);

    // Assert
    assertEquals(3, offerCodeImpl.maxUses.intValue());
    assertEquals(3, offerCodeImpl.getMaxUses());
    assertFalse(offerCodeImpl.isUnlimitedUse());
    assertTrue(offerCodeImpl.isLimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#setMaxUses(int)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) StartDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#setMaxUses(int)}
   */
  @Test
  public void testSetMaxUses_givenOfferCodeImplStartDateIsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setStartDate(mock(java.sql.Date.class));

    // Act
    offerCodeImpl.setMaxUses(3);

    // Assert
    assertEquals(3, offerCodeImpl.maxUses.intValue());
    assertEquals(3, offerCodeImpl.getMaxUses());
    assertFalse(offerCodeImpl.isUnlimitedUse());
    assertTrue(offerCodeImpl.isLimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isUnlimitedUse()}.
   * <p>
   * Method under test: {@link OfferCodeImpl#isUnlimitedUse()}
   */
  @Test
  public void testIsUnlimitedUse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);
    offerCodeImpl.setMaxUses(0);

    // Act and Assert
    assertTrue(offerCodeImpl.isUnlimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isUnlimitedUse()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) EndDate is
   * {@link java.sql.Date}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#isUnlimitedUse()}
   */
  @Test
  public void testIsUnlimitedUse_givenOfferCodeImplEndDateIsDate_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(mock(java.sql.Date.class));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl
        .setStartDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);
    offerCodeImpl.setMaxUses(0);

    // Act and Assert
    assertTrue(offerCodeImpl.isUnlimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isUnlimitedUse()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) MaxUses is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#isUnlimitedUse()}
   */
  @Test
  public void testIsUnlimitedUse_givenOfferCodeImplMaxUsesIsOne_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);
    offerCodeImpl.setMaxUses(1);

    // Act and Assert
    assertFalse(offerCodeImpl.isUnlimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isUnlimitedUse()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#isUnlimitedUse()}
   */
  @Test
  public void testIsUnlimitedUse_givenOfferCodeImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OfferCodeImpl()).isUnlimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isLimitedUse()}.
   * <p>
   * Method under test: {@link OfferCodeImpl#isLimitedUse()}
   */
  @Test
  public void testIsLimitedUse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);
    offerCodeImpl.setMaxUses(0);

    // Act and Assert
    assertFalse(offerCodeImpl.isLimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isLimitedUse()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) EndDate is
   * {@link java.sql.Date}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#isLimitedUse()}
   */
  @Test
  public void testIsLimitedUse_givenOfferCodeImplEndDateIsDate_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(mock(java.sql.Date.class));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl
        .setStartDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);
    offerCodeImpl.setMaxUses(0);

    // Act and Assert
    assertFalse(offerCodeImpl.isLimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isLimitedUse()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) MaxUses is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#isLimitedUse()}
   */
  @Test
  public void testIsLimitedUse_givenOfferCodeImplMaxUsesIsOne_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);
    offerCodeImpl.setMaxUses(1);

    // Act and Assert
    assertTrue(offerCodeImpl.isLimitedUse());
  }

  /**
   * Test {@link OfferCodeImpl#isLimitedUse()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#isLimitedUse()}
   */
  @Test
  public void testIsLimitedUse_givenOfferCodeImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OfferCodeImpl()).isLimitedUse());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferCodeImpl#setEmailAddress(String)}
   *   <li>{@link OfferCodeImpl#setEndDate(Date)}
   *   <li>{@link OfferCodeImpl#setId(Long)}
   *   <li>{@link OfferCodeImpl#setOfferCode(String)}
   *   <li>{@link OfferCodeImpl#setOrders(List)}
   *   <li>{@link OfferCodeImpl#setStartDate(Date)}
   *   <li>{@link OfferCodeImpl#setUses(int)}
   *   <li>{@link OfferCodeImpl#getEmailAddress()}
   *   <li>{@link OfferCodeImpl#getEndDate()}
   *   <li>{@link OfferCodeImpl#getId()}
   *   <li>{@link OfferCodeImpl#getOfferCode()}
   *   <li>{@link OfferCodeImpl#getOrders()}
   *   <li>{@link OfferCodeImpl#getStartDate()}
   *   <li>{@link OfferCodeImpl#getUses()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();

    // Act
    offerCodeImpl.setEmailAddress("42 Main St");
    Date endDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offerCodeImpl.setEndDate(endDate);
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setOfferCode("Offer Code");
    ArrayList<Order> orders = new ArrayList<>();
    offerCodeImpl.setOrders(orders);
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    offerCodeImpl.setStartDate(startDate);
    offerCodeImpl.setUses(1);
    String actualEmailAddress = offerCodeImpl.getEmailAddress();
    Date actualEndDate = offerCodeImpl.getEndDate();
    Long actualId = offerCodeImpl.getId();
    String actualOfferCode = offerCodeImpl.getOfferCode();
    List<Order> actualOrders = offerCodeImpl.getOrders();
    Date actualStartDate = offerCodeImpl.getStartDate();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("Offer Code", actualOfferCode);
    assertEquals(1, offerCodeImpl.getUses());
    assertTrue(actualOrders.isEmpty());
    assertEquals(OfferCodeImpl.serialVersionUID, actualId.longValue());
    assertSame(orders, actualOrders);
    assertSame(endDate, actualEndDate);
    assertSame(startDate, actualStartDate);
  }

  /**
   * Test {@link OfferCodeImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new OfferCodeImpl()).getArchived().charValue());
  }

  /**
   * Test {@link OfferCodeImpl#getArchived()}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) StartDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#getArchived()}
   */
  @Test
  public void testGetArchived_givenOfferCodeImplStartDateIsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setStartDate(mock(java.sql.Date.class));

    // Act and Assert
    assertEquals('N', offerCodeImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferCodeImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();

    // Act
    offerCodeImpl.setArchived('A');

    // Assert
    assertEquals('A', offerCodeImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', offerCodeImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferCodeImpl#setArchived(Character)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor) StartDate is
   * {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived_givenOfferCodeImplStartDateIsDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setStartDate(mock(java.sql.Date.class));

    // Act
    offerCodeImpl.setArchived('A');

    // Assert
    assertEquals('A', offerCodeImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', offerCodeImpl.getArchived().charValue());
  }

  /**
   * Test {@link OfferCodeImpl#isActive()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#isActive()}
   */
  @Test
  public void testIsActive_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act and Assert
    assertFalse(offerCodeImpl.isActive());
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}, and
   * {@link OfferCodeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferCodeImpl#equals(Object)}
   *   <li>{@link OfferCodeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    OfferCodeImpl offerCodeImpl2 = new OfferCodeImpl();
    offerCodeImpl2.setEmailAddress("42 Main St");
    offerCodeImpl2.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl2.setMaxUses(3);
    offerCodeImpl2.setOfferCode("Offer Code");
    offerCodeImpl2.setOrders(new ArrayList<>());
    offerCodeImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setUses(1);

    // Act and Assert
    assertEquals(offerCodeImpl, offerCodeImpl2);
    int expectedHashCodeResult = offerCodeImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerCodeImpl2.hashCode());
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}, and
   * {@link OfferCodeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferCodeImpl#equals(Object)}
   *   <li>{@link OfferCodeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl
        .setEndDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl
        .setStartDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(mock(java.sql.Date.class));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl
        .setStartDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    OfferCodeImpl offerCodeImpl2 = new OfferCodeImpl();
    offerCodeImpl2.setEmailAddress("42 Main St");
    offerCodeImpl2
        .setEndDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl2.setMaxUses(3);
    offerCodeImpl2.setOfferCode("Offer Code");
    offerCodeImpl2.setOrders(new ArrayList<>());
    offerCodeImpl2
        .setStartDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setUses(1);

    // Act and Assert
    assertEquals(offerCodeImpl, offerCodeImpl2);
    int expectedHashCodeResult = offerCodeImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerCodeImpl2.hashCode());
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}, and
   * {@link OfferCodeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OfferCodeImpl#equals(Object)}
   *   <li>{@link OfferCodeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertEquals(offerCodeImpl, offerCodeImpl);
    int expectedHashCodeResult = offerCodeImpl.hashCode();
    assertEquals(expectedHashCodeResult, offerCodeImpl.hashCode());
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("17 High St");
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    OfferCodeImpl offerCodeImpl2 = new OfferCodeImpl();
    offerCodeImpl2.setEmailAddress("42 Main St");
    offerCodeImpl2.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl2.setMaxUses(3);
    offerCodeImpl2.setOfferCode("Offer Code");
    offerCodeImpl2.setOrders(new ArrayList<>());
    offerCodeImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setUses(1);

    // Act and Assert
    assertNotEquals(offerCodeImpl, offerCodeImpl2);
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertNotEquals(offerCodeImpl, null);
  }

  /**
   * Test {@link OfferCodeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferCodeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setEmailAddress("42 Main St");
    offerCodeImpl.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl.setMaxUses(3);
    offerCodeImpl.setOfferCode("Offer Code");
    offerCodeImpl.setOrders(new ArrayList<>());
    offerCodeImpl.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl.setUses(1);

    // Act and Assert
    assertNotEquals(offerCodeImpl, "Different type to OfferCodeImpl");
  }

  /**
   * Test
   * {@link OfferCodeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link OfferCodeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<OfferCode> actualCreateOrRetrieveCopyInstanceResult = offerCodeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link OfferCodeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then calls {@link CreateResponse#getClone()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OfferCodeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_thenCallsGetClone() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferCodeImpl offerCodeImpl = new OfferCodeImpl();
    offerCodeImpl.setMaxUses(3);

    OfferCodeImpl offerCodeImpl2 = new OfferCodeImpl();
    offerCodeImpl2.setEmailAddress("42 Main St");
    offerCodeImpl2.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setId(OfferCodeImpl.serialVersionUID);
    offerCodeImpl2.setMaxUses(3);
    offerCodeImpl2.setOfferCode("Offer Code");
    offerCodeImpl2.setOrders(new ArrayList<>());
    offerCodeImpl2.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offerCodeImpl2.setUses(1);
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(offerCodeImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    offerCodeImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }

  /**
   * Test new {@link OfferCodeImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OfferCodeImpl}
   */
  @Test
  public void testNewOfferCodeImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OfferCodeImpl actualOfferCodeImpl = new OfferCodeImpl();

    // Assert
    assertEquals('N', actualOfferCodeImpl.archiveStatus.getArchived().charValue());
    assertEquals('N', actualOfferCodeImpl.getArchived().charValue());
    assertNull(actualOfferCodeImpl.maxUses);
    assertNull(actualOfferCodeImpl.getId());
    assertNull(actualOfferCodeImpl.getEmailAddress());
    assertNull(actualOfferCodeImpl.getOfferCode());
    assertNull(actualOfferCodeImpl.getEndDate());
    assertNull(actualOfferCodeImpl.getStartDate());
    assertNull(actualOfferCodeImpl.getOffer());
    assertNull(actualOfferCodeImpl.deproxiedOffer);
    assertNull(actualOfferCodeImpl.offer);
    assertNull(actualOfferCodeImpl.sbClonedOffer);
    assertEquals(0, actualOfferCodeImpl.getMaxUses());
    assertEquals(0, actualOfferCodeImpl.getUses());
    assertFalse(actualOfferCodeImpl.isLimitedUse());
    assertTrue(actualOfferCodeImpl.getOrders().isEmpty());
    assertTrue(actualOfferCodeImpl.isUnlimitedUse());
  }
}
