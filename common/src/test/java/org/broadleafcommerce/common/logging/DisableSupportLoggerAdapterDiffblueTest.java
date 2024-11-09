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
package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DisableSupportLoggerAdapterDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DisableSupportLoggerAdapter}
   *   <li>{@link DisableSupportLoggerAdapter#debug(String)}
   *   <li>{@link DisableSupportLoggerAdapter#debug(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#error(String)}
   *   <li>{@link DisableSupportLoggerAdapter#error(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#fatal(String)}
   *   <li>{@link DisableSupportLoggerAdapter#fatal(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#info(String)}
   *   <li>{@link DisableSupportLoggerAdapter#info(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#lifecycle(LifeCycleEvent, String)}
   *   <li>{@link DisableSupportLoggerAdapter#setName(String)}
   *   <li>{@link DisableSupportLoggerAdapter#support(String)}
   *   <li>{@link DisableSupportLoggerAdapter#support(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#warn(String)}
   *   <li>{@link DisableSupportLoggerAdapter#warn(String, Throwable)}
   *   <li>{@link DisableSupportLoggerAdapter#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DisableSupportLoggerAdapter actualDisableSupportLoggerAdapter = new DisableSupportLoggerAdapter();
    actualDisableSupportLoggerAdapter.debug("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.debug("Not all who wander are lost", new Throwable());
    actualDisableSupportLoggerAdapter.error("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.error("Not all who wander are lost", new Throwable());
    actualDisableSupportLoggerAdapter.fatal("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.fatal("Not all who wander are lost", new Throwable());
    actualDisableSupportLoggerAdapter.info("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.info("Not all who wander are lost", new Throwable());
    actualDisableSupportLoggerAdapter.lifecycle(LifeCycleEvent.START, "Not all who wander are lost");
    actualDisableSupportLoggerAdapter.setName("Name");
    actualDisableSupportLoggerAdapter.support("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.support("Not all who wander are lost", new Throwable());
    actualDisableSupportLoggerAdapter.warn("Not all who wander are lost");
    actualDisableSupportLoggerAdapter.warn("Not all who wander are lost", new Throwable());

    // Assert that nothing has changed
    assertNull(actualDisableSupportLoggerAdapter.getName());
  }
}
