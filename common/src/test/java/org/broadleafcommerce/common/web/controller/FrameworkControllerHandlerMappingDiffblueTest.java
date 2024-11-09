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
package org.broadleafcommerce.common.web.controller;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.springframework.util.StringValueResolver;

public class FrameworkControllerHandlerMappingDiffblueTest {
  /**
   * Test {@link FrameworkControllerHandlerMapping#isHandler(Class)}.
   * <p>
   * Method under test: {@link FrameworkControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  public void testIsHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FrameworkControllerHandlerMapping frameworkControllerHandlerMapping = new FrameworkControllerHandlerMapping();
    frameworkControllerHandlerMapping.setEmbeddedValueResolver(mock(StringValueResolver.class));
    Class<Object> beanType = Object.class;

    // Act and Assert
    assertFalse(frameworkControllerHandlerMapping.isHandler(beanType));
  }

  /**
   * Test {@link FrameworkControllerHandlerMapping#isHandler(Class)}.
   * <ul>
   *   <li>Given {@link FrameworkControllerHandlerMapping} (default
   * constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FrameworkControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  public void testIsHandler_givenFrameworkControllerHandlerMapping_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FrameworkControllerHandlerMapping frameworkControllerHandlerMapping = new FrameworkControllerHandlerMapping();
    Class<Object> beanType = Object.class;

    // Act and Assert
    assertFalse(frameworkControllerHandlerMapping.isHandler(beanType));
  }
}
