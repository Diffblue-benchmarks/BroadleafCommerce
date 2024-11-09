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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NullFactoryBeanDiffblueTest {
  /**
   * Test {@link NullFactoryBean#getObject()}.
   * <p>
   * Method under test: {@link NullFactoryBean#getObject()}
   */
  @Test
  public void testGetObject() throws Exception {
    // Arrange, Act and Assert
    assertNull((new NullFactoryBean()).getObject());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NullFactoryBean}
   *   <li>{@link NullFactoryBean#getObjectType()}
   *   <li>{@link NullFactoryBean#isSingleton()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NullFactoryBean actualNullFactoryBean = new NullFactoryBean();
    Class<? extends Void> actualObjectType = actualNullFactoryBean.getObjectType();

    // Assert
    assertNull(actualObjectType);
    assertTrue(actualNullFactoryBean.isSingleton());
  }
}
