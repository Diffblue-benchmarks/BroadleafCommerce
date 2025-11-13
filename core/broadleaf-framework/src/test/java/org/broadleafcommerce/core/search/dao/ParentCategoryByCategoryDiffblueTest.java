package org.broadleafcommerce.core.search.dao;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ParentCategoryByCategoryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParentCategoryByCategory#ParentCategoryByCategory(Long, Long, Long)}
   *   <li>{@link ParentCategoryByCategory#setChild(Long)}
   *   <li>{@link ParentCategoryByCategory#setDefaultParent(Long)}
   *   <li>{@link ParentCategoryByCategory#setParent(Long)}
   *   <li>{@link ParentCategoryByCategory#getChild()}
   *   <li>{@link ParentCategoryByCategory#getDefaultParent()}
   *   <li>{@link ParentCategoryByCategory#getParent()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParentCategoryByCategory.<init>(Long, Long, Long)",
    "Long ParentCategoryByCategory.getChild()",
    "Long ParentCategoryByCategory.getDefaultParent()",
    "Long ParentCategoryByCategory.getParent()",
    "void ParentCategoryByCategory.setChild(Long)",
    "void ParentCategoryByCategory.setDefaultParent(Long)",
    "void ParentCategoryByCategory.setParent(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ParentCategoryByCategory actualParentCategoryByCategory =
        new ParentCategoryByCategory(1L, 1L, 1L);
    actualParentCategoryByCategory.setChild(1L);
    actualParentCategoryByCategory.setDefaultParent(1L);
    actualParentCategoryByCategory.setParent(1L);
    Long actualChild = actualParentCategoryByCategory.getChild();
    Long actualDefaultParent = actualParentCategoryByCategory.getDefaultParent();
    Long actualParent = actualParentCategoryByCategory.getParent();

    // Assert
    assertEquals(1L, actualChild.longValue());
    assertEquals(1L, actualDefaultParent.longValue());
    assertEquals(1L, actualParent.longValue());
  }
}
