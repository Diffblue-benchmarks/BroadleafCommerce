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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class BLCCronUtilsDiffblueTest {
  /**
   * Method under test: {@link BLCCronUtils#getNextValidTime(String)}
   */
  @Test
  public void testGetNextValidTime() {
    // Arrange, Act and Assert
    assertNull(BLCCronUtils.getNextValidTime("Cron"));
    assertNull(BLCCronUtils.getNextValidTime("L-9"));
    assertNull(BLCCronUtils.getNextValidTime("42"));
    assertNull(BLCCronUtils.getNextValidTime(""));
    assertNull(BLCCronUtils.getNextValidTime("L-942"));
    assertNull(BLCCronUtils.getNextValidTime("42L-9"));
    assertNull(BLCCronUtils.getNextValidTime("42Unable to parse the given cron expression: "));
    assertNull(BLCCronUtils.getNextValidTime("4242"));
    assertNull(BLCCronUtils.getNextValidTime("L-94242"));
    assertNull(BLCCronUtils.getNextValidTime("4242Unable to parse the given cron expression: "));
  }

  /**
   * Method under test: {@link BLCCronUtils#isValidExpression(String)}
   */
  @Test
  public void testIsValidExpression() {
    // Arrange, Act and Assert
    assertFalse(BLCCronUtils.isValidExpression("Cron"));
    assertFalse(BLCCronUtils.isValidExpression("L-9"));
    assertFalse(BLCCronUtils.isValidExpression("42"));
    assertFalse(BLCCronUtils.isValidExpression(""));
    assertFalse(BLCCronUtils.isValidExpression("L-942"));
    assertFalse(BLCCronUtils.isValidExpression("42L-9"));
    assertFalse(BLCCronUtils.isValidExpression("42Cron"));
    assertFalse(BLCCronUtils.isValidExpression("4242"));
    assertFalse(BLCCronUtils.isValidExpression("L-94242"));
    assertFalse(BLCCronUtils.isValidExpression("4242Cron"));
  }
}
