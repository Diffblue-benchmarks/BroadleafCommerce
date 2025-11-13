package org.broadleafcommerce.core.web.order;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CartStateDiffblueTest {
  /**
   * Test {@link CartState#getCart()}.
   *
   * <p>Method under test: {@link CartState#getCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"org.broadleafcommerce.core.order.domain.Order CartState.getCart()"})
  public void testGetCart() {
    // Arrange, Act and Assert
    assertNull(CartState.getCart());
  }
}
