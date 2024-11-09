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

public class OrderMultishipOptionDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderMultishipOptionDTO}
   *   <li>{@link OrderMultishipOptionDTO#setAddressId(Long)}
   *   <li>{@link OrderMultishipOptionDTO#setFulfillmentOptionId(Long)}
   *   <li>{@link OrderMultishipOptionDTO#setId(Long)}
   *   <li>{@link OrderMultishipOptionDTO#setOrderItemId(Long)}
   *   <li>{@link OrderMultishipOptionDTO#getAddressId()}
   *   <li>{@link OrderMultishipOptionDTO#getFulfillmentOptionId()}
   *   <li>{@link OrderMultishipOptionDTO#getId()}
   *   <li>{@link OrderMultishipOptionDTO#getOrderItemId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderMultishipOptionDTO actualOrderMultishipOptionDTO = new OrderMultishipOptionDTO();
    actualOrderMultishipOptionDTO.setAddressId(1L);
    actualOrderMultishipOptionDTO.setFulfillmentOptionId(1L);
    actualOrderMultishipOptionDTO.setId(1L);
    actualOrderMultishipOptionDTO.setOrderItemId(1L);
    Long actualAddressId = actualOrderMultishipOptionDTO.getAddressId();
    Long actualFulfillmentOptionId = actualOrderMultishipOptionDTO.getFulfillmentOptionId();
    Long actualId = actualOrderMultishipOptionDTO.getId();
    Long actualOrderItemId = actualOrderMultishipOptionDTO.getOrderItemId();

    // Assert that nothing has changed
    assertEquals(1L, actualAddressId.longValue());
    assertEquals(1L, actualFulfillmentOptionId.longValue());
    assertEquals(1L, actualId.longValue());
    assertEquals(1L, actualOrderItemId.longValue());
  }
}
