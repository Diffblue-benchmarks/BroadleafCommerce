package org.broadleafcommerce.core.offer.service.discount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FulfillmentGroupOfferPotentialDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupOfferPotential#setOffer(Offer)}
   *   <li>{@link FulfillmentGroupOfferPotential#setPriority(int)}
   *   <li>{@link FulfillmentGroupOfferPotential#setTotalSavings(Money)}
   *   <li>{@link FulfillmentGroupOfferPotential#getOffer()}
   *   <li>{@link FulfillmentGroupOfferPotential#getPriority()}
   *   <li>{@link FulfillmentGroupOfferPotential#getTotalSavings()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Offer FulfillmentGroupOfferPotential.getOffer()",
    "int FulfillmentGroupOfferPotential.getPriority()",
    "Money FulfillmentGroupOfferPotential.getTotalSavings()",
    "void FulfillmentGroupOfferPotential.setOffer(Offer)",
    "void FulfillmentGroupOfferPotential.setPriority(int)",
    "void FulfillmentGroupOfferPotential.setTotalSavings(Money)"
  })
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();
    OfferImpl offer = new OfferImpl();

    // Act
    fulfillmentGroupOfferPotential.setOffer(offer);
    fulfillmentGroupOfferPotential.setPriority(1);
    Money totalSavings = new Money();
    fulfillmentGroupOfferPotential.setTotalSavings(totalSavings);
    Offer actualOffer = fulfillmentGroupOfferPotential.getOffer();
    int actualPriority = fulfillmentGroupOfferPotential.getPriority();

    // Assert
    assertEquals(1, actualPriority);
    assertSame(totalSavings, fulfillmentGroupOfferPotential.getTotalSavings());
    assertSame(offer, actualOffer);
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}, and {@link
   * FulfillmentGroupOfferPotential#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupOfferPotential#equals(Object)}
   *   <li>{@link FulfillmentGroupOfferPotential#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferPotential.equals(Object)",
    "int FulfillmentGroupOfferPotential.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupOfferPotential, fulfillmentGroupOfferPotential2);
    assertEquals(
        fulfillmentGroupOfferPotential.hashCode(), fulfillmentGroupOfferPotential2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}, and {@link
   * FulfillmentGroupOfferPotential#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupOfferPotential#equals(Object)}
   *   <li>{@link FulfillmentGroupOfferPotential#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferPotential.equals(Object)",
    "int FulfillmentGroupOfferPotential.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(null);
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(null);
    fulfillmentGroupOfferPotential2.setPriority(1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupOfferPotential, fulfillmentGroupOfferPotential2);
    assertEquals(
        fulfillmentGroupOfferPotential.hashCode(), fulfillmentGroupOfferPotential2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}, and {@link
   * FulfillmentGroupOfferPotential#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupOfferPotential#equals(Object)}
   *   <li>{@link FulfillmentGroupOfferPotential#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferPotential.equals(Object)",
    "int FulfillmentGroupOfferPotential.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupOfferPotential, fulfillmentGroupOfferPotential);
    int expectedHashCodeResult = fulfillmentGroupOfferPotential.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupOfferPotential.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupOfferPotential#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferPotential.equals(Object)",
    "int FulfillmentGroupOfferPotential.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setId(OfferImpl.serialVersionUID);

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(offer);
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupOfferPotential, fulfillmentGroupOfferPotential2);
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupOfferPotential#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferPotential.equals(Object)",
    "int FulfillmentGroupOfferPotential.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(null);
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupOfferPotential, fulfillmentGroupOfferPotential2);
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupOfferPotential#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferPotential.equals(Object)",
    "int FulfillmentGroupOfferPotential.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupOfferPotential, null);
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupOfferPotential#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferPotential.equals(Object)",
    "int FulfillmentGroupOfferPotential.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    // Act and Assert
    assertNotEquals(
        fulfillmentGroupOfferPotential, "Different type to FulfillmentGroupOfferPotential");
  }

  /**
   * Test new {@link FulfillmentGroupOfferPotential} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * FulfillmentGroupOfferPotential}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupOfferPotential.<init>()"})
  public void testNewFulfillmentGroupOfferPotential() {
    // Arrange and Act
    FulfillmentGroupOfferPotential actualFulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();

    // Assert
    Money totalSavings = actualFulfillmentGroupOfferPotential.getTotalSavings();
    Currency currency = totalSavings.getCurrency();
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.getSymbol());
    assertEquals("USD", currency.toString());
    assertNull(actualFulfillmentGroupOfferPotential.getOffer());
    assertEquals(0, actualFulfillmentGroupOfferPotential.getPriority());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    assertEquals(new BigDecimal("0.00"), totalSavings.getAmount());
    Money actualAbsResult = totalSavings.abs();
    assertEquals(totalSavings, actualAbsResult);
    Money actualZeroResult = totalSavings.zero();
    assertEquals(totalSavings, actualZeroResult);
  }
}
