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
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class CreditCardTypeCheckDiffblueTest {
  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code (2014)?(2149)?[0-9]{11}}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when201421490911_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> CreditCardTypeCheck.getCreditCardType("(2014)?(2149)?[0-9]{11}"));
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code 4999999999999}.</li>
   *   <li>Then return Type is {@code VISA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when4999999999999_thenReturnTypeIsVisa() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("4999999999999");

    // Assert
    assertEquals("VISA", actualCreditCardType.getType());
    assertEquals("Visa", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code 3638999999999999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when3638999999999999() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("3638999999999999");

    // Assert
    assertEquals("DINERSCLUB_CARTEBLANCHE", actualCreditCardType.getType());
    assertEquals("Diner's Club / Carte Blanche", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code 3999999999999999}.</li>
   *   <li>Then return FriendlyType is {@code JCB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when3999999999999999_thenReturnFriendlyTypeIsJcb() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("3999999999999999");

    // Assert
    assertEquals("JCB", actualCreditCardType.getFriendlyType());
    assertEquals("JCB", actualCreditCardType.getType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code 4999999999999999}.</li>
   *   <li>Then return Type is {@code VISA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when4999999999999999_thenReturnTypeIsVisa() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("4999999999999999");

    // Assert
    assertEquals("VISA", actualCreditCardType.getType());
    assertEquals("Visa", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code 6011999999999999}.</li>
   *   <li>Then return Type is {@code DISCOVER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when6011999999999999_thenReturnTypeIsDiscover() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("6011999999999999");

    // Assert
    assertEquals("DISCOVER", actualCreditCardType.getType());
    assertEquals("Discover", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code 34379999999999999}.</li>
   *   <li>Then return Type is {@code AMEX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when34379999999999999_thenReturnTypeIsAmex() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("34379999999999999");

    // Assert
    assertEquals("AMEX", actualCreditCardType.getType());
    assertEquals("American Express", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code 2014214999999999999}.</li>
   *   <li>Then return Type is {@code ENROUTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when2014214999999999999_thenReturnTypeIsEnroute() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("2014214999999999999");

    // Assert
    assertEquals("ENROUTE", actualCreditCardType.getType());
    assertEquals("En Route", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code 2131180099999999999}.</li>
   *   <li>Then return FriendlyType is {@code JCB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when2131180099999999999_thenReturnFriendlyTypeIsJcb() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("2131180099999999999");

    // Assert
    assertEquals("JCB", actualCreditCardType.getFriendlyType());
    assertEquals("JCB", actualCreditCardType.getType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code 515253545599999999999999}.</li>
   *   <li>Then return Type is {@code MASTERCARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when515253545599999999999999_thenReturnTypeIsMastercard() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("515253545599999999999999");

    // Assert
    assertEquals("MASTERCARD", actualCreditCardType.getType());
    assertEquals("Master Card", actualCreditCardType.getFriendlyType());
  }

  /**
   * Test {@link CreditCardTypeCheck#getCreditCardType(String)}.
   * <ul>
   *   <li>When {@code 30030130230330430599999999999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType_when30030130230330430599999999999() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("30030130230330430599999999999");

    // Assert
    assertEquals("DINERSCLUB_CARTEBLANCHE", actualCreditCardType.getType());
    assertEquals("Diner's Club / Carte Blanche", actualCreditCardType.getFriendlyType());
  }
}
