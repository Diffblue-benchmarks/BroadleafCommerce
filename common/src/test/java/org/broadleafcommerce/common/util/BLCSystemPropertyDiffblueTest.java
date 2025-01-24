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

public class BLCSystemPropertyDiffblueTest {
  /**
   * Test {@link BLCSystemProperty#resolveSystemProperty(String)} with
   * {@code name}.
   * <p>
   * Method under test: {@link BLCSystemProperty#resolveSystemProperty(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveSystemPropertyWithName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@4e9b4bcb has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveSystemProperty(BLCSystemProperty.java:50)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCSystemProperty.resolveSystemProperty("Name");
  }

  /**
   * Test {@link BLCSystemProperty#resolveSystemProperty(String, String)} with
   * {@code name}, {@code defaultValue}.
   * <p>
   * Method under test:
   * {@link BLCSystemProperty#resolveSystemProperty(String, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveSystemPropertyWithNameDefaultValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@4e9b4bcb has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveSystemProperty(BLCSystemProperty.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCSystemProperty.resolveSystemProperty("Name", "42");
  }

  /**
   * Test {@link BLCSystemProperty#resolveIntSystemProperty(String)} with
   * {@code name}.
   * <p>
   * Method under test: {@link BLCSystemProperty#resolveIntSystemProperty(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveIntSystemPropertyWithName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@4e9b4bcb has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveIntSystemProperty(BLCSystemProperty.java:61)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCSystemProperty.resolveIntSystemProperty("Name");
  }

  /**
   * Test {@link BLCSystemProperty#resolveIntSystemProperty(String, int)} with
   * {@code name}, {@code defaultValue}.
   * <p>
   * Method under test:
   * {@link BLCSystemProperty#resolveIntSystemProperty(String, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveIntSystemPropertyWithNameDefaultValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@4e9b4bcb has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveIntSystemProperty(BLCSystemProperty.java:65)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCSystemProperty.resolveIntSystemProperty("Name", 42);
  }

  /**
   * Test {@link BLCSystemProperty#resolveBooleanSystemProperty(String)} with
   * {@code name}.
   * <p>
   * Method under test:
   * {@link BLCSystemProperty#resolveBooleanSystemProperty(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveBooleanSystemPropertyWithName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@4e9b4bcb has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty(BLCSystemProperty.java:72)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCSystemProperty.resolveBooleanSystemProperty("Name");
  }

  /**
   * Test {@link BLCSystemProperty#resolveBooleanSystemProperty(String, boolean)}
   * with {@code name}, {@code defaultValue}.
   * <p>
   * Method under test:
   * {@link BLCSystemProperty#resolveBooleanSystemProperty(String, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveBooleanSystemPropertyWithNameDefaultValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@4e9b4bcb has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveBooleanSystemProperty(BLCSystemProperty.java:76)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCSystemProperty.resolveBooleanSystemProperty("Name", true);
  }

  /**
   * Test {@link BLCSystemProperty#resolveLongSystemProperty(String)} with
   * {@code name}.
   * <p>
   * Method under test:
   * {@link BLCSystemProperty#resolveLongSystemProperty(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveLongSystemPropertyWithName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@4e9b4bcb has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveLongSystemProperty(BLCSystemProperty.java:83)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCSystemProperty.resolveLongSystemProperty("Name");
  }

  /**
   * Test {@link BLCSystemProperty#resolveLongSystemProperty(String, long)} with
   * {@code name}, {@code defaultValue}.
   * <p>
   * Method under test:
   * {@link BLCSystemProperty#resolveLongSystemProperty(String, long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveLongSystemPropertyWithNameDefaultValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@4e9b4bcb has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.resolveLongSystemProperty(BLCSystemProperty.java:87)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCSystemProperty.resolveLongSystemProperty("Name", 42L);
  }

  /**
   * Test {@link BLCSystemProperty#getSystemPropertiesService()}.
   * <p>
   * Method under test: {@link BLCSystemProperty#getSystemPropertiesService()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSystemPropertiesService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@4e9b4bcb has not been refreshed yet
    //       at org.broadleafcommerce.common.util.BLCSystemProperty.getSystemPropertiesService(BLCSystemProperty.java:94)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    BLCSystemProperty.getSystemPropertiesService();
  }

  /**
   * Test {@link BLCSystemProperty#setApplicationContext(ApplicationContext)}.
   * <p>
   * Method under test:
   * {@link BLCSystemProperty#setApplicationContext(ApplicationContext)}
   */
  @Test
  public void testSetApplicationContext() throws BeansException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     BLCSystemProperty.applicationContext

    // Arrange
    BLCSystemProperty blcSystemProperty = new BLCSystemProperty();

    // Act
    blcSystemProperty.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
  }
}
