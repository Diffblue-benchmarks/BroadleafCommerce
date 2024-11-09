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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class Mod43CheckDigitUtilDiffblueTest {
  /**
   * Test {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}
   */
  @Test
  public void testIsValidCheckedValue_when42() {
    // Arrange, Act and Assert
    assertFalse(Mod43CheckDigitUtil.isValidCheckedValue("42"));
  }

  /**
   * Test {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}
   */
  @Test
  public void testIsValidCheckedValue_whenEmptyString() {
    // Arrange, Act and Assert
    assertFalse(Mod43CheckDigitUtil.isValidCheckedValue(""));
  }

  /**
   * Test {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mod43CheckDigitUtil#isValidCheckedValue(String)}
   */
  @Test
  public void testIsValidCheckedValue_whenNull() {
    // Arrange, Act and Assert
    assertFalse(Mod43CheckDigitUtil.isValidCheckedValue(null));
  }

  /**
   * Test {@link Mod43CheckDigitUtil#generateCheckDigit(String)}.
   * <p>
   * Method under test: {@link Mod43CheckDigitUtil#generateCheckDigit(String)}
   */
  @Test
  public void testGenerateCheckDigit() {
    // Arrange, Act and Assert
    assertEquals('A', Mod43CheckDigitUtil.generateCheckDigit("Data"));
  }
}
