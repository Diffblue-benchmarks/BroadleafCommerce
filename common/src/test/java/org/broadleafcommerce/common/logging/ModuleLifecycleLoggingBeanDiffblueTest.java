/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ModuleLifecycleLoggingBean.<init>()",
      "void ModuleLifecycleLoggingBean.<init>(String, LifeCycleEvent)",
      "LifeCycleEvent ModuleLifecycleLoggingBean.getLifeCycleEvent()",
      "String ModuleLifecycleLoggingBean.getModuleName()",
      "void ModuleLifecycleLoggingBean.setLifeCycleEvent(LifeCycleEvent)",
      "void ModuleLifecycleLoggingBean.setModuleName(String)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ModuleLifecycleLoggingBean actualModuleLifecycleLoggingBean = new ModuleLifecycleLoggingBean();
    actualModuleLifecycleLoggingBean.setLifeCycleEvent(LifeCycleEvent.START);
    actualModuleLifecycleLoggingBean.setModuleName("Module Name");
    LifeCycleEvent actualLifeCycleEvent = actualModuleLifecycleLoggingBean.getLifeCycleEvent();

    // Assert
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
   *   <li>{@link ModuleLifecycleLoggingBean#ModuleLifecycleLoggingBean(String, LifeCycleEvent)}
   *   <li>{@link ModuleLifecycleLoggingBean#setLifeCycleEvent(LifeCycleEvent)}
   *   <li>{@link ModuleLifecycleLoggingBean#setModuleName(String)}
   *   <li>{@link ModuleLifecycleLoggingBean#getLifeCycleEvent()}
   *   <li>{@link ModuleLifecycleLoggingBean#getModuleName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ModuleLifecycleLoggingBean.<init>()",
      "void ModuleLifecycleLoggingBean.<init>(String, LifeCycleEvent)",
      "LifeCycleEvent ModuleLifecycleLoggingBean.getLifeCycleEvent()",
      "String ModuleLifecycleLoggingBean.getModuleName()",
      "void ModuleLifecycleLoggingBean.setLifeCycleEvent(LifeCycleEvent)",
      "void ModuleLifecycleLoggingBean.setModuleName(String)"})
  public void testGettersAndSetters_whenModuleName() {
    // Arrange and Act
    ModuleLifecycleLoggingBean actualModuleLifecycleLoggingBean = new ModuleLifecycleLoggingBean("Module Name",
        LifeCycleEvent.START);
    actualModuleLifecycleLoggingBean.setLifeCycleEvent(LifeCycleEvent.START);
    actualModuleLifecycleLoggingBean.setModuleName("Module Name");
    LifeCycleEvent actualLifeCycleEvent = actualModuleLifecycleLoggingBean.getLifeCycleEvent();

    // Assert
    assertEquals("Module Name", actualModuleLifecycleLoggingBean.getModuleName());
    assertEquals(LifeCycleEvent.START, actualLifeCycleEvent);
  }

  /**
   * Test {@link ModuleLifecycleLoggingBean#init()}.
   * <p>
   * Method under test: {@link ModuleLifecycleLoggingBean#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ModuleLifecycleLoggingBean.init()"})
  public void testInit() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ModuleLifecycleLoggingBean(null, null)).init());
  }

  /**
   * Test {@link ModuleLifecycleLoggingBean#init()}.
   * <ul>
   *   <li>Given {@link ModuleLifecycleLoggingBean#ModuleLifecycleLoggingBean(String, LifeCycleEvent)} with {@code Module Name} and lifeCycleEvent is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModuleLifecycleLoggingBean#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ModuleLifecycleLoggingBean.init()"})
  public void testInit_givenModuleLifecycleLoggingBeanWithModuleNameAndLifeCycleEventIsNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ModuleLifecycleLoggingBean("Module Name", null)).init());
  }
}
