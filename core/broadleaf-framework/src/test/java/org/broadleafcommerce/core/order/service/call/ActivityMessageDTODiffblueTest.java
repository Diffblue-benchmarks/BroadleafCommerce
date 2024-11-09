/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ActivityMessageDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ActivityMessageDTO#ActivityMessageDTO(String, Integer, String)}
   *   <li>{@link ActivityMessageDTO#setErrorCode(String)}
   *   <li>{@link ActivityMessageDTO#setMessage(String)}
   *   <li>{@link ActivityMessageDTO#setPriority(Integer)}
   *   <li>{@link ActivityMessageDTO#setType(String)}
   *   <li>{@link ActivityMessageDTO#getErrorCode()}
   *   <li>{@link ActivityMessageDTO#getMessage()}
   *   <li>{@link ActivityMessageDTO#getPriority()}
   *   <li>{@link ActivityMessageDTO#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ActivityMessageDTO actualActivityMessageDTO = new ActivityMessageDTO("Type", 1, "Not all who wander are lost");
    actualActivityMessageDTO.setErrorCode("An error occurred");
    actualActivityMessageDTO.setMessage("Not all who wander are lost");
    actualActivityMessageDTO.setPriority(1);
    actualActivityMessageDTO.setType("Type");
    String actualErrorCode = actualActivityMessageDTO.getErrorCode();
    String actualMessage = actualActivityMessageDTO.getMessage();
    Integer actualPriority = actualActivityMessageDTO.getPriority();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualErrorCode);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("Type", actualActivityMessageDTO.getType());
    assertEquals(1, actualPriority.intValue());
  }
}
