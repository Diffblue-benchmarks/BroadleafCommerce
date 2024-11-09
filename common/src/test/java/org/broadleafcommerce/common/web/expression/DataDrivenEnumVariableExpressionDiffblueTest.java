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
package org.broadleafcommerce.common.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class DataDrivenEnumVariableExpressionDiffblueTest {
  /**
   * Test {@link DataDrivenEnumVariableExpression#getName()}.
   * <p>
   * Method under test: {@link DataDrivenEnumVariableExpression#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("enumeration", (new DataDrivenEnumVariableExpression()).getName());
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   * with {@code key}, {@code sort}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   */
  @Test
  public void testGetEnumValuesWithKeySort_whenEmptyString_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new DataDrivenEnumVariableExpression()).getEnumValues("", null));
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   * with {@code key}, {@code sort}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDrivenEnumVariableExpression#getEnumValues(String, String)}
   */
  @Test
  public void testGetEnumValuesWithKeySort_whenNull_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new DataDrivenEnumVariableExpression()).getEnumValues(null, null));
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String)} with
   * {@code key}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDrivenEnumVariableExpression#getEnumValues(String)}
   */
  @Test
  public void testGetEnumValuesWithKey_whenEmptyString_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new DataDrivenEnumVariableExpression()).getEnumValues(""));
  }

  /**
   * Test {@link DataDrivenEnumVariableExpression#getEnumValues(String)} with
   * {@code key}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DataDrivenEnumVariableExpression#getEnumValues(String)}
   */
  @Test
  public void testGetEnumValuesWithKey_whenNull_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new DataDrivenEnumVariableExpression()).getEnumValues(null));
  }
}
