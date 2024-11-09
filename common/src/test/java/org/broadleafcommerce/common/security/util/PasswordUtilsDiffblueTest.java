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
package org.broadleafcommerce.common.security.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PasswordUtilsDiffblueTest {
  /**
   * Test {@link PasswordUtils#generateSecurePassword(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PasswordUtils#generateSecurePassword(int)}
   */
  @Test
  public void testGenerateSecurePassword_whenZero_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", PasswordUtils.generateSecurePassword(0));
  }
}