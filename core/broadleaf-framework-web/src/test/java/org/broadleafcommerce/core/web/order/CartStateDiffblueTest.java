package org.broadleafcommerce.core.web.order;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CartStateDiffblueTest {
  /**
   * Test {@link CartState#getCart()}.
   * <p>
   * Method under test: {@link CartState#getCart()}
   */
  @Test
  @DisplayName("Test getCart()")
  void testGetCart() {
    // Arrange, Act and Assert
    assertNull(CartState.getCart());
  }

  /**
   * Test {@link CartState#setCart(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CartState#setCart(Order)}
   */
  @Test
  @DisplayName("Test setCart(Order); when NullOrderImpl (default constructor)")
  @Disabled("TODO: Complete this test")
  void testSetCart_whenNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.order.CartState.setCart(CartState.java:51)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    CartState.setCart(new NullOrderImpl());
  }
}
