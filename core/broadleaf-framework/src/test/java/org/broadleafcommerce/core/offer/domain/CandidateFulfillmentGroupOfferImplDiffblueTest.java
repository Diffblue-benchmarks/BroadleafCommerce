package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CandidateFulfillmentGroupOfferImplDiffblueTest {
  @Autowired private CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl;

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#getOffer()}.
   *
   * <p>Method under test: {@link CandidateFulfillmentGroupOfferImpl#getOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.offer.domain.Offer CandidateFulfillmentGroupOfferImpl.getOffer()"
  })
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull(candidateFulfillmentGroupOfferImpl.getOffer());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#getDiscountedPrice()}.
   *
   * <p>Method under test: {@link CandidateFulfillmentGroupOfferImpl#getDiscountedPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money CandidateFulfillmentGroupOfferImpl.getDiscountedPrice()"})
  public void testGetDiscountedPrice() {
    // Arrange, Act and Assert
    assertNull(candidateFulfillmentGroupOfferImpl.getDiscountedPrice());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#setDiscountedPrice(Money)}.
   *
   * <p>Method under test: {@link CandidateFulfillmentGroupOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CandidateFulfillmentGroupOfferImpl.setDiscountedPrice(Money)"})
  public void testSetDiscountedPrice() {
    // Arrange
    Money discountedPrice = new Money();

    // Act
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), candidateFulfillmentGroupOfferImpl.discountedPrice);
    BigDecimal bigDecimal = candidateFulfillmentGroupOfferImpl.discountedPrice;
    Money absResult = discountedPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = discountedPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#setDiscountedPrice(Money)}.
   *
   * <p>Method under test: {@link CandidateFulfillmentGroupOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CandidateFulfillmentGroupOfferImpl.setDiscountedPrice(Money)"})
  public void testSetDiscountedPrice2() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);

    // Assert
    verify(discountedPrice).getAmount();
    assertEquals(new BigDecimal("2.3"), candidateFulfillmentGroupOfferImpl.discountedPrice);
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#setFulfillmentGroup(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link
   * CandidateFulfillmentGroupOfferImpl#setFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CandidateFulfillmentGroupOfferImpl.setFulfillmentGroup(FulfillmentGroup)"
  })
  public void testSetFulfillmentGroup() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act
    candidateFulfillmentGroupOfferImpl.setFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertSame(fulfillmentGroup, candidateFulfillmentGroupOfferImpl.getFulfillmentGroup());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}, and {@link
   * CandidateFulfillmentGroupOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
    "int CandidateFulfillmentGroupOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
    assertEquals(
        candidateFulfillmentGroupOfferImpl.hashCode(),
        candidateFulfillmentGroupOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}, and {@link
   * CandidateFulfillmentGroupOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
    "int CandidateFulfillmentGroupOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
    assertEquals(
        candidateFulfillmentGroupOfferImpl.hashCode(),
        candidateFulfillmentGroupOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}, and {@link
   * CandidateFulfillmentGroupOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
    "int CandidateFulfillmentGroupOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(null);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
    assertEquals(
        candidateFulfillmentGroupOfferImpl.hashCode(),
        candidateFulfillmentGroupOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}, and {@link
   * CandidateFulfillmentGroupOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
    "int CandidateFulfillmentGroupOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);
    candidateFulfillmentGroupOfferImpl.setId(null);

    Money discountedPrice2 = mock(Money.class);
    when(discountedPrice2.getAmount()).thenReturn(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(discountedPrice2);
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
    assertEquals(
        candidateFulfillmentGroupOfferImpl.hashCode(),
        candidateFulfillmentGroupOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}, and {@link
   * CandidateFulfillmentGroupOfferImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
    "int CandidateFulfillmentGroupOfferImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl);
    int expectedHashCodeResult = candidateFulfillmentGroupOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateFulfillmentGroupOfferImpl.hashCode());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
    "int CandidateFulfillmentGroupOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(2L);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
    "int CandidateFulfillmentGroupOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money(10.0d));
    candidateFulfillmentGroupOfferImpl.setId(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
    "int CandidateFulfillmentGroupOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);
    candidateFulfillmentGroupOfferImpl.setId(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
    "int CandidateFulfillmentGroupOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, null);
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
    "int CandidateFulfillmentGroupOfferImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(
        candidateFulfillmentGroupOfferImpl, "Different type to CandidateFulfillmentGroupOfferImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CandidateFulfillmentGroupOfferImpl}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#setId(Long)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#getFulfillmentGroup()}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#getId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CandidateFulfillmentGroupOfferImpl.<init>()",
    "FulfillmentGroup CandidateFulfillmentGroupOfferImpl.getFulfillmentGroup()",
    "Long CandidateFulfillmentGroupOfferImpl.getId()",
    "void CandidateFulfillmentGroupOfferImpl.setId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CandidateFulfillmentGroupOfferImpl actualCandidateFulfillmentGroupOfferImpl =
        new CandidateFulfillmentGroupOfferImpl();
    actualCandidateFulfillmentGroupOfferImpl.setId(
        CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    FulfillmentGroup actualFulfillmentGroup =
        actualCandidateFulfillmentGroupOfferImpl.getFulfillmentGroup();

    // Assert
    assertNull(actualFulfillmentGroup);
    assertEquals(
        CandidateFulfillmentGroupOfferImpl.serialVersionUID,
        actualCandidateFulfillmentGroupOfferImpl.getId().longValue());
  }
}
