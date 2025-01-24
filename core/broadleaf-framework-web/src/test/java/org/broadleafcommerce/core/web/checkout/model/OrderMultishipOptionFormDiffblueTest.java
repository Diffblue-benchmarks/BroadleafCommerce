package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.service.call.OrderMultishipOptionDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderMultishipOptionFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderMultishipOptionForm}
   *   <li>{@link OrderMultishipOptionForm#setOptions(List)}
   *   <li>{@link OrderMultishipOptionForm#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    OrderMultishipOptionForm actualOrderMultishipOptionForm = new OrderMultishipOptionForm();
    ArrayList<OrderMultishipOptionDTO> options = new ArrayList<>();
    actualOrderMultishipOptionForm.setOptions(options);
    List<OrderMultishipOptionDTO> actualOptions = actualOrderMultishipOptionForm.getOptions();

    // Assert that nothing has changed
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
