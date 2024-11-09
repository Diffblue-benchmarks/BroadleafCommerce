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
package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ThirtyMinuteExpiryPolicyDiffblueTest {
  /**
   * Test new {@link ThirtyMinuteExpiryPolicy} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ThirtyMinuteExpiryPolicy}
   */
  @Test
  public void testNewThirtyMinuteExpiryPolicy() {
    // Arrange, Act and Assert
    assertEquals(1800000000000L, (new ThirtyMinuteExpiryPolicy()).getDefaultDuration().toNanos());
  }
}
