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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CandidateFulfillmentGroupOfferImplDiffblueTest {
  @Autowired
  private CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl;

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#getOffer()}.
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#getOffer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer CandidateFulfillmentGroupOfferImpl.getOffer()"})
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull((new CandidateFulfillmentGroupOfferImpl()).getOffer());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#setOffer(Offer)}.
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#setOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateFulfillmentGroupOfferImpl.setOffer(Offer)"})
  public void testSetOffer() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    candidateFulfillmentGroupOfferImpl2.setOffer(offer);

    // Assert
    assertTrue(candidateFulfillmentGroupOfferImpl2.offer instanceof OfferImpl);
    assertEquals(2147483646, candidateFulfillmentGroupOfferImpl2.getPriority());
    assertSame(offer, candidateFulfillmentGroupOfferImpl2.getOffer());
    assertSame(offer, candidateFulfillmentGroupOfferImpl2.deproxiedOffer);
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#getDiscountedPrice()}.
   * <ul>
   *   <li>Given {@link CandidateFulfillmentGroupOfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#getDiscountedPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money CandidateFulfillmentGroupOfferImpl.getDiscountedPrice()"})
  public void testGetDiscountedPrice_givenCandidateFulfillmentGroupOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CandidateFulfillmentGroupOfferImpl()).getDiscountedPrice());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#setDiscountedPrice(Money)}.
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateFulfillmentGroupOfferImpl.setDiscountedPrice(Money)"})
  public void testSetDiscountedPrice() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    Money discountedPrice = new Money();

    // Act
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(discountedPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), candidateFulfillmentGroupOfferImpl2.discountedPrice);
    BigDecimal bigDecimal = candidateFulfillmentGroupOfferImpl2.discountedPrice;
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
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateFulfillmentGroupOfferImpl.setDiscountedPrice(Money)"})
  public void testSetDiscountedPrice2() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(discountedPrice);

    // Assert
    verify(discountedPrice).getAmount();
    assertEquals(new BigDecimal("2.3"), candidateFulfillmentGroupOfferImpl2.discountedPrice);
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#setFulfillmentGroup(FulfillmentGroup)}.
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#setFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateFulfillmentGroupOfferImpl.setFulfillmentGroup(FulfillmentGroup)"})
  public void testSetFulfillmentGroup() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act
    candidateFulfillmentGroupOfferImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Assert
    assertSame(fulfillmentGroup, candidateFulfillmentGroupOfferImpl2.getFulfillmentGroup());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}, and {@link CandidateFulfillmentGroupOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
      "int CandidateFulfillmentGroupOfferImpl.hashCode()"})
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
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}, and {@link CandidateFulfillmentGroupOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
      "int CandidateFulfillmentGroupOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
    int expectedHashCodeResult = candidateFulfillmentGroupOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateFulfillmentGroupOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}, and {@link CandidateFulfillmentGroupOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
      "int CandidateFulfillmentGroupOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(null);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
    int expectedHashCodeResult = candidateFulfillmentGroupOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateFulfillmentGroupOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}, and {@link CandidateFulfillmentGroupOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
      "int CandidateFulfillmentGroupOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(discountedPrice);
    candidateFulfillmentGroupOfferImpl.setId(null);
    Money discountedPrice2 = mock(Money.class);
    when(discountedPrice2.getAmount()).thenReturn(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(discountedPrice2);
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
    int expectedHashCodeResult = candidateFulfillmentGroupOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateFulfillmentGroupOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}, and {@link CandidateFulfillmentGroupOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
      "int CandidateFulfillmentGroupOfferImpl.hashCode()"})
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
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
      "int CandidateFulfillmentGroupOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(2L);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
      "int CandidateFulfillmentGroupOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money(10.0d));
    candidateFulfillmentGroupOfferImpl.setId(null);

    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl2 = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl2.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl2.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, candidateFulfillmentGroupOfferImpl2);
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
      "int CandidateFulfillmentGroupOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
      "int CandidateFulfillmentGroupOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, null);
  }

  /**
   * Test {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateFulfillmentGroupOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateFulfillmentGroupOfferImpl.equals(Object)",
      "int CandidateFulfillmentGroupOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    candidateFulfillmentGroupOfferImpl.setDiscountedPrice(new Money());
    candidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateFulfillmentGroupOfferImpl, "Different type to CandidateFulfillmentGroupOfferImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CandidateFulfillmentGroupOfferImpl}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#setId(Long)}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#getFulfillmentGroup()}
   *   <li>{@link CandidateFulfillmentGroupOfferImpl#getId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateFulfillmentGroupOfferImpl.<init>()",
      "FulfillmentGroup CandidateFulfillmentGroupOfferImpl.getFulfillmentGroup()",
      "Long CandidateFulfillmentGroupOfferImpl.getId()", "void CandidateFulfillmentGroupOfferImpl.setId(Long)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    CandidateFulfillmentGroupOfferImpl actualCandidateFulfillmentGroupOfferImpl = new CandidateFulfillmentGroupOfferImpl();
    actualCandidateFulfillmentGroupOfferImpl.setId(CandidateFulfillmentGroupOfferImpl.serialVersionUID);
    FulfillmentGroup actualFulfillmentGroup = actualCandidateFulfillmentGroupOfferImpl.getFulfillmentGroup();

    // Assert
    assertNull(actualFulfillmentGroup);
    assertEquals(CandidateFulfillmentGroupOfferImpl.serialVersionUID,
        actualCandidateFulfillmentGroupOfferImpl.getId().longValue());
  }
}
