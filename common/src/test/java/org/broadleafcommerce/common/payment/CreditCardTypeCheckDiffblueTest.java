/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class CreditCardTypeCheckDiffblueTest {
  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("515253545599999999999999");

    // Assert
    assertEquals("MASTERCARD", actualCreditCardType.getType());
    assertEquals("Master Card", actualCreditCardType.getFriendlyType());
  }

  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType2() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("4999999999999999");

    // Assert
    assertEquals("VISA", actualCreditCardType.getType());
    assertEquals("Visa", actualCreditCardType.getFriendlyType());
  }

  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType3() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("4999999999999");

    // Assert
    assertEquals("VISA", actualCreditCardType.getType());
    assertEquals("Visa", actualCreditCardType.getFriendlyType());
  }

  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType4() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("34379999999999999");

    // Assert
    assertEquals("AMEX", actualCreditCardType.getType());
    assertEquals("American Express", actualCreditCardType.getFriendlyType());
  }

  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType5() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("30030130230330430599999999999");

    // Assert
    assertEquals("DINERSCLUB_CARTEBLANCHE", actualCreditCardType.getType());
    assertEquals("Diner's Club / Carte Blanche", actualCreditCardType.getFriendlyType());
  }

  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType6() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("3638999999999999");

    // Assert
    assertEquals("DINERSCLUB_CARTEBLANCHE", actualCreditCardType.getType());
    assertEquals("Diner's Club / Carte Blanche", actualCreditCardType.getFriendlyType());
  }

  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType7() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("6011999999999999");

    // Assert
    assertEquals("DISCOVER", actualCreditCardType.getType());
    assertEquals("Discover", actualCreditCardType.getFriendlyType());
  }

  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType8() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> CreditCardTypeCheck.getCreditCardType("(2014)?(2149)?[0-9]{11}"));
  }

  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType9() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("2014214999999999999");

    // Assert
    assertEquals("ENROUTE", actualCreditCardType.getType());
    assertEquals("En Route", actualCreditCardType.getFriendlyType());
  }

  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType10() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("3999999999999999");

    // Assert
    assertEquals("JCB", actualCreditCardType.getFriendlyType());
    assertEquals("JCB", actualCreditCardType.getType());
  }

  /**
   * Method under test: {@link CreditCardTypeCheck#getCreditCardType(String)}
   */
  @Test
  public void testGetCreditCardType11() {
    // Arrange and Act
    CreditCardType actualCreditCardType = CreditCardTypeCheck.getCreditCardType("2131180099999999999");

    // Assert
    assertEquals("JCB", actualCreditCardType.getFriendlyType());
    assertEquals("JCB", actualCreditCardType.getType());
  }
}
