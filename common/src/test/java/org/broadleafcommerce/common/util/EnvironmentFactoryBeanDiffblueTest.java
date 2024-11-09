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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class EnvironmentFactoryBeanDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EnvironmentFactoryBean#EnvironmentFactoryBean(String)}
   *   <li>{@link EnvironmentFactoryBean#isSingleton()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new EnvironmentFactoryBean("Class Name")).isSingleton());
  }

  /**
   * Test {@link EnvironmentFactoryBean#getObjectType()}.
   * <p>
   * Method under test: {@link EnvironmentFactoryBean#getObjectType()}
   */
  @Test
  public void testGetObjectType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new EnvironmentFactoryBean("Class Name")).getObjectType());
  }
}
