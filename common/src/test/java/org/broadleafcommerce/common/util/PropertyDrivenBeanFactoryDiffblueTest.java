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
package org.broadleafcommerce.common.util;

import org.junit.Ignore;
import org.junit.Test;

public class PropertyDrivenBeanFactoryDiffblueTest {
  /**
   * Test {@link PropertyDrivenBeanFactory#createInstance(String)} with
   * {@code className}.
   * <p>
   * Method under test: {@link PropertyDrivenBeanFactory#createInstance(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateInstanceWithClassName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: java.lang.ClassNotFoundException: Class Name
    //       at org.broadleafcommerce.common.exception.ExceptionHelper.wrapException(ExceptionHelper.java:96)
    //       at org.broadleafcommerce.common.exception.ExceptionHelper.refineException(ExceptionHelper.java:47)
    //       at org.broadleafcommerce.common.exception.ExceptionHelper.refineException(ExceptionHelper.java:59)
    //       at org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.createInstance(PropertyDrivenBeanFactory.java:44)
    //       at org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.createInstance(PropertyDrivenBeanFactory.java:31)
    //   java.lang.ClassNotFoundException: Class Name
    //       at java.base/java.lang.Class.forName0(Native Method)
    //       at java.base/java.lang.Class.forName(Class.java:315)
    //       at org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.createInstance(PropertyDrivenBeanFactory.java:40)
    //       at org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.createInstance(PropertyDrivenBeanFactory.java:31)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PropertyDrivenBeanFactory.createInstance("Class Name");
  }

  /**
   * Test {@link PropertyDrivenBeanFactory#createInstance(String, String[])} with
   * {@code className}, {@code constructorArgs}.
   * <ul>
   *   <li>When {@code Constructor Args}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PropertyDrivenBeanFactory#createInstance(String, String[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateInstanceWithClassNameConstructorArgs_whenConstructorArgs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: java.lang.ClassNotFoundException: Class Name
    //       at org.broadleafcommerce.common.exception.ExceptionHelper.wrapException(ExceptionHelper.java:96)
    //       at org.broadleafcommerce.common.exception.ExceptionHelper.refineException(ExceptionHelper.java:47)
    //       at org.broadleafcommerce.common.exception.ExceptionHelper.refineException(ExceptionHelper.java:59)
    //       at org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.createInstance(PropertyDrivenBeanFactory.java:44)
    //   java.lang.ClassNotFoundException: Class Name
    //       at java.base/java.lang.Class.forName0(Native Method)
    //       at java.base/java.lang.Class.forName(Class.java:315)
    //       at org.broadleafcommerce.common.util.PropertyDrivenBeanFactory.createInstance(PropertyDrivenBeanFactory.java:38)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    PropertyDrivenBeanFactory.createInstance("Class Name", "Constructor Args");
  }
}
