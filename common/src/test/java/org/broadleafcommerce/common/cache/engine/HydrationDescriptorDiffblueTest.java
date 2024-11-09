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
package org.broadleafcommerce.common.cache.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class HydrationDescriptorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link HydrationDescriptor}
   *   <li>{@link HydrationDescriptor#setCacheRegion(String)}
   *   <li>{@link HydrationDescriptor#setHydratedMutators(Map)}
   *   <li>{@link HydrationDescriptor#setIdMutators(Method[])}
   *   <li>{@link HydrationDescriptor#getCacheRegion()}
   *   <li>{@link HydrationDescriptor#getHydratedMutators()}
   *   <li>{@link HydrationDescriptor#getIdMutators()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    HydrationDescriptor actualHydrationDescriptor = new HydrationDescriptor();
    actualHydrationDescriptor.setCacheRegion("us-east-2");
    HashMap<String, HydrationItemDescriptor> hydratedMutators = new HashMap<>();
    actualHydrationDescriptor.setHydratedMutators(hydratedMutators);
    Method[] idMutators = new Method[]{null};
    actualHydrationDescriptor.setIdMutators(idMutators);
    String actualCacheRegion = actualHydrationDescriptor.getCacheRegion();
    Map<String, HydrationItemDescriptor> actualHydratedMutators = actualHydrationDescriptor.getHydratedMutators();
    Method[] actualIdMutators = actualHydrationDescriptor.getIdMutators();

    // Assert that nothing has changed
    assertEquals("us-east-2", actualCacheRegion);
    assertEquals(1, actualIdMutators.length);
    assertTrue(actualHydratedMutators.isEmpty());
    assertSame(hydratedMutators, actualHydratedMutators);
    assertSame(idMutators, actualIdMutators);
  }
}
