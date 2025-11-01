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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Set;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.junit.Test;

public class CandidateFulfillmentGroupOfferImplDiffblueTest {
  /**
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#getOffer()}
   */
  @Test
  public void testGetOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CandidateFulfillmentGroupOfferImpl()).getOffer());
  }

  /**
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#getOffer()}
   */
  @Test
  public void testGetOffer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);

    // Act
    Offer actualOffer = candidateFulfillmentGroupOfferImpl.getOffer();

    // Assert
    verify(discountedPrice).getAmount();
    assertNull(actualOffer);
  }

  /**
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    candidateFulfillmentGroupOfferImpl.setOffer(offer);

    // Assert
    Offer offer2 = candidateFulfillmentGroupOfferImpl.offer;
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
    assertEquals(2147483646, candidateFulfillmentGroupOfferImpl.getPriority());
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
    assertSame(offer, candidateFulfillmentGroupOfferImpl.getOffer());
    assertSame(offer, candidateFulfillmentGroupOfferImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
  }

  /**
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    OfferImpl offer = mock(OfferImpl.class);

    // Act
    candidateFulfillmentGroupOfferImpl.setOffer(offer);

    // Assert
    assertEquals(0, candidateFulfillmentGroupOfferImpl.getPriority());
    assertSame(offer, candidateFulfillmentGroupOfferImpl.getOffer());
    assertSame(offer, candidateFulfillmentGroupOfferImpl.deproxiedOffer);
  }

  /**
   * Method under test:
   * {@link CandidateFulfillmentGroupOfferImpl#getDiscountedPrice()}
   */
  @Test
  public void testGetDiscountedPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CandidateFulfillmentGroupOfferImpl()).getDiscountedPrice());
  }

  /**
   * Method under test:
   * {@link CandidateFulfillmentGroupOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  public void testSetDiscountedPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    Money discountedPrice = new Money();

    // Act
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = discountedPrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), candidateFulfillmentGroupOfferImpl.discountedPrice);
    assertEquals(discountedPrice, discountedPrice.abs());
    assertEquals(discountedPrice, discountedPrice.zero());
    assertSame(candidateFulfillmentGroupOfferImpl.discountedPrice, amount);
  }

  /**
   * Method under test:
   * {@link CandidateFulfillmentGroupOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  public void testSetDiscountedPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);

    // Assert
    verify(discountedPrice).getAmount();
    assertEquals(new BigDecimal("2.3"), candidateFulfillmentGroupOfferImpl.discountedPrice);
  }

  /**
   * Method under test:
   * {@link CandidateFulfillmentGroupOfferImpl#setFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testSetFulfillmentGroup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act
    candidateFulfillmentGroupOfferImpl.setFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertSame(fulfillmentGroup, candidateFulfillmentGroupOfferImpl.getFulfillmentGroup());
  }

  /**
   * Method under test:
   * {@link CandidateFulfillmentGroupOfferImpl#setFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testSetFulfillmentGroup2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);

    // Act
    candidateFulfillmentGroupOfferImpl.setFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertSame(fulfillmentGroup, candidateFulfillmentGroupOfferImpl.getFulfillmentGroup());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
    int expectedHashCodeResult = candidateFulfillmentGroupOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateFulfillmentGroupOfferImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
    int notExpectedHashCodeResult = candidateFulfillmentGroupOfferImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, candidateFulfillmentGroupOfferImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);
    candidateFulfillmentGroupOfferImpl.setId(null);
    Money discountedPrice2 = mock(Money.class);
    when(discountedPrice2.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(discountedPrice2);
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
    int expectedHashCodeResult = candidateFulfillmentGroupOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateFulfillmentGroupOfferImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl);
    int expectedHashCodeResult = candidateFulfillmentGroupOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateFulfillmentGroupOfferImpl.hashCode());
  }

  /**
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);
    candidateFulfillmentGroupOfferImpl.setId(2L);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
  }

  /**
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);
    candidateFulfillmentGroupOfferImpl.setId(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
  }

  /**
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(null);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
  }

  /**
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);
    candidateFulfillmentGroupOfferImpl.setId(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
  }

  /**
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, null);
  }

  /**
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, "Different type to CandidateFulfillmentGroupOfferImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CandidateFulfillmentGroupOfferImpl}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#setId(Long)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#getFulfillmentGroup()}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#getId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CandidateFulfillmentGroupOfferImpl actualCandidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    actualCandidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    actualCandidateFulfillmentGroupOfferImpl.getFulfillmentGroup();

    // Assert that nothing has changed
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID,
        actualCandidateFulfillmentGroupOfferImpl.getId().longValue());
  }
}
