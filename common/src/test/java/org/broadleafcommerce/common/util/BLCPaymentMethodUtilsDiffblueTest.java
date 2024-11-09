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
import java.util.List;
import org.junit.Test;

public class BLCPaymentMethodUtilsDiffblueTest {
  /**
   * Test {@link BLCPaymentMethodUtils#getExpirationMonthOptions()}.
   * <p>
   * Method under test: {@link BLCPaymentMethodUtils#getExpirationMonthOptions()}
   */
  @Test
  public void testGetExpirationMonthOptions() {
    // Arrange and Act
    List<String> actualExpirationMonthOptions = BLCPaymentMethodUtils.getExpirationMonthOptions();

    // Assert
    assertEquals(12, actualExpirationMonthOptions.size());
    assertEquals("01 - January", actualExpirationMonthOptions.get(0));
    assertEquals("02 - February", actualExpirationMonthOptions.get(1));
    assertEquals("03 - March", actualExpirationMonthOptions.get(2));
    assertEquals("04 - April", actualExpirationMonthOptions.get(3));
    assertEquals("05 - May", actualExpirationMonthOptions.get(4));
    assertEquals("06 - June", actualExpirationMonthOptions.get(5));
    assertEquals("07 - July", actualExpirationMonthOptions.get(6));
    assertEquals("08 - August", actualExpirationMonthOptions.get(7));
    assertEquals("09 - September", actualExpirationMonthOptions.get(8));
    assertEquals("10 - October", actualExpirationMonthOptions.get(9));
    assertEquals("11 - November", actualExpirationMonthOptions.get(10));
    assertEquals("12 - December", actualExpirationMonthOptions.get(11));
  }

  /**
   * Test {@link BLCPaymentMethodUtils#getExpirationYearOptions()}.
   * <p>
   * Method under test: {@link BLCPaymentMethodUtils#getExpirationYearOptions()}
   */
  @Test
  public void testGetExpirationYearOptions() {
    // Arrange and Act
    List<String> actualExpirationYearOptions = BLCPaymentMethodUtils.getExpirationYearOptions();

    // Assert
    assertEquals(10, actualExpirationYearOptions.size());
  }
}
