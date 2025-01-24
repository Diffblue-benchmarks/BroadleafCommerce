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
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class BLCMessageUtilsDiffblueTest {
  /**
   * Test {@link BLCMessageUtils#getMessage(String)} with {@code code}.
   * <p>
   * Method under test: {@link BLCMessageUtils#getMessage(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMessageWithCode() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@671ca6b2 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCMessageUtils.getMessageSource(BLCMessageUtils.java:67)
    //       at org.broadleafcommerce.common.util.BLCMessageUtils.getMessage(BLCMessageUtils.java:60)
    //       at org.broadleafcommerce.common.util.BLCMessageUtils.getMessage(BLCMessageUtils.java:48)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCMessageUtils.getMessage("Code");
  }

  /**
   * Test {@link BLCMessageUtils#getMessage(String, Object[])} with {@code code},
   * {@code args}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCMessageUtils#getMessage(String, Object[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMessageWithCodeArgs_whenNull_field() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@671ca6b2 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCMessageUtils.getMessageSource(BLCMessageUtils.java:67)
    //       at org.broadleafcommerce.common.util.BLCMessageUtils.getMessage(BLCMessageUtils.java:60)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCMessageUtils.getMessage("Code", BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link BLCMessageUtils#getMessageSource()}.
   * <p>
   * Method under test: {@link BLCMessageUtils#getMessageSource()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetMessageSource() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@671ca6b2 has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCMessageUtils.getMessageSource(BLCMessageUtils.java:67)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCMessageUtils.getMessageSource();
  }

  /**
   * Test {@link BLCMessageUtils#setApplicationContext(ApplicationContext)}.
   * <p>
   * Method under test:
   * {@link BLCMessageUtils#setApplicationContext(ApplicationContext)}
   */
  @Test
  public void testSetApplicationContext() throws BeansException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     BLCMessageUtils.applicationContext

    // Arrange
    BLCMessageUtils blcMessageUtils = new BLCMessageUtils();

    // Act
    blcMessageUtils.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
  }
}
