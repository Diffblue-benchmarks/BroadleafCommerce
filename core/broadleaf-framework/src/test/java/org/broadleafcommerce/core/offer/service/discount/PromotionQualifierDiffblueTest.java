package org.broadleafcommerce.core.offer.service.discount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteriaImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PromotionQualifierDiffblueTest {
  /**
   * Test {@link PromotionQualifier#copy()}.
   *
   * <p>Method under test: {@link PromotionQualifier#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionQualifier PromotionQualifier.copy()"})
  public void testCopy() {
    // Arrange and Act
    PromotionQualifier actualCopyResult = new PromotionQualifier().copy();

    // Assert
    assertNull(actualCopyResult.getPrice());
    assertNull(actualCopyResult.getPromotion());
    assertNull(actualCopyResult.getItemCriteria());
    assertEquals(0, actualCopyResult.getFinalizedQuantity());
    assertEquals(0, actualCopyResult.getQuantity());
    assertTrue(actualCopyResult.isFinalized());
  }

  /**
   * Test {@link PromotionQualifier#resetQty(int)}.
   *
   * <p>Method under test: {@link PromotionQualifier#resetQty(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifier.resetQty(int)"})
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
   * Test {@link PromotionQualifier#split(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return Price is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifier#split(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionQualifier PromotionQualifier.split(int)"})
  public void testSplit_whenMinusOne_thenReturnPriceIsNull() {
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
   * Test {@link PromotionQualifier#split(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifier#split(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionQualifier PromotionQualifier.split(int)"})
  public void testSplit_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PromotionQualifier().split(1));
  }

  /**
   * Test {@link PromotionQualifier#isFinalized()}.
   *
   * <ul>
   *   <li>Given {@link PromotionQualifier} (default constructor) incrementQuantity one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifier#isFinalized()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PromotionQualifier.isFinalized()"})
  public void testIsFinalized_givenPromotionQualifierIncrementQuantityOne_thenReturnFalse() {
    // Arrange
    PromotionQualifier promotionQualifier = new PromotionQualifier();
    promotionQualifier.incrementQuantity(1);

    // Act and Assert
    assertFalse(promotionQualifier.isFinalized());
  }

  /**
   * Test {@link PromotionQualifier#isFinalized()}.
   *
   * <ul>
   *   <li>Given {@link PromotionQualifier} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifier#isFinalized()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PromotionQualifier.isFinalized()"})
  public void testIsFinalized_givenPromotionQualifier_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PromotionQualifier().isFinalized());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotionQualifier.<init>()",
    "int PromotionQualifier.getFinalizedQuantity()",
    "OfferItemCriteria PromotionQualifier.getItemCriteria()",
    "Money PromotionQualifier.getPrice()",
    "Offer PromotionQualifier.getPromotion()",
    "int PromotionQualifier.getQuantity()",
    "void PromotionQualifier.incrementQuantity(int)",
    "void PromotionQualifier.setFinalizedQuantity(int)",
    "void PromotionQualifier.setItemCriteria(OfferItemCriteria)",
    "void PromotionQualifier.setPrice(Money)",
    "void PromotionQualifier.setPromotion(Offer)",
    "void PromotionQualifier.setQuantity(int)"
  })
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

    // Assert
    assertTrue(actualPromotion instanceof OfferImpl);
    assertEquals(1, actualFinalizedQuantity);
    assertEquals(1, actualPromotionQualifier.getQuantity());
    assertSame(price, actualPrice);
    assertSame(promotion, actualPromotion);
    assertSame(itemCriteria, actualItemCriteria);
  }
}
