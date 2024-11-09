/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ParameterDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Parameter}
   *   <li>{@link Parameter#setParameterClass(Class)}
   *   <li>{@link Parameter#setParameterInstance(Object)}
   *   <li>{@link Parameter#getParameterClass()}
   *   <li>{@link Parameter#getParameterInstance()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Parameter actualParameter = new Parameter();
    Class<Object> parameterClass = Object.class;
    actualParameter.setParameterClass(parameterClass);
    actualParameter.setParameterInstance("Parameter Instance");
    Class actualParameterClass = actualParameter.getParameterClass();

    // Assert that nothing has changed
    assertEquals("Parameter Instance", actualParameter.getParameterInstance());
    Class<Object> expectedParameterClass = Object.class;
    assertEquals(expectedParameterClass, actualParameterClass);
    assertSame(parameterClass, actualParameterClass);
  }
}