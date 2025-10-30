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
public class CandidateOrderOfferImplDiffblueTest {
  @Autowired
  private CandidateOrderOfferImpl candidateOrderOfferImpl;

  /**
   * Test {@link CandidateOrderOfferImpl#getOffer()}.
   * <p>
   * Method under test: {@link CandidateOrderOfferImpl#getOffer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Offer CandidateOrderOfferImpl.getOffer()"})
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull((new CandidateOrderOfferImpl()).getOffer());
  }

  /**
   * Test {@link CandidateOrderOfferImpl#setOffer(Offer)}.
   * <p>
   * Method under test: {@link CandidateOrderOfferImpl#setOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateOrderOfferImpl.setOffer(Offer)"})
  public void testSetOffer() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl2 = new CandidateOrderOfferImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    candidateOrderOfferImpl2.setOffer(offer);

    // Assert
    assertTrue(candidateOrderOfferImpl2.offer instanceof OfferImpl);
    assertEquals(2147483646, candidateOrderOfferImpl2.getPriority());
    assertSame(offer, candidateOrderOfferImpl2.getOffer());
    assertSame(offer, candidateOrderOfferImpl2.deproxiedOffer);
  }

  /**
   * Test {@link CandidateOrderOfferImpl#getDiscountedPrice()}.
   * <ul>
   *   <li>Given {@link CandidateOrderOfferImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateOrderOfferImpl#getDiscountedPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money CandidateOrderOfferImpl.getDiscountedPrice()"})
  public void testGetDiscountedPrice_givenCandidateOrderOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CandidateOrderOfferImpl()).getDiscountedPrice());
  }

  /**
   * Test {@link CandidateOrderOfferImpl#setDiscountedPrice(Money)}.
   * <p>
   * Method under test: {@link CandidateOrderOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateOrderOfferImpl.setDiscountedPrice(Money)"})
  public void testSetDiscountedPrice() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl2 = new CandidateOrderOfferImpl();
    Money discountedPrice = new Money();

    // Act
    candidateOrderOfferImpl2.setDiscountedPrice(discountedPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), candidateOrderOfferImpl2.discountedPrice);
    BigDecimal bigDecimal = candidateOrderOfferImpl2.discountedPrice;
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
   * Test {@link CandidateOrderOfferImpl#setDiscountedPrice(Money)}.
   * <p>
   * Method under test: {@link CandidateOrderOfferImpl#setDiscountedPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateOrderOfferImpl.setDiscountedPrice(Money)"})
  public void testSetDiscountedPrice2() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl2 = new CandidateOrderOfferImpl();
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    candidateOrderOfferImpl2.setDiscountedPrice(discountedPrice);

    // Assert
    verify(discountedPrice).getAmount();
    assertEquals(new BigDecimal("2.3"), candidateOrderOfferImpl2.discountedPrice);
  }

  /**
   * Test {@link CandidateOrderOfferImpl#equals(Object)}, and {@link CandidateOrderOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateOrderOfferImpl#equals(Object)}
   *   <li>{@link CandidateOrderOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateOrderOfferImpl.equals(Object)", "int CandidateOrderOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(new Money());
    candidateOrderOfferImpl.setId(CandidateOrderOfferImpl.serialVersionUID);

    CandidateOrderOfferImpl candidateOrderOfferImpl2 = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl2.setDiscountedPrice(new Money());
    candidateOrderOfferImpl2.setId(CandidateOrderOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateOrderOfferImpl, candidateOrderOfferImpl2);
    int expectedHashCodeResult = candidateOrderOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateOrderOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateOrderOfferImpl#equals(Object)}, and {@link CandidateOrderOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateOrderOfferImpl#equals(Object)}
   *   <li>{@link CandidateOrderOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateOrderOfferImpl.equals(Object)", "int CandidateOrderOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(new Money());
    candidateOrderOfferImpl.setId(null);

    CandidateOrderOfferImpl candidateOrderOfferImpl2 = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl2.setDiscountedPrice(new Money());
    candidateOrderOfferImpl2.setId(CandidateOrderOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateOrderOfferImpl, candidateOrderOfferImpl2);
    int expectedHashCodeResult = candidateOrderOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateOrderOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateOrderOfferImpl#equals(Object)}, and {@link CandidateOrderOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateOrderOfferImpl#equals(Object)}
   *   <li>{@link CandidateOrderOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateOrderOfferImpl.equals(Object)", "int CandidateOrderOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(new Money());
    candidateOrderOfferImpl.setId(CandidateOrderOfferImpl.serialVersionUID);

    CandidateOrderOfferImpl candidateOrderOfferImpl2 = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl2.setDiscountedPrice(new Money());
    candidateOrderOfferImpl2.setId(null);

    // Act and Assert
    assertEquals(candidateOrderOfferImpl, candidateOrderOfferImpl2);
    int expectedHashCodeResult = candidateOrderOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateOrderOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateOrderOfferImpl#equals(Object)}, and {@link CandidateOrderOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateOrderOfferImpl#equals(Object)}
   *   <li>{@link CandidateOrderOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateOrderOfferImpl.equals(Object)", "int CandidateOrderOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(null);

    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(discountedPrice);
    candidateOrderOfferImpl.setId(null);
    Money discountedPrice2 = mock(Money.class);
    when(discountedPrice2.getAmount()).thenReturn(null);

    CandidateOrderOfferImpl candidateOrderOfferImpl2 = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl2.setDiscountedPrice(discountedPrice2);
    candidateOrderOfferImpl2.setId(CandidateOrderOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateOrderOfferImpl, candidateOrderOfferImpl2);
    int expectedHashCodeResult = candidateOrderOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateOrderOfferImpl2.hashCode());
  }

  /**
   * Test {@link CandidateOrderOfferImpl#equals(Object)}, and {@link CandidateOrderOfferImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CandidateOrderOfferImpl#equals(Object)}
   *   <li>{@link CandidateOrderOfferImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateOrderOfferImpl.equals(Object)", "int CandidateOrderOfferImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(new Money());
    candidateOrderOfferImpl.setId(CandidateOrderOfferImpl.serialVersionUID);

    // Act and Assert
    assertEquals(candidateOrderOfferImpl, candidateOrderOfferImpl);
    int expectedHashCodeResult = candidateOrderOfferImpl.hashCode();
    assertEquals(expectedHashCodeResult, candidateOrderOfferImpl.hashCode());
  }

  /**
   * Test {@link CandidateOrderOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateOrderOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateOrderOfferImpl.equals(Object)", "int CandidateOrderOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(new Money());
    candidateOrderOfferImpl.setId(2L);

    CandidateOrderOfferImpl candidateOrderOfferImpl2 = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl2.setDiscountedPrice(new Money());
    candidateOrderOfferImpl2.setId(CandidateOrderOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateOrderOfferImpl, candidateOrderOfferImpl2);
  }

  /**
   * Test {@link CandidateOrderOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateOrderOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateOrderOfferImpl.equals(Object)", "int CandidateOrderOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(new Money(10.0d));
    candidateOrderOfferImpl.setId(null);

    CandidateOrderOfferImpl candidateOrderOfferImpl2 = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl2.setDiscountedPrice(new Money());
    candidateOrderOfferImpl2.setId(CandidateOrderOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateOrderOfferImpl, candidateOrderOfferImpl2);
  }

  /**
   * Test {@link CandidateOrderOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateOrderOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateOrderOfferImpl.equals(Object)", "int CandidateOrderOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Money discountedPrice = mock(Money.class);
    when(discountedPrice.getAmount()).thenReturn(null);

    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(discountedPrice);
    candidateOrderOfferImpl.setId(null);

    CandidateOrderOfferImpl candidateOrderOfferImpl2 = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl2.setDiscountedPrice(new Money());
    candidateOrderOfferImpl2.setId(CandidateOrderOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateOrderOfferImpl, candidateOrderOfferImpl2);
  }

  /**
   * Test {@link CandidateOrderOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateOrderOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateOrderOfferImpl.equals(Object)", "int CandidateOrderOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(new Money());
    candidateOrderOfferImpl.setId(CandidateOrderOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateOrderOfferImpl, null);
  }

  /**
   * Test {@link CandidateOrderOfferImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CandidateOrderOfferImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CandidateOrderOfferImpl.equals(Object)", "int CandidateOrderOfferImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CandidateOrderOfferImpl candidateOrderOfferImpl = new CandidateOrderOfferImpl();
    candidateOrderOfferImpl.setDiscountedPrice(new Money());
    candidateOrderOfferImpl.setId(CandidateOrderOfferImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(candidateOrderOfferImpl, "Different type to CandidateOrderOfferImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CandidateOrderOfferImpl}
   *   <li>{@link CandidateOrderOfferImpl#setId(Long)}
   *   <li>{@link CandidateOrderOfferImpl#getId()}
   *   <li>{@link CandidateOrderOfferImpl#getOrder()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CandidateOrderOfferImpl.<init>()", "Long CandidateOrderOfferImpl.getId()",
      "org.broadleafcommerce.core.order.domain.Order CandidateOrderOfferImpl.getOrder()",
      "void CandidateOrderOfferImpl.setId(Long)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    CandidateOrderOfferImpl actualCandidateOrderOfferImpl = new CandidateOrderOfferImpl();
    actualCandidateOrderOfferImpl.setId(CandidateOrderOfferImpl.serialVersionUID);
    Long actualId = actualCandidateOrderOfferImpl.getId();

    // Assert
    assertNull(actualCandidateOrderOfferImpl.getOrder());
    assertEquals(CandidateOrderOfferImpl.serialVersionUID, actualId.longValue());
  }
}
