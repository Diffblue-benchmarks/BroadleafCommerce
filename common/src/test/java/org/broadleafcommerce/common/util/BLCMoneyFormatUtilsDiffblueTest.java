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

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;

public class BLCMoneyFormatUtilsDiffblueTest {
  /**
   * Method under test: {@link BLCMoneyFormatUtils#formatPrice(Money)}
   */
  @Test
  public void testFormatPrice() {
    // Arrange, Act and Assert
    assertEquals("$0.00", BLCMoneyFormatUtils.formatPrice(Money.ZERO));
    assertEquals("$0.00", BLCMoneyFormatUtils.formatPrice(new Money()));
    assertEquals("Not Available", BLCMoneyFormatUtils.formatPrice(null));
    assertEquals("$0.00", BLCMoneyFormatUtils.formatPrice(Money.ZERO, new HashMap<>()));
  }
}
