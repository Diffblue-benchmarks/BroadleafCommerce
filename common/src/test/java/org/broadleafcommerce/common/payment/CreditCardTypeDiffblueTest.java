/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CreditCardType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CreditCardTypeDiffblueTest {
  @Autowired
  private CreditCardType creditCardType;

  /**
   * Test {@link CreditCardType#getInstance(String)}.
   * <p>
   * Method under test: {@link CreditCardType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    CreditCardType actualInstance = CreditCardType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardType#CreditCardType()}
   *   <li>{@link CreditCardType#getFriendlyType()}
   *   <li>{@link CreditCardType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CreditCardType actualCreditCardType = new CreditCardType();
    String actualFriendlyType = actualCreditCardType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualCreditCardType.getType());
  }

  /**
   * Test {@link CreditCardType#CreditCardType(String, String)}.
   * <p>
   * Method under test: {@link CreditCardType#CreditCardType(String, String)}
   */
  @Test
  public void testNewCreditCardType() {
    // Arrange and Act
    CreditCardType actualCreditCardType = new CreditCardType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualCreditCardType.getFriendlyType());
    assertEquals("Type", actualCreditCardType.getType());
  }

  /**
   * Test {@link CreditCardType#equals(Object)}, and
   * {@link CreditCardType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardType#equals(Object)}
   *   <li>{@link CreditCardType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CreditCardType creditCardType = CreditCardType.AMEX;
    CreditCardType creditCardType2 = CreditCardType.AMEX;

    // Act and Assert
    assertEquals(creditCardType, creditCardType2);
    int expectedHashCodeResult = creditCardType.hashCode();
    assertEquals(expectedHashCodeResult, creditCardType2.hashCode());
  }

  /**
   * Test {@link CreditCardType#equals(Object)}, and
   * {@link CreditCardType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardType#equals(Object)}
   *   <li>{@link CreditCardType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CreditCardType creditCardType = CreditCardType.DINERSCLUB_CARTEBLANCHE;
    CreditCardType creditCardType2 = new CreditCardType("DINERSCLUB_CARTEBLANCHE", "DINERSCLUB_CARTEBLANCHE");

    // Act and Assert
    assertEquals(creditCardType, creditCardType2);
    int expectedHashCodeResult = creditCardType.hashCode();
    assertEquals(expectedHashCodeResult, creditCardType2.hashCode());
  }

  /**
   * Test {@link CreditCardType#equals(Object)}, and
   * {@link CreditCardType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardType#equals(Object)}
   *   <li>{@link CreditCardType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CreditCardType creditCardType = new CreditCardType();
    CreditCardType creditCardType2 = new CreditCardType();

    // Act and Assert
    assertEquals(creditCardType, creditCardType2);
    int expectedHashCodeResult = creditCardType.hashCode();
    assertEquals(expectedHashCodeResult, creditCardType2.hashCode());
  }

  /**
   * Test {@link CreditCardType#equals(Object)}, and
   * {@link CreditCardType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CreditCardType#equals(Object)}
   *   <li>{@link CreditCardType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CreditCardType creditCardType = CreditCardType.AMEX;

    // Act and Assert
    assertEquals(creditCardType, creditCardType);
    int expectedHashCodeResult = creditCardType.hashCode();
    assertEquals(expectedHashCodeResult, creditCardType.hashCode());
  }

  /**
   * Test {@link CreditCardType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CreditCardType.DINERSCLUB_CARTEBLANCHE, CreditCardType.AMEX);
    assertNotEquals(new CreditCardType(), CreditCardType.AMEX);
  }

  /**
   * Test {@link CreditCardType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CreditCardType.AMEX, null);
  }

  /**
   * Test {@link CreditCardType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CreditCardType.AMEX, "Different type to CreditCardType");
  }
}
