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
package org.broadleafcommerce.common.extensibility.config;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PropertyConfigurerDiffblueTest {
  /**
   * Test new {@link PropertyConfigurer} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PropertyConfigurer}
   */
  @Test
  public void testNewPropertyConfigurer() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new PropertyConfigurer()).getOrder());
  }
}
