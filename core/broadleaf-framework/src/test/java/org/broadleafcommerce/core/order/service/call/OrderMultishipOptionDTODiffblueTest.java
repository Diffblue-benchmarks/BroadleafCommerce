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
