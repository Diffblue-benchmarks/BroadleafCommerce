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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class ModuleLifecycleLoggingBeanDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModuleLifecycleLoggingBean#ModuleLifecycleLoggingBean()}
   *   <li>{@link ModuleLifecycleLoggingBean#setLifeCycleEvent(LifeCycleEvent)}
   *   <li>{@link ModuleLifecycleLoggingBean#setModuleName(String)}
   *   <li>{@link ModuleLifecycleLoggingBean#getLifeCycleEvent()}
   *   <li>{@link ModuleLifecycleLoggingBean#getModuleName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ModuleLifecycleLoggingBean actualModuleLifecycleLoggingBean = new ModuleLifecycleLoggingBean();
    actualModuleLifecycleLoggingBean.setLifeCycleEvent(LifeCycleEvent.START);
    actualModuleLifecycleLoggingBean.setModuleName("Module Name");
    LifeCycleEvent actualLifeCycleEvent = actualModuleLifecycleLoggingBean.getLifeCycleEvent();

    // Assert that nothing has changed
    assertEquals("Module Name", actualModuleLifecycleLoggingBean.getModuleName());
    assertEquals(LifeCycleEvent.START, actualLifeCycleEvent);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Module Name}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ModuleLifecycleLoggingBean#ModuleLifecycleLoggingBean(String, LifeCycleEvent)}
   *   <li>{@link ModuleLifecycleLoggingBean#setLifeCycleEvent(LifeCycleEvent)}
   *   <li>{@link ModuleLifecycleLoggingBean#setModuleName(String)}
   *   <li>{@link ModuleLifecycleLoggingBean#getLifeCycleEvent()}
   *   <li>{@link ModuleLifecycleLoggingBean#getModuleName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenModuleName() {
    // Arrange and Act
    ModuleLifecycleLoggingBean actualModuleLifecycleLoggingBean = new ModuleLifecycleLoggingBean("Module Name",
        LifeCycleEvent.START);
    actualModuleLifecycleLoggingBean.setLifeCycleEvent(LifeCycleEvent.START);
    actualModuleLifecycleLoggingBean.setModuleName("Module Name");
    LifeCycleEvent actualLifeCycleEvent = actualModuleLifecycleLoggingBean.getLifeCycleEvent();

    // Assert that nothing has changed
    assertEquals("Module Name", actualModuleLifecycleLoggingBean.getModuleName());
    assertEquals(LifeCycleEvent.START, actualLifeCycleEvent);
  }

  /**
   * Test {@link ModuleLifecycleLoggingBean#init()}.
   * <p>
   * Method under test: {@link ModuleLifecycleLoggingBean#init()}
   */
  @Test
  public void testInit() {
    // Arrange
    ModuleLifecycleLoggingBean moduleLifecycleLoggingBean = new ModuleLifecycleLoggingBean("Module Name",
        LifeCycleEvent.START);
    moduleLifecycleLoggingBean.setModuleName(null);
    moduleLifecycleLoggingBean.setLifeCycleEvent(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> moduleLifecycleLoggingBean.init());
  }

  /**
   * Test {@link ModuleLifecycleLoggingBean#init()}.
   * <p>
   * Method under test: {@link ModuleLifecycleLoggingBean#init()}
   */
  @Test
  public void testInit2() {
    // Arrange
    ModuleLifecycleLoggingBean moduleLifecycleLoggingBean = new ModuleLifecycleLoggingBean("Module Name",
        LifeCycleEvent.START);
    moduleLifecycleLoggingBean.setModuleName("foo");
    moduleLifecycleLoggingBean.setLifeCycleEvent(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> moduleLifecycleLoggingBean.init());
  }
}
