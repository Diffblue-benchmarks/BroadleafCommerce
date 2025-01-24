package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertSame;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;

public class CheckoutSeedDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSeed#CheckoutSeed(Order, Map)}
   *   <li>{@link CheckoutSeed#setOrder(Order)}
   *   <li>{@link CheckoutSeed#getOrder()}
   *   <li>{@link CheckoutSeed#getUserDefinedFields()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    HashMap<String, Object> userDefinedFields = new HashMap<>();

    // Act
    CheckoutSeed actualCheckoutSeed = new CheckoutSeed(order, userDefinedFields);
    NullOrderImpl order2 = new NullOrderImpl();
    actualCheckoutSeed.setOrder(order2);
    Order actualOrder = actualCheckoutSeed.getOrder();

    // Assert that nothing has changed
    assertSame(userDefinedFields, actualCheckoutSeed.getUserDefinedFields());
    assertSame(order2, actualOrder);
  }
}
