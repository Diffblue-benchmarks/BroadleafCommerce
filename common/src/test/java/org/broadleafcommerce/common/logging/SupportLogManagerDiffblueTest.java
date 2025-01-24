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

import org.junit.Ignore;
import org.junit.Test;

public class SupportLogManagerDiffblueTest {
  /**
   * Test {@link SupportLogManager#getLogger(String, Class)} with
   * {@code moduleName}, {@code clazz}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SupportLogManager#getLogger(String, Class)}
   */
  @Test
  public void testGetLoggerWithModuleNameClazz_whenJavaLangObject() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    SupportLogManager.getLogger("Module Name", clazz);
  }

  /**
   * Test {@link SupportLogManager#getLogger(String, Class)} with
   * {@code moduleName}, {@code clazz}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SupportLogManager#getLogger(String, Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLoggerWithModuleNameClazz_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.logging.SupportLogManager.getLogger(SupportLogManager.java:50)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    SupportLogManager.getLogger("Module Name", (Class<?>) null);
  }

  /**
   * Test {@link SupportLogManager#getLogger(String, String)} with
   * {@code moduleName}, {@code name}.
   * <p>
   * Method under test: {@link SupportLogManager#getLogger(String, String)}
   */
  @Test
  public void testGetLoggerWithModuleNameName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SupportLogManager.getLogger("Module Name", "Name");
  }
}
