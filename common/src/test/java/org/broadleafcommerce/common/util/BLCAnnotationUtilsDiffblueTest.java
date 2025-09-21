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

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.annotation.Annotation;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLCAnnotationUtilsDiffblueTest {
  /**
   * Test {@link BLCAnnotationUtils#getAnnotationFromClassOrInterface(Class, Class)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCAnnotationUtils#getAnnotationFromClassOrInterface(Class,
   * Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Annotation BLCAnnotationUtils.getAnnotationFromClassOrInterface(Class, Class)"
  })
  public void testGetAnnotationFromClassOrInterface_thenReturnNull() {
    // Arrange
    Class<Annotation> annotationClass = Annotation.class;
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertNull(BLCAnnotationUtils.getAnnotationFromClassOrInterface(annotationClass, clazz));
  }
}
