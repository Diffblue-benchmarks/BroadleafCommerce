package org.broadleafcommerce.core.search.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.junit.Test;

public class ProductsByCategoryWithOrderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProductsByCategoryWithOrder#ProductsByCategoryWithOrder(Long, BigDecimal)}
   *   <li>{@link ProductsByCategoryWithOrder#setDisplayOrder(BigDecimal)}
   *   <li>{@link ProductsByCategoryWithOrder#setProductId(Long)}
   *   <li>{@link ProductsByCategoryWithOrder#getDisplayOrder()}
   *   <li>{@link ProductsByCategoryWithOrder#getProductId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductsByCategoryWithOrder actualProductsByCategoryWithOrder = new ProductsByCategoryWithOrder(1L,
        new BigDecimal("2.3"));
    BigDecimal displayOrder = new BigDecimal("2.3");
    actualProductsByCategoryWithOrder.setDisplayOrder(displayOrder);
    actualProductsByCategoryWithOrder.setProductId(1L);
    BigDecimal actualDisplayOrder = actualProductsByCategoryWithOrder.getDisplayOrder();

    // Assert that nothing has changed
    assertEquals(1L, actualProductsByCategoryWithOrder.getProductId().longValue());
    assertEquals(new BigDecimal("2.3"), actualDisplayOrder);
    assertSame(displayOrder, actualDisplayOrder);
  }
}
