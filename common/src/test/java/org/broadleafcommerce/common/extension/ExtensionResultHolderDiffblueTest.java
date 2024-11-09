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
package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class ExtensionResultHolderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ExtensionResultHolder}
   *   <li>{@link ExtensionResultHolder#setResult(Object)}
   *   <li>{@link ExtensionResultHolder#setThrowable(Throwable)}
   *   <li>{@link ExtensionResultHolder#getContextMap()}
   *   <li>{@link ExtensionResultHolder#getResult()}
   *   <li>{@link ExtensionResultHolder#getThrowable()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ExtensionResultHolder<Object> actualExtensionResultHolder = new ExtensionResultHolder<>();
    Object object = BLCFieldUtils.NULL_FIELD;
    actualExtensionResultHolder.setResult(object);
    Throwable throwable = new Throwable();
    actualExtensionResultHolder.setThrowable(throwable);
    Map<String, Object> actualContextMap = actualExtensionResultHolder.getContextMap();
    Object actualResult = actualExtensionResultHolder.getResult();
    Throwable actualThrowable = actualExtensionResultHolder.getThrowable();

    // Assert that nothing has changed
    assertTrue(actualContextMap.isEmpty());
    assertSame(throwable, actualThrowable);
    assertSame(object, actualResult);
  }
}
