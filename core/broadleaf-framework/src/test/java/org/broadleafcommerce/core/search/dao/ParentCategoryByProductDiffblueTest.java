package org.broadleafcommerce.core.search.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ParentCategoryByProductDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParentCategoryByProduct#ParentCategoryByProduct(Long, Long, BigDecimal)}
   *   <li>{@link ParentCategoryByProduct#setCategory(Long)}
   *   <li>{@link ParentCategoryByProduct#setDisplayOrder(BigDecimal)}
   *   <li>{@link ParentCategoryByProduct#setProduct(Long)}
   *   <li>{@link ParentCategoryByProduct#getCategory()}
   *   <li>{@link ParentCategoryByProduct#getDisplayOrder()}
   *   <li>{@link ParentCategoryByProduct#getProduct()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParentCategoryByProduct.<init>(Long, Long, BigDecimal)",
    "Long ParentCategoryByProduct.getCategory()",
    "BigDecimal ParentCategoryByProduct.getDisplayOrder()",
    "Long ParentCategoryByProduct.getProduct()",
    "void ParentCategoryByProduct.setCategory(Long)",
    "void ParentCategoryByProduct.setDisplayOrder(BigDecimal)",
    "void ParentCategoryByProduct.setProduct(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ParentCategoryByProduct actualParentCategoryByProduct =
        new ParentCategoryByProduct(1L, 1L, new BigDecimal("2.3"));
    actualParentCategoryByProduct.setCategory(1L);
    BigDecimal displayOrder = new BigDecimal("2.3");
    actualParentCategoryByProduct.setDisplayOrder(displayOrder);
    actualParentCategoryByProduct.setProduct(1L);
    Long actualCategory = actualParentCategoryByProduct.getCategory();
    BigDecimal actualDisplayOrder = actualParentCategoryByProduct.getDisplayOrder();
    Long actualProduct = actualParentCategoryByProduct.getProduct();

    // Assert
    assertEquals(1L, actualCategory.longValue());
    assertEquals(1L, actualProduct.longValue());
    assertEquals(new BigDecimal("2.3"), actualDisplayOrder);
    assertSame(displayOrder, actualDisplayOrder);
  }
}
