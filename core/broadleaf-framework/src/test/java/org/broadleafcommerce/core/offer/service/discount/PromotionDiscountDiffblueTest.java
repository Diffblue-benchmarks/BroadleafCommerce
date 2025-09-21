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
package org.broadleafcommerce.core.offer.service.discount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteriaImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PromotionDiscountDiffblueTest {
  /**
   * Test {@link PromotionDiscount#split(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Promotion is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionDiscount#split(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionDiscount PromotionDiscount.split(int)"})
  public void testSplit_whenOne_thenReturnPromotionIsNull() {
    // Arrange
    PromotionDiscount promotionDiscount = new PromotionDiscount();

    // Act
    PromotionDiscount actualSplitResult = promotionDiscount.split(1);

    // Assert
    assertNull(actualSplitResult.getPromotion());
    assertNull(actualSplitResult.getItemCriteria());
    assertNull(actualSplitResult.getCandidateItemOffer());
    assertEquals(-1, actualSplitResult.getFinalizedQuantity());
    assertEquals(-1, actualSplitResult.getQuantity());
    assertEquals(1, promotionDiscount.getFinalizedQuantity());
    assertEquals(1, promotionDiscount.getQuantity());
    assertTrue(actualSplitResult.isFinalized());
  }

  /**
   * Test {@link PromotionDiscount#split(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionDiscount#split(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionDiscount PromotionDiscount.split(int)"})
  public void testSplit_whenZero_thenReturnNull() {
    // Arrange
    PromotionDiscount promotionDiscount = new PromotionDiscount();

    // Act and Assert
    assertNull(promotionDiscount.split(0));
    assertEquals(0, promotionDiscount.getFinalizedQuantity());
    assertEquals(0, promotionDiscount.getQuantity());
  }

  /**
   * Test {@link PromotionDiscount#copy()}.
   *
   * <p>Method under test: {@link PromotionDiscount#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionDiscount PromotionDiscount.copy()"})
  public void testCopy() {
    // Arrange and Act
    PromotionDiscount actualCopyResult = new PromotionDiscount().copy();

    // Assert
    assertNull(actualCopyResult.getPromotion());
    assertNull(actualCopyResult.getItemCriteria());
    assertNull(actualCopyResult.getCandidateItemOffer());
    assertEquals(0, actualCopyResult.getFinalizedQuantity());
    assertEquals(0, actualCopyResult.getQuantity());
    assertTrue(actualCopyResult.isFinalized());
  }

  /**
   * Test {@link PromotionDiscount#resetQty(int)}.
   *
   * <p>Method under test: {@link PromotionDiscount#resetQty(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionDiscount.resetQty(int)"})
  public void testResetQty() {
    // Arrange
    PromotionDiscount promotionDiscount = new PromotionDiscount();

    // Act
    promotionDiscount.resetQty(1);

    // Assert
    assertEquals(1, promotionDiscount.getFinalizedQuantity());
    assertEquals(1, promotionDiscount.getQuantity());
  }

  /**
   * Test {@link PromotionDiscount#isFinalized()}.
   *
   * <ul>
   *   <li>Given {@link PromotionDiscount} (default constructor) incrementQuantity one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionDiscount#isFinalized()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PromotionDiscount.isFinalized()"})
  public void testIsFinalized_givenPromotionDiscountIncrementQuantityOne_thenReturnFalse() {
    // Arrange
    PromotionDiscount promotionDiscount = new PromotionDiscount();
    promotionDiscount.incrementQuantity(1);

    // Act and Assert
    assertFalse(promotionDiscount.isFinalized());
  }

  /**
   * Test {@link PromotionDiscount#isFinalized()}.
   *
   * <ul>
   *   <li>Given {@link PromotionDiscount} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionDiscount#isFinalized()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PromotionDiscount.isFinalized()"})
  public void testIsFinalized_givenPromotionDiscount_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PromotionDiscount().isFinalized());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PromotionDiscount}
   *   <li>{@link PromotionDiscount#incrementQuantity(int)}
   *   <li>{@link PromotionDiscount#setCandidateItemOffer(PromotableCandidateItemOffer)}
   *   <li>{@link PromotionDiscount#setFinalizedQuantity(int)}
   *   <li>{@link PromotionDiscount#setItemCriteria(OfferItemCriteria)}
   *   <li>{@link PromotionDiscount#setPromotion(Offer)}
   *   <li>{@link PromotionDiscount#setQuantity(int)}
   *   <li>{@link PromotionDiscount#getCandidateItemOffer()}
   *   <li>{@link PromotionDiscount#getFinalizedQuantity()}
   *   <li>{@link PromotionDiscount#getItemCriteria()}
   *   <li>{@link PromotionDiscount#getPromotion()}
   *   <li>{@link PromotionDiscount#getQuantity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotionDiscount.<init>()",
    "PromotableCandidateItemOffer PromotionDiscount.getCandidateItemOffer()",
    "int PromotionDiscount.getFinalizedQuantity()",
    "OfferItemCriteria PromotionDiscount.getItemCriteria()",
    "Offer PromotionDiscount.getPromotion()",
    "int PromotionDiscount.getQuantity()",
    "void PromotionDiscount.incrementQuantity(int)",
    "void PromotionDiscount.setCandidateItemOffer(PromotableCandidateItemOffer)",
    "void PromotionDiscount.setFinalizedQuantity(int)",
    "void PromotionDiscount.setItemCriteria(OfferItemCriteria)",
    "void PromotionDiscount.setPromotion(Offer)",
    "void PromotionDiscount.setQuantity(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PromotionDiscount actualPromotionDiscount = new PromotionDiscount();
    actualPromotionDiscount.incrementQuantity(1);
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    PromotableCandidateItemOfferImpl candidateItemOffer =
        new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());
    actualPromotionDiscount.setCandidateItemOffer(candidateItemOffer);
    actualPromotionDiscount.setFinalizedQuantity(1);
    OfferItemCriteriaImpl itemCriteria = new OfferItemCriteriaImpl();
    actualPromotionDiscount.setItemCriteria(itemCriteria);
    OfferImpl promotion = new OfferImpl();
    actualPromotionDiscount.setPromotion(promotion);
    actualPromotionDiscount.setQuantity(1);
    PromotableCandidateItemOffer actualCandidateItemOffer =
        actualPromotionDiscount.getCandidateItemOffer();
    int actualFinalizedQuantity = actualPromotionDiscount.getFinalizedQuantity();
    OfferItemCriteria actualItemCriteria = actualPromotionDiscount.getItemCriteria();
    Offer actualPromotion = actualPromotionDiscount.getPromotion();

    // Assert
    assertTrue(actualItemCriteria instanceof OfferItemCriteriaImpl);
    assertEquals(1, actualFinalizedQuantity);
    assertEquals(1, actualPromotionDiscount.getQuantity());
    assertSame(promotion, actualPromotion);
    assertSame(itemCriteria, actualItemCriteria);
    assertSame(candidateItemOffer, actualCandidateItemOffer);
  }
}
