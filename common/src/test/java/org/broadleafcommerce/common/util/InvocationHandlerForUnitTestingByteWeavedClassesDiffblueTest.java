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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.lang.reflect.Method;
import org.junit.Test;

public class InvocationHandlerForUnitTestingByteWeavedClassesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link InvocationHandlerForUnitTestingByteWeavedClasses#InvocationHandlerForUnitTestingByteWeavedClasses(Object[])}
   *   <li>
   * {@link InvocationHandlerForUnitTestingByteWeavedClasses#setObjectsForByteWeaving(Object[])}
   *   <li>
   * {@link InvocationHandlerForUnitTestingByteWeavedClasses#getObjectsForByteWeaving()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    InvocationHandlerForUnitTestingByteWeavedClasses actualInvocationHandlerForUnitTestingByteWeavedClasses = new InvocationHandlerForUnitTestingByteWeavedClasses(
        new Object[]{BLCFieldUtils.NULL_FIELD});
    Object[] objects = new Object[]{BLCFieldUtils.NULL_FIELD};
    actualInvocationHandlerForUnitTestingByteWeavedClasses.setObjectsForByteWeaving(objects);
    Object[] actualObjectsForByteWeaving = actualInvocationHandlerForUnitTestingByteWeavedClasses
        .getObjectsForByteWeaving();

    // Assert that nothing has changed
    assertEquals(1, actualObjectsForByteWeaving.length);
    assertSame(objects, actualObjectsForByteWeaving);
  }

  /**
   * Test
   * {@link InvocationHandlerForUnitTestingByteWeavedClasses#invoke(Object, Method, Object[])}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InvocationHandlerForUnitTestingByteWeavedClasses#invoke(Object, Method, Object[])}
   */
  @Test
  public void testInvoke_thenReturnNull() throws Throwable {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new InvocationHandlerForUnitTestingByteWeavedClasses(new Object[]{})).invoke(BLCFieldUtils.NULL_FIELD,
        null, new Object[]{BLCFieldUtils.NULL_FIELD}));
  }
}
