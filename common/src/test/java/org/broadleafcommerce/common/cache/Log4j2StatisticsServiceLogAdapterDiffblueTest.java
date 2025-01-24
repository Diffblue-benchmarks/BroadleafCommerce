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
package org.broadleafcommerce.common.cache;

import org.junit.Ignore;
import org.junit.Test;

public class Log4j2StatisticsServiceLogAdapterDiffblueTest {
  /**
   * Test {@link Log4j2StatisticsServiceLogAdapter#activateLogging(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Log4j2StatisticsServiceLogAdapter#activateLogging(Class)}
   */
  @Test
  public void testActivateLogging_whenJavaLangObject() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Log4j2StatisticsServiceLogAdapter log4j2StatisticsServiceLogAdapter = new Log4j2StatisticsServiceLogAdapter();
    Class<Object> clazz = Object.class;

    // Act
    log4j2StatisticsServiceLogAdapter.activateLogging(clazz);
  }

  /**
   * Test {@link Log4j2StatisticsServiceLogAdapter#activateLogging(Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Log4j2StatisticsServiceLogAdapter#activateLogging(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testActivateLogging_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.cache.Log4j2StatisticsServiceLogAdapter.activateLogging(Log4j2StatisticsServiceLogAdapter.java:32)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new Log4j2StatisticsServiceLogAdapter()).activateLogging(null);
  }

  /**
   * Test {@link Log4j2StatisticsServiceLogAdapter#disableLogging(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Log4j2StatisticsServiceLogAdapter#disableLogging(Class)}
   */
  @Test
  public void testDisableLogging_whenJavaLangObject() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Log4j2StatisticsServiceLogAdapter log4j2StatisticsServiceLogAdapter = new Log4j2StatisticsServiceLogAdapter();
    Class<Object> clazz = Object.class;

    // Act
    log4j2StatisticsServiceLogAdapter.disableLogging(clazz);
  }

  /**
   * Test new {@link Log4j2StatisticsServiceLogAdapter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link Log4j2StatisticsServiceLogAdapter}
   */
  @Test
  public void testNewLog4j2StatisticsServiceLogAdapter() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new Log4j2StatisticsServiceLogAdapter();
  }
}
