/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PricingServiceActivityDiffblueTest {
  /**
   * Test new {@link PricingServiceActivity} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PricingServiceActivity}
   */
  @Test
  public void testNewPricingServiceActivity() {
    // Arrange and Act
    PricingServiceActivity actualPricingServiceActivity = new PricingServiceActivity();

    // Assert
    assertNull(actualPricingServiceActivity.getBeanName());
    assertNull(actualPricingServiceActivity.getRollbackRegion());
    assertNull(actualPricingServiceActivity.getStateConfiguration());
    assertNull(actualPricingServiceActivity.getErrorHandler());
    assertNull(actualPricingServiceActivity.getRollbackHandler());
    assertFalse(actualPricingServiceActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualPricingServiceActivity.getOrder());
  }
}
