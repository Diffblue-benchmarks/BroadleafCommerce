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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.math.BigDecimal;
import java.util.Currency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.junit.Test;

public class FulfillmentGroupOfferPotentialDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    OfferImpl offer = new OfferImpl();

    // Act
    fulfillmentGroupOfferPotential.setOffer(offer);
    fulfillmentGroupOfferPotential.setPriority(1);
    Money totalSavings = new Money();
    fulfillmentGroupOfferPotential.setTotalSavings(totalSavings);
    Offer actualOffer = fulfillmentGroupOfferPotential.getOffer();
    int actualPriority = fulfillmentGroupOfferPotential.getPriority();

    // Assert that nothing has changed
    assertEquals(1, actualPriority);
    assertSame(totalSavings, fulfillmentGroupOfferPotential.getTotalSavings());
    assertSame(offer, actualOffer);
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}, and
   * {@link FulfillmentGroupOfferPotential#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupOfferPotential#equals(Object)}
   *   <li>{@link FulfillmentGroupOfferPotential#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupOfferPotential, fulfillmentGroupOfferPotential2);
    int expectedHashCodeResult = fulfillmentGroupOfferPotential.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupOfferPotential2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}, and
   * {@link FulfillmentGroupOfferPotential#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupOfferPotential#equals(Object)}
   *   <li>{@link FulfillmentGroupOfferPotential#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(null);
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(null);
    fulfillmentGroupOfferPotential2.setPriority(1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupOfferPotential, fulfillmentGroupOfferPotential2);
    int expectedHashCodeResult = fulfillmentGroupOfferPotential.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupOfferPotential2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}, and
   * {@link FulfillmentGroupOfferPotential#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupOfferPotential#equals(Object)}
   *   <li>{@link FulfillmentGroupOfferPotential#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupOfferPotential#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setId(OfferImpl.serialVersionUID);

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(offer);
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupOfferPotential, fulfillmentGroupOfferPotential2);
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupOfferPotential#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(null);
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupOfferPotential, fulfillmentGroupOfferPotential2);
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupOfferPotential#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(mock(OfferImpl.class));
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupOfferPotential, fulfillmentGroupOfferPotential2);
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupOfferPotential#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupOfferPotential, null);
  }

  /**
   * Test {@link FulfillmentGroupOfferPotential#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupOfferPotential#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupOfferPotential, "Different type to FulfillmentGroupOfferPotential");
  }

  /**
   * Test new {@link FulfillmentGroupOfferPotential} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FulfillmentGroupOfferPotential}
   */
  @Test
  public void testNewFulfillmentGroupOfferPotential() {
    // Arrange and Act
    FulfillmentGroupOfferPotential actualFulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();

    // Assert
    Money totalSavings = actualFulfillmentGroupOfferPotential.getTotalSavings();
    Currency currency = totalSavings.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(actualFulfillmentGroupOfferPotential.getOffer());
    assertEquals(0, actualFulfillmentGroupOfferPotential.getPriority());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, totalSavings.getAmount());
    assertEquals(totalSavings, totalSavings.abs());
    assertEquals(totalSavings, totalSavings.zero());
  }
}
