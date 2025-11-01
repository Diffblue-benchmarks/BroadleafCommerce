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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteriaImpl;
import org.junit.Test;

public class PromotionQualifierWrapperDiffblueTest {
  /**
   * Method under test: {@link PromotionQualifierWrapper#getPromotion()}
   */
  @Test
  public void testGetPromotion() {
    // Arrange, Act and Assert
    assertNull((new PromotionQualifierWrapper(new PromotionQualifier())).getPromotion());
    assertNull((new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))).getPromotion());
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#setPromotion(Offer)}
   */
  @Test
  public void testSetPromotion() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(new PromotionQualifier());
    OfferImpl promotion = new OfferImpl();

    // Act
    promotionQualifierWrapper.setPromotion(promotion);

    // Assert
    assertSame(promotion, promotionQualifierWrapper.getPromotion());
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#setPromotion(Offer)}
   */
  @Test
  public void testSetPromotion2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(
        new PromotionQualifierWrapper(new PromotionQualifier()));
    OfferImpl promotion = new OfferImpl();

    // Act
    promotionQualifierWrapper.setPromotion(promotion);

    // Assert
    assertSame(promotion, promotionQualifierWrapper.getPromotion());
  }

  /**
   * Method under test:
   * {@link PromotionQualifierWrapper#setItemCriteria(OfferItemCriteria)}
   */
  @Test
  public void testSetItemCriteria() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(new PromotionQualifier());
    OfferItemCriteriaImpl itemCriteria = new OfferItemCriteriaImpl();

    // Act
    promotionQualifierWrapper.setItemCriteria(itemCriteria);

    // Assert
    assertSame(itemCriteria, promotionQualifierWrapper.getItemCriteria());
  }

  /**
   * Method under test:
   * {@link PromotionQualifierWrapper#setItemCriteria(OfferItemCriteria)}
   */
  @Test
  public void testSetItemCriteria2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(
        new PromotionQualifierWrapper(new PromotionQualifier()));
    OfferItemCriteriaImpl itemCriteria = new OfferItemCriteriaImpl();

    // Act
    promotionQualifierWrapper.setItemCriteria(itemCriteria);

    // Assert
    assertSame(itemCriteria, promotionQualifierWrapper.getItemCriteria());
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#getQuantity()}
   */
  @Test
  public void testGetQuantity() {
    // Arrange, Act and Assert
    assertEquals(0, (new PromotionQualifierWrapper(new PromotionQualifier())).getQuantity());
    assertEquals(0,
        (new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))).getQuantity());
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#copy()}
   */
  @Test
  public void testCopy() {
    // Arrange and Act
    PromotionQualifier actualCopyResult = (new PromotionQualifierWrapper(new PromotionQualifier())).copy();

    // Assert
    assertNull(actualCopyResult.getPrice());
    assertNull(actualCopyResult.getPromotion());
    assertNull(actualCopyResult.getItemCriteria());
    assertEquals(0, actualCopyResult.getFinalizedQuantity());
    assertEquals(0, actualCopyResult.getQuantity());
    assertTrue(actualCopyResult.isFinalized());
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#copy()}
   */
  @Test
  public void testCopy2() {
    // Arrange and Act
    PromotionQualifier actualCopyResult = (new PromotionQualifierWrapper(
        new PromotionQualifierWrapper(new PromotionQualifier()))).copy();

    // Assert
    assertNull(actualCopyResult.getPrice());
    assertNull(actualCopyResult.getPromotion());
    assertNull(actualCopyResult.getItemCriteria());
    assertEquals(0, actualCopyResult.getFinalizedQuantity());
    assertEquals(0, actualCopyResult.getQuantity());
    assertTrue(actualCopyResult.isFinalized());
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#getItemCriteria()}
   */
  @Test
  public void testGetItemCriteria() {
    // Arrange, Act and Assert
    assertNull((new PromotionQualifierWrapper(new PromotionQualifier())).getItemCriteria());
    assertNull(
        (new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))).getItemCriteria());
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#getFinalizedQuantity()}
   */
  @Test
  public void testGetFinalizedQuantity() {
    // Arrange, Act and Assert
    assertEquals(0, (new PromotionQualifierWrapper(new PromotionQualifier())).getFinalizedQuantity());
    assertEquals(0, (new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier())))
        .getFinalizedQuantity());
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#isFinalized()}
   */
  @Test
  public void testIsFinalized() {
    // Arrange, Act and Assert
    assertTrue((new PromotionQualifierWrapper(new PromotionQualifier())).isFinalized());
    assertTrue((new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))).isFinalized());
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#isFinalized()}
   */
  @Test
  public void testIsFinalized2() {
    // Arrange
    PromotionQualifier pq = new PromotionQualifier();
    pq.incrementQuantity(1);

    // Act and Assert
    assertFalse((new PromotionQualifierWrapper(pq)).isFinalized());
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(new PromotionQualifier());

    // Act and Assert
    assertNotEquals(promotionQualifierWrapper, new PromotionQualifierWrapper(new PromotionQualifier()));
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(
        new PromotionQualifierWrapper(new PromotionQualifier()));

    // Act and Assert
    assertNotEquals(promotionQualifierWrapper, new PromotionQualifierWrapper(new PromotionQualifier()));
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(mock(PromotionQualifier.class));

    // Act and Assert
    assertNotEquals(promotionQualifierWrapper, new PromotionQualifierWrapper(new PromotionQualifier()));
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PromotionQualifierWrapper(new PromotionQualifier()), null);
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PromotionQualifierWrapper(new PromotionQualifier()),
        new PromotionQualifierWrapper(new PromotionQualifier()));
  }

  /**
   * Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PromotionQualifierWrapper(new PromotionQualifier()),
        "Different type to PromotionQualifierWrapper");
  }
}
