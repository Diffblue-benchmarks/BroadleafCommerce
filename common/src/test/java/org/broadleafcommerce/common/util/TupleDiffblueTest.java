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

import static org.junit.Assert.assertSame;
import org.junit.Test;

public class TupleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tuple#Tuple(Object, Object)}
   *   <li>{@link Tuple#getFirst()}
   *   <li>{@link Tuple#getSecond()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Tuple<Object, Object> actualTuple = new Tuple<>(BLCFieldUtils.NULL_FIELD, object);
    Object actualFirst = actualTuple.getFirst();

    // Assert
    assertSame(object, actualFirst);
    assertSame(object, actualTuple.getSecond());
  }
}
