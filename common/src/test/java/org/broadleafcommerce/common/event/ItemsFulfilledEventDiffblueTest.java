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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ItemsFulfilledEventDiffblueTest {
  /**
   * Test {@link ItemsFulfilledEvent#getFulfillmentGroupId()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemsFulfilledEvent#getFulfillmentGroupId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long ItemsFulfilledEvent.getFulfillmentGroupId()"})
  public void testGetFulfillmentGroupId_givenHashMapOneIsOne_thenReturnLongValueIsOne() {
    // Arrange
    HashMap<Long, Integer> fulfilled = new HashMap<>();
    fulfilled.put(1L, 1);

    // Act and Assert
    assertEquals(1L, (new ItemsFulfilledEvent(1L, fulfilled)).getFulfillmentGroupId().longValue());
  }
}
