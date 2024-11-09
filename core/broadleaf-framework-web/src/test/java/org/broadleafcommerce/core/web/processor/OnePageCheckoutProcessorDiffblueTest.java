/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OnePageCheckoutProcessorDiffblueTest {
  /**
   * Test {@link OnePageCheckoutProcessor#getName()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("one_page_checkout", (new OnePageCheckoutProcessor()).getName());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new OnePageCheckoutProcessor()).getPrecedence());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#useGlobalScope()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#useGlobalScope()}
   */
  @Test
  @DisplayName("Test useGlobalScope()")
  void testUseGlobalScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OnePageCheckoutProcessor()).useGlobalScope());
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateExpirationMonths()}.
   * <p>
   * Method under test:
   * {@link OnePageCheckoutProcessor#populateExpirationMonths()}
   */
  @Test
  @DisplayName("Test populateExpirationMonths()")
  void testPopulateExpirationMonths() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<String> actualPopulateExpirationMonthsResult = (new OnePageCheckoutProcessor()).populateExpirationMonths();

    // Assert
    assertEquals(12, actualPopulateExpirationMonthsResult.size());
    assertEquals("01 - January", actualPopulateExpirationMonthsResult.get(0));
    assertEquals("02 - February", actualPopulateExpirationMonthsResult.get(1));
    assertEquals("03 - March", actualPopulateExpirationMonthsResult.get(2));
    assertEquals("04 - April", actualPopulateExpirationMonthsResult.get(3));
    assertEquals("05 - May", actualPopulateExpirationMonthsResult.get(4));
    assertEquals("06 - June", actualPopulateExpirationMonthsResult.get(5));
    assertEquals("07 - July", actualPopulateExpirationMonthsResult.get(6));
    assertEquals("08 - August", actualPopulateExpirationMonthsResult.get(7));
    assertEquals("09 - September", actualPopulateExpirationMonthsResult.get(8));
    assertEquals("10 - October", actualPopulateExpirationMonthsResult.get(9));
    assertEquals("11 - November", actualPopulateExpirationMonthsResult.get(10));
    assertEquals("12 - December", actualPopulateExpirationMonthsResult.get(11));
  }

  /**
   * Test {@link OnePageCheckoutProcessor#populateExpirationYears()}.
   * <p>
   * Method under test: {@link OnePageCheckoutProcessor#populateExpirationYears()}
   */
  @Test
  @DisplayName("Test populateExpirationYears()")
  void testPopulateExpirationYears() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10, (new OnePageCheckoutProcessor()).populateExpirationYears().size());
  }
}
