package org.broadleafcommerce.core.search.dao;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ParentCategoryByCategoryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ParentCategoryByCategory#ParentCategoryByCategory(Long, Long, Long)}
   *   <li>{@link ParentCategoryByCategory#setChild(Long)}
   *   <li>{@link ParentCategoryByCategory#setDefaultParent(Long)}
   *   <li>{@link ParentCategoryByCategory#setParent(Long)}
   *   <li>{@link ParentCategoryByCategory#getChild()}
   *   <li>{@link ParentCategoryByCategory#getDefaultParent()}
   *   <li>{@link ParentCategoryByCategory#getParent()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ParentCategoryByCategory actualParentCategoryByCategory = new ParentCategoryByCategory(1L, 1L, 1L);
    actualParentCategoryByCategory.setChild(1L);
    actualParentCategoryByCategory.setDefaultParent(1L);
    actualParentCategoryByCategory.setParent(1L);
    Long actualChild = actualParentCategoryByCategory.getChild();
    Long actualDefaultParent = actualParentCategoryByCategory.getDefaultParent();
    Long actualParent = actualParentCategoryByCategory.getParent();

    // Assert that nothing has changed
    assertEquals(1L, actualChild.longValue());
    assertEquals(1L, actualDefaultParent.longValue());
    assertEquals(1L, actualParent.longValue());
  }
}
