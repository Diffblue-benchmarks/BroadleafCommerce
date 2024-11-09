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
package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class TimedValueHolderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimedValueHolder#TimedValueHolder(Object, Integer)}
   *   <li>{@link TimedValueHolder#getTimeToLiveSeconds()}
   *   <li>{@link TimedValueHolder#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    TimedValueHolder actualTimedValueHolder = new TimedValueHolder(object, 1);
    Integer actualTimeToLiveSeconds = actualTimedValueHolder.getTimeToLiveSeconds();
    Object actualValue = actualTimedValueHolder.getValue();

    // Assert
    assertEquals(1, actualTimeToLiveSeconds.intValue());
    assertSame(object, actualValue);
  }
}