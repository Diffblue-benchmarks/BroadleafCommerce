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
package org.broadleafcommerce.common.web.resource.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.function.BiFunction;
import org.junit.Test;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionStrategy;

public class BLVersionResourceResolverDefaultStrategyMapDiffblueTest {
  /**
   * Test {@link BLVersionResourceResolverDefaultStrategyMap#initIt()}.
   * <p>
   * Method under test:
   * {@link BLVersionResourceResolverDefaultStrategyMap#initIt()}
   */
  @Test
  public void testInitIt() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLVersionResourceResolverDefaultStrategyMap<Object, Object> objectObjectMap = new BLVersionResourceResolverDefaultStrategyMap<>();
    objectObjectMap.computeIfPresent("/**", mock(BiFunction.class));

    // Act
    objectObjectMap.initIt();

    // Assert
    assertEquals(1, objectObjectMap.size());
    assertTrue(objectObjectMap.get("/**") instanceof ContentVersionStrategy);
  }

  /**
   * Test {@link BLVersionResourceResolverDefaultStrategyMap#initIt()}.
   * <ul>
   *   <li>Given {@link BLVersionResourceResolverDefaultStrategyMap} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLVersionResourceResolverDefaultStrategyMap#initIt()}
   */
  @Test
  public void testInitIt_givenBLVersionResourceResolverDefaultStrategyMap() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BLVersionResourceResolverDefaultStrategyMap<Object, Object> objectObjectMap = new BLVersionResourceResolverDefaultStrategyMap<>();

    // Act
    objectObjectMap.initIt();

    // Assert
    assertEquals(1, objectObjectMap.size());
    assertTrue(objectObjectMap.get("/**") instanceof ContentVersionStrategy);
  }
}
