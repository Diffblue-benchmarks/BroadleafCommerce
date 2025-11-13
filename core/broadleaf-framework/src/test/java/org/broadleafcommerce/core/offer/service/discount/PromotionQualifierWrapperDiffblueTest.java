package org.broadleafcommerce.core.offer.service.discount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteriaImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PromotionQualifierWrapperDiffblueTest {
  @Mock private Offer offer;

  @Mock private OfferItemCriteria offerItemCriteria;

  @Mock private PromotionQualifier promotionQualifier;

  @InjectMocks private PromotionQualifierWrapper promotionQualifierWrapper;

  /**
   * Test {@link PromotionQualifierWrapper#getPromotion()}.
   *
   * <ul>
   *   <li>Given {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}
   *       with pq is {@link
   *       PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getPromotion()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer PromotionQualifierWrapper.getPromotion()"})
  public void testGetPromotion_givenPromotionQualifierWrapperWithPqIsPromotionQualifierWrapper() {
    // Arrange, Act and Assert
    assertNull(
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))
            .getPromotion());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getPromotion()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getPromotion()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer PromotionQualifierWrapper.getPromotion()"})
  public void testGetPromotion_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PromotionQualifierWrapper(new PromotionQualifier()).getPromotion());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getPromotion()}.
   *
   * <ul>
   *   <li>Then return {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getPromotion()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer PromotionQualifierWrapper.getPromotion()"})
  public void testGetPromotion_thenReturnOfferImpl() {
    // Arrange
    OfferImpl offerImpl = new OfferImpl();
    when(promotionQualifier.getPromotion()).thenReturn(offerImpl);

    // Act
    Offer actualPromotion = promotionQualifierWrapper.getPromotion();

    // Assert
    verify(promotionQualifier).getPromotion();
    assertSame(offerImpl, actualPromotion);
  }

  /**
   * Test {@link PromotionQualifierWrapper#setPromotion(Offer)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setPromotion(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setPromotion(Offer)"})
  public void testSetPromotion() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifier());
    OfferImpl promotion = new OfferImpl();

    // Act
    promotionQualifierWrapper.setPromotion(promotion);

    // Assert
    assertSame(promotion, promotionQualifierWrapper.getPromotion());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setPromotion(Offer)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setPromotion(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setPromotion(Offer)"})
  public void testSetPromotion2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()));
    OfferImpl promotion = new OfferImpl();

    // Act
    promotionQualifierWrapper.setPromotion(promotion);

    // Assert
    assertSame(promotion, promotionQualifierWrapper.getPromotion());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setPromotion(Offer)}.
   *
   * <ul>
   *   <li>Then calls {@link PromotionQualifier#setPromotion(Offer)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setPromotion(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setPromotion(Offer)"})
  public void testSetPromotion_thenCallsSetPromotion() {
    // Arrange
    doNothing().when(promotionQualifier).setPromotion(Mockito.<Offer>any());

    // Act
    promotionQualifierWrapper.setPromotion(offer);

    // Assert
    verify(promotionQualifier).setPromotion(isA(Offer.class));
  }

  /**
   * Test {@link PromotionQualifierWrapper#setItemCriteria(OfferItemCriteria)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setItemCriteria(OfferItemCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setItemCriteria(OfferItemCriteria)"})
  public void testSetItemCriteria() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifier());
    OfferItemCriteriaImpl itemCriteria = new OfferItemCriteriaImpl();

    // Act
    promotionQualifierWrapper.setItemCriteria(itemCriteria);

    // Assert
    assertSame(itemCriteria, promotionQualifierWrapper.getItemCriteria());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setItemCriteria(OfferItemCriteria)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setItemCriteria(OfferItemCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setItemCriteria(OfferItemCriteria)"})
  public void testSetItemCriteria2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()));
    OfferItemCriteriaImpl itemCriteria = new OfferItemCriteriaImpl();

    // Act
    promotionQualifierWrapper.setItemCriteria(itemCriteria);

    // Assert
    assertSame(itemCriteria, promotionQualifierWrapper.getItemCriteria());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setItemCriteria(OfferItemCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link PromotionQualifier#setItemCriteria(OfferItemCriteria)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setItemCriteria(OfferItemCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setItemCriteria(OfferItemCriteria)"})
  public void testSetItemCriteria_thenCallsSetItemCriteria() {
    // Arrange
    doNothing().when(promotionQualifier).setItemCriteria(Mockito.<OfferItemCriteria>any());

    // Act
    promotionQualifierWrapper.setItemCriteria(offerItemCriteria);

    // Assert
    verify(promotionQualifier).setItemCriteria(isA(OfferItemCriteria.class));
  }

  /**
   * Test {@link PromotionQualifierWrapper#getQuantity()}.
   *
   * <ul>
   *   <li>Given {@link PromotionQualifier} {@link PromotionQualifier#getQuantity()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PromotionQualifierWrapper.getQuantity()"})
  public void testGetQuantity_givenPromotionQualifierGetQuantityReturnOne_thenReturnOne() {
    // Arrange
    when(promotionQualifier.getQuantity()).thenReturn(1);

    // Act
    int actualQuantity = promotionQualifierWrapper.getQuantity();

    // Assert
    verify(promotionQualifier).getQuantity();
    assertEquals(1, actualQuantity);
  }

  /**
   * Test {@link PromotionQualifierWrapper#getQuantity()}.
   *
   * <ul>
   *   <li>Given {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}
   *       with pq is {@link
   *       PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PromotionQualifierWrapper.getQuantity()"})
  public void testGetQuantity_givenPromotionQualifierWrapperWithPqIsPromotionQualifierWrapper() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))
            .getQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getQuantity()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PromotionQualifierWrapper.getQuantity()"})
  public void testGetQuantity_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PromotionQualifierWrapper(new PromotionQualifier()).getQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setQuantity(int)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setQuantity(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setQuantity(int)"})
  public void testSetQuantity() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifier());

    // Act
    promotionQualifierWrapper.setQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setQuantity(int)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setQuantity(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setQuantity(int)"})
  public void testSetQuantity2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()));

    // Act
    promotionQualifierWrapper.setQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setQuantity(int)}.
   *
   * <ul>
   *   <li>Then calls {@link PromotionQualifier#setQuantity(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setQuantity(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setQuantity(int)"})
  public void testSetQuantity_thenCallsSetQuantity() {
    // Arrange
    doNothing().when(promotionQualifier).setQuantity(anyInt());

    // Act
    promotionQualifierWrapper.setQuantity(1);

    // Assert
    verify(promotionQualifier).setQuantity(1);
  }

  /**
   * Test {@link PromotionQualifierWrapper#setFinalizedQuantity(int)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setFinalizedQuantity(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setFinalizedQuantity(int)"})
  public void testSetFinalizedQuantity() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifier());

    // Act
    promotionQualifierWrapper.setFinalizedQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getFinalizedQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setFinalizedQuantity(int)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setFinalizedQuantity(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setFinalizedQuantity(int)"})
  public void testSetFinalizedQuantity2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()));

    // Act
    promotionQualifierWrapper.setFinalizedQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getFinalizedQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#setFinalizedQuantity(int)}.
   *
   * <ul>
   *   <li>Then calls {@link PromotionQualifier#setFinalizedQuantity(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#setFinalizedQuantity(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.setFinalizedQuantity(int)"})
  public void testSetFinalizedQuantity_thenCallsSetFinalizedQuantity() {
    // Arrange
    doNothing().when(promotionQualifier).setFinalizedQuantity(anyInt());

    // Act
    promotionQualifierWrapper.setFinalizedQuantity(1);

    // Assert
    verify(promotionQualifier).setFinalizedQuantity(1);
  }

  /**
   * Test {@link PromotionQualifierWrapper#copy()}.
   *
   * <ul>
   *   <li>Given {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}
   *       with pq is {@link
   *       PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionQualifier PromotionQualifierWrapper.copy()"})
  public void testCopy_givenPromotionQualifierWrapperWithPqIsPromotionQualifierWrapper() {
    // Arrange and Act
    PromotionQualifier actualCopyResult =
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))
            .copy();

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
   *
   * <ul>
   *   <li>Then return Price is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#copy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionQualifier PromotionQualifierWrapper.copy()"})
  public void testCopy_thenReturnPriceIsNull() {
    // Arrange and Act
    PromotionQualifier actualCopyResult =
        new PromotionQualifierWrapper(new PromotionQualifier()).copy();

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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionQualifierWrapper.equals(Object)",
    "int PromotionQualifierWrapper.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifier());

    // Act and Assert
    assertNotEquals(
        promotionQualifierWrapper, new PromotionQualifierWrapper(new PromotionQualifier()));
  }

  /**
   * Test {@link PromotionQualifierWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionQualifierWrapper.equals(Object)",
    "int PromotionQualifierWrapper.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()));

    // Act and Assert
    assertNotEquals(
        promotionQualifierWrapper, new PromotionQualifierWrapper(new PromotionQualifier()));
  }

  /**
   * Test {@link PromotionQualifierWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionQualifierWrapper.equals(Object)",
    "int PromotionQualifierWrapper.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PromotionQualifierWrapper(new PromotionQualifier()), null);
  }

  /**
   * Test {@link PromotionQualifierWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionQualifierWrapper.equals(Object)",
    "int PromotionQualifierWrapper.hashCode()"
  })
  public void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new PromotionQualifierWrapper(new PromotionQualifier()),
        new PromotionQualifierWrapper(new PromotionQualifier()));
  }

  /**
   * Test {@link PromotionQualifierWrapper#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PromotionQualifierWrapper.equals(Object)",
    "int PromotionQualifierWrapper.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new PromotionQualifierWrapper(new PromotionQualifier()),
        "Different type to PromotionQualifierWrapper");
  }

  /**
   * Test {@link PromotionQualifierWrapper#getItemCriteria()}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getItemCriteria()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferItemCriteria PromotionQualifierWrapper.getItemCriteria()"})
  public void testGetItemCriteria() {
    // Arrange, Act and Assert
    assertNull(
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))
            .getItemCriteria());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getItemCriteria()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getItemCriteria()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferItemCriteria PromotionQualifierWrapper.getItemCriteria()"})
  public void testGetItemCriteria_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PromotionQualifierWrapper(new PromotionQualifier()).getItemCriteria());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getItemCriteria()}.
   *
   * <ul>
   *   <li>Then return {@link OfferItemCriteriaImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getItemCriteria()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OfferItemCriteria PromotionQualifierWrapper.getItemCriteria()"})
  public void testGetItemCriteria_thenReturnOfferItemCriteriaImpl() {
    // Arrange
    OfferItemCriteriaImpl offerItemCriteriaImpl = new OfferItemCriteriaImpl();
    when(promotionQualifier.getItemCriteria()).thenReturn(offerItemCriteriaImpl);

    // Act
    OfferItemCriteria actualItemCriteria = promotionQualifierWrapper.getItemCriteria();

    // Assert
    verify(promotionQualifier).getItemCriteria();
    assertSame(offerItemCriteriaImpl, actualItemCriteria);
  }

  /**
   * Test {@link PromotionQualifierWrapper#getFinalizedQuantity()}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getFinalizedQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PromotionQualifierWrapper.getFinalizedQuantity()"})
  public void testGetFinalizedQuantity() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))
            .getFinalizedQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#getFinalizedQuantity()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getFinalizedQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PromotionQualifierWrapper.getFinalizedQuantity()"})
  public void testGetFinalizedQuantity_thenReturnOne() {
    // Arrange
    when(promotionQualifier.getFinalizedQuantity()).thenReturn(1);

    // Act
    int actualFinalizedQuantity = promotionQualifierWrapper.getFinalizedQuantity();

    // Assert
    verify(promotionQualifier).getFinalizedQuantity();
    assertEquals(1, actualFinalizedQuantity);
  }

  /**
   * Test {@link PromotionQualifierWrapper#getFinalizedQuantity()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#getFinalizedQuantity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PromotionQualifierWrapper.getFinalizedQuantity()"})
  public void testGetFinalizedQuantity_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PromotionQualifierWrapper(new PromotionQualifier()).getFinalizedQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#incrementQuantity(int)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#incrementQuantity(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.incrementQuantity(int)"})
  public void testIncrementQuantity() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifier());

    // Act
    promotionQualifierWrapper.incrementQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#incrementQuantity(int)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#incrementQuantity(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.incrementQuantity(int)"})
  public void testIncrementQuantity2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()));

    // Act
    promotionQualifierWrapper.incrementQuantity(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getQuantity());
    assertFalse(promotionQualifierWrapper.isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#incrementQuantity(int)}.
   *
   * <ul>
   *   <li>Then calls {@link PromotionQualifier#incrementQuantity(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#incrementQuantity(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.incrementQuantity(int)"})
  public void testIncrementQuantity_thenCallsIncrementQuantity() {
    // Arrange
    doNothing().when(promotionQualifier).incrementQuantity(anyInt());

    // Act
    promotionQualifierWrapper.incrementQuantity(1);

    // Assert
    verify(promotionQualifier).incrementQuantity(1);
  }

  /**
   * Test {@link PromotionQualifierWrapper#resetQty(int)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#resetQty(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.resetQty(int)"})
  public void testResetQty() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifier());

    // Act
    promotionQualifierWrapper.resetQty(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getFinalizedQuantity());
    assertEquals(1, promotionQualifierWrapper.getQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#resetQty(int)}.
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#resetQty(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.resetQty(int)"})
  public void testResetQty2() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()));

    // Act
    promotionQualifierWrapper.resetQty(1);

    // Assert
    assertEquals(1, promotionQualifierWrapper.getFinalizedQuantity());
    assertEquals(1, promotionQualifierWrapper.getQuantity());
  }

  /**
   * Test {@link PromotionQualifierWrapper#resetQty(int)}.
   *
   * <ul>
   *   <li>Given {@link PromotionQualifier} {@link PromotionQualifier#resetQty(int)} does nothing.
   *   <li>Then calls {@link PromotionQualifier#resetQty(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#resetQty(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotionQualifierWrapper.resetQty(int)"})
  public void testResetQty_givenPromotionQualifierResetQtyDoesNothing_thenCallsResetQty() {
    // Arrange
    doNothing().when(promotionQualifier).resetQty(anyInt());

    // Act
    promotionQualifierWrapper.resetQty(1);

    // Assert
    verify(promotionQualifier).resetQty(1);
  }

  /**
   * Test {@link PromotionQualifierWrapper#split(int)}.
   *
   * <ul>
   *   <li>Given {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}
   *       with pq is {@link
   *       PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#split(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionQualifier PromotionQualifierWrapper.split(int)"})
  public void testSplit_givenPromotionQualifierWrapperWithPqIsPromotionQualifierWrapper() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))
                .split(1));
  }

  /**
   * Test {@link PromotionQualifierWrapper#split(int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#split(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionQualifier PromotionQualifierWrapper.split(int)"})
  public void testSplit_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PromotionQualifierWrapper(new PromotionQualifier()).split(1));
  }

  /**
   * Test {@link PromotionQualifierWrapper#split(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return Price is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#split(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PromotionQualifier PromotionQualifierWrapper.split(int)"})
  public void testSplit_whenMinusOne_thenReturnPriceIsNull() {
    // Arrange
    PromotionQualifierWrapper promotionQualifierWrapper =
        new PromotionQualifierWrapper(new PromotionQualifier());

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
   *
   * <ul>
   *   <li>Given {@link PromotionQualifier} (default constructor) incrementQuantity one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#isFinalized()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PromotionQualifierWrapper.isFinalized()"})
  public void testIsFinalized_givenPromotionQualifierIncrementQuantityOne_thenReturnFalse() {
    // Arrange
    PromotionQualifier pq = new PromotionQualifier();
    pq.incrementQuantity(1);

    // Act and Assert
    assertFalse(new PromotionQualifierWrapper(pq).isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#isFinalized()}.
   *
   * <ul>
   *   <li>Given {@link PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}
   *       with pq is {@link
   *       PromotionQualifierWrapper#PromotionQualifierWrapper(PromotionQualifier)}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#isFinalized()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PromotionQualifierWrapper.isFinalized()"})
  public void testIsFinalized_givenPromotionQualifierWrapperWithPqIsPromotionQualifierWrapper() {
    // Arrange, Act and Assert
    assertTrue(
        new PromotionQualifierWrapper(new PromotionQualifierWrapper(new PromotionQualifier()))
            .isFinalized());
  }

  /**
   * Test {@link PromotionQualifierWrapper#isFinalized()}.
   *
   * <ul>
   *   <li>Then calls {@link PromotionQualifier#isFinalized()}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#isFinalized()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PromotionQualifierWrapper.isFinalized()"})
  public void testIsFinalized_thenCallsIsFinalized() {
    // Arrange
    when(promotionQualifier.isFinalized()).thenReturn(true);

    // Act
    boolean actualIsFinalizedResult = promotionQualifierWrapper.isFinalized();

    // Assert
    verify(promotionQualifier).isFinalized();
    assertTrue(actualIsFinalizedResult);
  }

  /**
   * Test {@link PromotionQualifierWrapper#isFinalized()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PromotionQualifierWrapper#isFinalized()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PromotionQualifierWrapper.isFinalized()"})
  public void testIsFinalized_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PromotionQualifierWrapper(new PromotionQualifier()).isFinalized());
  }
}
