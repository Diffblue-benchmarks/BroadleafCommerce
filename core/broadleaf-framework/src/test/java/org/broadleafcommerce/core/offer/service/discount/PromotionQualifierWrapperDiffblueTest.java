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
   * Test {@link PromotionQualifierWrapper#getPromotion()}.
   * <ul>
   *   <li>Given
   * {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}
   * with pq is
   * {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#getPromotion()}
   */
  @Test
  public void testGetPromotion_givenPromotionQualifierWrapperWithPqIsPromotionQualifierWrapper() {
    // Arrange, Act and Assert
    assertNull((new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))).getPromotion());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getPromotion()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#getPromotion()}
   */
  @Test
  public void testGetPromotion_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PromotionQualifierWrapper(new PromotionQualifier())).getPromotion());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setPromotion(Offer)}.
   * <p>
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
   * Test {@link PromotionQualifierWrapper#setPromotion(Offer)}.
   * <p>
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
   * Test {@link PromotionQualifierWrapper#setItemCriteria(OfferItemCriteria)}.
   * <p>
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
   * Test {@link PromotionQualifierWrapper#setItemCriteria(OfferItemCriteria)}.
   * <p>
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
   * Test {@link PromotionQualifierWrapper#getQuantity()}.
   * <ul>
   *   <li>Given
   * {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}
   * with pq is
   * {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#getQuantity()}
   */
  @Test
  public void testGetQuantity_givenPromotionQualifierWrapperWithPqIsPromotionQualifierWrapper() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))).getQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getQuantity()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#getQuantity()}
   */
  @Test
  public void testGetQuantity_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PromotionQualifierWrapper(new PromotionQualifier())).getQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setQuantity(int)}.
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#setQuantity(int)}
   */
  @Test
  public void testSetQuantity() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(new PromotionQualifier());

    // Act
    promotionQualifierWrapper.setQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setQuantity(int)}.
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#setQuantity(int)}
   */
  @Test
  public void testSetQuantity2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(
        new PromotionQualifierWrapper(new PromotionQualifier()));

    // Act
    promotionQualifierWrapper.setQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setFinalizedQuantity(int)}.
   * <p>
   * Method under test:
   * {@link PromotionQualifierWrapper#setFinalizedQuantity(int)}
   */
  @Test
  public void testSetFinalizedQuantity() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(new PromotionQualifier());

    // Act
    promotionQualifierWrapper.setFinalizedQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getFinalizedQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setFinalizedQuantity(int)}.
   * <p>
   * Method under test:
   * {@link PromotionQualifierWrapper#setFinalizedQuantity(int)}
   */
  @Test
  public void testSetFinalizedQuantity2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(
        new PromotionQualifierWrapper(new PromotionQualifier()));

    // Act
    promotionQualifierWrapper.setFinalizedQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getFinalizedQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#copy()}.
   * <ul>
   *   <li>Given
   * {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}
   * with pq is
   * {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#copy()}
   */
  @Test
  public void testCopy_givenPromotionQualifierWrapperWithPqIsPromotionQualifierWrapper() {
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
   * Test {@link PromotionQualifierWrapper#copy()}.
   * <ul>
   *   <li>Then return Price is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#copy()}
   */
  @Test
  public void testCopy_thenReturnPriceIsNull() {
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
   * Test {@link PromotionQualifierWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PromotionQualifierWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PromotionQualifierWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PromotionQualifierWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PromotionQualifierWrapper(new PromotionQualifier()), null);
  }

  /**
   * Test {@link PromotionQualifierWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PromotionQualifierWrapper(new PromotionQualifier()),
        new PromotionQualifierWrapper(new PromotionQualifier()));
  }

  /**
   * Test {@link PromotionQualifierWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PromotionQualifierWrapper(new PromotionQualifier()),
        "Different type to PromotionQualifierWrapper");
  }

  /**
   * Test {@link PromotionQualifierWrapper#getItemCriteria()}.
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#getItemCriteria()}
   */
  @Test
  public void testGetItemCriteria() {
    // Arrange, Act and Assert
    assertNull(
        (new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))).getItemCriteria());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getItemCriteria()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#getItemCriteria()}
   */
  @Test
  public void testGetItemCriteria_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PromotionQualifierWrapper(new PromotionQualifier())).getItemCriteria());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getFinalizedQuantity()}.
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#getFinalizedQuantity()}
   */
  @Test
  public void testGetFinalizedQuantity() {
    // Arrange, Act and Assert
    assertEquals(0, (new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier())))
        .getFinalizedQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getFinalizedQuantity()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#getFinalizedQuantity()}
   */
  @Test
  public void testGetFinalizedQuantity_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PromotionQualifierWrapper(new PromotionQualifier())).getFinalizedQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#incrementQuantity(int)}.
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#incrementQuantity(int)}
   */
  @Test
  public void testIncrementQuantity() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(new PromotionQualifier());

    // Act
    promotionQualifierWrapper.incrementQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#incrementQuantity(int)}.
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#incrementQuantity(int)}
   */
  @Test
  public void testIncrementQuantity2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(
        new PromotionQualifierWrapper(new PromotionQualifier()));

    // Act
    promotionQualifierWrapper.incrementQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#resetQty(int)}.
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#resetQty(int)}
   */
  @Test
  public void testResetQty() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(new PromotionQualifier());

    // Act
    promotionQualifierWrapper.resetQty(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getFinalizedQuantity());
    assertEquals(1, promotionQualifierWrapper.getQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#resetQty(int)}.
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#resetQty(int)}
   */
  @Test
  public void testResetQty2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(
        new PromotionQualifierWrapper(new PromotionQualifier()));

    // Act
    promotionQualifierWrapper.resetQty(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getFinalizedQuantity());
    assertEquals(1, promotionQualifierWrapper.getQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#split(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return Price is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#split(int)}
   */
  @Test
  public void testSplit_whenMinusOne_thenReturnPriceIsNull() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper = new PromotionQualifierWrapper(new PromotionQualifier());

    // Act
    PromotionQualifier actualSplitResult = promotionQualifierWrapper.split(-1);

    // Assert
    assertNull(actualSplitResult.getPrice());
    assertNull(actualSplitResult.getPromotion());
    assertNull(actualSplitResult.getItemCriteria());
    assertEquals(-1, actualSplitResult.getFinalizedQuantity());
    assertEquals(-1, actualSplitResult.getQuantity());
    assertEquals(1, promotionQualifierWrapper.getFinalizedQuantity());
    assertEquals(1, promotionQualifierWrapper.getQuantity());
    assertTrue(actualSplitResult.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#isFinalized()}.
   * <ul>
   *   <li>Given {@link PromotionQualifier} (default constructor) incrementQuantity
   * one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#isFinalized()}
   */
  @Test
  public void testIsFinalized_givenPromotionQualifierIncrementQuantityOne_thenReturnFalse() {
    // Arrange
    PromotionQualifier pq = new PromotionQualifier();
    pq.incrementQuantity(1);

    // Act and Assert
    assertFalse((new PromotionQualifierWrapper(pq)).isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#isFinalized()}.
   * <ul>
   *   <li>Given
   * {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}
   * with pq is
   * {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#isFinalized()}
   */
  @Test
  public void testIsFinalized_givenPromotionQualifierWrapperWithPqIsPromotionQualifierWrapper() {
    // Arrange, Act and Assert
    assertTrue((new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))).isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#isFinalized()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotionQualifierWrapper#isFinalized()}
   */
  @Test
  public void testIsFinalized_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PromotionQualifierWrapper(new PromotionQualifier())).isFinalized());
  }
}
