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

import java.lang.annotation.Annotation;
import org.junit.Ignore;
import org.junit.Test;

public class BLCAnnotationUtilsDiffblueTest {
  /**
   * Test
   * {@link BLCAnnotationUtils#getAnnotationFromClassOrInterface(Class, Class)}.
   * <p>
   * Method under test:
   * {@link BLCAnnotationUtils#getAnnotationFromClassOrInterface(Class, Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAnnotationFromClassOrInterface() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Class<Annotation> annotationClass = Annotation.class;
    Class<Object> clazz = Object.class;

    // Act
    BLCAnnotationUtils.getAnnotationFromClassOrInterface(annotationClass, clazz).annotationType();
  }
}
