package org.broadleafcommerce.core.search.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductsByCategoryWithOrderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductsByCategoryWithOrder#ProductsByCategoryWithOrder(Long, BigDecimal)}
   *   <li>{@link ProductsByCategoryWithOrder#setDisplayOrder(BigDecimal)}
   *   <li>{@link ProductsByCategoryWithOrder#setProductId(Long)}
   *   <li>{@link ProductsByCategoryWithOrder#getDisplayOrder()}
   *   <li>{@link ProductsByCategoryWithOrder#getProductId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductsByCategoryWithOrder.<init>(Long, BigDecimal)",
    "BigDecimal ProductsByCategoryWithOrder.getDisplayOrder()",
    "Long ProductsByCategoryWithOrder.getProductId()",
    "void ProductsByCategoryWithOrder.setDisplayOrder(BigDecimal)",
    "void ProductsByCategoryWithOrder.setProductId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductsByCategoryWithOrder actualProductsByCategoryWithOrder =
        new ProductsByCategoryWithOrder(1L, new BigDecimal("2.3"));
    BigDecimal displayOrder = new BigDecimal("2.3");
    actualProductsByCategoryWithOrder.setDisplayOrder(displayOrder);
    actualProductsByCategoryWithOrder.setProductId(1L);
    BigDecimal actualDisplayOrder = actualProductsByCategoryWithOrder.getDisplayOrder();

    // Assert
    assertEquals(1L, actualProductsByCategoryWithOrder.getProductId().longValue());
    assertEquals(new BigDecimal("2.3"), actualDisplayOrder);
    assertSame(displayOrder, actualDisplayOrder);
  }
}
