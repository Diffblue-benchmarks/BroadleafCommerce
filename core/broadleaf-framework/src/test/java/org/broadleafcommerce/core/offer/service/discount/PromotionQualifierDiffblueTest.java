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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteriaImpl;
import org.junit.Test;

public class PromotionQualifierDiffblueTest {
  /**
   * Method under test: {@link PromotionQualifier#copy()}
   */
  @Test
  public void testCopy() {
    // Arrange and Act
    PromotionQualifier actualCopyResult = (new PromotionQualifier()).copy();

    // Assert
    assertNull(actualCopyResult.getPrice());
    assertNull(actualCopyResult.getPromotion());
    assertNull(actualCopyResult.getItemCriteria());
    assertEquals(0, actualCopyResult.getFinalizedQuantity());
    assertEquals(0, actualCopyResult.getQuantity());
    assertTrue(actualCopyResult.isFinalized());
  }

  /**
   * Method under test: {@link PromotionQualifier#resetQty(int)}
   */
  @Test
  public void testResetQty() {
    // Arrange
    PromotionQualifier promotionQualifier = new PromotionQualifier();

    // Act
    promotionQualifier.resetQty(1);

    // Assert
    assertEquals(1, promotionQualifier.getFinalizedQuantity());
    assertEquals(1, promotionQualifier.getQuantity());
  }

  /**
   * Method under test: {@link PromotionQualifier#split(int)}
   */
  @Test
  public void testSplit() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PromotionQualifier()).split(1));
  }

  /**
   * Method under test: {@link PromotionQualifier#split(int)}
   */
  @Test
  public void testSplit2() {
    // Arrange
    PromotionQualifier promotionQualifier = new PromotionQualifier();

    // Act
    PromotionQualifier actualSplitResult = promotionQualifier.split(-1);

    // Assert
    assertNull(actualSplitResult.getPrice());
    assertNull(actualSplitResult.getPromotion());
    assertNull(actualSplitResult.getItemCriteria());
    assertEquals(-1, actualSplitResult.getFinalizedQuantity());
    assertEquals(-1, actualSplitResult.getQuantity());
    assertEquals(1, promotionQualifier.getFinalizedQuantity());
    assertEquals(1, promotionQualifier.getQuantity());
    assertTrue(actualSplitResult.isFinalized());
  }

  /**
   * Method under test: {@link PromotionQualifier#isFinalized()}
   */
  @Test
  public void testIsFinalized() {
    // Arrange, Act and Assert
    assertTrue((new PromotionQualifier()).isFinalized());
  }

  /**
   * Method under test: {@link PromotionQualifier#isFinalized()}
   */
  @Test
  public void testIsFinalized2() {
    // Arrange
    PromotionQualifier promotionQualifier = new PromotionQualifier();
    promotionQualifier.incrementQuantity(1);

    // Act and Assert
    assertFalse(promotionQualifier.isFinalized());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PromotionQualifier}
   *   <li>{@link PromotionQualifier#incrementQuantity(int)}
   *   <li>{@link PromotionQualifier#setFinalizedQuantity(int)}
   *   <li>{@link PromotionQualifier#setItemCriteria(OfferItemCriteria)}
   *   <li>{@link PromotionQualifier#setPrice(Money)}
   *   <li>{@link PromotionQualifier#setPromotion(Offer)}
   *   <li>{@link PromotionQualifier#setQuantity(int)}
   *   <li>{@link PromotionQualifier#getFinalizedQuantity()}
   *   <li>{@link PromotionQualifier#getItemCriteria()}
   *   <li>{@link PromotionQualifier#getPrice()}
   *   <li>{@link PromotionQualifier#getPromotion()}
   *   <li>{@link PromotionQualifier#getQuantity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PromotionQualifier actualPromotionQualifier = new PromotionQualifier();
    actualPromotionQualifier.incrementQuantity(1);
    actualPromotionQualifier.setFinalizedQuantity(1);
    OfferItemCriteriaImpl itemCriteria = new OfferItemCriteriaImpl();
    actualPromotionQualifier.setItemCriteria(itemCriteria);
    Money price = new Money();
    actualPromotionQualifier.setPrice(price);
    OfferImpl promotion = new OfferImpl();
    actualPromotionQualifier.setPromotion(promotion);
    actualPromotionQualifier.setQuantity(1);
    int actualFinalizedQuantity = actualPromotionQualifier.getFinalizedQuantity();
    OfferItemCriteria actualItemCriteria = actualPromotionQualifier.getItemCriteria();
    Money actualPrice = actualPromotionQualifier.getPrice();
    Offer actualPromotion = actualPromotionQualifier.getPromotion();

    // Assert that nothing has changed
    assertTrue(actualPromotion instanceof OfferImpl);
    assertEquals(1, actualFinalizedQuantity);
    assertEquals(1, actualPromotionQualifier.getQuantity());
    assertSame(price, actualPrice);
    assertSame(promotion, actualPromotion);
    assertSame(itemCriteria, actualItemCriteria);
  }
}
