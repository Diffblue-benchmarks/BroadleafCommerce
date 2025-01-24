package org.broadleafcommerce.core.search.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.junit.Test;

public class ParentCategoryByProductDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ParentCategoryByProduct#ParentCategoryByProduct(Long, Long, BigDecimal)}
   *   <li>{@link ParentCategoryByProduct#setCategory(Long)}
   *   <li>{@link ParentCategoryByProduct#setDisplayOrder(BigDecimal)}
   *   <li>{@link ParentCategoryByProduct#setProduct(Long)}
   *   <li>{@link ParentCategoryByProduct#getCategory()}
   *   <li>{@link ParentCategoryByProduct#getDisplayOrder()}
   *   <li>{@link ParentCategoryByProduct#getProduct()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ParentCategoryByProduct actualParentCategoryByProduct = new ParentCategoryByProduct(1L, 1L, new BigDecimal("2.3"));
    actualParentCategoryByProduct.setCategory(1L);
    BigDecimal displayOrder = new BigDecimal("2.3");
    actualParentCategoryByProduct.setDisplayOrder(displayOrder);
    actualParentCategoryByProduct.setProduct(1L);
    Long actualCategory = actualParentCategoryByProduct.getCategory();
    BigDecimal actualDisplayOrder = actualParentCategoryByProduct.getDisplayOrder();
    Long actualProduct = actualParentCategoryByProduct.getProduct();

    // Assert that nothing has changed
    assertEquals(1L, actualCategory.longValue());
    assertEquals(1L, actualProduct.longValue());
    assertEquals(new BigDecimal("2.3"), actualDisplayOrder);
    assertSame(displayOrder, actualDisplayOrder);
  }
}
