package org.broadleafcommerce.admin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategoryParentCategoryFieldPersistenceProviderDiffblueTest {
  /**
   * Test {@link CategoryParentCategoryFieldPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link CategoryParentCategoryFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CategoryParentCategoryFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-2147483548, new CategoryParentCategoryFieldPersistenceProvider().getOrder());
  }
}
