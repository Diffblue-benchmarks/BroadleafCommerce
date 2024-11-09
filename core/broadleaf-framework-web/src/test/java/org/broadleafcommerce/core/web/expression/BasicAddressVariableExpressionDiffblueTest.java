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
package org.broadleafcommerce.core.web.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.common.i18n.domain.ISOCountry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicAddressVariableExpressionDiffblueTest {
  /**
   * Test {@link BasicAddressVariableExpression#getName()}.
   * <p>
   * Method under test: {@link BasicAddressVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("address", (new BasicAddressVariableExpression()).getName());
  }

  /**
   * Test
   * {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasicAddressVariableExpression#getCountrySubOptionsByISOCountry(ISOCountry)}
   */
  @Test
  @DisplayName("Test getCountrySubOptionsByISOCountry(ISOCountry); when 'null'; then return Empty")
  void testGetCountrySubOptionsByISOCountry_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BasicAddressVariableExpression()).getCountrySubOptionsByISOCountry(null).isEmpty());
  }
}
